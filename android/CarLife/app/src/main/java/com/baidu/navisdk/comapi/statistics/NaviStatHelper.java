package com.baidu.navisdk.comapi.statistics;

import android.os.Message;
import com.baidu.carlife.core.C1253f;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.statistics.NaviStatSessionHelper.Session;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.statistic.datacheck.regular.Regular;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class NaviStatHelper {
    public static final String INIT_STAT = "stat.init";
    private static final int LOCAL_CACHE_SIZE = 10;
    public static String NAVI_URL = NAVI_URL_ONLINE;
    public static final String NAVI_URL_ONLINE = (HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/statistics/send");
    private static final String STAT_COMLOG_FILE = "statComLog.txt";
    private static final String STAT_LOG_FILE = "statLog.txt";
    public static final String UPLOAD_SESSION_STAT = "session.stat.upload";
    public static final String UPLOAD_STAT = "stat.upload";
    public static boolean hasCrashInNavi = false;
    private static boolean hasInitStat = false;
    private static Callback mHandlerThreadCallback = new C40721();
    private static int pushNaviStatisticsRet = 0;
    private static List<NameValuePair> sGlobalStatParamsPrefixs = new ArrayList();
    private static ArrayList<NameValuePair> sStatCacheContent;
    private static List<NameValuePair> sStatParamsPrefixs = new ArrayList();
    private static int test10Count = 0;
    private static int testCount = 0;

    /* renamed from: com.baidu.navisdk.comapi.statistics.NaviStatHelper$1 */
    static class C40721 extends Callback {
        C40721() {
        }

        public void careAbouts() {
            careAbout(12);
            careAbout(14);
            careAbout(13);
            careAbout(11);
        }

        public void execute(Message message) {
            Iterator it;
            boolean success;
            switch (message.what) {
                case 11:
                    NaviStatHelper.init();
                    NaviStatSessionHelper.initSession();
                    return;
                case 12:
                    if (message.obj != null && (message.obj instanceof String)) {
                        String statContentStr = message.obj;
                        switch (message.arg1) {
                            case NaviStatConstants.K_NSC_ACTION_POISEARCH /*50001*/:
                            case NaviStatConstants.K_NSC_ACTION_ROUTEPLAN /*50002*/:
                            case NaviStatConstants.K_NSC_ACTION_SETTING /*50006*/:
                            case NaviStatConstants.K_NSC_ACTION_DATAMANAGER /*50007*/:
                            case 50008:
                                NaviStatSessionHelper.pushNaviStatistics(message.arg1, message.arg2, statContentStr);
                                return;
                            case NaviStatConstants.K_NSC_ACTION_FINISHNAVI /*50003*/:
                                if (NaviStatHelper.hasCrashInNavi) {
                                    NaviStatSessionHelper.saveSessionCacheInNaviCrash(statContentStr);
                                    return;
                                } else {
                                    NaviStatSessionHelper.pushNaviStatistics(message.arg1, message.arg2, statContentStr);
                                    return;
                                }
                            default:
                                NaviStatHelper.pushNaviStatistics(statContentStr);
                                return;
                        }
                    }
                    return;
                case 13:
                    if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                        ArrayList<ArrayList<NameValuePair>> outerParams = NaviStatHelper.getOfflineStateListFromLocal();
                        if (outerParams != null && outerParams.size() > 0) {
                            it = outerParams.iterator();
                            while (it.hasNext()) {
                                List param = (ArrayList) it.next();
                                if (param != null && param.size() > 0) {
                                    success = NaviStatHelper.pushNaviStatistics(param);
                                    LogUtil.m15791e("CmdStatisticsUpload", "push Statistics result :" + success);
                                    if (!success) {
                                        NaviStatHelper.writeOfflineStatLogToFile(param);
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 14:
                    if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                        List<Session> outerParamsList = NaviStatSessionHelper.getListSessionFromFile();
                        if (outerParamsList != null && outerParamsList.size() > 0) {
                            for (Session param2 : outerParamsList) {
                                if (param2 != null && param2.size() > 0) {
                                    success = NaviStatSessionHelper.pushNaviSessionStatistics(param2);
                                    LogUtil.m15791e("CmdStatisticsUpload", "push SessionStatistics result :" + success);
                                    if (!success) {
                                        NaviStatSessionHelper.writeOfflineComSessionStatLogToFile(param2);
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.navisdk.comapi.statistics.NaviStatHelper$2 */
    static class C40732 extends BNHttpTextResponseHandler {
        C40732() {
        }

        public void onSuccess(int statusCode, String responseString) {
            LogUtil.m15791e("NaviStatHelper", "onSuccess().statusCode=" + statusCode);
            NaviStatHelper.pushNaviStatisticsRet = statusCode;
        }

        public void onFailure(int statusCode, String responseString, Throwable throwable) {
            LogUtil.m15791e("NaviStatHelper", "onFailure().statusCode=" + statusCode);
            NaviStatHelper.pushNaviStatisticsRet = statusCode;
        }
    }

    public static void initStatParamsPrefix(List<NameValuePair> mStatParamsPrefixs) {
        LogUtil.m15791e("NaviStatHelper", "initStatParamsPrefix start");
        mStatParamsPrefixs.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
        mStatParamsPrefixs.add(new BasicNameValuePair("os", C1253f.jb));
        mStatParamsPrefixs.add(new BasicNameValuePair("ov", PackageUtil.strOSVersion));
        mStatParamsPrefixs.add(new BasicNameValuePair("pcn", PackageUtil.getPackageName()));
        mStatParamsPrefixs.add(new BasicNameValuePair("ch", PackageUtil.getChannel()));
        mStatParamsPrefixs.add(new BasicNameValuePair("mb", PackageUtil.strPhoneType));
        mStatParamsPrefixs.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
        LogUtil.m15791e("NaviStatHelper", "initStatParamsPrefix end " + mStatParamsPrefixs.size());
    }

    public static void initGlobalStatParams(List<NameValuePair> mGlobalStatParamsPrefixs) {
        if (mGlobalStatParamsPrefixs != null) {
            mGlobalStatParamsPrefixs.clear();
            mGlobalStatParamsPrefixs.add(new BasicNameValuePair(Regular.CATEGORY_AREA_VALUE, getCountryArea() + ""));
            mGlobalStatParamsPrefixs.add(new BasicNameValuePair("cityid", getCityId() + ""));
        }
    }

    public static void initNaviStatHelper() {
        CommonHandlerThread.getInstance().registerCallback(mHandlerThreadCallback);
        CommonHandlerThread.getInstance().sendMessage(11, -1, -1, null, 0);
    }

    private static void deleteTxtFile(String txtName) {
        File file = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + txtName);
        if (file != null && file.exists()) {
            file.delete();
        }
    }

    private static void init() {
        if (!hasInitStat) {
            ArrayList<String> statParamList = getOfflineStateFromFile(STAT_LOG_FILE);
            if (statParamList != null && statParamList.size() > 0) {
                int size = statParamList.size();
                LogUtil.m15791e("NaviStatHelper", "statParamList size = " + size);
                sStatCacheContent = new ArrayList();
                for (int i = 0; i < size; i++) {
                    sStatCacheContent.add(new BasicNameValuePair("item" + i, (String) statParamList.get(i)));
                }
            }
            if (sStatCacheContent == null) {
                sStatCacheContent = new ArrayList();
            }
            hasInitStat = true;
        }
    }

    private static File getOfflineStatLogFile(String fileName) {
        File file = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static void writeOfflineStatLogToFile(ArrayList<NameValuePair> param) {
        Exception e;
        Throwable th;
        if (param != null && param.size() > 0) {
            FileOutputStream fos = null;
            try {
                FileOutputStream fos2 = new FileOutputStream(getOfflineStatLogFile(STAT_COMLOG_FILE), true);
                try {
                    String writeStr = "";
                    Iterator it = param.iterator();
                    while (it.hasNext()) {
                        String value = ((NameValuePair) it.next()).getValue();
                        if (!(value == null || "".equals(value))) {
                            writeStr = writeStr + value + "#";
                        }
                    }
                    fos2.write(writeStr.getBytes("utf-8"));
                    fos2.flush();
                    LogUtil.m15791e("NaviStatHelper", "writeOfflineStatLogToFile");
                    if (fos2 != null) {
                        try {
                            fos2.close();
                        } catch (IOException e2) {
                            LogUtil.m15791e("NaviStatHelper", e2.getMessage());
                        }
                        return;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fos = fos2;
                    try {
                        LogUtil.m15791e("NaviStatHelper", e.getMessage());
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e22) {
                                LogUtil.m15791e("NaviStatHelper", e22.getMessage());
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e222) {
                                LogUtil.m15791e("NaviStatHelper", e222.getMessage());
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
                LogUtil.m15791e("NaviStatHelper", e.getMessage());
                if (fos != null) {
                    fos.close();
                }
            }
        }
    }

    public static ArrayList<ArrayList<NameValuePair>> getOfflineStateListFromLocal() {
        ArrayList<ArrayList<NameValuePair>> outerParams = new ArrayList();
        ArrayList<String> suffixParamList = getOfflineStateFromFile(STAT_COMLOG_FILE);
        if (suffixParamList != null && suffixParamList.size() > 0) {
            int size = suffixParamList.size();
            LogUtil.m15791e("NaviStatHelper", "suffixParamList size = " + size);
            ArrayList<NameValuePair> innerParams = new ArrayList();
            int cnt = 0;
            int i = 0;
            while (cnt < size) {
                innerParams.add(new BasicNameValuePair("item" + i, (String) suffixParamList.get(cnt)));
                i++;
                if (i == 10 || cnt + 1 == size) {
                    outerParams.add(new ArrayList(innerParams));
                    innerParams.clear();
                    i = 0;
                }
                cnt++;
            }
            deleteTxtFile(STAT_COMLOG_FILE);
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.m15791e("NaviStatHelper", "local list size " + outerParams.size());
            Iterator it = outerParams.iterator();
            while (it.hasNext()) {
                LogUtil.m15791e("NaviStatHelper", "local list " + ((ArrayList) it.next()).toString());
            }
        }
        return outerParams;
    }

    private static ArrayList<String> getOfflineStateFromFile(String fileName) {
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        ArrayList<String> statList = new ArrayList();
        File file = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + fileName);
        if (!file.exists()) {
            return null;
        }
        BufferedReader input = null;
        try {
            BufferedReader input2 = new BufferedReader(new FileReader(file));
            try {
                String str = "";
                while (true) {
                    str = input2.readLine();
                    if (str != null && str != null && !str.equals("")) {
                        String[] destString = str.split("#");
                        int i = 0;
                        while (i < destString.length) {
                            if (!(destString[i] == null || "".equals(destString[i]))) {
                                statList.add(destString[i]);
                            }
                            i++;
                        }
                    } else if (input2 == null) {
                        try {
                            input2.close();
                        } catch (IOException e3) {
                            LogUtil.m15791e("NaviStatHelper", e3.getMessage());
                        }
                        return statList;
                    } else {
                        return statList;
                    }
                }
                if (input2 == null) {
                    return statList;
                }
                input2.close();
                return statList;
            } catch (FileNotFoundException e4) {
                e2 = e4;
                input = input2;
            } catch (IOException e5) {
                e3 = e5;
                input = input2;
            } catch (Throwable th2) {
                th = th2;
                input = input2;
            }
        } catch (FileNotFoundException e6) {
            e2 = e6;
            try {
                LogUtil.m15791e("NaviStatHelper", e2.getMessage());
                if (input == null) {
                    return statList;
                }
                try {
                    input.close();
                } catch (IOException e32) {
                    LogUtil.m15791e("NaviStatHelper", e32.getMessage());
                }
                return statList;
            } catch (Throwable th3) {
                th = th3;
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e322) {
                        LogUtil.m15791e("NaviStatHelper", e322.getMessage());
                    }
                }
                throw th;
            }
        } catch (IOException e7) {
            e322 = e7;
            LogUtil.m15791e("NaviStatHelper", e322.getMessage());
            if (input == null) {
                return statList;
            }
            try {
                input.close();
            } catch (IOException e3222) {
                LogUtil.m15791e("NaviStatHelper", e3222.getMessage());
            }
            return statList;
        }
    }

    public static void pushNaviStatistics(String statContent) {
        if (!hasInitStat) {
            init();
        }
        statisticsTest(statContent, "test1_1.txt");
        List cache = new ArrayList();
        int size = sStatCacheContent.size();
        sStatCacheContent.add(new BasicNameValuePair("item" + size, statContent));
        writeSynSessionStatLogToFile(statContent);
        LogUtil.m15791e("NaviStatHelper", "push Statistics item" + size + ": " + statContent);
        if (sStatCacheContent.size() >= 10) {
            cache.addAll(new ArrayList(sStatCacheContent));
            sStatCacheContent.clear();
        }
        if (cache.size() > 0) {
            deleteTxtFile(STAT_LOG_FILE);
            if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                boolean success = pushNaviStatistics(cache);
                LogUtil.m15791e("NaviStatHelper", "Send Statistics result : " + success);
                if (!success) {
                    writeOfflineStatLogToFile(cache);
                    return;
                }
                return;
            }
            writeOfflineStatLogToFile(cache);
        }
    }

    public static boolean pushNaviStatistics(List<NameValuePair> paramsSuffix) {
        if (paramsSuffix == null || paramsSuffix.size() == 0) {
            LogUtil.m15791e("NaviStatHelper", "push params is null");
            return false;
        }
        pushNaviStatisticsRet = 0;
        NAVI_URL = NAVI_URL_ONLINE;
        List<NameValuePair> params = new ArrayList();
        if (sStatParamsPrefixs.isEmpty()) {
            initStatParamsPrefix(sStatParamsPrefixs);
            sStatParamsPrefixs.add(new BasicNameValuePair("isSession", "0"));
        }
        initGlobalStatParams(sGlobalStatParamsPrefixs);
        if (sGlobalStatParamsPrefixs != null) {
            params.addAll(sGlobalStatParamsPrefixs);
        }
        params.addAll(sStatParamsPrefixs);
        params.addAll(paramsSuffix);
        BNHttpParams httpParams = new BNHttpParams();
        httpParams.isAsync = false;
        BNHttpCenter.getInstance().post(NAVI_URL, BNHttpCenterHelper.formatParams(params), new C40732(), httpParams);
        if ((pushNaviStatisticsRet == 200 || pushNaviStatisticsRet == -1) && LogUtil.LOGGABLE) {
            for (NameValuePair pair : params) {
                LogUtil.m15791e("NaviStatHelper", "push pair name = " + pair.getName() + " value = " + pair.getValue());
            }
        }
        if (pushNaviStatisticsRet == 200 || pushNaviStatisticsRet == -1) {
            statisticsTest(paramsSuffix);
        }
        if (pushNaviStatisticsRet == 200 || pushNaviStatisticsRet == -1) {
            return true;
        }
        return false;
    }

    public static void writeCacheToFile() {
    }

    private static void writeSynSessionStatLogToFile(String statContentStr) {
        Exception e;
        Throwable th;
        if (statContentStr != null) {
            File file = getOfflineStatLogFile(STAT_LOG_FILE);
            FileOutputStream fos = null;
            if (file != null) {
                try {
                    FileOutputStream fos2 = new FileOutputStream(file, true);
                    try {
                        statContentStr = statContentStr + "#";
                        fos2.write(statContentStr.getBytes("utf-8"));
                        fos2.flush();
                        LogUtil.m15791e("NaviStatSessionHelper", "writeSynSessionStatLogToFile():" + statContentStr);
                        if (fos2 != null) {
                            try {
                                fos2.close();
                            } catch (IOException e2) {
                                LogUtil.m15791e("NaviStatSessionHelper", e2.getMessage());
                            }
                            return;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fos = fos2;
                        try {
                            LogUtil.m15791e("NaviStatSessionHelper", e.getMessage());
                            if (fos != null) {
                                try {
                                    fos.close();
                                } catch (IOException e22) {
                                    LogUtil.m15791e("NaviStatSessionHelper", e22.getMessage());
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fos != null) {
                                try {
                                    fos.close();
                                } catch (IOException e222) {
                                    LogUtil.m15791e("NaviStatSessionHelper", e222.getMessage());
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
                    LogUtil.m15791e("NaviStatSessionHelper", e.getMessage());
                    if (fos != null) {
                        fos.close();
                    }
                }
            }
        }
    }

    private static void statisticsTest(String str, String fileName) {
        if (LogUtil.LOGGABLE) {
            File file = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + fileName);
        }
    }

    private static void statisticsTest(List<NameValuePair> list) {
        if (!LogUtil.LOGGABLE) {
        }
    }

    private static int getCountryArea() {
        RoutePlanModel routePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
        if (routePlanModel == null || routePlanModel.getEnNaviType() == 0) {
            return 0;
        }
        return 1;
    }

    private static int getCityId() {
        return BNaviModuleManager.getOutChinaCurrentCityId();
    }
}
