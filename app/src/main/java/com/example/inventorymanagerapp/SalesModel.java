package com.example.inventorymanagerapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


public class SalesModel extends AndroidViewModel {
    private ProductRepository pr;
    private LiveData<List<Sales>> sales;
    public SalesModel(Application application){
        super(application);
        pr=new ProductRepository(application);
        sales=pr.selectAllSales();
    }
    public LiveData<List<Sales>> allSales(){
        return sales;
    }
    public void insertSales(Sales s){pr.insertSales(s);}
}
