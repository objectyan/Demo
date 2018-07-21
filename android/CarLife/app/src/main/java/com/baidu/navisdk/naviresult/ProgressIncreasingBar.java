package com.baidu.navisdk.naviresult;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class ProgressIncreasingBar
  extends View
{
  private static final String TAG = ProgressIncreasingBar.class.getSimpleName();
  private int animRate = 3;
  private int animTime = 1;
  private boolean animationFinish = false;
  private Canvas canvas;
  private int comHeight;
  private int comWidth;
  private Handler handler = new Handler();
  private boolean isAnim = true;
  private boolean isHasRateTopView;
  private OnAnimationStateListener listener = null;
  BNWorkerNormalTask<String, String> mRefreshViewTask = new BNWorkerNormalTask("mRefreshViewTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      if ((ProgressIncreasingBar.this.orientation == 0) && (ProgressIncreasingBar.this.rateAnimValue <= ProgressIncreasingBar.this.rateWidth))
      {
        ProgressIncreasingBar.access$102(ProgressIncreasingBar.this, ProgressIncreasingBar.this.rateAnimValue + ProgressIncreasingBar.this.animRate);
        ProgressIncreasingBar.this.invalidate();
      }
      for (;;)
      {
        return null;
        if ((ProgressIncreasingBar.this.orientation == 1) && (ProgressIncreasingBar.this.rateAnimValue <= ProgressIncreasingBar.this.rateHeight))
        {
          ProgressIncreasingBar.access$102(ProgressIncreasingBar.this, ProgressIncreasingBar.this.rateAnimValue + ProgressIncreasingBar.this.animRate);
          ProgressIncreasingBar.this.invalidate();
        }
        else
        {
          ProgressIncreasingBar.access$102(ProgressIncreasingBar.this, 0);
          if (ProgressIncreasingBar.this.listener != null)
          {
            ProgressIncreasingBar.access$602(ProgressIncreasingBar.this, true);
            ProgressIncreasingBar.this.listener.onAnimationFinish(true);
          }
        }
      }
    }
  };
  private int orientation;
  private Paint paint;
  private double progress;
  private Bitmap rataBackgroundBitmap;
  private int rateAnimValue;
  private String rateBackgroundColor;
  private int rateBackgroundId;
  private int rateHeight;
  private View rateTopView;
  private View rateView;
  private int rateWidth;
  
  public ProgressIncreasingBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProgressIncreasingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProgressIncreasingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void drawViewWithBitmap(Paint paramPaint, boolean paramBoolean)
  {
    if (this.rataBackgroundBitmap == null) {
      return;
    }
    if (paramBoolean)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mRefreshViewTask, new BNWorkerConfig(2, 0), this.animTime);
      if (this.orientation == 0)
      {
        localRectF = new RectF(0.0F, 0.0F, this.rateAnimValue, this.comHeight);
        this.canvas.drawBitmap(this.rataBackgroundBitmap, null, localRectF, paramPaint);
        return;
      }
      localRectF = new RectF(0.0F, this.comHeight - this.rateAnimValue, this.comWidth, this.comHeight);
      this.canvas.drawBitmap(this.rataBackgroundBitmap, null, localRectF, paramPaint);
      return;
    }
    if (this.orientation == 0)
    {
      localRectF = new RectF(0.0F, 0.0F, this.rateWidth, this.comHeight);
      this.canvas.drawBitmap(this.rataBackgroundBitmap, null, localRectF, paramPaint);
      return;
    }
    RectF localRectF = new RectF(0.0F, this.comHeight - this.rateHeight, this.comWidth, this.comHeight);
    this.canvas.drawBitmap(this.rataBackgroundBitmap, null, localRectF, paramPaint);
  }
  
  private void drawViewWithColor(Paint paramPaint, boolean paramBoolean)
  {
    paramPaint.setColor(Color.parseColor(this.rateBackgroundColor));
    if (paramBoolean)
    {
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mRefreshViewTask, new BNWorkerConfig(2, 0), this.animTime);
      if (this.orientation == 0)
      {
        this.canvas.drawRect(0.0F, 0.0F, this.rateAnimValue, this.comHeight, paramPaint);
        return;
      }
      this.canvas.drawRect(0.0F, this.comHeight - this.rateAnimValue, this.comWidth, this.comHeight, paramPaint);
      return;
    }
    if (this.orientation == 0)
    {
      this.canvas.drawRect(0.0F, 0.0F, this.rateWidth, this.comHeight, paramPaint);
      return;
    }
    this.canvas.drawRect(0.0F, this.comHeight - this.rateHeight, this.comWidth, this.comHeight, paramPaint);
  }
  
  private Bitmap drawableToBitmap(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramDrawable != null))
    {
      if (paramDrawable.getOpacity() != -1) {}
      for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
      {
        localObject = Bitmap.createBitmap(paramInt1, paramInt2, (Bitmap.Config)localObject);
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
        paramDrawable.draw(localCanvas);
        return (Bitmap)localObject;
      }
    }
    return null;
  }
  
  public int getAnimRate()
  {
    return this.animRate;
  }
  
  public OnAnimationStateListener getListener()
  {
    return this.listener;
  }
  
  public int getOrientation()
  {
    return this.orientation;
  }
  
  public double getProgress()
  {
    return this.progress;
  }
  
  public String getRateBackgroundColor()
  {
    return this.rateBackgroundColor;
  }
  
  public int getRateBackgroundId()
  {
    return this.rateBackgroundId;
  }
  
  public int getRateHeight()
  {
    return this.rateHeight;
  }
  
  public View getRateView()
  {
    return this.rateView;
  }
  
  public int getRateWidth()
  {
    return this.rateWidth;
  }
  
  public boolean isAnim()
  {
    return this.isAnim;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    super.onDraw(paramCanvas);
    this.canvas = paramCanvas;
    if (this.paint == null) {
      this.paint = new Paint();
    }
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.FILL);
    if (this.rateBackgroundColor != null)
    {
      paramCanvas = this.paint;
      if ((this.isAnim) && (!this.animationFinish)) {
        drawViewWithColor(paramCanvas, bool1);
      }
    }
    while (this.rateBackgroundId == -1) {
      for (;;)
      {
        return;
        bool1 = false;
      }
    }
    paramCanvas = this.paint;
    if ((this.isAnim) && (!this.animationFinish)) {}
    for (bool1 = bool2;; bool1 = false)
    {
      drawViewWithBitmap(paramCanvas, bool1);
      return;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.comWidth = paramInt1;
    this.comHeight = paramInt2;
    if (this.orientation == 0)
    {
      this.rateWidth = ((int)(paramInt1 * this.progress));
      this.rateHeight = paramInt2;
      return;
    }
    this.rateHeight = ((int)(paramInt2 * this.progress));
    this.rateWidth = paramInt1;
  }
  
  public void setAnim(boolean paramBoolean)
  {
    this.isAnim = paramBoolean;
  }
  
  public void setAnimRate(int paramInt)
  {
    this.animRate = paramInt;
  }
  
  public void setListener(OnAnimationStateListener paramOnAnimationStateListener)
  {
    this.listener = paramOnAnimationStateListener;
  }
  
  public void setOrientation(int paramInt)
  {
    this.orientation = paramInt;
  }
  
  public void setProgress(double paramDouble)
  {
    this.progress = paramDouble;
  }
  
  public void setRateBackgroundColor(String paramString)
  {
    this.rateBackgroundColor = paramString;
    this.rateBackgroundId = -1;
    this.rataBackgroundBitmap = null;
  }
  
  public void setRateBackgroundId(int paramInt)
  {
    this.rateBackgroundId = paramInt;
    this.rataBackgroundBitmap = BitmapFactory.decodeResource(getResources(), this.rateBackgroundId);
    this.rateBackgroundColor = null;
  }
  
  public void setRateBackgroundId(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    this.rateBackgroundId = paramInt1;
    if (paramBoolean) {
      this.rataBackgroundBitmap = drawableToBitmap(JarUtils.getResources().getDrawable(paramInt1), paramInt2, paramInt3);
    }
    this.rateBackgroundColor = null;
  }
  
  public void setRateHeight(int paramInt)
  {
    this.rateHeight = paramInt;
  }
  
  public void setRateView(View paramView)
  {
    this.rateView = paramView;
  }
  
  public void setRateWidth(int paramInt)
  {
    this.rateWidth = paramInt;
  }
  
  public static abstract interface OnAnimationStateListener
  {
    public abstract void onAnimationFinish(boolean paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/naviresult/ProgressIncreasingBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */