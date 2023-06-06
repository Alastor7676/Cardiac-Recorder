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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class otp_verification extends AppCompatActivity {

    int d1;
    String user,name,pass,phone;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://cardiacrecorder-db6d2-default-rtdb.firebaseio.com");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        Intent intent=getIntent();
        user=intent.getStringExtra("user");
        name=intent.getStringExtra("name");
        pass=intent.getStringExtra("pass");
        phone=intent.getStringExtra("phone");

        EditText input1=findViewById(R.id.input1);
        EditText input2=findViewById(R.id.input2);
        EditText input3=findViewById(R.id.input3);
        EditText input4=findViewById(R.id.input4);
        Button verify=findViewById(R.id.verify1);
        int min = 1000;
        int max = 9999;

        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;

        //System.out.println("Random 4-digit number: " + randomNumber);

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phone, null, "Your OTP is"+randomNumber, null, null);



        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=input1.getText().toString();
                String a2=input2.getText().toString();
                String a3=input3.getText().toString();
                String a4=input4.getText().toString();

                if(a.isEmpty()||a2.isEmpty()||a3.isEmpty()||a4.isEmpty()){
                    Toast.makeText(otp_verification.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
                }
                else{
                    d1=Integer.parseInt(a);
                    int d2=Integer.parseInt(a2);
                    int d3=Integer.parseInt(a3);
                    int d4=Integer.parseInt(a4);
                    d1=d1*10+d2;
                    d1=d1*10+d3;
                    d1=d1*10+d4;

                    if(d1==randomNumber){
                        add_user(user,name,pass,phone);
                        Intent intent =  new Intent(otp_verification.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(otp_verification.this,"Wrong OTP",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void add_user(String user,String name,String pass,String phone){
        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot){
                databaseReference.child("users").child(user).child("name").setValue(name);
                databaseReference.child("users").child(user).child("pass").setValue(pass);
                databaseReference.child("users").child(user).child("email").setValue(phone);
                Toast.makeText(otp_verification.this,"Register successful",Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error){
            }
        }
        );
    }
}