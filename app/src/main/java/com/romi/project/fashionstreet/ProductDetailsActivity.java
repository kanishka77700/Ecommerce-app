package com.romi.project.fashionstreet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class ProductDetailsActivity extends AppCompatActivity {
Toolbar toolbar;
private ViewPager productpictureviewpager,productinteriordetailsviewpager;
private TabLayout indicatordottablayout,productinteriordetailstablayout;
private FloatingActionButton wishlishtbutton;
private static  Boolean ALREADY_IN_WISHLIST=false;
private LinearLayout ratestartlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        toolbar=findViewById(R.id.productdetailstoolbar);
        setSupportActionBar(toolbar);
      getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productpictureviewpager=findViewById(R.id.productpicturesviewpager);
        indicatordottablayout=findViewById(R.id.productpicturetablayout);
        productinteriordetailsviewpager=findViewById(R.id.productdetailsinteriorviewpager);
        productinteriordetailstablayout=findViewById(R.id.productdetailsinteriortablayout);
        indicatordottablayout.setupWithViewPager(productpictureviewpager,true);
        List<Integer> productpictures=new ArrayList<>();
        productpictures.add(R.drawable.horizontalscrollpic);
        productpictures.add(R.drawable.horizontalscrollpic);
        productpictures.add(R.drawable.horizontalscrollpic);
        productpictures.add(R.drawable.horizontalscrollpic);
        productpictures.add(R.drawable.horizontalscrollpic);
        productpictures.add(R.drawable.horizontalscrollpic);
        productpictures.add(R.drawable.donation2);
        ProductPictureAdapter productPictureAdapter=new ProductPictureAdapter(productpictures);
        productpictureviewpager.setAdapter(productPictureAdapter);
        wishlishtbutton=findViewById(R.id.wishlistfloatingActionButton);
        wishlishtbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ALREADY_IN_WISHLIST)
                {
                    ALREADY_IN_WISHLIST=false;
                    wishlishtbutton.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
                }
                else
                {
                    ALREADY_IN_WISHLIST=true;
                    final Animation animation=AnimationUtils.loadAnimation(v.getContext(),R.anim.bounce_animi);
                    wishlishtbutton.startAnimation(animation);
                    wishlishtbutton.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#FF1832")));

                }
            }
        });



        productinteriordetailsviewpager.setAdapter(new ProductInteriorDetailsViewTabAdapter(getSupportFragmentManager(),productinteriordetailstablayout.getTabCount()));
        productinteriordetailsviewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productinteriordetailstablayout));
        productinteriordetailstablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                productinteriordetailsviewpager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ///////////////////RateStar///////////////

              ratestartlayout=findViewById(R.id.RateStarsLayout);

              for(int i=0;i<ratestartlayout.getChildCount();i++)
              {

                  final int start = i;
                  ratestartlayout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          ratestar(start);
                      }

                      private void ratestar(int start) {


                          for (int j = 0; j <ratestartlayout.getChildCount(); j++) {
                              ImageView star = (ImageView) ratestartlayout.getChildAt(j);
                              star.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
                              if(j<=start)
                              {

                                  star.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));

                              }
                          }
                      }
                  });


        }

        ///////////////////RateStar///////////////

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.search_cart_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.search :
                       return true;
            case R.id.cart :
                      return true;
            case android.R.id.home :
                finish();
                return true;
        }
        return false;
    }
}
