package com.example.divinkas.testshopapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.divinkas.testshopapp.Data.Tovar;
import com.example.divinkas.testshopapp.R;
import com.example.divinkas.testshopapp.TovarItemActivity;

import java.util.List;

public class TovarAdapter  extends RecyclerView.Adapter<TovarAdapter.Viewholder>{
    Context context;
    LayoutInflater inflater;
    List<Tovar> tovarList;

    public TovarAdapter(Context context, List<Tovar> lst){
        this.context = context;
        tovarList = lst;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_listtovar, parent, false);
        return new Viewholder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, @SuppressLint("RecyclerView") final int position) {
        if (tovarList.get(position).isSale()){
            holder.sale.setVisibility(View.VISIBLE);
        }
        if(tovarList.get(position).isOldPrice()){
            holder.oldPrice.setText(tovarList.get(position).getOldPriceTovar() + "EUR");
            holder.oldPrice.setPaintFlags(holder.oldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.oldPrice.setVisibility(View.VISIBLE);
        }
        holder.imgTov.setImageResource(tovarList.get(position).getImageTovar());
        holder.price.setText(tovarList.get(position).getPriceTovar() + "EUR");
        holder.nameTov.setText("\t" + tovarList.get(position).getNameTovar());

        //add listeners
        holder.toBask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "add to Baskt tov id: " + tovarList.get(position).getIdTovar();
                        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
            }
        });
        holder.myLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "add to my like tov id: " + tovarList.get(position).getIdTovar();
                Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
            }
        });

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open tovar activity and set extras id tov
                int id_tov = tovarList.get(position).getIdTovar();
                Toast.makeText(context, "tov id: " + id_tov, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, TovarItemActivity.class);
                intent.putExtra("id", id_tov);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return tovarList.size(); }

    public static class Viewholder extends RecyclerView.ViewHolder{
        ImageView sale;
        RelativeLayout container;
        ImageView myLike, toBask;
        ImageView imgTov;
        TextView nameTov;
        TextView oldPrice;
        TextView price;

        public Viewholder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.tovarItemContainer);
            sale = itemView.findViewById(R.id.imgv_Sale);
            myLike = itemView.findViewById(R.id.addInMyLike);
            toBask = itemView.findViewById(R.id.addInBask);
            nameTov = itemView.findViewById(R.id.tvTovarName);
            oldPrice = itemView.findViewById(R.id.tv_oldPriceTov);
            price = itemView.findViewById(R.id.tv_priceTov);
            imgTov = itemView.findViewById(R.id.imgvTovar);
        }
    }
}
