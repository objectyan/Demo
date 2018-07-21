package com.baidu.carlife.radio.b;

import android.text.TextUtils;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.i;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.c.b;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class w
  extends a
{
  private static String c;
  private u d;
  
  private void b(String paramString)
  {
    for (;;)
    {
      int i;
      int k;
      try
      {
        Object localObject1 = new JSONObject(paramString);
        if (((JSONObject)localObject1).getInt("errno") != 0)
        {
          if (this.d != null) {
            this.d.a("errmsg=" + ((JSONObject)localObject1).getString("errmsg"));
          }
        }
        else
        {
          paramString = ((JSONObject)localObject1).getString("channel_id");
          long l1 = System.currentTimeMillis();
          long l2 = this.b;
          i.c("response_time", "channel_id=" + paramString + "; response_time=" + (l1 - l2) + "ms");
          localObject1 = ((JSONObject)localObject1).getJSONObject("data").getJSONArray("list");
          ArrayList localArrayList = new ArrayList();
          i = 0;
          int j = ((JSONArray)localObject1).length();
          if (i < j)
          {
            Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
            MusicSongModel localMusicSongModel = new MusicSongModel();
            k = ((JSONObject)localObject2).getInt("format");
            if ((k < 1) || (k > 3)) {
              break label449;
            }
            localMusicSongModel.c(k);
            localMusicSongModel.a(((JSONObject)localObject2).getString("id"));
            localMusicSongModel.i(((JSONObject)localObject2).getString("url"));
            localMusicSongModel.b(((JSONObject)localObject2).optInt("type"));
            localMusicSongModel.g(b.a().b(paramString));
            localMusicSongModel.b(((JSONObject)localObject2).optString("title"));
            localMusicSongModel.d(((JSONObject)localObject2).optInt("favorite"));
            localMusicSongModel.d(((JSONObject)localObject2).optString("album_id"));
            if ((k == 2) || (k == 3))
            {
              localMusicSongModel.b(((JSONObject)localObject2).getInt("size") * 1024);
              if (k == 3)
              {
                localMusicSongModel.c(((JSONObject)localObject2).getString("album"));
                localMusicSongModel.f(((JSONObject)localObject2).getString("singer"));
              }
            }
            localObject2 = com.baidu.carlife.logic.a.c.a().a(localMusicSongModel);
            if (localObject2 == null) {
              break label460;
            }
            localArrayList.add(localObject2);
            break label460;
          }
          if (localArrayList.size() > 0)
          {
            if (this.d == null) {
              break label448;
            }
            this.d.a(paramString, localArrayList);
          }
        }
      }
      catch (Exception paramString)
      {
        if (this.d != null)
        {
          this.d.a(paramString.toString());
          return;
          if (this.d != null) {
            this.d.a("song list is empty");
          }
        }
      }
      label448:
      return;
      label449:
      if (k != 999) {
        label460:
        i += 1;
      }
    }
  }
  
  public String a()
  {
    return com.baidu.carlife.radio.b.a.c.f();
  }
  
  public void a(int paramInt, String paramString)
  {
    i.e("radio_request", "statusCode = " + paramInt);
    c = null;
    if (paramInt == 200) {
      b(paramString);
    }
    while (this.d == null) {
      return;
    }
    this.d.a("statusCode=" + paramInt);
  }
  
  public void a(l paraml)
  {
    if ((TextUtils.isEmpty(paraml.c())) || (TextUtils.equals(paraml.c(), c)))
    {
      i.e("radio_request", "channel_id is empty OR this channel_id is loading");
      return;
    }
    a(paraml.c());
    c = paraml.c();
    this.d = paraml.d();
    c();
  }
  
  public void a(String paramString)
  {
    if (e.s() != 0)
    {
      StatisticManager.onEvent("CONTENT_REC_0001_REQ", "随心听请求次数");
      paramString = b.a().c(paramString);
      if (paramString != null) {
        StatisticManager.onEvent(paramString.d() + "_REQ", paramString.b() + "请求次数");
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    i.e("radio_request", "error = " + paramString2);
    c = null;
    if (this.d != null) {
      this.d.a(paramString2);
    }
  }
  
  public void a(Map<String, String> paramMap) {}
  
  public Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("channel_id", c);
    return localHashMap;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */