package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        dataStorage.loadData();
        customers = dataStorage.getAllCustomers();
        rvCustomers = findViewById(R.id.rvCustomerList);
        custAdapter = new CustomerListAdapter(customers);
        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvCustomers.setLayoutManager(mLinearLayoutManager);
        rvCustomers.setAdapter(custAdapter);
    }


}
