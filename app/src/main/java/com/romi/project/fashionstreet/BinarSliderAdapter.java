package com.romi.project.fashionstreet;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class BinarSliderAdapter extends PagerAdapter {

    private List<BannerSliderModel> bannerSliderModelList;

    public BinarSliderAdapter(List<BannerSliderModel> bannerSliderModelList) {
        this.bannerSliderModelList = bannerSliderModelList;
    }


    @Override
    public int getCount() {
      return bannerSliderModelList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
      View view= LayoutInflater.from(container.getContext()).inflate(R.layout.banner_slider,container,false);
        ImageView bannerimage=view.findViewById(R.id.bannericons);
        LinearLayout bannerlayout=view.findViewById(R.id.bannerlayout);
    bannerlayout.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(bannerSliderModelList.get(position).getBannerbackgroundcolor())));
        Glide.with(container.getContext()).load(bannerSliderModelList.get(position).getBanners()).apply(new RequestOptions().placeholder(R.drawable.navhome)).into(bannerimage);

        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View)object);
    }
}
