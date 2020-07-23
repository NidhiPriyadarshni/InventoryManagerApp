package com.example.inventorymanagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class AddProduct extends AppCompatActivity {
    private EditText id;
    private EditText name;
    private Spinner category;
    private EditText price;
    private EditText discount;
    private EditText qty;
    private EditText date;
    private Button save;
    private Button discard;

    private List<Category> allCategory;
    private Intent i;
    private Intent it;
    private Bundle b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        id=findViewById(R.id.pdcode);
        name=findViewById(R.id.pdname);
        category=findViewById(R.id.pdcat);
        price=findViewById(R.id.pdprice);
        discount=findViewById(R.id.pddisc);
        qty=findViewById(R.id.pdqty);
        date=findViewById(R.id.pddate);
        save=findViewById(R.id.pdsave);
        discard=findViewById(R.id.pddiscard);
        i=this.getIntent();
        b=i.getExtras();
        allCategory=(List<Category>)b.getSerializable("allCategory");
        ArrayAdapter<Category> adapter=new ArrayAdapter<Category>(this,android.R.layout.simple_spinner_item,allCategory);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });
    }
    private void add(){
        it=new Intent();
        it.putExtra("code",id.getText().toString().trim());
        it.putExtra("name",name.getText().toString().trim());
        it.putExtra("date",date.getText().toString().trim());
        it.putExtra("price",Integer.parseInt(price.getText().toString().trim()));
        it.putExtra("discount",Integer.parseInt(String.valueOf(discount.getText()).trim()));
        it.putExtra("quantity",Integer.parseInt(String.valueOf(qty.getText()).trim()));
        it.putExtra("category",category.getTooltipText());
        setResult(2,it);
        finish();
    }
}
