package com.baidu.android.pushservice.j;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.b.b;
import com.baidu.android.pushservice.b.f;
import com.baidu.android.pushservice.k.e;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g
{
  private static int a = 4;
  
  public static String a()
  {
    String str = "";
    for (;;)
    {
      try
      {
        Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
        if (localEnumeration1.hasMoreElements())
        {
          Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
          if (localEnumeration2.hasMoreElements())
          {
            InetAddress localInetAddress = (InetAddress)localEnumeration2.nextElement();
            if (!localInetAddress.isLoopbackAddress()) {
              str = localInetAddress.getHostAddress().toString();
            }
          }
        }
        else
        {
          if (TextUtils.isEmpty(str)) {
            return "";
          }
          int i = str.indexOf('%');
          if (i == -1) {
            break;
          }
          str = str.substring(0, i);
          return str;
        }
      }
      catch (SocketException localSocketException)
      {
        return "";
      }
    }
    return localSocketException;
  }
  
  public static String a(Context paramContext)
  {
    Object localObject = ((WifiManager)paramContext.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getBSSID();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return (String)localObject;
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    localObject = paramContext.getCellLocation();
    int i;
    int j;
    if ((localObject instanceof GsmCellLocation))
    {
      paramContext = (GsmCellLocation)paramContext.getCellLocation();
      i = paramContext.getLac();
      j = paramContext.getCid();
      return j + "" + i;
    }
    if ((localObject instanceof CdmaCellLocation))
    {
      paramContext = (CdmaCellLocation)paramContext.getCellLocation();
      i = paramContext.getBaseStationId();
      j = paramContext.getNetworkId();
      int k = paramContext.getSystemId();
      return i + "" + j + "" + k;
    }
    return "";
  }
  
  public static String a(Context paramContext, JSONObject paramJSONObject)
  {
    if ((paramContext == null) || (paramJSONObject == null)) {
      return null;
    }
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      if (paramJSONObject.has("cityCode")) {
        localJSONObject1.put("city_code", paramJSONObject.optString("cityCode"));
      }
      if (paramJSONObject.has("location"))
      {
        JSONObject localJSONObject2 = paramJSONObject.getJSONObject("location");
        JSONObject localJSONObject3 = new JSONObject();
        if (localJSONObject2 != null)
        {
          localJSONObject3.put("latitude", localJSONObject2.getString("lat"));
          localJSONObject3.put("longitude", localJSONObject2.getString("lng"));
        }
        if (paramJSONObject.has("accuracy")) {
          localJSONObject3.put("accuracy", paramJSONObject.optString("accuracy"));
        }
        localJSONObject1.put("location", localJSONObject3);
      }
      m.a(paramContext, "com.baidu.android.pushservice.lbscache", localJSONObject1.toString());
      return localJSONObject1.toString();
    }
    catch (JSONException paramContext) {}
    return null;
  }
  
  public static String a(Context paramContext, boolean paramBoolean)
  {
    String str1 = PushSettings.a(paramContext);
    String str2;
    String str3;
    Object localObject;
    JSONArray localJSONArray;
    JSONObject localJSONObject1;
    int i;
    if (!TextUtils.isEmpty(str1))
    {
      str2 = c(paramContext);
      if (!TextUtils.isEmpty(str2))
      {
        if ((!paramBoolean) && (!d(paramContext))) {
          return null;
        }
        str3 = a();
        localObject = b.a(paramContext);
        localJSONArray = new JSONArray();
        localJSONObject1 = new JSONObject();
        localObject = (ArrayList)((b)localObject).a.clone();
        i = 0;
      }
    }
    for (;;)
    {
      JSONObject localJSONObject2;
      if (i < ((ArrayList)localObject).size()) {
        if (!TextUtils.isEmpty(((f)((ArrayList)localObject).get(i)).a())) {
          localJSONObject2 = new JSONObject();
        }
      }
      try
      {
        localJSONObject2.put("userid", p.a(((f)((ArrayList)localObject).get(i)).f));
        localJSONObject2.put("appid", ((f)((ArrayList)localObject).get(i)).a());
        localJSONArray.put(localJSONObject2);
        i += 1;
        continue;
        if (localJSONArray.length() > 0) {}
        try
        {
          localJSONObject1.put("channelid", str1);
          localJSONObject1.put("cuid", e.a(paramContext));
          localJSONObject1.put("nettype", p.t(paramContext.getApplicationContext()));
          localJSONObject1.put("clients", localJSONArray);
          localJSONObject1.put("apinfo", str2);
          localJSONObject1.put("cip", str3);
          localJSONObject1.put("model", Build.MODEL);
          localJSONObject1.put("version", Build.VERSION.RELEASE);
          localJSONObject1.put("sdkversion", com.baidu.android.pushservice.a.a());
          if (p.F(paramContext)) {
            localJSONObject1.put("connect_version", 3);
          }
          return localJSONObject1.toString();
          return null;
        }
        catch (JSONException paramContext)
        {
          for (;;) {}
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    m.a(paramContext, "com.baidu.pushservice.clt", paramLong);
  }
  
  public static long b(Context paramContext)
  {
    if (paramContext == null) {
      return 0L;
    }
    return m.c(paramContext, "com.baidu.pushservice.clt");
  }
  
  public static String c(Context paramContext)
  {
    return new com.baidu.b.a.a(paramContext.getApplicationContext()).a(a);
  }
  
  private static boolean d(Context paramContext)
  {
    if (paramContext == null) {}
    String str1;
    String str2;
    do
    {
      return false;
      str1 = a(paramContext);
      str2 = m.a(paramContext, "com.baidu.android.pushservice.lac");
      if (TextUtils.isEmpty(str1)) {
        break;
      }
    } while ((TextUtils.equals(str1, str2)) && (System.currentTimeMillis() - b(paramContext) < 604800000L));
    m.a(paramContext, "com.baidu.android.pushservice.lac", str1);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */