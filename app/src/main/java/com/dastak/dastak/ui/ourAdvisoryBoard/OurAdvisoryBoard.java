package com.dastak.dastak.ui.ourAdvisoryBoard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.dastak.dastak.R;

public class OurAdvisoryBoard extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_our_advisory_board, container, false);
        final TextView textView = root.findViewById(R.id.text_send);
        return root;
    }
}