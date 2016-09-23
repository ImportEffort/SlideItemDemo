package com.zheteng.wsj.studysavainstance;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/**
 * Created by wsj20 on 2016/9/22.
 */

public class LeftFragment extends Fragment {

    private RecyclerView mLeftView;
    private ArrayList<LeftItem> mItems;
    private ALeftRecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLeftView = (RecyclerView) inflater.inflate(R.layout.left_fragment, container, false);
        return mLeftView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initLeftRecyclerView();
    }

    private void initLeftRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mLeftView.getContext(), LinearLayoutManager.VERTICAL, false);
        mLeftView.setLayoutManager(layoutManager);
        //准备数据
        prepareData();
        mAdapter = new ALeftRecyclerAdapter(mItems);
        mAdapter.setOnItemSelectListener(new ALeftRecyclerAdapter.OnItemSelectListener() {
            @Override
            public void onItemSelect(Object obj) {
                int seclection = (int) obj;
                setRightShow(seclection);
            }
        });
        mLeftView.setAdapter(mAdapter);
        mLeftView.post(new Runnable() {
            @Override
            public void run() {
                setRightShow(0);
            }
        });

    }


    private void setRightShow(int i) {
        RightFragment rightFragment = (RightFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.right_frame);
        //正常情况下这里应该获取网络数据并显示
        rightFragment.setText(i);
    }

    /**
     * 准备集合数据
     */
    private void prepareData() {
        mItems = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            LeftItem item1 = new LeftItem("推荐分类");
            mItems.add(item1);
            LeftItem item2 = new LeftItem("潮流女装");
            mItems.add(item2);
            LeftItem item3 = new LeftItem("品牌男装");
            mItems.add(item3);
            LeftItem item4 = new LeftItem("家用电器");
            mItems.add(item4);
            LeftItem item5 = new LeftItem("电脑办公");
            mItems.add(item5);
            LeftItem item6 = new LeftItem("手机数码");
            mItems.add(item6);
            LeftItem item7 = new LeftItem("母婴童装");
            mItems.add(item7);
            LeftItem item8 = new LeftItem("图书影像");
            mItems.add(item8);
            LeftItem item9 = new LeftItem("家居家纺");
            mItems.add(item9);
            LeftItem item10 = new LeftItem("居家生活");
            mItems.add(item10);
            LeftItem item11 = new LeftItem("家居建材");
            mItems.add(item11);
            LeftItem item12 = new LeftItem("家居建材");
            mItems.add(item12);
            LeftItem item13 = new LeftItem("家居建材");
            mItems.add(item13);
            LeftItem item14 = new LeftItem("家居建材");
            mItems.add(item14);
        }

    }
}
