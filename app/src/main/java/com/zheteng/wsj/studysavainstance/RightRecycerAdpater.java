package com.zheteng.wsj.studysavainstance;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by wsj20 on 2016/9/22.
 */
public class RightRecycerAdpater extends BaseQuickAdapter<RightItem> {


    public RightRecycerAdpater(List<RightItem> data) {
        super(R.layout.right_fragment_item,data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, RightItem rightItem) {
        baseViewHolder.setText(R.id.tv_right_item,rightItem.title);
    }
}
