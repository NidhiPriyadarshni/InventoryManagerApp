package com.example.inventorymanagerapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Salesdao {
    @Insert
    void insertSales(Sales sales);

    @Query("insert into sales(date,customer,phone,amount) values(:l,:s,:ss,:i)")
    long insert(long l,String s,String ss,int i);

    @Query("select * from sales where salesid= :id")
    Sales selectSalesById(int id);

    @Query("select * from sales where date= :datee")
    List<Sales> selectByDate(long datee);

    @Query("select * from sales")
    LiveData<List<Sales>> selectAllSales();

    @Update
    void updateSales(Sales s);
}
