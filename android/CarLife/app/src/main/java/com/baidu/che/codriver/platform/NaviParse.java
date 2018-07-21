package com.baidu.che.codriver.platform;

import com.baidu.che.codriver.util.h;
import com.google.gson.Gson;
import java.util.HashMap;

public class NaviParse
{
  private static final String TAG = "NaviParse";
  private static NaviParse mInstance;
  private static NaviParse sIntance = null;
  private static final Object sLock = new Object();
  private Gson mGson = new Gson();
  private HashMap<String, NaviCmdData> mNaviHash;
  
  public static NaviParse getInstance()
  {
    if (sIntance == null) {}
    synchronized (sLock)
    {
      if (sIntance == null) {
        sIntance = new NaviParse();
      }
      return sIntance;
    }
  }
  
  private NaviCmdData parseDomainMap(NaviCmdOriginalData paramNaviCmdOriginalData)
  {
    Object localObject2 = null;
    Object localObject1;
    if (("route".equals(paramNaviCmdOriginalData.intent)) || ("poi".equals(paramNaviCmdOriginalData.intent)))
    {
      localObject1 = localObject2;
      if (paramNaviCmdOriginalData.object != null) {
        localObject1 = parseObjectPoi(paramNaviCmdOriginalData.object);
      }
    }
    do
    {
      do
      {
        return (NaviCmdData)localObject1;
        localObject1 = localObject2;
      } while (!"nearby".equals(paramNaviCmdOriginalData.intent));
      localObject1 = localObject2;
    } while (paramNaviCmdOriginalData.object == null);
    return parseObjectPoi(paramNaviCmdOriginalData.object);
  }
  
  private NaviCmdData parseDomainNaviInstruction(NaviCmdOriginalData paramNaviCmdOriginalData)
  {
    Object localObject2 = null;
    Object localObject1;
    if ("zoom_in".equals(paramNaviCmdOriginalData.intent)) {
      localObject1 = (NaviCmdData)this.mNaviHash.get("key_navi_zoom_in");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return (NaviCmdData)localObject1;
            if ("zoom_out".equals(paramNaviCmdOriginalData.intent)) {
              return (NaviCmdData)this.mNaviHash.get("key_navi_zoom_out");
            }
            if ("map_left".equals(paramNaviCmdOriginalData.intent)) {
              return (NaviCmdData)this.mNaviHash.get("key_navi_move_left");
            }
            if ("map_right".equals(paramNaviCmdOriginalData.intent)) {
              return (NaviCmdData)this.mNaviHash.get("key_navi_move_right");
            }
            if ("map_up".equals(paramNaviCmdOriginalData.intent)) {
              return (NaviCmdData)this.mNaviHash.get("key_navi_move_up");
            }
            if ("map_down".equals(paramNaviCmdOriginalData.intent)) {
              return (NaviCmdData)this.mNaviHash.get("key_navi_move_down");
            }
            if ("quit".equals(paramNaviCmdOriginalData.intent)) {
              return (NaviCmdData)this.mNaviHash.get("key_navi_exit_app");
            }
            if ("navigate".equals(paramNaviCmdOriginalData.intent)) {
              return (NaviCmdData)this.mNaviHash.get("key_navi_start_app");
            }
            if ("view_map".equals(paramNaviCmdOriginalData.intent)) {
              return (NaviCmdData)this.mNaviHash.get("key_navi_start_app");
            }
            if ("speed_limit".equals(paramNaviCmdOriginalData.intent)) {
              return (NaviCmdData)this.mNaviHash.get("key_navi_current_limit_speed");
            }
            if ("rest_time".equals(paramNaviCmdOriginalData.intent)) {
              return (NaviCmdData)this.mNaviHash.get("key_navi_query_current_rest_time");
            }
            if ("rest_distance".equals(paramNaviCmdOriginalData.intent)) {
              return (NaviCmdData)this.mNaviHash.get("key_navi_query_current_rest_distance");
            }
            if ("route_work".equals(paramNaviCmdOriginalData.intent)) {
              return (NaviCmdData)this.mNaviHash.get("key_navi_start_task_company");
            }
            if ("route_home".equals(paramNaviCmdOriginalData.intent)) {
              return (NaviCmdData)this.mNaviHash.get("key_navi_start_task_home");
            }
            if ("set_work".equals(paramNaviCmdOriginalData.intent)) {
              return (NaviCmdData)this.mNaviHash.get("key_navi_set_company_address");
            }
            if ("set_home".equals(paramNaviCmdOriginalData.intent)) {
              return (NaviCmdData)this.mNaviHash.get("key_navi_set_home_address");
            }
            if (!"switch_mode".equals(paramNaviCmdOriginalData.intent)) {
              break;
            }
            localObject1 = localObject2;
          } while (paramNaviCmdOriginalData.object == null);
          return parseObjectSwitchModeItem(paramNaviCmdOriginalData.object);
          if (!"open".equals(paramNaviCmdOriginalData.intent)) {
            break;
          }
          localObject1 = localObject2;
        } while (paramNaviCmdOriginalData.object == null);
        return parseObjectOpenItem(paramNaviCmdOriginalData.object);
        localObject1 = localObject2;
      } while (!"close".equals(paramNaviCmdOriginalData.intent));
      localObject1 = localObject2;
    } while (paramNaviCmdOriginalData.object == null);
    return parseObjectCloseItem(paramNaviCmdOriginalData.object);
  }
  
  private NaviCmdData parseObjectArrival(NaviCmdOriginalData.ExtInfo paramExtInfo)
  {
    return null;
  }
  
  private NaviCmdData parseObjectCloseItem(NaviCmdOriginalData.ExtInfo paramExtInfo)
  {
    NaviCmdData localNaviCmdData = null;
    if ("route_condition".equals(paramExtInfo.item)) {
      localNaviCmdData = (NaviCmdData)this.mNaviHash.get("key_navi_traffic_off");
    }
    while (!"electronic_dog".equals(paramExtInfo.item)) {
      return localNaviCmdData;
    }
    return (NaviCmdData)this.mNaviHash.get("key_navi_edog_off");
  }
  
  private NaviCmdData parseObjectOpenItem(NaviCmdOriginalData.ExtInfo paramExtInfo)
  {
    NaviCmdData localNaviCmdData = null;
    if ("route_condition".equals(paramExtInfo.item)) {
      localNaviCmdData = (NaviCmdData)this.mNaviHash.get("key_navi_traffic_on");
    }
    while (!"electronic_dog".equals(paramExtInfo.item)) {
      return localNaviCmdData;
    }
    return (NaviCmdData)this.mNaviHash.get("key_navi_edog_on");
  }
  
  private NaviCmdData parseObjectPoi(NaviCmdOriginalData.ExtInfo paramExtInfo)
  {
    NaviCmdData localNaviCmdData = (NaviCmdData)this.mNaviHash.get("key_navi_start_task");
    if (paramExtInfo != null) {
      localNaviCmdData.setParams(NaviCmdData.createParamsPoi(paramExtInfo));
    }
    return localNaviCmdData;
  }
  
  private NaviCmdData parseObjectSwitchModeItem(NaviCmdOriginalData.ExtInfo paramExtInfo)
  {
    NaviCmdData localNaviCmdData = null;
    if ("north_forward".equals(paramExtInfo.item)) {
      localNaviCmdData = (NaviCmdData)this.mNaviHash.get("key_navi_north_forward");
    }
    do
    {
      return localNaviCmdData;
      if ("head_forward".equals(paramExtInfo.item)) {
        return (NaviCmdData)this.mNaviHash.get("key_navi_head_forward");
      }
      if ("day".equals(paramExtInfo.item)) {
        return (NaviCmdData)this.mNaviHash.get("key_navi_mode_day");
      }
      if ("night".equals(paramExtInfo.item)) {
        return (NaviCmdData)this.mNaviHash.get("key_navi_mode_night");
      }
      if ("new_hand".equals(paramExtInfo.item)) {
        return (NaviCmdData)this.mNaviHash.get("key_navi_tts_mode_newer");
      }
      if ("old_hand".equals(paramExtInfo.item)) {
        return (NaviCmdData)this.mNaviHash.get("key_navi_tts_mode_older");
      }
      if ("expert".equals(paramExtInfo.item)) {
        return (NaviCmdData)this.mNaviHash.get("key_navi_tts_mode_expert");
      }
      if ("safe".equals(paramExtInfo.item)) {
        return (NaviCmdData)this.mNaviHash.get("key_navi_tts_mode_safe");
      }
      if ("full_route".equals(paramExtInfo.item)) {
        return (NaviCmdData)this.mNaviHash.get("key_navi_overview");
      }
    } while (!"continue_navi".equals(paramExtInfo.item));
    return (NaviCmdData)this.mNaviHash.get("key_navi_continue_navi");
  }
  
  public NaviCmdData getNaviCmdData(String paramString)
  {
    if (this.mNaviHash == null)
    {
      h.e("NaviParse", "don't init navi hash map");
      return null;
    }
    return (NaviCmdData)this.mNaviHash.get(paramString);
  }
  
  public void initCmdHashMap()
  {
    this.mNaviHash = new HashMap();
    this.mNaviHash.put("key_navi_version", new NaviCmdData("fun_navi_get_version_info", ""));
    this.mNaviHash.put("key_navi_mode_night", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 231)));
    this.mNaviHash.put("key_navi_mode_day", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 232)));
    this.mNaviHash.put("key_navi_zoom_in", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 203)));
    this.mNaviHash.put("key_navi_zoom_out", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 202)));
    this.mNaviHash.put("key_navi_move_left", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 221)));
    this.mNaviHash.put("key_navi_move_right", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 220)));
    this.mNaviHash.put("key_navi_move_up", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 222)));
    this.mNaviHash.put("key_navi_move_down", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 223)));
    this.mNaviHash.put("key_navi_overview", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 216)));
    this.mNaviHash.put("key_navi_continue_navi", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 217)));
    this.mNaviHash.put("key_navi_north_forward", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 229)));
    this.mNaviHash.put("key_navi_head_forward", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 230)));
    this.mNaviHash.put("key_navi_traffic_on", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 207)));
    this.mNaviHash.put("key_navi_traffic_off", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 208)));
    this.mNaviHash.put("key_navi_tts_mode_newer", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 233)));
    this.mNaviHash.put("key_navi_tts_mode_expert", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 234)));
    this.mNaviHash.put("key_navi_tts_mode_older", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 234)));
    this.mNaviHash.put("key_navi_tts_mode_safe", new NaviCmdData("fun_navi_map_control", NaviCmdData.createParams("order", 206)));
    this.mNaviHash.put("key_navi_query_navi_state", new NaviCmdData("fun_navi_navi_state", NaviCmdData.createParams("order", "type_is_innavi")));
    this.mNaviHash.put("key_navi_query_edog_state", new NaviCmdData("fun_navi_navi_state", NaviCmdData.createParams("order", "type_is_incruise")));
    this.mNaviHash.put("key_navi_query_destination", new NaviCmdData("fun_navi_navi_state", NaviCmdData.createParams("order", "type_get_destination_viapoint")));
    this.mNaviHash.put("key_navi_query_route_mode", new NaviCmdData("fun_navi_navi_state", NaviCmdData.createParams("order", "type_navi_preference_setting")));
    this.mNaviHash.put("key_navi_query_current_route_mode", new NaviCmdData("fun_navi_navi_state", NaviCmdData.createParams("order", "type_navi_preference")));
    this.mNaviHash.put("key_navi_query_current_position", new NaviCmdData("fun_navi_navi_state", NaviCmdData.createParams("order", "type_car_point")));
    this.mNaviHash.put("key_navi_query_current_rest_time", new NaviCmdData("fun_navi_navi_state", NaviCmdData.createParams("order", "type_rest_time")));
    this.mNaviHash.put("key_navi_query_current_rest_distance", new NaviCmdData("fun_navi_navi_state", NaviCmdData.createParams("order", "type_rest_distance")));
    this.mNaviHash.put("key_navi_foreground_state", new NaviCmdData("fun_navi_app_control", NaviCmdData.createParams("order", "type_foreground")));
    this.mNaviHash.put("key_navi_exit_navi", new NaviCmdData("fun_navi_app_control", NaviCmdData.createParams("order", "end_navi")));
    this.mNaviHash.put("key_navi_exit_app", new NaviCmdData("fun_navi_app_control", NaviCmdData.createParams("order", "end_app")));
    this.mNaviHash.put("key_navi_start_app", new NaviCmdData("fun_navi_app_control", NaviCmdData.createParams("order", "start_app")));
    this.mNaviHash.put("key_navi_current_limit_speed", new NaviCmdData("fun_navi_limit_speed", ""));
    this.mNaviHash.put("key_navi_edog_on", new NaviCmdData("fun_navi_cruise", NaviCmdData.createParams("event", "open")));
    this.mNaviHash.put("key_navi_edog_off", new NaviCmdData("fun_navi_cruise", NaviCmdData.createParams("event", "close")));
    this.mNaviHash.put("key_navi_query_poi_traffic", new NaviCmdData("fun_navi_query_traffic", ""));
    this.mNaviHash.put("key_navi_set_home_address", new NaviCmdData("fun_navi_navi_set", ""));
    this.mNaviHash.put("key_navi_set_company_address", new NaviCmdData("fun_navi_navi_set", ""));
    this.mNaviHash.put("key_navi_query_home_address", new NaviCmdData("fun_navi_syn_address", NaviCmdData.createParams("order", "type_home_address")));
    this.mNaviHash.put("key_navi_query_company_address", new NaviCmdData("fun_navi_syn_address", NaviCmdData.createParams("order", "type_company_address")));
    this.mNaviHash.put("key_navi_start_task", new NaviCmdData("fun_navi_start_task", ""));
    this.mNaviHash.put("key_navi_start_task_home", new NaviCmdData("fun_navi_start_task", ""));
    this.mNaviHash.put("key_navi_start_task_company", new NaviCmdData("fun_navi_start_task", ""));
    this.mNaviHash.put("key_navi_prefer_mode_recommend", new NaviCmdData("fun_navi_navi_set", NaviCmdData.createParamsResetNaviByPreference("1")));
    this.mNaviHash.put("key_navi_prefer_mode_max_highway", new NaviCmdData("fun_navi_navi_set", NaviCmdData.createParamsResetNaviByPreference("2")));
    this.mNaviHash.put("key_navi_prefer_mode_min_highway", new NaviCmdData("fun_navi_navi_set", NaviCmdData.createParamsResetNaviByPreference("4")));
    this.mNaviHash.put("key_navi_prefer_mode_min_toll", new NaviCmdData("fun_navi_navi_set", NaviCmdData.createParamsResetNaviByPreference("8")));
    this.mNaviHash.put("key_navi_prefer_mode_avoid_traffic", new NaviCmdData("fun_navi_navi_set", NaviCmdData.createParamsResetNaviByPreference("16")));
  }
  
  public NaviCmdData parse(String paramString)
  {
    if (paramString.startsWith("key_")) {
      paramString = getInstance().getNaviCmdData(paramString);
    }
    for (;;)
    {
      return paramString;
      Object localObject = null;
      try
      {
        NaviCmdOriginalData localNaviCmdOriginalData = (NaviCmdOriginalData)this.mGson.fromJson(paramString, NaviCmdOriginalData.class);
        if ("navigate_instruction".equals(localNaviCmdOriginalData.domain)) {
          return parseDomainNaviInstruction(localNaviCmdOriginalData);
        }
        paramString = (String)localObject;
        if ("map".equals(localNaviCmdOriginalData.domain))
        {
          paramString = parseDomainMap(localNaviCmdOriginalData);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        h.e("NaviParse", "parse navi cmd error");
        paramString.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/platform/NaviParse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */