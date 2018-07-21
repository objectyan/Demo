package com.baidu.platform.comapi.location;

import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

public class CoordinateUtil
{
  @Nullable
  public static native Point bd09llTobd09mc(double paramDouble1, double paramDouble2);
  
  @Nullable
  public static native Point bd09llTogcj02ll(double paramDouble1, double paramDouble2);
  
  @Nullable
  public static native Point bd09mcTobd09ll(double paramDouble1, double paramDouble2);
  
  @Nullable
  public static Point bd09mcTogcj02ll(double paramDouble1, double paramDouble2)
  {
    Point localPoint = bd09mcTobd09ll(paramDouble1, paramDouble2);
    if (localPoint != null) {
      return bd09llTogcj02ll(localPoint.getDoubleX(), localPoint.getDoubleY());
    }
    return null;
  }
  
  public static Point complexPtToPoint(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    return nativeComplexPtToPoint(paramString);
  }
  
  @Nullable
  public static native Point gcj02Tobd09ll(double paramDouble1, double paramDouble2);
  
  @Nullable
  public static Point gcj02Tobd09mc(double paramDouble1, double paramDouble2)
  {
    Point localPoint = gcj02Tobd09ll(paramDouble1, paramDouble2);
    if (localPoint != null) {
      return bd09llTobd09mc(localPoint.getDoubleX(), localPoint.getDoubleY());
    }
    return null;
  }
  
  public static ComplexPt geoStringToComplexPt(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    Bundle localBundle1 = new Bundle();
    if (nativeGeoStringToComplexPt(paramString, localBundle1))
    {
      paramString = new ComplexPt();
      Object localObject1 = localBundle1.getBundle("map_bound");
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((Bundle)localObject1).getBundle("ll");
        if (localObject2 != null) {
          paramString.mLL = new Point((int)((Bundle)localObject2).getDouble("ptx"), (int)((Bundle)localObject2).getDouble("pty"));
        }
        localObject1 = ((Bundle)localObject1).getBundle("ru");
        if (localObject1 != null) {
          paramString.mRu = new Point((int)((Bundle)localObject1).getDouble("ptx"), (int)((Bundle)localObject1).getDouble("pty"));
        }
      }
      localObject1 = (ParcelItem[])localBundle1.getParcelableArray("poly_line");
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        localObject2 = localObject1[i];
        if (paramString.mGeoPt == null) {
          paramString.mGeoPt = new ArrayList();
        }
        localObject2 = ((ParcelItem)localObject2).getBundle();
        if (localObject2 != null)
        {
          localObject2 = (ParcelItem[])((Bundle)localObject2).getParcelableArray("point_array");
          ArrayList localArrayList = new ArrayList();
          int j = 0;
          while (j < localObject2.length)
          {
            Bundle localBundle2 = localObject2[j].getBundle();
            if (localBundle2 != null) {
              localArrayList.add(new Point((int)localBundle2.getDouble("ptx"), (int)localBundle2.getDouble("pty")));
            }
            j += 1;
          }
          localArrayList.trimToSize();
          paramString.mGeoPt.add(localArrayList);
        }
        i += 1;
      }
      paramString.mGeoPt.trimToSize();
      paramString.eType = ((int)localBundle1.getDouble("type"));
      return paramString;
    }
    return null;
  }
  
  public static ComplexPt geoStringToComplexPtBound(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    Bundle localBundle1;
    do
    {
      return null;
      localBundle1 = new Bundle();
    } while (!nativeGeoStringToComplexPtBound(paramString, localBundle1));
    paramString = new ComplexPt();
    Bundle localBundle2 = localBundle1.getBundle("map_bound");
    if (localBundle2 != null)
    {
      Bundle localBundle3 = localBundle2.getBundle("ll");
      if (localBundle3 != null) {
        paramString.mLL = new Point((int)localBundle3.getDouble("ptx"), (int)localBundle3.getDouble("pty"));
      }
      localBundle2 = localBundle2.getBundle("ru");
      if (localBundle2 != null) {
        paramString.mRu = new Point((int)localBundle2.getDouble("ptx"), (int)localBundle2.getDouble("pty"));
      }
    }
    paramString.eType = ((int)localBundle1.getDouble("type"));
    return paramString;
  }
  
  public static Point geoStringToPoint(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    return nativeGeoStringToPoint(paramString);
  }
  
  public static native double getDistanceByMc(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4);
  
  private static native Point nativeComplexPtToPoint(String paramString);
  
  private static native boolean nativeGeoStringToComplexPt(String paramString, Bundle paramBundle);
  
  private static native boolean nativeGeoStringToComplexPtBound(String paramString, Bundle paramBundle);
  
  private static native Point nativeGeoStringToPoint(String paramString);
  
  private static native String nativePointToGeoString(double paramDouble1, double paramDouble2);
  
  public static String pointToGeoString(Point paramPoint)
  {
    if (paramPoint == null) {
      return "";
    }
    return nativePointToGeoString(paramPoint.getDoubleX(), paramPoint.getDoubleY());
  }
  
  @Nullable
  public static Point wgs84Tobd09ll(double paramDouble1, double paramDouble2)
  {
    Point localPoint = wgs84Togcj02(paramDouble1, paramDouble2);
    if (localPoint != null) {
      return gcj02Tobd09ll(localPoint.getDoubleX(), localPoint.getDoubleY());
    }
    return null;
  }
  
  @Nullable
  public static Point wgs84Tobd09mc(double paramDouble1, double paramDouble2)
  {
    Point localPoint = wgs84Togcj02(paramDouble1, paramDouble2);
    if (localPoint != null)
    {
      localPoint = gcj02Tobd09ll(localPoint.getDoubleX(), localPoint.getDoubleY());
      if (localPoint != null) {
        return bd09llTobd09mc(localPoint.getDoubleX(), localPoint.getDoubleY());
      }
    }
    return null;
  }
  
  @Nullable
  public static native Point wgs84Togcj02(double paramDouble1, double paramDouble2);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/location/CoordinateUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */