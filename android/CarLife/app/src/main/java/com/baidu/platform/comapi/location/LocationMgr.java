package com.baidu.platform.comapi.location;

import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;

public class LocationMgr
{
  public static LocationMgr getInstance()
  {
    return HOLDER.INSTANCE;
  }
  
  public Point Coordinate_encryptEx(float paramFloat1, float paramFloat2, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = paramString;
    if (paramString.equals("")) {
      str = "bd09ll";
    }
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return null;
      case 0: 
        return CoordinateUtil.wgs84Tobd09mc(paramFloat1, paramFloat2);
        if (str.equals("wgs84"))
        {
          i = 0;
          continue;
          if (str.equals("gcj02"))
          {
            i = 1;
            continue;
            if (str.equals("bd09ll"))
            {
              i = 2;
              continue;
              if (str.equals("bd09mc")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return CoordinateUtil.gcj02Tobd09mc(paramFloat1, paramFloat2);
    return CoordinateUtil.bd09llTobd09mc(paramFloat1, paramFloat2);
    return new Point(paramFloat1, paramFloat2);
  }
  
  public ArrayList<Point> Coordinate_encryptExArray(ArrayList<Point> paramArrayList, String paramString)
  {
    ArrayList localArrayList = null;
    if (paramString == null) {
      paramString = localArrayList;
    }
    String str;
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    int j;
    do
    {
      do
      {
        return paramString;
        str = paramString;
        if (paramString.equals("")) {
          str = "bd09ll";
        }
        if ((str.equals("bd09ll")) || (str.equals("bd09mc")) || (str.equals("gcj02"))) {
          break;
        }
        paramString = localArrayList;
      } while (!str.equals("wgs84"));
      arrayOfFloat1 = new float[paramArrayList.size()];
      arrayOfFloat2 = new float[paramArrayList.size()];
      i = 0;
      while (i < paramArrayList.size())
      {
        arrayOfFloat1[i] = (((Point)paramArrayList.get(i)).getIntX() / 100000.0F);
        arrayOfFloat2[i] = (((Point)paramArrayList.get(i)).getIntY() / 100000.0F);
        i += 1;
      }
      localArrayList = new ArrayList();
      j = 0;
      paramString = localArrayList;
    } while (j >= arrayOfFloat1.length);
    paramArrayList = null;
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      label216:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      if (paramArrayList != null) {
        localArrayList.add(paramArrayList);
      }
      j += 1;
      break;
      if (!str.equals("wgs84")) {
        break label216;
      }
      i = 0;
      break label216;
      if (!str.equals("gcj02")) {
        break label216;
      }
      i = 1;
      break label216;
      if (!str.equals("bd09ll")) {
        break label216;
      }
      i = 2;
      break label216;
      if (!str.equals("bd09mc")) {
        break label216;
      }
      i = 3;
      break label216;
      paramArrayList = CoordinateUtil.wgs84Tobd09mc(arrayOfFloat1[j], arrayOfFloat2[j]);
      continue;
      paramArrayList = CoordinateUtil.gcj02Tobd09mc(arrayOfFloat1[j], arrayOfFloat2[j]);
      continue;
      paramArrayList = CoordinateUtil.bd09llTobd09mc(arrayOfFloat1[j], arrayOfFloat2[j]);
      continue;
      paramArrayList = new Point(arrayOfFloat1[j], arrayOfFloat2[j]);
    }
  }
  
  private static final class HOLDER
  {
    private static final LocationMgr INSTANCE = new LocationMgr(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/location/LocationMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */