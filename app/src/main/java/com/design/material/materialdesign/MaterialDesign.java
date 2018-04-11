package com.design.material.materialdesign;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.design.material.materialdesign.base.BBaseBean;
import com.design.material.materialdesign.bezier.BezierActivity;
import com.design.material.materialdesign.bottomnavgationview.BottomNavigationActivity;
import com.design.material.materialdesign.bottomnavgationview.BottomNavigationBean;
import com.design.material.materialdesign.cardslide.CardSlideActivity;
import com.design.material.materialdesign.cardslide.CardSlideBean;
import com.design.material.materialdesign.cardstackview.CardStackBean;
import com.design.material.materialdesign.cardstackview.CardStackViewActivity;
import com.design.material.materialdesign.circualreveal.CircualrevealActivity;
import com.design.material.materialdesign.expandingpager.ExpandingPagerBean;
import com.design.material.materialdesign.expandingpager.ExpandingpagerActivity;
import com.design.material.materialdesign.floatingactionbutton.FloatingActionButtonActivity;
import com.design.material.materialdesign.flycotablayout.FlycoBean;
import com.design.material.materialdesign.flycotablayout.acticity.CommonTabActivity;
import com.design.material.materialdesign.flycotablayout.acticity.SegmentTabActivity;
import com.design.material.materialdesign.flycotablayout.acticity.SlidingTabActivity;
import com.design.material.materialdesign.guideview.GuideViewActivity;
import com.design.material.materialdesign.guideview.GuideViewBean;
import com.design.material.materialdesign.indicatorstepview.IndicatorStepViewActivity;
import com.design.material.materialdesign.indicatorstepview.StepViewBean;
import com.design.material.materialdesign.indicatorstepview2.IndicatorStepView2Activity;
import com.design.material.materialdesign.indicatorstepview3.activity.IndicatorStepView3Activity;
import com.design.material.materialdesign.liquidbutton.LiquidBean;
import com.design.material.materialdesign.liquidbutton.LiquidButtonActivity;
import com.design.material.materialdesign.loaddrawable.LoadDrawableActivity;
import com.design.material.materialdesign.loaddrawable.LoadDrawableBean;
import com.design.material.materialdesign.loading.LoadingActivity;
import com.design.material.materialdesign.loading.LoadingBean;
import com.design.material.materialdesign.loadview.LoadViewActivity;
import com.design.material.materialdesign.loadview.LoadViewBean;
import com.design.material.materialdesign.mateballloading.MateBallLoadingActivity;
import com.design.material.materialdesign.mateballloading.MateBallLoadingBean;
import com.design.material.materialdesign.multidialog.MultiDialogActivity;
import com.design.material.materialdesign.multidialog.MultiDialogBean;
import com.design.material.materialdesign.pdfview.PDFViewActivity;
import com.design.material.materialdesign.pdfview.PdfViewBean;
import com.design.material.materialdesign.qqredflag1.BubbleNotificationActivity;
import com.design.material.materialdesign.qqredflag2.BezierViewActivity;
import com.design.material.materialdesign.rangdemo.RangActivity;
import com.design.material.materialdesign.richtext.RichTextActivity;
import com.design.material.materialdesign.richtext.RichTextBean;
import com.design.material.materialdesign.rippleclick1.RippleClickActivity;
import com.design.material.materialdesign.rippleclick2.RippleClick2Activity;
import com.design.material.materialdesign.sheetfab.SheetfabActivity;
import com.design.material.materialdesign.showcaseview.ShowCaseBean;
import com.design.material.materialdesign.showcaseview.ShowCaseView;
import com.design.material.materialdesign.threeslideview.SlideBean;
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
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_material_design, null);
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

        CardStackBean cardStackBean = new CardStackBean();
        cardStackBean.setName("CardStackView");
        mDatas.add(cardStackBean);

        LiquidBean liquidBean = new LiquidBean();
        liquidBean.setName("LiquidButton-一个实现液体填充效果的加载提示view");
        mDatas.add(liquidBean);

        CardSlideBean cardSlideBean = new CardSlideBean();
        cardSlideBean.setName("模仿探探的卡片左右滑动效果");
        mDatas.add(cardSlideBean);

        ExpandingPagerBean expandingPagerBean = new ExpandingPagerBean();
        expandingPagerBean.setName("一个比较常规的卡片式交互控件");
        mDatas.add(expandingPagerBean);

        LoadingBean loadingBean = new LoadingBean();
        loadingBean.setName("加载动画");
        mDatas.add(loadingBean);

        LoadDrawableBean loadDrawableBean = new LoadDrawableBean();
        loadDrawableBean.setName("加载动画-LoadDrawable");
        mDatas.add(loadDrawableBean);

        LoadViewBean loadViewBean = new LoadViewBean();
        loadViewBean.setName("加载动画-Loadview");
        mDatas.add(loadViewBean);

        MateBallLoadingBean mateBallLoadingBean = new MateBallLoadingBean();
        mateBallLoadingBean.setName("一个有贝塞尔曲线动画的加载提示框");
        mDatas.add(mateBallLoadingBean);

        MultiDialogBean multiDialogBean = new MultiDialogBean();
        multiDialogBean.setName("多种对话框展示");
        mDatas.add(multiDialogBean);

        StepViewBean stepViewBean1 = new StepViewBean();
        stepViewBean1.setFlag(1);
        stepViewBean1.setName("指示器-StepView1");
        mDatas.add(stepViewBean1);

        StepViewBean stepViewBean2 = new StepViewBean();
        stepViewBean2.setFlag(2);
        stepViewBean2.setName("指示器-StepView2");
        mDatas.add(stepViewBean2);

        StepViewBean stepViewBean3 = new StepViewBean();
        stepViewBean3.setFlag(3);
        stepViewBean3.setName("指示器-StepView3");
        mDatas.add(stepViewBean3);

        BBaseBean bBaseBean1 = new BBaseBean();
        bBaseBean1.setFlag(1);
        bBaseBean1.setName("贝塞尔曲线");
        mDatas.add(bBaseBean1);

        BBaseBean bBaseBean2 = new BBaseBean();
        bBaseBean2.setFlag(2);
        bBaseBean2.setName("模仿QQ的未读小红点-爱心爆炸");
        mDatas.add(bBaseBean2);

        BBaseBean bBaseBean3 = new BBaseBean();
        bBaseBean3.setFlag(3);
        bBaseBean3.setName("另一种模仿QQ的未读小红点");
        mDatas.add(bBaseBean3);

        BBaseBean bBaseBean4 = new BBaseBean();
        bBaseBean4.setFlag(4);
        bBaseBean4.setName("点击特效-涟漪");
        mDatas.add(bBaseBean4);

        BBaseBean bBaseBean5 = new BBaseBean();
        bBaseBean5.setFlag(5);
        bBaseBean5.setName("点击特效-涟漪2");
        mDatas.add(bBaseBean5);

        BBaseBean bBaseBean6 = new BBaseBean();
        bBaseBean6.setFlag(6);
        bBaseBean6.setName("Floatingactionbutton");
        mDatas.add(bBaseBean6);

        BBaseBean bBaseBean7 = new BBaseBean();
        bBaseBean7.setFlag(7);
        bBaseBean7.setName("MaterialSheetFab + RecyclerView（StaggeredGridLayoutManager）+ActionBarDrawerToggle");
        mDatas.add(bBaseBean7);

        BBaseBean bBaseBean8 = new BBaseBean();
        bBaseBean8.setFlag(8);
        bBaseBean8.setName("CircularReveal");
        mDatas.add(bBaseBean8);

        BBaseBean bBaseBean9 = new BBaseBean();
        bBaseBean9.setFlag(9);
        bBaseBean9.setName("范围");
        mDatas.add(bBaseBean9);

        BBaseBean bBaseBean10 = new BBaseBean();
        bBaseBean10.setFlag(10);
        bBaseBean10.setName("EditText");
        mDatas.add(bBaseBean10);

        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        mRecyclerView.setLayoutManager(layoutmanager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(new MultiItemCommonAdapter<BaseBean>(this, mDatas, new MultiItemTypeSupport<BaseBean>() {
            @Override
            public int getLayoutId(int itemType) {
                int layoutId = -1;
                switch (itemType){
                    case MaterialItemViewType.BASE:
                        layoutId =  R.layout.item_base;
                        break;
                    case MaterialItemViewType.BOTTOMNAVIGATION:
                        layoutId =  R.layout.item_bottomnavigation;
                        break;
                    case MaterialItemViewType.SILIDE:
                        layoutId = R.layout.item_slide;
                        break;
                    case MaterialItemViewType.FLYCO:
                        layoutId = R.layout.item_flyco;
                        break;
                    case MaterialItemViewType.PDFVIEW:
                        layoutId = R.layout.item_pdfview;
                        break;
                    case MaterialItemViewType.RICHTEXT:
                        layoutId = R.layout.item_richtext;
                        break;
                    case MaterialItemViewType.GUIDEVIEW:
                        layoutId = R.layout.item_guide;
                        break;
                    case MaterialItemViewType.SHOWCASEVIEW:
                        layoutId = R.layout.item_showcase;
                        break;
                    case MaterialItemViewType.CARDSTACKVIEW:
                        layoutId = R.layout.item_base;
                        break;
                    case MaterialItemViewType.LIQUIDB:
                        layoutId = R.layout.item_liquidbutton;
                        break;
                    case MaterialItemViewType.CARDSLIDE:
                        layoutId = R.layout.item_cardslide;
                        break;
                    case MaterialItemViewType.EXPANDINGPAGER:
                        layoutId = R.layout.item_expandingpager;
                        break;
                    case MaterialItemViewType.LOADINGVIEW:
                        layoutId = R.layout.item_loading;
                        break;
                    case MaterialItemViewType.LOADDRAWABLE:
                        layoutId = R.layout.item_loading;
                        break;
                    case MaterialItemViewType.LOADVIEW:
                        layoutId = R.layout.item_loading;
                        break;
                    case MaterialItemViewType.MATEBALLLOADING:
                        layoutId = R.layout.item_loading;
                        break;
                    case MaterialItemViewType.MULTIDIALOG:
                        layoutId = R.layout.item_base;
                        break;
                    case MaterialItemViewType.STEPVIEW:
                        layoutId = R.layout.item_base;
                        break;
                }
                return layoutId;
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
                }else if(baseBean instanceof CardStackBean){
                    return MaterialItemViewType.CARDSTACKVIEW;
                }else if(baseBean instanceof LiquidBean){
                    return MaterialItemViewType.LIQUIDB;
                }else if(baseBean instanceof CardSlideBean){
                    return MaterialItemViewType.CARDSLIDE;
                }else  if(baseBean instanceof ExpandingPagerBean){
                    return MaterialItemViewType.EXPANDINGPAGER;
                }else if(baseBean instanceof LoadingBean){
                    return MaterialItemViewType.LOADINGVIEW;
                }else if(baseBean instanceof LoadDrawableBean){
                    return MaterialItemViewType.LOADDRAWABLE;
                }else if(baseBean instanceof LoadViewBean){
                    return MaterialItemViewType.LOADVIEW;
                }else if(baseBean instanceof MateBallLoadingBean){
                    return MaterialItemViewType.MATEBALLLOADING;
                }else if(baseBean instanceof MultiDialogBean){
                    return MaterialItemViewType.MULTIDIALOG;
                }else if(baseBean instanceof StepViewBean){
                    return MaterialItemViewType.STEPVIEW;
                }
                return MaterialItemViewType.BASE;
            }
        }) {
            @Override
            public void convert(CommonViewHolder holder, BaseBean baseBean) {
                //填充
                TextView type;
                TextView mame;
                switch (baseBean.getItemViewType()){
                    case MaterialItemViewType.BASE:
                        final BBaseBean bbaseBean = (BBaseBean) baseBean;
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(bbaseBean.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(bbaseBean.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(bbaseBean.getFlag() == 1){
                                    startActivity(BezierActivity.class);
                                }else if(bbaseBean.getFlag() == 2){
                                    startActivity(BubbleNotificationActivity.class);
                                }else if(bbaseBean.getFlag() == 3){
                                    startActivity(BezierViewActivity.class);
                                }else if(bbaseBean.getFlag() ==4){
                                    startActivity(RippleClickActivity.class);
                                }else if(bbaseBean.getFlag() == 5){
                                    startActivity(RippleClick2Activity.class);
                                }else if(bbaseBean.getFlag() == 6){
                                    startActivity(FloatingActionButtonActivity.class);
                                }else if(bbaseBean.getFlag() == 7){
                                    startActivity(SheetfabActivity.class);
                                }else if(bbaseBean.getFlag() == 8){
                                    startActivity(CircualrevealActivity.class);
                                }else if(bbaseBean.getFlag() == 9){
                                    startActivity(RangActivity.class);
                                }else if(bbaseBean.getFlag() == 10){
                                    startActivity(MaterialEdittextActivity.class);
                                }
                            }
                        });
                        break;
                    case MaterialItemViewType.BOTTOMNAVIGATION:
                        BottomNavigationBean bottomNavigationBean1 = (BottomNavigationBean) baseBean;
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_bottomnavigation, null);
//                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(bottomNavigationBean1.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(bottomNavigationBean1.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(BottomNavigationActivity.class);
                            }
                        });
                        break;
                    case MaterialItemViewType.SILIDE:
                        SlideBean slideBean = (SlideBean) baseBean;
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_slide, null);
//                        linearLayout.addView(view);
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
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_flyco, null);
//                        linearLayout.addView(view);
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
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_pdfview, null);
//                        linearLayout.addView(view);
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
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_richtext, null);
//                        linearLayout.addView(view);
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
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_guide, null);
//                        linearLayout.addView(view);
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
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_showcase, null);
//                        linearLayout.addView(view);
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
                    case MaterialItemViewType.CARDSTACKVIEW:
                        CardStackBean csb = (CardStackBean) baseBean;
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_showcase, null);
//                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(csb.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(csb.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(CardStackViewActivity.class);
                            }
                        });
                        break;
                    case MaterialItemViewType.LIQUIDB:
                        LiquidBean lb = (LiquidBean) baseBean;
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_liquidbutton, null);
//                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(lb.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(lb.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(LiquidButtonActivity.class);
                            }
                        });
                        break;
                    case MaterialItemViewType.CARDSLIDE:
                        CardSlideBean csbn = (CardSlideBean) baseBean;
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_cardslide, null);
//                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(csbn.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(csbn.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(CardSlideActivity.class);
                            }
                        });
                        break;
                    case MaterialItemViewType.EXPANDINGPAGER:
                        ExpandingPagerBean epb = (ExpandingPagerBean) baseBean;
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_expandingpager, null);
//                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(epb.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(epb.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(ExpandingpagerActivity.class);
                            }
                        });
                        break;
                    case MaterialItemViewType.LOADINGVIEW:
                        LoadingBean lbn = (LoadingBean) baseBean;
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_loading, null);
//                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(lbn.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(lbn.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(LoadingActivity.class);
                            }
                        });
                        break;
                    case MaterialItemViewType.LOADDRAWABLE:
                        LoadDrawableBean ldb = (LoadDrawableBean) baseBean;
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_loading, null);
//                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(ldb.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(ldb.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(LoadDrawableActivity.class);
                            }
                        });
                        break;
                    case MaterialItemViewType.LOADVIEW:
                        LoadViewBean lvb = (LoadViewBean) baseBean;
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_loading, null);
//                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(lvb.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(lvb.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(LoadViewActivity.class);
                            }
                        });
                        break;
                    case MaterialItemViewType.MATEBALLLOADING:
                        MateBallLoadingBean mblb = (MateBallLoadingBean) baseBean;
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_loading, null);
//                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(mblb.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(mblb.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(MateBallLoadingActivity.class);
                            }
                        });
                        break;
                    case MaterialItemViewType.MULTIDIALOG:
                        MultiDialogBean mdb = (MultiDialogBean) baseBean;
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_base, null);
//                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(mdb.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(mdb.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(MultiDialogActivity.class);
                            }
                        });
                        break;
                    case MaterialItemViewType.STEPVIEW:
                        final StepViewBean svb = (StepViewBean) baseBean;
//                        layoutInflater = LayoutInflater.from(MaterialDesign.this);
//                        view = layoutInflater.inflate(R.layout.item_base, null);
//                        linearLayout.addView(view);
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(svb.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(svb.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(svb.getFlag() == 1){
                                    startActivity(IndicatorStepViewActivity.class);
                                }else if(svb.getFlag() == 2){
                                    startActivity(IndicatorStepView2Activity.class);
                                }else if(svb.getFlag() == 3){
                                    startActivity(IndicatorStepView3Activity.class);
                                }
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
