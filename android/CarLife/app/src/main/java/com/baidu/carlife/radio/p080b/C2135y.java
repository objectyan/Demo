package com.baidu.carlife.radio.p080b;

import android.text.TextUtils;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.logic.p088a.C1685c;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.carlife.radio.p080b.p103a.C2109c;
import com.baidu.carlife.radio.p102a.C2105a;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RecommendNewsListRequest */
/* renamed from: com.baidu.carlife.radio.b.y */
public class C2135y extends C2110a {
    /* renamed from: c */
    private static String f6800c;
    /* renamed from: d */
    private C1843u f6801d;

    /* renamed from: a */
    public String mo1770a() {
        return C2109c.m7930d();
    }

    /* renamed from: b */
    public Map<String, String> mo1768b() {
        Map<String, String> paramMap = new HashMap();
        paramMap.put("channel_id", f6800c);
        return paramMap;
    }

    /* renamed from: a */
    public void mo1775a(C2124l parameters) {
        if (TextUtils.isEmpty(parameters.m8011c()) || TextUtils.equals(parameters.m8011c(), f6800c)) {
            C1260i.m4445e("radio_request", "channel_id is empty OR this channel_id is loading");
            return;
        }
        mo1780a(parameters.m8011c());
        f6800c = parameters.m8011c();
        this.f6801d = parameters.m8012d();
        mo1769c();
    }

    /* renamed from: a */
    public void mo1771a(int statusCode, String response) {
        C1260i.m4445e("radio_request", "statusCode = " + statusCode);
        f6800c = null;
        if (statusCode == 200) {
            m8058b(response);
        } else if (this.f6801d != null) {
            this.f6801d.mo1693a("statusCode=" + statusCode);
        }
    }

    /* renamed from: a */
    public void mo1773a(Map<String, String> map) {
    }

    /* renamed from: a */
    public void mo1772a(String url, String error) {
        C1260i.m4445e("radio_request", "error = " + error);
        f6800c = null;
        if (this.f6801d != null) {
            this.f6801d.mo1693a(error);
        }
    }

    /* renamed from: b */
    private void m8058b(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            if (jsonObject.getInt(C2125n.f6745M) == 0) {
                String channelId = jsonObject.getString("channel_id");
                C1260i.m4440c("response_time", "channel_id=" + channelId + "; response_time=" + (System.currentTimeMillis() - this.b) + "ms");
                JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("list");
                List<MusicSongModel> songList = new ArrayList();
                String picUrl = C2142b.m8067a().m8074b(channelId);
                int len = jsonArray.length();
                for (int i = 0; i < len; i++) {
                    jsonObject = jsonArray.getJSONObject(i);
                    MusicSongModel songModel = new MusicSongModel();
                    songModel.m7345a(jsonObject.getString("id"));
                    String title = jsonObject.getString("title");
                    if (title == null || title.equals("")) {
                        title = jsonObject.getString("subtitle");
                    }
                    songModel.m7350b(title);
                    songModel.m7348b(4);
                    songModel.m7363g(picUrl);
                    MusicSongModel song = C1685c.m6142a().m6146b(songModel);
                    if (song != null) {
                        songList.add(song);
                    }
                }
                if (songList.size() > 0) {
                    if (this.f6801d != null) {
                        this.f6801d.mo1694a(channelId, songList);
                    }
                } else if (this.f6801d != null) {
                    this.f6801d.mo1693a("song list is empty");
                }
            } else if (this.f6801d != null) {
                this.f6801d.mo1693a("errmsg=" + jsonObject.getString(C2125n.f6746N));
            }
        } catch (Exception e) {
            if (this.f6801d != null) {
                this.f6801d.mo1693a(e.toString());
            }
        }
    }

    /* renamed from: a */
    public void mo1780a(String channelId) {
        if (C1251e.m4381s() != 0) {
            StatisticManager.onEvent("CONTENT_REC_0001_REQ", "随心听请求次数");
            C2105a channelModel = C2142b.m8067a().m8077c(channelId);
            if (channelModel != null) {
                StatisticManager.onEvent(channelModel.m7899d() + "_REQ", channelModel.m7895b() + "请求次数");
            }
        }
    }
}
