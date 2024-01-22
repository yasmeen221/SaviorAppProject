package com.example.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {
   MyMovieAdapter.RecyclerViewListiener recyclerViewListiener ;
    MyMovieData[] myMovieData;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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
        View view= inflater.inflate(R.layout.fragment_menu, container, false);
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main2);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        setOnClickListener();
        MyMovieData[] myMovieData = new MyMovieData[]{
                new MyMovieData("SHRIMP","150 $",R.drawable.image1),
                new MyMovieData("Burger","80 $",R.drawable.image2),
                new MyMovieData("PIZZA","90$",R.drawable.image3),
                new MyMovieData("GRAPE LEAVES","50 $",R.drawable.image4),
                new MyMovieData("CHICKEN","100 $",R.drawable.image5),
                new MyMovieData("PINCAKE","35 $",R.drawable.image6),
                new MyMovieData("CHICKEN","140 $",R.drawable.image7),
                new MyMovieData("HAMAM","150 $",R.drawable.image8),
                new MyMovieData("SWEET CEAPE","40 $",R.drawable.image9),
                new MyMovieData("SHRIMP","200 $",R.drawable.image10),
                new MyMovieData("SOUP","50 $",R.drawable.image11),
        };

        MyMovieAdapter myMovieAdapter = new MyMovieAdapter(myMovieData,MenuFragment.this);
        recyclerView.setAdapter(myMovieAdapter);

        return view;
    }
    private void setOnClickListener() {
        recyclerViewListiener = new MyMovieAdapter.RecyclerViewListiener() {
            @Override
            public void onClick(View v, int postion) {
                int[] myMovieData = new int[0];
                Toast.makeText(getContext(),myMovieData[postion] , Toast.LENGTH_SHORT).show();
               //  Intent intent = new Intent(getContext(), MedicineProfile.class);
               // intent.putExtra("MedcineInfo", all_meidicine.get(postion));
               // startActivity(intent);

            }
        };
    }

}