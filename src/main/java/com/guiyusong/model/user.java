package com.guiyusong.model;

import  java.util.Date;
public class user {
    private  int id;
    private  String username;
    private String password;
    private String email;
    private String gender;
    private  java.util.Date birthday;
    private Date birthDate;

    public user()
    {
    }


    public user(int id, String username , String password, String email, String gender, Date birthday){
        this.id=id;
        this.username=username;
        this.birthday = birthday;
        this.password=password;
        this.email=email;
        this.gender=gender;
    }

    public  int getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return  email;
    }

    public  String getGender(){
        return  gender;
    }

    public  Date getBirthday()
    {
        return birthday;
    }

    public void setId(int id){
        this.id =id;
    }

    public void  setUsername(String username){
        this.username= username;
    }

    public  void setPassword(String password){
        this.password=password;
    }

    public void  setEmail(String email){
        this.email=email;
    }

    public void setGender(String gender){
        this.gender=gender;
    }

    public void setBirthday(Date birthday){
        this.birthday = this.birthday;
    }

    @Override
    public String toString(){
        return  "User{"+
                "id="+id+
                ",username='"+username+'\''+
                ",password='"+password+'\''+
                ",email='"+email+'\''+
                ",gender='"+gender+'\''+
                ",birthDate='"+ birthday +'\''+
                '}';
    }


    public void setBirthDate(java.sql.Date birthDate) { this.birthDate = this.birthday;
    }

}


