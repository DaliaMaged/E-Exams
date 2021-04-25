package com.example.e_exams;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login_tabFragment extends Fragment {
    EditText email;
    EditText pass;
    Button mLoginbtn;
    TextView forgetPass;
    FirebaseAuth mAuth;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login_tab_fragment, container, false);



        email=rootView.findViewById(R.id.email);
        pass=rootView.findViewById(R.id.password);
        mLoginbtn=rootView.findViewById(R.id.login_button);
        forgetPass=rootView.findViewById(R.id.forgetPassword);
        mAuth = FirebaseAuth.getInstance();

        mLoginbtn.setOnClickListener((View v) -> {

            String Email=email.getText().toString().trim();
            String password= pass.getText().toString().trim();


            if(password.isEmpty()){
                pass.setError("Password is Required");
                pass.requestFocus();
                return;
            }
            if(Email.isEmpty()){
                email.setError("Email is Required");
                email.requestFocus();

                return;
            }
            if(password.length()<7){
                pass.setError("Password must be 7 characters or more");
            }

            mAuth.signInWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        FirebaseUser user = mAuth.getCurrentUser();

                        Toast.makeText(getActivity().getBaseContext(),"User Logged in",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getContext(),user_created.class));

                    }
                    else {
                        Toast.makeText(getActivity().getBaseContext(),"Error !" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });

//            //forget pass
//            switch (v.getId()){
//                case R.id.login_button:
//                    getActivity().getBaseContext();
//                break;
//                case R.id.forgetPassword:
//                    startActivity(new Intent(getActivity().getBaseContext(),forgetPasswordActivity.class));
//            }

        });
        //forget password
        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getBaseContext(),forgetPasswordActivity.class));
            }
        });

        return rootView;
    }}
