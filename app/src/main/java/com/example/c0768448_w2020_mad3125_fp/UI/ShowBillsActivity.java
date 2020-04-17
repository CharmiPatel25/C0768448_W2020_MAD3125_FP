package com.example.c0768448_w2020_mad3125_fp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.c0768448_w2020_mad3125_fp.R;

import java.util.ArrayList;

public class ShowBillsActivity extends AppCompatActivity {
    private RecyclerView rvBillsList;
    private ArrayList billsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bills);
        getSupportActionBar().setTitle("Bill Details");
    }
}
