package com.example.aztecs;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FertilizerViewAdapterClass extends RecyclerView.Adapter<FertilizerViewAdapterClass.ViewHolder> {

    List<FertilizerModelClass> fertilizer;
    Context context;
    DatabaseHelperClass databaseHelperClass;



    public FertilizerViewAdapterClass(List<FertilizerModelClass> fertilizer, Context context) {
        this.fertilizer = fertilizer;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fertilizer_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final FertilizerModelClass fertilizerModelClass = fertilizer.get(position);

        holder.textViewID.setText(Integer.toString(fertilizerModelClass.getId()));
        holder.imageView6.setImageBitmap(fertilizerModelClass.getImage());
        holder.editText_Name.setText(fertilizerModelClass.getName());
        holder.editText_Quantity.setText(fertilizerModelClass.getQuantity());
        holder.editText_Price.setText(fertilizerModelClass.getPrice());


    }

    @Override
    public int getItemCount() {
        return fertilizer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView6;
        TextView textViewID;
        TextView editText_Name;
        TextView editText_Quantity;
        TextView editText_Price;
        Button button_adCart2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            textViewID = itemView.findViewById(R.id.lbl0002);
            imageView6 = itemView.findViewById(R.id.imageView6);
            editText_Name = itemView.findViewById(R.id.lbl0003);
            editText_Quantity = itemView.findViewById(R.id.lbl0004);
            editText_Price = itemView.findViewById(R.id.lbl0005);
            button_adCart2 = itemView.findViewById(R.id.button_addCart2);


        }
    }
}
