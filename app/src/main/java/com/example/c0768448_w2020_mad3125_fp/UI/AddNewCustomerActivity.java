package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.c0768448_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddNewCustomerActivity extends AppCompatActivity {
    private TextInputLayout lblCustID, lblFirstName, lblLastName, lblBirthDate, lblEmailID;
    private RadioButton rdBMale, rdFemale, rdOther;
    private TextInputEditText edtTxtCustID, edtTxtFirstName, edtTxtLastName, edtTxtBirthDate,edtTxtEmailID;
    private Button btnAdd, btnClear;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_customer);
        getSupportActionBar().setTitle("Add New Customer");
    }
}
