package com.example.inventorymanagerapp;

import android.app.Application;
import java.util.List;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class AdminModel extends AndroidViewModel {
    private LiveData<List<Admintable>> admins;
    private ProductRepository pr;
    public AdminModel(Application application){
        super(application);
        pr=new ProductRepository(application);
        admins=pr.selectAllAdmin();
    }
    public LiveData<List<Admintable>> allAdmins(){
        return admins;
    }
    public void deleteAdmin(Admintable a){pr.deleteAdmin(a);}
}
