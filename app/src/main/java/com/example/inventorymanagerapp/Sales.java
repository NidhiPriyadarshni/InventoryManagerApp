package com.example.inventorymanagerapp;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Sales {
    @PrimaryKey(autoGenerate = true)
    private int salesid;
    private long date;
    private String customer;
    private String phone;
    private int amount;




    public Sales( long date, String customer, String  phone, int amount) {

        this.date = date;
        this.customer = customer;
        this.phone = phone;
        this.amount = amount;
    }

    public int getSalesid() {
        return salesid;
    }

    public long getDate() {
        return date;
    }

    public String getCustomer() {
        return customer;
    }

    public String getPhone() {
        return phone;
    }

    public int getAmount() {
        return amount;
    }

    public void setSalesid(int salesid) {
        this.salesid = salesid;
    }
}
