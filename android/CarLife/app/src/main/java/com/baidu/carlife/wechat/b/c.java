package com.baidu.carlife.wechat.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private b a = b.a;
  private String b;
  private i c;
  private List<h> d;
  private j e;
  private List<b> f = new ArrayList();
  private List<b> g = new ArrayList();
  private boolean h = true;
  
  public static c a()
  {
    return a.a;
  }
  
  private String d(String paramString)
  {
    return paramString.replaceAll("ch", "c").replaceAll("sh", "s").replaceAll("zh", "z").replaceAll("f", "h").replaceAll("r", "n").replaceAll("l", "n").replaceAll("ang", "an").replaceAll("eng", "en").replaceAll("ing", "in").replaceAll(" ", "");
  }
  
  public void a(b paramb)
  {
    this.a = paramb;
  }
  
  public void a(i parami)
  {
    this.c = parami;
    this.b = parami.b();
  }
  
  public void a(j paramj)
  {
    this.e = paramj;
  }
  
  public void a(List<h> paramList)
  {
    this.d = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a(String paramString)
  {
    return TextUtils.equals(paramString, this.b);
  }
  
  public b b(String paramString)
  {
    Object localObject = k.a().b(paramString);
    if (localObject != null) {
      return (b)localObject;
    }
    b localb;
    if (paramString.startsWith("@@"))
    {
      localObject = this.g.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localb = (b)((Iterator)localObject).next();
      } while (!TextUtils.equals(localb.a(), paramString));
      return localb;
    }
    localObject = this.f.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localb = (b)((Iterator)localObject).next();
      if (TextUtils.equals(localb.a(), paramString)) {
        return localb;
      }
    }
    if (a().a(paramString)) {
      return a().f().e();
    }
    return null;
  }
  
  public void b()
  {
    this.a = b.a;
    this.b = "";
    this.c = new i();
    this.e = new j();
    this.d = null;
    this.f = new ArrayList();
    this.g = new ArrayList();
    this.h = true;
  }
  
  public void b(List<b> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (localb.k()) {
        this.g.add(localb);
      } else {
        this.f.add(localb);
      }
    }
    com.baidu.carlife.wechat.a.b.c.c("room contact size = " + this.g.size());
    com.baidu.carlife.wechat.a.b.c.c("contact size = " + this.f.size());
  }
  
  public List<b> c(String paramString)
  {
    paramString = paramString.replaceAll("，|。", "");
    paramString = d(com.baidu.carlife.wechat.a.b.b.a().a(paramString));
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.g.iterator();
    b localb;
    while (localIterator1.hasNext())
    {
      localb = (b)localIterator1.next();
      if (d(localb.c()).contains(paramString)) {
        localArrayList.add(localb);
      }
    }
    localIterator1 = this.f.iterator();
    while (localIterator1.hasNext())
    {
      localb = (b)localIterator1.next();
      if (d(localb.c()).contains(paramString)) {
        localArrayList.add(localb);
      }
    }
    localIterator1 = k.a().c().iterator();
    while (localIterator1.hasNext())
    {
      localb = ((a)localIterator1.next()).a();
      if ((localb.k()) && (d(localb.c()).contains(paramString)))
      {
        int j = 0;
        Iterator localIterator2 = localArrayList.iterator();
        do
        {
          i = j;
          if (!localIterator2.hasNext()) {
            break;
          }
        } while (!TextUtils.equals(((b)localIterator2.next()).a(), localb.a()));
        int i = 1;
        if (i == 0) {
          localArrayList.add(localb);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public b d()
  {
    return this.a;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public i f()
  {
    if (this.c == null) {
      return new i();
    }
    return this.c;
  }
  
  public j g()
  {
    if (this.e == null) {
      return new j();
    }
    return this.e;
  }
  
  public List<b> h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.g);
    localArrayList.addAll(this.f);
    return localArrayList;
  }
  
  public List<b> i()
  {
    return this.g;
  }
  
  public JSONObject j()
  {
    JSONObject localJSONObject = new JSONObject();
    if (this.e != null) {}
    try
    {
      localJSONObject.put("Sid", this.e.b());
      localJSONObject.put("Skey", this.e.a());
      localJSONObject.put("Uin", this.e.c());
      localJSONObject.put("DeviceID", com.baidu.carlife.wechat.g.c.b());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public JSONObject k()
  {
    if ((this.d == null) || (this.d.size() == 0)) {
      return null;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    int j = this.d.size();
    try
    {
      localJSONObject1.put("Count", j);
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("Key", ((h)this.d.get(i)).a);
        localJSONObject2.put("Val", ((h)this.d.get(i)).b);
        localJSONArray.put(localJSONObject2);
        i += 1;
      }
      localJSONObject1.put("List", localJSONArray);
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject1;
  }
  
  public String l()
  {
    if ((this.d == null) || (this.d.size() == 0)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j = this.d.size();
    while (i < j)
    {
      localStringBuffer.append(((h)this.d.get(i)).a + "_" + ((h)this.d.get(i)).b);
      if (i < j - 1) {
        localStringBuffer.append("%7c");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static class a
  {
    public static final c a = new c(null);
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */