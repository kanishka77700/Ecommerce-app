package com.romi.project.fashionstreet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Settings extends AppCompatActivity {

FirebaseUser firebaseUser;
FirebaseAuth firebaseAuth;
    EditText firstname,email,mobile,address,pincode,state;
    Button save;
    String fullnamestring,emailstring,mobilestring,addressstring,pincodestring,statestring;
    CircleImageView pic;
    ArrayList<String> detailsarray;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
firebaseAuth=FirebaseAuth.getInstance();
firebaseUser=firebaseAuth.getCurrentUser();
        pic=findViewById(R.id.profilepicinsetings);
if(firebaseUser!=null)
{

    String url=firebaseUser.getPhotoUrl().toString();
    Picasso.get().load(url).into(pic);
}

        firstname=findViewById(R.id.editTextTextfirstname);
        email=findViewById(R.id.editTextemail);
        mobile=findViewById(R.id.editTextphone);
        address=findViewById(R.id.editTextTextAddress);
        pincode=findViewById(R.id.editTextpincode);
        state=findViewById(R.id.editTextstate);

        save=findViewById(R.id.save);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog=new ProgressDialog(Settings.this);
                progressDialog.setTitle("Saving");
progressDialog.setMax(100);
                progressDialog.show();

                fullnamestring=firstname.getText().toString();
                emailstring=email.getText().toString();

                mobilestring=mobile.getText().toString();
                addressstring=address.getText().toString();


                pincodestring=pincode.getText().toString();
                statestring=state.getText().toString();




                    Intent intent=new Intent(Settings.this,MyAccountFragment.class);
               MyAccountFragment.fullnamestring=fullnamestring;

             intent.putExtra("name",fullnamestring);
                intent.putExtra("email",emailstring);
                intent.putExtra("mobile",mobilestring);
                intent.putExtra("address",addressstring);
                intent.putExtra("pincode",pincodestring);
                intent.putExtra("state",statestring);
                progressDialog.dismiss();
                      finish();
                    startActivity(intent);







                }


        });






    }
}