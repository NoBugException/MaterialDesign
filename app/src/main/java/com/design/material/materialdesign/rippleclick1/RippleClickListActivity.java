package com.design.material.materialdesign.rippleclick1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.design.material.materialdesign.R;

import java.util.UUID;

public class RippleClickListActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private final static String[] data;

    static {
        data = new String[50];
        for (int i = 0; i < data.length; i++) {
            data[i] = UUID.randomUUID().toString();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_list);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new ArrayAdapter<>(this, R.layout.demo_list_item, android.R.id.text1, data));
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(position%2==0){
                    Toast.makeText(RippleClickListActivity.this, "long item: " + position +" and not consumed", Toast.LENGTH_SHORT).show();
                    return false;
                }
                Toast.makeText(RippleClickListActivity.this, "long item: " + position +" and consumed", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Rippled item: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.switch_button) {
            startActivity(new Intent(this, RippleClickActivity.class));
            finish();
            return true;
        } else if (id == R.id.switch_recycler) {
            startActivity(new Intent(this, RippleClickRecyclerActivity.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
