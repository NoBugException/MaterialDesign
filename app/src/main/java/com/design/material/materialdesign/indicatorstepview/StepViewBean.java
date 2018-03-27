package com.design.material.materialdesign.indicatorstepview;

import com.design.material.materialdesign.BaseBean;
import com.design.material.materialdesign.MaterialItemViewType;

/**
 * Created by beixinyuan_android on 2018/3/27.
 */

public class StepViewBean extends BaseBean {

    private int flag;

    @Override
    public int getItemViewType() {
        return MaterialItemViewType.STEPVIEW;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
