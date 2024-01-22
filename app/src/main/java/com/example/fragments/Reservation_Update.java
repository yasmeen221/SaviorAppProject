package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Reservation_Update#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Reservation_Update extends Fragment {
    EditText Firstname ,Lastname ,Email,Phone;
    Spinner Number, Date,Time,Reservation;
    Button UPDATE , Reset;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Reservation_Update() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Reservation_Update.
     */
    // TODO: Rename and change types and number of parameters
    public static Reservation_Update newInstance(String param1, String param2) {
        Reservation_Update fragment = new Reservation_Update();
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
        View view= inflater.inflate(R.layout.fragment_reservation, container, false);
        DatabaseSqlite databaseSqlite = new DatabaseSqlite(this.getContext());
        Firstname=view.findViewById(R.id.Fname);
        Lastname = view.findViewById(R.id.Lname);
        Email = view.findViewById( R.id.email);
        Phone = view.findViewById(R.id.phone);
        Number = view.findViewById(R.id.number);
        Date = view.findViewById(R.id.date);
        Time = view.findViewById(R.id.time);
        Reservation = view.findViewById(R.id.reservation);
        UPDATE = view.findViewById(R.id.update);
        UPDATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = Firstname.getText().toString();
                String lname = Lastname.getText().toString();
                String email = Email.getText().toString();
                int phone = Integer.parseInt(Phone.getText().toString());
                int number= Integer.parseInt(Number.getSelectedItem().toString());
                String date = Date.getSelectedItem().toString();
                String time = Time.getSelectedItem().toString();
                String reservation = Reservation.getSelectedItem().toString();
                String Result= databaseSqlite.Update_Book(fname,lname,email,number,date,time,reservation,phone);
                if (Result.equalsIgnoreCase("Faild Update"))
                {
                    Toast.makeText(getActivity(),Result, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), Result, Toast.LENGTH_SHORT).show();
                }
            }
        });
        Reset = view.findViewById(R.id.reset);
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = Firstname.getText().toString();
                String lname = Lastname.getText().toString();
                String email = Email.getText().toString();
                int phone = Integer.parseInt(Phone.getText().toString());
                int number= Integer.parseInt(Number.getSelectedItem().toString());
                String date = Date.getSelectedItem().toString();
                String time = Time.getSelectedItem().toString();
                String reservation = Reservation.getSelectedItem().toString();
                Bundle bundle = new Bundle();
                bundle.putString("First_Name",fname);
                bundle.putString("Last_Name",lname);
                bundle.putString("Email",email);
                bundle.putString("Phone", String.valueOf(phone));
                bundle.putString("Number", String.valueOf(number));
                bundle.putString("Date",date);
                bundle.putString("Time",time);
                bundle.putString("Reservation",reservation);
                Your_Reset your_reset=new Your_Reset();
                your_reset.setArguments(bundle);
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.navHostFragment,your_reset);
                fragmentTransaction.commit();
            }
        });




                return view;
    }
}