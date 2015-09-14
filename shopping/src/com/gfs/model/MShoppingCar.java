package com.gfs.model;

public class MShoppingCar {
	private Integer id;
    private String pname;
    private Double price;
    private Integer num;
    /**单商品总价*/
    private Double pprice;
    /**购物车总价*/
    private Double allprice;
	public MShoppingCar() {
		super();
	}
	public MShoppingCar(Integer id, String pname, Double price, Integer num) {
		super();
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.num = num;
	}
	public MShoppingCar(Integer id, String pname, Double price, Integer num,
			Double pprice, Double allprice) {
		super();
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.num = num;
		this.pprice = pprice;
		this.allprice = allprice;
	}
	public MShoppingCar(Integer id, String pname, Double price, Integer num,
			Double pprice) {
		super();
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.num = num;
		this.pprice = pprice;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getPprice() {
		return pprice;
	}
	public void setPprice(Double pprice) {
		this.pprice = pprice;
	}
	public Double getAllprice() {
		return allprice;
	}
	public void setAllprice(Double allprice) {
		this.allprice = allprice;
	}
	
}
