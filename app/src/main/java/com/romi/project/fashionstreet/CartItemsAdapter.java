package com.romi.project.fashionstreet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartItemsAdapter extends RecyclerView.Adapter {
List<CartItemsModel> cartItemsModelList;

    public CartItemsAdapter(List<CartItemsModel> cartItemsModelList) {
        this.cartItemsModelList = cartItemsModelList;
    }

    @Override
    public int getItemViewType(int position) {

        switch (cartItemsModelList.get(position).getType())
        {


            case 0 :     return CartItemsModel.cart_Product_details;

            case 1: return CartItemsModel.cart_Product_price_details;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       switch (viewType)
       {



           case CartItemsModel.cart_Product_details :
               return new productdetailsViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items_layout,parent,false));
           case CartItemsModel.cart_Product_price_details :
               return new pricedetailsViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_total_pricedetails,parent,false));


       }
           return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {



        switch (cartItemsModelList.get(position).getType())
        {
            case CartItemsModel.cart_Product_details :

                int resource=cartItemsModelList.get(position).getProductimage();
                String title=cartItemsModelList.get(position).getProducttitle();
                int offerno=cartItemsModelList.get(position).getNoofoffersavailable();
                String productpricetext=cartItemsModelList.get(position).getProductprice();
                String productcuttedpricetext=cartItemsModelList.get(position).getProductcuttedprice();
                int offerappliedno=cartItemsModelList.get(position).getOfferapplied();

                ((productdetailsViewholder) holder).setcartProductdetails(resource,title,offerno,productpricetext,productcuttedpricetext,offerappliedno);
                break;

                case CartItemsModel.cart_Product_price_details:
                  String totalitemstext=cartItemsModelList.get(position).gettotalitems();
                    String totalitemspricetext=cartItemsModelList.get(position).getTotalprice();

                    String deliverychargestext=cartItemsModelList.get(position).getDeliverycharges();

                    String totalamounttext=cartItemsModelList.get(position).getTotalamount();
                    String savedamounttext=cartItemsModelList.get(position).getSavedamount();

                    ((pricedetailsViewholder)holder).settotalpricedetails(totalitemstext,totalitemspricetext,deliverychargestext,totalamounttext,savedamounttext);




        }
    }

    @Override
    public int getItemCount() {
        return cartItemsModelList.size();
    }


    public class productdetailsViewholder extends RecyclerView.ViewHolder {

        ImageView productimage;
        TextView producttitle;
        ImageView couponsavailableimage;
        TextView couponsavailable;
        TextView productprice;
        TextView productcuttedprice;
        TextView offerappliedtext;
        TextView couponsappliedtext;
        TextView productquantity;

        public productdetailsViewholder(@NonNull View itemView) {
            super(itemView);

            productimage =itemView.findViewById(R.id.cartimage);
            producttitle =itemView.findViewById(R.id.cartitemtitle);
            couponsavailableimage =itemView.findViewById(R.id.cartoffericon);
            couponsavailable =itemView.findViewById(R.id.cartoffertext);
            productprice =itemView.findViewById(R.id.cartproductprice);
            productcuttedprice =itemView.findViewById(R.id.cartproductcuttedprice);
            offerappliedtext =itemView.findViewById(R.id.cartofferappliedtext);
            couponsappliedtext =itemView.findViewById(R.id.cartcouponappliedtext);
            productquantity =itemView.findViewById(R.id.cartproductquantity);

        }

        private void setcartProductdetails(int resource,String title,int offerno,String productpricetext,String productcuttedpricetext,int offerappliedno)
        {
            productimage.setImageResource(resource);
            producttitle.setText(title);
            if(offerno>0)
            {
                couponsavailableimage.setVisibility(View.VISIBLE);
                couponsavailable.setVisibility(View.VISIBLE);
                if(offerno==1)
                {
                    couponsavailable.setText("free" + offerno + "coupon");
                }
                else
                {
                    couponsavailable.setText("free" + offerno + "coupons");
                }


            }
            else
            {
                couponsavailableimage.setVisibility(View.INVISIBLE);
                couponsavailable.setVisibility(View.INVISIBLE);
            }
             productprice.setText(productpricetext);
            productcuttedprice.setText(productcuttedpricetext);
            if(offerappliedno>0)
            {
                offerappliedtext.setVisibility(View.VISIBLE);
                if(offerappliedno==1)
                {
                    offerappliedtext.setText(offerappliedno + " offer applied");
                }
                else
                {
                    offerappliedtext.setText(offerappliedno + " offers applied");
                }
            }
            else
            {offerappliedtext.setVisibility(View.INVISIBLE);

            }

        }
    }

    public class pricedetailsViewholder extends RecyclerView.ViewHolder {

        TextView totalitems;
        TextView totalitemsprice;
        TextView deliverycahrges;
        TextView totalamount;
        TextView savedprice;



        public pricedetailsViewholder(@NonNull View itemView) {
            super(itemView);
            totalitems=itemView.findViewById(R.id.itemsquentityinpricedetails);
            totalitemsprice=itemView.findViewById(R.id.allitemspriceinpricedetails);
            deliverycahrges=itemView.findViewById(R.id.delicerycharges);
            totalamount=itemView.findViewById(R.id.cartpricedetailstotalamount);
            savedprice=itemView.findViewById(R.id.cartyouwillsaveamounttext);


        }



        private void settotalpricedetails(String totalitemstext,String totalitemspricetext,String deliverychargestext,String totalamounttext,String savedpricetext)
        {

            totalitems.setText(totalitemstext);
            totalitemsprice.setText(totalitemspricetext);
            deliverycahrges.setText(deliverychargestext);
            totalamount.setText(totalamounttext);
            savedprice.setText(savedpricetext);



        }
    }


}
