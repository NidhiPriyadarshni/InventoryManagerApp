package com.example.inventorymanagerapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Categorydao {
    @Insert
    void insertCategory(Category c);

    @Query("select * from category")
    LiveData<List<Category>> selectAllCategory();

    @Delete
    void deleteCategory(Category c);

    @Query("select cname from category where cname= :name")
    String selectByName(String name);
}
