package com.gfs.pojo;

import java.util.HashSet;
import java.util.Set;


/**
 * Merchant entity. @author MyEclipse Persistence Tools
 */

public class Merchant  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String password;
     private Set products = new HashSet(0);
     private Set banks = new HashSet(0);


    // Constructors

    /** default constructor */
    public Merchant() {
    }

	/** minimal constructor */
    public Merchant(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Merchant(Integer id, String name, String password, Set products, Set banks) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.products = products;
        this.banks = banks;
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

    public Set getProducts() {
        return this.products;
    }
    
    public void setProducts(Set products) {
        this.products = products;
    }

    public Set getBanks() {
        return this.banks;
    }
    
    public void setBanks(Set banks) {
        this.banks = banks;
    }
   








}