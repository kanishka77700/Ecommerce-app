package com.romi.project.fashionstreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAccountFragment extends AppCompatActivity {


    TextView profilename,profileemail;
    String profileurl;
    CircleImageView profilepic;
    FirebaseAuth firebaseAuth;
GoogleSignInClient googleSignInClient;
    FloatingActionButton settings;
    Button signout;

public  static  String fullnamestring,emailstring,mobilestring,addressstring,pincodestring,statestring;
    TextView firstname,email,mobile,address,pincode,state;

FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account_fragment);

        profileemail=findViewById(R.id.myaccountemailaddress);
        profilename=findViewById(R.id.myaccountfullname);
        profilepic=findViewById(R.id.profilepic);

        firebaseAuth=FirebaseAuth.getInstance();

        firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null)
        {

            profilename.setText(firebaseUser.getDisplayName());
            profileemail.setText(firebaseUser.getEmail());
            String url=firebaseUser.getPhotoUrl().toString();



            if(!(url.isEmpty()))
            {
                Picasso.get().load(url).into(profilepic);
            }



        }





        settings=findViewById(R.id.floatsettings);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(MyAccountFragment.this,Settings.class);
                startActivity(intent);

            }
        });
        firstname=findViewById(R.id.firstnamevalue);
        email=findViewById(R.id.emailvalue);
        mobile=findViewById(R.id.mobilevalue);
        address=findViewById(R.id.addressvalue);
        pincode=findViewById(R.id.pincodevalue);
        state=findViewById(R.id.statevalue);


    fullnamestring=getIntent().getStringExtra("name");
        emailstring=getIntent().getStringExtra("email");
        mobilestring=getIntent().getStringExtra("mobile");
        addressstring=getIntent().getStringExtra("address");
        pincodestring=getIntent().getStringExtra("pincode");
        statestring=getIntent().getStringExtra("state");



        firstname.setText(" " + firebaseUser.getDisplayName());
        email.setText(" " + firebaseUser.getEmail());
        String phoneno=firebaseUser.getPhoneNumber();
        if(phoneno!=null)
        {
            mobile.setText(" " + phoneno);
        }

            if(fullnamestring!=null) {
                firstname.setText(" " + fullnamestring);
            }
            if(emailstring!=null) {
                email.setText(" " + emailstring);
            }

        if(mobilestring!=null)
        {
            mobile.setText(" "  + mobilestring);
        }
        if(addressstring!=null)
        {
            address.setText(" "  + addressstring);
        }
        if(pincodestring!=null)
        {
            pincode.setText(" "  + pincodestring);
        }
        if(statestring!=null)
        {
            state.setText(" "  + statestring);
        }

        googleSignInClient = GoogleSignIn.getClient(this, GoogleSignInOptions.DEFAULT_SIGN_IN);
        signout=findViewById(R.id.signoututton);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                googleSignInClient.signOut();
                finish();
                Intent intent=new Intent(MyAccountFragment.this,OpenActivity.class);
                Toast.makeText(MyAccountFragment.this, "Successfully Logged out", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });


    }
}