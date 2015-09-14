package com.gfs.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gfs.model.MShoppingCar;
import com.gfs.model.PageBean;
import com.gfs.service.LoginService;
import com.gfs.service.ManageService;
import com.gfs.service.OrderService;
import com.gfs.service.ProductService;
import com.gfs.service.ShoppingCarService;
import com.tool.MyTool;

@RequestMapping("/spa")
@Controller
public class ShowProductAction {
	
	private PageBean bean = null;
	
	@Autowired
	private LoginService loginS;
	@Autowired
	private ProductService productS;
	@Autowired
	private ShoppingCarService SCS;
	@Autowired
	private OrderService orders;
	@Autowired
	private ManageService ms;
	
	@RequestMapping(value="mlogin", params={"name","pwd"})
	public String mlogin(@RequestParam("name") String name, 
						 @RequestParam("pwd") String pwd,
						 Map<String, Object> map){
		try {
			if (loginS.login(1, name, pwd)) {
				bean = new PageBean(1, 15);
				bean.setTotalCount(ms.getNumByM(name));
				map.put("allTotal", bean.getTotalCount());
				map.put("myProducts", ms.getProByName(name,bean));
				map.put("mname", name);
				map.put("pwd", pwd);
				return "MyProduct";
			}else {
				return "index";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "fail";
	}
	
	@RequestMapping(value="ulogin", params={"name","pwd"})
	public String ulogin(@RequestParam("name") String name, 
						 @RequestParam("pwd") String pwd,
						 Map<String, Object> map){
		try {
			if (loginS.login(0, name, pwd)) {
				bean = new PageBean(1, 5);
				bean.setTotalCount(productS.getNumByP());
				
				List<MShoppingCar> msclist = SCS.byName(name);
				Double allprice = 0.00D;
				if (!(msclist==null||msclist.size()<1)) {
					for (MShoppingCar msc : msclist) {
						allprice = allprice + msc.getPprice();
					}
				}
				
				map.put("pwd", pwd);
				map.put("uname", name);
				map.put("products", productS.getAllP(bean));
				map.put("totalP", bean.getTotalPage());
				map.put("shoppingcars", msclist);
				map.put("allprice", MyTool.moneyChange(allprice));
				return "allProduct";
			}else {
				return "index";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "fail";
	}
	
	@RequestMapping(value="ureg", params={"name","pwd"})
	public String ureg(@RequestParam("name") String name, 
			 		   @RequestParam("pwd") String pwd){
		try {			
			if (loginS.reg(name, pwd)) {
				return "index";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "fail";
	}
	
	@RequestMapping(value="addSC", params={"pid","num","uname","pwd"})
	public String addSC(@RequestParam("pid") Integer pid,
			 		    @RequestParam("num") int num,
			 		    @RequestParam("uname") String uname,
			 		    @RequestParam("pwd") String pwd){
		try {
			if (num==0) {
				return "redirect:/spa/ulogin?&name="+uname+"&pwd="+pwd;
			}
			if (productS.addShoppingCar(uname, pid, num)) {
				return "redirect:/spa/ulogin?&name="+uname+"&pwd="+pwd;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "fail";
	}
	
	@RequestMapping(value="deleteSC", params={"scid","uname","pwd"})
	public String deleteSC(@RequestParam("scid") Integer scid,
							  @RequestParam("uname") String uname,
							  @RequestParam("pwd") String pwd){
		try {
			if (SCS.deleteSC(scid)) {
				return "redirect:/spa/ulogin?&name="+uname+"&pwd="+pwd;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "fail";
	}
	
	@RequestMapping(value="addOrder", params={"uname","pwd"})
	public String addOrder(@RequestParam("uname") String uname,
						   @RequestParam("pwd") String pwd){
		try {
			if (orders.addOrder(uname)) {
				return "redirect:/spa/ulogin?&name="+uname+"&pwd="+pwd;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "fail";
	}
}
