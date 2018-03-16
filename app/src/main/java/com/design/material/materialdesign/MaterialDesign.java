package com.design.material.materialdesign;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.design.material.materialdesign.bottomnavgationview.BottomNavigationBean;
import com.design.material.materialdesign.flycotablayout.FlycoBean;
import com.design.material.materialdesign.flycotablayout.acticity.CommonTabActivity;
import com.design.material.materialdesign.flycotablayout.acticity.SegmentTabActivity;
import com.design.material.materialdesign.flycotablayout.acticity.SlidingTabActivity;
import com.design.material.materialdesign.guideview.GuideViewActivity;
import com.design.material.materialdesign.guideview.GuideViewBean;
import com.design.material.materialdesign.pdfview.PDFViewActivity;
import com.design.material.materialdesign.pdfview.PdfViewBean;
import com.design.material.materialdesign.richtext.RichTextActivity;
import com.design.material.materialdesign.richtext.RichTextBean;
import com.design.material.materialdesign.showcaseview.ShowCaseBean;
import com.design.material.materialdesign.showcaseview.ShowCaseView;
import com.design.material.materialdesign.threeslideview.SlideBean;
import com.design.material.materialdesign.bottomnavgationview.BottomNavigationActivity;
import com.design.material.materialdesign.threeslideview.viewflipper.activity.ViewFlipper1Activity;
import com.design.material.materialdesign.threeslideview.viewflipper.activity.ViewFlipper2Activity;
import com.design.material.materialdesign.threeslideview.viewflow.ViewFlowActivity;
import com.design.material.materialdesign.threeslideview.viewpager.activity.ViewPager1Activity;
import com.design.material.materialdesign.threeslideview.viewpager.activity.ViewPager2Activity;
import com.zzhoujay.richtext.RichText;

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

        FlycoBean flycoBean = new FlycoBean();
        flycoBean.setName("flycotablayout");
        flycoBean.setModelName1("SlidingTabLayout");
        flycoBean.setModelName2("CommonTabLayout");
        flycoBean.setModelName3("SegmentTabLayout");
        mDatas.add(flycoBean);

        PdfViewBean pdfViewBean = new PdfViewBean();
        pdfViewBean.setName("pdfView");
        mDatas.add(pdfViewBean);

        RichTextBean richTextBean = new RichTextBean();
        richTextBean.setName("richText-丰富文本解析");
        mDatas.add(richTextBean);

        GuideViewBean guideViewBean = new GuideViewBean();
        guideViewBean.setName("GuideView-遮罩");
        mDatas.add(guideViewBean);

        ShowCaseBean showCaseBean = new ShowCaseBean();
        showCaseBean.setName("ShowCaseView-遮罩-高亮突出");
        mDatas.add(showCaseBean);

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
                }else if(baseBean instanceof FlycoBean){
                    return MaterialItemViewType.FLYCO;
                }else if(baseBean instanceof PdfViewBean){
                    return MaterialItemViewType.PDFVIEW;
                }else if(baseBean instanceof RichTextBean){
                    return MaterialItemViewType.RICHTEXT;
                }else if(baseBean instanceof GuideViewBean){
                    return MaterialItemViewType.GUIDEVIEW;
                }else if(baseBean instanceof ShowCaseBean){
                    return MaterialItemViewType.SHOWCASEVIEW;
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
                    case MaterialItemViewType.FLYCO:
                        FlycoBean fb = (FlycoBean) baseBean;
                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
                        view = layoutInflater.inflate(R.layout.item_flyco, null);
                        linearLayout.addView(view);
                        TextView flyco_model1 = holder.getView(R.id.flyco_model1);
                        flyco_model1.setText(fb.getModelName1());
                        TextView flyco_model2 = holder.getView(R.id.flyco_model2);
                        flyco_model2.setText(fb.getModelName2());
                        TextView flyco_model3 = holder.getView(R.id.flyco_model3);
                        flyco_model3.setText(fb.getModelName3());
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(fb.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(fb.getItemViewType()));
                        holder.setOnClickListener(R.id.flyco_model1, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(SlidingTabActivity.class);
                            }
                        });
                        holder.setOnClickListener(R.id.flyco_model2, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(CommonTabActivity.class);
                            }
                        });
                        holder.setOnClickListener(R.id.flyco_model3, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(SegmentTabActivity.class);
                            }
                        });
                        break;
                    case MaterialItemViewType.PDFVIEW:
                        PdfViewBean pdfvb = (PdfViewBean) baseBean;
                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
                        view = layoutInflater.inflate(R.layout.item_pdfview, null);
                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(pdfvb.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(pdfvb.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(PDFViewActivity.class);
                            }
                        });
                        break;
                    case MaterialItemViewType.RICHTEXT:
                        RichTextBean rtb = (RichTextBean) baseBean;
                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
                        view = layoutInflater.inflate(R.layout.item_richtext, null);
                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(rtb.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(rtb.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(RichTextActivity.class);
                            }
                        });
                        break;
                    case MaterialItemViewType.GUIDEVIEW:
                        GuideViewBean gvb = (GuideViewBean) baseBean;
                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
                        view = layoutInflater.inflate(R.layout.item_guide, null);
                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(gvb.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(gvb.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(GuideViewActivity.class);
                            }
                        });
                        break;
                    case MaterialItemViewType.SHOWCASEVIEW:
                        ShowCaseBean scb = (ShowCaseBean) baseBean;
                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
                        view = layoutInflater.inflate(R.layout.item_showcase, null);
                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(scb.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(scb.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(ShowCaseView.class);
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
