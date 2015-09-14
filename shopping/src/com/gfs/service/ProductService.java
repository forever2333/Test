package com.gfs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfs.dao.impl.ProductDaoImpl;
import com.gfs.dao.impl.ShoppingcarDaoImpl;
import com.gfs.dao.impl.UserDaoImpl;
import com.gfs.model.PageBean;
import com.gfs.pojo.Product;
import com.gfs.pojo.User;

@Service("productService")
public class ProductService {
	
	@Autowired
	private UserDaoImpl udi = null;
	@Autowired
	private ProductDaoImpl pdi = null;
	@Autowired
	private ShoppingcarDaoImpl scdi = null;
		
	/** 商品总数 */
	public Long getNumByP(){
		Long num = 0l;
		num = pdi.getAllNum();
		return num;
	}
	
	/** 所有商品 */
	public List<Product> getAllP(PageBean pageBean){
		try {
			return pdi.findAll(pageBean).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	/**购物车*/
	public boolean addShoppingCar(String uname,Integer pid,Integer num){
		try {
			if (num==0||num==null) {
				return false;
			}
			User u = udi.findByName(uname);
			Product p = pdi.findById(pid);
			return scdi.addSC(u,p,num);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
}
