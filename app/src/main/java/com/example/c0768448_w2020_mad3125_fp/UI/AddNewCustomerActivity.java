package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.c0768448_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

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

        addDatePicker();
    }

    public String getGender()
    {
        if (rdBMale.isChecked()){
            return "Male";
        }
        else if (rdFemale.isChecked()) {
            return "Female";
        }
        else if(rdOther.isChecked())
        {
            return "Other";
        }
        return null;
    }

    private void addDatePicker() {
        edtTxtBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddNewCustomerActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String date = "";
                month = month + 1;
                if (day < 10) {
                    date = "0" + day + "/" + month + "/" + year;
                } else {
                    date = day + "/" + month + "/" + year;
                }
                edtTxtBirthDate.setText(date);
            }
        };
    }
}
