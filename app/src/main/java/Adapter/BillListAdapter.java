package Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BillListAdapter extends RecyclerView.Adapter<BillListAdapter.BillsViewHolder> {
    @NonNull
    @Override
    public BillListAdapter.BillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BillListAdapter.BillsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BillsViewHolder extends RecyclerView.ViewHolder {
        public BillsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
