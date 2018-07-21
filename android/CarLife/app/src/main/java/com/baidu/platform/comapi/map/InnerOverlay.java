package com.baidu.platform.comapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public abstract class InnerOverlay
  extends Overlay
{
  static final boolean DEBUG = false;
  private static final String TAG = "InnerOverlay";
  AppBaseMap mBaseMap = null;
  String strJsonData = null;
  
  public InnerOverlay() {}
  
  public InnerOverlay(int paramInt)
  {
    setType(paramInt);
  }
  
  public InnerOverlay(int paramInt, AppBaseMap paramAppBaseMap)
  {
    setType(paramInt);
    this.mBaseMap = paramAppBaseMap;
  }
  
  public boolean IsOverlayShow()
  {
    return (this.mLayerID != 0) && (this.mBaseMap != null) && (this.mBaseMap.GetId() != 0) && (this.mBaseMap.LayersIsShow(this.mLayerID));
  }
  
  public void SetMapParam(int paramInt, AppBaseMap paramAppBaseMap)
  {
    this.mLayerID = paramInt;
    this.mBaseMap = paramAppBaseMap;
  }
  
  public void SetOverlayShow(boolean paramBoolean)
  {
    if ((this.mLayerID == 0) || (this.mBaseMap == null) || (this.mBaseMap.GetId() == 0)) {}
    long l;
    do
    {
      return;
      l = 0L;
      if (MapTrace.enableTrace) {
        l = System.currentTimeMillis();
      }
      this.mBaseMap.ShowLayers(this.mLayerID, paramBoolean);
    } while (!MapTrace.enableTrace);
    MapTrace.trace("InnerOverlay", "ShowLayer:" + this.mLayerID + ":" + paramBoolean + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - l) + "ms]");
  }
  
  public void UpdateOverlay()
  {
    if ((this.mLayerID == 0) || (this.mBaseMap == null) || (this.mBaseMap.GetId() == 0)) {}
    long l;
    do
    {
      return;
      l = 0L;
      if (MapTrace.enableTrace) {
        l = System.currentTimeMillis();
      }
      this.mBaseMap.UpdateLayers(this.mLayerID);
    } while (!MapTrace.enableTrace);
    MapTrace.trace("InnerOverlay", "UpdateLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - l) + "ms]");
  }
  
  public boolean addedToMapView()
  {
    if ((this.mBaseMap == null) || (this.mBaseMap.GetId() == 0)) {
      return false;
    }
    long l = 0L;
    if (MapTrace.enableTrace) {
      l = System.currentTimeMillis();
    }
    this.mLayerID = this.mBaseMap.AddLayer(getUpdateType(), getUpdateTimeInterval(), getLayerTag());
    if (MapTrace.enableTrace) {
      MapTrace.trace("InnerOverlay", "AddLayer:" + this.mLayerID + " type:" + this.mType + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - l) + "ms]");
    }
    if (this.mLayerID != 0)
    {
      this.mBaseMap.SetLayersClickable(this.mLayerID, true);
      SetOverlayShow(getDefaultShowStatus());
      return true;
    }
    return false;
  }
  
  public void clear()
  {
    long l = 0L;
    if (MapTrace.enableTrace) {
      l = System.currentTimeMillis();
    }
    if (!TextUtils.isEmpty(this.strJsonData))
    {
      this.strJsonData = null;
      if (this.mBaseMap != null) {
        this.mBaseMap.ClearLayer(this.mLayerID);
      }
    }
    if (MapTrace.enableTrace) {
      MapTrace.trace("InnerOverlay", "ClearLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - l) + "ms]");
    }
  }
  
  public String getData()
  {
    return this.strJsonData;
  }
  
  public boolean getDefaultShowStatus()
  {
    return false;
  }
  
  public String getLayerTag()
  {
    return "default";
  }
  
  public Bundle getParam()
  {
    return null;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public int getUpdateTimeInterval()
  {
    return 0;
  }
  
  public int getUpdateType()
  {
    return 0;
  }
  
  public boolean insertToMapView(int paramInt)
  {
    if ((this.mBaseMap == null) || (this.mBaseMap.GetId() == 0)) {
      return false;
    }
    this.mLayerID = this.mBaseMap.InsertLayerAt(paramInt, getUpdateType(), getUpdateTimeInterval(), getLayerTag());
    if (this.mLayerID != 0)
    {
      this.mBaseMap.SetLayersClickable(this.mLayerID, true);
      SetOverlayShow(getDefaultShowStatus());
      return true;
    }
    return false;
  }
  
  public void setData(String paramString)
  {
    if (paramString != null) {
      this.strJsonData = paramString;
    }
  }
  
  public void setFocus(int paramInt, boolean paramBoolean)
  {
    setFocus(paramInt, paramBoolean, null);
  }
  
  public void setFocus(int paramInt, boolean paramBoolean, String paramString)
  {
    if ((this.mBaseMap == null) || (this.mBaseMap.GetId() == 0)) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("uid", paramString);
    }
    this.mBaseMap.SetFocus(this.mLayerID, paramInt, paramBoolean, localBundle);
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/InnerOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */