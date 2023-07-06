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


    }
