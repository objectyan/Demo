package com.baidu.carlife.radio.p080b;

import android.text.TextUtils;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.logic.p088a.C1685c;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.carlife.radio.p080b.p103a.C2109c;
import com.baidu.navi.protocol.model.GetPluginInfoDataStruct;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RecommendListByVoiceRequest */
/* renamed from: com.baidu.carlife.radio.b.t */
public class C2131t extends C2110a {
    /* renamed from: c */
    private static String f6792c;
    /* renamed from: d */
    private C1843u f6793d;

    /* renamed from: a */
    public String mo1770a() {
        return C2109c.m7933g();
    }

    /* renamed from: b */
    public Map<String, String> mo1768b() {
        Map<String, String> paramMap = new HashMap();
        paramMap.put("query", f6792c);
        return paramMap;
    }

    /* renamed from: a */
    public void mo1775a(C2124l parameters) {
        if (TextUtils.isEmpty(parameters.m8010b()) || TextUtils.equals(parameters.m8010b(), f6792c)) {
            C1260i.m4445e("radio_request", "query is empty OR this query is loading");
            return;
        }
        f_();
        this.f6793d = parameters.m8012d();
        f6792c = parameters.m8010b();
        List<MusicSongModel> resultList = m8033c(f6792c);
        if (resultList == null) {
            mo1769c();
        } else if (this.f6793d != null) {
            this.f6793d.mo1694a(C2142b.f6818b, resultList);
        }
    }

    /* renamed from: a */
    public void mo1771a(int statusCode, String response) {
        C1260i.m4445e("radio_request", "statusCode = " + statusCode);
        f6792c = null;
        if (statusCode == 200) {
            m8032b(response);
        } else if (this.f6793d != null) {
            this.f6793d.mo1693a("statusCode=" + statusCode);
        }
    }

    /* renamed from: a */
    public void mo1773a(Map<String, String> map) {
    }

    /* renamed from: a */
    public void mo1772a(String url, String error) {
        C1260i.m4445e("radio_request", "error = " + error);
        f6792c = null;
        if (this.f6793d != null) {
            this.f6793d.mo1693a(error);
        }
    }

    /* renamed from: b */
    private void m8032b(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            if (jsonObject.getInt(C2125n.f6745M) == 0) {
                C1260i.m4440c("response_time", "channel_id=10; response_time=" + (System.currentTimeMillis() - this.b) + "ms");
                JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("list");
                List<MusicSongModel> songList = new ArrayList();
                int len = jsonArray.length();
                for (int i = 0; i < len; i++) {
                    jsonObject = jsonArray.getJSONObject(i);
                    MusicSongModel songModel = new MusicSongModel();
                    int format = jsonObject.getInt(C2125n.f6750R);
                    if (format >= 1 && format <= 3) {
                        songModel.m7353c(format);
                        songModel.m7345a(jsonObject.getString("id"));
                        songModel.m7367i(jsonObject.getString("url"));
                        songModel.m7350b(jsonObject.getString("title"));
                        songModel.m7363g(m8030a((int) C0965R.drawable.radio_ch_cover_voice));
                        songModel.m7348b(jsonObject.optInt("type"));
                        songModel.m7356d(jsonObject.getInt("favorite"));
                        songModel.m7357d(jsonObject.optString("album_id"));
                        if (format == 2 || format == 3) {
                            songModel.m7349b((long) (jsonObject.getInt("size") * 1024));
                            if (format == 3) {
                                songModel.m7354c(jsonObject.getString(C2125n.f6756X));
                                songModel.m7361f(jsonObject.getString("singer"));
                            }
                        }
                        MusicSongModel song = C1685c.m6142a().m6144a(songModel);
                        if (song != null) {
                            songList.add(song);
                        }
                    }
                }
                if (songList.size() > 0) {
                    if (this.f6793d != null) {
                        this.f6793d.mo1694a(C2142b.f6818b, songList);
                    }
                } else if (this.f6793d != null) {
                    this.f6793d.mo1693a("song list is empty");
                }
            } else if (this.f6793d != null) {
                this.f6793d.mo1693a("errmsg=" + jsonObject.getString(C2125n.f6746N));
            }
        } catch (Exception e) {
            if (this.f6793d != null) {
                this.f6793d.mo1693a(e.toString());
            }
        }
    }

    /* renamed from: a */
    private String m8030a(int id) {
        return "res://com.baidu.carlife/" + id;
    }

    public void f_() {
        if (C1251e.m4381s() != 0) {
            StatisticManager.onEvent("CONTENT_REC_0001_REQ", "随心听请求次数");
            StatisticManager.onEvent("CONTENT_REC_0011_REQ", "语音点播请求次数");
        }
    }

    /* renamed from: c */
    private List<MusicSongModel> m8033c(String newsParam) {
        if (newsParam == null || !newsParam.contains("type") || !newsParam.contains("news")) {
            return null;
        }
        List<MusicSongModel> songList = new ArrayList();
        try {
            JSONObject jsonObject = new JSONObject(newsParam);
            if (jsonObject.has("result_list")) {
                JSONArray resultList = jsonObject.getJSONArray("result_list");
                for (int i = 0; i < resultList.length(); i++) {
                    List<MusicSongModel> list = m8031a(resultList.getJSONObject(i));
                    if (list != null || list.size() > 0) {
                        songList.addAll(list);
                    }
                }
            } else {
                songList = m8031a(jsonObject);
            }
        } catch (Exception e) {
            C1260i.m4435b("Voice parseNewsParam error:", e.getMessage());
        }
        if (songList == null || songList.size() < 1) {
            return null;
        }
        return songList;
    }

    /* renamed from: a */
    private List<MusicSongModel> m8031a(JSONObject jsonObject) throws JSONException {
        JSONArray jsonResultArray = jsonObject.getJSONObject("merged_res").getJSONObject("semantic_form").getJSONArray("results");
        List<MusicSongModel> songList = new ArrayList();
        for (int j = 0; j < jsonResultArray.length(); j++) {
            JSONObject jsonResultObj = jsonResultArray.getJSONObject(j).getJSONObject("object");
            if ("新闻".equals(jsonResultObj.getString("type"))) {
                JSONArray jsonArray = jsonResultObj.getJSONArray("news");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonNews = jsonArray.getJSONObject(i);
                    MusicSongModel songModel = new MusicSongModel();
                    String name = null;
                    if (jsonNews.has("title")) {
                        name = jsonNews.getString("title");
                    }
                    if ((name == null || name.equals("")) && jsonNews.has(GetPluginInfoDataStruct.KEY_SUMMARY)) {
                        name = jsonNews.getString(GetPluginInfoDataStruct.KEY_SUMMARY);
                    }
                    if ((name == null || name.equals("")) && jsonNews.has("site")) {
                        name = jsonNews.getString("site");
                    }
                    songModel.m7350b(name);
                    songModel.m7367i(jsonNews.getString("url"));
                    songModel.m7363g(m8030a((int) C0965R.drawable.radio_ch_cover_voice));
                    if (!(songModel.m7371l() == null || songModel.m7371l().equals(""))) {
                        songList.add(songModel);
                    }
                }
            }
        }
        return songList;
    }
}
