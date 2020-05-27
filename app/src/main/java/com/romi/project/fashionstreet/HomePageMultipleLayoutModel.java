package com.romi.project.fashionstreet;

import java.util.List;

class HomePageMultipleLayoutModel {
    public static final int donation=0;
    public static final int stripad=1;
    public static final int horizontal_scroll_products=2;
    public static final int grid_view_items=3;
    public static final int bannerslider=4;
    public static final  int covidpic=5;
    public static final int categoryitems=6;
    private List<BannerSliderModel> bannerSliderModelList;
    private int type;
    private String n;
    private List<Category_Model> category_modelList;






    //////////////////CategoryItems/////////////////

    public HomePageMultipleLayoutModel(int type,List<Category_Model> category_modelList) {
        this.type = type;
        this.category_modelList = category_modelList;
    }

    public List<Category_Model> getCategory_modelList() {
        return category_modelList;
    }

    public void setCategory_modelList(List<Category_Model> category_modelList) {
        this.category_modelList = category_modelList;
    }
    //////////////////CategoryItems/////////////////

    //////////////Donation//////////////


    public HomePageMultipleLayoutModel(int type, String title) {
        this.type = type;
        this.title = title;
    }

    //////////////Donation//////////////
         //////////////BannerSlider///////////
         public HomePageMultipleLayoutModel(List<BannerSliderModel> bannerSliderModelList,int type) {
             this.bannerSliderModelList = bannerSliderModelList;
             this.type = type;
         }

    public List<BannerSliderModel> getBannerSliderModelList() {
        return bannerSliderModelList;
    }

    public void setBannerSliderModelList(List<BannerSliderModel> bannerSliderModelList) {
        this.bannerSliderModelList = bannerSliderModelList;
    }



    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    //////////////BannerSlider!/////////////////////
    ///////////////Stripad////////////

    private int resouce;
    private String backgroundcolor;

    public HomePageMultipleLayoutModel(int type, int resouce, String backgroundcolor) {
        this.resouce = resouce;
        this.backgroundcolor = backgroundcolor;
        this.type=type;
    }


    public int getResouce() {
        return resouce;
    }

    public void setResouce(int resouce) {
        this.resouce = resouce;
    }

    public String getBackgroundcolor() {
        return backgroundcolor;
    }

    public void setBackgroundcolor(String backgroundcolor) {
        this.backgroundcolor = backgroundcolor;
    }

    //////////////Stripad!/////////

    /////////////horizonatlscrollproducts////////////

   private String title;
    private List<HorizontalScrollProductModel> horizontalScrollProductModelList;

    public HomePageMultipleLayoutModel(int type, String title, List<HorizontalScrollProductModel> horizontalScrollProductModelList) {
        this.type = type;
        this.title = title;
        this.horizontalScrollProductModelList = horizontalScrollProductModelList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HorizontalScrollProductModel> getHorizontalScrollProductModelList() {
        return horizontalScrollProductModelList;
    }

    public void setHorizontalScrollProductModelList(List<HorizontalScrollProductModel> horizontalScrollProductModelList) {
        this.horizontalScrollProductModelList = horizontalScrollProductModelList;
    }
    /////////////horizonatlscrollproducts////////////


   ////////////////gridviewitems/////////////////////
  ////Same as like horizontalScrollview//////////


    ////////////////gridviewitems/////////////////////
    ////////////////covidpic/////////////////////

    public HomePageMultipleLayoutModel(int type, int resouce) {
        this.type = type;
        this.resouce = resouce;
    }



    ////////////////covidpic/////////////////////



}
