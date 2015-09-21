package com.svc;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.database.HibernateSessionFactory;
import com.pojo.Account;
import com.pojo.Detail;
import com.pojo.Refund;
import com.pojo.User;
import com.tools.EncyptTools;
import com.vo.DetailType;
import com.vo.RefundType;

@Path("banksvc")
public class BankSvc {
	@GET
	@Path("pay/{aid},{to},{paypwd},{cash}")
	@Produces(MediaType.APPLICATION_JSON)
	public String pay(@PathParam("aid")String aid,@PathParam("to")String to,
					  @PathParam("paypwd")String pwd,@PathParam("cash")String cash){
		Session session=HibernateSessionFactory.getSession();
		Transaction tr=session.beginTransaction();
		tr.begin();
		session.getTransaction().begin();
		String flag="Password ERROR!!!";
		int status=1;
		String payPwd=(String)session.createQuery("select paypwd from Account where aid=?")
						.setInteger(0,Integer.parseInt(aid)).uniqueResult();
		if(payPwd.equals(EncyptTools.MessageEncypt(pwd))){
			flag="Finished successfully!!!";
			status=0;
			Account from=(Account)session.createQuery("from Account where aid=?").setInteger(0,Integer.parseInt(aid))
							.uniqueResult();
			if(from.getCash()-Float.parseFloat(cash)<0){
				status=2;
				flag="Cash is NOT enough!!!";
			}else{
				from.setCash(from.getCash()-Float.parseFloat(cash));
				Account toAcc=(Account)session.createQuery("from Account where aid=?").setInteger(0,Integer.parseInt(to))
								.uniqueResult();
				toAcc.setCash(toAcc.getCash()+Float.parseFloat(cash));
				session.update(from);
				session.update(toAcc);
			}
		}
		User toUser=(User) session.createQuery("from User where uid=?").setInteger(0,Integer.parseInt(to))
						.uniqueResult();
		User fromUser=(User) session.createQuery("from User where uid=?").setInteger(0,Integer.parseInt(aid))
						.uniqueResult();
		Detail detail=new Detail(toUser,fromUser,0,Float.parseFloat(cash),status,new Timestamp(new Date().getTime()));
		session.save(detail);
		tr.commit();
		HibernateSessionFactory.closeSession();
		return "{\"pay\":[{\"status\":"+status+",\"info\":"+flag+"}]}";
	}
	
	@GET
	@Path("refund_req/{uid},{from},{cash}")
	@Produces(MediaType.APPLICATION_JSON)
	public String sendRefundReq(@PathParam("uid") String uid,@PathParam("from") String from,
								@PathParam("cash") String cash){
		Session session=HibernateSessionFactory.getSession();
		Transaction tr=session.beginTransaction();
		tr.begin();
		Account toAcc=(Account) session.createQuery("from Account where aid=?").setInteger(0,Integer.parseInt(uid))
						.uniqueResult();
		Account fromAcc=(Account) session.createQuery("from Account where aid=?").setInteger(0,Integer.parseInt(from))
						.uniqueResult();
		Refund refund=new Refund(fromAcc, toAcc, Float.parseFloat(cash),1,new Timestamp(new Date().getTime()));
		session.save(refund);
		String flag="Refund request sended successfully!!!";
		tr.commit();
		HibernateSessionFactory.closeSession();
		return "{\"refundReq\":[{\"status\":"+flag+"}]}";
	}
	
	@GET
	@Path("refund/{sid},{flag}")
	@Produces(MediaType.APPLICATION_JSON)
	public String refundResp(@PathParam("sid") String sid,@PathParam("flag") String flag){
		String status="Request REFUSED!!!";
		Session session=HibernateSessionFactory.getSession();
		Transaction tr=session.beginTransaction();
		tr.begin();
		String hql="select new com.vo.RefundType(r.sid,r.accountByUid.aid,r.accountByFromUid.aid,r.scash,r.type) "
						+ "from Refund r where sid=?";
		RefundType refund=(RefundType) session.createQuery(hql).setInteger(0,Integer.parseInt(sid))
						.uniqueResult();
		if(flag.equals("0")){
			status="Request ACCEPTED!!!";
			Account fromAcc=(Account)session.createQuery("from Account where aid=?").setInteger(0,refund.getFrom())
								.uniqueResult();
			fromAcc.setCash(fromAcc.getCash()-refund.getCash());
			Account toAcc=(Account)session.createQuery("from Account where aid=?").setInteger(0,refund.getUid())
								.uniqueResult();
			toAcc.setCash(toAcc.getCash()+refund.getCash());
			session.update(fromAcc);
			session.update(toAcc);
			session.createQuery("update Refund set type=0 where sid=?").setInteger(0,refund.getSid()).executeUpdate();
		}
		User from=(User)session.createQuery("from User where uid=?").setInteger(0,refund.getFrom()).uniqueResult();
		User to=(User)session.createQuery("from User where uid=?").setInteger(0,refund.getUid()).uniqueResult();
		Detail detail=new Detail(to, from, 1,refund.getCash(),Integer.parseInt(flag),new Timestamp(new Date().getTime()));
		session.save(detail);
		tr.commit();
		HibernateSessionFactory.closeSession();
		return "{\"refundResp\":[{\"status\":"+flag+",\"info\":"+status+"}]}";
	}
	
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("checksum")
	@Produces(MediaType.APPLICATION_JSON)
	public String checksum(){
		String flag="Checksum ERROR!!!";
		Session session=HibernateSessionFactory.getSession();
		Account seller=(Account)session.createQuery("from Account where atype=1").uniqueResult();
		float sellerSum=seller.getInit();
		List<Detail> sellerDetails=session.createQuery("from Detail where userByUid.uid=? or userByToUid=?")
									.setInteger(0,seller.getAid()).setInteger(1,seller.getAid()).list();
		for(Detail d:sellerDetails){
			if(d.getStatus()==0){
				if(d.getType()==0){
					sellerSum+=d.getCash();
				}else{
					sellerSum-=d.getCash();
				}
			}
		}
		if(sellerSum==seller.getCash()&&checkCustomer()){
			flag="Checksum finished SUCCESSFULLY!!!";
		}
		HibernateSessionFactory.closeSession();
		return "{\"checksum\":[{\"status\":"+flag+"}]}";
	}
	
	@SuppressWarnings("unchecked")
	private boolean checkCustomer(){
		float sum=0f;
		boolean flag=true;
		Session session=HibernateSessionFactory.getSession();
		List<Account> accList=session.createQuery("from Account where atype=0").list();
		String hql="select new com.vo.DetailType(d.userByUid.uid,d.userByToUid.uid,d.cash) from Detail d where d.status=0";
		List<DetailType> dt=session.createQuery(hql).list();
		for(Account acc:accList){
			sum=acc.getInit();
			for(DetailType d:dt){
				if(acc.getAid()==d.getFromId()){
					sum-=d.getCash();
				}else if(acc.getAid()==d.getToId()){
					sum+=d.getCash();
				}
			}
			if(sum!=acc.getCash()){
				flag=false;
				break;
			}
		}
		HibernateSessionFactory.closeSession();
		return flag;
	}
}
