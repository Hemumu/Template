package com.helin.template.view.common;


import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by helin on 2017/1/19.
 * 监听Recyclerview滑动到底部
 */
public class OnRcvScrollListener extends RecyclerView.OnScrollListener {


    public void onBottom() {

    }

    public void onScroll() {

    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

        //得到当前显示的最后一个item的view
        View lastChildView = recyclerView.getLayoutManager().getChildAt(recyclerView.getLayoutManager().getChildCount() - 1);
        //得到lastChildView的bottom坐标值
        int lastChildBottom = 0;
        int recyclerBottom = 0;
        int lastPosition = 0;
        if (lastChildView != null) {
            lastChildBottom = lastChildView.getBottom();
            //得到Recyclerview的底部坐标减去底部padding值，也就是显示内容最底部的坐标
            recyclerBottom = recyclerView.getBottom() - recyclerView.getPaddingBottom();
            //通过这个lastChildView得到这个view当前的position值
            lastPosition = recyclerView.getLayoutManager().getPosition(lastChildView);
        }

        //判断lastChildView的bottom值跟recyclerBottom
        //判断lastPosition是不是最后一个position
        //如果两个条件都满足则说明是真正的滑动到了底部
        if (lastChildBottom == recyclerBottom && lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {
            onBottom();
        } else {
            if (lastPosition < recyclerView.getLayoutManager().getItemCount() - 5) {
                onScroll();
            }
        }
    }


}
