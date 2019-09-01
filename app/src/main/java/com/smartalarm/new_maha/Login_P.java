package com.smartalarm.new_maha;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login_P extends AppCompatActivity {
    private EditText inputeamil, inputPassword;
    private Button button;
    private TextView click_here;
    public FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    public FirebaseUser user;
    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference databaseReference;
    private TextView fgt_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__p);
        firebaseAuth=FirebaseAuth.getInstance();

        firebaseDatabase=FirebaseDatabase.getInstance();
        // databaseReference=firebaseDatabase.getReference(USERS_KEY);
        user=firebaseAuth.getCurrentUser();
        if (user != null) {
            finish();
            startActivity(new Intent(Login_P.this, MainActivity.class));

        }
        fgt_password=(TextView) findViewById(R.id.fgt_password);
        inputeamil=(EditText) findViewById(R.id.editText1);
        inputPassword=(EditText) findViewById(R.id.editText2);
        button=(Button) findViewById(R.id.button);
        click_here=(TextView) findViewById(R.id.click_here);
        progressDialog=new ProgressDialog(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(inputeamil.getText().toString(),inputPassword.getText().toString());

            }
        });

        click_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(Login_P.this,Registation_Page.class);
                startActivity(intent2);
            }
        });

        fgt_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intnt=new Intent(Login_P.this,Forget_Password.class);
                startActivity(intnt);
            }
        });
    }
    private void validate(String email,String userPassword){
        progressDialog.setTitle("Please Waiting");
        progressDialog.setMessage("Processing........");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,userPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            progressDialog.dismiss();
                            Intent intent3=new Intent(Login_P.this,MainActivity.class);
                            startActivity(intent3);

                        }
                        else {
                            Toast.makeText(Login_P.this,"Login failed",Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    }
                });
    }
}
