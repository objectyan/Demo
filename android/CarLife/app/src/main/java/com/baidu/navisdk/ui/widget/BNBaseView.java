package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public abstract class BNBaseView
{
  private BNWorkerNormalTask<String, String> mAutoHideRunnable = new BNWorkerNormalTask("BNBaseView-autoHideTask", null)
  {
    protected String execute()
    {
      BNBaseView.this.hiedByTimeOut();
      return null;
    }
  };
  protected Context mContext;
  protected int mCurOrientation = 2;
  protected boolean mIsCurDay = true;
  protected ViewGroup mRootViewGroup;
  protected OnRGSubViewListener mSubViewListener;
  private boolean mVisibility = false;
  
  public BNBaseView(Context paramContext, ViewGroup paramViewGroup)
  {
    this.mContext = paramContext;
    this.mRootViewGroup = paramViewGroup;
    this.mSubViewListener = null;
  }
  
  public BNBaseView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    this.mContext = paramContext;
    this.mRootViewGroup = paramViewGroup;
    this.mSubViewListener = paramOnRGSubViewListener;
  }
  
  protected void cancelAutoHide()
  {
    BNWorkerCenter.getInstance().cancelTask(this.mAutoHideRunnable, false);
  }
  
  public void dispose()
  {
    this.mSubViewListener = null;
    this.mContext = null;
  }
  
  protected int getColor(int paramInt)
  {
    return BNStyleManager.getColor(paramInt, this.mIsCurDay);
  }
  
  protected Drawable getDrawable(int paramInt)
  {
    return BNStyleManager.getDrawable(paramInt, this.mIsCurDay);
  }
  
  public void hide()
  {
    this.mVisibility = false;
  }
  
  protected void hiedByTimeOut() {}
  
  public boolean isVisibility()
  {
    return this.mVisibility;
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    this.mRootViewGroup = paramViewGroup;
    this.mCurOrientation = paramInt;
  }
  
  public void show()
  {
    show(null);
  }
  
  public void show(Bundle paramBundle)
  {
    this.mVisibility = true;
  }
  
  protected void startAutoHide(int paramInt)
  {
    BNWorkerCenter.getInstance().cancelTask(this.mAutoHideRunnable, false);
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mAutoHideRunnable, new BNWorkerConfig(2, 0), paramInt);
  }
  
  public void updateData(Bundle paramBundle) {}
  
  public void updateStyle(boolean paramBoolean)
  {
    this.mIsCurDay = paramBoolean;
  }
  
  public void updateSubListener(OnRGSubViewListener paramOnRGSubViewListener)
  {
    this.mSubViewListener = paramOnRGSubViewListener;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNBaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */