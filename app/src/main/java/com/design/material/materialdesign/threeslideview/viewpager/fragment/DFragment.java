package com.design.material.materialdesign.threeslideview.viewpager.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.design.material.materialdesign.R;

/**
 * Created by beixinyuan_android on 2018/3/6.
 */

public class DFragment extends Fragment {

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d("yunchong","setUserVisibleHint");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("yunchong","onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("yunchong","onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("yunchong","onCreateView");
        //引用创建好的xml布局
        View view = inflater.inflate(R.layout.item_image_1,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("yunchong","onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("yunchong","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("yunchong","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("yunchong","onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("yunchong","onSaveInstanceState");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("yunchong","onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("yunchong","onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("yunchong","onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("yunchong","onDetach");
    }
}
