package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.c0768448_w2020_mad3125_fp.Model.Bill;
import com.example.c0768448_w2020_mad3125_fp.R;

public class BillTypeDetailsActivity extends AppCompatActivity {
    FragmentManager fm;
    FragmentTransaction ft;
    Bill bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_type_details);
        getSupportActionBar().setTitle("Bill Information");
        Intent mIntent = getIntent();
        bill = (Bill) mIntent.getSerializableExtra("Bills");

        if(bill.getBillID().contains("MB"))
        {
            mobileFragment mobileFg = new mobileFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("mobileBill", bill);
            mobileFg.setArguments(bundle);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.mobileBox, mobileFg);
            ft.commit();
        }



    }
}
