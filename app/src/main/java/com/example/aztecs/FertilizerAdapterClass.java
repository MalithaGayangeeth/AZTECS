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

public class FertilizerAdapterClass extends RecyclerView.Adapter<FertilizerAdapterClass.ViewHolder> {

    List<FertilizerModelClass> fertilizer;
    Context context;
    DatabaseHelperClass databaseHelperClass;



    public FertilizerAdapterClass(List<FertilizerModelClass> fertilizer, Context context) {
        this.fertilizer = fertilizer;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fertilizer_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final FertilizerModelClass fertilizerModelClass = fertilizer.get(position);

        holder.textViewID2.setText(Integer.toString(fertilizerModelClass.getId()));
        holder.imageView2.setImageBitmap(fertilizerModelClass.getImage());
        holder.editText_Name2.setText(fertilizerModelClass.getName());
        holder.editText_Quantity2.setText(fertilizerModelClass.getQuantity());
        holder.editText_Price2.setText(fertilizerModelClass.getPrice());

        //Edit item details when clicking edit button
        holder.button_Edit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String stringName = holder.editText_Name2.getText().toString();
                String stringQuantity = holder.editText_Quantity2.getText().toString();
                String stringPrice = holder.editText_Price2.getText().toString();


                int z2= databaseHelperClass.updateFertilizer(new FertilizerModelClass(fertilizerModelClass.getId(),stringName,stringQuantity,stringPrice));
                notifyDataSetChanged();

                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
                if(!(z2==0)){
                    Toast.makeText(context,"Successfully Edited!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context,"Not Edited!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        holder.button_delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int y2 = databaseHelperClass.deletePlant(fertilizerModelClass.getId());
                fertilizer.remove(position);
                notifyDataSetChanged();
                if(!(y2==0)){
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
        return fertilizer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView2;
        TextView textViewID2;
        EditText editText_Name2;
        EditText editText_Quantity2;
        EditText editText_Price2;
        Button button_Edit2;
        Button button_delete2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            textViewID2 = itemView.findViewById(R.id.text_id2);
            imageView2 = itemView.findViewById(R.id.imageView2);
            editText_Name2 = itemView.findViewById(R.id.edittext_name2);
            editText_Quantity2 = itemView.findViewById(R.id.edittext_quantity2);
            editText_Price2 = itemView.findViewById(R.id.edittext_price2);
            button_delete2 = itemView.findViewById(R.id.button_delete2);
            button_Edit2 = itemView.findViewById(R.id.button_edit2);

        }
    }
}
