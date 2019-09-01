package com.smartalarm.new_maha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class User_Profile extends AppCompatActivity {
    private TextView tv1,tv2,tv4,tv5,tv6,tv7,inch;
    public FirebaseAuth firebaseAuth;
    public FirebaseDatabase firebaseDatabase;
    public FirebaseUser user;
    public Button edit_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__profile);
        tv1=(TextView) findViewById(R.id.tv1);
        tv2=(TextView) findViewById(R.id.tv2);
        tv4=(TextView) findViewById(R.id.tv4);
        tv5=(TextView) findViewById(R.id.tv5);
        tv6=(TextView) findViewById(R.id.tv6);
        tv7=(TextView) findViewById(R.id.tv7);
        inch=(TextView) findViewById(R.id.inch);
        edit_button=(Button) findViewById(R.id.edit_button);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        user=firebaseAuth.getCurrentUser();
        DatabaseReference myRef = firebaseDatabase.getReference(user.getUid());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Profile profile=dataSnapshot.getValue(Profile.class);
                tv4.setText(profile.getAge());
                tv1.setText(profile.getUserName());
                tv2.setText(profile.getUserEmail());
                tv5.setText(profile.getHeight()+"f,");
                tv6.setText(profile.getWeidth());
                tv7.setText(profile.getGender());
                inch.setText(profile.getInch()+"in");



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(User_Profile.this,databaseError.getCode(),Toast.LENGTH_LONG).show();
            }
        });

        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(User_Profile.this,Gif_Show.class);
                startActivity(intent);
            }
        });

    }

}

