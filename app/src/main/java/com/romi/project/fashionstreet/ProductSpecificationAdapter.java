package com.romi.project.fashionstreet;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class ProductSpecificationAdapter extends RecyclerView.Adapter<ProductSpecificationAdapter.ViewHolder> {

    List<ProductSpecificationModel> productSpecificationModelList;

    public ProductSpecificationAdapter(List<ProductSpecificationModel> productSpecificationModelList) {
        this.productSpecificationModelList = productSpecificationModelList;
    }


    @Override
    public int getItemViewType(int position) {
        switch (productSpecificationModelList.get(position).getType())
        {
            case 0:    return ProductSpecificationModel.SPECIFICATIONTITLE;
            case 1: return  ProductSpecificationModel.SPECIFICATIONBODY;
        }
        return -1;
    }

    @NonNull
    @Override
    public ProductSpecificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType)
        {
            case ProductSpecificationModel.SPECIFICATIONTITLE :
                TextView title=new TextView(parent.getContext());
                title.setTypeface(null, Typeface.BOLD);
                title.setTextColor(Color.parseColor("#000000"));
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(setDp(16,parent.getContext()),setDp(16,parent.getContext()),setDp(16,parent.getContext()),setDp(8,parent.getContext()));
                title.setLayoutParams(layoutParams);
                return new ViewHolder(title);
                case ProductSpecificationModel.SPECIFICATIONBODY:
                    View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.product_specificationrecycle_items,parent,false);
                    return new ViewHolder(view);
        }
        return null;



    }

    @Override
    public void onBindViewHolder(@NonNull ProductSpecificationAdapter.ViewHolder holder, int position) {


        switch (productSpecificationModelList.get(position).getType())
        {
            case ProductSpecificationModel.SPECIFICATIONTITLE:
                holder.setTitle(productSpecificationModelList.get(position).getTitle());
                break;
                case ProductSpecificationModel.SPECIFICATIONBODY:
                    String text1=productSpecificationModelList.get(position).getFeaturename();
                    String text2=productSpecificationModelList.get(position).getFeaturevalue();
                    holder.setfeatures(text1,text2);
                    break;
            default: return;
        }


    }

    @Override
    public int getItemCount() {
        return productSpecificationModelList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView featurename,featurevalue,title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


        }

        private void setTitle(String titlehead)
        {
            title= (TextView) itemView;
            title.setText(titlehead);
        }
        private void setfeatures(String featurevalue1,String featurevalue2)
        {
            featurename=itemView.findViewById(R.id.featurename);
            featurevalue=itemView.findViewById(R.id.featurevalue);
            featurename.setText(featurevalue1);
            featurevalue.setText(featurevalue2);
        }


    }



    private int setDp(int dp, Context context)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());

    }
}
