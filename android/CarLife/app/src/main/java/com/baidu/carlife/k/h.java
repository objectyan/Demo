package com.baidu.carlife.k;

import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.f;
import com.baidu.carlife.k.a.f.c;
import com.baidu.carlife.util.k;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends com.baidu.carlife.k.a.e
{
  private int a;
  private List<com.baidu.carlife.model.e> b;
  
  public h()
  {
    this.tag = h.class.getSimpleName();
  }
  
  public List<com.baidu.carlife.model.e> a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.a;
  }
  
  protected d getPostRequestParams()
  {
    LocData localLocData = BNLocationManagerProxy.getInstance().getCurLocation();
    if (localLocData == null) {
      return null;
    }
    d locald = new d();
    locald.put("token", "76646ec3a3d2c05957a44f59bf4978c76ab80b92");
    long l = System.currentTimeMillis() / 1000L;
    locald.put("t", String.valueOf(l));
    locald.put("sn", k.a(l + "baiduCarlife"));
    locald.put("lat", String.valueOf(localLocData.latitude));
    locald.put("lng", String.valueOf(localLocData.longitude));
    locald.put("page", String.valueOf(this.a));
    return locald;
  }
  
  protected String getUrl()
  {
    return f.a(f.c.a);
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString);
    if ((paramString == null) || (!paramString.has("result"))) {}
    Object localObject;
    int j;
    do
    {
      do
      {
        return -3;
        localObject = paramString.optJSONObject("result");
        paramString = ((JSONObject)localObject).optJSONArray("shops");
      } while (paramString == null);
      j = paramString.length();
    } while (j < 1);
    this.a = ((JSONObject)localObject).optInt("nextPage");
    this.b = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localObject = com.baidu.carlife.model.e.a(paramString.optJSONObject(i));
      if (localObject != null) {
        this.b.add(localObject);
      }
      i += 1;
    }
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */