package com.romi.project.fashionstreet;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridViewItemsAdapter extends BaseAdapter {

    List<HorizontalScrollProductModel>horizontalScrollProductModelList;

    public GridViewItemsAdapter(List<HorizontalScrollProductModel> horizontalScrollProductModelList) {
        this.horizontalScrollProductModelList = horizontalScrollProductModelList;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view;
        if(convertView==null)
        {
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scrollview_items,parent,false);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#FFFAFA"));
            ImageView itemImage=view.findViewById(R.id.horiz_scroll_item_image);
            TextView itemname=view.findViewById(R.id.horiz_scroll_item_name);
            TextView itemdetails=view.findViewById(R.id.horiz_scroll_item_details);
            TextView itemprice=view.findViewById(R.id.horiz_scroll_item_price);

            itemImage.setImageResource(horizontalScrollProductModelList.get(position).getProductImage());
            itemname.setText(horizontalScrollProductModelList.get(position).getProductName());
            itemdetails.setText(horizontalScrollProductModelList.get(position).getProductDetails());
            itemprice.setText(horizontalScrollProductModelList.get(position).getProductPrice());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(parent.getContext(),ProductDetailsActivity.class);
                    parent.getContext().startActivity(intent);
                }
            });
        }
        else
        {
            view=convertView;
        }


        return view;
    }
}
