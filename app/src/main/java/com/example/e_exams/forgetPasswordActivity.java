package com.example.e_exams;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgetPasswordActivity extends AppCompatActivity {
EditText enterEmail;
Button resetPassword;
FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        enterEmail=findViewById(R.id.enter_email);
        resetPassword=findViewById(R.id.resetBtn);
        mAuth=FirebaseAuth.getInstance();

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=enterEmail.getText().toString().trim();

                if(Email.isEmpty()){
                    enterEmail.setError("Email is Required");
                    enterEmail.requestFocus();

                    return;
                }
            mAuth.sendPasswordResetEmail(Email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(forgetPasswordActivity.this,"Check your Email to reset password",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(forgetPasswordActivity.this,"Try again Something went wrong",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            }
        });
    }


}