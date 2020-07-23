package com.example.inventorymanagerapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductListModel extends AndroidViewModel {
    private ProductRepository repository;
    private LiveData<List<Product>> allProduct;
    private LiveData<List<Category>> allCategory;
    public ProductListModel(Application application){
        super(application);
        repository=new ProductRepository(application);
        allProduct=repository.selectAllProduct();
        allCategory=repository.selectAllCategory();
    }
    public LiveData<List<Product>> getAllProduct(){
        return allProduct;
    }
    public LiveData<List<Category>> getAllCategory(){
        return allCategory;
    }
    public void addProduct(Product p){
        repository.insertProduct(p);
    }
    public void deleteProduct(Product p){
        repository.deleteProduct(p);
    }
}
