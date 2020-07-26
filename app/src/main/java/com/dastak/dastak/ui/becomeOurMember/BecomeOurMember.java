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


public class BecomeOurMember extends Fragment {
    RecyclerView recyclerView;
    MembershipRecyclerViewAdaptor membershipRecyclerViewAdaptor;
    String[] cardTitle;
    String[] cardFee;
    String[] cardBenefits;
    int[] imageSource;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_become_our_member, container, false);
        recyclerView = root.findViewById(R.id.membership_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        loadData();
        membershipRecyclerViewAdaptor = new MembershipRecyclerViewAdaptor(getActivity(),cardFee,cardTitle,cardBenefits,imageSource);
        recyclerView.setAdapter(membershipRecyclerViewAdaptor);
        return root;
    }

    private void loadData(){
        cardBenefits = new String[]{". Tshirts, Bag, Yearly Calendar, Newsletter\n" +
                ". 15% discount on selective restaurants in Isb\n" +
                ". Free invites on the events arranged by TGLF.\n" +
                ". Birthday present by TGLF",". Tshirts, Yearly Calendar, Newsletter\n" +
                ". 20% off on the tickets of events by TGLF",". Yealy Calendar, Newsletter\n" +
                ". 20% off on the tickets of events by TGLF"};
        cardTitle = new String[]{"Platinum", "Gold", "Silver"};
        cardFee = new String[]{"Rs. 10,000", "Rs. 5,000", "Rs. 2,000"};
        imageSource = new int[]{R.mipmap.membership_card_platinum, R.mipmap.membership_card_gold, R.mipmap.membership_card_silver};

    }
}