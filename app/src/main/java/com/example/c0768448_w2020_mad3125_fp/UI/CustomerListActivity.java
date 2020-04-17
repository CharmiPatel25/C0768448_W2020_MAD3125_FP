package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.c0768448_w2020_mad3125_fp.R;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Adapter.CustomerListAdapter;
import Model.Customer;
import Util.DataStorage;

import static java.security.AccessController.getContext;

public class CustomerListActivity extends AppCompatActivity {
    private RecyclerView rvCustomers;
    private ArrayList customers;
    private ArrayList customerArrayList;
    private CustomerListAdapter custAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Customers");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        DataStorage dataStorage = DataStorage.getInstance();
        try {
            dataStorage.loadData();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        customers = dataStorage.getAllCustomers();
        rvCustomers = findViewById(R.id.rvCustomerList);
        custAdapter = new CustomerListAdapter(customers);
        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvCustomers.setLayoutManager(mLinearLayoutManager);
        rvCustomers.setAdapter(custAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.customerlist_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.btnAddCustomer:
                Intent mIntent = new Intent(CustomerListActivity.this, AddNewCustomerActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btnLogout:
                Intent mLogout = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(mLogout);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}