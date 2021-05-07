package com.romi.project.fashionstreet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    EditText emailid,firstname,mobileno,password,confirmpassword;
    Button createaccount;
    TextView haveanaccount;
    ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        emailid=findViewById(R.id.registerdemailid);
        confirmpassword=findViewById(R.id.registerconfirmpassword);
        firstname=findViewById(R.id.registerfirstname);
        mobileno=findViewById(R.id.mobileno);
        password=findViewById(R.id.registeredpassword);
        createaccount=findViewById(R.id.createaccount);
        haveanaccount=findViewById(R.id.haveanaccount);
        progressDialog= new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        haveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goback=new Intent(SignUpActivity.this,LoginAcitvity.class);
                Toast.makeText(SignUpActivity.this,"You can Login here",Toast.LENGTH_LONG).show();
                startActivity(goback);
            }
        });
        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailid.getText().toString().trim();
                String mobile=mobileno.getText().toString().trim();
                String pass=password.getText().toString();
                String cpass=confirmpassword.getText().toString();
                if(TextUtils.isEmpty(email))
                {
                    emailid.setError("Please enter email id");
                    emailid.requestFocus();
                }
                else if(TextUtils.isEmpty(cpass))
                {
                    confirmpassword.setError("Please enter Confirm Password");
                    confirmpassword.requestFocus();
                }
                else if((TextUtils.isEmpty(cpass)) && (TextUtils.isEmpty(email))) {
                    confirmpassword.setError("Please enter Full name");
                    emailid.setError("Please enter email id");
                    emailid.requestFocus();
                    confirmpassword.requestFocus();
                }

                else if(TextUtils.isEmpty(mobile))
                {
                    mobileno.setError("Please enter Mobile no");
                    mobileno.requestFocus();
                }
                else if((TextUtils.isEmpty(mobile)) && (TextUtils.isEmpty(cpass))) {
                    mobileno.setError("Please enter Mobile no");
                    confirmpassword.setError("Please enter Confirm Password");
                    mobileno.requestFocus();
                    confirmpassword.requestFocus();
                }

                else  if(TextUtils.isEmpty(pass))
                {
                    password.setError("Please enter Password");
                    password.requestFocus();
                }
                else if((TextUtils.isEmpty(mobile)) && (TextUtils.isEmpty(pass))) {
                    mobileno.setError("Please enter Mobile no");
                    password.setError("Please enter Password");
                    password.requestFocus();
                    mobileno.requestFocus();
                }
                else if(pass.length()<8)
                {
                    password.setError("Atleast 8 Characters");
                    password.requestFocus();
                }
                else if(!(pass.equals(cpass)))
                {
                    confirmpassword.setError("Please enter valid Password");
                    confirmpassword.requestFocus();
                }
                else
                {
                    progressDialog.setTitle("Create Account");
                    progressDialog.setMessage("please wait your account is creating...");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();
                    Authentication(email,pass);

                }

            }

            private void Authentication(String email, String pass) {
                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Your Account has been Created Successfully",Toast.LENGTH_LONG).show();
                            finish();
                            startActivity(new Intent(SignUpActivity.this,LoginAcitvity.class));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Network Error",Toast.LENGTH_LONG).show();
                        }


                    }
                });
            }


        });
    }
}
