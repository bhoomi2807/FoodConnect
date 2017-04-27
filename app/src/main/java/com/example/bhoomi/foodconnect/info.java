package com.example.bhoomi.foodconnect;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

public class info extends Activity {
    Firebase fObj12;
    Button btnExit,btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Firebase.setAndroidContext(this);
        fObj12=new Firebase("https://foodconnect-ce150.firebaseio.com/");
        final TextView nameText=(TextView)findViewById(R.id.name1);
        final TextView phoneText=(TextView)findViewById(R.id.phone1);
        final TextView locText=(TextView)findViewById(R.id.loc1);
        final TextView ncText=(TextView)findViewById(R.id.nc);
        final TextView cText=(TextView)findViewById(R.id.c);
        btnExit=(Button)findViewById(R.id.exit);
        btnAccept = (Button) findViewById(R.id.accept);

        Intent intent=getIntent();
        final String hname= intent.getStringExtra(listAll.EXTRA_MESSAGE);
        Log.e("Error",hname);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                //System.exit(0);

            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAct = new Intent(info.this,listAll.class);
                startActivity(openAct);
                Toast.makeText(getApplicationContext(),"Thank You for accepting",Toast.LENGTH_SHORT).show();
            }
        });
        fObj12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Person person = postSnapshot.getValue(Person.class);
                    if (person.getUname().toString().equals(hname)) {

                       nameText.setText(person.getUname().toString());
                        phoneText.setText(person.getPhone().toString());
                        locText.setText(person.getLoc().toString());
                        ncText.setText(""+person.getC());
                        cText.setText(""+person.getNc());


                    }

                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}
