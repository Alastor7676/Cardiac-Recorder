package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class otp_verification extends AppCompatActivity {

    int d1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        Intent intent=getIntent();
        String user=intent.getStringExtra("user");
        String name=intent.getStringExtra("name");
        String pass=intent.getStringExtra("pass");
        String phone=intent.getStringExtra("phone");

        EditText input1=findViewById(R.id.input1);
        EditText input2=findViewById(R.id.input2);
        EditText input3=findViewById(R.id.input3);
        EditText input4=findViewById(R.id.input4);
        Button verify=findViewById(R.id.verify1);
        int min = 1000;
        int max = 9999;

        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;

        System.out.println("Random 4-digit number: " + randomNumber);

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phone, null, "Your OTP "+randomNumber, null, null);

        String a=input1.getText().toString();
        d1=Integer.parseInt(a);

        String a2=input2.getText().toString();
        int d2=Integer.parseInt(a2);

        String a3=input3.getText().toString();
        int d3=Integer.parseInt(a3);

        String a4=input4.getText().toString();
        int d4=Integer.parseInt(a4);
        d1=d1*10+d2;
        d1=d1*10+d3;
        d1=d1*10+d4;

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d1==randomNumber){
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener(){
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot){
                            if(snapshot.hasChild(usernametxt)){
                                Toast.makeText(otp_verification.this,"Username is already registered",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                databaseReference.child("users").child(usernametxt).child("name").setValue(nametxt);
                                databaseReference.child("users").child(usernametxt).child("pass").setValue(passtxt);
                                databaseReference.child("users").child(usernametxt).child("email").setValue(emailtxt);

                                Toast.makeText(otp_verification.this,"Register successful",Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error){

                        }
                    }
                    );
                }
                else {
                    Toast.makeText(otp_verification.this,"Wrong OTP",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}