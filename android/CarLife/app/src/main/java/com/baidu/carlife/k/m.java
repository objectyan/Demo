package com.baidu.carlife.k;

import android.content.Context;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.f;
import com.baidu.carlife.k.a.f.a;
import com.baidu.carlife.logic.t;
import com.baidu.carlife.model.l;
import com.baidu.carlife.util.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m
  extends com.baidu.carlife.k.a.e
{
  private List<l> a;
  
  public m(Context paramContext)
  {
    super(paramContext, "sign");
    this.tag = m.class.getSimpleName();
  }
  
  public List<l> a()
  {
    return this.a;
  }
  
  protected String getUrl()
  {
    return f.a(f.a.b);
  }
  
  protected d getUrlParams()
  {
    d locald = new d();
    locald.put("cuid", c.b());
    locald.put("os", "0");
    locald.put("sv", com.baidu.carlife.core.e.g());
    return locald;
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString).optJSONArray("list");
    int j;
    if (paramString != null)
    {
      j = paramString.length();
      if (j >= 1) {}
    }
    else
    {
      return -3;
    }
    t.a();
    this.a = new ArrayList();
    int i = 0;
    while (i < j)
    {
      l locall = l.a(paramString.optJSONObject(i));
      if (locall != null) {
        this.a.add(locall);
      }
      i += 1;
    }
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */