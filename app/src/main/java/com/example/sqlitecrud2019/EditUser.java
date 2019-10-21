package com.example.sqlitecrud2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        this.setTitle(R.string.EditU);
    }

    public void Edit(View view){
        Intent up= new Intent(this, ListUsers.class);
        startActivity(up);
    }
}
