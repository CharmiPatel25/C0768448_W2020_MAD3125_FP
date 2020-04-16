package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.c0768448_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

import Model.Customer;
import Util.DataStorage;

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
                addCustomer();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        addDatePicker();
    }

    private void addCustomer() {
        if(edtTxtCustID.getText().toString().isEmpty() && edtTxtFirstName.getText().toString().isEmpty() && edtTxtLastName.getText().toString().isEmpty() && edtTxtBirthDate.getText().toString().isEmpty()&& edtTxtEmailID.getText().toString().isEmpty()&&rdGender.getCheckedRadioButtonId()==-1)
        {
          rdOther.setError("Please select Gender");

               // Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();

            lblCustID.setError("Please Enter Customer ID");
            lblFirstName.setError("Please Enter First Name");
            lblLastName.setError("Please Enter Last Name");
            lblBirthDate.setError("Please Enter Birth Date");
            lblEmailID.setError("Please Enter Email ID");
        }

        else if (edtTxtCustID.getText().toString().isEmpty())
        {
            edtTxtCustID.setError("Please Enter Customer ID");
        }
        else if(edtTxtFirstName.getText().toString().isEmpty())
        {
            edtTxtFirstName.setError("Please Enter First Name");
        }
        else if (edtTxtLastName.getText().toString().isEmpty())
        {
            edtTxtLastName.setError("Please Enter Last Name");
        }
        else if(edtTxtBirthDate.getText().toString().isEmpty())
        {
            edtTxtBirthDate.setError("Please Enter Birth Date");
        }
        else if(edtTxtEmailID.getText().toString().isEmpty())
        {
            edtTxtEmailID.setError("Please Enter Email ID");
        }
        else
        {
            Customer newCustomer = new Customer(edtTxtCustID.getText().toString(), edtTxtFirstName.getText().toString(), edtTxtLastName.getText().toString(),edtTxtEmailID.getText().toString(), edtTxtBirthDate.getText().toString(),getGender(),R.drawable.user);
            DataStorage.getInstance().addCustomer(newCustomer);
            Intent mIntent = new Intent(AddNewCustomerActivity.this, CustomerListActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("newCustomer", newCustomer);
            mIntent.putExtras(bundle);
            startActivity(mIntent);
        }
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

    public void clearAll()
    {
        edtTxtCustID.getText().clear();
        edtTxtFirstName.getText().clear();
        edtTxtLastName.getText().clear();
        edtTxtBirthDate.getText().clear();
        edtTxtEmailID.getText().clear();
        rdBMale.setChecked(false);
        rdFemale.setChecked(false);
        rdOther.setChecked(false);
    }
}
