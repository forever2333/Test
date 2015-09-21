package com.vo;

public class RefundType {
	private int sid;
	private int uid;
	private int from;
	private float cash;
	private int type;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public float getCash() {
		return cash;
	}
	public void setCash(float cash) {
		this.cash = cash;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public RefundType(int sid, int uid, int from, float cash, int type) {
		super();
		this.sid = sid;
		this.uid = uid;
		this.from = from;
		this.cash = cash;
		this.type = type;
	}
	public RefundType() {
		super();
	}
}
