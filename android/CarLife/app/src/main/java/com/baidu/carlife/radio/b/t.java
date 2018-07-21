package com.baidu.carlife.radio.b;

import android.text.TextUtils;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.i;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class t
  extends a
{
  private static String c;
  private u d;
  
  private String a(int paramInt)
  {
    return "res://com.baidu.carlife/" + paramInt;
  }
  
  private List<MusicSongModel> a(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONArray localJSONArray1 = paramJSONObject.getJSONObject("merged_res").getJSONObject("semantic_form").getJSONArray("results");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localJSONArray1.length())
    {
      paramJSONObject = localJSONArray1.getJSONObject(i).getJSONObject("object");
      if ("新闻".equals(paramJSONObject.getString("type")))
      {
        JSONArray localJSONArray2 = paramJSONObject.getJSONArray("news");
        int j = 0;
        while (j < localJSONArray2.length())
        {
          JSONObject localJSONObject = localJSONArray2.getJSONObject(j);
          MusicSongModel localMusicSongModel = new MusicSongModel();
          Object localObject = null;
          if (localJSONObject.has("title")) {
            localObject = localJSONObject.getString("title");
          }
          if (localObject != null)
          {
            paramJSONObject = (JSONObject)localObject;
            if (!((String)localObject).equals("")) {}
          }
          else
          {
            paramJSONObject = (JSONObject)localObject;
            if (localJSONObject.has("summary")) {
              paramJSONObject = localJSONObject.getString("summary");
            }
          }
          if (paramJSONObject != null)
          {
            localObject = paramJSONObject;
            if (!paramJSONObject.equals("")) {}
          }
          else
          {
            localObject = paramJSONObject;
            if (localJSONObject.has("site")) {
              localObject = localJSONObject.getString("site");
            }
          }
          localMusicSongModel.b((String)localObject);
          localMusicSongModel.i(localJSONObject.getString("url"));
          localMusicSongModel.g(a(2130839326));
          if ((localMusicSongModel.l() != null) && (!localMusicSongModel.l().equals(""))) {
            localArrayList.add(localMusicSongModel);
          }
          j += 1;
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
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
          long l1 = System.currentTimeMillis();
          long l2 = this.b;
          i.c("response_time", "channel_id=10; response_time=" + (l1 - l2) + "ms");
          paramString = paramString.getJSONObject("data").getJSONArray("list");
          ArrayList localArrayList = new ArrayList();
          i = 0;
          int j = paramString.length();
          if (i < j)
          {
            Object localObject = paramString.getJSONObject(i);
            MusicSongModel localMusicSongModel = new MusicSongModel();
            int k = ((JSONObject)localObject).getInt("format");
            if ((k < 1) || (k > 3)) {
              break label422;
            }
            localMusicSongModel.c(k);
            localMusicSongModel.a(((JSONObject)localObject).getString("id"));
            localMusicSongModel.i(((JSONObject)localObject).getString("url"));
            localMusicSongModel.b(((JSONObject)localObject).getString("title"));
            localMusicSongModel.g(a(2130839326));
            localMusicSongModel.b(((JSONObject)localObject).optInt("type"));
            localMusicSongModel.d(((JSONObject)localObject).getInt("favorite"));
            localMusicSongModel.d(((JSONObject)localObject).optString("album_id"));
            if ((k == 2) || (k == 3))
            {
              localMusicSongModel.b(((JSONObject)localObject).getInt("size") * 1024);
              if (k == 3)
              {
                localMusicSongModel.c(((JSONObject)localObject).getString("album"));
                localMusicSongModel.f(((JSONObject)localObject).getString("singer"));
              }
            }
            localObject = com.baidu.carlife.logic.a.c.a().a(localMusicSongModel);
            if (localObject == null) {
              break label422;
            }
            localArrayList.add(localObject);
            break label422;
          }
          if (localArrayList.size() > 0)
          {
            if (this.d == null) {
              break label421;
            }
            this.d.a("10", localArrayList);
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
      label421:
      return;
      label422:
      i += 1;
    }
  }
  
  private List<MusicSongModel> c(String paramString)
  {
    if ((paramString == null) || (!paramString.contains("type")) || (!paramString.contains("news"))) {
      localObject = null;
    }
    label108:
    do
    {
      return (List<MusicSongModel>)localObject;
      localObject = new ArrayList();
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.has("result_list")) {
          break label108;
        }
        localJSONArray = paramString.getJSONArray("result_list");
        i = 0;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          JSONArray localJSONArray;
          int i;
          i.b("Voice parseNewsParam error:", paramString.getMessage());
          paramString = (String)localObject;
          continue;
          i += 1;
        }
      }
      paramString = (String)localObject;
      if (i < localJSONArray.length())
      {
        paramString = a(localJSONArray.getJSONObject(i));
        if ((paramString == null) && (paramString.size() <= 0)) {
          break label147;
        }
        ((List)localObject).addAll(paramString);
        break label147;
        paramString = a(paramString);
      }
      if (paramString == null) {
        break;
      }
      localObject = paramString;
    } while (paramString.size() >= 1);
    return null;
  }
  
  public String a()
  {
    return com.baidu.carlife.radio.b.a.c.g();
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
    if ((TextUtils.isEmpty(paraml.b())) || (TextUtils.equals(paraml.b(), c))) {
      i.e("radio_request", "query is empty OR this query is loading");
    }
    do
    {
      return;
      f_();
      this.d = paraml.d();
      c = paraml.b();
      paraml = c(c);
      if (paraml == null) {
        break;
      }
    } while (this.d == null);
    this.d.a("10", paraml);
    return;
    c();
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
    localHashMap.put("query", c);
    return localHashMap;
  }
  
  public void f_()
  {
    if (e.s() != 0)
    {
      StatisticManager.onEvent("CONTENT_REC_0001_REQ", "随心听请求次数");
      StatisticManager.onEvent("CONTENT_REC_0011_REQ", "语音点播请求次数");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */