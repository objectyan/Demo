package com.baidu.navisdk.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.LogUtil;

public class CustomLinearScrollView extends LinearLayout {
    public static final int STATUS_BOTTOM = 1;
    public static final int STATUS_TOP = 0;
    private static final String TAG = "CustomLinearScrollView";
    private int bottomHight;
    private int button;
    private boolean hasMoveScroll;
    private boolean isBreakCallback;
    private boolean isScrolling;
    private EventCatchListener mEventCatchListener;
    private int mFirstInitStatus;
    boolean mIsBeingDragged;
    public boolean mLastEventIsScroll;
    private int mLastY;
    private OnStatusChangeListener mOnStatusChangeListener;
    private int mScrollEnd;
    private int mScrollStart;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private boolean needScroll;
    private int status;
    private boolean statusChange;
    private int topBoxHeight;
    private int topHight;

    public interface OnStatusChangeListener {
        void onProgressChange(int i);

        void onStatusChange(int i);
    }

    public interface EventCatchListener {
        void onEventCatch(MotionEvent motionEvent);
    }

    public CustomLinearScrollView(Context context) {
        this(context, null);
        initScroller(context);
    }

    public CustomLinearScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.bottomHight = 0;
        this.topBoxHeight = 0;
        this.status = 0;
        this.statusChange = false;
        this.needScroll = false;
        this.hasMoveScroll = false;
        this.mLastEventIsScroll = false;
        this.mFirstInitStatus = 1;
        this.isBreakCallback = false;
        this.mIsBeingDragged = false;
        this.mEventCatchListener = null;
        initScroller(context);
    }

    @TargetApi(11)
    public CustomLinearScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.bottomHight = 0;
        this.topBoxHeight = 0;
        this.status = 0;
        this.statusChange = false;
        this.needScroll = false;
        this.hasMoveScroll = false;
        this.mLastEventIsScroll = false;
        this.mFirstInitStatus = 1;
        this.isBreakCallback = false;
        this.mIsBeingDragged = false;
        this.mEventCatchListener = null;
        initScroller(context);
    }

    private void initScroller(Context context) {
        this.mScroller = new Scroller(context);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        try {
            this.bottomHight = findViewById(C4048R.id.sub_scroll_layout).getHeight();
            this.topBoxHeight = findViewById(C4048R.id.bnav_rg_toolbox_toolbar).getHeight();
            View fadeView = findViewById(C4048R.id.sub_fade_layer);
            if (fadeView != null) {
                this.button = fadeView.getHeight();
            } else {
                this.button = 0;
            }
            this.topHight = getHeight() - this.button;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.bottomHight = getHeight() - this.topBoxHeight;
        if (this.mFirstInitStatus == 1) {
            gotoBottom(false, false);
        }
    }

    public void setScrollSupport(boolean needScroll) {
    }

    public void setInitScrollStatus(int status) {
        this.mFirstInitStatus = status;
    }

    public boolean gotoTop() {
        return gotoTop(true, true);
    }

    private boolean gotoTop(boolean showAnim, boolean needCallback) {
        if (this.status == 0 || this.mScroller == null || this.bottomHight == 0) {
            return false;
        }
        boolean z;
        LogUtil.m15791e(TAG, "gotoTop showAnim:" + showAnim + " needCallback" + needCallback);
        if (showAnim) {
            this.mScroller.startScroll(0, getScrollY(), 0, this.bottomHight);
        } else {
            this.mScroller.startScroll(0, getScrollY(), 0, this.bottomHight, 0);
        }
        this.status = 0;
        this.statusChange = true;
        this.isScrolling = true;
        if (needCallback) {
            z = false;
        } else {
            z = true;
        }
        this.isBreakCallback = z;
        this.hasMoveScroll = true;
        this.mLastEventIsScroll = false;
        postInvalidate();
        return true;
    }

    public boolean gotoBottom() {
        return gotoBottom(true, true);
    }

    private boolean gotoBottom(boolean showAnim, boolean needCallback) {
        boolean z;
        if (this.status == 1 || this.mScroller == null || this.bottomHight == 0) {
            String str = TAG;
            StringBuilder append = new StringBuilder().append("gotoBottom return : status=").append(this.status).append(" mScroller=");
            if (this.mScroller == null) {
                z = true;
            } else {
                z = false;
            }
            LogUtil.m15791e(str, append.append(z).append(" bottomHight = ").append(this.bottomHight).toString());
            return false;
        }
        LogUtil.m15791e(TAG, "gotoBottom showAnim:" + showAnim + " needCallback" + needCallback);
        if (showAnim) {
            this.mScroller.startScroll(0, getScrollY(), 0, -this.bottomHight);
        } else {
            this.mScroller.startScroll(0, getScrollY(), 0, -this.bottomHight, 0);
        }
        this.status = 1;
        this.statusChange = true;
        this.isScrolling = true;
        if (needCallback) {
            z = false;
        } else {
            z = true;
        }
        this.isBreakCallback = z;
        this.hasMoveScroll = true;
        this.mLastEventIsScroll = false;
        postInvalidate();
        return true;
    }

    public int getCurStatus() {
        if (this.bottomHight == 0) {
            return this.mFirstInitStatus;
        }
        return this.status;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (!this.needScroll) {
            return super.onInterceptTouchEvent(ev);
        }
        int action = ev.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        switch (action & 255) {
            case 0:
                this.mLastY = (int) ev.getY();
                this.mScrollStart = getScrollY();
                if (this.mScrollStart >= (-this.bottomHight) / 2) {
                    this.status = 0;
                    break;
                }
                this.status = 1;
                break;
            case 2:
                if (Math.abs(((int) ev.getY()) - this.mLastY) > this.mTouchSlop) {
                    this.mIsBeingDragged = true;
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!this.needScroll) {
            return super.onTouchEvent(event);
        }
        if (this.isScrolling) {
            super.onTouchEvent(event);
            return true;
        }
        int y = (int) event.getY();
        int action = event.getAction();
        obtainVelocity(event);
        switch (action) {
            case 0:
                if (this.status == 1) {
                    if (y < this.bottomHight + this.button) {
                        LogUtil.m15791e(TAG, "onTouchEvent ACTION_DOWN return status_bottom getY:" + y);
                        return false;
                    }
                } else if (y < this.button) {
                    LogUtil.m15791e(TAG, "onTouchEvent ACTION_DOWN return status_top getY:" + y);
                    return false;
                }
                LogUtil.m15791e(TAG, "onTouchEvent ACTION_DOWN status " + this.status + "  " + this.mScrollStart + "  ");
                this.mIsBeingDragged = true;
                this.mLastY = y;
                return true;
            case 1:
                if (!this.mIsBeingDragged) {
                    return true;
                }
                this.mIsBeingDragged = false;
                this.mScrollEnd = getScrollY();
                int dScrollY = this.mScrollEnd - this.mScrollStart;
                LogUtil.m15791e(TAG, "onTouchEvent ACTION_UP " + this.mScrollEnd + "  " + this.mScrollStart + "  " + dScrollY);
                if (this.status == 0) {
                    if ((-(this.mScrollEnd - this.mScrollStart)) > this.bottomHight / 3) {
                        this.mScroller.startScroll(0, getScrollY(), 0, -(this.bottomHight + dScrollY));
                        LogUtil.m15791e(TAG, "onTouchEvent ACTION_UP 1");
                        this.status = 1;
                        this.statusChange = true;
                        this.hasMoveScroll = true;
                    } else {
                        this.mScroller.startScroll(0, getScrollY(), 0, -dScrollY);
                        this.hasMoveScroll = true;
                        LogUtil.m15791e(TAG, "onTouchEvent ACTION_UP 2");
                    }
                } else if (this.mScrollEnd - this.mScrollStart > (this.topHight - this.bottomHight) / 3) {
                    this.status = 0;
                    this.statusChange = true;
                    this.hasMoveScroll = true;
                    this.mScroller.startScroll(0, getScrollY(), 0, this.bottomHight - dScrollY);
                    LogUtil.m15791e(TAG, "onTouchEvent ACTION_UP 3");
                } else {
                    this.mScroller.startScroll(0, getScrollY(), 0, -dScrollY);
                    this.hasMoveScroll = true;
                    LogUtil.m15791e(TAG, "onTouchEvent ACTION_UP 4");
                }
                this.isScrolling = true;
                this.mLastEventIsScroll = true;
                postInvalidate();
                recycleVelocity();
                return true;
            case 2:
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                int dy = this.mLastY - y;
                int scrollY = getScrollY();
                int percent = (int) ((((float) scrollY) / ((float) this.bottomHight)) * 100.0f);
                if (this.mOnStatusChangeListener != null) {
                    this.mOnStatusChangeListener.onProgressChange(Math.abs(percent));
                }
                if (dy > 0 && dy + scrollY > 0) {
                    LogUtil.m15791e(TAG, "onTouchEvent ACTION_MOVE break move1 dy:" + dy + " scrollY:" + scrollY);
                    dy = -scrollY;
                    return true;
                } else if ((-(scrollY + dy)) > this.bottomHight) {
                    LogUtil.m15791e(TAG, "onTouchEvent ACTION_MOVE break move2 " + dy + "  " + scrollY);
                    dy = -dy;
                    return true;
                } else {
                    scrollBy(0, dy);
                    this.mLastY = y;
                    return true;
                }
            default:
                return true;
        }
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(0, this.mScroller.getCurrY());
            invalidate();
            return;
        }
        LogUtil.m15791e(TAG, "computeScroll statusChange :" + this.statusChange);
        if (this.statusChange) {
            if (getScrollY() < (-this.bottomHight) / 2) {
                if (!(this.mOnStatusChangeListener == null || this.isBreakCallback)) {
                    this.mOnStatusChangeListener.onStatusChange(1);
                    this.mOnStatusChangeListener.onProgressChange(100);
                }
                this.status = 1;
                LogUtil.m15791e(TAG, "STATUS_BOTTOM");
            } else {
                if (!(this.mOnStatusChangeListener == null || this.isBreakCallback)) {
                    this.mOnStatusChangeListener.onStatusChange(0);
                    this.mOnStatusChangeListener.onProgressChange(0);
                }
                this.status = 0;
                LogUtil.m15791e(TAG, "STATUS_TOP");
            }
            this.statusChange = false;
        } else if (!this.mIsBeingDragged) {
            if (getScrollY() < (-this.bottomHight) / 2) {
                if (!(this.mOnStatusChangeListener == null || this.isBreakCallback)) {
                    if (this.status != 1) {
                        LogUtil.m15791e(TAG, "statusChange STATUS_BOTTOM");
                        this.mOnStatusChangeListener.onStatusChange(1);
                    }
                    this.mOnStatusChangeListener.onProgressChange(100);
                }
                this.status = 1;
                LogUtil.m15791e(TAG, "STATUS_BOTTOM");
            } else {
                if (!(this.mOnStatusChangeListener == null || this.isBreakCallback)) {
                    if (this.status != 0) {
                        LogUtil.m15791e(TAG, "statusChange STATUS_TOP");
                        this.mOnStatusChangeListener.onStatusChange(0);
                    }
                    this.mOnStatusChangeListener.onProgressChange(0);
                }
                this.status = 0;
                LogUtil.m15791e(TAG, "STATUS_TOP");
            }
        }
        this.isScrolling = false;
        if (this.status == 1) {
            scrollTo(0, -this.bottomHight);
        } else {
            scrollTo(0, 0);
        }
        this.isBreakCallback = false;
    }

    public boolean onInterceptHoverEvent(MotionEvent event) {
        return this.mIsBeingDragged;
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

    private void obtainVelocity(MotionEvent event) {
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

    public boolean isScrolling() {
        return this.isScrolling;
    }
}
