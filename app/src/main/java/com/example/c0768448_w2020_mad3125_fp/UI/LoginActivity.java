package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;



import com.example.c0768448_w2020_mad3125_fp.R;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class LoginActivity extends AppCompatActivity {

    EditText _emailText;
    EditText _passwordText;
    Button _loginButton;
    SwitchMaterial switchRememberMe;
    private SharedPreferences loginPrefer;
    private SharedPreferences.Editor loginEditorPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");

        _emailText = findViewById(R.id.edt_emailID);
        _passwordText = findViewById(R.id.edt_password);
        _loginButton = findViewById(R.id.btnLogin);
        switchRememberMe = findViewById(R.id.switchRememberMe);

        getSupportActionBar().hide();

        loginPrefer = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginEditorPref = loginPrefer.edit();

        _emailText.setText(loginPrefer.getString("username", null));
        _passwordText.setText(loginPrefer.getString("password", null));

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                login();
            }
        });


    }

    void login()
    {
        if(_emailText.getText().toString().isEmpty() && _passwordText.getText().toString().isEmpty())
        {
            _emailText.setError("Please Enter Email ID");
            _passwordText.setError("Please Enter Password");
        }
        else if(_emailText.getText().toString().isEmpty())
        {
            _emailText.setError("Please Enter Email ID");
        }
        else if(_passwordText.getText().toString().isEmpty())
        {
            _passwordText.setError("Please Enter Password");
        }
        else if(_emailText.getText().toString().equals("user@gmail.com") && _passwordText.getText().toString().equals("user@123"))
        {
            String username = _emailText.getText().toString();
            String password = _passwordText.getText().toString();
            if(switchRememberMe.isChecked())
            {
                loginEditorPref.putString("username", username);
                loginEditorPref.putString("password", password);
                loginEditorPref.apply();

                Intent mIntent = new Intent(LoginActivity.this, CustomerListActivity.class);
                startActivity(mIntent);
            }
            else
            {
                loginEditorPref.clear();
                loginEditorPref.apply();

                Intent mIntent = new Intent(LoginActivity.this, CustomerListActivity.class);
                startActivity(mIntent);
            }
        }
        else
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
            alert.setCancelable(false);
            alert.setTitle("Invalid Login Credentials");
            alert.setMessage("Invalid Email ID and Password");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = alert.create();
            alertDialog.show();
        }
    }
}
