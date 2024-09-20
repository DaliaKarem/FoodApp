package com.example.myapplication.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {
    ActivityIntroBinding binding; //Connect With XML don't need To Use FindByID
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityIntroBinding.inflate(getLayoutInflater());//Connect With activity_intro.xml
        setContentView(binding.getRoot());//Show Ui
        setVariable();
        //Will Change StatusBar Color
        getWindow().setStatusBarColor(Color.parseColor("#FFE4B5"));

    }

    private void setVariable() {
        binding.logBtn.setOnClickListener(view -> {
            if(mAuth.getCurrentUser()!=null)
            {
                startActivity(new Intent(IntroActivity.this,MainActivity.class));
            }
            else {
                startActivity(new Intent(IntroActivity.this,LoginActivity.class));

            }
        });
        binding.SignBtn.setOnClickListener(view -> startActivity(new Intent(IntroActivity.this,SignUpActivity.class)));
    }
}