package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.c0768448_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddNewCustomerActivity extends AppCompatActivity {
    private TextInputLayout lblCustID, lblFirstName, lblLastName, lblBirthDate, lblEmailID;
    private RadioButton rdBMale, rdFemale, rdOther;
    private RadioGroup rdGender;
    private TextInputEditText edtTxtCustID, edtTxtFirstName, edtTxtLastName, edtTxtBirthDate,edtTxtEmailID;
    private Button btnAdd, btnClear;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_customer);
        getSupportActionBar().setTitle("Add New Customer");
        lblCustID = findViewById(R.id.lblCustId);
        lblFirstName = findViewById(R.id.lblFirstName);
        lblLastName = findViewById(R.id.lblLastName);
        lblBirthDate = findViewById(R.id.lblBirthDate);
        lblEmailID = findViewById(R.id.lblEmailID);
        edtTxtCustID = findViewById(R.id.edtTxtCustID);
        edtTxtFirstName = findViewById(R.id.edtTxtFirstName);
        edtTxtLastName = findViewById(R.id.edtTxtLastName);
        edtTxtBirthDate = findViewById(R.id.edtTxtBirthDate);
        edtTxtEmailID = findViewById(R.id.edtTxtEmailID);
        rdBMale = findViewById(R.id.rdMale);
        rdFemale = findViewById(R.id.rdFemale);
        rdOther = findViewById(R.id.rdOther);
        rdGender = findViewById(R.id.rdGender);
        btnAdd = findViewById(R.id.btnAddCustomer);
        btnClear = findViewById(R.id.btnClear);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
