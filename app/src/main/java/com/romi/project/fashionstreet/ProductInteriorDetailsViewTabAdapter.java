package com.romi.project.fashionstreet;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ProductInteriorDetailsViewTabAdapter extends FragmentStatePagerAdapter {

  private   int totalTabs;
    public ProductInteriorDetailsViewTabAdapter(@NonNull FragmentManager fm, int totalTabs) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.totalTabs=totalTabs;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0: ProductDescriptionFragment productDescriptionFragment=new ProductDescriptionFragment();
                   return productDescriptionFragment;
            case 1:
 ProductSpecificationFragment productSpecificationFragment=new ProductSpecificationFragment();
 return productSpecificationFragment;
            case 2:
                ProductDescriptionFragment productDescriptionFragment2=new ProductDescriptionFragment();
                return productDescriptionFragment2;
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
