package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tapmenu#newInstance} factory method to
 * create an instance of this fragment.
 */

public class tapmenu extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
   Button Reservation;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public tapmenu() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static tapmenu newInstance(String param1, String param2) {
        tapmenu fragment = new tapmenu();
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
        View view= inflater.inflate(R.layout.fragment_tapmenu, container, false);
        super.onCreate(savedInstanceState);
        tabLayout = view.findViewById(R.id.tablayout2);
        viewPager = view.findViewById(R.id.viewpager2);
        tabLayout.setupWithViewPager(viewPager);
        VPAdapter vpAdapter = new VPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addfragment(new Desserts(), "Desserts ");
        vpAdapter.addfragment(new Mokplat(), "Drinkes and Coffee");
        vpAdapter.addfragment(new MenuFragment(), "Meals");
        viewPager.setAdapter(vpAdapter);

        Reservation=view.findViewById(R.id.button_to_reserve);
        Reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reservation reservation = new Reservation();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.navHostFragment,reservation);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}