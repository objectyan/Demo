package com.baidu.platform.comjni.map.dataengine;

import android.os.Bundle;
import com.baidu.platform.comjni.a;

public class NADataEngine
  extends a
{
  private int a = 0;
  
  private native void nativeCancelThumbImageRequest(int paramInt);
  
  private native int nativeCreate();
  
  private native String nativeGetCurrentStreetId(int paramInt);
  
  private native String nativeGetCurrentStreetInfo(int paramInt, Bundle paramBundle);
  
  private native boolean nativeGetHotMapCityInfo(int paramInt, Bundle paramBundle);
  
  private native boolean nativeGetStreetCityInfo(int paramInt, Bundle paramBundle);
  
  private native boolean nativeQueryThumbImage(int paramInt, String paramString);
  
  private native int nativeRelease(int paramInt);
  
  private native void nativeSetStreetPOIUID(int paramInt, String paramString);
  
  private native boolean nativeStreetSwitchByUID(int paramInt, String paramString1, String paramString2);
  
  private native boolean nativeStreetSwitchToID(int paramInt1, String paramString, int paramInt2);
  
  private native boolean nativeStreetSwitchToIDFromReGeo(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  private native boolean nativeStreetSwitchToIID(int paramInt, String paramString1, String paramString2, boolean paramBoolean);
  
  public void cancelThumbImageRequest()
  {
    nativeCancelThumbImageRequest(this.a);
  }
  
  public int create()
  {
    this.a = nativeCreate();
    return this.a;
  }
  
  public String getCurrentStreetId()
  {
    return nativeGetCurrentStreetId(this.a);
  }
  
  public String getCurrentStreetInfo(Bundle paramBundle)
  {
    return nativeGetCurrentStreetInfo(this.a, paramBundle);
  }
  
  public boolean getHotMapCityInfo(Bundle paramBundle)
  {
    return nativeGetHotMapCityInfo(this.a, paramBundle);
  }
  
  public boolean getStreetCityInfo(Bundle paramBundle)
  {
    return nativeGetStreetCityInfo(this.a, paramBundle);
  }
  
  public boolean queryThumbImage(String paramString)
  {
    return nativeQueryThumbImage(this.a, paramString);
  }
  
  public int release()
  {
    return nativeRelease(this.a);
  }
  
  public void setStreetPOIUID(String paramString)
  {
    nativeSetStreetPOIUID(this.a, paramString);
  }
  
  public boolean streetSwitchByUID(String paramString1, String paramString2)
  {
    return nativeStreetSwitchByUID(this.a, paramString1, paramString2);
  }
  
  public boolean streetSwitchToIID(String paramString1, String paramString2, boolean paramBoolean)
  {
    return nativeStreetSwitchToIID(this.a, paramString1, paramString2, paramBoolean);
  }
  
  public boolean streetSwitchToId(String paramString, int paramInt)
  {
    return nativeStreetSwitchToID(this.a, paramString, paramInt);
  }
  
  public boolean streetSwitchToId(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    return nativeStreetSwitchToIDFromReGeo(this.a, paramString1, paramString2, paramLong1, paramLong2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comjni/map/dataengine/NADataEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */