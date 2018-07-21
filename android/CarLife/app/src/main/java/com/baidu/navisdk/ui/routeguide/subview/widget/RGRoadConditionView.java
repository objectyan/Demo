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
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.baidu.navisdk.model.datastruct.RoadConditionItem;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.ArrayList;
import java.util.List;

public class RGRoadConditionView
  extends View
{
  private static final String TAG = "RGRoadConditionView";
  private NinePatchDrawable bgBitmap = null;
  private Bitmap carPointBitmap = null;
  private float carPointEdgeWidth = 0.0F;
  private float carPointPlaintEdge = 6.0F;
  private final float carPointPlaintEdgeDp = 3.0F;
  private float carPointSize = 54.6F;
  private final float carPointSizeDP = 27.3F;
  private float colorBarEdgeWidth = 16.0F;
  private final float colorBarEdgeWidthDp = 8.0F;
  private float colorBarMarginTop = 13.34F;
  private final float colorBarMarginTopDp = 6.67F;
  private int height = 0;
  private ViewTreeObserver.OnGlobalLayoutListener listener;
  private Paint mBGPaint = null;
  private Bitmap mCacheBitmap = null;
  private Canvas mCacheCanvas = null;
  private double mCurCarProgress = 0.0D;
  private int mItemTotalIndex = 0;
  private int mLastH = 0;
  private int mLastW = 0;
  private Paint[] mPaints = new Paint[5];
  private Paint mPassPaint = null;
  private List<RoadConditionItem> mRoadConditionItems = new ArrayList();
  private int width = 0;
  
  public RGRoadConditionView(Context paramContext)
  {
    super(paramContext);
    initPaints();
    initListener();
    this.colorBarEdgeWidth = ScreenUtil.getInstance().dip2px(8.0F);
    this.carPointSize = ScreenUtil.getInstance().dip2px(27.3F);
    this.colorBarMarginTop = ScreenUtil.getInstance().dip2px(6.67F);
    this.carPointPlaintEdge = ScreenUtil.getInstance().dip2px(3.0F);
    this.mCurCarProgress = RGAssistGuideModel.getInstance().getCarProgress();
    this.bgBitmap = ((NinePatchDrawable)getBackground());
    this.carPointBitmap = BNStyleManager.getBitmap(1711407822);
    setBackgroundDrawable(null);
  }
  
  public RGRoadConditionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initPaints();
    initListener();
    this.colorBarEdgeWidth = ScreenUtil.getInstance().dip2px(8.0F);
    this.carPointSize = ScreenUtil.getInstance().dip2px(27.3F);
    this.colorBarMarginTop = ScreenUtil.getInstance().dip2px(6.67F);
    this.carPointPlaintEdge = ScreenUtil.getInstance().dip2px(3.0F);
    this.mCurCarProgress = RGAssistGuideModel.getInstance().getCarProgress();
    this.bgBitmap = ((NinePatchDrawable)getBackground());
    this.carPointBitmap = BNStyleManager.getBitmap(1711407822);
    setBackgroundDrawable(null);
  }
  
  private int getRoadConditionItemDrawHeight(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mItemTotalIndex <= 0) {
      return 0;
    }
    return (int)(1.0D * (paramInt3 - this.colorBarMarginTop - this.carPointSize) * (paramInt2 - paramInt1) / this.mItemTotalIndex);
  }
  
  private void initListener()
  {
    this.listener = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        long l = RGRoadConditionView.this.getHeight() * RGRoadConditionView.this.getWidth() * 16L;
        LogUtil.e("RGRoadConditionView", "---> RGRoadConditionView: height is " + RGRoadConditionView.this.getHeight() + ", width is " + RGRoadConditionView.this.getWidth() + ", cacheBitmapSize is " + l);
        if ((RGRoadConditionView.this.getHeight() > 10000) || (RGRoadConditionView.this.getWidth() > 10000) || (l > 2147483647L)) {
          LogUtil.e("RGRoadConditionView", "---> RGRoadConditionView: cacheBitmapSize is " + l + ", cacheBitmapSize exceeds 32 bits ");
        }
        do
        {
          return;
          RGRoadConditionView.access$002(RGRoadConditionView.this, RGRoadConditionView.this.getHeight());
          RGRoadConditionView.access$102(RGRoadConditionView.this, RGRoadConditionView.this.getWidth());
          RGRoadConditionView.access$202(RGRoadConditionView.this, (int)((RGRoadConditionView.this.width - RGRoadConditionView.this.carPointSize) / 2.0F));
        } while (RGRoadConditionView.this.height == 0);
        RGRoadConditionView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      }
    };
  }
  
  private void initPaints()
  {
    this.mBGPaint = new Paint();
    this.mBGPaint.setAntiAlias(true);
    this.mPassPaint = new Paint();
    this.mPassPaint.setColor(-3158065);
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
    if ((this.width <= 0) || (this.height <= 0)) {}
    do
    {
      return;
      if ((this.mCacheBitmap == null) || (this.mCacheCanvas == null) || (this.width != this.mLastW) || (this.height != this.mLastH))
      {
        if (this.mCacheBitmap != null)
        {
          this.mCacheBitmap.recycle();
          this.mCacheBitmap = null;
        }
        this.mLastW = this.width;
        this.mLastH = this.height;
        this.mCacheBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_4444);
        this.mCacheBitmap.eraseColor(0);
        this.mCacheCanvas = new Canvas(this.mCacheBitmap);
      }
    } while ((this.mCacheBitmap == null) || (this.mCacheCanvas == null));
    int k = (int)(this.height - this.carPointSize);
    int i = 0;
    Object localObject = new Rect(0, 0, this.width, (int)(this.height - this.carPointSize + this.colorBarMarginTop));
    this.bgBitmap.setBounds((Rect)localObject);
    this.bgBitmap.draw(paramCanvas);
    paramCanvas.saveLayer(0.0F, 0.0F, this.width, this.height, this.mBGPaint, 31);
    this.mCacheCanvas.drawRect(this.colorBarEdgeWidth, this.colorBarMarginTop, this.width - this.colorBarEdgeWidth, k, this.mPaints[0]);
    if (isRoadConditionDataValid())
    {
      int j = 0;
      if (j < this.mRoadConditionItems.size())
      {
        localObject = (RoadConditionItem)this.mRoadConditionItems.get(j);
        i = k - getRoadConditionItemDrawHeight(i, ((RoadConditionItem)localObject).curItemEndIndex, (int)(this.height - this.carPointSize));
        if (j == this.mRoadConditionItems.size() - 1) {
          i = (int)this.colorBarMarginTop;
        }
        if (this.mRoadConditionItems.size() != 1) {
          this.mCacheCanvas.drawRect(this.colorBarEdgeWidth, i, this.width - this.colorBarEdgeWidth, k, this.mPaints[localObject.roadConditionType]);
        }
        for (;;)
        {
          int m = ((RoadConditionItem)localObject).curItemEndIndex;
          j += 1;
          k = i;
          i = m;
          break;
          this.mCacheCanvas.drawRect(this.colorBarEdgeWidth, this.colorBarMarginTop, this.width - this.colorBarEdgeWidth, k, this.mPaints[localObject.roadConditionType]);
        }
      }
    }
    i = (int)((this.height - this.carPointSize - this.colorBarMarginTop) * (1.0D - this.mCurCarProgress) + this.colorBarMarginTop);
    this.mCacheCanvas.drawRect(this.colorBarEdgeWidth, i, this.width - this.colorBarEdgeWidth, this.height - this.carPointSize, this.mPassPaint);
    paramCanvas.drawRoundRect(new RectF(this.colorBarEdgeWidth, this.colorBarMarginTop, this.width - this.colorBarEdgeWidth, this.height - this.carPointSize), (this.width - 2.0F * this.colorBarEdgeWidth) / 2.0F, (this.width - 2.0F * this.colorBarEdgeWidth) / 2.0F, this.mBGPaint);
    this.mBGPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    paramCanvas.drawBitmap(this.mCacheBitmap, 0.0F, 0.0F, this.mBGPaint);
    this.mBGPaint.setXfermode(null);
    paramCanvas.saveLayer(0.0F, 0.0F, this.width, this.height, this.mBGPaint, 31);
    localObject = new RectF(this.carPointEdgeWidth, i - this.carPointPlaintEdge, this.width - this.carPointEdgeWidth, i + this.carPointSize - this.carPointPlaintEdge);
    paramCanvas.drawBitmap(this.carPointBitmap, null, (RectF)localObject, this.mBGPaint);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    getViewTreeObserver().addOnGlobalLayoutListener(this.listener);
  }
  
  public void recycle()
  {
    if (this.mCacheBitmap != null)
    {
      this.mCacheBitmap.recycle();
      this.mCacheBitmap = null;
    }
    if (this.bgBitmap != null) {
      this.bgBitmap = null;
    }
    if (this.carPointBitmap != null)
    {
      this.carPointBitmap.recycle();
      this.carPointBitmap = null;
    }
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/widget/RGRoadConditionView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */