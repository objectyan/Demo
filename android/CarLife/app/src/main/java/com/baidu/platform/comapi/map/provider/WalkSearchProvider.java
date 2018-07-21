package com.baidu.platform.comapi.map.provider;

import com.baidu.entity.pb.WalkSearch;
import com.baidu.entity.pb.WalkSearch.Content;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WalkSearchProvider
  implements RenderProvider
{
  private WalkSearch walkSearch;
  
  public WalkSearchProvider(WalkSearch paramWalkSearch)
  {
    this.walkSearch = paramWalkSearch;
  }
  
  private JSONObject buildContentJson(WalkSearch.Content paramContent, int paramInt1, int paramInt2)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ud", paramContent.getUid());
    localJSONObject.put("align", 2);
    localJSONObject.put("ty", 3);
    localJSONObject.put("nst", 247);
    localJSONObject.put("fst", 248);
    localJSONObject.put("of", 15);
    localJSONObject.put("in", paramInt2);
    localJSONObject.put("tx", paramContent.getName());
    localJSONObject.put("geo", CoordinateUtil.pointToGeoString(new Point(paramContent.getX(), paramContent.getY())));
    return localJSONObject;
  }
  
  private JSONArray generateWalkSearchJson()
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < this.walkSearch.getContentList().size())
    {
      localJSONArray.put(buildContentJson(this.walkSearch.getContent(i), localJSONArray.length(), i));
      i += 1;
    }
    return localJSONArray;
  }
  
  public String getRenderData()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("dataset", generateWalkSearchJson());
      return localJSONObject.toString();
    }
    catch (Exception localException) {}
    return "";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/provider/WalkSearchProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */