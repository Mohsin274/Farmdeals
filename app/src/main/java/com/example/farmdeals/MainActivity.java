package com.example.farmdeals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openSignIn(View v){
        Intent a = new Intent(this, login.class);
        startActivity(a);
    }
    public void openSignUp(View v){
        Intent b = new Intent(this, signupPage.class);
        startActivity(b);
    }
}