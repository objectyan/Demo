package com.baidu.carlife;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.ItsMapObj;
import com.baidu.platform.comapi.map.MapObj;
import com.baidu.platform.comapi.map.MapViewListener;
import java.util.List;

public abstract class a
  implements MapViewListener
{
  public static final String a = a.class.getSimpleName();
  
  protected abstract void a(MapObj paramMapObj);
  
  protected abstract void b(MapObj paramMapObj);
  
  protected abstract void c(MapObj paramMapObj);
  
  protected abstract void d(MapObj paramMapObj);
  
  public void onClickStreetArrow(MapObj paramMapObj) {}
  
  public void onClickStreetSurface(MapObj paramMapObj) {}
  
  public void onClickedBackground(int paramInt1, int paramInt2) {}
  
  public void onClickedItem(int paramInt1, int paramInt2, GeoPoint paramGeoPoint, int paramInt3) {}
  
  public void onClickedItem(int paramInt1, GeoPoint paramGeoPoint, int paramInt2) {}
  
  public void onClickedItsMapObj(List<ItsMapObj> paramList) {}
  
  public void onClickedMapObj(List<MapObj> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      paramList = (MapObj)paramList.get(0);
    } while ((paramList.nType == 17) && (TextUtils.isEmpty(paramList.strText)));
    switch (paramList.nType)
    {
    }
    d(paramList);
  }
  
  public void onClickedOPPoiEventMapObj(MapObj paramMapObj) {}
  
  public void onClickedParticleEventMapObj(List<MapObj> paramList) {}
  
  public void onClickedPoiObj(List<MapObj> paramList) {}
  
  public void onClickedPopup(int paramInt) {}
  
  public void onClickedRouteLabelObj(List<MapObj> paramList) {}
  
  public void onClickedRouteObj(List<MapObj> paramList) {}
  
  public void onClickedStreetIndoorPoi(MapObj paramMapObj) {}
  
  public void onClickedStreetPopup(String paramString) {}
  
  public void onClickedTrafficUgcEventMapObj(MapObj paramMapObj, boolean paramBoolean) {}
  
  public void onMapAnimationFinish()
  {
    Log.d(a, "onMapAnimationFinish");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */