package com.example.liang.arlvyou.lanjiazai;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liang.arlvyou.R;

/**
 * Created by liang on 2018/5/6.
 */
public class TestLazyFragmentPagerAdapterActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ((LazyViewPager) findViewById(R.id.lazy_view_pager)).setAdapter(new CustomLazyFragmentPagerAdapter(getSupportFragmentManager()));
    }

    private static class CustomLazyFragmentPagerAdapter extends LazyFragmentPagerAdapter {

        private CustomLazyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(ViewGroup container, int position) {
            return CustomFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 6;
        }

    }

    public static class CustomFragment extends Fragment implements LazyFragmentPagerAdapter.Laziable {

        private static final String KEY_POSITION = "position";

        private static CustomFragment newInstance(int position) {
            CustomFragment customFragment = new CustomFragment();
            Bundle args = new Bundle(1);
            args.putInt(KEY_POSITION, position);
            customFragment.setArguments(args);
            return customFragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return buildItemView(getArguments().getInt(KEY_POSITION));
        }

        private View buildItemView(int position) {
            View view=getLayoutInflater().inflate(R.layout.fm_layout1,null);
            return view;
        }
    }

}