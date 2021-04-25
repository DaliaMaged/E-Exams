package com.example.e_exams;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class signUp_tabFragment extends Fragment {
    EditText email;
    EditText pass;
    EditText name;
    Button btn;
    CheckBox showPassword;
    RadioGroup radioGroup;

    FirebaseAuth mAuth;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sign_up_tab_fragment, container, false);
        email=rootView.findViewById(R.id.email);
        pass=rootView.findViewById(R.id.password);

        name=rootView.findViewById(R.id.name);
        btn=rootView.findViewById(R.id.signup_button);
        showPassword=rootView.findViewById(R.id.showPass);
        radioGroup=rootView.findViewById(R.id.radioGroup);
        mAuth = FirebaseAuth.getInstance();


//show password check box
        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
//sign up button
        btn.setOnClickListener((View v) -> {

    String Email= email.getText().toString().trim();
    String password= pass.getText().toString().trim();
    String Name= name.getText().toString().trim();

    if(Name.isEmpty()){
        name.setError("Name is Required");
        name.requestFocus();
        return;
    }
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

    mAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful()){
                User user=new User(Name,Email,password);

                Toast.makeText(getActivity().getBaseContext(),"User Created",Toast.LENGTH_SHORT).show();

            }
            else {
                Toast.makeText(getActivity().getBaseContext(),"Error !" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    });
//radio button
          int checkId=radioGroup.getCheckedRadioButtonId();
          if(checkId==-1){
             Toast.makeText(getActivity().getBaseContext(),"Select an Item ",Toast.LENGTH_SHORT).show();
         }
           else {
               findRadioButtton(checkId);
           }

       });

        return rootView;
}

    private void findRadioButtton(int checkId) {
        switch (checkId) {
            case R.id.radioProf:
                Intent intent = new Intent(getActivity().getBaseContext(), signProfessor.class);
                startActivity(intent);
                break;
            case R.id.radioStudent:
                Intent intent2 = new Intent(getActivity().getBaseContext(), signStudent.class);
                startActivity(intent2);
                break;
        }

    }
}
