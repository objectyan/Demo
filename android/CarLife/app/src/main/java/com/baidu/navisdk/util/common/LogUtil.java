package com.baidu.navisdk.util.common;

import android.os.Environment;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.debug.SDKDebugFileUtil.CoreLogModule;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogUtil {
    private static final String DEFAULT_TAG = "com.baidu.carlife#navisdk#";
    public static boolean LOGGABLE = BNSettingManager.isShowJavaLog();
    public static boolean LOGWRITE = false;
    public static boolean PERFORMANCE_LOGGABLE = (LOGGABLE & 0);
    public static boolean PERFORMANCE_LOG_TO_FILE = PERFORMANCE_LOGGABLE;
    private static final String TAG = LogUtil.class.getSimpleName();

    /* renamed from: e */
    public static void m15791e(String moduleName, String str) {
        if (LOGGABLE) {
            String tmpInfo = makeLogDetailInfoString(moduleName, str, getValidStackTrace());
            Log.e(DEFAULT_TAG, tmpInfo);
            SDKDebugFileUtil.get(SDKDebugFileUtil.NORMAL_ALL_LOG).add(tmpInfo);
        }
        if (LOGWRITE) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_ALL, makeLogDetailInfoString(moduleName, str, getValidStackTrace()));
        }
    }

    private static StackTraceElement getValidStackTrace() {
        StackTraceElement[] ste = new Throwable().getStackTrace();
        StackTraceElement ret = null;
        if (ste == null) {
            return null;
        }
        for (int i = 1; i < ste.length; i++) {
            StackTraceElement item = ste[i];
            if (!item.getFileName().contains(TAG) && !item.getFileName().contains("NavLogUtils.java")) {
                ret = item;
                break;
            }
        }
        if (ret == null) {
            return ste[0];
        }
        return ret;
    }

    /* renamed from: f */
    public static void m15792f(String moduleName, String str) {
        String sLogFilePath = Environment.getExternalStorageDirectory().toString() + "/BaiduCarLifeLog.txt";
        String strLog = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault()).format(new Date()) + " " + makeLogDetailInfoString(moduleName, str, new Throwable().getStackTrace()[1]) + "\r\n";
        try {
            FileWriter writer = new FileWriter(sLogFilePath, true);
            writer.write(strLog);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            m15791e("", e.toString());
        }
    }

    public static void saveFellowLogToFile(String moduleName, String str) {
        if (LOGGABLE) {
            String sLogFilePath = SysOSAPI.getInstance().GetSDCardPath() + "/fellow/FellowPlayLog.txt";
            String strLog = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault()).format(new Date()) + " " + makeLogDetailInfoString(moduleName, str, new Throwable().getStackTrace()[1]) + "\r\n";
            try {
                FileWriter writer = new FileWriter(sLogFilePath, true);
                writer.write(strLog);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                m15791e("", e.toString());
            }
        }
    }

    private static String makeLogDetailInfoString(String moduleName, String str, StackTraceElement ste) {
        return ("[" + moduleName + "]-" + ste.getFileName() + "(" + ste.getLineNumber() + "): ") + str;
    }

    public static void printCallStatck() {
        StackTraceElement[] stackElements = new Throwable().getStackTrace();
        if (stackElements != null) {
            m15791e("printCallStatck", "----start----");
            for (int i = 0; i < stackElements.length; i++) {
                m15791e("printCallStatck", "at " + stackElements[i].getClassName() + "." + stackElements[i].getMethodName() + "(" + stackElements[i].getFileName() + Config.TRACE_TODAY_VISIT_SPLIT + stackElements[i].getLineNumber() + ")\n");
            }
            m15791e("printCallStatck", "----end----");
        }
    }

    public static String getCallStack() {
        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stackElements = new Throwable().getStackTrace();
        if (stackElements != null) {
            for (int i = 0; i < stackElements.length; i++) {
                sb.append("at " + stackElements[i].getClassName() + "." + stackElements[i].getMethodName() + "(" + stackElements[i].getFileName() + Config.TRACE_TODAY_VISIT_SPLIT + stackElements[i].getLineNumber() + ")\n");
            }
        }
        return sb.toString();
    }

    public static String getCallStack(String filter) {
        if (filter == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stackElements = new Throwable().getStackTrace();
        if (stackElements != null) {
            int i = 0;
            while (i < stackElements.length) {
                if (stackElements[i].getClassName() != null && stackElements[i].getClassName().contains(filter)) {
                    sb.append("at " + stackElements[i].getClassName() + "." + stackElements[i].getMethodName() + "(" + stackElements[i].getFileName() + Config.TRACE_TODAY_VISIT_SPLIT + stackElements[i].getLineNumber() + ")\n");
                }
                i++;
            }
        }
        return sb.toString();
    }
}
