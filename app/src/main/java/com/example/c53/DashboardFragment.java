package com.example.c53;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
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

    private ImageButton btn_history;
    private List<Item> dashboardItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_dashboard, container, false);

        CardView cardView1 = view.findViewById(R.id.cardview1);
        CardView cardView2 = view.findViewById(R.id.cardview2);
        CardView cardView3 = view.findViewById(R.id.cardview3);
        CardView cardView4 = view.findViewById(R.id.cardview4);
        CardView cardView5 = view.findViewById(R.id.cardview5);
        CardView cardView6 = view.findViewById(R.id.cardview6);
        CardView cardView7 = view.findViewById(R.id.cardview7);
        CardView cardView8 = view.findViewById(R.id.cardview8);

        dashboardItems = new ArrayList<>();

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for CardView 1
                Intent intent = new Intent(requireContext(), BuyActivity.class);
                intent.putExtra("name", "Black T-Shirt");
                intent.putExtra("image", R.drawable.img_1);
                startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for CardView 2
                Intent intent = new Intent(requireContext(), BuyActivity.class);
                intent.putExtra("name", "Black T-Shirt Oversize");
                intent.putExtra("image", R.drawable.img_2);
                startActivity(intent);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for CardView 3
                Intent intent = new Intent(requireContext(), BuyActivity.class);
                intent.putExtra("name", "White T-Shirt");
                intent.putExtra("image", R.drawable.img_3);
                startActivity(intent);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for CardView 4
                Intent intent = new Intent(requireContext(), BuyActivity.class);
                intent.putExtra("name", "Parka");
                intent.putExtra("image", R.drawable.img_4);
                startActivity(intent);
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for CardView 1
                Intent intent = new Intent(requireContext(), BuyActivity.class);
                intent.putExtra("name", "Chinos");
                intent.putExtra("image", R.drawable.img_5);
                startActivity(intent);
            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for CardView 2
                Intent intent = new Intent(requireContext(), BuyActivity.class);
                intent.putExtra("name", "Black Pants");
                intent.putExtra("image", R.drawable.img_7);
                startActivity(intent);
            }
        });

        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for CardView 3
                Intent intent = new Intent(requireContext(), BuyActivity.class);
                intent.putExtra("name", "Brown Pants");
                intent.putExtra("image", R.drawable.img_6);
                startActivity(intent);
            }
        });

        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for CardView 4
                Intent intent = new Intent(requireContext(), BuyActivity.class);
                intent.putExtra("name", "Brown Chinos");
                intent.putExtra("image", R.drawable.img_8);
                startActivity(intent);
            }
        });

        btn_history = view.findViewById(R.id.btn_history);
        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
