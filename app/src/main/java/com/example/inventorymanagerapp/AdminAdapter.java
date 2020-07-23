package com.example.inventorymanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.Itemholder> {
    private List<Admintable> admins;
    private onClickListener listener;

    public interface onClickListener{
        void onDeleteClick(Admintable c);
    }
    class Itemholder extends RecyclerView.ViewHolder{
        private TextView id;
        private TextView name;
        private ImageView iv;
        public Itemholder(View view){
            super(view);
            id=view.findViewById(R.id.apsw);
            name=view.findViewById(R.id.aname);
            iv=view.findViewById(R.id.adelete);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null &&getAdapterPosition()!=RecyclerView.NO_POSITION){
                        listener.onDeleteClick(admins.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
    @NonNull
    @Override
    public AdminAdapter.Itemholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_item,parent,false);
        return new Itemholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminAdapter.Itemholder holder, int position) {

        Admintable a=admins.get(position);
        holder.name.setText(holder.name.getText()+a.getAusername());
        holder.id.setText(holder.id.getText()+a.getApassword());
    }

    @Override
    public int getItemCount() {
        if(admins==null)return 0;
        return admins.size();
    }
    public void setList(List<Admintable> a){
        this.admins=a;
        notifyDataSetChanged();
    }
    public void setOnClickListener(onClickListener listener){
        this.listener=listener;
    }
}
