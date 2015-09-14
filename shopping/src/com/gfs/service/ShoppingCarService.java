package com.gfs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfs.dao.impl.OrderDaoImpl;
import com.gfs.dao.impl.ProductDaoImpl;
import com.gfs.dao.impl.ShoppingcarDaoImpl;
import com.gfs.dao.impl.UserDaoImpl;
import com.gfs.model.MShoppingCar;
import com.gfs.pojo.Product;
import com.gfs.pojo.Shoppingcar;

@Service("shoppingcarService")
public class ShoppingCarService {
	
	@Autowired
	private UserDaoImpl udi = null;
	@Autowired
	private ProductDaoImpl pdi = null;
	@Autowired
	private ShoppingcarDaoImpl scdi = null;
	@Autowired
	private OrderDaoImpl odi = null;
	
	/**某买家的购物车*/
	public List<MShoppingCar> byName(String uname){
		return scdi.findByName(uname);
	}

	public boolean deleteSC(Integer scid) {
		// TODO Auto-generated method stub
		try {
			Shoppingcar sc = scdi.findById(scid);
			Product p = pdi.findById(sc.getProduct().getId());
			p.setNum(p.getNum()+sc.getNum());
			pdi.updateP(p);
			scdi.deleteById(scid);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}