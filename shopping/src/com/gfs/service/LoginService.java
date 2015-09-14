package com.gfs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfs.dao.impl.MerchantDaoImpl;
import com.gfs.dao.impl.PeopleDaoImpl;
import com.gfs.dao.impl.UserDaoImpl;

@Service("loginService")
public class LoginService {
	
	@Autowired
	private UserDaoImpl udi = null;
	@Autowired
	private MerchantDaoImpl mdi = null;
	@Autowired
	private PeopleDaoImpl pdi = null;
	
	public boolean login(int type, String name, String pwd){ //0是user,1是merchant
		if (name==null||name.equals("")||pwd==null||pwd.equals("")) {
			return false;
		}
		switch (type) {
		case 0:
			return udi.login(name, pwd);
		case 1:
			return mdi.login(name, pwd);
		}
		return false;
	}
	
	public boolean reg(String name, String pwd){
		if (name==null||name.equals("")||pwd==null||pwd.equals("")) {
			return false;
		}
		return udi.reg(name, pwd);
	}
	
}
