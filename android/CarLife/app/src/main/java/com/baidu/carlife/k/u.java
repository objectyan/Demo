package com.baidu.carlife.k;

import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.e;
import com.baidu.carlife.k.a.f;
import com.baidu.carlife.k.a.f.d;
import com.baidu.carlife.model.r;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.util.common.PackageUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class u
  extends e
{
  public r a;
  private int b;
  
  public u()
  {
    this.tag = u.class.getSimpleName();
    GeoLocateModel localGeoLocateModel = GeoLocateModel.getInstance();
    if ((localGeoLocateModel != null) && (localGeoLocateModel.getCurrentDistrict() != null)) {
      this.b = localGeoLocateModel.getCurrentDistrict().mId;
    }
  }
  
  public r a()
  {
    return this.a;
  }
  
  protected d getPostRequestParams()
  {
    d locald = new d();
    locald.put("cityID", String.valueOf(this.b));
    locald.put("cuid", PackageUtil.getCuid());
    locald.toSign();
    return locald;
  }
  
  protected String getUrl()
  {
    return f.a(f.d.b);
  }
  
  protected int responseSuccessCallBack(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString);
    this.a = new r();
    this.a.a = paramString.optString("weather");
    this.a.b = paramString.optString("temperature");
    this.a.c = paramString.optString("washCar");
    this.a.e = paramString.optString("limit");
    this.a.d = paramString.optString("place");
    this.a.f = paramString.optString("tmpSection");
    this.a.d = paramString.optString("place");
    this.a.g = paramString.optInt("pm25");
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */