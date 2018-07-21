package com.baidu.location.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.Jni;
import com.baidu.location.b.c;
import com.baidu.location.d.a.d;
import com.baidu.location.h.b;
import com.baidu.location.h.e;
import com.baidu.location.h.g;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class a
  extends e
{
  static a f = null;
  private static int v = 3;
  private static int w = 2024;
  ArrayList<String> a = null;
  boolean b = false;
  long c = 0L;
  long d = 0L;
  int e = 0;
  private Handler p = null;
  private a q = null;
  private int r = 0;
  private SharedPreferences s = null;
  private long t = 0L;
  private String u = null;
  private String x;
  private boolean y = true;
  
  public a()
  {
    this.k = new HashMap();
    this.i = 2;
    try
    {
      this.x = (com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "lltg" + File.separator + "llg.dat");
      e();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        this.x = null;
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    for (;;)
    {
      int j;
      int i;
      int k;
      try
      {
        File localFile = new File(paramString1);
        if (!localFile.exists()) {
          b(paramString1);
        }
        try
        {
          paramString1 = new RandomAccessFile(localFile, "rw");
          paramString1.seek(4L);
          j = paramString1.readInt();
          n = paramString1.readInt();
          i = paramString1.readInt();
          k = paramString1.readInt();
          int m = paramString1.readInt();
          if (i >= j) {
            continue;
          }
          paramString1.seek(n * i + 128);
          paramString2 = (paramString2 + '\000').getBytes();
          paramString1.writeInt(paramString2.length);
          paramString1.write(paramString2, 0, paramString2.length);
          j = i + 1;
          i = k;
          paramString1.seek(12L);
          paramString1.writeInt(j);
          paramString1.writeInt(i);
          paramString1.writeInt(m);
          paramString1.close();
        }
        catch (Exception paramString1)
        {
          int n;
          long l;
          paramString1.printStackTrace();
          continue;
        }
        return;
      }
      finally {}
      l = k * n + 128;
      paramString1.seek(l);
      paramString2 = (paramString2 + '\000').getBytes();
      paramString1.writeInt(paramString2.length);
      paramString1.write(paramString2, 0, paramString2.length);
      k += 1;
      if (k > i)
      {
        k = 0;
        j = i;
        i = k;
      }
      else
      {
        j = i;
        i = k;
      }
    }
  }
  
  private boolean a(String paramString, List<String> paramList)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return false;
    }
    for (;;)
    {
      int i;
      int j;
      int k;
      boolean bool2;
      try
      {
        paramString = new RandomAccessFile(paramString, "rw");
        paramString.seek(8L);
        int n = paramString.readInt();
        i = paramString.readInt();
        m = paramString.readInt();
        byte[] arrayOfByte = new byte[w];
        j = v;
        j += 1;
        bool1 = false;
        long l;
        if ((j > 0) && (i > 0))
        {
          k = m;
          if (i < m) {
            k = 0;
          }
          l = (i - 1) * n + 128;
        }
        try
        {
          paramString.seek(l);
          m = paramString.readInt();
          bool2 = bool1;
          if (m <= 0) {
            break label224;
          }
          bool2 = bool1;
          if (m >= n) {
            break label224;
          }
          paramString.read(arrayOfByte, 0, m);
          bool2 = bool1;
          if (arrayOfByte[(m - 1)] != 0) {
            break label224;
          }
          paramList.add(0, new String(arrayOfByte, 0, m - 1));
          bool2 = true;
        }
        catch (Exception paramString)
        {
          return bool1;
        }
        paramString.seek(12L);
        paramString.writeInt(i);
        paramString.writeInt(m);
        paramString.close();
        return bool1;
      }
      catch (Exception paramString)
      {
        return false;
      }
      label224:
      j -= 1;
      i -= 1;
      boolean bool1 = bool2;
      int m = k;
    }
  }
  
  public static a b()
  {
    if (f == null) {
      f = new a();
    }
    return f;
  }
  
  private void b(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      if (!localFile.exists())
      {
        paramString = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "lltg");
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
        paramString.writeInt(500);
        paramString.writeInt(2040);
        paramString.writeInt(0);
        paramString.writeInt(0);
        paramString.writeInt(0);
        paramString.close();
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void e()
  {
    if (this.s == null) {
      this.s = com.baidu.location.f.getServiceContext().getSharedPreferences("ltconfig", 0);
    }
    if (this.s != null) {}
    try
    {
      this.t = this.s.getLong("tt", 0L);
      this.u = this.s.getString("cfg", null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    if ((o < 6) && (this.r < 10) && (c.a().e()))
    {
      this.r += 1;
      if (!d()) {
        this.r = 0;
      }
      return;
    }
    this.r = 0;
  }
  
  public void a()
  {
    this.k.put("qt", "cltr");
    try
    {
      this.k.put("info", Jni.encode(b.a().d()));
      int i = 0;
      while (i < this.a.size())
      {
        this.k.put("cltr[" + i + "]", this.a.get(i));
        i += 1;
      }
      String str = String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      this.k.put("trtm", str);
      if (System.currentTimeMillis() - this.t > 86400000L) {
        this.k.put("cfg", Integer.valueOf(1));
      }
      this.h = g.i();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void a(String paramString)
  {
    if (this.x == null) {
      return;
    }
    a(this.x, paramString);
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/baidu/location/c/a:a	Ljava/util/ArrayList;
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: getfield 50	com/baidu/location/c/a:a	Ljava/util/ArrayList;
    //   11: invokevirtual 326	java/util/ArrayList:clear	()V
    //   14: iload_1
    //   15: ifeq +174 -> 189
    //   18: aload_0
    //   19: getfield 329	com/baidu/location/c/a:j	Ljava/lang/String;
    //   22: ifnull +167 -> 189
    //   25: aload_0
    //   26: getfield 329	com/baidu/location/c/a:j	Ljava/lang/String;
    //   29: astore_2
    //   30: new 331	org/json/JSONObject
    //   33: dup
    //   34: aload_0
    //   35: getfield 329	com/baidu/location/c/a:j	Ljava/lang/String;
    //   38: invokespecial 332	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore_2
    //   42: aload_2
    //   43: ifnull +28 -> 71
    //   46: aload_2
    //   47: ldc_w 334
    //   50: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   53: ifeq +18 -> 71
    //   56: aload_2
    //   57: ldc_w 334
    //   60: invokevirtual 342	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   63: ifne +8 -> 71
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 72	com/baidu/location/c/a:y	Z
    //   71: aload_2
    //   72: ifnull +75 -> 147
    //   75: aload_2
    //   76: ldc -35
    //   78: invokevirtual 338	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   81: ifeq +66 -> 147
    //   84: aload_0
    //   85: getfield 66	com/baidu/location/c/a:s	Landroid/content/SharedPreferences;
    //   88: astore_3
    //   89: aload_3
    //   90: ifnull +57 -> 147
    //   93: aload_0
    //   94: getfield 66	com/baidu/location/c/a:s	Landroid/content/SharedPreferences;
    //   97: invokeinterface 346 1 0
    //   102: astore_3
    //   103: aload_3
    //   104: ldc -43
    //   106: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   109: invokeinterface 352 4 0
    //   114: pop
    //   115: aload_0
    //   116: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   119: putfield 68	com/baidu/location/c/a:t	J
    //   122: aload_3
    //   123: ldc -35
    //   125: aload_2
    //   126: ldc -35
    //   128: invokevirtual 356	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   131: invokevirtual 357	org/json/JSONObject:toString	()Ljava/lang/String;
    //   134: invokeinterface 361 3 0
    //   139: pop
    //   140: aload_3
    //   141: invokeinterface 364 1 0
    //   146: pop
    //   147: aload_0
    //   148: getfield 79	com/baidu/location/c/a:k	Ljava/util/Map;
    //   151: ifnull +12 -> 163
    //   154: aload_0
    //   155: getfield 79	com/baidu/location/c/a:k	Ljava/util/Map;
    //   158: invokeinterface 365 1 0
    //   163: aload_0
    //   164: iconst_0
    //   165: putfield 52	com/baidu/location/c/a:b	Z
    //   168: aload_0
    //   169: getfield 60	com/baidu/location/c/a:p	Landroid/os/Handler;
    //   172: iconst_1
    //   173: ldc2_w 366
    //   176: invokevirtual 373	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   179: pop
    //   180: return
    //   181: astore_2
    //   182: aload_2
    //   183: invokevirtual 128	java/lang/Exception:printStackTrace	()V
    //   186: goto -39 -> 147
    //   189: aload_0
    //   190: lconst_0
    //   191: putfield 54	com/baidu/location/c/a:c	J
    //   194: goto -47 -> 147
    //   197: astore_2
    //   198: goto -51 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	a
    //   0	201	1	paramBoolean	boolean
    //   29	97	2	localObject1	Object
    //   181	2	2	localException1	Exception
    //   197	1	2	localException2	Exception
    //   88	53	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   25	42	181	java/lang/Exception
    //   46	71	181	java/lang/Exception
    //   75	89	181	java/lang/Exception
    //   93	147	197	java/lang/Exception
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (this.b) {}
    while (!this.y) {
      return true;
    }
    if (System.currentTimeMillis() - this.c < 7200000L) {
      return false;
    }
    if (System.currentTimeMillis() - this.d > 3600000L) {
      this.e = 0;
    }
    if ((this.e > 10) && (paramBoolean)) {
      return false;
    }
    com.baidu.location.f.f.a();
    if (!com.baidu.location.f.f.j()) {
      return false;
    }
    if ((!c.a().e()) && (paramBoolean)) {
      return false;
    }
    if ((this.a == null) || (this.a.size() < 1))
    {
      if ((g.m() != null) && (this.x != null))
      {
        if (this.a == null) {
          this.a = new ArrayList();
        }
        a(this.x, this.a);
      }
    }
    else
    {
      if ((this.a == null) || (this.a.size() <= 0)) {
        break label207;
      }
      this.e += 1;
      this.d = System.currentTimeMillis();
      this.b = true;
      c(g.i());
      return true;
    }
    return false;
    label207:
    return false;
  }
  
  public String c()
  {
    return this.u;
  }
  
  public boolean d()
  {
    boolean bool = true;
    com.baidu.location.f.f.a();
    if (!com.baidu.location.f.f.j()) {
      bool = false;
    }
    while (b(true)) {
      return bool;
    }
    return this.q.b();
  }
  
  class a
    extends e
  {
    String a = null;
    int b = 0;
    boolean c = false;
    
    a() {}
    
    public void a()
    {
      this.l = this.a;
      try
      {
        String str = g.a(new File(this.l), "MD5");
        this.h = (g.h() + "?&qt=indoor&trtm=" + System.currentTimeMillis());
        if (str != null) {
          this.h = (this.h + "&md5=" + str);
        }
        this.i = 1;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
    
    public void a(boolean paramBoolean)
    {
      if (paramBoolean) {}
      try
      {
        new File(this.a).delete();
        for (this.b = 0;; this.b += 2)
        {
          this.a = null;
          this.c = false;
          a.b(a.this).sendEmptyMessageDelayed(1, 1500L);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
    
    public boolean b()
    {
      if (this.c) {
        return true;
      }
      this.a = d.a().b();
      if (this.a == null) {
        return false;
      }
      this.c = true;
      j();
      return true;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */