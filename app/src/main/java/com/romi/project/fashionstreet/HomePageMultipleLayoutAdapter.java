package com.romi.project.fashionstreet;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageMultipleLayoutAdapter extends RecyclerView.Adapter {

    private List<HomePageMultipleLayoutModel> homePageMultipleLayoutModelList;

    public HomePageMultipleLayoutAdapter(List<HomePageMultipleLayoutModel> homePageMultipleLayoutModelList) {
        this.homePageMultipleLayoutModelList = homePageMultipleLayoutModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (homePageMultipleLayoutModelList.get(position).getType())
        {
            case 0: return HomePageMultipleLayoutModel.donation;
            case 1: return HomePageMultipleLayoutModel.stripad;
            case 2: return HomePageMultipleLayoutModel.horizontal_scroll_products;
            case 3: return HomePageMultipleLayoutModel.grid_view_items;
            case 4: return HomePageMultipleLayoutModel.bannerslider;
            case 5: return HomePageMultipleLayoutModel.covidpic;
            case 6: return HomePageMultipleLayoutModel.categoryitems;

        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType)
        {
            case HomePageMultipleLayoutModel.donation:
                return new DonationViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.donation,parent,false));

            case HomePageMultipleLayoutModel.stripad:

                return new StripAdViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.strip_ad,parent,false));
            case HomePageMultipleLayoutModel.horizontal_scroll_products:

                return new HorizontalScrollProductsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scrolling_view,parent,false));
            case HomePageMultipleLayoutModel.grid_view_items:

                return new GridViewItemsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view,parent,false));
            case HomePageMultipleLayoutModel.bannerslider:
                return new BannerSliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_slider_2,parent,false));
                case HomePageMultipleLayoutModel.covidpic:
                    return new CovidpicViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.covid19,parent,false));

                case HomePageMultipleLayoutModel.categoryitems:
                    return new CategoryItemsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.categoryitemsrecycler,parent,false));

        }

        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (homePageMultipleLayoutModelList.get(position).getType())
        {
            case HomePageMultipleLayoutModel.donation:
                String head=homePageMultipleLayoutModelList.get(position).getTitle();
                ((DonationViewHolder) holder).setDonationpic(head);
                break;

                case HomePageMultipleLayoutModel.stripad:
                    int resource=homePageMultipleLayoutModelList.get(position).getResouce();
                    String color=homePageMultipleLayoutModelList.get(position).getBackgroundcolor();
                    ((StripAdViewHolder)holder).setStripAd(resource,color);
                    break;
                    case HomePageMultipleLayoutModel.horizontal_scroll_products:
                        List<HorizontalScrollProductModel>horizontalScrollProductModelList=homePageMultipleLayoutModelList.get(position).getHorizontalScrollProductModelList();
                        String title=homePageMultipleLayoutModelList.get(position).getTitle();
                        ((HorizontalScrollProductsViewHolder) holder).setHorizScrollProducts(title,horizontalScrollProductModelList);
                        break;
                        case HomePageMultipleLayoutModel.grid_view_items:
                            List<HorizontalScrollProductModel> GridProductModelList=homePageMultipleLayoutModelList.get(position).getHorizontalScrollProductModelList();
                            String GridLayoutTitle=homePageMultipleLayoutModelList.get(position).getTitle();
                            ((GridViewItemsViewHolder) holder).setGridViewItems(GridProductModelList,GridLayoutTitle);
                            break;
                            case HomePageMultipleLayoutModel.bannerslider:
                                List<BannerSliderModel> bannerSliderModelList=homePageMultipleLayoutModelList.get(position).getBannerSliderModelList();
                                ((BannerSliderViewHolder) holder).setBannersliderviewpager(bannerSliderModelList);
                                break;
                                case HomePageMultipleLayoutModel.covidpic:
                                    int image=homePageMultipleLayoutModelList.get(position).getResouce();
                                    ((CovidpicViewHolder) holder).setCovidpic(image);
                                   break;
                                   case HomePageMultipleLayoutModel.categoryitems:
                                       List<Category_Model> category_modelList=homePageMultipleLayoutModelList.get(position).getCategory_modelList();
                                       ((CategoryItemsViewHolder)holder).setCategoryItems(category_modelList);
                                       break;


        }

    }

    @Override
    public int getItemCount() {
        return homePageMultipleLayoutModelList.size();
    }

    public class StripAdViewHolder extends RecyclerView.ViewHolder {
        private ImageView stripAdImage;
        private ConstraintLayout stripAdLayout;
        public StripAdViewHolder(View itemView) {
            super(itemView);
            stripAdImage =itemView.findViewById(R.id.stripadicon);
            stripAdLayout=itemView.findViewById(R.id.stripadlayout);
        }
        public void setStripAd(int resouce,String color)
        {
            stripAdImage.setImageResource(resouce);
            stripAdLayout.setBackgroundColor(Color.parseColor(color));
        }
    }

    public class HorizontalScrollProductsViewHolder extends RecyclerView.ViewHolder {
        private TextView horizScrollDeals;
        private Button horizScrollViewAll;
        private RecyclerView horizScrollViewRecycler;
        public HorizontalScrollProductsViewHolder(View itemView) {
            super(itemView);
            horizScrollViewRecycler=itemView.findViewById(R.id.horizontalScrollRecyclerview);
            horizScrollDeals=itemView.findViewById(R.id.horizntal_Scroll_Deals);
            horizScrollViewAll=itemView.findViewById(R.id.horizontalscrollViewall);
        }
        private void setHorizScrollProducts(String title,List<HorizontalScrollProductModel> horizontalScrollProductModelList)
        {
            horizScrollDeals.setText(title);

            if(horizontalScrollProductModelList.size()>8)
            {
                horizScrollViewAll.setVisibility(View.VISIBLE);
            }
            else
            {
                horizScrollViewAll.setVisibility(View.INVISIBLE);
            }

            HorizontalScrollProductAdapter horizontalScrollProductAdapter=new HorizontalScrollProductAdapter(horizontalScrollProductModelList);
            LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(itemView.getContext());
            linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
            horizScrollViewRecycler.setLayoutManager(linearLayoutManager1);

            horizScrollViewRecycler.setAdapter(horizontalScrollProductAdapter);
            horizontalScrollProductAdapter.notifyDataSetChanged();
        }
    }

    public class GridViewItemsViewHolder extends RecyclerView.ViewHolder {
        private  TextView gridViewLayoutTitle;
        private Button gridViewLayoutViewAll;
        private GridView itemsGridView;
        public GridViewItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            gridViewLayoutTitle=itemView.findViewById(R.id.gridViewTopBrands);
            gridViewLayoutViewAll=itemView.findViewById(R.id.gridViewViewAll);
            itemsGridView=itemView.findViewById(R.id.itemsGridView);
        }
        private void setGridViewItems(List<HorizontalScrollProductModel>horizontalScrollProductModelList,String title)
        {
            gridViewLayoutTitle.setText(title);
            itemsGridView.setAdapter(new GridViewItemsAdapter(horizontalScrollProductModelList));

        }
    }

    public class BannerSliderViewHolder extends RecyclerView.ViewHolder {

        private ViewPager bannersliderviewpager;
        public int currentbanner = 2;
        final private int DELAYTIME = 2000;
        final private int PEROIDTIME = 2000;
        private Timer timer;

        public BannerSliderViewHolder(View itemView) {
            super(itemView);
            bannersliderviewpager=itemView.findViewById(R.id.bannersliderviewpager);

        }
        public void setBannersliderviewpager (final List<BannerSliderModel> bannerSliderModelList){

            bannersliderviewpager.setCurrentItem(currentbanner);
            bannersliderviewpager.setAdapter(new BinarSliderAdapter(bannerSliderModelList));
            bannersliderviewpager.setPageMargin(20);
            bannersliderviewpager.setClipToPadding(false);

            bannersliderviewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    currentbanner = position;
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    if (state == ViewPager.SCROLL_STATE_IDLE) {
                        bannerLooper(bannerSliderModelList);
                    }
                }
            });
            startBannerSliderTimer(bannerSliderModelList);
            bannersliderviewpager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    bannerLooper(bannerSliderModelList);
                    stopBannerSliderTimer();
                    if(event.getAction()==MotionEvent.ACTION_UP)
                    {
                        startBannerSliderTimer(bannerSliderModelList);
                    }
                    return false;
                }
            });





        }
        public void bannerLooper(final List<BannerSliderModel> bannerSliderModelList) {
            if (currentbanner == bannerSliderModelList.size() - 2) {
                currentbanner = 2;
                bannersliderviewpager.setCurrentItem(currentbanner, false);
            } else if (currentbanner == 1) {
                currentbanner = bannerSliderModelList.size() - 3;
                bannersliderviewpager.setCurrentItem(currentbanner, false);
            }
        }
        private void startBannerSliderTimer(final List<BannerSliderModel> bannerSliderModelList) {

            final Handler handler=new Handler();
            final Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    if(currentbanner > bannerSliderModelList.size())
                    {
                        currentbanner=1;
                    }
                    bannersliderviewpager.setCurrentItem(currentbanner++);
                }
            };
            timer=new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(runnable);
                }
            },DELAYTIME,PEROIDTIME);

        }
        private void stopBannerSliderTimer()
        {
            timer.cancel();
        }

    }

    public class CovidpicViewHolder extends RecyclerView.ViewHolder {
        private ImageView covidpic;
        public CovidpicViewHolder(@NonNull View itemView) {
            super(itemView);
            covidpic=itemView.findViewById(R.id.covid19pic);


        }
        private void setCovidpic(int image)
        {
            covidpic.setImageResource(image);
            covidpic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=nic.goi.aarogyasetu&hl=en_IN"));
                    itemView.getContext().startActivity(intent);

                }
            });
        }

    }

    public class DonationViewHolder extends RecyclerView.ViewHolder {
        private TextView donationHead;
        private Button donatenow;
        public DonationViewHolder(@NonNull View itemView) {
            super(itemView);
            donationHead=itemView.findViewById(R.id.donationhead);
            donatenow=itemView.findViewById(R.id.donatenowbutton);


        }
        private void setDonationpic(String head)
        {
            donationHead.setText(head);
            donatenow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(itemView.getContext(),DonationPage.class);
                    itemView.getContext().startActivity(intent);
                }
            });
        }


    }
    public class CategoryItemsViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView CategoryItemsRecyclerView;
        public   Category_Adapter category_adapter;
        public CategoryItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            CategoryItemsRecyclerView = itemView.findViewById(R.id.categories_recyclerview);

        }

        private void setCategoryItems(List<Category_Model>category_modelList)
        {


            LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager4.setOrientation(LinearLayoutManager.HORIZONTAL);
            CategoryItemsRecyclerView.setLayoutManager(linearLayoutManager4);
            category_adapter = new Category_Adapter(category_modelList);
            CategoryItemsRecyclerView.setAdapter(category_adapter);
            category_adapter.notifyDataSetChanged();

        }
    }
}
