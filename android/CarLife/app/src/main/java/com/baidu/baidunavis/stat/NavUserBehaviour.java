package com.baidu.baidunavis.stat;

import android.app.Fragment;
import android.os.SystemClock;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavCommonFuncController;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.model.NavGeoPoint;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.baidunavis.stat.NavUserBehaviourDef.NavUserBehaviourNaviAction;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.statistic.NaviStatItem;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.platform.comapi.p209e.C4770a;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.tencent.qplayauto.device.QPlayAutoJNI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.http.message.BasicNameValuePair;

public class NavUserBehaviour {
    public static final String APP_KEY = "e9d85b3e5a";
    private static final String Simple_Log_File_Name = "navi_simple.log";
    private static final String TAG = NavUserBehaviour.class.getSimpleName();
    private static volatile NavUserBehaviour mInstance = null;
    private static boolean mIsNeedSendNaviStartMTJLog = false;
    private static boolean sIsInitialized = false;
    private int headNaviStatisticsRet = 0;
    private boolean mIsPropertiesSettingOK = false;
    private ArrayList<String> mOfflineStatInfoList = null;
    private Properties mSimpleLogProperties = new Properties();

    /* renamed from: com.baidu.baidunavis.stat.NavUserBehaviour$2 */
    class C08662 extends BNHttpTextResponseHandler {
        C08662() {
        }

        public void onFailure(int statusCode, String responseString, Throwable throwable) {
            NavUserBehaviour.this.headNaviStatisticsRet = statusCode;
        }

        public void onSuccess(int statusCode, String responseString) {
            NavUserBehaviour.this.headNaviStatisticsRet = statusCode;
        }
    }

    private NavUserBehaviour() {
    }

    public static NavUserBehaviour getInstance() {
        if (mInstance == null) {
            synchronized (NavUserBehaviour.class) {
                if (mInstance == null) {
                    try {
                        mInstance = new NavUserBehaviour();
                        NavLogUtils.m3003e(TAG, "mtj inited:");
                        if (LogUtil.LOGGABLE) {
                            mInstance.loadSimpleLog();
                        }
                        sIsInitialized = true;
                        if (mInstance != null && NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()) && mInstance.isExistOfflineStatLogFile()) {
                            mInstance.uploadOfflineStatLog();
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        }
        return mInstance;
    }

    public static void destory() {
        if (mInstance != null) {
            synchronized (NavUserBehaviour.class) {
                if (mInstance != null) {
                    mInstance.dispose();
                }
            }
        }
        mInstance = null;
        sIsInitialized = false;
    }

    public static boolean isInitialized() {
        return sIsInitialized;
    }

    public static void setIsNeedSendNaviStartMTJLog(boolean isNeed) {
        mIsNeedSendNaviStartMTJLog = isNeed;
    }

    private void dispose() {
        if (LogUtil.LOGGABLE) {
            storeSimpleLog();
        }
    }

    private String getFragmentName(Fragment fragment) {
        try {
            String name = getClass().getName();
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Throwable th) {
            return "";
        }
    }

    public void sendBehaviourLog(String behaviour) {
        com.baidu.baidunavis.wrapper.LogUtil.m3004e(TAG, "MTJ behaviour:" + behaviour);
    }

    public void sendUserdataCollect(String behaviour) {
        com.baidu.baidunavis.wrapper.LogUtil.m3004e(TAG, "UserdataCollect behaviour:" + behaviour);
        C4770a.a().a(NaviStatConstants.K_NSC_KEY_MODE_TYPE, "nav");
        C4770a.a().a(behaviour);
    }

    public void sendNaviStatistics(RouteNode startNode, RouteNode endNode, String naviAction, String naviNet, String naviEnter) {
        try {
            final RouteNode routeNode = startNode;
            final RouteNode routeNode2 = endNode;
            final String str = naviAction;
            final String str2 = naviNet;
            final String str3 = naviEnter;
            BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("sendNaviStatistics", null) {
                protected String execute() {
                    try {
                        String sn = NavUserBehaviour.this.getPoint(routeNode);
                        String en = NavUserBehaviour.this.getPoint(routeNode2);
                        String sc = NavUserBehaviour.this.getCityId(routeNode);
                        String ec = NavUserBehaviour.this.getCityId(routeNode2);
                        NavUserBehaviour.this.onEventWithParam(sn, en, sc, ec, str, str2, str3);
                        boolean isSendSuccess = false;
                        int cntReConnect = 3;
                        while (cntReConnect > 0) {
                            if (NavUserBehaviour.this.headNaviStatistics(sn, en, sc, ec, str, str2, str3) == 200) {
                                isSendSuccess = true;
                                com.baidu.baidunavis.wrapper.LogUtil.m3004e(TAG, "NETWORK_NORMAL,Send Statistics Success! ");
                                break;
                            }
                            cntReConnect--;
                            if (cntReConnect > 0) {
                                com.baidu.baidunavis.wrapper.LogUtil.m3004e(TAG, "NETWORK ERROR, try again! ");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                }
                            }
                        }
                        if (!isSendSuccess) {
                            if ("navi".equals(str)) {
                                NavUserBehaviour.this.sendUserdataCollect(NavUserBehaviourDef.LOG_NAVI_TO);
                            } else if (NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_EDOG.equals(str)) {
                                NavUserBehaviour.this.sendUserdataCollect(NavUserBehaviourDef.LOG_E_DOG);
                            } else if (NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_YAW.equals(str)) {
                                NavUserBehaviour.this.sendUserdataCollect(NavUserBehaviourDef.LOG_YAW);
                            } else if (NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_RPLAN.equals(str)) {
                                NavUserBehaviour.this.sendUserdataCollect(NavUserBehaviourDef.LOG_ROUTE_PLAN);
                            } else if ("download".equals(str)) {
                                NavUserBehaviour.this.sendUserdataCollect(NavUserBehaviourDef.LOG_DOWNLAOD);
                            } else if (NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_SET.equals(str)) {
                                NavUserBehaviour.this.sendUserdataCollect(NavUserBehaviourDef.LOG_SETTINGS);
                            }
                            NavUserBehaviour.this.writeDataOfflineStatLogToFile(sn + " " + en + " " + sc + " " + ec + " " + str + " " + str2 + " " + str3);
                        }
                    } catch (Exception e2) {
                    }
                    return null;
                }
            }, new BNWorkerConfig(102, 0));
        } catch (Throwable th) {
        }
    }

    public void sendNaviStatisticsTransfer(RoutePlanNode startRoutePlanNode, RoutePlanNode endRoutePlanNode, String naviAction, String naviNet, String naviEnter) {
        if (startRoutePlanNode != null && endRoutePlanNode != null) {
            RouteNode mStartNode = new RouteNode();
            RouteNode mEndNode = new RouteNode();
            mStartNode.mCityID = startRoutePlanNode.mDistrictID;
            mEndNode.mCityID = endRoutePlanNode.mDistrictID;
            mStartNode.mGeoPoint = new NavGeoPoint(startRoutePlanNode.getLongitudeE6(), startRoutePlanNode.getLatitudeE6());
            mEndNode.mGeoPoint = new NavGeoPoint(endRoutePlanNode.getLongitudeE6(), endRoutePlanNode.getLatitudeE6());
            sendNaviStatistics(mStartNode, mEndNode, naviAction, naviNet, naviEnter);
        }
    }

    private int headNaviStatistics(String sn, String en, String sc, String ec, String naviAction, String naviNet, String naviEnter) {
        SysOSAPIv2 sysOSAPIv2 = SysOSAPIv2.getInstance();
        String mb = sysOSAPIv2.getPhoneType();
        String os = sysOSAPIv2.getOSVersion();
        String sv = sysOSAPIv2.getVersionName();
        String cuid = sysOSAPIv2.getCuid();
        String channel = SysOSAPIv2.getInstance().getChannel();
        this.headNaviStatisticsRet = 0;
        try {
            String url = NavUserBehaviourDef.NAVI_URL + "&mode=" + URLEncoder.encode(NavUserBehaviourDef.NAVI_MODE_TYPE, "UTF-8") + "&da_src=" + URLEncoder.encode(naviEnter, "UTF-8") + "&mb=" + URLEncoder.encode(mb, "UTF-8") + "&os=" + URLEncoder.encode(os, "UTF-8") + "&sv=" + URLEncoder.encode(sv, "UTF-8") + "&cuid=" + URLEncoder.encode(cuid, "UTF-8") + "&channel=" + URLEncoder.encode(channel, "UTF-8") + "&ctm=" + URLEncoder.encode(String.valueOf(System.currentTimeMillis()), "UTF-8") + "&navi_city=" + URLEncoder.encode(String.valueOf(NavCommonFuncController.getInstance().getLocationCityId()), "UTF-8") + "&sn=" + URLEncoder.encode(sn, "UTF-8") + "&en=" + URLEncoder.encode(en, "UTF-8") + "&sc=" + URLEncoder.encode(sc, "UTF-8") + "&ec=" + URLEncoder.encode(ec, "UTF-8") + "&nav_act=" + URLEncoder.encode(naviAction, "UTF-8") + "&nav_net=" + URLEncoder.encode(naviNet, "UTF-8") + "&nav_enter=" + URLEncoder.encode(naviEnter, "UTF-8");
            com.baidu.baidunavis.wrapper.LogUtil.m3004e(TAG, "URL:" + url);
            BNHttpParams httpParams = new BNHttpParams();
            httpParams.isAsync = false;
            BNHttpCenter.getInstance().get(url, null, new C08662(), httpParams);
            com.baidu.baidunavis.wrapper.LogUtil.m3004e(TAG, url + " HttpHead 服务器返回状态:" + this.headNaviStatisticsRet);
        } catch (Throwable th) {
        }
        return this.headNaviStatisticsRet;
    }

    private String getPoint(RouteNode node) {
        String tmp = "-1,-1";
        if (node == null || node.mGeoPoint == null) {
            return tmp;
        }
        return String.valueOf(node.mGeoPoint.getLongitudeE6()) + "," + String.valueOf(node.mGeoPoint.getLatitudeE6());
    }

    private String getCityId(RouteNode node) {
        String tmp = QPlayAutoJNI.SONG_LIST_ROOT_ID;
        if (node == null) {
            return tmp;
        }
        if (node.mCityID != -1) {
            return String.valueOf(node.mCityID);
        }
        if (node.mCityID != -1 || node.mProvinceID == -1) {
            return tmp;
        }
        return String.valueOf(node.mProvinceID);
    }

    private boolean makesureSimpleLogFileExists() {
        boolean z = false;
        String outputDir = SysOSAPIv2.getInstance().getOutputCache();
        if (outputDir == null || outputDir.length() <= 0) {
            return z;
        }
        File f = new File(outputDir + File.separator + Simple_Log_File_Name);
        if (f.exists()) {
            return true;
        }
        try {
            return f.createNewFile();
        } catch (IOException e) {
            return z;
        }
    }

    private void loadSimpleLog() {
        Throwable th;
        if (makesureSimpleLogFileExists()) {
            String outputDir = SysOSAPIv2.getInstance().getOutputCache();
            if (outputDir != null && outputDir.length() > 0) {
                FileInputStream fis = null;
                try {
                    FileInputStream fis2 = new FileInputStream(outputDir + File.separator + Simple_Log_File_Name);
                    try {
                        this.mSimpleLogProperties.load(fis2);
                        this.mIsPropertiesSettingOK = true;
                        if (fis2 != null) {
                            try {
                                fis2.close();
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        }
                        return;
                    } catch (Exception e2) {
                        fis = fis2;
                        if (fis != null) {
                            try {
                                fis.close();
                                return;
                            } catch (IOException e3) {
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        fis = fis2;
                        if (fis != null) {
                            try {
                                fis.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    if (fis != null) {
                        fis.close();
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    if (fis != null) {
                        fis.close();
                    }
                    throw th;
                }
            }
            return;
        }
        this.mIsPropertiesSettingOK = false;
    }

    private void updateSimpleLogCount(String key) {
        if (this.mIsPropertiesSettingOK) {
            try {
                this.mSimpleLogProperties.setProperty(key, "" + (Integer.parseInt(this.mSimpleLogProperties.getProperty(key, "0")) + 1));
            } catch (Exception e) {
            }
        }
    }

    private void storeSimpleLog() {
        Throwable th;
        if (this.mIsPropertiesSettingOK) {
            String outputDir = SysOSAPIv2.getInstance().getOutputCache();
            if (outputDir != null && outputDir.length() > 0) {
                FileOutputStream fos = null;
                try {
                    FileOutputStream fos2 = new FileOutputStream(outputDir + File.separator + Simple_Log_File_Name);
                    try {
                        this.mSimpleLogProperties.store(fos2, "Navi_Simple_Log");
                        fos2.flush();
                        if (fos2 != null) {
                            try {
                                fos2.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (Exception e2) {
                        fos = fos2;
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e3) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fos = fos2;
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fos != null) {
                        fos.close();
                    }
                    throw th;
                }
            }
        }
    }

    private void onEventWithParam(String sn, String en, String sc, String ec, String naviAction, String naviNet, String naviEnter) {
        ArrayList mStatPairList = new ArrayList();
        mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_SN, sn));
        mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_EN, en));
        mStatPairList.add(new BasicNameValuePair("sc", sc));
        mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_EC, ec));
        mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_NAV_ACT, naviAction));
        mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_NAV_NET, naviNet));
        mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_NAV_ENTER, naviEnter));
        mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_MODE_TYPE, NavUserBehaviourDef.NAVI_MODE_TYPE));
        mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_DA_SRC, naviEnter));
        mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_CUR_TIME, String.valueOf(System.currentTimeMillis())));
        mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_NAVI_CITY, String.valueOf(NavCommonFuncController.getInstance().getLocationCityId())));
        int eventId = 0;
        if ("navi".equals(naviAction)) {
            eventId = NaviStatConstants.K_NSC_ACTION_BEHAVIOUR_NAVI;
        } else if (NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_EDOG.equals(naviAction)) {
            eventId = NaviStatConstants.K_NSC_ACTION_BEHAVIOUR_EDOG;
        } else if (NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_YAW.equals(naviAction)) {
            eventId = NaviStatConstants.K_NSC_ACTION_BEHAVIOUR_YAW;
        } else if (NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_RPLAN.equals(naviAction)) {
            eventId = NaviStatConstants.K_NSC_ACTION_BEHAVIOUR_RPLAN;
        } else if ("download".equals(naviAction)) {
            eventId = NaviStatConstants.K_NSC_ACTION_BEHAVIOUR_DOWNLOAD;
        } else if (NavUserBehaviourNaviAction.BEHAVIOUR_NAVI_ACTION_SET.equals(naviAction)) {
            eventId = NaviStatConstants.K_NSC_ACTION_BEHAVIOUR_SET;
        }
        com.baidu.baidunavis.wrapper.LogUtil.m3004e(TAG, "NavUserBehaviour,onEventWithParam  naviAction " + naviAction + " eventId " + eventId + " naviNet " + naviNet + " naviEnter " + naviEnter);
        BNStatisticsManager.getInstance().onEventWithParam(eventId, null, mStatPairList);
    }

    private File getDataOfflineStatLogFile() {
        return new File(NavMapAdapter.getInstance().getDataPath() + "/bnav/offlineStatLog.txt");
    }

    private void writeDataOfflineStatLogToFile(String logStr) {
        Exception e;
        Throwable th;
        FileOutputStream fos = null;
        try {
            FileOutputStream fos2 = new FileOutputStream(getDataOfflineStatLogFile(), true);
            try {
                fos2.write(logStr.getBytes("utf-8"));
                fos2.write(System.getProperty("line.separator").getBytes());
                fos2.flush();
                if (fos2 != null) {
                    try {
                        fos2.close();
                    } catch (IOException e2) {
                        com.baidu.baidunavis.wrapper.LogUtil.m3004e("navSDK", e2.getMessage());
                    }
                    return;
                }
            } catch (Exception e3) {
                e = e3;
                fos = fos2;
                try {
                    com.baidu.baidunavis.wrapper.LogUtil.m3004e("navSDK", e.getMessage());
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e22) {
                            com.baidu.baidunavis.wrapper.LogUtil.m3004e("navSDK", e22.getMessage());
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e222) {
                            com.baidu.baidunavis.wrapper.LogUtil.m3004e("navSDK", e222.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fos = fos2;
                if (fos != null) {
                    fos.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            com.baidu.baidunavis.wrapper.LogUtil.m3004e("navSDK", e.getMessage());
            if (fos != null) {
                fos.close();
            }
        }
    }

    private void cleanOfflineStatLog() {
        Exception e;
        Throwable th;
        FileOutputStream fos = null;
        try {
            FileOutputStream fos2 = new FileOutputStream(getDataOfflineStatLogFile(), false);
            try {
                fos2.write("".getBytes("utf-8"));
                fos2.flush();
                if (fos2 != null) {
                    try {
                        fos2.close();
                    } catch (IOException e2) {
                        com.baidu.baidunavis.wrapper.LogUtil.m3004e("navSDK", e2.getMessage());
                    }
                    return;
                }
            } catch (Exception e3) {
                e = e3;
                fos = fos2;
                try {
                    com.baidu.baidunavis.wrapper.LogUtil.m3004e("navSDK", e.getMessage());
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e22) {
                            com.baidu.baidunavis.wrapper.LogUtil.m3004e("navSDK", e22.getMessage());
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e222) {
                            com.baidu.baidunavis.wrapper.LogUtil.m3004e("navSDK", e222.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fos = fos2;
                if (fos != null) {
                    fos.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            com.baidu.baidunavis.wrapper.LogUtil.m3004e("navSDK", e.getMessage());
            if (fos != null) {
                fos.close();
            }
        }
    }

    private boolean isExistOfflineStatLogFile() {
        return getDataOfflineStatLogFile().exists();
    }

    private void uploadOfflineStatLog() {
        BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-uploadOfflineStatLog", null) {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected java.lang.String execute() {
                /*
                r20 = this;
                r0 = r20;
                r2 = com.baidu.baidunavis.stat.NavUserBehaviour.this;	 Catch:{ Exception -> 0x0051 }
                r2 = r2.mOfflineStatInfoList;	 Catch:{ Exception -> 0x0051 }
                if (r2 != 0) goto L_0x0016;
            L_0x000a:
                r0 = r20;
                r2 = com.baidu.baidunavis.stat.NavUserBehaviour.this;	 Catch:{ Exception -> 0x0051 }
                r3 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0051 }
                r3.<init>();	 Catch:{ Exception -> 0x0051 }
                r2.mOfflineStatInfoList = r3;	 Catch:{ Exception -> 0x0051 }
            L_0x0016:
                r0 = r20;
                r2 = com.baidu.baidunavis.stat.NavUserBehaviour.this;	 Catch:{ Exception -> 0x0051 }
                r13 = r2.getDataOfflineStatLogFile();	 Catch:{ Exception -> 0x0051 }
                r14 = 0;
                r15 = new java.io.BufferedReader;	 Catch:{ FileNotFoundException -> 0x016a, IOException -> 0x009f }
                r2 = new java.io.FileReader;	 Catch:{ FileNotFoundException -> 0x016a, IOException -> 0x009f }
                r2.<init>(r13);	 Catch:{ FileNotFoundException -> 0x016a, IOException -> 0x009f }
                r15.<init>(r2);	 Catch:{ FileNotFoundException -> 0x016a, IOException -> 0x009f }
                r19 = "";
            L_0x002c:
                r19 = r15.readLine();	 Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0166, all -> 0x0162 }
                if (r19 == 0) goto L_0x0080;
            L_0x0032:
                r2 = "";
                r0 = r19;
                r2 = r2.equals(r0);	 Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0166, all -> 0x0162 }
                if (r2 == 0) goto L_0x0054;
            L_0x003d:
                r2 = 0;
                if (r15 == 0) goto L_0x0170;
            L_0x0040:
                r15.close();	 Catch:{ IOException -> 0x0045 }
            L_0x0043:
                r14 = 0;
            L_0x0044:
                return r2;
            L_0x0045:
                r11 = move-exception;
                r3 = "navSDK";
                r4 = r11.getMessage();	 Catch:{ Exception -> 0x0051 }
                com.baidu.baidunavis.wrapper.LogUtil.m3004e(r3, r4);	 Catch:{ Exception -> 0x0051 }
                goto L_0x0043;
            L_0x0051:
                r2 = move-exception;
            L_0x0052:
                r2 = 0;
                goto L_0x0044;
            L_0x0054:
                r0 = r20;
                r2 = com.baidu.baidunavis.stat.NavUserBehaviour.this;	 Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0166, all -> 0x0162 }
                r2 = r2.mOfflineStatInfoList;	 Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0166, all -> 0x0162 }
                r0 = r19;
                r2.add(r0);	 Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0166, all -> 0x0162 }
                goto L_0x002c;
            L_0x0062:
                r11 = move-exception;
                r14 = r15;
            L_0x0064:
                r2 = "navSDK";
                r3 = r11.getMessage();	 Catch:{ all -> 0x00bd }
                com.baidu.baidunavis.wrapper.LogUtil.m3004e(r2, r3);	 Catch:{ all -> 0x00bd }
                if (r14 == 0) goto L_0x0074;
            L_0x0070:
                r14.close();	 Catch:{ IOException -> 0x0093 }
            L_0x0073:
                r14 = 0;
            L_0x0074:
                r0 = r20;
                r2 = com.baidu.baidunavis.stat.NavUserBehaviour.this;	 Catch:{ Exception -> 0x0051 }
                r2 = r2.mOfflineStatInfoList;	 Catch:{ Exception -> 0x0051 }
                if (r2 != 0) goto L_0x00d1;
            L_0x007e:
                r2 = 0;
                goto L_0x0044;
            L_0x0080:
                if (r15 == 0) goto L_0x016d;
            L_0x0082:
                r15.close();	 Catch:{ IOException -> 0x0087 }
            L_0x0085:
                r14 = 0;
                goto L_0x0074;
            L_0x0087:
                r11 = move-exception;
                r2 = "navSDK";
                r3 = r11.getMessage();	 Catch:{ Exception -> 0x0051 }
                com.baidu.baidunavis.wrapper.LogUtil.m3004e(r2, r3);	 Catch:{ Exception -> 0x0051 }
                goto L_0x0085;
            L_0x0093:
                r11 = move-exception;
                r2 = "navSDK";
                r3 = r11.getMessage();	 Catch:{ Exception -> 0x0051 }
                com.baidu.baidunavis.wrapper.LogUtil.m3004e(r2, r3);	 Catch:{ Exception -> 0x0051 }
                goto L_0x0073;
            L_0x009f:
                r11 = move-exception;
            L_0x00a0:
                r2 = "navSDK";
                r3 = r11.getMessage();	 Catch:{ all -> 0x00bd }
                com.baidu.baidunavis.wrapper.LogUtil.m3004e(r2, r3);	 Catch:{ all -> 0x00bd }
                if (r14 == 0) goto L_0x0074;
            L_0x00ac:
                r14.close();	 Catch:{ IOException -> 0x00b1 }
            L_0x00af:
                r14 = 0;
                goto L_0x0074;
            L_0x00b1:
                r11 = move-exception;
                r2 = "navSDK";
                r3 = r11.getMessage();	 Catch:{ Exception -> 0x0051 }
                com.baidu.baidunavis.wrapper.LogUtil.m3004e(r2, r3);	 Catch:{ Exception -> 0x0051 }
                goto L_0x00af;
            L_0x00bd:
                r2 = move-exception;
            L_0x00be:
                if (r14 == 0) goto L_0x00c4;
            L_0x00c0:
                r14.close();	 Catch:{ IOException -> 0x00c5 }
            L_0x00c3:
                r14 = 0;
            L_0x00c4:
                throw r2;	 Catch:{ Exception -> 0x0051 }
            L_0x00c5:
                r11 = move-exception;
                r3 = "navSDK";
                r4 = r11.getMessage();	 Catch:{ Exception -> 0x0051 }
                com.baidu.baidunavis.wrapper.LogUtil.m3004e(r3, r4);	 Catch:{ Exception -> 0x0051 }
                goto L_0x00c3;
            L_0x00d1:
                r0 = r20;
                r2 = com.baidu.baidunavis.stat.NavUserBehaviour.this;	 Catch:{ Exception -> 0x0051 }
                r2.cleanOfflineStatLog();	 Catch:{ Exception -> 0x0051 }
                r12 = 0;
            L_0x00d9:
                r0 = r20;
                r2 = com.baidu.baidunavis.stat.NavUserBehaviour.this;	 Catch:{ Exception -> 0x0051 }
                r2 = r2.mOfflineStatInfoList;	 Catch:{ Exception -> 0x0051 }
                r2 = r2.size();	 Catch:{ Exception -> 0x0051 }
                if (r12 >= r2) goto L_0x0052;
            L_0x00e7:
                r0 = r20;
                r2 = com.baidu.baidunavis.stat.NavUserBehaviour.this;	 Catch:{ Exception -> 0x0051 }
                r2 = r2.mOfflineStatInfoList;	 Catch:{ Exception -> 0x0051 }
                r2 = r2.get(r12);	 Catch:{ Exception -> 0x0051 }
                r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0051 }
                r3 = " ";
                r17 = r2.split(r3);	 Catch:{ Exception -> 0x0051 }
                r0 = r17;
                r2 = r0.length;	 Catch:{ Exception -> 0x0051 }
                r3 = 7;
                if (r2 != r3) goto L_0x014b;
            L_0x0102:
                r16 = 0;
                r10 = 3;
            L_0x0105:
                if (r10 <= 0) goto L_0x0134;
            L_0x0107:
                r0 = r20;
                r2 = com.baidu.baidunavis.stat.NavUserBehaviour.this;	 Catch:{ Exception -> 0x0051 }
                r3 = 0;
                r3 = r17[r3];	 Catch:{ Exception -> 0x0051 }
                r4 = 1;
                r4 = r17[r4];	 Catch:{ Exception -> 0x0051 }
                r5 = 2;
                r5 = r17[r5];	 Catch:{ Exception -> 0x0051 }
                r6 = 3;
                r6 = r17[r6];	 Catch:{ Exception -> 0x0051 }
                r7 = 4;
                r7 = r17[r7];	 Catch:{ Exception -> 0x0051 }
                r8 = 5;
                r8 = r17[r8];	 Catch:{ Exception -> 0x0051 }
                r9 = 6;
                r9 = r17[r9];	 Catch:{ Exception -> 0x0051 }
                r18 = r2.headNaviStatistics(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0051 }
                r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
                r0 = r18;
                if (r0 != r2) goto L_0x014e;
            L_0x012a:
                r16 = 1;
                r2 = TAG;	 Catch:{ Exception -> 0x0051 }
                r3 = "NETWORK_NORMAL,Send Statistics Success! ";
                com.baidu.baidunavis.wrapper.LogUtil.m3004e(r2, r3);	 Catch:{ Exception -> 0x0051 }
            L_0x0134:
                if (r16 != 0) goto L_0x014b;
            L_0x0136:
                r0 = r20;
                r3 = com.baidu.baidunavis.stat.NavUserBehaviour.this;	 Catch:{ Exception -> 0x0051 }
                r0 = r20;
                r2 = com.baidu.baidunavis.stat.NavUserBehaviour.this;	 Catch:{ Exception -> 0x0051 }
                r2 = r2.mOfflineStatInfoList;	 Catch:{ Exception -> 0x0051 }
                r2 = r2.get(r12);	 Catch:{ Exception -> 0x0051 }
                r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0051 }
                r3.writeDataOfflineStatLogToFile(r2);	 Catch:{ Exception -> 0x0051 }
            L_0x014b:
                r12 = r12 + 1;
                goto L_0x00d9;
            L_0x014e:
                r10 = r10 + -1;
                if (r10 <= 0) goto L_0x0105;
            L_0x0152:
                r2 = TAG;	 Catch:{ Exception -> 0x0051 }
                r3 = "NETWORK ERROR, try again! ";
                com.baidu.baidunavis.wrapper.LogUtil.m3004e(r2, r3);	 Catch:{ Exception -> 0x0051 }
                r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
                java.lang.Thread.sleep(r2);	 Catch:{ InterruptedException -> 0x0160 }
                goto L_0x0105;
            L_0x0160:
                r2 = move-exception;
                goto L_0x0105;
            L_0x0162:
                r2 = move-exception;
                r14 = r15;
                goto L_0x00be;
            L_0x0166:
                r11 = move-exception;
                r14 = r15;
                goto L_0x00a0;
            L_0x016a:
                r11 = move-exception;
                goto L_0x0064;
            L_0x016d:
                r14 = r15;
                goto L_0x0074;
            L_0x0170:
                r14 = r15;
                goto L_0x0044;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.baidunavis.stat.NavUserBehaviour.3.execute():java.lang.String");
            }
        }, new BNWorkerConfig(102, 0));
    }

    public void statNaviIntentTime() {
        try {
            NaviStatItem.getInstance().setNaviIntentTime(SystemClock.elapsedRealtime());
        } catch (Throwable th) {
        }
    }

    public void statNaviIntentTime2() {
        try {
            NaviStatItem.getInstance().init();
            NaviStatItem.getInstance().setNaviIntentTime2(SystemClock.elapsedRealtime());
        } catch (Throwable th) {
        }
    }

    public void resetNaviStatItem() {
        try {
            NaviStatItem.getInstance().init();
        } catch (Throwable th) {
        }
    }
}
