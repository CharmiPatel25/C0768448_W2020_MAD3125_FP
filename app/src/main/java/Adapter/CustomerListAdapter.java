package Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0768448_w2020_mad3125_fp.R;
import com.example.c0768448_w2020_mad3125_fp.UI.ShowBillsActivity;

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
        Customer mCustomer = this.custList.get(position);
        holder.txtFullName.setText(mCustomer.getFirstName());
        holder.txtCustID.setText(mCustomer.getCustId());
        holder.txtEmail.setText(mCustomer.getEmailID());
        holder.txtDob.setText(mCustomer.getDateOfBirth());
        holder.txtGender.setText(mCustomer.getGender());
        holder.imgUser.setImageResource(mCustomer.getCustIcon());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Customer customer = custList.get(position);
                Intent mIntent = new Intent(holder.itemView.getContext(), ShowBillsActivity.class);
                mIntent.putExtra("CustomerBills", customer);
                holder.itemView.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.custList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {
        TextView  txtFullName, txtCustID,txtEmail,txtDob,txtGender;
        ImageView imgUser;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtFullName = itemView.findViewById(R.id.txtFullName);
            this.txtCustID = itemView.findViewById(R.id.txtCustID);
            this.txtEmail = itemView.findViewById(R.id.txtCustEmail);
            this.txtGender = itemView.findViewById(R.id.txtCustGender);
            this.txtDob = itemView.findViewById(R.id.txt_customer_dob);
            this.imgUser = itemView.findViewById(R.id.imgUser);
        }
    }
}

