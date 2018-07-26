package com.baidu.android.pushservice.message.p033a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.message.C0623i;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.p028g.C0527a;
import com.baidu.android.pushservice.p032k.C0590f;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.message.a.j */
public final class C0609j {
    /* renamed from: a */
    public static PublicMsg m2702a(Context context, String str, String str2, byte[] bArr) {
        boolean z = true;
        PublicMsg publicMsg = new PublicMsg();
        publicMsg.mMsgId = str;
        publicMsg.mAppId = str2;
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (!jSONObject.isNull("title")) {
                publicMsg.mTitle = jSONObject.getString("title");
            }
            if (!jSONObject.isNull("description")) {
                publicMsg.mDescription = jSONObject.getString("description");
            }
            if (!jSONObject.isNull("url")) {
                publicMsg.mUrl = jSONObject.getString("url");
            }
            if (!jSONObject.isNull("notification_builder_id")) {
                publicMsg.mNotificationBuilder = jSONObject.getInt("notification_builder_id");
            }
            if (!jSONObject.isNull("open_type")) {
                publicMsg.mOpenType = jSONObject.getInt("open_type");
            }
            if (!jSONObject.isNull("notification_basic_style")) {
                publicMsg.mNotificationBasicStyle = jSONObject.getInt("notification_basic_style");
            }
            if (!jSONObject.isNull("custom_content")) {
                publicMsg.mCustomContent = jSONObject.getString("custom_content");
            }
            if (!jSONObject.isNull("net_support")) {
                publicMsg.mNetType = jSONObject.getInt("net_support");
            }
            if (!jSONObject.isNull("app_situation")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("app_situation");
                if (jSONObject2.getInt("as_is_support") != 1) {
                    z = false;
                }
                publicMsg.mIsSupportApp = z;
                publicMsg.mSupportAppname = jSONObject2.getString("as_pkg_name");
            }
            if (!jSONObject.isNull(PushConstants.PACKAGE_NAME)) {
                publicMsg.mPkgName = jSONObject.getString(PushConstants.PACKAGE_NAME);
            }
            if (!jSONObject.isNull("pkg_vercode")) {
                publicMsg.mPkgVercode = jSONObject.getInt("pkg_vercode");
            }
            if (jSONObject.isNull("pkg_content")) {
                return publicMsg;
            }
            publicMsg.mPkgContent = jSONObject.getString("pkg_content");
            return publicMsg;
        } catch (Throwable e) {
            C0527a.m2217a("PublicMsgParser", e, context.getApplicationContext());
            return null;
        }
    }

    /* renamed from: a */
    public static C0623i m2703a(Context context, String str) {
        C0623i c0623i = new C0623i();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("msgContent")) {
                JSONObject jSONObject2;
                jSONObject = jSONObject.getJSONObject("msgContent");
                if (!jSONObject.isNull("adContent")) {
                    jSONObject2 = jSONObject.getJSONObject("adContent");
                    c0623i.f1956e = jSONObject2.getString("notifyTitle");
                    c0623i.f1957f = jSONObject2.getString("content");
                    if (!jSONObject2.isNull("param")) {
                        jSONObject2 = jSONObject2.getJSONObject("param");
                        if (!jSONObject2.isNull("url")) {
                            c0623i.f1952a = jSONObject2.getString("url");
                        }
                        if (!jSONObject2.isNull("intentUri")) {
                            c0623i.f1954c = jSONObject2.getString("intentUri");
                        } else if (!jSONObject2.isNull("acn")) {
                            c0623i.f1954c = jSONObject2.getString("acn");
                        }
                    }
                }
                if (!jSONObject.isNull("psContent")) {
                    jSONObject2 = jSONObject.getJSONObject("psContent");
                    c0623i.f1958g = jSONObject2.getString("notifyTitle");
                    c0623i.f1959h = jSONObject2.getString("content");
                    if (!jSONObject2.isNull("param")) {
                        jSONObject2 = jSONObject2.getJSONObject("param");
                        if (!jSONObject2.isNull("url")) {
                            c0623i.f1953b = jSONObject2.getString("url");
                        }
                        if (!jSONObject2.isNull("intentUri")) {
                            c0623i.f1955d = jSONObject2.getString("intentUri");
                        } else if (!jSONObject2.isNull("acn")) {
                            c0623i.f1955d = jSONObject2.getString("acn");
                        }
                    }
                }
                if (!jSONObject.isNull("extras")) {
                    c0623i.m2747a(jSONObject.getJSONArray("extras"));
                }
                if (TextUtils.isEmpty(c0623i.f1963l)) {
                    c0623i.f1963l = C0590f.m2669a(str.getBytes(), false);
                }
            }
        } catch (Exception e) {
        }
        return c0623i;
    }
}
