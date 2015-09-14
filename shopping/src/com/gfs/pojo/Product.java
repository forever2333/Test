package com.gfs.pojo;

import java.util.HashSet;
import java.util.Set;


/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Merchant merchant;
     private String name;
     private Double price;
     private Integer num;
     private Integer allnum;
     private Set shoppingcars = new HashSet(0);


    // Constructors

    /** default constructor */
    public Product() {
    }

	/** minimal constructor */
    public Product(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Product(Integer id, Merchant merchant, String name, Double price, Integer num, Integer allnum, Set shoppingcars) {
        this.id = id;
        this.merchant = merchant;
        this.name = name;
        this.price = price;
        this.num = num;
        this.allnum = allnum;
        this.shoppingcars = shoppingcars;
    }

   
    // Property accessors

    public Product(Integer id, Merchant merchant, String name, Double price,
			Integer num, Integer allnum) {
		super();
		this.id = id;
		this.merchant = merchant;
		this.name = name;
		this.price = price;
		this.num = num;
		this.allnum = allnum;
	}

	public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Merchant getMerchant() {
        return this.merchant;
    }
    
    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return this.num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getAllnum() {
        return this.allnum;
    }
    
    public void setAllnum(Integer allnum) {
        this.allnum = allnum;
    }

    public Set getShoppingcars() {
        return this.shoppingcars;
    }
    
    public void setShoppingcars(Set shoppingcars) {
        this.shoppingcars = shoppingcars;
    }
   








}