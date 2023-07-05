package com.example.cardiacrecorder;

import org.junit.Test;

import static org.junit.Assert.*;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://cardiacrecorder-db6d2-default-rtdb.firebaseio.com");
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test_add_user(){
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

    @Test
    public void test_add_data(){
        String time = "11";
        String date = "11";
        String sys = "11";
        String dis = "11";
        String bpm = "11";
        String cmnt = "11";
        String id = "50000";
        String passeduser="ab";

        DataClass dataClass = new DataClass(date,time,sys,dis,bpm,cmnt,"ab",id);
        AddActivity addActivity=new AddActivity();
        addActivity.add_data(id,dataClass,passeduser);

        databaseReference.child("data").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot contentSnapshot = snapshot.child(passeduser);
                assertTrue(contentSnapshot.hasChild(id));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Test
    public void test_edit_data(){
        String datevalue = "ab";
        String timevalue = "ab";
        String sysvalue = "ab";
        String disvalue = "ab";
        String bpmvalue = "ab";
        String cmntvalue = "ab";
        String user="ab";
        String id = "50000";
        edit e=new edit();
        e.edit_data(user,id,datevalue,timevalue,sysvalue,disvalue,bpmvalue,cmntvalue);

        databaseReference.child("data").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String datavalue2=snapshot.child(user).child(id).child("date").getValue(String.class);
                String timevalue2=snapshot.child(user).child(id).child("time").getValue(String.class);
                String sysvalue2=snapshot.child(user).child(id).child("sys").getValue(String.class);
                String disvalue2=snapshot.child(user).child(id).child("dis").getValue(String.class);
                String bpmvalue2=snapshot.child(user).child(id).child("bpm").getValue(String.class);
                String cmntvalue2=snapshot.child(user).child(id).child("cmnt").getValue(String.class);
                assertEquals(datevalue,datavalue2);
                assertEquals(timevalue,timevalue2);
                assertEquals(sysvalue,sysvalue2);
                assertEquals(disvalue,disvalue2);
                assertEquals(bpmvalue,bpmvalue2);
                assertEquals(cmntvalue,cmntvalue2);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
//
//    @Test
//    public void test_delete_data(){
//        String id="50000";
//        String user="ab";
//        MyAdapter myAdapter=new MyAdapter();
//        myAdapter.delete_data(user,id);
//
//        databaseReference.child("data").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                DataSnapshot contentSnapshot = snapshot.child(user);
//                assertTrue(!contentSnapshot.hasChild(id));
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
}