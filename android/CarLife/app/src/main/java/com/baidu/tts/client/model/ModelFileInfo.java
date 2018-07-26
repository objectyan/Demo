package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.tools.ResourceTools;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ModelFileInfo {
    /* renamed from: a */
    private String f20867a;
    /* renamed from: b */
    private String f20868b;
    /* renamed from: c */
    private String f20869c;
    /* renamed from: d */
    private String f20870d;
    /* renamed from: e */
    private String f20871e;
    /* renamed from: f */
    private String f20872f;

    public String getServerid() {
        return this.f20867a;
    }

    public void setServerid(String serverid) {
        this.f20867a = serverid;
    }

    public String getLength() {
        return this.f20868b;
    }

    public void setLength(String length) {
        this.f20868b = length;
    }

    public String getMd5() {
        return this.f20869c;
    }

    public void setMd5(String md5) {
        this.f20869c = md5;
    }

    public String getName() {
        return this.f20870d;
    }

    public void setName(String name) {
        this.f20870d = name;
    }

    public String getAbsPath() {
        return this.f20871e;
    }

    public void setAbsPath(String absPath) {
        this.f20871e = absPath;
    }

    public String getUrl() {
        return this.f20872f;
    }

    public void setUrl(String url) {
        this.f20872f = url;
    }

    public void generateAbsPath(Context context) {
        this.f20871e = ResourceTools.getModelFileAbsName(context, this.f20870d);
    }

    public void setMap(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.f20867a = (String) map.get(C5089g.ID.m17274b());
            this.f20868b = (String) map.get(C5089g.LENGTH.m17274b());
            this.f20869c = (String) map.get(C5089g.MD5.m17274b());
            this.f20870d = (String) map.get(C5089g.NAME.m17274b());
            this.f20871e = (String) map.get(C5089g.ABS_PATH.m17274b());
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(C5089g.ID.m17274b(), this.f20867a);
            jSONObject.putOpt(C5089g.LENGTH.m17274b(), this.f20868b);
            jSONObject.putOpt(C5089g.MD5.m17274b(), this.f20869c);
            jSONObject.putOpt(C5089g.NAME.m17274b(), this.f20870d);
            jSONObject.putOpt(C5089g.ABS_PATH.m17274b(), this.f20871e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void parseJson(JSONObject jo) {
        this.f20867a = jo.optString(C5089g.ID.m17274b());
        this.f20868b = jo.optString(C5089g.LENGTH.m17274b());
        this.f20869c = jo.optString(C5089g.MD5.m17274b());
        this.f20870d = jo.optString(C5089g.NAME.m17274b());
        this.f20872f = jo.optString(C5089g.URL.m17274b());
    }
}
