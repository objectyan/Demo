package com.baidu.carlife.radio.b;

import android.text.TextUtils;
import com.baidu.carlife.core.i;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.b.a.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class f
  extends a
{
  private static String c;
  private u d;
  private m<JSONObject, MusicSongModel> e = new d();
  private v f;
  
  public String a()
  {
    return c.f();
  }
  
  public void a(int paramInt, String paramString)
  {
    i.e("radio_request", "statusCode = " + paramInt);
    if (paramInt == 200)
    {
      paramString = this.f.a(paramString);
      if ((paramString != null) && (paramString.size() > 0)) {
        if (this.d != null) {
          this.d.a(c, paramString);
        }
      }
    }
    for (;;)
    {
      c = null;
      return;
      if (this.d != null)
      {
        this.d.a("song list is empty");
        continue;
        if (this.d != null) {
          this.d.a("statusCode=" + paramInt);
        }
      }
    }
  }
  
  public void a(l paraml)
  {
    if ((TextUtils.isEmpty(paraml.c())) || (TextUtils.equals(paraml.c(), c)))
    {
      i.e("radio_request", "channel_id is empty OR this channel_id is loading");
      return;
    }
    this.f = new v(this.e, paraml.d());
    a(paraml.c());
    c = paraml.c();
    this.d = paraml.d();
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
    localHashMap.put("channel_id", c);
    return localHashMap;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */