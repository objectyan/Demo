package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CooperService
  implements ICooperService
{
  private static CooperService a;
  private bu b = new bu();
  
  static CooperService a()
  {
    try
    {
      if (a == null) {
        a = new CooperService();
      }
      CooperService localCooperService = a;
      return localCooperService;
    }
    finally {}
  }
  
  private static String a(Context paramContext)
  {
    String str = de.j(paramContext);
    paramContext = str;
    if (!TextUtils.isEmpty(str)) {
      paramContext = str.replaceAll(":", "");
    }
    return paramContext;
  }
  
  private String a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramContext = b(paramContext);; paramContext = a(paramContext))
    {
      Object localObject = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        localObject = "";
      }
      return (String)localObject;
    }
  }
  
  private static String b(Context paramContext)
  {
    String str = de.i(paramContext);
    paramContext = str;
    if (!TextUtils.isEmpty(str)) {
      paramContext = str.replaceAll(":", "");
    }
    return paramContext;
  }
  
  private static String c(Context paramContext)
  {
    String str = de.k(paramContext);
    paramContext = str;
    if (!TextUtils.isEmpty(str)) {
      paramContext = str.replaceAll(":", "");
    }
    return paramContext;
  }
  
  private String d(Context paramContext)
  {
    try
    {
      if ((this.b.m == null) || (this.b.m.equals("")))
      {
        boolean bool = bj.a().h(paramContext);
        if (bool) {
          this.b.m = bj.a().g(paramContext);
        }
        if ((!bool) || (this.b.m == null) || (this.b.m.equals(""))) {
          this.b.m = de.a(paramContext, "BaiduMobAd_CHANNEL");
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        db.a(paramContext);
      }
    }
    return this.b.m;
  }
  
  public boolean checkCellLocationSetting(Context paramContext)
  {
    return "true".equalsIgnoreCase(de.a(paramContext, "BaiduMobAd_CELL_LOCATION"));
  }
  
  public boolean checkGPSLocationSetting(Context paramContext)
  {
    return "true".equals(de.a(paramContext, "BaiduMobAd_GPS_LOCATION"));
  }
  
  public boolean checkWifiLocationSetting(Context paramContext)
  {
    return "true".equalsIgnoreCase(de.a(paramContext, "BaiduMobAd_WIFI_LOCATION"));
  }
  
  public void enableDeviceMac(Context paramContext, boolean paramBoolean)
  {
    bj.a().d(paramContext, paramBoolean);
  }
  
  public String getAppChannel(Context paramContext)
  {
    return d(paramContext);
  }
  
  public String getAppKey(Context paramContext)
  {
    if (this.b.f == null) {
      this.b.f = de.a(paramContext, "BaiduMobAd_STAT_ID");
    }
    return this.b.f;
  }
  
  public int getAppVersionCode(Context paramContext)
  {
    if (this.b.h == -1) {
      this.b.h = de.e(paramContext);
    }
    return this.b.h;
  }
  
  public String getAppVersionName(Context paramContext)
  {
    if (TextUtils.isEmpty(this.b.i)) {
      this.b.i = de.f(paramContext);
    }
    return this.b.i;
  }
  
  public String getCUID(Context paramContext, boolean paramBoolean)
  {
    if (this.b.g == null)
    {
      this.b.g = bj.a().f(paramContext);
      if ((this.b.g != null) && (!"".equalsIgnoreCase(this.b.g))) {}
    }
    try
    {
      this.b.g = dg.a(paramContext);
      Matcher localMatcher = Pattern.compile("\\s*|\t|\r|\n").matcher(this.b.g);
      this.b.g = localMatcher.replaceAll("");
      this.b.g = getSecretValue(this.b.g);
      bj.a().b(paramContext, this.b.g);
      if (paramBoolean) {
        return this.b.g;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        db.c(paramContext.getMessage());
      }
      try
      {
        paramContext = this.b.g;
        if (!TextUtils.isEmpty(paramContext))
        {
          paramContext = new String(ct.b(1, cv.a(paramContext.getBytes())));
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        db.a(paramContext);
      }
    }
    return null;
  }
  
  public String getDeviceId(TelephonyManager paramTelephonyManager, Context paramContext)
  {
    localObject = this.b.j;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return this.b.j;
    }
    if (bj.a().j(paramContext))
    {
      this.b.j = getMacIdForTv(paramContext);
      return this.b.j;
    }
    if (paramTelephonyManager == null) {
      return this.b.j;
    }
    Pattern localPattern = Pattern.compile("\\s*|\t|\r|\n");
    try
    {
      String str = paramTelephonyManager.getDeviceId();
      paramTelephonyManager = (TelephonyManager)localObject;
      if (str != null) {
        paramTelephonyManager = localPattern.matcher(str).replaceAll("");
      }
    }
    catch (Exception paramTelephonyManager)
    {
      try
      {
        paramTelephonyManager = c(paramContext);
        if (TextUtils.isEmpty(paramTelephonyManager)) {
          break label168;
        }
        localObject = paramTelephonyManager;
        if (!paramTelephonyManager.equals("000000000000000")) {
          break label176;
        }
        localObject = bj.a().e(paramContext);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label194;
        }
        paramTelephonyManager = (TelephonyManager)localObject;
        if (!((String)localObject).equals("000000000000000")) {
          break label259;
        }
        paramTelephonyManager = new Date().getTime() + "";
        paramTelephonyManager = "hol" + paramTelephonyManager.hashCode() + "mes";
        bj.a().a(paramContext, paramTelephonyManager);
        this.b.j = paramTelephonyManager;
        this.b.j = getSecretValue(this.b.j);
        return this.b.j;
        paramTelephonyManager = paramTelephonyManager;
        db.a(paramTelephonyManager);
        paramTelephonyManager = (TelephonyManager)localObject;
      }
      catch (Exception paramTelephonyManager)
      {
        for (;;)
        {
          db.a(paramTelephonyManager);
          paramTelephonyManager = (TelephonyManager)localObject;
        }
      }
    }
    if (paramTelephonyManager != null)
    {
      localObject = paramTelephonyManager;
      if (!paramTelephonyManager.equals("000000000000000")) {}
    }
    else
    {
      localObject = a(paramContext);
    }
    paramTelephonyManager = (TelephonyManager)localObject;
    if (de.s(paramContext)) {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramTelephonyManager = (TelephonyManager)localObject;
        if (!((String)localObject).equals("000000000000000")) {
          break label150;
        }
      }
    }
  }
  
  public bu getHeadObject()
  {
    return this.b;
  }
  
  public JSONObject getHeaderExt(Context paramContext)
  {
    Object localObject = bj.a().l(paramContext);
    paramContext = new JSONObject();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = new JSONObject((String)localObject);
        return (JSONObject)localObject;
      }
      catch (JSONException localJSONException)
      {
        return paramContext;
      }
    }
    return paramContext;
  }
  
  public String getHost()
  {
    return Config.LOG_SEND_URL;
  }
  
  public String getLinkedWay(Context paramContext)
  {
    if (TextUtils.isEmpty(this.b.s)) {
      this.b.s = de.o(paramContext);
    }
    return this.b.s;
  }
  
  public String getMTJSDKVersion()
  {
    return "3.7.6.1";
  }
  
  public String getMacAddress(Context paramContext, boolean paramBoolean)
  {
    String str1 = "02:00:00:00:00:00".replace(":", "");
    if ((!paramBoolean) && (Build.VERSION.SDK_INT >= 23)) {
      return getSecretValue(str1);
    }
    if (!TextUtils.isEmpty(this.b.t)) {
      return this.b.t;
    }
    String str2 = bj.a().i(paramContext);
    if (!TextUtils.isEmpty(str2))
    {
      this.b.t = str2;
      return this.b.t;
    }
    str2 = a(paramContext, paramBoolean);
    if ((!TextUtils.isEmpty(str2)) && (!str1.equals(str2)))
    {
      str1 = getSecretValue(str2);
      this.b.t = str1;
      bj.a().d(paramContext, this.b.t);
      return this.b.t;
    }
    this.b.t = "";
    return this.b.t;
  }
  
  public String getMacIdForTv(Context paramContext)
  {
    if (!TextUtils.isEmpty(this.b.u)) {
      return this.b.u;
    }
    String str = bj.a().k(paramContext);
    if (!TextUtils.isEmpty(str))
    {
      this.b.u = str;
      return this.b.u;
    }
    str = de.c(1, paramContext);
    if (!TextUtils.isEmpty(str))
    {
      this.b.u = str;
      bj.a().e(paramContext, str);
      return this.b.u;
    }
    this.b.u = "";
    return this.b.u;
  }
  
  public String getManufacturer()
  {
    if (TextUtils.isEmpty(this.b.p)) {
      this.b.p = Build.MANUFACTURER;
    }
    return this.b.p;
  }
  
  public String getOSSysVersion()
  {
    if (TextUtils.isEmpty(this.b.d)) {
      this.b.d = Build.VERSION.RELEASE;
    }
    return this.b.d;
  }
  
  public String getOSVersion()
  {
    if (TextUtils.isEmpty(this.b.c)) {
      this.b.c = Integer.toString(Build.VERSION.SDK_INT);
    }
    return this.b.c;
  }
  
  public String getOperator(TelephonyManager paramTelephonyManager)
  {
    if (TextUtils.isEmpty(this.b.n)) {
      this.b.n = paramTelephonyManager.getNetworkOperator();
    }
    return this.b.n;
  }
  
  public String getPhoneModel()
  {
    if (TextUtils.isEmpty(this.b.o)) {
      this.b.o = Build.MODEL;
    }
    return this.b.o;
  }
  
  public String getSecretValue(String paramString)
  {
    return ct.c(1, paramString.getBytes());
  }
  
  public int getTagValue()
  {
    return 1;
  }
  
  public String getUUID()
  {
    return UUID.randomUUID().toString().replace("-", "");
  }
  
  public void installHeader(Context paramContext, JSONObject paramJSONObject)
  {
    this.b.a(paramContext, paramJSONObject);
  }
  
  public boolean isDeviceMacEnabled(Context paramContext)
  {
    return bj.a().m(paramContext);
  }
  
  public void resetHeadSign()
  {
    this.b.y = a().getUUID();
  }
  
  public void setHeaderExt(Context paramContext, ExtraInfo paramExtraInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramExtraInfo != null) {
      localJSONObject = paramExtraInfo.dumpToJson();
    }
    this.b.a(localJSONObject);
    bj.a().f(paramContext, localJSONObject.toString());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/CooperService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */