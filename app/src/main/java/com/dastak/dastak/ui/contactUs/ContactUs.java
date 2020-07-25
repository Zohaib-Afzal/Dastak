package com.dastak.dastak.ui.contactUs;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.dastak.dastak.R;


public class ContactUs extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact_us, container, false);
         TextView phoneNumber = root.findViewById(R.id.phone_number);
         TextView email = root.findViewById(R.id.email);
         TextView website = root.findViewById(R.id.website);
         phoneNumber.setPaintFlags(phoneNumber.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        email.setPaintFlags(email.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        website.setPaintFlags(website.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        return root;
    }
}