package com.baidu.navi.track.model;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class TrackSyncResponseModel
{
  private static final String TAG = TrackSyncResponseModel.class.getSimpleName();
  public ArrayList<CarNaviModel> dataList = new ArrayList();
  public ArrayList<String> guidList = new ArrayList();
  public int isResponse = 0;
  public String lastver;
  public TrackAcmp trackAcmp = new TrackAcmp();
  
  public static TrackSyncResponseModel parseJson(JSONObject paramJSONObject)
  {
    TrackSyncResponseModel localTrackSyncResponseModel = new TrackSyncResponseModel();
    if (paramJSONObject == null) {}
    Object localObject1;
    do
    {
      return localTrackSyncResponseModel;
      localTrackSyncResponseModel.isResponse = 1;
      localObject1 = paramJSONObject.optJSONArray("orbitTotal");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        localObject1 = ((JSONArray)localObject1).optJSONObject(0);
        if (localObject1 != null)
        {
          localTrackSyncResponseModel.trackAcmp.setCarMaxDuration(((JSONObject)localObject1).optInt("longest_conn_time"));
          localTrackSyncResponseModel.trackAcmp.setCarWeekMileage(((JSONObject)localObject1).optInt("week_mileage"));
          localTrackSyncResponseModel.trackAcmp.setCarNaviDistance(((JSONObject)localObject1).optInt("total_mileage"));
        }
      }
      paramJSONObject = paramJSONObject.optJSONArray("allorbits");
    } while (paramJSONObject == null);
    int i = 0;
    label102:
    Object localObject2;
    if (i < paramJSONObject.length())
    {
      localObject2 = paramJSONObject.optJSONObject(i);
      if (localObject2 != null)
      {
        localObject1 = new CarNaviModel();
        ((CarNaviModel)localObject1).cleanCarInfo();
        ((CarNaviModel)localObject1).setUseId(((JSONObject)localObject2).optString("uid"));
        ((CarNaviModel)localObject1).getPBData().setSid("111");
        if (((JSONObject)localObject2).optInt("is_deleted") != 0) {
          break label542;
        }
        ((CarNaviModel)localObject1).setSyncState(3);
      }
    }
    for (;;)
    {
      ((CarNaviModel)localObject1).getPBData().setGuid(((JSONObject)localObject2).optString("guid"));
      ((CarNaviModel)localObject1).getPBData().setDuration(((JSONObject)localObject2).optInt("duration"));
      ((CarNaviModel)localObject1).getPBData().setDistance(((JSONObject)localObject2).optInt("distance"));
      ((CarNaviModel)localObject1).getPBData().setMaxSpeed(((JSONObject)localObject2).optDouble("max_speed"));
      ((CarNaviModel)localObject1).getPBData().setAvgSpeed(((JSONObject)localObject2).optDouble("speed"));
      ((CarNaviModel)localObject1).getPBData().setType("car_navi");
      ((CarNaviModel)localObject1).getPBData().setCtime(((JSONObject)localObject2).optInt("start_time"));
      Object localObject3 = ((JSONObject)localObject2).optString("name");
      Object localObject4 = ((JSONObject)localObject2).optString("start_end_coords");
      localObject2 = new NaviPoint();
      NaviPoint localNaviPoint = new NaviPoint();
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject3 = ((String)localObject3).split("_", 2);
        if ((localObject3 != null) && (localObject3.length == 2))
        {
          ((NaviPoint)localObject2).setAddr(localObject3[0]);
          localNaviPoint.setAddr(localObject3[1]);
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        localObject4 = ((String)localObject4).split("_", 2);
        if ((localObject4 != null) && (localObject4.length == 2))
        {
          localObject3 = localObject4[0];
          localObject4 = localObject4[1];
          localObject3 = ((String)localObject3).split(",", 2);
          localObject4 = ((String)localObject4).split(",", 2);
          if (localObject3 == null) {}
        }
      }
      try
      {
        if (localObject3.length == 2)
        {
          ((NaviPoint)localObject2).setLng(Double.valueOf(localObject3[0]).doubleValue());
          ((NaviPoint)localObject2).setLat(Double.valueOf(localObject3[1]).doubleValue());
        }
        if ((localObject4 != null) && (localObject4.length == 2))
        {
          localNaviPoint.setLng(Double.valueOf(localObject4[0]).doubleValue());
          localNaviPoint.setLat(Double.valueOf(localObject4[1]).doubleValue());
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
      ((CarNaviModel)localObject1).getPBData().setStartPoint((NaviPoint)localObject2);
      ((CarNaviModel)localObject1).getPBData().setEndPoint(localNaviPoint);
      localTrackSyncResponseModel.dataList.add(localObject1);
      i += 1;
      break label102;
      break;
      label542:
      ((CarNaviModel)localObject1).setSyncState(2);
    }
  }
  
  public String toString()
  {
    return "TrackSyncResponseModel[ lastver=" + this.lastver + ", trackAcmp=" + this.trackAcmp + ", isResponse=" + this.isResponse + ", dataList=" + this.dataList + ", guidList=" + this.guidList + " ]";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/model/TrackSyncResponseModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */