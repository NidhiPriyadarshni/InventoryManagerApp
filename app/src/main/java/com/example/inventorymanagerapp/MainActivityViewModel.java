package com.example.inventorymanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private ProductRepository repository;
    private int acount;
    private int ocount;
    private Admintable admin;
    private Ownertable owner;
    private LiveData<List<Admintable>> allAdmin;
    private LiveData<List<Ownertable>> allOwner;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository=new ProductRepository(application);
        allAdmin=repository.selectAllAdmin();
        allOwner=repository.selectAllOwner();
    }



    public LiveData<List<Admintable>> selectAllAdmin(){return allAdmin;}
    public LiveData<List<Ownertable>> selectAllOwner(){return allOwner;}
    public int getAcount(String s){
       return repository.selectAdminCountById(s);
   }

   public int getOcount(String s){
       return repository.selectOwnerCountById(s);
   }

   public void addAdmin(String u,String p){
       admin=new Admintable(u,p);
       repository.insertAdmin(admin);
   }

   public void addOwner(String u,String p){
       owner=new Ownertable(u,p);
       repository.insertOwner(owner);
   }

   public int checkAdmin(String u, String p){
        return repository.checkAdmin(u,p);
   }

    public int checkOwner(String u,String p){

        return repository.checkOwner(u,p);
    }
}
