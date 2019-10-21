package com.example.sqlitecrud2019.DataAcces;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sqlitecrud2019.Controller.ViewL;
import com.example.sqlitecrud2019.Model.Users;

import java.util.ArrayList;
import java.util.List;

public class ConnectionDB extends SQLiteOpenHelper{

    public ConnectionDB(@Nullable Context context) {
        super(context, "CRUD", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase CRUD) {
        CRUD.execSQL("Create Table user ("+"Id integer primary key autoincrement  not null,"+
                "firstname text not null,"+
                "lastname text not null,"+
                "username text not null,"+
                "password text not null," +
                "birth text," +
                "country text," +
                "phone text," +
                "gender text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
public boolean eli(String idf){
    SQLiteDatabase db = getReadableDatabase();
    Cursor cursor = db.rawQuery("Delete from user where id= '"+ idf + "'", null);
    if(cursor.moveToFirst()){
        return  true;
    }else{

        return false;
    }
}
    public boolean ValidateUs(String us){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where username= '"+ us + "'Limit 1", null);
        if(cursor.moveToFirst()){
            return  true;
        }else{
            return false;
        }
    }

    public boolean ValidateLo(String user, String password){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("Select * from user where username= '"+ user + "' and password='"+ password +"' Limit 1", null);

        if(cursor.moveToFirst()){
            return  true;
        }else{
            return false;
        }
    }

    public List<Users> showListUsers(){

        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM user", null);

        List<Users>  listUsers = new ArrayList<>();

        if(cursor.moveToFirst()){
            do {
                listUsers.add(new Users(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8)));
            }while (cursor.moveToNext());
        }
        return listUsers;
    }
public boolean delete (){
        return true;
}

    public List<Users> male(){

        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM user  where gender = '" + "Male" + "'", null);

        List<Users>  listUsers = new ArrayList<>();

        if(cursor.moveToFirst()){
            do {
                listUsers.add(new Users(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8)));
            }while (cursor.moveToNext());
        }
        return listUsers;
    }

    public List<Users> female(){

        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM user  where gender = '" + "Female" + "'", null);

        List<Users>  listUsers = new ArrayList<>();

        if(cursor.moveToFirst()){
            do {
                listUsers.add(new Users(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8)));
            }while (cursor.moveToNext());
        }
        return listUsers;


    }
}
