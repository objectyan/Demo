package com.baidu.location.indoor;

import android.location.Location;
import java.util.ArrayList;
import java.util.List;

public class f
{
  private List<Location> a;
  private String b;
  private Location c = null;
  
  f(String paramString, Location[] paramArrayOfLocation)
  {
    if ((paramArrayOfLocation != null) && (paramArrayOfLocation.length > 0))
    {
      a(paramArrayOfLocation);
      this.b = paramString;
    }
  }
  
  private void a(Location[] paramArrayOfLocation)
  {
    double d1 = 0.0D;
    if ((paramArrayOfLocation != null) && (paramArrayOfLocation.length > 0))
    {
      if (this.a == null) {
        this.a = new ArrayList();
      }
      int i = 0;
      double d2 = 0.0D;
      while (i < paramArrayOfLocation.length)
      {
        d2 += paramArrayOfLocation[i].getLatitude();
        d1 += paramArrayOfLocation[i].getLongitude();
        this.a.add(paramArrayOfLocation[i]);
        i += 1;
      }
      if (this.c == null)
      {
        this.c = new Location("gps");
        this.c.setLatitude(d2 / paramArrayOfLocation.length);
        this.c.setLongitude(d1 / paramArrayOfLocation.length);
      }
    }
  }
  
  public String a()
  {
    return this.b;
  }
  
  public boolean a(double paramDouble1, double paramDouble2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    int m;
    int n;
    int i;
    int j;
    int i1;
    int i2;
    int i3;
    if (this.a != null)
    {
      int k = this.a.size();
      m = (int)(1000000 * paramDouble2);
      n = (int)(1000000 * paramDouble1);
      i = 0;
      j = k - 1;
      bool2 = bool1;
      if (i < k)
      {
        i1 = (int)(((Location)this.a.get(i)).getLongitude() * 1000000);
        i2 = (int)(((Location)this.a.get(i)).getLatitude() * 1000000);
        i3 = (int)(((Location)this.a.get(j)).getLongitude() * 1000000);
        j = (int)(((Location)this.a.get(j)).getLatitude() * 1000000);
        if (((m != i1) || (n != i2)) && ((m != i3) || (n != j))) {
          break label190;
        }
        bool2 = true;
      }
    }
    return bool2;
    label190:
    if (((i2 < n) && (j >= n)) || ((i2 >= n) && (j < n)))
    {
      j = (n - i2) * (i3 - i1) / (j - i2) + i1;
      if (j == m) {
        return true;
      }
      if (j > m) {
        if (!bool1) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      j = i;
      i += 1;
      break;
      bool1 = false;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */