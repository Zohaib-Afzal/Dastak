package com.dastak.dastak.ui.drugsWeTreatDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dastak.dastak.MainActivity;
import com.dastak.dastak.R;
import com.dastak.dastak.dataModel.DrugsWeTreatDetailDataModel;

public class DrugsWeTreatDetail extends Fragment {

    int position;
    public DrugsWeTreatDetail(int position) {
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_drugs_we_treat_detail,container,false);
        TextView drugsNameTextView = view.findViewById(R.id.drugs_heading);
        TextView drugsDetailTextView = view.findViewById(R.id.drugs_detail);
        drugsDetailTextView.setText(DrugsWeTreatDetailDataModel.drugsDetail[position]);
        drugsNameTextView.setText(DrugsWeTreatDetailDataModel.drugsTitle[position]);
        return view;
    }
}
