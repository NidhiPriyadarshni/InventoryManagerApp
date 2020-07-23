package com.example.inventorymanagerapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Supplierdao {
    @Insert
    void insertSupplier(Supplier supplier);

    @Query("select * from supplier")
    LiveData<List<Supplier>> selectAllSupplier();

    @Delete
    void deleteSupplier(Supplier s);
}
