package com.design.material.materialdesign.multidialog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.MenuItem;
import android.view.View;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;

@SuppressLint("NewApi")
public class PreferenceActivity extends BaseActivity {

  @Override
  protected View getRootView() {
    return View.inflate(this, R.layout.preference_activity_custom, null);
  }

  @Override
  protected void initView() {
    if (getFragmentManager().findFragmentById(R.id.content_frame) == null) {
      getFragmentManager()
              .beginTransaction()
              .replace(R.id.content_frame, new SettingsFragment())
              .commit();
    }
  }

  @Override
  protected void initData() {

  }

  @Override
  protected void initListener() {

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      onBackPressed();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  public static class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      addPreferencesFromResource(R.xml.preferences);
    }
  }
}
