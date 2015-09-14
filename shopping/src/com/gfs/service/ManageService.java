package com.gfs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfs.dao.impl.MerchantDaoImpl;
import com.gfs.dao.impl.ProductDaoImpl;
import com.gfs.model.PageBean;
import com.gfs.pojo.Merchant;
import com.gfs.pojo.Product;
import com.tool.MyTool;

@Service("manageService")
public class ManageService {
	
	@Autowired
	private ProductDaoImpl pdi = null;
	@Autowired
	private MerchantDaoImpl mdi = null;
	
	/**获取商家信息*/
	public Merchant getM(String mname){
		return mdi.getM(mname);
	}
	
	/**新增商品的编号*/
	public Integer getID(){
		List<?> list = pdi.getAllId();
		return MyTool.getTruID(list);
	}
	
	public Product findProductById(Integer id){
		try {
			return pdi.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**总数*/
	public Long getNumByM(String mname){
		Long num = 0l;
		num = pdi.getNumByM(mname);
		return num;
	}
	
	/** 获取店主商品 */
	public List<?> getProByName(String mname,PageBean pageBean){
		return pdi.getProByName(mname,pageBean);
	}
	
	public boolean addProduct(Product p){
		try {
			pdi.addP(p);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteProduct(Integer pid){
		try {
			pdi.deleteById(pid);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateProduct(Product p){
		try {
			pdi.update(p);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
