package com.romi.project.fashionstreet;

import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;
import java.util.zip.Inflater;

public class Category_Adapter extends RecyclerView.Adapter<Category_Adapter.ViewHolder> {
    public List<Category_Model> categoryModelList;


    public Category_Adapter(List<Category_Model> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @Override
    public Category_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Category_Adapter.ViewHolder holder, int position) {
 String icon= categoryModelList.get(position).getCategoryiconlink();
     String name=categoryModelList.get(position).getCategorytext();

        holder.setCategoryPage(name);



    }

    @Override
    public int getItemCount() {


            return categoryModelList.size();
        }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryitemicon;
        TextView categoryitemtext;
        ShimmerFrameLayout shimmerFrameLayout;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            categoryitemicon = itemView.findViewById(R.id.category_item_icon);
            categoryitemtext = itemView.findViewById(R.id.category_item_text);
        }

        public void setCategoryItemIcon() {

        }

        public void setCategoryPage(final String name) {

        categoryitemtext.setText(name);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categorypage=new Intent(itemView.getContext(),CategoryPage.class);
                categorypage.putExtra("categoryname",name);
                itemView.getContext().startActivity(categorypage);

            }
        });

        }
    }
}
