package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class edit extends AppCompatActivity {

    DatabaseReference databaserefence=FirebaseDatabase.getInstance().getReferenceFromUrl("https://cardiacrecorder-db6d2-default-rtdb.firebaseio.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        EditText date=findViewById(R.id.datevalueText);
        EditText time=findViewById(R.id.timevalueText);
        EditText systolic=findViewById(R.id.systolicvalueText);
        EditText diastolic=findViewById(R.id.diastolicvalueText);
        EditText heart=findViewById(R.id.heartratevalueText);
        EditText comment=findViewById(R.id.commentvalueText);
        Button save=findViewById(R.id.saveButton);

        Intent intent=getIntent();
        String user=intent.getStringExtra("username");
        String id=intent.getStringExtra("id");

        databaseReference.child("data").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String datevalue = snapshot.child(user).child(id).child("date").getValue(String.class);
                String timevalue = snapshot.child(user).child(id).child("time").getValue(String.class);
                String sysvalue = snapshot.child(user).child(id).child("sys").getValue(String.class);
                String disvalue = snapshot.child(user).child(id).child("dis").getValue(String.class);
                String bpmvalue = snapshot.child(user).child(id).child("bpm").getValue(String.class);
                String cmntvalue = snapshot.child(user).child(id).child("cmnt").getValue(String.class);

                date.setText(datevalue);
                time.setText(timevalue);
                systolic.setText(sysvalue);
                diastolic.setText(disvalue);
                heart.setText(bpmvalue);
                comment.setText(cmntvalue);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String datevalue = date.getText().toString();
                String timevalue = time.getText().toString();
                String sysvalue = systolic.getText().toString();
                String disvalue = diastolic.getText().toString();
                String bpmvalue = heart.getText().toString();
                String cmntvalue = comment.getText().toString();

                databasereference.child("data").addListener.ForSingleValueEvent(new ValueEventListener(){
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot){
                            databaseReference.child("data").child(user).child(id).child("date").setValue(datevalue);
                            databaseReference.child("data").child(user).child(id).child("time").setValue(timevalue);
                            databaseReference.child("data").child(user).child(id).child("sys").setValue(sysvalue);
                            databaseReference.child("data").child(user).child(id).child("dis").setValue(disvalue);
                            databaseReference.child("data").child(user).child(id).child("bpm").setValue(bpmvalue);
                            databaseReference.child("data").child(user).child(id).child("cmnt").setValue(cmntvalue);
                            Toast.makeText(edit.this,"Data Update Successful",Toast.LENGTH_SHORT).show();
                            Intent intent =  new Intent(edit.this, MainActivity.class);
                            intent.putExtra("username",user);
                            startActivity(intent);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error){

                    }
                }
                );

            }
        });
    }
}