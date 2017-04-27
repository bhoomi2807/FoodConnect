package com.example.bhoomi.foodconnect;

/**
 * Created by Admin on 10/4/2016.
 */
public class Ngo {
    String uname,pass,phone,loc,email;

    Ngo()
    {}

    Ngo(String uname,String pass,String phone,String loc,String email)
    {
        this.uname = uname;
        this.pass = pass;
        this.phone=phone;
        this.loc=loc;
        this.email=email;

    }
    String getUname()
    {

        return this.uname;

    }
    String getPass()
    {

        return this.pass;

    }
}
