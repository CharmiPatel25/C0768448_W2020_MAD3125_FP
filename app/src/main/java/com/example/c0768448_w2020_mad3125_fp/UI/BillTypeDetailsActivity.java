package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.c0768448_w2020_mad3125_fp.Model.Bill;
import com.example.c0768448_w2020_mad3125_fp.Model.Hydro;
import com.example.c0768448_w2020_mad3125_fp.Model.Internet;
import com.example.c0768448_w2020_mad3125_fp.Model.Mobile;
import com.example.c0768448_w2020_mad3125_fp.R;

public class BillTypeDetailsActivity extends AppCompatActivity {
    FragmentManager fm;
    FragmentTransaction ft;
    Bill bill;
    Mobile mob;
    Hydro hydro;
    Internet internet;
    TextView tv1, tv2, tv4, tv5, tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_type_details);
        getSupportActionBar().setTitle("Bill Information");
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        Intent mIntent = getIntent();
        bill = (Bill) mIntent.getSerializableExtra("Bills");

        if (getIntent().getExtras() != null) {
            bill = (Bill) mIntent.getSerializableExtra("Bills");
            if (bill.getBillType().equals(Bill.BillType.Mobile)) {
                mob = (Mobile) mIntent.getSerializableExtra("Bills");
                tv5.setText("Bill ID - " + bill.getBillID());
                tv1.setText("Bill Date - " + bill.getBillDate());
                tv2.setText("Plan Name - " + mob.getPlanName());
                tv6.setText("Manufacturer Name - " + mob.getMobileManufacturerName());
                tv4.setText("Mobile Number - " + mob.getMobileNumber());
            }
            if (bill.getBillType().equals(Bill.BillType.Hydro)) {
                hydro = (Hydro) mIntent.getSerializableExtra("Bills");
                tv5.setText("Bill ID - " + bill.getBillID());
                tv1.setText("Bill Date - " + bill.getBillDate());
                tv2.setText("Bill Type - " + bill.getBillType().toString());
                tv6.setText("Agency Name - " + hydro.getAgencyName());
                tv4.setText("Units Used - " + hydro.getUnitsConsumed());
            }
            if (bill.getBillType().equals(Bill.BillType.Internet)) {
                internet = (Internet) mIntent.getSerializableExtra("Bills");
                tv5.setText("Bill ID - " + bill.getBillID());
                tv1.setText("Bill Date - " + bill.getBillDate());
                tv2.setText("Bill Type - " + bill.getBillType().toString());
                tv6.setText("Internet Provider - " + internet.getInternetProviderName());
                tv4.setText("GB Used - " + internet.getInternetGBUsed().toString());
            }
        }
    }
}
