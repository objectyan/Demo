package com.baidu.baidunavis.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.carlife.core.screen.presentation.h;
import java.util.HashMap;

public class NavFragmentManager
{
  private static final String TAG = "Framework";
  public static final int TYPE_CRUISE = 3;
  public static final int TYPE_LIGHT_NAVI = 2;
  public static final int TYPE_NAVI_RESULT = 4;
  public static final int TYPE_NONE = 0;
  public static final int TYPE_ROUTE_GUIDE = 1;
  public static final int TYPE_ROUTE_REPORT = 6;
  public static final int TYPE_SELECT_POINT = 5;
  private int mLastPageType = 0;
  private HashMap<String, Integer> mPageNameTypeMap = null;
  
  public static NavFragmentManager getInstance()
  {
    return LazyLoader.sInstance;
  }
  
  private CarNaviMapPage getPageInstance(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    default: 
      return null;
    case 1: 
      return new BNRouteGuideFragment();
    }
    return new BNCruiserFragment();
  }
  
  private boolean isPageUsesNaviMapMode(String paramString)
  {
    return true;
  }
  
  private boolean justRemovePageWhenBack(String paramString)
  {
    return getPageInstance(getCarNaviPageType(paramString)) != null;
  }
  
  private void logHistoryRecord() {}
  
  public void back(Bundle paramBundle, boolean paramBoolean)
  {
    NavLogUtils.e("Framework", "back: forceResetMode --> " + paramBoolean);
    if ((paramBoolean) || (!lastPageUsesNaviMapMode()))
    {
      NavMapManager.getInstance().removeNaviMapListener();
      NavMapManager.getInstance().handleMapThemeAndScene(0);
    }
  }
  
  public void backToPage(String paramString, Bundle paramBundle)
  {
    if (paramString == null) {
      return;
    }
    NavLogUtils.e("Framework", "backToPage: --> " + paramString);
  }
  
  public void destroy()
  {
    NavLogUtils.e("Framework", "destroy: --> ");
    NavMapManager.getInstance().unInit();
  }
  
  public void finishCarNaviPages(Bundle paramBundle)
  {
    NavLogUtils.e("Framework", "finishCarNaviPages: --> ");
    h.a().backTo(17, null);
  }
  
  public int getCarNaviPageType(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 0;
      if (this.mPageNameTypeMap == null)
      {
        this.mPageNameTypeMap = new HashMap();
        this.mPageNameTypeMap.put(BNRouteGuideFragment.class.getName(), Integer.valueOf(1));
        this.mPageNameTypeMap.put(BNCruiserFragment.class.getName(), Integer.valueOf(3));
      }
      paramString = (Integer)this.mPageNameTypeMap.get(paramString);
    } while (paramString == null);
    return paramString.intValue();
  }
  
  public int getLastPageType()
  {
    return this.mLastPageType;
  }
  
  public boolean lastPageUsesNaviMapMode()
  {
    NavLogUtils.e("Framework", "lastPageUsesNaviMapMode: --> " + false);
    return false;
  }
  
  public void removeNaviPage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    NavLogUtils.e("Framework", "removeNaviPage: --> " + paramString);
  }
  
  public void setLastPageType(int paramInt)
  {
    this.mLastPageType = paramInt;
  }
  
  public void showNavMapMapPage(String paramString, Bundle paramBundle)
  {
    NavLogUtils.e("Framework", "showNavMapMapPage: mapPageClsName --> " + paramString);
    Activity localActivity = NavCommonFuncModel.getInstance().getActivity();
    if ((paramString != null) && (localActivity != null)) {
      NavMapAdapter.getInstance().navigateTo(localActivity, paramString, paramBundle);
    }
  }
  
  private static class LazyLoader
  {
    private static final NavFragmentManager sInstance = new NavFragmentManager(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/ui/NavFragmentManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */