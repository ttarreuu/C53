package com.example.c53;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        final ProfileFragment myFragment = new ProfileFragment();

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        buttonLogin = findViewById(R.id.btn_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameKey = etUsername.getText().toString();
                String passwordKey = etPassword.getText().toString();

                if (usernameKey.equals("username") && passwordKey.equals("password")){
                    Toast.makeText(getApplicationContext(), "LOGIN SUCCESSFULL",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    intent.putExtra("username", usernameKey);
                    startActivity(intent);
                    finish();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Username or password wrong!")
                            .setNegativeButton("Retry", null).create().show();
                }


            }
        });
    }
}