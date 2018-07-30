package com.example.divinkas.testshopapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.divinkas.testshopapp.R;

import java.util.List;

public class TypeRegistrationsAdapter extends RecyclerView.Adapter<TypeRegistrationsAdapter.ViewHolder>{
    private List<String> listTypeRegistr;
    private LayoutInflater inflater;
    private Context context;

    public TypeRegistrationsAdapter(Context context, List<String> lst){
        this.context = context;
        listTypeRegistr = lst;
        inflater = LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_type_registrations, parent, false);
        return new ViewHolder(view);
    }

    @Override
    @SuppressLint("RecyclerView")
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textView.setText(listTypeRegistr.get(position));
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "position: " + position;
                Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
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
