package com.smartalarm.new_maha;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forget_Password extends AppCompatActivity {
    private EditText forget_email;
    private Button reset_password;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget__password);

        forget_email=(EditText) findViewById(R.id.forget_email);
        reset_password=(Button) findViewById(R.id.reset_password);
        firebaseAuth=FirebaseAuth.getInstance();
        reset_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail=forget_email.getText().toString().trim();
                if (userEmail.equals("")){
                    Toast.makeText(Forget_Password.this,"Please enter your registation email address",Toast.LENGTH_LONG).show();
                }
                else {
                    firebaseAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Forget_Password.this,"Password reset email send",Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(Forget_Password.this,Login_P.class));
                            }
                            else {
                                Toast.makeText(Forget_Password.this,"error is sending password reset email",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
