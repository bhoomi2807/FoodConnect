package com.example.bhoomi.foodconnect;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hotelRegister(View view) {
        Intent startNewActivity = new Intent(this, hotelSignup.class);
        startActivity(startNewActivity);

    }

    public void eventRegister(View view) {
        Intent startNewActivity = new Intent(this, eventSignup.class);
        startActivity(startNewActivity);

    }

    public void ngoRegister(View view) {
        Intent startNewActivity = new Intent(this, ngoSignup.class);
        startActivity(startNewActivity);

    }

    public void pmcRegister(View view) {
        Intent startNewActivity = new Intent(this, pnLogin.class);
        startActivity(startNewActivity);

    }
}