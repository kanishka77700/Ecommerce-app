package com.romi.project.fashionstreet;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ProductPictureAdapter extends PagerAdapter {
private List<Integer> productPictures;

    public ProductPictureAdapter(List<Integer> productPictures) {
        this.productPictures = productPictures;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView productpicture=new ImageView(container.getContext());
        productpicture.setImageResource(productPictures.get(position));
        container.addView(productpicture,0);
        return productpicture;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }

    @Override
    public int getCount() {
        return productPictures.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
