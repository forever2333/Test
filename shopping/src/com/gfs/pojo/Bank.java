package com.gfs.pojo;



/**
 * Bank entity. @author MyEclipse Persistence Tools
 */

public class Bank  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Merchant merchant;
     private User user;
     private Double money;
     private Double agency;


    // Constructors

    /** default constructor */
    public Bank() {
    }

	/** minimal constructor */
    public Bank(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Bank(Integer id, Merchant merchant, User user, Double money, Double agency) {
        this.id = id;
        this.merchant = merchant;
        this.user = user;
        this.money = money;
        this.agency = agency;
    }

   
    // Property accessors

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

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public Double getMoney() {
        return this.money;
    }
    
    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getAgency() {
        return this.agency;
    }
    
    public void setAgency(Double agency) {
        this.agency = agency;
    }
   








}