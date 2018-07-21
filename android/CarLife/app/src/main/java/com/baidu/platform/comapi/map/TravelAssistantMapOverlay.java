package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class TravelAssistantMapOverlay
  extends InnerOverlay
{
  public static final int PB_LENGTH_SIGN = 32;
  private byte[] extData;
  
  public TravelAssistantMapOverlay()
  {
    super(37);
  }
  
  public TravelAssistantMapOverlay(AppBaseMap paramAppBaseMap)
  {
    super(37, paramAppBaseMap);
  }
  
  private byte[] getExtData(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length >= 32) {
        break label25;
      }
      arrayOfByte1 = arrayOfByte2;
    }
    label25:
    int j;
    int k;
    int m;
    int n;
    do
    {
      return arrayOfByte1;
      i = paramArrayOfByte[0];
      j = paramArrayOfByte[1];
      k = paramArrayOfByte[2];
      m = paramArrayOfByte[3];
      n = paramArrayOfByte.length;
      arrayOfByte1 = arrayOfByte2;
    } while (((i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8 | m & 0xFF) != n - 32);
    arrayOfByte2 = new byte[n - 32];
    int i = 0;
    for (;;)
    {
      arrayOfByte1 = arrayOfByte2;
      if (i >= arrayOfByte2.length) {
        break;
      }
      arrayOfByte2[i] = paramArrayOfByte[(i + 32)];
      i += 1;
    }
  }
  
  public boolean addedToMapView()
  {
    if (this.mBaseMap == null) {}
    do
    {
      return false;
      this.mLayerID = this.mBaseMap.AddLayer(0, 0, "dynamicmap");
    } while (this.mLayerID == 0);
    this.mBaseMap.SetLayersClickable(this.mLayerID, true);
    this.mBaseMap.ShowLayers(this.mLayerID, false);
    return true;
  }
  
  public Bundle getParam()
  {
    Bundle localBundle1 = new Bundle();
    if ((this.extData != null) && (this.extData.length > 1))
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putByteArray("data", this.extData);
      localBundle2.putInt("len", this.extData.length);
      localBundle1.putParcelableArray("imge_ext", new Bundle[] { localBundle2 });
    }
    return localBundle1;
  }
  
  public void setExtData(byte[] paramArrayOfByte)
  {
    this.extData = getExtData(paramArrayOfByte);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/TravelAssistantMapOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */