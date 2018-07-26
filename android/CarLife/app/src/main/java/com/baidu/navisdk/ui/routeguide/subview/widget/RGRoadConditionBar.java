package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.navisdk.model.datastruct.RoadConditionItem;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.ArrayList;
import java.util.List;

public class RGRoadConditionBar extends View {
    public static int EDGE_WIDTH = 4;
    public static final int EDGE_WIDTH_DP = 2;
    private Paint mBGPaint;
    private Bitmap mCacheBitmap;
    private Canvas mCacheCanvas;
    private Paint mCarGreaterPaint;
    private int mCarHeight;
    private Paint mCarLitterPaint;
    private Paint mCarPaint;
    private Path mCarPath;
    private int mCarWidth;
    private double mCurCarProgress;
    private int mItemTotalIndex;
    private int mLastH;
    private int mLastW;
    private Paint[] mPaints;
    private Paint mPassPaint;
    private List<RoadConditionItem> mRoadConditionItems;

    public RGRoadConditionBar(Context context) {
        super(context);
        this.mCurCarProgress = 0.0d;
        this.mCarHeight = 0;
        this.mCarWidth = 0;
        this.mCarPath = new Path();
        this.mRoadConditionItems = new ArrayList();
        this.mItemTotalIndex = 0;
        this.mBGPaint = null;
        this.mPaints = new Paint[5];
        this.mPassPaint = null;
        this.mCarPaint = null;
        this.mCarGreaterPaint = null;
        this.mCarLitterPaint = null;
        this.mCacheBitmap = null;
        this.mCacheCanvas = null;
        this.mLastW = 0;
        this.mLastH = 0;
        initPaints();
        EDGE_WIDTH = ScreenUtil.getInstance().dip2px(2);
        this.mCurCarProgress = RGAssistGuideModel.getInstance().getCarProgress();
    }

    public RGRoadConditionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mCurCarProgress = 0.0d;
        this.mCarHeight = 0;
        this.mCarWidth = 0;
        this.mCarPath = new Path();
        this.mRoadConditionItems = new ArrayList();
        this.mItemTotalIndex = 0;
        this.mBGPaint = null;
        this.mPaints = new Paint[5];
        this.mPassPaint = null;
        this.mCarPaint = null;
        this.mCarGreaterPaint = null;
        this.mCarLitterPaint = null;
        this.mCacheBitmap = null;
        this.mCacheCanvas = null;
        this.mLastW = 0;
        this.mLastH = 0;
        initPaints();
        EDGE_WIDTH = ScreenUtil.getInstance().dip2px(2);
        this.mCurCarProgress = RGAssistGuideModel.getInstance().getCarProgress();
    }

    public RGRoadConditionBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mCurCarProgress = 0.0d;
        this.mCarHeight = 0;
        this.mCarWidth = 0;
        this.mCarPath = new Path();
        this.mRoadConditionItems = new ArrayList();
        this.mItemTotalIndex = 0;
        this.mBGPaint = null;
        this.mPaints = new Paint[5];
        this.mPassPaint = null;
        this.mCarPaint = null;
        this.mCarGreaterPaint = null;
        this.mCarLitterPaint = null;
        this.mCacheBitmap = null;
        this.mCacheCanvas = null;
        this.mLastW = 0;
        this.mLastH = 0;
        initPaints();
        EDGE_WIDTH = ScreenUtil.getInstance().dip2px(2);
        this.mCurCarProgress = RGAssistGuideModel.getInstance().getCarProgress();
    }

    private void initPaints() {
        this.mBGPaint = new Paint();
        this.mBGPaint.setColor(0);
        this.mPassPaint = new Paint();
        this.mPassPaint.setColor(RoadConditionItem.Color_Of_Pass_Road);
        this.mCarPaint = new Paint();
        this.mCarPaint.setColor(-1);
        this.mCarGreaterPaint = new Paint();
        this.mCarGreaterPaint.setColor(-1);
        this.mCarGreaterPaint.setAntiAlias(true);
        this.mCarLitterPaint = new Paint();
        this.mCarLitterPaint.setColor(-16776961);
        this.mCarLitterPaint.setAntiAlias(true);
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

    private boolean isRoadConditionDataValid() {
        if (this.mRoadConditionItems == null || this.mRoadConditionItems.size() <= 0) {
            return false;
        }
        return true;
    }

    public void updateCarProgress(double carProgress) {
        this.mCurCarProgress = carProgress;
    }

    private int getRoadConditionItemDrawHeight(int itemStartIndex, int itemEndIndex, int h) {
        if (this.mItemTotalIndex <= 0) {
            return 0;
        }
        return (int) (((1.0d * ((double) h)) * ((double) (itemEndIndex - itemStartIndex))) / ((double) this.mItemTotalIndex));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = getMeasuredWidth();
        int h = getMeasuredHeight();
        if (w > 0 && h > 0) {
            if (this.mCacheBitmap == null || this.mCacheCanvas == null || w != this.mLastW || h != this.mLastH) {
                if (this.mCacheBitmap != null) {
                    this.mCacheBitmap.recycle();
                    this.mCacheBitmap = null;
                }
                this.mLastW = w;
                this.mLastH = h;
                this.mCacheBitmap = Bitmap.createBitmap(w, h, Config.ARGB_4444);
                this.mCacheBitmap.eraseColor(0);
                this.mCacheCanvas = new Canvas(this.mCacheBitmap);
                this.mCarWidth = w;
                this.mCarHeight = w;
            }
            if (this.mCacheBitmap != null && this.mCacheCanvas != null) {
                int drawRectBottom = h;
                int itemStartIndex = 0;
                this.mCacheCanvas.drawRect((float) EDGE_WIDTH, (float) EDGE_WIDTH, (float) (w - EDGE_WIDTH), (float) (drawRectBottom - EDGE_WIDTH), this.mPaints[0]);
                if (isRoadConditionDataValid()) {
                    for (int i = 0; i < this.mRoadConditionItems.size(); i++) {
                        RoadConditionItem item = (RoadConditionItem) this.mRoadConditionItems.get(i);
                        int drawRectTop = drawRectBottom - getRoadConditionItemDrawHeight(itemStartIndex, item.curItemEndIndex, h);
                        if (i == this.mRoadConditionItems.size() - 1) {
                            drawRectTop = 0;
                        }
                        if (this.mRoadConditionItems.size() == 1) {
                            this.mCacheCanvas.drawRect((float) EDGE_WIDTH, (float) (EDGE_WIDTH + drawRectTop), (float) (w - EDGE_WIDTH), (float) (drawRectBottom - EDGE_WIDTH), this.mPaints[item.roadConditionType]);
                        } else if (i == 0) {
                            this.mCacheCanvas.drawRect((float) EDGE_WIDTH, (float) drawRectTop, (float) (w - EDGE_WIDTH), (float) (drawRectBottom - EDGE_WIDTH), this.mPaints[item.roadConditionType]);
                        } else if (i == this.mRoadConditionItems.size() - 1) {
                            this.mCacheCanvas.drawRect((float) EDGE_WIDTH, (float) (EDGE_WIDTH + drawRectTop), (float) (w - EDGE_WIDTH), (float) drawRectBottom, this.mPaints[item.roadConditionType]);
                        } else {
                            this.mCacheCanvas.drawRect((float) EDGE_WIDTH, (float) drawRectTop, (float) (w - EDGE_WIDTH), (float) drawRectBottom, this.mPaints[item.roadConditionType]);
                        }
                        itemStartIndex = item.curItemEndIndex;
                        drawRectBottom = drawRectTop;
                    }
                }
                this.mCacheCanvas.drawRect((float) EDGE_WIDTH, (float) ((int) (((double) h) - (((double) h) * this.mCurCarProgress))), (float) (w - EDGE_WIDTH), (float) (h - EDGE_WIDTH), this.mPassPaint);
                canvas.drawBitmap(this.mCacheBitmap, 0.0f, 0.0f, null);
            }
        }
    }

    private void drawCar(Canvas cv, int curCarPointH, int w, int h) {
        curCarPointH -= this.mCarHeight / 2;
        int carTop = curCarPointH;
        int carBottom = curCarPointH + this.mCarHeight;
        if (carBottom > h) {
            carTop -= carBottom - h;
            carBottom -= carBottom - h;
        }
        int litterRadius = w / 4;
        cv.drawCircle((float) (w / 2), (float) ((carTop + carBottom) / 2), (float) (w / 2), this.mCarGreaterPaint);
        cv.drawCircle((float) (w / 2), (float) ((carTop + carBottom) / 2), (float) litterRadius, this.mCarLitterPaint);
    }
}
