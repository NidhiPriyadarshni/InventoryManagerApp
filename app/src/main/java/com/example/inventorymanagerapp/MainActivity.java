package com.example.inventorymanagerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.*;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditText auedt;
    private EditText ouedt;
    private EditText apedt;
    private EditText opedt;
    private Button alb;
    private Button asb;
    private Button olb;
    private Button osb;
    private Button sa;
    private Button so;
    private MainActivityViewModel model;
    private int in;
    private int inn;
    private LiveData<List<Admintable>> allAdmin;
    private LiveData<List<Ownertable>> allOwner;
    private StringBuffer as;
    private StringBuffer os;
    private AlertDialog alert;
    // private Integer it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auedt=findViewById(R.id.au1);
        ouedt=findViewById(R.id.ou1);
        apedt=findViewById(R.id.ap1);
        opedt=findViewById(R.id.op1);
        alb=findViewById(R.id.al1);
        asb=findViewById(R.id.as1);
        olb=findViewById(R.id.ol1);
        osb=findViewById(R.id.os1);
        sa=findViewById(R.id.showa);
        so=findViewById(R.id.showo);
        EditText editText=findViewById(R.id.id);
        editText.setMovementMethod(LinkMovementMethod.getInstance());

        model= new ViewModelProvider(this).get(MainActivityViewModel.class);
        model.selectAllAdmin().observe(this,new Observer<List<Admintable>>() {
            @Override
            public void onChanged(List<Admintable> admintables) {
                  as=new StringBuffer();
                  for(Admintable a:admintables){
                      as.append(a.getAusername()+"\t"+a.getApassword()+"\n");
                  }
            }

        });
        model.selectAllOwner().observe(this, new Observer<List<Ownertable>>() {
            @Override
            public void onChanged(List<Ownertable> ownertables) {
                os=new StringBuffer();
                for(Ownertable a:ownertables){
                    os.append(a.getOusername()+"\t"+a.getOpassword()+"\n");
                }
            }
        });

        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                alert=new AlertDialog.Builder(MainActivity.this).setMessage(as).setCancelable(true).create();
                alert.setTitle("Available Admins");
                alert.show();
            }
        });

        so.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert=new AlertDialog.Builder(MainActivity.this).setMessage(os).setCancelable(true).create();
                alert.setTitle("Available Owners");
                alert.show();
            }
        });
        asb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String u=auedt.getText().toString().trim();
                String p=apedt.getText().toString().trim();
                if(u.equals("")){
                    Toast.makeText(MainActivity.this,"Enter a username",Toast.LENGTH_SHORT).show();
                }else if(p.equals("")){
                    Toast.makeText(MainActivity.this,"Enter a password",Toast.LENGTH_SHORT).show();
                }else{
                    addAdmin(u,p);
                }


            }
        });
        osb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u=ouedt.getText().toString().trim();
                String p=opedt.getText().toString().trim();
                if(u.equals("")){
                    Toast.makeText(MainActivity.this,"Enter a username",Toast.LENGTH_SHORT).show();
                }else if(p.equals("")){
                    Toast.makeText(MainActivity.this,"Enter a password",Toast.LENGTH_SHORT).show();
                }else{
                    addOwner(u,p);
                }
            }
        });

        alb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u=auedt.getText().toString().trim();
                String p=apedt.getText().toString().trim();
                if(u.equals("")){
                    Toast.makeText(MainActivity.this,"Enter a username",Toast.LENGTH_SHORT).show();
                }else if(p.contentEquals("")){
                    Toast.makeText(MainActivity.this,"Enter a password",Toast.LENGTH_SHORT).show();
                }else{
                    openUser(u,p);
                }
            }
        });

        olb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u=ouedt.getText().toString().trim();
                String p=opedt.getText().toString().trim();
                if(u.equals("")){
                    Toast.makeText(MainActivity.this,"Enter a username",Toast.LENGTH_SHORT).show();
                }else if(p.equals("")){
                    Toast.makeText(MainActivity.this,"Enter a password",Toast.LENGTH_SHORT).show();
                }else{
                    openOwner(u,p);
                }
            }
        });

    }
    private boolean checkAdminCount(String s){
        in=model.getAcount(s);
        if(in==0)return true;
        else return false;

    }
    private boolean checkOwnerCount(String s){
        inn=model.getOcount(s);
        if(in==0)return true;
        else return false;
    }
    private void addAdmin(String u,String p){
        if(checkAdminCount(u)){
            model.addAdmin(u,p);
            Intent i=new Intent(MainActivity.this,User.class);
            startActivity(i);
            finish();
        }else{
            Toast.makeText(this,"The username already exist.\nEnter another username",Toast.LENGTH_SHORT).show();
        }
    }
    private void addOwner(String u,String p){
        if(checkOwnerCount(u)){
            model.addOwner(u,p);
            Intent i=new Intent(MainActivity.this,Owner.class);
            startActivity(i);
            finish();
        }else{
            Toast.makeText(this,"The username already exist.\nEnter another username",Toast.LENGTH_SHORT).show();
        }
    }
    private void openUser(String u,String p){
        in=model.checkAdmin(u,p);
        if(in==0){
            Toast.makeText(MainActivity.this,"Invalid username or password",Toast.LENGTH_SHORT).show();
        }else{

            Intent i=new Intent(MainActivity.this,User.class);
            startActivity(i);
            finish();
        }
    }
    private void openOwner(String u,String p){
        inn=model.checkOwner(u,p);
        if(inn==0){
            Toast.makeText(this,"Invalid username or password",Toast.LENGTH_SHORT).show();
        }else{
            Intent i=new Intent(MainActivity.this,Owner.class);
            startActivity(i);
            finish();
        }
    }
}
