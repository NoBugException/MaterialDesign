package com.design.material.materialdesign.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.design.material.materialdesign.inteface.MultiItemTypeSupport;

import java.util.List;

/**
 * 封装可支持多种类型的recycleview
 * Created by Q on 2018/3/1.
 */

public abstract class MultiItemCommonAdapter<T> extends CommonAdapter<T> {

    protected MultiItemTypeSupport<T> mMultiItemTypeSupport;

    public MultiItemCommonAdapter(Context context, List<T> datas, MultiItemTypeSupport<T> multiItemTypeSupport) {
        super(context, -1, datas);
        mMultiItemTypeSupport = multiItemTypeSupport;
    }

    @Override
    public int getItemViewType(int position) {
        return mMultiItemTypeSupport.getItemViewType(position, mDatas.get(position));
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = mMultiItemTypeSupport.getLayoutId(viewType);
        CommonViewHolder holder = CommonViewHolder.get(mContext, parent, layoutId);
        return holder;
    }
}
