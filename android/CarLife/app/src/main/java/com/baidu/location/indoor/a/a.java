package com.baidu.location.indoor.a;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.location.Jni;
import com.baidu.location.d.i;
import com.baidu.location.h.b;
import com.baidu.location.h.g;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a
  extends com.baidu.location.h.e
{
  private static a d = null;
  private static Object e = new Object();
  String a = null;
  String b = null;
  String c = null;
  private String f = null;
  private String p = null;
  private long q = 0L;
  private String r = null;
  private Handler s = null;
  private int t = -1;
  
  public a()
  {
    try
    {
      this.f = i.a().a("jar", null);
      this.p = i.a().a("so", null);
      this.q = i.a().a("tt", 0L);
      this.r = i.a().a("city", null);
      this.t = i.a().a("enable", 1);
      return;
    }
    catch (Exception localException)
    {
      this.f = null;
      this.p = null;
      this.q = System.currentTimeMillis();
    }
  }
  
  /* Error */
  public static void a(File paramFile1, File paramFile2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 97	java/io/BufferedInputStream
    //   6: dup
    //   7: new 99	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: invokespecial 105	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_3
    //   19: new 107	java/io/BufferedOutputStream
    //   22: dup
    //   23: new 109	java/io/FileOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 110	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: invokespecial 113	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   34: astore_1
    //   35: sipush 5120
    //   38: newarray <illegal type>
    //   40: astore 4
    //   42: aload_3
    //   43: aload 4
    //   45: invokevirtual 117	java/io/BufferedInputStream:read	([B)I
    //   48: istore_2
    //   49: iload_2
    //   50: iconst_m1
    //   51: if_icmpeq +33 -> 84
    //   54: aload_1
    //   55: aload 4
    //   57: iconst_0
    //   58: iload_2
    //   59: invokevirtual 121	java/io/BufferedOutputStream:write	([BII)V
    //   62: goto -20 -> 42
    //   65: astore_0
    //   66: aload_3
    //   67: ifnull +7 -> 74
    //   70: aload_3
    //   71: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_1
    //   79: invokevirtual 125	java/io/BufferedOutputStream:close	()V
    //   82: aload_0
    //   83: athrow
    //   84: aload_1
    //   85: invokevirtual 128	java/io/BufferedOutputStream:flush	()V
    //   88: aload_0
    //   89: invokevirtual 134	java/io/File:delete	()Z
    //   92: pop
    //   93: aload_3
    //   94: ifnull +7 -> 101
    //   97: aload_3
    //   98: invokevirtual 124	java/io/BufferedInputStream:close	()V
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 125	java/io/BufferedOutputStream:close	()V
    //   109: return
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_1
    //   113: aload 4
    //   115: astore_3
    //   116: goto -50 -> 66
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_1
    //   122: goto -56 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramFile1	File
    //   0	125	1	paramFile2	File
    //   48	11	2	i	int
    //   18	98	3	localObject	Object
    //   1	113	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   35	42	65	finally
    //   42	49	65	finally
    //   54	62	65	finally
    //   84	93	65	finally
    //   3	19	110	finally
    //   19	35	119	finally
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    File localFile = new File(g.l() + File.separator + "tmplocdata");
    if (localFile.exists()) {
      localFile.delete();
    }
    FileOutputStream localFileOutputStream;
    BufferedInputStream localBufferedInputStream;
    try
    {
      localFileOutputStream = new FileOutputStream(localFile);
      byte[] arrayOfByte = new byte['က'];
      paramString1 = (HttpURLConnection)new URL(paramString1).openConnection();
      paramString1.setReadTimeout(300000);
      localBufferedInputStream = new BufferedInputStream(paramString1.getInputStream());
      for (;;)
      {
        int i = localBufferedInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
      paramString1.disconnect();
    }
    catch (Exception paramString1)
    {
      localFile.delete();
      return false;
    }
    localFileOutputStream.flush();
    localFileOutputStream.close();
    localBufferedInputStream.close();
    if (localFile.length() < 10240L)
    {
      localFile.delete();
      return false;
    }
    localFile.renameTo(new File(g.l() + File.separator + paramString2));
    return true;
  }
  
  public static a b()
  {
    synchronized (e)
    {
      if (d == null) {
        d = new a();
      }
      a locala = d;
      return locala;
    }
  }
  
  private boolean f()
  {
    SensorManager localSensorManager = (SensorManager)com.baidu.location.f.getServiceContext().getSystemService("sensor");
    return (localSensorManager.getDefaultSensor(4) != null) && (localSensorManager.getDefaultSensor(1) != null) && (localSensorManager.getDefaultSensor(2) != null);
  }
  
  private void g()
  {
    if (this.a == null) {
      return;
    }
    new Thread()
    {
      public void run()
      {
        if (a.d(a.this)) {
          a.e(a.this);
        }
      }
    }.start();
  }
  
  private boolean k()
  {
    if (this.c == null) {
      return true;
    }
    File localFile = new File(g.l() + File.separator + this.c);
    if ((!localFile.exists()) && (!a("http://" + this.a + "/" + this.c, this.c))) {
      return false;
    }
    Object localObject;
    if (localFile.exists())
    {
      localObject = g.a(localFile, "SHA-256");
      if ((this.p != null) && (localObject != null) && (g.b((String)localObject, this.p, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")))
      {
        localObject = new File(g.n() + File.separator + "repiaso.so");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        try
        {
          a(localFile, (File)localObject);
          return true;
        }
        catch (Exception localException3)
        {
          if (localFile == null) {}
        }
      }
    }
    try
    {
      if (localFile.exists()) {
        localFile.delete();
      }
      if ((localObject != null) && (((File)localObject).exists())) {
        ((File)localObject).delete();
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
    return false;
    if (localFile != null) {}
    try
    {
      if (localFile.exists()) {
        localFile.delete();
      }
      return false;
      return false;
    }
    catch (Exception localException1)
    {
      for (;;) {}
    }
  }
  
  private boolean l()
  {
    if (this.b == null) {
      return true;
    }
    File localFile = new File(g.l() + File.separator + this.b);
    if ((!localFile.exists()) && (!a("http://" + this.a + "/" + this.b, this.b))) {
      return false;
    }
    Object localObject;
    if (localFile.exists())
    {
      localObject = g.a(localFile, "SHA-256");
      if ((this.f != null) && (localObject != null) && (g.b((String)localObject, this.f, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")))
      {
        localObject = new File(g.n() + File.separator + "repiall.jar");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        try
        {
          a(localFile, (File)localObject);
          return true;
        }
        catch (Exception localException3)
        {
          if (localFile == null) {}
        }
      }
    }
    try
    {
      if (localFile.exists()) {
        localFile.delete();
      }
      if ((localObject != null) && (((File)localObject).exists())) {
        ((File)localObject).delete();
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
    return false;
    if (localFile != null) {}
    try
    {
      if (localFile.exists()) {
        localFile.delete();
      }
      return false;
      return false;
    }
    catch (Exception localException1)
    {
      for (;;) {}
    }
  }
  
  public void a()
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("&sdk=");
    localStringBuffer.append(7.32F);
    localStringBuffer.append("&fw=");
    localStringBuffer.append(com.baidu.location.f.getFrameVersion());
    Object localObject2;
    Object localObject1;
    if (b.a().b == null)
    {
      localStringBuffer.append("&im=");
      localStringBuffer.append(b.a().a);
      localStringBuffer.append("&mb=");
      localStringBuffer.append(Build.MODEL);
      localStringBuffer.append("&sv=");
      localObject2 = Build.VERSION.RELEASE;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() > 10) {
          localObject1 = ((String)localObject2).substring(0, 10);
        }
      }
      localStringBuffer.append((String)localObject1);
      localStringBuffer.append("&pack=");
      localStringBuffer.append(b.d);
      localStringBuffer.append("&city=");
      localStringBuffer.append(this.r);
      localObject1 = null;
      localObject2 = new File(g.n() + File.separator + "iaso.so");
      if (!((File)localObject2).exists()) {
        break label314;
      }
      localObject1 = g.a((File)localObject2, "MD5");
    }
    for (;;)
    {
      localStringBuffer.append("&somd5=");
      localStringBuffer.append((String)localObject1);
      this.h = "http://loc.map.baidu.com/cfgs/geomag/geomagloccfg";
      if (this.k == null) {
        this.k = new HashMap();
      }
      if (this.k != null) {
        this.k.clear();
      }
      this.k.put("it", Jni.en1(localStringBuffer.toString()));
      return;
      localStringBuffer.append("&cu=");
      localStringBuffer.append(b.a().b);
      break;
      label314:
      localObject2 = new File(g.n() + File.separator + "repiaso.so");
      if (((File)localObject2).exists()) {
        localObject1 = g.a((File)localObject2, "MD5");
      }
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.r = paramString;
      i.a().b("city", this.r);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.j != null)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.j);
      if ("up".equals(localJSONObject.getString("ret")))
      {
        this.a = localJSONObject.getString("upath");
        if (localJSONObject.has("u1")) {
          this.b = localJSONObject.getString("u1");
        }
        if (localJSONObject.has("u2")) {
          this.c = localJSONObject.getString("u2");
        }
        if (localJSONObject.has("u1_rsa"))
        {
          this.f = localJSONObject.getString("u1_rsa");
          i.a().b("jar", this.f);
        }
        if (localJSONObject.has("u2_rsa"))
        {
          this.p = localJSONObject.getString("u2_rsa");
          i.a().b("so", this.p);
        }
        this.s.post(new Runnable()
        {
          public void run()
          {
            a.c(a.this);
          }
        });
      }
      if (localJSONObject.has("ison"))
      {
        this.t = localJSONObject.getInt("ison");
        i.a().b("enable", this.t);
      }
      if (localJSONObject.has("saron"))
      {
        int i = localJSONObject.getInt("saron");
        i.a().b("saron", i);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean c()
  {
    int i = 1;
    if (this.t == 1) {
      label226:
      for (;;)
      {
        try
        {
          File localFile1 = new File(g.n() + File.separator + "repiaso.so");
          File localFile2 = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "iaso.so");
          if ((localFile1 != null) && (localFile1.exists()))
          {
            String str = g.a(localFile1, "SHA-256");
            if ((this.p != null) && (str != null) && (g.b(str, this.p, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")))
            {
              if (localFile2.exists()) {
                localFile2.delete();
              }
              a(localFile1, localFile2);
            }
          }
          else
          {
            if ((this.p == null) || (!this.p.equals("Xywq2kG6dffoAjv04PWM3QMMECGCdrLBFFmp6xMqZQGUH4UE4Cv4c6NQthpl3y5s0RlPP3J80bPIOqzbwogMtei1Ax61yZDPuWbhxdByZKISkRsXvd0ALCPAcuz6xhwZZ+VQFoRlrm5cZeC9M2/LkS3H460Mg9fGys5zZMVoZLM="))) {
              break label226;
            }
            if ((!localFile2.exists()) || (i == 0)) {
              break;
            }
            boolean bool = g.b(g.a(localFile2, "SHA-256"), this.p, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB");
            if ((this.p == null) || (!bool)) {
              break;
            }
            return d();
          }
          localFile1.delete();
          continue;
          i = 0;
        }
        catch (Exception localException)
        {
          return false;
        }
      }
    }
    return false;
  }
  
  public boolean d()
  {
    try
    {
      System.load(com.baidu.location.f.getServiceContext().getFileStreamPath("iaso.so").getAbsolutePath());
      return true;
    }
    catch (Exception localException)
    {
      return false;
    }
    catch (Error localError)
    {
      for (;;) {}
    }
  }
  
  public void e()
  {
    if (this.s == null) {
      this.s = new Handler();
    }
    long l = System.currentTimeMillis() - this.q;
    if ((l > 86400000L) && (com.baidu.location.f.f.j())) {}
    for (int i = 1;; i = 0)
    {
      if (l > 86400000L) {}
      int j = i;
      if (i != 0)
      {
        j = i;
        if (!f())
        {
          this.q = System.currentTimeMillis();
          i.a().b("tt", this.q);
          j = 0;
        }
      }
      if ((j != 0) && (this.s != null)) {
        this.s.postDelayed(new Runnable()
        {
          public void run()
          {
            if ((com.baidu.location.a.e.a().d() != 0) || (a.a(a.this) == null)) {}
            do
            {
              return;
              a.a(a.this, System.currentTimeMillis());
              i.a().b("tt", a.b(a.this));
            } while (Build.VERSION.SDK_INT < 14);
            a.this.c("https://loc.map.baidu.com/cfgs/geomag/geomagloccfg");
          }
        }, 30000L);
      }
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */