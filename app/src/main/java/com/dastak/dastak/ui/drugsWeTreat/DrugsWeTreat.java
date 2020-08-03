package com.dastak.dastak.ui.drugsWeTreat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dastak.dastak.MainActivity;
import com.dastak.dastak.R;
import com.dastak.dastak.adaptors.DrugsWeTreatRecyclerViewAdaptor;
import com.dastak.dastak.dataModel.DrugsWeTreatDataModel;

public class DrugsWeTreat extends Fragment {

    RecyclerView recyclerView;
    DrugsWeTreatRecyclerViewAdaptor drugsWeTreatRecyclerViewAdaptor;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_drugs_we_treat, container, false);
        recyclerView = root.findViewById(R.id.drugs_we_treat_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        drugsWeTreatRecyclerViewAdaptor = new DrugsWeTreatRecyclerViewAdaptor(getActivity(), DrugsWeTreatDataModel.drugName,DrugsWeTreatDataModel.drugDetail);
        clickListener();
        recyclerView.setAdapter(drugsWeTreatRecyclerViewAdaptor);
        return root;
    }
    private void clickListener(){
        drugsWeTreatRecyclerViewAdaptor.setOnItemClickListener(position -> {
            ((MainActivity) requireActivity()).selectedItemFromDrugsWeTreat.setValue(String.valueOf(position));
        });


    }
}