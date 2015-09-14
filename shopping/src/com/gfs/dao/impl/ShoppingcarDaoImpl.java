package com.gfs.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.gfs.model.MShoppingCar;
import com.gfs.pojo.Product;
import com.gfs.pojo.Shoppingcar;
import com.gfs.pojo.User;
import com.tool.MyTool;

@Repository("shoppingcarDao")
public class ShoppingcarDaoImpl extends BaseDaoImpl<Shoppingcar> {
	
	private Session session = null;
	private Query query = null;
	private Transaction transaction = null;
	
	private MyTool mtool = null;
	
	@SuppressWarnings({ "static-access" })
	public boolean addSC(User u, Product p, Integer num) {
		// TODO Auto-generated method stub
		boolean is = false;
		List<?> list = null;
		Shoppingcar sc = null;
		if (p.getNum()<num) {
			return is;
		}
		String hql = "";
		try {
			hql = "FROM Shoppingcar sc WHERE sc.product.id=?";
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			query = session.createQuery(hql);
			query.setInteger(0, p.getId());
			list = query.list();
			if (list!=null&&list.size()>0) {
				sc = (Shoppingcar) list.get(0);
				p.setNum(p.getNum()-num);
				sc.setNum(sc.getNum()+num);
				session.update(sc);
				session.update(p);
			}else {
				hql = "SELECT sc.id FROM Shoppingcar sc";
				query = session.createQuery(hql);
				list = query.list();
				Integer id = mtool.getTruID(list);
				sc = new Shoppingcar(id, u, p, num);
				p.setNum(p.getNum()-num);
				session.save(sc);
				session.update(p);
			}
			transaction.commit();
			is = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (session!=null&&session.isOpen()) {
			session.close();
		}
		return is;
	}

	@SuppressWarnings("unchecked")
	public List<Shoppingcar> findByUName(String uname) {
		List<?> list = null;
		String hql = "FROM Shoppingcar sc WHERE sc.user.name=?";
		try {
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			query = session.createQuery(hql);
			query.setString(0, uname);
			list = query.list();
			if (list!=null&&list.size()<=0) {
				list = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (session!=null&&session.isOpen()) {
			session.close();
		}
		return (List<Shoppingcar>) list;
	}
	
	@SuppressWarnings("unchecked")
	public List<MShoppingCar> findByName(String uname) {
		// TODO Auto-generated method stub
		List<?> list = null;
		String hql = "SELECT NEW com.gfs.model.MShoppingCar("
				+ "sc.id,sc.product.name,sc.product.price,sc.num,"
				+ "sc.product.price*sc.num"
				+ ")"
				+ " FROM Shoppingcar sc WHERE sc.user.name=?";
		try {
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			query = session.createQuery(hql);
			query.setString(0, uname);
			list = query.list();
			if (list!=null&&list.size()<=0) {
				list = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (session!=null&&session.isOpen()) {
			session.close();
		}
		return (List<MShoppingCar>) list;
	}
	
	public void deleteSCByUName(String uname) {
		String hql = "FROM Shoppingcar sc WHERE sc.user.name=?";
		try {
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			query = session.createQuery(hql);
			query.setString(0, uname);
			List<?> list = query.list();
			for (Object object : list) {
				session.delete(object);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (session!=null&&session.isOpen()) {
			session.close();
		}
	}
	
}
