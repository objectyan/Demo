package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class LocationOverlay
  extends InnerOverlay
{
  private AppBaseMap mAppBaseMap;
  
  public LocationOverlay()
  {
    super(7);
  }
  
  public LocationOverlay(AppBaseMap paramAppBaseMap)
  {
    super(7, paramAppBaseMap);
    this.mAppBaseMap = paramAppBaseMap;
  }
  
  public void clearLocationLayerData(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("locationaddr", this.mLayerID);
    this.mAppBaseMap.ClearLocationLayerData(localBundle);
  }
  
  public boolean getDefaultShowStatus()
  {
    return true;
  }
  
  public String getLayerTag()
  {
    return "location";
  }
  
  public void setLocationLayerData(List<OverlayLocationData> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (this.mLayerID == 0)) {
      return;
    }
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("locationaddr", this.mLayerID);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label212;
      }
      OverlayLocationData localOverlayLocationData = (OverlayLocationData)paramList.get(i);
      if (localOverlayLocationData.getImage() == null) {
        break;
      }
      ParcelItem localParcelItem = new ParcelItem();
      Bitmap localBitmap = localOverlayLocationData.getImage();
      Bundle localBundle2 = new Bundle();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(localBitmap.getWidth() * localBitmap.getHeight() * 4);
      localBitmap.copyPixelsToBuffer(localByteBuffer);
      localBundle2.putByteArray("imgbin", localByteBuffer.array());
      localBundle2.putInt("w", localOverlayLocationData.getImgWidth());
      localBundle2.putInt("h", localOverlayLocationData.getImgHeight());
      localBundle2.putInt("rotation", localOverlayLocationData.isRotation());
      localBundle2.putString("name", localOverlayLocationData.getImgName());
      localParcelItem.setBundle(localBundle2);
      localArrayList.add(localParcelItem);
      i += 1;
    }
    label212:
    if (localArrayList.size() > 0)
    {
      paramList = new ParcelItem[localArrayList.size()];
      i = 0;
      while (i < localArrayList.size())
      {
        paramList[i] = ((ParcelItem)localArrayList.get(i));
        i += 1;
      }
      localBundle1.putParcelableArray("imagedata", paramList);
    }
    this.mAppBaseMap.SetLocationLayerData(localBundle1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/LocationOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */