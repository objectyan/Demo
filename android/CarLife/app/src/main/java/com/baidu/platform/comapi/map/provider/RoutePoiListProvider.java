package com.baidu.platform.comapi.map.provider;

import com.baidu.entity.pb.PoiResult;
import com.baidu.entity.pb.PoiResult.Contents;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RoutePoiListProvider
  implements RenderProvider
{
  private PoiResult mPoiResult;
  
  public RoutePoiListProvider(PoiResult paramPoiResult)
  {
    this.mPoiResult = paramPoiResult;
  }
  
  private JSONObject buildRoutePoiContentJson(PoiResult.Contents paramContents, int paramInt1, int paramInt2)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ud", paramContents.getUid());
    localJSONObject.put("align", 2);
    localJSONObject.put("ty", 3);
    localJSONObject.put("nst", 247);
    localJSONObject.put("fst", 248);
    localJSONObject.put("of", 15);
    localJSONObject.put("in", paramInt2);
    localJSONObject.put("tx", paramContents.getName());
    localJSONObject.put("geo", paramContents.getGeo());
    return localJSONObject;
  }
  
  private JSONArray generateRoutePoiResultData()
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < this.mPoiResult.getContentsList().size())
    {
      PoiResult.Contents localContents = this.mPoiResult.getContents(i);
      if (!isLegalPoiType(localContents.getPoiType())) {}
      for (;;)
      {
        i += 1;
        break;
        localJSONArray.put(buildRoutePoiContentJson(localContents, localJSONArray.length(), i));
      }
    }
    return localJSONArray;
  }
  
  private boolean isLegalPoiType(int paramInt)
  {
    return (paramInt != 2) && (paramInt != 4);
  }
  
  public String getRenderData()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("dataset", generateRoutePoiResultData());
      return localJSONObject.toString();
    }
    catch (Exception localException) {}
    return "";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/provider/RoutePoiListProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */