package com.gfs.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.gfs.pojo.Order;
import com.gfs.pojo.Shoppingcar;

@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> {

	private Session session = null;
	private Query query = null;
	private Transaction transaction = null;
	
	public List<?> getAllId() {
		// TODO Auto-generated method stub
		List<?> list = null;
		String hql = "SELECT sc.id FROM Order sc";
		try {
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			query = session.createQuery(hql);
			list = query.list();
			if (list!=null&&list.size()<=0) {
				list = null;
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (session!=null&&session.isOpen()) {
			session.close();
		}
		return list;
	}
	
	/** 生成订单信息清单 */
	public String getOrderTitle(List<Shoppingcar> sclist){
		String title = "";
		title = title + "{\"orders\":[";
		for (int i = 0; i < (sclist.size()-1); i++) {
			title = title + "{\"uid\":\"" + sclist.get(i).getUser().getId().toString() + "\",";
			title = title + "\"pid\":\"" + sclist.get(i).getProduct().getId().toString() + "\",";
			title = title + "\"num\":\"" + sclist.get(i).getNum().toString() + "\"},";
		}
		title = title + "{\"uid\":\"" + sclist.get((sclist.size()-1)).getUser().getId().toString() + "\",";
		title = title + "\"pid\":\"" + sclist.get((sclist.size()-1)).getProduct().getId().toString() + "\",";
		title = title + "\"num\":\"" + sclist.get((sclist.size()-1)).getNum().toString() + "\"}";
		title = title + "]}";
		return title;
	}

	public List<?> findByType(String uname, int type) {
		// TODO Auto-generated method stub
		List<?> list = null;
		String hql = "FROM Order sc WHERE sc.user.name=? AND sc.type=?";
		try {
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			query = session.createQuery(hql);
			query.setString(0, uname);
			query.setInteger(1, type);
			list = query.list();
			if (list!=null&&list.size()<=0) {
				list = null;
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (session!=null&&session.isOpen()) {
			session.close();
		}
		return list;
	}

	public void addOrder(Order o) {
		// TODO Auto-generated method stub
		try {
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(o);
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