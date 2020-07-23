package com.example.inventorymanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

public class SalesList extends AppCompatActivity {

    private SalesModel model;
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_list);
        rv=findViewById(R.id.sllist);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        final SalesAdapter adapter=new SalesAdapter();
        rv.setAdapter(adapter);
        model=new ViewModelProvider(this).get(SalesModel.class);
        model.allSales().observe(this, new Observer<List<Sales>>() {
            @Override
            public void onChanged(List<Sales> sales) {
                Sales s=new Sales(new Date().getTime(),"Riya","+91 6200846942",11);
                s.setSalesid(1);
                if(sales.isEmpty())sales.add(s);
                adapter.setList(sales);
                Toast.makeText(SalesList.this,sales.size()+" items in sales history",Toast.LENGTH_LONG).show();
            }
        });
    }
}
