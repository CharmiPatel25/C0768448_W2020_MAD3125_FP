package com.example.c0768448_w2020_mad3125_fp.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.c0768448_w2020_mad3125_fp.Model.Bill;
import com.example.c0768448_w2020_mad3125_fp.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HydroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HydroFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    Bill bill;

    public HydroFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HydroFragment.
     */
    // TODO: Rename and change types and number of parameters
  /*  public static HydroFragment newInstance(String param1, String param2) {
        HydroFragment fragment = new HydroFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    } */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_hydro, container, false);
        Bundle bundle = new Bundle();
        try
        {
            bill = (Bill) bundle.getSerializable("hydroBill");
        }
        catch (NullPointerException e)
        {
            Toast.makeText(getActivity(), "Hydro Bill not generated", Toast.LENGTH_SHORT).show();
        }
        return inflater.inflate(R.layout.fragment_hydro, container, false);
    }
}