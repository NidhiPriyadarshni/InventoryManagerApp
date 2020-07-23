package com.example.inventorymanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class User extends AppCompatActivity {
    private Button product;
    private Button category;
    private Button stock;
    private Button expired;
    private Button sales;
    private Button salesreturn;
    private Button makesales;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        product=findViewById(R.id.uproduct);
        category=findViewById(R.id.ucategory);
        stock=findViewById(R.id.ustock);
        expired=findViewById(R.id.uexpired);
        sales=findViewById(R.id.usales);
        makesales=findViewById(R.id.umakesales);
        salesreturn=findViewById(R.id.usalesreturn);

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProduct();
            }
        });
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCategory();
            }
        });
        sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSales();
            }
        });
        makesales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buy();
            }
        });
    }
    private void openProduct(){
        Intent i=new Intent(User.this,ProductList.class);
        startActivity(i);
    }
    private void openCategory(){
        Intent i=new Intent(User.this,CategoryList.class);
        startActivity(i);
    }
    private void openSales(){
        Intent i=new Intent(User.this,SalesList.class);
        startActivity(i);
    }
    private void buy(){

        Intent i=new Intent(User.this,MakeSales.class);
        startActivity(i);
    }
}
