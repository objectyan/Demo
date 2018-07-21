package cz.msebera.android.httpclient.o;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class l
{
  public static final String a = "UNAVAILABLE";
  public static final String b = "version.properties";
  public static final String c = "info.module";
  public static final String d = "info.release";
  public static final String e = "info.timestamp";
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  
  protected l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a.a(paramString1, "Package identifier");
    this.f = paramString1;
    if (paramString2 != null)
    {
      this.g = paramString2;
      if (paramString3 == null) {
        break label63;
      }
      label29:
      this.h = paramString3;
      if (paramString4 == null) {
        break label69;
      }
      label39:
      this.i = paramString4;
      if (paramString5 == null) {
        break label76;
      }
    }
    for (;;)
    {
      this.j = paramString5;
      return;
      paramString2 = "UNAVAILABLE";
      break;
      label63:
      paramString3 = "UNAVAILABLE";
      break label29;
      label69:
      paramString4 = "UNAVAILABLE";
      break label39;
      label76:
      paramString5 = "UNAVAILABLE";
    }
  }
  
  /* Error */
  public static l a(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 32
    //   3: invokestatic 37	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_1
    //   8: ifnull +97 -> 105
    //   11: aload_1
    //   12: astore_3
    //   13: aconst_null
    //   14: astore_2
    //   15: aconst_null
    //   16: astore 4
    //   18: aload_2
    //   19: astore_1
    //   20: aload_3
    //   21: new 53	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   28: aload_0
    //   29: bipush 46
    //   31: bipush 47
    //   33: invokevirtual 60	java/lang/String:replace	(CC)Ljava/lang/String;
    //   36: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 66
    //   41: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 11
    //   46: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokevirtual 76	java/lang/ClassLoader:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   55: astore 5
    //   57: aload 4
    //   59: astore_1
    //   60: aload 5
    //   62: ifnull +28 -> 90
    //   65: new 78	java/util/Properties
    //   68: dup
    //   69: invokespecial 79	java/util/Properties:<init>	()V
    //   72: astore_1
    //   73: aload_1
    //   74: aload 5
    //   76: invokevirtual 83	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   79: aload_1
    //   80: astore_2
    //   81: aload_2
    //   82: astore_1
    //   83: aload 5
    //   85: invokevirtual 88	java/io/InputStream:close	()V
    //   88: aload_2
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_2
    //   92: aload_1
    //   93: ifnull +10 -> 103
    //   96: aload_0
    //   97: aload_1
    //   98: aload_3
    //   99: invokestatic 91	cz/msebera/android/httpclient/o/l:a	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/ClassLoader;)Lcz/msebera/android/httpclient/o/l;
    //   102: astore_2
    //   103: aload_2
    //   104: areturn
    //   105: invokestatic 97	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   108: invokevirtual 101	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   111: astore_3
    //   112: goto -99 -> 13
    //   115: astore 4
    //   117: aload_2
    //   118: astore_1
    //   119: aload 5
    //   121: invokevirtual 88	java/io/InputStream:close	()V
    //   124: aload_2
    //   125: astore_1
    //   126: aload 4
    //   128: athrow
    //   129: astore_2
    //   130: goto -40 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramString	String
    //   0	133	1	paramClassLoader	ClassLoader
    //   14	111	2	localObject1	Object
    //   129	1	2	localIOException	java.io.IOException
    //   12	100	3	localClassLoader	ClassLoader
    //   16	42	4	localObject2	Object
    //   115	12	4	localObject3	Object
    //   55	65	5	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   65	79	115	finally
    //   20	57	129	java/io/IOException
    //   83	88	129	java/io/IOException
    //   119	124	129	java/io/IOException
    //   126	129	129	java/io/IOException
  }
  
  protected static l a(String paramString, Map<?, ?> paramMap, ClassLoader paramClassLoader)
  {
    a.a(paramString, "Package identifier");
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    if (paramMap != null)
    {
      localObject2 = (String)paramMap.get("info.module");
      Object localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() < 1) {
          localObject1 = null;
        }
      }
      localObject2 = (String)paramMap.get("info.release");
      Object localObject3 = localObject2;
      if (localObject2 != null) {
        if (((String)localObject2).length() >= 1)
        {
          localObject3 = localObject2;
          if (!((String)localObject2).equals("${pom.version}")) {}
        }
        else
        {
          localObject3 = null;
        }
      }
      paramMap = (String)paramMap.get("info.timestamp");
      localObject4 = localObject1;
      localObject5 = localObject3;
      localObject2 = paramMap;
      if (paramMap != null) {
        if (paramMap.length() >= 1)
        {
          localObject4 = localObject1;
          localObject5 = localObject3;
          localObject2 = paramMap;
          if (!paramMap.equals("${mvn.timestamp}")) {}
        }
        else
        {
          localObject2 = null;
          localObject5 = localObject3;
          localObject4 = localObject1;
        }
      }
    }
    paramMap = null;
    if (paramClassLoader != null) {
      paramMap = paramClassLoader.toString();
    }
    return new l(paramString, (String)localObject4, (String)localObject5, (String)localObject2, paramMap);
  }
  
  public static String a(String paramString1, String paramString2, Class<?> paramClass)
  {
    paramString2 = a(paramString2, paramClass.getClassLoader());
    if (paramString2 != null) {}
    for (paramString2 = paramString2.c();; paramString2 = "UNAVAILABLE")
    {
      paramClass = System.getProperty("java.version");
      return paramString1 + "/" + paramString2 + " (Java 1.5 minimum; Java/" + paramClass + ")";
    }
  }
  
  public static l[] a(String[] paramArrayOfString, ClassLoader paramClassLoader)
  {
    a.a(paramArrayOfString, "Package identifier array");
    ArrayList localArrayList = new ArrayList(paramArrayOfString.length);
    int m = paramArrayOfString.length;
    int k = 0;
    while (k < m)
    {
      l locall = a(paramArrayOfString[k], paramClassLoader);
      if (locall != null) {
        localArrayList.add(locall);
      }
      k += 1;
    }
    return (l[])localArrayList.toArray(new l[localArrayList.size()]);
  }
  
  public final String a()
  {
    return this.f;
  }
  
  public final String b()
  {
    return this.g;
  }
  
  public final String c()
  {
    return this.h;
  }
  
  public final String d()
  {
    return this.i;
  }
  
  public final String e()
  {
    return this.j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.f.length() + 20 + this.g.length() + this.h.length() + this.i.length() + this.j.length());
    localStringBuilder.append("VersionInfo(").append(this.f).append(':').append(this.g);
    if (!"UNAVAILABLE".equals(this.h)) {
      localStringBuilder.append(':').append(this.h);
    }
    if (!"UNAVAILABLE".equals(this.i)) {
      localStringBuilder.append(':').append(this.i);
    }
    localStringBuilder.append(')');
    if (!"UNAVAILABLE".equals(this.j)) {
      localStringBuilder.append('@').append(this.j);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/o/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */