package com.baidu.navisdk.lightnavi.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class LightNaviUpSlideRelativeLayout extends RelativeLayout {
    private Context mContext;
    private View mRoot;
    private int mScreenHeigh;
    private Scroller mScroller;
    private SlideListerner mSlideListerner = null;
    private Handler mhandler = new Handler(Looper.getMainLooper());
    private int originY = -1;
    private BNWorkerNormalTask<String, String> rootViewHandlerTask = new BNWorkerNormalTask<String, String>("rootViewHandlerTask-" + getClass().getSimpleName(), null) {
        protected String execute() {
            LogUtil.m15791e("wangyang", "rootViewHandlerRunable");
            LightNaviUpSlideRelativeLayout.this.mScroller.setFinalY(0);
            if (BNLightNaviManager.getInstance().getType() == 2) {
                LightNaviUpSlideRelativeLayout.this.mRoot.setVisibility(8);
            } else {
                LightNaviUpSlideRelativeLayout.this.mRoot.setVisibility(0);
            }
            return null;
        }
    };

    public interface SlideListerner {
        void onDeblocking();
    }

    public LightNaviUpSlideRelativeLayout(Context context) {
        super(context);
        this.mContext = context;
        this.mRoot = JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_ipo_up_slide_relativelayout, this);
        this.mScroller = new Scroller(this.mContext, new BounceInterpolator());
        this.mScreenHeigh = ScreenUtil.getInstance().getHeightPixels();
        setClickable(true);
        setEnabled(true);
    }

    public LightNaviUpSlideRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.mRoot = JarUtils.inflate((Activity) context, C4048R.layout.nsdk_layout_ipo_up_slide_relativelayout, this);
        this.mScroller = new Scroller(this.mContext, new BounceInterpolator());
        this.mScreenHeigh = ScreenUtil.getInstance().getHeightPixels();
        setClickable(true);
        setEnabled(true);
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 0) {
            this.originY = (int) event.getY();
        } else if (event.getAction() == 2) {
            mDelY = this.originY - ((int) event.getY());
            if (mDelY > 0) {
                scrollTo(0, mDelY);
            }
        } else {
            mDelY = this.originY - ((int) event.getY());
            if (mDelY > 0) {
                if (Math.abs(mDelY) > this.mScreenHeigh / 4) {
                    if (this.mSlideListerner != null) {
                        this.mSlideListerner.onDeblocking();
                    }
                    startBounceAnim(getScrollY(), this.mScreenHeigh, 1000);
                    BNWorkerCenter.getInstance().cancelTask(this.rootViewHandlerTask, false);
                    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.rootViewHandlerTask, new BNWorkerConfig(9, 0), 500);
                } else {
                    startBounceAnim(getScrollY(), -getScrollY(), 1000);
                }
            }
        }
        return true;
    }

    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
        }
    }

    public void startBounceAnim(int startY, int dy, int duration) {
        this.mScroller.startScroll(0, startY, 0, dy, duration);
        invalidate();
    }

    public void setSlideListerner(SlideListerner listerner) {
        this.mSlideListerner = listerner;
    }

    public void onDestory() {
        BNWorkerCenter.getInstance().cancelTask(this.rootViewHandlerTask, false);
    }
}
