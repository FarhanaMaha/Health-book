package com.smartalarm.new_maha;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class Gif_Show extends AppCompatActivity {
    private EditText edit_weight,edit_age,edit_height,edit_inch,edit_gender;
    private TextView edit_username,edit_email;
    public Button edit_save;
    public FirebaseAuth firebaseAuth;
    public FirebaseDatabase firebaseDatabase;
    public FirebaseUser user;
    public DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif__show);
        edit_username=(TextView) findViewById(R.id.edit_username);
        edit_email=(TextView) findViewById(R.id.edit_email);
        edit_age=(EditText) findViewById(R.id.edit_age);
        edit_height=(EditText) findViewById(R.id.edit_height);
        edit_inch=(EditText) findViewById(R.id.edit_inch);
        edit_weight=(EditText) findViewById(R.id.edit_weight);
        edit_gender=(EditText) findViewById(R.id.edit_gender);


        edit_save=(Button) findViewById(R.id.edit_save);


        firebaseAuth= FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        user=firebaseAuth.getCurrentUser();
        final DatabaseReference myRef= firebaseDatabase.getReference(user.getUid());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Profile profile=dataSnapshot.getValue(Profile.class);
                edit_age.setText(profile.getAge());
                edit_username.setText(profile.getUserName());
                edit_email.setText(profile.getUserEmail());
                edit_height.setText(profile.getHeight());
                edit_inch.setText(profile.getInch());
                edit_weight.setText(profile.getWeidth());
                edit_gender.setText(profile.getGender());




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Gif_Show.this,databaseError.getCode(),Toast.LENGTH_LONG).show();
            }
        });

        edit_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String new_age=edit_age.getText().toString();
                String new_username=edit_username.getText().toString();
                String new_email=edit_email.getText().toString();
                String new_height=edit_height.getText().toString();
                String new_inch=edit_inch.getText().toString();
                String new_weight=edit_weight.getText().toString();
                String new_gender=edit_gender.getText().toString();

                Profile newProfile=new Profile(new_age,new_username,new_email,new_height,new_weight,new_gender,new_inch);
                myRef.setValue(newProfile);
                finish();
            }
        });
    }


}