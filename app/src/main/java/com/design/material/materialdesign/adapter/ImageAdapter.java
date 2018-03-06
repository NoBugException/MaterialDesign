package com.design.material.materialdesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.design.material.materialdesign.R;

public class ImageAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    //图片资源的id
    private static final int[] ids = { R.drawable.one, R.mipmap.ic_launcher,R.drawable.one, R.mipmap.ic_launcher,R.drawable.one, R.mipmap.ic_launcher,R.drawable.one, R.mipmap.ic_launcher};
    public ImageAdapter(Context context) {
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return ids == null ? 0 :ids.length;
    }
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_image_1, null);
        }
        ((ImageView) convertView.findViewById(R.id.image)).setImageResource(ids[position]);
        return convertView;
    }
}