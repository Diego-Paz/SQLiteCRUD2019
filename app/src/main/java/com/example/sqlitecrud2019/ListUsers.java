package com.example.sqlitecrud2019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.sqlitecrud2019.Controller.ViewL;
import com.example.sqlitecrud2019.DataAcces.ConnectionDB;
import com.example.sqlitecrud2019.Model.Users;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ListUsers extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ViewL adausu;

    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        this.setTitle(R.string.ListU);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ConnectionDB db = new ConnectionDB(getApplicationContext());

        adausu = new ViewL(db.showListUsers());
        recyclerView.setAdapter(adausu);
    }
    public void Edit(View view){
        Intent up= new Intent(this, EditUser.class);
        startActivity(up);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menulist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switchecase(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menulist,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 121:
                displayMessage("eliminado");
                return true;
            case 122:
                Intent up= new Intent(this, EditUser.class);
                startActivity(up);
                displayMessage("actuañizando");
                return true;
                default:
                    return super.onContextItemSelected(item);
        }

    }
    private void displayMessage(String message){
        Snackbar.make(findViewById(R.id.eso),message,Snackbar.LENGTH_SHORT).show();
    }

    public boolean switchecase(MenuItem item){
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ConnectionDB db = new ConnectionDB(getApplicationContext());

        switch (item.getItemId()){
            case R.id.itemMale:
                adausu = new ViewL(db.male());
                recyclerView.setAdapter(adausu);
                return  true;
            case R.id.itemFemale:
                adausu = new ViewL(db.female());
                recyclerView.setAdapter(adausu);
                return  true;
            case R.id.itemAllUser:
                adausu = new ViewL(db.showListUsers());
                recyclerView.setAdapter(adausu);
                return  true;
            case R.id.itemAbout:
                Toast.makeText(this, "Application created by: Diego Andres Paz Pantoja", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemLogout:
                Intent lo= new Intent(this, MainActivity.class);
                startActivity(lo);
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

}
