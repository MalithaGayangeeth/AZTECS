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

public class PlantAdapterClass extends RecyclerView.Adapter<PlantAdapterClass.ViewHolder> {

    List<PlantModelClass> plant;
    Context context;
    DatabaseHelperClass databaseHelperClass;



    public PlantAdapterClass(List<PlantModelClass> plant, Context context) {
        this.plant = plant;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.plant_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final PlantModelClass plantModelClass = plant.get(position);

        holder.textViewID.setText(Integer.toString(plantModelClass.getId()));
        holder.imageView1.setImageBitmap(plantModelClass.getImage());
        holder.editText_Name.setText(plantModelClass.getName());
        holder.editText_Quantity.setText(plantModelClass.getQuantity());
        holder.editText_Price.setText(plantModelClass.getPrice());

        //Edit item details when clicking edit button
        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String stringName = holder.editText_Name.getText().toString();
                String stringQuantity = holder.editText_Quantity.getText().toString();
                String stringPrice = holder.editText_Price.getText().toString();


                int z= databaseHelperClass.updatePlant(new PlantModelClass(plantModelClass.getId(),stringName,stringQuantity,stringPrice));
                notifyDataSetChanged();

                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
                if(!(z==0)){
                    Toast.makeText(context,"Successfully Edited!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context,"Not Edited!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int y = databaseHelperClass.deletePlant(plantModelClass.getId());
                plant.remove(position);
                notifyDataSetChanged();
                if(!(y==0)){
                    Toast.makeText(context,"Successfully Deleted!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context,"Not Deleted!!", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return plant.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView1;
        TextView textViewID;
        EditText editText_Name;
        EditText editText_Quantity;
        EditText editText_Price;
        Button button_Edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            textViewID = itemView.findViewById(R.id.text_id);
            imageView1 = itemView.findViewById(R.id.imageView1);
            editText_Name = itemView.findViewById(R.id.edittext_name);
            editText_Quantity = itemView.findViewById(R.id.edittext_quantity);
            editText_Price = itemView.findViewById(R.id.edittext_price);
            button_delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);

        }
    }
}
