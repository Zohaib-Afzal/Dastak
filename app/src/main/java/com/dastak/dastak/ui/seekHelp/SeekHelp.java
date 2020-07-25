package com.dastak.dastak.ui.seekHelp;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.dastak.dastak.R;

public class SeekHelp extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_seek_help, container, false);
         TextView consultant1PhoneNumber = root.findViewById(R.id.consultant_1_phone_number);
        consultant1PhoneNumber.setPaintFlags(consultant1PhoneNumber.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
         TextView consultant2PhoneNumber = root.findViewById(R.id.consultant_2_phone_number);
        consultant2PhoneNumber.setPaintFlags(consultant2PhoneNumber.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        return root;
    }
}