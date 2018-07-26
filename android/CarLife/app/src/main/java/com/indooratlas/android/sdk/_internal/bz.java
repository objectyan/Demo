package com.indooratlas.android.sdk._internal;

import com.baidu.baidunavis.BaiduNaviParams;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bz {
    /* renamed from: a */
    public int f23274a = 1;
    /* renamed from: b */
    public long f23275b;
    /* renamed from: c */
    public String[] f23276c;
    /* renamed from: d */
    public String f23277d;
    /* renamed from: e */
    public int f23278e;
    /* renamed from: f */
    public String f23279f;
    /* renamed from: g */
    public JSONObject f23280g;
    /* renamed from: h */
    public long[] f23281h;

    bz(String str, long j) {
        this.f23275b = j;
        this.f23277d = str;
        this.f23280g = new JSONObject();
    }

    /* renamed from: a */
    public final String m20194a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        switch (this.f23274a) {
            case 1:
                jSONObject.put("type", "histogram");
                this.f23280g.put("name", this.f23277d);
                if (this.f23281h != null && this.f23281h.length > 0) {
                    this.f23280g.put("values", new JSONArray().put(this.f23281h[0]));
                    break;
                }
            case 2:
                Object obj;
                jSONObject.put("type", "log");
                JSONObject jSONObject2 = this.f23280g;
                String str = "level";
                switch (this.f23278e) {
                    case 2:
                        obj = "verbose";
                        break;
                    case 5:
                        obj = "warn";
                        break;
                    case 6:
                        obj = ParamKey.KEY_MSG_ERRORS;
                        break;
                    default:
                        obj = "debug";
                        break;
                }
                jSONObject2.put(str, obj);
                this.f23280g.put("msg", this.f23279f);
                break;
            default:
                throw new IllegalArgumentException("event type not implemented: " + this.f23274a);
        }
        jSONObject.put("data", this.f23280g);
        jSONObject.put(BaiduNaviParams.KEY_TIME, ((double) this.f23275b) / 1000.0d);
        if (this.f23276c != null && this.f23276c.length > 0) {
            int length = this.f23276c.length;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                jSONArray.put(i, this.f23276c[i]);
            }
            jSONObject.put("tags", jSONArray);
        }
        return jSONObject.toString();
    }

    public final String toString() {
        try {
            return m20194a();
        } catch (JSONException e) {
            return super.toString();
        }
    }
}
