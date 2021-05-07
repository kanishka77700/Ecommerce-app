package com.romi.project.fashionstreet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.JsonObject;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CartActivity extends AppCompatActivity {


    RecyclerView cartrecyclerview;
    Toolbar toolbar;
    TextView totalamountfinal;
    Button continuecart;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        totalamountfinal=findViewById(R.id.carttotalamount);
       continuecart=findViewById(R.id.cart_continue);
       toolbar=findViewById(R.id.toolbar);
       firebaseAuth=FirebaseAuth.getInstance();
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

        continuecart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(CartActivity.this, Manifest.permission.READ_SMS)!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(CartActivity.this,new String[]{Manifest.permission.READ_SMS,Manifest.permission.RECEIVE_SMS},101);
                }
                final RequestQueue requestQueue= Volley.newRequestQueue(CartActivity.this);
                final String mid="FXrMuN47663889849159";
                final String customer_id= FirebaseAuth.getInstance().getUid();
                final String order_id= UUID.randomUUID().toString().substring(0,28);
                String url="https://streetmall.000webhostapp.com/Paytmappfile/generateChecksum.php";
                final String callback_url="https://pguat.paytm.com/paytmchecksum/paytmCallback.jsp";

                StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject=new JSONObject(response);

                            if(jsonObject.has("CHECKSUMHASH"))
                            {
                                String checksumhash=jsonObject.getString("CHECKSUMHASH");
                                PaytmPGService paytmPGService=PaytmPGService.getStagingService();
                                HashMap<String, String> paramMap = new HashMap<String,String>();
                                paramMap.put( "MID" , mid);
                                paramMap.put( "ORDER_ID" , order_id);
                                paramMap.put( "CUST_ID" , customer_id);
                                paramMap.put( "CHANNEL_ID" , "WAP");
                                paramMap.put( "TXN_AMOUNT" , totalamountfinal.getText().toString().substring(2,totalamountfinal.getText().toString().length()-2));
                                paramMap.put( "WEBSITE" , "WEBSTAGING");
                                paramMap.put( "INDUSTRY_TYPE_ID" , "Retail");

                                paramMap.put( "CALLBACK_URL", callback_url);
                                paramMap.put("CHECKSUMHASH",checksumhash);
                                PaytmOrder paytmOrder=new PaytmOrder(paramMap);
                                paytmPGService.initialize(paytmOrder,null);
                                paytmPGService.startPaymentTransaction(CartActivity.this, true, true, new PaytmPaymentTransactionCallback() {
                                    @Override
                                    public void onTransactionResponse(Bundle inResponse) {


                                        if(inResponse.getString("STATUS").equals("TXN_SUCCESS"))
                                        {
                                            String OrderId=inResponse.getString("ORDERID");
                                            Intent intent=new Intent(CartActivity.this,OrderPlaced.class);
                                            intent.putExtra("orderid",OrderId);
                                            startActivity(intent);




                                        }
                                    }

                                    @Override
                                    public void networkNotAvailable() {
                                        Toast.makeText(getApplicationContext(), "Network connection error: Check your internet connectivity", Toast.LENGTH_LONG).show();
                                    }

                                    @Override
                                    public void clientAuthenticationFailed(String inErrorMessage) {
                                        Toast.makeText(getApplicationContext(), "Authentication failed: Server error" + inErrorMessage.toString(), Toast.LENGTH_LONG).show();
                                    }

                                    @Override
                                    public void someUIErrorOccurred(String inErrorMessage) {
                                        Toast.makeText(getApplicationContext(), "UI Error " + inErrorMessage , Toast.LENGTH_LONG).show();

                                    }

                                    @Override
                                    public void onErrorLoadingWebPage(int iniErrorCode, String inErrorMessage, String inFailingUrl) {

                                        Toast.makeText(getApplicationContext(), "Unable to load webpage " + inErrorMessage.toString(), Toast.LENGTH_LONG).show();
                                    }

                                    @Override
                                    public void onBackPressedCancelTransaction() {
                                        Toast.makeText(getApplicationContext(), "Transaction cancelled" , Toast.LENGTH_LONG).show();

                                    }

                                    @Override
                                    public void onTransactionCancel(String inErrorMessage, Bundle inResponse) {
                                        Toast.makeText(getApplicationContext(), "Transaction cancelled" , Toast.LENGTH_LONG).show();


                                    }
                                });

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(CartActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> paramMap = new HashMap<String,String>();
                        paramMap.put( "MID" , mid);
                        paramMap.put( "ORDER_ID" , order_id);
                        paramMap.put( "CUST_ID" , customer_id);
                        paramMap.put( "CHANNEL_ID" , "WAP");
                        paramMap.put( "TXN_AMOUNT" , totalamountfinal.getText().toString().substring(2,totalamountfinal.getText().toString().length()-2));
                        paramMap.put( "WEBSITE" , "WEBSTAGING");
                        paramMap.put( "INDUSTRY_TYPE_ID" , "Retail");

                        paramMap.put( "CALLBACK_URL", callback_url);

                       return paramMap;
                    }
                };

                requestQueue.add(stringRequest);
            }
        });


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
