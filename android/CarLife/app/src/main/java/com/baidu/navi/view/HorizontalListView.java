package com.baidu.navi.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.baidu.carlife.C0965R;
import com.google.android.support.v4.view.ViewCompat;
import com.google.android.support.v4.widget.EdgeEffectCompat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListView extends AdapterView<ListAdapter> {
    private static final String BUNDLE_ID_CURRENT_X = "BUNDLE_ID_CURRENT_X";
    private static final String BUNDLE_ID_PARENT_STATE = "BUNDLE_ID_PARENT_STATE";
    private static final float FLING_DEFAULT_ABSORB_VELOCITY = 30.0f;
    private static final float FLING_FRICTION = 0.009f;
    private static final int INSERT_AT_END_OF_LIST = -1;
    private static final int INSERT_AT_START_OF_LIST = 0;
    private static final int distanceX = ViewConfiguration.getTouchSlop();
    int lastDownX;
    protected ListAdapter mAdapter;
    private DataSetObserver mAdapterDataObserver = new C40052();
    private boolean mBlockTouchAction = false;
    private ScrollState mCurrentScrollState = ScrollState.SCROLL_STATE_IDLE;
    protected int mCurrentX;
    private int mCurrentlySelectedAdapterIndex;
    private boolean mDataChanged = false;
    private Runnable mDelayedLayout = new C40063();
    private int mDisplayOffset;
    private Drawable mDivider = null;
    private int mDividerWidth = 0;
    private EdgeEffectCompat mEdgeGlowLeft;
    private EdgeEffectCompat mEdgeGlowRight;
    protected Scroller mFlingTracker = new Scroller(getContext());
    private GestureDetector mGestureDetector;
    private final GestureListener mGestureListener = new GestureListener();
    private boolean mHasNotifiedRunningLowOnData = false;
    private int mHeightMeasureSpec;
    private boolean mIsParentVerticiallyScrollableViewDisallowingInterceptTouchEvent = false;
    private int mLeftViewAdapterIndex;
    private int mMaxX = Integer.MAX_VALUE;
    protected int mNextX;
    private OnClickListener mOnClickListener;
    private OnScrollStateChangedListener mOnScrollStateChangedListener = null;
    private Rect mRect = new Rect();
    private List<Queue<View>> mRemovedViewsCache = new ArrayList();
    private Integer mRestoreX = null;
    private int mRightViewAdapterIndex;
    private RunningOutOfDataListener mRunningOutOfDataListener = null;
    private int mRunningOutOfDataThreshold = 0;
    private View mViewBeingTouched = null;

    /* renamed from: com.baidu.navi.view.HorizontalListView$1 */
    class C40041 implements OnTouchListener {
        C40041() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return HorizontalListView.this.mGestureDetector.onTouchEvent(event);
        }
    }

    /* renamed from: com.baidu.navi.view.HorizontalListView$2 */
    class C40052 extends DataSetObserver {
        C40052() {
        }

        public void onChanged() {
            HorizontalListView.this.mDataChanged = true;
            HorizontalListView.this.mHasNotifiedRunningLowOnData = false;
            HorizontalListView.this.unpressTouchedChild();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }

        public void onInvalidated() {
            HorizontalListView.this.mHasNotifiedRunningLowOnData = false;
            HorizontalListView.this.unpressTouchedChild();
            HorizontalListView.this.reset();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }
    }

    /* renamed from: com.baidu.navi.view.HorizontalListView$3 */
    class C40063 implements Runnable {
        C40063() {
        }

        public void run() {
            HorizontalListView.this.requestLayout();
        }
    }

    private class GestureListener extends SimpleOnGestureListener {
        private GestureListener() {
        }

        public boolean onDown(MotionEvent e) {
            return HorizontalListView.this.onDown(e);
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return HorizontalListView.this.onFling(e1, e2, velocityX, velocityY);
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            HorizontalListView.this.requestParentListViewToNotInterceptTouchEvents(Boolean.valueOf(true));
            HorizontalListView.this.setCurrentScrollState(ScrollState.SCROLL_STATE_TOUCH_SCROLL);
            HorizontalListView.this.unpressTouchedChild();
            HorizontalListView horizontalListView = HorizontalListView.this;
            horizontalListView.mNextX += (int) distanceX;
            HorizontalListView.this.updateOverscrollAnimation(Math.round(distanceX));
            HorizontalListView.this.requestLayout();
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent e) {
            HorizontalListView.this.unpressTouchedChild();
            OnItemClickListener onItemClickListener = HorizontalListView.this.getOnItemClickListener();
            int index = HorizontalListView.this.getChildIndex((int) e.getX(), (int) e.getY());
            if (index >= 0 && !HorizontalListView.this.mBlockTouchAction) {
                View child = HorizontalListView.this.getChildAt(index);
                int adapterIndex = HorizontalListView.this.mLeftViewAdapterIndex + index;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(HorizontalListView.this, child, adapterIndex, HorizontalListView.this.mAdapter.getItemId(adapterIndex));
                    return true;
                }
            }
            if (!(HorizontalListView.this.mOnClickListener == null || HorizontalListView.this.mBlockTouchAction)) {
                HorizontalListView.this.mOnClickListener.onClick(HorizontalListView.this);
            }
            return false;
        }

        public void onLongPress(MotionEvent e) {
            HorizontalListView.this.unpressTouchedChild();
            int index = HorizontalListView.this.getChildIndex((int) e.getX(), (int) e.getY());
            if (index >= 0 && !HorizontalListView.this.mBlockTouchAction) {
                View child = HorizontalListView.this.getChildAt(index);
                OnItemLongClickListener onItemLongClickListener = HorizontalListView.this.getOnItemLongClickListener();
                if (onItemLongClickListener != null) {
                    int adapterIndex = HorizontalListView.this.mLeftViewAdapterIndex + index;
                    if (onItemLongClickListener.onItemLongClick(HorizontalListView.this, child, adapterIndex, HorizontalListView.this.mAdapter.getItemId(adapterIndex))) {
                        HorizontalListView.this.performHapticFeedback(0);
                    }
                }
            }
        }
    }

    @TargetApi(11)
    private static final class HoneycombPlus {
        private HoneycombPlus() {
        }

        public static void setFriction(Scroller scroller, float friction) {
            if (VERSION.SDK_INT >= 11 && scroller != null) {
                scroller.setFriction(friction);
            }
        }
    }

    @TargetApi(14)
    private static final class IceCreamSandwichPlus {
        private IceCreamSandwichPlus() {
        }

        public static float getCurrVelocity(Scroller scroller) {
            if (VERSION.SDK_INT >= 14) {
                return scroller.getCurrVelocity();
            }
            return 0.0f;
        }
    }

    public interface OnScrollStateChangedListener {

        public enum ScrollState {
            SCROLL_STATE_IDLE,
            SCROLL_STATE_TOUCH_SCROLL,
            SCROLL_STATE_FLING
        }

        void onScrollStateChanged(ScrollState scrollState);
    }

    public interface RunningOutOfDataListener {
        void onRunningOutOfData();
    }

    public HorizontalListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mEdgeGlowLeft = new EdgeEffectCompat(context);
        this.mEdgeGlowRight = new EdgeEffectCompat(context);
        this.mGestureDetector = new GestureDetector(context, this.mGestureListener);
        bindGestureDetector();
        initView();
        retrieveXmlConfiguration(context, attrs);
        setWillNotDraw(false);
        if (VERSION.SDK_INT >= 11) {
            HoneycombPlus.setFriction(this.mFlingTracker, FLING_FRICTION);
        }
    }

    private void bindGestureDetector() {
        setOnTouchListener(new C40041());
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
            TypedArray a = context.obtainStyledAttributes(attrs, C0965R.C0963p.HorizontalListView);
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
        View view = getChildAt(0);
        if (view != null) {
            int distance = position * (this.mDividerWidth + view.getMeasuredWidth());
            if (this.mFlingTracker != null) {
                this.mFlingTracker.startScroll(this.mNextX, 0, distance - this.mNextX, 0);
                setCurrentScrollState(ScrollState.SCROLL_STATE_FLING);
                requestLayout();
            }
        }
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
        LayoutParams childLayoutParams = getLayoutParams(child);
        int childHeightSpec = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, getPaddingTop() + getPaddingBottom(), childLayoutParams.height);
        if (childLayoutParams.width > 0) {
            childWidthSpec = MeasureSpec.makeMeasureSpec(childLayoutParams.width, 1073741824);
        } else {
            childWidthSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    private LayoutParams getLayoutParams(View child) {
        LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams == null) {
            return new LayoutParams(-2, -1);
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
            return IceCreamSandwichPlus.getCurrVelocity(this.mFlingTracker);
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
        return super.onTouchEvent(event);
    }

    private void releaseEdgeGlow() {
        if (this.mEdgeGlowLeft != null) {
            this.mEdgeGlowLeft.onRelease();
        }
        if (this.mEdgeGlowRight != null) {
            this.mEdgeGlowRight.onRelease();
        }
    }

    public void setRunningOutOfDataListener(RunningOutOfDataListener listener, int numberOfItemsLeftConsideredLow) {
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

    public void setOnScrollStateChangedListener(OnScrollStateChangedListener listener) {
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
                    deltaDistance = ((float) overscroll) / ((float) getRenderWidth());
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

    public void addHeaderView(View v) {
        Boolean add = Boolean.valueOf(addViewInLayout(v, 0, new AbsListView.LayoutParams(-1, -2), true));
        measureChild(v);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == 0) {
            this.lastDownX = (int) ev.getX();
        } else if (action == 2 && Math.abs(ev.getX() - ((float) this.lastDownX)) > ((float) distanceX)) {
            unpressTouchedChild();
            return true;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
