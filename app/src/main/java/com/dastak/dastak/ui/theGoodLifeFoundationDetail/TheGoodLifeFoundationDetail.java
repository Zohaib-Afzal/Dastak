package com.dastak.dastak.ui.theGoodLifeFoundationDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dastak.dastak.R;

public class TheGoodLifeFoundationDetail extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View  view = inflater.inflate(R.layout.fragment_the_good_life_foundation_detail,container,false);
        TextView heading1Detail1 = view.findViewById(R.id.heading1_detail1);
        TextView heading1Detail2 = view.findViewById(R.id.heading1_detail2);
        TextView heading2Detail = view.findViewById(R.id.heading2_detail);
        TextView heading3Detail = view.findViewById(R.id.heading3_detail);
        TextView heading4Detail = view.findViewById(R.id.heading4_detail);

        onBackPressed();
        String heading1Detail1Value = "The Good Life Foundation is a Non-Profit Organization, committed to working for the betterment of the country’s youth.\n" +
                "The Foundation is working of the uplift of the living standards of the youth and is currently operating\n";
        String heading1Detail2Value = "- Drug Free World-Pakistan\n" +
                "- The Good Life Center\n" +
                "- Behtar Mustaqbil";
        String heading2DetailValue = "Here at TGLF we strive to have a meaningful impact on the transformation of troubled youth by improving their health and wellness with education and prevention and irresponsible use of harmful drugs by treatment and programs to empower them by teaching crucial life skills.";
        String heading3DetailValue = "We envision a Drug free World Pakistan where the underprivileged youth is encouraged to live a healthy life by given sufficient trainings in a safe environment.";
        String heading4DetailValue = "- Hope\n" +
                "\n" +
                "- Purpose\n" +
                "\n" +
                "- Respect\n" +
                "\n" +
                "- Spirituality\n" +
                "\n" +
                "- integrity";
        heading1Detail1.setText(heading1Detail1Value);
        heading1Detail2.setText(heading1Detail2Value);
        heading2Detail.setText(heading2DetailValue);
        heading3Detail.setText(heading3DetailValue);
        heading4Detail.setText(heading4DetailValue);
        return view;
    }

    void onBackPressed(){

    }


}
