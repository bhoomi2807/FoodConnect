package com.example.bhoomi.foodconnect;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class listAll extends Activity {
    public final static String EXTRA_MESSAGE = "com.example.bhoomi.foodconnect.MESSAGE";

    ListView listView;
    Firebase fObj1;
    String listItem,hotel;
    ArrayList names=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all);
        Firebase.setAndroidContext(this);
        fObj1=new Firebase("https://foodconnect-ce150.firebaseio.com/");

        listView=(ListView)findViewById(R.id.list);


        fObj1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Person person = postSnapshot.getValue(Person.class);
                    listItem=person.getUname().toString();
                    names.add(listItem);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(getApplicationContext(), "Database error", Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.text_view,names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(listAll.this,info.class);
                hotel = parent.getItemAtPosition(position).toString();
                Log.e("Error",hotel);
                intent.putExtra(EXTRA_MESSAGE,hotel);
                startActivity(intent);
            }
        });


    }
}
