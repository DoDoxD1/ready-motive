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

public class SignupActivity extends AppCompatActivity {

    TextView singInButton;
    ImageView cutImageButton;
    Button signUpButton;
    RelativeLayout googleSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //refrences

        singInButton = findViewById(R.id.sign_in_button);
        cutImageButton = findViewById(R.id.cut_imageButton);
        signUpButton = findViewById(R.id.sign_up);
        googleSignUp = findViewById(R.id.google_signin);

        singInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });

        cutImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this,GettingStarted.class);
                startActivity(intent);
                finishAffinity();
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignupActivity.this, "Sign up button pressed!", Toast.LENGTH_SHORT).show();
            }
        });

        googleSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignupActivity.this, "Sign up with google pressed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}