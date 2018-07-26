package com.baidu.che.codriver.platform.navi;

import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.che.codriver.p122h.C2543d;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.sdk.p081a.C2575a;
import com.baidu.che.codriver.sdk.p081a.C2575a.C1979b;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class NaviState {
    public static final String CODRIVER_EXIT_APP = "CODRIVER_EXIT_APP";
    public static final String CODRIVER_EXIT_NAVI = "CODRIVER_EXIT_NAVI";
    public static final String TAG = "NaviState";
    private Set<String> mCommonCmdSet = new HashSet();
    private Set<String> mCruiseCmdSet = new HashSet();
    private NaviAppState mCurState = NaviAppState.STATE_NORMAL;
    private HashMap<String, NaviDialog> mDialogMap = new HashMap();
    private HashMap<String, String> mMapCmdMap = new HashMap();
    private Set<String> mNaviCmdSet = new HashSet();
    private Set<String> mNormalCmdSet = new HashSet();
    private RouteDetail mRouteDetail = new RouteDetail();
    private C1979b mSceneCommand = new C25551();

    /* renamed from: com.baidu.che.codriver.platform.navi.NaviState$1 */
    class C25551 extends C1979b {
        C25551() {
        }

        public void onCommand(String type, String cmd) {
            C2725h.m10207b(NaviState.TAG, "mSceneCommand onCommand(): type=" + type + " cmd=" + cmd);
            if (!NaviCmdController.getInstance().isNaviFront()) {
                C2725h.m10207b(NaviState.TAG, "navi background, return");
            } else if (NaviState.this.tryExecuteDialogCmd(type, cmd)) {
                C2725h.m10207b(NaviState.TAG, cmd + " consumed by dialog");
            } else if (NaviState.this.tryExecuteRouteDetailCmd(cmd)) {
                C2725h.m10207b(NaviState.TAG, cmd + " consumed by route detail");
            } else if (NaviState.this.tryExecuteMapCmd(type, cmd)) {
                C2725h.m10207b(NaviState.TAG, cmd + " consumed by map control");
            } else {
                C2725h.m10207b(NaviState.TAG, cmd + " not consumed!");
            }
        }
    }

    enum NaviAppState {
        STATE_NORMAL,
        STATE_NAVI,
        STATE_CRUISE
    }

    private static class RouteDetail {
        boolean mIsShowing;
        int mRouteCount;

        private RouteDetail() {
            this.mIsShowing = false;
            this.mRouteCount = 0;
        }

        public void updateState(String params) {
            if (!TextUtils.isEmpty(params)) {
                try {
                    JSONObject bean = new JSONObject(params);
                    String openClose = bean.optString("event");
                    if (openClose.equals("open")) {
                        this.mIsShowing = true;
                        this.mRouteCount = bean.getJSONObject("data").getJSONArray("route_details").length();
                    } else if (openClose.equals("close")) {
                        this.mIsShowing = false;
                        this.mRouteCount = 0;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public NaviState() {
        initCmdSet();
    }

    private void initCmdSet() {
        this.mCommonCmdSet.add(NaviCmdConstants.KEY_NAVI_MODE_NIGHT);
        this.mCommonCmdSet.add(NaviCmdConstants.KEY_NAVI_MODE_DAY);
        this.mCommonCmdSet.add(NaviCmdConstants.KEY_NAVI_ZOOM_IN);
        this.mCommonCmdSet.add(NaviCmdConstants.KEY_NAVI_ZOOM_OUT);
        this.mCommonCmdSet.add(NaviCmdConstants.KEY_NAVI_TRAFFIC_ON);
        this.mCommonCmdSet.add(NaviCmdConstants.KEY_NAVI_TRAFFIC_OFF);
        this.mCommonCmdSet.add(NaviCmdConstants.KEY_NAVI_EXIT_APP);
        this.mNormalCmdSet.add(NaviCmdConstants.KEY_NAVI_EDOG_OFF);
        this.mNormalCmdSet.add(NaviCmdConstants.KEY_NAVI_EDOG_ON);
        this.mNaviCmdSet.add(NaviCmdConstants.KEY_NAVI_OVERVIEW);
        this.mNaviCmdSet.add(NaviCmdConstants.KEY_NAVI_CONTINUE_NAVI);
        this.mNaviCmdSet.add(NaviCmdConstants.KEY_NAVI_NORTH_FORWARD);
        this.mNaviCmdSet.add(NaviCmdConstants.KEY_NAVI_HEAD_FORWARD);
        this.mNaviCmdSet.add(NaviCmdConstants.KEY_NAVI_TTS_MODE_NEWER);
        this.mNaviCmdSet.add(NaviCmdConstants.KEY_NAVI_TTS_MODE_OLDER);
        this.mNaviCmdSet.add(NaviCmdConstants.KEY_NAVI_TTS_MODE_SAFE);
        this.mNaviCmdSet.add(NaviCmdConstants.KEY_NAVI_CURRENT_LIMIT_SPEED);
        this.mNaviCmdSet.add(NaviCmdConstants.KEY_NAVI_PREFER_MODE_AVOID_TRAFFIC);
        this.mNaviCmdSet.add(NaviCmdConstants.KEY_NAVI_PREFER_MODE_MAX_HIGHWAY);
        this.mNaviCmdSet.add(NaviCmdConstants.KEY_NAVI_PREFER_MODE_MIN_HIGHWAY);
        this.mNaviCmdSet.add(NaviCmdConstants.KEY_NAVI_PREFER_MODE_MIN_TOLL);
        this.mNaviCmdSet.add(NaviCmdConstants.KEY_NAVI_PREFER_MODE_RECOMMEND);
        this.mCruiseCmdSet.add(NaviCmdConstants.KEY_NAVI_CURRENT_LIMIT_SPEED);
        this.mCruiseCmdSet.add(NaviCmdConstants.KEY_NAVI_EDOG_OFF);
        this.mCruiseCmdSet.add(NaviCmdConstants.KEY_NAVI_EDOG_ON);
    }

    private void initAllCmdMap(C1979b sceneCommand) {
        sceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_MODE_NIGHT, "夜间模式", "黑夜模式").addCommand(NaviCmdConstants.KEY_NAVI_MODE_NIGHT, "夜间模式", "黑夜模式").addCommand(NaviCmdConstants.KEY_NAVI_MODE_DAY, "日间模式", "白天模式").addCommand(NaviCmdConstants.KEY_NAVI_ZOOM_IN, "放大地图", "地图放大").addCommand(NaviCmdConstants.KEY_NAVI_ZOOM_OUT, "缩小地图", "地图缩小").addCommand(NaviCmdConstants.KEY_NAVI_TRAFFIC_ON, "打开路况").addCommand(NaviCmdConstants.KEY_NAVI_TRAFFIC_OFF, "关闭路况").addCommand(NaviCmdConstants.KEY_NAVI_EXIT_APP, "结束导航", "关闭导航", "退出导航", "取消导航").addCommand(NaviCmdConstants.KEY_NAVI_EDOG_OFF, "关闭电子狗", "退出巡航", "退出巡航模式").addCommand(NaviCmdConstants.KEY_NAVI_EDOG_ON, "打开电子狗", "进入巡航", "进入巡航模式").addCommand(NaviCmdConstants.KEY_NAVI_OVERVIEW, "查看全程", "全览模式").addCommand(NaviCmdConstants.KEY_NAVI_CONTINUE_NAVI, FsmEvent.CONTINUE_NAVI).addCommand(NaviCmdConstants.KEY_NAVI_NORTH_FORWARD, "正北朝上", "正北模式").addCommand(NaviCmdConstants.KEY_NAVI_HEAD_FORWARD, "车头朝上", "跟随模式").addCommand(NaviCmdConstants.KEY_NAVI_TTS_MODE_NEWER, "新手模式").addCommand(NaviCmdConstants.KEY_NAVI_TTS_MODE_OLDER, "老手模式", "专家模式").addCommand(NaviCmdConstants.KEY_NAVI_TTS_MODE_SAFE, "静音模式").addCommand(NaviCmdConstants.KEY_NAVI_PREFER_MODE_AVOID_TRAFFIC, "躲避拥堵").addCommand(NaviCmdConstants.KEY_NAVI_PREFER_MODE_MAX_HIGHWAY, "高速优先").addCommand(NaviCmdConstants.KEY_NAVI_PREFER_MODE_MIN_HIGHWAY, "不走高速").addCommand(NaviCmdConstants.KEY_NAVI_PREFER_MODE_MIN_TOLL, "少收费").addCommand(NaviCmdConstants.KEY_NAVI_PREFER_MODE_RECOMMEND, "推荐路线");
        sceneCommand.addCommand(NaviCmdConstants.KEY_NAVI_CURRENT_LIMIT_SPEED, "当前限速", "限速多少");
    }

    public void enter(NaviAppState state) {
        C2725h.m10207b(TAG, getClass().getSimpleName() + " enter() " + state.name());
        this.mCurState = state;
    }

    public void registerCustomCmd() {
        initRouteDetailCmd(this.mSceneCommand);
        registerDialogCmd(this.mSceneCommand);
        initAllCmdMap(this.mSceneCommand);
        C2575a.m9709a().m9729a(this.mSceneCommand);
    }

    public void unRegisterCustomCmd() {
        C2575a.m9709a().m9732b(this.mSceneCommand);
    }

    public void notifyRouteDetail(String params) {
        this.mRouteDetail.updateState(params);
    }

    private boolean tryExecuteDialogCmd(String type, String word) {
        if (!type.equals(NaviCmdConstants.KEY_NAVI_EXIT_APP) || !this.mDialogMap.isEmpty()) {
            for (String dialogId : this.mDialogMap.keySet()) {
                NaviDialog dialog = (NaviDialog) this.mDialogMap.get(dialogId);
                if (dialogId.equals(CODRIVER_EXIT_APP)) {
                    if ("进入后台".equals(word)) {
                        sendDialogCancelToNavi(CODRIVER_EXIT_APP);
                        return true;
                    } else if ("退出导航".equals(word)) {
                        NaviCmdController.getInstance().executeCmd(NaviCmdConstants.KEY_NAVI_EXIT_APP);
                        sendDialogCancelToNavi(CODRIVER_EXIT_APP);
                        return true;
                    }
                }
                if (dialogId.equals(CODRIVER_EXIT_NAVI)) {
                    if ("取消".equals(word)) {
                        sendDialogCancelToNavi(CODRIVER_EXIT_NAVI);
                        return true;
                    } else if ("确定".equals(word)) {
                        NaviCmdController.getInstance().executeCmd(NaviCmdConstants.KEY_NAVI_EXIT_NAVI);
                        sendDialogCancelToNavi(CODRIVER_EXIT_NAVI);
                        return true;
                    }
                }
                if (word.equals(dialog.mFirstBtn)) {
                    dialog.notifyBtnClick(true);
                    return true;
                } else if (word.equals(dialog.mSecondBtn)) {
                    dialog.notifyBtnClick(false);
                    return true;
                }
            }
            return false;
        } else if (this.mCurState == NaviAppState.STATE_NAVI) {
            sendShowDialogToNavi(CODRIVER_EXIT_NAVI);
            return true;
        } else {
            sendShowDialogToNavi(CODRIVER_EXIT_APP);
            return true;
        }
    }

    private void sendDialogCancelToNavi(String dialogId) {
        String params = "{\"dialogid\":" + dialogId + "}";
    }

    private void initRouteDetailCmd(C1979b sceneCommand) {
        sceneCommand.addCommand("route_detail", "立即导航", "开始导航", "选择第一个", "选择第一条路线", "选择第一条路径", "选择第二条路线", "选择第二条路径", "选择第三条路线", "选择第三条路径", "选择第二个", "选择第三个", "切换第一个", "切换第二个", "切换第三个", "取消");
    }

    private boolean tryExecuteRouteDetailCmd(String word) {
        if (this.mRouteDetail.mIsShowing) {
            String paramRP = null;
            String index = null;
            if ("立即导航,开始导航,".contains(word)) {
                paramRP = "{\"event\":\"start\"}";
            } else if (word.contains("第一") && this.mRouteDetail.mRouteCount > 0) {
                index = "一";
                paramRP = "{\"select\": 1}";
            } else if (word.contains("第二") && this.mRouteDetail.mRouteCount > 1) {
                index = "二";
                paramRP = "{\"select\": 2}";
            } else if (word.contains("第三") && this.mRouteDetail.mRouteCount > 2) {
                index = "三";
                paramRP = "{\"select\": 3}";
            } else if ("取消,".contains(word)) {
                paramRP = "{\"event\": \"close\"}";
            }
            if (paramRP != null) {
                if (index != null) {
                    C2543d.m9631a().m9633a("好的");
                }
                this.mRouteDetail.mIsShowing = false;
                return true;
            }
        }
        return false;
    }

    private boolean tryExecuteMapCmd(String type, String word) {
        if (!isCmdMatchingState(type) || !canExecuteWithoutDialog(type)) {
            return false;
        }
        NaviCmdController.getInstance().executeCmd(type);
        return true;
    }

    private boolean isCmdMatchingState(String cmdType) {
        if (this.mCommonCmdSet.contains(cmdType)) {
            return true;
        }
        if (this.mCurState == NaviAppState.STATE_NORMAL && this.mNormalCmdSet.contains(cmdType)) {
            return true;
        }
        if (this.mCurState == NaviAppState.STATE_NAVI && this.mNaviCmdSet.contains(cmdType)) {
            return true;
        }
        if (this.mCurState == NaviAppState.STATE_CRUISE && this.mCruiseCmdSet.contains(cmdType)) {
            return true;
        }
        C2725h.m10207b(TAG, "isCmdMatchingState = false");
        return false;
    }

    private boolean canExecuteWithoutDialog(String cmdType) {
        if (NaviCmdConstants.KEY_NAVI_EXIT_NAVI.equals(cmdType) || NaviCmdConstants.KEY_NAVI_EXIT_APP.equals(cmdType)) {
            return false;
        }
        return true;
    }

    private void sendShowDialogToNavi(String dialogId) {
        try {
            JSONObject json = new JSONObject();
            String tts;
            JSONObject value;
            NaviDialog dialog;
            if (CODRIVER_EXIT_APP.equals(dialogId)) {
                tts = "您可以选择进入后台或者退出";
                json.put("dialogid", CODRIVER_EXIT_APP);
                json.put("type", PushConstants.EXTRA_PUSH_MESSAGE);
                value = new JSONObject();
                value.put("title", "提示");
                value.put("content", tts);
                value.put("firstbtn", "进入后台");
                value.put("secondbtn", "退出导航");
                json.put("value", value);
                dialog = NaviDialog.create(tts, "进入后台", "退出导航", CODRIVER_EXIT_APP);
                this.mDialogMap.put(CODRIVER_EXIT_APP, dialog);
                C2725h.m10207b(TAG, "put dialog id=" + dialog.mDialogId + " size=" + this.mDialogMap.size());
                C2543d.m9631a().m9633a(tts);
            } else if (CODRIVER_EXIT_NAVI.equals(dialogId)) {
                tts = "您确定要结束导航吗";
                json.put("dialogid", CODRIVER_EXIT_NAVI);
                json.put("type", PushConstants.EXTRA_PUSH_MESSAGE);
                value = new JSONObject();
                value.put("title", "提示");
                value.put("content", tts);
                value.put("firstbtn", "取消");
                value.put("secondbtn", "确定");
                json.put("value", value);
                dialog = NaviDialog.create(tts, "取消", "确定", CODRIVER_EXIT_NAVI);
                this.mDialogMap.put(CODRIVER_EXIT_NAVI, dialog);
                C2725h.m10207b(TAG, "put dialog id=" + dialog.mDialogId + " size=" + this.mDialogMap.size());
                C2543d.m9631a().m9633a(tts);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void registerDialogCmd(C1979b sceneCommand) {
        sceneCommand.addCommand(CODRIVER_EXIT_APP, "进入后台", "取消", "确定");
        for (String dialogId : this.mDialogMap.keySet()) {
            NaviDialog dialog = (NaviDialog) this.mDialogMap.get(dialogId);
            if (!(dialog == null || CODRIVER_EXIT_APP.equals(dialog.mDialogId) || CODRIVER_EXIT_NAVI.equals(dialog.mDialogId))) {
                C2725h.m10207b(TAG, "registerDialogCmd id=" + dialogId);
                sceneCommand.addCommand(dialog.mDialogId, dialog.mFirstBtn, dialog.mSecondBtn);
            }
        }
    }

    public void notifyShowDialog(String params) {
        NaviDialog dialog = NaviDialog.create(params);
        C2543d.m9631a().m9633a(dialog.mContent);
        this.mDialogMap.put(dialog.mDialogId, dialog);
        C2725h.m10207b(TAG, "put dialog id=" + dialog.mDialogId + " size=" + this.mDialogMap.size());
        if (!CODRIVER_EXIT_APP.equals(dialog.mDialogId) && !CODRIVER_EXIT_NAVI.equals(dialog.mDialogId)) {
            registerCustomCmd();
        }
    }

    public void notifyCancelDialog(String params) {
        try {
            String dialogId = new JSONObject(params).getString("dialogid");
            NaviDialog dialog = (NaviDialog) this.mDialogMap.remove(dialogId);
            C2725h.m10207b(TAG, "remove dialog id=" + dialogId + " size=" + this.mDialogMap.size());
            if (dialog != null && !CODRIVER_EXIT_APP.equals(dialog.mDialogId) && !CODRIVER_EXIT_NAVI.equals(dialog.mDialogId)) {
                registerCustomCmd();
                C2543d.m9631a().m9639c();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void handleDialogResponse(String params) {
        JSONException e;
        try {
            JSONObject json = new JSONObject(params);
            JSONObject jSONObject;
            try {
                String dialogId = json.getString("dialogid");
                int order = json.getInt(NaviCmdConstants.KEY_NAVI_CMD_ORDER);
                if (CODRIVER_EXIT_APP.equals(dialogId)) {
                    if (order == -2) {
                        NaviCmdController.getInstance().executeCmd(NaviCmdConstants.KEY_NAVI_EXIT_APP);
                    }
                } else if (CODRIVER_EXIT_NAVI.equals(dialogId) && order == -2) {
                    NaviCmdController.getInstance().executeCmd(NaviCmdConstants.KEY_NAVI_EXIT_NAVI);
                }
                C2543d.m9631a().m9639c();
                jSONObject = json;
            } catch (JSONException e2) {
                e = e2;
                jSONObject = json;
                e.printStackTrace();
            }
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
        }
    }

    public void resetAllDialogState() {
        C2725h.m10207b(TAG, getClass().getSimpleName() + " resetAllDialogState() mDialogMap clear()");
        this.mDialogMap.clear();
    }
}
