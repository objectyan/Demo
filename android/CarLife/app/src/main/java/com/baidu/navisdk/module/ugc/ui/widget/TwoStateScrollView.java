package com.baidu.navisdk.module.ugc.ui.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.baidu.navisdk.util.common.LogUtil;

public class TwoStateScrollView extends LinearLayout {
    private static final String TAG = TwoStateScrollView.class.getSimpleName();
    public int blankSpaceHeight;
    boolean enableBg;
    boolean enableTitleAnim;
    public int foldableHeight;
    private boolean gotoFlag;
    public boolean hasActionDown;
    boolean hasMoveScroll;
    public boolean heightsInited;
    public boolean isScrolling;
    private EventCatchListener mEventCatchListener;
    public int mLastY;
    private OnStatusChangeListener mOnStatusChangeListener;
    private int mScrollEnd;
    public int mScrollStart;
    public Scroller mScroller;
    private View mTitleContainer;
    private VelocityTracker mVelocityTracker;
    private View mViewBg;
    public boolean needScroll;
    private boolean needStatusChangeAlways;
    public int persistantHeight;
    public DragState status;
    boolean statusChange;
    public int titleHeight;
    public int topMargin;

    public enum DragState {
        TOP,
        BOTTOM
    }

    public interface EventCatchListener {
        void onEventCatch(MotionEvent motionEvent);
    }

    public interface OnStatusChangeListener {
        void onStatusChange(DragState dragState);
    }

    public TwoStateScrollView(Context context) {
        this(context, null);
        this.mScroller = new Scroller(context);
    }

    public TwoStateScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.foldableHeight = 0;
        this.heightsInited = false;
        this.statusChange = false;
        this.needScroll = false;
        this.hasMoveScroll = false;
        this.enableTitleAnim = false;
        this.enableBg = false;
        this.gotoFlag = false;
        this.needStatusChangeAlways = false;
        this.hasActionDown = false;
        this.topMargin = 0;
        this.status = DragState.TOP;
        this.mEventCatchListener = null;
        this.mScroller = new Scroller(context);
    }

    public TwoStateScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.foldableHeight = 0;
        this.heightsInited = false;
        this.statusChange = false;
        this.needScroll = false;
        this.hasMoveScroll = false;
        this.enableTitleAnim = false;
        this.enableBg = false;
        this.gotoFlag = false;
        this.needStatusChangeAlways = false;
        this.hasActionDown = false;
        this.topMargin = 0;
        this.status = DragState.TOP;
        this.mEventCatchListener = null;
        this.mScroller = new Scroller(context);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    public void setTitleContainer(View view, int viewHeight) {
        this.mTitleContainer = view;
        this.titleHeight = viewHeight;
    }

    public void setHeights(int persistantHeight, int totalHeight) {
        this.persistantHeight = persistantHeight;
        this.blankSpaceHeight = totalHeight - persistantHeight;
        this.foldableHeight = this.blankSpaceHeight;
        this.heightsInited = true;
        LogUtil.m15791e(TAG, "setHeights: --> foldableHeight: " + this.foldableHeight + ", persistantHeight: " + persistantHeight + ", blankSpaceHeight: " + this.blankSpaceHeight);
    }

    public void setTitleAnimEnabled(boolean enableTitleAnim) {
        this.enableTitleAnim = enableTitleAnim;
    }

    public void setViewBg(View mViewBg) {
        this.mViewBg = mViewBg;
    }

    public void setEnableBg(boolean enableBg) {
        this.enableBg = enableBg;
    }

    public void setScrollSupport(boolean needScroll) {
        this.needScroll = needScroll;
        LogUtil.m15791e(TAG, "setScrollSupport : needScroll --> " + needScroll);
    }

    public void setTopMargin(int topMargin) {
        this.topMargin = topMargin;
        LayoutParams params = getLayoutParams();
        if (params != null && (params instanceof MarginLayoutParams)) {
            ((MarginLayoutParams) params).setMargins(((MarginLayoutParams) params).leftMargin, topMargin, ((MarginLayoutParams) params).rightMargin, ((MarginLayoutParams) params).bottomMargin);
            setLayoutParams(params);
        }
    }

    public int getTopMargin() {
        return this.topMargin;
    }

    public boolean goToTop() {
        if (!this.heightsInited) {
            LogUtil.m15791e(TAG, "gotoTop: heightsInited --> " + this.heightsInited);
            return false;
        } else if (this.status == DragState.TOP) {
            LogUtil.m15791e(TAG, "gotoTop: status already --> " + this.status);
            return false;
        } else {
            if (this.mScroller != null) {
                this.mScroller.startScroll(0, getScrollY(), 0, this.foldableHeight);
                this.statusChange = true;
                this.isScrolling = true;
                this.gotoFlag = true;
                this.hasMoveScroll = true;
                postInvalidate();
            }
            return true;
        }
    }

    public boolean goToBottom() {
        return goToBottom(250);
    }

    public boolean goToBottom(int duration) {
        if (!this.heightsInited) {
            LogUtil.m15791e(TAG, "goToBottom: heightsInited --> " + this.heightsInited);
            return false;
        } else if (this.status == DragState.BOTTOM) {
            LogUtil.m15791e(TAG, "goToBottom: status already --> " + this.status);
            return false;
        } else {
            if (this.mScroller != null) {
                this.mScroller.startScroll(0, getScrollY(), 0, -this.foldableHeight, duration);
                this.statusChange = true;
                this.isScrolling = true;
                this.gotoFlag = true;
                this.hasMoveScroll = true;
                postInvalidate();
            }
            return true;
        }
    }

    public DragState getCurStatus() {
        return this.status;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!this.needScroll) {
            super.onTouchEvent(event);
            return true;
        } else if (this.isScrolling) {
            super.onTouchEvent(event);
            LogUtil.m15791e(TAG, "onTouchEvent: isScrolling --> " + this.isScrolling);
            return true;
        } else {
            int y = (int) event.getY();
            int action = event.getAction();
            obtainVelocity(event);
            switch (action) {
                case 0:
                    this.mScrollStart = getScrollY();
                    if (this.mScrollStart < (-this.foldableHeight) / 2) {
                        this.status = DragState.BOTTOM;
                    } else {
                        this.status = DragState.TOP;
                    }
                    LogUtil.m15791e(TAG, "onTouchEvent: --> ACTION_DOWN: status:" + this.status + ", mScrollStart " + this.mScrollStart);
                    if (this.status == DragState.BOTTOM) {
                        if (y < this.blankSpaceHeight) {
                            LogUtil.m15791e(TAG, "onTouchEvent: --> return status_bottom: " + y);
                            return false;
                        }
                    } else if (y < (getMeasuredHeight() - this.persistantHeight) - this.foldableHeight) {
                        LogUtil.m15791e(TAG, "onTouchEvent: --> return status_top: " + y);
                        return false;
                    }
                    this.hasActionDown = true;
                    this.mLastY = y;
                    return true;
                case 1:
                    if (!this.hasActionDown) {
                        return true;
                    }
                    this.hasActionDown = false;
                    this.mScrollEnd = getScrollY();
                    int dScrollY = this.mScrollEnd - this.mScrollStart;
                    LogUtil.m15791e(TAG, "onTouchEvent: --> ACTION_UP: mScrollEnd: " + this.mScrollEnd + ", mScrollStart: " + this.mScrollStart + ", dScrollY: " + dScrollY);
                    int scrollDistance;
                    if (this.status == DragState.TOP) {
                        if ((-(this.mScrollEnd - this.mScrollStart)) > this.foldableHeight / 3) {
                            scrollDistance = -(this.foldableHeight + dScrollY);
                            LogUtil.m15791e(TAG, "onTouchEvent: startScroll 1 --> from: " + getScrollY() + ", scrollDistance: " + scrollDistance);
                            if (scrollDistance == 0) {
                                return true;
                            }
                            this.mScroller.startScroll(0, getScrollY(), 0, scrollDistance);
                            this.status = DragState.BOTTOM;
                            this.statusChange = true;
                            this.hasMoveScroll = true;
                            this.isScrolling = true;
                            postInvalidate();
                            recycleVelocity();
                            return true;
                        }
                        scrollDistance = -dScrollY;
                        LogUtil.m15791e(TAG, "onTouchEvent: startScroll 2 --> from: " + getScrollY() + ", scrollDistance: " + scrollDistance);
                        if (scrollDistance == 0) {
                            return true;
                        }
                        this.mScroller.startScroll(0, getScrollY(), 0, scrollDistance);
                        this.hasMoveScroll = true;
                        this.isScrolling = true;
                        postInvalidate();
                        recycleVelocity();
                        return true;
                    } else if (this.mScrollEnd - this.mScrollStart > this.foldableHeight / 3) {
                        scrollDistance = this.foldableHeight - dScrollY;
                        LogUtil.m15791e(TAG, "onTouchEvent: startScroll 3 --> from: " + getScrollY() + ", scrollDistance: " + scrollDistance);
                        if (scrollDistance == 0) {
                            return true;
                        }
                        this.status = DragState.TOP;
                        this.statusChange = true;
                        this.hasMoveScroll = true;
                        this.mScroller.startScroll(0, getScrollY(), 0, scrollDistance);
                        this.isScrolling = true;
                        postInvalidate();
                        recycleVelocity();
                        return true;
                    } else {
                        scrollDistance = -dScrollY;
                        LogUtil.m15791e(TAG, "onTouchEvent: startScroll 4 --> from: " + getScrollY() + ", scrollDistance: " + scrollDistance);
                        if (scrollDistance == 0) {
                            return true;
                        }
                        this.mScroller.startScroll(0, getScrollY(), 0, scrollDistance);
                        this.hasMoveScroll = true;
                        this.isScrolling = true;
                        postInvalidate();
                        recycleVelocity();
                        return true;
                    }
                case 2:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                    }
                    int dy = this.mLastY - y;
                    int scrollY = getScrollY();
                    LogUtil.m15791e(TAG, "onTouchEvent: --> ACTION_MOVE: dy:" + dy + ", scrollY " + scrollY);
                    if (dy > 0 && dy + scrollY > 0) {
                        LogUtil.m15791e(TAG, "onTouchEvent: --> break ACTION_MOVE 1: dy: " + dy + ", scrollY: " + scrollY);
                        dy = -scrollY;
                        return true;
                    } else if ((-scrollY) - dy > this.foldableHeight) {
                        LogUtil.m15791e(TAG, "onTouchEvent: --> break ACTION_MOVE 2: dy: " + dy + ", scrollY: " + scrollY);
                        dy = -dy;
                        return true;
                    } else {
                        onScrollChanged(scrollY);
                        scrollBy(0, dy);
                        this.mLastY = y;
                        return true;
                    }
                default:
                    return true;
            }
        }
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.mScroller.computeScrollOffset()) {
            int y = this.mScroller.getCurrY();
            scrollTo(0, y);
            LogUtil.m15791e(TAG, "computeScroll: scrollTo: y --> " + y);
            invalidate();
            onScrollChanged(y);
            return;
        }
        if (this.statusChange) {
            if (getScrollY() < (-this.foldableHeight) / 2) {
                if (!(this.mOnStatusChangeListener == null || this.gotoFlag)) {
                    this.mOnStatusChangeListener.onStatusChange(DragState.BOTTOM);
                }
                this.status = DragState.BOTTOM;
            } else {
                if (!(this.mOnStatusChangeListener == null || this.gotoFlag)) {
                    this.mOnStatusChangeListener.onStatusChange(DragState.TOP);
                }
                this.status = DragState.TOP;
            }
            LogUtil.m15791e(TAG, "computeScroll: onStatusChange --> status: " + this.status + ", gotoFlag: " + this.gotoFlag + ", scrollY: " + getScrollY());
            this.statusChange = false;
        }
        this.isScrolling = false;
        if (this.hasMoveScroll) {
            LogUtil.m15791e(TAG, "computeScroll: hasMoveScroll --> " + this.hasMoveScroll + ", status: " + this.status);
            if (this.status == DragState.BOTTOM) {
                scrollTo(0, -this.foldableHeight);
                onScrollChanged(-this.foldableHeight);
            } else {
                scrollTo(0, 0);
                onScrollChanged(0);
            }
            this.hasMoveScroll = false;
            if (this.needStatusChangeAlways) {
                this.statusChange = true;
            }
        }
        this.gotoFlag = false;
    }

    private void onScrollChanged(int currScrollY) {
        LogUtil.m15791e(TAG, "onScrollChanged: currScrollY --> " + currScrollY);
        if (currScrollY <= 0) {
            currScrollY = -currScrollY;
        } else {
            currScrollY = 0;
        }
        if (this.enableTitleAnim && this.mTitleContainer != null && this.titleHeight > 0) {
            double completePercentage = 1.0d - ((((double) currScrollY) * 1.0d) / ((double) this.titleHeight));
            LogUtil.m15791e(TAG, "onScrollChanged: completePercentage --> " + completePercentage);
            if (completePercentage < 0.0d) {
                completePercentage = 0.0d;
            }
            if (VERSION.SDK_INT >= 11) {
                this.mTitleContainer.setAlpha((float) completePercentage);
                this.mTitleContainer.invalidate();
            }
        }
        if (this.enableBg && this.mViewBg != null) {
            LayoutParams params = this.mViewBg.getLayoutParams();
            params.height = getMeasuredHeight() - currScrollY;
            this.mViewBg.setLayoutParams(params);
        }
    }

    private int getVelocity() {
        this.mVelocityTracker.computeCurrentVelocity(1000);
        return (int) this.mVelocityTracker.getYVelocity();
    }

    private void recycleVelocity() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void obtainVelocity(MotionEvent event) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(event);
    }

    public void setOnStatusChangeListener(OnStatusChangeListener onStatusChangeListener) {
        this.mOnStatusChangeListener = onStatusChangeListener;
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean ret = super.dispatchTouchEvent(ev);
        if (this.mEventCatchListener != null) {
            this.mEventCatchListener.onEventCatch(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void setOnEventCatchListener(EventCatchListener mEventCatchListener) {
        this.mEventCatchListener = mEventCatchListener;
    }

    public void setNeedStatusChangeAlways(boolean needStatusChangeAlways) {
        this.needStatusChangeAlways = needStatusChangeAlways;
    }

    public int getFoldableHeight() {
        return this.foldableHeight;
    }
}
