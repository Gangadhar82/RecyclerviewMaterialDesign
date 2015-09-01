package com.mmadapps.recyclerviewmaterialdesign;

/**
 * Created by gangadhar.g on 8/26/2015.
 */
public class ItemData {


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    private String title,title1;
    private int imageUrl;

    public ItemData(String title,String title1,int imageUrl){

        this.title = title;
        this.title1=title1;
        this.imageUrl = imageUrl;
    }
    // getters & setters
}
