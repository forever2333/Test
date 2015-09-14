package com.gfs.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gfs.model.MProduct;
import com.gfs.model.PageBean;
import com.gfs.pojo.Product;
import com.gfs.service.LoginService;
import com.gfs.service.ManageService;
import com.gfs.service.ProductService;

@RequestMapping("/ma")
@Controller
public class ManageAction {
	
	private PageBean bean = null;
	
	@Autowired
	private LoginService loginS;
	@Autowired
	private ManageService ms;
	@Autowired
	private ProductService ps;
	
	@RequestMapping(value="addPro")
	public String addPro(MProduct mpro){
		Double pprice = 0.00d;
		try {
			pprice = Double.valueOf(mpro.getPrice());
			Product t = new Product(ms.getID(), ms.getM(mpro.getMname()),
									mpro.getPname(), pprice, 
									mpro.getNum(), mpro.getAllnum());
			ms.addProduct(t);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/spa/mlogin?&name="+mpro.getMname()+"&pwd="+mpro.getMpwd();
	}
	
	@RequestMapping(value="deleteP", params={"pid","mname","pwd"})
	public String deleteP(@RequestParam("pid") Integer pid,
			  @RequestParam("mname") String mname,
			  @RequestParam("pwd") String pwd){
		try {
			ms.deleteProduct(pid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/spa/mlogin?&name="+mname+"&pwd="+pwd;
	}
	
	@RequestMapping(value="updatePro", params={"pid","mname","pwd"})
	public String updatePro(@RequestParam("pid") Integer pid,
							@RequestParam("mname") String mname,
							@RequestParam("pwd") String pwd,
							Map<String, Object> map){
		try {
			map.put("mname", mname);
			map.put("pwd", pwd);
			
			map.put("product", ms.findProductById(pid));
			return "One";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/spa/mlogin?&name="+mname+"&pwd="+pwd;
	}
	
	@RequestMapping(value="updateProTru")
	public String updateProTru(MProduct mpro){
		Double pprice = 0.00d;
		try {
			pprice = Double.valueOf(mpro.getPrice());
			Product t = new Product(mpro.getPid(), ms.getM(mpro.getMname()),
									mpro.getPname(), pprice, 
									mpro.getNum(), mpro.getAllnum());
			ms.addProduct(t);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/spa/mlogin?&name="+mpro.getMname()+"&pwd="+mpro.getMpwd();
	}
	
}
