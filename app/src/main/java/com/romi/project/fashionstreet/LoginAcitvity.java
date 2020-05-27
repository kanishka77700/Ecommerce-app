package com.romi.project.fashionstreet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginAcitvity extends AppCompatActivity {
    EditText emailid, password;
    TextView forgotpassword;
    CheckBox rememberme;
    Button signin;
    TextView donthaveanaccount;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser mFirebaseUser = firebaseAuth.getCurrentUser();
        if (mFirebaseUser != null) {
            Toast logintoast;
          logintoast=  Toast.makeText(this, "You are sucessfully logged in", Toast.LENGTH_SHORT);
          logintoast.show();

            Intent intent = new Intent(LoginAcitvity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acitvity);
        emailid = findViewById(R.id.emailid);
        password = findViewById(R.id.password);
        forgotpassword = findViewById(R.id.forgotpassword);
        signin = findViewById(R.id.signin);
        donthaveanaccount = findViewById(R.id.donthaveanaccount);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginAcitvity.this,ResetPassword.class);
                startActivity(intent);
                finish();
            }
        });






        donthaveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotocreate=new Intent(LoginAcitvity.this,SignUpActivity.class);
                Toast.makeText(LoginAcitvity.this, "Create yout Account here", Toast.LENGTH_SHORT).show();
                startActivity(gotocreate);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }

        });
    }
    public void Login()
    {
        String email = emailid.getText().toString().trim();
        String pass = password.getText().toString();
        if (TextUtils.isEmpty(email)) {
            emailid.setError("Please enter email id");
            emailid.requestFocus();
        } else if (TextUtils.isEmpty(pass)) {
            password.setError("Please enter Password");
            password.requestFocus();
        }
        else if ((TextUtils.isEmpty(email)  && (TextUtils.isEmpty(pass))))
        {
            emailid.setError("Please enter email id");
            password.setError("Please enter Password");

        }
        else {
            progressDialog.setTitle("Login");
            progressDialog.setMessage("Please wait ........Logging in");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            AccessAccount(email, pass);
        }
    }

  public void AccessAccount(final String email, final String pass) {

        firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(LoginAcitvity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(LoginAcitvity.this,"Incorrect Email or Password",Toast.LENGTH_SHORT).show();
                }
                else{
                    progressDialog.dismiss();
                    Intent intToHome = new Intent(LoginAcitvity.this,MainActivity.class);
                    startActivity(intToHome);
                }
            }
        });
    }

}
