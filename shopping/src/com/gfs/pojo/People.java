package com.gfs.pojo;



/**
 * People entity. @author MyEclipse Persistence Tools
 */

public class People  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private User user;
     private String name;
     private Integer age;
     private Integer sex;


    // Constructors

    /** default constructor */
    public People() {
    }

	/** minimal constructor */
    public People(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public People(Integer id, User user, String name, Integer age, Integer sex) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }
   








}