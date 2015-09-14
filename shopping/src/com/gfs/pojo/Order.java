package com.gfs.pojo;



/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private User user;
     private String bought;
     private Integer type;


    // Constructors

    /** default constructor */
    public Order() {
    }

	/** minimal constructor */
    public Order(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Order(Integer id, User user, String bought, Integer type) {
        this.id = id;
        this.user = user;
        this.bought = bought;
        this.type = type;
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

    public String getBought() {
        return this.bought;
    }
    
    public void setBought(String bought) {
        this.bought = bought;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
   








}