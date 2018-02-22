package com.jackchen.view_day14;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Email 2185134304@qq.com
 * Created by JackChen on 2018/2/10.
 * Version 1.0
 * Description:
 */
public class ViewDragListView extends FrameLayout {

    //可以认为这个是系统给我们写好的工具类
    private ViewDragHelper mDragHelper ;

    public ViewDragListView(@NonNull Context context) {
        this(context,null);
    }

    public ViewDragListView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewDragListView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mDragHelper = ViewDragHelper.create(this , mDragHelperCallback) ;

    }

    //1. 拖动我们的子View，也就是VerticalDragListView里边包裹的子布局
    private ViewDragHelper.Callback mDragHelperCallback = new ViewDragHelper.Callback() {

        //指定该子View是否可以拖动,就是child。 返回true的目的就是我让VerticalDragListView里边包裹的所有子View都返回true
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return true;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            //垂直拖动移动的位置
            return top;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            //水平拖动移动的位置
            return left;
        }
    } ;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //表示把onTouchEvent触摸事件交给mDragHelper来处理
        mDragHelper.processTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
