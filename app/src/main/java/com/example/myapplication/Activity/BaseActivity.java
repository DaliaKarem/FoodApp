package com.example.myapplication.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class BaseActivity extends AppCompatActivity {
FirebaseAuth mAuth; //to Auh Operation
FirebaseDatabase database; //to Conect WithDB
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database=FirebaseDatabase.getInstance();//Init
        mAuth=FirebaseAuth.getInstance();//Init
        //Will Change StatusBar Color->White
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
    }
}