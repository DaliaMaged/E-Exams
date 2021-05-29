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
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.e_exams.professor.CreateExams;
import com.example.e_exams.professor.homeActivityProfesor;
import com.example.e_exams.student.homeActivityStudent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login_tabFragment extends Fragment {
    EditText email;
    EditText pass;
    Button mLoginbtn;
    TextView forgetPass;
String type;
    private DatabaseReference mDatabase;
    FirebaseAuth mAuth;
    String usertype;
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
            mAuth=FirebaseAuth.getInstance();
            mAuth.signInWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        FirebaseUser user = mAuth.getCurrentUser();
                        String  uid = user.getUid();
                        System.out.println(uid);
                        mDatabase = FirebaseDatabase.getInstance().getReference().child("USERS").child(uid);


                        Toast.makeText(getActivity().getBaseContext(),"User Logged in",Toast.LENGTH_SHORT).show();

                        mDatabase.child("type").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull  DataSnapshot snapshot) {
type= (String) snapshot.getValue();

                                System.out.println(type);
                                if(type.equals("Doctor")) {
                                    Intent intent1= new Intent(getActivity(), homeActivityProfesor.class);
                                    intent1.putExtra("uid",uid);
                                    startActivity(intent1);
                                } else if (type.equals("Student")){
                                    Intent intent= new Intent(getActivity(), homeActivityStudent.class);
                                    intent.putExtra("uid",uid);
                                    startActivity(intent);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull  DatabaseError error) {
                                System.out.println("failed to get data from fire base");
                            }

                        });

                    }
                    else {
                        Toast.makeText(getActivity().getBaseContext(),"Error !" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });


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
