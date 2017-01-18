package com.ouyben.animationdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ListView mListview;
    private FloatingActionButton mFab;

    private ArrayAdapter<String> mAdapter;
    private Context mContext;
    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        mContext = this;
        mList.add("ValueAnimator动画方式改变textview字体大小");
        mList.add("ObjectAnimator方式改变textview字体大小");
        mList.add("ObjectAnimator方式组合改变text属性");
        mList.add("XML方式改变text属性");
        mAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, mList);
        mListview.setAdapter(mAdapter);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        ValueAnimatorActivity.startActivity(mContext);
                        break;
                    case 1:
                        ObjectAnimatorActivity.startActivity(mContext);
                        break;
                    case 2:
                        CombinedAnimationActivity.startActivity(mContext);
                        break;
                    case 3:
                        XMLAnimActivity.startActivity(mContext);
                        break;

                }
            }
        });
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mListview = (ListView) findViewById(R.id.listview);

        mToolbar.setTitle("属性动画");
        setSupportActionBar(mToolbar);
    }

}
