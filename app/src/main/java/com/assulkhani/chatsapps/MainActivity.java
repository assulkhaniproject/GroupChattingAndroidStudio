package com.assulkhani.chatsapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {

    TextInputEditText txtEmail , txtPassword;
    ProgressBar progressBar;
    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser()!=null)
        {
            Intent i = new Intent(MainActivity.this, GroupChatActivity.class);
            startActivity(i);
        }else {
            setContentView(R.layout.activity_main);

            txtEmail = (TextInputEditText)findViewById(R.id.emailLogin);
            txtPassword = (TextInputEditText)findViewById(R.id.passwordLogin);
            progressBar = (ProgressBar)findViewById(R.id.progressLogin);
            reference = FirebaseDatabase.getInstance().getReference().child("Users");
        }

    }

    public void LoginUser(View v){
        progressBar.setVisibility(View.VISIBLE);
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();

        if (!email.equals("") && !password.equals(""))
        {
            auth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(),"Loggin Berhasil",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(MainActivity.this, GroupChatActivity.class);
                                startActivity(i);
                            }else{
                                Toast.makeText(getApplicationContext(),"Email Atau Password Salah, Silahkan Coba Lagi !",Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }

                        }
                    });
        }
    }
    public void GoToRegister(View v){
        Intent i = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(i);
    }
    public void forgotPassword(View v){

    }
}
