package com.romi.project.fashionstreet;

public class ProductSpecificationModel  {



     public static final int SPECIFICATIONTITLE=0;
     public static final int SPECIFICATIONBODY=1;
     private int type;
     private String title;
/////////////////////SPECIFICATIONTITLES//////////////////////////

    public ProductSpecificationModel(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    /////////////////////SPECIFICATIONTITLES//////////////////////////
    ///////////////SpecificationBody////////////
    private String featurename,featurevalue;

    public ProductSpecificationModel(int type, String featurename, String featurevalue) {
        this.type = type;
        this.featurename = featurename;
        this.featurevalue = featurevalue;
    }

    public String getFeaturename() {
        return featurename;
    }

    public void setFeaturename(String featurename) {
        this.featurename = featurename;
    }

    public String getFeaturevalue() {
        return featurevalue;
    }

    public void setFeaturevalue(String featurevalue) {
        this.featurevalue = featurevalue;
    }

    ///////////////SpecificationBody////////////
}
