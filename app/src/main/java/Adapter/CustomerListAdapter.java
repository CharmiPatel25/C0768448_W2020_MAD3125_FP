package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0768448_w2020_mad3125_fp.R;

import java.util.ArrayList;

import Model.Customer;

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.CustomerViewHolder> {

    ArrayList<Customer> custList;
    public CustomerListAdapter(ArrayList<Customer> custArrayList) {
        this.custList = custArrayList;
}
    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_item, parent, false);
        CustomerViewHolder mCustomerViewHolder = new CustomerViewHolder(mView);
        return mCustomerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.custList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {
        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

