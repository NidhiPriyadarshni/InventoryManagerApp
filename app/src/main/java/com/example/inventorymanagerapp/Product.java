package com.example.inventorymanagerapp;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product implements Cloneable {

    @PrimaryKey
    @NonNull
    private String pbarcode;
    private String pname;
    private String pcategory;
    private int pquantity;
    private int pprice;
    private String pexpirydate;
    private int pdiscount;

    public Product(String pbarcode, String pname, String pcategory, int pquantity, int pprice, String pexpirydate, int pdiscount) {
        this.pbarcode = pbarcode;
        this.pname = pname;
        this.pcategory = pcategory;
        this.pquantity = pquantity;
        this.pprice = pprice;
        this.pexpirydate = pexpirydate;
        this.pdiscount = pdiscount;
    }


    public String getPname() {
        return pname;
    }

    public String getPbarcode() {
        return pbarcode;
    }

    public String getPcategory() {
        return pcategory;
    }

    public int getPquantity() {
        return pquantity;
    }

    public int getPprice() {
        return pprice;
    }

    public String getPexpirydate() {
        return pexpirydate;
    }

    public int getPdiscount() {
        return pdiscount;
    }

    public void setPquantity(int pquantity) {
        this.pquantity = pquantity;
    }
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
