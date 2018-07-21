package com.baidu.location.indoor.mapversion.b;

import android.content.Context;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class a
{
  private static a a;
  private c b;
  private String c;
  private boolean d = false;
  private String e = "rn";
  private b f;
  private String g = "gcj02";
  private HashMap<String, d> h = new HashMap();
  
  private a(Context paramContext) {}
  
  public static a a()
  {
    return a;
  }
  
  public static a a(Context paramContext)
  {
    if (a == null) {
      a = new a(paramContext);
    }
    return a;
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: new 85	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 92	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: getstatic 98	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   16: lconst_0
    //   17: aload_0
    //   18: invokevirtual 102	java/io/File:length	()J
    //   21: invokevirtual 108	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   24: astore_0
    //   25: ldc 110
    //   27: invokestatic 116	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   30: astore_3
    //   31: aload_3
    //   32: aload_0
    //   33: invokevirtual 120	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   36: new 122	java/math/BigInteger
    //   39: dup
    //   40: iconst_1
    //   41: aload_3
    //   42: invokevirtual 126	java/security/MessageDigest:digest	()[B
    //   45: invokespecial 129	java/math/BigInteger:<init>	(I[B)V
    //   48: bipush 16
    //   50: invokevirtual 133	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   53: astore_0
    //   54: aload_2
    //   55: invokevirtual 136	java/io/FileInputStream:close	()V
    //   58: aload_0
    //   59: invokevirtual 141	java/lang/String:length	()I
    //   62: istore_1
    //   63: bipush 32
    //   65: iload_1
    //   66: isub
    //   67: istore_1
    //   68: aload_0
    //   69: astore_2
    //   70: iload_1
    //   71: ifle +41 -> 112
    //   74: new 143	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   81: ldc -110
    //   83: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_0
    //   87: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_2
    //   94: iload_1
    //   95: iconst_1
    //   96: isub
    //   97: istore_1
    //   98: aload_2
    //   99: astore_0
    //   100: goto -32 -> 68
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_0
    //   106: aload_2
    //   107: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   110: aload_0
    //   111: astore_2
    //   112: aload_2
    //   113: areturn
    //   114: astore_2
    //   115: goto -9 -> 106
    //   118: astore_2
    //   119: goto -13 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramFile	File
    //   62	36	1	i	int
    //   8	91	2	localObject	Object
    //   103	4	2	localException1	Exception
    //   111	2	2	localFile	File
    //   114	1	2	localException2	Exception
    //   118	1	2	localException3	Exception
    //   30	12	3	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   0	54	103	java/lang/Exception
    //   54	63	114	java/lang/Exception
    //   74	94	118	java/lang/Exception
  }
  
  private String a(String paramString1, String paramString2)
  {
    return c(paramString1) + "_" + paramString2;
  }
  
  private void b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new File(this.e + "/" + a(paramString1, paramString2));
      if (paramString1.exists()) {
        paramString1.delete();
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private String c(String paramString)
  {
    return paramString;
  }
  
  private boolean c()
  {
    if (this.c == null) {}
    Object localObject2;
    do
    {
      return false;
      localObject1 = e(this.c);
      localObject2 = new ByteArrayOutputStream();
    } while (!b.a((File)localObject1, (ByteArrayOutputStream)localObject2));
    this.h.clear();
    Object localObject1 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(((ByteArrayOutputStream)localObject2).toByteArray())));
    try
    {
      for (;;)
      {
        localObject2 = ((BufferedReader)localObject1).readLine();
        if (localObject2 == null) {
          break;
        }
        d locald = new d(this.c);
        locald.b((String)localObject2);
        locald.a(this.g);
        this.h.put(locald.b.toLowerCase(), locald);
      }
      return true;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    for (;;)
    {
      localIOException.close();
    }
  }
  
  private String d(final String paramString)
  {
    int j = 0;
    File localFile = new File(this.e);
    if ((!localFile.exists()) || (!localFile.isDirectory())) {}
    do
    {
      for (;;)
      {
        return null;
        paramString = localFile.listFiles(new FilenameFilter()
        {
          public boolean accept(File paramAnonymousFile, String paramAnonymousString)
          {
            return paramAnonymousString.startsWith(a.a(a.this, paramString) + "_");
          }
        });
        int i = j;
        if (paramString != null)
        {
          if (paramString.length != 1) {
            i = j;
          }
        }
        else {
          while ((paramString != null) && (i < paramString.length))
          {
            paramString[i].delete();
            i += 1;
          }
        }
      }
      paramString = paramString[0].getName().split("_");
    } while (paramString.length < 2);
    return paramString[1];
  }
  
  private File e(String paramString)
  {
    String str = d(paramString);
    return new File(this.e + "/" + a(paramString, str));
  }
  
  private boolean f(String paramString)
  {
    paramString = e(paramString);
    return (paramString.exists()) && (paramString.length() > 0L);
  }
  
  private boolean g(String paramString)
  {
    long l = e(paramString).lastModified();
    return System.currentTimeMillis() - l > 1296000000L;
  }
  
  private void h(String paramString)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.f = new b(paramString, d(paramString));
    this.f.start();
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public void a(String paramString, c paramc)
  {
    if ((this.c != null) && (paramString.equals(this.c))) {}
    do
    {
      return;
      this.b = paramc;
      if ((!f(paramString)) || (g(paramString))) {
        break;
      }
      this.c = paramString;
      c();
    } while (this.b == null);
    this.b.a(true, "OK");
    return;
    h(paramString);
  }
  
  public d b(String paramString)
  {
    return (d)this.h.get(paramString.toLowerCase());
  }
  
  public void b()
  {
    this.h.clear();
    this.c = null;
    this.d = false;
  }
  
  public static class a
  {
    public double a;
    public double b;
    public double c;
    public double d;
    public double e;
    public double f;
    public double g;
    public double h;
    
    public a(String paramString)
    {
      a(paramString);
    }
    
    public void a(String paramString)
    {
      paramString = paramString.trim().split("\\|");
      this.a = Double.valueOf(paramString[0]).doubleValue();
      this.b = Double.valueOf(paramString[1]).doubleValue();
      this.c = Double.valueOf(paramString[2]).doubleValue();
      this.d = Double.valueOf(paramString[3]).doubleValue();
      this.e = Double.valueOf(paramString[4]).doubleValue();
      this.f = Double.valueOf(paramString[5]).doubleValue();
      this.g = Double.valueOf(paramString[6]).doubleValue();
      this.h = Double.valueOf(paramString[7]).doubleValue();
    }
  }
  
  private class b
    extends Thread
  {
    private String b;
    private String c;
    
    public b(String paramString1, String paramString2)
    {
      this.b = paramString1;
      this.c = paramString2;
    }
    
    public void run()
    {
      File localFile;
      Object localObject2;
      int i;
      try
      {
        localFile = new File(a.a(a.this));
        if ((!localFile.exists()) || (!localFile.isDirectory())) {
          localFile.mkdirs();
        }
        Object localObject1 = (HttpURLConnection)new URL("http://loc.map.baidu.com/cfgs/indoorloc/indoorroadnet").openConnection();
        ((HttpURLConnection)localObject1).setDoInput(true);
        ((HttpURLConnection)localObject1).setDoOutput(true);
        ((HttpURLConnection)localObject1).setRequestMethod("POST");
        ((HttpURLConnection)localObject1).addRequestProperty("Accept-encoding", "gzip");
        localObject2 = ((HttpURLConnection)localObject1).getOutputStream();
        Object localObject3 = new StringBuilder().append("bldg=").append(this.b).append("&md5=");
        if (this.c == null)
        {
          String str1 = "null";
          ((OutputStream)localObject2).write(str1.getBytes());
          i = ((HttpURLConnection)localObject1).getResponseCode();
          if (i != 200) {
            break label360;
          }
          str1 = ((HttpURLConnection)localObject1).getHeaderField("Hash");
          localObject1 = ((HttpURLConnection)localObject1).getInputStream();
          localFile = new File(localFile, a.a(a.this, this.b, str1));
          localObject2 = new FileOutputStream(localFile);
          localObject3 = new byte['Ѐ'];
          for (;;)
          {
            i = ((InputStream)localObject1).read((byte[])localObject3);
            if (i < 0) {
              break;
            }
            ((FileOutputStream)localObject2).write((byte[])localObject3, 0, i);
          }
          a.a(a.this, false);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label360:
      label465:
      for (;;)
      {
        return;
        String str2 = this.c;
        break;
        ((FileOutputStream)localObject2).flush();
        ((FileOutputStream)localObject2).close();
        boolean bool;
        if (a.a(localFile).equalsIgnoreCase(str2))
        {
          a.b(a.this, this.b, this.c);
          a.b(a.this, this.b);
          bool = a.b(a.this);
          str2 = "OK";
        }
        for (;;)
        {
          if (a.c(a.this) == null) {
            break label465;
          }
          a.c(a.this).a(bool, str2);
          break;
          str2 = "Download failed";
          localFile.delete();
          bool = false;
          continue;
          if (i == 304)
          {
            a.b(a.this, this.b);
            bool = a.b(a.this);
            str2 = "No roadnet update for " + this.b + "," + this.c;
          }
          else if (i == 204)
          {
            str2 = "Not found bldg " + this.b;
            bool = false;
          }
          else
          {
            str2 = null;
            bool = false;
          }
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean, String paramString);
  }
  
  public static class d
    implements Serializable
  {
    public String a;
    public String b;
    public a.a c;
    public a.a d;
    public a.a e;
    public a.a f = this.d;
    public short[][] g;
    private String h = "gcj02";
    
    public d(String paramString)
    {
      this.a = paramString;
    }
    
    public double a(double paramDouble)
    {
      return (this.f.d + paramDouble) * this.f.c;
    }
    
    public a.a a()
    {
      return this.f;
    }
    
    public void a(String paramString)
    {
      if (paramString != null)
      {
        this.h = paramString.toLowerCase();
        if (!this.h.startsWith("wgs84")) {
          break label33;
        }
        this.f = this.c;
      }
      label33:
      do
      {
        return;
        if (this.h.startsWith("bd09"))
        {
          this.f = this.e;
          return;
        }
      } while (!this.h.startsWith("gcj02"));
      this.f = this.d;
    }
    
    public double b(double paramDouble)
    {
      return (this.f.f + paramDouble) * this.f.e;
    }
    
    public void b(String paramString)
    {
      paramString = paramString.split("\\t");
      this.b = paramString[1];
      this.c = new a.a(paramString[2]);
      this.e = new a.a(paramString[3]);
      this.d = new a.a(paramString[4]);
      this.f = this.d;
      int i = (int)this.f.g;
      int j = (int)this.f.h;
      this.g = ((short[][])Array.newInstance(Short.TYPE, new int[] { i, j }));
      i = 0;
      while (i < this.f.g)
      {
        j = 0;
        while (j < this.f.h)
        {
          int k = (int)this.f.h;
          this.g[i][j] = ((short)(paramString[5].charAt(k * i + j) - '0'));
          j += 1;
        }
        i += 1;
      }
    }
    
    public double c(double paramDouble)
    {
      return paramDouble / this.f.c - this.f.d;
    }
    
    public double d(double paramDouble)
    {
      return paramDouble / this.f.e - this.f.f;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/mapversion/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */