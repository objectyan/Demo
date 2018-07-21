package com.indooratlas.android.sdk._internal;

import java.util.ArrayList;
import java.util.List;

public final class em
{
  public final eq a;
  public final Integer b;
  
  public em(List<double[]> paramList, Integer paramInteger)
  {
    this.a = new eq(paramList);
    this.b = paramInteger;
  }
  
  public final boolean a(ep paramep)
  {
    Object localObject = paramep.c;
    int i;
    double d1;
    label102:
    int j;
    label113:
    double d3;
    if ((this.b == null) || ((localObject != null) && (((Integer)localObject).equals(this.b))))
    {
      i = 1;
      if (i == 0) {
        break label351;
      }
      localObject = this.a;
      d1 = paramep.a;
      double d2 = paramep.b;
      paramep = ((eq)localObject).b;
      if ((paramep.a > d2) || (d2 > paramep.c) || (paramep.b > d1) || (d1 > paramep.d)) {
        break label286;
      }
      i = 1;
      if (i == 0) {
        break label345;
      }
      i = 0;
      j = 0;
      if (j >= ((eq)localObject).a.size() - 1) {
        break label330;
      }
      d3 = ((double[])localObject.a.get(j))[1];
      double d4 = ((double[])localObject.a.get(j))[0];
      d3 = (((double[])localObject.a.get(j + 1))[1] - d3) * (d1 - d4) - (d2 - d3) * (((double[])localObject.a.get(j + 1))[0] - d4);
      if (((double[])localObject.a.get(j))[0] > d1) {
        break label292;
      }
      if ((((double[])localObject.a.get(j + 1))[0] <= d1) || (d3 <= 0.0D)) {
        break label353;
      }
      i += 1;
    }
    label286:
    label292:
    label330:
    label345:
    label351:
    label353:
    for (;;)
    {
      j += 1;
      break label113;
      i = 0;
      break;
      i = 0;
      break label102;
      if ((((double[])localObject.a.get(j + 1))[0] <= d1) && (d3 < 0.0D))
      {
        i -= 1;
        continue;
        if (i != 0) {}
        for (i = 1; i != 0; i = 0) {
          return true;
        }
        return false;
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof em))) {}
    do
    {
      do
      {
        return false;
        paramObject = (em)paramObject;
      } while (!this.a.equals(((em)paramObject).a));
      if (this.b != null) {
        break;
      }
    } while (((em)paramObject).b != null);
    for (;;)
    {
      return true;
      if (!this.b.equals(((em)paramObject).b)) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int j = this.a.hashCode();
    if (this.b == null) {}
    for (int i = 0;; i = this.b.intValue()) {
      return i + j * 37;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FloorArea{polygon=").append(this.a).append(",floor=");
    if (this.b == null) {}
    for (Object localObject = "null";; localObject = this.b) {
      return localObject + "}";
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */