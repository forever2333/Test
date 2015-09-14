package com.gfs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfs.dao.impl.OrderDaoImpl;
import com.gfs.dao.impl.ProductDaoImpl;
import com.gfs.dao.impl.ShoppingcarDaoImpl;
import com.gfs.dao.impl.UserDaoImpl;
import com.gfs.pojo.Order;
import com.gfs.pojo.Shoppingcar;
import com.tool.MyTool;

@Service("orderService")
public class OrderService {
	
	@Autowired
	private UserDaoImpl udi = null;
	@Autowired
	private ProductDaoImpl pdi = null;
	@Autowired
	private ShoppingcarDaoImpl scdi = null;
	@Autowired
	private OrderDaoImpl odi = null;
	
	/**添加订单*/
	public boolean addOrder(String uname) {
		// TODO Auto-generated method stub
		try {
			List<?> idlist = odi.getAllId();
			Integer id = MyTool.getTruID(idlist);
			List<Shoppingcar> sclist = scdi.findByUName(uname);
			Order o = new Order(id, udi.findByName(uname), odi.getOrderTitle(sclist), 0);
			odi.addOrder(o);
			scdi.deleteSCByUName(uname);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**删除订单*/
	public boolean deleteOrder(Integer oid){
		try {
			odi.deleteById(oid);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**修改订单*/
	public boolean updateOrder(Integer oid,Integer type){
		if (type==null||type==0) {
			return true;
		}
		try {
			Order o = odi.findById(oid);
			o.setType(type);
			odi.update(o);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**查询订单*/
	public List<?> findByType(String uname, int type){
		return odi.findByType(uname, type);
	}
	
}
