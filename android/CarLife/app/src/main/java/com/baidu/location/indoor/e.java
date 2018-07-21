package com.baidu.location.indoor;

import android.os.Handler;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.d.g;
import com.baidu.location.h.b;
import java.util.Locale;

class e
{
  private static volatile e a = null;
  private StringBuffer b = null;
  private Handler c = null;
  private a d = null;
  private boolean e = false;
  
  public static e a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new e();
      }
      return a;
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      if (this.b != null)
      {
        String str = this.b.toString();
        g.a(g.a, Jni.encode(str));
        this.b = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(BDLocation paramBDLocation, String paramString)
  {
    if ((paramBDLocation == null) || ((paramBDLocation != null) && (paramBDLocation.getBuildingID() == null))) {
      return;
    }
    if (this.c == null) {
      this.c = new Handler();
    }
    if (this.e)
    {
      if (this.d == null) {
        this.d = new a(null);
      }
      this.c.removeCallbacks(this.d);
      this.e = false;
    }
    if (this.b == null)
    {
      this.b = new StringBuffer();
      if (paramString != null)
      {
        this.b.append("&bldg=");
        this.b.append(paramString);
      }
      this.b.append(b.a().a(false));
      this.b.append("&uptype=indoor");
      this.b.append("&data=");
    }
    try
    {
      if ((paramBDLocation.getNetworkLocationType() != null) && (paramBDLocation.getNetworkLocationType().equals("ml"))) {
        paramBDLocation = String.format(Locale.CHINA, "%f|%f|%.1f|%d|%s|1", new Object[] { Double.valueOf(paramBDLocation.getLatitude()), Double.valueOf(paramBDLocation.getLongitude()), Float.valueOf(paramBDLocation.getRadius()), Long.valueOf(System.currentTimeMillis() / 1000L), paramBDLocation.getFloor() });
      }
      for (;;)
      {
        this.b.append("" + paramBDLocation);
        this.b.append(",");
        if (this.b.length() <= 700) {
          break;
        }
        c();
        return;
        if (paramBDLocation.getNetworkLocationType().equals("dr")) {
          paramBDLocation = String.format(Locale.CHINA, "%f|%f|%.1f|%d|%s|2", new Object[] { Double.valueOf(paramBDLocation.getLatitude()), Double.valueOf(paramBDLocation.getLongitude()), Float.valueOf(paramBDLocation.getRadius()), Long.valueOf(System.currentTimeMillis() / 1000L), paramBDLocation.getFloor() });
        } else {
          paramBDLocation = String.format(Locale.CHINA, "%f|%f|%.1f|%d|%s|0", new Object[] { Double.valueOf(paramBDLocation.getLatitude()), Double.valueOf(paramBDLocation.getLongitude()), Float.valueOf(paramBDLocation.getRadius()), Long.valueOf(System.currentTimeMillis() / 1000L), paramBDLocation.getFloor() });
        }
      }
      this.c.postDelayed(this.d, 30000L);
      this.e = true;
      return;
    }
    catch (Exception paramBDLocation) {}
  }
  
  void b()
  {
    if ((this.e) && (this.c != null))
    {
      this.c.removeCallbacks(this.d);
      this.d = null;
      this.e = false;
    }
    c();
  }
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      if (e.a(e.this))
      {
        e.b(e.this);
        e.a(e.this, false);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */