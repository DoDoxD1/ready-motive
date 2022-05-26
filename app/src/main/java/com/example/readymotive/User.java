package com.example.readymotive;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class User {
    private String lname, fname, email, password, mobileNumber;

    static FirebaseAuth mAuth;
    static FirebaseUser mUser;
    static User user;
    static FirebaseFirestore db;
    static DocumentReference userRef;

    public User() {
    }

    public User(String lname, String fname, String email) {
        this.lname = lname;
        this.fname = fname;
        this.email = email;
    }

    public User(String lname, String fname, String email, String password, String mobileNumber) {
        this.lname = lname;
        this.fname = fname;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    public static void getCurrentUserFromDB() {
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();
        if(mUser!=null)
            userRef = db.collection("Users").document(mUser.getUid());
        if(userRef!=null)
            userRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    user = documentSnapshot.toObject(User.class);
                }
            });
    }

    public static User getUser() {
        return user;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
