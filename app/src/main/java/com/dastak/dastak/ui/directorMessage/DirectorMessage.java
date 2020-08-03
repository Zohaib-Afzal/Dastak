package com.dastak.dastak.ui.directorMessage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.dastak.dastak.R;
import com.dastak.dastak.dataModel.DirectorsMessageDataModel;

public class DirectorMessage extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_director_message, container, false);
        final TextView mainText = root.findViewById(R.id.main_text_director_message);
        mainText.setText(DirectorsMessageDataModel.mainTextValue);
        return root;
    }
}