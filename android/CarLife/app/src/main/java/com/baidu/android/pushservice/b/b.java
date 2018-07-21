package com.baidu.android.pushservice.b;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.pushservice.d.c;
import com.baidu.android.pushservice.d.d;
import com.baidu.android.pushservice.e.g;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static volatile b b;
  public ArrayList<f> a = new ArrayList();
  private Context c;
  private HashMap<String, g> d = new HashMap();
  
  private b(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    Object localObject2 = c.f(paramContext);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (p.E(this.c))
      {
        localObject1 = this.c.getPackageName() + ".push_sync";
        localObject1 = com.baidu.android.pushservice.j.q.a(this.c, (String)localObject1, "r_v2");
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = e(a((String)localObject1));
        if (localObject1 != null)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (f)((Iterator)localObject1).next();
            this.a.add(localObject2);
          }
        }
        j = m.b(this.c, "com.baidu.push.sync.vn", -1);
      }
      catch (Exception localException) {}
    }
    try
    {
      int j;
      i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      if (j < i)
      {
        a();
        m.a(this.c, "com.baidu.push.sync.vn", i);
      }
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new b(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static String a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = com.baidu.android.pushservice.k.b.a(paramString.getBytes());
          if ((paramString != null) && (paramString.length > 0))
          {
            paramString = new String(BaiduAppSSOJni.decryptAES(paramString, paramString.length, 0));
            return paramString;
          }
        }
      }
      catch (UnsatisfiedLinkError paramString)
      {
        return "";
      }
      catch (Exception paramString)
      {
        return "";
      }
      paramString = "";
    }
  }
  
  /* Error */
  private String a(List<f> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 172 1 0
    //   10: ifne +6 -> 16
    //   13: ldc -91
    //   15: areturn
    //   16: aconst_null
    //   17: astore 4
    //   19: new 174	java/lang/StringBuffer
    //   22: dup
    //   23: invokespecial 175	java/lang/StringBuffer:<init>	()V
    //   26: astore_3
    //   27: iconst_0
    //   28: istore_2
    //   29: aload_3
    //   30: astore 4
    //   32: iload_2
    //   33: aload_1
    //   34: invokeinterface 172 1 0
    //   39: if_icmpge +141 -> 180
    //   42: aload_1
    //   43: iload_2
    //   44: invokeinterface 179 2 0
    //   49: checkcast 103	com/baidu/android/pushservice/b/f
    //   52: astore 4
    //   54: aload 4
    //   56: ifnull +145 -> 201
    //   59: aload_3
    //   60: aload 4
    //   62: getfield 182	com/baidu/android/pushservice/b/f:c	Ljava/lang/String;
    //   65: invokevirtual 185	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   68: pop
    //   69: aload_3
    //   70: ldc -69
    //   72: invokevirtual 185	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   75: pop
    //   76: aload_3
    //   77: aload 4
    //   79: getfield 189	com/baidu/android/pushservice/b/f:a	Ljava/lang/String;
    //   82: invokevirtual 185	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   85: pop
    //   86: aload_3
    //   87: ldc -69
    //   89: invokevirtual 185	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   92: pop
    //   93: aload_3
    //   94: aload 4
    //   96: getfield 191	com/baidu/android/pushservice/b/f:f	Ljava/lang/String;
    //   99: invokevirtual 185	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   102: pop
    //   103: aload_3
    //   104: ldc -69
    //   106: invokevirtual 185	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   109: pop
    //   110: aload 4
    //   112: getfield 195	com/baidu/android/pushservice/b/f:g	Z
    //   115: ifeq +49 -> 164
    //   118: aload_3
    //   119: ldc -59
    //   121: invokevirtual 185	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   124: pop
    //   125: aload_3
    //   126: ldc -69
    //   128: invokevirtual 185	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   131: pop
    //   132: aload_3
    //   133: aload 4
    //   135: getfield 199	com/baidu/android/pushservice/b/f:e	I
    //   138: invokevirtual 202	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   141: pop
    //   142: iload_2
    //   143: aload_1
    //   144: invokeinterface 172 1 0
    //   149: iconst_1
    //   150: isub
    //   151: if_icmpeq +50 -> 201
    //   154: aload_3
    //   155: ldc -52
    //   157: invokevirtual 185	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   160: pop
    //   161: goto +40 -> 201
    //   164: aload_3
    //   165: ldc -50
    //   167: invokevirtual 185	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   170: pop
    //   171: goto -46 -> 125
    //   174: astore_1
    //   175: aload_3
    //   176: astore_1
    //   177: aload_1
    //   178: astore 4
    //   180: aload 4
    //   182: ifnull +9 -> 191
    //   185: aload 4
    //   187: invokevirtual 207	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   190: areturn
    //   191: ldc -91
    //   193: areturn
    //   194: astore_1
    //   195: aload 4
    //   197: astore_1
    //   198: goto -21 -> 177
    //   201: iload_2
    //   202: iconst_1
    //   203: iadd
    //   204: istore_2
    //   205: goto -176 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	b
    //   0	208	1	paramList	List<f>
    //   28	177	2	i	int
    //   26	150	3	localStringBuffer	StringBuffer
    //   17	179	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   32	54	174	java/lang/Exception
    //   59	125	174	java/lang/Exception
    //   125	161	174	java/lang/Exception
    //   164	171	174	java/lang/Exception
    //   19	27	194	java/lang/Exception
  }
  
  private void a()
  {
    a("r_v2", this.a);
  }
  
  private void a(String paramString, ArrayList<f> paramArrayList)
  {
    String str = this.c.getPackageName() + ".push_sync";
    Object localObject1;
    label55:
    Object localObject3;
    if (p.F(this.c))
    {
      localObject1 = p.o(this.c);
      Iterator localIterator = ((List)localObject1).iterator();
      if (!localIterator.hasNext()) {
        break label505;
      }
      localObject3 = (ResolveInfo)localIterator.next();
    }
    for (;;)
    {
      try
      {
        localObject4 = ((ResolveInfo)localObject3).activityInfo.packageName;
        if (!p.E(this.c)) {
          break label573;
        }
        Object localObject5 = p.v(this.c, ((ResolveInfo)localObject3).activityInfo.packageName);
        if (localObject5 == null) {
          break label573;
        }
        localObject1 = com.baidu.android.pushservice.j.q.a((Context)localObject5, ((ResolveInfo)localObject3).activityInfo.packageName + ".push_sync", paramString);
        localObject3 = com.baidu.android.pushservice.j.q.a((Context)localObject5, ((ResolveInfo)localObject3).activityInfo.packageName + ".self_push_sync", "bindinfo");
        if (((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3))) || (p.m(this.c, (String)localObject4) <= 50)) {
          break label562;
        }
        localObject3 = d.f(this.c, (String)localObject4);
        localObject1 = d.g(this.c, (String)localObject4);
        localObject4 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          break label412;
        }
        localObject3 = e(a((String)localObject4));
        if (localObject3 == null) {
          break label412;
        }
        localObject3 = ((ArrayList)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label412;
        }
        localObject4 = (f)((Iterator)localObject3).next();
        localObject5 = paramArrayList.iterator();
        if (!((Iterator)localObject5).hasNext()) {
          break label557;
        }
        f localf = (f)((Iterator)localObject5).next();
        if ((!TextUtils.equals(((f)localObject4).c, localf.c)) && (!TextUtils.equals(((f)localObject4).a, localf.a))) {
          continue;
        }
        paramArrayList.remove(localf);
        paramArrayList.add(localObject4);
        i = 1;
        if (i != 0) {
          continue;
        }
        paramArrayList.add(localObject4);
        continue;
      }
      catch (Exception localException)
      {
        com.baidu.android.pushservice.h.q.a(this.c, localException);
      }
      Object localObject2 = p.n(this.c);
      break;
      label412:
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label55;
      }
      localObject2 = h(a((String)localObject2));
      localObject3 = paramArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (f)((Iterator)localObject3).next();
        if (TextUtils.equals(((f)localObject2).c, ((f)localObject4).c))
        {
          paramArrayList.remove(localObject4);
          paramArrayList.add(localObject2);
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label555;
        }
        paramArrayList.add(localObject2);
        break;
        label505:
        if (paramArrayList.size() > 0)
        {
          paramArrayList = b(a(paramArrayList));
          c.d(this.c, paramArrayList);
          if (p.E(this.c)) {
            com.baidu.android.pushservice.j.q.a(this.c, str, paramString, paramArrayList);
          }
        }
        return;
      }
      label555:
      break label55;
      label557:
      i = 0;
      continue;
      label562:
      Object localObject4 = localObject2;
      localObject2 = localObject3;
      continue;
      label573:
      localObject3 = null;
      localObject2 = null;
    }
  }
  
  public static ArrayList<f> e(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        String[] arrayOfString = paramString.trim().split(";");
        int j = arrayOfString.length;
        paramString = localArrayList;
        if (i >= j) {
          break;
        }
        paramString = arrayOfString[i].trim().split(",");
        if (paramString.length >= 3)
        {
          f localf = new f();
          localf.c = paramString[0].trim();
          localf.a = paramString[1].trim();
          localf.f = paramString[2].trim();
          if (paramString.length > 3)
          {
            localf.g = paramString[3].trim().equals("true");
            if (paramString.length > 4) {
              localf.e = Integer.parseInt(paramString[4].trim());
            }
          }
          localArrayList.add(localf);
        }
      }
      catch (Exception paramString)
      {
        return localArrayList;
      }
      i += 1;
    }
  }
  
  private f h(String paramString)
  {
    f localf = new f();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.trim().split(",");
        if ((paramString != null) && (paramString.length >= 3) && (!TextUtils.isEmpty(paramString[0])))
        {
          localf.c = paramString[0].trim();
          localf.a = paramString[1].trim();
          localf.f = paramString[2].trim();
          if (paramString.length > 3)
          {
            localf.g = paramString[3].trim().equals("true");
            if (paramString.length > 4) {
              localf.e = Integer.parseInt(paramString[4].trim());
            }
          }
          return localf;
        }
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public f a(int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if ((localf.d >= paramInt) && ((!paramBoolean) || (localf.g)) && (p.c(this.c, localf.c()))) {
        return localf;
      }
    }
    return null;
  }
  
  public String a(f paramf, boolean paramBoolean)
  {
    return a(paramf, paramBoolean, this.a, "r_v2");
  }
  
  public String a(f paramf, boolean paramBoolean, ArrayList<f> paramArrayList, String paramString)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label167;
        }
        f localf = (f)localIterator.next();
        if ((!localf.c.equals(paramf.c)) && (!localf.a.equals(paramf.a))) {
          continue;
        }
        paramArrayList.remove(localf);
        if (!paramBoolean) {
          break label173;
        }
        paramArrayList.add(paramf);
      }
      finally {}
      if ((i == 0) && (paramBoolean)) {
        paramArrayList.add(paramf);
      }
      paramf = b(a(paramArrayList));
      c.d(this.c, paramf);
      if (p.E(this.c)) {
        com.baidu.android.pushservice.j.q.a(this.c, this.c.getPackageName() + ".push_sync", paramString, paramf);
      }
      return paramf;
      label167:
      int i = 0;
      continue;
      label173:
      i = 1;
    }
  }
  
  public void a(String paramString, g paramg)
  {
    this.d.put(paramString, paramg);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ArrayList localArrayList;
    label174:
    try
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        localArrayList = e(a(paramString2));
        paramString2 = "";
        Object localObject = b;
        if ((localObject != null) && (localArrayList != null)) {
          try
          {
            if (!paramString1.equals("r_v2")) {
              break label174;
            }
            paramString2 = new ArrayList();
            localObject = localArrayList.iterator();
            while (((Iterator)localObject).hasNext()) {
              paramString2.add(((f)((Iterator)localObject).next()).c);
            }
          }
          catch (Exception paramString1) {}
        }
      }
      return;
    }
    finally {}
    int i = 0;
    for (;;)
    {
      if (i < b.a.size())
      {
        if (paramString2.contains(((f)b.a.get(i)).c))
        {
          b.a.remove(i);
          i -= 1;
        }
      }
      else
      {
        b.a.addAll(localArrayList);
        paramString2 = a(b.a);
        paramString2 = b(paramString2);
        c.d(this.c, paramString2);
        if (!p.E(this.c)) {
          break;
        }
        com.baidu.android.pushservice.j.q.a(this.c, this.c.getPackageName() + ".push_sync", paramString1, paramString2);
        break;
      }
      i += 1;
    }
  }
  
  public String b(String paramString)
  {
    try
    {
      paramString = com.baidu.android.pushservice.k.b.a(BaiduAppSSOJni.encryptAES(paramString, 0), "utf-8");
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      return "";
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public void b(Context paramContext)
  {
    Object localObject2;
    Object localObject1;
    try
    {
      localObject2 = c.f(paramContext);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        p.b("ClientManager*BBind* selfbindinfo is null", paramContext);
        localObject1 = localObject2;
        if (p.E(this.c))
        {
          localObject1 = this.c.getPackageName() + ".push_sync";
          localObject1 = com.baidu.android.pushservice.j.q.a(this.c, (String)localObject1, "r_v2");
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = a((String)localObject1);
        p.b("ClientManager*BBind* clients=" + (String)localObject1, paramContext);
        localObject1 = e((String)localObject1);
        if ((b != null) && (localObject1 != null))
        {
          localObject2 = new ArrayList();
          Iterator localIterator = ((ArrayList)localObject1).iterator();
          while (localIterator.hasNext()) {
            ((ArrayList)localObject2).add(((f)localIterator.next()).c);
          }
          i = 0;
        }
      }
    }
    finally {}
    for (;;)
    {
      int i;
      if (i < b.a.size())
      {
        if (((ArrayList)localObject2).contains(((f)b.a.get(i)).c))
        {
          b.a.remove(i);
          i -= 1;
          break label290;
        }
      }
      else
      {
        b.a.addAll((Collection)localObject1);
        p.b("ClientManager*BBind* sInstance.mClientsV2.size=" + b.a.size(), paramContext);
        return;
      }
      break label290;
      localObject1 = null;
      break;
      label290:
      i += 1;
    }
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    return (this.d.containsKey(paramString1)) && (paramString2.equals(((g)this.d.get(paramString1)).a()));
  }
  
  public f c(String paramString)
  {
    if ((this.a != null) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (localf.c.equals(paramString)) {
          return localf;
        }
      }
    }
    return null;
  }
  
  public f d(String paramString)
  {
    Object localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = this.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (f)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((f)localObject2).a)) && (((f)localObject2).a.equals(paramString))) {
          return (f)localObject2;
        }
      }
      p.b("ClientManager*BBind* isRegisteredClientByAppid return not by mClientsV2!", this.c);
    }
    for (;;)
    {
      try
      {
        if (!p.F(this.c)) {
          continue;
        }
        localObject1 = p.o(this.c);
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          continue;
        }
        Iterator localIterator = ((List)localObject1).iterator();
        localObject1 = null;
        localObject2 = localObject1;
        try
        {
          if (!localIterator.hasNext()) {
            continue;
          }
          localObject2 = localObject1;
          ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
          Object localObject4 = localObject1;
          localObject2 = localObject1;
          if (p.E(this.c))
          {
            localObject2 = localObject1;
            localObject3 = p.v(this.c, localResolveInfo.activityInfo.packageName);
            localObject4 = localObject1;
            if (localObject3 != null)
            {
              localObject2 = localObject1;
              localObject4 = com.baidu.android.pushservice.j.q.a((Context)localObject3, localResolveInfo.activityInfo.packageName + ".push_sync", "r_v2");
            }
          }
          Object localObject3 = localObject4;
          localObject2 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject2 = localObject4;
            localObject3 = d.f(this.c, localResolveInfo.activityInfo.packageName);
          }
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            continue;
          }
          localObject2 = localObject3;
          localObject4 = a((String)localObject3);
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (!((String)localObject4).contains(paramString)) {
            continue;
          }
          localObject2 = localObject3;
          localObject4 = e((String)localObject4);
          localObject1 = localObject3;
          if (localObject4 == null) {
            continue;
          }
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (((ArrayList)localObject4).isEmpty()) {
            continue;
          }
          localObject2 = localObject3;
          localObject4 = ((ArrayList)localObject4).iterator();
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (!((Iterator)localObject4).hasNext()) {
            continue;
          }
          localObject2 = localObject3;
          localObject1 = (f)((Iterator)localObject4).next();
          localObject2 = localObject3;
          if (TextUtils.isEmpty(((f)localObject1).a)) {
            continue;
          }
          localObject2 = localObject3;
          if (!((f)localObject1).a.equals(paramString)) {
            continue;
          }
          localObject2 = localObject3;
          this.a.add(localObject1);
          return (f)localObject1;
        }
        catch (Exception paramString)
        {
          paramString = (String)localObject2;
        }
      }
      catch (Exception paramString)
      {
        paramString = null;
        continue;
        paramString = (String)localObject1;
        continue;
      }
      p.b("ClientManager*BBind* isRegisteredClientByAppid return null!" + paramString, this.c);
      return null;
      localObject1 = p.n(this.c);
      continue;
      p.b("ClientManager*BBind* getFriendPackages is null!", this.c);
      paramString = null;
    }
  }
  
  public String f(String paramString)
  {
    if (this.d.get(paramString) != null) {
      return ((g)this.d.get(paramString)).b();
    }
    return "";
  }
  
  public void g(String paramString)
  {
    if (this.d.containsKey(paramString)) {
      this.d.remove(paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */