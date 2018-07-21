package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BaseMapCallback
{
  private static final ConcurrentHashMap<Long, a> LAYER_CALLBACKS = new ConcurrentHashMap(2);
  
  public static int ReqLayerData(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (LAYER_CALLBACKS.isEmpty()) {}
    a locala;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return 0;
        localIterator = LAYER_CALLBACKS.entrySet().iterator();
      }
      locala = (a)((Map.Entry)localIterator.next()).getValue();
    } while ((locala == null) || (!locala.hasLayer(paramInt1)));
    return locala.mapLayerDataReq(paramBundle, paramInt1, paramInt2);
  }
  
  public static boolean setMapCallback(long paramLong, a parama)
  {
    if ((parama == null) || (paramLong == 0L)) {
      return false;
    }
    LAYER_CALLBACKS.put(Long.valueOf(paramLong), parama);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comjni/map/basemap/BaseMapCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */