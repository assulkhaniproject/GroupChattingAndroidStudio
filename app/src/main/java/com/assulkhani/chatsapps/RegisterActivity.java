package com.assulkhani.chatsapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText txtEmail , txtPassword;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtEmail = (TextInputEditText)findViewById(R.id.emailRegister);
        txtPassword = (TextInputEditText)findViewById(R.id.passwordRegister);
        progressBar = (ProgressBar)findViewById(R.id.progressRegister);
    }
    public void GoToLogin (View v){
        Intent i = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(i);
    }
}
