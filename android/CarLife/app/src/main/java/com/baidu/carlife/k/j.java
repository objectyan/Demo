package com.baidu.carlife.k;

import android.text.TextUtils;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.e;
import com.baidu.carlife.k.a.f.c;
import com.baidu.carlife.util.k;
import com.baidu.navi.util.NaviAccountUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class j
  extends e
{
  private List<com.baidu.carlife.model.f> a;
  private String b;
  private String c;
  
  public j()
  {
    this.tag = j.class.getSimpleName();
  }
  
  public List<com.baidu.carlife.model.f> a()
  {
    return this.a;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }
  
  protected d getPostRequestParams()
  {
    Object localObject = null;
    if (NaviAccountUtils.getInstance().isLogin())
    {
      d locald = new d();
      locald.put("m", NaviAccountUtils.getInstance().getSecurePhoneNum());
      locald.put("token", "76646ec3a3d2c05957a44f59bf4978c76ab80b92");
      localObject = String.valueOf(System.currentTimeMillis() / 1000L);
      locald.put("t", (String)localObject);
      locald.put("sn", k.a((String)localObject + "baiduCarlife"));
      localObject = locald;
      if (!TextUtils.isEmpty(this.c))
      {
        locald.put("orderid", this.b);
        locald.put("serialid", this.c);
        localObject = locald;
      }
    }
    return (d)localObject;
  }
  
  protected String getUrl()
  {
    return com.baidu.carlife.k.a.f.a(f.c.d);
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString).optJSONObject("result");
    if (paramString == null) {
      return -1;
    }
    this.a = com.baidu.carlife.model.f.a(paramString.optJSONArray("queues"));
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */