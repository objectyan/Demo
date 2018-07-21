package com.baidu.carlife.radio.b;

import com.baidu.carlife.core.i;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.b.a.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class p
  extends a
{
  private m<JSONObject, MusicSongModel> c = new o();
  private v d;
  private u e;
  private String f;
  private String g;
  
  public String a()
  {
    return c.m();
  }
  
  public void a(int paramInt, String paramString)
  {
    i.e("radio_request", "statusCode = " + paramInt);
    if (paramInt == 200)
    {
      paramString = this.d.a(paramString);
      if ((paramString != null) && (paramString.size() > 0)) {
        if (this.e != null) {
          this.e.a(this.f, paramString);
        }
      }
    }
    for (;;)
    {
      this.f = null;
      return;
      if (this.e != null)
      {
        this.e.a("song list is empty");
        continue;
        if (this.e != null) {
          this.e.a("statusCode=" + paramInt);
        }
      }
    }
  }
  
  public void a(l paraml)
  {
    if (this.d == null) {
      this.d = new v(this.c, this.e);
    }
    this.e = paraml.d();
    this.f = paraml.c();
    this.g = paraml.e();
    a(this.f);
    c();
  }
  
  public void a(String paramString1, String paramString2)
  {
    i.e("radio_request", "error = " + paramString2);
    this.f = null;
    if (this.e != null) {
      this.e.a(paramString2);
    }
  }
  
  public void a(Map<String, String> paramMap) {}
  
  public Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("channel_id", this.f);
    localHashMap.put("control_state", this.g);
    return localHashMap;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */