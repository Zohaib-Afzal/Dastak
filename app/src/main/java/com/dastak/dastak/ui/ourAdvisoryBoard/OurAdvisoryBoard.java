package com.dastak.dastak.ui.ourAdvisoryBoard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dastak.dastak.R;
import com.dastak.dastak.adaptors.AdvisoryBoardRecyclerViewAdaptor;
import com.dastak.dastak.adaptors.HomeRecyclerViewAdaptor;

public class OurAdvisoryBoard extends Fragment {
    RecyclerView recyclerView;
    AdvisoryBoardRecyclerViewAdaptor advisoryBoardRecyclerViewAdaptor;
    String[] name = new String[4];
    String[] designation = new String[4];
    String[] location = new String[4];
    int[] imageSource = new int[4];


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_our_advisory_board, container, false);
        recyclerView = root.findViewById(R.id.advisory_board_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        loadData();
        advisoryBoardRecyclerViewAdaptor = new AdvisoryBoardRecyclerViewAdaptor(getActivity(),name,designation,location,imageSource);
        recyclerView.setAdapter(advisoryBoardRecyclerViewAdaptor);
        return root;
    }

    private void loadData(){
        name = new String[]{"Mr. Kamran Rizvi", "Mr. Mujtaba Hussain", "Nawaz Mahmood", "Syed Saud Ahmed"};
        designation = new String[]{"CEO", "Head of Operations Pakistan", "Senior Director Human Resources", "Head of Human Resources"};
        location = new String[]{"Carnelian", "Evercare Group", "Caesars Bluewaters Dubai", "Eighteen"};
        imageSource = new int[]{R.mipmap.image_ceo,R.mipmap.image_head_of_operations_pakistan,R.mipmap.image_senior_director_human_resources,R.mipmap.image_head_of_human_resources};

    }
}