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
public abstract class Admindao {
    @Insert
    public abstract void insertAdmin(Admintable admin);

    @Query("select * from admintable where ausername= :id")
    public abstract Admintable selectAdminById(String id);

    @Query("select count(*) from admintable where ausername= :id")
    public abstract int selectAdminCountById(String id);

    @Query("select count(ausername) from admintable where ausername = :u and apassword = :p ")
    public abstract int checkAdmin(String u, String p);

    @Query("select * from admintable")
    public abstract LiveData<List<Admintable>> selectAllAdmin();

    @Delete
    public abstract void deleteAdmin(Admintable a);

    @Update
    public abstract void updateAdmin(Admintable a);

   /* @Transaction
    public void act(){

    }*/
}
