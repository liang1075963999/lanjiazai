package com.example.liang.arlvyou.lanjiazai;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liang.arlvyou.R;

/**
 * Created by liang on 2018/5/6.
 */
public class TestLazyViewPagerAdapterActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ((LazyViewPager) findViewById(R.id.lazy_view_pager)).setAdapter(new CustomLazyViewPagerAdapter(this));
    }

    public static class CustomLazyViewPagerAdapter extends LazyViewPagerAdapter {

        private final Context mContext;

        private CustomLazyViewPagerAdapter(Context context) {
            mContext = context;
        }

        @Override
        public View getItem(ViewGroup container, int position) {
            return buildItemView(position);
        }

        @Override
        public int getCount() {
            return 4;
        }

        private View buildItemView(int position) {
            View view= LayoutInflater.from(mContext).inflate(R.layout.fm_layout1,null);
            return view;
        }
    }

}