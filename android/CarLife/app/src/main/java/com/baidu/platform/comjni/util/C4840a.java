package com.baidu.platform.comjni.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.navi.protocol.model.GetPluginInfoDataStruct;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.p209e.C4770a;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* compiled from: InnerErrorLog */
/* renamed from: com.baidu.platform.comjni.util.a */
public class C4840a {
    /* renamed from: a */
    private static final int f20011a = 1024;
    /* renamed from: b */
    private static final int f20012b = 20480;
    /* renamed from: c */
    private static final String f20013c = C4840a.class.getName();
    /* renamed from: d */
    private static Handler f20014d = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static void m16052a(final Throwable throwable) {
        f20014d.post(new Runnable() {
            public void run() {
                C4840a.m16055d(throwable);
            }
        });
    }

    /* renamed from: d */
    private static String m16055d(Throwable throwable) {
        String traces = C4840a.m16056e(throwable);
        C4770a.m15846a().m15849a("exception_type", ParamKey.KEY_MSG_ERRORS);
        C4770a.m15846a().m15851a("exceptionlog");
        return traces;
    }

    /* renamed from: e */
    private static String m16056e(Throwable throwable) {
        Throwable rootCause = throwable;
        for (Throwable t = throwable; t != null; t = t.getCause()) {
            rootCause = t;
        }
        String traces = C4840a.m16053b(rootCause);
        C4770a.m15846a().m15849a("reason", throwable.toString());
        C4770a.m15846a().m15849a(GetPluginInfoDataStruct.KEY_DETAIL, traces);
        C4770a.m15846a().m15849a("mem_info", C4840a.m16050a());
        C4770a.m15846a().m15849a("cpu_abi", Build.CPU_ABI);
        if (8 <= VERSION.SDK_INT) {
            C4770a.m15846a().m15849a("cpu_abi2", Build.CPU_ABI2);
        }
        C4770a.m15846a().m15849a("active_thread", String.valueOf(Thread.activeCount()));
        return traces;
    }

    /* renamed from: a */
    private static String m16051a(String message, String totalTrace) {
        if (message == null) {
            return "";
        }
        byte[] bytes = message.getBytes();
        if (bytes.length > 20480) {
            return new String(bytes, 0, 20480);
        }
        return message;
    }

    /* renamed from: b */
    public static String m16053b(Throwable rootCause) {
        StringBuilder builder;
        String[] ss;
        int i;
        String traces = "";
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            rootCause.printStackTrace(new PrintStream(byteArrayOutputStream));
            byteArrayOutputStream.close();
            traces = byteArrayOutputStream.toString();
            builder = new StringBuilder();
            ss = traces.split("Caused by: ");
            for (i = ss.length - 1; i >= 0; i--) {
                builder.append(ss[i]);
            }
            traces = C4840a.m16051a(builder.toString(), traces);
        } catch (Exception e) {
        }
        builder = new StringBuilder();
        ss = traces.split("\\n\\t");
        i = 0;
        int len = ss.length;
        while (i < len) {
            if (!ss[i].startsWith("...") && (i <= 0 || ss[i].startsWith("at"))) {
                if (ss[i].startsWith("at")) {
                    builder.append("<br>");
                }
                builder.append(ss[i].trim());
            }
            i++;
        }
        return builder.toString();
    }

    /* renamed from: a */
    public static String m16050a() {
        Context context = C2907c.f();
        if (context == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(BusinessActivityManager.AUDIO_DIR);
            stringBuilder.append("HeapMax:").append(activityManager.getMemoryClass()).append(",");
            stringBuilder.append("DvmTotal:").append(Runtime.getRuntime().totalMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).append(",");
            stringBuilder.append("DvmFree:").append(Runtime.getRuntime().freeMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).append(",");
            MemoryInfo[] memoryInfoArray = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
            if (memoryInfoArray != null) {
                for (MemoryInfo pidMemoryInfo : memoryInfoArray) {
                    stringBuilder.append("Pss:").append(pidMemoryInfo.getTotalPss()).append(",");
                    stringBuilder.append("Private:").append(pidMemoryInfo.getTotalPrivateDirty()).append(",");
                    stringBuilder.append("Shared:").append(pidMemoryInfo.getTotalSharedDirty());
                }
            }
        } catch (Exception e) {
            stringBuilder.append("get memory info error");
        }
        return stringBuilder.toString();
    }
}
