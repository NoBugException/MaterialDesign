package com.design.material.materialdesign;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.design.material.materialdesign.bottomnavgationview.BottomNavigationBean;
import com.design.material.materialdesign.threeslideview.SlideBean;
import com.design.material.materialdesign.bottomnavgationview.BottomNavigationActivity;
import com.design.material.materialdesign.threeslideview.viewflipper.activity.ViewFlipper1Activity;
import com.design.material.materialdesign.threeslideview.viewflipper.activity.ViewFlipper2Activity;
import com.design.material.materialdesign.threeslideview.viewflow.ViewFlowActivity;
import com.design.material.materialdesign.threeslideview.viewpager.activity.ViewPager1Activity;
import com.design.material.materialdesign.threeslideview.viewpager.activity.ViewPager2Activity;

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

        BottomNavigationBean bottomNavigationBean = new BottomNavigationBean();
        bottomNavigationBean.setName("BottomNavigationView");
        mDatas.add(bottomNavigationBean);

        SlideBean slideBean = new SlideBean();
        slideBean.setName("三种滑动组件");
        slideBean.setModelName1("ViewPager");
        slideBean.setModelName2("ViewFlipper");
        slideBean.setModelName3("ViewFlow");
        mDatas.add(slideBean);


        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        mRecyclerView.setLayoutManager(layoutmanager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
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
                }else if(baseBean instanceof SlideBean){
                    return MaterialItemViewType.SILIDE;
                }
                return 0;
            }
        }) {
            @Override
            public void convert(CommonViewHolder holder, BaseBean baseBean) {
                //填充
                LinearLayout linearLayout = holder.getView(R.id.item_container);
                LayoutInflater layoutInflater;
                TextView type;
                View view;
                TextView mame;
                switch (baseBean.getItemViewType()){
                    case MaterialItemViewType.BOTTOMNAVIGATION:
                        BottomNavigationBean bottomNavigationBean1 = (BottomNavigationBean) baseBean;
                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
                        view = layoutInflater.inflate(R.layout.item_bottomnavigation, null);
                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(bottomNavigationBean1.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(bottomNavigationBean1.getItemViewType()));
                        holder.setOnClickListener(R.id.item_container, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(BottomNavigationActivity.class);
                            }
                        });
                        break;
                    case MaterialItemViewType.SILIDE:
                        SlideBean slideBean = (SlideBean) baseBean;
                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
                        view = layoutInflater.inflate(R.layout.item_slide, null);
                        linearLayout.addView(view);
                        TextView model1 = holder.getView(R.id.model1);
                        model1.setText(slideBean.getModelName1());
                        TextView model2 = holder.getView(R.id.model2);
                        model2.setText(slideBean.getModelName2());
                        TextView model3 = holder.getView(R.id.model3);
                        model3.setText(slideBean.getModelName3());
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(slideBean.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(slideBean.getItemViewType()));
                        holder.setOnClickListener(R.id.model1_1, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(ViewPager1Activity.class);
                            }
                        });
                        holder.setOnClickListener(R.id.model1_2, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(ViewPager2Activity.class);
                            }
                        });
                        holder.setOnClickListener(R.id.model2_1, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(ViewFlipper2Activity.class);
                            }
                        });
                        holder.setOnClickListener(R.id.model2_2, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(ViewFlipper1Activity.class);
                            }
                        });
                        holder.setOnClickListener(R.id.model3, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(ViewFlowActivity.class);
                            }
                        });
                        break;
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
