package com.baidu.navisdk.module.ugc.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class UgcMapsViewConstructor
{
  private static ViewGroup btnContainer;
  private static boolean hasCloudData = false;
  private static CallBackListener mCallBack;
  private static View.OnClickListener mOnBtnClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (UgcMapsViewConstructor.mCallBack != null) {
        UgcMapsViewConstructor.mCallBack.onBtnClick(1);
      }
      UserOPController.getInstance().add("3.u", "1", null, null);
    }
  };
  
  private static void constructUgcReportBtn(final Context paramContext, ViewGroup paramViewGroup)
  {
    if ((paramContext == null) || (paramViewGroup == null)) {
      return;
    }
    paramViewGroup.setOnClickListener(mOnBtnClickListener);
    paramContext = new ImageView(paramContext);
    paramContext.setScaleType(ImageView.ScaleType.FIT_XY);
    paramContext.setPadding(6, 6, 6, 6);
    new UgcImageLoaderUtils().updateUgcViewOnLine(4096, paramContext, new BNImageLoadingListener()
    {
      public void onLoadingComplete(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, int paramAnonymousInt)
      {
        this.val$mContainer.removeAllViews();
        this.val$mContainer.addView(paramContext, new ViewGroup.LayoutParams(-1, -1));
        this.val$mContainer.setVisibility(0);
        if (UgcMapsViewConstructor.mCallBack != null) {
          UgcMapsViewConstructor.mCallBack.onBtnClick(8);
        }
      }
      
      public void onLoadingFailed(String paramAnonymousString1, View paramAnonymousView, String paramAnonymousString2)
      {
        this.val$mContainer.removeAllViews();
        this.val$mContainer.addView(paramContext, new ViewGroup.LayoutParams(-1, -1));
        this.val$mContainer.setVisibility(0);
        if (UgcMapsViewConstructor.mCallBack != null) {
          UgcMapsViewConstructor.mCallBack.onBtnClick(8);
        }
      }
      
      public void onLoadingStarted(String paramAnonymousString, View paramAnonymousView) {}
    });
  }
  
  public static void getUgcReportBtn(ViewGroup paramViewGroup, CallBackListener paramCallBackListener)
  {
    if ((paramViewGroup == null) || (paramCallBackListener == null)) {
      return;
    }
    mCallBack = paramCallBackListener;
    if (hasCloudData)
    {
      constructUgcReportBtn(BNaviModuleManager.getContext(), paramViewGroup);
      return;
    }
    btnContainer = paramViewGroup;
  }
  
  public static View getUgcResYellowTipsView(Activity paramActivity, YellowTipsCallback paramYellowTipsCallback)
  {
    View localView1 = null;
    if (paramActivity == null) {
      paramActivity = localView1;
    }
    View localView2;
    do
    {
      do
      {
        return paramActivity;
        localView1 = JarUtils.inflate(paramActivity, 1711472650, null);
        paramActivity = localView1;
      } while (localView1 == null);
      localView2 = localView1.findViewById(1711865877);
      paramActivity = localView1;
    } while (localView2 == null);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (this.val$mYellowTipsCallback != null) {
          this.val$mYellowTipsCallback.close();
        }
      }
    });
    return localView1;
  }
  
  public static void requestPhotoCaptureAuth()
  {
    if (mCallBack != null) {
      mCallBack.onBtnClick(3);
    }
  }
  
  public static void requestSoundsAuth()
  {
    if (mCallBack != null) {
      mCallBack.onBtnClick(4);
    }
  }
  
  public static void updateUgcReportBtn()
  {
    hasCloudData = true;
    if (btnContainer == null) {
      return;
    }
    constructUgcReportBtn(BNaviModuleManager.getContext(), btnContainer);
  }
  
  public static abstract interface CallBackListener
  {
    public abstract void onBtnClick(int paramInt);
  }
  
  public static abstract interface YellowTipsCallback
  {
    public abstract void close();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/utils/UgcMapsViewConstructor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */