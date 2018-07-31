package com.example.divinkas.testshopapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.divinkas.testshopapp.Data.Tovar;

public class TovarItemAdapter {
    Tovar tovar;
    LayoutInflater inflater;
    Context context;

    public TovarItemAdapter(Context context, Tovar tovar){
        this.context = context;
        this.tovar = tovar;
        inflater = LayoutInflater.from(context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgTovavr;
        TextView name, desc, price, model, tvModel, kod, vurobnuk, upk;
        LinearLayout myLike;
        LinearLayout bask;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
