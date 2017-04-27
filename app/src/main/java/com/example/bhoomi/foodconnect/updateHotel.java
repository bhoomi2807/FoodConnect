package com.example.bhoomi.foodconnect;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.w3c.dom.DOMError;

public class updateHotel extends Activity {

    int Ccounter=0,NCcounter=0;
    Button ConAdd,ConSub,NConAdd,NConSub,Done;
    EditText Conedit,NConedit;
    Firebase fbObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_hotel);
        Firebase.setAndroidContext(this);
        fbObj=new Firebase("https://foodconnect-ce150.firebaseio.com/");

        ConAdd = (Button) findViewById(R.id.cAdd);
        ConSub = (Button) findViewById(R.id.cSub);
        NConAdd = (Button) findViewById(R.id.nAdd);
        NConSub = (Button) findViewById(R.id.nSub);
        Done  =(Button) findViewById(R.id.done);
        Conedit = (EditText) findViewById(R.id.cEdit);
        NConedit = (EditText) findViewById(R.id.ncEdit);
        Conedit.setText(""+Ccounter);
        NConedit.setText(""+NCcounter);

        ConAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ccounter++;
                Conedit.setText(""+Ccounter);
            }
        });

        ConSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Integer.parseInt(Conedit.getText().toString()) <= 0)
                {
                    Ccounter=0;
                    Conedit.setText(" "+Ccounter);
                }
                else
                {
                    Ccounter--;
                    Conedit.setText("" + Ccounter);
                }



            }
        });

        NConAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NCcounter++;
                NConedit.setText("" + NCcounter);
            }


        });

        NConSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Integer.parseInt(NConedit.getText().toString())<=0)
                {
                    NCcounter=0;
                    NConedit.setText(""+NCcounter);
                }
                else
                {
                    NCcounter--;
                    NConedit.setText("" + NCcounter);
                }




            }
        });

        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = getIntent();
                Person p = (Person) i.getSerializableExtra("MyClass");
                //getIntent().getSerializableExtra("MyClass");
                p.setC(Ccounter);
                p.setNC(NCcounter);
                fbObj.child(p.getUname()).setValue(p);
                Intent openAct = new Intent(updateHotel.this,MainActivity.class);
                startActivity(openAct);

            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}