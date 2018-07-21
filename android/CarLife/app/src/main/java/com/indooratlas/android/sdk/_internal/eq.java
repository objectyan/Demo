package com.indooratlas.android.sdk._internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class eq
{
  public final ArrayList<double[]> a;
  final er b;
  
  public eq(List<double[]> paramList)
  {
    if (paramList.size() <= 2) {
      throw new IllegalArgumentException("Invalid number of edges for a geofence.");
    }
    this.b = a(paramList);
    this.a = new ArrayList(paramList);
    this.a.add(paramList.get(0));
  }
  
  private static er a(List<double[]> paramList)
  {
    double d2 = ((double[])paramList.get(0))[1];
    double d1 = ((double[])paramList.get(0))[0];
    int i = 1;
    double d3 = d1;
    double d4 = d2;
    while (i < paramList.size())
    {
      d4 = Math.min(((double[])paramList.get(i))[1], d4);
      d3 = Math.min(((double[])paramList.get(i))[0], d3);
      d2 = Math.max(((double[])paramList.get(i))[1], d2);
      d1 = Math.max(((double[])paramList.get(i))[0], d1);
      i += 1;
    }
    return new er(d4, d3, d2, d1);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (getClass() != paramObject.getClass());
      paramObject = (eq)paramObject;
      bool1 = bool2;
    } while (this.a.size() != ((eq)paramObject).a.size());
    int i = 0;
    for (;;)
    {
      if (i >= this.a.size()) {
        break label134;
      }
      double[] arrayOfDouble1 = (double[])this.a.get(i);
      double[] arrayOfDouble2 = (double[])((eq)paramObject).a.get(i);
      bool1 = bool2;
      if (arrayOfDouble1[0] != arrayOfDouble2[0]) {
        break;
      }
      bool1 = bool2;
      if (arrayOfDouble1[1] != arrayOfDouble2[1]) {
        break;
      }
      i += 1;
    }
    label134:
    return true;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = this.a.iterator();
    long l;
    int j;
    for (int i = 1; localIterator.hasNext(); i = (int)(l ^ l >>> 32) + (i * 37 + j) * 37)
    {
      double[] arrayOfDouble = (double[])localIterator.next();
      l = Double.doubleToLongBits(arrayOfDouble[0]);
      j = (int)(l ^ l >>> 32);
      l = Double.doubleToLongBits(arrayOfDouble[1]);
    }
    return i;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Polygon{");
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      double[] arrayOfDouble = (double[])localIterator.next();
      localStringBuilder.append('[').append(arrayOfDouble[0]).append(',').append(arrayOfDouble[1]).append(']');
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/eq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */