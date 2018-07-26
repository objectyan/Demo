package com.baidu.navi.view.pulltorefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.baidu.carlife.C0965R;
import com.baidu.navi.view.pulltorefresh.PullToRefreshBase.AnimationStyle;
import com.baidu.navi.view.pulltorefresh.PullToRefreshBase.Mode;
import com.baidu.navi.view.pulltorefresh.PullToRefreshBase.Orientation;

public class PullToRefreshHorizontalScrollView extends PullToRefreshBase<HorizontalScrollView> {

    class slowHorizontalScrollView extends HorizontalScrollView {
        public slowHorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        public slowHorizontalScrollView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public slowHorizontalScrollView(Context context) {
            super(context);
        }

        public void fling(int velocityX) {
            super.fling(velocityX / 2);
        }
    }

    @TargetApi(9)
    final class InternalHorizontalScrollViewSDK9 extends slowHorizontalScrollView {
        public InternalHorizontalScrollViewSDK9(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
            boolean returnValue = super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
            OverscrollHelper.overScrollBy(PullToRefreshHorizontalScrollView.this, deltaX, scrollX, deltaY, scrollY, getScrollRange(), isTouchEvent);
            return returnValue;
        }

        private int getScrollRange() {
            if (getChildCount() > 0) {
                return Math.max(0, getChildAt(0).getWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight()));
            }
            return 0;
        }
    }

    public PullToRefreshHorizontalScrollView(Context context) {
        super(context);
    }

    public PullToRefreshHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToRefreshHorizontalScrollView(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefreshHorizontalScrollView(Context context, Mode mode, AnimationStyle style) {
        super(context, mode, style);
    }

    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.HORIZONTAL;
    }

    protected HorizontalScrollView createRefreshableView(Context context, AttributeSet attrs) {
        HorizontalScrollView scrollView;
        if (VERSION.SDK_INT >= 9) {
            scrollView = new InternalHorizontalScrollViewSDK9(context, attrs);
        } else {
            scrollView = new slowHorizontalScrollView(context, attrs);
        }
        scrollView.setId(C0965R.id.nsdk_ptr_scrollview);
        return scrollView;
    }

    protected boolean isReadyForPullStart() {
        return ((HorizontalScrollView) this.mRefreshableView).getScrollX() == 0;
    }

    protected boolean isReadyForPullEnd() {
        View scrollViewChild = ((HorizontalScrollView) this.mRefreshableView).getChildAt(0);
        if (scrollViewChild == null) {
            return false;
        }
        if (((HorizontalScrollView) this.mRefreshableView).getScrollX() >= scrollViewChild.getWidth() - getWidth()) {
            return true;
        }
        return false;
    }

    public void hideLayoutViews() {
        getHeaderLayout().hideAllViews();
        getFooterLayout().hideAllViews();
    }
}
