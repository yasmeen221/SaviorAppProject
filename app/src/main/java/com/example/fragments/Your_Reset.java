package com.example.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Your_Reset#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Your_Reset extends Fragment {
    TextView FirstName;
    TextView LastName;
    TextView Email;
    TextView Time;
    TextView Date;
    TextView Number;
    TextView RESERVATION;
    TextView phone;
    Button OK,Update,Delete;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Your_Reset() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Your_Reset.
     */
    // TODO: Rename and change types and number of parameters
    public static Your_Reset newInstance(String param1, String param2) {
        Your_Reset fragment = new Your_Reset();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_your__reset, container, false);
        FirstName=v.findViewById(R.id.FIRSTNAME);
        LastName=v.findViewById(R.id.LASTNAME);
        Email=v.findViewById(R.id.EMAIL);
        Time=v.findViewById(R.id.TIME);
        Date=v.findViewById(R.id.DATE);
        Number=v.findViewById(R.id.NUMBER);
        RESERVATION=v.findViewById(R.id.RESERVATION);
        phone=v.findViewById(R.id.PHONE);
        Bundle bundle = this.getArguments();
        String Fname = bundle.getString("First_Name");
        FirstName.setText(Fname);
        String Lname = bundle.getString("Last_Name");
        LastName.setText(Lname);
        String side_view = bundle.getString("Side_View");
        Email.setText(side_view);
        String time = bundle.getString("Time");
        Time.setText(time);
        String date = bundle.getString("Date");
        Date.setText(date);
        String number = bundle.getString("Number");
        Number.setText(number);
        String reservation = bundle.getString("Reservation");
        RESERVATION.setText(reservation);
        String Phone = bundle.getString("Phone");
        phone.setText(Phone);
        OK = v.findViewById(R.id.btn_ok_Search);
        //Update = v.findViewById(R.id.btn_update_search);
        Delete = v.findViewById(R.id.btn_delete_search);
        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),After_Login.class);
                startActivity(intent);
            }
        });
      //  Update.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View view) {
             //   Reservation_Update reservation_update=new Reservation_Update();
             //   FragmentManager fragmentManager = getParentFragmentManager();
             //   FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
             //   fragmentTransaction.replace(R.id.navHostFragment,reservation_update);
             //   fragmentTransaction.commit();
      //      }
        //});
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone=(TextView) v.findViewById(R.id.PHONE);
                int Phone = Integer.parseInt(phone.getText().toString());
                DatabaseSqlite databaseSqlite= new DatabaseSqlite(getContext());
                String Result = databaseSqlite.Delete_Book(Phone );
                Toast.makeText(getContext(), Result, Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}