package com.dastak.dastak.ui.becomeOurMember;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dastak.dastak.R;
import com.dastak.dastak.adaptors.MembershipRecyclerViewAdaptor;
import com.dastak.dastak.dataModel.BecomeOurMemberDataModel;


public class BecomeOurMember extends Fragment {
    RecyclerView recyclerView;
    MembershipRecyclerViewAdaptor membershipRecyclerViewAdaptor;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_become_our_member, container, false);
        recyclerView = root.findViewById(R.id.membership_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        membershipRecyclerViewAdaptor = new MembershipRecyclerViewAdaptor(getActivity(), BecomeOurMemberDataModel.cardFee,BecomeOurMemberDataModel.cardTitle,BecomeOurMemberDataModel.cardBenefits,BecomeOurMemberDataModel.imageSource);
        recyclerView.setAdapter(membershipRecyclerViewAdaptor);
        return root;
    }
}