package com.baidu.platform.comapi.map.provider;

import com.baidu.platform.comapi.basestruct.MapBound;
import java.util.List;

public class MapOverlayUtils
{
  public static MapBound getGeoPointFromDiff(List<Integer> paramList)
  {
    if (paramList.size() == 0) {
      return null;
    }
    int k = 0;
    int m = 0;
    int i = 0;
    int j = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    if (i2 < paramList.size())
    {
      if (i2 == 0)
      {
        n = ((Integer)paramList.get(i2)).intValue();
        i = n;
        k = n;
      }
      for (;;)
      {
        i2 += 1;
        break;
        if (i2 == 1)
        {
          i1 = ((Integer)paramList.get(i2)).intValue();
          j = i1;
          m = i1;
        }
        else if (i2 % 2 == 0)
        {
          n += ((Integer)paramList.get(i2)).intValue();
          k = Math.min(k, n);
          i = Math.max(i, n);
        }
        else
        {
          i1 += ((Integer)paramList.get(i2)).intValue();
          m = Math.min(m, i1);
          j = Math.max(j, i1);
        }
      }
    }
    return new MapBound(k, m, i, j);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/provider/MapOverlayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */