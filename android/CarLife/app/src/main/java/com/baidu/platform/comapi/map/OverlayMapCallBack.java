package com.baidu.platform.comapi.map;

import android.os.Bundle;
import android.util.SparseArray;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.platform.comjni.map.basemap.a;

public final class OverlayMapCallBack
  implements a
{
  static final boolean DEBUG = false;
  static final String LAYERDATA_KEY = "jsondata";
  static final String LAYERDATA_PARAM = "param";
  static final String TAG = OverlayMapCallBack.class.getName();
  AppBaseMap mBaseMap = null;
  SparseArray<InnerOverlay> overlayMap = new SparseArray();
  
  public OverlayMapCallBack(AppBaseMap paramAppBaseMap)
  {
    this.mBaseMap = paramAppBaseMap;
  }
  
  public void addOverlay(InnerOverlay paramInnerOverlay)
  {
    this.overlayMap.put(paramInnerOverlay.mLayerID, paramInnerOverlay);
    paramInnerOverlay.SetMapParam(paramInnerOverlay.mLayerID, this.mBaseMap);
  }
  
  public void clear()
  {
    if (this.mBaseMap != null)
    {
      int j = this.overlayMap.size();
      int i = 0;
      while (i < j)
      {
        int k = this.overlayMap.keyAt(i);
        if (k > 0)
        {
          this.mBaseMap.ClearLayer(k);
          this.mBaseMap.RemoveLayer(k);
        }
        i += 1;
      }
    }
    this.overlayMap.clear();
  }
  
  public InnerOverlay getOverlay(int paramInt)
  {
    return (InnerOverlay)this.overlayMap.get(paramInt);
  }
  
  public int getOverlaySize()
  {
    return this.overlayMap.size();
  }
  
  public boolean hasLayer(int paramInt)
  {
    return this.overlayMap.indexOfKey(paramInt) >= 0;
  }
  
  public int mapLayerDataReq(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    long l = 0L;
    if (MapTrace.enableTrace) {
      l = System.currentTimeMillis();
    }
    InnerOverlay localInnerOverlay = (InnerOverlay)this.overlayMap.get(paramInt1);
    if (localInnerOverlay != null)
    {
      String str = localInnerOverlay.getData();
      if (this.mBaseMap.LayersIsShow(paramInt1))
      {
        paramBundle.putString("jsondata", str);
        Bundle localBundle = localInnerOverlay.getParam();
        if (localBundle != null) {
          paramBundle.putBundle("param", localBundle);
        }
      }
      for (;;)
      {
        if (MapTrace.enableTrace) {
          MapTrace.trace(TAG, "MapLayerDataReq:" + paramInt1 + " tag:" + localInnerOverlay.getLayerTag() + " [" + (System.currentTimeMillis() - l) + "ms] LayerData:" + str);
        }
        return localInnerOverlay.getType();
        paramBundle.putString("jsondata", null);
      }
    }
    return 0;
  }
  
  public void remove(Overlay paramOverlay)
  {
    this.overlayMap.remove(paramOverlay.mLayerID);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/OverlayMapCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */