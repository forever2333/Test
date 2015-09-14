package com.gfs.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.gfs.model.PageBean;
import com.gfs.pojo.Product;

@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> {
	
	private Session session = null;
	private Query query = null;
	private Transaction transaction = null;

	public Long getAllNum() {
		// TODO Auto-generated method stub
		Long num = 0l;
		String hql = "SELECT COUNT(p.id) FROM Product p";
		try {
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			query = session.createQuery(hql);
			num = (Long) query.uniqueResult();
			if (num==null) {
				num=0l;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (session!=null&&session.isOpen()) {
			session.close();
		}
		return num;
	}

	public void updateP(Product p) {
		// TODO Auto-generated method stub
		try {
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(p);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (session!=null&&session.isOpen()) {
			session.close();
		}
	}

	public List<?> getProByName(String mname,PageBean pageBean) {
		// TODO Auto-generated method stub
		List<?> list = null;
		String hql = "FROM Product p WHERE p.merchant.name=?";
		try {
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			query = session.createQuery(hql);
			query.setString(0, mname);
			query.setMaxResults(pageBean.getPageSize());
			query.setFirstResult(pageBean.getLimit());
			list = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list!=null&&list.size()<=0) {
			list = null;
		}
		if (session!=null&&session.isOpen()) {
			session.close();
		}
		return list;
	}

	public Long getNumByM(String mname) {
		// TODO Auto-generated method stub
		Long num = 0l;
		String hql = "SELECT COUNT(p.id) FROM Product p WHERE p.merchant.name=?";
		try {
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			query = session.createQuery(hql);
			query.setString(0, mname);
			num = (Long) query.uniqueResult();
			if (num==null) {
				num=0l;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (session!=null&&session.isOpen()) {
			session.close();
		}
		return num;
	}

	public List<?> getAllId() {
		// TODO Auto-generated method stub
		List<?> list = null;
		String hql = "SELECT sc.id FROM Product sc";
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

	public void addP(Product p) {
		// TODO Auto-generated method stub
		try {
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(p);
			transaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (session!=null&&session.isOpen()) {
			session.close();
		}
	}

}
