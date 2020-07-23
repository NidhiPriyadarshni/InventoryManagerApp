package com.example.inventorymanagerapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MakeSales extends AppCompatActivity {
    private RecyclerView rv;
    private FloatingActionButton ab;
    private TextView amt;
    private NakeSalesAdapter adapter;
    private float amount=0;
    private Button pay;
    private Button dis;
    private MakeSalesModel model;
    private List<Product> productList;
    private List<Product> productList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_sales);
        model=new ViewModelProvider(this).get(MakeSalesModel.class);
        productList=new ArrayList<Product>();
        productList2=new ArrayList<Product>();
        rv=findViewById(R.id.msrv);
        ab=findViewById(R.id.msab);
        amt=findViewById(R.id.amt);
        pay=findViewById(R.id.mp);
        dis=findViewById(R.id.dis);
        adapter=new NakeSalesAdapter();
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        adapter.setList(productList);
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProduct();
            }
        });

        dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productList.clear();
                productList2.clear();
                adapter.setList(productList);
                amount=0;
                amt.setText(String.valueOf(amount)+" Rs");

            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeSale();

            }
        });
    }

    private void makeSale(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.customer_info,null);
        final EditText cus=v.findViewById(R.id.cn);
        final EditText phone=v.findViewById(R.id.pn);
        EditText date=v.findViewById(R.id.dt);
        final EditText amtt=v.findViewById(R.id.am);
        amtt.setText(String.valueOf(amount)+" Rs");
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        final Date date1=new Date(System.currentTimeMillis());

        date.setText(dateFormat.format(date1));
        builder.setView(v).setTitle("Customer Info").setCancelable(true)
                .setNegativeButton("Discard", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Make Payment", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        model.updatelist(productList);
                        Sales s=new Sales(date1.getTime(),cus.getText().toString().trim(),phone.getText().toString().trim(),(int) amount);
                        long l=model.inserts(s);

                        Toast.makeText(MakeSales.this,"new sales added at id "+l+" You pay amount= "+amount+" Rs.",Toast.LENGTH_LONG).show();
                        productList.clear();
                        productList2.clear();
                        adapter.setList(productList);
                        amount=0;


                    }
                });
        builder.create().show();
        amt.setText(String.valueOf(amount)+" Rs");
    }

    private void addProduct(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.sale_product,null);
        final EditText idd=v.findViewById(R.id.id);
        final EditText qty=v.findViewById(R.id.qty);
        builder.setView(v).setTitle("New Category").setCancelable(true)
                .setNegativeButton("Discard", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Add to cart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String s=idd.getText().toString();
                        if(!s.isEmpty())
                        {

                            Toast.makeText(MakeSales.this,"Barcode is not empty",Toast.LENGTH_SHORT).show();
                            int code=Integer.parseInt(s);
                            String q=qty.getText().toString().trim();
                            if(!q.isEmpty()){
                                Toast.makeText(MakeSales.this,"Quantity is not empty",Toast.LENGTH_SHORT).show();
                                Product p=model.selectProductById(code);
                                int qq=p.getPquantity();
                                int qt=Integer.parseInt(q);
                                if(p!=null){
                                    Toast.makeText(MakeSales.this,"Product found for code "+code,Toast.LENGTH_SHORT).show();
                                    p.setPquantity(qt);
                                    if(qq>=qt){
                                        Toast.makeText(MakeSales.this,qq+">"+qt,Toast.LENGTH_SHORT).show();

                                        Product pp;
                                        try {
                                            productList2.add(p);
                                            adapter.setList(productList2);
                                            pp = (Product)p.clone();
                                            pp.setPquantity(qq-qt);
                                            productList.add(pp);
                                            //model.updateProduct(pp);
                                            amount+=((100-p.getPdiscount())*p.getPprice()*qt)/100;
                                            amt.setText(String.valueOf(amount));
                                        } catch (CloneNotSupportedException e) {

                                            Toast.makeText(MakeSales.this,"Error occured",Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                }
                            }
                        }



                    }
                });
        builder.create().show();
    }
}
