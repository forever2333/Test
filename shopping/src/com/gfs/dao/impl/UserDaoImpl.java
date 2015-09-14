package com.gfs.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.gfs.pojo.People;
import com.gfs.pojo.User;
import com.tool.MyTool;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> {
	
	private Session session = null;
	private Query query = null;
	private Transaction transaction = null;
	
	private MyTool mtool = null;
	
	public User findByName(String uname) {
		User u = null;
		List<?> list = null;
		String hql = "FROM User u WHERE u.name=?";
		try {
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			query = session.createQuery(hql);
			query.setString(0, uname);
			list = query.list();
			if (list!=null&&list.size()>0) {
				u = (User) list.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (session!=null&&session.isOpen()) {
			session.close();
		}
		return u;
	}
	
	public boolean login(String uname, String password){
		boolean is = false;
		List<?> list = null;
		String hql = "FROM User u WHERE u.name=? AND u.password=?";
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
	
	@SuppressWarnings({ "static-access" })
	public boolean reg(String uname, String password){
		boolean is = false;
		try {
			Integer id = 0;
			List<?> list = null;
			User u = null;
			People p = null;
			
			String hql = "FROM User u WHERE u.name=?";
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			query = session.createQuery(hql);
			query.setString(0, uname);
			list = query.list();
			if (list==null||list.size()<1) {
				hql = "SELECT u.id FROM User u";
				query = session.createQuery(hql);
				list = query.list();
				if (list.size()<=0) {
					list = null;
				}
				mtool = new MyTool();
				id = mtool.getTruID(list);
				u = new User(id, uname, password);
				
				hql = "SELECT u.id FROM People u";
				query = session.createQuery(hql);
				list = query.list();
				if (list.size()<=0) {
					list = null;
				}
				mtool = new MyTool();
				id = mtool.getTruID(list);
				p = new People(id);
				p.setUser(u);
				
				session.save(u);
				session.save(p);
				transaction.commit();
				is = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (session!=null&&session.isOpen()) {
			session.close();
		}
		return is;
	}
	
}