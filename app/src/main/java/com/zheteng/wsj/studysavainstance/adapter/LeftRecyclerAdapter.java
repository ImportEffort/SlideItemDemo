package com.zheteng.wsj.studysavainstance.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zheteng.wsj.studysavainstance.R;
import com.zheteng.wsj.studysavainstance.entry.LeftItem;

import java.util.ArrayList;

/**
 * Created by wsj20 on 2016/9/23.
 */

public class LeftRecyclerAdapter extends RecyclerView.Adapter<LeftRecyclerAdapter.ViewHoler> {

    private ArrayList<LeftItem> mItems;
    private int selectPosition;

    public LeftRecyclerAdapter(ArrayList<LeftItem> items) {
        mItems = items;
    }

    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.left_fragment_item, parent, false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {
        holder.tv_item.setText(mItems.get(position).item);
        //根据条目效果切换条目背景和文字颜色
        holder.tv_item.setBackgroundColor(position == selectPosition ? holder.itemView.getResources().getColor(R.color.colorPrimary) : Color.WHITE);
        holder.tv_item.setTextColor(position == selectPosition ? Color.WHITE : Color.BLACK);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    class ViewHoler extends RecyclerView.ViewHolder {

        public TextView tv_item;


        public ViewHoler(View itemView) {
            super(itemView);
            tv_item = (TextView) itemView.findViewById(R.id.tv_left_item);
            tv_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //记录点击的位置
                    selectPosition = getAdapterPosition();
                    //刷新数据会再次走onBindViewHolder方法在该方法中改变条目的背景
                    notifyDataSetChanged();
                    if (listener != null) {
                        //这里只需要把条目的id传过去
                        listener.onItemSelect(selectPosition);
                    }
                }
            });
        }

    }

    OnItemSelectListener listener;

    public void setOnItemSelectListener(OnItemSelectListener listener) {
        this.listener = listener;
    }

    public interface OnItemSelectListener {
        void onItemSelect(Object obj);
    }
}
