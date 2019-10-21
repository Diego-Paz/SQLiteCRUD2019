package com.example.sqlitecrud2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitecrud2019.DataAcces.ConnectionDB;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText user,password;
    TextInputLayout lau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        lau = findViewById(R.id.lau);
    }
    private boolean Email() {
        String emailInput = lau.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            lau.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            lau.setError("Please enter a valid email address");
            return false;
        } else {
            lau.setError(null);
            return true;
        }
    }
    public void Signin(View view){
        if (!Email()) {
            return;
        }
        ConnectionDB con = new ConnectionDB(this);
        boolean res = con.ValidateLo(user.getText().toString(),password.getText().toString());
        if (res== true){
            Intent listUseres= new Intent(this,ListUsers.class);
            startActivity(listUseres);
        }else {
            Toast.makeText(this, "Error email or password incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    public void Signup(View view){
        Intent up= new Intent(this, SignUp.class);
        startActivity(up);
    }
}
