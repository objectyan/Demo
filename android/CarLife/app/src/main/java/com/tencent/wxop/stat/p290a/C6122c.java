package com.tencent.wxop.stat.p290a;

import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.c */
public class C6122c {
    /* renamed from: a */
    public String f24767a;
    /* renamed from: b */
    public JSONArray f24768b;
    /* renamed from: c */
    public JSONObject f24769c = null;

    public C6122c(String str, String[] strArr, Properties properties) {
        this.f24767a = str;
        if (properties != null) {
            this.f24769c = new JSONObject(properties);
        } else if (strArr != null) {
            this.f24768b = new JSONArray();
            for (Object put : strArr) {
                this.f24768b.put(put);
            }
        } else {
            this.f24769c = new JSONObject();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6122c)) {
            return false;
        }
        return toString().equals(((C6122c) obj).toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(this.f24767a).append(",");
        if (this.f24768b != null) {
            stringBuilder.append(this.f24768b.toString());
        }
        if (this.f24769c != null) {
            stringBuilder.append(this.f24769c.toString());
        }
        return stringBuilder.toString();
    }
}
