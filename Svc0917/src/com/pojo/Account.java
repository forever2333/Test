package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private Integer aid;
	private User user;
	private String paypwd;
	private String account;
	private Float cash;
	private Float init;
	private Integer atype;
	private Set refundsForUid = new HashSet(0);
	private Set refundsForFromUid = new HashSet(0);

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** minimal constructor */
	public Account(User user, String paypwd, String account, Float cash,
			Float init, Integer atype) {
		this.user = user;
		this.paypwd = paypwd;
		this.account = account;
		this.cash = cash;
		this.init = init;
		this.atype = atype;
	}

	/** full constructor */
	public Account(User user, String paypwd, String account, Float cash,
			Float init, Integer atype, Set refundsForUid, Set refundsForFromUid) {
		this.user = user;
		this.paypwd = paypwd;
		this.account = account;
		this.cash = cash;
		this.init = init;
		this.atype = atype;
		this.refundsForUid = refundsForUid;
		this.refundsForFromUid = refundsForFromUid;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPaypwd() {
		return this.paypwd;
	}

	public void setPaypwd(String paypwd) {
		this.paypwd = paypwd;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Float getCash() {
		return this.cash;
	}

	public void setCash(Float cash) {
		this.cash = cash;
	}

	public Float getInit() {
		return this.init;
	}

	public void setInit(Float init) {
		this.init = init;
	}

	public Integer getAtype() {
		return this.atype;
	}

	public void setAtype(Integer atype) {
		this.atype = atype;
	}

	public Set getRefundsForUid() {
		return this.refundsForUid;
	}

	public void setRefundsForUid(Set refundsForUid) {
		this.refundsForUid = refundsForUid;
	}

	public Set getRefundsForFromUid() {
		return this.refundsForFromUid;
	}

	public void setRefundsForFromUid(Set refundsForFromUid) {
		this.refundsForFromUid = refundsForFromUid;
	}

}