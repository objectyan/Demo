package com.baidu.location.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.a.a;
import com.baidu.location.a.h;
import com.baidu.location.a.k;
import com.baidu.location.a.m;
import com.baidu.location.c.b;
import com.baidu.location.c.c;
import com.baidu.location.indoor.d;
import com.baidu.location.indoor.d.e;
import com.baidu.location.wifihistory.SClient;
import java.util.LinkedList;
import java.util.List;

public class f
{
  public static long a = 0L;
  private static f b = null;
  private WifiManager c = null;
  private a d = null;
  private e e = null;
  private long f = 0L;
  private long g = 0L;
  private boolean h = false;
  private Handler i = new Handler();
  private long j = 0L;
  private long k = 0L;
  
  public static f a()
  {
    try
    {
      if (b == null) {
        b = new f();
      }
      f localf = b;
      return localf;
    }
    finally {}
  }
  
  public static boolean a(e parame1, e parame2)
  {
    return a(parame1, parame2, 0.7F);
  }
  
  public static boolean a(e parame1, e parame2, float paramFloat)
  {
    if ((parame1 == null) || (parame2 == null)) {
      return false;
    }
    parame1 = parame1.a;
    parame2 = parame2.a;
    if (parame1 == parame2) {
      return true;
    }
    if ((parame1 == null) || (parame2 == null)) {
      return false;
    }
    LinkedList localLinkedList = new LinkedList();
    int i2 = parame1.size();
    int i3 = parame2.size();
    if ((i2 == 0) && (i3 == 0)) {
      return true;
    }
    if ((i2 == 0) || (i3 == 0)) {
      return false;
    }
    int m = 0;
    long l = 0L;
    int n = 0;
    int i1;
    for (;;)
    {
      if (n < i2)
      {
        String str = ((ScanResult)parame1.get(n)).BSSID;
        if (str == null)
        {
          n += 1;
        }
        else
        {
          i1 = 0;
          label135:
          if (i1 >= i3) {
            break label353;
          }
          if (str.equals(((ScanResult)parame2.get(i1)).BSSID))
          {
            m += 1;
            int i4 = ((ScanResult)parame1.get(n)).level;
            int i5 = ((ScanResult)parame2.get(i1)).level;
            l += (((ScanResult)parame1.get(n)).level - ((ScanResult)parame2.get(i1)).level) * (i4 - i5);
          }
        }
      }
    }
    label353:
    for (;;)
    {
      if (i1 == i3)
      {
        localLinkedList.add(parame1.get(n));
        i1 = ((ScanResult)parame1.get(n)).level;
        l = (((ScanResult)parame1.get(n)).level + 100) * (i1 + 100) + l;
        break;
        i1 += 1;
        break label135;
        double d1 = Math.sqrt(l) / i2;
        return m >= i2 * paramFloat;
      }
      break;
    }
  }
  
  public static boolean a(List<ScanResult> paramList1, List<ScanResult> paramList2, float paramFloat)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return false;
    }
    if (paramList1 == paramList2) {
      return true;
    }
    if ((paramList1 == null) || (paramList2 == null)) {
      return false;
    }
    int i2 = paramList1.size();
    int i3 = paramList2.size();
    float f1 = i2 + i3;
    if ((i2 == 0) && (i3 == 0)) {
      return true;
    }
    if ((i2 == 0) || (i3 == 0)) {
      return false;
    }
    int n = 0;
    int m = 0;
    String str;
    if (n < i2)
    {
      str = ((ScanResult)paramList1.get(n)).BSSID;
      if (str != null) {}
    }
    for (;;)
    {
      n += 1;
      break;
      int i1 = 0;
      for (;;)
      {
        if (i1 < i3)
        {
          if (str.equals(((ScanResult)paramList2.get(i1)).BSSID))
          {
            m += 1;
            break;
          }
          i1 += 1;
          continue;
          return m * 2 >= f1 * paramFloat;
        }
      }
    }
  }
  
  private String b(long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(String.valueOf((int)(paramLong & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 8 & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 16 & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 24 & 0xFF)));
    return localStringBuffer.toString();
  }
  
  public static boolean j()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)com.baidu.location.f.getServiceContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        int m = localNetworkInfo.getType();
        if (m == 1) {
          return true;
        }
      }
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private void v()
  {
    if (this.c == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = this.c.getScanResults();
        if (localObject != null)
        {
          localObject = new e((List)localObject, System.currentTimeMillis());
          if ((this.e == null) || (!((e)localObject).a(this.e)))
          {
            this.e = ((e)localObject);
            SClient.getInstance().updateWifiHistory(this.e.a);
            return;
          }
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public void a(int paramInt)
  {
    this.j += paramInt;
    if (this.j > 9000L) {
      this.j = 9000L;
    }
  }
  
  public boolean a(long paramLong)
  {
    try
    {
      if ((this.c.isWifiEnabled()) || ((Build.VERSION.SDK_INT > 17) && (this.c.isScanAlwaysAvailable())))
      {
        if (j()) {
          return false;
        }
        e locale = new e(this.c.getScanResults(), 0L);
        if (locale != null)
        {
          boolean bool = locale.a(paramLong);
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    catch (NoSuchMethodError localNoSuchMethodError) {}
    return false;
  }
  
  public void b()
  {
    this.j = 0L;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/baidu/location/f/f:h	Z
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_1
    //   9: if_icmpne +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: getstatic 219	com/baidu/location/f:isServing	Z
    //   18: ifeq -6 -> 12
    //   21: aload_0
    //   22: invokestatic 148	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   25: invokevirtual 222	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   28: ldc -32
    //   30: invokevirtual 156	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   33: checkcast 169	android/net/wifi/WifiManager
    //   36: putfield 40	com/baidu/location/f/f:c	Landroid/net/wifi/WifiManager;
    //   39: aload_0
    //   40: new 8	com/baidu/location/f/f$a
    //   43: dup
    //   44: aload_0
    //   45: aconst_null
    //   46: invokespecial 227	com/baidu/location/f/f$a:<init>	(Lcom/baidu/location/f/f;Lcom/baidu/location/f/f$1;)V
    //   49: putfield 42	com/baidu/location/f/f:d	Lcom/baidu/location/f/f$a;
    //   52: invokestatic 148	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   55: aload_0
    //   56: getfield 42	com/baidu/location/f/f:d	Lcom/baidu/location/f/f$a;
    //   59: new 229	android/content/IntentFilter
    //   62: dup
    //   63: ldc -25
    //   65: invokespecial 234	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   68: invokevirtual 238	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   71: pop
    //   72: invokestatic 148	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   75: aload_0
    //   76: getfield 42	com/baidu/location/f/f:d	Lcom/baidu/location/f/f$a;
    //   79: new 229	android/content/IntentFilter
    //   82: dup
    //   83: ldc -16
    //   85: invokespecial 234	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   88: invokevirtual 238	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   91: pop
    //   92: aload_0
    //   93: iconst_1
    //   94: putfield 50	com/baidu/location/f/f:h	Z
    //   97: goto -85 -> 12
    //   100: astore_2
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_2
    //   104: athrow
    //   105: astore_2
    //   106: goto -14 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	f
    //   6	4	1	bool	boolean
    //   100	4	2	localObject	Object
    //   105	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	7	100	finally
    //   15	52	100	finally
    //   52	92	100	finally
    //   92	97	100	finally
    //   52	92	105	java/lang/Exception
  }
  
  public List<WifiConfiguration> d()
  {
    List localList = null;
    try
    {
      if (this.c != null) {
        localList = this.c.getConfiguredNetworks();
      }
      return localList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/baidu/location/f/f:h	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 148	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   17: aload_0
    //   18: getfield 42	com/baidu/location/f/f:d	Lcom/baidu/location/f/f$a;
    //   21: invokevirtual 251	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   24: lconst_0
    //   25: putstatic 34	com/baidu/location/f/f:a	J
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 42	com/baidu/location/f/f:d	Lcom/baidu/location/f/f$a;
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 40	com/baidu/location/f/f:c	Landroid/net/wifi/WifiManager;
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 50	com/baidu/location/f/f:h	Z
    //   43: goto -32 -> 11
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    //   51: astore_2
    //   52: goto -24 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	f
    //   6	2	1	bool	boolean
    //   46	4	2	localObject	Object
    //   51	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	7	46	finally
    //   14	28	46	finally
    //   28	43	46	finally
    //   14	28	51	java/lang/Exception
  }
  
  public boolean f()
  {
    long l = System.currentTimeMillis();
    if ((l - this.g > 0L) && (l - this.g <= 5000L)) {
      return false;
    }
    this.g = l;
    b();
    return g();
  }
  
  public boolean g()
  {
    if (this.c == null) {}
    long l;
    do
    {
      return false;
      l = System.currentTimeMillis();
    } while ((l - this.f > 0L) && ((l - this.f <= this.j + 5000L) || (l - a * 1000L <= this.j + 5000L) || ((j()) && (l - this.f <= 10000L + this.j))));
    return i();
  }
  
  public String h()
  {
    String str2 = "";
    String str1 = str2;
    if (this.c != null) {}
    try
    {
      if (!this.c.isWifiEnabled())
      {
        str1 = str2;
        if (Build.VERSION.SDK_INT > 17)
        {
          str1 = str2;
          if (!this.c.isScanAlwaysAvailable()) {}
        }
      }
      else
      {
        str1 = "&wifio=1";
      }
      return str1;
    }
    catch (Exception localException)
    {
      return "";
    }
    catch (NoSuchMethodError localNoSuchMethodError) {}
    return "";
  }
  
  public boolean i()
  {
    long l = System.currentTimeMillis() - this.k;
    if ((l >= 0L) && (l <= 2000L)) {}
    for (;;)
    {
      return false;
      this.k = System.currentTimeMillis();
      try
      {
        if ((this.c.isWifiEnabled()) || ((Build.VERSION.SDK_INT > 17) && (this.c.isScanAlwaysAvailable())))
        {
          this.c.startScan();
          this.f = System.currentTimeMillis();
          return true;
        }
      }
      catch (Exception localException)
      {
        return false;
      }
      catch (NoSuchMethodError localNoSuchMethodError) {}
    }
    return false;
  }
  
  public boolean k()
  {
    try
    {
      if ((this.c.isWifiEnabled()) || ((Build.VERSION.SDK_INT > 17) && (this.c.isScanAlwaysAvailable())))
      {
        if (j()) {
          return false;
        }
        e locale = new e(this.c.getScanResults(), 0L);
        if (locale != null)
        {
          boolean bool = locale.e();
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    catch (NoSuchMethodError localNoSuchMethodError) {}
    return false;
  }
  
  public WifiInfo l()
  {
    if (this.c == null) {}
    for (;;)
    {
      return null;
      try
      {
        WifiInfo localWifiInfo = this.c.getConnectionInfo();
        if ((localWifiInfo != null) && (localWifiInfo.getBSSID() != null) && (localWifiInfo.getRssi() > -100))
        {
          String str = localWifiInfo.getBSSID();
          if (str != null)
          {
            str = str.replace(":", "");
            if (!"000000000000".equals(str))
            {
              boolean bool = "".equals(str);
              if (bool) {}
            }
          }
          else
          {
            return localWifiInfo;
          }
        }
      }
      catch (Error localError)
      {
        return null;
      }
      catch (Exception localException) {}
    }
    return null;
  }
  
  public String m()
  {
    String str2 = null;
    StringBuffer localStringBuffer = new StringBuffer();
    WifiInfo localWifiInfo = a().l();
    String str1 = str2;
    if (localWifiInfo != null)
    {
      str1 = str2;
      if (localWifiInfo.getBSSID() != null)
      {
        String str4 = localWifiInfo.getBSSID().replace(":", "");
        int n = localWifiInfo.getRssi();
        String str3 = a().n();
        int m = n;
        if (n < 0) {
          m = -n;
        }
        str1 = str2;
        if (str4 != null)
        {
          str1 = str2;
          if (m < 100)
          {
            localStringBuffer.append("&wf=");
            localStringBuffer.append(str4);
            localStringBuffer.append(";");
            localStringBuffer.append("" + m + ";");
            str2 = localWifiInfo.getSSID();
            str1 = str2;
            if (str2 != null) {
              if (!str2.contains("&"))
              {
                str1 = str2;
                if (!str2.contains(";")) {}
              }
              else
              {
                str1 = str2.replace("&", "_");
              }
            }
            localStringBuffer.append(str1);
            localStringBuffer.append("&wf_n=1");
            if (str3 != null)
            {
              localStringBuffer.append("&wf_gw=");
              localStringBuffer.append(str3);
            }
            str1 = localStringBuffer.toString();
          }
        }
      }
    }
    return str1;
  }
  
  public String n()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.c != null)
    {
      DhcpInfo localDhcpInfo = this.c.getDhcpInfo();
      localObject1 = localObject2;
      if (localDhcpInfo != null) {
        localObject1 = b(localDhcpInfo.gateway);
      }
    }
    return (String)localObject1;
  }
  
  public boolean o()
  {
    if (this.c == null) {
      return false;
    }
    try
    {
      boolean bool = this.c.isScanAlwaysAvailable();
      return bool;
    }
    catch (NoSuchMethodError localNoSuchMethodError) {}
    return false;
  }
  
  public e p()
  {
    if ((this.e == null) || (!this.e.l())) {
      return r();
    }
    return this.e;
  }
  
  public e q()
  {
    if ((this.e == null) || (!this.e.m())) {
      return r();
    }
    return this.e;
  }
  
  public e r()
  {
    if (this.c != null) {
      try
      {
        e locale = new e(this.c.getScanResults(), this.f);
        return locale;
      }
      catch (Exception localException) {}
    }
    return new e(null, 0L);
  }
  
  public void s()
  {
    if (com.baidu.location.d.a.e.a().a)
    {
      StringBuffer localStringBuffer = new StringBuffer(1024);
      localStringBuffer.append("W");
      localStringBuffer.append("\t");
      localStringBuffer.append(q().a(52));
      localStringBuffer.append("\n");
      com.baidu.location.d.a.e.a().a(localStringBuffer);
      i();
    }
  }
  
  public boolean t()
  {
    boolean bool2 = false;
    try
    {
      boolean bool1;
      if (!this.c.isWifiEnabled())
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT > 17)
        {
          boolean bool3 = this.c.isScanAlwaysAvailable();
          bool1 = bool2;
          if (!bool3) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException)
    {
      return false;
    }
    catch (NoSuchMethodError localNoSuchMethodError) {}
    return false;
  }
  
  public String u()
  {
    String str = null;
    try
    {
      WifiInfo localWifiInfo = this.c.getConnectionInfo();
      if (localWifiInfo != null) {
        str = localWifiInfo.getMacAddress();
      }
      return str;
    }
    catch (Error localError)
    {
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private class a
    extends BroadcastReceiver
  {
    private long b = 0L;
    private boolean c = false;
    
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramContext == null) {}
      do
      {
        do
        {
          do
          {
            return;
            paramContext = paramIntent.getAction();
            if (!paramContext.equals("android.net.wifi.SCAN_RESULTS")) {
              break;
            }
            f.a = System.currentTimeMillis() / 1000L;
            f.a(f.this);
            c.a().d();
            h.c().j();
            if (d.a().f()) {
              d.a().c.obtainMessage(41).sendToTarget();
            }
            f.this.s();
          } while (System.currentTimeMillis() - k.b() > 5000L);
          m.a(k.c(), f.this.p(), k.d(), k.a());
          return;
        } while ((!paramContext.equals("android.net.wifi.STATE_CHANGE")) || (!((NetworkInfo)paramIntent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED)) || (System.currentTimeMillis() - this.b < 5000L));
        this.b = System.currentTimeMillis();
        if (!this.c)
        {
          this.c = true;
          return;
        }
        c.a().e();
        if (a.a().c()) {
          b.a().b();
        }
      } while ((a.a().c()) || (f.b(f.this) == null));
      f.c(f.this).postDelayed(new Runnable()
      {
        public void run()
        {
          if (f.b(f.this) != null) {}
          try
          {
            f.b(f.this).getConnectionInfo();
            if (0 != 0) {
              throw new NullPointerException();
            }
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;) {}
          }
        }
      }, 1000L);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */