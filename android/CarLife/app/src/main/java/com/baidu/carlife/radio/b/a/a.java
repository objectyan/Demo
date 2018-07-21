package com.baidu.carlife.radio.b.a;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.util.k;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a
  implements com.baidu.carlife.d.a.c, b
{
  protected static final String a = "radio_request";
  protected long b = 0L;
  private Map<String, String> c;
  
  private String b(Map<String, String> paramMap)
  {
    Object localObject = new ArrayList(paramMap.keySet());
    Collections.sort((List)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    try
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (i > 0) {
          localStringBuilder.append("&");
        }
        localStringBuilder.append(String.format("%s=%s", new Object[] { str, paramMap.get(str) }));
        i += 1;
      }
      localStringBuilder.append("&");
      localStringBuilder.append(String.format("%s=%s", new Object[] { "token", d() }));
    }
    catch (Exception paramMap)
    {
      for (;;)
      {
        paramMap.printStackTrace();
      }
    }
    return k.a(localStringBuilder.toString());
  }
  
  private String d()
  {
    return "208f3bc80b5167f299f5928c2c22feac";
  }
  
  private Map<String, String> e()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cuid", PackageUtil.getCuid());
    localHashMap.put("device_from", "1");
    localHashMap.put("sv", com.baidu.carlife.core.e.g());
    localHashMap.put("channel", com.baidu.carlife.util.c.c());
    localHashMap.put("vehicle_channel", f.jx.a());
    Object localObject = BNLocationManagerProxy.getInstance().getCurLocation();
    if (localObject != null)
    {
      localObject = CoordinateTransformUtil.transferGCJ02ToBD09(((LocData)localObject).longitude, ((LocData)localObject).latitude);
      double d1 = ((GeoPoint)localObject).getLongitudeE6() / 100000.0D;
      double d2 = ((GeoPoint)localObject).getLatitudeE6() / 100000.0D;
      localHashMap.put("lng", String.valueOf(d1));
      localHashMap.put("lat", String.valueOf(d2));
    }
    localObject = NaviAccountUtils.getInstance().getUid();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localHashMap.put("uuid", localObject);
    }
    localHashMap.put("product", "carlife");
    localHashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
    return localHashMap;
  }
  
  public void a(Bundle paramBundle)
  {
    this.c = com.baidu.carlife.radio.b.b.a(paramBundle);
    c();
  }
  
  protected void a(String paramString, Map<String, String> paramMap, com.baidu.carlife.d.a.c paramc)
  {
    com.baidu.carlife.d.a.e.a(paramString, paramMap, paramc);
  }
  
  public Map<String, String> b()
  {
    return this.c;
  }
  
  public void c()
  {
    Map localMap = b();
    String str;
    if (localMap == null)
    {
      localMap = e();
      localMap.put("sign", b(localMap));
      str = NaviAccountUtils.getInstance().syncGetBduss();
      if (!TextUtils.isEmpty(str)) {
        break label76;
      }
      com.baidu.carlife.d.a.e.c();
    }
    for (;;)
    {
      this.b = System.currentTimeMillis();
      a(a(), localMap, this);
      return;
      localMap.putAll(e());
      break;
      label76:
      com.baidu.carlife.d.a.e.a("bduss", str, c.b());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */