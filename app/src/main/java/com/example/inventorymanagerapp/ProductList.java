package com.example.inventorymanagerapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.List;

public class ProductList extends AppCompatActivity {

    private RecyclerView rv;
    private FloatingActionButton fb;
    private ProductListModel model;
    private int Add_Product=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        fb=findViewById(R.id.pfab);
        rv=findViewById(R.id.pllist);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        model=new ViewModelProvider(this).get(ProductListModel.class);
        final ProductListAdapter adapter=new ProductListAdapter();
        adapter.setOnClickListener(new ProductListAdapter.onClickListener() {
            @Override
            public void onDeleteClick(Product p) {
                model.deleteProduct(p);
            }
        });
        rv.setAdapter(adapter);
        model.getAllProduct().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                if(products.isEmpty())products.add(new Product("1","Default","Default",1,1,"11:01:2030",5));
                adapter.setList(products);
            }
        });
        model.getAllCategory().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(final List<Category> categories) {
                fb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Category c=new Category("Default_Name");
                        c.setCid(1);
                        if(categories.isEmpty())categories.add(c);
                        addProduct(categories);
                    }
                });

            }
        });

    }
    private void addProduct(List<Category> categories){
        Bundle b=new Bundle();
        b.putSerializable("allCategory",(Serializable) categories);
        Intent i=new Intent(this,AddProduct.class);
        i.putExtras(b);
        startActivityForResult(i,Add_Product);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==2){
            String code=data.getStringExtra("code");
            String name=data.getStringExtra("name");
            String category=data.getStringExtra("category");
            int quantity=data.getIntExtra("quantity",0);
            int price=data.getIntExtra("price",0);
            String date=data.getStringExtra("date");
            int discount=data.getIntExtra("discount",0);
            Product p=new Product(code,name,category,quantity,price,date,discount);
            if(code!=null)model.addProduct(p);

        }
    }
}
