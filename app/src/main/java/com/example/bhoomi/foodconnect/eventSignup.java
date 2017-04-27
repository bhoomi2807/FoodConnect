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
import com.firebase.client.core.view.Event;

public class eventSignup extends Activity {
    TextView alusEvents;
    EditText nameE,passE,phoneE,emailE;
    Button signupE;
    Firebase eventObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_signup);

        Firebase.setAndroidContext(this);
        alusEvents=(TextView)findViewById(R.id.aluserEvent);
        nameE=(EditText)findViewById(R.id.nameEvent);
        passE=(EditText)findViewById(R.id.passEvent);
        signupE=(Button)findViewById(R.id.signupEvent);
        phoneE=(EditText)findViewById(R.id.pnoEvent);
        emailE=(EditText)findViewById(R.id.emailEvent);

        alusEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(eventSignup.this,commonLogin.class);
                startActivity(in);
            }
        });
        eventObj=new Firebase("https://foodconnect-ce150.firebaseio.com/");
        signupE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String unameH = nameE.getText().toString();
                final String passwordH = passE.getText().toString();
                final String phoneNoH = phoneE.getText().toString();
                final String eH = emailE.getText().toString();
                event e=new event(unameH,passwordH,phoneNoH,eH);
                eventObj.child(unameH).setValue(e);
            }
        });
    }

}
