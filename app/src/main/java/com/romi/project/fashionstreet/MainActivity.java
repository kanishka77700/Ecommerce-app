package com.romi.project.fashionstreet;


import android.accounts.Account;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar,toolbar2;
    DrawerLayout drawerLayout;
    private TabLayout mainbottombartablayout;
    private ViewPager mainbottombarViewPager;
    private GoogleSignInClient googleSignInClient;
    private EditText mainSearch;
  private  FirebaseAuth firebaseAuth;
 private   FirebaseUser firebaseUser;
 private long backpressedtime;
 private Toast doubleback;
 GoogleSignInAccount account;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    TextView navfullname,navemail,textView;
    FrameLayout frameLayout;
    TabLayout botnavtab;
    BottomNavigationView bottomNavigationView;
    private FloatingActionButton mainCartFAB;
CircleImageView navphoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();


account =GoogleSignIn.getLastSignedInAccount(this);






        googleSignInClient =GoogleSignIn.getClient(this,GoogleSignInOptions.DEFAULT_SIGN_IN);


        toolbar = findViewById(R.id.toolbar);
        toolbar2=findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("StreetMart");




        navigationView = findViewById(R.id.nav_view);
        View headernavview=navigationView.getHeaderView(0);
        navfullname=(TextView)headernavview.findViewById(R.id.fullname);
        navphoto=headernavview.findViewById(R.id.navimage);

        if(firebaseUser!=null) {
            addNavDetails(firebaseUser.getDisplayName(),firebaseUser.getPhotoUrl().toString());

        }


        drawerLayout = findViewById(R.id.drawer_layout);
        frameLayout=findViewById(R.id.contentmain);
        mainSearch=findViewById(R.id.mainsearch);
        mainbottombartablayout=findViewById(R.id.bottonavtablayout);
        mainbottombarViewPager=findViewById(R.id.mainbottombarviewpager);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        mainCartFAB=findViewById(R.id.homefloatingactionbutton);
        mainSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            }
        });

      setFragment(new HomeFragment());

        toolbar.setTitleTextColor(ColorStateList.valueOf(Color.parseColor("#000000")));
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.syncState();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);



                } else {
                    drawerLayout.openDrawer(GravityCompat.START);

                }
            }
        });

        ////////////////////bottomBarTabAndViewPager//////////////////////

        mainbottombarViewPager.setCurrentItem(0);

          mainbottombartablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
              @Override
              public void onTabSelected(TabLayout.Tab tab) {
                mainbottombarViewPager.setCurrentItem(0);
                  int tabIconColor = ContextCompat.getColor(getBaseContext(), R.color.orange);
                  tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                 switch (tab.getPosition())
                 {
                     case 0 :  setFragment(new HomeFragment());
                     break;
                     case 3 :
                         Intent intent=new Intent(MainActivity.this,VideoActivity.class);
                          startActivity(intent);
                          break;
                 }


              }

              @Override
              public void onTabUnselected(TabLayout.Tab tab) {
                  int tabIconColor = ContextCompat.getColor(getBaseContext(), R.color.ash1);
                  tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

              }

              @Override
              public void onTabReselected(TabLayout.Tab tab) {

              }
          });


        ////////////////////bottomBarTabAndViewPager//////////////////////




    }

    private void addNavDetails(String displayName, String photoUrl) {

        navfullname.setText("Hello" + " " + displayName);

        if(!(photoUrl.isEmpty()))
        {
            Picasso.get().load(photoUrl).into(navphoto);

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.tool_items,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.cart :
                gotocart();
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }
    private void gotocart()
    {
       Intent intent=new Intent(MainActivity.this,CartActivity.class);
       startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mycart :
                gotocart();
                 return true;
            case R.id.signout:
                firebaseAuth.signOut();
googleSignInClient.signOut();
                finish();
                return true;


            case R.id.myaccount:
                Intent intent=new Intent(MainActivity.this,MyAccountFragment.class);
                startActivity(intent);
                return true;
        }



        return false;
    }

    private void  setFragment(Fragment fragment)
    {
        getSupportFragmentManager().beginTransaction().replace(frameLayout.getId(),fragment).commit();
    }




    }




