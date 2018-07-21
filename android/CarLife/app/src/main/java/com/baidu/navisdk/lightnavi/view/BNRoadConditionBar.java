package com.baidu.navisdk.lightnavi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.navisdk.ui.util.BNStyleManager;
import java.util.ArrayList;
import java.util.Iterator;

public class BNRoadConditionBar
  extends View
{
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
  
  public BNRoadConditionBar(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public BNRoadConditionBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public BNRoadConditionBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mRoadCondRect = new ArrayList();
    this.mPaint = new Paint();
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mRouteConTypeNum = 0;
    this.mDistance = 0;
  }
  
  public int getColorByRoadCondType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return BNStyleManager.getColor(1711800734);
    case 0: 
      return BNStyleManager.getColor(1711800734);
    case 1: 
      return BNStyleManager.getColor(1711800733);
    case 2: 
      return BNStyleManager.getColor(1711800732);
    case 3: 
      return BNStyleManager.getColor(1711800731);
    }
    return BNStyleManager.getColor(1711800730);
  }
  
  public void getRoadCondRectLocation(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt2 == null)) {}
    while (paramInt1 == 0) {
      return;
    }
    label27:
    float f3;
    float f4;
    float f5;
    int i;
    label49:
    RoadCondRect localRoadCondRect;
    float f2;
    if (this.mRoadCondRect != null)
    {
      this.mRoadCondRect.clear();
      f3 = this.mViewY;
      f4 = this.mViewY;
      f5 = this.mViewHeight;
      i = 0;
      if (i < paramInt2)
      {
        localRoadCondRect = new RoadCondRect();
        if (i != 0) {
          break label167;
        }
        f2 = this.mViewWidth * paramArrayOfInt1[i] / paramInt1;
      }
    }
    for (float f1 = this.mViewX;; f1 = ((RoadCondRect)this.mRoadCondRect.get(i - 1)).endX)
    {
      localRoadCondRect.startX = f1;
      localRoadCondRect.startY = f3;
      localRoadCondRect.endX = (f1 + f2);
      localRoadCondRect.endY = (f4 + f5);
      localRoadCondRect.type = paramArrayOfInt2[i];
      this.mRoadCondRect.add(localRoadCondRect);
      i += 1;
      break label49;
      break;
      this.mRoadCondRect = new ArrayList();
      break label27;
      label167:
      f2 = this.mViewWidth * (paramArrayOfInt1[i] - paramArrayOfInt1[(i - 1)]) / paramInt1;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mViewX = 0.0F;
    this.mViewY = 0.0F;
    this.mViewWidth = getWidth();
    this.mViewHeight = getHeight();
    getRoadCondRectLocation(this.mDistance, this.mRoadShapeArray, this.mRoadCondTypeArray, this.mRouteConTypeNum);
    if (this.mRoadCondRect == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mRoadCondRect.iterator();
      while (localIterator.hasNext())
      {
        RoadCondRect localRoadCondRect = (RoadCondRect)localIterator.next();
        int i = getColorByRoadCondType(localRoadCondRect.type);
        this.mPaint.setColor(i);
        paramCanvas.drawRect(localRoadCondRect.startX, localRoadCondRect.startY, localRoadCondRect.endX, localRoadCondRect.endY, this.mPaint);
      }
    }
  }
  
  public void setRouteConditionInfo(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.mRouteConTypeNum = paramInt2;
    this.mDistance = paramInt1;
    this.mRoadShapeArray = new int[this.mRouteConTypeNum];
    this.mRoadCondTypeArray = new int[this.mRouteConTypeNum];
    paramInt1 = 0;
    while (paramInt1 < this.mRouteConTypeNum)
    {
      this.mRoadShapeArray[paramInt1] = paramArrayOfInt1[paramInt1];
      this.mRoadCondTypeArray[paramInt1] = paramArrayOfInt2[paramInt1];
      paramInt1 += 1;
    }
  }
  
  public class RoadCondRect
  {
    public float endX;
    public float endY;
    public float startX;
    public float startY;
    public int type;
    
    public RoadCondRect() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/lightnavi/view/BNRoadConditionBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */