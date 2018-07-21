package com.baidu.location.f;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.location.h.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e
{
  public List<ScanResult> a = null;
  private long b = 0L;
  private long c = 0L;
  private boolean d = false;
  private boolean e;
  
  public e(e parame)
  {
    if (parame != null)
    {
      this.a = parame.a;
      this.b = parame.b;
      this.c = parame.c;
      this.d = parame.d;
    }
  }
  
  public e(List<ScanResult> paramList, long paramLong)
  {
    this.b = paramLong;
    this.a = paramList;
    this.c = System.currentTimeMillis();
    o();
  }
  
  public static String a(int paramInt, List<ScanResult> paramList)
  {
    if (paramList.size() < 1) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(512);
    int j = paramList.size();
    if (j > paramInt) {
      j = paramInt;
    }
    for (;;)
    {
      int k = 0;
      paramInt = 1;
      while (k < j)
      {
        int i = paramInt;
        if (((ScanResult)paramList.get(k)).level != 0)
        {
          if (((ScanResult)paramList.get(k)).BSSID == null)
          {
            k += 1;
            continue;
          }
          if (paramInt == 0) {
            break label187;
          }
          paramInt = 0;
        }
        for (;;)
        {
          localStringBuffer.append(((ScanResult)paramList.get(k)).BSSID.replace(":", ""));
          int m = ((ScanResult)paramList.get(k)).level;
          i = m;
          if (m < 0) {
            i = -m;
          }
          localStringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[] { Integer.valueOf(i) }));
          i = paramInt;
          paramInt = i;
          break;
          label187:
          localStringBuffer.append("|");
        }
      }
      if (paramInt == 0) {
        return localStringBuffer.toString();
      }
      return null;
    }
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("wpa|wep", 2).matcher(paramString).find();
  }
  
  private String b(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      if (!paramString.contains("&"))
      {
        str = paramString;
        if (!paramString.contains(";")) {}
      }
      else
      {
        str = paramString.replace("&", "_").replace(";", "_");
      }
    }
    return str;
  }
  
  private void o()
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
    return a(paramInt, false, false);
  }
  
  public String a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a() < 1) {
      return null;
    }
    int j = 0;
    int n;
    String str;
    Object localObject7;
    long l2;
    long l3;
    int i;
    int k;
    long l4;
    label155:
    int i2;
    label176:
    int m;
    label208:
    int i4;
    label265:
    int i1;
    for (;;)
    {
      try
      {
        localObject9 = new Random();
        localStringBuffer = new StringBuffer(512);
        localObject8 = new ArrayList();
        localObject5 = f.a().l();
        if ((localObject5 == null) || (((WifiInfo)localObject5).getBSSID() == null)) {
          break label1417;
        }
        localObject1 = ((WifiInfo)localObject5).getBSSID().replace(":", "");
        n = ((WifiInfo)localObject5).getRssi();
        str = f.a().n();
        if (n >= 0) {
          break label1410;
        }
        n = -n;
        localObject7 = localObject1;
        l2 = 0L;
        l3 = 0L;
        i = 0;
        k = Build.VERSION.SDK_INT;
        if (k < 17) {
          break label1403;
        }
      }
      catch (Error localError2)
      {
        StringBuffer localStringBuffer;
        Object localObject5;
        Object localObject1;
        return null;
        if ((paramInt != 1) || (((Random)localObject9).nextInt(20) != 1) || (((ScanResult)this.a.get(i4)).SSID == null) || (((ScanResult)this.a.get(i4)).SSID.length() >= 30)) {
          break label1390;
        }
        localStringBuffer.append(b(((ScanResult)this.a.get(i4)).SSID));
        paramInt = 2;
        continue;
        continue;
        localStringBuffer.append(b(((ScanResult)this.a.get(i4)).SSID));
        i1 = m;
        break label1449;
        if (k != 0) {
          continue;
        }
        localStringBuffer.append("&wf_n=" + j);
        if ((localObject7 == null) || (n == -1)) {
          continue;
        }
        localStringBuffer.append("&wf_rs=" + n);
        if ((l2 <= 10L) || (((List)localObject8).size() <= 0) || (((Long)((List)localObject8).get(0)).longValue() <= 0L)) {
          continue;
        }
        localObject4 = new StringBuffer(128);
        ((StringBuffer)localObject4).append("&wf_ut=");
        paramInt = 1;
        localObject7 = (Long)((List)localObject8).get(0);
        Object localObject8 = ((List)localObject8).iterator();
        if (!((Iterator)localObject8).hasNext()) {
          continue;
        }
        Object localObject9 = (Long)((Iterator)localObject8).next();
        if (paramInt == 0) {
          continue;
        }
        ((StringBuffer)localObject4).append(((Long)localObject9).longValue());
        paramInt = 0;
        ((StringBuffer)localObject4).append("|");
        continue;
        long l1 = ((Long)localObject9).longValue() - ((Long)localObject7).longValue();
        if (l1 == 0L) {
          break label1470;
        }
        ((StringBuffer)localObject4).append("" + l1);
        break label1470;
        localStringBuffer.append(((StringBuffer)localObject4).toString());
        localStringBuffer.append("&wf_st=");
        localStringBuffer.append(this.b);
        localStringBuffer.append("&wf_et=");
        localStringBuffer.append(this.c);
        localStringBuffer.append("&wf_vt=");
        localStringBuffer.append(f.a);
        if (j <= 0) {
          continue;
        }
        this.d = true;
        localStringBuffer.append("&wf_en=");
        if (!this.e) {
          continue;
        }
        paramInt = 1;
        localStringBuffer.append(paramInt);
        if (str == null) {
          continue;
        }
        localStringBuffer.append("&wf_gw=");
        localStringBuffer.append(str);
        if (localException3 == null) {
          continue;
        }
        localStringBuffer.append(localException3.toString());
        localObject4 = localStringBuffer.toString();
        return (String)localObject4;
        paramInt = 0;
        continue;
        return null;
      }
      catch (Exception localException2)
      {
        label730:
        return null;
      }
      try
      {
        l1 = SystemClock.elapsedRealtimeNanos() / 1000L;
        l2 = l1;
        if (l1 <= 0L) {
          break label1403;
        }
        i = 1;
        l4 = l1;
        if (i == 0) {
          break label1396;
        }
        if ((i != 0) && (paramBoolean1))
        {
          i = 1;
          i2 = i;
          m = 0;
          i = 0;
          int i3 = this.a.size();
          k = 1;
          if (i3 <= paramInt) {
            break label1393;
          }
          i3 = paramInt;
          break label1429;
          if (i4 >= i3) {
            continue;
          }
          i = ((ScanResult)this.a.get(i4)).level;
          if (i != 0) {
            continue;
          }
          localObject1 = localObject5;
          i = j;
          j = m;
          l1 = l2;
          m = paramInt;
          paramInt = k;
          k = m;
          i4 += 1;
          m = j;
          j = paramInt;
          paramInt = k;
          localObject5 = localObject1;
          k = j;
          j = i;
          l2 = l1;
          continue;
        }
      }
      catch (Error localError1)
      {
        l1 = 0L;
        continue;
        i = 0;
        continue;
        l1 = l2;
        if (i2 == 0) {}
      }
      try
      {
        l3 = (l4 - ((ScanResult)this.a.get(i4)).timestamp) / 1000000L;
        ((List)localObject8).add(Long.valueOf(l3));
        l1 = l2;
        if (l3 > l2) {
          l1 = l3;
        }
        if (k != 0)
        {
          k = 0;
          localStringBuffer.append("&wf=");
          Object localObject2 = localObject5;
          i = k;
          if (paramBoolean2)
          {
            localObject2 = new StringBuffer();
            ((StringBuffer)localObject2).append("&wf_ch=");
            ((StringBuffer)localObject2).append(b(((ScanResult)this.a.get(i4)).frequency));
            i = k;
          }
          localObject5 = ((ScanResult)this.a.get(i4)).BSSID;
          k = j;
          i1 = m;
          if (localObject5 == null) {
            break label1449;
          }
          localObject5 = ((String)localObject5).replace(":", "");
          localStringBuffer.append((String)localObject5);
          i1 = ((ScanResult)this.a.get(i4)).level;
          k = i1;
          if (i1 < 0) {
            k = -i1;
          }
          localStringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[] { Integer.valueOf(k) }));
          m += 1;
          int i5 = 0;
          i1 = i5;
          k = j;
          if (localObject7 != null)
          {
            i1 = i5;
            k = j;
            if (((String)localObject7).equals(localObject5))
            {
              this.e = a(((ScanResult)this.a.get(i4)).capabilities);
              i1 = 1;
              k = m;
            }
          }
          if (i1 != 0) {
            continue;
          }
          if (paramInt != 0) {
            continue;
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if ((((Random)localObject9).nextInt(10) != 2) || (((ScanResult)this.a.get(i4)).SSID == null) || (((ScanResult)this.a.get(i4)).SSID.length() >= 30)) {
            break label1390;
          }
          localStringBuffer.append(b(((ScanResult)this.a.get(i4)).SSID));
          paramInt = 1;
          j = m;
          m = paramInt;
          paramInt = i;
          i = k;
          k = m;
        }
        catch (Exception localException3)
        {
          Object localObject3;
          j = m;
          m = paramInt;
          paramInt = i;
          i = k;
          k = m;
        }
        localException1 = localException1;
        l3 = 0L;
        continue;
        localStringBuffer.append("|");
        localObject3 = localObject5;
        i = k;
        if (paramBoolean2)
        {
          ((StringBuffer)localObject5).append("|");
          ((StringBuffer)localObject5).append(b(((ScanResult)this.a.get(i4)).frequency));
          localObject3 = localObject5;
          i = k;
        }
      }
    }
    label1390:
    label1393:
    label1396:
    label1403:
    label1410:
    label1417:
    label1429:
    label1449:
    label1470:
    for (;;)
    {
      Object localObject4;
      break label730;
      break label1429;
      i2 = i;
      break label176;
      l4 = l2;
      break label155;
      localObject7 = localException2;
      break;
      n = -1;
      str = null;
      localObject7 = null;
      break;
      Object localObject6 = null;
      i4 = 0;
      paramInt = j;
      j = i;
      l2 = l3;
      break label208;
      j = i1;
      m = paramInt;
      paramInt = i;
      i = k;
      k = m;
      break label265;
    }
  }
  
  public boolean a(long paramLong)
  {
    long l2 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    if (Build.VERSION.SDK_INT >= 17) {}
    for (;;)
    {
      long l1;
      try
      {
        l1 = SystemClock.elapsedRealtimeNanos() / 1000L;
        l2 = l1;
        if (l1 <= 0L) {
          break label294;
        }
        i = 1;
        l2 = l1;
        if (i == 0) {
          return false;
        }
      }
      catch (Error localError1)
      {
        l1 = 0L;
        continue;
      }
      catch (Exception localException1)
      {
        l1 = 0L;
        continue;
        if ((this.a == null) || (this.a.size() == 0)) {
          continue;
        }
        j = this.a.size();
        if (j <= 16) {
          break label291;
        }
      }
      int j = 16;
      label291:
      for (;;)
      {
        int k = 0;
        if (k < j)
        {
          long l6;
          long l5;
          if (((ScanResult)this.a.get(k)).level == 0)
          {
            l6 = l3;
            l5 = l4;
          }
          for (;;)
          {
            k += 1;
            l4 = l5;
            l3 = l6;
            break;
            l5 = l4;
            l6 = l3;
            if (i != 0) {
              try
              {
                l1 = (l2 - ((ScanResult)this.a.get(k)).timestamp) / 1000000L;
                l4 += l1;
                l5 = l4;
                l6 = l3;
                if (l1 > l3)
                {
                  l5 = l4;
                  l6 = l1;
                }
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  l1 = 0L;
                }
              }
              catch (Error localError2)
              {
                for (;;)
                {
                  l1 = 0L;
                }
              }
            }
          }
        }
        l1 = l4 / j;
        if ((1000L * l3 > paramLong) || (l1 * 1000L > paramLong)) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      label294:
      int i = 0;
    }
  }
  
  public boolean a(e parame)
  {
    if ((this.a != null) && (parame != null) && (parame.a != null))
    {
      int i;
      int j;
      if (this.a.size() < parame.a.size())
      {
        i = this.a.size();
        j = 0;
      }
      for (;;)
      {
        if (j >= i) {
          break label116;
        }
        if (!((ScanResult)this.a.get(j)).BSSID.equals(((ScanResult)parame.a.get(j)).BSSID))
        {
          return false;
          i = parame.a.size();
          break;
        }
        j += 1;
      }
      label116:
      return true;
    }
    return false;
  }
  
  public int b(int paramInt)
  {
    if ((paramInt > 2400) && (paramInt < 2500)) {
      return 2;
    }
    if ((paramInt > 4900) && (paramInt < 5900)) {
      return 5;
    }
    return 0;
  }
  
  public String b()
  {
    try
    {
      String str = a(g.N, true, true);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public boolean b(e parame)
  {
    if ((this.a != null) && (parame != null) && (parame.a != null))
    {
      int i;
      int j;
      if (this.a.size() < parame.a.size())
      {
        i = this.a.size();
        j = 0;
      }
      for (;;)
      {
        if (j >= i) {
          break label167;
        }
        String str1 = ((ScanResult)this.a.get(j)).BSSID;
        int k = ((ScanResult)this.a.get(j)).level;
        String str2 = ((ScanResult)parame.a.get(j)).BSSID;
        int m = ((ScanResult)parame.a.get(j)).level;
        if ((!str1.equals(str2)) || (k != m))
        {
          return false;
          i = parame.a.size();
          break;
        }
        j += 1;
      }
      label167:
      return true;
    }
    return false;
  }
  
  public String c()
  {
    try
    {
      String str = a(g.N, true, false);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String c(int paramInt)
  {
    if (a() < 1) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(512);
    int j = this.a.size();
    if (j > paramInt) {
      j = paramInt;
    }
    for (;;)
    {
      int k = 0;
      paramInt = 1;
      while (k < j)
      {
        int i = paramInt;
        if (((ScanResult)this.a.get(k)).level != 0)
        {
          if (((ScanResult)this.a.get(k)).BSSID == null)
          {
            k += 1;
            continue;
          }
          if (paramInt == 0) {
            break label200;
          }
          paramInt = 0;
        }
        for (;;)
        {
          localStringBuffer.append(((ScanResult)this.a.get(k)).BSSID.replace(":", ""));
          int m = ((ScanResult)this.a.get(k)).level;
          i = m;
          if (m < 0) {
            i = -m;
          }
          localStringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[] { Integer.valueOf(i) }));
          i = paramInt;
          paramInt = i;
          break;
          label200:
          localStringBuffer.append("|");
        }
      }
      if (paramInt == 0) {
        return localStringBuffer.toString();
      }
      return null;
    }
  }
  
  public boolean c(e parame)
  {
    return f.a(parame, this);
  }
  
  public String d()
  {
    try
    {
      String str = a(15);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String d(int paramInt)
  {
    if (a() < 1) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(512);
    int j = this.a.size();
    if (j > paramInt) {
      j = paramInt;
    }
    for (;;)
    {
      int k = 0;
      paramInt = 1;
      while (k < j)
      {
        int i = paramInt;
        if (((ScanResult)this.a.get(k)).level != 0)
        {
          if (((ScanResult)this.a.get(k)).BSSID == null)
          {
            k += 1;
            continue;
          }
          if (paramInt == 0) {
            break label200;
          }
          paramInt = 0;
        }
        for (;;)
        {
          localStringBuffer.append(((ScanResult)this.a.get(k)).BSSID.replace(":", ""));
          int m = ((ScanResult)this.a.get(k)).level;
          i = m;
          if (m < 0) {
            i = -m;
          }
          localStringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[] { Integer.valueOf(i) }));
          i = paramInt;
          paramInt = i;
          break;
          label200:
          localStringBuffer.append("|");
        }
      }
      if (paramInt == 0)
      {
        localStringBuffer.append("|");
        localStringBuffer.append(this.c / 1000L);
        return localStringBuffer.toString();
      }
      return null;
    }
  }
  
  public boolean d(e parame)
  {
    return f.a(parame, this, 0.5F);
  }
  
  public String e(int paramInt)
  {
    int i = 0;
    if ((paramInt == 0) || (a() < 1)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(256);
    int j = this.a.size();
    if (j > g.N) {
      j = g.N;
    }
    for (;;)
    {
      int m = 1;
      int k = 0;
      if (k < j)
      {
        if (((m & paramInt) == 0) || (((ScanResult)this.a.get(k)).BSSID == null)) {
          break label202;
        }
        if (i == 0)
        {
          localStringBuffer.append("&ssid=");
          label101:
          localStringBuffer.append(((ScanResult)this.a.get(k)).BSSID.replace(":", ""));
          localStringBuffer.append(";");
          localStringBuffer.append(b(((ScanResult)this.a.get(k)).SSID));
          i += 1;
        }
      }
      label202:
      for (;;)
      {
        m <<= 1;
        k += 1;
        break;
        localStringBuffer.append("|");
        break label101;
        return localStringBuffer.toString();
      }
    }
  }
  
  public boolean e()
  {
    return a(g.ae);
  }
  
  public long f()
  {
    int j = 16;
    int k = 0;
    if (Build.VERSION.SDK_INT >= 17) {}
    for (;;)
    {
      long l1;
      int m;
      long l3;
      try
      {
        l1 = SystemClock.elapsedRealtimeNanos() / 1000L;
        if (l1 <= 0L) {
          break label188;
        }
        i = 1;
        l2 = l1;
        m = this.a.size();
        if (m <= 16) {
          break label182;
        }
        l3 = 0L;
        if (k < j) {
          if (((ScanResult)this.a.get(k)).level == 0)
          {
            l4 = l3;
            k += 1;
            l3 = l4;
            continue;
          }
        }
      }
      catch (Error localError1)
      {
        l1 = 0L;
        continue;
      }
      catch (Exception localException1)
      {
        l1 = 0L;
        continue;
        long l4 = l3;
        if (i == 0) {
          continue;
        }
        try
        {
          l1 = (l2 - ((ScanResult)this.a.get(k)).timestamp) / 1000000L;
          l4 = l3;
          if (l1 <= l3) {
            continue;
          }
          l4 = l1;
        }
        catch (Exception localException2)
        {
          l1 = 0L;
          continue;
        }
        catch (Error localError2)
        {
          l1 = 0L;
          continue;
        }
      }
      return l3;
      label182:
      j = m;
      continue;
      label188:
      int i = 0;
      long l2 = l1;
      continue;
      i = 0;
      l2 = 0L;
    }
  }
  
  public ArrayList<Long> g()
  {
    int j = 16;
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    if (Build.VERSION.SDK_INT >= 17) {}
    for (;;)
    {
      long l1;
      int m;
      try
      {
        l1 = SystemClock.elapsedRealtimeNanos() / 1000L;
        if (l1 <= 0L) {
          break label177;
        }
        i = 1;
        l2 = l1;
        m = this.a.size();
        if (m <= 16) {
          break label171;
        }
        if (k < j) {
          if (((ScanResult)this.a.get(k)).level == 0)
          {
            k += 1;
            continue;
          }
        }
      }
      catch (Error localError1)
      {
        l1 = 0L;
        continue;
      }
      catch (Exception localException1)
      {
        l1 = 0L;
        continue;
        if (i == 0) {
          continue;
        }
        try
        {
          l1 = (l2 - ((ScanResult)this.a.get(k)).timestamp) / 1000000L;
          localArrayList.add(Long.valueOf(l1));
        }
        catch (Exception localException2)
        {
          l1 = 0L;
          continue;
        }
        catch (Error localError2)
        {
          l1 = 0L;
          continue;
        }
      }
      return localArrayList;
      label171:
      j = m;
      continue;
      label177:
      int i = 0;
      long l2 = l1;
      continue;
      i = 0;
      l2 = 0L;
    }
  }
  
  public long h()
  {
    return this.c;
  }
  
  public LinkedHashMap<String, Integer> i()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      localLinkedHashMap.put(((ScanResult)this.a.get(i)).BSSID.replace(":", ""), Integer.valueOf(((ScanResult)this.a.get(i)).level));
      i += 1;
    }
    return localLinkedHashMap;
  }
  
  public int j()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < a())
      {
        j = -((ScanResult)this.a.get(i)).level;
        if (j <= 0) {}
      }
      else
      {
        return j;
      }
      i += 1;
    }
  }
  
  public boolean k()
  {
    return this.d;
  }
  
  public boolean l()
  {
    return (System.currentTimeMillis() - this.c > 0L) && (System.currentTimeMillis() - this.c < 5000L);
  }
  
  public boolean m()
  {
    return (System.currentTimeMillis() - this.c > 0L) && (System.currentTimeMillis() - this.c < 5000L);
  }
  
  public boolean n()
  {
    return (System.currentTimeMillis() - this.c > 0L) && (System.currentTimeMillis() - this.b < 5000L);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */