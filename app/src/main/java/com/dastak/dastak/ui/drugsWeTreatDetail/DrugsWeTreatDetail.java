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

public class DrugsWeTreatDetail extends Fragment {

    String drugTitle;
    String drugDetail;
    public DrugsWeTreatDetail(String drugTitle,String drugDetail) {
        this.drugDetail = drugDetail;
        this.drugTitle = drugTitle;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_drugs_we_treat_detail,container,false);
        TextView drugsNameTextView = view.findViewById(R.id.drugs_heading);
        TextView drugsDetailTextView = view.findViewById(R.id.drugs_detail);
        drugsDetailTextView.setText(drugDetail);
        drugsNameTextView.setText(drugTitle);
        return view;
    }
}
