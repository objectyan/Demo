package com.baidu.navisdk.hudsdk.socket;

import android.os.Bundle;
import com.baidu.navisdk.hudsdk.BitmapUtils;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGEnlargeRoadMapModel;
import com.baidu.navisdk.ui.routeguide.model.RGHighwayModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.PackageUtil;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PacketJSONData
{
  private static JSONObject packetAssistant()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    int k = RGAssistGuideModel.getInstance().getLastestData().getInt("assisttype");
    int m = RGAssistGuideModel.getInstance().getLastestData().getInt("updatetype");
    int j = RGAssistGuideModel.getInstance().getLastestData().getInt("speed");
    localJSONObject1.put("messageType", 102);
    localJSONObject2.put("assistantType", k);
    localJSONObject2.put("assistUpdateType", m);
    int i;
    if (k != 8)
    {
      i = j;
      if (k != 11) {}
    }
    else
    {
      i = j;
      if (m != 3) {
        i = j / 1000;
      }
    }
    localJSONObject2.put("limitedSpeed", i);
    if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("remain_dist")) {
      localJSONObject2.put("distance", RGSimpleGuideModel.sSimpleGuideBundle.getInt("remain_dist"));
    }
    for (;;)
    {
      localJSONObject1.put("messageData", localJSONObject2);
      return localJSONObject1;
      localJSONObject2.put("distance", 0);
    }
  }
  
  public static JSONObject packetAuthRes(boolean paramBoolean)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject4 = new JSONObject();
    localJSONObject2.put("messageType", 12);
    if (paramBoolean)
    {
      localJSONObject4.put("serverType", 1);
      localJSONObject4.put("serverVersion", PackageUtil.getVersionName());
      localJSONObject4.put("repMsg", "AUTHORIZE_SUCCESS_MSG");
      localJSONObject3.put("errorCode", 0);
      localJSONObject3.put("errorMessage", "ok");
    }
    for (;;)
    {
      localJSONObject2.put("messageData", localJSONObject4);
      localJSONObject1.put("data", localJSONObject2);
      localJSONObject1.put("error", localJSONObject3);
      return localJSONObject1;
      localJSONObject3.put("errorCode", 1);
      localJSONObject3.put("errorMessage", "The user is not authorized");
    }
  }
  
  private static JSONObject packetCarFreeStatus()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    boolean bool = RGSimpleGuideModel.getInstance().isCarlogoFree();
    localJSONObject1.put("messageType", 117);
    localJSONObject2.put("isCarFree", bool);
    localJSONObject1.put("messageData", localJSONObject2);
    return localJSONObject1;
  }
  
  private static JSONObject packetCarPointInfo(Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    double d1 = paramBundle.getDouble("direction");
    double d2 = paramBundle.getDouble("longitude");
    double d3 = paramBundle.getDouble("latitude");
    localJSONObject1.put("messageType", 116);
    localJSONObject2.put("angle", d1);
    localJSONObject2.put("longitude", d2);
    localJSONObject2.put("latitude", d3);
    localJSONObject2.put("speed", RGAssistGuideModel.getInstance().getCurCarSpeedInt());
    localJSONObject1.put("messageData", localJSONObject2);
    return localJSONObject1;
  }
  
  private static JSONObject packetCarTunnelInfo(Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    if (paramBundle.getInt("isTunnel") == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localJSONObject1.put("messageType", 118);
      localJSONObject2.put("isInTunnel", bool);
      localJSONObject1.put("messageData", localJSONObject2);
      return localJSONObject1;
    }
  }
  
  private static JSONObject packetCurrentRoad()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject1.put("messageType", 104);
    localJSONObject2.put("currentRoadName", RGSimpleGuideModel.getInstance().getCurRoadName());
    localJSONObject1.put("messageData", localJSONObject2);
    return localJSONObject1;
  }
  
  private static JSONObject packetDestInfo(Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    int i = paramBundle.getInt("totalDist");
    double d1 = paramBundle.getDouble("longitude");
    double d2 = paramBundle.getDouble("latitude");
    localJSONObject1.put("messageType", 115);
    localJSONObject2.put("destTotalDist", i);
    localJSONObject2.put("longitude", d1);
    localJSONObject2.put("latitude", d2);
    localJSONObject2.put("destIcon", 0);
    localJSONObject1.put("messageData", localJSONObject2);
    return localJSONObject1;
  }
  
  private static JSONObject packetDestRemainInfo()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject1.put("messageType", 103);
    if (RGSimpleGuideModel.getInstance().getTotalInfo().containsKey("totaldist"))
    {
      localJSONObject2.put("remainDistance", RGSimpleGuideModel.getInstance().getTotalInfo().getInt("totaldist"));
      if (!RGSimpleGuideModel.getInstance().getTotalInfo().containsKey("totaltime")) {
        break label110;
      }
      localJSONObject2.put("remainTime", RGSimpleGuideModel.getInstance().getTotalInfo().getInt("totaltime"));
    }
    for (;;)
    {
      localJSONObject1.put("messageData", localJSONObject2);
      return localJSONObject1;
      localJSONObject2.put("remainDistance", 0);
      break;
      label110:
      localJSONObject2.put("remainTime", 0);
    }
  }
  
  public static JSONObject packetDestRemainInfo(int paramInt1, int paramInt2)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject4 = new JSONObject();
    localJSONObject2.put("messageType", 103);
    localJSONObject4.put("remainDistance", paramInt1);
    localJSONObject4.put("remainTime", paramInt2);
    localJSONObject2.put("messageData", localJSONObject4);
    localJSONObject3.put("errorCode", 0);
    localJSONObject3.put("errorMessage", "ok");
    localJSONObject1.put("data", localJSONObject2);
    localJSONObject1.put("error", localJSONObject3);
    return localJSONObject1;
  }
  
  public static JSONObject packetEnlargeRoad(int paramInt1, int paramInt2)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject4 = new JSONObject();
    localJSONObject2.put("messageType", 114);
    localJSONObject4.put("enlargeType", paramInt1);
    localJSONObject4.put("enlargeShowState", paramInt2);
    Bundle localBundle = RGEnlargeRoadMapModel.getInstance().getLastestData();
    if (localBundle == null) {
      throw new JSONException("");
    }
    if ((paramInt2 == 0) || (paramInt2 == 1))
    {
      if (paramInt2 != 0) {
        break label343;
      }
      byte[] arrayOfByte = BitmapUtils.bitmap2Bytes(RGEnlargeRoadMapModel.getInstance().getBGBitmap());
      if (arrayOfByte == null) {
        break label328;
      }
      localJSONObject4.put("enlargeBasicImage", BitmapUtils.encodeToBase64Str(arrayOfByte));
      arrayOfByte = BitmapUtils.bitmap2Bytes(RGEnlargeRoadMapModel.getInstance().getArrowBitmap());
      if (arrayOfByte == null) {
        break label330;
      }
      localJSONObject4.put("enlargeArrowImage", BitmapUtils.encodeToBase64Str(arrayOfByte));
      localJSONObject4.put("nextRoadName", localBundle.getString("road_name"));
      localJSONObject4.put("enlargeTotalDist", localBundle.getInt("total_dist"));
      localJSONObject4.put("enlargeRemainDist", localBundle.getInt("rem_dist"));
      if (paramInt1 == 1)
      {
        localJSONObject4.put("carPosX", localBundle.getInt("car_pos_x"));
        localJSONObject4.put("carPosY", localBundle.getInt("car_pos_y"));
        localJSONObject4.put("carPosRotate", localBundle.getInt("car_rotate"));
        if (paramInt2 != 0) {
          break label366;
        }
        localJSONObject4.put("lastCarPosX", 0);
        localJSONObject4.put("lastCarPosY", 0);
        localJSONObject4.put("lastCarPosRotate", 0);
      }
    }
    for (;;)
    {
      localJSONObject2.put("messageData", localJSONObject4);
      localJSONObject3.put("errorCode", 0);
      localJSONObject3.put("errorMessage", "ok");
      localJSONObject1.put("data", localJSONObject2);
      localJSONObject1.put("error", localJSONObject3);
      return localJSONObject1;
      label328:
      return null;
      label330:
      localJSONObject4.put("enlargeArrowImage", "");
      break;
      label343:
      localJSONObject4.put("enlargeBasicImage", "");
      localJSONObject4.put("enlargeArrowImage", "");
      break;
      label366:
      localJSONObject4.put("lastCarPosX", localBundle.getInt("last_car_pos_x"));
      localJSONObject4.put("lastCarPosY", localBundle.getInt("last_car_pos_y"));
      localJSONObject4.put("lastCarPosRotate", localBundle.getInt("last_car_rotate"));
    }
  }
  
  public static JSONObject packetJSONData(int paramInt, Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    switch (paramInt)
    {
    case 106: 
    case 107: 
    case 108: 
    case 109: 
    case 110: 
    case 111: 
    case 112: 
    case 113: 
    case 114: 
    default: 
      paramBundle = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      paramBundle.put("messageType", paramInt);
      paramBundle.put("messageData", localJSONObject3);
    }
    for (;;)
    {
      localJSONObject2.put("errorCode", 0);
      localJSONObject2.put("errorMessage", "ok");
      localJSONObject1.put("data", paramBundle);
      localJSONObject1.put("error", localJSONObject2);
      return localJSONObject1;
      paramBundle = packetManeuver();
      continue;
      paramBundle = packetServiceArea();
      continue;
      paramBundle = packetAssistant();
      continue;
      paramBundle = packetDestRemainInfo();
      continue;
      paramBundle = packetCurrentRoad();
      continue;
      paramBundle = packetNextRoad();
      continue;
      paramBundle = packetDestInfo(paramBundle);
      continue;
      paramBundle = packetCarPointInfo(paramBundle);
      continue;
      paramBundle = packetCarFreeStatus();
      continue;
      paramBundle = packetCarTunnelInfo(paramBundle);
      continue;
      paramBundle = packetShapeIndexUpdate(paramBundle);
      continue;
      paramBundle = packetRouteInfo(paramBundle);
      continue;
      paramBundle = packetNearByCamera();
    }
  }
  
  private static JSONObject packetManeuver()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    int i = -1;
    boolean bool = false;
    Object localObject1 = "";
    Object localObject2 = "";
    localJSONObject1.put("messageType", 100);
    if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("roadID")) {
      localJSONObject2.put("maneuverId", RGSimpleGuideModel.sSimpleGuideBundle.getInt("roadID"));
    }
    Object localObject3;
    if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("icon_name"))
    {
      localObject3 = RGSimpleGuideModel.sSimpleGuideBundle.getString("icon_name");
      if (localObject3 != null) {
        localJSONObject2.put("maneuverName", ((String)localObject3).replace(".png", "").toLowerCase());
      }
    }
    for (;;)
    {
      label146:
      label185:
      label214:
      String str;
      if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("straight"))
      {
        if (RGSimpleGuideModel.sSimpleGuideBundle.getInt("straight", 0) > 0)
        {
          bool = true;
          localJSONObject2.put("straight", bool);
        }
      }
      else
      {
        if (!RGSimpleGuideModel.sSimpleGuideBundle.containsKey("remain_dist")) {
          break label609;
        }
        i = RGSimpleGuideModel.sSimpleGuideBundle.getInt("remain_dist");
        localJSONObject2.put("distance", i);
        if (!RGSimpleGuideModel.sSimpleGuideBundle.containsKey("road_name")) {
          break label621;
        }
        localObject1 = RGSimpleGuideModel.sSimpleGuideBundle.getString("road_name");
        localJSONObject2.put("nextRoadName", localObject1);
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("cur_road_name")) {
          localObject2 = RGSimpleGuideModel.sSimpleGuideBundle.getString("cur_road_name");
        }
        int j = -1;
        str = RGSimpleGuideModel.getInstance().getFormatAfterMeters(i);
        localObject3 = RGSimpleGuideModel.getInstance().getNextGuideInfo();
        i = j;
        if (localObject3 != null) {
          i = ((Bundle)localObject3).getInt("resid");
        }
        if ((i == 0) || ((i != 1711407751) && (i != 1711407752) && (i != 1711407704) && (i != 1711407705))) {
          break label634;
        }
        localObject3 = BNStyleManager.getString(1711669850);
        label312:
        if (!bool) {
          break label645;
        }
        localObject1 = "沿" + (String)localObject2 + "行驶" + str;
        label349:
        localJSONObject2.put("maneuverTips", localObject1);
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("roadPosX")) {
          localJSONObject2.put("longitude", RGSimpleGuideModel.sSimpleGuideBundle.getDouble("roadPosX"));
        }
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("roadPoxY")) {
          localJSONObject2.put("latitude", RGSimpleGuideModel.sSimpleGuideBundle.getDouble("roadPoxY"));
        }
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("ringFlag")) {
          localJSONObject2.put("ringFlag", RGSimpleGuideModel.sSimpleGuideBundle.getInt("ringFlag"));
        }
        if (!RGSimpleGuideModel.sSimpleGuideBundle.containsKey("laneCount")) {
          break label679;
        }
        localJSONObject2.put("laneCount", RGSimpleGuideModel.sSimpleGuideBundle.getInt("laneCount"));
        label477:
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("laneAddType")) {
          i = RGSimpleGuideModel.sSimpleGuideBundle.getInt("laneAddType");
        }
      }
      try
      {
        localJSONObject2.put("laneTotalAddType", i);
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("laneAddTypeArray"))
        {
          localObject1 = RGSimpleGuideModel.sSimpleGuideBundle.getIntArray("laneAddTypeArray");
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            localObject2 = new ArrayList();
            i = 0;
            for (;;)
            {
              if (i < localObject1.length)
              {
                ((ArrayList)localObject2).add(Integer.valueOf(localObject1[i]));
                i += 1;
                continue;
                localJSONObject2.put("maneuverName", "");
                break;
                localJSONObject2.put("maneuverName", "");
                break;
                bool = false;
                break label146;
                label609:
                localJSONObject2.put("distance", 0);
                break label185;
                label621:
                localJSONObject2.put("nextRoadName", "");
                break label214;
                label634:
                localObject3 = BNStyleManager.getString(1711669849);
                break label312;
                label645:
                localObject1 = str + "后" + (String)localObject3 + (String)localObject1;
                break label349;
                label679:
                localJSONObject2.put("laneCount", 0);
                break label477;
              }
            }
            localJSONObject2.put("laneAdditionTypeArray", new JSONArray((Collection)localObject2));
          }
        }
        if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("laneSignArray"))
        {
          localObject1 = RGSimpleGuideModel.sSimpleGuideBundle.getIntArray("laneSignArray");
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            localObject2 = new ArrayList();
            i = 0;
            while (i < localObject1.length)
            {
              ((ArrayList)localObject2).add(Integer.valueOf(localObject1[i]));
              i += 1;
            }
            localJSONObject2.put("laneSignTypeArray", new JSONArray((Collection)localObject2));
          }
        }
        localJSONObject1.put("messageData", localJSONObject2);
        return localJSONObject1;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
  
  private static JSONObject packetNearByCamera()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject1.put("messageType", 121);
    JSONArray localJSONArray = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    if (JNIGuidanceControl.getInstance().GetHUDSDKCameraInfo(localArrayList) == 1)
    {
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        Bundle localBundle = (Bundle)localArrayList.get(i);
        if (localBundle != null)
        {
          JSONObject localJSONObject3 = new JSONObject();
          localJSONObject3.put("longitude", localBundle.getDouble("longitude"));
          localJSONObject3.put("latitude", localBundle.getDouble("latitude"));
          localJSONObject3.put("cameraType", localBundle.getInt("cameraType"));
          localJSONObject3.put("distance", localBundle.getInt("fromStartDist"));
          localJSONArray.put(localJSONObject3);
        }
        i += 1;
      }
    }
    localJSONObject2.put("cameraList", localJSONArray);
    localJSONObject1.put("messageData", localJSONObject2);
    return localJSONObject1;
  }
  
  private static JSONObject packetNextRoad()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject1.put("messageType", 105);
    localJSONObject2.put("nextRoadName", RGSimpleGuideModel.sSimpleGuideBundle.getString("road_name"));
    localJSONObject1.put("messageData", localJSONObject2);
    return localJSONObject1;
  }
  
  public static JSONObject packetPong()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject4 = new JSONObject();
    localJSONObject2.put("messageType", 14);
    localJSONObject2.put("messageData", localJSONObject4);
    localJSONObject3.put("errorCode", 0);
    localJSONObject3.put("errorMessage", "ok");
    localJSONObject1.put("data", localJSONObject2);
    localJSONObject1.put("error", localJSONObject3);
    return localJSONObject1;
  }
  
  private static JSONObject packetRouteInfo(Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    int i = paramBundle.getInt("routeId");
    localJSONObject1.put("messageType", 120);
    localJSONObject2.put("routeID", i);
    paramBundle = new JSONArray();
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = new JSONArray();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (JNIGuidanceControl.getInstance().GetHUDSDKRouteInfo((ArrayList)localObject2, (ArrayList)localObject1, localArrayList) == 1)
    {
      int j = ((ArrayList)localObject2).size();
      i = 0;
      Object localObject3;
      while (i < j)
      {
        localObject3 = (Bundle)((ArrayList)localObject2).get(i);
        if (localObject3 != null)
        {
          JSONObject localJSONObject3 = new JSONObject();
          localJSONObject3.put("longitude", ((Bundle)localObject3).getDouble("longitude"));
          localJSONObject3.put("latitude", ((Bundle)localObject3).getDouble("latitude"));
          localJSONObject3.put("routeType", ((Bundle)localObject3).getInt("roadType"));
          localJSONObject3.put("fromStartDist", ((Bundle)localObject3).getInt("fromStartDist"));
          paramBundle.put(localJSONObject3);
        }
        i += 1;
      }
      j = ((ArrayList)localObject1).size();
      i = 0;
      while (i < j)
      {
        localObject2 = (Bundle)((ArrayList)localObject1).get(i);
        if (localObject2 != null)
        {
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("fromStartPointDistance", ((Bundle)localObject2).getInt("startPointFromStartDist"));
          ((JSONObject)localObject3).put("fromEndPointDistance", ((Bundle)localObject2).getInt("endPointFromStartDist"));
          ((JSONObject)localObject3).put("routeType", ((Bundle)localObject2).getInt("roadType"));
          localJSONArray1.put(localObject3);
        }
        i += 1;
      }
      j = localArrayList.size();
      i = 0;
      while (i < j)
      {
        localObject1 = (Bundle)localArrayList.get(i);
        if (localObject1 != null)
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("longitude", ((Bundle)localObject1).getDouble("longitude"));
          ((JSONObject)localObject2).put("latitude", ((Bundle)localObject1).getDouble("latitude"));
          ((JSONObject)localObject2).put("latitude", ((Bundle)localObject1).getDouble("latitude"));
          ((JSONObject)localObject2).put("restrictType", ((Bundle)localObject1).getInt("restrictType"));
          ((JSONObject)localObject2).put("distance", ((Bundle)localObject1).getInt("fromStartDist"));
          localJSONArray2.put(localObject2);
        }
        i += 1;
      }
    }
    localJSONObject2.put("arRoutList", paramBundle);
    localJSONObject2.put("timeLineList", localJSONArray1);
    localJSONObject2.put("restritInfoList", localJSONArray2);
    localJSONObject1.put("messageData", localJSONObject2);
    return localJSONObject1;
  }
  
  public static JSONObject packetServerExit()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject4 = new JSONObject();
    localJSONObject2.put("messageType", 13);
    localJSONObject4.put("msg", "End_Communication");
    localJSONObject2.put("messageData", localJSONObject4);
    localJSONObject3.put("errorCode", 0);
    localJSONObject3.put("errorMessage", "ok");
    localJSONObject1.put("data", localJSONObject2);
    localJSONObject1.put("error", localJSONObject3);
    return localJSONObject1;
  }
  
  private static JSONObject packetServiceArea()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject1.put("messageType", 101);
    localJSONObject2.put("serviceArea", RGHighwayModel.getInstance().getServiceName());
    localJSONObject2.put("distance", RGHighwayModel.getInstance().getServiceRemainDist());
    localJSONObject1.put("messageData", localJSONObject2);
    return localJSONObject1;
  }
  
  private static JSONObject packetShapeIndexUpdate(Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    int i = paramBundle.getInt("curLocIndex");
    int j = paramBundle.getInt("fromStartDist");
    localJSONObject1.put("messageType", 119);
    localJSONObject2.put("shapeIndex", i);
    localJSONObject2.put("distance", j);
    localJSONObject1.put("messageData", localJSONObject2);
    return localJSONObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/hudsdk/socket/PacketJSONData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */