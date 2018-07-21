package com.baidu.platform.comapi.search;

import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddrResult
  implements ResultBase
{
  public String address;
  public AddressDetail addressDetail;
  public String buildingId;
  public String business;
  public String floorId;
  public String indoorPano;
  public String nearby;
  public int pano;
  private Point point;
  private int requestId;
  public String streetId;
  private ArrayList<GeoPoiInfo> surround_poi;
  
  public Point getPoint()
  {
    return this.point;
  }
  
  public int getRequestId()
  {
    return this.requestId;
  }
  
  public GeoPoiInfo getSurround_poi(int paramInt)
  {
    if (this.surround_poi.size() > paramInt) {
      return (GeoPoiInfo)this.surround_poi.get(paramInt);
    }
    return null;
  }
  
  public ArrayList<GeoPoiInfo> getSurround_poi()
  {
    return this.surround_poi;
  }
  
  void setPoint(Point paramPoint)
  {
    this.point = paramPoint;
  }
  
  public void setRequestId(int paramInt)
  {
    this.requestId = paramInt;
  }
  
  void setSurround_poi(GeoPoiInfo paramGeoPoiInfo)
  {
    if (this.surround_poi == null) {
      this.surround_poi = new ArrayList();
    }
    this.surround_poi.add(paramGeoPoiInfo);
  }
  
  void setSurround_poi(ArrayList<GeoPoiInfo> paramArrayList)
  {
    this.surround_poi = paramArrayList;
  }
  
  public String toJson()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("address", this.address);
      localJSONObject1.put("pano", this.pano);
      localJSONObject1.put("business", this.business);
      localJSONObject1.put("id", this.streetId);
      localJSONObject1.put("floor", this.floorId);
      localJSONObject1.put("build_id", this.buildingId);
      localJSONObject1.put("nearby", this.nearby);
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("x", this.point.getIntX());
      ((JSONObject)localObject).put("y", this.point.getIntY());
      localJSONObject1.put("point", localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("city_code", this.addressDetail.cityCode);
      ((JSONObject)localObject).put("city", this.addressDetail.cityName);
      ((JSONObject)localObject).put("district", this.addressDetail.district);
      ((JSONObject)localObject).put("province", this.addressDetail.province);
      ((JSONObject)localObject).put("street", this.addressDetail.street);
      ((JSONObject)localObject).put("street_number", this.addressDetail.streetNum);
      localJSONObject1.put("addr_detail", localObject);
      if ((getSurround_poi() != null) && (!getSurround_poi().isEmpty()))
      {
        localObject = new JSONArray();
        int i = 0;
        while (i < getSurround_poi().size())
        {
          JSONObject localJSONObject2 = new JSONObject();
          GeoPoiInfo localGeoPoiInfo = getSurround_poi(i);
          localJSONObject2.put("addr", localGeoPoiInfo.addr);
          localJSONObject2.put("uid", localGeoPoiInfo.uid);
          localJSONObject2.put("floor", localGeoPoiInfo.floorId);
          localJSONObject2.put("build_id", localGeoPoiInfo.buildingId);
          localJSONObject2.put("name", localGeoPoiInfo.name);
          localJSONObject2.put("pano", localGeoPoiInfo.pano);
          localJSONObject2.put("indoor_pano", localGeoPoiInfo.indoorPano);
          localJSONObject2.put("distance", localGeoPoiInfo.distance);
          localJSONObject2.put("tag", localGeoPoiInfo.tag);
          JSONObject localJSONObject3 = new JSONObject();
          localJSONObject3.put("x", localGeoPoiInfo.getPoint().getIntX());
          localJSONObject3.put("y", localGeoPoiInfo.getPoint().getIntY());
          localJSONObject2.put("point", localJSONObject3);
          ((JSONArray)localObject).put(localJSONObject2);
          i += 1;
        }
        localJSONObject1.put("surround_poi", localObject);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
    return localJSONObject1.toString();
  }
  
  public class AddressDetail
  {
    public int cityCode;
    public String cityName;
    public String country;
    public int countryCode;
    public String district;
    public String province;
    public String street;
    public String streetNum;
    
    public AddressDetail() {}
  }
  
  public class GeoPoiInfo
  {
    public String addr;
    public String buildingId;
    public double distance;
    public String floorId;
    public String indoorPano;
    public String name;
    public int pano;
    private Point point;
    public String tag;
    public String tel;
    public String uid;
    
    public GeoPoiInfo() {}
    
    public Point getPoint()
    {
      return this.point;
    }
    
    void setPoint(Point paramPoint)
    {
      this.point = paramPoint;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/AddrResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */