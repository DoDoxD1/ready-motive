package com.example.readymotive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    ImageView cutImageButton;
    Button signInButton;
    RelativeLayout googleSignIn;
    TextView signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //refrences

        cutImageButton = findViewById(R.id.cut_imageButton);
        signInButton = findViewById(R.id.sign_in);
        googleSignIn = findViewById(R.id.google_signin);
        signUpButton = findViewById(R.id.sign_up_button);


        cutImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this,GettingStarted.class);
                startActivity(intent);
                finishAffinity();
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignInActivity.this, "Sing in button pressed!", Toast.LENGTH_SHORT).show();
            }
        });

        googleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignInActivity.this, "Sign in with Google!", Toast.LENGTH_SHORT).show();
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}