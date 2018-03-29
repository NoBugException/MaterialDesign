package com.design.material.materialdesign.showcaseview;/*
 * Copyright 2014 Alex Curran
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.view.View;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.SimpleShowcaseEventListener;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class MemoryManagementTesting extends BaseActivity {

    int currentShowcase = 1;

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.layout_showcaseview, null);
    }

    @Override
    protected void initView() {
        showcase();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    private void showcase() {
        new ShowcaseView.Builder(this)
                .withMaterialShowcase()
                .setContentText(String.format("Showing %1$d", currentShowcase))
                .setTarget(new ViewTarget(R.id.buttonBlocked, this))
                .setShowcaseEventListener(
                        new SimpleShowcaseEventListener() {
                            @Override
                            public void onShowcaseViewDidHide(ShowcaseView showcaseView) {
                                currentShowcase++;
                                showcase();
                            }
                        }
                )
                .build();
    }

}
