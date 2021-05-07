package com.romi.project.fashionstreet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.telecom.Call;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static android.provider.ContactsContract.Intents.Insert.EMAIL;
import static com.romi.project.fashionstreet.R.*;

public class LoginAcitvity extends AppCompatActivity {
    EditText emailid, password;
    TextView forgotpassword;
    CheckBox rememberme;
    Button signin,googlesignin;
    Button signupbutton;
    CallbackManager callbackManager;
    boolean facebookuses=false;
    private AccessTokenTracker accessTokenTracker;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN=100;
    private LoginButton facebookloginButton;

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser mFirebaseUser = firebaseAuth.getCurrentUser();
        if (mFirebaseUser != null) {

            Intent intent=new Intent(LoginAcitvity.this,MainActivity.class);

            startActivity(intent);



        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_login_acitvity);
        emailid = findViewById(id.emailid);
        password = findViewById(id.password);
        forgotpassword = findViewById(id.forgotpassword);
        signin = findViewById(id.signin);
        signupbutton = findViewById(id.donthaveanaccount);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        facebookloginButton=findViewById(id.facebooklogin_button);
        FacebookSdk.sdkInitialize(getApplicationContext());



        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginAcitvity.this,ResetPassword.class);
                startActivity(intent);
                finish();
            }
        });






        signupbutton.setOnClickListener(new View.OnClickListener() {
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

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount lastaccount=GoogleSignIn.getLastSignedInAccount(this);
          googlesignin=findViewById(id.googlesigninbutton);

         googlesignin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 signIn();
             }
         });






       facebookloginButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               facebookuses=true;

               LoginManager.getInstance().logOut();
               callbackManager= CallbackManager.Factory.create();
               LoginManager.getInstance().logInWithReadPermissions(LoginAcitvity.this,Arrays.asList("email","public_profile"));
               LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                   @Override
                   public void onSuccess(LoginResult loginResult) {
                       handleFacebookToken(loginResult.getAccessToken());

                   }

                   @Override
                   public void onCancel() {

                   }

                   @Override
                   public void onError(FacebookException error) {
                       Toast.makeText(LoginAcitvity.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();

                   }
               });
           }
       });

    }


    private void handleFacebookToken(AccessToken accessToken)
    {
        AuthCredential credential= FacebookAuthProvider.getCredential(accessToken.getToken());
firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {

        if(task.isSuccessful()) {

         FirebaseUser user=   firebaseAuth.getCurrentUser();
            Intent intent=new Intent(LoginAcitvity.this,MainActivity.class);

            startActivity(intent);

        }
        else
        {
            Toast.makeText(LoginAcitvity.this,"Something error",Toast.LENGTH_LONG).show();
        }

    }
});


    }




    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==RC_SIGN_IN) {

                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                try {
                    // Google Sign In was successful, authenticate with Firebase
                    GoogleSignInAccount account = task.getResult(ApiException.class);
                    firebaseAuthWithGoogle(account.getIdToken());
                } catch (ApiException e) {
                    // Google Sign In failed, update UI appropriately
                    e.printStackTrace();
                }
            }
        else
        {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            finish();
                            Intent intent=new Intent(LoginAcitvity.this,MainActivity.class);

                            startActivity(intent);

                        } else {
                            Toast.makeText(LoginAcitvity.this, "Sign in activity failure", Toast.LENGTH_SHORT).show();
                        }
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
