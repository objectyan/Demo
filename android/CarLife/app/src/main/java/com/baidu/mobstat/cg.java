package com.baidu.mobstat;

import org.json.JSONObject;

class cg {
    /* renamed from: a */
    private String f19562a;
    /* renamed from: b */
    private String f19563b;
    /* renamed from: c */
    private String f19564c;
    /* renamed from: d */
    private long f19565d;
    /* renamed from: e */
    private long f19566e;
    /* renamed from: f */
    private boolean f19567f;
    /* renamed from: g */
    private JSONObject f19568g;

    public cg(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo) {
        this.f19563b = str;
        this.f19564c = str2;
        this.f19562a = str3;
        this.f19565d = j;
        this.f19566e = j2;
        this.f19567f = z;
        JSONObject jSONObject = new JSONObject();
        if (extraInfo != null) {
            jSONObject = extraInfo.dumpToJson();
        }
        this.f19568g = jSONObject;
    }

    /* renamed from: a */
    public String m15562a() {
        return this.f19563b;
    }

    /* renamed from: b */
    public String m15564b() {
        return this.f19564c;
    }

    /* renamed from: c */
    public long m15565c() {
        return this.f19565d;
    }

    /* renamed from: d */
    public long m15566d() {
        return this.f19566e;
    }

    /* renamed from: e */
    public JSONObject m15567e() {
        return this.f19568g;
    }

    /* renamed from: f */
    public boolean m15568f() {
        return this.f19567f;
    }

    /* renamed from: a */
    public void m15563a(cg cgVar) {
        this.f19562a = cgVar.f19562a;
        this.f19563b = cgVar.f19563b;
        this.f19564c = cgVar.f19564c;
        this.f19565d = cgVar.f19565d;
        this.f19566e = cgVar.f19566e;
        this.f19567f = cgVar.f19567f;
        this.f19568g = cgVar.f19568g;
    }
}
