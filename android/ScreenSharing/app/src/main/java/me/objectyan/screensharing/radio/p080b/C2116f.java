package com.baidu.carlife.radio.p080b;

import android.text.TextUtils;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.p080b.p103a.C2109c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: FMRecommendListRequest */
/* renamed from: com.baidu.carlife.radio.b.f */
public class C2116f extends C2110a {
    /* renamed from: c */
    private static String f6717c;
    /* renamed from: d */
    private C1843u f6718d;
    /* renamed from: e */
    private C2113m<JSONObject, MusicSongModel> f6719e = new C2114d();
    /* renamed from: f */
    private C2132v f6720f;

    /* renamed from: a */
    public String mo1770a() {
        return C2109c.m7932f();
    }

    /* renamed from: b */
    public Map<String, String> mo1768b() {
        Map<String, String> paramMap = new HashMap();
        paramMap.put("channel_id", f6717c);
        return paramMap;
    }

    /* renamed from: a */
    public void mo1775a(C2124l parameters) {
        if (TextUtils.isEmpty(parameters.m8011c()) || TextUtils.equals(parameters.m8011c(), f6717c)) {
            LogUtil.m4445e("radio_request", "channel_id is empty OR this channel_id is loading");
            return;
        }
        this.f6720f = new C2132v(this.f6719e, parameters.m8012d());
        mo1780a(parameters.m8011c());
        f6717c = parameters.m8011c();
        this.f6718d = parameters.m8012d();
        mo1769c();
    }

    /* renamed from: a */
    public void mo1771a(int statusCode, String response) {
        LogUtil.m4445e("radio_request", "statusCode = " + statusCode);
        if (statusCode == 200) {
            List<MusicSongModel> songModels = this.f6720f.m7991a(response);
            if (songModels == null || songModels.size() <= 0) {
                if (this.f6718d != null) {
                    this.f6718d.mo1693a("song list is empty");
                }
            } else if (this.f6718d != null) {
                this.f6718d.mo1694a(f6717c, songModels);
            }
        } else if (this.f6718d != null) {
            this.f6718d.mo1693a("statusCode=" + statusCode);
        }
        f6717c = null;
    }

    /* renamed from: a */
    public void mo1773a(Map<String, String> map) {
    }

    /* renamed from: a */
    public void mo1772a(String url, String error) {
        LogUtil.m4445e("radio_request", "error = " + error);
        f6717c = null;
        if (this.f6718d != null) {
            this.f6718d.mo1693a(error);
        }
    }
}
