package com.example.inventorymanagerapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Ownerdao {
    @Insert
    void insertOwner(Ownertable owner);

    @Delete
    void deleteOwner(Ownertable owner);

    @Query("select * from ownertable where ousername= :id")
    Ownertable selectOwnerById(String id);

    @Query("select * from ownertable")
    LiveData<List<Ownertable>> selectAllOwner();

    @Query("select count(*) from ownertable where ousername= :id")
    int selectOwnerCountById(String id);

    @Query("select count(*) from ownertable where ousername= :u and opassword=:p")
    int checkOwner(String u,String p);

}
