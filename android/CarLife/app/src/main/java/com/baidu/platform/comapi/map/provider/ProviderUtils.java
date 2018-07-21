package com.baidu.platform.comapi.map.provider;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.c;
import com.baidu.platform.comapi.util.JsonBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderUtils
{
  static List<Integer> connectPath(List<Integer> paramList1, List<Integer> paramList2)
  {
    Object localObject = paramList2;
    if (paramList1 != null)
    {
      ComplexPt localComplexPt = ComplexPt.createComplexPt(paramList1);
      paramList1 = ComplexPt.createComplexPt(paramList2);
      localObject = paramList2;
      if (localComplexPt != null)
      {
        localObject = paramList2;
        if (!localComplexPt.isEmpty())
        {
          localObject = paramList2;
          if (paramList1 != null)
          {
            localObject = paramList2;
            if (!paramList1.isEmpty())
            {
              paramList2 = (ArrayList)localComplexPt.mGeoPt.get(localComplexPt.mGeoPt.size() - 1);
              paramList2 = (Point)paramList2.get(paramList2.size() - 1);
              ((ArrayList)paramList1.mGeoPt.get(0)).add(0, paramList2);
              localObject = paramList1.toIntArray();
            }
          }
        }
      }
    }
    return (List<Integer>)localObject;
  }
  
  public static int dip2px(int paramInt)
  {
    return (int)(0.5F + c.f().getResources().getDisplayMetrics().density * paramInt);
  }
  
  static String escapeString(String paramString)
  {
    return paramString.replace("\"", "'");
  }
  
  static String pathToJson(List<? extends Number> paramList)
  {
    JsonBuilder localJsonBuilder = new JsonBuilder();
    localJsonBuilder.arrayValue();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJsonBuilder.value((Number)paramList.next());
    }
    localJsonBuilder.endArrayValue();
    return localJsonBuilder.getJson();
  }
  
  public static int px2dip(int paramInt)
  {
    return (int)(0.5F + paramInt / c.f().getResources().getDisplayMetrics().density);
  }
  
  static List<List<Integer>> splitPath(List<Integer> paramList1, List<Integer> paramList2)
  {
    ComplexPt localComplexPt = ComplexPt.createComplexPt(paramList1);
    if ((localComplexPt == null) || (localComplexPt.isEmpty()))
    {
      paramList2 = new ArrayList();
      return paramList2;
    }
    ArrayList localArrayList1 = new ArrayList();
    paramList1 = localComplexPt.mGeoPt.iterator();
    while (paramList1.hasNext())
    {
      localObject = ((List)paramList1.next()).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList1.add((Point)((Iterator)localObject).next());
      }
    }
    Object localObject = new ArrayList();
    paramList1 = null;
    int i = 0;
    Iterator localIterator = paramList2.iterator();
    for (;;)
    {
      paramList2 = (List<Integer>)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList2 = (Integer)localIterator.next();
      if (localArrayList1.size() > paramList2.intValue() + i)
      {
        localComplexPt.mGeoPt = new ArrayList();
        ArrayList localArrayList2 = subArrayList(localArrayList1, i, paramList2.intValue() + i);
        if (paramList1 != null) {
          localArrayList2.add(0, paramList1);
        }
        paramList1 = (Point)localArrayList2.get(localArrayList2.size() - 1);
        localComplexPt.mGeoPt.add(localArrayList2);
        ((List)localObject).add(localComplexPt.toIntArray());
        i += paramList2.intValue();
      }
    }
  }
  
  private static <T> ArrayList<T> subArrayList(ArrayList<T> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    while (paramInt1 <= paramInt2)
    {
      localArrayList.add(paramArrayList.get(paramInt1));
      paramInt1 += 1;
    }
    return localArrayList;
  }
  
  public static enum RouteState
  {
    ENTIRE(1),  SEGMENT(2);
    
    private int nativeValue;
    
    private RouteState(int paramInt)
    {
      this.nativeValue = paramInt;
    }
    
    public int getNativeValue()
    {
      return this.nativeValue;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/provider/ProviderUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */