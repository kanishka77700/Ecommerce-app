package com.romi.project.fashionstreet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {
EditText emailatreset;
Button resetpassword;
FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        emailatreset=findViewById(R.id.emailatreset);
        resetpassword=findViewById(R.id.resetpassword);
        firebaseAuth=FirebaseAuth.getInstance();
        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ResetPassword(view);
            }
        });

    }
    public void ResetPassword(final View view)
    {
        final String email=emailatreset.getText().toString().trim();
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                if (task.isSuccessful())
                {
                  Snackbar.make(view,"Link has been sent your Email",Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    emailatreset.setError("Incorrect EmailId");
                    emailatreset.requestFocus();
                }

            }
        });
    }
}
