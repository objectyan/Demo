package com.baidu.nplatform.comapi.map;

import android.graphics.drawable.Drawable;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class ItemizedOverlayUtil
{
  private MapWrapper mMapWrapper;
  
  public static ItemizedOverlayUtil getInstance()
  {
    return Holder.OVERLAY;
  }
  
  public void addMapItem(OverlayItem paramOverlayItem)
  {
    if (getMapWrapper() != null) {
      getMapWrapper().addMapItem(paramOverlayItem);
    }
  }
  
  public MapWrapper getMapWrapper()
  {
    return this.mMapWrapper;
  }
  
  public OnTapListener getOnTapListener()
  {
    if (getMapWrapper() != null) {
      return getMapWrapper().getOnTapListener();
    }
    return null;
  }
  
  public OverlayItem getOverlayItem(GeoPoint paramGeoPoint, Drawable paramDrawable)
  {
    paramGeoPoint = new OverlayItem(paramGeoPoint, "mItem", "");
    paramGeoPoint.setMarker(paramDrawable);
    return paramGeoPoint;
  }
  
  public void hide()
  {
    if (getMapWrapper() != null) {
      getMapWrapper().showItemizedOverlay(false);
    }
  }
  
  public void refresh()
  {
    if (getMapWrapper() != null) {
      getMapWrapper().refresh();
    }
  }
  
  public void removeAllItems()
  {
    if (getMapWrapper() != null) {
      getMapWrapper().removeAllItems();
    }
  }
  
  public void removeMapItem(OverlayItem paramOverlayItem)
  {
    if (getMapWrapper() != null) {
      getMapWrapper().removeMapItem(paramOverlayItem);
    }
  }
  
  public void setMapWrapper(MapWrapper paramMapWrapper)
  {
    this.mMapWrapper = paramMapWrapper;
  }
  
  public void setOnTapListener(OnTapListener paramOnTapListener)
  {
    if (getMapWrapper() != null) {
      getMapWrapper().setOnTapListener(paramOnTapListener);
    }
  }
  
  public void show()
  {
    if (getMapWrapper() != null) {
      getMapWrapper().showItemizedOverlay(true);
    }
  }
  
  private static class Holder
  {
    static final ItemizedOverlayUtil OVERLAY = new ItemizedOverlayUtil(null);
  }
  
  public static abstract interface MapWrapper
  {
    public abstract void addMapItem(OverlayItem paramOverlayItem);
    
    public abstract ItemizedOverlayUtil.OnTapListener getOnTapListener();
    
    public abstract void refresh();
    
    public abstract void removeAllItems();
    
    public abstract void removeMapItem(OverlayItem paramOverlayItem);
    
    public abstract void setOnTapListener(ItemizedOverlayUtil.OnTapListener paramOnTapListener);
    
    public abstract void showItemizedOverlay(boolean paramBoolean);
  }
  
  public static abstract interface OnTapListener
  {
    public abstract boolean onTap(int paramInt);
    
    public abstract boolean onTap(int paramInt1, int paramInt2, GeoPoint paramGeoPoint);
    
    public abstract boolean onTap(GeoPoint paramGeoPoint);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comapi/map/ItemizedOverlayUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */