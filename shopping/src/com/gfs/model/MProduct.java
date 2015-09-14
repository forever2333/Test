package com.gfs.model;


public class MProduct {
	private Integer pid = 0;
    private String pname = "";
    private String price = "";
    private Integer num = 0;
    private Integer allnum = 0;
    private String mpwd = "";
    private String mname = "";
    
	public MProduct() {
		super();
	}
	public MProduct(Integer pid, String pname, String price, Integer num,
			Integer allnum, String mpwd, String mname) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.num = num;
		this.allnum = allnum;
		this.mpwd = mpwd;
		this.mname = mname;
	}
	public MProduct(String pname, String price, Integer num, Integer allnum,
			String mpwd, String mname) {
		super();
		this.pname = pname;
		this.price = price;
		this.num = num;
		this.allnum = allnum;
		this.mpwd = mpwd;
		this.mname = mname;
	}
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getAllnum() {
		return allnum;
	}
	public void setAllnum(Integer allnum) {
		this.allnum = allnum;
	}
	public String getMpwd() {
		return mpwd;
	}
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
}