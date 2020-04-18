package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;


import com.example.c0768448_w2020_mad3125_fp.Model.Customer;
import com.example.c0768448_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddBillActivity extends AppCompatActivity {
    Spinner spnBillType;
    TextInputLayout edtBillId, edtNumber,edtBillDate,edtDataUsed,edtMinsUsed,edtManufacName,edtPlanName,edtUnitsUsed,edtAgencyName;
    TextInputEditText edtBillIdText,edtNumberText,edtBillDateText,edtDataUsedText,edtMinsUsedText,edtManufacNameText,edtPlanNameText,edtUnitsUsedText,edtAgencyNameText;
    Button btnBillAdd;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Customer customer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);
        getSupportActionBar().setTitle("Add New Bill");
        spnBillType = findViewById(R.id.spnBillType);
        edtBillIdText = findViewById(R.id.edtTxtBillId);
                edtNumberText= findViewById(R.id.edtNumberText);
        edtBillDateText= findViewById(R.id.edtBillDateText);
                edtDataUsedText= findViewById(R.id.edtDataUsedText);
        edtMinsUsedText= findViewById(R.id.edtMinsUsedText);
                edtManufacNameText= findViewById(R.id.edtManufacNameText);
        edtPlanNameText= findViewById(R.id.edtPlanNameText);
                edtUnitsUsedText= findViewById(R.id.edtUnitsUsedText);
        edtAgencyNameText= findViewById(R.id.edtAgencyNameText);


    }
}
