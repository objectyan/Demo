package com.baidu.navi.voice;

import android.text.TextUtils;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.logic.codriver.adapter.b;
import com.baidu.carlife.m.a;
import com.baidu.carlife.util.w;
import com.baidu.che.codriver.sdk.a.a.b;
import com.baidu.navi.util.StatisticManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NaviState
{
  private static final String TAG = NaviState.class.getSimpleName();
  private static NaviState mInstance;
  private Set<String> mBrowseMapCmdSet = new HashSet();
  private Set<String> mCommonCmdSet = new HashSet();
  private HashMap<String, String> mMapCmdMap = new HashMap();
  private RouteDetail mRouteDetail = new RouteDetail(null);
  private Set<String> mRouteGuideCmdSet = new HashSet();
  private a.b mSceneCommand = new a.b()
  {
    public void onCommand(String paramAnonymousString1, String paramAnonymousString2)
    {
      i.b(NaviState.TAG, "mCommandListener onCommand():" + paramAnonymousString2);
      StatisticManager.onEvent("VOICE_0005");
      if (NaviState.this.tryExecuteRouteDetailCmd(paramAnonymousString2))
      {
        i.b(NaviState.TAG, paramAnonymousString2 + " consumed by routeDetail");
        return;
      }
      if (NaviState.this.tryExecuteMapCmd(paramAnonymousString2))
      {
        i.b(NaviState.TAG, paramAnonymousString2 + " consumed by map control");
        return;
      }
      i.b(NaviState.TAG, paramAnonymousString2 + " not consumed!");
    }
  };
  private Set<String> mVoiceModeCmdSet = new HashSet();
  
  private NaviState()
  {
    initAllCmdSet();
  }
  
  public static NaviState getInstance()
  {
    if (mInstance == null) {
      mInstance = new NaviState();
    }
    return mInstance;
  }
  
  private void handleError()
  {
    a.a().b("当前页面不支持", 0);
    w.a("当前页面不支持");
  }
  
  private void initAllCmdMap()
  {
    this.mSceneCommand.addCommand("key_navi_zoom_in", new String[] { "放大地图", "地图放大" });
    this.mSceneCommand.addCommand("key_navi_zoom_out", new String[] { "缩小地图", "地图缩小" });
    this.mSceneCommand.addCommand("key_navi_move_down", new String[] { "地图向下" });
    this.mSceneCommand.addCommand("key_navi_move_left", new String[] { "地图向左" });
    this.mSceneCommand.addCommand("key_navi_move_right", new String[] { "地图向右" });
    this.mSceneCommand.addCommand("key_navi_move_up", new String[] { "地图向上" });
    this.mSceneCommand.addCommand("key_navi_north_forward", new String[] { "正北朝上", "正北模式" });
    this.mSceneCommand.addCommand("key_navi_head_forward", new String[] { "车头朝上", "跟随模式" });
    this.mSceneCommand.addCommand("key_navi_mode_night", new String[] { "夜间模式", "黑夜模式" });
    this.mSceneCommand.addCommand("key_navi_mode_day", new String[] { "日间模式", "白天模式" });
    this.mSceneCommand.addCommand("key_navi_traffic_on", new String[] { "打开路况" });
    this.mSceneCommand.addCommand("key_navi_traffic_off", new String[] { "关闭路况" });
    this.mSceneCommand.addCommand("key_navi_overview", new String[] { "查看全程", "全览模式" });
    this.mSceneCommand.addCommand("key_navi_continue_navi", new String[] { "继续导航", "恢复导航" });
    this.mSceneCommand.addCommand("key_navi_exit_navi", new String[] { "结束导航", "关闭导航", "退出导航" });
    this.mSceneCommand.addCommand("key_navi_tts_mode_newer", new String[] { "新手模式" });
    this.mSceneCommand.addCommand("key_navi_tts_mode_older", new String[] { "老手模式", "专家模式" });
    this.mMapCmdMap.put("key_navi_zoom_in", "放大地图,地图放大");
    this.mMapCmdMap.put("key_navi_zoom_out", "缩小地图,地图缩小");
    this.mMapCmdMap.put("key_navi_move_down", "地图向下");
    this.mMapCmdMap.put("key_navi_move_left", "地图向左");
    this.mMapCmdMap.put("key_navi_move_right", "地图向右");
    this.mMapCmdMap.put("key_navi_move_up", "地图向上");
    this.mMapCmdMap.put("key_navi_north_forward", "正北朝上,正北模式");
    this.mMapCmdMap.put("key_navi_head_forward", "车头朝上,跟随模式");
    this.mMapCmdMap.put("key_navi_mode_night", "夜间模式,黑夜模式");
    this.mMapCmdMap.put("key_navi_mode_day", "日间模式,白天模式");
    this.mMapCmdMap.put("key_navi_traffic_on", "打开路况");
    this.mMapCmdMap.put("key_navi_traffic_off", "关闭路况");
    this.mMapCmdMap.put("key_navi_overview", "查看全程,全览模式");
    this.mMapCmdMap.put("key_navi_continue_navi", "继续导航,恢复导航");
    this.mMapCmdMap.put("key_navi_exit_navi", "结束导航,关闭导航,退出导航");
    this.mMapCmdMap.put("key_navi_tts_mode_newer", "新手模式");
    this.mMapCmdMap.put("key_navi_tts_mode_older", "老手模式,专家模式");
    this.mMapCmdMap.put("key_navi_cruise_on", "打开电子狗");
    this.mMapCmdMap.put("key_navi_cruise_off", "关闭电子狗");
  }
  
  private void initAllCmdSet()
  {
    this.mBrowseMapCmdSet.add("key_navi_zoom_in");
    this.mBrowseMapCmdSet.add("key_navi_zoom_out");
    this.mBrowseMapCmdSet.add("key_navi_move_up");
    this.mBrowseMapCmdSet.add("key_navi_move_down");
    this.mBrowseMapCmdSet.add("key_navi_move_left");
    this.mBrowseMapCmdSet.add("key_navi_move_right");
    this.mBrowseMapCmdSet.add("key_navi_north_forward");
    this.mBrowseMapCmdSet.add("key_navi_head_forward");
    this.mCommonCmdSet.add("key_navi_mode_day");
    this.mCommonCmdSet.add("key_navi_mode_night");
    this.mCommonCmdSet.add("key_navi_traffic_off");
    this.mCommonCmdSet.add("key_navi_traffic_on");
    this.mRouteGuideCmdSet.add("key_navi_overview");
    this.mRouteGuideCmdSet.add("key_navi_continue_navi");
    this.mRouteGuideCmdSet.add("key_navi_exit_navi");
    this.mVoiceModeCmdSet.add("key_navi_tts_mode_newer");
    this.mVoiceModeCmdSet.add("key_navi_tts_mode_older");
    this.mVoiceModeCmdSet.add("key_navi_tts_mode_safe");
    this.mVoiceModeCmdSet.add("key_navi_tts_mode_expert");
  }
  
  private void initRouteDetailCmd()
  {
    this.mSceneCommand.addCommand("route_detail", new String[] { "立即导航", "开始导航", "选择第一个", "选择第一条路线", "选择第一条路径", "选择第二条路线", "选择第二条路径", "选择第三条路线", "选择第三条路径", "选择第二个", "选择第三个", "切换第一个", "切换第二个", "切换第三个" });
  }
  
  private boolean isCmdMatchingState(String paramString)
  {
    if (this.mBrowseMapCmdSet.contains(paramString)) {}
    while ((this.mCommonCmdSet.contains(paramString)) || (this.mRouteGuideCmdSet.contains(paramString)) || (this.mVoiceModeCmdSet.contains(paramString))) {
      return true;
    }
    i.b(TAG, "isCmdMatchingState = false");
    return false;
  }
  
  private boolean tryExecuteMapCmd(String paramString)
  {
    boolean bool2 = false;
    Iterator localIterator = this.mMapCmdMap.keySet().iterator();
    String str;
    do
    {
      bool1 = bool2;
      if (!localIterator.hasNext()) {
        break;
      }
      str = (String)localIterator.next();
    } while (!((String)this.mMapCmdMap.get(str)).contains(paramString));
    boolean bool1 = bool2;
    if (isCmdMatchingState(str)) {
      bool1 = executeCmd(str);
    }
    return bool1;
  }
  
  private boolean tryExecuteRouteDetailCmd(String paramString)
  {
    if ((this.mRouteDetail.mIsShowing) && (h.a().getCurrentFragmentType() == 52))
    {
      int k = 0;
      int m = 0;
      int j;
      int i;
      if ("立即导航,开始导航,".contains(paramString))
      {
        j = 1;
        i = m;
      }
      while (i > 0)
      {
        this.mRouteDetail.mIsShowing = false;
        MapVoiceCommandController.getInstance().selectRouteAndStartNavi(i - 1);
        return true;
        if ((paramString.contains("第一")) && (this.mRouteDetail.mRouteCount > 0))
        {
          i = 1;
          j = k;
        }
        else if ((paramString.contains("第二")) && (this.mRouteDetail.mRouteCount > 1))
        {
          i = 2;
          j = k;
        }
        else
        {
          i = m;
          j = k;
          if (paramString.contains("第三"))
          {
            i = m;
            j = k;
            if (this.mRouteDetail.mRouteCount > 2)
            {
              i = 3;
              j = k;
            }
          }
        }
      }
      if (j != 0)
      {
        this.mRouteDetail.mIsShowing = false;
        MapVoiceCommandController.getInstance().startNavi();
        return true;
      }
    }
    return false;
  }
  
  public boolean executeCmd(String paramString)
  {
    if ((!MapVoiceCommandController.getInstance().isMapModule()) || (!MapVoiceCommandController.getInstance().isMapContentFragment())) {
      handleError();
    }
    while (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ("key_navi_zoom_in".equals(paramString)) {
      MapVoiceCommandController.getInstance().mapZoomIn();
    }
    for (;;)
    {
      return true;
      if ("key_navi_zoom_out".equals(paramString)) {
        MapVoiceCommandController.getInstance().mapZoomOut();
      } else if ("key_navi_move_down".equals(paramString)) {
        MapVoiceCommandController.getInstance().mapMoveDown();
      } else if ("key_navi_move_left".equals(paramString)) {
        MapVoiceCommandController.getInstance().mapMoveLeft();
      } else if ("key_navi_move_right".equals(paramString)) {
        MapVoiceCommandController.getInstance().mapMoveRight();
      } else if ("key_navi_move_up".equals(paramString)) {
        MapVoiceCommandController.getInstance().mapMoveUp();
      } else if ("key_navi_north_forward".equals(paramString)) {
        MapVoiceCommandController.getInstance().mapNorthForward();
      } else if ("key_navi_head_forward".equals(paramString)) {
        MapVoiceCommandController.getInstance().mapCarForward();
      } else if ("key_navi_mode_night".equals(paramString)) {
        MapVoiceCommandController.getInstance().switchDayNightMode(false);
      } else if ("key_navi_mode_day".equals(paramString)) {
        MapVoiceCommandController.getInstance().switchDayNightMode(true);
      } else if ("key_navi_traffic_on".equals(paramString)) {
        MapVoiceCommandController.getInstance().switchRoadCondition(true);
      } else if ("key_navi_traffic_off".equals(paramString)) {
        MapVoiceCommandController.getInstance().switchRoadCondition(false);
      } else if ("key_navi_overview".equals(paramString)) {
        MapVoiceCommandController.getInstance().naviFullView();
      } else if ("key_navi_continue_navi".equals(paramString)) {
        MapVoiceCommandController.getInstance().naviContinue();
      } else if ("key_navi_exit_navi".equals(paramString)) {
        MapVoiceCommandController.getInstance().exitNavi();
      } else if ("key_navi_tts_mode_newer".equals(paramString)) {
        MapVoiceCommandController.getInstance().switchNaviVoiceMode(true);
      } else if ("key_navi_tts_mode_older".equals(paramString)) {
        MapVoiceCommandController.getInstance().switchNaviVoiceMode(false);
      } else if ("key_navi_cruise_on".equals(paramString)) {
        i.b(TAG, "KEY_NAVI_CRUISE_ON");
      } else if ("key_navi_cruise_off".equals(paramString)) {
        i.b(TAG, "KEY_NAVI_CRUISE_OFF");
      }
    }
  }
  
  public void notifyRouteDetail(boolean paramBoolean, int paramInt)
  {
    this.mRouteDetail.updateState(paramBoolean, paramInt);
  }
  
  public void registerCustomCmd()
  {
    initAllCmdMap();
    initRouteDetailCmd();
    b.a().a(this.mSceneCommand);
  }
  
  private static class RouteDetail
  {
    boolean mIsShowing = false;
    int mRouteCount = 0;
    
    public void updateState(boolean paramBoolean, int paramInt)
    {
      this.mIsShowing = paramBoolean;
      if (paramBoolean)
      {
        this.mRouteCount = paramInt;
        return;
      }
      this.mRouteCount = 0;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/voice/NaviState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */