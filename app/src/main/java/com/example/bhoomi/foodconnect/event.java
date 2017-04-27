package com.example.bhoomi.foodconnect;

/**
 * Created by Bhoomi on 10/3/2016.
 */
public class event {


    String uname,pass,phone,email;

    event()
    {}

    event(String uname,String pass,String phone,String email)
    {
        this.uname = uname;
        this.pass = pass;
        this.phone=phone;
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
