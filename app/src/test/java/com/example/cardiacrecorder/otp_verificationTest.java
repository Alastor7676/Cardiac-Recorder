package com.example.cardiacrecorder;

import static org.junit.Assert.*;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.junit.Test;

public class otp_verificationTest {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://cardiacrecorder-db6d2-default-rtdb.firebaseio.com");

    @Test
    public void add_user() {
        otp_verification otp=new otp_verification();
        String user="ab";
        String name="ab";
        String pass="ab";
        String phone="ab";
        otp.add_user(user,name,pass,phone);
        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                assertTrue(snapshot.hasChild(user));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}