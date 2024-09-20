package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class SignUpActivity extends BaseActivity {
ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setVariable();

    }

    private void setVariable() {
        binding.SignUpBtn.setOnClickListener(view -> {
         String email=binding.editEmailText.getText().toString();
         String Pass=binding.editPassText.getText().toString();
        if(Pass.length()<6)
         {
             Toast.makeText(SignUpActivity.this,"You Password must be more than 6 Character",Toast.LENGTH_SHORT).show();
             return;
         }
         mAuth.createUserWithEmailAndPassword(email,Pass).addOnCompleteListener(SignUpActivity.this, task -> {
             if (task.isSuccessful())
             {
                 Log.i(TAG,"onCompleted :");
                 startActivity(new Intent(SignUpActivity.this,MainActivity.class));
             }
             else{
                 Log.i(TAG,"Failure: "+task.getException());
                 Toast.makeText(SignUpActivity.this,"Authentication faild",Toast.LENGTH_SHORT).show();


             }
         });
        });
    }
}