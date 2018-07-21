package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.map.provider.TrackRegionData;
import com.baidu.platform.comapi.util.f;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TrackRegionItemOverlay
  extends InnerOverlay
{
  private static final int AREA_NEW_FLAG_COLOR = -939489287;
  private static final int GEO_TYPE_AREA = 3;
  private static final int NORMAL_OFFSET = 15;
  private ArrayList<TrackRegionData> mTrackRegionDatas;
  
  public TrackRegionItemOverlay()
  {
    super(33);
  }
  
  public TrackRegionItemOverlay(AppBaseMap paramAppBaseMap)
  {
    super(33, paramAppBaseMap);
  }
  
  private JSONObject buildChildJson(TrackRegionData paramTrackRegionData, int paramInt)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("ud", paramTrackRegionData.uid);
    localJSONObject1.put("ty", 32);
    localJSONObject1.put("of", 15);
    localJSONObject1.put("in", paramInt);
    localJSONObject1.put("tx", paramTrackRegionData.name);
    localJSONObject1.put("sgeo", buildSgeoJson(paramTrackRegionData, 3));
    JSONObject localJSONObject2 = new JSONObject();
    paramInt = getProvAreaColorForNum(paramTrackRegionData.trackNum);
    int i = getNewRegionLineColor(paramTrackRegionData.isNewFlag);
    if (paramTrackRegionData.isNewFlag) {
      paramInt = -939489287;
    }
    localJSONObject2.put("scolor", paramInt);
    localJSONObject2.put("color", i);
    localJSONObject2.put("width", 4);
    localJSONObject1.put("style", localJSONObject2);
    return localJSONObject1;
  }
  
  private JSONObject buildSgeoJson(TrackRegionData paramTrackRegionData, int paramInt)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", paramInt);
    if ((paramTrackRegionData != null) && (!paramTrackRegionData.region.isEmpty()))
    {
      JSONArray localJSONArray1 = new JSONArray();
      JSONArray localJSONArray2 = new JSONArray();
      paramInt = 0;
      while (paramInt < paramTrackRegionData.region.size())
      {
        localJSONArray2.put(paramTrackRegionData.region.get(paramInt));
        paramInt += 1;
      }
      paramTrackRegionData = new JSONObject();
      paramTrackRegionData.put("points", localJSONArray2);
      localJSONArray1.put(paramTrackRegionData);
      localJSONObject.put("elements", localJSONArray1);
    }
    return localJSONObject;
  }
  
  private String generateChildJson(ArrayList<TrackRegionData> paramArrayList)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    try
    {
      while (i < paramArrayList.size())
      {
        localJSONArray.put(buildChildJson((TrackRegionData)paramArrayList.get(i), 0));
        i += 1;
      }
      localJSONObject.put("dataset", localJSONArray);
      return localJSONObject.toString();
    }
    catch (Exception paramArrayList)
    {
      f.a("Cary", "getRenderData error", paramArrayList);
    }
    return "";
  }
  
  private int getNewRegionLineColor(boolean paramBoolean)
  {
    if (paramBoolean) {
      return -16757816;
    }
    return -3641826;
  }
  
  private int getProvAreaColorForNum(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 10)) {
      return -923081024;
    }
    if (paramInt < 20) {
      return -923411280;
    }
    if (paramInt < 30) {
      return -923741018;
    }
    if (paramInt < 40) {
      return -923547501;
    }
    if (paramInt < 60) {
      return -923877759;
    }
    if (paramInt < 100) {
      return -924405906;
    }
    if (paramInt < 200) {
      return -924935335;
    }
    if (paramInt < 400) {
      return -926644400;
    }
    return -928091325;
  }
  
  public boolean addedToMapView()
  {
    if (this.mBaseMap == null) {}
    do
    {
      return false;
      this.mLayerID = this.mBaseMap.AddLayer(2, 0, "extend");
    } while (this.mLayerID == 0);
    this.mBaseMap.SetLayersClickable(this.mLayerID, true);
    this.mBaseMap.ShowLayers(this.mLayerID, false);
    return true;
  }
  
  public String getData()
  {
    return generateChildJson(this.mTrackRegionDatas);
  }
  
  public void setData(ArrayList<TrackRegionData> paramArrayList)
  {
    this.mTrackRegionDatas = paramArrayList;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/TrackRegionItemOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */