package com.baidu.carlife.radio.p080b;

import android.text.TextUtils;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.carlife.radio.p080b.p103a.C2109c;
import com.baidu.carlife.radio.p102a.C2105a;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: RecommendNewsDetailRequest */
/* renamed from: com.baidu.carlife.radio.b.x */
public class C2134x extends C2110a {
    /* renamed from: c */
    private static String f6797c;
    /* renamed from: d */
    private static String f6798d;
    /* renamed from: e */
    private C1843u f6799e;

    /* renamed from: a */
    public String mo1770a() {
        return C2109c.m7931e();
    }

    /* renamed from: b */
    public Map<String, String> mo1768b() {
        Map<String, String> paramMap = new HashMap();
        paramMap.put("channel_id", f6797c);
        paramMap.put("id", f6798d);
        return paramMap;
    }

    /* renamed from: a */
    public void mo1775a(C2124l parameters) {
        if (TextUtils.isEmpty(parameters.m8011c())) {
            LogUtil.e("radio_request", "channel_id is empty ");
        } else if (TextUtils.isEmpty(parameters.m8009a()) || TextUtils.equals(parameters.m8009a(), f6798d)) {
            LogUtil.e("radio_request", "id is empty OR this song id is loading");
        } else {
            mo1780a(parameters.m8011c());
            f6797c = parameters.m8011c();
            f6798d = parameters.m8009a();
            this.f6799e = parameters.m8012d();
            mo1769c();
        }
    }

    /* renamed from: a */
    public void mo1771a(int statusCode, String response) {
        LogUtil.e("radio_request", "statusCode = " + statusCode);
        f6798d = null;
        if (statusCode == 200) {
            m8050b(response);
        } else if (this.f6799e != null) {
            this.f6799e.mo1693a("statusCode=" + statusCode);
        }
    }

    /* renamed from: a */
    public void mo1773a(Map<String, String> map) {
    }

    /* renamed from: a */
    public void mo1772a(String url, String error) {
        LogUtil.e("radio_request", "error = " + error);
        f6798d = null;
        if (this.f6799e != null) {
            this.f6799e.mo1693a(error);
        }
    }

    /* renamed from: b */
    private void m8050b(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            if (jsonObject.getInt(C2125n.f6745M) == 0) {
                LogUtil.m4440c("response_time", "response_time=" + (System.currentTimeMillis() - this.b) + "ms");
                JSONObject jsonDetail = jsonObject.getJSONObject("data");
                MusicSongModel songModel = new MusicSongModel();
                songModel.m7345a(jsonDetail.getString("id"));
                songModel.m7367i(jsonDetail.getString("url"));
                if (songModel.m7371l() != null) {
                    if (this.f6799e != null) {
                        ArrayList<MusicSongModel> list = new ArrayList();
                        list.add(songModel);
                        this.f6799e.mo1694a(f6797c, list);
                    }
                } else if (this.f6799e != null) {
                    this.f6799e.mo1693a("song list is empty");
                }
            } else if (this.f6799e != null) {
                this.f6799e.mo1693a("errmsg=" + jsonObject.getString(C2125n.f6746N));
            }
        } catch (Exception e) {
            if (this.f6799e != null) {
                this.f6799e.mo1693a(e.toString());
            }
        }
    }

    /* renamed from: a */
    public void mo1780a(String channelId) {
        if (CarlifeUtil.m4381s() != 0) {
            StatisticManager.onEvent("CONTENT_REC_0001_REQ", "随心听请求次数");
            C2105a channelModel = C2142b.m8067a().m8077c(channelId);
            if (channelModel != null) {
                StatisticManager.onEvent(channelModel.m7899d() + "_REQ", channelModel.m7895b() + "请求次数");
            }
        }
    }
}
