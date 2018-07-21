package com.baidu.carlife.logic;

import com.baidu.carlife.core.k;
import com.baidu.carlife.k.a.e;
import com.baidu.carlife.util.p;
import org.json.JSONException;
import org.json.JSONObject;

public class o
{
  private static final String a = "https://vehicle.baidu.com/carlife/api/getnewestactivity";
  private static final String b = "newest";
  private static final String c = "key_newest_no";
  private static final String d = "key_read_no";
  private static final String e = "key_has_news";
  private static o h;
  private e f = new a(null);
  private boolean g = p.a().a("key_has_news", false);
  
  public static o a()
  {
    if (h == null) {
      h = new o();
    }
    return h;
  }
  
  private void a(long paramLong)
  {
    this.g = p.a().a("key_has_news", false);
    long l = p.a().a("key_read_no", 0L);
    if (this.g) {
      if (paramLong > l) {
        p.a().b("key_newest_no", paramLong);
      }
    }
    for (;;)
    {
      k.b(3012);
      return;
      p.a().c("key_has_news", false);
      p.a().b("key_newest_no", paramLong);
      this.g = false;
      continue;
      if (paramLong > l)
      {
        p.a().b("key_newest_no", paramLong);
        p.a().c("key_has_news", true);
        this.g = true;
      }
    }
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public void c()
  {
    if (this.f != null)
    {
      this.f.cancel();
      this.f.toGetRequest();
    }
  }
  
  public void d()
  {
    p.a().c("key_has_news", false);
    p.a().b("key_read_no", p.a().a("key_newest_no", 0L));
    this.g = false;
  }
  
  private class a
    extends e
  {
    private a() {}
    
    protected String getUrl()
    {
      return "https://vehicle.baidu.com/carlife/api/getnewestactivity";
    }
    
    protected int responseSuccessCallBack(String paramString)
    {
      try
      {
        paramString = new JSONObject(paramString);
        o.a(o.this, paramString.optLong("newest"));
        return 0;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */