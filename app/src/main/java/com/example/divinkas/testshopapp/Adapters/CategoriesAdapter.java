package com.example.divinkas.testshopapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.divinkas.testshopapp.Data.ListCategoryTovars;
import com.example.divinkas.testshopapp.R;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder>{

    private List<ListCategoryTovars> categoryTovarsList;
    private Context context;
    private LayoutInflater inflater;

    public CategoriesAdapter(Context context, List<ListCategoryTovars> lst){
        this.context = context;
        categoryTovarsList = lst;
        inflater = LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    @SuppressLint("RecyclerView")
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.tvNameCategory.setText(categoryTovarsList.get(position).getNameCategory());
        holder.imgCategory.setImageResource(categoryTovarsList.get(position).getImageRes());
        holder.containerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pos = "id clicked position: " + categoryTovarsList.get(position).getIdCategory();
                Toast.makeText(context, pos, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() { return categoryTovarsList.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout containerLayout;
        TextView tvNameCategory;
        ImageView imgCategory;

        public ViewHolder(View itemView) {
            super(itemView);
            containerLayout = itemView.findViewById(R.id.itemContainerCategory);
            tvNameCategory = itemView.findViewById(R.id.tvCategoryItemName);
            imgCategory = itemView.findViewById(R.id.imgCategory);
        }
    }
}
