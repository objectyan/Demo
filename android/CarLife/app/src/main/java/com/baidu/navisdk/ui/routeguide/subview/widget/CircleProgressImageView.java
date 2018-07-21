package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.baidu.navisdk.R.styleable;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.Timer;
import java.util.TimerTask;

public class CircleProgressImageView
  extends ImageView
{
  private static final boolean DEFAULT_FILL_MODE = true;
  private static final int DEFAULT_INSIDE_VALUE = 0;
  private static final int DEFAULT_MAX_VALUE = 100;
  private static final int DEFAULT_PAINT_COLOR = 0;
  private static final int DEFAULT_PAINT_WIDTH = 10;
  private static final int DEFAULT_PROGRESS_PAINT_WIDTH = 10;
  private int mBackgroundColor;
  private Drawable mBackgroundPicture;
  private CartoomEngine mCartoomEngine;
  private CircleAttribute mCircleAttribute;
  private boolean mIsBackgroundFill;
  private boolean mIsMainCapRound = false;
  private int mMainCurProgress;
  private int mMaxProgress;
  private int mSubCurProgress;
  private int mSubProgressColor;
  private String mText;
  
  public CircleProgressImageView(Context paramContext)
  {
    super(paramContext);
    defaultParam();
  }
  
  public CircleProgressImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    defaultParam();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CircleProgressImageView);
    this.mMaxProgress = paramContext.getInteger(0, 100);
    boolean bool = paramContext.getBoolean(1, true);
    int i = (int)paramContext.getDimension(2, 10.0F);
    this.mCircleAttribute.setFill(bool);
    this.mSubProgressColor = paramContext.getInteger(7, 0);
    this.mCircleAttribute.mSubPaint.setColor(this.mSubProgressColor);
    this.mBackgroundColor = paramContext.getInteger(8, 0);
    if (this.mBackgroundColor != 0) {
      this.mCircleAttribute.setBackgroundColor(this.mBackgroundColor);
    }
    this.mIsBackgroundFill = paramContext.getBoolean(9, bool);
    if (this.mIsBackgroundFill) {
      this.mCircleAttribute.mBottomPaint.setStyle(Paint.Style.FILL);
    }
    for (;;)
    {
      if (!bool) {
        this.mCircleAttribute.setPaintWidth(i);
      }
      i = (int)paramContext.getDimension(6, 10.0F);
      this.mCircleAttribute.setProgressPaintWidth(i);
      i = paramContext.getColor(3, 0);
      this.mCircleAttribute.setPaintColor(i);
      this.mCircleAttribute.mSidePaintInterval = ((int)paramContext.getDimension(4, 0.0F));
      i = paramContext.getColor(5, -16777216);
      this.mCircleAttribute.setTextColor(i);
      this.mIsMainCapRound = paramContext.getBoolean(10, false);
      if (this.mIsMainCapRound) {
        this.mCircleAttribute.mMainPaints.setStrokeCap(Paint.Cap.ROUND);
      }
      paramContext.recycle();
      return;
      this.mCircleAttribute.mBottomPaint.setStyle(Paint.Style.STROKE);
    }
  }
  
  private void defaultParam()
  {
    this.mCircleAttribute = new CircleAttribute();
    this.mMaxProgress = 100;
    this.mMainCurProgress = 0;
    this.mSubCurProgress = 0;
    this.mText = "";
  }
  
  private int determineMaxTextSize(String paramString, float paramFloat)
  {
    int i = 0;
    int j;
    do
    {
      Paint localPaint = this.mCircleAttribute.mTextPaint;
      j = i + 1;
      localPaint.setTextSize(j);
      i = j;
    } while (this.mCircleAttribute.mTextPaint.measureText(paramString) < paramFloat);
    return j;
  }
  
  private void drawText(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(this.mText)) {
      return;
    }
    if (this.mCircleAttribute.mBeamHeight != 0) {
      this.mCircleAttribute.mBeamHeight = (getHeight() / 3);
    }
    Rect localRect = new Rect();
    this.mCircleAttribute.mTextPaint.getTextBounds(this.mText, 0, this.mText.length() - 1, localRect);
    int i = Math.abs(localRect.bottom - localRect.top);
    paramCanvas.drawText(this.mText, (int)(getWidth() * 0.5D), (int)((getHeight() + i + this.mCircleAttribute.mBeamHeight) * 0.5D), this.mCircleAttribute.mTextPaint);
  }
  
  public int getMainProgress()
  {
    try
    {
      int i = this.mMainCurProgress;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getSubProgress()
  {
    try
    {
      int i = this.mSubCurProgress;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f = this.mSubCurProgress / this.mMaxProgress;
    paramCanvas.drawArc(this.mCircleAttribute.mRoundOval, this.mCircleAttribute.mDrawPos, 360.0F * f, this.mCircleAttribute.mBRoundPaintsFill, this.mCircleAttribute.mSubPaint);
    f = this.mMainCurProgress / this.mMaxProgress;
    paramCanvas.drawArc(this.mCircleAttribute.mRoundOval, this.mCircleAttribute.mDrawPos, 360.0F * f, this.mCircleAttribute.mBRoundPaintsFill, this.mCircleAttribute.mMainPaints);
    drawText(paramCanvas);
    LogUtil.e("wangyang", "CircleProgressImageView onDraw ");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    this.mBackgroundPicture = getBackground();
    if (this.mBackgroundPicture != null)
    {
      j = this.mBackgroundPicture.getMinimumWidth();
      i = this.mBackgroundPicture.getMinimumHeight();
    }
    setMeasuredDimension(resolveSize(j, paramInt1), resolveSize(i, paramInt2));
    LogUtil.e("wangyang", "CircleProgressImageView onMeasure  mode =" + View.MeasureSpec.getMode(paramInt2) + " widthMeasureSpec=" + paramInt1 + " heightMeasureSpec=" + paramInt2 + " width=" + j + " height=" + i + "resolvewidthSize= " + resolveSize(j, paramInt1) + "resolveHeightSize= " + resolveSize(i, paramInt2));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mCircleAttribute.autoFix(paramInt1, paramInt2);
  }
  
  public void setBeamHeight(int paramInt)
  {
    this.mCircleAttribute.mBeamHeight = paramInt;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageDrawable(JarUtils.getResources().getDrawable(paramInt));
  }
  
  public void setMainProgress(int paramInt)
  {
    try
    {
      if (this.mMainCurProgress != paramInt)
      {
        this.mMainCurProgress = paramInt;
        if (this.mMainCurProgress < 0) {
          this.mMainCurProgress = 0;
        }
        if (this.mMainCurProgress > this.mMaxProgress) {
          this.mMainCurProgress = this.mMaxProgress;
        }
        invalidate();
      }
      return;
    }
    finally {}
  }
  
  public void setSubProgress(int paramInt)
  {
    try
    {
      if (this.mSubCurProgress != paramInt)
      {
        this.mSubCurProgress = paramInt;
        if (this.mSubCurProgress < 0) {
          this.mSubCurProgress = 0;
        }
        if (this.mSubCurProgress > this.mMaxProgress) {
          this.mSubCurProgress = this.mMaxProgress;
        }
        invalidate();
      }
      return;
    }
    finally {}
  }
  
  public void setText(String paramString)
  {
    if (paramString == null) {}
    while ((this.mText != null) && (this.mText.equals(paramString))) {
      return;
    }
    this.mText = paramString;
    invalidate();
  }
  
  public void startCartoom(int paramInt) {}
  
  public void stopCartoom() {}
  
  class CartoomEngine
  {
    private static final int TIMER_ID = 16;
    public boolean mBCartoom = false;
    public float mCurFloatProcess = 0.0F;
    public Handler mHandler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        }
        do
        {
          do
          {
            return;
          } while (!CircleProgressImageView.CartoomEngine.this.mBCartoom);
          paramAnonymousMessage = CircleProgressImageView.CartoomEngine.this;
          paramAnonymousMessage.mCurFloatProcess += 1.0F;
          CircleProgressImageView.this.setMainProgress((int)CircleProgressImageView.CartoomEngine.this.mCurFloatProcess);
          long l = System.currentTimeMillis();
          CircleProgressImageView.CartoomEngine.access$002(CircleProgressImageView.CartoomEngine.this, l);
        } while (CircleProgressImageView.CartoomEngine.this.mCurFloatProcess < CircleProgressImageView.this.mMaxProgress);
        CircleProgressImageView.CartoomEngine.this.stopCartoom();
      }
    };
    public int mSaveMax = 0;
    public Timer mTimer = new Timer(getClass().getSimpleName() + "_CartoomEngine");
    public int mTimerInterval = 50;
    public MyTimerTask mTimerTask;
    private long timeMil;
    
    public CartoomEngine() {}
    
    /* Error */
    public void startCartoom(int paramInt)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: iload_1
      //   3: ifle +13 -> 16
      //   6: aload_0
      //   7: getfield 45	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mBCartoom	Z
      //   10: istore_2
      //   11: iload_2
      //   12: iconst_1
      //   13: if_icmpne +6 -> 19
      //   16: aload_0
      //   17: monitorexit
      //   18: return
      //   19: aload_0
      //   20: lconst_0
      //   21: putfield 85	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:timeMil	J
      //   24: aload_0
      //   25: iconst_1
      //   26: putfield 45	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mBCartoom	Z
      //   29: aload_0
      //   30: getfield 35	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:this$0	Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView;
      //   33: iconst_0
      //   34: invokevirtual 90	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView:setMainProgress	(I)V
      //   37: aload_0
      //   38: getfield 35	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:this$0	Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView;
      //   41: iconst_0
      //   42: invokevirtual 93	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView:setSubProgress	(I)V
      //   45: aload_0
      //   46: aload_0
      //   47: getfield 35	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:this$0	Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView;
      //   50: invokestatic 97	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView:access$100	(Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView;)I
      //   53: putfield 76	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mSaveMax	I
      //   56: aload_0
      //   57: getfield 35	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:this$0	Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView;
      //   60: sipush 1000
      //   63: aload_0
      //   64: getfield 78	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mTimerInterval	I
      //   67: idiv
      //   68: iload_1
      //   69: imul
      //   70: invokestatic 101	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView:access$102	(Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView;I)I
      //   73: pop
      //   74: aload_0
      //   75: fconst_0
      //   76: putfield 80	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mCurFloatProcess	F
      //   79: aload_0
      //   80: new 11	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine$MyTimerTask
      //   83: dup
      //   84: aload_0
      //   85: invokespecial 104	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine$MyTimerTask:<init>	(Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine;)V
      //   88: putfield 106	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mTimerTask	Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine$MyTimerTask;
      //   91: aload_0
      //   92: getfield 74	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mTimer	Ljava/util/Timer;
      //   95: aload_0
      //   96: getfield 106	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mTimerTask	Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine$MyTimerTask;
      //   99: aload_0
      //   100: getfield 78	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mTimerInterval	I
      //   103: i2l
      //   104: aload_0
      //   105: getfield 78	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mTimerInterval	I
      //   108: i2l
      //   109: invokevirtual 110	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
      //   112: goto -96 -> 16
      //   115: astore_3
      //   116: aload_0
      //   117: monitorexit
      //   118: aload_3
      //   119: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	120	0	this	CartoomEngine
      //   0	120	1	paramInt	int
      //   10	4	2	bool	boolean
      //   115	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   6	11	115	finally
      //   19	112	115	finally
    }
    
    /* Error */
    public void stopCartoom()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 45	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mBCartoom	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifne +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: iconst_0
      //   16: putfield 45	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mBCartoom	Z
      //   19: aload_0
      //   20: getfield 35	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:this$0	Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView;
      //   23: aload_0
      //   24: getfield 76	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mSaveMax	I
      //   27: invokestatic 101	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView:access$102	(Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView;I)I
      //   30: pop
      //   31: aload_0
      //   32: getfield 35	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:this$0	Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView;
      //   35: iconst_0
      //   36: invokevirtual 90	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView:setMainProgress	(I)V
      //   39: aload_0
      //   40: getfield 35	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:this$0	Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView;
      //   43: iconst_0
      //   44: invokevirtual 93	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView:setSubProgress	(I)V
      //   47: aload_0
      //   48: getfield 106	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mTimerTask	Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine$MyTimerTask;
      //   51: ifnull -40 -> 11
      //   54: aload_0
      //   55: getfield 106	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mTimerTask	Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine$MyTimerTask;
      //   58: invokevirtual 115	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine$MyTimerTask:cancel	()Z
      //   61: pop
      //   62: aload_0
      //   63: aconst_null
      //   64: putfield 106	com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine:mTimerTask	Lcom/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView$CartoomEngine$MyTimerTask;
      //   67: goto -56 -> 11
      //   70: astore_2
      //   71: aload_0
      //   72: monitorexit
      //   73: aload_2
      //   74: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	75	0	this	CartoomEngine
      //   6	2	1	bool	boolean
      //   70	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	70	finally
      //   14	67	70	finally
    }
    
    class MyTimerTask
      extends TimerTask
    {
      MyTimerTask() {}
      
      public void run()
      {
        CircleProgressImageView.CartoomEngine.this.mHandler.obtainMessage(16).sendToTarget();
      }
    }
  }
  
  class CircleAttribute
  {
    public boolean mBRoundPaintsFill = true;
    public int mBeamHeight;
    public Paint mBottomPaint;
    public int mDrawPos = -90;
    public Paint mMainPaints = new Paint();
    public int mPaintColor = 0;
    public int mPaintWidth = 0;
    public int mProgressPaintWidth = 0;
    public RectF mRoundOval = new RectF();
    public int mSidePaintInterval = 0;
    public Paint mSubPaint;
    public Paint mTextPaint;
    public int mTextPaintColor;
    
    public CircleAttribute()
    {
      this.mMainPaints.setAntiAlias(true);
      this.mMainPaints.setStyle(Paint.Style.FILL);
      this.mMainPaints.setStrokeWidth(this.mPaintWidth);
      this.mMainPaints.setColor(this.mPaintColor);
      this.mSubPaint = new Paint();
      this.mSubPaint.setAntiAlias(true);
      this.mSubPaint.setStyle(Paint.Style.FILL);
      this.mSubPaint.setStrokeWidth(this.mPaintWidth);
      this.mSubPaint.setColor(this.mPaintColor);
      this.mBottomPaint = new Paint();
      this.mBottomPaint.setAntiAlias(true);
      this.mBottomPaint.setStyle(Paint.Style.FILL);
      this.mBottomPaint.setStrokeWidth(this.mPaintWidth);
      this.mBottomPaint.setColor(-7829368);
      this.mTextPaint = new Paint();
      this.mTextPaint.setAntiAlias(true);
      this.mTextPaint.setTextAlign(Paint.Align.CENTER);
      this.mTextPaint.setStyle(Paint.Style.FILL);
      this.mTextPaint.setStrokeWidth(this.mPaintWidth);
      this.mTextPaint.setColor(-16777216);
      this.mTextPaint.setTextSize(ScreenUtil.getInstance().dip2px(25));
    }
    
    public void autoFix(int paramInt1, int paramInt2)
    {
      int i = Math.max(this.mPaintWidth, this.mProgressPaintWidth);
      if (this.mSidePaintInterval != 0)
      {
        this.mRoundOval.set(i / 2 + this.mSidePaintInterval + ScreenUtil.getInstance().dip2px(1), i / 2 + this.mSidePaintInterval, paramInt1 - i / 2 - this.mSidePaintInterval - ScreenUtil.getInstance().dip2px(1), paramInt2 - i / 2 - this.mSidePaintInterval - ScreenUtil.getInstance().dip2px(2));
        LogUtil.e("wangyang", "autoFix " + (i / 2 + this.mSidePaintInterval + ScreenUtil.getInstance().dip2px(1)) + " ; " + (i / 2 + this.mSidePaintInterval) + "," + (paramInt1 - i / 2 - this.mSidePaintInterval - ScreenUtil.getInstance().dip2px(1)) + " ; " + (paramInt2 - i / 2 - this.mSidePaintInterval - ScreenUtil.getInstance().dip2px(2)));
        return;
      }
      int j = CircleProgressImageView.this.getPaddingLeft();
      int k = CircleProgressImageView.this.getPaddingRight();
      int m = CircleProgressImageView.this.getPaddingTop();
      int n = CircleProgressImageView.this.getPaddingBottom();
      this.mRoundOval.set(i / 2 + j, i / 2 + m, paramInt1 - k - i / 2, paramInt2 - n - i / 2);
      LogUtil.e("wangyang", "autoFix " + (i / 2 + j) + " ; " + (i / 2 + m) + "," + (paramInt1 - k - i / 2) + " ; " + (paramInt2 - n - i / 2));
    }
    
    public void setBackgroundColor(int paramInt)
    {
      this.mBottomPaint.setColor(paramInt);
    }
    
    public void setFill(boolean paramBoolean)
    {
      this.mBRoundPaintsFill = paramBoolean;
      if (paramBoolean)
      {
        this.mMainPaints.setStyle(Paint.Style.FILL);
        this.mSubPaint.setStyle(Paint.Style.FILL);
        this.mBottomPaint.setStyle(Paint.Style.FILL);
        return;
      }
      this.mMainPaints.setStyle(Paint.Style.STROKE);
      this.mSubPaint.setStyle(Paint.Style.STROKE);
      this.mBottomPaint.setStyle(Paint.Style.STROKE);
    }
    
    public void setPaintColor(int paramInt)
    {
      this.mMainPaints.setColor(paramInt);
      this.mSubPaint.setColor(0xFFFFFF & paramInt | 0x66000000);
    }
    
    public void setPaintWidth(int paramInt)
    {
      this.mMainPaints.setStrokeWidth(paramInt);
      this.mSubPaint.setStrokeWidth(paramInt);
      this.mBottomPaint.setStrokeWidth(paramInt);
    }
    
    public void setProgressPaintWidth(int paramInt)
    {
      this.mMainPaints.setStrokeWidth(paramInt);
      this.mProgressPaintWidth = paramInt;
    }
    
    public void setTextColor(int paramInt)
    {
      this.mTextPaintColor = paramInt;
      this.mTextPaint.setColor(this.mTextPaintColor);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/widget/CircleProgressImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */