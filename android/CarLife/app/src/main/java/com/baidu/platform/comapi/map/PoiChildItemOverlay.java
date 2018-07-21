package com.baidu.platform.comapi.map;

import com.baidu.entity.pb.PoiResult;
import com.baidu.entity.pb.PoiResult.Contents;
import com.baidu.entity.pb.PoiResult.Contents.Sgeo;
import com.baidu.entity.pb.PoiResult.Contents.Sgeo.GeoElements;
import com.baidu.platform.comapi.search.convert.ResultCache;
import com.baidu.platform.comapi.search.convert.ResultCache.Item;
import com.baidu.platform.comapi.util.f;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PoiChildItemOverlay
  extends InnerOverlay
{
  private static final int AREA_STYLE = 60;
  private static final int GEO_TYPE_AREA = 4;
  private static final int GEO_TYPE_LINE = 2;
  private static final int LINE_STYLE = 128;
  private static final int NORMAL_OFFSET = 15;
  private int poiIndex = 0;
  private boolean showSpecialChild;
  
  public PoiChildItemOverlay()
  {
    super(33);
  }
  
  public PoiChildItemOverlay(AppBaseMap paramAppBaseMap)
  {
    super(33, paramAppBaseMap);
  }
  
  private void addChildGeoArray(PoiResult.Contents paramContents, JSONArray paramJSONArray)
    throws JSONException
  {
    if (paramContents.hasSgeo()) {}
    switch (paramContents.getSgeo().getType())
    {
    case 3: 
    default: 
      return;
    case 2: 
      paramJSONArray.put(buildChildLineJson(paramContents, 0));
      return;
    }
    paramJSONArray.put(buildChildAreaJson(paramContents, 0));
  }
  
  private JSONObject buildChildAreaJson(PoiResult.Contents paramContents, int paramInt)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ud", paramContents.getUid());
    localJSONObject.put("ty", 33);
    localJSONObject.put("nst", 60);
    localJSONObject.put("fst", 0);
    localJSONObject.put("of", 15);
    localJSONObject.put("in", paramInt);
    localJSONObject.put("tx", paramContents.getName());
    localJSONObject.put("sgeo", buildSgeoJson(paramContents));
    return localJSONObject;
  }
  
  private JSONObject buildChildLineJson(PoiResult.Contents paramContents, int paramInt)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ud", paramContents.getUid());
    localJSONObject.put("ty", 32);
    localJSONObject.put("nst", 128);
    localJSONObject.put("fst", 0);
    localJSONObject.put("of", 15);
    localJSONObject.put("in", paramInt);
    localJSONObject.put("tx", paramContents.getName());
    localJSONObject.put("sgeo", buildSgeoJson(paramContents));
    return localJSONObject;
  }
  
  private JSONObject buildSgeoJson(PoiResult.Contents paramContents)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray1;
    int i;
    if (paramContents.getSgeo().getBoundList() != null)
    {
      localJSONArray1 = new JSONArray();
      i = 0;
      while (i < paramContents.getSgeo().getBoundList().size())
      {
        localJSONArray1.put(paramContents.getSgeo().getBound(i));
        i += 1;
      }
      localJSONObject1.put("bound", localJSONArray1);
    }
    if (paramContents.getSgeo().getType() == 4)
    {
      localJSONObject1.put("type", 3);
      if (paramContents.getSgeo().getGeoElementsList() != null)
      {
        localJSONArray1 = new JSONArray();
        paramContents = paramContents.getSgeo().getGeoElementsList();
        i = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (i >= paramContents.size()) {
          break label259;
        }
        if (((PoiResult.Contents.Sgeo.GeoElements)paramContents.get(i)).getPointList() != null)
        {
          JSONArray localJSONArray2 = new JSONArray();
          int j = 0;
          for (;;)
          {
            if (j < ((PoiResult.Contents.Sgeo.GeoElements)paramContents.get(i)).getPointCount())
            {
              localJSONArray2.put(((PoiResult.Contents.Sgeo.GeoElements)paramContents.get(i)).getPoint(j));
              j += 1;
              continue;
              localJSONObject1.put("type", paramContents.getSgeo().getType());
              break;
            }
          }
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("points", localJSONArray2);
          localJSONArray1.put(localJSONObject2);
        }
        i += 1;
      }
      label259:
      localJSONObject1.put("elements", localJSONArray1);
    }
    return localJSONObject1;
  }
  
  private String generateChildJson(PoiResult paramPoiResult)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      if ((this.poiIndex >= 0) && (this.poiIndex < paramPoiResult.getContentsList().size())) {
        addChildGeoArray(paramPoiResult.getContents(this.poiIndex), localJSONArray);
      }
      localJSONObject.put("dataset", localJSONArray);
      return localJSONObject.toString();
    }
    catch (Exception paramPoiResult)
    {
      f.a("Cary", "getRenderData error", paramPoiResult);
    }
    return "";
  }
  
  public String getData()
  {
    ResultCache.Item localItem = ResultCache.getInstance().get(this.strJsonData);
    if ((localItem != null) && ((localItem.messageLite instanceof PoiResult))) {
      return generateChildJson((PoiResult)localItem.messageLite);
    }
    return "";
  }
  
  public String getLayerTag()
  {
    return "poison";
  }
  
  public boolean isShowSpecialChild()
  {
    return this.showSpecialChild;
  }
  
  public void setPoiIndex(int paramInt)
  {
    this.poiIndex = paramInt;
  }
  
  public void setShowSpecialChild(boolean paramBoolean)
  {
    this.showSpecialChild = paramBoolean;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/PoiChildItemOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */