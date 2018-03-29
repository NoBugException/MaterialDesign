package com.design.material.materialdesign.mateballloading;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;

/**
 * Created by beixinyuan_android on 2018/3/26.
 */

public class MateBallLoadingActivity extends BaseActivity implements SeekBar.OnSeekBarChangeListener{

    private MetaballView metaballView;
    private MetaballDebugView debugMetaballView;
    private SeekBar seekBar, seekBar2, seekBar3;

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_mateballloading, null);
    }

    @Override
    protected void initView() {
        metaballView = (MetaballView) this.findViewById(R.id.metaball);
        debugMetaballView = (MetaballDebugView) findViewById(R.id.debug_metaball);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        seekBar.setOnSeekBarChangeListener(this);
        seekBar2.setOnSeekBarChangeListener(this);
        seekBar3.setOnSeekBarChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mateballloading, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_fill) {
            metaballView.setPaintMode(1);
            debugMetaballView.setPaintMode(1);
            return true;
        } else if (id == R.id.action_strock) {
            metaballView.setPaintMode(0);
            debugMetaballView.setPaintMode(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


        @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            switch (seekBar.getId()) {
                case R.id.seekBar:
                    debugMetaballView.setMaxDistance(progress);
                    break;
                case R.id.seekBar2:
                    debugMetaballView.setMv(progress / 100f);
                    break;
                case R.id.seekBar3:
                    debugMetaballView.setHandleLenRate(progress / 100f);
                    break;
            }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
