package com.dastak.dastak.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dastak.dastak.R;

public class DrugsWeTreatRecyclerViewAdaptor extends RecyclerView.Adapter<DrugsWeTreatRecyclerViewAdaptor.ViewHolder> {
    Context context;
    String[] drugName;
    String[] drugDetail;
    private onItemClickListener onItemClickListener;

    public interface onItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(onItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;

    }

    public DrugsWeTreatRecyclerViewAdaptor(Context context, String[] drugName, String[] drugDetail) {

        this.context = context;
        this.drugDetail = drugDetail;
        this.drugName = drugName;
    }

    @NonNull
    @Override
    public DrugsWeTreatRecyclerViewAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(context).inflate(R.layout.custome_drugs_we_treat_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrugsWeTreatRecyclerViewAdaptor.ViewHolder holder, int position) {
        int realPosition = position+1;
        if((position)<9) {
            holder.drugNameTextView.setText("0".concat(String.valueOf(realPosition)).concat(". ".concat(drugName[position])));
        } else{
            holder.drugNameTextView.setText(String.valueOf(realPosition).concat(". ".concat(drugName[position])));
        }
        holder.drugDetailTextView.setText(drugDetail[position]);


    }

    @Override
    public int getItemCount() {
        return drugName.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView drugNameTextView;
        TextView drugDetailTextView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            drugDetailTextView = itemView.findViewById(R.id.drug_detail);
            drugNameTextView = itemView.findViewById(R.id.drug_name);
            cardView = itemView.findViewById(R.id.drugs_we_treat_card_view);
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

