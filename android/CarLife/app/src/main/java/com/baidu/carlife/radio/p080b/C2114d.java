package com.baidu.carlife.radio.p080b;

import com.baidu.carlife.logic.p088a.C1685c;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.p079c.C2142b;
import org.json.JSONObject;

/* compiled from: FMParser */
/* renamed from: com.baidu.carlife.radio.b.d */
public class C2114d implements C2113m<JSONObject, MusicSongModel> {
    /* renamed from: a */
    public MusicSongModel m7962a(JSONObject input) {
        MusicSongModel songModel = new MusicSongModel();
        songModel.m7353c(input.optInt(C2125n.f6750R));
        songModel.m7345a(input.optString("id"));
        songModel.m7367i(input.optString("url"));
        songModel.m7348b(input.optInt("type"));
        songModel.m7350b(input.optString("title"));
        songModel.m7363g(C2142b.m8067a().m8074b(String.valueOf(9)));
        return C1685c.m6142a().m6144a(songModel);
    }
}
