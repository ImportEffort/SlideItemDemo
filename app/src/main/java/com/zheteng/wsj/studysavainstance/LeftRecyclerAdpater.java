package com.zheteng.wsj.studysavainstance;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by wsj20 on 2016/9/22.
 */
public class LeftRecyclerAdpater extends BaseQuickAdapter<LeftItem> {

    public LeftRecyclerAdpater(List<LeftItem> data) {
        super(R.layout.left_fragment_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, LeftItem leftItem) {

        baseViewHolder.setText(R.id.tv_left_item,leftItem.item)
        .addOnClickListener(R.id.tv_left_item);

    }


}
