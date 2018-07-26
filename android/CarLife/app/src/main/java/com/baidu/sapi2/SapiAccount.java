package com.baidu.sapi2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.C4919c;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SapiAccount implements Parcelable, Cloneable {
    public static final Creator<SapiAccount> CREATOR = new SapiAccount$1();
    /* renamed from: a */
    static final String f12748a = "uid";
    /* renamed from: b */
    static final String f12749b = "displayname";
    /* renamed from: c */
    static final String f12750c = "username";
    /* renamed from: d */
    static final String f12751d = "email";
    /* renamed from: e */
    static final String f12752e = "phone";
    /* renamed from: f */
    static final String f12753f = "bduss";
    /* renamed from: g */
    static final String f12754g = "app";
    /* renamed from: h */
    static final String f12755h = "ptoken";
    /* renamed from: i */
    static final String f12756i = "stoken";
    /* renamed from: j */
    static final String f12757j = "extra";
    public String app;
    public String bduss;
    public String displayname;
    @Deprecated
    public String email;
    public String extra;
    @Deprecated
    /* renamed from: k */
    private String f12758k;
    @Deprecated
    /* renamed from: l */
    private String f12759l;
    @Deprecated
    public String phone;
    public String ptoken;
    public String stoken;
    public String uid;
    public String username;

    SapiAccount(Parcel parcel) {
        this.uid = parcel.readString();
        this.displayname = parcel.readString();
        this.username = parcel.readString();
        this.email = parcel.readString();
        this.phone = parcel.readString();
        this.bduss = parcel.readString();
        this.app = parcel.readString();
        this.ptoken = parcel.readString();
        this.stoken = parcel.readString();
        this.f12759l = parcel.readString();
        this.extra = parcel.readString();
        this.f12758k = parcel.readString();
    }

    public JSONObject toJSONObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("uid", this.uid);
            obj.put("displayname", this.displayname);
            obj.put(f12750c, this.username);
            obj.put("email", this.email);
            obj.put(f12752e, this.phone);
            obj.put("bduss", this.bduss);
            obj.put("app", this.app);
            obj.put("ptoken", this.ptoken);
            obj.put("stoken", this.stoken);
            obj.put(f12757j, this.extra);
            return obj;
        } catch (JSONException e) {
            C4913L.e(e);
            return null;
        }
    }

    public static JSONArray toJSONArray(List<SapiAccount> accountList) {
        if (accountList == null) {
            return null;
        }
        JSONArray arr = new JSONArray();
        for (SapiAccount account : accountList) {
            JSONObject obj = account.toJSONObject();
            if (obj != null) {
                arr.put(obj);
            }
        }
        return arr;
    }

    public static SapiAccount fromJSONObject(JSONObject obj) {
        if (obj == null) {
            return null;
        }
        SapiAccount account = new SapiAccount();
        account.uid = obj.optString("uid");
        account.displayname = obj.optString("displayname");
        account.username = obj.optString(f12750c);
        account.email = obj.optString("email");
        account.phone = obj.optString(f12752e);
        account.bduss = obj.optString("bduss");
        account.app = obj.optString("app");
        account.ptoken = obj.optString("ptoken");
        account.stoken = obj.optString("stoken");
        account.extra = obj.optString(f12757j);
        return account;
    }

    public static List<SapiAccount> fromJSONArray(JSONArray arr) {
        if (arr == null || arr.length() == 0) {
            return new ArrayList();
        }
        List<SapiAccount> accounts = new ArrayList();
        for (int i = 0; i < arr.length(); i++) {
            try {
                SapiAccount account = fromJSONObject(arr.getJSONObject(i));
                if (account != null) {
                    accounts.add(account);
                }
            } catch (JSONException e) {
                C4913L.e(e);
            }
        }
        return accounts;
    }

    public boolean isSocialAccount() {
        boolean z = false;
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                z = new JSONObject(this.extra).optBoolean(C4919c.f20539a, false);
            } catch (JSONException e) {
            }
        }
        return z;
    }

    public SocialType getSocialType() {
        if (TextUtils.isEmpty(this.extra)) {
            return SocialType.UNKNOWN;
        }
        try {
            return SocialType.getSocialType(new JSONObject(this.extra).optInt(C4919c.f20540b, SocialType.UNKNOWN.getType()));
        } catch (JSONException e) {
            return SocialType.UNKNOWN;
        }
    }

    public String getSocialPortrait() {
        String str = null;
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                str = new JSONObject(this.extra).optString(C4919c.f20541c, null);
            } catch (JSONException e) {
            }
        }
        return str;
    }

    public Object clone() throws CloneNotSupportedException {
        super.clone();
        SapiAccount clone = new SapiAccount();
        clone.uid = this.uid;
        clone.displayname = this.displayname;
        clone.username = this.username;
        clone.email = this.email;
        clone.phone = this.phone;
        clone.bduss = this.bduss;
        clone.ptoken = this.ptoken;
        clone.stoken = this.stoken;
        clone.app = this.app;
        clone.extra = this.extra;
        return clone;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uid);
        dest.writeString(this.displayname);
        dest.writeString(this.username);
        dest.writeString(this.email);
        dest.writeString(this.phone);
        dest.writeString(this.bduss);
        dest.writeString(this.app);
        dest.writeString(this.ptoken);
        dest.writeString(this.stoken);
        dest.writeString(this.f12759l);
        dest.writeString(this.extra);
        dest.writeString(this.f12758k);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SapiAccount that = (SapiAccount) o;
        if (this.uid != null) {
            if (this.uid.equals(that.uid)) {
                return true;
            }
        } else if (that.uid == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.uid != null ? this.uid.hashCode() : 0;
    }

    public String toString() {
        return "SapiAccount{uid='" + this.uid + '\'' + ", displayname='" + this.displayname + '\'' + ", username='" + this.username + '\'' + ", email='" + this.email + '\'' + ", phone='" + this.phone + '\'' + ", bduss='" + this.bduss + '\'' + ", app='" + this.app + '\'' + ", ptoken='" + this.ptoken + '\'' + ", stoken='" + this.stoken + '\'' + ", extra='" + this.extra + '\'' + '}';
    }

    public SapiAccount$ReloginCredentials getReloginCredentials() {
        return C4891b.a(SapiAccountManager.getInstance().getSapiConfiguration().context).b(this.uid);
    }
}
