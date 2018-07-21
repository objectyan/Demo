package com.baidu.carlife.k;

import android.os.Build;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.f.d;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.baidu.carlife.k.a.e
{
  private com.baidu.carlife.model.c a;
  
  public a()
  {
    this.tag = a.class.getSimpleName();
  }
  
  public com.baidu.carlife.model.c a()
  {
    return this.a;
  }
  
  protected d getPostRequestParams()
  {
    d locald = new d();
    locald.put("protocolVersion", "1.0");
    locald.put("appID", com.baidu.carlife.core.e.f());
    locald.put("appVersionCode", String.valueOf(com.baidu.carlife.core.e.h()));
    locald.put("appVersionName", com.baidu.carlife.core.e.g());
    locald.put("channel", com.baidu.carlife.util.c.c());
    locald.put("model", Build.MODEL);
    locald.put("subModel", "unknow");
    locald.put("platform", "Android");
    locald.put("language", Locale.getDefault().getLanguage());
    locald.put("resolution", com.baidu.carlife.core.e.c());
    locald.put("carModel", com.baidu.carlife.core.f.jx.a());
    locald.put("chipModel", Build.HARDWARE);
    LocData localLocData = BNLocationManagerProxy.getInstance().getCurLocation();
    if (localLocData != null)
    {
      locald.put("longitude", String.valueOf(localLocData.longitude));
      locald.put("latitude", String.valueOf(localLocData.latitude));
    }
    for (;;)
    {
      locald.toSign();
      return locald;
      locald.put("longitude", "unknow");
      locald.put("latitude", "unknow");
    }
  }
  
  protected String getUrl()
  {
    return com.baidu.carlife.k.a.f.a(f.d.d);
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    this.a = com.baidu.carlife.model.c.a(new JSONObject(paramString));
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */