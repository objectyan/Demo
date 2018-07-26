package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.baidu.navisdk.module.BusinessActivityManager;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import org.json.JSONArray;
import org.json.JSONObject;

class bl implements UncaughtExceptionHandler {
    /* renamed from: a */
    private static final bl f19453a = new bl();
    /* renamed from: b */
    private UncaughtExceptionHandler f19454b = null;
    /* renamed from: c */
    private Context f19455c = null;
    /* renamed from: d */
    private bu f19456d = new bu();

    /* renamed from: a */
    public static bl m15490a() {
        return f19453a;
    }

    private bl() {
    }

    /* renamed from: a */
    public void m15494a(Context context) {
        if (this.f19454b == null) {
            this.f19454b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
        if (this.f19455c == null) {
            this.f19455c = context.getApplicationContext();
        }
        this.f19456d.m15506a(this.f19455c);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String th2 = th.toString();
        String str = "";
        if (!(th2 == null || th2.equals(""))) {
            try {
                String str2;
                String[] split = th2.split(Config.TRACE_TODAY_VISIT_SPLIT);
                if (th2.length() > 1) {
                    str2 = split[0];
                } else {
                    str2 = th2;
                }
                str = str2;
            } catch (Throwable e) {
                db.m15664c(e);
                str = "";
            }
        }
        if (str == null || str.equals("")) {
            str = th2;
        }
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String obj = stringWriter.toString();
        db.m15657a(obj);
        m15493a(System.currentTimeMillis(), obj, str, 0);
        if (!this.f19454b.equals(this)) {
            this.f19454b.uncaughtException(thread, th);
        }
    }

    /* renamed from: a */
    public void m15493a(long j, String str, String str2, int i) {
        ch.m15571a().m15599b(this.f19455c, System.currentTimeMillis());
        if (this.f19455c != null && str != null && !str.trim().equals("")) {
            try {
                String appVersionName = CooperService.m15264a().getAppVersionName(this.f19455c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("t", j);
                jSONObject.put("c", str);
                jSONObject.put("y", str2);
                jSONObject.put("v", appVersionName);
                jSONObject.put(Config.EXCEPTION_CRASH_TYPE, i);
                jSONObject.put(Config.EXCEPTION_MEMORY, m15492c());
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                jSONObject = new JSONObject();
                this.f19456d.m15507a(this.f19455c, jSONObject);
                jSONObject.put("ss", 0);
                jSONObject.put(Config.SEQUENCE_INDEX, 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(Config.HEADER_PART, jSONObject);
                jSONObject2.put(Config.PRINCIPAL_PART, new JSONArray());
                jSONObject2.put(Config.EVENT_PART, new JSONArray());
                jSONObject2.put(Config.EXCEPTION_PART, jSONArray);
                jSONObject2.put(Config.TRACE_PART, m15491b());
                cu.m15630a(this.f19455c, Config.PREFIX_SEND_DATA + System.currentTimeMillis(), jSONObject2.toString(), false);
                db.m15657a("Dump exception successlly");
            } catch (Throwable e) {
                db.m15662b(e);
            }
        }
    }

    /* renamed from: b */
    private JSONObject m15491b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.TRACE_APPLICATION_SESSION, 0);
        } catch (Exception e) {
        }
        try {
            jSONObject.put(Config.TRACE_FAILED_CNT, 0);
        } catch (Exception e2) {
        }
        return jSONObject;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    private JSONObject m15492c() {
        ActivityManager activityManager = (ActivityManager) this.f19455c.getSystemService(BusinessActivityManager.AUDIO_DIR);
        if (activityManager == null) {
            return null;
        }
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            if (VERSION.SDK_INT >= 16) {
                jSONObject.put(Config.EXCEPTION_MEMORY_TOTAL, memoryInfo.totalMem);
            }
            jSONObject.put(Config.EXCEPTION_MEMORY_FREE, memoryInfo.availMem);
            jSONObject.put(Config.EXCEPTION_MEMORY_LOW, memoryInfo.lowMemory ? 1 : 0);
            return jSONObject;
        } catch (Exception e) {
            return jSONObject;
        }
    }
}
