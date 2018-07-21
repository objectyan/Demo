package com.baidu.location.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.location.b.c;
import com.baidu.location.h.b;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class n
{
  private static final Charset j = Charset.forName("UTF-8");
  public Handler a = null;
  private Context b = null;
  private final long c = 300000L;
  private long d = 300000L;
  private h e = null;
  private c f = null;
  private boolean g = false;
  private HandlerThread h = null;
  private Looper i = null;
  private LocationManager k = null;
  private d l = null;
  private long m = 15L;
  private long n = 300000L;
  private boolean o = false;
  private long p = 0L;
  private boolean q = false;
  private e r = null;
  
  private n()
  {
    Log.i("TrafficCollectMan", "TrafficCollectMan object create");
    this.e = new h(null);
    this.f = new c(null);
    this.b = com.baidu.location.f.getServiceContext();
    this.h = new HandlerThread("TrafficCollectHandlerThread", 10);
    this.h.start();
    this.i = this.h.getLooper();
    this.a = new g(this.i);
  }
  
  public static n a()
  {
    return f.a;
  }
  
  private String a(float paramFloat)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
    localDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    return localDecimalFormat.format(paramFloat);
  }
  
  private void a(Location paramLocation)
  {
    if (c.e(this.f) == 0) {
      c.a(this.f, paramLocation);
    }
    while (Math.abs(paramLocation.getTime() - c.f(this.f)) < this.m * 1000L) {
      return;
    }
    c.a(this.f, paramLocation);
  }
  
  private void a(com.baidu.location.f.e parame)
  {
    if (parame == null) {}
    long l1;
    long l2;
    do
    {
      com.baidu.location.f.e locale;
      do
      {
        do
        {
          return;
        } while (parame.a() < 1);
        locale = h.d(this.e);
      } while (parame.c(locale));
      if (locale == null)
      {
        h.a(this.e, parame);
        return;
      }
      l1 = parame.h();
      l2 = h.e(this.e);
    } while (l1 - l2 < 60000L);
    if (l1 - l2 >= 600000L) {
      h.c(this.e);
    }
    h.a(this.e, parame);
  }
  
  private boolean a(String paramString, Context paramContext)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool4;
    label126:
    for (;;)
    {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        if (paramContext != null)
        {
          bool2 = bool4;
          paramContext = paramContext.iterator();
          bool2 = bool1;
          bool3 = bool1;
          if (paramContext.hasNext())
          {
            bool2 = bool1;
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            bool2 = bool1;
            if (!localRunningAppProcessInfo.processName.equals(paramString)) {
              break label126;
            }
            bool2 = bool1;
            int i1 = localRunningAppProcessInfo.importance;
            if ((i1 != 200) && (i1 != 100)) {
              break label126;
            }
            bool1 = true;
            continue;
          }
        }
        return bool3;
      }
      catch (Exception paramString)
      {
        bool3 = bool2;
      }
    }
  }
  
  private static String b(String paramString)
  {
    int i4 = 0;
    if (paramString == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[10];
    byte[] tmp17_15 = arrayOfByte;
    tmp17_15[0] = 48;
    byte[] tmp23_17 = tmp17_15;
    tmp23_17[1] = 49;
    byte[] tmp29_23 = tmp23_17;
    tmp29_23[2] = 50;
    byte[] tmp35_29 = tmp29_23;
    tmp35_29[3] = 51;
    byte[] tmp41_35 = tmp35_29;
    tmp41_35[4] = 52;
    byte[] tmp47_41 = tmp41_35;
    tmp47_41[5] = 53;
    byte[] tmp53_47 = tmp47_41;
    tmp53_47[6] = 54;
    byte[] tmp60_53 = tmp53_47;
    tmp60_53[7] = 55;
    byte[] tmp67_60 = tmp60_53;
    tmp67_60[8] = 56;
    byte[] tmp74_67 = tmp67_60;
    tmp74_67[9] = 57;
    tmp74_67;
    paramString = paramString.getBytes(j);
    int i1 = arrayOfByte[((byte)new java.util.Random().nextInt(10))];
    int i2 = arrayOfByte[((byte)new java.util.Random().nextInt(10))];
    arrayOfByte = new byte[paramString.length + 2];
    int i5 = paramString.length;
    int i3 = 0;
    while (i4 < i5)
    {
      arrayOfByte[i3] = ((byte)(paramString[i4] ^ i1));
      i4 += 1;
      i3 += 1;
    }
    i4 = i3 + 1;
    arrayOfByte[i3] = i1;
    arrayOfByte[i4] = i2;
    return new String(arrayOfByte);
  }
  
  private void d()
  {
    this.d = this.n;
    this.a.obtainMessage(1).sendToTarget();
  }
  
  private void e()
  {
    try
    {
      if ((this.a != null) && (this.r != null))
      {
        this.a.postDelayed(this.r, this.d);
        this.q = true;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b()
  {
    if (this.r == null) {
      this.r = new e(null);
    }
    this.a.postDelayed(this.r, 1000L);
    this.q = true;
    this.g = true;
    this.b = com.baidu.location.f.getServiceContext();
    try
    {
      this.k = ((LocationManager)this.b.getSystemService("location"));
      this.l = new d(null);
      this.k.requestLocationUpdates("passive", 5000L, 0.0F, this.l);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void c()
  {
    if ((this.q) && (this.a != null)) {}
    try
    {
      this.a.removeCallbacks(this.r);
      this.q = false;
      this.g = false;
      this.o = false;
      try
      {
        this.k.removeUpdates(this.l);
        this.k = null;
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  private class a
    extends com.baidu.location.h.e
  {
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = null;
    
    public a(String paramString1, String paramString2)
    {
      this.b = n.a(paramString1);
      this.c = paramString2;
      this.d = n.a(b.a().a);
      this.e = n.a(b.a().b);
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = "http://itsdata.map.baidu.com/gps-wifi-collect/data_collect.php";
      this.k.put("type", n.a(this.c));
      this.k.put("im", this.d);
      this.k.put("cu", this.e);
      if (this.c.contains("gps")) {
        this.k.put("gps", this.b);
      }
      if (this.c.contains("wifi")) {
        this.k.put("wfh", this.b);
      }
    }
    
    public void a(boolean paramBoolean) {}
    
    public void b()
    {
      i();
    }
  }
  
  private class b
    extends com.baidu.location.h.e
  {
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = null;
    
    public b(double paramDouble1, double paramDouble2)
    {
      int i = (int)(paramDouble1 * 1000000.0D);
      paramDouble1 = (int)(paramDouble2 * 1000000.0D) / 1000000.0D;
      this.b = String.valueOf(i / 1000000.0D);
      this.c = String.valueOf(paramDouble1);
      this.d = "1";
      this.e = b.a().b;
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = "https://loc.map.baidu.com/cfgs/loc/gps";
      this.k.put("qt", "gps_pc");
      this.k.put("cuid", this.e);
      this.k.put("suit", this.d);
      this.k.put("x", this.c);
      this.k.put("y", this.b);
    }
    
    public void a(boolean paramBoolean)
    {
      if (paramBoolean) {
        try
        {
          JSONObject localJSONObject = new JSONObject(this.j);
          if (localJSONObject.has("gps_pc"))
          {
            localJSONObject = localJSONObject.getJSONObject("gps_pc");
            if (localJSONObject.has("enable"))
            {
              if (localJSONObject.getInt("enable") != 0) {
                break label110;
              }
              n.b(n.this, false);
            }
            for (;;)
            {
              if (localJSONObject.has("collect_freq_sec")) {
                n.b(n.this, localJSONObject.getLong("collect_freq_sec"));
              }
              if (!localJSONObject.has("pingback_freq_sec")) {
                break;
              }
              n.c(n.this, localJSONObject.getLong("pingback_freq_sec") * 1000L);
              return;
              label110:
              n.b(n.this, true);
            }
          }
          return;
        }
        catch (Exception localException) {}
      }
    }
    
    public void b()
    {
      c("https://loc.map.baidu.com/cfgs/loc/gps");
    }
  }
  
  private class c
  {
    private final ArrayDeque<Location> b = new ArrayDeque();
    
    private c() {}
    
    private long a()
    {
      if (this.b.size() == 0) {
        return 0L;
      }
      return ((Location)this.b.getLast()).getTime();
    }
    
    private void a(Location paramLocation)
    {
      if (this.b.size() >= 20) {
        this.b.removeFirst();
      }
      this.b.addLast(paramLocation);
    }
    
    private void b()
    {
      this.b.clear();
    }
    
    private boolean c()
    {
      return this.b.size() == 0;
    }
    
    private boolean d()
    {
      long l = System.currentTimeMillis();
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        if (Math.abs(((Location)localIterator.next()).getTime() - l) < 300000L) {
          return false;
        }
      }
      return true;
    }
    
    private int e()
    {
      return this.b.size();
    }
    
    private String f()
    {
      long l2 = System.currentTimeMillis();
      Iterator localIterator = this.b.iterator();
      Object localObject = null;
      long l1 = 0L;
      int i = 1;
      while (localIterator.hasNext())
      {
        Location localLocation = (Location)localIterator.next();
        if (Math.abs(localLocation.getTime() - l2) <= 300000L)
        {
          int j = (int)(localLocation.getLongitude() * 1000000.0D);
          int k = (int)(localLocation.getLatitude() * 1000000.0D);
          double d1 = j / 1000000.0D;
          double d2 = k / 1000000.0D;
          String str1 = n.a(n.this, localLocation.getSpeed());
          String str2 = n.a(n.this, localLocation.getBearing());
          if (i != 0)
          {
            str1 = String.valueOf(d1) + "|" + String.valueOf(d2) + "|" + str1 + "|" + str2 + "|" + String.valueOf(localLocation.getTime() / 1000L);
            l1 = localLocation.getTime() / 1000L;
            label218:
            if (i == 0) {
              break label321;
            }
            i = 0;
          }
          for (;;)
          {
            localObject = str1;
            break;
            str1 = String.valueOf(d1) + "|" + String.valueOf(d2) + "|" + str1 + "|" + str2 + "|" + String.valueOf(localLocation.getTime() / 1000L - l1);
            l1 = localLocation.getTime() / 1000L;
            break label218;
            label321:
            str1 = (String)localObject + ";" + str1;
          }
        }
      }
      return (String)localObject;
    }
  }
  
  private class d
    implements LocationListener
  {
    private d() {}
    
    public void onLocationChanged(Location paramLocation)
    {
      if (!n.a(n.this)) {}
      while ((paramLocation == null) || (!paramLocation.getProvider().contains("gps"))) {
        return;
      }
      Message localMessage = n.this.a.obtainMessage(51);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("traffic_gps", paramLocation);
      localMessage.setData(localBundle);
      localMessage.sendToTarget();
    }
    
    public void onProviderDisabled(String paramString) {}
    
    public void onProviderEnabled(String paramString) {}
    
    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  }
  
  private class e
    implements Runnable
  {
    private e() {}
    
    public void run()
    {
      if ((n.this.a != null) && (n.b(n.this))) {
        n.a(n.this, false);
      }
      try
      {
        n.this.a.sendEmptyMessage(0);
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  private static class f
  {
    public static final n a = new n(null);
  }
  
  private class g
    extends Handler
  {
    public g(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (!com.baidu.location.f.isServing) {}
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                switch (paramMessage.what)
                {
                default: 
                  return;
                case 0: 
                  try
                  {
                    n.c(n.this);
                    n.d(n.this);
                    return;
                  }
                  catch (Exception paramMessage)
                  {
                    paramMessage = paramMessage;
                    n.d(n.this);
                    return;
                  }
                  finally
                  {
                    paramMessage = finally;
                    n.d(n.this);
                    throw paramMessage;
                  }
                }
              } while ((!n.e(n.this)) || (n.a(n.this, b.d, com.baidu.location.f.getServiceContext())));
              paramMessage = n.c.a(n.f(n.this));
            } while (paramMessage == null);
            new n.a(n.this, paramMessage, "collect_gps").b();
            n.c.b(n.f(n.this));
            return;
            paramMessage = new com.baidu.location.f.e(com.baidu.location.f.f.a().p());
            n.a(n.this, paramMessage);
          } while ((n.a(n.this, b.d, com.baidu.location.f.getServiceContext())) || (!n.h.a(n.g(n.this))) || (!c.a().e()) || ((!n.c.c(n.f(n.this))) && (!n.c.d(n.f(n.this)))));
          paramMessage = n.h.b(n.g(n.this));
        } while (paramMessage == null);
        new n.a(n.this, paramMessage, "collect_wifi").b();
        n.h.c(n.g(n.this));
        return;
        paramMessage = (Location)paramMessage.getData().getParcelable("traffic_gps");
        if (Math.abs(System.currentTimeMillis() - n.h(n.this)) / 3600000L > 12L)
        {
          new n.b(n.this, paramMessage.getLatitude(), paramMessage.getLongitude()).b();
          n.a(n.this, System.currentTimeMillis());
        }
      } while (!n.e(n.this));
      n.a(n.this, paramMessage);
    }
  }
  
  private class h
  {
    private final ArrayDeque<com.baidu.location.f.e> b = new ArrayDeque();
    
    private h() {}
    
    private long a()
    {
      if (this.b.size() == 0) {
        return 0L;
      }
      return ((com.baidu.location.f.e)this.b.getLast()).h();
    }
    
    private void a(com.baidu.location.f.e parame)
    {
      if (this.b.size() >= 10) {
        this.b.removeFirst();
      }
      this.b.addLast(parame);
    }
    
    private com.baidu.location.f.e b()
    {
      if (this.b.size() == 0) {
        return null;
      }
      return (com.baidu.location.f.e)this.b.getLast();
    }
    
    private void c()
    {
      this.b.clear();
    }
    
    private boolean d()
    {
      return this.b.size() == 10;
    }
    
    private String e()
    {
      int i = 1;
      Iterator localIterator = this.b.iterator();
      String str = null;
      if (localIterator.hasNext())
      {
        com.baidu.location.f.e locale = (com.baidu.location.f.e)localIterator.next();
        if (i != 0)
        {
          str = locale.d(5);
          i = 0;
        }
        for (;;)
        {
          break;
          str = str + "@" + locale.d(5);
        }
      }
      return str;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */