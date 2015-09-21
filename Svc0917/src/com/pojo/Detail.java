package com.pojo;

import java.sql.Timestamp;

/**
 * Detail entity. @author MyEclipse Persistence Tools
 */

public class Detail implements java.io.Serializable {

	// Fields

	private Integer id;
	private User userByToUid;
	private User userByUid;
	private Integer type;
	private Float cash;
	private Integer status;
	private Timestamp tdate;

	// Constructors

	/** default constructor */
	public Detail() {
	}

	/** full constructor */
	public Detail(User userByToUid, User userByUid, Integer type, Float cash,
			Integer status, Timestamp tdate) {
		this.userByToUid = userByToUid;
		this.userByUid = userByUid;
		this.type = type;
		this.cash = cash;
		this.status = status;
		this.tdate = tdate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUserByToUid() {
		return this.userByToUid;
	}

	public void setUserByToUid(User userByToUid) {
		this.userByToUid = userByToUid;
	}

	public User getUserByUid() {
		return this.userByUid;
	}

	public void setUserByUid(User userByUid) {
		this.userByUid = userByUid;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Float getCash() {
		return this.cash;
	}

	public void setCash(Float cash) {
		this.cash = cash;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getTdate() {
		return this.tdate;
	}

	public void setTdate(Timestamp tdate) {
		this.tdate = tdate;
	}

}