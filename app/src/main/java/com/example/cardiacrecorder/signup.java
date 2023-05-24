package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class signup extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://cardiacrecorder-db6d2-default-rtdb.firebaseio.com");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText name=findViewById(R.id.name);
        EditText username=findViewById(R.id.username);
        EditText pass=findViewById(R.id.password);
        EditText conpass=findViewById(R.id.confirmpassword);
        EditText email=findViewById(R.id.email);

        Button btn=findViewById(R.id.signupButton);
        TextView logtxt=findViewById(R.id.loginText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nametxt=name.getText().toString();
                String usernametxt=username.getText().toString();
                String passtxt=pass.getText().toString();
                String conpasstxt=conpass.getText().toString();
                String emailtxt=email.getText().toString();

                if(nametxt.isEmpty() || usernametxt.isEmpty() || passtxt.isEmpty() || conpasstxt.isEmpty() || emailtxt.isEmpty())
                {
                    Toast.makeText(signup.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
                }
                else if (!passtxt.equals(conpasstxt))
                {
                    Toast.makeText(signup.this,"Passwords are not matching",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener(){
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot){
                            if(snapshot.hasChild(usernametxt)){
                                Toast.makeText(signup.this,"Username is already registered",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                databaseReference.child("users").child(usernametxt).child("name").setValue(nametxt);
                                databaseReference.child("users").child(usernametxt).child("pass").setValue(nametxt);
                                databaseReference.child("users").child(usernametxt).child("email").setValue(nametxt);

                                Toast.makeText(signup.this,"Register successful",Toast.LENGTH_SHORT).show();
                                Intent intent =  new Intent(signup.this,LoginActivity.class);
                                startActivity(intent);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error){

                        }
                    }
                    );



                }
            }
        });

        logtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(signup.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}