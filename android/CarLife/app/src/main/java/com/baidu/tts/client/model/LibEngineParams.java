package com.baidu.tts.client.model;

import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.tools.JsonTool;
import org.json.JSONException;
import org.json.JSONObject;

public class LibEngineParams {
    /* renamed from: a */
    private String f20858a;
    /* renamed from: b */
    private String f20859b;
    /* renamed from: c */
    private String[] f20860c;
    /* renamed from: d */
    private String[] f20861d;
    /* renamed from: e */
    private String[] f20862e;

    public LibEngineParams(String params) {
        this.f20858a = params;
        try {
            JSONObject jSONObject = new JSONObject(params);
            this.f20859b = jSONObject.optString(C5089g.VERSION.m17274b());
            this.f20860c = JsonTool.getStringarray(jSONObject.optJSONArray(C5089g.DOMAIN.m17274b()));
            this.f20861d = JsonTool.getStringarray(jSONObject.optJSONArray(C5089g.LANGUAGE.m17274b()));
            this.f20862e = JsonTool.getStringarray(jSONObject.optJSONArray(C5089g.QUALITY.m17274b()));
        } catch (Exception e) {
        }
    }

    public String getVersion() {
        return this.f20859b;
    }

    public void setVersion(String version) {
        this.f20859b = version;
    }

    public String[] getDomain() {
        return this.f20860c;
    }

    public void setDomain(String[] domain) {
        this.f20860c = domain;
    }

    public String[] getLanguage() {
        return this.f20861d;
    }

    public void setLanguage(String[] language) {
        this.f20861d = language;
    }

    public String[] getQuality() {
        return this.f20862e;
    }

    public void setQuality(String[] quality) {
        this.f20862e = quality;
    }

    public String getResult() {
        return this.f20858a;
    }

    public JSONObject getJsonResult() {
        try {
            return new JSONObject(this.f20858a);
        } catch (JSONException e) {
            return null;
        }
    }
}
