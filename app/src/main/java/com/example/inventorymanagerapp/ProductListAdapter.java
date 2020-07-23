package com.example.inventorymanagerapp;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.Itemholder> {

    private List<Product> productList;
    private onClickListener listener;

    public interface onClickListener{
        void onDeleteClick(Product p);
    }

    class Itemholder extends RecyclerView.ViewHolder{
        public TextView code;
        public TextView name;
        public TextView category;
        public TextView quantity;
        public TextView price;
        public TextView discount;
        public TextView date;
        public ImageView image;


        public Itemholder(View view){
            super(view);
            code=view.findViewById(R.id.picode);
            name=view.findViewById(R.id.piname);
            category=view.findViewById(R.id.picategory);
            quantity=view.findViewById(R.id.piquantity);
            price=view.findViewById(R.id.piprice);
            discount= view.findViewById(R.id.pidiscount);
            date= view.findViewById(R.id.piexpirydate);
            image=view.findViewById(R.id.delete);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     if(listener!=null &&getAdapterPosition()!=RecyclerView.NO_POSITION){
                         listener.onDeleteClick(productList.get(getAdapterPosition()));
                     }
                }
            });
        }
    }

    @NonNull
    @Override
    public Itemholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_product_item,parent,false);
        return new Itemholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Itemholder holder, int position) {
        Product p=productList.get(position);
        holder.code.setText(p.getPbarcode());
        holder.name.setText(p.getPname());
        holder.category.setText(p.getPcategory());
        holder.quantity.setText("Qty: "+String.valueOf(p.getPquantity()));
        holder.price.setText("Price: "+String.valueOf(p.getPprice()));
        holder.discount.setText("Discount %: "+String.valueOf(p.getPdiscount()));
        holder.date.setText("Valid till "+p.getPexpirydate());

    }

    @Override
    public int getItemCount() {
        if(productList==null)return 0;
        return productList.size();
    }

    public void setList(List<Product> p){
        this.productList=p;
        notifyDataSetChanged();
    }

    public void setOnClickListener(onClickListener listener){
        this.listener=listener;
    }


}
