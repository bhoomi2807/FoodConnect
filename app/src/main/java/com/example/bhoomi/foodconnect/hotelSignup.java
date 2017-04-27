package com.example.bhoomi.foodconnect;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class hotelSignup extends Activity {

    String veg="no",nveg="no";
    EditText nameH,passH,phoneH,locH,emailH;
    TextView alusHotel;
    Firebase HotelObj;
    Button  signupH;
    CheckBox vegH,nonvegH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hotel_signup);
        alusHotel=(TextView)findViewById(R.id.aluserHotel);
        nameH=(EditText)findViewById(R.id.nameHotel);
        passH=(EditText)findViewById(R.id.passHotel);
        signupH=(Button)findViewById(R.id.signupHotel);
        phoneH=(EditText)findViewById(R.id.pnoHotel);
        locH=(EditText)findViewById(R.id.locHotel);
        emailH=(EditText)findViewById(R.id.emailHotel);
        vegH=(CheckBox)findViewById(R.id.vegHotel);
        nonvegH=(CheckBox)findViewById(R.id.nonVegHotel);

        alusHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(hotelSignup.this,commonLogin.class);
                startActivity(in);
            }
        });
        Firebase.setAndroidContext(this);
        HotelObj=new Firebase("https://foodconnect-ce150.firebaseio.com/");
        signupH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vegH.isChecked())
                {
                    veg = "Yes";
                }
                if(nonvegH.isChecked())
                {
                    nveg = "Yes";
                }
                final String vegH=veg;
                final String nonvegH=nveg;
                final String unameH = nameH.getText().toString();
                final String passwordH = passH.getText().toString();
                final String phoneNoH = phoneH.getText().toString();
                final String locationH = locH.getText().toString();
                final String eH = emailH.getText().toString();
                Person person=new Person(unameH,passwordH,phoneNoH,locationH,eH,vegH,nonvegH);
                HotelObj.child(unameH).setValue(person);
            }
        });
    }
}
