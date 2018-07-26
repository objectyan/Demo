package com.baidu.che.codriver.platform.navi;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.p122h.C2543d;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.platform.NaviCmdData;
import com.baidu.che.codriver.platform.NaviParse;
import com.baidu.che.codriver.platform.PlatformManager;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2721e;
import com.baidu.che.codriver.util.C2722f;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.p130a.C2747a;
import com.google.gson.Gson;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class NaviCmdController {
    private static final String COMMPANY_ADDRESS_FILE = "commpany_address_file";
    private static final String HOME_ADDRESS_FILE = "home_address_file";
    public static final String TAG = "NaviCmdController";
    private static NaviCmdController mInstance;
    private NaviAddressData mCommpanyAddress = null;
    private NaviState mCurrentState = new NaviState();
    private Gson mGson = new Gson();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private NaviAddressData mHomeAddress = null;
    private boolean mIsNaviFront = false;
    private HashMap<String, String> mMapControlRequestMap = new HashMap();

    /* renamed from: com.baidu.che.codriver.platform.navi.NaviCmdController$2 */
    class C25512 implements Runnable {
        C25512() {
        }

        public void run() {
            C2543d.m9631a().m9633a(C2716c.m10141a().getString(C0965R.string.navi_command_reset_bypreference_success));
        }
    }

    /* renamed from: com.baidu.che.codriver.platform.navi.NaviCmdController$3 */
    class C25523 implements Runnable {
        C25523() {
        }

        public void run() {
            NaviCmdController.this.executeCmd(NaviCmdConstants.KEY_NAVI_QUERY_HOME_ADDRESS, Boolean.valueOf(false));
            NaviCmdController.this.executeCmd(NaviCmdConstants.KEY_NAVI_QUERY_COMPANY_ADDRESS, Boolean.valueOf(false));
        }
    }

    /* renamed from: com.baidu.che.codriver.platform.navi.NaviCmdController$4 */
    class C25534 implements Runnable {
        C25534() {
        }

        public void run() {
            try {
                String homeParams = C2722f.m10186a(NaviCmdController.HOME_ADDRESS_FILE);
                String commpanyParams = C2722f.m10186a(NaviCmdController.COMMPANY_ADDRESS_FILE);
                NaviCmdController.this.handleNaviAppAddress(homeParams);
                NaviCmdController.this.handleNaviAppAddress(commpanyParams);
            } catch (Exception ex) {
                C2725h.m10207b(NaviCmdController.TAG, "read address from file error");
                ex.printStackTrace();
            }
        }
    }

    private NaviCmdController() {
    }

    public static NaviCmdController getInstance() {
        if (mInstance == null) {
            synchronized (NaviCmdController.class) {
                if (mInstance == null) {
                    mInstance = new NaviCmdController();
                }
            }
        }
        return mInstance;
    }

    public void executeCmd(String cmdType) {
        C2725h.m10207b(TAG, "executeCmd() cmdType = " + cmdType);
        PlatformManager.getInstance().sendNaviCommand(cmdType, Boolean.valueOf(true));
    }

    public void executeCmd(String cmdType, Boolean needLaunchApp) {
        C2725h.m10207b(TAG, "executeCmd() cmdType = " + cmdType);
        PlatformManager.getInstance().sendNaviCommand(cmdType, needLaunchApp);
    }

    public boolean isNaviFront() {
        C2725h.m10214e(TAG, "isNaviFront = " + this.mIsNaviFront);
        return this.mIsNaviFront;
    }

    public void handleResponse(int type, int errorNo, String requestId, String func, String params) {
        final String str = func;
        final String str2 = params;
        final String str3 = requestId;
        final int i = errorNo;
        this.mHandler.post(new Runnable() {
            public void run() {
                if (NaviCmdConstants.FUN_NAVI_STATUS_SYNC.equals(str)) {
                    NaviCmdController.this.handleStatusSyncRequest(str2);
                } else if (NaviCmdConstants.FUN_NAVI_MAP_CONTROL.equals(str)) {
                    NaviCmdController.this.handleMapControlReceive(str3, i, str2);
                } else if (NaviCmdConstants.FUN_NAVI_DIALOG_NOTIFY.equals(str)) {
                    NaviCmdController.this.handleDialogShow(str2);
                } else if (NaviCmdConstants.FUN_NAVI_DIALOG_CANCEL.equals(str)) {
                    NaviCmdController.this.handleDialogCancel(str2);
                } else if (NaviCmdConstants.FUN_NAVI_DIALOG_RESPONSE.equals(str)) {
                    NaviCmdController.this.handleDialogResponse(str2);
                } else if (NaviCmdConstants.FUN_NAVI_ROUTE_PLAN.equals(str)) {
                    NaviCmdController.this.handleRouteDetail(str2);
                } else if (NaviCmdConstants.FUN_NAVI_NAVI_STATE.equals(str)) {
                    NaviCmdController.this.handleNaviAppState(str2);
                } else if (NaviCmdConstants.FUN_NAVI_CRUISE.equals(str)) {
                    NaviCmdController.this.handleCruiseResponse(str3, i, str2);
                } else if (NaviCmdConstants.FUN_NAVI_SYN_ADDRESS.equals(str)) {
                    NaviCmdController.this.handleNaviAppAddress(str2);
                } else if (NaviCmdConstants.FUN_NAVI_LIMIT_SPEED.equals(str)) {
                    NaviCmdController.this.handleNaviLimitSpeed(str2);
                } else if (NaviCmdConstants.FUN_NAVI_NAVI_SET.equals(str)) {
                    NaviCmdController.this.handleNaviSet(str3, i);
                }
                NaviCmdController.this.mMapControlRequestMap.remove(str3);
            }
        });
    }

    private void handleCruiseResponse(String requestId, int errorNo, String error) {
        String params = (String) this.mMapControlRequestMap.get(requestId);
        if (params != null) {
            String tts = null;
            try {
                String event = new JSONObject(params).getString("event");
                if ("open".equals(event)) {
                    if (errorNo != 0) {
                        tts = errorNo == 4 ? error : C2716c.m10141a().getString(C0965R.string.navi_command_mode_cruise_open_already);
                    }
                } else if ("close".equals(event)) {
                    tts = errorNo == 0 ? C2716c.m10141a().getString(C0965R.string.navi_command_mode_cruise_close) : C2716c.m10141a().getString(C0965R.string.navi_command_mode_cruise_close_already);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (tts != null) {
                C2543d.m9631a().m9633a(tts);
            }
        }
    }

    private void handleRouteDetail(String params) {
        this.mCurrentState.notifyRouteDetail(params);
    }

    private void handleNaviAppState(String params) {
        try {
            JSONObject json = new JSONObject(params);
            if (json.has("is_innavi")) {
                if (json.getString("is_innavi").equals("true")) {
                    this.mCurrentState.enter(NaviAppState.STATE_NAVI);
                }
            } else if (json.has("is_incruise") && json.getString("is_incruise").equals("true")) {
                this.mCurrentState.enter(NaviAppState.STATE_CRUISE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void handleStatusSyncRequest(String params) {
        try {
            String event = new JSONObject(params).optString("event");
            if ("navi_front".equals(event)) {
                this.mIsNaviFront = true;
            } else if ("navi_background".equals(event)) {
                this.mIsNaviFront = false;
            } else if ("navi_app_launch".equals(event)) {
                requestSyncAddress();
            } else if ("navi_app_exit".equals(event)) {
                this.mIsNaviFront = false;
            } else if ("navi_start".equals(event)) {
                this.mCurrentState.enter(NaviAppState.STATE_NAVI);
            } else if ("navi_end".equals(event)) {
                this.mCurrentState.enter(NaviAppState.STATE_NORMAL);
            } else if ("cruise_start".equals(event)) {
                this.mCurrentState.enter(NaviAppState.STATE_CRUISE);
            } else if ("cruise_end".equals(event)) {
                this.mCurrentState.enter(NaviAppState.STATE_NORMAL);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void handleMapControlReceive(String requestId, int errorNo, String error) {
        String tts = null;
        String params = (String) this.mMapControlRequestMap.get(requestId);
        int order = -1;
        if (params != null) {
            try {
                order = new JSONObject(params).optInt(NaviCmdConstants.KEY_NAVI_CMD_ORDER, -1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Resources mResources = C2716c.m10141a().getResources();
        switch (order) {
            case 202:
                if (errorNo != 0) {
                    if (errorNo == 4) {
                        tts = error;
                        break;
                    }
                }
                if (Log.isLoggable(C2747a.f9028a, 3)) {
                    tts = mResources.getString(C0965R.string.navi_command_mode_zoom_out);
                } else {
                    tts = mResources.getString(C0965R.string.navi_command_mode_zoom_out_1);
                }
                break;
                break;
            case 203:
                if (errorNo != 0) {
                    if (errorNo == 4) {
                        tts = error;
                        break;
                    }
                }
                if (Log.isLoggable(C2747a.f9028a, 3)) {
                    tts = mResources.getString(C0965R.string.navi_command_mode_zoom_in);
                } else {
                    tts = mResources.getString(C0965R.string.navi_command_mode_zoom_in_1);
                }
                break;
                break;
            case 206:
                if (errorNo != 0) {
                    if (errorNo == 4) {
                        if (Log.isLoggable(C2747a.f9028a, 3)) {
                            tts = mResources.getString(C0965R.string.navi_command_mode_silence_already);
                        } else {
                            tts = mResources.getString(C0965R.string.navi_command_mode_already);
                        }
                        break;
                    }
                }
                if (Log.isLoggable(C2747a.f9028a, 3)) {
                    tts = mResources.getString(C0965R.string.navi_command_mode_silence_echo);
                } else {
                    tts = mResources.getString(C0965R.string.navi_command_mode_normal);
                }
                break;
                break;
            case 207:
                if (errorNo != 0) {
                    if (errorNo == 4) {
                        tts = error;
                        break;
                    }
                }
                if (Log.isLoggable(C2747a.f9028a, 3)) {
                    tts = mResources.getString(C0965R.string.navi_command_mode_traffic_on);
                } else {
                    tts = mResources.getString(C0965R.string.navi_command_mode_traffic_on_1);
                }
                break;
                break;
            case 208:
                if (errorNo != 0) {
                    if (errorNo == 4) {
                        tts = error;
                        break;
                    }
                }
                if (Log.isLoggable(C2747a.f9028a, 3)) {
                    tts = mResources.getString(C0965R.string.navi_command_mode_traffic_off);
                } else {
                    tts = mResources.getString(C0965R.string.navi_command_mode_traffic_off_1);
                }
                break;
                break;
            case 216:
                if (errorNo != 0) {
                    if (errorNo == 4) {
                        tts = mResources.getString(C0965R.string.navi_command_mode_over_view_already);
                        break;
                    }
                }
                if (Log.isLoggable(C2747a.f9028a, 3)) {
                    tts = mResources.getString(C0965R.string.navi_command_mode_over_view);
                } else {
                    tts = mResources.getString(C0965R.string.navi_command_mode_over_view_1);
                }
                break;
                break;
            case 217:
                if (errorNo != 0) {
                    if (errorNo == 4) {
                        tts = mResources.getString(C0965R.string.navi_command_mode_continue_navi_already);
                        break;
                    }
                }
                if (Log.isLoggable(C2747a.f9028a, 3)) {
                    tts = mResources.getString(C0965R.string.navi_command_mode_continue_navi);
                } else {
                    tts = mResources.getString(C0965R.string.navi_command_mode_continue_navi_1);
                }
                break;
                break;
            case 229:
                if (errorNo != 0) {
                    if (errorNo == 4) {
                        if (Log.isLoggable(C2747a.f9028a, 3)) {
                            tts = mResources.getString(C0965R.string.navi_command_mode_north_forward_already);
                        } else {
                            tts = mResources.getString(C0965R.string.navi_command_mode_already);
                        }
                        break;
                    }
                }
                if (Log.isLoggable(C2747a.f9028a, 3)) {
                    tts = mResources.getString(C0965R.string.navi_command_mode_north_forward_echo);
                } else {
                    tts = mResources.getString(C0965R.string.navi_command_mode_normal);
                }
                break;
                break;
            case 230:
                if (errorNo != 0) {
                    if (errorNo == 4) {
                        if (Log.isLoggable(C2747a.f9028a, 3)) {
                            tts = mResources.getString(C0965R.string.navi_command_mode_head_forward_already);
                        } else {
                            tts = mResources.getString(C0965R.string.navi_command_mode_already);
                        }
                        break;
                    }
                }
                if (Log.isLoggable(C2747a.f9028a, 3)) {
                    tts = mResources.getString(C0965R.string.navi_command_mode_head_forward_echo);
                } else {
                    tts = mResources.getString(C0965R.string.navi_command_mode_normal);
                }
                break;
                break;
            case NaviCmdConstants.ACTION_TYPE_NAVI_MODE_NIGHT /*231*/:
                if (errorNo != 0) {
                    if (errorNo == 4) {
                        if (Log.isLoggable(C2747a.f9028a, 3)) {
                            tts = mResources.getString(C0965R.string.navi_command_mode_night_already);
                        } else {
                            tts = mResources.getString(C0965R.string.navi_command_mode_already);
                        }
                        break;
                    }
                }
                if (Log.isLoggable(C2747a.f9028a, 3)) {
                    tts = mResources.getString(C0965R.string.navi_command_mode_night_echo);
                } else {
                    tts = mResources.getString(C0965R.string.navi_command_mode_normal);
                }
                break;
                break;
            case NaviCmdConstants.ACTION_TYPE_NAVI_MODE_DAY /*232*/:
                if (errorNo != 0) {
                    if (errorNo == 4) {
                        if (Log.isLoggable(C2747a.f9028a, 3)) {
                            tts = mResources.getString(C0965R.string.navi_command_mode_day_already);
                        } else {
                            tts = mResources.getString(C0965R.string.navi_command_mode_already);
                        }
                        break;
                    }
                }
                if (Log.isLoggable(C2747a.f9028a, 3)) {
                    tts = mResources.getString(C0965R.string.navi_command_mode_day_echo);
                } else {
                    tts = mResources.getString(C0965R.string.navi_command_mode_normal);
                }
                break;
                break;
            case NaviCmdConstants.ACTION_TYPE_NAVI_TTS_MODE_NEWER /*233*/:
                if (errorNo != 0) {
                    if (errorNo == 4) {
                        if (Log.isLoggable(C2747a.f9028a, 3)) {
                            tts = mResources.getString(C0965R.string.navi_command_mode_newer_already);
                        } else {
                            tts = mResources.getString(C0965R.string.navi_command_mode_already);
                        }
                        break;
                    }
                }
                if (Log.isLoggable(C2747a.f9028a, 3)) {
                    tts = mResources.getString(C0965R.string.navi_command_mode_newer_echo);
                } else {
                    tts = mResources.getString(C0965R.string.navi_command_mode_normal);
                }
                break;
                break;
            case NaviCmdConstants.ACTION_TYPE_NAVI_TTS_MODE_EXPERT /*234*/:
                if (errorNo != 0) {
                    if (errorNo == 4) {
                        if (Log.isLoggable(C2747a.f9028a, 3)) {
                            tts = mResources.getString(C0965R.string.navi_command_mode_expert_already);
                        } else {
                            tts = mResources.getString(C0965R.string.navi_command_mode_already);
                        }
                        break;
                    }
                }
                if (Log.isLoggable(C2747a.f9028a, 3)) {
                    tts = mResources.getString(C0965R.string.navi_command_mode_expert_echo);
                } else {
                    tts = mResources.getString(C0965R.string.navi_command_mode_normal);
                }
                break;
                break;
        }
        C2543d.m9631a().m9633a(tts);
    }

    public void addMapControlRequest(String requestId, String params) {
        this.mMapControlRequestMap.put(requestId, params);
    }

    private void handleDialogShow(String params) {
        this.mCurrentState.notifyShowDialog(params);
    }

    private void handleDialogCancel(String params) {
        this.mCurrentState.notifyCancelDialog(params);
    }

    private void handleDialogResponse(String params) {
        this.mCurrentState.handleDialogResponse(params);
    }

    public void handleNaviAppAddress(String params) {
        try {
            C2725h.m10207b(TAG, "navi address is " + params);
            if (!TextUtils.isEmpty(params)) {
                NaviAddressData mAddress = (NaviAddressData) this.mGson.fromJson(new JSONObject(params).getString("data"), NaviAddressData.class);
                if (mAddress.getType() == null) {
                    return;
                }
                if (TextUtils.isEmpty(mAddress.getName()) || TextUtils.isEmpty(mAddress.getAddress()) || "0".equals(mAddress.getLat()) || "0".equals(mAddress.getLng())) {
                    if (mAddress.getType().equals(NaviCmdConstants.KEY_NAVI_CMD_SET_ADDRESS_COMPANY)) {
                        setCommpanyAddress(null);
                        writeAddress(NaviCmdConstants.KEY_NAVI_CMD_SET_ADDRESS_COMPANY, "");
                    } else if (mAddress.getType().equals("home")) {
                        setHomeAddress(null);
                        writeAddress("home", "");
                    }
                } else if (mAddress.getType().equals(NaviCmdConstants.KEY_NAVI_CMD_SET_ADDRESS_COMPANY)) {
                    setCommpanyAddress(mAddress);
                    writeAddress(NaviCmdConstants.KEY_NAVI_CMD_SET_ADDRESS_COMPANY, params);
                } else if (mAddress.getType().equals("home")) {
                    setHomeAddress(mAddress);
                    writeAddress("home", params);
                }
            }
        } catch (Exception ex) {
            C2725h.m10214e(TAG, "parse address error");
            ex.printStackTrace();
        }
    }

    private void handleNaviLimitSpeed(String params) {
        String tts = params;
        try {
            tts = C2716c.m10141a().getString(C0965R.string.navi_command_mode_limit_speed) + new JSONObject(params).optInt("limsp");
        } catch (Exception ex) {
            ex.printStackTrace();
            tts = C2716c.m10141a().getString(C0965R.string.navi_command_mode_limit_speed_fail);
        }
        C2543d.m9631a().m9633a(tts);
    }

    private void handleNaviSet(String requestId, int errorNo) {
        String params = (String) this.mMapControlRequestMap.get(requestId);
        String order = "";
        if (params != null) {
            try {
                if (!new JSONObject(params).optString(NaviCmdConstants.KEY_NAVI_CMD_ORDER, "").equals("type_reset_navi_bypreference")) {
                    return;
                }
                if (errorNo == 0) {
                    this.mHandler.postDelayed(new C25512(), 1500);
                } else if (errorNo == 4) {
                    C2543d.m9631a().m9633a(C2716c.m10141a().getString(C0965R.string.navi_command_reset_bypreference_fail));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void requestSyncAddress() {
        this.mHandler.post(new C25523());
    }

    public void readAddress() {
        new Thread(new C25534()).start();
    }

    public void writeAddress(final String type, final String params) {
        C2721e.m10184a().execute(new Runnable() {
            public void run() {
                try {
                    if (NaviCmdConstants.KEY_NAVI_CMD_SET_ADDRESS_COMPANY.equals(type)) {
                        C2722f.m10188a(NaviCmdController.COMMPANY_ADDRESS_FILE, params);
                    } else if ("home".equals(type)) {
                        C2722f.m10188a(NaviCmdController.HOME_ADDRESS_FILE, params);
                    }
                } catch (Exception ex) {
                    C2725h.m10207b(NaviCmdController.TAG, "write address to file error");
                    ex.printStackTrace();
                }
            }
        });
    }

    public boolean isSetHomeAddress() {
        return this.mHomeAddress != null;
    }

    public boolean isSetCompanyAddress() {
        return this.mCommpanyAddress != null;
    }

    public void setCommpanyAddress(NaviAddressData mAddress) {
        this.mCommpanyAddress = mAddress;
        NaviParse.getInstance().getNaviCmdData(NaviCmdConstants.KEY_NAVI_START_TASK_COMPANY).setParams(mAddress != null ? NaviCmdData.createParamsPoi(mAddress) : "");
        NaviParse.getInstance().getNaviCmdData(NaviCmdConstants.KEY_NAVI_SET_COMPANY_ADDRESS).setParams(mAddress != null ? NaviCmdData.createParamsAddress(mAddress) : "");
    }

    public void setHomeAddress(NaviAddressData mAddress) {
        this.mHomeAddress = mAddress;
        NaviParse.getInstance().getNaviCmdData(NaviCmdConstants.KEY_NAVI_START_TASK_HOME).setParams(mAddress != null ? NaviCmdData.createParamsPoi(mAddress) : "");
        NaviParse.getInstance().getNaviCmdData(NaviCmdConstants.KEY_NAVI_SET_HOME_ADDRESS).setParams(mAddress != null ? NaviCmdData.createParamsAddress(mAddress) : "");
    }
}
