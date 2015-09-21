package com.pojo;

import java.sql.Timestamp;

/**
 * Refund entity. @author MyEclipse Persistence Tools
 */

public class Refund implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Account accountByFromUid;
	private Account accountByUid;
	private Float scash;
	private Integer type;
	private Timestamp rdate;

	// Constructors

	/** default constructor */
	public Refund() {
	}

	/** full constructor */
	public Refund(Account accountByFromUid, Account accountByUid, Float scash,
			Integer type, Timestamp rdate) {
		this.accountByFromUid = accountByFromUid;
		this.accountByUid = accountByUid;
		this.scash = scash;
		this.type = type;
		this.rdate = rdate;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Account getAccountByFromUid() {
		return this.accountByFromUid;
	}

	public void setAccountByFromUid(Account accountByFromUid) {
		this.accountByFromUid = accountByFromUid;
	}

	public Account getAccountByUid() {
		return this.accountByUid;
	}

	public void setAccountByUid(Account accountByUid) {
		this.accountByUid = accountByUid;
	}

	public Float getScash() {
		return this.scash;
	}

	public void setScash(Float scash) {
		this.scash = scash;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Timestamp getRdate() {
		return this.rdate;
	}

	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}

}