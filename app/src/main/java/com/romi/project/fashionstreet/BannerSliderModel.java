package com.romi.project.fashionstreet;

public class BannerSliderModel {

    private int banners;
    private String bannerbackgroundcolor;

    public BannerSliderModel(int banners, String bannerbackgroundcolor) {
        this.banners = banners;
        this.bannerbackgroundcolor = bannerbackgroundcolor;
    }

    public int getBanners() {
        return banners;
    }

    public void setBanners(int banners) {
        this.banners = banners;
    }

    public String getBannerbackgroundcolor() {
        return bannerbackgroundcolor;
    }

    public void setBannerbackgroundcolor(String bannerbackgroundcolor) {
        this.bannerbackgroundcolor = bannerbackgroundcolor;
    }
}
