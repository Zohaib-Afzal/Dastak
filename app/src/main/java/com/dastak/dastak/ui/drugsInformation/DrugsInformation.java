package com.dastak.dastak.ui.drugsInformation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.dastak.dastak.R;
import com.dastak.dastak.dataModel.DrugsInformationDataModel;

public class DrugsInformation extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_drugs_information, container, false);
         TextView mainTextView = root.findViewById(R.id.main_text_drugs_info);
         TextView facilitiesTextView = root.findViewById(R.id.facilities);
        TextView benefitsOfRehabTextView = root.findViewById(R.id.benefits_of_rehab);
        mainTextView.setText(DrugsInformationDataModel.mainTextValue);
        facilitiesTextView.setText(DrugsInformationDataModel.facilitiesTextValue);
        benefitsOfRehabTextView.setText(DrugsInformationDataModel.benefitsOfRehabValue);

        return root;
    }
}