package com.example.c0768448_w2020_mad3125_fp.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0768448_w2020_mad3125_fp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.example.c0768448_w2020_mad3125_fp.Model.Bill;
import com.example.c0768448_w2020_mad3125_fp.UI.BillTypeDetailsActivity;

public class BillListAdapter extends RecyclerView.Adapter<BillListAdapter.BillsViewHolder> {

    public static ArrayList<Bill> billListArray;

    public BillListAdapter(ArrayList<Bill> billListArray)
    {
        this.billListArray = billListArray;
    }
    @NonNull
    @Override
    public BillListAdapter.BillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bill_item
                        , parent
                        , false);
        BillListAdapter.BillsViewHolder mBillsViewHolder = new BillListAdapter.BillsViewHolder(mView);
        return mBillsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BillListAdapter.BillsViewHolder holder, int position) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Bill b = this.billListArray.get(position);
        String strDate = dateFormat.format(b.getBillDate());
        if(b.getBillType().equals(Bill.BillType.Hydro)) {
            holder.imgBillType.setImageResource(R.drawable.hydro);
        }
        if(b.getBillType().equals(Bill.BillType.Mobile))
        {
            holder.imgBillType.setImageResource(R.drawable.mobile);
        }
        if(b.getBillType().equals(Bill.BillType.Internet)) {
            holder.imgBillType.setImageResource(R.drawable.internet);
        }
        holder.txtBillID.setText("Bill ID : "+b.getBillID());
        holder.txtBillAmount.setText("Bill Amount : "+String.format("$ " + "%,.2f", b.getBillAmount()));
        holder.txtBillDate.setText("Bill Date : "+strDate);
        holder.txtBillType.setText("Bill Type : "+b.getBillType().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Bill billObj = billListArray.get(position);
                Intent mIntent = new Intent(holder.itemView.getContext(), BillTypeDetailsActivity.class);
                mIntent.putExtra("Bills", billObj);
                holder.itemView.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return billListArray.size();
    }

    public class BillsViewHolder extends RecyclerView.ViewHolder {
        TextView txtBillID,txtBillDate,txtBillType,txtBillAmount;
        ImageView imgBillType;
        public BillsViewHolder(@NonNull View itemView) {
            super(itemView);
            txtBillID = itemView.findViewById(R.id.txtBillID);
            txtBillDate = itemView.findViewById(R.id.txtBillDate);
            txtBillType = itemView.findViewById(R.id.txtBillType);
            txtBillAmount = itemView.findViewById(R.id.txtBillAmount);
            imgBillType = itemView.findViewById(R.id.imgBillType);
        }
    }
}
