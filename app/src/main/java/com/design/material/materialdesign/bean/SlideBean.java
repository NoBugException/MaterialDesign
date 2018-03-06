package com.design.material.materialdesign.bean;

import com.design.material.materialdesign.Constant.MaterialItemViewType;

/**
 * Created by beixinyuan_android on 2018/3/5.
 */

public class SlideBean extends BaseBean{
    //第一种滑动
    private String modelName1;
    //第二种滑动
    private String modelName2;
    //第三种滑动
    private String modelName3;

    @Override
    public int getItemViewType() {
        return MaterialItemViewType.SILIDE;
    }

    public String getModelName1() {
        return modelName1;
    }

    public void setModelName1(String modelName1) {
        this.modelName1 = modelName1;
    }

    public String getModelName2() {
        return modelName2;
    }

    public void setModelName2(String modelName2) {
        this.modelName2 = modelName2;
    }

    public String getModelName3() {
        return modelName3;
    }

    public void setModelName3(String modelName3) {
        this.modelName3 = modelName3;
    }
}
