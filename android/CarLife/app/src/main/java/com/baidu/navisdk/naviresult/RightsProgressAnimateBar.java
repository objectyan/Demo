package com.baidu.navisdk.naviresult;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class RightsProgressAnimateBar
  extends RelativeLayout
{
  private static final String TAG = RightsProgressAnimateBar.class.getSimpleName();
  private boolean animateFinish = false;
  private RelativeLayout currentProgressPointer;
  private boolean isLocal = false;
  private OnSizeChangedRelativeLayout kilosContainer;
  private View kilosPointerIc;
  private int kilosPointerIcWidth = 0;
  private TextView kilosTv;
  private int kilosTvCornerWidth = 0;
  private int kilosTvWidth = 0;
  private Handler mHandler = null;
  private BNNaviResultModel model = BNNaviResultModel.getInstance();
  private ProgressIncreasingBar newlyObtainedProgressBar;
  private int newlyObtainedWidth = 0;
  private View presentProgressBar;
  private int presentWidth = 0;
  private ImageView rightsLableIc;
  private boolean sizeChangeFinish = false;
  private int totalWidth = 0;
  
  public RightsProgressAnimateBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public RightsProgressAnimateBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void arrangeContent(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    setWidth(this.presentProgressBar, this.presentWidth);
    setWidth(this.newlyObtainedProgressBar, this.newlyObtainedWidth);
    this.newlyObtainedProgressBar.setListener(new ProgressIncreasingBar.OnAnimationStateListener()
    {
      public void onAnimationFinish(boolean paramAnonymousBoolean)
      {
        LogUtil.e(RightsProgressAnimateBar.TAG, "onAnimationFinish:  -->> ");
        RightsProgressAnimateBar.access$502(RightsProgressAnimateBar.this, true);
        RightsProgressAnimateBar.this.showKilosPointer(true);
      }
    });
    this.newlyObtainedProgressBar.setProgress(1.0D);
    this.newlyObtainedProgressBar.setRateBackgroundId(1711407328, true, this.newlyObtainedWidth, ScreenUtil.getInstance().dip2px(40));
    this.newlyObtainedProgressBar.setOrientation(0);
    this.newlyObtainedProgressBar.setAnim(paramBoolean);
    if (!paramBoolean)
    {
      this.animateFinish = true;
      showKilosPointer(true);
    }
  }
  
  private void delayShowKilosPointer()
  {
    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("delayShowKilosPointer-" + getClass().getSimpleName(), null)new BNWorkerConfig
    {
      protected String execute()
      {
        RightsProgressAnimateBar.this.showKilosPointer(true);
        return null;
      }
    }, new BNWorkerConfig(3, 0));
  }
  
  private int getSuitableLeftMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramInt1 -= (int)Math.ceil(paramInt2 / 2.0F);
    if (paramInt1 < 0) {
      return paramInt4;
    }
    if (paramInt1 + paramInt2 <= paramInt3 - paramInt5) {
      return paramInt1;
    }
    return paramInt3 - paramInt5 - paramInt2;
  }
  
  private void initVariables()
  {
    this.mHandler = new Handler();
    this.totalWidth = 0;
    this.presentWidth = 0;
    this.newlyObtainedWidth = 0;
    this.kilosTvWidth = 0;
    this.kilosPointerIcWidth = 0;
    this.kilosTvCornerWidth = 0;
    this.isLocal = false;
    this.sizeChangeFinish = false;
    this.animateFinish = false;
  }
  
  private void showKilosPointer(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        RelativeLayout localRelativeLayout = this.currentProgressPointer;
        if (localRelativeLayout == null) {
          return;
        }
        if (paramBoolean)
        {
          LogUtil.e(TAG, "showKilosPointer: -->> animateFinish: " + this.animateFinish + ", sizeChangeFinish: " + this.sizeChangeFinish);
          if ((!this.animateFinish) || (!this.sizeChangeFinish)) {
            continue;
          }
          int j = this.presentWidth + this.newlyObtainedWidth;
          int i = getSuitableLeftMargin(j, this.kilosPointerIcWidth, this.totalWidth, this.kilosTvCornerWidth, this.kilosTvCornerWidth);
          j = getSuitableLeftMargin(j, this.kilosTvWidth, this.totalWidth, 2, 2);
          setMargins(this.kilosContainer, j, 0, 2, 0);
          LogUtil.e(TAG, "showKilosPointer: -->> kilosContainer leftkilos: " + j);
          setMargins(this.kilosPointerIc, i, 0, this.kilosTvCornerWidth, 0);
          LogUtil.e(TAG, "showKilosPointer: -->> kilosPointerIc leftPointer: " + i);
          this.currentProgressPointer.setVisibility(0);
          LogUtil.e(TAG, "showKilosPointer: show -->> done");
          continue;
        }
        this.currentProgressPointer.setVisibility(4);
      }
      finally {}
      LogUtil.e(TAG, "showKilosPointer: hide -->> done");
    }
  }
  
  public void destroy()
  {
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    this.mHandler = null;
  }
  
  public void init()
  {
    if (this.kilosTv != null) {
      this.kilosTv.setText(this.model.getTotalDistanceStr());
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    initVariables();
    this.currentProgressPointer = ((RelativeLayout)findViewById(1711866270));
    this.kilosContainer = ((OnSizeChangedRelativeLayout)findViewById(1711866271));
    this.kilosTv = ((TextView)findViewById(1711866274));
    this.kilosPointerIc = findViewById(1711866276);
    this.rightsLableIc = ((ImageView)findViewById(1711866273));
    this.presentProgressBar = findViewById(1711866279);
    this.newlyObtainedProgressBar = ((ProgressIncreasingBar)findViewById(1711866280));
    this.totalWidth = ScreenUtil.getInstance().getWidthPixels();
    this.kilosPointerIcWidth = ScreenUtil.getInstance().dip2px(9);
    this.kilosTvCornerWidth = ScreenUtil.getInstance().dip2px(4);
    this.kilosContainer.setListener(new OnSizeChangedRelativeLayout.OnSizeChangedListener()
    {
      public void OnSizeChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        LogUtil.e(RightsProgressAnimateBar.TAG, "onSizeChanged: w -->> " + paramAnonymousInt1);
        if ((RightsProgressAnimateBar.this.kilosTvWidth == 0) && (paramAnonymousInt1 != 0))
        {
          RightsProgressAnimateBar.access$202(RightsProgressAnimateBar.this, true);
          RightsProgressAnimateBar.access$102(RightsProgressAnimateBar.this, paramAnonymousInt1);
          RightsProgressAnimateBar.this.delayShowKilosPointer();
        }
      }
    });
  }
  
  public void setMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    if ((paramView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      if (paramInt1 >= 0) {
        break label85;
      }
      paramInt1 = localMarginLayoutParams.leftMargin;
      if (paramInt2 >= 0) {
        break label88;
      }
      paramInt2 = localMarginLayoutParams.topMargin;
      label39:
      if (paramInt3 >= 0) {
        break label91;
      }
      paramInt3 = localMarginLayoutParams.rightMargin;
      label51:
      if (paramInt4 >= 0) {
        break label94;
      }
      paramInt4 = localMarginLayoutParams.bottomMargin;
    }
    label85:
    label88:
    label91:
    label94:
    for (;;)
    {
      localMarginLayoutParams.setMargins(paramInt1, paramInt2, paramInt3, paramInt4);
      paramView.setLayoutParams(localMarginLayoutParams);
      paramView.requestLayout();
      return;
      break;
      break label39;
      break label51;
    }
  }
  
  public void setWidth(View paramView, int paramInt)
  {
    if ((paramView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.width = paramInt;
      paramView.setLayoutParams(localLayoutParams);
      paramView.requestLayout();
    }
  }
  
  public void updateProgress(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.isLocal = paramBoolean2;
    LogUtil.e(TAG, "updateProgress: -->> isLocal: " + paramBoolean2 + ", initialPercent: " + paramInt1 + ", currentPercent: " + paramInt2);
    if (paramInt2 < paramInt1)
    {
      showKilosPointer(true);
      return;
    }
    showKilosPointer(false);
    this.presentWidth = ((int)(this.totalWidth * (paramInt1 / 100.0F)));
    this.newlyObtainedWidth = ((int)(this.totalWidth * ((paramInt2 - paramInt1) / 100.0F)));
    if (paramInt1 == paramInt2) {
      paramBoolean1 = false;
    }
    arrangeContent(paramInt1, paramInt2, paramBoolean1);
  }
  
  public void updateRightsLabelIc()
  {
    if ((this.rightsLableIc != null) && (BusinessActivityManager.getInstance().getModel().userRightIconBitmapEnd != null))
    {
      Drawable localDrawable = BNNaviResultController.getInstance().getDrawableFromBitmap(BusinessActivityManager.getInstance().getModel().userRightIconBitmapEnd);
      if (localDrawable != null) {
        this.rightsLableIc.setImageDrawable(localDrawable);
      }
      return;
    }
    LogUtil.e(TAG, "updateRightsLabelIc: bitmap -->> " + BusinessActivityManager.getInstance().getModel().userRightIconBitmapEnd);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/naviresult/RightsProgressAnimateBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */