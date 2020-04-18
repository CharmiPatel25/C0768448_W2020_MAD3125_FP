package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;


import com.example.c0768448_w2020_mad3125_fp.Model.Customer;
import com.example.c0768448_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class AddBillActivity extends AppCompatActivity {
    Spinner spnBillType;
    TextInputLayout edtBillId, edtNumber, edtBillDate, edtDataUsed, edtMinsUsed, edtManufacName, edtPlanName, edtUnitsUsed, edtAgencyName;
    TextInputEditText edtBillIdText, edtNumberText, edtBillDateText, edtDataUsedText, edtMinsUsedText, edtManufacNameText, edtPlanNameText, edtUnitsUsedText, edtAgencyNameText;
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
        edtNumberText = findViewById(R.id.edtNumberText);
        edtBillDateText = findViewById(R.id.edtBillDateText);
        edtDataUsedText = findViewById(R.id.edtDataUsedText);
        edtMinsUsedText = findViewById(R.id.edtMinsUsedText);
        edtManufacNameText = findViewById(R.id.edtManufacNameText);
        edtPlanNameText = findViewById(R.id.edtPlanNameText);
        edtUnitsUsedText = findViewById(R.id.edtUnitsUsedText);
        edtAgencyNameText = findViewById(R.id.edtAgencyNameText);

        Intent mIntent = getIntent();
        customer2 = mIntent.getParcelableExtra("custBillsAddNew");

        ArrayList<String> billType = new ArrayList<>();
        billType.add("Hydro");
        billType.add("Mobile");
        billType.add("Internet");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, billType);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBillType.setAdapter(dataAdapter);

        spnBillType.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        addingDatePicker();
    }

    private void addingDatePicker() {
        edtBillDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddBillActivity.this,
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
                    date = "0" + day + "-" + month + "-" + year;
                } else {
                    date = day + "-" + month + "-" + year;
                }
                edtBillDateText.setText(date);
            }
        };
    }
}
