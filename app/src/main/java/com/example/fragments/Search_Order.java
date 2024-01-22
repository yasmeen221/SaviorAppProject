package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Search_Order#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Search_Order extends Fragment {
    TextView FirstName;
    TextView LastName;
    TextView Email;
    TextView Time;
    TextView Date;
    TextView Number;
    TextView RESERVATION;
    TextView phone;
    EditText search;
    Button btn_Search;
    Button Update , Delete ,Ok;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Search_Order() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Search_Order.
     */
    // TODO: Rename and change types and number of parameters
    public static Search_Order newInstance(String param1, String param2) {
        Search_Order fragment = new Search_Order();
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
        View v =inflater.inflate(R.layout.fragment_search__order, container, false);
        FirstName = v.findViewById(R.id.FIRSTNAME_Search);
        LastName=v.findViewById(R.id.LASTNAME_Search);
        Email=v.findViewById(R.id.EMAIL_Search);
        Time=v.findViewById(R.id.TIME_Search);
        Date=v.findViewById(R.id.DATE_Search);
        Number=v.findViewById(R.id.NUMBER_Search);
        RESERVATION=v.findViewById(R.id.RESERVATION_Search);
        phone=v.findViewById(R.id.PHONE_Search);
        search=v.findViewById(R.id.editTextPhone_Search);
        btn_Search = v.findViewById(R.id.btn_search);
        btn_Search.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View view) {
        DatabaseSqlite databaseSqlite=new DatabaseSqlite(getContext());
            ArrayList<String> arrayList = databaseSqlite.get_booking(search.getText().toString());
            if (arrayList==null)
            {
                Toast.makeText(getContext(), "Sorry ,This Order NOT EXISTS", Toast.LENGTH_SHORT).show();
            }
            else
            {
                FirstName.setText(arrayList.get(0));
                LastName.setText(arrayList.get(1));
                Email.setText(arrayList.get(2));
                Number.setText(arrayList.get(3));
                Date.setText(arrayList.get(4));
                Time.setText(arrayList.get(5));
                RESERVATION.setText(arrayList.get(6));
                phone.setText(arrayList.get(7));
            }
        }
     });
        return v;
    }
}