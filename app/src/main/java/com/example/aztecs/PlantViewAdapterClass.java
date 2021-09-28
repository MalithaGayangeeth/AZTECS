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

public class PlantViewAdapterClass extends RecyclerView.Adapter<PlantViewAdapterClass.ViewHolder> {

    List<PlantModelClass> plant;
    Context context;
    DatabaseHelperClass databaseHelperClass;



    public PlantViewAdapterClass(List<PlantModelClass> plant, Context context) {
        this.plant = plant;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.plant_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final PlantModelClass plantModelClass = plant.get(position);

        holder.textViewID.setText(Integer.toString(plantModelClass.getId()));
        holder.imageView5.setImageBitmap(plantModelClass.getImage());
        holder.editText_Name.setText(plantModelClass.getName());
        holder.editText_Quantity.setText(plantModelClass.getQuantity());
        holder.editText_Price.setText(plantModelClass.getPrice());


    }

    @Override
    public int getItemCount() {
        return plant.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView5;
        TextView textViewID;
        TextView editText_Name;
        TextView editText_Quantity;
        TextView editText_Price;
        Button button_adCart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            textViewID = itemView.findViewById(R.id.lbl02);
            imageView5 = itemView.findViewById(R.id.imageView5);
            editText_Name = itemView.findViewById(R.id.lbl002);
            editText_Quantity = itemView.findViewById(R.id.lbl003);
            editText_Price = itemView.findViewById(R.id.lbl004);
            button_adCart = itemView.findViewById(R.id.button_addCart);


        }
    }
}
