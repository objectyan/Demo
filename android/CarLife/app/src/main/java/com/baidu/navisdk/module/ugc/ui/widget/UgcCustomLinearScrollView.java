package com.baidu.navisdk.module.ugc.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.util.common.LogUtil;

public class UgcCustomLinearScrollView extends LinearLayout {
    public static final int status_bottom = 1;
    public static final int status_top = 0;
    int bottomHight;
    int button;
    private boolean gotoFlag;
    boolean hasActionDown;
    boolean hasMoveScroll;
    private boolean isScrolling;
    private EventCatchListener mEventCatchListener;
    private int mLastY;
    private OnStatusChangeListener mOnStatusChangeListener;
    private int mScrollEnd;
    private int mScrollStart;
    private Scroller mScroller;
    private VelocityTracker mVelocityTracker;
    boolean needScroll;
    private boolean needStatusChange;
    int status;
    boolean statusChange;
    int topHight;

    public interface OnStatusChangeListener {
        void onStatusChange(int i);
    }

    public interface EventCatchListener {
        void onEventCatch(MotionEvent motionEvent);
    }

    public UgcCustomLinearScrollView(Context context) {
        this(context, null);
        this.mScroller = new Scroller(context);
    }

    public UgcCustomLinearScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.needStatusChange = false;
        this.bottomHight = 0;
        this.status = 0;
        this.statusChange = false;
        this.needScroll = false;
        this.hasMoveScroll = false;
        this.gotoFlag = false;
        this.hasActionDown = false;
        this.mEventCatchListener = null;
        this.mScroller = new Scroller(context);
    }

    public UgcCustomLinearScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.needStatusChange = false;
        this.bottomHight = 0;
        this.status = 0;
        this.statusChange = false;
        this.needScroll = false;
        this.hasMoveScroll = false;
        this.gotoFlag = false;
        this.hasActionDown = false;
        this.mEventCatchListener = null;
        this.mScroller = new Scroller(context);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (this.bottomHight == 0) {
            try {
                this.bottomHight = findViewById(C4048R.id.ugc_sub_scroll_layout).getHeight();
                this.button = findViewById(C4048R.id.ugc_sub_fade_layer).getHeight();
                this.topHight = getHeight() - this.button;
            } catch (Exception e) {
                e.printStackTrace();
            }
            LogUtil.m15791e("UgcCustomLinearScrollView: onLayout", " bottomHight:" + this.bottomHight + " button:" + this.button + "topHight: " + this.topHight);
        }
    }

    public void setScrollSupport(boolean needScroll) {
        this.needScroll = needScroll;
    }

    public boolean gotoTop() {
        if (this.status == 0) {
            return false;
        }
        if (this.mScroller != null) {
            this.mScroller.startScroll(0, getScrollY(), 0, this.bottomHight);
            this.statusChange = true;
            this.isScrolling = true;
            this.gotoFlag = true;
            this.hasMoveScroll = true;
            postInvalidate();
        }
        return true;
    }

    public boolean gotoBottom() {
        if (this.status == 1) {
            return false;
        }
        if (this.mScroller != null) {
            this.mScroller.startScroll(0, getScrollY(), 0, -this.bottomHight);
            this.statusChange = true;
            this.isScrolling = true;
            this.gotoFlag = true;
            this.hasMoveScroll = true;
            postInvalidate();
        }
        return true;
    }

    public int getCurStatus() {
        return this.status;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!this.needScroll) {
            super.onTouchEvent(event);
            return true;
        } else if (this.isScrolling) {
            super.onTouchEvent(event);
            return true;
        } else {
            int y = (int) event.getY();
            int action = event.getAction();
            obtainVelocity(event);
            switch (action) {
                case 0:
                    this.mScrollStart = getScrollY();
                    if (this.mScrollStart < (-this.bottomHight) / 2) {
                        this.status = 1;
                    } else {
                        this.status = 0;
                    }
                    if (this.status == 1) {
                        if (y < this.bottomHight + this.button) {
                            LogUtil.m15791e("UgcCustomLinearScrollView: return status_bottom", " " + y);
                            return false;
                        }
                    } else if (y < this.button) {
                        LogUtil.m15791e("UgcCustomLinearScrollView: return status_top", " " + y);
                        return false;
                    }
                    LogUtil.m15791e("UgcCustomLinearScrollView: ACTION_DOWN ", " " + this.status + "  " + this.mScrollStart + "  ");
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
                    LogUtil.m15791e("UgcCustomLinearScrollView: ACTION_UP ", " " + this.mScrollEnd + "  " + this.mScrollStart + "  " + dScrollY);
                    if (this.status == 0) {
                        if ((-(this.mScrollEnd - this.mScrollStart)) > this.bottomHight / 3) {
                            this.mScroller.startScroll(0, getScrollY(), 0, -(this.bottomHight + dScrollY));
                            LogUtil.m15791e("UgcCustomLinearScrollView: up ", " 1");
                            this.status = 1;
                            this.statusChange = true;
                            this.hasMoveScroll = true;
                        } else {
                            this.mScroller.startScroll(0, getScrollY(), 0, -dScrollY);
                            this.hasMoveScroll = true;
                            LogUtil.m15791e("UgcCustomLinearScrollView: up ", " 2");
                        }
                    } else if (this.mScrollEnd - this.mScrollStart > (this.topHight - this.bottomHight) / 3) {
                        this.status = 0;
                        this.statusChange = true;
                        this.hasMoveScroll = true;
                        this.mScroller.startScroll(0, getScrollY(), 0, this.bottomHight - dScrollY);
                        LogUtil.m15791e("UgcCustomLinearScrollView: up ", " 3");
                    } else {
                        this.mScroller.startScroll(0, getScrollY(), 0, -dScrollY);
                        this.hasMoveScroll = true;
                        LogUtil.m15791e("UgcCustomLinearScrollView: up ", " 4");
                    }
                    this.isScrolling = true;
                    postInvalidate();
                    recycleVelocity();
                    return true;
                case 2:
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                    }
                    int dy = this.mLastY - y;
                    int scrollY = getScrollY();
                    if (dy > 0 && dy + scrollY > 0) {
                        LogUtil.m15791e("UgcCustomLinearScrollView: break move1", " " + dy + "  " + scrollY);
                        dy = -scrollY;
                        return true;
                    } else if ((-(scrollY + dy)) > this.bottomHight) {
                        LogUtil.m15791e("UgcCustomLinearScrollView: break move2", " " + dy + "  " + scrollY);
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
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(0, this.mScroller.getCurrY());
            invalidate();
            return;
        }
        if (this.statusChange) {
            if (getScrollY() < (-this.bottomHight) / 2) {
                if (!(this.mOnStatusChangeListener == null || this.gotoFlag)) {
                    this.mOnStatusChangeListener.onStatusChange(1);
                }
                this.status = 1;
            } else {
                if (!(this.mOnStatusChangeListener == null || this.gotoFlag)) {
                    this.mOnStatusChangeListener.onStatusChange(0);
                }
                this.status = 0;
            }
            this.statusChange = false;
        }
        this.isScrolling = false;
        if (this.hasMoveScroll) {
            if (this.status == 1) {
                scrollTo(0, -this.bottomHight);
            } else {
                scrollTo(0, 0);
            }
            this.hasMoveScroll = false;
            if (this.needStatusChange) {
                this.statusChange = true;
            }
        }
        this.gotoFlag = false;
    }

    public boolean onInterceptHoverEvent(MotionEvent event) {
        return this.hasActionDown;
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

    public void setNeedStatusChange(boolean needStatusChange) {
        this.needStatusChange = needStatusChange;
    }
}
