package com.baidu.carlife.k;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.carlife.k.a.e;
import com.baidu.carlife.k.a.f;
import com.baidu.carlife.k.a.f.b;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.vi.VDeviceAPI;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends e
{
  private String a;
  private Context b;
  
  public d(String paramString, Context paramContext)
  {
    this.a = paramString;
    this.b = paramContext;
  }
  
  protected com.baidu.carlife.k.a.d getPostRequestParams()
  {
    String str = VDeviceAPI.getPhoneType().replace(" ", "");
    com.baidu.carlife.k.a.d locald = new com.baidu.carlife.k.a.d();
    locald.put("appname", this.a);
    locald.put("appvn", PackageUtil.getVersionName());
    locald.put("pkgname", PackageUtil.getPackageName());
    locald.put("sdkvn", "1.0.0");
    locald.put("os", "android");
    locald.put("model", str);
    return locald;
  }
  
  protected String getUrl()
  {
    return f.a(f.b.a);
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    Object localObject = new JSONObject(paramString);
    if ((localObject == null) && (!((JSONObject)localObject).has("clientid")) && (!((JSONObject)localObject).has("appid")) && (!((JSONObject)localObject).has("devid"))) {
      return -1;
    }
    paramString = ((JSONObject)localObject).optString("clientid");
    String str = ((JSONObject)localObject).getString("appid");
    localObject = ((JSONObject)localObject).getString("devid");
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject))) {
      return -3;
    }
    PreferenceHelper.getInstance(this.b).putString("feedback_clientid", paramString);
    PreferenceHelper.getInstance(this.b).putString("feedback_appid", str);
    PreferenceHelper.getInstance(this.b).putString("feedback_deviceid", (String)localObject);
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */