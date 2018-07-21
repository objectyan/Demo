package com.baidu.mobstat;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class cf
{
  private volatile long a = 0L;
  private volatile long b = 0L;
  private volatile long c = 0L;
  private volatile long d = 0L;
  private volatile long e = 0L;
  private volatile int f = 0;
  private List<cg> g = new ArrayList();
  
  public cf()
  {
    long l = System.currentTimeMillis();
    this.a = l;
    this.e = l;
  }
  
  public static JSONObject a(cg paramcg, long paramLong)
  {
    long l = 0L;
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("n", paramcg.a());
      localJSONObject.put("d", paramcg.c());
      paramLong = paramcg.d() - paramLong;
      if (paramLong < 0L)
      {
        paramLong = l;
        localJSONObject.put("ps", paramLong);
        localJSONObject.put("t", paramcg.b());
        if (!paramcg.f()) {
          break label122;
        }
      }
      label122:
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("at", i);
        paramcg = paramcg.e();
        if ((paramcg != null) && (paramcg.length() != 0)) {
          localJSONObject.put("ext", paramcg);
        }
        return localJSONObject;
        break;
      }
      return localJSONObject;
    }
    catch (JSONException paramcg)
    {
      db.b(paramcg);
    }
  }
  
  private void a(List<cg> paramList, cg paramcg)
  {
    if (paramList == null) {}
    cg localcg;
    do
    {
      do
      {
        return;
      } while (paramcg == null);
      int i = paramList.size();
      if (i == 0)
      {
        paramList.add(paramcg);
        return;
      }
      localcg = (cg)paramList.get(i - 1);
      if ((TextUtils.isEmpty(cg.b(localcg))) || (TextUtils.isEmpty(cg.b(paramcg))))
      {
        paramList.add(paramcg);
        return;
      }
      if ((!cg.b(localcg).equals(cg.b(paramcg))) || (cg.c(localcg) == cg.c(paramcg)))
      {
        paramList.add(paramcg);
        return;
      }
    } while (!cg.c(localcg));
    localcg.a(paramcg);
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    c(l);
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = l;
    this.f = 0;
    this.f = 0;
    this.g.clear();
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void a(cg paramcg)
  {
    a(this.g, paramcg);
  }
  
  public long b()
  {
    return this.a;
  }
  
  public void b(long paramLong)
  {
    this.d = paramLong;
  }
  
  public long c()
  {
    return this.b;
  }
  
  public void c(long paramLong)
  {
    this.a = paramLong;
  }
  
  public JSONObject d()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("s", this.a);
      localJSONObject.put("e", this.b);
      localJSONObject.put("i", this.e);
      localJSONObject.put("c", 1);
      localJSONObject.put("s2", this.c);
      localJSONObject.put("e2", this.d);
      localJSONObject.put("pc", this.f);
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < this.g.size())
      {
        localJSONArray.put(a((cg)this.g.get(i), this.a));
        i += 1;
      }
      localJSONObject.put("p", localJSONArray);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      db.a("StatSession.constructJSONObject() failed");
    }
    return localJSONObject;
  }
  
  public void d(long paramLong)
  {
    this.b = paramLong;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */