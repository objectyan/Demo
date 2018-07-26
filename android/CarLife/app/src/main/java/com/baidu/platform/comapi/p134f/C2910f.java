package com.baidu.platform.comapi.p134f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.concurrent.QueueToken;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.MD5;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.platform.comjni.base.versionupdate.NAVersionUpdate;
import com.tencent.qplayauto.device.QPlayAutoJNI;

/* compiled from: VersionUpdater */
/* renamed from: com.baidu.platform.comapi.f.f */
public class C2910f {
    /* renamed from: b */
    private static C2910f f12719b = null;
    /* renamed from: c */
    private static QueueToken f12720c = ConcurrentManager.obtainTaskQueue(Module.VERSION_UPDATE_MODULE);
    /* renamed from: a */
    private NAVersionUpdate f12721a = null;

    /* renamed from: a */
    public static synchronized C2910f m10989a() {
        C2910f c2910f;
        synchronized (C2910f.class) {
            if (f12719b == null) {
                f12719b = new C2910f();
            }
            f12719b.m10997b();
            c2910f = f12719b;
        }
        return c2910f;
    }

    private C2910f() {
    }

    /* renamed from: b */
    boolean m10997b() {
        if (this.f12721a == null) {
            this.f12721a = new NAVersionUpdate();
            if (this.f12721a.create() == 0) {
                this.f12721a = null;
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static void m10993c() {
        ConcurrentTask task = new f$1();
        task.setQueueToken(f12720c);
        ConcurrentManager.executeTask(Module.VERSION_UPDATE_MODULE, task, ScheduleConfig.forData());
    }

    /* renamed from: a */
    public void m10996a(Context context, String oldPath, String loadPath) {
        if (this.f12721a != null) {
            SysOSAPIv2 sysOSAPIv2 = SysOSAPIv2.getInstance();
            String softVer = sysOSAPIv2.getVersionName();
            String channel = sysOSAPIv2.getChannel();
            String mb = sysOSAPIv2.getPhoneType();
            String os = sysOSAPIv2.getOSVersion();
            int screenX = sysOSAPIv2.getScreenWidth();
            int screenY = sysOSAPIv2.getScreenHeight();
            int dpiX = sysOSAPIv2.getDensityDpi();
            int dpiY = sysOSAPIv2.getDensityDpi();
            JsonBuilder jsonBuilder = new JsonBuilder();
            jsonBuilder.object();
            jsonBuilder.putStringValue("sv", softVer);
            jsonBuilder.putStringValue("channel", channel);
            jsonBuilder.putStringValue("mb", mb);
            jsonBuilder.putStringValue("os", os);
            jsonBuilder.putStringValue("cuid", sysOSAPIv2.getCuid());
            jsonBuilder.putStringValue("resid", sysOSAPIv2.getResID());
            jsonBuilder.putStringValue("ver", "1");
            jsonBuilder.key("screen_x").value(screenX);
            jsonBuilder.key("screen_y").value(screenY);
            jsonBuilder.key("dpi_x").value(dpiX);
            jsonBuilder.key("dpi_y").value(dpiY);
            jsonBuilder.putStringValue("key", "map.android." + sysOSAPIv2.getOem());
            jsonBuilder.key("gpsloc").value(sysOSAPIv2.getGPSOn());
            jsonBuilder.key("netloc").value(sysOSAPIv2.getNetOn());
            jsonBuilder.putStringValue("glr", sysOSAPIv2.getGLRenderer());
            jsonBuilder.putStringValue("glv", sysOSAPIv2.getGLVersion());
            jsonBuilder.putStringValue("cpu", sysOSAPIv2.getCPUProcessor());
            jsonBuilder.putStringValue("net", sysOSAPIv2.getNetType());
            jsonBuilder.endObject();
            ConcurrentTask task = new f$2(this, loadPath, jsonBuilder);
            task.setQueueToken(f12720c);
            ConcurrentManager.executeTask(Module.VERSION_UPDATE_MODULE, task, ScheduleConfig.forData());
        }
    }

    /* renamed from: a */
    public String m10995a(Context context) {
        try {
            PackageInfo packageinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageinfo == null) {
                return QPlayAutoJNI.SONG_LIST_ROOT_ID;
            }
            String md5 = MD5.getMD5String(packageinfo.signatures[0].toCharsString().getBytes());
            if (TextUtils.isEmpty(md5) || md5.length() < 32) {
                return QPlayAutoJNI.SONG_LIST_ROOT_ID;
            }
            int i;
            String sign = md5.substring(8, 24);
            long id1 = 0;
            long id2 = 0;
            String s = "";
            for (i = 0; i < 8; i++) {
                id2 = (id2 * 16) + ((long) Integer.parseInt(sign.substring(i, i + 1), 16));
            }
            for (i = 8; i < sign.length(); i++) {
                id1 = (id1 * 16) + ((long) Integer.parseInt(sign.substring(i, i + 1), 16));
            }
            return String.valueOf((id1 + id2) & 4294967295L);
        } catch (Exception e) {
            C2911f.m11014b(e.getMessage());
            return QPlayAutoJNI.SONG_LIST_ROOT_ID;
        }
    }
}
