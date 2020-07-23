package com.example.inventorymanagerapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class MakeSalesModel extends AndroidViewModel {
    private ProductRepository repo;
    public MakeSalesModel(Application application){
        super(application);
        repo=new ProductRepository(application);

    }
    public Product selectProductById(int i){
        return repo.selectProductById(i);
    }
    public void updateProduct(Product p){
        repo.updateProduct(p);
    }
    public void updatelist(List<Product> p){repo.updateproductlist(p);}
    public void insertsales(Sales s){repo.insertSales(s);}
    public long inserts(Sales s){return repo.inserts(s);}
}
