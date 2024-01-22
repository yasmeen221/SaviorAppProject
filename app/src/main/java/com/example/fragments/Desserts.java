package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Desserts extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Desserts() {
        // Required empty public constructor
    }

    public static Desserts newInstance(String param1, String param2) {
        Desserts fragment = new Desserts();
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
        View view= inflater.inflate(R.layout.fragment_desserts, container, false);
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main2);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Desserts_class[] Desserts_class = new Desserts_class[]{
                new Desserts_class("Molten Cake","150 $",R.drawable.moltn),
                new Desserts_class("Brawneez","80 $",R.drawable.moltncake),
                new Desserts_class("Cheese Cake","90$",R.drawable.cheesecake),
                new Desserts_class("Donuts","50 $",R.drawable.cokies),
                new Desserts_class("","100 $",R.drawable.moltn),
                new Desserts_class("PINCAKE","35 $",R.drawable.image6),
                new Desserts_class("CHICKEN","140 $",R.drawable.image7),
                new Desserts_class("HAMAM","150 $",R.drawable.image8),
                new Desserts_class("SWEET CEAPE","40 $",R.drawable.image9),
                new Desserts_class("SHRIMP","200 $",R.drawable.image10),
                new Desserts_class("SOUP","50 $",R.drawable.image11),
        };

        Adapter_Desserts myMovieAdapter = new Adapter_Desserts(Desserts_class,Desserts.this);
        recyclerView.setAdapter(myMovieAdapter);

        return view;
    }
}