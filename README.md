# SlideItemDemo
仿京东侧边栏条目显示效果

最近在研究商城类的App实现，此demo是仿照京东商城的商品分类列表界面的简单实现

遇到的困难：

1. 如何让RecyclerView实现默认选中第一栏数据
2. 如何让RecyclerView点击不同的条目实现选中效果

效果如下图所示


问题1 RecyclerView实现默认选中第一栏数据 实现方法

        //设置默认选中第一项
        mLeftView.post(new Runnable() {
            @Override
            public void run() {
                //设置右侧栏目数据显示的内容
                setRightShow(0);
            }
        });
​	一开始我是在RecyclerView setAdapter后，通过直接使用 getChildAt(0) 来获取第一项对应的 View的，但是却一直报空指针异常，通过打印getChildCount发现在设置setAdapter后的RecyclerView的子view数量还是0，所以造成这个空指针也理所当然了。

​	通过翻阅资料，终于在http://blog.csdn.net/foruok/article/details/43321071的博客下找到了相关的解决办法：

> 一开始我在调用了 ListView 的 setAdapter 方法后，直接使用 getChildAt(1) 来获取第二项对应的 View ，你猜到了，没错，崩溃了： NullPointerException 。空指针啊，用 C++ 时的老情人，改用 Java 写 Android 了，她又跑来和我约会了。
>
> 搞了半天，我才弄明白： **setAdapter() 其实是异步的** ，调用了这个方法， ListView 的 item 并没有立马创建，而是在下一轮消息处理时才创建。弄明白了这个，就有了前面代码中的解决办法：**使用 post() 提交一个 Runnable() 对象，在 Runnable() 内部来做默认选中这种初始化动作**。



2. 如何让RecyclerView点击不同的条目实现选中效果

   实现思路：在viewholder中设置textView的点击事件，然后通过getAdapterPosition的方法拿到当前点击的条目的位置，然后调用notify方法更新条目，因为调用notify后adpter会冲洗调用onBindViewHolder方法，所以我们可以在该方法中根据记录的位置来设置所以条目应该显示的颜色和背景：

   ```
   //记录点击的位置
   selectPosition = getAdapterPosition();
   //刷新数据会再次走onBindViewHolder方法在该方法中改变条目的背景
   notifyDataSetChanged();
   ```

   ```
   //根据条目效果切换条目背景和文字颜色
   holder.tv_item.setBackgroundColor(position == selectPosition ? holder.itemView.getResources().getColor(R.color.colorPrimary) : Color.WHITE);
   holder.tv_item.setTextColor(position == selectPosition ? Color.WHITE : Color.BLACK);
   ```

 

![默认展示第一条数据.png](https://ooo.0o0.ooo/2016/09/23/57e529acb6cc7.png)

