package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.c0768448_w2020_mad3125_fp.R;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Adapter.CustomerListAdapter;
import Model.Customer;
import Util.DataStorage;

public class CustomerListActivity extends AppCompatActivity {
    private RecyclerView rvCustomers;
    private ArrayList customers;
    private ArrayList customerArrayList;
    private CustomerListAdapter custAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        rvCustomers =findViewById(R.id.rvCustomerList);
        try {
            loadCustomers();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        custAdapter = new CustomerListAdapter(customers);
        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvCustomers.setLayoutManager(mLinearLayoutManager);
        rvCustomers.setAdapter(custAdapter);
    }

    private void loadCustomers() throws ParseException {
        DataStorage.getInstance().loadData();
        customers = new ArrayList();
        HashMap<String, Customer> customerHashMap = DataStorage.getInstance().getAllCustomerHash();
        Collection<Customer> demoValues = customerHashMap.values();
        customerArrayList = new ArrayList<>(demoValues);
        customers.addAll(customerArrayList);

    }
}
