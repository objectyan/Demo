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

public class RGRoadConditionBar
  extends View
{
  public static int EDGE_WIDTH = 4;
  public static final int EDGE_WIDTH_DP = 2;
  private Paint mBGPaint = null;
  private Bitmap mCacheBitmap = null;
  private Canvas mCacheCanvas = null;
  private Paint mCarGreaterPaint = null;
  private int mCarHeight = 0;
  private Paint mCarLitterPaint = null;
  private Paint mCarPaint = null;
  private Path mCarPath = new Path();
  private int mCarWidth = 0;
  private double mCurCarProgress = 0.0D;
  private int mItemTotalIndex = 0;
  private int mLastH = 0;
  private int mLastW = 0;
  private Paint[] mPaints = new Paint[5];
  private Paint mPassPaint = null;
  private List<RoadConditionItem> mRoadConditionItems = new ArrayList();
  
  public RGRoadConditionBar(Context paramContext)
  {
    super(paramContext);
    initPaints();
    EDGE_WIDTH = ScreenUtil.getInstance().dip2px(2);
    this.mCurCarProgress = RGAssistGuideModel.getInstance().getCarProgress();
  }
  
  public RGRoadConditionBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initPaints();
    EDGE_WIDTH = ScreenUtil.getInstance().dip2px(2);
    this.mCurCarProgress = RGAssistGuideModel.getInstance().getCarProgress();
  }
  
  public RGRoadConditionBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initPaints();
    EDGE_WIDTH = ScreenUtil.getInstance().dip2px(2);
    this.mCurCarProgress = RGAssistGuideModel.getInstance().getCarProgress();
  }
  
  private void drawCar(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 -= this.mCarHeight / 2;
    int j = paramInt1;
    int k = paramInt1 + this.mCarHeight;
    int i = k;
    paramInt1 = j;
    if (k > paramInt3)
    {
      paramInt1 = j - (k - paramInt3);
      i = k - (k - paramInt3);
    }
    paramInt3 = paramInt2 / 4;
    j = paramInt2 / 2;
    paramCanvas.drawCircle(paramInt2 / 2, (paramInt1 + i) / 2, j, this.mCarGreaterPaint);
    paramCanvas.drawCircle(paramInt2 / 2, (paramInt1 + i) / 2, paramInt3, this.mCarLitterPaint);
  }
  
  private int getRoadConditionItemDrawHeight(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mItemTotalIndex <= 0) {
      return 0;
    }
    return (int)(1.0D * paramInt3 * (paramInt2 - paramInt1) / this.mItemTotalIndex);
  }
  
  private void initPaints()
  {
    this.mBGPaint = new Paint();
    this.mBGPaint.setColor(0);
    this.mPassPaint = new Paint();
    this.mPassPaint.setColor(-3158065);
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
  
  private boolean isRoadConditionDataValid()
  {
    return (this.mRoadConditionItems != null) && (this.mRoadConditionItems.size() > 0);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = getMeasuredWidth();
    int m = getMeasuredHeight();
    if ((i1 <= 0) || (m <= 0)) {}
    do
    {
      return;
      if ((this.mCacheBitmap == null) || (this.mCacheCanvas == null) || (i1 != this.mLastW) || (m != this.mLastH))
      {
        if (this.mCacheBitmap != null)
        {
          this.mCacheBitmap.recycle();
          this.mCacheBitmap = null;
        }
        this.mLastW = i1;
        this.mLastH = m;
        this.mCacheBitmap = Bitmap.createBitmap(i1, m, Bitmap.Config.ARGB_4444);
        this.mCacheBitmap.eraseColor(0);
        this.mCacheCanvas = new Canvas(this.mCacheBitmap);
        this.mCarWidth = i1;
        this.mCarHeight = i1;
      }
    } while ((this.mCacheBitmap == null) || (this.mCacheCanvas == null));
    int k = m;
    int i = 0;
    this.mCacheCanvas.drawRect(EDGE_WIDTH, EDGE_WIDTH, i1 - EDGE_WIDTH, k - EDGE_WIDTH, this.mPaints[0]);
    if (isRoadConditionDataValid())
    {
      int j = 0;
      if (j < this.mRoadConditionItems.size())
      {
        RoadConditionItem localRoadConditionItem = (RoadConditionItem)this.mRoadConditionItems.get(j);
        i = k - getRoadConditionItemDrawHeight(i, localRoadConditionItem.curItemEndIndex, m);
        if (j == this.mRoadConditionItems.size() - 1) {
          i = 0;
        }
        if (this.mRoadConditionItems.size() != 1) {
          if (j == 0) {
            this.mCacheCanvas.drawRect(EDGE_WIDTH, i, i1 - EDGE_WIDTH, k - EDGE_WIDTH, this.mPaints[localRoadConditionItem.roadConditionType]);
          }
        }
        for (;;)
        {
          int n = localRoadConditionItem.curItemEndIndex;
          j += 1;
          k = i;
          i = n;
          break;
          if (j == this.mRoadConditionItems.size() - 1)
          {
            this.mCacheCanvas.drawRect(EDGE_WIDTH, EDGE_WIDTH + i, i1 - EDGE_WIDTH, k, this.mPaints[localRoadConditionItem.roadConditionType]);
          }
          else
          {
            this.mCacheCanvas.drawRect(EDGE_WIDTH, i, i1 - EDGE_WIDTH, k, this.mPaints[localRoadConditionItem.roadConditionType]);
            continue;
            this.mCacheCanvas.drawRect(EDGE_WIDTH, EDGE_WIDTH + i, i1 - EDGE_WIDTH, k - EDGE_WIDTH, this.mPaints[localRoadConditionItem.roadConditionType]);
          }
        }
      }
    }
    i = (int)(m - m * this.mCurCarProgress);
    this.mCacheCanvas.drawRect(EDGE_WIDTH, i, i1 - EDGE_WIDTH, m - EDGE_WIDTH, this.mPassPaint);
    paramCanvas.drawBitmap(this.mCacheBitmap, 0.0F, 0.0F, null);
  }
  
  public void resetRoadConditionData()
  {
    if (this.mRoadConditionItems != null) {
      this.mRoadConditionItems.clear();
    }
  }
  
  public void updateCarProgress(double paramDouble)
  {
    this.mCurCarProgress = paramDouble;
  }
  
  public void updateRoadConditionData(List<RoadConditionItem> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if (this.mRoadConditionItems != null) {
      this.mRoadConditionItems.clear();
    }
    this.mRoadConditionItems.addAll(paramList);
    this.mItemTotalIndex = ((RoadConditionItem)this.mRoadConditionItems.get(this.mRoadConditionItems.size() - 1)).curItemEndIndex;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/widget/RGRoadConditionBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */