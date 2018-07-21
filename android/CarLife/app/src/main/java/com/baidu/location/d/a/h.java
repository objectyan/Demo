package com.baidu.location.d.a;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.List;

class h
{
  static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    while ((paramString1.length() != 12) || (paramString2.length() != 12)) {
      return false;
    }
    paramString1 = paramString1.getBytes();
    paramString2 = paramString2.getBytes();
    int i = 0;
    int k;
    for (int j = 0; i < 12; j = k)
    {
      k = j;
      if (paramString1[i] == paramString2[i]) {
        k = j + 1;
      }
      i += 1;
    }
    if (j >= 8) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(List<ScanResult> paramList)
  {
    if (paramList == null) {}
    int m;
    int j;
    do
    {
      ArrayList localArrayList;
      do
      {
        return false;
        localArrayList = new ArrayList(paramList.size());
        i = 0;
        if (i < paramList.size())
        {
          String str = ((ScanResult)paramList.get(i)).BSSID.replace(":", "");
          if (str.length() != 12) {}
          for (;;)
          {
            i += 1;
            break;
            localArrayList.add(str);
          }
        }
        m = localArrayList.size();
      } while (m < 3);
      paramList = new a(m);
      int i = 0;
      while (i < m)
      {
        j = i + 1;
        while (j < m)
        {
          if (a((String)localArrayList.get(i), (String)localArrayList.get(j))) {
            paramList.a(i, j);
          }
          j += 1;
        }
        i += 1;
      }
      i = 0;
      int k;
      for (j = 0; i < m; j = k)
      {
        k = j;
        if (paramList.a(i) == 1)
        {
          k = j;
          if (paramList.b(i) >= 3) {
            k = j + paramList.b(i);
          }
        }
        i += 1;
      }
    } while (j * 2 <= m);
    return true;
  }
  
  private static class a
  {
    private int[] a;
    private int[] b;
    
    public a(int paramInt)
    {
      if (paramInt <= 0) {}
      for (;;)
      {
        return;
        this.a = new int[paramInt];
        this.b = new int[paramInt];
        int i = 0;
        while (i < paramInt)
        {
          this.a[i] = i;
          this.b[i] = 1;
          i += 1;
        }
      }
    }
    
    public int a(int paramInt)
    {
      if ((this.a == null) || (paramInt < 0) || (paramInt >= this.a.length)) {
        return -1;
      }
      if (paramInt == this.a[paramInt]) {
        return 1;
      }
      return 0;
    }
    
    public int a(int paramInt1, int paramInt2)
    {
      if ((this.a == null) || (paramInt1 < 0) || (paramInt1 >= this.a.length) || (paramInt2 < 0) || (paramInt2 >= this.a.length)) {
        return -1;
      }
      paramInt1 = c(paramInt1);
      paramInt2 = c(paramInt2);
      if (paramInt1 == paramInt2) {
        return 0;
      }
      int[] arrayOfInt = this.b;
      arrayOfInt[paramInt1] += this.b[paramInt2];
      this.a[paramInt2] = paramInt1;
      return 1;
    }
    
    public int b(int paramInt)
    {
      if ((this.b == null) || (paramInt < 0) || (paramInt >= this.b.length)) {
        return -1;
      }
      return this.b[paramInt];
    }
    
    public int c(int paramInt)
    {
      int i;
      if ((this.a != null) && (paramInt >= 0))
      {
        i = paramInt;
        if (paramInt < this.a.length) {}
      }
      else
      {
        paramInt = -1;
        return paramInt;
      }
      for (;;)
      {
        paramInt = i;
        if (i == this.a[i]) {
          break;
        }
        this.a[i] = this.a[this.a[i]];
        i = this.a[i];
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */