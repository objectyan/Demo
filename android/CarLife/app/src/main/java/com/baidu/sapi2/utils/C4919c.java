package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.enums.SocialType;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SapiAccountUtils */
/* renamed from: com.baidu.sapi2.utils.c */
public class C4919c {
    /* renamed from: a */
    public static final String f20539a = "is_social_account";
    /* renamed from: b */
    public static final String f20540b = "social_type";
    /* renamed from: c */
    public static final String f20541c = "social_portrait";

    /* renamed from: a */
    public static void m16395a(SapiAccount account, SocialType socialType, String socialPortrait) {
        C4919c.m16396a(account, f20539a, Boolean.valueOf(true));
        C4919c.m16396a(account, f20540b, Integer.valueOf(socialType.getType()));
        C4919c.m16396a(account, f20541c, (Object) socialPortrait);
    }

    /* renamed from: a */
    public static void m16396a(SapiAccount account, String key, Object value) {
        if (account != null && !TextUtils.isEmpty(key) && value != null) {
            JSONObject object;
            if (TextUtils.isEmpty(account.extra)) {
                try {
                    object = new JSONObject();
                    object.put(key, value);
                    account.extra = object.toString();
                    return;
                } catch (JSONException e) {
                    C4913L.m16374e(e);
                    return;
                }
            }
            try {
                object = new JSONObject(account.extra);
                object.put(key, value);
                account.extra = object.toString();
            } catch (JSONException e2) {
                C4913L.m16374e(e2);
            }
        }
    }
}
