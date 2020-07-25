package com.dastak.dastak.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dastak.dastak.R;

public class AdvisoryBoardRecyclerViewAdaptor extends RecyclerView.Adapter<AdvisoryBoardRecyclerViewAdaptor.ViewHolder> {
        Context context;
    String[] name;
    String[] designation;
    String[] location;
    int[] imageSource;
    public AdvisoryBoardRecyclerViewAdaptor(Context context, String[] name, String[] designation, String[] location, int[] imageSource) {
        this.context = context;
        this.name = name;
        this.designation = designation;
        this.location = location;
        this.imageSource = imageSource;
    }

    @NonNull
    @Override
    public AdvisoryBoardRecyclerViewAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view  = LayoutInflater.from(context).inflate(R.layout.custome_advisory_board_list,parent,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdvisoryBoardRecyclerViewAdaptor.ViewHolder holder, int position) {

        holder.image.setImageResource(imageSource[position]);
        holder.name.setText(name[position]);
        holder.designation.setText(designation[position]);
        holder.location.setText(location[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView designation;
        TextView location;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            designation = itemView.findViewById(R.id.designation);
            location = itemView.findViewById(R.id.location);

        }
    }
}
