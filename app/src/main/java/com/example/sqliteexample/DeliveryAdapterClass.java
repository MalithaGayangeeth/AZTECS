package com.example.sqliteexample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DeliveryAdapterClass extends RecyclerView.Adapter<DeliveryAdapterClass.ViewHolder> {

    List<DeliveryModelClass> employee;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public DeliveryAdapterClass(List<DeliveryModelClass> employee, Context context) {
        this.employee = employee;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.delivery_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final DeliveryModelClass deliveryModelClass = employee.get(position);

        holder.textViewID.setText(Integer.toString(deliveryModelClass.getId()));
        holder.editText_Name.setText(deliveryModelClass.getName());
        holder.editText_Tele.setText(deliveryModelClass.getTele());
        holder.editText_Email.setText(deliveryModelClass.getEmail());
        holder.editText_Address1.setText(deliveryModelClass.getAddress1());
        holder.editText_Address2.setText(deliveryModelClass.getAddress2());
        holder.editText_City.setText(deliveryModelClass.getCity());
        holder.editText_Date.setText(deliveryModelClass.getDate());

        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = holder.editText_Name.getText().toString();
                String stringTele = holder.editText_Tele.getText().toString();
                String stringEmail = holder.editText_Email.getText().toString();
                String stringAddress1 = holder.editText_Address1.getText().toString();
                String stringAddress2 = holder.editText_Address2.getText().toString();
                String stringCity = holder.editText_City.getText().toString();
                String stringDate = holder.editText_Date.getText().toString();


                databaseHelperClass.updateEmployee(new DeliveryModelClass(deliveryModelClass.getId(),stringName,stringTele,stringEmail,stringAddress1,stringAddress2,stringCity,stringDate));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteEmployee(deliveryModelClass.getId());
                employee.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {

        return employee.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_Name;
        EditText editText_Tele;
        EditText editText_Email;
        EditText editText_Address1;
        EditText editText_Address2;
        EditText editText_City;
        EditText editText_Date;
        Button button_Edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_id);
            editText_Name = itemView.findViewById(R.id.edittext_name);
            editText_Tele = itemView.findViewById(R.id.edittext_tele);
            editText_Email = itemView.findViewById(R.id.edittext_email);
            editText_Address1 = itemView.findViewById(R.id.edittext_address1);
            editText_Address2 = itemView.findViewById(R.id.edittext_address2);
            editText_City = itemView.findViewById(R.id.edittext_city);
            editText_Date = itemView.findViewById(R.id.edittext_date);
            button_delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);

        }
    }
}
