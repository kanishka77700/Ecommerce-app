package com.romi.project.fashionstreet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderPlaced extends AppCompatActivity {

    TextView orderidtext;
    ImageView continueshopping;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_placed);
orderidtext=findViewById(R.id.orderid);
continueshopping=findViewById(R.id.continueshoppingimage);

        Intent intent=getIntent();
        String orderid=intent.getStringExtra("orderid");
        orderidtext.setText(" Order id: " + orderid);
        continueshopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(OrderPlaced.this,HomeFragment.class);
                startActivity(intent1);
            }
        });

    }
}