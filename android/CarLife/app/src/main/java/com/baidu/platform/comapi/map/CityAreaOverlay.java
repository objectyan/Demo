package com.baidu.platform.comapi.map;

import com.baidu.entity.pb.CityResult;
import com.baidu.entity.pb.CityResult.Content;
import com.baidu.entity.pb.CityResult.Content.Sgeo;
import com.baidu.entity.pb.CityResult.Content.Sgeo.GeoElements;
import com.baidu.platform.comapi.search.convert.ResultCache;
import com.baidu.platform.comapi.search.convert.ResultCache.Item;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CityAreaOverlay
  extends InnerOverlay
{
  private static final int AREA_STYLE_SCOLOR = -1595814730;
  private static final int GEO_TYPE_AREA = 3;
  private static final int GEO_TYPE_LINE = 2;
  private static final int LEVEL_FOUR_COLOR = 14798006;
  private static final int LEVEL_ONE_COLOR = 1507970230;
  private static final int LEVEL_THREE_COLOR = 652332214;
  private static final int LEVEL_TWO_COLOR = 1071762614;
  private static final int LINE_STYLE = 140;
  private static final int MAX_LEVEL = 20;
  private static final int MIN_LEVEL = 3;
  private static final int NORMAL_OFFSET = 15;
  private static final int ONE_LEVEL_DIFF = 1;
  private static final int THREE_LEVEL_DIFF = 3;
  private static final int TWO_LEVEL_DIFF = 2;
  
  public CityAreaOverlay()
  {
    super(33);
  }
  
  public CityAreaOverlay(AppBaseMap paramAppBaseMap)
  {
    super(33, paramAppBaseMap);
  }
  
  private void addChildGeoArray(CityResult.Content paramContent, JSONArray paramJSONArray)
    throws JSONException
  {
    if (paramContent.hasSgeo())
    {
      paramJSONArray.put(buildChildAreaJson(paramContent, 0));
      paramJSONArray.put(buildChildLineJson(paramContent, 1));
    }
  }
  
  private JSONObject buildChildAreaJson(CityResult.Content paramContent, int paramInt)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("ud", paramContent.getUid());
    localJSONObject1.put("ty", 33);
    localJSONObject1.put("of", 15);
    localJSONObject1.put("in", paramInt);
    localJSONObject1.put("tx", paramContent.getCname());
    localJSONObject1.put("sgeo", buildSgeoJson(paramContent, 3));
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("scolor", -1595814730);
    localJSONObject1.put("style", localJSONObject2);
    localJSONObject1.put("difflevel", buildDifflevel(paramContent.getLevel()));
    return localJSONObject1;
  }
  
  private JSONObject buildChildLineJson(CityResult.Content paramContent, int paramInt)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ud", paramContent.getUid());
    localJSONObject.put("ty", 32);
    localJSONObject.put("nst", 140);
    localJSONObject.put("fst", 140);
    localJSONObject.put("of", 15);
    localJSONObject.put("in", paramInt);
    localJSONObject.put("tx", paramContent.getCname());
    localJSONObject.put("sgeo", buildSgeoJson(paramContent, 2));
    return localJSONObject;
  }
  
  private JSONArray buildDifflevel(int paramInt)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("maxl", paramInt);
    localJSONObject.put("minl", 3);
    localJSONObject.put("scolor", 1507970230);
    localJSONArray.put(localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("maxl", paramInt + 1);
    localJSONObject.put("minl", paramInt + 1);
    localJSONObject.put("scolor", 1071762614);
    localJSONArray.put(localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("maxl", paramInt + 2);
    localJSONObject.put("minl", paramInt + 2);
    localJSONObject.put("scolor", 652332214);
    localJSONArray.put(localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("maxl", 20);
    localJSONObject.put("minl", paramInt + 3);
    localJSONObject.put("scolor", 14798006);
    localJSONArray.put(localJSONObject);
    return localJSONArray;
  }
  
  private JSONObject buildSgeoJson(CityResult.Content paramContent, int paramInt)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray1;
    int i;
    if (paramContent.getSgeo().getBoundList() != null)
    {
      localJSONArray1 = new JSONArray();
      i = 0;
      while (i < paramContent.getSgeo().getBoundList().size())
      {
        localJSONArray1.put(Double.valueOf(paramContent.getSgeo().getBound(i)));
        i += 1;
      }
      localJSONObject1.put("bound", localJSONArray1);
    }
    localJSONObject1.put("type", paramInt);
    if (paramContent.getSgeo().getGeoElementsList() != null)
    {
      localJSONArray1 = new JSONArray();
      paramContent = paramContent.getSgeo().getGeoElementsList();
      paramInt = 0;
      while (paramInt < paramContent.size())
      {
        if (((CityResult.Content.Sgeo.GeoElements)paramContent.get(paramInt)).getPointList() != null)
        {
          JSONArray localJSONArray2 = new JSONArray();
          i = 0;
          while (i < ((CityResult.Content.Sgeo.GeoElements)paramContent.get(paramInt)).getPointCount())
          {
            localJSONArray2.put(Double.valueOf(((CityResult.Content.Sgeo.GeoElements)paramContent.get(paramInt)).getPoint(i)));
            i += 1;
          }
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("points", localJSONArray2);
          localJSONArray1.put(localJSONObject2);
        }
        paramInt += 1;
      }
      localJSONObject1.put("elements", localJSONArray1);
    }
    return localJSONObject1;
  }
  
  private String generateChildJson(CityResult paramCityResult)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    CityResult.Content localContent = null;
    if (paramCityResult.hasContent()) {
      localContent = paramCityResult.getContent();
    }
    if (localContent == null) {
      return "";
    }
    try
    {
      addChildGeoArray(localContent, localJSONArray);
      localJSONObject.put("dataset", localJSONArray);
      return localJSONObject.toString();
    }
    catch (JSONException paramCityResult)
    {
      for (;;)
      {
        paramCityResult.printStackTrace();
      }
    }
  }
  
  public boolean addedToMapView()
  {
    if (this.mBaseMap == null) {}
    do
    {
      return false;
      this.mLayerID = this.mBaseMap.AddLayer(0, 0, "cityarea");
    } while (this.mLayerID == 0);
    this.mBaseMap.SetLayersClickable(this.mLayerID, true);
    this.mBaseMap.ShowLayers(this.mLayerID, false);
    return true;
  }
  
  public String getData()
  {
    ResultCache.Item localItem = ResultCache.getInstance().get(this.strJsonData);
    if ((localItem != null) && ((localItem.messageLite instanceof CityResult))) {
      return generateChildJson((CityResult)localItem.messageLite);
    }
    return "";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/CityAreaOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */