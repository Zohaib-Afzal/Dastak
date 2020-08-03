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
import com.dastak.dastak.dataModel.OurAdvisoryBoardDataModel;

public class OurAdvisoryBoard extends Fragment {
    RecyclerView recyclerView;
    AdvisoryBoardRecyclerViewAdaptor advisoryBoardRecyclerViewAdaptor;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_our_advisory_board, container, false);
        recyclerView = root.findViewById(R.id.advisory_board_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        advisoryBoardRecyclerViewAdaptor = new AdvisoryBoardRecyclerViewAdaptor(getActivity(), OurAdvisoryBoardDataModel.name,OurAdvisoryBoardDataModel.designation,OurAdvisoryBoardDataModel.location,OurAdvisoryBoardDataModel.imageSource);
        recyclerView.setAdapter(advisoryBoardRecyclerViewAdaptor);
        return root;
    }

}