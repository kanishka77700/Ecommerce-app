package com.romi.project.fashionstreet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.Inflater;


public class HomeFragment extends Fragment {

    private RecyclerView CategoryItemsRecyclerView;
    public List<Category_Model> category_modelList;
    public   Category_Adapter category_adapter;
    private TabLayout bannerslidertablayout;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

         category_modelList = new ArrayList<>();



                category_modelList.add(new Category_Model("link", "Essentials"));
                category_modelList.add(new Category_Model("link", "Mobiles"));
                category_modelList.add(new Category_Model("link", "Fashion"));
                category_modelList.add(new Category_Model("link", "Electronics"));
                category_modelList.add(new Category_Model("link", "Beauty"));
                category_modelList.add(new Category_Model("link", "Appliances"));
                category_modelList.add(new Category_Model("link", "Toys"));
                category_modelList.add(new Category_Model("link", "Flights"));
                category_modelList.add(new Category_Model("link", "Insurance"));
                category_modelList.add(new Category_Model("link", "Sports"));







            /////Banner Slider Code//////

        List<BannerSliderModel> bannerSliderModelList;

        bannerSliderModelList = new ArrayList<>();
        bannerSliderModelList.add(new BannerSliderModel(R.drawable.navaccount,"#FF6347"));
        bannerSliderModelList.add(new BannerSliderModel(R.drawable.navcart,"#FF6347"));

        bannerSliderModelList.add(new BannerSliderModel(R.drawable.navwishlist,"#FF6347"));
        bannerSliderModelList.add(new BannerSliderModel(R.drawable.navmyrewards,"#FF6347"));
        bannerSliderModelList.add(new BannerSliderModel(R.drawable.navuser,"#FF6347"));
        bannerSliderModelList.add(new BannerSliderModel(R.drawable.navchooselang,"#FF6347"));
        bannerSliderModelList.add(new BannerSliderModel(R.drawable.navaccount,"#FF6347"));
        bannerSliderModelList.add(new BannerSliderModel(R.drawable.navcart,"#FF6347"));

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
        RecyclerView HomepageMultiplelayoutrecyclerview=view.findViewById(R.id.homepagemultiplelayoutrecylerview);
        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        HomepageMultiplelayoutrecyclerview.setLayoutManager(linearLayoutManager2);

        List<HomePageMultipleLayoutModel>homePageMultipleLayoutModelList=new ArrayList<>();
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(6,category_modelList));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(0,"India Unites to Fight COVID-19"));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(bannerSliderModelList,4));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(2,"Deals of the Day",horizontalScrollProductModelList));

        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(5,R.drawable.arogyasethuapp));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(3,"Top Brands",horizontalScrollProductModelList));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(1,R.drawable.strip_ad211,"#000000"));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(2,"Suggested for You",horizontalScrollProductModelList));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(3,"Personal and baby care",horizontalScrollProductModelList));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(1,R.drawable.strip_ad211,"#000000"));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(2,"Furniture",horizontalScrollProductModelList));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(3,"Electronics",horizontalScrollProductModelList));
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(2,"Top Brands",horizontalScrollProductModelList));


        HomePageMultipleLayoutAdapter homePageMultipleLayoutAdapter=new HomePageMultipleLayoutAdapter(homePageMultipleLayoutModelList);
        HomepageMultiplelayoutrecyclerview.setAdapter(homePageMultipleLayoutAdapter);
        homePageMultipleLayoutAdapter.notifyDataSetChanged();
        /////////HomePageMultipleLayoutRecycler/////////



        return view;

    }


}



