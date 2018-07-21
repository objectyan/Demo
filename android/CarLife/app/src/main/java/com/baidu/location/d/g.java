package com.baidu.location.d;

import com.baidu.location.Jni;
import com.baidu.location.a.a;
import com.baidu.location.h.b;
import com.baidu.location.h.e;
import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class g
{
  public static final String a = com.baidu.location.h.f.a + "/llin.dat";
  private static volatile g b = null;
  private static String c = "LogSDK";
  private static int d = 5;
  private static int e = 1024;
  private static final String f = com.baidu.location.h.f.a + "/llg.dat";
  private static final String g = com.baidu.location.h.f.a + "/ller.dat";
  private SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private m i = null;
  private m j = null;
  private a k = null;
  private long l = 0L;
  
  private g()
  {
    if (this.i == null) {
      this.i = new m();
    }
  }
  
  public static g a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new g();
      }
      return b;
    }
    finally {}
  }
  
  public static void a(String paramString1, String paramString2)
  {
    for (;;)
    {
      File localFile;
      int i3;
      int i2;
      try
      {
        localFile = new File(paramString1);
        if (!localFile.exists()) {
          c(paramString1);
        }
      }
      finally {}
      try
      {
        paramString1 = new RandomAccessFile(localFile, "rw");
        paramString1.seek(4L);
        n = paramString1.readInt();
        i3 = paramString1.readInt();
        m = paramString1.readInt();
        i1 = paramString1.readInt();
        i2 = paramString1.readInt();
        if (m >= n) {
          continue;
        }
        paramString1.seek(i3 * m + 128);
        paramString2 = (paramString2 + '\000').getBytes();
        paramString1.writeInt(paramString2.length);
        paramString1.write(paramString2, 0, paramString2.length);
        n = m + 1;
        m = i1;
      }
      catch (Exception paramString1)
      {
        continue;
        n = m;
        m = i1;
        continue;
      }
      paramString1.seek(12L);
      paramString1.writeInt(n);
      paramString1.writeInt(m);
      paramString1.writeInt(i2);
      paramString1.close();
      return;
      long l1 = i1 * i3 + 128;
      paramString1.seek(l1);
      paramString2 = (paramString2 + '\000').getBytes();
      paramString1.writeInt(paramString2.length);
      paramString1.write(paramString2, 0, paramString2.length);
      i1 += 1;
      if (i1 <= m) {
        break label251;
      }
      i1 = 0;
      n = m;
      m = i1;
    }
  }
  
  public static boolean a(String paramString, List<String> paramList)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return false;
    }
    for (;;)
    {
      int m;
      int n;
      int i1;
      boolean bool2;
      try
      {
        paramString = new RandomAccessFile(paramString, "rw");
        paramString.seek(8L);
        int i3 = paramString.readInt();
        m = paramString.readInt();
        i2 = paramString.readInt();
        byte[] arrayOfByte = new byte[e];
        n = d;
        n += 1;
        bool1 = false;
        long l1;
        if ((n > 0) && (m > 0))
        {
          i1 = i2;
          if (m < i2) {
            i1 = 0;
          }
          l1 = (m - 1) * i3 + 128;
        }
        try
        {
          paramString.seek(l1);
          i2 = paramString.readInt();
          bool2 = bool1;
          if (i2 <= 0) {
            break label220;
          }
          bool2 = bool1;
          if (i2 >= i3) {
            break label220;
          }
          paramString.read(arrayOfByte, 0, i2);
          bool2 = bool1;
          if (arrayOfByte[(i2 - 1)] != 0) {
            break label220;
          }
          paramList.add(0, new String(arrayOfByte, 0, i2 - 1));
          bool2 = true;
        }
        catch (Exception paramString)
        {
          return bool1;
        }
        paramString.seek(12L);
        paramString.writeInt(m);
        paramString.writeInt(i2);
        paramString.close();
        return bool1;
      }
      catch (Exception paramString)
      {
        return false;
      }
      label220:
      n -= 1;
      m -= 1;
      boolean bool1 = bool2;
      int i2 = i1;
    }
  }
  
  public static void b(String paramString)
  {
    try
    {
      a(a, paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static void c(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      if (!localFile.exists())
      {
        paramString = new File(com.baidu.location.h.f.a);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        paramString = localFile;
        if (!localFile.createNewFile()) {
          paramString = null;
        }
        paramString = new RandomAccessFile(paramString, "rw");
        paramString.seek(0L);
        paramString.writeInt(32);
        paramString.writeInt(1000);
        paramString.writeInt(1040);
        paramString.writeInt(0);
        paramString.writeInt(0);
        paramString.writeInt(0);
        paramString.close();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(m paramm)
  {
    if (paramm != null)
    {
      paramm = Jni.encode(paramm.c());
      a(f, paramm);
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      Object localObject1 = new StringBuffer();
      Object localObject2 = new Date();
      localObject2 = this.h.format((Date)localObject2);
      ((StringBuffer)localObject1).append("&time=");
      ((StringBuffer)localObject1).append((String)localObject2);
      ((StringBuffer)localObject1).append("&err=");
      ((StringBuffer)localObject1).append(paramString);
      ((StringBuffer)localObject1).append(b.a().a(false));
      ((StringBuffer)localObject1).append(a.a().f());
      localObject1 = Jni.encode(((StringBuffer)localObject1).toString());
      a(g, (String)localObject1);
      if (((paramString.contains("Criteria")) || (paramString.contains("locType"))) && (!com.baidu.location.h.g.e(com.baidu.location.f.getServiceContext()).equals("&netc=-1"))) {
        f();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public m b()
  {
    return this.i;
  }
  
  public m c()
  {
    if (this.j == null) {
      this.j = new m();
    }
    return this.j;
  }
  
  public void d()
  {
    if (this.i != null)
    {
      String str = Jni.encode(this.i.c());
      a(f, str);
    }
  }
  
  public void e()
  {
    if (this.j != null)
    {
      String str = Jni.encode(this.j.d());
      a(f, str);
    }
  }
  
  public void f()
  {
    if (this.k == null) {
      this.k = new a();
    }
    if (System.currentTimeMillis() - this.l < 3600000L) {}
    for (;;)
    {
      return;
      if (this.k.b()) {
        continue;
      }
      try
      {
        ArrayList localArrayList = new ArrayList();
        a(g, localArrayList);
        int m;
        int n;
        if (localArrayList.size() > 0)
        {
          m = 0;
          n = 1;
        }
        for (;;)
        {
          JSONArray localJSONArray = new JSONArray();
          JSONObject localJSONObject = new JSONObject();
          if (localArrayList.size() <= 0) {
            break;
          }
          int i2 = localArrayList.size();
          int i1 = 0;
          for (;;)
          {
            if (i1 < i2)
            {
              localJSONArray.put((String)localArrayList.get(i1));
              i1 += 1;
              continue;
              a(f, localArrayList);
              if (localArrayList.size() != 0) {
                break label241;
              }
              a(a, localArrayList);
              m = 1;
              n = 0;
              break;
            }
          }
          if (n != 0) {
            localJSONObject.put("locpt", localJSONArray);
          }
          for (;;)
          {
            this.k.a(localJSONObject.toString());
            return;
            if (m != 0) {
              localJSONObject.put("locup", localJSONArray);
            } else {
              localJSONObject.put("loctc", localJSONArray);
            }
          }
          label241:
          m = 0;
          n = 0;
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  private class a
    extends e
  {
    private String b = null;
    private boolean c = false;
    
    a()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.k.clear();
      this.k.put("qt", "stat");
      this.k.put("req", this.b);
      this.h = "http://ofloc.map.baidu.com/statloc";
    }
    
    public void a(String paramString)
    {
      this.b = paramString;
      if (this.b != null)
      {
        c("https://ofloc.map.baidu.com/statloc");
        this.c = true;
      }
    }
    
    public void a(boolean paramBoolean)
    {
      this.c = false;
      if ((paramBoolean) && (this.j != null)) {}
      try
      {
        String str = this.j;
        return;
      }
      catch (Exception localException) {}
      g.a(g.this, System.currentTimeMillis());
      return;
    }
    
    public boolean b()
    {
      return this.c;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */