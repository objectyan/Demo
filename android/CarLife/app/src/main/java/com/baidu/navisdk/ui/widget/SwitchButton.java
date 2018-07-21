package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.baidu.navisdk.ui.routeguide.subview.widget.FrameAnimationController;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class SwitchButton
  extends CheckBox
{
  private static final float EXTENDED_OFFSET_Y = 15.0F;
  private static final int MAX_ALPHA = 255;
  private static final float VELOCITY = 350.0F;
  private int mAlpha = 255;
  private float mAnimatedVelocity;
  private boolean mAnimating;
  private float mAnimationPosition;
  private Bitmap mBottom;
  private boolean mBroadcasting;
  private Bitmap mBtnNormal;
  private float mBtnOffPos;
  private float mBtnOnPos;
  private float mBtnPos;
  private Bitmap mBtnPressed;
  private float mBtnWidth;
  private boolean mChecked = false;
  private int mClickTimeout;
  private Context mContext;
  private Bitmap mCurBtnPic;
  private boolean mDayStyle = true;
  private float mExtendOffsetY;
  private float mFirstDownX;
  private float mFirstDownY;
  private Bitmap mFrame;
  private Bitmap mMask;
  private float mMaskHeight;
  private float mMaskWidth;
  private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
  private CompoundButton.OnCheckedChangeListener mOnCheckedChangeWidgetListener;
  private Paint mPaint;
  private ViewParent mParent;
  private float mRealPos;
  private RectF mSaveLayerRectF;
  private int mTouchSlop;
  private float mVelocity;
  private PorterDuffXfermode mXfermode;
  
  public SwitchButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842860);
  }
  
  public SwitchButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void attemptClaimDrag()
  {
    this.mParent = getParent();
    if (this.mParent != null) {
      this.mParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private void doAnimation()
  {
    this.mAnimationPosition += this.mAnimatedVelocity * 16.0F / 1000.0F;
    if (this.mAnimationPosition <= this.mBtnOnPos - 8.0F)
    {
      stopAnimation();
      this.mAnimationPosition = (this.mBtnOnPos - 8.0F);
      setCheckedDelayed(true);
    }
    for (;;)
    {
      moveView(this.mAnimationPosition);
      return;
      if (this.mAnimationPosition >= this.mBtnOffPos + 8.0F)
      {
        stopAnimation();
        this.mAnimationPosition = (this.mBtnOffPos + 8.0F);
        setCheckedDelayed(false);
      }
    }
  }
  
  private float getRealPos(float paramFloat)
  {
    return paramFloat - this.mBtnWidth / 2.0F;
  }
  
  private void initView(Context paramContext)
  {
    this.mContext = paramContext;
    this.mPaint = new Paint();
    this.mPaint.setColor(-1);
    Resources localResources = JarUtils.getResources();
    this.mClickTimeout = (ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout());
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    if (this.mDayStyle)
    {
      this.mBottom = BitmapFactory.decodeResource(localResources, 1711407804);
      if (this.mChecked)
      {
        this.mBtnPressed = BitmapFactory.decodeResource(localResources, 1711407572);
        this.mBtnNormal = BitmapFactory.decodeResource(localResources, 1711407570);
        this.mFrame = BitmapFactory.decodeResource(localResources, 1711407806);
        this.mMask = BitmapFactory.decodeResource(localResources, 1711407808);
        this.mCurBtnPic = this.mBtnNormal;
        this.mBtnWidth = this.mBtnPressed.getWidth();
        this.mMaskWidth = this.mMask.getWidth();
        this.mMaskHeight = this.mMask.getHeight();
        this.mBtnOffPos = (this.mBtnWidth / 2.0F);
        this.mBtnOnPos = (this.mMaskWidth - this.mBtnWidth / 2.0F);
        if (!this.mChecked) {
          break label397;
        }
      }
    }
    label397:
    for (float f = this.mBtnOnPos;; f = this.mBtnOffPos)
    {
      this.mBtnPos = f;
      this.mRealPos = getRealPos(this.mBtnPos);
      this.mVelocity = ScreenUtil.getInstance().dip2px(350.0F);
      this.mExtendOffsetY = ScreenUtil.getInstance().dip2px(15.0F);
      this.mSaveLayerRectF = new RectF(0.0F, this.mExtendOffsetY, this.mMask.getWidth(), this.mMask.getHeight() + this.mExtendOffsetY);
      this.mXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
      return;
      this.mBtnPressed = BitmapFactory.decodeResource(localResources, 1711407576);
      this.mBtnNormal = BitmapFactory.decodeResource(localResources, 1711407574);
      break;
      this.mBottom = BitmapFactory.decodeResource(localResources, 1711407805);
      if (this.mChecked) {
        this.mBtnPressed = BitmapFactory.decodeResource(localResources, 1711407573);
      }
      for (this.mBtnNormal = BitmapFactory.decodeResource(localResources, 1711407571);; this.mBtnNormal = BitmapFactory.decodeResource(localResources, 1711407575))
      {
        this.mFrame = BitmapFactory.decodeResource(localResources, 1711407807);
        this.mMask = BitmapFactory.decodeResource(localResources, 1711407809);
        break;
        this.mBtnPressed = BitmapFactory.decodeResource(localResources, 1711407577);
      }
    }
  }
  
  private void moveView(float paramFloat)
  {
    this.mBtnPos = paramFloat;
    this.mRealPos = getRealPos(this.mBtnPos);
    invalidate();
  }
  
  private void setCheckedDelayed(final boolean paramBoolean)
  {
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask("setCheckedDelayed-" + getClass().getSimpleName(), null)new BNWorkerConfig
    {
      protected String execute()
      {
        SwitchButton.this.setInternalChecked(paramBoolean);
        return null;
      }
    }, new BNWorkerConfig(100, 0), 10L);
  }
  
  private void setInternalChecked(boolean paramBoolean)
  {
    this.mChecked = paramBoolean;
    if (paramBoolean) {}
    for (float f = this.mBtnOnPos;; f = this.mBtnOffPos)
    {
      this.mBtnPos = f;
      this.mRealPos = getRealPos(this.mBtnPos);
      invalidate();
      if (!this.mBroadcasting) {
        break;
      }
      return;
    }
    this.mBroadcasting = true;
    Object localObject = JarUtils.getResources();
    if (this.mDayStyle) {
      if (this.mChecked)
      {
        this.mBtnPressed = BitmapFactory.decodeResource((Resources)localObject, 1711407572);
        this.mBtnNormal = BitmapFactory.decodeResource((Resources)localObject, 1711407570);
        this.mCurBtnPic = this.mBtnNormal;
        invalidate();
        if (this.mOnCheckedChangeListener != null)
        {
          localObject = this.mOnCheckedChangeListener;
          if (this.mChecked) {
            break label263;
          }
        }
      }
    }
    label263:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((CompoundButton.OnCheckedChangeListener)localObject).onCheckedChanged(this, paramBoolean);
      if (this.mOnCheckedChangeWidgetListener != null) {
        this.mOnCheckedChangeWidgetListener.onCheckedChanged(this, this.mChecked);
      }
      this.mBroadcasting = false;
      return;
      this.mBtnPressed = BitmapFactory.decodeResource((Resources)localObject, 1711407576);
      this.mBtnNormal = BitmapFactory.decodeResource((Resources)localObject, 1711407574);
      this.mCurBtnPic = this.mBtnNormal;
      break;
      if (this.mChecked)
      {
        this.mBtnPressed = BitmapFactory.decodeResource((Resources)localObject, 1711407573);
        this.mBtnNormal = BitmapFactory.decodeResource((Resources)localObject, 1711407571);
        this.mCurBtnPic = this.mBtnNormal;
        break;
      }
      this.mBtnPressed = BitmapFactory.decodeResource((Resources)localObject, 1711407577);
      this.mBtnNormal = BitmapFactory.decodeResource((Resources)localObject, 1711407575);
      this.mCurBtnPic = this.mBtnNormal;
      break;
    }
  }
  
  private void startAnimation(boolean paramBoolean)
  {
    this.mAnimating = true;
    if (paramBoolean) {}
    for (float f = -this.mVelocity;; f = this.mVelocity)
    {
      this.mAnimatedVelocity = f;
      this.mAnimationPosition = this.mBtnPos;
      new SwitchAnimation(null).run();
      return;
    }
  }
  
  private void stopAnimation()
  {
    this.mAnimating = false;
  }
  
  public boolean isChecked()
  {
    return this.mChecked;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayerAlpha(this.mSaveLayerRectF, this.mAlpha, 31);
    paramCanvas.drawBitmap(this.mMask, 0.0F, this.mExtendOffsetY, this.mPaint);
    this.mPaint.setXfermode(this.mXfermode);
    if (this.mChecked)
    {
      paramCanvas.drawBitmap(this.mBottom, this.mRealPos - 4.0F, this.mExtendOffsetY, this.mPaint);
      this.mPaint.setXfermode(null);
      paramCanvas.drawBitmap(this.mFrame, 0.0F, this.mExtendOffsetY, this.mPaint);
      if (!this.mChecked) {
        break label164;
      }
      paramCanvas.drawBitmap(this.mCurBtnPic, this.mRealPos - 4.0F, this.mExtendOffsetY, this.mPaint);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      paramCanvas.drawBitmap(this.mBottom, this.mRealPos + 4.0F, this.mExtendOffsetY, this.mPaint);
      break;
      label164:
      paramCanvas.drawBitmap(this.mCurBtnPic, this.mRealPos + 4.0F, this.mExtendOffsetY, this.mPaint);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension((int)this.mMaskWidth, (int)(this.mMaskHeight + 2.0F * this.mExtendOffsetY));
  }
  
  public boolean performClick()
  {
    if (!this.mChecked) {}
    for (boolean bool = true;; bool = false)
    {
      startAnimation(bool);
      return true;
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setInternalChecked(paramBoolean);
      return;
    }
  }
  
  public void setDayStyle(boolean paramBoolean)
  {
    this.mDayStyle = paramBoolean;
    try
    {
      initView(this.mContext);
      invalidate();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 255;; i = 127)
    {
      this.mAlpha = i;
      super.setEnabled(paramBoolean);
      return;
    }
  }
  
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.mOnCheckedChangeListener = paramOnCheckedChangeListener;
  }
  
  void setOnCheckedChangeWidgetListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.mOnCheckedChangeWidgetListener = paramOnCheckedChangeListener;
  }
  
  public void toggle()
  {
    if (!this.mChecked) {}
    for (boolean bool = true;; bool = false)
    {
      setInternalChecked(bool);
      return;
    }
  }
  
  private final class PerformClick
    implements Runnable
  {
    private PerformClick() {}
    
    public void run()
    {
      SwitchButton.this.performClick();
    }
  }
  
  private final class SwitchAnimation
    implements Runnable
  {
    private SwitchAnimation() {}
    
    public void run()
    {
      if (!SwitchButton.this.mAnimating) {
        return;
      }
      SwitchButton.this.doAnimation();
      FrameAnimationController.requestAnimationFrame(this);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/SwitchButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */