package com.baidu.navisdk.util.statistic.userop;

import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.statistic.GuideStatItem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class UserOPController {
    private static final String CACHE_FILE_NAME = "navi_ops_cache";
    private static final char[] PAGE_PREFIX = new char[]{'2', '3', '4', '5', '6'};
    public static final String TAG = "UserOP";
    private static UserOPController sInstance = null;
    private long mBaseTime = -1;
    private Map<String, UserOP> mCacheOpMap = new HashMap();
    private Callback mHandlerThreadCB = new C47311();
    private String mLastContinuousOP = null;
    private int mLastContinuousOPCount = 0;
    private int mLastMapGestureCount = 0;
    private int mLastMapGestureEvent = -1;
    private long mLastOPTime = -1;
    private int mOPCount = 0;
    private StringBuffer mOPs = new StringBuffer();
    private String mPageParam = "0";
    private String sessionId = null;

    /* renamed from: com.baidu.navisdk.util.statistic.userop.UserOPController$1 */
    class C47311 extends Callback {
        C47311() {
        }

        public void execute(Message message) {
            switch (message.what) {
                case 1:
                    UserOPController.this.performLoadCacheOPs();
                    return;
                case 2:
                    UserOPController.this.performClearCacheOPs();
                    return;
                case 3:
                    UserOPController.this.performCacheOPs();
                    return;
                default:
                    return;
            }
        }

        public void careAbouts() {
            careAbout(1);
            careAbout(3);
            careAbout(2);
        }

        public String getName() {
            return UserOPController.TAG;
        }
    }

    private UserOPController() {
        CommonHandlerThread.getInstance().registerCallback(this.mHandlerThreadCB);
        loadCacheOPs(0);
    }

    public static UserOPController getInstance() {
        if (sInstance == null) {
            synchronized (UserOPController.class) {
                if (sInstance == null) {
                    sInstance = new UserOPController();
                }
            }
        }
        return sInstance;
    }

    public boolean end() {
        ArrayList<NameValuePair> statPairList = new ArrayList();
        statPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_LJ, this.mOPs.toString()));
        statPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, addEscapeSeqToSsid(this.sessionId)));
        GuideStatItem.getInstance().end();
        String guideStatStr = GuideStatItem.getInstance().getGuideStatString();
        if (guideStatStr != null) {
            statPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_RG, guideStatStr));
        }
        new UserOPDataCheckItem(statPairList).check();
        BNStatisticsManager.getInstance().onEventWithParam(50008, null, statPairList);
        if (BNSettingManager.isShowJavaLog()) {
            SDKDebugFileUtil.get(SDKDebugFileUtil.USEROP_FILENAME).add(this.mOPs.toString());
        }
        this.mBaseTime = -1;
        this.mLastOPTime = -1;
        this.mPageParam = "0";
        this.mOPs = new StringBuffer();
        this.mOPCount = 0;
        clearCacheOPs();
        return false;
    }

    public void add(String op) {
        add(op, null, null, null);
    }

    public void add(String op, String paramA, String paramB, String paramC) {
        if (op != null && op.length() != 0) {
            long timeValue;
            if (paramA != null) {
                if (paramA.trim().equals(Config.APP_VERSION_CODE)) {
                    paramA = "";
                } else if (paramA.trim().equals("b")) {
                    paramA = null;
                    paramB = "";
                } else if (paramA.trim().equals("c")) {
                    paramA = null;
                    paramB = null;
                    paramC = "";
                }
            }
            checkEnd();
            checkAddMapOPInner();
            checkAddContinuousOPInner();
            if (this.mBaseTime <= 0) {
                this.mBaseTime = SystemClock.elapsedRealtime();
                timeValue = System.currentTimeMillis() / 1000;
            } else {
                timeValue = ((SystemClock.elapsedRealtime() - this.mBaseTime) / 1000) + 1;
            }
            StringBuffer sb = new StringBuffer();
            sb.append(op);
            sb.append("-");
            sb.append(String.valueOf(timeValue));
            boolean isFirstParam = true;
            if (!(paramA == null && paramB == null && paramC == null)) {
                if (paramA != null) {
                    sb.append("-");
                    sb.append(Config.APP_VERSION_CODE);
                    if (paramA.length() > 0) {
                        sb.append(paramA);
                    }
                    isFirstParam = false;
                }
                if (paramB != null) {
                    sb.append(isFirstParam ? "-" : "|");
                    sb.append("b");
                    if (paramB.length() > 0) {
                        sb.append(paramB);
                    }
                    isFirstParam = false;
                }
                if (paramC != null) {
                    sb.append(isFirstParam ? "-" : "|");
                    sb.append("c");
                    if (paramC.length() > 0) {
                        sb.append(paramC);
                    }
                    isFirstParam = false;
                }
            }
            if (isNeedUpdatePageParam(op)) {
                this.mPageParam = op.substring(0, 1);
                LogUtil.m15791e(TAG, "mPageParam=" + this.mPageParam);
            } else if ('1' == op.charAt(0)) {
                sb.append(isFirstParam ? "-" : "|");
                sb.append("p");
                if (this.mPageParam != null) {
                    sb.append(this.mPageParam);
                }
            }
            this.mLastOPTime = SystemClock.elapsedRealtime();
            this.mOPCount++;
            LogUtil.m15791e(TAG, "add() ops=" + sb.toString());
            if (this.mOPs.length() > 0) {
                this.mOPs.append(Config.TRACE_TODAY_VISIT_SPLIT);
            }
            this.mOPs.append(sb.toString());
            cacheOPs();
        }
    }

    private boolean isNeedUpdatePageParam(String op) {
        if (op == null || op.length() == 0) {
            return false;
        }
        char tar = op.charAt(0);
        for (char item : PAGE_PREFIX) {
            if (item == tar) {
                return true;
            }
        }
        return false;
    }

    private void checkEnd() {
        if (this.mOPCount > 100 || (this.mLastOPTime > 0 && SystemClock.elapsedRealtime() - this.mLastOPTime > 21600000)) {
            LogUtil.m15791e(TAG, "checkEnd() end");
            end();
        }
    }

    public void checkQuitForExceptionInNaviMode() {
        if (BNSettingManager.getQuitForExceptionInNaviMode()) {
            add(UserOPParams.COMMON_1_k);
            BNSettingManager.setQuitForExceptionInNaviMode(false);
        }
    }

    private void clearCacheOPs() {
        CommonHandlerThread.getInstance().removeMessage(3);
        CommonHandlerThread.getInstance().removeMessage(2);
        CommonHandlerThread.getInstance().sendMessage(2, 0, 0, null, 0);
    }

    private void loadCacheOPs(long ms) {
        CommonHandlerThread.getInstance().removeMessage(1);
        CommonHandlerThread.getInstance().sendMessage(1, 0, 0, null, ms);
    }

    private void cacheOPs() {
        CommonHandlerThread.getInstance().removeMessage(3);
        CommonHandlerThread.getInstance().sendMessage(3, 0, 0, null, Config.BPLUS_DELAY_TIME);
    }

    private void cacheOPs(boolean cacheNoDelay) {
        if (cacheNoDelay) {
            CommonHandlerThread.getInstance().removeMessage(3);
            CommonHandlerThread.getInstance().sendMessage(3, 0, 0, null, 0);
            return;
        }
        cacheOPs();
    }

    private void performClearCacheOPs() {
        Exception exception;
        Throwable th;
        LogUtil.m15791e(TAG, "performClearCacheOPs()");
        BufferedWriter bWriter = null;
        try {
            if (SysOSAPI.getInstance().getSecondCachePath() == null || SysOSAPI.getInstance().getSecondCachePath().length() <= 0) {
                if (bWriter != null) {
                    try {
                        bWriter.close();
                    } catch (Exception exception2) {
                        if (LogUtil.LOGGABLE) {
                            exception2.printStackTrace();
                        }
                    }
                }
                return;
            }
            File cFile = new File(SysOSAPI.getInstance().getSecondCachePath(), CACHE_FILE_NAME);
            if (cFile != null && cFile.exists()) {
                BufferedWriter bWriter2 = new BufferedWriter(new FileWriter(cFile));
                try {
                    bWriter2.write("");
                    bWriter2.flush();
                    bWriter = bWriter2;
                } catch (Exception e) {
                    exception = e;
                    bWriter = bWriter2;
                    try {
                        if (LogUtil.LOGGABLE) {
                            exception.printStackTrace();
                        }
                        if (bWriter != null) {
                            try {
                                bWriter.close();
                            } catch (Exception exception22) {
                                if (LogUtil.LOGGABLE) {
                                    exception22.printStackTrace();
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bWriter != null) {
                            try {
                                bWriter.close();
                            } catch (Exception exception222) {
                                if (LogUtil.LOGGABLE) {
                                    exception222.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bWriter = bWriter2;
                    if (bWriter != null) {
                        bWriter.close();
                    }
                    throw th;
                }
            }
            if (bWriter != null) {
                try {
                    bWriter.close();
                } catch (Exception exception2222) {
                    if (LogUtil.LOGGABLE) {
                        exception2222.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            exception = e2;
            if (LogUtil.LOGGABLE) {
                exception.printStackTrace();
            }
            if (bWriter != null) {
                bWriter.close();
            }
        }
    }

    private void performLoadCacheOPs() {
        Exception exception;
        Throwable th;
        LogUtil.m15791e(TAG, "performLoadCacheOPs()");
        if (BNaviModuleManager.getContext() == null) {
            loadCacheOPs(1000);
            return;
        }
        BufferedReader bReader = null;
        try {
            if (SysOSAPI.getInstance().getSecondCachePath() != null && SysOSAPI.getInstance().getSecondCachePath().length() > 0) {
                File cFile = new File(SysOSAPI.getInstance().getSecondCachePath(), CACHE_FILE_NAME);
                if (cFile != null && cFile.exists()) {
                    BufferedReader bReader2 = new BufferedReader(new FileReader(cFile));
                    String cacheOPs = null;
                    String mSsid = null;
                    int lineCount = 0;
                    while (true) {
                        try {
                            String str = bReader2.readLine();
                            if (str == null) {
                                break;
                            }
                            if (lineCount != 0) {
                                if (lineCount != 1) {
                                    break;
                                }
                                mSsid = str;
                            } else {
                                cacheOPs = str;
                            }
                            lineCount++;
                        } catch (Exception e) {
                            exception = e;
                            bReader = bReader2;
                        } catch (Throwable th2) {
                            th = th2;
                            bReader = bReader2;
                        }
                    }
                    if (cacheOPs != null && cacheOPs.length() > 0) {
                        String tmp = "";
                        if (BNSettingManager.getQuitForExceptionInNaviMode()) {
                            tmp = tmp + ":1.k-0";
                            BNSettingManager.setQuitForExceptionInNaviMode(false);
                        }
                        tmp = tmp + ":1.j-0";
                        if (LogUtil.LOGGABLE) {
                            LogUtil.m15791e(TAG, "performLoadCacheOPs() loadOP=" + cacheOPs + tmp);
                        }
                        ArrayList<NameValuePair> statPairList = new ArrayList();
                        statPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_LJ, cacheOPs + tmp));
                        statPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_FINISHNAVI_SSID, addEscapeSeqToSsid(mSsid)));
                        new UserOPDataCheckItem(statPairList).check();
                        BNStatisticsManager.getInstance().onEventWithParam(50008, null, statPairList);
                        if (BNSettingManager.isShowJavaLog()) {
                            SDKDebugFileUtil.get(SDKDebugFileUtil.USEROP_FILENAME).add(mSsid + "," + cacheOPs + tmp);
                        }
                    }
                    bReader = bReader2;
                }
                if (bReader != null) {
                    try {
                        bReader.close();
                    } catch (Exception exception2) {
                        if (LogUtil.LOGGABLE) {
                            exception2.printStackTrace();
                        }
                    }
                }
            } else if (bReader != null) {
                try {
                    bReader.close();
                } catch (Exception exception22) {
                    if (LogUtil.LOGGABLE) {
                        exception22.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            exception = e2;
            try {
                if (LogUtil.LOGGABLE) {
                    exception.printStackTrace();
                }
                if (bReader != null) {
                    try {
                        bReader.close();
                    } catch (Exception exception222) {
                        if (LogUtil.LOGGABLE) {
                            exception222.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (bReader != null) {
                    try {
                        bReader.close();
                    } catch (Exception exception2222) {
                        if (LogUtil.LOGGABLE) {
                            exception2222.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        }
    }

    private void performCacheOPs() {
        Exception exception;
        Throwable th;
        LogUtil.m15791e(TAG, "performCacheOPs()");
        BufferedWriter bWriter = null;
        try {
            if (SysOSAPI.getInstance().getSecondCachePath() == null || SysOSAPI.getInstance().getSecondCachePath().length() <= 0) {
                if (bWriter != null) {
                    try {
                        bWriter.close();
                    } catch (Exception exception2) {
                        if (LogUtil.LOGGABLE) {
                            exception2.printStackTrace();
                        }
                    }
                }
                return;
            }
            File cFile = new File(SysOSAPI.getInstance().getSecondCachePath(), CACHE_FILE_NAME);
            if (!(cFile == null || cFile.exists() || cFile.createNewFile())) {
                cFile = null;
            }
            if (cFile != null) {
                BufferedWriter bWriter2 = new BufferedWriter(new FileWriter(cFile));
                try {
                    bWriter2.write(this.mOPs.toString());
                    String newLine = System.getProperty("line.separator");
                    if (!TextUtils.isEmpty(this.sessionId)) {
                        bWriter2.write(newLine);
                        bWriter2.write(this.sessionId);
                    }
                    bWriter2.flush();
                    if (LogUtil.LOGGABLE) {
                        LogUtil.m15791e(TAG, "performCacheOPs() cacheOP=" + this.mOPs.toString());
                    }
                    bWriter = bWriter2;
                } catch (Exception e) {
                    exception = e;
                    bWriter = bWriter2;
                    try {
                        if (LogUtil.LOGGABLE) {
                            exception.printStackTrace();
                        }
                        if (bWriter != null) {
                            try {
                                bWriter.close();
                            } catch (Exception exception22) {
                                if (LogUtil.LOGGABLE) {
                                    exception22.printStackTrace();
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bWriter != null) {
                            try {
                                bWriter.close();
                            } catch (Exception exception222) {
                                if (LogUtil.LOGGABLE) {
                                    exception222.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bWriter = bWriter2;
                    if (bWriter != null) {
                        bWriter.close();
                    }
                    throw th;
                }
            }
            if (bWriter != null) {
                try {
                    bWriter.close();
                } catch (Exception exception2222) {
                    if (LogUtil.LOGGABLE) {
                        exception2222.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            exception = e2;
            if (LogUtil.LOGGABLE) {
                exception.printStackTrace();
            }
            if (bWriter != null) {
                bWriter.close();
            }
        }
    }

    public void addMapOP(int type, int event) {
        if (!careAboutMapEvent(type, event)) {
            return;
        }
        if (520 != this.mLastMapGestureEvent || 513 != event) {
            if (519 == event) {
                event = 518;
            }
            if (520 != this.mLastMapGestureEvent || 518 != event) {
                if ((521 == this.mLastMapGestureEvent && 518 == event) || 2 != type) {
                    return;
                }
                if (event == this.mLastMapGestureEvent) {
                    this.mLastMapGestureCount++;
                    return;
                }
                addMapOPInner(type, this.mLastMapGestureEvent, this.mLastMapGestureCount);
                this.mLastMapGestureEvent = event;
                this.mLastMapGestureCount = 1;
            }
        }
    }

    private boolean careAboutMapEvent(int type, int event) {
        if (type == 2) {
            switch (event) {
                case 513:
                case 514:
                case 516:
                case 517:
                case 518:
                case 519:
                case 520:
                case 521:
                    return true;
            }
        }
        return false;
    }

    private void checkAddMapOPInner() {
        if (-1 != this.mLastMapGestureEvent) {
            addMapOPInner(2, this.mLastMapGestureEvent, this.mLastMapGestureCount);
            this.mLastMapGestureEvent = -1;
            this.mLastMapGestureCount = 0;
        }
    }

    private void addMapOPInner(int type, int event, int count) {
        this.mLastMapGestureEvent = -1;
        this.mLastMapGestureCount = 0;
        if (2 == type && event != -1) {
            switch (event) {
                case 513:
                    add(UserOPParams.COMMON_1_c, "" + count, null, null);
                    return;
                case 514:
                    add(UserOPParams.COMMON_1_d, "" + count, null, null);
                    return;
                case 516:
                    add(UserOPParams.COMMON_1_f, "" + count, null, null);
                    return;
                case 517:
                    add(UserOPParams.COMMON_1_g, "" + count, null, null);
                    return;
                case 518:
                case 519:
                    add(UserOPParams.COMMON_1_7, "" + count, null, null);
                    return;
                case 520:
                    add(UserOPParams.COMMON_1_8, "" + count, null, null);
                    return;
                case 521:
                    add(UserOPParams.COMMON_1_b, "" + count, null, null);
                    return;
                default:
                    return;
            }
        }
    }

    public void appendContinuousOP(String op) {
        if (op != null) {
            if (this.mLastContinuousOP == null) {
                this.mLastContinuousOP = op;
                this.mLastContinuousOPCount = 1;
            } else if (this.mLastContinuousOP.equals(op)) {
                this.mLastContinuousOPCount++;
            } else {
                appendContinuousOPInner(this.mLastContinuousOP, this.mLastContinuousOPCount);
                this.mLastContinuousOP = op;
                this.mLastContinuousOPCount = 1;
            }
        }
    }

    private void checkAddContinuousOPInner() {
        if (this.mLastContinuousOP != null && this.mLastContinuousOPCount > 0) {
            appendContinuousOPInner(this.mLastContinuousOP, this.mLastContinuousOPCount);
            this.mLastContinuousOP = null;
            this.mLastContinuousOPCount = 0;
        }
    }

    private void appendContinuousOPInner(String op, int opCount) {
        this.mLastContinuousOP = null;
        this.mLastContinuousOPCount = 0;
        if (UserOPParams.GUIDE_3_ka.equals(op)) {
            add(UserOPParams.GUIDE_3_k, String.valueOf(opCount), null, null);
        } else if (UserOPParams.GUIDE_3_kb.equals(op)) {
            add(UserOPParams.GUIDE_3_k, null, String.valueOf(opCount), null);
        }
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
        if (!TextUtils.isEmpty(sessionId)) {
            cacheOPs(true);
        }
    }

    private String addEscapeSeqToSsid(String ssidStr) {
        if (ssidStr == null) {
            return null;
        }
        return ssidStr.replace("\"", "\\\"");
    }

    public void cacheOP(UserOP op) {
        if (op != null && op.op != null && op.op.length() > 0) {
            this.mCacheOpMap.put(op.op, op);
        }
    }

    public boolean useAndRemoveCacheOP(String op) {
        if (op != null && op.length() > 0 && this.mCacheOpMap.containsKey(op)) {
            UserOP userOP = (UserOP) this.mCacheOpMap.get(op);
            if (userOP != null) {
                add(op, userOP.f19724a, userOP.f19725b, userOP.f19726c);
                return true;
            }
            this.mCacheOpMap.remove(op);
        }
        return false;
    }

    public void removeCacheOP(UserOP op) {
        if (op != null && op.op != null && op.op.length() > 0 && this.mCacheOpMap.containsKey(op.op)) {
            this.mCacheOpMap.remove(op.op);
        }
    }
}
