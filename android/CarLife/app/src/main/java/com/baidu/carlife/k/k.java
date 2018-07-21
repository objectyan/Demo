package com.baidu.carlife.k;

import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.e;
import com.baidu.carlife.model.g;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class k
  extends e
{
  private List<g> a;
  
  public k()
  {
    this.tag = k.class.getSimpleName();
  }
  
  public List<g> a()
  {
    return this.a;
  }
  
  protected d getPostRequestParams()
  {
    Object localObject = BNLocationManagerProxy.getInstance().getCurLocation();
    if (localObject == null) {
      return null;
    }
    d locald = new d();
    localObject = CoordinateTransformUtil.transferGCJ02ToBD09(((LocData)localObject).longitude, ((LocData)localObject).latitude);
    double d1 = ((GeoPoint)localObject).getLongitudeE6() / 100000.0D;
    double d2 = ((GeoPoint)localObject).getLatitudeE6() / 100000.0D;
    locald.put("userName", "baiducarlife");
    locald.put("userPwd", "84e08663f0e03dd5479133dd1a370320");
    locald.put("longitude", String.valueOf(d1));
    locald.put("latitude", String.valueOf(d2));
    locald.put("secretSign", com.baidu.carlife.util.k.a("baiducarlife" + "84e08663f0e03dd5479133dd1a370320" + d2 + d1).toLowerCase());
    locald.put("distance", "1000");
    locald.put("pageSize", "50");
    locald.put("currentPage", "1");
    return locald;
  }
  
  protected String getUrl()
  {
    return "http://api.soargift.com:8998/parkApi/queryNearbyParkInfoList";
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString).optJSONArray("parkDistanceList");
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
    this.a = new ArrayList();
    int i = 0;
    while (i < j)
    {
      g localg = g.a(paramString.optJSONObject(i));
      if (localg != null) {
        this.a.add(localg);
      }
      i += 1;
    }
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */