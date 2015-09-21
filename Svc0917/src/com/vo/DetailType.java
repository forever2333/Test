package com.vo;

import java.sql.Timestamp;

public class DetailType {
	private int id;
	private int fromId;
	private int toId;
	private int type;
	private float cash;
	private int status;
	private Timestamp date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFromId() {
		return fromId;
	}
	public void setFromId(int fromId) {
		this.fromId = fromId;
	}
	public int getToId() {
		return toId;
	}
	public void setToId(int toId) {
		this.toId = toId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public float getCash() {
		return cash;
	}
	public void setCash(float cash) {
		this.cash = cash;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public DetailType(int id, int fromId, int toId, int type, float cash,
			int status, Timestamp date) {
		super();
		this.id = id;
		this.fromId = fromId;
		this.toId = toId;
		this.type = type;
		this.cash = cash;
		this.status = status;
		this.date = date;
	}
	
	public DetailType(int fromId, int toId, float cash) {
		super();
		this.fromId = fromId;
		this.toId = toId;
		this.cash = cash;
	}
	public DetailType() {
		super();
	}
}
