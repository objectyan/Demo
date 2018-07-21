package com.baidu.android.pushservice.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h
  extends e
{
  private static volatile h d;
  private static String e = "SDKClientManager";
  
  private h(Context paramContext)
  {
    super(paramContext, c.b);
  }
  
  private g a(String paramString, ArrayList<a> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      a locala = (a)paramArrayList.next();
      if ((!TextUtils.isEmpty(locala.a())) && (locala.a().equals(paramString)) && (p.c(this.b, locala.c())))
      {
        if (0 != 0) {
          throw new NullPointerException();
        }
        paramString = (g)locala;
        this.a.add(paramString);
        return paramString;
      }
    }
    return null;
  }
  
  /* Error */
  public static h a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 89	com/baidu/android/pushservice/b/h:d	Lcom/baidu/android/pushservice/b/h;
    //   6: ifnonnull +23 -> 29
    //   9: new 2	com/baidu/android/pushservice/b/h
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 91	com/baidu/android/pushservice/b/h:<init>	(Landroid/content/Context;)V
    //   17: putstatic 89	com/baidu/android/pushservice/b/h:d	Lcom/baidu/android/pushservice/b/h;
    //   20: getstatic 89	com/baidu/android/pushservice/b/h:d	Lcom/baidu/android/pushservice/b/h;
    //   23: astore_0
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: getstatic 89	com/baidu/android/pushservice/b/h:d	Lcom/baidu/android/pushservice/b/h;
    //   32: aload_0
    //   33: invokevirtual 97	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   36: putfield 64	com/baidu/android/pushservice/b/h:b	Landroid/content/Context;
    //   39: goto -19 -> 20
    //   42: astore_0
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	20	42	finally
    //   20	24	42	finally
    //   29	39	42	finally
  }
  
  public String a(g paramg)
  {
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        if (!TextUtils.isEmpty(paramg.a()))
        {
          Iterator localIterator = this.a.iterator();
          if (localIterator.hasNext())
          {
            a locala = (a)localIterator.next();
            if (!locala.b().equals(paramg.b())) {
              continue;
            }
            locala.b(paramg.c);
            locala.a(paramg.a());
            i = 1;
            if (i != 0) {
              paramg = a(this.a);
            }
          }
        }
      }
      try
      {
        paramg = com.baidu.android.pushservice.k.b.a(BaiduAppSSOJni.encryptAES(paramg, 0), "utf-8");
        com.baidu.android.pushservice.j.b.a(this.b, "com.baidu.push.sdkr", paramg);
        return paramg;
        return null;
        paramg = finally;
        throw paramg;
      }
      catch (Exception paramg)
      {
        for (;;) {}
        i = 0;
      }
      catch (UnsatisfiedLinkError paramg)
      {
        for (;;) {}
      }
    }
  }
  
  public String a(List<a> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      a locala = (a)paramList.get(i);
      localStringBuffer.append(locala.b());
      localStringBuffer.append(",");
      localStringBuffer.append(locala.c());
      localStringBuffer.append(",");
      localStringBuffer.append(locala.d());
      localStringBuffer.append(",");
      localStringBuffer.append(locala.a());
      if (i != paramList.size() - 1) {
        localStringBuffer.append(";");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public ArrayList<a> a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    ArrayList localArrayList;
    do
    {
      return (ArrayList<a>)localObject;
      localArrayList = new ArrayList();
      localObject = localArrayList;
    } while (TextUtils.isEmpty(paramString));
    paramString = paramString.trim().split(";");
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= j) {
        break;
      }
      String[] arrayOfString = paramString[i].trim().trim().split(",");
      if (arrayOfString.length >= 2) {
        localObject = new g(arrayOfString[0], arrayOfString[1]);
      }
      try
      {
        if (arrayOfString.length == 3) {
          ((g)localObject).a(Integer.parseInt(arrayOfString[2]));
        }
        for (;;)
        {
          localArrayList.add(localObject);
          i += 1;
          break;
          if (arrayOfString.length == 4)
          {
            ((g)localObject).a(Integer.parseInt(arrayOfString[2]));
            ((g)localObject).a(arrayOfString[3]);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public g e(String paramString)
  {
    g localg = a(paramString, this.a);
    Object localObject = localg;
    if (localg == null) {}
    try
    {
      String str = com.baidu.android.pushservice.j.b.a(this.b, "com.baidu.push.sdkr");
      localObject = localg;
      if (!TextUtils.isEmpty(str))
      {
        localObject = com.baidu.android.pushservice.k.b.a(str.getBytes());
        localObject = a(paramString, a(new String(BaiduAppSSOJni.decryptAES((byte[])localObject, localObject.length, 0))));
      }
      return (g)localObject;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      return localg;
    }
    catch (Exception paramString) {}
    return localg;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */