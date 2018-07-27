package com.baidu.carlife.radio.p080b;

import com.baidu.carlife.model.MusicSongModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RecommendListParser */
/* renamed from: com.baidu.carlife.radio.b.v */
public class C2132v extends C2120j<MusicSongModel> {
    /* renamed from: a */
    private C1843u f6794a;

    public C2132v(C2113m<JSONObject, MusicSongModel> objectParser, C1843u mCallback) {
        super(objectParser);
        this.f6794a = mCallback;
    }

    /* renamed from: a */
    protected List<MusicSongModel> mo1779a(JSONObject jsonObject) {
        List<MusicSongModel> songModels = null;
        try {
            if (jsonObject.getInt(C2125n.f6745M) == 0) {
                songModels = m8040b(jsonObject);
            } else if (this.f6794a != null) {
                this.f6794a.mo1693a("errmsg=" + jsonObject.getString(C2125n.f6746N));
            }
        } catch (Exception e) {
            if (this.f6794a != null) {
                this.f6794a.mo1693a(e.toString());
            }
        }
        return songModels;
    }

    /* renamed from: b */
    private List<MusicSongModel> m8040b(JSONObject jsonObject) throws JSONException {
        JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("list");
        List<MusicSongModel> songList = new ArrayList();
        int len = jsonArray.length();
        for (int i = 0; i < len; i++) {
            MusicSongModel songModel = (MusicSongModel) m7989a().mo1774a(jsonArray.getJSONObject(i));
            if (songModel != null) {
                songList.add(songModel);
            }
        }
        return songList;
    }
}
