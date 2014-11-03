package com.rnr.model;

public class UserInfo{
    private String name;
    private String password;
    private String mail;

    public void setName(String name){
        this.name=name;
    }
    
    public String getName(){
        return name;
    }

    public void setPassword(String password){
        this.password=password;
    }
    
    public String getPassword(){
        return password;
    }

    public boolean checkavailibility(){
        Log log=new Log();
        return log.isValidName(name);
    }

    public boolean verifypassword(){
        Log log=new Log();
        return log.isValidPassword(name,password);
    }

    public void writeuserinfo(){
        Log log=new Log();
        log.writeUserinfo(name,password);
    }
}
