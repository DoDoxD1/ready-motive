package com.example.readymotive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignupActivity extends AppCompatActivity {

    TextView singInButton;
    ImageView cutImageButton;
    Button signUpButton;
    RelativeLayout googleSignUp;
    ProgressBar progressBar;

    EditText emaiEditText, passEditText, fnameEditText, lnameEditText, mobileEditText;

    FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private CollectionReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //refrences

        singInButton = findViewById(R.id.sign_in_button);
        cutImageButton = findViewById(R.id.cut_imageButton);
        signUpButton = findViewById(R.id.sign_up);
        googleSignUp = findViewById(R.id.google_signin);

        emaiEditText = findViewById(R.id.email_editText);
        passEditText = findViewById(R.id.password_editText);
        fnameEditText = findViewById(R.id.fname_editText);
        lnameEditText = findViewById(R.id.lname_editText);
        mobileEditText = findViewById(R.id.mobile_editText);

        progressBar = findViewById(R.id.progressbar);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        userRef = db.collection("Users");

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
                String email, lname, fname, pass, mobile;
                email = emaiEditText.getText().toString();
                lname = lnameEditText.getText().toString();
                fname = fnameEditText.getText().toString();
                pass = passEditText.getText().toString();
                mobile = mobileEditText.getText().toString();

                if(email.isEmpty()||pass.isEmpty()||fname.isEmpty()||lname.isEmpty()||mobile.isEmpty()){
                    Toast.makeText(SignupActivity.this, "You can't leave empty fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(pass.length()<8){
                    Toast.makeText(SignupActivity.this, "Password can't be less than 8 characters", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                signUp(email,pass,fname,lname,mobile);
            }
        });

        googleSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignupActivity.this, "Sign up with google pressed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void signUp(String email, String pass, String fname, String lname, String mobile) {
        User user = new User(lname,fname,email,pass,mobile);
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("aunu", "createUserWithEmail:success");
                            FirebaseUser fUser = mAuth.getCurrentUser();
                            addUserToDB(email,pass,fname,lname,mobile,fUser,user);
                        }
                        else{
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignupActivity.this, "Authentication failed."+task.getException(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }

    private void addUserToDB(String email, String pass, String fname, String lname, String mobile, FirebaseUser fUser, User user) {
        userRef.document(fUser.getUid()).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                progressBar.setVisibility(View.GONE);
                updateUI(user);
                finishAffinity();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressBar.setVisibility(View.GONE);
                Log.w("aunu", "createUserWithEmail:failure"+ e);
            }
        });
    }

    private void updateUI(User user) {
        Intent intent = new Intent(SignupActivity.this,MainActivity.class);
        startActivity(intent);
        finishAffinity();
    }
}