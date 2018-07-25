package com.baidu.carlife.radio.p080b;

import android.text.TextUtils;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.carlife.radio.p080b.p103a.C2109c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: FMRecommendByVoiceRequest */
/* renamed from: com.baidu.carlife.radio.b.e */
public class C2115e extends C2110a {
    /* renamed from: c */
    private static String f6713c;
    /* renamed from: d */
    private C1843u f6714d;
    /* renamed from: e */
    private C2113m<JSONObject, MusicSongModel> f6715e = new C2114d();
    /* renamed from: f */
    private C2132v f6716f;

    /* renamed from: a */
    public String mo1770a() {
        return C2109c.m7933g();
    }

    /* renamed from: b */
    public Map<String, String> mo1768b() {
        Map<String, String> paramMap = new HashMap();
        paramMap.put("query", f6713c);
        return paramMap;
    }

    /* renamed from: a */
    public void mo1775a(C2124l parameters) {
        if (TextUtils.isEmpty(parameters.m8010b()) || TextUtils.equals(parameters.m8010b(), f6713c)) {
            LogUtil.e("radio_request", "query is empty OR this query is loading");
            return;
        }
        f_();
        this.f6716f = new C2132v(this.f6715e, parameters.m8012d());
        this.f6714d = parameters.m8012d();
        f6713c = parameters.m8010b();
        mo1769c();
    }

    /* renamed from: a */
    public void mo1771a(int statusCode, String response) {
        LogUtil.e("radio_request", "statusCode = " + statusCode);
        f6713c = null;
        if (statusCode == 200) {
            List<MusicSongModel> songList = this.f6716f.m7991a(response);
            if (songList == null || songList.size() <= 0) {
                if (this.f6714d != null) {
                    this.f6714d.mo1693a("song list is empty");
                }
            } else if (this.f6714d != null) {
                this.f6714d.mo1694a(C2142b.f6818b, songList);
            }
        } else if (this.f6714d != null) {
            this.f6714d.mo1693a("statusCode=" + statusCode);
        }
    }

    /* renamed from: a */
    public void mo1773a(Map<String, String> map) {
    }

    /* renamed from: a */
    public void mo1772a(String url, String error) {
        LogUtil.e("radio_request", "error = " + error);
        f6713c = null;
        if (this.f6714d != null) {
            this.f6714d.mo1693a(error);
        }
    }
}
