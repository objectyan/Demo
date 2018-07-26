package com.baidu.ufosdk.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel;
import com.baidu.navisdk.util.common.SystemInfoUtils;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map.Entry;

public class NativeClass {
    private static final String UFO_NATIVE_LIB = "ufosdk";
    private Context mContext;

    public native String init(String str, String str2, String str3);

    public void init(String str, String str2, HashMap hashMap) {
        String str3;
        String absolutePath = this.mContext.getFilesDir().getAbsolutePath();
        StringBuilder stringBuilder = new StringBuilder();
        if (hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                String str4 = (String) entry.getKey();
                str3 = (String) entry.getValue();
                stringBuilder.append("&");
                stringBuilder.append(str4);
                stringBuilder.append("=");
                stringBuilder.append(str3);
            }
        }
        str3 = new StringBuilder(String.valueOf(str2)).append(stringBuilder.toString()).toString();
        C5210c.m17734b("ufosdk-->commonuninstall: " + str3);
        C5210c.m17734b("pkgNamePath-->pkgNamePath: " + absolutePath);
        if (VERSION.SDK_INT < 17) {
            init(absolutePath, str3, null);
        } else {
            init(absolutePath, str3, getUserSerial());
        }
    }

    public NativeClass(Context context) {
        this.mContext = context;
    }

    @SuppressLint({"NewApi"})
    public boolean loadUFONativeLib() {
        try {
            if (this.mContext == null) {
                C5210c.m17734b("##################NativeCrashHandler loadNativeCrashHandler failed context is null!");
                return false;
            }
            String stringBuilder;
            if (C5216i.m17756a() < 9) {
                stringBuilder = new StringBuilder(String.valueOf(this.mContext.getApplicationInfo().dataDir)).append("/lib/").append(System.mapLibraryName(UFO_NATIVE_LIB)).toString();
            } else {
                stringBuilder = new StringBuilder(String.valueOf(this.mContext.getApplicationInfo().nativeLibraryDir)).append("/").append(System.mapLibraryName(UFO_NATIVE_LIB)).toString();
            }
            if (TextUtils.isEmpty(stringBuilder) || new File(stringBuilder).exists()) {
                stringBuilder = Build.CPU_ABI;
                C5210c.m17734b("cpu-->" + stringBuilder);
                if (TextUtils.isEmpty(stringBuilder) || !(stringBuilder.contains("arm") || stringBuilder.contains(SystemInfoUtils.K_CPU_MODEL_X86) || stringBuilder.contains("mips"))) {
                    C5210c.m17734b("###################NativeCrashHandler loadNativeCrashHandler failed, CPU_ABI is " + stringBuilder);
                    return false;
                }
                System.loadLibrary(UFO_NATIVE_LIB);
                C5210c.m17734b("###################NativeCrashHandler loadNativeCrashHandler success!  CPU_ABI is " + stringBuilder);
                return true;
            }
            C5210c.m17734b("###################NativeCrashHandler loadNativeCrashHandler failed so file is not exists! dir is " + stringBuilder);
            return false;
        } catch (Exception e) {
            C5210c.m17736d("###################NativeCrashHandler loadNativeCrashHandler failed!");
            e.printStackTrace();
            return false;
        }
    }

    private String getUserSerial() {
        Object systemService = this.mContext.getSystemService(BNRCEventDetailsModel.BN_RC_KEY_USER);
        if (systemService == null) {
            C5210c.m17736d("NativeClass-->userManager not exsit!!!");
            return null;
        }
        try {
            Object invoke = Process.class.getMethod("myUserHandle", null).invoke(Process.class, null);
            return String.valueOf(((Long) systemService.getClass().getMethod("getSerialNumberForUser", new Class[]{invoke.getClass()}).invoke(systemService, new Object[]{invoke})).longValue());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
