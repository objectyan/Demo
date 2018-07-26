package com.baidu.platform.comapi.p134f;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navi.track.sync.SyncChannelConstant.Key;
import com.facebook.common.p141m.C2924g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UpdateInfo */
/* renamed from: com.baidu.platform.comapi.f.b */
public class C4772b {
    /* renamed from: a */
    public static String f19817a = "bsdiff";
    /* renamed from: b */
    public String f19818b;
    /* renamed from: c */
    public String f19819c;
    /* renamed from: d */
    public int f19820d;
    /* renamed from: e */
    public String f19821e;
    /* renamed from: f */
    public int f19822f;
    /* renamed from: g */
    public int f19823g;
    /* renamed from: h */
    public String f19824h;
    /* renamed from: i */
    public String f19825i;
    /* renamed from: j */
    public int f19826j;
    /* renamed from: k */
    public int f19827k;
    /* renamed from: l */
    public boolean f19828l = true;
    /* renamed from: m */
    public String f19829m;
    /* renamed from: n */
    public String f19830n;
    /* renamed from: o */
    public int f19831o;
    /* renamed from: p */
    public String f19832p;
    /* renamed from: q */
    public boolean f19833q = false;

    /* renamed from: a */
    public boolean m15855a() {
        return (TextUtils.isEmpty(this.f19829m) || TextUtils.isEmpty(this.f19830n) || this.f19831o <= 0) ? false : true;
    }

    /* renamed from: b */
    public boolean m15856b() {
        return !TextUtils.isEmpty(this.f19832p);
    }

    /* renamed from: c */
    public Intent m15857c() {
        return new Intent("android.intent.action.VIEW", Uri.parse(this.f19832p));
    }

    /* renamed from: a */
    public C4772b m15854a(Bundle bundle) {
        boolean z = true;
        String json = bundle.getString("ret");
        if (json != null) {
            try {
                JSONObject jsonObject = new JSONObject(json);
                this.f19818b = jsonObject.optString("oem");
                this.f19821e = jsonObject.optString(C2924g.f12889c);
                this.f19824h = jsonObject.optString("md5sum");
                this.f19825i = jsonObject.optString("desc");
                this.f19819c = jsonObject.optString("verson");
                this.f19820d = jsonObject.optInt(C2125n.f6748P);
                this.f19822f = jsonObject.optInt("frag_num");
                this.f19823g = jsonObject.optInt("filesize");
                this.f19826j = jsonObject.optInt(Key.INTERVAL);
                this.f19827k = jsonObject.optInt("force");
                this.f19832p = jsonObject.optString("google_play");
                if (jsonObject.has("diffup")) {
                    JSONArray jsonArray = jsonObject.getJSONArray("diffup");
                    if (jsonArray.length() > 0) {
                        int len = jsonArray.length();
                        for (int i = 0; i < len; i++) {
                            JSONObject jsonObjectItem = jsonArray.getJSONObject(i);
                            if (TextUtils.equals(jsonObjectItem.optString("type"), f19817a)) {
                                this.f19830n = jsonObjectItem.optString("md5sum");
                                this.f19829m = jsonObjectItem.optString(C2924g.f12889c);
                                this.f19831o = jsonObjectItem.optInt("filesize");
                                break;
                            }
                        }
                    }
                }
                if (jsonObject.optInt("JNIDownLoad") == 1) {
                    z = false;
                }
                this.f19828l = z;
                this.f19833q = true;
            } catch (JSONException e) {
                e.printStackTrace();
                this.f19833q = false;
            }
        }
        return this;
    }
}
