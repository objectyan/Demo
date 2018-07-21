package com.baidu.carlife.radio.b;

import com.baidu.carlife.logic.a.c;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.c.b;
import org.json.JSONObject;

public class q
  implements m<JSONObject, MusicSongModel>
{
  protected String a(JSONObject paramJSONObject)
  {
    return b.a().b(paramJSONObject.optString("channel_id", "0"));
  }
  
  public MusicSongModel b(JSONObject paramJSONObject)
  {
    MusicSongModel localMusicSongModel = new MusicSongModel();
    int i = paramJSONObject.optInt("format");
    localMusicSongModel.c(i);
    localMusicSongModel.a(paramJSONObject.optString("id"));
    localMusicSongModel.i(paramJSONObject.optString("url"));
    localMusicSongModel.b(paramJSONObject.optString("title"));
    localMusicSongModel.b(paramJSONObject.optInt("type"));
    localMusicSongModel.d(paramJSONObject.optInt("favorite"));
    localMusicSongModel.g(a(paramJSONObject));
    if ((i == 2) || (i == 3))
    {
      localMusicSongModel.b(paramJSONObject.optInt("size") * 1024);
      localMusicSongModel.h(paramJSONObject.optString("duration"));
      if (i == 3)
      {
        localMusicSongModel.d(paramJSONObject.optString("album_id"));
        localMusicSongModel.c(paramJSONObject.optString("album"));
        localMusicSongModel.f(paramJSONObject.optString("singer"));
      }
    }
    return c.a().a(localMusicSongModel);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */