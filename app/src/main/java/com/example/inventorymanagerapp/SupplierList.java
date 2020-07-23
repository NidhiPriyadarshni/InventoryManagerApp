package com.example.inventorymanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class SupplierList extends AppCompatActivity {

    private RecyclerView rv;
    private SupplierModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_list);
        rv=findViewById(R.id.slist);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        final SupplierAdapter adapter=new SupplierAdapter();
        rv.setAdapter(adapter);
        model=new ViewModelProvider(this).get(SupplierModel.class);
        model.allSupplier().observe(this, new Observer<List<Supplier>>() {
            @Override
            public void onChanged(List<Supplier> suppliers) {
                Supplier s=new Supplier("Default supplier");
                s.setSid(1);
                if(suppliers.isEmpty())suppliers.add(s);
                adapter.setList(suppliers);
            }
        });
    }
}
