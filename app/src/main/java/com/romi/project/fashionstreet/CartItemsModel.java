package com.romi.project.fashionstreet;

public class CartItemsModel {

    public static final int cart_Product_details=0;
    public static final int cart_Product_price_details=1;



    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    ///////////////////////CartProductitems//////////////////
    private int productimage;
    private String producttitle;
    private int noofoffersavailable;
    private String productprice;
    private String productcuttedprice;
    private int offerapplied;
    private int coupensapplied;
    private int productquantity;

    public CartItemsModel(int type, int productimage, String producttitle, int noofoffersavailable, String productprice, String productcuttedprice, int  offerapplied, int  coupensapplied, int productquantity) {
        this.type = type;
        this.productimage = productimage;
        this.producttitle = producttitle;
        this.noofoffersavailable = noofoffersavailable;
        this.productprice = productprice;
        this.productcuttedprice = productcuttedprice;
        this.offerapplied = offerapplied;
        this.coupensapplied = coupensapplied;
        this.productquantity = productquantity;
    }

    public int getProductimage() {
        return productimage;
    }

    public void setProductimage(int productimage) {
        this.productimage = productimage;
    }

    public String getProducttitle() {
        return producttitle;
    }

    public void setProducttitle(String producttitle) {
        this.producttitle = producttitle;
    }

    public int getNoofoffersavailable() {
        return noofoffersavailable;
    }

    public void setNoofoffersavailable(int noofoffersavailable) {
        this.noofoffersavailable = noofoffersavailable;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public String getProductcuttedprice() {
        return productcuttedprice;
    }

    public void setProductcuttedprice(String productcuttedprice) {
        this.productcuttedprice = productcuttedprice;
    }

    public int getOfferapplied() {
        return offerapplied;
    }

    public void setOfferapplied(int offerapplied) {
        this.offerapplied = offerapplied;
    }

    public int getCoupensapplied() {
        return coupensapplied;
    }

    public void setCoupensapplied(int coupensapplied) {
        this.coupensapplied = coupensapplied;
    }

    public int getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(int productquantity) {
        this.productquantity = productquantity;
    }

    ///////////////////////CartProductitems//////////////////

//////////////////////////cartpricedetails///////////////////

    private String totalitems;
    private String totalprice;
    private String deliverycharges;
    private String totalamount;
    private String savedamount;

    public CartItemsModel(int type, String totalitems, String totalprice, String deliverycharges, String totalamount, String savedamount) {
        this.type = type;
        this.totalitems = totalitems;
        this.totalprice = totalprice;
        this.deliverycharges = deliverycharges;
        this.totalamount = totalamount;
        this.savedamount = savedamount;
    }

    public String gettotalitems() {
        return totalitems;
    }

    public void settotalitems(String nooditems) {
        this.totalitems = nooditems;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getDeliverycharges() {
        return deliverycharges;
    }

    public void setDeliverycharges(String deliverycharges) {
        this.deliverycharges = deliverycharges;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getSavedamount() {
        return savedamount;
    }

    public void setSavedamount(String savedamount) {
        this.savedamount = savedamount;
    }


    //////////////////////////cartpricedetails///////////////////

}
