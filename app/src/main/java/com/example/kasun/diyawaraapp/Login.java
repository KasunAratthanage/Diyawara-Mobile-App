package com.example.kasun.diyawaraapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onButtonClick(View v)
    {
        if (v.getId() == R.id.BTlogin) {
            EditText uname = (EditText) findViewById(R.id.ETusername);
            EditText pass = (EditText) findViewById(R.id.ETpassword);

            String unamestr = uname.getText().toString();
            String upassstr = pass.getText().toString();

            if (unamestr.equals("admin") && upassstr.equals("123")) {

                Intent i = new Intent(this,ManningCalculation.class);
                startActivity(i);
            }
            else

                Toast.makeText(Login.this, "Incorrect Username & Password", Toast.LENGTH_SHORT).show();
        }

    }
}
