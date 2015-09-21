package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private String loginPwd;
	private Set detailsForToUid = new HashSet(0);
	private Set detailsForUid = new HashSet(0);
	private Set accounts = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String uname, String loginPwd) {
		this.uname = uname;
		this.loginPwd = loginPwd;
	}

	/** full constructor */
	public User(String uname, String loginPwd, Set detailsForToUid,
			Set detailsForUid, Set accounts) {
		this.uname = uname;
		this.loginPwd = loginPwd;
		this.detailsForToUid = detailsForToUid;
		this.detailsForUid = detailsForUid;
		this.accounts = accounts;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public Set getDetailsForToUid() {
		return this.detailsForToUid;
	}

	public void setDetailsForToUid(Set detailsForToUid) {
		this.detailsForToUid = detailsForToUid;
	}

	public Set getDetailsForUid() {
		return this.detailsForUid;
	}

	public void setDetailsForUid(Set detailsForUid) {
		this.detailsForUid = detailsForUid;
	}

	public Set getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set accounts) {
		this.accounts = accounts;
	}

}