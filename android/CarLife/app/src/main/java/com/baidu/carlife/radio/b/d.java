package com.baidu.carlife.radio.b;

import com.baidu.carlife.logic.a.c;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.c.b;
import org.json.JSONObject;

public class d
  implements m<JSONObject, MusicSongModel>
{
  public MusicSongModel a(JSONObject paramJSONObject)
  {
    MusicSongModel localMusicSongModel = new MusicSongModel();
    localMusicSongModel.c(paramJSONObject.optInt("format"));
    localMusicSongModel.a(paramJSONObject.optString("id"));
    localMusicSongModel.i(paramJSONObject.optString("url"));
    localMusicSongModel.b(paramJSONObject.optInt("type"));
    localMusicSongModel.b(paramJSONObject.optString("title"));
    localMusicSongModel.g(b.a().b(String.valueOf(9)));
    return c.a().a(localMusicSongModel);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */