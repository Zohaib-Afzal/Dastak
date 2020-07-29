package com.dastak.dastak.ui.drugsWeTreat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dastak.dastak.MainActivity;
import com.dastak.dastak.R;
import com.dastak.dastak.adaptors.DrugsWeTreatRecyclerViewAdaptor;

public class DrugsWeTreat extends Fragment {

    RecyclerView recyclerView;
    DrugsWeTreatRecyclerViewAdaptor drugsWeTreatRecyclerViewAdaptor;
    String[] drugName;
    String[] drugDetail;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_drugs_we_treat, container, false);
        recyclerView = root.findViewById(R.id.drugs_we_treat_recycler_view);
        recyclerView.setHasFixedSize(true);
        loadRecyclerViewData();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        drugsWeTreatRecyclerViewAdaptor = new DrugsWeTreatRecyclerViewAdaptor(getActivity(),drugName,drugDetail);
        clickListener();

        recyclerView.setAdapter(drugsWeTreatRecyclerViewAdaptor);
        return root;
    }
    private void loadRecyclerViewData(){
        drugName = new String[]{"Crystal Meth","Cocaine","LSD","Heroine","Synthetic Drug","Inhalants","Marijuana","Alcohol","Ecstasy","Ritalin","Painkiller","Prescription Drug Abuse","Crack Cacaine"};
        drugDetail = new String[]{"Crystal meth is short for crystal methamphetamine. It is just one form of the dilig methamphetamine...",
                               "The word cocaine refers to the drug in a powder form or crystal form. The powder is usually mixed with substances...",
                                "LSD is one of the most potent, mood-changing chemicals. It is manufactured from lysergic acid, which is found...",
                                "Heroin is a highly addictive, illegal drug. It is used by millions of addicts around the world who are unable to overcome...",
                                "Synthetic drugs are created using man-made chemicals rather than natural ingredients. A designer drug is a...",
                                "Inhalants refer to the vapors from toxic substances that are inhaled to reach a quick high. Of more than I ,000...",
                                "Marijuana is one of the most abused drugs in the world. There are over 400 chemicals in marijuana and hashish...",
                                "Alcohol is a drug. It is classed as a depressant, meaning that it slows down vital functions—resulting in slurred...",
                                "Tragically, Ecstasy is one of the most popular drugs among youth today. The UN Office on Drugs and Crime...",
                                "Ritalin is the common name for methylphenidate. It is abused by teens for their stimulant effects. Even when...",
                                "Among teens, prescription drugs are the most commonly used drugs next to marijuana, and almost half of the...",
                                "Many teens think prescription drugs are safe because they were prescribed by a doctor. But taking them for...",
                                "Cocaine is the crystal form of cocaine. Which normally comes in a powder form. It comes in solid blocks or cystals...",
                               };

    }
    private void clickListener(){

        drugsWeTreatRecyclerViewAdaptor.setOnItemClickListener(position -> {
            ((MainActivity) requireActivity()).selectedItemFromDrugsWeTreat.setValue(String.valueOf(position));


        });


    }
}