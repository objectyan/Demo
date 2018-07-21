package com.baidu.nplatform.comapi.map;

import com.baidu.nplatform.comapi.MapItem;

public abstract interface MapViewListener
{
  public abstract void onClickedBackground(int paramInt1, int paramInt2);
  
  public abstract void onClickedBaseLayer();
  
  public abstract void onClickedBasePOILayer(MapItem paramMapItem);
  
  public abstract void onClickedCompassLayer();
  
  public abstract void onClickedCustomLayer(MapItem paramMapItem, int paramInt1, int paramInt2);
  
  public abstract void onClickedEndLayer(MapItem paramMapItem, int paramInt1, int paramInt2);
  
  public abstract void onClickedFavPoiLayer(MapItem paramMapItem);
  
  public abstract void onClickedPOIBkgLayer(MapItem paramMapItem);
  
  public abstract void onClickedPOILayer(MapItem paramMapItem);
  
  public abstract void onClickedPopupLayer();
  
  public abstract void onClickedRoute(MapItem paramMapItem);
  
  public abstract void onClickedRouteSpecLayer(MapItem paramMapItem);
  
  public abstract void onClickedRouteUgcItem(MapItem paramMapItem);
  
  public abstract void onClickedStartLayer(MapItem paramMapItem, int paramInt1, int paramInt2);
  
  public abstract void onClickedStreetIndoorPoi(MapObj paramMapObj);
  
  public abstract void onClickedStreetPopup(String paramString);
  
  public abstract void onClickedThroughNodeLayer(MapItem paramMapItem, int paramInt1, int paramInt2);
  
  public abstract void onClickedUgcItem(MapItem paramMapItem);
  
  public abstract void onDoubleFingerRotate();
  
  public abstract void onDoubleFingerZoom();
  
  public abstract void onMapAnimationFinish();
  
  public abstract void onMapNetworkingChanged(boolean paramBoolean);
  
  public abstract void onMapObviousMove();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/MapViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */