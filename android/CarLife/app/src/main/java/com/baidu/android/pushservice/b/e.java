package com.baidu.android.pushservice.b;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.pushservice.d.d;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.j.q;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class e
{
  protected ArrayList<a> a = new ArrayList();
  protected Context b;
  protected c c;
  
  public e(Context paramContext, c paramc)
  {
    this.b = paramContext.getApplicationContext();
    this.c = paramc;
    a();
  }
  
  private void a(String paramString, ArrayList<a> paramArrayList)
  {
    String str = this.b.getPackageName() + ".push_sync";
    Object localObject;
    if (p.F(this.b))
    {
      localObject = p.o(this.b);
      Iterator localIterator1 = ((List)localObject).iterator();
      label55:
      if (!localIterator1.hasNext()) {
        break label250;
      }
      localObject = (ResolveInfo)localIterator1.next();
    }
    for (;;)
    {
      a locala1;
      int i;
      try
      {
        if (!"com.baidu.push.sdkr".equals(paramString)) {
          break label311;
        }
        localObject = d.e(this.b, ((ResolveInfo)localObject).activityInfo.packageName);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label55;
        }
        localObject = a(c((String)localObject));
        if (localObject == null) {
          break label55;
        }
        localObject = ((ArrayList)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label55;
        }
        locala1 = (a)((Iterator)localObject).next();
        Iterator localIterator2 = paramArrayList.iterator();
        if (!localIterator2.hasNext()) {
          break label306;
        }
        a locala2 = (a)localIterator2.next();
        if (TextUtils.equals(locala1.c, locala2.c)) {
          break label317;
        }
        if (!TextUtils.equals(locala1.a, locala2.a)) {
          continue;
        }
      }
      catch (Exception localException) {}
      if (i == 0)
      {
        paramArrayList.add(locala1);
        continue;
        break label55;
        List localList = p.n(this.b);
        break;
        label250:
        if (paramArrayList.size() > 0)
        {
          paramArrayList = d(a(paramArrayList));
          if ("com.baidu.push.sdkr".equals(paramString)) {
            com.baidu.android.pushservice.d.c.c(this.b, paramArrayList);
          }
          if (p.E(this.b)) {
            q.a(this.b, str, paramString, paramArrayList);
          }
        }
        return;
        label306:
        i = 0;
        continue;
        label311:
        localList = null;
        continue;
        label317:
        i = 1;
      }
    }
  }
  
  public static String c(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = com.baidu.android.pushservice.k.b.a(paramString.getBytes());
        if ((paramString != null) && (paramString.length > 0))
        {
          paramString = new String(BaiduAppSSOJni.decryptAES(paramString, paramString.length, 0));
          return paramString;
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
  
  public String a(a parama, boolean paramBoolean)
  {
    int j = 1;
    for (;;)
    {
      Object localObject;
      a locala;
      int i;
      synchronized (this.a)
      {
        if (!TextUtils.isEmpty(parama.a()))
        {
          localObject = this.a.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label406;
          }
          locala = (a)((Iterator)localObject).next();
          if (((TextUtils.isEmpty(parama.b())) || (!TextUtils.equals(locala.b(), parama.b()))) && (!parama.a().equals(locala.a()))) {
            continue;
          }
          this.a.remove(locala);
          if (!paramBoolean) {
            break label411;
          }
          this.a.add(parama);
          break label411;
          if ((i == 0) && (paramBoolean)) {
            this.a.add(parama);
          }
          localObject = a(this.a);
          i = 1.a[this.c.ordinal()];
          switch (i)
          {
          default: 
            parama = "";
          }
        }
      }
      try
      {
        localObject = com.baidu.android.pushservice.k.b.a(BaiduAppSSOJni.encryptAES((String)localObject, 0), "utf-8");
        com.baidu.android.pushservice.j.b.a(this.b, parama, (String)localObject);
        return (String)localObject;
        if (this.c == c.b)
        {
          localObject = this.a.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            locala = (a)((Iterator)localObject).next();
          } while ((TextUtils.isEmpty(parama.b())) || (!TextUtils.equals(locala.b(), parama.b())) || (TextUtils.isEmpty(parama.c())) || (!TextUtils.equals(locala.c(), parama.c())));
          i = j;
          continue;
        }
        localObject = this.a.iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break label401;
          }
          locala = (a)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(parama.b()))
          {
            i = j;
            if (TextUtils.equals(locala.b(), parama.b())) {
              break;
            }
          }
        } while (!TextUtils.isEmpty(locala.a()));
        i = j;
        continue;
        return "";
        parama = finally;
        throw parama;
      }
      catch (Exception parama)
      {
        for (;;)
        {
          continue;
          i = 0;
          break;
          i = 0;
          break label413;
          i = 1;
          break;
          parama = "com.baidu.push.sdkr";
          continue;
          parama = "";
        }
      }
      catch (UnsatisfiedLinkError parama)
      {
        label401:
        label406:
        label411:
        label413:
        for (;;) {}
      }
    }
  }
  
  protected String a(List<a> paramList)
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
      localStringBuffer.append(locala.a());
      if (i != paramList.size() - 1) {
        localStringBuffer.append(";");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  protected ArrayList<a> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramString.trim().split(";");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString = localArrayList;
      if (i >= j) {
        break;
      }
      paramString = arrayOfString[i].trim().trim().split(",");
      if ((paramString.length == 1) || (paramString.length == 2))
      {
        a locala = new a(paramString[0]);
        if (paramString.length == 2) {
          locala.a(paramString[1]);
        }
        localArrayList.add(locala);
      }
      i += 1;
    }
  }
  
  protected void a()
  {
    String str1;
    switch (1.a[this.c.ordinal()])
    {
    default: 
      str1 = "";
    }
    for (;;)
    {
      Object localObject1 = null;
      if (p.E(this.b)) {
        localObject1 = com.baidu.android.pushservice.j.b.a(this.b, str1);
      }
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if ("com.baidu.push.sdkr".equals(str1)) {
          localObject2 = com.baidu.android.pushservice.d.c.e(this.b);
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
      try
      {
        localObject1 = a(c((String)localObject2));
        if (localObject1 != null)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (a)((Iterator)localObject1).next();
            this.a.add(localObject2);
          }
        }
      }
      catch (Exception localException)
      {
        return;
        String str2 = "com.baidu.push.sdkr";
        continue;
        str2 = "";
        continue;
        a(str2, this.a);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ArrayList localArrayList;
    try
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = a(c(paramString2));
        if (paramString2 != null)
        {
          localArrayList = new ArrayList();
          Iterator localIterator = paramString2.iterator();
          while (localIterator.hasNext()) {
            localArrayList.add(((a)localIterator.next()).c);
          }
          i = 0;
        }
      }
    }
    finally {}
    for (;;)
    {
      int i;
      if (i < this.a.size())
      {
        if (localArrayList.contains(((a)this.a.get(i)).c))
        {
          this.a.remove(i);
          i -= 1;
        }
      }
      else
      {
        this.a.addAll(paramString2);
        paramString2 = a(this.a);
        try
        {
          paramString2 = d(paramString2);
          if ("com.baidu.push.sdkr".equals(paramString1)) {
            com.baidu.android.pushservice.d.c.c(this.b, paramString2);
          }
          if (p.E(this.b)) {
            q.a(this.b, this.b.getPackageName() + ".push_sync", paramString1, paramString2);
          }
        }
        catch (Exception paramString1)
        {
          for (;;) {}
        }
        return;
      }
      i += 1;
    }
  }
  
  public a b(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((!TextUtils.isEmpty(locala.b())) && (locala.b().equals(paramString))) {
        return locala;
      }
    }
    return null;
  }
  
  public String d(String paramString)
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
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */