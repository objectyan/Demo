package com.baidu.carlife.radio.p080b;

import com.baidu.carlife.logic.p088a.C1685c;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.p079c.C2142b;
import org.json.JSONObject;

/* compiled from: RadioParser */
/* renamed from: com.baidu.carlife.radio.b.q */
public class C2126q implements C2113m<JSONObject, MusicSongModel> {
    /* renamed from: a */
    public /* synthetic */ Object mo1774a(Object obj) {
        return m8016b((JSONObject) obj);
    }

    /* renamed from: b */
    public MusicSongModel m8016b(JSONObject input) {
        MusicSongModel songModel = new MusicSongModel();
        int format = input.optInt(C2125n.f6750R);
        songModel.m7353c(format);
        songModel.m7345a(input.optString("id"));
        songModel.m7367i(input.optString("url"));
        songModel.m7350b(input.optString("title"));
        songModel.m7348b(input.optInt("type"));
        songModel.m7356d(input.optInt("favorite"));
        songModel.m7363g(mo1777a(input));
        if (format == 2 || format == 3) {
            songModel.m7349b((long) (input.optInt("size") * 1024));
            songModel.m7365h(input.optString("duration"));
            if (format == 3) {
                songModel.m7357d(input.optString("album_id"));
                songModel.m7354c(input.optString(C2125n.f6756X));
                songModel.m7361f(input.optString("singer"));
            }
        }
        return C1685c.m6142a().m6144a(songModel);
    }

    /* renamed from: a */
    protected String mo1777a(JSONObject input) {
        return C2142b.m8067a().m8074b(input.optString("channel_id", "0"));
    }
}
