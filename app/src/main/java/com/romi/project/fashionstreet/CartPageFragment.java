package com.romi.project.fashionstreet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartPageFragment extends Fragment {

    RecyclerView cartrecyclerview;


    public CartPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cart_page, container, false);


        cartrecyclerview=view.findViewById(R.id.cartrecyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartrecyclerview.setLayoutManager(linearLayoutManager);

        List<CartItemsModel> cartItemsModelList=new ArrayList<>();
        cartItemsModelList.add(new CartItemsModel(0,R.drawable.phone22,"Realme 6 (Comet Blue, 128 GB)",2,"Rs.49,999/-","Rs.59,999/-",2,0,1));
        cartItemsModelList.add(new CartItemsModel(0,R.drawable.phone22,"Realme 6 (Comet Blue, 128 GB)",2,"Rs.49,999/-","Rs.59,999/-",2,0,1));
        cartItemsModelList.add(new CartItemsModel(0,R.drawable.phone22,"Realme 6 (Comet Blue, 128 GB)",2,"Rs.49,999/-","Rs.59,999/-",2,0,1));
        cartItemsModelList.add(new CartItemsModel(1,"Price(2 items)","Rs.49,999/-","Free","Rs.49,999/-","You will save 10,000/- on this order"));
          CartItemsAdapter cartItemsAdapter=new CartItemsAdapter(cartItemsModelList);

          cartrecyclerview.setAdapter(cartItemsAdapter);
          cartItemsAdapter.notifyDataSetChanged();
        return view;
    }
}
