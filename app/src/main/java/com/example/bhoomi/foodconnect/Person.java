package com.example.bhoomi.foodconnect;

/**
 * Created by Bhoomi on 9/28/2016.
 */
import java.io.Serializable;
public class Person implements Serializable{
    String uname,pass,phone,loc,email,veg,nveg;
    int c,nc;

    Person()
    {}

    Person(String uname,String pass,String phone,String loc,String email,String veg,String nveg)
    {
        this.uname = uname;
        this.pass = pass;
        this.phone=phone;
        this.loc=loc;
        this.email=email;
        this.veg=veg;
        this.nveg=nveg;
        this.c = 0;
        this.nc = 0;

    }
    String getUname()
    {

      return this.uname;

    }
    String getPass()
    {

        return this.pass;

    }
    String getPhone(){
        return this.phone;
    }
    String getLoc(){
        return this.loc;

    }
    String getEmail(){
        return this.email;
    }

    void setC(int c)
    {
        this.c = c;
    }
    void setNC(int nc)
    {
        this.nc = nc;
    }
    int getC()
    {

        return this.c;

    }
    int getNc()
    {

        return this.nc;

    }


}
