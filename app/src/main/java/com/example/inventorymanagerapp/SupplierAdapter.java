package com.example.inventorymanagerapp;

import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SupplierAdapter extends RecyclerView.Adapter<SupplierAdapter.Itemholder> {
    private List<com.example.inventorymanagerapp.Supplier> suppliers;
    class Itemholder extends RecyclerView.ViewHolder{
        private TextView id;
        private TextView name;
        private ImageView iv;
        public Itemholder(View view){
            super(view);
            id=view.findViewById(R.id.ssid);
            name=view.findViewById(R.id.ssname);
            iv=view.findViewById(R.id.ssdelete);
        }
    }
    @NonNull
    @Override
    public SupplierAdapter.Itemholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.supplier_item,parent,false);
        return new Itemholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SupplierAdapter.Itemholder holder, int position) {
        com.example.inventorymanagerapp.Supplier s=suppliers.get(position);
        holder.name.setText(s.getSname());
        holder.id.setText(holder.id.getText()+String.valueOf(s.getSid()));
    }

    @Override
    public int getItemCount() {
        if(suppliers==null)return 0;
        return suppliers.size();
    }
    public void setList(List<Supplier> s){
        this.suppliers=s;
        notifyDataSetChanged();
    }
}
