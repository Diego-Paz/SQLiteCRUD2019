package com.example.sqlitecrud2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import com.example.sqlitecrud2019.DataAcces.ConnectionDB;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {
EditText la,fi,us,pa,cpa;
TextInputLayout layaus, conf;
private boolean authorizer = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        la = findViewById(R.id.la);
        fi = findViewById(R.id.fi);
        us = findViewById(R.id.us);
        pa = findViewById((R.id.pa));
        cpa= findViewById((R.id.cpa));

        layaus = findViewById(R.id.layaus);
        conf = findViewById(R.id.confi);
        validate();
    }

    public void onPause(){
        super.onPause();
        super.onRestart();
    }

    public void Register (View view){
        if (!Email()) {
            return;
        }

        ConnectionDB con = new ConnectionDB(this);
        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues values = new ContentValues();
        String a= pa.getText().toString();
        String b= cpa.getText().toString();
        if(a.equals(b)){
            conf.setErrorEnabled(false);
            if (!la.getText().toString().isEmpty() && !fi.getText().toString().isEmpty() && !us.getText().toString().isEmpty() && !pa.getText().toString().isEmpty() && authorizer==true){

                values.put("firstname", fi.getText().toString());
                values.put("lastname", la.getText().toString());
                values.put("username", us.getText().toString());
                values.put("password", pa.getText().toString());
                long noRegistro =db.insert("user", null, values);

                Toast.makeText(this, "Registro No "+noRegistro, Toast.LENGTH_SHORT).show();
                db.close();

                Intent lo= new Intent(this, MainActivity.class);
                startActivity(lo);

            }else{
                Toast.makeText(this, "there are empty fields", Toast.LENGTH_SHORT).show();
            }
        }else {
            conf.setError("passwords do not match");
        }
    }
    private boolean Email() {
        String emailInput = layaus.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            layaus.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            layaus.setError("Please enter a valid email address");
            return false;
        } else {
            layaus.setError(null);
            return true;
        }
    }
    public void validate(){
        final ConnectionDB con = new ConnectionDB(this);
        boolean res =con.ValidateUs(us.getText().toString());
        if(res==true){
            layaus.setError("this email already exists");
            authorizer=false;
        }else{
            layaus.setErrorEnabled(false);
            authorizer=true;
        }
        us.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                boolean res= con.ValidateUs(editable.toString());
                if(res==true){
                    layaus.setError("This email arrady exist");
                    authorizer=false;
                }else{
                    layaus.setErrorEnabled(false);
                    authorizer=true;
                }

            }
        });




    }
}
