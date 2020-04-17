package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c0768448_w2020_mad3125_fp.Adapter.BillListAdapter;
import com.example.c0768448_w2020_mad3125_fp.Model.Bill;
import com.example.c0768448_w2020_mad3125_fp.Model.Customer;
import com.example.c0768448_w2020_mad3125_fp.R;

import java.util.ArrayList;

public class ShowBillsActivity extends AppCompatActivity {
    private RecyclerView rvBillsList;
    private ArrayList billsList;
    private BillListAdapter billAdapter;
    private TextView txtTotalAmount;
    Customer cust;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bills);
        getSupportActionBar().setTitle("Bill Details");
        Intent mIntent = getIntent();
        cust = mIntent.getParcelableExtra("customerKey");
        billsList = cust.getAllBills();
        txtTotalAmount = findViewById(R.id.txtTotalBillAmount);
        if(!billsList.isEmpty()){
            txtTotalAmount.setText("Total Bill to Pay :"+ String.format("$ " + "%,.2f",cust.getTotalAmount()));
        }
        else
        {
            txtTotalAmount.setText("No bills to Pay");
        }
        rvBillsList = findViewById(R.id.rvShowBillDetails);
        billAdapter = new BillListAdapter(this.billsList);

        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvBillsList.setLayoutManager(mLinearLayoutManager);
        rvBillsList.setAdapter(billAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.customerlist_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.btnLogout:
                Intent logout = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(logout);
                finish();
                return true;
            case R.id.btnAddCustomer:
                Intent mIntent = new Intent(ShowBillsActivity.this, BillTypeDetailsActivity.class);
                mIntent.putExtra("custBillsAddNew", cust);
                startActivity(mIntent);

        }
        return true;
    }

    public ArrayList<Bill> getBillsArrayList()
    {
        return this.billsList;
    }
}
