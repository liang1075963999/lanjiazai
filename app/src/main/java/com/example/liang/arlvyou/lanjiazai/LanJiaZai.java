package com.example.liang.arlvyou.lanjiazai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

/**
 * Created by liang on 2018/5/6.
 */

public class LanJiaZai extends Activity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, Arrays.asList(new String[]{"LazyViewPagerAdapter", "LazyFragmentPagerAdapter"})));
        listView.setOnItemClickListener(this);
        setContentView(listView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if (position == 0) {
            startActivity(new Intent(this, TestLazyViewPagerAdapterActivity.class));
        } else {
            startActivity(new Intent(this, TestLazyFragmentPagerAdapterActivity.class));
        }
    }

}
