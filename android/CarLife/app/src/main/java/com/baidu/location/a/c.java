package com.baidu.location.a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.h.e;
import com.baidu.location.h.g;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class c
{
  private static Method g = null;
  private static Method h = null;
  private static Method i = null;
  private static Method j = null;
  private static Method k = null;
  private static Class<?> l = null;
  String a = null;
  String b = null;
  c c = new c();
  private Context d = null;
  private TelephonyManager e = null;
  private a f = new a(null);
  private WifiManager m = null;
  private d n = null;
  private String o = null;
  private LocationClientOption p;
  private b q;
  private String r = null;
  private String s = null;
  private String t = null;
  
  public c(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
    try
    {
      this.e = ((TelephonyManager)this.d.getSystemService("phone"));
      this.m = ((WifiManager)this.d.getApplicationContext().getSystemService("wifi"));
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  private String a(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 3) {
      i1 = 3;
    }
    try
    {
      a(this.e.getCellLocation());
      str1 = this.f.a();
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          String str1;
          this.n = null;
          this.n = new d(this.m.getScanResults());
          String str3 = this.n.a(i1);
          if ((str1 != null) || (str3 != null)) {
            break;
          }
          this.r = null;
          return null;
          localException1 = localException1;
          str2 = null;
        }
      }
      catch (Exception localException2)
      {
        String str5;
        do
        {
          String str2;
          String str4;
          for (;;)
          {
            str4 = null;
          }
          str5 = str2;
          if (str4 != null) {
            str5 = str2 + str4;
          }
        } while (str5 == null);
        this.r = str5;
        if (this.o != null) {
          this.r += this.o;
        }
        return str5 + this.o;
      }
    }
  }
  
  private void a(CellLocation paramCellLocation)
  {
    int i2 = 0;
    int i3 = 0;
    if ((paramCellLocation == null) || (this.e == null)) {
      return;
    }
    a locala = new a(null);
    Object localObject = this.e.getNetworkOperator();
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    try
    {
      if (((String)localObject).length() >= 3)
      {
        int i4 = Integer.valueOf(((String)localObject).substring(0, 3)).intValue();
        i1 = i4;
        if (i4 < 0) {
          i1 = this.f.c;
        }
        locala.c = i1;
      }
      localObject = ((String)localObject).substring(3);
      if (localObject != null)
      {
        char[] arrayOfChar = ((String)localObject).toCharArray();
        i1 = i3;
        i2 = i1;
        if (i1 < arrayOfChar.length)
        {
          if (Character.isDigit(arrayOfChar[i1])) {
            break label227;
          }
          i2 = i1;
        }
      }
      i2 = Integer.valueOf(((String)localObject).substring(0, i2)).intValue();
      i1 = i2;
      if (i2 < 0) {
        i1 = this.f.d;
      }
      locala.d = i1;
    }
    catch (Exception localException)
    {
      int i1;
      for (;;) {}
    }
    if ((paramCellLocation instanceof GsmCellLocation))
    {
      locala.a = ((GsmCellLocation)paramCellLocation).getLac();
      locala.b = ((GsmCellLocation)paramCellLocation).getCid();
      locala.g = 'g';
    }
    for (;;)
    {
      if (a.a(locala))
      {
        this.f = locala;
        return;
        label227:
        i1 += 1;
        break;
        if (!(paramCellLocation instanceof CdmaCellLocation)) {
          continue;
        }
        locala.g = 'c';
        if (l == null) {}
        try
        {
          l = Class.forName("android.telephony.cdma.CdmaCellLocation");
          g = l.getMethod("getBaseStationId", new Class[0]);
          h = l.getMethod("getNetworkId", new Class[0]);
          i = l.getMethod("getSystemId", new Class[0]);
          j = l.getMethod("getBaseStationLatitude", new Class[0]);
          k = l.getMethod("getBaseStationLongitude", new Class[0]);
          if ((l != null) && (l.isInstance(paramCellLocation)))
          {
            try
            {
              i2 = ((Integer)i.invoke(paramCellLocation, new Object[0])).intValue();
              i1 = i2;
              if (i2 < 0) {
                i1 = this.f.d;
              }
              locala.d = i1;
              locala.b = ((Integer)g.invoke(paramCellLocation, new Object[0])).intValue();
              locala.a = ((Integer)h.invoke(paramCellLocation, new Object[0])).intValue();
              localObject = j.invoke(paramCellLocation, new Object[0]);
              if (((Integer)localObject).intValue() < Integer.MAX_VALUE) {
                locala.e = ((Integer)localObject).intValue();
              }
              paramCellLocation = k.invoke(paramCellLocation, new Object[0]);
              if (((Integer)paramCellLocation).intValue() >= Integer.MAX_VALUE) {
                continue;
              }
              locala.f = ((Integer)paramCellLocation).intValue();
            }
            catch (Exception paramCellLocation)
            {
              return;
            }
            this.f = null;
          }
        }
        catch (Exception paramCellLocation)
        {
          l = null;
          return;
        }
      }
    }
  }
  
  public String a()
  {
    try
    {
      String str = a(15);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private class a
  {
    public int a = -1;
    public int b = -1;
    public int c = -1;
    public int d = -1;
    public int e = Integer.MAX_VALUE;
    public int f = Integer.MAX_VALUE;
    public char g = '\000';
    
    private a() {}
    
    private boolean b()
    {
      return (this.a > -1) && (this.b > 0);
    }
    
    public String a()
    {
      if (!b()) {
        return null;
      }
      StringBuffer localStringBuffer = new StringBuffer(128);
      localStringBuffer.append("&nw=");
      localStringBuffer.append(this.g);
      localStringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b) }));
      if ((this.e < Integer.MAX_VALUE) && (this.f < Integer.MAX_VALUE)) {
        localStringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", new Object[] { Double.valueOf(this.f / 14400.0D), Double.valueOf(this.e / 14400.0D) }));
      }
      return localStringBuffer.toString();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(BDLocation paramBDLocation);
  }
  
  class c
    extends e
  {
    String a = null;
    
    c()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = g.e();
      String str = Jni.encodeTp4(this.a);
      this.a = null;
      this.k.put("bloc", str);
      str = String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      this.k.put("trtm", str);
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.j != null)) {}
      for (;;)
      {
        try
        {
          localObject = this.j;
        }
        catch (Exception localException2)
        {
          Object localObject;
          BDLocation localBDLocation;
          continue;
        }
        try
        {
          localObject = new BDLocation((String)localObject);
          if ((localObject != null) && (((BDLocation)localObject).getLocType() == 161))
          {
            ((BDLocation)localObject).setCoorType(c.a(c.this).coorType);
            ((BDLocation)localObject).setLocationID(Jni.en1(c.this.a + ";" + c.this.b + ";" + ((BDLocation)localObject).getTime()));
            c.b(c.this).a((BDLocation)localObject);
          }
          if (this.k != null) {
            this.k.clear();
          }
          return;
        }
        catch (Exception localException1)
        {
          localBDLocation = new BDLocation();
          localBDLocation.setLocType(63);
        }
      }
    }
  }
  
  protected class d
  {
    public List<ScanResult> a = null;
    private long c = 0L;
    
    public d()
    {
      List localList;
      this.a = localList;
      this.c = System.currentTimeMillis();
      c();
    }
    
    private String b()
    {
      Object localObject1 = c.c(c.this).getConnectionInfo();
      if (localObject1 == null) {
        return null;
      }
      for (;;)
      {
        try
        {
          localObject1 = ((WifiInfo)localObject1).getBSSID();
          if (localObject1 != null)
          {
            localObject1 = ((String)localObject1).replace(":", "");
            if ((localObject1 != null) && (((String)localObject1).length() != 12)) {
              break;
            }
            localObject1 = new String((String)localObject1);
            return (String)localObject1;
          }
        }
        catch (Exception localException)
        {
          return null;
        }
        Object localObject2 = null;
      }
    }
    
    private void c()
    {
      if (a() < 1) {
        return;
      }
      int j = this.a.size() - 1;
      int i = 1;
      label23:
      int k;
      if ((j >= 1) && (i != 0))
      {
        k = 0;
        i = 0;
        label36:
        if (k < j)
        {
          if (((ScanResult)this.a.get(k)).level >= ((ScanResult)this.a.get(k + 1)).level) {
            break label147;
          }
          ScanResult localScanResult = (ScanResult)this.a.get(k + 1);
          this.a.set(k + 1, this.a.get(k));
          this.a.set(k, localScanResult);
          i = 1;
        }
      }
      label147:
      for (;;)
      {
        k += 1;
        break label36;
        j -= 1;
        break label23;
        break;
      }
    }
    
    public int a()
    {
      if (this.a == null) {
        return 0;
      }
      return this.a.size();
    }
    
    public String a(int paramInt)
    {
      if (a() < 2) {
        return null;
      }
      StringBuffer localStringBuffer = new StringBuffer(512);
      int i4 = this.a.size();
      int j = 1;
      int m = 0;
      String str1 = b();
      int i1 = 0;
      int i = 0;
      int n = 0;
      int i2;
      int k;
      for (;;)
      {
        i2 = j;
        k = i;
        if (n >= i4) {
          break label280;
        }
        if (((ScanResult)this.a.get(n)).level != 0) {
          break;
        }
        k = m;
        m = i;
        i2 = j;
        i = k;
        n += 1;
        k = i;
        j = i2;
        i = m;
        m = k;
      }
      i1 += 1;
      if (j != 0)
      {
        localStringBuffer.append("&wf=");
        j = 0;
      }
      for (;;)
      {
        String str2 = ((ScanResult)this.a.get(n)).BSSID.replace(":", "");
        localStringBuffer.append(str2);
        k = i;
        if (str1 != null)
        {
          k = i;
          if (str2.equals(str1)) {
            k = i1;
          }
        }
        i2 = ((ScanResult)this.a.get(n)).level;
        i = i2;
        if (i2 < 0) {
          i = -i2;
        }
        localStringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[] { Integer.valueOf(i) }));
        int i3 = m + 1;
        i = i3;
        i2 = j;
        m = k;
        if (i3 <= paramInt) {
          break;
        }
        i2 = j;
        label280:
        if (k > 0)
        {
          localStringBuffer.append("&wf_n=");
          localStringBuffer.append(k);
        }
        if (i2 == 0) {
          break label319;
        }
        return null;
        localStringBuffer.append("|");
      }
      label319:
      return localStringBuffer.toString();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */