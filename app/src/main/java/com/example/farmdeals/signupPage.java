package com.example.farmdeals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signupPage extends AppCompatActivity {
    EditText User_id, Mobile_no, Email, Address, Password;
    Button createacc;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        User_id = (EditText) findViewById(R.id.name_input);
        Mobile_no = (EditText) findViewById(R.id.number_input);
        Email = (EditText) findViewById(R.id.email_input);
        Address = (EditText) findViewById(R.id.address_input);
        Password = (EditText) findViewById(R.id.password_input);

        createacc = (Button) findViewById(R.id.create);

        myDB = new DBHelper(this);

        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = User_id.getText().toString();
                String mobile = Mobile_no.getText().toString();
                String email = Email.getText().toString();
                String address = Address.getText().toString();
                String pass = Password.getText().toString();

                if (user.equals("") || mobile.equals("") || email.equals("") || address.equals("") || pass.equals("")) {
                    Toast.makeText(signupPage.this, "Fill all the fields!", Toast.LENGTH_SHORT).show();
                } else {
                    boolean usercheckresult = myDB.checkUser_id(user);
                    if (usercheckresult == false) {
                        boolean regresult = myDB.insertData(user, mobile, email, address, pass);
                        if (regresult == true) {
                            Toast.makeText(signupPage.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(signupPage.this, login.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(signupPage.this, "Registration failed!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(signupPage.this, "User already exists!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }
}