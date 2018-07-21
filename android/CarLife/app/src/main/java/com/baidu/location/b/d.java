package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.baidu.location.Jni;
import com.baidu.location.h.b;
import com.baidu.location.h.e;
import com.baidu.location.h.g;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class d
{
  private static d i = null;
  private static final String k = com.baidu.location.h.f.a + "/conlts.dat";
  private static int l = -1;
  private static int m = -1;
  private static int n = 0;
  public boolean a = true;
  public boolean b = true;
  public boolean c = false;
  public boolean d = true;
  public boolean e = true;
  public boolean f = true;
  public boolean g = true;
  public boolean h = false;
  private a j = null;
  
  public static d a()
  {
    if (i == null) {
      i = new d();
    }
    return i;
  }
  
  private void a(int paramInt)
  {
    boolean bool2 = true;
    if ((paramInt & 0x1) == 1)
    {
      bool1 = true;
      this.a = bool1;
      if ((paramInt & 0x2) != 2) {
        break label112;
      }
      bool1 = true;
      label25:
      this.b = bool1;
      if ((paramInt & 0x4) != 4) {
        break label117;
      }
      bool1 = true;
      label39:
      this.c = bool1;
      if ((paramInt & 0x8) != 8) {
        break label122;
      }
      bool1 = true;
      label55:
      this.d = bool1;
      if ((paramInt & 0x10000) != 65536) {
        break label127;
      }
      bool1 = true;
      label71:
      this.f = bool1;
      if ((paramInt & 0x20000) != 131072) {
        break label132;
      }
    }
    label112:
    label117:
    label122:
    label127:
    label132:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.g = bool1;
      if ((paramInt & 0x10) == 16) {
        this.e = false;
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label25;
      bool1 = false;
      break label39;
      bool1 = false;
      break label55;
      bool1 = false;
      break label71;
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    boolean bool = false;
    if (paramJSONObject == null) {
      return;
    }
    int i1 = 14400000;
    int i2 = 10;
    for (;;)
    {
      try
      {
        if ((paramJSONObject.has("ipen")) && (paramJSONObject.getInt("ipen") == 0))
        {
          if (paramJSONObject.has("ipvt")) {
            i1 = paramJSONObject.getInt("ipvt");
          }
          if (paramJSONObject.has("ipvn")) {
            i2 = paramJSONObject.getInt("ipvn");
          }
          paramJSONObject = com.baidu.location.f.getServiceContext().getSharedPreferences("MapCoreServicePre", 0).edit();
          paramJSONObject.putBoolean("ipLocInfoUpload", bool);
          paramJSONObject.putInt("ipValidTime", i1);
          paramJSONObject.putInt("ipLocInfoUploadTimesPerDay", i2);
          paramJSONObject.commit();
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        return;
      }
      bool = true;
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    int i2 = 0;
    int i1 = 0;
    if (paramArrayOfByte == null) {}
    while (i1 != 0)
    {
      try
      {
        g();
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        return;
      }
      if (paramArrayOfByte.length < 640)
      {
        g.w = false;
        g.t = g.r + 0.025D;
        g.s = g.q - 0.025D;
        i1 = 1;
      }
      else
      {
        g.w = true;
        g.s = Double.longBitsToDouble((paramArrayOfByte[7] & 0xFF) << 56 | (paramArrayOfByte[6] & 0xFF) << 48 | (paramArrayOfByte[5] & 0xFF) << 40 | (paramArrayOfByte[4] & 0xFF) << 32 | (paramArrayOfByte[3] & 0xFF) << 24 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[1] & 0xFF) << 8 | paramArrayOfByte[0] & 0xFF);
        g.t = Double.longBitsToDouble((paramArrayOfByte[15] & 0xFF) << 56 | (paramArrayOfByte[14] & 0xFF) << 48 | (paramArrayOfByte[13] & 0xFF) << 40 | (paramArrayOfByte[12] & 0xFF) << 32 | (paramArrayOfByte[11] & 0xFF) << 24 | (paramArrayOfByte[10] & 0xFF) << 16 | (paramArrayOfByte[9] & 0xFF) << 8 | paramArrayOfByte[8] & 0xFF);
        g.v = new byte['ɱ'];
        i1 = i2;
        while (i1 < 625)
        {
          g.v[i1] = paramArrayOfByte[(i1 + 16)];
          i1 += 1;
        }
        i1 = 1;
      }
    }
  }
  
  private void b(int paramInt)
  {
    Object localObject = new File(k);
    if (!((File)localObject).exists()) {
      i();
    }
    try
    {
      localObject = new RandomAccessFile((File)localObject, "rw");
      ((RandomAccessFile)localObject).seek(4L);
      int i1 = ((RandomAccessFile)localObject).readInt();
      int i2 = ((RandomAccessFile)localObject).readInt();
      ((RandomAccessFile)localObject).seek(i1 * n + 128);
      byte[] arrayOfByte = (b.d + '\000').getBytes();
      ((RandomAccessFile)localObject).writeInt(arrayOfByte.length);
      ((RandomAccessFile)localObject).write(arrayOfByte, 0, arrayOfByte.length);
      ((RandomAccessFile)localObject).writeInt(paramInt);
      if (i2 == n)
      {
        ((RandomAccessFile)localObject).seek(8L);
        ((RandomAccessFile)localObject).writeInt(i2 + 1);
      }
      ((RandomAccessFile)localObject).close();
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean b(String paramString)
  {
    boolean bool2 = true;
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString);
      boolean bool1 = paramString.has("ipconf");
      if (bool1) {}
      try
      {
        a(paramString.getJSONObject("ipconf"));
        int i1 = Integer.parseInt(paramString.getString("ver"));
        if (i1 > g.x)
        {
          g.x = i1;
          String[] arrayOfString;
          if (paramString.has("gps"))
          {
            arrayOfString = paramString.getString("gps").split("\\|");
            if (arrayOfString.length > 10)
            {
              if ((arrayOfString[0] != null) && (!arrayOfString[0].equals(""))) {
                g.y = Float.parseFloat(arrayOfString[0]);
              }
              if ((arrayOfString[1] != null) && (!arrayOfString[1].equals(""))) {
                g.z = Float.parseFloat(arrayOfString[1]);
              }
              if ((arrayOfString[2] != null) && (!arrayOfString[2].equals(""))) {
                g.A = Float.parseFloat(arrayOfString[2]);
              }
              if ((arrayOfString[3] != null) && (!arrayOfString[3].equals(""))) {
                g.B = Float.parseFloat(arrayOfString[3]);
              }
              if ((arrayOfString[4] != null) && (!arrayOfString[4].equals(""))) {
                g.C = Integer.parseInt(arrayOfString[4]);
              }
              if ((arrayOfString[5] != null) && (!arrayOfString[5].equals(""))) {
                g.D = Integer.parseInt(arrayOfString[5]);
              }
              if ((arrayOfString[6] != null) && (!arrayOfString[6].equals(""))) {
                g.E = Integer.parseInt(arrayOfString[6]);
              }
              if ((arrayOfString[7] != null) && (!arrayOfString[7].equals(""))) {
                g.F = Integer.parseInt(arrayOfString[7]);
              }
              if ((arrayOfString[8] != null) && (!arrayOfString[8].equals(""))) {
                g.G = Integer.parseInt(arrayOfString[8]);
              }
              if ((arrayOfString[9] != null) && (!arrayOfString[9].equals(""))) {
                g.H = Integer.parseInt(arrayOfString[9]);
              }
              if ((arrayOfString[10] != null) && (!arrayOfString[10].equals(""))) {
                g.I = Integer.parseInt(arrayOfString[10]);
              }
            }
          }
          if (paramString.has("up"))
          {
            arrayOfString = paramString.getString("up").split("\\|");
            if (arrayOfString.length > 3)
            {
              if ((arrayOfString[0] != null) && (!arrayOfString[0].equals(""))) {
                g.J = Float.parseFloat(arrayOfString[0]);
              }
              if ((arrayOfString[1] != null) && (!arrayOfString[1].equals(""))) {
                g.K = Float.parseFloat(arrayOfString[1]);
              }
              if ((arrayOfString[2] != null) && (!arrayOfString[2].equals(""))) {
                g.L = Float.parseFloat(arrayOfString[2]);
              }
              if ((arrayOfString[3] != null) && (!arrayOfString[3].equals(""))) {
                g.M = Float.parseFloat(arrayOfString[3]);
              }
            }
          }
          if (paramString.has("wf"))
          {
            arrayOfString = paramString.getString("wf").split("\\|");
            if (arrayOfString.length > 3)
            {
              if ((arrayOfString[0] != null) && (!arrayOfString[0].equals(""))) {
                g.N = Integer.parseInt(arrayOfString[0]);
              }
              if ((arrayOfString[1] != null) && (!arrayOfString[1].equals(""))) {
                g.O = Float.parseFloat(arrayOfString[1]);
              }
              if ((arrayOfString[2] != null) && (!arrayOfString[2].equals(""))) {
                g.P = Integer.parseInt(arrayOfString[2]);
              }
              if ((arrayOfString[3] != null) && (!arrayOfString[3].equals(""))) {
                g.Q = Float.parseFloat(arrayOfString[3]);
              }
            }
          }
          if (paramString.has("ab"))
          {
            arrayOfString = paramString.getString("ab").split("\\|");
            if (arrayOfString.length > 3)
            {
              if ((arrayOfString[0] != null) && (!arrayOfString[0].equals(""))) {
                g.R = Float.parseFloat(arrayOfString[0]);
              }
              if ((arrayOfString[1] != null) && (!arrayOfString[1].equals(""))) {
                g.S = Float.parseFloat(arrayOfString[1]);
              }
              if ((arrayOfString[2] != null) && (!arrayOfString[2].equals(""))) {
                g.T = Integer.parseInt(arrayOfString[2]);
              }
              if ((arrayOfString[3] != null) && (!arrayOfString[3].equals(""))) {
                g.U = Integer.parseInt(arrayOfString[3]);
              }
            }
          }
          if (paramString.has("zxd"))
          {
            arrayOfString = paramString.getString("zxd").split("\\|");
            if (arrayOfString.length > 4)
            {
              if ((arrayOfString[0] != null) && (!arrayOfString[0].equals(""))) {
                g.aq = Float.parseFloat(arrayOfString[0]);
              }
              if ((arrayOfString[1] != null) && (!arrayOfString[1].equals(""))) {
                g.ar = Float.parseFloat(arrayOfString[1]);
              }
              if ((arrayOfString[2] != null) && (!arrayOfString[2].equals(""))) {
                g.as = Integer.parseInt(arrayOfString[2]);
              }
              if ((arrayOfString[3] != null) && (!arrayOfString[3].equals(""))) {
                g.at = Integer.parseInt(arrayOfString[3]);
              }
              if ((arrayOfString[4] != null) && (!arrayOfString[4].equals(""))) {
                g.au = Integer.parseInt(arrayOfString[4]);
              }
            }
          }
          if (paramString.has("gpc"))
          {
            arrayOfString = paramString.getString("gpc").split("\\|");
            if (arrayOfString.length > 5)
            {
              if ((arrayOfString[0] != null) && (!arrayOfString[0].equals("")))
              {
                if (Integer.parseInt(arrayOfString[0]) <= 0) {
                  break label1474;
                }
                g.Z = true;
              }
              if ((arrayOfString[1] != null) && (!arrayOfString[1].equals("")))
              {
                if (Integer.parseInt(arrayOfString[1]) <= 0) {
                  break label1481;
                }
                g.aa = true;
              }
              label1174:
              if ((arrayOfString[2] != null) && (!arrayOfString[2].equals(""))) {
                g.ab = Integer.parseInt(arrayOfString[2]);
              }
              if ((arrayOfString[3] != null) && (!arrayOfString[3].equals(""))) {
                g.ad = Integer.parseInt(arrayOfString[3]);
              }
              if ((arrayOfString[4] != null) && (!arrayOfString[4].equals("")))
              {
                i1 = Integer.parseInt(arrayOfString[4]);
                if (i1 <= 0) {
                  break label1488;
                }
                g.aj = i1;
                g.af = g.aj * 1000L * 60L;
                g.ak = g.af >> 2;
              }
            }
          }
          for (;;)
          {
            if ((arrayOfString[5] != null) && (!arrayOfString[5].equals(""))) {
              g.am = Integer.parseInt(arrayOfString[5]);
            }
            if (paramString.has("shak"))
            {
              arrayOfString = paramString.getString("shak").split("\\|");
              if (arrayOfString.length > 2)
              {
                if ((arrayOfString[0] != null) && (!arrayOfString[0].equals(""))) {
                  g.an = Integer.parseInt(arrayOfString[0]);
                }
                if ((arrayOfString[1] != null) && (!arrayOfString[1].equals(""))) {
                  g.ao = Integer.parseInt(arrayOfString[1]);
                }
                if ((arrayOfString[2] != null) && (!arrayOfString[2].equals(""))) {
                  g.ap = Float.parseFloat(arrayOfString[2]);
                }
              }
            }
            bool1 = bool2;
            if (!paramString.has("dmx")) {
              break label1502;
            }
            g.al = paramString.getInt("dmx");
            bool1 = bool2;
            break label1502;
            label1474:
            g.Z = false;
            break;
            label1481:
            g.aa = false;
            break label1174;
            label1488:
            g.o = false;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      bool1 = false;
      label1502:
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  /* Error */
  private void c(String paramString)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: putstatic 54	com/baidu/location/b/d:m	I
    //   4: aload_1
    //   5: ifnull +109 -> 114
    //   8: aload_0
    //   9: aload_1
    //   10: invokespecial 416	com/baidu/location/b/d:b	(Ljava/lang/String;)Z
    //   13: ifeq +7 -> 20
    //   16: aload_0
    //   17: invokespecial 418	com/baidu/location/b/d:f	()V
    //   20: new 97	org/json/JSONObject
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 235	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload_1
    //   30: ldc_w 420
    //   33: invokevirtual 101	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   36: ifeq +16 -> 52
    //   39: aload_1
    //   40: ldc_w 420
    //   43: invokevirtual 249	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokestatic 254	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   49: putstatic 54	com/baidu/location/b/d:m	I
    //   52: aload_0
    //   53: invokespecial 422	com/baidu/location/b/d:j	()V
    //   56: getstatic 54	com/baidu/location/b/d:m	I
    //   59: iconst_m1
    //   60: if_icmpeq +25 -> 85
    //   63: getstatic 54	com/baidu/location/b/d:m	I
    //   66: istore_2
    //   67: aload_0
    //   68: getstatic 54	com/baidu/location/b/d:m	I
    //   71: invokespecial 424	com/baidu/location/b/d:b	(I)V
    //   74: iload_2
    //   75: iconst_m1
    //   76: if_icmpeq +38 -> 114
    //   79: aload_0
    //   80: iload_2
    //   81: invokespecial 426	com/baidu/location/b/d:a	(I)V
    //   84: return
    //   85: getstatic 52	com/baidu/location/b/d:l	I
    //   88: iconst_m1
    //   89: if_icmpeq +20 -> 109
    //   92: getstatic 52	com/baidu/location/b/d:l	I
    //   95: istore_2
    //   96: goto -22 -> 74
    //   99: astore_1
    //   100: return
    //   101: astore_1
    //   102: goto -50 -> 52
    //   105: astore_3
    //   106: goto -86 -> 20
    //   109: iconst_m1
    //   110: istore_2
    //   111: goto -37 -> 74
    //   114: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	d
    //   0	115	1	paramString	String
    //   66	45	2	i1	int
    //   105	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   52	74	99	java/lang/Exception
    //   79	84	99	java/lang/Exception
    //   85	96	99	java/lang/Exception
    //   20	52	101	java/lang/Exception
    //   8	20	105	java/lang/Exception
  }
  
  private void e()
  {
    String str = "&ver=" + g.x + "&usr=" + b.a().c() + "&app=" + b.d + "&prod=" + b.e;
    if (this.j == null) {
      this.j = new a();
    }
    this.j.a(str, false);
  }
  
  private void f()
  {
    Object localObject1 = com.baidu.location.h.f.a + "/config.dat";
    if (g.Z) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (g.aa) {}
      for (int i2 = 1;; i2 = 0)
      {
        byte[] arrayOfByte = String.format(Locale.CHINA, "{\"ver\":\"%d\",\"gps\":\"%.1f|%.1f|%.1f|%.1f|%d|%d|%d|%d|%d|%d|%d\",\"up\":\"%.1f|%.1f|%.1f|%.1f\",\"wf\":\"%d|%.1f|%d|%.1f\",\"ab\":\"%.2f|%.2f|%d|%d\",\"gpc\":\"%d|%d|%d|%d|%d|%d\",\"zxd\":\"%.1f|%.1f|%d|%d|%d\",\"shak\":\"%d|%d|%.1f\",\"dmx\":%d}", new Object[] { Integer.valueOf(g.x), Float.valueOf(g.y), Float.valueOf(g.z), Float.valueOf(g.A), Float.valueOf(g.B), Integer.valueOf(g.C), Integer.valueOf(g.D), Integer.valueOf(g.E), Integer.valueOf(g.F), Integer.valueOf(g.G), Integer.valueOf(g.H), Integer.valueOf(g.I), Float.valueOf(g.J), Float.valueOf(g.K), Float.valueOf(g.L), Float.valueOf(g.M), Integer.valueOf(g.N), Float.valueOf(g.O), Integer.valueOf(g.P), Float.valueOf(g.Q), Float.valueOf(g.R), Float.valueOf(g.S), Integer.valueOf(g.T), Integer.valueOf(g.U), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(g.ab), Integer.valueOf(g.ad), Long.valueOf(g.aj), Integer.valueOf(g.am), Float.valueOf(g.aq), Float.valueOf(g.ar), Integer.valueOf(g.as), Integer.valueOf(g.at), Integer.valueOf(g.au), Integer.valueOf(g.an), Integer.valueOf(g.ao), Float.valueOf(g.ap), Integer.valueOf(g.al) }).getBytes();
        try
        {
          localObject1 = new File((String)localObject1);
          if (!((File)localObject1).exists())
          {
            Object localObject2 = new File(com.baidu.location.h.f.a);
            if (!((File)localObject2).exists()) {
              ((File)localObject2).mkdirs();
            }
            if (((File)localObject1).createNewFile())
            {
              localObject2 = new RandomAccessFile((File)localObject1, "rw");
              ((RandomAccessFile)localObject2).seek(0L);
              ((RandomAccessFile)localObject2).writeBoolean(false);
              ((RandomAccessFile)localObject2).writeBoolean(false);
              ((RandomAccessFile)localObject2).close();
            }
          }
          else
          {
            localObject1 = new RandomAccessFile((File)localObject1, "rw");
            ((RandomAccessFile)localObject1).seek(0L);
            ((RandomAccessFile)localObject1).writeBoolean(true);
            ((RandomAccessFile)localObject1).seek(2L);
            ((RandomAccessFile)localObject1).writeInt(arrayOfByte.length);
            ((RandomAccessFile)localObject1).write(arrayOfByte);
            ((RandomAccessFile)localObject1).close();
          }
          return;
        }
        catch (Exception localException)
        {
          return;
        }
      }
    }
  }
  
  private void g()
  {
    Object localObject1 = com.baidu.location.h.f.a + "/config.dat";
    try
    {
      localObject1 = new File((String)localObject1);
      if (!((File)localObject1).exists())
      {
        Object localObject2 = new File(com.baidu.location.h.f.a);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        if (((File)localObject1).createNewFile())
        {
          localObject2 = new RandomAccessFile((File)localObject1, "rw");
          ((RandomAccessFile)localObject2).seek(0L);
          ((RandomAccessFile)localObject2).writeBoolean(false);
          ((RandomAccessFile)localObject2).writeBoolean(false);
          ((RandomAccessFile)localObject2).close();
        }
      }
      else
      {
        localObject1 = new RandomAccessFile((File)localObject1, "rw");
        ((RandomAccessFile)localObject1).seek(1L);
        ((RandomAccessFile)localObject1).writeBoolean(true);
        ((RandomAccessFile)localObject1).seek(1024L);
        ((RandomAccessFile)localObject1).writeDouble(g.s);
        ((RandomAccessFile)localObject1).writeDouble(g.t);
        ((RandomAccessFile)localObject1).writeBoolean(g.w);
        if ((g.w) && (g.v != null)) {
          ((RandomAccessFile)localObject1).write(g.v);
        }
        ((RandomAccessFile)localObject1).close();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void h()
  {
    Object localObject = com.baidu.location.h.f.a + "/config.dat";
    try
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists())
      {
        localObject = new RandomAccessFile((File)localObject, "rw");
        if (((RandomAccessFile)localObject).readBoolean())
        {
          ((RandomAccessFile)localObject).seek(2L);
          int i1 = ((RandomAccessFile)localObject).readInt();
          byte[] arrayOfByte = new byte[i1];
          ((RandomAccessFile)localObject).read(arrayOfByte, 0, i1);
          b(new String(arrayOfByte));
        }
        ((RandomAccessFile)localObject).seek(1L);
        if (((RandomAccessFile)localObject).readBoolean())
        {
          ((RandomAccessFile)localObject).seek(1024L);
          g.s = ((RandomAccessFile)localObject).readDouble();
          g.t = ((RandomAccessFile)localObject).readDouble();
          g.w = ((RandomAccessFile)localObject).readBoolean();
          if (g.w)
          {
            g.v = new byte['ɱ'];
            ((RandomAccessFile)localObject).read(g.v, 0, 625);
          }
        }
        ((RandomAccessFile)localObject).close();
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
    if ((g.o) && (com.baidu.location.f.isServing)) {}
    try
    {
      com.baidu.location.c.c.a().b();
      return;
    }
    catch (Exception localException1) {}
  }
  
  private void i()
  {
    try
    {
      File localFile = new File(k);
      if (!localFile.exists())
      {
        Object localObject = new File(com.baidu.location.h.f.a);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = localFile;
        if (!localFile.createNewFile()) {
          localObject = null;
        }
        localObject = new RandomAccessFile((File)localObject, "rw");
        ((RandomAccessFile)localObject).seek(0L);
        ((RandomAccessFile)localObject).writeInt(0);
        ((RandomAccessFile)localObject).writeInt(128);
        ((RandomAccessFile)localObject).writeInt(0);
        ((RandomAccessFile)localObject).close();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void j()
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        Object localObject = new File(k);
        if (!((File)localObject).exists()) {
          break;
        }
        localObject = new RandomAccessFile((File)localObject, "rw");
        ((RandomAccessFile)localObject).seek(4L);
        int i2 = ((RandomAccessFile)localObject).readInt();
        if (i2 > 3000)
        {
          ((RandomAccessFile)localObject).close();
          n = 0;
          i();
          return;
        }
        int i3 = ((RandomAccessFile)localObject).readInt();
        ((RandomAccessFile)localObject).seek(128L);
        byte[] arrayOfByte = new byte[i2];
        if (i1 < i3)
        {
          ((RandomAccessFile)localObject).seek(i2 * i1 + 128);
          int i4 = ((RandomAccessFile)localObject).readInt();
          if ((i4 > 0) && (i4 < i2))
          {
            ((RandomAccessFile)localObject).read(arrayOfByte, 0, i4);
            if (arrayOfByte[(i4 - 1)] == 0)
            {
              String str = new String(arrayOfByte, 0, i4 - 1);
              b.a();
              if (str.equals(b.d))
              {
                l = ((RandomAccessFile)localObject).readInt();
                n = i1;
              }
            }
          }
        }
        else
        {
          if (i1 == i3) {
            n = i3;
          }
          ((RandomAccessFile)localObject).close();
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      i1 += 1;
    }
  }
  
  public void a(String paramString)
  {
    if (this.j == null) {
      this.j = new a();
    }
    this.j.a(paramString, true);
  }
  
  public void b()
  {
    h();
  }
  
  public void c()
  {
    com.baidu.location.c.c.a().c();
  }
  
  public void d()
  {
    if (System.currentTimeMillis() - com.baidu.location.h.c.a().d() > 86400000L)
    {
      com.baidu.location.h.c.a().d(System.currentTimeMillis());
      e();
    }
  }
  
  class a
    extends e
  {
    String a = null;
    boolean b = false;
    boolean c = false;
    
    public a()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = g.e();
      this.i = 2;
      String str = Jni.encode(this.a);
      this.a = null;
      if (this.b) {
        this.k.put("qt", "grid");
      }
      for (;;)
      {
        this.k.put("req", str);
        return;
        this.k.put("qt", "conf");
      }
    }
    
    public void a(String paramString, boolean paramBoolean)
    {
      if (this.c) {
        return;
      }
      this.c = true;
      this.a = paramString;
      this.b = paramBoolean;
      if (paramBoolean)
      {
        a(true, "loc.map.baidu.com");
        return;
      }
      c(g.f);
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.j != null)) {
        if (this.b) {
          d.a(d.this, this.m);
        }
      }
      for (;;)
      {
        if (this.k != null) {
          this.k.clear();
        }
        this.c = false;
        return;
        d.a(d.this, this.j);
        continue;
        d.a(d.this, null);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */