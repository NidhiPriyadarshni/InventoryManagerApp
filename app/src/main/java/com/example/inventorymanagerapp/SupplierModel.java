package com.example.inventorymanagerapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class SupplierModel extends AndroidViewModel {
    private LiveData<List<Supplier>> allSupplier;
    private ProductRepository pr;
    public SupplierModel(Application application){
        super(application);
        pr=new ProductRepository(application);
        allSupplier=pr.selectAllSupplier();
    }
    public LiveData<List<Supplier>> allSupplier(){
        return allSupplier;
    }
}
