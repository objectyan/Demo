package com.baidu.baidunavis.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.drivertool.BNAttachmentManager;
import com.baidu.navisdk.util.drivertool.BNTakePhotoManager;

public abstract class CarNaviMapPage
  extends ContentFragment
{
  private static final String TAG = "Framework";
  
  private String getClassName()
  {
    try
    {
      String str = getClass().getName();
      str = str.substring(str.lastIndexOf(".") + 1);
      return str;
    }
    catch (Throwable localThrowable) {}
    return "Crash";
  }
  
  public boolean forbidsConfigurationChange()
  {
    return true;
  }
  
  public boolean forceResetModeWhenBack()
  {
    return false;
  }
  
  public abstract String getPageClsName();
  
  public abstract int getPageType();
  
  public void goBack()
  {
    NavLogUtils.e("Framework", getPageClsName() + ": --> goBack");
    NavFragmentManager.getInstance().back(null, forceResetModeWhenBack());
    back();
  }
  
  public boolean is3DGestureEnable()
  {
    return false;
  }
  
  public boolean isMapPage()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    NavLogUtils.e("Framework", getPageClsName() + ": resultCode --> " + paramInt2);
    BNavigator.getInstance().onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 256) && (paramInt2 == -1))
    {
      paramIntent = (Bitmap)paramIntent.getExtras().get("data");
      BNTakePhotoManager.getInstance().onPhotoTakeActionFinish(paramIntent, new Object());
    }
    while ((paramInt1 != 257) || (paramInt2 != -1)) {
      return;
    }
    BNAttachmentManager.getInstance().onSelectPictureFinish(paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    NavLogUtils.e("Framework", getPageClsName() + ": --> onAttach");
  }
  
  public boolean onBackPressed()
  {
    NavLogUtils.e("Framework", getPageClsName() + ": --> onBackPressed");
    goBack();
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((!BaiduNaviManager.isNaviSoLoadSuccess()) || (!BaiduNaviManager.sIsBaseEngineInitialized)) {
      super.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.baidu.navi.fragment.BaseFragment.mResumeMapView = true;
    if ((!BaiduNaviManager.isNaviSoLoadSuccess()) || (!BaiduNaviManager.sIsBaseEngineInitialized)) {
      back();
    }
    long l;
    do
    {
      do
      {
        return;
        NavLogUtils.e("Framework", getPageClsName() + ": --> onCreate");
      } while (!BNRouteGuideFragment.isStopedByWatch);
      l = BNRouteGuideFragment.sWatchEixtTime;
    } while (SystemClock.elapsedRealtime() - l > 1500L);
    goBack();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    return null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    NavLogUtils.e("Framework", getPageClsName() + ": --> onCreateView");
    NavFragmentManager.getInstance().setLastPageType(getPageType());
    NavMapManager.getInstance().addNaviMapListener();
    NavMapManager.getInstance().handleMapThemeAndScene(getPageType());
    NavMapManager.getInstance().set3DGestureEnable(is3DGestureEnable());
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    NavLogUtils.e("Framework", getPageClsName() + ": --> onDestroy");
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    NavLogUtils.e("Framework", getPageClsName() + ": --> onDestroyView");
    NavMapManager.getInstance().removeNaviMapListener();
    NavMapManager.getInstance().handleMapThemeAndScene(0);
    NavMapManager.getInstance().set3DGestureEnable(GlobalConfig.getInstance().isOpen3D());
    NavLogUtils.e("Framework", getPageClsName() + ": --> onDestroyView end");
  }
  
  public void onDetach()
  {
    super.onDetach();
    NavLogUtils.e("Framework", getPageClsName() + ": --> onDetach");
  }
  
  protected void onInitView() {}
  
  public void onPause()
  {
    super.onPause();
    NavLogUtils.e("Framework", getPageClsName() + ": --> onPause");
  }
  
  public void onResume()
  {
    super.onResume();
    NavLogUtils.e("Framework", getPageClsName() + ": --> onResume");
  }
  
  public void onStart()
  {
    super.onStart();
    NavLogUtils.e("Framework", getPageClsName() + ": --> onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    NavLogUtils.e("Framework", getPageClsName() + ": --> onStop");
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    NavLogUtils.e("Framework", getPageClsName() + ": --> onViewCreated");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/ui/CarNaviMapPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */