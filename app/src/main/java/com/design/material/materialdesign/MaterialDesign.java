package com.design.material.materialdesign;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.design.material.materialdesign.Constant.MaterialItemViewType;
import com.design.material.materialdesign.adapter.CommonViewHolder;
import com.design.material.materialdesign.adapter.MultiItemCommonAdapter;
import com.design.material.materialdesign.bean.BaseBean;
import com.design.material.materialdesign.bean.BottomNavigationBean;
import com.design.material.materialdesign.inteface.MultiItemTypeSupport;

import java.util.ArrayList;
import java.util.List;

public class MaterialDesign extends BaseActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected int getRootView() {
        return R.layout.activity_material_design;
    }

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.materialdesign_recycle);
    }

    @Override
    protected void initData() {
        List<BaseBean> mDatas = new ArrayList<>();
        BaseBean bottomNavigationBean = new BottomNavigationBean();
        bottomNavigationBean.setName("BottomNavigationView");
        mDatas.add(bottomNavigationBean);
//        mDatas.add("B");
//        mDatas.add("C");
//        mDatas.add("D");
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        mRecyclerView.setLayoutManager(layoutmanager);

        mRecyclerView.setAdapter(new MultiItemCommonAdapter<BaseBean>(this, mDatas, new MultiItemTypeSupport<BaseBean>() {
            @Override
            public int getLayoutId(int itemType) {
                //基本布局
                return R.layout.item_list;
            }

            @Override
            public int getItemViewType(int position, BaseBean baseBean) {
                //view类型
                if(baseBean instanceof BottomNavigationBean){
                    return MaterialItemViewType.BOTTOMNAVIGATION;
                }
                return 0;
            }
        }) {
            @Override
            public void convert(CommonViewHolder holder, BaseBean baseBean) {
                //填充
                LinearLayout linearLayout = holder.getView(R.id.item_container);
                LayoutInflater layoutInflater = LayoutInflater.from(MaterialDesign.this);
                View view = layoutInflater.inflate(R.layout.item_bottomnavigation, null);
                linearLayout.addView(view);
                if(baseBean.getItemViewType() == MaterialItemViewType.BOTTOMNAVIGATION){
                    TextView mame = holder.getView(R.id.id_item_materialname);
                    mame.setText(baseBean.getName());
                    TextView type = holder.getView(R.id.id_item_materialtype);
                    type.setText(String.valueOf(baseBean.getItemViewType()));
                    holder.setOnClickListener(R.id.item_container, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(BottomNavigationActivity.class);
                        }
                    });
                }
            }
        });
    }

    @Override
    protected void initListener() {
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }
}
