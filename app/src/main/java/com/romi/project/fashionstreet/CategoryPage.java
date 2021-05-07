package com.romi.project.fashionstreet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class CategoryPage extends AppCompatActivity {
Toolbar categorytoolbar;
RecyclerView categoryPageRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);
        categorytoolbar=findViewById(R.id.categorypagetoolbar);
        setSupportActionBar(categorytoolbar);
        String categoryname=getIntent().getStringExtra("categoryname");
        getSupportActionBar().setTitle(categoryname);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        categoryPageRecyclerView=findViewById(R.id.categoryrecyclerview);

        /////Banner Slider Code//////
        List<BannerSliderModel> bannerSliderModelList;


        /////Banner Slider Code//////*


        //////// horitonal srcoll view //////

        List<HorizontalScrollProductModel> horizontalScrollProductModelList=new ArrayList<>();
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));


        //////Horizontal Scroll view/////*


        ////////////HomePageMultiplelayoutRecyclerview//////////////////

        List<HomePageMultipleLayoutModel>homePageMultipleLayoutModelList=new ArrayList<>();
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this);
        categoryPageRecyclerView.setLayoutManager(linearLayoutManager3);
      //  homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(1,R.drawable.strip_ad211,"#000000"));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(2,"Deals of the Day",horizontalScrollProductModelList));
       // homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(bannerSliderModelList,4));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(3,"Top Brands",horizontalScrollProductModelList));
     //   homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(1,R.drawable.strip_ad211,"#000000"));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(2,"Suggested for You",horizontalScrollProductModelList));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(3,"Personal and baby care",horizontalScrollProductModelList));
      //  homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(1,R.drawable.strip_ad211,"#000000"));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(2,"Furniture",horizontalScrollProductModelList));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(3,"Electronics",horizontalScrollProductModelList));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(2,"Top Brands",horizontalScrollProductModelList));


        HomePageMultipleLayoutAdapter homePageMultipleLayoutAdapter=new HomePageMultipleLayoutAdapter(homePageMultipleLayoutModelList);
        categoryPageRecyclerView.setAdapter(homePageMultipleLayoutAdapter);
        homePageMultipleLayoutAdapter.notifyDataSetChanged();
        /////////HomePageMultipleLayoutRecycler/////////

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.categorytoolbaritems,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.search : return true;
            case android.R.id.home : finish();
            return true;
        }
        return false;
    }
}
