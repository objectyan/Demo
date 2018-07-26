package com.baidu.navi.voice;

import android.text.TextUtils;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.logic.codriver.adapter.C1754b;
import com.baidu.carlife.p052m.C1915a;
import com.baidu.carlife.util.C2201w;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.sdk.p081a.C2575a.C1979b;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NaviState {
    private static final String TAG = NaviState.class.getSimpleName();
    private static NaviState mInstance;
    private Set<String> mBrowseMapCmdSet = new HashSet();
    private Set<String> mCommonCmdSet = new HashSet();
    private HashMap<String, String> mMapCmdMap = new HashMap();
    private RouteDetail mRouteDetail = new RouteDetail();
    private Set<String> mRouteGuideCmdSet = new HashSet();
    private C1979b mSceneCommand = new C40461();
    private Set<String> mVoiceModeCmdSet = new HashSet();

    /* renamed from: com.baidu.navi.voice.NaviState$1 */
    class C40461 extends C1979b {
        C40461() {
        }

        public void onCommand(String type, String cmd) {
            C1260i.b(NaviState.TAG, "mCommandListener onCommand():" + cmd);
            StatisticManager.onEvent(StatisticConstants.VOICE_0005);
            if (NaviState.this.tryExecuteRouteDetailCmd(cmd)) {
                C1260i.b(NaviState.TAG, cmd + " consumed by routeDetail");
            } else if (NaviState.this.tryExecuteMapCmd(cmd)) {
                C1260i.b(NaviState.TAG, cmd + " consumed by map control");
            } else {
                C1260i.b(NaviState.TAG, cmd + " not consumed!");
            }
        }
    }

    private static class RouteDetail {
        boolean mIsShowing;
        int mRouteCount;

        private RouteDetail() {
            this.mIsShowing = false;
            this.mRouteCount = 0;
        }

        public void updateState(boolean isOpen, int routeCount) {
            this.mIsShowing = isOpen;
            if (isOpen) {
                this.mRouteCount = routeCount;
            } else {
                this.mRouteCount = 0;
            }
        }
    }

    private NaviState() {
        initAllCmdSet();
    }

    public static NaviState getInstance() {
        if (mInstance == null) {
            mInstance = new NaviState();
        }
        return mInstance;
    }

    private void initAllCmdSet() {
        this.mBrowseMapCmdSet.add(NaviCmdConstants.KEY_NAVI_ZOOM_IN);
        this.mBrowseMapCmdSet.add(NaviCmdConstants.KEY_NAVI_ZOOM_OUT);
        this.mBrowseMapCmdSet.add(NaviCmdConstants.KEY_NAVI_MOVE_UP);
        this.mBrowseMapCmdSet.add(NaviCmdConstants.KEY_NAVI_MOVE_DOWN);
        this.mBrowseMapCmdSet.add(NaviCmdConstants.KEY_NAVI_MOVE_LEFT);
        this.mBrowseMapCmdSet.add(NaviCmdConstants.KEY_NAVI_MOVE_RIGHT);
        this.mBrowseMapCmdSet.add(NaviCmdConstants.KEY_NAVI_NORTH_FORWARD);
        this.mBrowseMapCmdSet.add(NaviCmdConstants.KEY_NAVI_HEAD_FORWARD);
        this.mCommonCmdSet.add(NaviCmdConstants.KEY_NAVI_MODE_DAY);
        this.mCommonCmdSet.add(NaviCmdConstants.KEY_NAVI_MODE_NIGHT);
        this.mCommonCmdSet.add(NaviCmdConstants.KEY_NAVI_TRAFFIC_OFF);
        this.mCommonCmdSet.add(NaviCmdConstants.KEY_NAVI_TRAFFIC_ON);
        this.mRouteGuideCmdSet.add(NaviCmdConstants.KEY_NAVI_OVERVIEW);
        this.mRouteGuideCmdSet.add(NaviCmdConstants.KEY_NAVI_CONTINUE_NAVI);
        this.mRouteGuideCmdSet.add(NaviCmdConstants.KEY_NAVI_EXIT_NAVI);
        this.mVoiceModeCmdSet.add(NaviCmdConstants.KEY_NAVI_TTS_MODE_NEWER);
        this.mVoiceModeCmdSet.add(NaviCmdConstants.KEY_NAVI_TTS_MODE_OLDER);
        this.mVoiceModeCmdSet.add(NaviCmdConstants.KEY_NAVI_TTS_MODE_SAFE);
        this.mVoiceModeCmdSet.add(NaviCmdConstants.KEY_NAVI_TTS_MODE_EXPERT);
    }

    private void initAllCmdMap() {
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_ZOOM_IN, new String[]{"放大地图", "地图放大"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_ZOOM_OUT, new String[]{"缩小地图", "地图缩小"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_MOVE_DOWN, new String[]{"地图向下"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_MOVE_LEFT, new String[]{"地图向左"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_MOVE_RIGHT, new String[]{"地图向右"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_MOVE_UP, new String[]{"地图向上"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_NORTH_FORWARD, new String[]{"正北朝上", "正北模式"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_HEAD_FORWARD, new String[]{"车头朝上", "跟随模式"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_MODE_NIGHT, new String[]{"夜间模式", "黑夜模式"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_MODE_DAY, new String[]{"日间模式", "白天模式"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_TRAFFIC_ON, new String[]{"打开路况"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_TRAFFIC_OFF, new String[]{"关闭路况"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_OVERVIEW, new String[]{"查看全程", "全览模式"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_CONTINUE_NAVI, new String[]{FsmEvent.CONTINUE_NAVI, "恢复导航"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_EXIT_NAVI, new String[]{"结束导航", "关闭导航", "退出导航"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_TTS_MODE_NEWER, new String[]{"新手模式"});
        this.mSceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_TTS_MODE_OLDER, new String[]{"老手模式", "专家模式"});
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_ZOOM_IN, "放大地图,地图放大");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_ZOOM_OUT, "缩小地图,地图缩小");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_MOVE_DOWN, "地图向下");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_MOVE_LEFT, "地图向左");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_MOVE_RIGHT, "地图向右");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_MOVE_UP, "地图向上");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_NORTH_FORWARD, "正北朝上,正北模式");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_HEAD_FORWARD, "车头朝上,跟随模式");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_MODE_NIGHT, "夜间模式,黑夜模式");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_MODE_DAY, "日间模式,白天模式");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_TRAFFIC_ON, "打开路况");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_TRAFFIC_OFF, "关闭路况");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_OVERVIEW, "查看全程,全览模式");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_CONTINUE_NAVI, "继续导航,恢复导航");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_EXIT_NAVI, "结束导航,关闭导航,退出导航");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_TTS_MODE_NEWER, "新手模式");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_TTS_MODE_OLDER, "老手模式,专家模式");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_CRUISE_ON, "打开电子狗");
        this.mMapCmdMap.put(NaviCmdConstants.KEY_NAVI_CRUISE_OFF, "关闭电子狗");
    }

    public void registerCustomCmd() {
        initAllCmdMap();
        initRouteDetailCmd();
        C1754b.a().a(this.mSceneCommand);
    }

    private void initRouteDetailCmd() {
        this.mSceneCommand.addCommand("route_detail", new String[]{"立即导航", "开始导航", "选择第一个", "选择第一条路线", "选择第一条路径", "选择第二条路线", "选择第二条路径", "选择第三条路线", "选择第三条路径", "选择第二个", "选择第三个", "切换第一个", "切换第二个", "切换第三个"});
    }

    public void notifyRouteDetail(boolean isOpen, int routeCount) {
        this.mRouteDetail.updateState(isOpen, routeCount);
    }

    private boolean tryExecuteRouteDetailCmd(String word) {
        if (this.mRouteDetail.mIsShowing && C1328h.a().getCurrentFragmentType() == 52) {
            boolean isStartNavi = false;
            int index = 0;
            if ("立即导航,开始导航,".contains(word)) {
                isStartNavi = true;
            } else if (word.contains("第一") && this.mRouteDetail.mRouteCount > 0) {
                index = 1;
            } else if (word.contains("第二") && this.mRouteDetail.mRouteCount > 1) {
                index = 2;
            } else if (word.contains("第三") && this.mRouteDetail.mRouteCount > 2) {
                index = 3;
            }
            if (index > 0) {
                this.mRouteDetail.mIsShowing = false;
                MapVoiceCommandController.getInstance().selectRouteAndStartNavi(index - 1);
                return true;
            } else if (isStartNavi) {
                this.mRouteDetail.mIsShowing = false;
                MapVoiceCommandController.getInstance().startNavi();
                return true;
            }
        }
        return false;
    }

    private boolean tryExecuteMapCmd(String word) {
        for (String cmdType : this.mMapCmdMap.keySet()) {
            if (((String) this.mMapCmdMap.get(cmdType)).contains(word)) {
                if (isCmdMatchingState(cmdType)) {
                    return executeCmd(cmdType);
                }
                return false;
            }
        }
        return false;
    }

    private boolean isCmdMatchingState(String cmdType) {
        if (this.mBrowseMapCmdSet.contains(cmdType) || this.mCommonCmdSet.contains(cmdType) || this.mRouteGuideCmdSet.contains(cmdType) || this.mVoiceModeCmdSet.contains(cmdType)) {
            return true;
        }
        C1260i.b(TAG, "isCmdMatchingState = false");
        return false;
    }

    public boolean executeCmd(String commandType) {
        if (!MapVoiceCommandController.getInstance().isMapModule() || !MapVoiceCommandController.getInstance().isMapContentFragment()) {
            handleError();
            return false;
        } else if (TextUtils.isEmpty(commandType)) {
            return false;
        } else {
            if (NaviCmdConstants.KEY_NAVI_ZOOM_IN.equals(commandType)) {
                MapVoiceCommandController.getInstance().mapZoomIn();
            } else if (NaviCmdConstants.KEY_NAVI_ZOOM_OUT.equals(commandType)) {
                MapVoiceCommandController.getInstance().mapZoomOut();
            } else if (NaviCmdConstants.KEY_NAVI_MOVE_DOWN.equals(commandType)) {
                MapVoiceCommandController.getInstance().mapMoveDown();
            } else if (NaviCmdConstants.KEY_NAVI_MOVE_LEFT.equals(commandType)) {
                MapVoiceCommandController.getInstance().mapMoveLeft();
            } else if (NaviCmdConstants.KEY_NAVI_MOVE_RIGHT.equals(commandType)) {
                MapVoiceCommandController.getInstance().mapMoveRight();
            } else if (NaviCmdConstants.KEY_NAVI_MOVE_UP.equals(commandType)) {
                MapVoiceCommandController.getInstance().mapMoveUp();
            } else if (NaviCmdConstants.KEY_NAVI_NORTH_FORWARD.equals(commandType)) {
                MapVoiceCommandController.getInstance().mapNorthForward();
            } else if (NaviCmdConstants.KEY_NAVI_HEAD_FORWARD.equals(commandType)) {
                MapVoiceCommandController.getInstance().mapCarForward();
            } else if (NaviCmdConstants.KEY_NAVI_MODE_NIGHT.equals(commandType)) {
                MapVoiceCommandController.getInstance().switchDayNightMode(false);
            } else if (NaviCmdConstants.KEY_NAVI_MODE_DAY.equals(commandType)) {
                MapVoiceCommandController.getInstance().switchDayNightMode(true);
            } else if (NaviCmdConstants.KEY_NAVI_TRAFFIC_ON.equals(commandType)) {
                MapVoiceCommandController.getInstance().switchRoadCondition(true);
            } else if (NaviCmdConstants.KEY_NAVI_TRAFFIC_OFF.equals(commandType)) {
                MapVoiceCommandController.getInstance().switchRoadCondition(false);
            } else if (NaviCmdConstants.KEY_NAVI_OVERVIEW.equals(commandType)) {
                MapVoiceCommandController.getInstance().naviFullView();
            } else if (NaviCmdConstants.KEY_NAVI_CONTINUE_NAVI.equals(commandType)) {
                MapVoiceCommandController.getInstance().naviContinue();
            } else if (NaviCmdConstants.KEY_NAVI_EXIT_NAVI.equals(commandType)) {
                MapVoiceCommandController.getInstance().exitNavi();
            } else if (NaviCmdConstants.KEY_NAVI_TTS_MODE_NEWER.equals(commandType)) {
                MapVoiceCommandController.getInstance().switchNaviVoiceMode(true);
            } else if (NaviCmdConstants.KEY_NAVI_TTS_MODE_OLDER.equals(commandType)) {
                MapVoiceCommandController.getInstance().switchNaviVoiceMode(false);
            } else if (NaviCmdConstants.KEY_NAVI_CRUISE_ON.equals(commandType)) {
                C1260i.b(TAG, "KEY_NAVI_CRUISE_ON");
            } else if (NaviCmdConstants.KEY_NAVI_CRUISE_OFF.equals(commandType)) {
                C1260i.b(TAG, "KEY_NAVI_CRUISE_OFF");
            }
            return true;
        }
    }

    private void handleError() {
        C1915a.a().b("当前页面不支持", 0);
        C2201w.a("当前页面不支持");
    }
}
