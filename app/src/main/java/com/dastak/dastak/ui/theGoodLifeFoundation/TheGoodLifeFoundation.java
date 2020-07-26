package com.dastak.dastak.ui.theGoodLifeFoundation;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dastak.dastak.MainActivity;
import com.dastak.dastak.R;
import com.dastak.dastak.adaptors.HomeRecyclerViewAdaptor;

import java.util.Objects;


public class TheGoodLifeFoundation extends Fragment {
    RecyclerView recyclerView;
    HomeRecyclerViewAdaptor homeRecyclerViewAdaptor;
   // ArrayList<HomeDataModel> dataArray = new ArrayList<>(8);
    String[] description = new String[8];
    int[] imageSource = new int[8];
    Button drawerButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_the_good_life_foundation, container, false);
        recyclerView = view.findViewById(R.id.home_recycler_view);
        drawerButton = view.findViewById(R.id.burger_icon);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        loadData();
    //    homeRecyclerViewAdaptor = new HomeRecyclerViewAdaptor(getActivity(),dataArray);
        homeRecyclerViewAdaptor = new HomeRecyclerViewAdaptor(getActivity(),imageSource,description);
        clickListener();
        recyclerView.setAdapter(homeRecyclerViewAdaptor);

        return view;
    }

    private void loadData(){

            description = new String[]{"The Good Life \n Foundation","Drugs \n Information","Drugs We \n Treat",
                    "Director \n Message","Our Advisory \n Board","Become Our \n Member","SOS","Seeking Help "};

            imageSource = new int[]{R.mipmap.logo_green,R.mipmap.no_drugs,R.mipmap.drugs_we_treat,
                    R.mipmap.message,R.mipmap.advisory, R.mipmap.membership,R.mipmap.icon_feather_phone_call_green,
                    R.mipmap.group};
        //    HomeDataModel homeDataModel = new HomeDataModel();
         //   homeDataModel.setDescription("Description");
            //homeDataModel.setImageSource(R.drawable.ic_launcher_foreground);
         //   dataArray.set(0,homeDataModel);


    }

    private void clickListener(){
        drawerButton.setOnClickListener(view ->{
            //changing the value of a local variable in main activity to trigger same response as the drawer click in main activity
                ((MainActivity) requireActivity()).didClickDrawerButton.setValue("true");
        });

        homeRecyclerViewAdaptor.setOnItemClickListener(position -> {
            ((MainActivity) requireActivity()).selectedItemFromHome.setValue(String.valueOf(position));

        });


    }



}