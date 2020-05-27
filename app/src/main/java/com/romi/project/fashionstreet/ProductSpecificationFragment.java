package com.romi.project.fashionstreet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductSpecificationFragment extends Fragment {
    private RecyclerView productspecificationrecyclerview;

    public ProductSpecificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_product_specification, container, false);


        productspecificationrecyclerview=view.findViewById(R.id.productspecificationrecyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        productspecificationrecyclerview.setLayoutManager(linearLayoutManager);

        List<ProductSpecificationModel> productSpecificationModelList =new ArrayList<>();
        productSpecificationModelList.add(new ProductSpecificationModel(0,"General"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"Design"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"Internal"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"External"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Mobile name","Redmi note 4"));

        ProductSpecificationAdapter productSpecificationAdapter=new ProductSpecificationAdapter(productSpecificationModelList);
        productspecificationrecyclerview.setAdapter(productSpecificationAdapter);
        productSpecificationAdapter.notifyDataSetChanged();

        return view;
    }
}
