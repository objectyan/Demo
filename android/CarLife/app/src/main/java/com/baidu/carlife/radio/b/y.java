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

public class y
  extends a
{
  private static String c;
  private u d;
  
  private void b(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.getInt("errno") != 0)
        {
          if (this.d != null) {
            this.d.a("errmsg=" + paramString.getString("errmsg"));
          }
        }
        else
        {
          String str2 = paramString.getString("channel_id");
          long l1 = System.currentTimeMillis();
          long l2 = this.b;
          i.c("response_time", "channel_id=" + str2 + "; response_time=" + (l1 - l2) + "ms");
          JSONArray localJSONArray = paramString.getJSONObject("data").getJSONArray("list");
          ArrayList localArrayList = new ArrayList();
          String str3 = b.a().b(str2);
          i = 0;
          int j = localJSONArray.length();
          if (i < j)
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            MusicSongModel localMusicSongModel = new MusicSongModel();
            localMusicSongModel.a(localJSONObject.getString("id"));
            String str1 = localJSONObject.getString("title");
            if (str1 != null)
            {
              paramString = str1;
              if (!str1.equals("")) {}
            }
            else
            {
              paramString = localJSONObject.getString("subtitle");
            }
            localMusicSongModel.b(paramString);
            localMusicSongModel.b(4);
            localMusicSongModel.g(str3);
            paramString = com.baidu.carlife.logic.a.c.a().b(localMusicSongModel);
            if (paramString == null) {
              break label346;
            }
            localArrayList.add(paramString);
            break label346;
          }
          if (localArrayList.size() > 0)
          {
            if (this.d == null) {
              break label345;
            }
            this.d.a(str2, localArrayList);
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
      label345:
      return;
      label346:
      i += 1;
    }
  }
  
  public String a()
  {
    return com.baidu.carlife.radio.b.a.c.d();
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */