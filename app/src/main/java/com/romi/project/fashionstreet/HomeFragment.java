package com.romi.project.fashionstreet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.Inflater;


public class HomeFragment extends Fragment {

    private RecyclerView categoryItemsRecyclerView;
    public List<Category_Model> category_modelList;
    public   Category_Adapter category_adapter;
    private TabLayout bannerslidertablayout;
    private FirebaseFirestore firebaseFirestore;
    private HomePageMultipleLayoutAdapter homePageMultipleLayoutAdapter;
    private  List<HomePageMultipleLayoutModel> homePageMultipleLayoutModelList;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        firebaseFirestore=FirebaseFirestore.getInstance();


        category_modelList = new ArrayList<>();

  categoryItemsRecyclerView = view.findViewById(R.id.categories_recyclerview);

        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(getActivity());
        linearLayoutManager4.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryItemsRecyclerView.setLayoutManager(linearLayoutManager4);
        category_adapter = new Category_Adapter(category_modelList);
        categoryItemsRecyclerView.setAdapter(category_adapter);




        firebaseFirestore.collection("CATEGORIES").orderBy("index").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {


        if(task.isSuccessful())
        {
          for(QueryDocumentSnapshot queryDocumentSnapshot : task.getResult())
          {
              category_modelList.add(new Category_Model(queryDocumentSnapshot.get("Icon").toString(), queryDocumentSnapshot.get("categoryName").toString()));


          }

          category_adapter.notifyDataSetChanged();

        }
        else
        {
            Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();


        }

    }
});





            /////Banner Slider Code//////




        /////Banner Slider Code//////*


        //////// horitonal srcoll view //////

        final List<HorizontalScrollProductModel> horizontalScrollProductModelList=new ArrayList<>();

        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.horizontalscrollpic,"Redmi 5A","SD 425 Processor","Rs.9999/-"));


         //////Horizontal Scroll view/////*


        ////////////HomePageMultiplelayoutRecyclerview//////////////////
        RecyclerView HomepageMultiplelayoutrecyclerview=view.findViewById(R.id.homepagemultiplelayoutrecylerview);
        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        HomepageMultiplelayoutrecyclerview.setLayoutManager(linearLayoutManager2);
        homePageMultipleLayoutModelList=new ArrayList<>();
       homePageMultipleLayoutAdapter=new HomePageMultipleLayoutAdapter(homePageMultipleLayoutModelList);
        HomepageMultiplelayoutrecyclerview.setAdapter(homePageMultipleLayoutAdapter);
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(0,"India Unites to Fight Covid-19"));


        firebaseFirestore.collection("CATEGORIES").document("HOME").collection("TOP_DEALS").orderBy("index").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if(task.isSuccessful())
                {

for(QueryDocumentSnapshot queryDocumentSnapshot: task.getResult())
{
long index=(long)queryDocumentSnapshot.get("view_type");
    if(index==0)
    {
        List<BannerSliderModel> bannerSliderModelList=new ArrayList<>();
        long no_of_banners=(long)queryDocumentSnapshot.get("no_of_banners");

        for(long i=1;i<=no_of_banners;i++)
        {
            bannerSliderModelList.add(new BannerSliderModel(queryDocumentSnapshot.get("banner" + i).toString(),queryDocumentSnapshot.get("banner_" + i + "_background").toString()));
        }
        homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(bannerSliderModelList,4));
    }

    else if(index==1)
    {
       homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(1,queryDocumentSnapshot.get("strip_ad1").toString(),queryDocumentSnapshot.get("strip_ad1_background").toString()));
        //homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(1,queryDocumentSnapshot.get("strip_ad2").toString(),queryDocumentSnapshot.get("strip_ad2_background").toString()));

    }
    homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(2, "Deals of the Day" ,horizontalScrollProductModelList));

    homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(5,R.drawable.arogyasethuapp));
    homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(2,"Suggested for You",horizontalScrollProductModelList));
    homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(3,"Personal and baby care",horizontalScrollProductModelList));
    homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(2,"Furniture",horizontalScrollProductModelList));
    homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(3,"Electronics",horizontalScrollProductModelList));
    homePageMultipleLayoutModelList.add(new HomePageMultipleLayoutModel(2,"Top Brands",horizontalScrollProductModelList));

}

homePageMultipleLayoutAdapter.notifyDataSetChanged();
                }
                else
                {

                    Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });




        /////////HomePageMultipleLayoutRecycler/////////



        return view;

    }


}



