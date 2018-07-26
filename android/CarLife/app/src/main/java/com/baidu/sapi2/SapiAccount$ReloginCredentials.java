package com.baidu.sapi2;

import com.baidu.sapi2.utils.C4913L;
import org.json.JSONException;
import org.json.JSONObject;

public final class SapiAccount$ReloginCredentials {
    /* renamed from: a */
    static final String f20015a = "account";
    /* renamed from: b */
    static final String f20016b = "account_type";
    /* renamed from: c */
    static final String f20017c = "password";
    /* renamed from: d */
    static final String f20018d = "ubi";
    public String account;
    public String accountType;
    public String password;
    public String ubi;

    public JSONObject toJSONObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put(f20015a, this.account);
            obj.put(f20016b, this.accountType);
            obj.put(f20017c, this.password);
            obj.put(f20018d, this.ubi);
            return obj;
        } catch (JSONException e) {
            C4913L.m16374e(e);
            return null;
        }
    }

    public static SapiAccount$ReloginCredentials fromJSONObject(JSONObject obj) {
        if (obj == null) {
            return null;
        }
        SapiAccount$ReloginCredentials credentials = new SapiAccount$ReloginCredentials();
        credentials.account = obj.optString(f20015a);
        credentials.accountType = obj.optString(f20016b);
        credentials.password = obj.optString(f20017c);
        credentials.ubi = obj.optString(f20018d);
        return credentials;
    }
}
