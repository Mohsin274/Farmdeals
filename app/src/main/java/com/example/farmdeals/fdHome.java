package com.example.farmdeals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class fdHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fd_home);
    }

    public void openQtySelect(View v){
        Intent i = new Intent(this, qtySelection.class);
        startActivity(i);
    }

}