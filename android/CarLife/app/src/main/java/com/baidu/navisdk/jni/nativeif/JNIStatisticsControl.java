package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import com.baidu.navisdk.jni.control.EnvironmentUtil;
import com.baidu.navisdk.util.common.PackageUtil;

public class JNIStatisticsControl {
    private static final String KEY_LOG_HEAD_CHANNEL = "channel";
    private static final String KEY_LOG_HEAD_UID = "duid";
    public static JNIStatisticsControl sInstance = new JNIStatisticsControl();

    public native void clearOldNetWorkDataRecord();

    public native void getAllNetWorkDataSize(Bundle bundle);

    public native int getStatisticsResult(String str, Bundle bundle);

    public native int recordStatisticsItem(String str);

    public native int setLogHeaderParam(Bundle bundle);

    public native int setTTSTextPlayResult(String str, String str2);

    public native int upLoadStatistics();

    public native int writeTmpLogFile();

    private JNIStatisticsControl() {
    }

    public void init() {
        try {
            setLogHeaderParam(PackageUtil.getChannel(), EnvironmentUtil.getCuid());
        } catch (Throwable th) {
        }
    }

    public void exit() {
        try {
            writeTmpLogFile();
        } catch (Throwable th) {
        }
    }

    private int setLogHeaderParam(String strChannel, String strUid) {
        try {
            Bundle input = new Bundle();
            input.putString(KEY_LOG_HEAD_CHANNEL, strChannel);
            input.putString(KEY_LOG_HEAD_UID, strUid);
            return setLogHeaderParam(input);
        } catch (Throwable th) {
            return -1;
        }
    }
}
