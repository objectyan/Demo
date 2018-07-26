package com.baidu.navisdk.util.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.util.TipTool;

public class SystemAuth {
    public static final String CALL_PHONE_AUTH = "android.permission.CALL_PHONE";
    public static final int NO_TRY_SOURCE = 1000;
    public static final String PHOTO_CAPTURE_AUTH = "android.permission.CAMERA";
    public static final String PHOTO_CAPTURE_MSG = "没有照相机权限，请打开后重试";
    public static final String PROCESS_OUTGOING_CALLS_AUTH = "android.permission.PROCESS_OUTGOING_CALLS";
    public static final String READ_PHONE_STATE_AUTH = "android.permission.READ_PHONE_STATE";
    public static final String RECORD_AUDIO_AUTH = "android.permission.RECORD_AUDIO";
    public static final String RECORD_AUDIO_MSG = "没有麦克风权限，请打开后重试";

    public interface IOnRequestAuthrityListener {
        boolean onRequestAuthrity(String str, int i, Bundle bundle);
    }

    public static boolean checkAuth(String auth) {
        return checkAuth(auth, false, null);
    }

    public static boolean checkAuth(String auth, boolean isToastMsg, String toastMsg) {
        Context ctx = BNaviModuleManager.getContext();
        if (ctx == null) {
            return false;
        }
        try {
            boolean permission;
            if (ctx.getPackageManager().checkPermission(auth, PackageUtil.getPackageName()) == 0) {
                permission = true;
            } else {
                permission = false;
            }
            if (permission || !isToastMsg || TextUtils.isEmpty(toastMsg)) {
                return permission;
            }
            TipTool.onCreateToastDialog(ctx, toastMsg);
            return permission;
        } catch (Throwable th) {
            return false;
        }
    }
}
