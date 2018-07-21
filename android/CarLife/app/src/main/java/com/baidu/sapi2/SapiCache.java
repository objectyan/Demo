package com.baidu.sapi2;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.d;
import com.baidu.sapi2.utils.enums.Domain;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class SapiCache
{
  private static final Map<String, SoftReference<String>> a = new ConcurrentHashMap();
  private static final List<String> b = new ArrayList();
  private static final List<String> c = new ArrayList();
  private static Context d;
  
  static String a(Context paramContext, String paramString)
  {
    return b(paramContext, c(paramString));
  }
  
  static String a(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      Object localObject1 = new byte[paramInputStream.available()];
      paramInputStream.read((byte[])localObject1);
      localObject1 = new String((byte[])localObject1);
      return (String)localObject1;
    }
    finally
    {
      paramInputStream.close();
    }
  }
  
  static void a()
  {
    Object localObject = b.a(d).j().f();
    if (((c.a)localObject).a())
    {
      Iterator localIterator = ((c.a)localObject).b().iterator();
      while (localIterator.hasNext())
      {
        c.a.a locala = (c.a.a)localIterator.next();
        b.add(locala.a);
      }
      c.addAll(b);
      localObject = ((c.a)localObject).b().iterator();
      while (((Iterator)localObject).hasNext()) {
        a((c.a.a)((Iterator)localObject).next(), new a()
        {
          public void a(c.a.a paramAnonymousa)
          {
            SapiCache.a(SapiCache.f(), paramAnonymousa);
          }
          
          public void a(c.a.a paramAnonymousa, String paramAnonymousString)
          {
            SapiCache.a(paramAnonymousa.a, paramAnonymousString);
          }
        });
      }
    }
  }
  
  static void a(Context paramContext, c.a.a parama)
  {
    String str = c.a.a.a(parama.a);
    if (new File(paramContext.getFilesDir(), str).exists()) {
      try
      {
        str = e(paramContext, str);
        a(parama.a, str);
        return;
      }
      catch (Throwable localThrowable)
      {
        d(paramContext, parama.a);
        return;
      }
    }
    d(paramContext, parama.a);
  }
  
  /* Error */
  static void a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: aload_1
    //   7: iconst_0
    //   8: invokevirtual 162	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   11: astore_0
    //   12: aload_0
    //   13: astore_3
    //   14: aload_0
    //   15: astore 4
    //   17: aload_0
    //   18: aload_2
    //   19: invokevirtual 167	java/io/OutputStream:write	([B)V
    //   22: aload_0
    //   23: ifnull +7 -> 30
    //   26: aload_0
    //   27: invokevirtual 168	java/io/OutputStream:close	()V
    //   30: return
    //   31: astore_0
    //   32: aload_3
    //   33: ifnull -3 -> 30
    //   36: aload_3
    //   37: invokevirtual 168	java/io/OutputStream:close	()V
    //   40: return
    //   41: astore_0
    //   42: return
    //   43: astore_0
    //   44: aload 4
    //   46: ifnull +8 -> 54
    //   49: aload 4
    //   51: invokevirtual 168	java/io/OutputStream:close	()V
    //   54: aload_0
    //   55: athrow
    //   56: astore_0
    //   57: return
    //   58: astore_1
    //   59: goto -5 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramContext	Context
    //   0	62	1	paramString	String
    //   0	62	2	paramArrayOfByte	byte[]
    //   4	33	3	localContext1	Context
    //   1	49	4	localContext2	Context
    // Exception table:
    //   from	to	target	type
    //   5	12	31	java/lang/Throwable
    //   17	22	31	java/lang/Throwable
    //   36	40	41	java/lang/Throwable
    //   5	12	43	finally
    //   17	22	43	finally
    //   26	30	56	java/lang/Throwable
    //   49	54	58	java/lang/Throwable
  }
  
  static void a(c.a.a parama, a parama1)
  {
    if (parama1 == null) {
      throw new IllegalArgumentException(a.class.getName() + "can't be null");
    }
    String str = c.a.a.c(parama.a);
    try
    {
      if (("mounted".equals(Environment.getExternalStorageState())) && (new File(Environment.getExternalStorageDirectory(), str).exists()))
      {
        str = d(str);
        if (MD5Util.toMd5(str.getBytes(), false).equals(parama.c))
        {
          parama1.a(parama, str);
          return;
        }
        parama1.a(parama);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      parama1.a(parama);
      return;
    }
    parama1.a(parama);
  }
  
  static void a(String paramString)
  {
    a.remove(paramString);
  }
  
  static void a(String paramString1, String paramString2)
  {
    a.put(paramString1, new SoftReference(paramString2));
  }
  
  /* Error */
  static void a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 5
    //   10: astore_2
    //   11: ldc -62
    //   13: invokestatic 199	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   16: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: ifeq +79 -> 98
    //   22: aload 5
    //   24: astore_2
    //   25: new 137	java/io/File
    //   28: dup
    //   29: invokestatic 205	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   32: aload_0
    //   33: invokespecial 146	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   36: astore_0
    //   37: aload 5
    //   39: astore_2
    //   40: aload_0
    //   41: invokevirtual 244	java/io/File:getParentFile	()Ljava/io/File;
    //   44: invokevirtual 149	java/io/File:exists	()Z
    //   47: ifne +14 -> 61
    //   50: aload 5
    //   52: astore_2
    //   53: aload_0
    //   54: invokevirtual 244	java/io/File:getParentFile	()Ljava/io/File;
    //   57: invokevirtual 247	java/io/File:mkdirs	()Z
    //   60: pop
    //   61: aload 5
    //   63: astore_2
    //   64: aload_0
    //   65: invokevirtual 149	java/io/File:exists	()Z
    //   68: ifne +11 -> 79
    //   71: aload 5
    //   73: astore_2
    //   74: aload_0
    //   75: invokevirtual 250	java/io/File:createNewFile	()Z
    //   78: pop
    //   79: aload 5
    //   81: astore_2
    //   82: new 252	java/io/FileOutputStream
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 255	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   90: astore_0
    //   91: aload_0
    //   92: aload_1
    //   93: invokevirtual 167	java/io/OutputStream:write	([B)V
    //   96: aload_0
    //   97: astore_3
    //   98: aload_3
    //   99: ifnull +7 -> 106
    //   102: aload_3
    //   103: invokevirtual 168	java/io/OutputStream:close	()V
    //   106: return
    //   107: astore_0
    //   108: aload_0
    //   109: invokestatic 260	com/baidu/sapi2/utils/L:e	(Ljava/lang/Throwable;)V
    //   112: return
    //   113: astore_1
    //   114: aload 4
    //   116: astore_0
    //   117: aload_0
    //   118: astore_2
    //   119: aload_1
    //   120: invokestatic 260	com/baidu/sapi2/utils/L:e	(Ljava/lang/Throwable;)V
    //   123: aload_0
    //   124: ifnull -18 -> 106
    //   127: aload_0
    //   128: invokevirtual 168	java/io/OutputStream:close	()V
    //   131: return
    //   132: astore_0
    //   133: aload_0
    //   134: invokestatic 260	com/baidu/sapi2/utils/L:e	(Ljava/lang/Throwable;)V
    //   137: return
    //   138: astore_0
    //   139: aload_2
    //   140: ifnull +7 -> 147
    //   143: aload_2
    //   144: invokevirtual 168	java/io/OutputStream:close	()V
    //   147: aload_0
    //   148: athrow
    //   149: astore_1
    //   150: aload_1
    //   151: invokestatic 260	com/baidu/sapi2/utils/L:e	(Ljava/lang/Throwable;)V
    //   154: goto -7 -> 147
    //   157: astore_1
    //   158: aload_0
    //   159: astore_2
    //   160: aload_1
    //   161: astore_0
    //   162: goto -23 -> 139
    //   165: astore_1
    //   166: goto -49 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramString	String
    //   0	169	1	paramArrayOfByte	byte[]
    //   10	150	2	localObject1	Object
    //   7	96	3	str	String
    //   1	114	4	localObject2	Object
    //   4	76	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   102	106	107	java/lang/Throwable
    //   11	22	113	java/lang/Throwable
    //   25	37	113	java/lang/Throwable
    //   40	50	113	java/lang/Throwable
    //   53	61	113	java/lang/Throwable
    //   64	71	113	java/lang/Throwable
    //   74	79	113	java/lang/Throwable
    //   82	91	113	java/lang/Throwable
    //   127	131	132	java/lang/Throwable
    //   11	22	138	finally
    //   25	37	138	finally
    //   40	50	138	finally
    //   53	61	138	finally
    //   64	71	138	finally
    //   74	79	138	finally
    //   82	91	138	finally
    //   119	123	138	finally
    //   143	147	149	java/lang/Throwable
    //   91	96	157	finally
    //   91	96	165	java/lang/Throwable
  }
  
  static boolean a(c.a.a parama1, c.a.a parama2)
  {
    return (!TextUtils.isEmpty(parama1.c)) && ((parama2 == null) || (!parama1.c.equals(parama2.c)));
  }
  
  static String b(Context paramContext, String paramString)
  {
    
    if (b.a(paramContext).j().f().a())
    {
      Object localObject = b(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return (String)localObject;
      }
      localObject = c(paramContext, paramString);
      if (localObject != null)
      {
        a((c.a.a)localObject, new a()
        {
          public void a(c.a.a paramAnonymousa)
          {
            SapiCache.a(this.a, paramAnonymousa);
          }
          
          public void a(c.a.a paramAnonymousa, String paramAnonymousString)
          {
            SapiCache.a(paramAnonymousa.a, paramAnonymousString);
          }
        });
        return b(paramString);
      }
      return d(paramContext, paramString);
    }
    return null;
  }
  
  static String b(String paramString)
  {
    if ((a.containsKey(paramString)) && (a.get(paramString) != null))
    {
      paramString = (String)((SoftReference)a.get(paramString)).get();
      if (!TextUtils.isEmpty(paramString)) {
        return paramString;
      }
    }
    return null;
  }
  
  static void b()
  {
    if (!SapiUtils.hasActiveNetwork(d)) {
      return;
    }
    try
    {
      RequestParams localRequestParams = c();
      String str = d.b("/static/appsapi/conf/config.txt");
      if (!TextUtils.isEmpty(str)) {
        localRequestParams.put("di", str);
      }
      localRequestParams.put("cdnversion", String.valueOf((int)(System.currentTimeMillis() / 300000L)));
      new AsyncHttpClient().get(d, d(), localRequestParams, new JsonHttpResponseHandler(Looper.getMainLooper())
      {
        public void onSuccess(JSONObject paramAnonymousJSONObject)
        {
          if (paramAnonymousJSONObject == null) {}
          for (;;)
          {
            return;
            c localc1 = b.a(SapiCache.f()).j();
            final c localc2 = c.a(paramAnonymousJSONObject);
            paramAnonymousJSONObject = localc2.f();
            b.a(SapiCache.f()).a(localc2);
            SapiCache.g().clear();
            if (paramAnonymousJSONObject.a())
            {
              Object localObject1 = paramAnonymousJSONObject.b().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (c.a.a)((Iterator)localObject1).next();
                SapiCache.g().add(((c.a.a)localObject2).a);
              }
              Object localObject2 = paramAnonymousJSONObject.b().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                final c.a.a locala = (c.a.a)((Iterator)localObject2).next();
                paramAnonymousJSONObject = null;
                Iterator localIterator = localc1.f().b().iterator();
                while (localIterator.hasNext())
                {
                  localObject1 = (c.a.a)localIterator.next();
                  if (((c.a.a)localObject1).a.equals(locala.a)) {
                    paramAnonymousJSONObject = (JSONObject)localObject1;
                  }
                }
                if (SapiCache.a(locala, paramAnonymousJSONObject))
                {
                  SapiCache.a(locala, new SapiCache.a()
                  {
                    public void a(c.a.a paramAnonymous2a)
                    {
                      new AsyncHttpClient().get(SapiCache.f(), locala.b, SapiCache.c(), new HttpResponseHandler(Looper.getMainLooper())
                      {
                        public void onFailure(Throwable paramAnonymous3Throwable, String paramAnonymous3String) {}
                        
                        public void onSuccess(String paramAnonymous3String)
                        {
                          if ((!TextUtils.isEmpty(SapiCache.3.1.this.b.a)) && (!TextUtils.isEmpty(paramAnonymous3String)) && (SapiCache.3.1.this.b.c.equals(MD5Util.toMd5(paramAnonymous3String.getBytes(), false))))
                          {
                            b.a(SapiCache.f()).a(SapiCache.3.1.this.a);
                            SapiCache.a(SapiCache.3.1.this.b.a, paramAnonymous3String);
                            SapiCache.a(SapiCache.f(), c.a.a.a(SapiCache.3.1.this.b.a), paramAnonymous3String.getBytes());
                            if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", SapiCache.f())) {
                              SapiCache.a(c.a.a.c(SapiCache.3.1.this.b.a), paramAnonymous3String.getBytes());
                            }
                          }
                        }
                      });
                    }
                    
                    public void a(c.a.a paramAnonymous2a, String paramAnonymous2String)
                    {
                      b.a(SapiCache.f()).a(localc2);
                      if ((!TextUtils.isEmpty(locala.a)) && (!TextUtils.isEmpty(paramAnonymous2String)))
                      {
                        SapiCache.a(locala.a, paramAnonymous2String);
                        SapiCache.a(SapiCache.f(), c.a.a.a(locala.a), paramAnonymous2String.getBytes());
                      }
                    }
                  });
                }
                else
                {
                  b.a(SapiCache.f()).a(localc2);
                  SapiCache.a(locala, new SapiCache.a()
                  {
                    public void a(c.a.a paramAnonymous2a)
                    {
                      String str = c.a.a.a(paramAnonymous2a.a);
                      paramAnonymous2a = c.a.a.c(paramAnonymous2a.a);
                      if (new File(SapiCache.f().getFilesDir(), str).exists()) {}
                      try
                      {
                        str = SapiCache.e(SapiCache.f(), str);
                        if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", SapiCache.f())) {
                          SapiCache.a(paramAnonymous2a, str.getBytes());
                        }
                        return;
                      }
                      catch (Throwable paramAnonymous2a)
                      {
                        L.e(paramAnonymous2a);
                      }
                    }
                    
                    public void a(c.a.a paramAnonymous2a, String paramAnonymous2String) {}
                  });
                }
              }
            }
          }
        }
      });
      return;
    }
    catch (Throwable localThrowable)
    {
      L.e(localThrowable);
    }
  }
  
  static RequestParams c()
  {
    try
    {
      RequestParams localRequestParams = new RequestParams();
      localRequestParams.put("tpl", SapiAccountManager.getInstance().getSapiConfiguration().tpl);
      localRequestParams.put("sdk_version", "6.14.5");
      localRequestParams.put("app_version", SapiUtils.getVersionName(d));
      return localRequestParams;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  static c.a.a c(Context paramContext, String paramString)
  {
    paramContext = b.a(paramContext).j().f().b().iterator();
    while (paramContext.hasNext())
    {
      c.a.a locala = (c.a.a)paramContext.next();
      if (locala.a.equals(paramString)) {
        return locala;
      }
    }
    return null;
  }
  
  static String c(String paramString)
  {
    Object localObject = Uri.parse(paramString);
    StringBuilder localStringBuilder = new StringBuilder().append(((Uri)localObject).getHost());
    if (((Uri)localObject).getPort() == -1) {}
    for (paramString = "";; paramString = ":" + ((Uri)localObject).getPort())
    {
      localObject = paramString + ((Uri)localObject).getPath();
      paramString = (String)localObject;
      if (!((String)localObject).endsWith(".html")) {
        paramString = (String)localObject + ".html";
      }
      return paramString;
    }
  }
  
  static String d()
  {
    return SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigUrl() + "/static/appsapi/conf/config.txt";
  }
  
  static String d(Context paramContext, String paramString)
  {
    String str = c.a.a.b(paramString);
    try
    {
      a(paramString, f(paramContext, str));
      paramContext = b(paramContext, paramString);
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  static String d(String paramString)
    throws IOException
  {
    return a(new FileInputStream(new File(Environment.getExternalStorageDirectory(), paramString)));
  }
  
  static String e(Context paramContext, String paramString)
    throws IOException
  {
    return a(paramContext.openFileInput(paramString));
  }
  
  static void e()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if (!c.contains(str))
      {
        ((List)localObject1).add(str);
        a(str);
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (b.contains(localObject2)) {
        b.remove(localObject2);
      }
    }
  }
  
  static String f(Context paramContext, String paramString)
    throws IOException
  {
    return a(paramContext.getAssets().open(paramString));
  }
  
  public static void init(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context can't be null");
    }
    d = paramContext.getApplicationContext();
    a();
    b();
  }
  
  static abstract interface a
  {
    public abstract void a(c.a.a parama);
    
    public abstract void a(c.a.a parama, String paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/SapiCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */