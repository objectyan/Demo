package com.baidu.navisdk.comapi.statistics;

import com.baidu.mobstat.Config;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class NaviStatSessionHelper {
    private static final String DOCUMENTS_TEST_FILE = "testLog";
    private static final String JSONKEY_TM = "\"tm\":";
    private static final int MAX_SESSION_SIZE = 6144;
    private static final String STAT_COMSESSION_LOG_FILE = "statComSessionLog.txt";
    private static final String STAT_SESSION_LOG_FILE = "statSessionLog.txt";
    private static final String TEST_STAT_LOG_FILE = "testLogFile";
    private static final Long TIME_OUT = Long.valueOf(21600);
    private static boolean hasTestIninted = false;
    private static Session mSession = null;
    private static int maxSessionSize = 8192;
    private static long preActionTime = -1;
    private static int preEventID = -1;
    private static int pushNaviSessionStatisticsRet = 0;
    private static List<NameValuePair> sGlobalStatParamsPrefixs = new ArrayList();
    private static ArrayList<String> sStatCacheContent = new ArrayList();
    private static List<NameValuePair> sStatParamsPrefixs = new ArrayList();
    private static int testCount = 0;
    private static int testSessionCount = 0;
    private static String testSessionFileName = null;
    private long preIDTime = 0;

    /* renamed from: com.baidu.navisdk.comapi.statistics.NaviStatSessionHelper$1 */
    static class C40741 extends BNHttpTextResponseHandler {
        C40741() {
        }

        public void onSuccess(int statusCode, String responseString) {
            LogUtil.m15791e("NaviStatSessionHelper", "onSuccess().statusCode=" + statusCode);
            NaviStatSessionHelper.pushNaviSessionStatisticsRet = statusCode;
        }

        public void onFailure(int statusCode, String responseString, Throwable throwable) {
            LogUtil.m15791e("NaviStatSessionHelper", "onFailure().statusCode=" + statusCode);
            NaviStatSessionHelper.pushNaviSessionStatisticsRet = statusCode;
        }
    }

    public static class Session {
        private ArrayList<NameValuePair> sStatCacheContent;

        private Session() {
            this.sStatCacheContent = null;
            this.sStatCacheContent = new ArrayList();
        }

        private Session copy() {
            if (this.sStatCacheContent == null) {
                this.sStatCacheContent = new ArrayList();
            }
            Session mSession = new Session();
            mSession.sStatCacheContent.addAll(this.sStatCacheContent);
            return mSession;
        }

        private void clear() {
            if (this.sStatCacheContent == null) {
                this.sStatCacheContent = new ArrayList();
            }
            this.sStatCacheContent.clear();
        }

        private void add(NameValuePair mNameValuePair) {
            if (this.sStatCacheContent == null) {
                this.sStatCacheContent = new ArrayList();
            }
            this.sStatCacheContent.add(mNameValuePair);
        }

        private void add(String strItem) {
            if (this.sStatCacheContent == null) {
                this.sStatCacheContent = new ArrayList();
            }
            this.sStatCacheContent.add(new BasicNameValuePair("item" + size(), strItem));
        }

        public int size() {
            if (this.sStatCacheContent != null) {
                return this.sStatCacheContent.size();
            }
            this.sStatCacheContent = new ArrayList();
            return 0;
        }

        private ArrayList<NameValuePair> getSStatCacheContent() {
            return this.sStatCacheContent;
        }
    }

    private static File getOfflineSessionStatLogFile(String txtName) {
        File file = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + txtName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    private static void clearTxtFile(String txtName) {
        Exception e;
        Throwable th;
        File file = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + txtName);
        if (file != null && file.exists()) {
            FileOutputStream fos = null;
            try {
                FileOutputStream fos2 = new FileOutputStream(file, false);
                try {
                    fos2.write("".getBytes());
                    fos2.flush();
                    if (fos2 != null) {
                        try {
                            fos2.close();
                        } catch (IOException e2) {
                            LogUtil.m15791e("NaviStatSessionHelper", e2.getMessage());
                        }
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

    public static void pushNaviStatistics(int eventID, int actionTime, String statisticsString) {
        if (mSession == null) {
            mSession = new Session();
        }
        Session cachSession = null;
        statisticsTest(statisticsString);
        boolean ret = false;
        int size = mSession.size();
        if (eventID != NaviStatConstants.K_NSC_ACTION_FINISHNAVI && needUploadAtOnce()) {
            cachSession = mSession.copy();
            mSession.clear();
            uploadAComSession(cachSession);
            cachSession = null;
        }
        if (eventID == NaviStatConstants.K_NSC_ACTION_FINISHNAVI) {
            cachSession = mSession.copy();
            cachSession.add(new BasicNameValuePair("item" + size, statisticsString));
            mSession.clear();
            ret = true;
        } else if (preEventID != -1 && ((preEventID == NaviStatConstants.K_NSC_ACTION_ROUTEPLAN || preEventID == NaviStatConstants.K_NSC_ACTION_POISEARCH) && preActionTime != -1 && ((long) actionTime) - preActionTime >= TIME_OUT.longValue())) {
            cachSession = mSession.copy();
            mSession.clear();
            mSession.add(new BasicNameValuePair("item" + size, statisticsString));
            writeSynSessionStatLogToFile(statisticsString);
            ret = true;
        }
        if (!ret) {
            mSession.add(new BasicNameValuePair("item" + size, statisticsString));
            writeSynSessionStatLogToFile(statisticsString);
        }
        preActionTime = (long) actionTime;
        preEventID = eventID;
        uploadAComSession(cachSession);
    }

    private static void uploadAComSession(Session cachSession) {
        if (cachSession != null) {
            clearTxtFile(STAT_SESSION_LOG_FILE);
            if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
                boolean success = pushNaviSessionStatistics(cachSession);
                LogUtil.m15791e("NaviStatHelper", "Send Statistics result : " + success);
                if (!success) {
                    writeOfflineComSessionStatLogToFile(cachSession);
                    return;
                }
                return;
            }
            writeOfflineComSessionStatLogToFile(cachSession);
        }
    }

    public static void saveSessionCacheInNaviCrash(String statisticsString) {
        if (mSession != null) {
            int size = mSession.size();
            Session cachSession = mSession.copy();
            cachSession.add(new BasicNameValuePair("item" + size, statisticsString));
            mSession.clear();
            clearTxtFile(STAT_SESSION_LOG_FILE);
            writeOfflineComSessionStatLogToFile(cachSession);
        }
    }

    public static void initSession() {
        preActionTime = System.currentTimeMillis() / 1000;
        mSession = getOfflineStateFromSessionFile();
        if (mSession == null) {
            mSession = new Session();
        }
    }

    private static Session getOfflineStateFromSessionFile() {
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        File file = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + STAT_SESSION_LOG_FILE);
        if (!file.exists()) {
            return null;
        }
        BufferedReader input = null;
        Session sSession = new Session();
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
                                sSession.add(destString[i]);
                                if (i == destString.length - 1) {
                                    preActionTime = getEventTimeFromFile(destString[i]);
                                }
                            }
                            i++;
                        }
                    } else if (input2 == null) {
                        try {
                            input2.close();
                        } catch (IOException e3) {
                            LogUtil.m15791e("NaviStatSessionHelper", e3.getMessage());
                        }
                        return sSession;
                    } else {
                        return sSession;
                    }
                }
                if (input2 == null) {
                    return sSession;
                }
                input2.close();
                return sSession;
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
                LogUtil.m15791e("NaviStatSessionHelper", e2.getMessage());
                if (input == null) {
                    return sSession;
                }
                try {
                    input.close();
                } catch (IOException e32) {
                    LogUtil.m15791e("NaviStatSessionHelper", e32.getMessage());
                }
                return sSession;
            } catch (Throwable th3) {
                th = th3;
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e322) {
                        LogUtil.m15791e("NaviStatSessionHelper", e322.getMessage());
                    }
                }
                throw th;
            }
        } catch (IOException e7) {
            e322 = e7;
            LogUtil.m15791e("NaviStatSessionHelper", e322.getMessage());
            if (input == null) {
                return sSession;
            }
            try {
                input.close();
            } catch (IOException e3222) {
                LogUtil.m15791e("NaviStatSessionHelper", e3222.getMessage());
            }
            return sSession;
        }
    }

    public static List<Session> getListSessionFromFile() {
        return getOfflineStateFromComSessionFile();
    }

    private static List<Session> getOfflineStateFromComSessionFile() {
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        List<Session> statList = new LinkedList();
        File file = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + STAT_COMSESSION_LOG_FILE);
        if (!file.exists()) {
            return null;
        }
        BufferedReader input = null;
        try {
            BufferedReader input2 = new BufferedReader(new FileReader(file));
            try {
                Session sSession;
                String str = "";
                Session sSession2 = null;
                while (true) {
                    try {
                        str = input2.readLine();
                        if (str != null && str != null && !str.equals("")) {
                            String[] destString = str.split("#");
                            sSession = new Session();
                            int i = 0;
                            while (i < destString.length) {
                                if (!(destString[i] == null || "".equals(destString[i]))) {
                                    sSession.add(destString[i]);
                                }
                                i++;
                            }
                            statList.add(sSession);
                            sSession2 = sSession;
                        } else if (input2 == null) {
                            try {
                                input2.close();
                            } catch (IOException e3) {
                                LogUtil.m15791e("NaviStatSessionHelper", e3.getMessage());
                            }
                            sSession = sSession2;
                        } else {
                            input = input2;
                        }
                    } catch (FileNotFoundException e4) {
                        e2 = e4;
                        sSession = sSession2;
                        input = input2;
                    } catch (IOException e5) {
                        e3 = e5;
                        sSession = sSession2;
                        input = input2;
                    } catch (Throwable th2) {
                        th = th2;
                        sSession = sSession2;
                        input = input2;
                    }
                }
                if (input2 == null) {
                    input = input2;
                } else {
                    input2.close();
                    sSession = sSession2;
                }
            } catch (FileNotFoundException e6) {
                e2 = e6;
                input = input2;
            } catch (IOException e7) {
                e3 = e7;
                input = input2;
            } catch (Throwable th3) {
                th = th3;
                input = input2;
            }
        } catch (FileNotFoundException e8) {
            e2 = e8;
            try {
                LogUtil.m15791e("NaviStatSessionHelper", e2.getMessage());
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e32) {
                        LogUtil.m15791e("NaviStatSessionHelper", e32.getMessage());
                    }
                }
                clearTxtFile(STAT_COMSESSION_LOG_FILE);
                return statList;
            } catch (Throwable th4) {
                th = th4;
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e322) {
                        LogUtil.m15791e("NaviStatSessionHelper", e322.getMessage());
                    }
                }
                throw th;
            }
        } catch (IOException e9) {
            e322 = e9;
            LogUtil.m15791e("NaviStatSessionHelper", e322.getMessage());
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e3222) {
                    LogUtil.m15791e("NaviStatSessionHelper", e3222.getMessage());
                }
            }
            clearTxtFile(STAT_COMSESSION_LOG_FILE);
            return statList;
        }
        clearTxtFile(STAT_COMSESSION_LOG_FILE);
        return statList;
    }

    private static long getEventTimeFromFile(String str) {
        try {
            int index = str.indexOf("tm\":");
            if (index >= 0) {
                str = str.substring("tm\":".length() + index);
            }
            return Long.parseLong(str.substring(0, str.indexOf(",")));
        } catch (Exception e) {
            return -1;
        }
    }

    private static void writeSynSessionStatLogToFile(String statContentStr) {
        Exception e;
        Throwable th;
        if (statContentStr != null) {
            File file = getOfflineSessionStatLogFile(STAT_SESSION_LOG_FILE);
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

    private static void writeOfflineSessionStatLogToFile(Session sSession) {
        Exception e;
        Throwable th;
        if (sSession != null && sSession.size() > 0) {
            ArrayList<NameValuePair> sStatCacheContent = sSession.getSStatCacheContent();
            FileOutputStream fos = null;
            File file = getOfflineSessionStatLogFile(STAT_SESSION_LOG_FILE);
            if (file != null) {
                try {
                    FileOutputStream fos2 = new FileOutputStream(file, false);
                    try {
                        String writeStr = "";
                        Iterator it = sStatCacheContent.iterator();
                        while (it.hasNext()) {
                            String value = ((NameValuePair) it.next()).getValue();
                            if (!(value == null || "".equals(value))) {
                                writeStr = writeStr + value + "#";
                            }
                        }
                        fos2.write(writeStr.getBytes("utf-8"));
                        fos2.flush();
                        LogUtil.m15791e("NaviStatSessionHelper", "writeOfflineSessionStatLogToFile()");
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

    public static void writeOfflineComSessionStatLogToFile(Session sSession) {
        Exception e;
        Throwable th;
        if (sSession != null && sSession.size() > 0) {
            ArrayList<NameValuePair> sStatCacheContent = sSession.getSStatCacheContent();
            FileOutputStream fos = null;
            File file = getOfflineSessionStatLogFile(STAT_COMSESSION_LOG_FILE);
            if (file != null) {
                try {
                    FileOutputStream fos2 = new FileOutputStream(file, true);
                    try {
                        String writeStr = "";
                        String newLine = System.getProperty("line.separator");
                        Iterator it = sStatCacheContent.iterator();
                        while (it.hasNext()) {
                            String value = ((NameValuePair) it.next()).getValue();
                            if (!(value == null || "".equals(value))) {
                                writeStr = writeStr + value + "#";
                            }
                        }
                        fos2.write(writeStr.getBytes("utf-8"));
                        fos2.write(newLine.getBytes());
                        fos2.flush();
                        LogUtil.m15791e("NaviStatSessionHelper", "writeOfflineSessionStatLogToFile()");
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

    public static boolean pushNaviSessionStatistics(Session paramsSession) {
        if (paramsSession == null || paramsSession.size() == 0) {
            LogUtil.m15791e("NaviStatSessionHelper", "push params is null");
            return false;
        }
        pushNaviSessionStatisticsRet = 0;
        NaviStatHelper.NAVI_URL = NaviStatHelper.NAVI_URL_ONLINE;
        List<NameValuePair> params = new ArrayList();
        if (sStatParamsPrefixs.isEmpty()) {
            NaviStatHelper.initStatParamsPrefix(sStatParamsPrefixs);
            sStatParamsPrefixs.add(new BasicNameValuePair("isSession", "1"));
        }
        NaviStatHelper.initGlobalStatParams(sGlobalStatParamsPrefixs);
        if (sGlobalStatParamsPrefixs != null) {
            params.addAll(sGlobalStatParamsPrefixs);
        }
        params.addAll(sStatParamsPrefixs);
        params.addAll(paramsSession.getSStatCacheContent());
        BNHttpParams httpParams = new BNHttpParams();
        httpParams.isAsync = false;
        BNHttpCenter.getInstance().post(NaviStatHelper.NAVI_URL, BNHttpCenterHelper.formatParams(params), new C40741(), httpParams);
        if ((pushNaviSessionStatisticsRet == 200 || pushNaviSessionStatisticsRet == -1) && LogUtil.LOGGABLE) {
            for (NameValuePair pair : params) {
                LogUtil.m15791e("NaviStatHelper", "push pair name = " + pair.getName() + " value = " + pair.getValue());
            }
        }
        if (pushNaviSessionStatisticsRet == 200 || pushNaviSessionStatisticsRet == -1) {
            statisticsSessionTest(paramsSession, null);
        } else {
            statisticsSessionTest(paramsSession, Integer.valueOf(pushNaviSessionStatisticsRet));
        }
        if (pushNaviSessionStatisticsRet == 200 || pushNaviSessionStatisticsRet == -1) {
            return true;
        }
        return false;
    }

    public static void writeCacheToFile() {
    }

    private static void statisticsTest(String str) {
        if (!LogUtil.LOGGABLE) {
        }
    }

    private static void statisticsSessionTest(Session mSession, Integer ret) {
        Exception e;
        Throwable th;
        if (LogUtil.LOGGABLE) {
            if (!hasTestIninted) {
                testSessionInit();
                hasTestIninted = true;
            }
            File file = getTestSessionFile();
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fos = new FileOutputStream(file, true);
                try {
                    String newLine = System.getProperty("line.separator");
                    Iterator it = mSession.getSStatCacheContent().iterator();
                    while (it.hasNext()) {
                        NameValuePair mNameValuePair = (NameValuePair) it.next();
                        if (ret != null) {
                            fos.write((ParamKey.KEY_MSG_ERRORS + ret + Config.TRACE_TODAY_VISIT_SPLIT).getBytes("utf-8"));
                        }
                        fos.write((testSessionCount + Config.TRACE_TODAY_VISIT_SPLIT + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + Config.TRACE_TODAY_VISIT_SPLIT + mNameValuePair.getValue()).getBytes("utf-8"));
                        fos.write(newLine.getBytes());
                    }
                    fos.flush();
                    LogUtil.m15791e("NaviStatHelper", "statisticsTest");
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e22) {
                            LogUtil.m15791e("NaviStatHelper", e22.getMessage());
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fos;
                    try {
                        LogUtil.m15791e("NaviStatHelper_statisticsTest", e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e222) {
                                LogUtil.m15791e("NaviStatHelper", e222.getMessage());
                            }
                        }
                        testSessionCount++;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2222) {
                                LogUtil.m15791e("NaviStatHelper", e2222.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fos;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                LogUtil.m15791e("NaviStatHelper_statisticsTest", e.getMessage());
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                testSessionCount++;
            }
            testSessionCount++;
        }
    }

    private static boolean needUploadAtOnce() {
        long curTime = System.currentTimeMillis() / 1000;
        if (curTime - preActionTime >= TIME_OUT.longValue()) {
            preActionTime = curTime;
            return true;
        }
        preActionTime = curTime;
        return false;
    }

    private static void testSessionInit() {
        long currentTime = Long.parseLong(new SimpleDateFormat("yyyyMMdd").format(new Date()) + "");
        File file = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + DOCUMENTS_TEST_FILE);
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isDirectory()) {
            File[] fileArr = file.listFiles();
            if (fileArr != null && fileArr.length > 0) {
                for (File mFile : fileArr) {
                    if (needDelete(mFile.getName(), currentTime)) {
                        mFile.delete();
                    }
                }
            }
        }
        File mFile2 = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + DOCUMENTS_TEST_FILE + "/" + currentTime + TEST_STAT_LOG_FILE);
        if (!mFile2.exists()) {
            try {
                mFile2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean needDelete(String fileName, long currentTime) {
        try {
            if (fileName.length() > 7 && currentTime - Long.parseLong(fileName.substring(0, 7)) <= 100) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    private static File getTestSessionFile() {
        if (testSessionFileName == null) {
            testSessionFileName = Long.parseLong(new SimpleDateFormat("yyyyMMdd").format(new Date()) + "") + TEST_STAT_LOG_FILE;
        }
        File mFile = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + DOCUMENTS_TEST_FILE + "/" + testSessionFileName);
        if (!mFile.exists()) {
            try {
                mFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mFile;
    }
}
