package com.gfs.pojo;



/**
 * Shoppingcar entity. @author MyEclipse Persistence Tools
 */

public class Shoppingcar  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private User user;
     private Product product;
     private Integer num;


    // Constructors

    /** default constructor */
    public Shoppingcar() {
    }

	/** minimal constructor */
    public Shoppingcar(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Shoppingcar(Integer id, User user, Product product, Integer num) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.num = num;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getNum() {
        return this.num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }
   








}