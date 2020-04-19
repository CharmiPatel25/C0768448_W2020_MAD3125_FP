package com.example.c0768448_w2020_mad3125_fp.UI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c0768448_w2020_mad3125_fp.Model.Bill;
import com.example.c0768448_w2020_mad3125_fp.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mobileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mobileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   /* private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
*/
   Bill bill;
    private TextView txtFragBillId, txtFragBillDate, txtFragDataUsed, txtFragManufac, txtFragPlanName, txtFragMinsUsed, txtFragBillAmount;
    public mobileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mobileFragment.
     */
    // TODO: Rename and change types and number of parameters
  /*  public static mobileFragment newInstance(String param1, String param2) {
        mobileFragment fragment = new mobileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_mobile, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        txtFragBillId = view.findViewById(R.id.txtFragBillId);
        txtFragBillDate = view.findViewById(R.id.txtFragBillDate);
        txtFragDataUsed = view.findViewById(R.id.txtFragDataUsed);
        txtFragManufac = view.findViewById(R.id.txtFragManufac);
        txtFragPlanName = view.findViewById(R.id.txtFragPlanName);
        txtFragMinsUsed = view.findViewById(R.id.txtFragMinsUsed);
        txtFragBillAmount = view.findViewById(R.id.txtBillAmount);

    }
}
