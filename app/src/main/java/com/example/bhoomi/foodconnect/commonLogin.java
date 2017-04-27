package com.example.bhoomi.foodconnect;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class commonLogin extends Activity {
    public final static String MyClass = "com.example.bhoomi.foodconnect.MESSAGE";

    Firebase fbObj;
    EditText login,pass;
    Button auth;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_login);
        Firebase.setAndroidContext(this);
        fbObj=new Firebase("https://foodconnect-ce150.firebaseio.com/");
        auth=(Button)findViewById(R.id.login);
        login=(EditText)findViewById(R.id.loginAll);
        pass=(EditText)findViewById(R.id.passAll);

        auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String unameS = login.getText().toString();
                final String passS = pass.getText().toString();
                if (login.getText().toString().trim().length() == 0 || pass.getText().toString().trim().length() == 0) {
                    if (login.getText().toString().trim().length() == 0)
                        login.setError("Username Empty");
                    if (pass.getText().toString().trim().length() == 0)
                        pass.setError("Password Empty");
                } else
                    fbObj.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                                Person person = postSnapshot.getValue(Person.class);
                                if (person.getUname().toString().equals(unameS.toString())) {
                                    flag = 1;
                                    if (person.getPass().equals(passS)) {

                                        Intent intent = new Intent(commonLogin.this,updateHotel.class);
                                        intent.putExtra("MyClass",person);
                                        startActivity(intent);

                                    } else {
                                        Toast.makeText(getApplicationContext(), "Password Incorrect", Toast.LENGTH_SHORT).show();
                                    }
                                }

                            }
                            if (flag == 0) {
                                Toast.makeText(getApplicationContext(), "Username Incorrect", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            Toast.makeText(getApplicationContext(), "Database error", Toast.LENGTH_SHORT).show();

                        }
                    });
            }
        });
    }
}