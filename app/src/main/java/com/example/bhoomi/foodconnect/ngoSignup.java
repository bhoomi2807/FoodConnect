package com.example.bhoomi.foodconnect;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class ngoSignup extends Activity {

    EditText nameN,passN,phoneN,locN,emailN;
    Button signupN;

    TextView alusNgo;
    Firebase ngoObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Firebase.setAndroidContext(this);
        ngoObj=new Firebase("https://foodconnect-ce150.firebaseio.com/");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_signup);
        alusNgo=(TextView)findViewById(R.id.aluserNgo);
        nameN=(EditText)findViewById(R.id.nameNgo);
        passN=(EditText)findViewById(R.id.passNgo);
        signupN=(Button)findViewById(R.id.signupNgo);
        phoneN=(EditText)findViewById(R.id.pnoNgo);
        locN=(EditText)findViewById(R.id.locNgo);
        emailN=(EditText)findViewById(R.id.emailNgo);

        alusNgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(ngoSignup.this,pnLogin.class);
                startActivity(in);
            }
        });
        signupN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String unameN = nameN.getText().toString();
                final String passwordN = passN.getText().toString();
                final String phoneNoN = phoneN.getText().toString();
                final String locationN = locN.getText().toString();
                final String eN = emailN.getText().toString();
                Ngo ngo=new Ngo(unameN,passwordN,phoneNoN,locationN,eN);
                ngoObj.child(unameN).setValue(ngo);
            }
        });

    }
}