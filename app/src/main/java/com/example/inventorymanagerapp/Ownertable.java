package com.example.inventorymanagerapp;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ownertable {
    @PrimaryKey
    @NonNull
    private String ousername;
    private String opassword;

    public String getOusername() {
        return ousername;
    }

    public String getOpassword() {
        return opassword;
    }

    public Ownertable(String ousername, String opassword) {
        this.ousername = ousername;
        this.opassword = opassword;
    }


}
