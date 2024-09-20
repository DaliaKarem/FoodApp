package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setVariable();
    }

    private void setVariable() {
        binding.LoginBtn.setOnClickListener(view -> {
            String email=binding.editEmailText.getText().toString();
            String Pass=binding.editPassText.getText().toString();
            if (!Pass.isEmpty() && !email.isEmpty())
            {
                mAuth.signInWithEmailAndPassword(email,Pass).addOnCompleteListener(LoginActivity.this, task -> {
                    if (task.isSuccessful())
                    {
                        //Log.i(TAG,"onCompleted :");
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    }
                    else{
                        //Log.i(TAG,"Failure: "+task.getException());
                        Toast.makeText(LoginActivity.this,"Authentication failed",Toast.LENGTH_SHORT).show();


                    }
                });

            }
            else if(Pass.length()<6)
            {
                Toast.makeText(LoginActivity.this,"You Password must be more than 6 Character",Toast.LENGTH_SHORT).show();
                return;
            }
        });

    }
}