package com.example.inventorymanagerapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Supplier {
    @PrimaryKey(autoGenerate = true)
    private int sid;
    private String sname;

    public Supplier(String sname) {
        this.sname = sname;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }
}
