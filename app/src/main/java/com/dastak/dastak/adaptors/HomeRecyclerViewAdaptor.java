package com.dastak.dastak.adaptors;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dastak.dastak.R;
import com.dastak.dastak.dataModel.HomeDataModel;

import java.util.ArrayList;

public class  HomeRecyclerViewAdaptor extends RecyclerView.Adapter<HomeRecyclerViewAdaptor.ViewHolder> {
        private Context context;
        private  ArrayList<HomeDataModel> dataArray;
        private int[] source;
        private String[] description;
        private onItemClickListener onItemClickListener;
public interface onItemClickListener{
    void onItemClick(int position);
}
public void setOnItemClickListener(onItemClickListener onItemClickListener){
    this.onItemClickListener = onItemClickListener;

}
public HomeRecyclerViewAdaptor(Context context , int[] source, String[] description) {
    this.context = context;
    this.source = source;
    this.description = description;
}

    @NonNull
    @Override
    public HomeRecyclerViewAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custome_home_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerViewAdaptor.ViewHolder holder, int position) {
//        HomeDataModel homeDataModel = dataArray.get(position);
//        holder.description.setText(homeDataModel.getDescription());
//        holder.image.setImageResource(homeDataModel.getImageSource());
        holder.description.setText(description[position]);
        holder.image.setImageResource(source[position]);
        //int width = holder.cardView.getLayoutParams().width;
      //  holder.cardView.setLayoutParams(new LinearLayout.LayoutParams(width, width));
            if(position == 6){
                String sourceString = "<b>" + description[position] + "</b> ";
                holder.description.setText(Html.fromHtml(sourceString));
                holder.description.setTextSize(18);

            }

    }


    @Override
    public int getItemCount() {
        return description.length;
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{

        TextView description;
        ImageView image;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.card_view);
            cardView.setOnClickListener(view ->{
                if(onItemClickListener != null) {


                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {

                        onItemClickListener.onItemClick(position);


                    }
                }



            });
        }
    }
}
