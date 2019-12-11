package com.example.bookstore.ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.allthelucky.common.view.AutoPlayManager;
import com.allthelucky.common.view.ImageIndicatorView;
import com.example.bookstore.R;

public class HomeFragment extends Fragment {

    private ImageIndicatorView indicate_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,null);
        /*
        loading_data = view.findViewById(R.id.loading_data);
        imageView_shopping_cart = (ImageView) view.findViewById(R.id.imageView_shopping_cart);
        imageView_shopping_cart.setOnClickListener(this);
        //loading_data.setVisibility(View.GONE);

         */
        initIndicateView(view);
        /*
        listView = (ListView) view.findViewById(R.id.listView);
        bookListItemAdapter = new BookListItemAdapter(mainActivity,bookInfos);
        listView.setAdapter(bookListItemAdapter);
        listView.setOnItemClickListener(this);

        loadData();

         */
        return view;
    }


    private void initIndicateView(View view) {
        indicate_view = (ImageIndicatorView) view.findViewById(R.id.indicate_view);
        final Integer[] resArray = new Integer[] { R.mipmap.qdzt, R.mipmap.qinghuabiancheng,R.mipmap.scala};
        indicate_view.setupLayoutByDrawable(resArray);
        indicate_view.setIndicateStyle(ImageIndicatorView.INDICATE_USERGUIDE_STYLE);
        indicate_view.show();
        AutoPlayManager autoBrocastManager =  new AutoPlayManager(indicate_view);
        autoBrocastManager.setBroadcastEnable(true);
        autoBrocastManager.setBroadCastTimes(5);//loop times
        autoBrocastManager.setBroadcastTimeIntevel(3 * 1000, 3 * 1000);//set first play time and interval
        autoBrocastManager.loop();
    }

}
