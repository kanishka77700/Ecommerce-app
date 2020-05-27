package com.romi.project.fashionstreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OpenActivity extends AppCompatActivity {
Button register,login;
private long backpressedtime;
private Toast doubleback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        register=findViewById(R.id.register);
        login=findViewById(R.id.login);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OpenActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(OpenActivity.this,LoginAcitvity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(backpressedtime+2000> System.currentTimeMillis())
        {
            doubleback.cancel();
            super.onBackPressed();
        }
        else
        {
            doubleback =  Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            doubleback.show();
        }
        backpressedtime=System.currentTimeMillis();
    }
}
