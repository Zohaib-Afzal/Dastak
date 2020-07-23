package com.dastak.dastak.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dastak.dastak.R;
import com.dastak.dastak.adaptors.HomeRecyclerViewAdaptor;


public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    HomeRecyclerViewAdaptor homeRecyclerViewAdaptor;
   // ArrayList<HomeDataModel> dataArray = new ArrayList<>(8);
    String[] description = new String[8];
    int[] imageSource = new int[8];
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.home_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        loadData();
    //    homeRecyclerViewAdaptor = new HomeRecyclerViewAdaptor(getActivity(),dataArray);
        homeRecyclerViewAdaptor = new HomeRecyclerViewAdaptor(getActivity(),imageSource,description);
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
}