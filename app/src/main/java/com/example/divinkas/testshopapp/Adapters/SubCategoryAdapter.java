package com.example.divinkas.testshopapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.divinkas.testshopapp.CatalogTovarsActivity;
import com.example.divinkas.testshopapp.Data.SubCategory;
import com.example.divinkas.testshopapp.R;

import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.ViewHolder> {
    private List<SubCategory> listTypeRegistr;
    private LayoutInflater inflater;
    private Context context;

    public SubCategoryAdapter(Context context, List<SubCategory> lst){
        this.context = context;
        listTypeRegistr = lst;
        inflater = LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public SubCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_type_registrations, parent, false);
        return new SubCategoryAdapter.ViewHolder(view);
    }

    @Override
    @SuppressLint("RecyclerView")
    public void onBindViewHolder(@NonNull SubCategoryAdapter.ViewHolder holder, final int position) {
        holder.textView.setText(listTypeRegistr.get(position).getNameSubCategory());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "go to tovar: " + listTypeRegistr.get(position).getIdCategory();
                Toast.makeText(context, s, Toast.LENGTH_SHORT).show();

                Intent intent =  new Intent(context, CatalogTovarsActivity.class);
                intent.putExtra("id", listTypeRegistr.get(position).getIdCategory());
                intent.putExtra("title", listTypeRegistr.get(position).getNameSubCategory());
                context.startActivity(intent);
            }
        });
        //holder.container.click.animate();
    }

    @Override
    public int getItemCount() { return listTypeRegistr.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        LinearLayout container;

        public ViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.containerLL_item_reg);
            textView = itemView.findViewById(R.id.tvTypeRegName);
        }
    }
}
