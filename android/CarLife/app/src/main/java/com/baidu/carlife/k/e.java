package com.baidu.carlife.k;

import android.content.Context;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.f;
import com.baidu.carlife.k.a.f.b;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.google.gson.Gson;
import java.util.List;
import org.json.JSONException;

public class e
  extends com.baidu.carlife.k.a.e
{
  private String a;
  private String b;
  private String c;
  private List<String> d;
  private Context e;
  
  public e(String paramString1, String paramString2, String paramString3, List<String> paramList, Context paramContext)
  {
    this.tag = e.class.getSimpleName();
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramList;
    this.e = paramContext;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(List<String> paramList)
  {
    this.d = paramList;
  }
  
  public void b(String paramString)
  {
    this.a = paramString;
  }
  
  protected d getPostRequestParams()
  {
    d locald = new d();
    String str1 = VDeviceAPI.getPhoneType().replace(" ", "");
    String str2 = PreferenceHelper.getInstance(this.e).getString("feedback_clientid", "");
    String str3 = PreferenceHelper.getInstance(this.e).getString("feedback_appid", "");
    String str4 = PreferenceHelper.getInstance(this.e).getString("feedback_deviceid", "");
    String str5 = new Gson().toJson(this.d);
    locald.put("clientid", str2);
    locald.put("devid", str4);
    locald.put("appid", str3);
    locald.put("uid", NaviAccountUtils.getInstance().getUid());
    locald.put("userid", NaviAccountUtils.getInstance().getUid());
    locald.put("username", NaviAccountUtils.getInstance().getUserName());
    locald.put("osvn", PackageUtil.strOSVersion);
    locald.put("appvn", PackageUtil.getVersionName());
    locald.put("model", str1);
    locald.put("content", this.a);
    locald.put("contact_way", this.b);
    if (this.d != null) {
      locald.put("screenshot", str5);
    }
    locald.put("feedback_type", this.c);
    locald.put("baiducuid", PackageUtil.getCuid());
    locald.toSign("token");
    return locald;
  }
  
  protected String getUrl()
  {
    return f.a(f.b.b);
  }
  
  protected void responseErrorCallBack(int paramInt)
  {
    super.responseErrorCallBack(paramInt);
    StatisticManager.onEvent("1030", "UPLOAD_FEEDBACK_FAIL");
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    StatisticManager.onEvent("1030", "UPLOAD_FEEDBACK_SUCCESS");
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */