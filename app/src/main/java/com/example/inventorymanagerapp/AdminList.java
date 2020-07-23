package com.example.inventorymanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class AdminList extends AppCompatActivity {
    private RecyclerView rv;
    private AdminModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_list);
        rv=findViewById(R.id.allist);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        final AdminAdapter adapter=new AdminAdapter();
        adapter.setOnClickListener(new AdminAdapter.onClickListener() {
            @Override
            public void onDeleteClick(Admintable c) {
                model.deleteAdmin(c);
            }
        });
        rv.setAdapter(adapter);
        model=new ViewModelProvider(this).get(AdminModel.class);
        model.allAdmins().observe(this, new Observer<List<Admintable>>() {
            @Override
            public void onChanged(List<Admintable> admintables) {
                if(admintables.isEmpty())admintables.add(new Admintable("Default_usrname","Default_password"));
                adapter.setList(admintables);
            }
        });
    }
}
