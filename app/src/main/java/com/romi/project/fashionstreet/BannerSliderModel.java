package com.romi.project.fashionstreet;

public class BannerSliderModel {

    private String banners;
    private String bannerbackgroundcolor;

    public BannerSliderModel(String banners, String bannerbackgroundcolor) {
        this.banners = banners;
        this.bannerbackgroundcolor = bannerbackgroundcolor;
    }

    public String getBanners() {
        return banners;
    }

    public void setBanners(String banners) {
        this.banners = banners;
    }

    public String getBannerbackgroundcolor() {
        return bannerbackgroundcolor;
    }

    public void setBannerbackgroundcolor(String bannerbackgroundcolor) {
        this.bannerbackgroundcolor = bannerbackgroundcolor;
    }
}
