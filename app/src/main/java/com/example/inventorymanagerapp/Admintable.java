package com.example.inventorymanagerapp;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Admintable {
    @PrimaryKey
    @NonNull
    private String ausername;
    private String apassword;

    public Admintable(String ausername, String apassword) {
        this.ausername = ausername;
        this.apassword = apassword;
    }

    public String getAusername() {
        return ausername;
    }

    public String getApassword() {
        return apassword;
    }
}
