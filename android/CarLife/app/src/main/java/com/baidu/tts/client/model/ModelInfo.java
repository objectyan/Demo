package com.baidu.tts.client.model;

import com.baidu.tts.p233f.C5089g;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ModelInfo {
    /* renamed from: a */
    private String f20873a;
    /* renamed from: b */
    private String f20874b;
    /* renamed from: c */
    private String f20875c;
    /* renamed from: d */
    private String f20876d;
    /* renamed from: e */
    private String f20877e;
    /* renamed from: f */
    private String f20878f;
    /* renamed from: g */
    private String f20879g;
    /* renamed from: h */
    private String f20880h;
    /* renamed from: i */
    private String f20881i;
    /* renamed from: j */
    private String f20882j;
    /* renamed from: k */
    private String f20883k;

    public String getServerId() {
        return this.f20873a;
    }

    public void setServerId(String serverId) {
        this.f20873a = serverId;
    }

    public String getName() {
        return this.f20874b;
    }

    public void setName(String name) {
        this.f20874b = name;
    }

    public String getVersionMin() {
        return this.f20875c;
    }

    public void setVersionMin(String versionMin) {
        this.f20875c = versionMin;
    }

    public String getVersionMax() {
        return this.f20876d;
    }

    public void setVersionMax(String versionMax) {
        this.f20876d = versionMax;
    }

    public String getLanguage() {
        return this.f20877e;
    }

    public void setLanguage(String language) {
        this.f20877e = language;
    }

    public String getGender() {
        return this.f20878f;
    }

    public void setGender(String gender) {
        this.f20878f = gender;
    }

    public String getSpeaker() {
        return this.f20879g;
    }

    public void setSpeaker(String speaker) {
        this.f20879g = speaker;
    }

    public String getDomain() {
        return this.f20880h;
    }

    public void setDomain(String domain) {
        this.f20880h = domain;
    }

    public String getQuality() {
        return this.f20881i;
    }

    public void setQuality(String quality) {
        this.f20881i = quality;
    }

    public String getTextDataId() {
        return this.f20882j;
    }

    public void setTextDataId(String textDataId) {
        this.f20882j = textDataId;
    }

    public String getSpeechDataId() {
        return this.f20883k;
    }

    public void setSpeechDataId(String speechDataId) {
        this.f20883k = speechDataId;
    }

    public void setMap(Map<String, String> map) {
        if (map != null) {
            this.f20873a = (String) map.get(C5089g.ID.m17274b());
            this.f20874b = (String) map.get(C5089g.NAME.m17274b());
            this.f20875c = (String) map.get(C5089g.VERSION_MIN.m17274b());
            this.f20876d = (String) map.get(C5089g.VERSION_MAX.m17274b());
            this.f20877e = (String) map.get(C5089g.LANGUAGE.m17274b());
            this.f20878f = (String) map.get(C5089g.GENDER.m17274b());
            this.f20879g = (String) map.get(C5089g.SPEAKER.m17274b());
            this.f20880h = (String) map.get(C5089g.DOMAIN.m17274b());
            this.f20881i = (String) map.get(C5089g.QUALITY.m17274b());
            this.f20882j = (String) map.get(C5089g.TEXT_DATA_ID.m17274b());
            this.f20883k = (String) map.get(C5089g.SPEECH_DATA_ID.m17274b());
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(C5089g.ID.m17274b(), this.f20873a);
            jSONObject.putOpt(C5089g.NAME.m17274b(), this.f20874b);
            jSONObject.putOpt(C5089g.VERSION_MIN.m17274b(), this.f20875c);
            jSONObject.putOpt(C5089g.VERSION_MAX.m17274b(), this.f20876d);
            jSONObject.putOpt(C5089g.LANGUAGE.m17274b(), this.f20877e);
            jSONObject.putOpt(C5089g.GENDER.m17274b(), this.f20878f);
            jSONObject.putOpt(C5089g.SPEAKER.m17274b(), this.f20879g);
            jSONObject.putOpt(C5089g.DOMAIN.m17274b(), this.f20880h);
            jSONObject.putOpt(C5089g.QUALITY.m17274b(), this.f20881i);
            jSONObject.putOpt(C5089g.TEXT_DATA_ID.m17274b(), this.f20882j);
            jSONObject.putOpt(C5089g.SPEECH_DATA_ID.m17274b(), this.f20883k);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void parseJson(JSONObject jo) {
        this.f20873a = jo.optString(C5089g.ID.m17274b());
        this.f20874b = jo.optString(C5089g.NAME.m17274b());
        this.f20875c = jo.optString(C5089g.VERSION_MIN.m17274b());
        this.f20876d = jo.optString(C5089g.VERSION_MAX.m17274b());
        this.f20877e = jo.optString(C5089g.LANGUAGE.m17274b());
        this.f20878f = jo.optString(C5089g.GENDER.m17274b());
        this.f20879g = jo.optString(C5089g.SPEAKER.m17274b());
        this.f20880h = jo.optString(C5089g.DOMAIN.m17274b());
        this.f20881i = jo.optString(C5089g.QUALITY.m17274b());
        this.f20882j = jo.optString(C5089g.TEXT_DATA_ID.m17274b());
        this.f20883k = jo.optString(C5089g.SPEECH_DATA_ID.m17274b());
    }
}
