package com.baidu.platform.comapi.search.convert;

import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PBConvertUtil
{
  public static Point decryptPoint(String paramString)
  {
    return CoordinateUtil.geoStringToPoint(paramString);
  }
  
  public static Point decryptPointFromArray(List<? extends Number> paramList)
  {
    if ((paramList != null) && (paramList.size() >= 2)) {
      return new Point(((Number)paramList.get(0)).doubleValue(), ((Number)paramList.get(1)).doubleValue());
    }
    return new Point();
  }
  
  public static List<Integer> encodePoint(Point paramPoint)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramPoint != null)
    {
      localArrayList.add(Integer.valueOf(paramPoint.getIntX()));
      localArrayList.add(Integer.valueOf(paramPoint.getIntY()));
      return localArrayList;
    }
    localArrayList.add(Integer.valueOf(0));
    localArrayList.add(Integer.valueOf(0));
    return localArrayList;
  }
  
  public static boolean intToBool(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static boolean stringToBool(String paramString)
  {
    return (paramString != null) && (paramString.equals("1"));
  }
  
  public static int[] toIntArray(List<Integer> paramList)
  {
    int[] arrayOfInt = new int[paramList.size()];
    int i = 0;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      arrayOfInt[i] = ((Integer)paramList.next()).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/convert/PBConvertUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */