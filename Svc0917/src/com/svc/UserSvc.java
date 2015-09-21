package com.svc;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.database.HibernateSessionFactory;
import com.pojo.User;
import com.tools.EncyptTools;

@Path("usersvc")
public class UserSvc {	
	@GET
	@Path("login/{username},{loginpwd}")
	@Produces(MediaType.APPLICATION_JSON)
	public String login(@PathParam("username")String userName,@PathParam("loginpwd")String loginPwd){
		String flag="Password ERROR!!!";
		Session session=HibernateSessionFactory.getSession();
		User user=(User) session.createQuery("from User where uname=?").setString(0,userName).uniqueResult();
		if(null==user){
			flag ="User is NOT exists!!!";
			return "{\"login\":[{\"status\":"+flag+"}]}";
		}
		if(user.getLoginPwd().equals(EncyptTools.MessageEncypt(loginPwd))){
			flag="Login successfully!!!";
		}
		int uid=user.getUid();
		HibernateSessionFactory.closeSession();
		return "{\"login\":[{\"status\":"+flag+",\"uid\":"+uid+"}]}";
	}
}