package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.c0768448_w2020_mad3125_fp.Model.Bill;
import com.example.c0768448_w2020_mad3125_fp.Model.Customer;
import com.example.c0768448_w2020_mad3125_fp.Model.Hydro;
import com.example.c0768448_w2020_mad3125_fp.Model.Internet;
import com.example.c0768448_w2020_mad3125_fp.Model.Mobile;
import com.example.c0768448_w2020_mad3125_fp.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AddBillActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
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
        edtBillId = findViewById(R.id.lblBillId);
        edtNumber= findViewById(R.id.edtNumber);
        edtBillDate= findViewById(R.id.edtBillDate);
        edtDataUsed  = findViewById(R.id.edtDataUsed);
        edtMinsUsed= findViewById(R.id.edtMinsUsed);
        edtManufacName= findViewById(R.id.edtManufacName);
        edtPlanName= findViewById(R.id.edtPlanName);
        edtUnitsUsed= findViewById(R.id.edtUnitsUsed);
        edtAgencyName= findViewById(R.id.edtAgencyName);
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
        btnBillAdd= findViewById(R.id.btnAddBill);
        Intent mIntent = getIntent();
        customer2 = mIntent.getParcelableExtra("custBillsAddNew");

        ArrayList<String> billType = new ArrayList<>();
        billType.add("MOBILE");
        billType.add("HYDRO");
        billType.add("INTERNET");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, billType);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBillType.setAdapter(dataAdapter);

        spnBillType.setOnItemSelectedListener(this);

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
                    date = "0" + day + "/" + month + "/" + year;
                } else {
                    date = day + "/" + month + "/" + year;
                }
                edtBillDateText.setText(date);
            }
        };
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0)
        {
            showFields();
            clearData();
            edtUnitsUsed.setVisibility(View.INVISIBLE);
            edtAgencyName.setVisibility(View.INVISIBLE);
            btnBillAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean someFlag = false;
                    if(edtBillIdText.getText().toString().isEmpty())
                    {
                        edtBillIdText.setError("Please enter the bill ID");
                        someFlag = true;
                        return;
                    }
                    if(edtBillDateText.getText().toString().isEmpty()){
                        edtBillDateText.setError("Please enter your the bill text");
                        someFlag = true;
                        return;
                    }
                    if(edtNumberText.getText().toString().isEmpty())
                    {
                        edtNumberText.setError("Please enter your phone number");
                        someFlag = true;
                        return;
                    }
                    if(edtDataUsedText.getText().toString().isEmpty())
                    {
                        edtDataUsedText.setError("Please enter the data used");
                        someFlag = true;
                        return;
                    }
                    if(edtMinsUsedText.getText().toString().isEmpty())
                    {
                        edtMinsUsedText.setError("Please enter the mins used");
                        someFlag = true;
                        return;
                    }
                    if(edtManufacNameText.getText().toString().isEmpty())
                    {
                        edtManufacNameText.setError("Please enter the Manufacturer Name");
                        someFlag = true;
                        return;
                    }
                    if(edtPlanNameText.getText().toString().isEmpty())
                    {
                        edtPlanNameText.setError("Please enter your plan name");
                        someFlag = true;
                        return;
                    }
                    String numb = edtNumberText.getText().toString();
                    if(numb.length()<10)
                    {
                        edtNumberText.setError("Invalid Phone number");
                        new MaterialAlertDialogBuilder(AddBillActivity.this)
                                .setTitle("Invalid phone number")
                                .setMessage("Please enter valid phone number")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                        someFlag = true;
                        return;
                    }
                    SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
                    Date billDate = null;
                    try {
                         billDate=sf.parse(edtBillDateText.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (!someFlag)
                    {
                        Mobile mObj = new Mobile(edtBillIdText.getText().toString(),
                                billDate,
                                Bill.BillType.Mobile,
                                edtManufacNameText.getText().toString(),
                                edtPlanNameText.getText().toString(),
                                edtNumberText.getText().toString(),
                                Integer.parseInt(edtDataUsedText.getText().toString()),
                                Integer.parseInt(edtMinsUsedText.getText().toString()));
                        customer2.getBills().put(mObj.getBillID(), mObj);
                        Intent mIntent = new Intent(AddBillActivity.this, ShowBillsActivity.class);
                        mIntent.putExtra("customerKey", customer2);
                        startActivity(mIntent);
                    }
                }
            });
        }

        if(position == 1)
        {
            hidefields();
            clearData();
            edtUnitsUsed.setVisibility(View.VISIBLE);
            edtAgencyName.setVisibility(View.VISIBLE);
            edtAgencyName.setHint("Enter Agency Name");
            edtUnitsUsed.setHint("Enter Units Consumed");
            btnBillAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean someFlag = false;
                    if(edtBillIdText.getText().toString().isEmpty())
                    {
                        edtBillIdText.setError("Please enter the bill ID");
                        someFlag = true;
                        return;
                    }
                    if(edtBillDateText.getText().toString().isEmpty()){
                        edtBillDateText.setError("Please enter your the bill text");
                        someFlag = true;
                        return;
                    }
                    if(edtAgencyNameText.getText().toString().isEmpty())
                    {
                        edtNumberText.setError("Please enter the agency name");
                        someFlag = true;
                        return;
                    }
                    if(edtUnitsUsedText.getText().toString().isEmpty())
                    {
                        edtDataUsedText.setError("Please enter the units used");
                        someFlag = true;
                        return;
                    }
                    if(!edtBillIdText.getText().toString().contains("HD"))
                    {
                        new MaterialAlertDialogBuilder(AddBillActivity.this)
                                .setTitle("Invalid bill ID")
                                .setMessage("Hydro bill IDs must contain HD")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                        someFlag = true;
                        return;
                    }
                    SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
                    Date billDate = null;
                    try {
                        billDate=sf.parse(edtBillDateText.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if(!someFlag) {
                        Hydro hObj = new Hydro(edtBillIdText.getText().toString(),
                                billDate,
                                Bill.BillType.Hydro,
                                edtAgencyNameText.getText().toString(),
                                Integer.parseInt(edtUnitsUsedText.getText().toString()));
                        customer2.getBills().put(hObj.getBillID(), hObj);
                        Intent mIntent = new Intent(AddBillActivity.this, ShowBillsActivity.class);
                        mIntent.putExtra("customerKey", customer2);
                        startActivity(mIntent);
                    }
                }
            });
        }

        if(position == 2)
        {
            hidefields();
            clearData();
            edtUnitsUsed.setVisibility(View.VISIBLE);
            edtAgencyName.setVisibility(View.VISIBLE);
            edtAgencyName.setHint("Enter provider name");
            edtUnitsUsed.setHint("Enter data used");
            btnBillAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean someFlag = false;
                    if(edtBillIdText.getText().toString().isEmpty())
                    {
                        edtBillIdText.setError("Please enter the bill ID");
                        someFlag = true;
                        return;
                    }
                    if(edtBillDateText.getText().toString().isEmpty()){
                        edtBillDateText.setError("Please enter your the bill text");
                        someFlag = true;
                        return;
                    }
                    if(edtAgencyNameText.getText().toString().isEmpty())
                    {
                        edtNumberText.setError("Please enter the provider");
                        someFlag = true;
                        return;
                    }
                    if(edtUnitsUsedText.getText().toString().isEmpty())
                    {
                        edtDataUsedText.setError("Please enter the data used");
                        someFlag = true;
                        return;
                    }
                    if(!edtBillIdText.getText().toString().contains("IN"))
                    {
                        new MaterialAlertDialogBuilder(AddBillActivity.this)
                                .setTitle("Invalid bill ID")
                                .setMessage("Internet bill IDs must contain IN")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                        someFlag = true;
                        return;
                    }
                    SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
                    Date billDate = null;
                    try {
                        billDate=sf.parse(edtBillDateText.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Internet iObj = new Internet(edtBillIdText.getText().toString(),
                            billDate,
                            Bill.BillType.Internet,
                            edtAgencyNameText.getText().toString(),
                            Double.parseDouble(edtUnitsUsedText.getText().toString()));
                    customer2.getBills().put(iObj.getBillID(),iObj);
                    Intent mIntent = new Intent(AddBillActivity.this, ShowBillsActivity.class);
                    mIntent.putExtra("customerKey", customer2);
                    startActivity(mIntent);
                }
            });
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void showFields()
    {
        edtMinsUsed.setVisibility(View.VISIBLE);
        edtNumber.setVisibility(View.VISIBLE);
        edtDataUsed.setVisibility(View.VISIBLE);
        edtMinsUsed.setVisibility(View.VISIBLE);
        edtPlanName.setVisibility(View.VISIBLE);
        edtManufacName.setVisibility(View.VISIBLE);
    }
    public void hidefields()
    {
        edtMinsUsed.setVisibility(View.INVISIBLE);
        edtNumber.setVisibility(View.INVISIBLE);
        edtDataUsed.setVisibility(View.INVISIBLE);
        edtMinsUsed.setVisibility(View.INVISIBLE);
        edtPlanName.setVisibility(View.INVISIBLE);
        edtManufacName.setVisibility(View.INVISIBLE);
    }

    public void clearData()
    {
        edtNumberText.getText().clear();
        edtDataUsedText.getText().clear();
        edtMinsUsedText.getText().clear();
        edtPlanNameText.getText().clear();
        edtManufacNameText.getText().clear();
        edtBillDateText.getText().clear();
        edtBillIdText.getText().clear();
        edtAgencyNameText.getText().clear();
        edtDataUsedText.getText().clear();
        edtUnitsUsedText.getText().clear();
    }
}
