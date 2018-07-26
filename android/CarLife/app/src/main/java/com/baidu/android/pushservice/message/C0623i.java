package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.p028g.C0527a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.message.i */
public class C0623i {
    /* renamed from: a */
    public String f1952a;
    /* renamed from: b */
    public String f1953b;
    /* renamed from: c */
    public String f1954c;
    /* renamed from: d */
    public String f1955d;
    /* renamed from: e */
    public String f1956e;
    /* renamed from: f */
    public String f1957f;
    /* renamed from: g */
    public String f1958g;
    /* renamed from: h */
    public String f1959h;
    /* renamed from: i */
    public int f1960i;
    /* renamed from: j */
    public String f1961j;
    /* renamed from: k */
    public String f1962k;
    /* renamed from: l */
    public String f1963l;
    /* renamed from: m */
    public int f1964m;
    /* renamed from: n */
    public String f1965n;
    /* renamed from: o */
    public String f1966o;

    /* renamed from: a */
    public PublicMsg m2745a(Context context) {
        PublicMsg publicMsg = new PublicMsg();
        try {
            publicMsg.mMsgId = this.f1963l;
            publicMsg.mAppId = this.f1962k;
            if (TextUtils.isEmpty(this.f1958g) && TextUtils.isEmpty(this.f1959h)) {
                publicMsg.mTitle = this.f1956e;
                publicMsg.mDescription = this.f1957f;
                publicMsg.mUrl = this.f1952a;
                publicMsg.mPkgContent = this.f1954c;
                return publicMsg;
            }
            publicMsg.mTitle = this.f1958g;
            publicMsg.mDescription = this.f1959h;
            publicMsg.mUrl = this.f1953b;
            publicMsg.mPkgContent = this.f1955d;
            return publicMsg;
        } catch (Exception e) {
            C0527a.m2218b("ProxyPushMessage", "Public Message Parsing Fail:\r\n" + e.getMessage(), context.getApplicationContext());
            return null;
        }
    }

    /* renamed from: a */
    public String m2746a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("extras")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("extras");
                    if (jSONArray != null) {
                        m2747a(jSONArray);
                        if (!TextUtils.isEmpty(this.f1965n)) {
                            JSONObject jSONObject2 = new JSONObject(new String(this.f1965n));
                            String string = !jSONObject2.isNull("custom_content") ? jSONObject2.getString("custom_content") : null;
                            if (jSONObject2.isNull("hwsigninfo")) {
                                return string;
                            }
                            this.f1966o = jSONObject2.getString("hwsigninfo");
                            return string;
                        }
                    }
                }
            }
            return null;
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: a */
    public void m2747a(JSONArray jSONArray) {
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!jSONObject.isNull("Appid")) {
                    this.f1962k = jSONObject.getString("Appid");
                }
                if (!jSONObject.isNull("Msgid")) {
                    this.f1963l = jSONObject.getString("Msgid");
                }
                if (!jSONObject.isNull("Type")) {
                    this.f1964m = jSONObject.getInt("Type");
                }
                if (!jSONObject.isNull("push_type")) {
                    this.f1960i = jSONObject.getInt("push_type");
                }
                if (!jSONObject.isNull("gid")) {
                    this.f1961j = jSONObject.getString("gid");
                }
                if (!jSONObject.isNull("msgBody")) {
                    this.f1965n = jSONObject.getString("msgBody");
                }
                i++;
            } catch (Exception e) {
                return;
            }
        }
    }

    /* renamed from: b */
    public String m2748b(Context context, String str) {
        String str2 = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("extras")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("extras");
                    if (jSONArray != null) {
                        m2747a(jSONArray);
                        if (!TextUtils.isEmpty(this.f1965n)) {
                            jSONObject = new JSONObject(this.f1965n);
                            if (!jSONObject.isNull("custom_content")) {
                                str2 = jSONObject.getString("custom_content");
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
        }
        return str2;
    }

    /* renamed from: c */
    public String m2749c(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("extras")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("extras");
                    if (jSONArray != null) {
                        m2747a(jSONArray);
                        if (!TextUtils.isEmpty(this.f1965n)) {
                            JSONObject jSONObject2 = new JSONObject(this.f1965n);
                            String string = !jSONObject2.isNull("custom_content") ? jSONObject2.getString("custom_content") : null;
                            if (jSONObject2.isNull("mzsigninfo")) {
                                return string;
                            }
                            this.f1966o = jSONObject2.getString("mzsigninfo");
                            return string;
                        }
                    }
                }
            }
            return null;
        } catch (JSONException e) {
            return null;
        }
    }
}
