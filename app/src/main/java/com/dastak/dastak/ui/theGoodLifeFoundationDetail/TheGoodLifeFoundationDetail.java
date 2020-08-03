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
import com.dastak.dastak.dataModel.TheGoodLifeFoundationDetailDataModel;

public class TheGoodLifeFoundationDetail extends Fragment {
    TextView heading1Detail1;
    TextView heading1Detail2;
    TextView heading2Detail;
    TextView heading3Detail;
    TextView heading4Detail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View  view = inflater.inflate(R.layout.fragment_the_good_life_foundation_detail,container,false);
        findViews(view);
        setText();
        return view;
    }
    private void findViews(View  view) {
         heading1Detail1 = view.findViewById(R.id.heading1_detail1);
         heading1Detail2 = view.findViewById(R.id.heading1_detail2);
         heading2Detail = view.findViewById(R.id.heading2_detail);
         heading3Detail = view.findViewById(R.id.heading3_detail);
         heading4Detail = view.findViewById(R.id.heading4_detail);

    }
    private void setText(){
        heading1Detail1.setText(TheGoodLifeFoundationDetailDataModel.heading1Detail1Value);
        heading1Detail2.setText(TheGoodLifeFoundationDetailDataModel.heading1Detail2Value);
        heading2Detail.setText(TheGoodLifeFoundationDetailDataModel.heading2DetailValue);
        heading3Detail.setText(TheGoodLifeFoundationDetailDataModel.heading3DetailValue);
        heading4Detail.setText(TheGoodLifeFoundationDetailDataModel.heading4DetailValue);
    }


}
