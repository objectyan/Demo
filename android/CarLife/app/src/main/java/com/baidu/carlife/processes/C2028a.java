package com.baidu.carlife.processes;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.processes.models.AndroidAppProcess;
import com.baidu.carlife.processes.models.AndroidAppProcess.C2030a;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.module.BusinessActivityManager;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProcessManager */
/* renamed from: com.baidu.carlife.processes.a */
public class C2028a {
    /* renamed from: a */
    public static final String f6555a = "AndroidProcesses";
    /* renamed from: b */
    private static final int f6556b = 1;
    /* renamed from: c */
    private static final int f6557c = 2;
    /* renamed from: d */
    private static final String f6558d = "com.android.incallui";
    /* renamed from: e */
    private static List<String> f6559e = new ArrayList();
    /* renamed from: f */
    private static List<String> f6560f = new ArrayList();
    /* renamed from: g */
    private static List<String> f6561g = new ArrayList();

    /* compiled from: ProcessManager */
    /* renamed from: com.baidu.carlife.processes.a$a */
    public static final class C2027a implements Comparator<AndroidAppProcess> {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7775a((AndroidAppProcess) obj, (AndroidAppProcess) obj2);
        }

        /* renamed from: a */
        public int m7775a(AndroidAppProcess lhs, AndroidAppProcess rhs) {
            try {
                return lhs.m7794e() - rhs.m7794e();
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    static {
        f6559e.add("com.motorola.audiomonitor");
        f6559e.add("com.qiyi.video");
        f6560f.add("com.google.android.dialer");
        f6560f.add(f6558d);
        f6560f.add("com.android.dialer");
        if (VERSION.SDK_INT < 21) {
            f6560f.add("com.android.phone");
        }
        f6561g.add("SM-N9106W");
        f6561g.add("SCH-I959");
        f6561g.add("SM-G9008V");
        f6561g.add("SM-G9200");
    }

    private C2028a() {
        throw new AssertionError("no instances");
    }

    /* renamed from: a */
    public static List<AndroidAppProcess> m7776a() {
        List<AndroidAppProcess> processes = new ArrayList();
        for (File file : new File("/proc").listFiles()) {
            if (file.isDirectory()) {
                try {
                    try {
                        processes.add(new AndroidAppProcess(Integer.parseInt(file.getName())));
                    } catch (C2030a e) {
                    } catch (IOException e2) {
                    }
                } catch (NumberFormatException e3) {
                }
            }
        }
        return processes;
    }

    /* renamed from: a */
    public static List<AndroidAppProcess> m7777a(Context ctx) {
        List<AndroidAppProcess> processes = new ArrayList();
        File[] files = new File("/proc").listFiles();
        PackageManager pm = ctx.getPackageManager();
        for (File file : files) {
            if (file.isDirectory()) {
                try {
                    try {
                        AndroidAppProcess process = new AndroidAppProcess(Integer.parseInt(file.getName()));
                        if (process.f6565a && !process.c.contains(Config.TRACE_TODAY_VISIT_SPLIT) && (((process.f6566b < 1000 || process.f6566b > 9999) && pm.getLaunchIntentForPackage(process.m7802a()) != null) || f6560f.contains(process.m7802a()))) {
                            processes.add(process);
                        }
                    } catch (C2030a e) {
                    } catch (IOException e2) {
                    }
                } catch (NumberFormatException e3) {
                }
            }
        }
        return processes;
    }

    /* renamed from: b */
    public static boolean m7779b(Context ctx) {
        return C2028a.m7782e(ctx);
    }

    /* renamed from: d */
    private static boolean m7781d(Context ctx) {
        if (VERSION.SDK_INT >= 21) {
            List<AndroidAppProcess> processLists = C2028a.m7777a(ctx);
            if (!processLists.isEmpty()) {
                AndroidAppProcess phoneProcess = null;
                for (AndroidAppProcess process : processLists) {
                    if (f6560f.contains(process.m7802a())) {
                        phoneProcess = process;
                        break;
                    }
                }
                if (phoneProcess != null && phoneProcess.f6566b >= 1000 && phoneProcess.f6566b < 10000) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: e */
    private static boolean m7782e(Context ctx) {
        if (f6560f.contains(C2028a.m7780c(ctx))) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private static boolean m7783f(Context ctx) {
        List<AndroidAppProcess> processes = C2028a.m7777a(ctx);
        String carLifePackageName = ctx.getPackageName();
        boolean isSystemPhoneExists = false;
        boolean isCarLifeExists = false;
        if (!processes.isEmpty()) {
            for (AndroidAppProcess process : processes) {
                if (!TextUtils.isEmpty(process.m7802a()) && f6560f.contains(process.m7802a())) {
                    isSystemPhoneExists = true;
                } else if (!TextUtils.isEmpty(process.m7802a()) && TextUtils.equals(carLifePackageName, process.m7802a())) {
                    isCarLifeExists = true;
                }
            }
        }
        return isSystemPhoneExists && !isCarLifeExists;
    }

    /* renamed from: c */
    public static String m7780c(Context ctx) {
        String packageName = "";
        if (VERSION.SDK_INT < 21) {
            return C2028a.m7785h(ctx);
        }
        packageName = C2028a.m7786i(ctx);
        if (Build.MANUFACTURER.equals("motorola") || Build.MANUFACTURER.equals("sony")) {
            packageName = "";
            C1260i.m4435b(f6555a, "motorola's mobile need special handle。 model=" + Build.MODEL);
        }
        if (TextUtils.isEmpty(packageName)) {
            return C2028a.m7784g(ctx);
        }
        return packageName;
    }

    /* renamed from: g */
    private static String m7784g(Context ctx) {
        String packageName = "";
        List<AndroidAppProcess> processes = C2028a.m7777a(ctx);
        if (processes.isEmpty()) {
            return packageName;
        }
        for (String itemName : f6559e) {
            Iterator<AndroidAppProcess> iter = processes.iterator();
            while (iter.hasNext()) {
                if (TextUtils.equals(itemName, ((AndroidAppProcess) iter.next()).m7802a())) {
                    iter.remove();
                }
            }
        }
        Collections.sort(processes, new C2027a());
        return ((AndroidAppProcess) processes.get(0)).m7802a();
    }

    /* renamed from: h */
    private static String m7785h(Context ctx) {
        List<RunningTaskInfo> runningTaskInfos = ((ActivityManager) ctx.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningTasks(Integer.MAX_VALUE);
        if (runningTaskInfos != null) {
            return ((RunningTaskInfo) runningTaskInfos.get(0)).topActivity.getPackageName();
        }
        return null;
    }

    /* renamed from: i */
    private static String m7786i(Context ctx) {
        RunningAppProcessInfo currentInfo = null;
        Field field = null;
        try {
            field = RunningAppProcessInfo.class.getDeclaredField("processState");
        } catch (Exception ignored) {
            C1260i.m4445e(f6555a, ignored.getMessage());
        }
        for (RunningAppProcessInfo app : ((ActivityManager) ctx.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningAppProcesses()) {
            if (app.importance == 100 && app.importanceReasonCode == 0) {
                Integer state = null;
                try {
                    state = Integer.valueOf(field.getInt(app));
                } catch (Exception e) {
                    C1260i.m4445e(f6555a, e.getMessage());
                }
                if (state != null && (state.intValue() == 2 || state.intValue() == 1)) {
                    currentInfo = app;
                    break;
                }
            }
        }
        if (currentInfo != null) {
            return currentInfo.processName;
        }
        return "";
    }

    /* renamed from: b */
    public static boolean m7778b() {
        List<AndroidAppProcess> processes = C2028a.m7776a();
        int myPid = Process.myPid();
        for (AndroidAppProcess process : processes) {
            if (process.d == myPid && process.f6565a) {
                return true;
            }
        }
        return false;
    }
}
