package com.romi.project.fashionstreet;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalScrollProductAdapter extends RecyclerView.Adapter<HorizontalScrollProductAdapter.ViewHolder> {
    private List<HorizontalScrollProductModel>horizontalScrollProductModelList;

    public HorizontalScrollProductAdapter(List<HorizontalScrollProductModel> horizontalScrollProductModelList) {
        this.horizontalScrollProductModelList = horizontalScrollProductModelList;
    }

    @NonNull
    @Override
    public HorizontalScrollProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scrollview_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalScrollProductAdapter.ViewHolder holder, int position) {
        int image=horizontalScrollProductModelList.get(position).getProductImage();
        String name=horizontalScrollProductModelList.get(position).getProductName();
        String details=horizontalScrollProductModelList.get(position).getProductDetails();
        String price=horizontalScrollProductModelList.get(position).getProductPrice();
        holder.setProductImage(image);
        holder.setProductName(name);
        holder.setProductDetails(details);
        holder.setProductPrice(price);

    }

    @Override
    public int getItemCount() {
        if(horizontalScrollProductModelList.size()>8)
        {
            return 8;
        }
        else
        {

        return horizontalScrollProductModelList.size();
    }}
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView productImage;
        private TextView productName,productDetails,productPrice;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.horiz_scroll_item_image);
            productName=itemView.findViewById(R.id.horiz_scroll_item_name);
            productDetails=itemView.findViewById(R.id.horiz_scroll_item_details);
            productPrice=itemView.findViewById(R.id.horiz_scroll_item_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(itemView.getContext(),ProductDetailsActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });

        }

        private void setProductImage(int resource)
        {
            productImage.setImageResource(resource);
        }
        private  void setProductName(String name)
        {
            productName.setText(name);
        }
        private void setProductDetails(String details)
        {
            productDetails.setText(details);
        }
        private void setProductPrice(String price)
        {
            productPrice.setText(price);
        }
    }
}
