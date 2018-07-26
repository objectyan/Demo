package com.baidu.navisdk.lightnavi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.util.BNStyleManager;
import java.util.ArrayList;
import java.util.Iterator;

public class BNRoadConditionBar extends View {
    private int mDistance;
    private Paint mPaint;
    private ArrayList<RoadCondRect> mRoadCondRect;
    private int[] mRoadCondTypeArray = null;
    private int[] mRoadShapeArray = null;
    private int mRouteConTypeNum;
    private int mViewHeight;
    private int mViewWidth;
    private float mViewX;
    private float mViewY;

    public class RoadCondRect {
        public float endX;
        public float endY;
        public float startX;
        public float startY;
        public int type;
    }

    public BNRoadConditionBar(Context context) {
        super(context);
        init();
    }

    public BNRoadConditionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BNRoadConditionBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        this.mRoadCondRect = new ArrayList();
        this.mPaint = new Paint();
        this.mPaint.setStyle(Style.FILL);
        this.mRouteConTypeNum = 0;
        this.mDistance = 0;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mViewX = 0.0f;
        this.mViewY = 0.0f;
        this.mViewWidth = getWidth();
        this.mViewHeight = getHeight();
        getRoadCondRectLocation(this.mDistance, this.mRoadShapeArray, this.mRoadCondTypeArray, this.mRouteConTypeNum);
        if (this.mRoadCondRect != null) {
            Iterator<RoadCondRect> iterator = this.mRoadCondRect.iterator();
            while (iterator.hasNext()) {
                RoadCondRect rect = (RoadCondRect) iterator.next();
                this.mPaint.setColor(getColorByRoadCondType(rect.type));
                canvas.drawRect(rect.startX, rect.startY, rect.endX, rect.endY, this.mPaint);
            }
        }
    }

    public void setRouteConditionInfo(int distance, int num, int[] roadShapeIndexArray, int[] routeCondTypeArray) {
        this.mRouteConTypeNum = num;
        this.mDistance = distance;
        this.mRoadShapeArray = new int[this.mRouteConTypeNum];
        this.mRoadCondTypeArray = new int[this.mRouteConTypeNum];
        for (int i = 0; i < this.mRouteConTypeNum; i++) {
            this.mRoadShapeArray[i] = roadShapeIndexArray[i];
            this.mRoadCondTypeArray[i] = routeCondTypeArray[i];
        }
    }

    public int getColorByRoadCondType(int type) {
        switch (type) {
            case 0:
                return BNStyleManager.getColor(C4048R.color.nsdk_ipo_road_condition_invalid);
            case 1:
                return BNStyleManager.getColor(C4048R.color.nsdk_ipo_road_condition_good);
            case 2:
                return BNStyleManager.getColor(C4048R.color.nsdk_ipo_road_condition_bad);
            case 3:
                return BNStyleManager.getColor(C4048R.color.nsdk_ipo_road_condition_worse);
            case 4:
                return BNStyleManager.getColor(C4048R.color.nsdk_ipo_road_condition_worst);
            default:
                return BNStyleManager.getColor(C4048R.color.nsdk_ipo_road_condition_invalid);
        }
    }

    public void getRoadCondRectLocation(int distance, int[] roadShapeIndexArray, int[] routeCondTypeArray, int size) {
        if (roadShapeIndexArray != null && routeCondTypeArray != null && distance != 0) {
            if (this.mRoadCondRect != null) {
                this.mRoadCondRect.clear();
            } else {
                this.mRoadCondRect = new ArrayList();
            }
            float startY = this.mViewY;
            float endY = this.mViewY + ((float) this.mViewHeight);
            for (int i = 0; i < size; i++) {
                float width;
                float startX;
                RoadCondRect rect = new RoadCondRect();
                if (i == 0) {
                    width = (float) ((this.mViewWidth * roadShapeIndexArray[i]) / distance);
                    startX = this.mViewX;
                } else {
                    width = (float) ((this.mViewWidth * (roadShapeIndexArray[i] - roadShapeIndexArray[i - 1])) / distance);
                    startX = ((RoadCondRect) this.mRoadCondRect.get(i - 1)).endX;
                }
                float endX = startX + width;
                rect.startX = startX;
                rect.startY = startY;
                rect.endX = endX;
                rect.endY = endY;
                rect.type = routeCondTypeArray[i];
                this.mRoadCondRect.add(rect);
            }
        }
    }
}
