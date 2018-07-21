package com.baidu.carlife.k;

import android.os.Build;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.f.d;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class t
  extends com.baidu.carlife.k.a.e
{
  private static String c = null;
  private String a;
  private com.baidu.carlife.model.c b;
  
  public t()
  {
    this.tag = t.class.getSimpleName();
  }
  
  public static void b(String paramString)
  {
    c = paramString;
  }
  
  public com.baidu.carlife.model.c a()
  {
    return this.b;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  protected d getPostRequestParams()
  {
    d locald = new d();
    locald.put("protocolVersion", "1.0");
    locald.put("appID", "com.baidu.ota.carlife");
    locald.put("appVersionCode", this.a);
    locald.put("appVersionName", "1.0.0");
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
    if ((c != null) && (!c.isEmpty()))
    {
      i.b("#######", "VehicleUpdate URL: " + c);
      return c;
    }
    return com.baidu.carlife.k.a.f.a(f.d.d);
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    this.b = com.baidu.carlife.model.c.a(new JSONObject(paramString));
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */