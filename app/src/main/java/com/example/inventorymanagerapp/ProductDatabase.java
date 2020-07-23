package com.example.inventorymanagerapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Admintable.class,Category.class,Ownertable.class,Product.class,Sales.class,Supplier.class},version = 1,exportSchema = false)
public abstract class ProductDatabase extends RoomDatabase {
    private static ProductDatabase instance;
    public abstract Admindao admindao();
    public abstract Categorydao categorydao();
    public abstract Ownerdao ownerdao();
    public abstract Productdao productdao();
    public abstract Salesdao salesdao();
    public abstract Supplierdao supplierdao();

    public static  synchronized ProductDatabase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),ProductDatabase.class,"Product_Database").allowMainThreadQueries().build();
        }
        return instance;
    }
}
