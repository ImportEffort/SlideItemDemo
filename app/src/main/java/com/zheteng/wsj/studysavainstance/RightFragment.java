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

public class RightFragment extends Fragment {

    private RecyclerView mRightView;
    private RightRecycerAdpater mAdapter;
    private ArrayList<RightItem> mDatas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRightView = (RecyclerView) inflater.inflate(R.layout.right_fragment, container, false);
        return mRightView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRightRecyclerView(view);
    }

    private void initRightRecyclerView(View view) {
        mRightView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        mDatas = new ArrayList<>();
        prepareDatas(mDatas);
        mAdapter = new RightRecycerAdpater(mDatas);
        mRightView.setAdapter(mAdapter);
    }

    private void prepareDatas(ArrayList<RightItem> datas) {
        datas.add(new RightItem("我是第一个条目内容"));
    }

    /**
     * 控制右侧fragment的布局显示
     * @param postion
     */
    public void setText(int postion) {
        if (mDatas!=null) {
            mDatas.clear();
            mDatas.add(new RightItem("我是第" + postion + "条目"));
            mAdapter.notifyDataSetChanged();
        }
    }
}
