package com.example.inventorymanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Itemholder> {
    private List<Category> categories;
    private onClickListener listener;

    public interface onClickListener{
        void onDeleteClick(Category c);
    }
    class Itemholder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView code;
        public ImageView iv;
        public Itemholder(View view){
            super(view);
            name=view.findViewById(R.id.cname);
            code=view.findViewById(R.id.ccode);
            iv=view.findViewById(R.id.cdelete);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null &&getAdapterPosition()!=RecyclerView.NO_POSITION){
                        listener.onDeleteClick(categories.get(getAdapterPosition()));
                    }
                }
            });
        }

    }

    @NonNull
    @Override
    public CategoryAdapter.Itemholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new Itemholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.Itemholder holder, int position) {

        Category c=categories.get(position);
        holder.code.setText(String.valueOf(c.getCid()));
        holder.name.setText(String.valueOf(c.getCname()));
    }

    @Override
    public int getItemCount() {
        if(categories==null)return 0;
        else return categories.size();
    }
    public void setList(List<Category> c){
        this.categories=c;
        notifyDataSetChanged();
    }

    public void setOnClickListener(onClickListener listener){
        this.listener=listener;
    }
}
