package com.baidu.navi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapGLSurfaceView;

public class MapFragment
  extends BaseFragment
{
  private static final String TAG = "Map";
  private boolean isFirstLoad = true;
  private boolean isForeground = true;
  
  private void updateMapTheme(boolean paramBoolean)
  {
    if (NavMapManager.getInstance().getNaviMapMode() != 0) {
      return;
    }
    MapController localMapController = MapViewFactory.getInstance().getMapView().getController();
    int j = 10;
    if (BNSettingManager.isRoadCondOnOrOff())
    {
      i = 5;
      if (!paramBoolean)
      {
        if (!NavMapManager.getInstance().isChangedMapMode()) {
          break label84;
        }
        j = 11;
        if (!BNSettingManager.isRoadCondOnOrOff()) {
          break label78;
        }
      }
    }
    label78:
    for (int i = 13;; i = 9)
    {
      localMapController.setMapThemeScene(j, i, new Bundle());
      return;
      i = 0;
      break;
    }
    label84:
    j = 12;
    if (BNSettingManager.isRoadCondOnOrOff()) {}
    for (i = 5;; i = 0) {
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = (ViewGroup)paramLayoutInflater.inflate(2130968777, null);
    MapViewFactory.getInstance().relayoutMapView(paramLayoutInflater, 0);
    this.mViewCreated = true;
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    this.mViewCreated = false;
    super.onDestroyView();
  }
  
  public void onPause()
  {
    MapGLSurfaceView localMapGLSurfaceView = MapViewFactory.getInstance().getMapView();
    if (localMapGLSurfaceView != null)
    {
      localMapGLSurfaceView.onPause();
      localMapGLSurfaceView.onBackground();
      this.isForeground = false;
    }
    super.onPause();
  }
  
  public void onResume()
  {
    this.isForeground = true;
    MapGLSurfaceView localMapGLSurfaceView = MapViewFactory.getInstance().getMapView();
    if (localMapGLSurfaceView != null)
    {
      localMapGLSurfaceView.onResume();
      localMapGLSurfaceView.onForeground();
      if (this.isFirstLoad)
      {
        this.isFirstLoad = false;
        updateMapTheme(StyleManager.getRealDayStyle());
      }
    }
    super.onResume();
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean)
  {
    updateMapTheme(paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/MapFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */