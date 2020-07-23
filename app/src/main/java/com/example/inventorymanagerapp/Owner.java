package com.example.inventorymanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Owner extends AppCompatActivity {

    private Button admin;
    private Button supplier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);
        admin=findViewById(R.id.cadmin);
        supplier=findViewById(R.id.csupplier);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdmin();
            }
        });
        supplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSupplier();
            }
        });
    }
    private void openAdmin(){
        Intent i=new Intent(this,AdminList.class);
        startActivity(i);
    }
    private void openSupplier(){
        Intent i=new Intent(this,SupplierList.class);
        startActivity(i);
    }
}
