package com.example.fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.VideoView;

import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView whatsappV,FaceV,instV,Twitv;
    Button btn_restable,btnlocation , Menue , search;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        super.onCreate(savedInstanceState);
        VideoView simpleVideoView = (VideoView) view.findViewById(R.id.video_view);
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.ree;
        Uri uri = Uri.parse(path);
        simpleVideoView.setVideoURI(uri);
        simpleVideoView.start();

        tabLayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);
        VPAdapter vpAdapter = new VPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addfragment(new Fragment1(), "Right side ");
        vpAdapter.addfragment(new Fragment2(), "Middle side ");
        vpAdapter.addfragment(new Fragment3(), "left side ");
        viewPager.setAdapter(vpAdapter);
        btnlocation=view.findViewById(R.id.btn_location);
        btnlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:30.470288, 30.937239?q="+Uri.parse("30.470288, 30.937239"));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        Menue=view.findViewById(R.id.btn_menu);
        Menue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapmenu tapmenu =new tapmenu();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.navHostFragment,tapmenu);
                fragmentTransaction.commit();
            }
        });
        search = view.findViewById(R.id.button_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Search_Order search_order = new Search_Order();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.navHostFragment,search_order);
                fragmentTransaction.commit();
;            }
        });

        return view;
    }

    private void openLink(String applink, String apppackage, String weblink) {
        try {
            Uri uri = Uri.parse(applink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setPackage(apppackage);
            intent.setFlags((Intent.FLAG_ACTIVITY_NEW_TASK));
            startActivity(intent);
        }
        catch (ActivityNotFoundException activityNotFoundException){
            Uri uri=Uri.parse(weblink);
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setPackage(apppackage);
            intent.setFlags((Intent.FLAG_ACTIVITY_NEW_TASK));
            startActivity(intent);
        }
    }

}