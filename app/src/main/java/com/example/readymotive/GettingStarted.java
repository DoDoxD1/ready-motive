package com.example.readymotive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GettingStarted extends AppCompatActivity {

    TextView singInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_started);

        //refrences
        singInButton = findViewById(R.id.sign_in_button);

        singInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GettingStarted.this,SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}