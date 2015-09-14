package com.gfs.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.gfs.pojo.Merchant;

@Repository("merchantDao")
public class MerchantDaoImpl extends BaseDaoImpl<Merchant> {
	private Session session = null;
	private Query query = null; 
	
	public boolean login(String uname, String password){
		boolean is = false;
		List<?> list = null;
		String hql = "FROM Merchant u WHERE u.name=? AND u.password=?";
		try {
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			query = session.createQuery(hql);
			query.setString(0, uname);
			query.setString(1, password);
			list = query.list();
			if (list!=null&&list.size()==1) {
				is = true;
			}
		} catch (Exception e) {
//			 TODO: handle exception
			e.printStackTrace();
		}
		if (session!=null&&session.isOpen()) {
			session.close();
		}
		return is;
	}

	public Merchant getM(String mname) {
		// TODO Auto-generated method stub
		List<?> list = null;
		String hql = "FROM Merchant u WHERE u.name=?";
		try {
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			query = session.createQuery(hql);
			query.setString(0, mname);
			list = query.list();
			if (list!=null&&list.size()<1) {
				list = null;
			}
		} catch (Exception e) {
//			 TODO: handle exception
			e.printStackTrace();
		}
		if (session!=null&&session.isOpen()) {
			session.close();
		}
		return (Merchant) list.get(0);
	}
	
}
