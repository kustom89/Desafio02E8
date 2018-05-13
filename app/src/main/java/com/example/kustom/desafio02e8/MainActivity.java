package com.example.kustom.desafio02e8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.kustom.desafio02e8.models.Client;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView departemnt= findViewById(R.id.departmentTv);
        final TextView jobTile= findViewById(R.id.jobTitleTv);
        final TextView name= findViewById(R.id.nameTv);

        DatabaseReference root= FirebaseDatabase.getInstance().getReference();
        root.child("credentials").child("00030").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Client client= dataSnapshot.getValue(Client.class);

                departemnt.setText(client.getDeparment());
                jobTile.setText(client.getJobTitle());
                name.setText(client.getName());



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }


}
