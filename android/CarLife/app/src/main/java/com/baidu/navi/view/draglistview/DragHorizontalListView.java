package com.baidu.navi.view.draglistview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.baidu.carlife.C0965R;
import com.baidu.navi.view.draglistview.DragHorizontalListView$OnScrollStateChangedListener.ScrollState;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DragHorizontalListView extends AdapterView<ListAdapter> {
    private static final int ANIMATION_DURATION = 200;
    private static final String BUNDLE_ID_CURRENT_X = "BUNDLE_ID_CURRENT_X";
    private static final String BUNDLE_ID_PARENT_STATE = "BUNDLE_ID_PARENT_STATE";
    private static final long ENABLE_BOUND_DURATION = 500;
    private static final float FLING_DEFAULT_ABSORB_VELOCITY = 30.0f;
    private static final float FLING_FRICTION = 0.009f;
    private static final int INSERT_AT_END_OF_LIST = -1;
    private static final int INSERT_AT_START_OF_LIST = 0;
    private final String TAG = "DragSortHorizontalListView";
    private int dragndropBackgroundColor = 0;
    private boolean enableChangeLeftBound = true;
    Runnable enableChangeLeftBoundRunnable = new DragHorizontalListView$4(this);
    private boolean enableChangeRightBound = true;
    Runnable enableChangeRightBoundRunnable = new DragHorizontalListView$5(this);
    private int itemWidth;
    private int lastPosition = -1;
    private int lastX = -1;
    protected ListAdapter mAdapter;
    private DataSetObserver mAdapterDataObserver = new DragHorizontalListView$2(this);
    private int mBarHeight = 0;
    private boolean mBlockTouchAction = false;
    private int mCoordOffsetX;
    private int mCoordOffsetY;
    private int mCurrentCoordOffsetx;
    private ScrollState mCurrentScrollState = ScrollState.SCROLL_STATE_IDLE;
    protected int mCurrentX;
    private int mCurrentlySelectedAdapterIndex;
    private boolean mDataChanged = false;
    private Runnable mDelayedLayout = new DragHorizontalListView$3(this);
    private int mDisplayOffset;
    private Drawable mDivider = null;
    private int mDividerWidth = 0;
    private Bitmap mDragBitmap;
    private int mDragPointX;
    private int mDragPointY;
    private int mDragPos;
    private ImageView mDragView;
    private EdgeEffectCompat mEdgeGlowLeft;
    private EdgeEffectCompat mEdgeGlowRight;
    protected Scroller mFlingTracker = new Scroller(getContext());
    private GestureDetector mGestureDetector;
    private final DragHorizontalListView$GestureListener mGestureListener = new DragHorizontalListView$GestureListener(this, null);
    private boolean mHasNotifiedRunningLowOnData = false;
    private int mHeightMeasureSpec;
    private boolean mIsParentVerticiallyScrollableViewDisallowingInterceptTouchEvent = false;
    private int mLeftBound;
    private int mLeftViewAdapterIndex;
    private int mMaxX = Integer.MAX_VALUE;
    protected int mNextX;
    private OnClickListener mOnClickListener;
    private DragHorizontalListView$OnScrollStateChangedListener mOnScrollStateChangedListener = null;
    private Rect mRect = new Rect();
    private List<Queue<View>> mRemovedViewsCache = new ArrayList();
    private Integer mRestoreX = null;
    private int mRightBound;
    private int mRightViewAdapterIndex;
    private DragHorizontalListView$RunningOutOfDataListener mRunningOutOfDataListener = null;
    private int mRunningOutOfDataThreshold = 0;
    private Rect mTouchFrame;
    private final int mTouchSlop;
    private View mViewBeingTouched = null;
    private int mWidth;
    private WindowManager mWindowManager;
    private LayoutParams mWindowParams;
    private int totalWidth;

    public DragHorizontalListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mEdgeGlowLeft = new EdgeEffectCompat(context);
        this.mEdgeGlowRight = new EdgeEffectCompat(context);
        this.mGestureDetector = new GestureDetector(context, this.mGestureListener);
        bindGestureDetector();
        initView();
        retrieveXmlConfiguration(context, attrs);
        setWillNotDraw(false);
        if (VERSION.SDK_INT >= 11) {
            DragHorizontalListView$HoneycombPlus.setFriction(this.mFlingTracker, FLING_FRICTION);
        }
    }

    private void bindGestureDetector() {
        setOnTouchListener(new DragHorizontalListView$1(this));
    }

    private void requestParentListViewToNotInterceptTouchEvents(Boolean disallowIntercept) {
        if (this.mIsParentVerticiallyScrollableViewDisallowingInterceptTouchEvent != disallowIntercept.booleanValue()) {
            View view = this;
            while (view.getParent() instanceof View) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(disallowIntercept.booleanValue());
                    this.mIsParentVerticiallyScrollableViewDisallowingInterceptTouchEvent = disallowIntercept.booleanValue();
                    return;
                }
                view = (View) view.getParent();
            }
        }
    }

    private void retrieveXmlConfiguration(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, C0965R.C0963p.DragHorizontalListView);
            Drawable d = a.getDrawable(1);
            if (d != null) {
                setDivider(d);
            }
            int dividerWidth = a.getDimensionPixelSize(3, 0);
            if (dividerWidth != 0) {
                setDividerWidth(dividerWidth);
            }
            a.recycle();
        }
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_ID_PARENT_STATE, super.onSaveInstanceState());
        bundle.putInt(BUNDLE_ID_CURRENT_X, this.mCurrentX);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            this.mRestoreX = Integer.valueOf(bundle.getInt(BUNDLE_ID_CURRENT_X));
            super.onRestoreInstanceState(bundle.getParcelable(BUNDLE_ID_PARENT_STATE));
        }
    }

    public void setDivider(Drawable divider) {
        this.mDivider = divider;
        if (divider != null) {
            setDividerWidth(divider.getIntrinsicWidth());
        } else {
            setDividerWidth(0);
        }
    }

    public void setDividerWidth(int width) {
        this.mDividerWidth = width;
        requestLayout();
        invalidate();
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    private void initView() {
        this.mLeftViewAdapterIndex = -1;
        this.mRightViewAdapterIndex = -1;
        this.mDisplayOffset = 0;
        this.mCurrentX = 0;
        this.mNextX = 0;
        this.mMaxX = Integer.MAX_VALUE;
        setCurrentScrollState(ScrollState.SCROLL_STATE_IDLE);
    }

    private void reset() {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    public void setSelection(int position) {
        this.mCurrentlySelectedAdapterIndex = position;
    }

    public View getSelectedView() {
        return getChild(this.mCurrentlySelectedAdapterIndex);
    }

    public void setAdapter(ListAdapter adapter) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mAdapterDataObserver);
        }
        if (adapter != null) {
            this.mHasNotifiedRunningLowOnData = false;
            this.mAdapter = adapter;
            this.mAdapter.registerDataSetObserver(this.mAdapterDataObserver);
        }
        initializeRecycledViewCache(this.mAdapter.getViewTypeCount());
        reset();
    }

    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    private void initializeRecycledViewCache(int viewTypeCount) {
        this.mRemovedViewsCache.clear();
        for (int i = 0; i < viewTypeCount; i++) {
            this.mRemovedViewsCache.add(new LinkedList());
        }
    }

    private View getRecycledView(int adapterIndex) {
        int itemViewType = this.mAdapter.getItemViewType(adapterIndex);
        if (isItemViewTypeValid(itemViewType)) {
            return (View) ((Queue) this.mRemovedViewsCache.get(itemViewType)).poll();
        }
        return null;
    }

    private void recycleView(int adapterIndex, View view) {
        int itemViewType = this.mAdapter.getItemViewType(adapterIndex);
        if (isItemViewTypeValid(itemViewType)) {
            ((Queue) this.mRemovedViewsCache.get(itemViewType)).offer(view);
        }
    }

    private boolean isItemViewTypeValid(int itemViewType) {
        return itemViewType < this.mRemovedViewsCache.size();
    }

    private void addAndMeasureChild(View child, int viewPos) {
        addViewInLayout(child, viewPos, getLayoutParams(child), true);
        measureChild(child);
    }

    private void measureChild(View child) {
        int childWidthSpec;
        ViewGroup.LayoutParams childLayoutParams = getLayoutParams(child);
        int childHeightSpec = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, getPaddingTop() + getPaddingBottom(), childLayoutParams.height);
        if (childLayoutParams.width > 0) {
            childWidthSpec = MeasureSpec.makeMeasureSpec(childLayoutParams.width, 1073741824);
        } else {
            childWidthSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    private ViewGroup.LayoutParams getLayoutParams(View child) {
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams == null) {
            return new ViewGroup.LayoutParams(-2, -1);
        }
        return layoutParams;
    }

    @SuppressLint({"WrongCall"})
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.mAdapter != null) {
            invalidate();
            if (this.mDataChanged) {
                int oldCurrentX = this.mCurrentX;
                initView();
                removeAllViewsInLayout();
                this.mNextX = oldCurrentX;
                this.mDataChanged = false;
            }
            if (this.mRestoreX != null) {
                this.mNextX = this.mRestoreX.intValue();
                this.mRestoreX = null;
            }
            if (this.mFlingTracker.computeScrollOffset()) {
                this.mNextX = this.mFlingTracker.getCurrX();
            }
            if (this.mNextX < 0) {
                this.mNextX = 0;
                if (this.mEdgeGlowLeft.isFinished()) {
                    this.mEdgeGlowLeft.onAbsorb((int) determineFlingAbsorbVelocity());
                }
                this.mFlingTracker.forceFinished(true);
                setCurrentScrollState(ScrollState.SCROLL_STATE_IDLE);
            } else if (this.mNextX > this.mMaxX) {
                this.mNextX = this.mMaxX;
                if (this.mEdgeGlowRight.isFinished()) {
                    this.mEdgeGlowRight.onAbsorb((int) determineFlingAbsorbVelocity());
                }
                this.mFlingTracker.forceFinished(true);
                setCurrentScrollState(ScrollState.SCROLL_STATE_IDLE);
            }
            int dx = this.mCurrentX - this.mNextX;
            removeNonVisibleChildren(dx);
            fillList(dx);
            positionChildren(dx);
            this.mCurrentX = this.mNextX;
            if (determineMaxX()) {
                onLayout(changed, left, top, right, bottom);
            } else if (!this.mFlingTracker.isFinished()) {
                ViewCompat.postOnAnimation(this, this.mDelayedLayout);
            } else if (this.mCurrentScrollState == ScrollState.SCROLL_STATE_FLING) {
                setCurrentScrollState(ScrollState.SCROLL_STATE_IDLE);
            }
        }
    }

    protected float getLeftFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.mCurrentX == 0) {
            return 0.0f;
        }
        if (this.mCurrentX < horizontalFadingEdgeLength) {
            return ((float) this.mCurrentX) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getRightFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.mCurrentX == this.mMaxX) {
            return 0.0f;
        }
        if (this.mMaxX - this.mCurrentX < horizontalFadingEdgeLength) {
            return ((float) (this.mMaxX - this.mCurrentX)) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    private float determineFlingAbsorbVelocity() {
        if (VERSION.SDK_INT >= 14) {
            return DragHorizontalListView$IceCreamSandwichPlus.getCurrVelocity(this.mFlingTracker);
        }
        return FLING_DEFAULT_ABSORB_VELOCITY;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mHeightMeasureSpec = heightMeasureSpec;
    }

    private boolean determineMaxX() {
        if (!isLastItemInAdapter(this.mRightViewAdapterIndex)) {
            return false;
        }
        View rightView = getRightmostChild();
        if (rightView == null) {
            return false;
        }
        int oldMaxX = this.mMaxX;
        this.mMaxX = (this.mCurrentX + (rightView.getRight() - getPaddingLeft())) - getRenderWidth();
        if (this.mMaxX < 0) {
            this.mMaxX = 0;
        }
        if (this.mMaxX != oldMaxX) {
            return true;
        }
        return false;
    }

    private void fillList(int dx) {
        int edge = 0;
        View child = getRightmostChild();
        if (child != null) {
            edge = child.getRight();
        }
        fillListRight(edge, dx);
        edge = 0;
        child = getLeftmostChild();
        if (child != null) {
            edge = child.getLeft();
        }
        fillListLeft(edge, dx);
    }

    private void removeNonVisibleChildren(int dx) {
        View child = getLeftmostChild();
        while (child != null && child.getRight() + dx <= 0) {
            int measuredWidth;
            int i = this.mDisplayOffset;
            if (isLastItemInAdapter(this.mLeftViewAdapterIndex)) {
                measuredWidth = child.getMeasuredWidth();
            } else {
                measuredWidth = this.mDividerWidth + child.getMeasuredWidth();
            }
            this.mDisplayOffset = measuredWidth + i;
            recycleView(this.mLeftViewAdapterIndex, child);
            removeViewInLayout(child);
            this.mLeftViewAdapterIndex++;
            child = getLeftmostChild();
        }
        child = getRightmostChild();
        while (child != null && child.getLeft() + dx >= getWidth()) {
            recycleView(this.mRightViewAdapterIndex, child);
            removeViewInLayout(child);
            this.mRightViewAdapterIndex--;
            child = getRightmostChild();
        }
    }

    private void fillListRight(int rightEdge, int dx) {
        while ((rightEdge + dx) + this.mDividerWidth < getWidth() && this.mRightViewAdapterIndex + 1 < this.mAdapter.getCount()) {
            this.mRightViewAdapterIndex++;
            if (this.mLeftViewAdapterIndex < 0) {
                this.mLeftViewAdapterIndex = this.mRightViewAdapterIndex;
            }
            View child = this.mAdapter.getView(this.mRightViewAdapterIndex, getRecycledView(this.mRightViewAdapterIndex), this);
            addAndMeasureChild(child, -1);
            rightEdge += (this.mRightViewAdapterIndex == 0 ? 0 : this.mDividerWidth) + child.getMeasuredWidth();
            determineIfLowOnData();
        }
    }

    private void fillListLeft(int leftEdge, int dx) {
        while ((leftEdge + dx) - this.mDividerWidth > 0 && this.mLeftViewAdapterIndex >= 1) {
            this.mLeftViewAdapterIndex--;
            View child = this.mAdapter.getView(this.mLeftViewAdapterIndex, getRecycledView(this.mLeftViewAdapterIndex), this);
            addAndMeasureChild(child, 0);
            leftEdge -= this.mLeftViewAdapterIndex == 0 ? child.getMeasuredWidth() : this.mDividerWidth + child.getMeasuredWidth();
            this.mDisplayOffset -= leftEdge + dx == 0 ? child.getMeasuredWidth() : this.mDividerWidth + child.getMeasuredWidth();
        }
    }

    private void positionChildren(int dx) {
        int childCount = getChildCount();
        if (childCount > 0) {
            this.mDisplayOffset += dx;
            int leftOffset = this.mDisplayOffset;
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                int left = leftOffset + getPaddingLeft();
                int top = getPaddingTop();
                child.layout(left, top, left + child.getMeasuredWidth(), top + child.getMeasuredHeight());
                leftOffset += child.getMeasuredWidth() + this.mDividerWidth;
            }
        }
    }

    public int pointToPosition(int x, int y) {
        Rect frame = this.mTouchFrame;
        if (frame == null) {
            this.mTouchFrame = new Rect();
            frame = this.mTouchFrame;
        }
        int count = getChildCount();
        LogUtil.e("DragSortHorizontalListView", "pointToPosition=== count:" + count + ",index:" + getChildIndex(x, y));
        for (int i = count - 1; i >= 0; i--) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                child.getHitRect(frame);
                if (frame.contains(x, y)) {
                    return getFirstVisiblePosition() + i;
                }
            }
        }
        return -1;
    }

    private View getLeftmostChild() {
        return getChildAt(0);
    }

    private View getRightmostChild() {
        return getChildAt(getChildCount() - 1);
    }

    private View getChild(int adapterIndex) {
        if (adapterIndex >= this.mLeftViewAdapterIndex && adapterIndex <= this.mRightViewAdapterIndex) {
            getChildAt(adapterIndex - this.mLeftViewAdapterIndex);
        }
        return null;
    }

    private int getChildIndex(int x, int y) {
        int childCount = getChildCount();
        for (int index = 0; index < childCount; index++) {
            getChildAt(index).getHitRect(this.mRect);
            if (this.mRect.contains(x, y)) {
                return index;
            }
        }
        return -1;
    }

    private boolean isLastItemInAdapter(int index) {
        return index == this.mAdapter.getCount() + -1;
    }

    private int getRenderHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getRenderWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void scrollTo(int x) {
        this.mFlingTracker.startScroll(this.mNextX, 0, x - this.mNextX, 0);
        setCurrentScrollState(ScrollState.SCROLL_STATE_FLING);
        requestLayout();
    }

    private void drawEdgeGlow(Canvas canvas) {
        int restoreCount;
        if (this.mEdgeGlowLeft != null && !this.mEdgeGlowLeft.isFinished() && isEdgeGlowEnabled()) {
            restoreCount = canvas.save();
            int height = getHeight();
            canvas.rotate(-90.0f, 0.0f, 0.0f);
            canvas.translate((float) ((-height) + getPaddingBottom()), 0.0f);
            this.mEdgeGlowLeft.setSize(getRenderHeight(), getRenderWidth());
            if (this.mEdgeGlowLeft.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(restoreCount);
        } else if (this.mEdgeGlowRight != null && !this.mEdgeGlowRight.isFinished() && isEdgeGlowEnabled()) {
            restoreCount = canvas.save();
            int width = getWidth();
            canvas.rotate(90.0f, 0.0f, 0.0f);
            canvas.translate((float) getPaddingTop(), (float) (-width));
            this.mEdgeGlowRight.setSize(getRenderHeight(), getRenderWidth());
            if (this.mEdgeGlowRight.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(restoreCount);
        }
    }

    private void drawDividers(Canvas canvas) {
        int count = getChildCount();
        Rect bounds = this.mRect;
        this.mRect.top = getPaddingTop();
        this.mRect.bottom = this.mRect.top + getRenderHeight();
        for (int i = 0; i < count; i++) {
            if (i != count - 1 || !isLastItemInAdapter(this.mRightViewAdapterIndex)) {
                View child = getChildAt(i);
                bounds.left = child.getRight();
                bounds.right = child.getRight() + this.mDividerWidth;
                if (bounds.left < getPaddingLeft()) {
                    bounds.left = getPaddingLeft();
                }
                if (bounds.right > getWidth() - getPaddingRight()) {
                    bounds.right = getWidth() - getPaddingRight();
                }
                drawDivider(canvas, bounds);
                if (i == 0 && child.getLeft() > getPaddingLeft()) {
                    bounds.left = getPaddingLeft();
                    bounds.right = child.getLeft();
                    drawDivider(canvas, bounds);
                }
            }
        }
    }

    private void drawDivider(Canvas canvas, Rect bounds) {
        if (this.mDivider != null) {
            this.mDivider.setBounds(bounds);
            this.mDivider.draw(canvas);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDividers(canvas);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        drawEdgeGlow(canvas);
    }

    protected void dispatchSetPressed(boolean pressed) {
    }

    protected boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        this.mFlingTracker.fling(this.mNextX, 0, (int) (-velocityX), 0, 0, this.mMaxX, 0, 0);
        setCurrentScrollState(ScrollState.SCROLL_STATE_FLING);
        requestLayout();
        return true;
    }

    protected boolean onDown(MotionEvent e) {
        this.mBlockTouchAction = !this.mFlingTracker.isFinished();
        this.mFlingTracker.forceFinished(true);
        setCurrentScrollState(ScrollState.SCROLL_STATE_IDLE);
        unpressTouchedChild();
        if (!this.mBlockTouchAction) {
            int index = getChildIndex((int) e.getX(), (int) e.getY());
            if (index >= 0) {
                this.mViewBeingTouched = getChildAt(index);
                if (this.mViewBeingTouched != null) {
                    this.mViewBeingTouched.setPressed(true);
                    refreshDrawableState();
                }
            }
        }
        return true;
    }

    private void unpressTouchedChild() {
        if (this.mViewBeingTouched != null) {
            this.mViewBeingTouched.setPressed(false);
            refreshDrawableState();
            this.mViewBeingTouched = null;
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 1) {
            if (this.mFlingTracker == null || this.mFlingTracker.isFinished()) {
                setCurrentScrollState(ScrollState.SCROLL_STATE_IDLE);
            }
            requestParentListViewToNotInterceptTouchEvents(Boolean.valueOf(false));
            releaseEdgeGlow();
        } else if (event.getAction() == 3) {
            unpressTouchedChild();
            releaseEdgeGlow();
            requestParentListViewToNotInterceptTouchEvents(Boolean.valueOf(false));
        }
        if (this.mDragView == null || this.mDragPos == -1) {
            return super.onTouchEvent(event);
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case 1:
                dropView(x, y);
                return true;
            case 2:
                dragView(x, y);
                return true;
            default:
                return true;
        }
    }

    private void releaseEdgeGlow() {
        if (this.mEdgeGlowLeft != null) {
            this.mEdgeGlowLeft.onRelease();
        }
        if (this.mEdgeGlowRight != null) {
            this.mEdgeGlowRight.onRelease();
        }
    }

    public void setRunningOutOfDataListener(DragHorizontalListView$RunningOutOfDataListener listener, int numberOfItemsLeftConsideredLow) {
        this.mRunningOutOfDataListener = listener;
        this.mRunningOutOfDataThreshold = numberOfItemsLeftConsideredLow;
    }

    private void determineIfLowOnData() {
        if (this.mRunningOutOfDataListener != null && this.mAdapter != null && this.mAdapter.getCount() - (this.mRightViewAdapterIndex + 1) < this.mRunningOutOfDataThreshold && !this.mHasNotifiedRunningLowOnData) {
            this.mHasNotifiedRunningLowOnData = true;
            this.mRunningOutOfDataListener.onRunningOutOfData();
        }
    }

    public void setOnClickListener(OnClickListener listener) {
        this.mOnClickListener = listener;
    }

    public void setOnScrollStateChangedListener(DragHorizontalListView$OnScrollStateChangedListener listener) {
        this.mOnScrollStateChangedListener = listener;
    }

    private void setCurrentScrollState(ScrollState newScrollState) {
        if (!(this.mCurrentScrollState == newScrollState || this.mOnScrollStateChangedListener == null)) {
            this.mOnScrollStateChangedListener.onScrollStateChanged(newScrollState);
        }
        this.mCurrentScrollState = newScrollState;
    }

    private void updateOverscrollAnimation(int scrolledOffset) {
        if (this.mEdgeGlowLeft != null && this.mEdgeGlowRight != null) {
            int nextScrollPosition = this.mCurrentX + scrolledOffset;
            if (this.mFlingTracker != null && !this.mFlingTracker.isFinished()) {
                return;
            }
            if (nextScrollPosition < 0) {
                int overscroll = Math.abs(scrolledOffset);
                float deltaDistance = 0.0f;
                if (getRenderWidth() != 0) {
                    deltaDistance = (float) (overscroll / getRenderWidth());
                }
                this.mEdgeGlowLeft.onPull(deltaDistance);
                if (!this.mEdgeGlowRight.isFinished()) {
                    this.mEdgeGlowRight.onRelease();
                }
            } else if (nextScrollPosition > this.mMaxX) {
                this.mEdgeGlowRight.onPull(((float) Math.abs(scrolledOffset)) / ((float) getRenderWidth()));
                if (!this.mEdgeGlowLeft.isFinished()) {
                    this.mEdgeGlowLeft.onRelease();
                }
            }
        }
    }

    private boolean isEdgeGlowEnabled() {
        if (this.mAdapter == null || this.mAdapter.isEmpty() || this.mMaxX <= 0) {
            return false;
        }
        return true;
    }

    @CapturedViewProperty
    public int getCount() {
        if (this.mAdapter != null) {
            return this.mAdapter.getCount();
        }
        return 0;
    }

    public int getFirstVisiblePosition() {
        return this.mLeftViewAdapterIndex;
    }

    private boolean beginDrag(MotionEvent ev) {
        LogUtil.e("test", "onItemLongClick=====X:" + ev.getX() + " Y:" + ev.getY() + " RawX:" + ev.getRawX() + " getRawY()" + ev.getRawY());
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        int itemindex = pointToPosition(x, 0);
        LogUtil.e("DragSortHorizontalListView", "pointToPosition item=" + itemindex);
        if (itemindex < 1 || itemindex >= getCount() - 1) {
            return false;
        }
        ViewGroup item = (ViewGroup) getChildAt(itemindex - getFirstVisiblePosition());
        LogUtil.e("DragSortHorizontalListView", "item(" + item.getLeft() + "," + item.getTop() + ") Raw(" + ev.getRawX() + "," + ev.getRawY() + ") getFirstVisiblePosition=" + getFirstVisiblePosition());
        this.mDragPointX = x - item.getLeft();
        this.mCoordOffsetX = ((int) ev.getRawX()) - x;
        this.mCurrentCoordOffsetx = this.mCoordOffsetX;
        this.mDragPointY = y - item.getTop();
        this.mCoordOffsetY = (int) (ev.getRawY() - ((float) y));
        item.destroyDrawingCache();
        item.setDrawingCacheEnabled(true);
        startDragging(Bitmap.createBitmap(item.getDrawingCache()), x, y);
        this.mDragPos = itemindex;
        this.mWidth = getWidth();
        this.itemWidth = item.getWidth();
        int touchSlop = this.mTouchSlop;
        this.mLeftBound = this.mWidth / 6;
        this.mRightBound = (this.mWidth * 5) / 6;
        LogUtil.e("DragSortHorizontalListView", "touchSlop=" + touchSlop + ",mLeftBound=" + this.mLeftBound + ",mRightBound=" + this.mRightBound);
        item.setVisibility(4);
        return true;
    }

    private void startDragging(Bitmap bm, int x, int y) {
        LogUtil.e("DragSortHorizontalListView", "startDragging x=" + x);
        stopDragging();
        this.mWindowParams = new LayoutParams();
        this.mWindowParams.gravity = 51;
        this.mWindowParams.x = (x - this.mDragPointX) + this.mCoordOffsetX;
        this.mWindowParams.y = (y - this.mDragPointY) + this.mCoordOffsetY;
        LogUtil.e("DragSortHorizontalListView", "mWindowParams x=" + this.mWindowParams.x + ",y=" + this.mWindowParams.y + " mBarHeight=" + this.mBarHeight);
        this.mWindowParams.height = -2;
        this.mWindowParams.width = -2;
        this.mWindowParams.flags = 408;
        this.mWindowParams.format = -3;
        this.mWindowParams.windowAnimations = 0;
        ImageView v = new ImageView(getContext());
        v.setBackgroundColor(this.dragndropBackgroundColor);
        v.setImageBitmap(bm);
        this.mDragBitmap = bm;
        this.mWindowManager = (WindowManager) getContext().getSystemService("window");
        this.mWindowManager.addView(v, this.mWindowParams);
        this.mDragView = v;
    }

    private void dropView(int x, int y) {
        LogUtil.e("DragSortHorizontalListView", "dropView x=" + x + ",y=" + y);
        if (this.mDragView == null) {
            Log.w("DragSortHorizontalListView", "dropView mDragView is null!");
            return;
        }
        stopDragging();
        ListAdapter adapter = getWrappedAdapter();
        int itemindex = pointToPosition(x, y);
        if (itemindex < 1 || itemindex >= getCount() - 1) {
            Log.w("DragSortHorizontalListView", "dropView invalid position! itemindex" + itemindex + "Count:" + getCount());
        } else if (this.lastPosition != -1) {
            onExchange(this.mDragPos, this.lastPosition);
        }
        if (adapter instanceof BaseAdapter) {
            ((BaseAdapter) adapter).notifyDataSetChanged();
        }
        this.lastPosition = -1;
    }

    private void dragView(int x, int y) {
        LogUtil.e("DragSortHorizontalListView", "dragView(" + x + "," + y + ")");
        if (this.mDragView != null) {
            int width = this.mDragView.getWidth();
            this.mWindowParams.x = (x - this.mDragPointX) + this.mCoordOffsetX;
            int itemindex1 = pointToPosition(this.mWindowParams.x, y);
            int itemindex2 = pointToPosition(this.mWindowParams.x + width, y);
            if (itemindex1 < 1 || itemindex1 >= getCount() - 1 || itemindex2 < 1 || itemindex2 >= getCount() - 1) {
                Log.w("DragSortHorizontalListView", "dragView invalid position!");
                return;
            }
            this.mWindowManager.updateViewLayout(this.mDragView, this.mWindowParams);
            testAnimation(x);
            return;
        }
        Log.w("DragSortHorizontalListView", "dragView mDragView is null!");
    }

    private void testAnimation(int x) {
        int tempPosition = pointToPosition(x, 0);
        LogUtil.e("test", tempPosition + "," + this.lastPosition);
        if (tempPosition == -1) {
            return;
        }
        if (tempPosition != this.lastPosition || this.lastPosition == -1) {
            if (this.lastPosition == -1) {
                this.lastPosition = this.mDragPos;
            }
            int moveNum = tempPosition - this.lastPosition;
            int count = Math.abs(moveNum);
            boolean isAnimationNeedUsingToSelf = false;
            for (int i = 0; i < count; i++) {
                int movePosition;
                int xAbsOffset;
                int yAbsOffset;
                Animation animation;
                if (moveNum > 0) {
                    if (this.lastPosition < this.mDragPos) {
                        movePosition = this.lastPosition;
                        isAnimationNeedUsingToSelf = true;
                    } else {
                        movePosition = this.lastPosition + 1;
                    }
                    xAbsOffset = -this.itemWidth;
                    yAbsOffset = 0;
                    this.lastPosition++;
                } else {
                    if (this.lastPosition > this.mDragPos) {
                        movePosition = this.lastPosition;
                        isAnimationNeedUsingToSelf = true;
                    } else {
                        movePosition = this.lastPosition - 1;
                    }
                    xAbsOffset = this.itemWidth;
                    yAbsOffset = 0;
                    this.lastPosition--;
                }
                System.err.println("lastPosition=" + this.lastPosition);
                System.err.println("movePosition=" + this.lastPosition);
                System.err.println("curposition=" + (movePosition - getFirstVisiblePosition()));
                View moveView = getChildAt(movePosition - getFirstVisiblePosition());
                if (isAnimationNeedUsingToSelf) {
                    animation = getToSelfAnimation(xAbsOffset, yAbsOffset);
                } else {
                    animation = getFromSelfAnimation(xAbsOffset, yAbsOffset);
                }
                try {
                    moveView.startAnimation(animation);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void onExchange(int last, int current) {
        ListAdapter adapter = getWrappedAdapter();
        if (adapter instanceof OnDragAdapterListener) {
            ((OnDragAdapterListener) adapter).onExchange(last, current);
        }
    }

    private ListAdapter getWrappedAdapter() {
        ListAdapter adapter = getAdapter();
        if (adapter == null || !(adapter instanceof HeaderViewListAdapter)) {
            return adapter;
        }
        return ((HeaderViewListAdapter) adapter).getWrappedAdapter();
    }

    public Animation getFromSelfAnimation(int x, int y) {
        TranslateAnimation go = new TranslateAnimation(1, 0.0f, 0, (float) x, 1, 0.0f, 0, (float) y);
        go.setInterpolator(new AccelerateDecelerateInterpolator());
        go.setFillAfter(true);
        go.setDuration(200);
        go.setInterpolator(new AccelerateInterpolator());
        return go;
    }

    public Animation getToSelfAnimation(int x, int y) {
        TranslateAnimation go = new TranslateAnimation(0, (float) (-x), 1, 0.0f, 0, (float) (-y), 1, 0.0f);
        go.setInterpolator(new AccelerateDecelerateInterpolator());
        go.setFillAfter(true);
        go.setDuration(200);
        go.setInterpolator(new AccelerateInterpolator());
        return go;
    }

    public void stopDragging() {
        if (this.mDragView != null) {
            this.mWindowManager.removeView(this.mDragView);
            this.mDragView.setImageDrawable(null);
            this.mDragView = null;
        }
        if (this.mDragBitmap != null) {
            this.mDragBitmap.recycle();
            this.mDragBitmap = null;
        }
    }

    public void setVisibility(int visibility) {
        stopDragging();
        super.setVisibility(visibility);
    }
}
