package com.baidu.navi.view.draglistview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.carlife.C0965R;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.util.common.LogUtil;

public class DragListView extends ListView {
    private static final int ANIMATION_DURATION = 200;
    public static final int MSG_DRAG_MOVE = 4098;
    public static final int MSG_DRAG_STOP = 4097;
    private static final String TAG = "test";
    private static final int TOUCH_TAP = 20;
    private static final int step = 1;
    private boolean bHasGetSapcing = false;
    private int clickCount;
    private int currentStep;
    private int downScrollBounce;
    private ImageView dragImageView;
    private int dragOffset;
    private int dragPoint;
    private int dragPosition;
    DragType dragType = DragType.ITEM_CLICK;
    private int holdPosition;
    private boolean isDragEnable;
    private boolean isLock;
    private boolean isMove;
    private boolean isRelease;
    private boolean isSameDragDirection = true;
    private int lastDownX;
    private int lastDownY;
    private int lastFlag = -1;
    private int lastPosition;
    Runnable longClickRunnable = new C40261();
    private Context mContext;
    Handler mHandler = new C40272();
    private boolean mIsOccpy;
    private int mItemVerticalSpacing = 0;
    private int offsetY;
    private int startPosition;
    Rect touchFrame;
    private int unableDragEndCount = 0;
    private int unableDragStartCount = 0;
    private int upScrollBounce;
    private WindowManager windowManager;
    private LayoutParams windowParams;

    /* renamed from: com.baidu.navi.view.draglistview.DragListView$1 */
    class C40261 implements Runnable {
        C40261() {
        }

        public void run() {
            DragListView.this.clickCount = DragListView.this.clickCount - 1;
            if (DragListView.this.clickCount <= 0 && !DragListView.this.isRelease && !DragListView.this.isMove) {
                DragListView.this.isDragEnable = true;
                DragListView.this.performDragEvent(DragListView.this.lastDownX, DragListView.this.lastDownY, DragListView.this.offsetY);
            }
        }
    }

    /* renamed from: com.baidu.navi.view.draglistview.DragListView$2 */
    class C40272 extends Handler {
        C40272() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 4097:
                    DragListView.this.stopDrag();
                    DragListView.this.onDrop(msg.arg1);
                    return;
                case 4098:
                    DragListView.this.onDrag(msg.arg1);
                    return;
                default:
                    return;
            }
        }
    }

    enum DragType {
        ITEM_CLICK,
        LONG_CLICK
    }

    public DragListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
        this.mIsOccpy = false;
    }

    public boolean checkDragListIsOccpuy() {
        return this.mIsOccpy;
    }

    public void setLock(boolean isLock) {
        this.isLock = isLock;
    }

    private void init() {
        this.dragType = DragType.ITEM_CLICK;
        this.windowManager = (WindowManager) getContext().getSystemService("window");
    }

    private void getSpacing() {
        this.bHasGetSapcing = true;
        this.upScrollBounce = getHeight() / 3;
        this.downScrollBounce = (getHeight() * 2) / 3;
        int[] tempLocation0 = new int[2];
        int[] tempLocation1 = new int[2];
        int headerViewCount = getFirstVisiblePosition();
        ViewGroup itemView0 = (ViewGroup) getChildAt(headerViewCount + 0);
        ViewGroup itemView1 = (ViewGroup) getChildAt(headerViewCount + 1);
        if (itemView0 != null) {
            itemView0.getLocationOnScreen(tempLocation0);
            if (itemView1 != null) {
                itemView1.getLocationOnScreen(tempLocation1);
                this.mItemVerticalSpacing = Math.abs(tempLocation1[1] - tempLocation0[1]);
            }
        }
    }

    private void performDragEvent(int x, int y, int offset) {
        LogUtil.m15791e(TAG, "performDragEvent()......................enter");
        int pointToPosition = pointToPosition(x, y);
        this.dragPosition = pointToPosition;
        this.startPosition = pointToPosition;
        this.lastPosition = pointToPosition;
        if (!isDragPositionValid(this.dragPosition)) {
            this.isDragEnable = false;
        }
        if (!this.bHasGetSapcing) {
            getSpacing();
        }
        ViewGroup dragger = (ViewGroup) getChildAt(this.dragPosition - getFirstVisiblePosition());
        this.dragPoint = y - dragger.getTop();
        this.dragOffset = offset;
        int[] location = new int[2];
        dragger.getLocationOnScreen(location);
        int imageX = location[0] - 10;
        dragger.destroyDrawingCache();
        dragger.setDrawingCacheEnabled(true);
        if (dragger.getBackground() != null) {
            dragger.getBackground().setAlpha(80);
        }
        Bitmap bm = Bitmap.createBitmap(dragger.getDrawingCache(true));
        dragger.setVisibility(4);
        startDrag(bm, imageX, y);
    }

    public Animation getScaleAnimation() {
        Animation scaleAnimation = new ScaleAnimation(0.0f, 0.0f, 0.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        return scaleAnimation;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case 0:
                this.lastDownX = (int) ev.getX();
                this.lastDownY = (int) ev.getY();
                int absoScreenx = (int) ev.getRawX();
                if (isDragPositionValid(pointToPosition(this.lastDownX, this.lastDownY))) {
                    this.offsetY = (int) (ev.getRawY() - ((float) this.lastDownY));
                    this.isMove = false;
                    this.isRelease = false;
                    if (this.dragType != DragType.LONG_CLICK) {
                        View dragItemView = findViewById(C0965R.id.iv_drag);
                        int[] location = new int[2];
                        dragItemView.getLocationOnScreen(location);
                        if (absoScreenx > location[0] - 20 && absoScreenx < (location[0] + dragItemView.getWidth()) + 20) {
                            this.mIsOccpy = true;
                            this.isDragEnable = true;
                            performDragEvent(this.lastDownX, this.lastDownY, this.offsetY);
                            StatisticManager.onEvent(StatisticConstants.ROUTE_DRAGSORT, StatisticConstants.ROUTE_DRAGSORT);
                            break;
                        }
                    }
                    this.isDragEnable = false;
                    this.clickCount++;
                    postDelayed(this.longClickRunnable, (long) ViewConfiguration.getLongPressTimeout());
                    break;
                }
                break;
            case 1:
                if (this.isDragEnable && this.dragImageView != null && isDragPositionValid(this.dragPosition)) {
                    int upY = (int) ev.getY();
                    stopDrag();
                    onDrop(upY);
                } else {
                    this.isRelease = true;
                }
                this.mIsOccpy = false;
                break;
            case 2:
                int moveY = (int) ev.getY();
                if (!this.isMove || !this.isDragEnable || this.dragImageView == null || !isDragPositionValid(this.dragPosition)) {
                    if (Math.abs(((float) this.lastDownX) - ev.getX()) > 20.0f || Math.abs(((float) this.lastDownY) - ev.getY()) > 20.0f) {
                        this.isMove = true;
                        break;
                    }
                } else if (isDragPositionValid(pointToPosition(0, moveY))) {
                    onDrag(moveY);
                    testAnimation(moveY);
                    break;
                }
                break;
            default:
                this.mIsOccpy = false;
                stopDrag();
                break;
        }
        if (this.isDragEnable && this.dragImageView != null && isDragPositionValid(this.dragPosition)) {
            return true;
        }
        return super.onTouchEvent(ev);
    }

    private void onChangeCopy(int last, int current) {
        ListAdapter adapter = getWrappedAdapter();
        if (last != current && (adapter instanceof OnDragAdapterListener)) {
            ((OnDragAdapterListener) adapter).onExchange(last - getFirstVisiblePosition(), current - getFirstVisiblePosition());
        }
    }

    private void testAnimation(int y) {
        int tempPosition = pointToPosition(0, y);
        if (tempPosition == 0) {
            LogUtil.m15791e(TAG, "0");
        }
        if (isDragPositionValid(tempPosition) && tempPosition != this.lastPosition) {
            LogUtil.m15791e(TAG, "Before:position valid");
            this.dragPosition = tempPosition;
            LogUtil.m15791e(TAG, "Before:lastPosition=" + this.lastPosition + ", dragPosition=" + this.dragPosition);
            onChangeCopy(this.lastPosition, this.dragPosition);
            int moveNum = tempPosition - this.lastPosition;
            int count = Math.abs(moveNum);
            for (int i = 1; i <= count; i++) {
                int xAbsOffset;
                int yAbsOffset;
                Animation animation;
                if (moveNum > 0) {
                    if (this.lastFlag == -1) {
                        this.lastFlag = 0;
                        this.isSameDragDirection = true;
                    } else if (this.lastFlag == 1) {
                        this.lastFlag = 0;
                        this.isSameDragDirection = !this.isSameDragDirection;
                    }
                    if (this.isSameDragDirection) {
                        this.holdPosition = this.lastPosition + 1;
                    } else if (this.startPosition < tempPosition) {
                        this.holdPosition = this.lastPosition + 1;
                        this.isSameDragDirection = !this.isSameDragDirection;
                    } else {
                        this.holdPosition = this.lastPosition;
                    }
                    xAbsOffset = 0;
                    yAbsOffset = -this.mItemVerticalSpacing;
                    this.lastPosition++;
                } else {
                    if (this.lastFlag == -1) {
                        this.lastFlag = 1;
                        this.isSameDragDirection = true;
                    }
                    if (this.lastFlag == 0) {
                        boolean z;
                        this.lastFlag = 1;
                        if (this.isSameDragDirection) {
                            z = false;
                        } else {
                            z = true;
                        }
                        this.isSameDragDirection = z;
                    }
                    if (this.isSameDragDirection) {
                        this.holdPosition = this.lastPosition - 1;
                    } else if (this.startPosition > tempPosition) {
                        this.holdPosition = this.lastPosition - 1;
                        this.isSameDragDirection = !this.isSameDragDirection;
                    } else {
                        this.holdPosition = this.lastPosition;
                    }
                    xAbsOffset = 0;
                    yAbsOffset = this.mItemVerticalSpacing;
                    this.lastPosition--;
                }
                ViewGroup moveView = (ViewGroup) getChildAt(this.holdPosition - getFirstVisiblePosition());
                if (this.isSameDragDirection) {
                    animation = getFromSelfAnimation(xAbsOffset, yAbsOffset);
                } else {
                    animation = getToSelfAnimation(xAbsOffset, -yAbsOffset);
                }
                moveView.startAnimation(animation);
            }
            Log.d(TAG, "After:lastPosition=" + this.lastPosition + ", dragPosition=" + this.dragPosition);
        }
    }

    private boolean isDragPositionValid(int dragPosition) {
        int count = getAdapter().getCount();
        if (dragPosition == -1 || dragPosition + 1 <= getUnableDragStartCount() || count - dragPosition <= getUnableDragEndCount()) {
            return false;
        }
        return true;
    }

    private int getUnableDragStartCount() {
        return this.unableDragStartCount + getFirstVisiblePosition();
    }

    private int getUnableDragEndCount() {
        return this.unableDragEndCount + getFooterViewsCount();
    }

    public int pointToPosition(int x, int y) {
        Rect frame = this.touchFrame;
        if (frame == null) {
            this.touchFrame = new Rect();
            frame = this.touchFrame;
        }
        for (int i = getChildCount() - 1; i >= 0; i--) {
            getChildAt(i).getHitRect(frame);
            if (frame.contains(x, y)) {
                return getFirstVisiblePosition() + i;
            }
        }
        return -1;
    }

    private void startDrag(Bitmap bm, int imageX, int y) {
        this.windowParams = new LayoutParams();
        this.windowParams.gravity = 48;
        this.windowParams.x = imageX;
        this.windowParams.y = (y - this.dragPoint) + this.dragOffset;
        this.windowParams.width = -2;
        this.windowParams.height = -2;
        this.windowParams.flags = 408;
        this.windowParams.windowAnimations = 0;
        this.windowParams.alpha = 0.8f;
        this.windowParams.format = -3;
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(bm);
        this.windowManager.addView(imageView, this.windowParams);
        this.dragImageView = imageView;
    }

    public void onDrag(int y) {
        int dragTop = y - this.dragPoint;
        if (this.dragImageView != null && dragTop >= 0) {
            this.windowParams.alpha = 1.0f;
            this.windowParams.y = (y - this.dragPoint) + this.dragOffset;
            this.windowManager.updateViewLayout(this.dragImageView, this.windowParams);
        }
        doScroller(y);
    }

    public void doScroller(int y) {
        if (y < this.upScrollBounce) {
            this.currentStep = ((this.upScrollBounce - y) / 10) + 1;
        } else if (y > this.downScrollBounce) {
            this.currentStep = (-((y - this.downScrollBounce) + 1)) / 10;
        } else {
            this.currentStep = 0;
        }
        setSelectionFromTop(this.dragPosition, getChildAt(this.dragPosition - getFirstVisiblePosition()).getTop() + this.currentStep);
    }

    public void stopDrag() {
        if (this.dragImageView != null) {
            this.windowManager.removeView(this.dragImageView);
            this.dragImageView = null;
        }
        this.isSameDragDirection = true;
        this.lastFlag = -1;
        ListAdapter adapter = getWrappedAdapter();
        if (adapter instanceof BaseAdapter) {
            ((BaseAdapter) adapter).notifyDataSetChanged();
        }
    }

    public void onDrop(int y) {
        onDrop(0, y);
    }

    private void onDrop(int x, int y) {
        ListAdapter adapter = getWrappedAdapter();
        if (adapter instanceof OnDragAdapterListener) {
            ((BaseAdapter) adapter).notifyDataSetChanged();
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
        TranslateAnimation go = new TranslateAnimation(0, (float) x, 1, 0.0f, 0, (float) y, 1, 0.0f);
        go.setInterpolator(new AccelerateDecelerateInterpolator());
        go.setFillAfter(true);
        go.setDuration(200);
        go.setInterpolator(new AccelerateInterpolator());
        return go;
    }

    public void setVisibility(int visibility) {
        stopDrag();
        super.setVisibility(visibility);
    }
}
