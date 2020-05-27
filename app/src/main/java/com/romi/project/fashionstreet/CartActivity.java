package com.romi.project.fashionstreet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {


    RecyclerView cartrecyclerview;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


       toolbar=findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
       getSupportActionBar().setTitle("My Cart");
        toolbar.setTitleTextColor(ColorStateList.valueOf(Color.parseColor("#000000")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cartrecyclerview=findViewById(R.id.cartrecyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartrecyclerview.setLayoutManager(linearLayoutManager);

        List<CartItemsModel> cartItemsModelList=new ArrayList<>();
        cartItemsModelList.add(new CartItemsModel(0,R.drawable.phone22,"Realme 6 (Comet Blue, 128 GB)",2,"₹ 49,999/-","₹ 59,999/-",2,0,1));
        cartItemsModelList.add(new CartItemsModel(0,R.drawable.phone22,"Realme 6 (Comet Blue, 128 GB)",2,"₹ 49,999/-","₹ 59,999/-",2,0,1));
        cartItemsModelList.add(new CartItemsModel(0,R.drawable.phone22,"Realme 6 (Comet Blue, 128 GB)",2,"₹ 49,999/-","₹ 59,999/-",2,0,1));
        cartItemsModelList.add(new CartItemsModel(1,"Price(2 items)","₹ 49,999/-","Free","₹ 49,999/-","You will save 10,000/- on this order"));
        CartItemsAdapter cartItemsAdapter=new CartItemsAdapter(cartItemsModelList);

        cartrecyclerview.setAdapter(cartItemsAdapter);
        cartItemsAdapter.notifyDataSetChanged();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.search,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.search :
                return true;

            case android.R.id.home :
                finish();
                return true;
        }
        return false;
    }
}
