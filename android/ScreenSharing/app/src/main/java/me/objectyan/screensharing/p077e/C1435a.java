package com.baidu.carlife.p077e;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.config.CarlifeConfig;
import com.baidu.carlife.core.config.CarlifeConfig.C1189a;
import com.baidu.carlife.p054k.C1642c;
import com.baidu.carlife.util.C2177h;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ConfigManager */
/* renamed from: com.baidu.carlife.e.a */
public class C1435a {
    /* renamed from: a */
    private static final String f4157a = "ConfigManager";
    /* renamed from: b */
    private static final String f4158b = "carlife.config";
    /* renamed from: c */
    private static final String f4159c = "screenadapt.config";
    /* renamed from: d */
    private static final String f4160d = "KEY_HOME_FOUND_ETCP_STRING";
    /* renamed from: e */
    private static final String f4161e = "KEY_HOME_FOUND_ETCP_OPEN_BOOL";
    /* renamed from: f */
    private static final String f4162f = "289,131,340,132";
    /* renamed from: g */
    private static final String f4163g = "KEY_HOME_FOUND_BOOK_STRING";
    /* renamed from: h */
    private static final String f4164h = "KEY_HOME_FOUND_BOOK_OPEN_BOOL";
    /* renamed from: i */
    private static final String f4165i = "340";
    /* renamed from: j */
    private static final String f4166j = "KEY_HOME_FOUND_JYB_OPEN_BOOL";
    /* renamed from: k */
    private static final String f4167k = "KEY_TRACK_UPLOAD_GPS_FILE_OPEN";
    /* renamed from: l */
    private static final String f4168l = "KEY_INTERNAL_SCREEN_BLACK_LIST";
    /* renamed from: m */
    private static final String f4169m = "{\"HUAWEI\":{\"HUAWEI P6-T00\":\"19\"},\"samsung\":{\"SM-A8000\":\"22\"}}";
    /* renamed from: q */
    private static C1435a f4170q = new C1435a();
    /* renamed from: n */
    private boolean f4171n = false;
    /* renamed from: o */
    private boolean f4172o = false;
    /* renamed from: p */
    private JSONObject f4173p = new JSONObject();

    /* compiled from: ConfigManager */
    /* renamed from: com.baidu.carlife.e.a$a */
    public interface C1433a {
        /* renamed from: a */
        void mo1551a();

        /* renamed from: a */
        void mo1552a(int i);
    }

    /* compiled from: ConfigManager */
    /* renamed from: com.baidu.carlife.e.a$1 */
    class C14341 implements C1433a {
        /* renamed from: a */
        final /* synthetic */ C1435a f4156a;

        C14341(C1435a this$0) {
            this.f4156a = this$0;
        }

        /* renamed from: a */
        public void mo1551a() {
            LogUtil.d(C1435a.f4157a, "onSuccess()");
            this.f4156a.m5230o();
            this.f4156a.m5238j();
            this.f4156a.m5239k();
            this.f4156a.m5240l();
            CarlifeConfig.m4064a(this.f4156a.f4171n);
            MsgHandlerCenter.m4461b(6001);
        }

        /* renamed from: a */
        public void mo1552a(int errorType) {
            this.f4156a.m5241m();
        }
    }

    /* renamed from: a */
    public static C1435a m5226a() {
        return f4170q;
    }

    private C1435a() {
        m5230o();
    }

    /* renamed from: b */
    public void m5231b() {
        m5238j();
        m5240l();
        CarlifeConfig.m4064a(this.f4171n);
        new C1642c(new C14341(this)).toGetRequest();
    }

    /* renamed from: c */
    public static String m5229c() {
        File file = new File(AppContext.m3876a().getFilesDir(), f4158b);
        LogUtil.d(f4157a, "ConfigFilePath: " + file.exists());
        return file.getPath();
    }

    /* renamed from: o */
    private void m5230o() {
        String jsonStr = C2177h.m8274b(C1435a.m5229c());
        if (!TextUtils.isEmpty(jsonStr)) {
            try {
                LogUtil.d(f4157a, "loadData=" + jsonStr);
                this.f4173p = new JSONObject(jsonStr);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    public String m5232d() {
        if (this.f4173p != null) {
            return this.f4173p.optString(f4160d, f4162f);
        }
        return f4162f;
    }

    /* renamed from: e */
    public String m5233e() {
        if (this.f4173p != null) {
            return this.f4173p.optString(f4163g, f4165i);
        }
        return f4165i;
    }

    /* renamed from: f */
    public boolean m5234f() {
        if (this.f4173p != null) {
            return this.f4173p.optBoolean(f4161e, false);
        }
        return false;
    }

    /* renamed from: g */
    public boolean m5235g() {
        if (this.f4173p != null) {
            return this.f4173p.optBoolean(f4164h, true);
        }
        return true;
    }

    /* renamed from: h */
    public boolean m5236h() {
        if (this.f4173p != null) {
            return this.f4173p.optBoolean(f4166j, true);
        }
        return true;
    }

    /* renamed from: i */
    public int m5237i() {
        if (this.f4173p != null) {
            return this.f4173p.optInt(f4167k, 1);
        }
        return 1;
    }

    /* renamed from: j */
    public void m5238j() {
        if (this.f4173p != null) {
            JSONObject blackList = this.f4173p.optJSONObject(f4168l);
            if (blackList == null) {
                try {
                    blackList = new JSONObject(f4169m);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (blackList != null) {
                JSONObject manufacturer = blackList.optJSONObject(Build.MANUFACTURER);
                if (manufacturer != null) {
                    String version = manufacturer.optString(Build.MODEL);
                    if (!TextUtils.isEmpty(version) && version.contains(VERSION.SDK_INT + "")) {
                        this.f4171n = true;
                        LogUtil.m4445e(f4157a, "manufacturer=" + Build.MANUFACTURER + ", model=" + Build.MODEL + ", version=" + VERSION.SDK_INT + " not support internal screen capture policy.");
                    }
                }
            }
        }
    }

    /* renamed from: k */
    public void m5239k() {
        if (this.f4173p != null) {
            try {
                CarlifeConfig.m4066b();
                JSONArray jsonArray = this.f4173p.getJSONArray("CHAT_SWITCH");
                int len = jsonArray.length();
                for (int i = 0; i < len; i++) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    C1189a wechatChannel = new C1189a();
                    wechatChannel.f3153a = json.optString("vehiclechannel");
                    wechatChannel.f3154b = json.optString("text");
                    CarlifeConfig.m4063a(wechatChannel);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: l */
    public void m5240l() {
        if (this.f4173p != null) {
            try {
                JSONArray jsonArray = this.f4173p.getJSONArray("KEY_WIDE_SCREEN_HU");
                LogUtil.d(f4157a, "KEY_WIDE_SCREEN_HU: " + jsonArray);
                int len = jsonArray.length();
                for (int i = 0; i < len; i++) {
                    CarlifeScreenUtil.m4332a(jsonArray.getString(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: m */
    public void m5241m() {
        File file = new File(AppContext.m3876a().getFilesDir(), f4159c);
        JSONArray jsonArray = null;
        if (file.exists()) {
            try {
                String jsonStr = C2177h.m8274b(file.getPath());
                if (!TextUtils.isEmpty(jsonStr)) {
                    try {
                        LogUtil.d(f4157a, "readOfflineScreenAdaptConfig=" + jsonStr);
                        this.f4173p = new JSONObject(jsonStr);
                        jsonArray = this.f4173p.getJSONArray("KEY_WIDE_SCREEN_HU");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (jsonArray != null) {
                    LogUtil.d(f4157a, "KEY_WIDE_SCREEN_HU: " + jsonArray);
                    int len = jsonArray.length();
                    for (int i = 0; i < len; i++) {
                        CarlifeScreenUtil.m4332a(jsonArray.getString(i));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: n */
    public void m5242n() {
        if (this.f4173p != null && !this.f4173p.toString().isEmpty()) {
            LogUtil.d(f4157a, "Save config: " + this.f4173p.toString());
            C2177h.m8271a(C1435a.m5229c(), this.f4173p.toString());
        }
    }
}
