package com.baidu.carlife.k;

import android.text.TextUtils;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.e;
import com.baidu.carlife.k.a.f;
import com.baidu.carlife.k.a.f.d;
import com.baidu.carlife.util.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class n
  extends e
{
  private a a;
  private String b;
  
  public n()
  {
    this.tag = n.class.getSimpleName();
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  protected d getPostRequestParams()
  {
    Object localObject;
    if (this.a == null) {
      localObject = null;
    }
    d locald;
    do
    {
      return (d)localObject;
      locald = new d();
      locald.put("channel", this.a.b);
      if (("harman".equals(this.a.a.toLowerCase())) || (f.a.k.a().equals(this.a.a)) || (f.a.l.a().equals(this.a.a))) {
        this.a.a = this.a.f;
      }
      locald.put("cuid", this.a.a);
      locald.put("version", this.a.c);
      locald.put("os", this.a.d);
      locald.put("mb", this.a.e);
      locald.put("mCuid", this.a.f);
      locald.put("appVer", this.a.g);
      locald.put("loc", "" + this.a.h);
      locald.put("isConn", "" + this.a.i);
      localObject = locald;
    } while (this.a.j == null);
    int i = 0;
    for (;;)
    {
      localObject = locald;
      if (i >= this.a.j.size()) {
        break;
      }
      locald.put("item" + i, (String)this.a.j.get(i));
      i += 1;
    }
  }
  
  protected String getUrl()
  {
    return f.a(f.d.a);
  }
  
  protected int responseSuccessCallBack(String paramString)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      paramString = new File(s.b + this.b);
      if (paramString.exists()) {
        paramString.delete();
      }
    }
    return 0;
  }
  
  public static class a
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public int h;
    public int i;
    public ArrayList<String> j;
    
    public String a(String paramString)
    {
      if (this.j == null) {
        this.j = new ArrayList();
      }
      this.j.add(paramString);
      return paramString;
    }
    
    public JSONObject a(String paramString, Map<String, String> paramMap, long paramLong)
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2;
      try
      {
        localJSONObject2 = new JSONObject();
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject2.put(str, paramMap.get(str));
        }
        localJSONObject1.put("act", paramString);
      }
      catch (Exception paramString)
      {
        i.e("StatisticMobileParams", paramString.toString());
        return null;
      }
      localJSONObject1.put("ActParam", localJSONObject2);
      localJSONObject1.put("tm", paramLong);
      a(localJSONObject1.toString());
      return localJSONObject1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */