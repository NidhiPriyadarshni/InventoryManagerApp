package com.example.inventorymanagerapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CategoryModel extends AndroidViewModel {
    private LiveData<List<Category>> allCategory;
    private ProductRepository pr;
    public CategoryModel(Application application){
        super(application);
        pr=new ProductRepository(application);
        allCategory=pr.selectAllCategory();

    }

    public LiveData<List<Category>> getAllCategory() {
        return allCategory;
    }
    public String selectCategoryByName(String name){
        return pr.selectCategoryByName(name);
    }
    public void addCategory(Category c){
        pr.insertCategory(c);
    }
    public void deleteCategory(Category c){pr.deleteCategory(c);}
}
