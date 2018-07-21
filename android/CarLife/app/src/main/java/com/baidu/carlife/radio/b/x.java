package com.baidu.carlife.radio.b;

import android.text.TextUtils;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.i;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.b.a.c;
import com.baidu.carlife.radio.c.b;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class x
  extends a
{
  private static String c;
  private static String d;
  private u e;
  
  private void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.getInt("errno") != 0)
      {
        if (this.e != null) {
          this.e.a("errmsg=" + paramString.getString("errmsg"));
        }
      }
      else
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.b;
        i.c("response_time", "response_time=" + (l1 - l2) + "ms");
        Object localObject = paramString.getJSONObject("data");
        paramString = new MusicSongModel();
        paramString.a(((JSONObject)localObject).getString("id"));
        paramString.i(((JSONObject)localObject).getString("url"));
        if (paramString.l() != null)
        {
          if (this.e == null) {
            return;
          }
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramString);
          this.e.a(c, (List)localObject);
        }
      }
    }
    catch (Exception paramString)
    {
      if (this.e != null)
      {
        this.e.a(paramString.toString());
        return;
        if (this.e != null) {
          this.e.a("song list is empty");
        }
      }
    }
  }
  
  public String a()
  {
    return c.e();
  }
  
  public void a(int paramInt, String paramString)
  {
    i.e("radio_request", "statusCode = " + paramInt);
    d = null;
    if (paramInt == 200) {
      b(paramString);
    }
    while (this.e == null) {
      return;
    }
    this.e.a("statusCode=" + paramInt);
  }
  
  public void a(l paraml)
  {
    if (TextUtils.isEmpty(paraml.c()))
    {
      i.e("radio_request", "channel_id is empty ");
      return;
    }
    if ((TextUtils.isEmpty(paraml.a())) || (TextUtils.equals(paraml.a(), d)))
    {
      i.e("radio_request", "id is empty OR this song id is loading");
      return;
    }
    a(paraml.c());
    c = paraml.c();
    d = paraml.a();
    this.e = paraml.d();
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
    d = null;
    if (this.e != null) {
      this.e.a(paramString2);
    }
  }
  
  public void a(Map<String, String> paramMap) {}
  
  public Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("channel_id", c);
    localHashMap.put("id", d);
    return localHashMap;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */