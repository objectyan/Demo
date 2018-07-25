package com.baidu.carlife.radio.p080b;

import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.p080b.p103a.C2109c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: RadioMusicRequest */
/* renamed from: com.baidu.carlife.radio.b.p */
public class C2128p extends C2110a {
    /* renamed from: c */
    private C2113m<JSONObject, MusicSongModel> f6785c = new C2127o();
    /* renamed from: d */
    private C2132v f6786d;
    /* renamed from: e */
    private C1843u f6787e;
    /* renamed from: f */
    private String f6788f;
    /* renamed from: g */
    private String f6789g;

    /* renamed from: b */
    public Map<String, String> mo1768b() {
        Map<String, String> paramMap = new HashMap();
        paramMap.put("channel_id", this.f6788f);
        paramMap.put(C2125n.at, this.f6789g);
        return paramMap;
    }

    /* renamed from: a */
    public void mo1772a(String url, String error) {
        LogUtil.e("radio_request", "error = " + error);
        this.f6788f = null;
        if (this.f6787e != null) {
            this.f6787e.mo1693a(error);
        }
    }

    /* renamed from: a */
    public void mo1771a(int statusCode, String response) {
        LogUtil.e("radio_request", "statusCode = " + statusCode);
        if (statusCode == 200) {
            List<MusicSongModel> songModels = this.f6786d.m7991a(response);
            if (songModels == null || songModels.size() <= 0) {
                if (this.f6787e != null) {
                    this.f6787e.mo1693a("song list is empty");
                }
            } else if (this.f6787e != null) {
                this.f6787e.mo1694a(this.f6788f, songModels);
            }
        } else if (this.f6787e != null) {
            this.f6787e.mo1693a("statusCode=" + statusCode);
        }
        this.f6788f = null;
    }

    /* renamed from: a */
    public void mo1773a(Map<String, String> map) {
    }

    /* renamed from: a */
    public String mo1770a() {
        return C2109c.m7939m();
    }

    /* renamed from: a */
    public void mo1775a(C2124l parameters) {
        if (this.f6786d == null) {
            this.f6786d = new C2132v(this.f6785c, this.f6787e);
        }
        this.f6787e = parameters.m8012d();
        this.f6788f = parameters.m8011c();
        this.f6789g = parameters.m8013e();
        mo1780a(this.f6788f);
        mo1769c();
    }
}
