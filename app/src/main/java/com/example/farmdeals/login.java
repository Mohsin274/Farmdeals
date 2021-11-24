package com.example.farmdeals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login<c> extends AppCompatActivity {
    public Button button,log;
    public EditText user,pass;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        button=(Button) findViewById(R.id.signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this, signupPage.class);
                startActivity(intent);
            }
        });

        user=(EditText)findViewById(R.id.input);
        pass=(EditText)findViewById(R.id.password1);
        myDB=new DBHelper(this);
        log=(Button)findViewById(R.id.login);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=user.getText().toString();
                String password=pass.getText().toString();
                if(username.equals("")||password.equals("")){
                    Toast.makeText(login.this, "Please enter all credentials", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean result=myDB.checkUser_idPassword(username,password);
                    if(result==true){
                        Toast.makeText(login.this, "Login successful!", Toast.LENGTH_SHORT).show();
                        Intent I = new Intent(login.this, fdHome.class);
                        startActivity(I);
                    }
                    else{
                        Toast.makeText(login.this, "Invalid credentials!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}