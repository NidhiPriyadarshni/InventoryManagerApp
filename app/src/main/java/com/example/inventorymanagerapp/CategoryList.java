package com.example.inventorymanagerapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.inventorymanagerapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class CategoryList extends AppCompatActivity {

    private RecyclerView rv;
    private CategoryModel model;
    private FloatingActionButton ab;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        rv=findViewById(R.id.cllist);
        ab=findViewById(R.id.cfab);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        final CategoryAdapter adapter=new CategoryAdapter();
        adapter.setOnClickListener(new CategoryAdapter.onClickListener() {
            @Override
            public void onDeleteClick(Category c) {
                model.deleteCategory(c);
            }
        });
        rv.setAdapter(adapter);
        model=new ViewModelProvider(this).get(CategoryModel.class);
        model.getAllCategory().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                Category c=new Category("Default_Name");
                c.setCid(1);
                if(categories.isEmpty())categories.add(c);
                adapter.setList(categories);
            }
        });
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCategory();
            }
        });

    }
    private void addCategory(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.add_category,null);
        final EditText name=v.findViewById(R.id.cdname);
        builder.setView(v).setTitle("New Category").setCancelable(true)
                .setNegativeButton("Discard", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String n=name.getText().toString().trim();
                                if(n!=""){
                        String s=model.selectCategoryByName(n);
                        if(s==null)model.addCategory(new Category(n));
                        else{

                        }
                                } else{

                                }
                    }
                });
        builder.create().show();

    }


}
