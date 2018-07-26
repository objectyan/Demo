package com.baidu.tts.client.model;

import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.JsonTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Conditions {
    /* renamed from: a */
    private Set<String> f20843a;
    /* renamed from: b */
    private String f20844b;
    /* renamed from: c */
    private Set<String> f20845c;
    /* renamed from: d */
    private Set<String> f20846d;
    /* renamed from: e */
    private Set<String> f20847e;
    /* renamed from: f */
    private Set<String> f20848f;
    /* renamed from: g */
    private Set<String> f20849g;

    public Set<String> getModelIds() {
        return this.f20843a;
    }

    public void setModelIds(Set<String> modelIds) {
        this.f20843a = modelIds;
    }

    public Set<String> getLanguages() {
        return this.f20845c;
    }

    public void setLanguages(Set<String> languages) {
        this.f20845c = languages;
    }

    public Set<String> getGenders() {
        return this.f20846d;
    }

    public void setGenders(Set<String> genders) {
        this.f20846d = genders;
    }

    public Set<String> getSpeakers() {
        return this.f20847e;
    }

    public void setSpeakers(Set<String> speakers) {
        this.f20847e = speakers;
    }

    public Set<String> getDomains() {
        return this.f20848f;
    }

    public void setDomains(Set<String> domains) {
        this.f20848f = domains;
    }

    public Set<String> getQualitys() {
        return this.f20849g;
    }

    public void setQualitys(Set<String> qualitys) {
        this.f20849g = qualitys;
    }

    public void appendId(String id) {
        if (!StringTool.isEmpty(id)) {
            if (this.f20843a == null) {
                this.f20843a = new HashSet();
            }
            this.f20843a.add(id);
        }
    }

    public void appendLanguage(String language) {
        if (!StringTool.isEmpty(language)) {
            if (this.f20845c == null) {
                this.f20845c = new HashSet();
            }
            this.f20845c.add(language);
        }
    }

    public void appendGender(String gender) {
        if (!StringTool.isEmpty(gender)) {
            if (this.f20846d == null) {
                this.f20846d = new HashSet();
            }
            this.f20846d.add(gender);
        }
    }

    public void appendSpeaker(String speaker) {
        if (!StringTool.isEmpty(speaker)) {
            if (this.f20847e == null) {
                this.f20847e = new HashSet();
            }
            this.f20847e.add(speaker);
        }
    }

    public void appendDomain(String domain) {
        if (!StringTool.isEmpty(domain)) {
            if (this.f20848f == null) {
                this.f20848f = new HashSet();
            }
            this.f20848f.add(domain);
        }
    }

    public void appendQuality(String quality) {
        if (!StringTool.isEmpty(quality)) {
            if (this.f20849g == null) {
                this.f20849g = new HashSet();
            }
            this.f20849g.add(quality);
        }
    }

    public JSONArray getSpeakerJA() {
        return JsonTool.fromSetToJson(this.f20847e);
    }

    public JSONArray getGenderJA() {
        return JsonTool.fromSetToJson(this.f20846d);
    }

    public void setDomains(String[] domains) {
        this.f20848f = DataTool.fromArrayToSet(domains);
    }

    public void setLanguages(String[] languages) {
        this.f20845c = DataTool.fromArrayToSet(languages);
    }

    public void setQualitys(String[] qualities) {
        this.f20849g = DataTool.fromArrayToSet(qualities);
    }

    public String[] getModelIdsArray() {
        return DataTool.fromSetToArray(this.f20843a);
    }

    public String[] getDomainArray() {
        return DataTool.fromSetToArray(this.f20848f);
    }

    public String[] getLanguageArray() {
        return DataTool.fromSetToArray(this.f20845c);
    }

    public String[] getQualityArray() {
        return DataTool.fromSetToArray(this.f20849g);
    }

    public String[] getGenderArray() {
        return DataTool.fromSetToArray(this.f20846d);
    }

    public String[] getSpeakerArray() {
        return DataTool.fromSetToArray(this.f20847e);
    }

    public String getVersion() {
        return this.f20844b;
    }

    public void setVersion(String version) {
        this.f20844b = version;
    }

    public JSONObject getJSONConditions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C5089g.ID.m17274b(), JsonTool.fromSetToJson(this.f20843a));
            jSONObject.put(C5089g.VERSION.m17274b(), this.f20844b);
            jSONObject.put(C5089g.LANGUAGE.m17274b(), JsonTool.fromSetToJson(this.f20845c));
            jSONObject.put(C5089g.GENDER.m17274b(), JsonTool.fromSetToJson(this.f20846d));
            jSONObject.put(C5089g.SPEAKER.m17274b(), JsonTool.fromSetToJson(this.f20847e));
            jSONObject.put(C5089g.DOMAIN.m17274b(), JsonTool.fromSetToJson(this.f20848f));
            jSONObject.put(C5089g.QUALITY.m17274b(), JsonTool.fromSetToJson(this.f20849g));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
