package com.example.inventorymanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NakeSalesAdapter extends RecyclerView.Adapter<NakeSalesAdapter.Itemholder> {
    private List<Product> products;
    class Itemholder extends RecyclerView.ViewHolder{
        public ImageView add;
        public ImageView minus;

        public TextView name;
        public TextView category;
        public TextView qty;
        public TextView price;
        public TextView discount;
        public ImageView delete;
        public Itemholder(View view){
            super(view);
            add=view.findViewById(R.id.msab);
            minus=view.findViewById(R.id.msabm);

            name=view.findViewById(R.id.piname);
            category=view.findViewById(R.id.picategory);
            qty=view.findViewById(R.id.piquantity);
            price=view.findViewById(R.id.piprice);
            discount=view.findViewById(R.id.pidiscount);
            delete=view.findViewById(R.id.delete);

        }

    }
    @NonNull
    @Override
    public NakeSalesAdapter.Itemholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.make_sales_item,parent,false);
        return new NakeSalesAdapter.Itemholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NakeSalesAdapter.Itemholder holder, int position) {
        Product p=products.get(position);
        holder.name.setText("ProductName: "+p.getPname());
        holder.category.setText("Category: "+p.getPcategory());
        holder.qty.setText("Qty: "+String.valueOf(p.getPquantity()));
        holder.price.setText("Price(Rs): "+String.valueOf(p.getPprice()));
        holder.discount.setText("Discount(%): "+String.valueOf(p.getPdiscount()));


    }

    @Override
    public int getItemCount() {
        if(products==null)return 0;
        return products.size();
    }
    public void setList(List<Product> p){
        products=p;
        notifyDataSetChanged();
    }
}
