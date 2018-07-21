package com.baidu.location.c;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Time;
import com.baidu.location.Jni;
import com.baidu.location.a.m;
import com.baidu.location.f.b;
import com.baidu.location.f.d;
import com.baidu.location.f.e;
import com.baidu.location.h.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
{
  private static volatile c n = null;
  b a = null;
  long b = 0L;
  private Context c = null;
  private Handler d = null;
  private final int e = 1;
  private boolean f = false;
  private long g = 180000L;
  private long h = 60000L;
  private long i = 0L;
  private String j = "";
  private boolean k = false;
  private e l = null;
  private com.baidu.location.f.a m = null;
  private List<c> o = null;
  private long p = 4000L;
  private boolean q = false;
  private a r = new a(null);
  
  public c(Context paramContext)
  {
    this.c = paramContext;
    h();
  }
  
  public static c a()
  {
    if (n == null) {}
    try
    {
      if (n == null) {
        n = new c(com.baidu.location.f.getServiceContext());
      }
      return n;
    }
    finally {}
  }
  
  private void h()
  {
    Object localObject = a.b().c();
    if (localObject != null) {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("min")) {
          this.h = (((JSONObject)localObject).getInt("min") * 60 * 1000);
        }
        if (((JSONObject)localObject).has("max")) {
          this.g = (((JSONObject)localObject).getInt("max") * 60 * 1000);
        }
        if (((JSONObject)localObject).has("slot"))
        {
          localObject = ((JSONObject)localObject).getJSONArray("slot");
          int i2 = ((JSONArray)localObject).length();
          int i1 = 0;
          while (i1 < i2)
          {
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
            if ((localJSONObject.has("t1")) && (localJSONObject.has("t2")) && (localJSONObject.has("min")) && (localJSONObject.has("max")))
            {
              if (this.o == null) {
                this.o = new ArrayList();
              }
              this.o.add(new c(localJSONObject.getInt("min"), localJSONObject.getInt("max"), localJSONObject.getInt("t1"), localJSONObject.getInt("t2")));
            }
            i1 += 1;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private int i()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return localTime.hour;
  }
  
  private void j()
  {
    if ("trfk.dat" != null) {
      try
      {
        File localFile = new File(g.k() + File.separator + "trfk.dat");
        if (localFile != null)
        {
          if (!localFile.exists())
          {
            localFile.createNewFile();
            return;
          }
          localFile.delete();
          localFile.createNewFile();
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  private boolean k()
  {
    boolean bool2 = true;
    try
    {
      File localFile = new File(g.k() + File.separator + "trfk2.dat");
      boolean bool1 = bool2;
      if (localFile != null)
      {
        bool1 = bool2;
        if (localFile.exists())
        {
          long l1 = localFile.lastModified();
          long l2 = System.currentTimeMillis();
          l1 = l2 - l1;
          bool1 = bool2;
          if (l1 < 600000L)
          {
            bool1 = bool2;
            if (l1 > 0L) {
              bool1 = false;
            }
          }
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public void b()
  {
    if (this.f) {
      return;
    }
    this.b = 0L;
    try
    {
      this.a = new b();
      this.d = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          if (!com.baidu.location.f.isServing) {
            return;
          }
          switch (paramAnonymousMessage.what)
          {
          default: 
            return;
          }
          try
          {
            c.this.f();
            return;
          }
          catch (Exception paramAnonymousMessage) {}
        }
      };
      this.f = true;
      e();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.a = null;
      }
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 60	com/baidu/location/c/c:f	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 60	com/baidu/location/c/c:f	Z
    //   19: aload_0
    //   20: getfield 84	com/baidu/location/c/c:a	Lcom/baidu/location/c/c$b;
    //   23: ifnull +14 -> 37
    //   26: aload_0
    //   27: getfield 84	com/baidu/location/c/c:a	Lcom/baidu/location/c/c$b;
    //   30: aload_0
    //   31: getfield 54	com/baidu/location/c/c:c	Landroid/content/Context;
    //   34: invokevirtual 236	com/baidu/location/c/c$b:b	(Landroid/content/Context;)V
    //   37: aload_0
    //   38: getfield 56	com/baidu/location/c/c:d	Landroid/os/Handler;
    //   41: ifnull +11 -> 52
    //   44: aload_0
    //   45: getfield 56	com/baidu/location/c/c:d	Landroid/os/Handler;
    //   48: iconst_1
    //   49: invokevirtual 242	android/os/Handler:removeMessages	(I)V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 78	com/baidu/location/c/c:l	Lcom/baidu/location/f/e;
    //   57: aload_0
    //   58: lconst_0
    //   59: putfield 90	com/baidu/location/c/c:b	J
    //   62: aload_0
    //   63: lconst_0
    //   64: putfield 70	com/baidu/location/c/c:i	J
    //   67: aload_0
    //   68: ldc 72
    //   70: putfield 74	com/baidu/location/c/c:j	Ljava/lang/String;
    //   73: aload_0
    //   74: iconst_0
    //   75: putfield 76	com/baidu/location/c/c:k	Z
    //   78: goto -67 -> 11
    //   81: astore_2
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_2
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	c
    //   6	2	1	bool	boolean
    //   81	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	81	finally
    //   14	37	81	finally
    //   37	52	81	finally
    //   52	78	81	finally
  }
  
  public void d()
  {
    try
    {
      if (this.d != null) {
        this.d.sendEmptyMessageDelayed(1, 2000L + this.p);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void e()
  {
    if ((com.baidu.location.f.f.j()) && (this.d != null) && (!this.q)) {
      this.d.postDelayed(this.r, 5000L + this.p);
    }
  }
  
  void f()
  {
    if (!this.f) {}
    long l1;
    Object localObject1;
    e locale;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            l1 = 0L;
            if ((this.o != null) && (this.o.size() > 0))
            {
              i1 = i();
              localObject1 = this.o.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (c)((Iterator)localObject1).next();
                if ((i1 >= ((c)localObject2).c) && (i1 < ((c)localObject2).d))
                {
                  this.h = (((c)localObject2).b * 60L * 1000L);
                  this.g = (((c)localObject2).a * 60L * 1000L);
                }
              }
            }
            if (this.i == 0L) {
              break;
            }
            l1 = System.currentTimeMillis() - this.i;
          } while (l1 <= this.h);
          this.i = System.currentTimeMillis();
        } while (g.m() == null);
        localObject1 = b.a().f();
      } while ((localObject1 == null) || (!((com.baidu.location.f.a)localObject1).e()));
      locale = com.baidu.location.f.f.a().q();
    } while ((locale == null) || ((locale.a != null) && (locale.a.size() < 1)));
    int i1 = 0;
    if (this.b == 0L) {
      i1 = 1;
    }
    if (this.l == null) {
      this.l = new e(locale);
    }
    if (this.m == null) {
      this.m = new com.baidu.location.f.a((com.baidu.location.f.a)localObject1);
    }
    boolean bool1 = this.l.d(locale);
    boolean bool2 = this.m.a((com.baidu.location.f.a)localObject1);
    if (this.l != null)
    {
      this.l = null;
      this.l = new e(locale);
    }
    if (this.m != null)
    {
      this.m = null;
      this.m = new com.baidu.location.f.a((com.baidu.location.f.a)localObject1);
    }
    StringBuffer localStringBuffer = new StringBuffer(200);
    if (i1 != 0) {
      localStringBuffer.append("s");
    }
    localStringBuffer.append("v");
    localStringBuffer.append(7);
    i1 = (int)(System.currentTimeMillis() >> 15);
    localStringBuffer.append("t");
    localStringBuffer.append(i1);
    if (((com.baidu.location.f.a)localObject1).b())
    {
      if (((com.baidu.location.f.a)localObject1).c == 460)
      {
        localStringBuffer.append("x,");
        localStringBuffer.append(((com.baidu.location.f.a)localObject1).d);
        localStringBuffer.append(",");
        localStringBuffer.append(((com.baidu.location.f.a)localObject1).a);
        localStringBuffer.append(",");
        localStringBuffer.append(((com.baidu.location.f.a)localObject1).b);
      }
    }
    else
    {
      localObject1 = com.baidu.location.f.f.a().l();
      if (localObject1 == null) {
        break label1212;
      }
    }
    label691:
    label848:
    label883:
    label1141:
    label1153:
    label1183:
    label1186:
    label1212:
    for (Object localObject2 = ((WifiInfo)localObject1).getBSSID().replace(":", "");; localObject2 = null)
    {
      i1 = 0;
      int i2 = 0;
      localObject1 = null;
      int i3;
      if ((locale != null) && (locale.a != null))
      {
        int i4 = 0;
        for (;;)
        {
          if (i4 < locale.a.size())
          {
            String str2 = ((ScanResult)locale.a.get(i4)).BSSID.replace(":", "");
            int i5 = ((ScanResult)locale.a.get(i4)).level;
            if (i5 < 0)
            {
              i5 = -i5;
              if (i1 < 15)
              {
                if ((i4 >= 2) && (i2 == 0) && (localObject2 != null) && (!((String)localObject2).equals(str2)))
                {
                  if (localObject1 != null) {
                    break label1186;
                  }
                  localObject1 = "," + str2 + ";" + i5;
                  i3 = i2;
                  i2 = i1;
                  i1 = i3;
                  i4 += 1;
                  i3 = i2;
                  i2 = i1;
                  i1 = i3;
                  continue;
                  localStringBuffer.append("x");
                  localStringBuffer.append(((com.baidu.location.f.a)localObject1).c);
                  localStringBuffer.append(",");
                  break;
                }
                if (i4 == 0)
                {
                  localStringBuffer.append("w");
                  localStringBuffer.append(str2);
                  i3 = i2;
                  if (localObject2 != null)
                  {
                    i3 = i2;
                    if (((String)localObject2).equals(str2))
                    {
                      str2 = ((ScanResult)locale.a.get(i4)).capabilities;
                      if (TextUtils.isEmpty(str2)) {
                        break label1153;
                      }
                      str2 = str2.toUpperCase(Locale.CHINA);
                      if ((!str2.contains("WEP")) && (!str2.contains("WPA"))) {
                        break label1141;
                      }
                      localStringBuffer.append("l");
                      i3 = 1;
                    }
                  }
                  localStringBuffer.append(";" + i5);
                  i2 = i1 + 1;
                  i1 = i3;
                  if (i2 <= 15) {
                    break label1183;
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if ((i2 < 15) && (localObject1 != null)) {
          localStringBuffer.append((String)localObject1);
        }
        for (;;)
        {
          try
          {
            if (!g()) {
              continue;
            }
            localObject1 = "y2";
          }
          catch (Exception localException)
          {
            long l2;
            String str1 = "y";
            continue;
          }
          localObject2 = localObject1;
          if (com.baidu.location.b.c.a().d() != null) {
            localObject2 = (String)localObject1 + com.baidu.location.b.c.a().d();
          }
          localStringBuffer.append((String)localObject2);
          if (this.k)
          {
            if (l1 > 0L)
            {
              l1 /= 60000L;
              this.j = ("r" + l1);
              localStringBuffer.append(this.j);
              this.j = "";
            }
            this.k = false;
          }
          j();
          i1 = 1;
          if (!k()) {
            i1 = 0;
          }
          if ((i1 != 0) && (!d.a().m()))
          {
            l1 = System.currentTimeMillis();
            l2 = this.b;
            if (((bool2) || (bool1)) && (l1 - l2 >= this.g - 5000L))
            {
              a.b().a(Jni.encodeOfflineLocationUpdateRequest(localStringBuffer.toString()));
              this.b = System.currentTimeMillis();
            }
          }
          m.a().c();
          return;
          localStringBuffer.append(",");
          break;
          localStringBuffer.append("j");
          break label848;
          localStringBuffer.append("j");
          break label848;
          localObject1 = "y1";
        }
        break label691;
        i3 = i1;
        i1 = i2;
        i2 = i3;
        break label691;
        i3 = i1;
        i1 = i2;
        i2 = i3;
        break label883;
        break;
        i2 = i1;
      }
    }
  }
  
  public boolean g()
  {
    return ((KeyguardManager)this.c.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      if ((c.a(c.this)) && (com.baidu.location.f.f.j()))
      {
        c.a(c.this, true);
        c.this.d();
        if (c.b(c.this) != null) {
          c.b(c.this).postDelayed(this, c.c(c.this) + c.d(c.this));
        }
        return;
      }
      c.a(c.this, false);
    }
  }
  
  class b
    extends BroadcastReceiver
  {
    boolean a = false;
    long b = 0L;
    
    public b()
    {
      a(com.baidu.location.f.getServiceContext());
    }
    
    public void a(Context paramContext)
    {
      if (!this.a)
      {
        this.a = true;
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.USER_PRESENT");
        paramContext.registerReceiver(this, localIntentFilter);
      }
    }
    
    public void b(Context paramContext)
    {
      if (this.a)
      {
        paramContext.unregisterReceiver(this);
        this.a = false;
      }
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent.getAction().equals("android.intent.action.USER_PRESENT")) && (System.currentTimeMillis() - this.b > 1000L) && (c.b(c.this) != null))
      {
        this.b = System.currentTimeMillis();
        c.b(c.this).sendEmptyMessageDelayed(1, 2000L);
      }
    }
  }
  
  private class c
  {
    public long a = 0L;
    public long b = 0L;
    public int c = 0;
    public int d = 0;
    
    c(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
    {
      this.a = paramLong2;
      this.b = paramLong1;
      this.d = paramInt2;
      this.c = paramInt1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */