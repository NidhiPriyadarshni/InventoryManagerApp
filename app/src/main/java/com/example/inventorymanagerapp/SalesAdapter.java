package com.example.inventorymanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.Itemholder> {
    private List<Sales> sales;

    class Itemholder extends RecyclerView.ViewHolder{


        public TextView id;
        public TextView date;
        public TextView name;
        public TextView phone;
        public TextView amt;
        public Itemholder(View view){
            super(view);
            id=view.findViewById(R.id.sid);
            date=view.findViewById(R.id.sdate);
            name=view.findViewById(R.id.sname);
            phone=view.findViewById(R.id.sphone);
            amt=view.findViewById(R.id.samount);

        }
    }
    @NonNull
    @Override
    public SalesAdapter.Itemholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.sales_item,parent,false);
        return new Itemholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SalesAdapter.Itemholder holder, int position) {
        Sales s=sales.get(position);
        holder.id.setText("Sales id: "+String.valueOf(s.getSalesid()));
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        Date date1=new Date(s.getDate());
        holder.date.setText("Dated: "+dateFormat.format(date1));
        holder.name.setText("Cust. name: "+s.getCustomer());
        holder.phone.setText("Phone no.: "+s.getPhone());
        holder.amt.setText("Toatal amount: "+String.valueOf(s.getAmount()));

    }

    @Override
    public int getItemCount() {
        if(sales==null)return 0;
        return sales.size();
    }
    public void setList(List<Sales> s){
        this.sales=s;
        notifyDataSetChanged();
    }
}
