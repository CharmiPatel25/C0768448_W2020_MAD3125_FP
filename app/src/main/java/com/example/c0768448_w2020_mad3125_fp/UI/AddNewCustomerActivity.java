package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.c0768448_w2020_mad3125_fp.R;

public class AddNewCustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_customer);
        getSupportActionBar().setTitle("Add New Customer");
    }
}
