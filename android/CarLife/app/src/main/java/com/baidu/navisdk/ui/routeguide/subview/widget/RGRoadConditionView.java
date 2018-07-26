package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.model.datastruct.RoadConditionItem;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.ArrayList;
import java.util.List;

public class RGRoadConditionView extends View {
    private static final String TAG = "RGRoadConditionView";
    private NinePatchDrawable bgBitmap;
    private Bitmap carPointBitmap;
    private float carPointEdgeWidth;
    private float carPointPlaintEdge;
    private final float carPointPlaintEdgeDp;
    private float carPointSize;
    private final float carPointSizeDP;
    private float colorBarEdgeWidth;
    private final float colorBarEdgeWidthDp;
    private float colorBarMarginTop;
    private final float colorBarMarginTopDp;
    private int height;
    private OnGlobalLayoutListener listener;
    private Paint mBGPaint;
    private Bitmap mCacheBitmap;
    private Canvas mCacheCanvas;
    private double mCurCarProgress;
    private int mItemTotalIndex;
    private int mLastH;
    private int mLastW;
    private Paint[] mPaints;
    private Paint mPassPaint;
    private List<RoadConditionItem> mRoadConditionItems;
    private int width;

    /* renamed from: com.baidu.navisdk.ui.routeguide.subview.widget.RGRoadConditionView$1 */
    class C44681 implements OnGlobalLayoutListener {
        C44681() {
        }

        public void onGlobalLayout() {
            long cacheBitmapSize = (((long) RGRoadConditionView.this.getHeight()) * ((long) RGRoadConditionView.this.getWidth())) * 16;
            LogUtil.m15791e(RGRoadConditionView.TAG, "---> RGRoadConditionView: height is " + RGRoadConditionView.this.getHeight() + ", width is " + RGRoadConditionView.this.getWidth() + ", cacheBitmapSize is " + cacheBitmapSize);
            if (RGRoadConditionView.this.getHeight() > 10000 || RGRoadConditionView.this.getWidth() > 10000 || cacheBitmapSize > 2147483647L) {
                LogUtil.m15791e(RGRoadConditionView.TAG, "---> RGRoadConditionView: cacheBitmapSize is " + cacheBitmapSize + ", cacheBitmapSize exceeds 32 bits ");
                return;
            }
            RGRoadConditionView.this.height = RGRoadConditionView.this.getHeight();
            RGRoadConditionView.this.width = RGRoadConditionView.this.getWidth();
            RGRoadConditionView.this.carPointEdgeWidth = (float) ((int) ((((float) RGRoadConditionView.this.width) - RGRoadConditionView.this.carPointSize) / 2.0f));
            if (RGRoadConditionView.this.height != 0) {
                RGRoadConditionView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    public RGRoadConditionView(Context context) {
        super(context);
        this.colorBarEdgeWidthDp = 8.0f;
        this.colorBarEdgeWidth = 16.0f;
        this.colorBarMarginTopDp = 6.67f;
        this.colorBarMarginTop = 13.34f;
        this.carPointSizeDP = 27.3f;
        this.carPointSize = 54.6f;
        this.carPointEdgeWidth = 0.0f;
        this.carPointPlaintEdgeDp = 3.0f;
        this.carPointPlaintEdge = 6.0f;
        this.mCurCarProgress = 0.0d;
        this.mRoadConditionItems = new ArrayList();
        this.mItemTotalIndex = 0;
        this.mBGPaint = null;
        this.mPaints = new Paint[5];
        this.mPassPaint = null;
        this.mCacheBitmap = null;
        this.mCacheCanvas = null;
        this.mLastW = 0;
        this.mLastH = 0;
        this.height = 0;
        this.width = 0;
        this.bgBitmap = null;
        this.carPointBitmap = null;
        initPaints();
        initListener();
        this.colorBarEdgeWidth = (float) ScreenUtil.getInstance().dip2px(8.0f);
        this.carPointSize = (float) ScreenUtil.getInstance().dip2px(27.3f);
        this.colorBarMarginTop = (float) ScreenUtil.getInstance().dip2px(6.67f);
        this.carPointPlaintEdge = (float) ScreenUtil.getInstance().dip2px(3.0f);
        this.mCurCarProgress = RGAssistGuideModel.getInstance().getCarProgress();
        this.bgBitmap = (NinePatchDrawable) getBackground();
        this.carPointBitmap = BNStyleManager.getBitmap(C4048R.drawable.nsdk_drawable_roadcondition_carpoint);
        setBackgroundDrawable(null);
    }

    public RGRoadConditionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.colorBarEdgeWidthDp = 8.0f;
        this.colorBarEdgeWidth = 16.0f;
        this.colorBarMarginTopDp = 6.67f;
        this.colorBarMarginTop = 13.34f;
        this.carPointSizeDP = 27.3f;
        this.carPointSize = 54.6f;
        this.carPointEdgeWidth = 0.0f;
        this.carPointPlaintEdgeDp = 3.0f;
        this.carPointPlaintEdge = 6.0f;
        this.mCurCarProgress = 0.0d;
        this.mRoadConditionItems = new ArrayList();
        this.mItemTotalIndex = 0;
        this.mBGPaint = null;
        this.mPaints = new Paint[5];
        this.mPassPaint = null;
        this.mCacheBitmap = null;
        this.mCacheCanvas = null;
        this.mLastW = 0;
        this.mLastH = 0;
        this.height = 0;
        this.width = 0;
        this.bgBitmap = null;
        this.carPointBitmap = null;
        initPaints();
        initListener();
        this.colorBarEdgeWidth = (float) ScreenUtil.getInstance().dip2px(8.0f);
        this.carPointSize = (float) ScreenUtil.getInstance().dip2px(27.3f);
        this.colorBarMarginTop = (float) ScreenUtil.getInstance().dip2px(6.67f);
        this.carPointPlaintEdge = (float) ScreenUtil.getInstance().dip2px(3.0f);
        this.mCurCarProgress = RGAssistGuideModel.getInstance().getCarProgress();
        this.bgBitmap = (NinePatchDrawable) getBackground();
        this.carPointBitmap = BNStyleManager.getBitmap(C4048R.drawable.nsdk_drawable_roadcondition_carpoint);
        setBackgroundDrawable(null);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        getViewTreeObserver().addOnGlobalLayoutListener(this.listener);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.width > 0 && this.height > 0) {
            if (this.mCacheBitmap == null || this.mCacheCanvas == null || this.width != this.mLastW || this.height != this.mLastH) {
                if (this.mCacheBitmap != null) {
                    this.mCacheBitmap.recycle();
                    this.mCacheBitmap = null;
                }
                this.mLastW = this.width;
                this.mLastH = this.height;
                this.mCacheBitmap = Bitmap.createBitmap(this.width, this.height, Config.ARGB_4444);
                this.mCacheBitmap.eraseColor(0);
                this.mCacheCanvas = new Canvas(this.mCacheBitmap);
            }
            if (this.mCacheBitmap != null && this.mCacheCanvas != null) {
                int drawRectBottom = (int) (((float) this.height) - this.carPointSize);
                int itemStartIndex = 0;
                this.bgBitmap.setBounds(new Rect(0, 0, this.width, (int) ((((float) this.height) - this.carPointSize) + this.colorBarMarginTop)));
                this.bgBitmap.draw(canvas);
                canvas.saveLayer(0.0f, 0.0f, (float) this.width, (float) this.height, this.mBGPaint, 31);
                this.mCacheCanvas.drawRect(this.colorBarEdgeWidth, this.colorBarMarginTop, ((float) this.width) - this.colorBarEdgeWidth, (float) drawRectBottom, this.mPaints[0]);
                if (isRoadConditionDataValid()) {
                    for (int i = 0; i < this.mRoadConditionItems.size(); i++) {
                        RoadConditionItem item = (RoadConditionItem) this.mRoadConditionItems.get(i);
                        int drawRectTop = drawRectBottom - getRoadConditionItemDrawHeight(itemStartIndex, item.curItemEndIndex, (int) (((float) this.height) - this.carPointSize));
                        if (i == this.mRoadConditionItems.size() - 1) {
                            drawRectTop = (int) this.colorBarMarginTop;
                        }
                        if (this.mRoadConditionItems.size() != 1) {
                            this.mCacheCanvas.drawRect(this.colorBarEdgeWidth, (float) drawRectTop, ((float) this.width) - this.colorBarEdgeWidth, (float) drawRectBottom, this.mPaints[item.roadConditionType]);
                        } else {
                            this.mCacheCanvas.drawRect(this.colorBarEdgeWidth, this.colorBarMarginTop, ((float) this.width) - this.colorBarEdgeWidth, (float) drawRectBottom, this.mPaints[item.roadConditionType]);
                        }
                        itemStartIndex = item.curItemEndIndex;
                        drawRectBottom = drawRectTop;
                    }
                }
                int curCarPointH = (int) ((((double) ((((float) this.height) - this.carPointSize) - this.colorBarMarginTop)) * (1.0d - this.mCurCarProgress)) + ((double) this.colorBarMarginTop));
                this.mCacheCanvas.drawRect(this.colorBarEdgeWidth, (float) curCarPointH, ((float) this.width) - this.colorBarEdgeWidth, ((float) this.height) - this.carPointSize, this.mPassPaint);
                canvas.drawRoundRect(new RectF(this.colorBarEdgeWidth, this.colorBarMarginTop, ((float) this.width) - this.colorBarEdgeWidth, ((float) this.height) - this.carPointSize), (((float) this.width) - (2.0f * this.colorBarEdgeWidth)) / 2.0f, (((float) this.width) - (2.0f * this.colorBarEdgeWidth)) / 2.0f, this.mBGPaint);
                this.mBGPaint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                canvas.drawBitmap(this.mCacheBitmap, 0.0f, 0.0f, this.mBGPaint);
                this.mBGPaint.setXfermode(null);
                canvas.saveLayer(0.0f, 0.0f, (float) this.width, (float) this.height, this.mBGPaint, 31);
                RectF carPointRectF = new RectF(this.carPointEdgeWidth, ((float) curCarPointH) - this.carPointPlaintEdge, ((float) this.width) - this.carPointEdgeWidth, (((float) curCarPointH) + this.carPointSize) - this.carPointPlaintEdge);
                canvas.drawBitmap(this.carPointBitmap, null, carPointRectF, this.mBGPaint);
                canvas.restore();
            }
        }
    }

    private void initPaints() {
        this.mBGPaint = new Paint();
        this.mBGPaint.setAntiAlias(true);
        this.mPassPaint = new Paint();
        this.mPassPaint.setColor(RoadConditionItem.Color_Of_Pass_Road);
        this.mPaints[0] = new Paint();
        this.mPaints[0].setColor(RoadConditionItem.getRoadConditionColor(0));
        this.mPaints[1] = new Paint();
        this.mPaints[1].setColor(RoadConditionItem.getRoadConditionColor(1));
        this.mPaints[2] = new Paint();
        this.mPaints[2].setColor(RoadConditionItem.getRoadConditionColor(2));
        this.mPaints[3] = new Paint();
        this.mPaints[3].setColor(RoadConditionItem.getRoadConditionColor(3));
        this.mPaints[4] = new Paint();
        this.mPaints[4].setColor(RoadConditionItem.getRoadConditionColor(4));
    }

    private void initListener() {
        this.listener = new C44681();
    }

    private boolean isRoadConditionDataValid() {
        if (this.mRoadConditionItems == null || this.mRoadConditionItems.size() <= 0) {
            return false;
        }
        return true;
    }

    private int getRoadConditionItemDrawHeight(int itemStartIndex, int itemEndIndex, int h) {
        if (this.mItemTotalIndex <= 0) {
            return 0;
        }
        return (int) (((1.0d * ((double) ((((float) h) - this.colorBarMarginTop) - this.carPointSize))) * ((double) (itemEndIndex - itemStartIndex))) / ((double) this.mItemTotalIndex));
    }

    public void updateCarProgress(double carProgress) {
        this.mCurCarProgress = carProgress;
    }

    public void resetRoadConditionData() {
        if (this.mRoadConditionItems != null) {
            this.mRoadConditionItems.clear();
        }
    }

    public void updateRoadConditionData(List<RoadConditionItem> data) {
        if (data != null && data.size() != 0) {
            if (this.mRoadConditionItems != null) {
                this.mRoadConditionItems.clear();
            }
            this.mRoadConditionItems.addAll(data);
            this.mItemTotalIndex = ((RoadConditionItem) this.mRoadConditionItems.get(this.mRoadConditionItems.size() - 1)).curItemEndIndex;
        }
    }

    public void recycle() {
        if (this.mCacheBitmap != null) {
            this.mCacheBitmap.recycle();
            this.mCacheBitmap = null;
        }
        if (this.bgBitmap != null) {
            this.bgBitmap = null;
        }
        if (this.carPointBitmap != null) {
            this.carPointBitmap.recycle();
            this.carPointBitmap = null;
        }
    }
}
