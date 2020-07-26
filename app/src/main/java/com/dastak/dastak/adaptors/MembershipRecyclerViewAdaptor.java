package com.dastak.dastak.adaptors;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dastak.dastak.R;

public class MembershipRecyclerViewAdaptor extends RecyclerView.Adapter<MembershipRecyclerViewAdaptor.ViewHolder> {
    Context context;
    String[] cardTitle;
    String[] cardFee;
    String[] cardBenefits;
    int[] imageSource;
    public MembershipRecyclerViewAdaptor(Context context, String[] cardFee, String[] cardTitle, String[] cardBenefits, int[] imageSource ) {
        this.context = context;
        this.cardBenefits = cardBenefits;
        this.cardFee = cardFee;
        this.cardTitle = cardTitle;
        this.imageSource = imageSource;
    }

    @NonNull
    @Override
    public MembershipRecyclerViewAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custome_membership_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MembershipRecyclerViewAdaptor.ViewHolder holder, int position) {

        holder.cardFee.setText(cardFee[position]);
        holder.cardFee.setPaintFlags(holder.cardFee.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        holder.cardImage.setImageResource(imageSource[position]);
        holder.cardTitle.setText(cardTitle[position]);
        holder.cardBenefits.setText(cardBenefits[position]);

    }

    @Override
    public int getItemCount() {
        return cardTitle.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        TextView cardTitle;
        TextView cardFee;
        TextView cardBenefits;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardImage = itemView.findViewById(R.id.image_card);
            cardTitle = itemView.findViewById(R.id.title_card);
            cardFee = itemView.findViewById(R.id.fee_card);
            cardBenefits = itemView.findViewById(R.id.detail_benefits);


        }
    }
}
