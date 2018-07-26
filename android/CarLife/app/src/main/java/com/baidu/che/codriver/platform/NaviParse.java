package com.baidu.che.codriver.platform;

import com.baidu.che.codriver.platform.NaviCmdOriginalData.ExtInfo;
import com.baidu.che.codriver.util.C2725h;
import com.google.gson.Gson;
import java.util.HashMap;

public class NaviParse {
    private static final String TAG = "NaviParse";
    private static NaviParse mInstance;
    private static NaviParse sIntance = null;
    private static final Object sLock = new Object();
    private Gson mGson = new Gson();
    private HashMap<String, NaviCmdData> mNaviHash;

    private NaviParse() {
    }

    public static NaviParse getInstance() {
        if (sIntance == null) {
            synchronized (sLock) {
                if (sIntance == null) {
                    sIntance = new NaviParse();
                }
            }
        }
        return sIntance;
    }

    public NaviCmdData parse(String coDriverCmd) {
        if (coDriverCmd.startsWith(NaviCmdConstants.KEY_PREFIX)) {
            return getInstance().getNaviCmdData(coDriverCmd);
        }
        try {
            NaviCmdOriginalData mNaviCmdOriginalData = (NaviCmdOriginalData) this.mGson.fromJson(coDriverCmd, NaviCmdOriginalData.class);
            if ("navigate_instruction".equals(mNaviCmdOriginalData.domain)) {
                return parseDomainNaviInstruction(mNaviCmdOriginalData);
            }
            if ("map".equals(mNaviCmdOriginalData.domain)) {
                return parseDomainMap(mNaviCmdOriginalData);
            }
            return null;
        } catch (Exception ex) {
            C2725h.m10214e(TAG, "parse navi cmd error");
            ex.printStackTrace();
            return null;
        }
    }

    private NaviCmdData parseDomainMap(NaviCmdOriginalData mNaviCmdOriginalData) {
        if ("route".equals(mNaviCmdOriginalData.intent) || "poi".equals(mNaviCmdOriginalData.intent)) {
            if (mNaviCmdOriginalData.object != null) {
                return parseObjectPoi(mNaviCmdOriginalData.object);
            }
            return null;
        } else if (!"nearby".equals(mNaviCmdOriginalData.intent) || mNaviCmdOriginalData.object == null) {
            return null;
        } else {
            return parseObjectPoi(mNaviCmdOriginalData.object);
        }
    }

    private NaviCmdData parseDomainNaviInstruction(NaviCmdOriginalData mNaviCmdOriginalData) {
        if (NaviCmdConstants.INTENT_ZOOM_IN.equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_ZOOM_IN);
        }
        if (NaviCmdConstants.INTENT_ZOOM_OUT.equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_ZOOM_OUT);
        }
        if (NaviCmdConstants.INTENT_MOVE_LEFT.equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_MOVE_LEFT);
        }
        if (NaviCmdConstants.INTENT_MOVE_RIGHT.equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_MOVE_RIGHT);
        }
        if (NaviCmdConstants.INTENT_MOVE_UP.equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_MOVE_UP);
        }
        if (NaviCmdConstants.INTENT_MOVE_DOWN.equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_MOVE_DOWN);
        }
        if ("quit".equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_EXIT_APP);
        }
        if ("navigate".equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_START_APP);
        }
        if (NaviCmdConstants.INTENT_VIEW_MAP.equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_START_APP);
        }
        if ("speed_limit".equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_CURRENT_LIMIT_SPEED);
        }
        if (NaviCmdConstants.INTENT_REST_TIME.equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_QUERY_CURRENT_REST_TIME);
        }
        if (NaviCmdConstants.INTENT_REST_DISTANCE.equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_QUERY_CURRENT_REST_DISTANCE);
        }
        if ("route_work".equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_START_TASK_COMPANY);
        }
        if ("route_home".equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_START_TASK_HOME);
        }
        if ("set_work".equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_SET_COMPANY_ADDRESS);
        }
        if ("set_home".equals(mNaviCmdOriginalData.intent)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_SET_HOME_ADDRESS);
        }
        if (NaviCmdConstants.INTENT_SWITCH_MODE.equals(mNaviCmdOriginalData.intent)) {
            if (mNaviCmdOriginalData.object != null) {
                return parseObjectSwitchModeItem(mNaviCmdOriginalData.object);
            }
            return null;
        } else if ("open".equals(mNaviCmdOriginalData.intent)) {
            if (mNaviCmdOriginalData.object != null) {
                return parseObjectOpenItem(mNaviCmdOriginalData.object);
            }
            return null;
        } else if (!"close".equals(mNaviCmdOriginalData.intent) || mNaviCmdOriginalData.object == null) {
            return null;
        } else {
            return parseObjectCloseItem(mNaviCmdOriginalData.object);
        }
    }

    private NaviCmdData parseObjectSwitchModeItem(ExtInfo object) {
        if (NaviCmdConstants.OBJECT_SWITCH_MODE_NORTH_FORWARD.equals(object.item)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_NORTH_FORWARD);
        }
        if (NaviCmdConstants.OBJECT_SWITCH_MODE_HEAD_FORWARD.equals(object.item)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_HEAD_FORWARD);
        }
        if ("day".equals(object.item)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_MODE_DAY);
        }
        if (NaviCmdConstants.OBJECT_SWITCH_MODE_NIGHT.equals(object.item)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_MODE_NIGHT);
        }
        if (NaviCmdConstants.OBJECT_SWITCH_MODE_NEW_HAND.equals(object.item)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_TTS_MODE_NEWER);
        }
        if (NaviCmdConstants.OBJECT_SWITCH_MODE_OLD_HAND.equals(object.item)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_TTS_MODE_OLDER);
        }
        if (NaviCmdConstants.OBJECT_SWITCH_MODE_EXPERT.equals(object.item)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_TTS_MODE_EXPERT);
        }
        if (NaviCmdConstants.OBJECT_SWITCH_MODE_SAFE.equals(object.item)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_TTS_MODE_SAFE);
        }
        if (NaviCmdConstants.OBJECT_SWITCH_MODE_FULL_ROUTE.equals(object.item)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_OVERVIEW);
        }
        if (NaviCmdConstants.OBJECT_SWITCH_MODE_CONTINUE_NAVI.equals(object.item)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_CONTINUE_NAVI);
        }
        return null;
    }

    private NaviCmdData parseObjectOpenItem(ExtInfo object) {
        if (NaviCmdConstants.OBJECT_OPEN_ROUTE_CONDITION.equals(object.item)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_TRAFFIC_ON);
        }
        if (NaviCmdConstants.OBJECT_OPEN_ELECTRONIC_DOG.equals(object.item)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_EDOG_ON);
        }
        return null;
    }

    private NaviCmdData parseObjectCloseItem(ExtInfo object) {
        if (NaviCmdConstants.OBJECT_OPEN_ROUTE_CONDITION.equals(object.item)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_TRAFFIC_OFF);
        }
        if (NaviCmdConstants.OBJECT_OPEN_ELECTRONIC_DOG.equals(object.item)) {
            return (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_EDOG_OFF);
        }
        return null;
    }

    private NaviCmdData parseObjectPoi(ExtInfo object) {
        NaviCmdData mNaviCmdData = (NaviCmdData) this.mNaviHash.get(NaviCmdConstants.KEY_NAVI_START_TASK);
        if (object != null) {
            mNaviCmdData.setParams(NaviCmdData.createParamsPoi(object));
        }
        return mNaviCmdData;
    }

    private NaviCmdData parseObjectArrival(ExtInfo object) {
        return null;
    }

    public void initCmdHashMap() {
        this.mNaviHash = new HashMap();
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_VERSION, new NaviCmdData(NaviCmdConstants.FUN_NAVI_GET_VERSION_INFO, ""));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_MODE_NIGHT, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, (int) NaviCmdConstants.ACTION_TYPE_NAVI_MODE_NIGHT)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_MODE_DAY, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, (int) NaviCmdConstants.ACTION_TYPE_NAVI_MODE_DAY)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_ZOOM_IN, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, 203)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_ZOOM_OUT, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, 202)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_MOVE_LEFT, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, 221)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_MOVE_RIGHT, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, (int) NaviCmdConstants.ACTION_TYPE_NAVI_MOVE_RIGHT)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_MOVE_UP, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, 222)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_MOVE_DOWN, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, 223)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_OVERVIEW, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, 216)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_CONTINUE_NAVI, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, 217)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_NORTH_FORWARD, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, 229)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_HEAD_FORWARD, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, 230)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_TRAFFIC_ON, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, 207)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_TRAFFIC_OFF, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, 208)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_TTS_MODE_NEWER, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, (int) NaviCmdConstants.ACTION_TYPE_NAVI_TTS_MODE_NEWER)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_TTS_MODE_EXPERT, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, (int) NaviCmdConstants.ACTION_TYPE_NAVI_TTS_MODE_EXPERT)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_TTS_MODE_OLDER, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, (int) NaviCmdConstants.ACTION_TYPE_NAVI_TTS_MODE_EXPERT)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_TTS_MODE_SAFE, new NaviCmdData(NaviCmdConstants.FUN_NAVI_MAP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, 206)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_QUERY_NAVI_STATE, new NaviCmdData(NaviCmdConstants.FUN_NAVI_NAVI_STATE, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_QUERY_NAVI_STATE)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_QUERY_EDOG_STATE, new NaviCmdData(NaviCmdConstants.FUN_NAVI_NAVI_STATE, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_QUERY_EDOG_STATE)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_QUERY_DESTINATION, new NaviCmdData(NaviCmdConstants.FUN_NAVI_NAVI_STATE, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_QUERY_DESTINATION)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_QUERY_ROUTE_MODE, new NaviCmdData(NaviCmdConstants.FUN_NAVI_NAVI_STATE, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_QUERY_ROUTE_MODE)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_QUERY_CURRENT_ROUTE_MODE, new NaviCmdData(NaviCmdConstants.FUN_NAVI_NAVI_STATE, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_QUERY_CURRENT_ROUTE_MODE)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_QUERY_CURRENT_POSITION, new NaviCmdData(NaviCmdConstants.FUN_NAVI_NAVI_STATE, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_QUERY_CURRENT_POSITION)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_QUERY_CURRENT_REST_TIME, new NaviCmdData(NaviCmdConstants.FUN_NAVI_NAVI_STATE, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_QUERY_CURRENT_REST_TIME)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_QUERY_CURRENT_REST_DISTANCE, new NaviCmdData(NaviCmdConstants.FUN_NAVI_NAVI_STATE, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_QUERY_CURRENT_REST_DISTANCE)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_FOREGROUND_STATE, new NaviCmdData(NaviCmdConstants.FUN_NAVI_APP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_FOREGROUND_STATE)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_EXIT_NAVI, new NaviCmdData(NaviCmdConstants.FUN_NAVI_APP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_EXIT_NAVI)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_EXIT_APP, new NaviCmdData(NaviCmdConstants.FUN_NAVI_APP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_EXIT_APP)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_START_APP, new NaviCmdData(NaviCmdConstants.FUN_NAVI_APP_CONTROL, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_START_APP)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_CURRENT_LIMIT_SPEED, new NaviCmdData(NaviCmdConstants.FUN_NAVI_LIMIT_SPEED, ""));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_EDOG_ON, new NaviCmdData(NaviCmdConstants.FUN_NAVI_CRUISE, NaviCmdData.createParams("event", "open")));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_EDOG_OFF, new NaviCmdData(NaviCmdConstants.FUN_NAVI_CRUISE, NaviCmdData.createParams("event", "close")));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_QUERY_POI_TRAFFIC, new NaviCmdData(NaviCmdConstants.FUN_NAVI_QUERY_TRAFFIC, ""));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_SET_HOME_ADDRESS, new NaviCmdData(NaviCmdConstants.FUN_NAVI_NAVI_SET, ""));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_SET_COMPANY_ADDRESS, new NaviCmdData(NaviCmdConstants.FUN_NAVI_NAVI_SET, ""));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_QUERY_HOME_ADDRESS, new NaviCmdData(NaviCmdConstants.FUN_NAVI_SYN_ADDRESS, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_QUERY_HOME_ADDRESS)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_QUERY_COMPANY_ADDRESS, new NaviCmdData(NaviCmdConstants.FUN_NAVI_SYN_ADDRESS, NaviCmdData.createParams(NaviCmdConstants.KEY_NAVI_CMD_ORDER, NaviCmdConstants.ACTION_TYPE_NAVI_QUERY_COMPANY_ADDRESS)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_START_TASK, new NaviCmdData(NaviCmdConstants.FUN_NAVI_START_TASK, ""));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_START_TASK_HOME, new NaviCmdData(NaviCmdConstants.FUN_NAVI_START_TASK, ""));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_START_TASK_COMPANY, new NaviCmdData(NaviCmdConstants.FUN_NAVI_START_TASK, ""));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_PREFER_MODE_RECOMMEND, new NaviCmdData(NaviCmdConstants.FUN_NAVI_NAVI_SET, NaviCmdData.createParamsResetNaviByPreference("1")));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_PREFER_MODE_MAX_HIGHWAY, new NaviCmdData(NaviCmdConstants.FUN_NAVI_NAVI_SET, NaviCmdData.createParamsResetNaviByPreference("2")));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_PREFER_MODE_MIN_HIGHWAY, new NaviCmdData(NaviCmdConstants.FUN_NAVI_NAVI_SET, NaviCmdData.createParamsResetNaviByPreference("4")));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_PREFER_MODE_MIN_TOLL, new NaviCmdData(NaviCmdConstants.FUN_NAVI_NAVI_SET, NaviCmdData.createParamsResetNaviByPreference(NaviCmdConstants.ACTION_TYPE_PREFER_MODE_MIN_TOLL)));
        this.mNaviHash.put(NaviCmdConstants.KEY_NAVI_PREFER_MODE_AVOID_TRAFFIC, new NaviCmdData(NaviCmdConstants.FUN_NAVI_NAVI_SET, NaviCmdData.createParamsResetNaviByPreference("16")));
    }

    public NaviCmdData getNaviCmdData(String key) {
        if (this.mNaviHash != null) {
            return (NaviCmdData) this.mNaviHash.get(key);
        }
        C2725h.m10214e(TAG, "don't init navi hash map");
        return null;
    }
}
