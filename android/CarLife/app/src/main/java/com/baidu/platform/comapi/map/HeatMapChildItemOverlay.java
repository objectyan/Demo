package com.baidu.platform.comapi.map;

import com.baidu.entity.pb.Inf;
import com.baidu.entity.pb.Inf.Content;
import com.baidu.entity.pb.Inf.Content.HeatMap;
import com.baidu.entity.pb.Inf.Content.HeatMap.Points;
import com.baidu.entity.pb.Inf.Content.HeatMap.Points.GeoElements;
import com.baidu.platform.comapi.search.convert.ResultCache;
import com.baidu.platform.comapi.search.convert.ResultCache.Item;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HeatMapChildItemOverlay
  extends InnerOverlay
{
  private static final int AREA_STYLE = 61;
  private static final int GEO_TYPE_AREA = 4;
  private static final int GEO_TYPE_LINE = 2;
  private static final int LINE_STYLE = 128;
  private static final int NORMAL_OFFSET = 15;
  
  public HeatMapChildItemOverlay()
  {
    super(34);
  }
  
  public HeatMapChildItemOverlay(AppBaseMap paramAppBaseMap)
  {
    super(34, paramAppBaseMap);
  }
  
  private void addChildGeoArray(Inf.Content paramContent, JSONArray paramJSONArray)
    throws JSONException
  {
    if (paramContent.getHeatMap().hasPoints()) {}
    switch (paramContent.getHeatMap().getPoints().getType())
    {
    case 3: 
    default: 
      return;
    case 2: 
      paramJSONArray.put(buildChildLineJson(paramContent, 0));
      return;
    }
    paramJSONArray.put(buildChildAreaJson(paramContent, 0));
  }
  
  private JSONObject buildChildAreaJson(Inf.Content paramContent, int paramInt)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ty", 33);
    localJSONObject.put("nst", 61);
    localJSONObject.put("fst", 0);
    localJSONObject.put("of", 15);
    localJSONObject.put("in", paramInt);
    localJSONObject.put("sgeo", buildSgeoJson(paramContent));
    return localJSONObject;
  }
  
  private JSONObject buildChildLineJson(Inf.Content paramContent, int paramInt)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ty", 32);
    localJSONObject.put("nst", 128);
    localJSONObject.put("fst", 0);
    localJSONObject.put("of", 15);
    localJSONObject.put("in", paramInt);
    localJSONObject.put("sgeo", buildSgeoJson(paramContent));
    return localJSONObject;
  }
  
  private JSONObject buildSgeoJson(Inf.Content paramContent)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = paramContent.getHeatMap();
    JSONArray localJSONArray;
    int i;
    if (((Inf.Content.HeatMap)localObject).getPoints().getBoundList() != null)
    {
      localJSONArray = new JSONArray();
      i = 0;
      while (i < ((Inf.Content.HeatMap)localObject).getPoints().getBoundList().size())
      {
        localJSONArray.put(paramContent.getHeatMap().getPoints().getBound(i));
        i += 1;
      }
      localJSONObject1.put("bound", localJSONArray);
    }
    if (((Inf.Content.HeatMap)localObject).getPoints().getType() == 4)
    {
      localJSONObject1.put("type", 3);
      if (((Inf.Content.HeatMap)localObject).getPoints().getGeoElementsList() != null)
      {
        paramContent = new JSONArray();
        localObject = ((Inf.Content.HeatMap)localObject).getPoints().getGeoElementsList();
        i = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (i >= ((List)localObject).size()) {
          break label277;
        }
        if (((Inf.Content.HeatMap.Points.GeoElements)((List)localObject).get(i)).getPointList() != null)
        {
          localJSONArray = new JSONArray();
          int j = 0;
          for (;;)
          {
            if (j < ((Inf.Content.HeatMap.Points.GeoElements)((List)localObject).get(i)).getPointCount())
            {
              localJSONArray.put(((Inf.Content.HeatMap.Points.GeoElements)((List)localObject).get(i)).getPoint(j));
              j += 1;
              continue;
              localJSONObject1.put("type", ((Inf.Content.HeatMap)localObject).getPoints().getType());
              break;
            }
          }
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("points", localJSONArray);
          paramContent.put(localJSONObject2);
        }
        i += 1;
      }
      label277:
      localJSONObject1.put("elements", paramContent);
    }
    return localJSONObject1;
  }
  
  private String generateChildJson(Inf paramInf)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      if (paramInf.hasContent())
      {
        paramInf = paramInf.getContent();
        if (paramInf.hasHeatMap()) {
          addChildGeoArray(paramInf, localJSONArray);
        }
      }
      localJSONObject.put("dataset", localJSONArray);
      return localJSONObject.toString();
    }
    catch (Exception paramInf) {}
    return "";
  }
  
  public boolean addedToMapView()
  {
    if (this.mBaseMap == null) {}
    do
    {
      return false;
      this.mLayerID = this.mBaseMap.AddLayer(0, 0, "heatmap");
    } while (this.mLayerID == 0);
    this.mBaseMap.SetLayersClickable(this.mLayerID, true);
    this.mBaseMap.ShowLayers(this.mLayerID, false);
    return true;
  }
  
  public String getData()
  {
    ResultCache.Item localItem = ResultCache.getInstance().get(this.strJsonData);
    if ((localItem != null) && ((localItem.messageLite instanceof Inf))) {
      return generateChildJson((Inf)localItem.messageLite);
    }
    return "";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/HeatMapChildItemOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */