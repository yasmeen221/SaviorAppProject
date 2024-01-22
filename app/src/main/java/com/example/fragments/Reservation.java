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
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Reservation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Reservation extends Fragment {
    EditText Firstname ,Lastname ,Email,Phone;
    Spinner Number, Date,Time,Reservation;
    Button Book , Reset;
    RadioButton Right_view , Left_view , middle_view;
    String View_side;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Reservation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Reservation.
     */
    // TODO: Rename and change types and number of parameters
    public static Reservation newInstance(String param1, String param2) {
        Reservation fragment = new Reservation();
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
        Right_view=view.findViewById(R.id.radioButton_right);
        Left_view=view.findViewById(R.id.radioButton_left);
        middle_view=view.findViewById(R.id.radioButton_middle);
        Book = view.findViewById(R.id.update);
        Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = Firstname.getText().toString();
                String lname = Lastname.getText().toString();
                if ( Right_view.isChecked())
                {
                    View_side = Right_view.getText().toString();
                }
                else if (Left_view.isChecked())
                {
                    View_side = Left_view.getText().toString();
                }
                else if (middle_view.isChecked())
                {
                    View_side = middle_view.getText().toString();
                }
                //int phone = Integer.parseInt(Phone.getText().toString());
               // int number= Integer.parseInt(Number.getSelectedItem().toString());
                String date = Date.getSelectedItem().toString();
                String time = Time.getSelectedItem().toString();
                String reservation = Reservation.getSelectedItem().toString();
                if (fname.equalsIgnoreCase("")||
                        lname.equalsIgnoreCase("")||
                        date.equalsIgnoreCase("")||
                        time.equalsIgnoreCase("")||
                        Phone.getText().toString().equalsIgnoreCase("")||
                        Number.getSelectedItem().toString().equalsIgnoreCase("")||
                        reservation.equalsIgnoreCase(""))
                {
                    Toast.makeText(Reservation.getContext(),"Please write all fields ", Toast.LENGTH_SHORT).show();
                }
                else {
                    String Result = databaseSqlite.book(fname
                            ,lname
                            ,View_side
                            ,Integer.parseInt(Number.getSelectedItem().toString())
                                    ,date
                                    ,time
                                    ,reservation
                                    ,Integer.parseInt(Number.getSelectedItem().toString()));
                    Toast.makeText(Reservation.getContext(),Result, Toast.LENGTH_SHORT).show();
                }
            }
        });
        Reset = view.findViewById(R.id.reset);
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = Firstname.getText().toString();
                String lname = Lastname.getText().toString();
                int phone = Integer.parseInt(Phone.getText().toString());
                int number= Integer.parseInt(Number.getSelectedItem().toString());
                String date = Date.getSelectedItem().toString();
                String time = Time.getSelectedItem().toString();
                String reservation = Reservation.getSelectedItem().toString();
                Bundle bundle = new Bundle();
                bundle.putString("First_Name",fname);
                bundle.putString("Last_Name",lname);
                bundle.putString("Side_View",View_side);
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