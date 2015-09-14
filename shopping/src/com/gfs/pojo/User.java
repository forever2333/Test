package com.gfs.pojo;

import java.util.HashSet;
import java.util.Set;


/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String password;
     private Set peoples = new HashSet(0);
     private Set banks = new HashSet(0);
     private Set orders = new HashSet(0);
     private Set shoppingcars = new HashSet(0);


    // Constructors

    /** default constructor */
    public User() {
    }

	/** minimal constructor */
    public User(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    
    /** full constructor */
    public User(Integer id, String name, String password, Set peoples, Set banks, Set orders, Set shoppingcars) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.peoples = peoples;
        this.banks = banks;
        this.orders = orders;
        this.shoppingcars = shoppingcars;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Set getPeoples() {
        return this.peoples;
    }
    
    public void setPeoples(Set peoples) {
        this.peoples = peoples;
    }

    public Set getBanks() {
        return this.banks;
    }
    
    public void setBanks(Set banks) {
        this.banks = banks;
    }

    public Set getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set orders) {
        this.orders = orders;
    }

    public Set getShoppingcars() {
        return this.shoppingcars;
    }
    
    public void setShoppingcars(Set shoppingcars) {
        this.shoppingcars = shoppingcars;
    }
   








}