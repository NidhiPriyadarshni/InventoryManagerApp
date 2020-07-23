package com.example.inventorymanagerapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;


@Dao
public abstract class Productdao {
    @Insert
    public abstract void insertProduct(Product product);

    @Query("select * from product where pbarcode= :code")
    public abstract Product checkCode(String code);

    @Update
    public abstract void updateProduct(Product product);

    @Query("select * from product")
    public abstract LiveData<List<Product>> selectAllProduct();

    @Delete
    public abstract void deleteProduct(Product product);

    @Query("select * from product where pbarcode= :id")
    public abstract Product selectProductById(int id);

    @Transaction
    public void updatelist(List<Product> pp){
        for(Product p:pp)updateProduct(p);
    }
}
