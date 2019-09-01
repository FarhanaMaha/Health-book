package com.smartalarm.new_maha;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registation_Page extends AppCompatActivity {
    private EditText username, user_email, age, height, weidth, user_password,inch;
    public Button submit;
    private RadioGroup mGender;
    private RadioButton radioButton;
    private FirebaseAuth firebaseAuth;
    public FirebaseUser user;
    public String name,email,upassword,contact2,age2,height2,inch2,weidth2,srtGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation__page);
        firebaseAuth=FirebaseAuth.getInstance();

        submit = (Button) findViewById(R.id.submit);
        username = (EditText) findViewById(R.id.et1);
        user_email = (EditText) findViewById(R.id.et2);
        age=(EditText) findViewById(R.id.age);
        height = (EditText) findViewById(R.id.et4);
        inch=(EditText) findViewById(R.id.inch);
        weidth = (EditText) findViewById(R.id.et5);
        user_password = (EditText) findViewById(R.id.et6);
        mGender=(RadioGroup) findViewById(R.id.radio_group);



        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                radioButton=mGender.findViewById(i);
                switch (i){
                    case R.id.radiobtn1:
                        srtGender=radioButton.getText().toString();
                        break;
                    case R.id.radiobtn2:
                        srtGender=radioButton.getText().toString();
                        break;
                    default:

                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if ( validate())
                {
                    email=user_email.getText().toString().trim();
                    upassword=user_password.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(email,upassword)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful())
                                    {
                                        sendUserData();
                                        emailVerification();
                                        firebaseAuth.signOut();
                                        Toast.makeText(Registation_Page.this,"Registation Successful",Toast.LENGTH_SHORT).show();
                                        finish();
                                        Intent intent=new Intent(Registation_Page.this,Login_P.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(Registation_Page.this,"Registation failed",Toast.LENGTH_LONG).show();
                                    }

                                }
                            });

                }
                else {

                }

            }
        });



    }
    private boolean validate(){
        boolean result=false;
        name=username.getText().toString();
        email=user_email.getText().toString();
        age2=age.getText().toString();
        height2=height.getText().toString();
        weidth2=weidth.getText().toString();
        upassword=user_password.getText().toString();
        inch2=inch.getText().toString();

        if (name.isEmpty()|| email.isEmpty()|| upassword.isEmpty()){
            Toast.makeText(this,"Enter all the details",Toast.LENGTH_LONG).show();
        }else {
            result=true;
        }
        return result;
    }

    public void sendUserData(){
        user=firebaseAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(user.getUid());
        Profile profile=new Profile(age2,name,email,height2,weidth2,srtGender,inch2);
        myRef.setValue(profile);

    }
    private void emailVerification(){
        user=firebaseAuth.getInstance().getCurrentUser();
        if (user!=null){
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
             if (task.isSuccessful()){
                 firebaseAuth.signOut();
                 finish();
             }

                }
            });
        }
    }
}
