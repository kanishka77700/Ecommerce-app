package com.romi.project.fashionstreet;

public class Category_Model
{
String categoryiconlink, categorytext;


    public Category_Model(String categoryiconlink, String categorytext) {
        this.categoryiconlink = categoryiconlink;
        this.categorytext = categorytext;
    }

    public String getCategoryiconlink() {
        return categoryiconlink;
    }

    public String getCategorytext() {
        return categorytext;
    }

    public void setCategoryiconlink(String categoryiconlink) {
        this.categoryiconlink = categoryiconlink;
    }

    public void setCategorytext(String categorytext) {
        this.categorytext = categorytext;
    }
}
