package com.baidu.carlife.logic.music;

import android.os.Bundle;
import com.baidu.carlife.logic.a.j;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.radio.a.a;
import com.baidu.carlife.radio.b.g;
import org.json.JSONObject;

public class c
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  private int e = 1;
  private com.baidu.carlife.radio.b.h f = new com.baidu.carlife.radio.b.h();
  private com.baidu.carlife.radio.b.i g = new com.baidu.carlife.radio.b.i();
  private g h = new g();
  private Bundle i = new Bundle();
  private Bundle j = new Bundle();
  private String k = null;
  
  public static c a()
  {
    return a.a();
  }
  
  private void a(int paramInt, MusicSongModel paramMusicSongModel)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
    case 3: 
    case 4: 
      this.i.putString("action_type", String.valueOf(paramInt));
      long l = p.a().e();
      this.i.putString("play_time", String.valueOf(l));
      return;
    }
    this.i.putString("action_type", String.valueOf(paramInt));
    p.a().b();
  }
  
  private Bundle b(MusicSongModel paramMusicSongModel)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("action_type", this.i.getString("action_type"));
      localJSONObject.put("play_time", this.i.getString("play_time"));
      localJSONObject.put("id", paramMusicSongModel.a());
      localJSONObject.put("url", paramMusicSongModel.l());
      localJSONObject.put("title", paramMusicSongModel.b());
      localJSONObject.put("favorite", paramMusicSongModel.q() + "");
      localJSONObject.put("duration", paramMusicSongModel.i);
      this.i.putString("data_type", "news_feedback");
      this.i.putString("data", localJSONObject.toString());
      return this.i;
    }
    catch (Exception paramMusicSongModel)
    {
      for (;;)
      {
        com.baidu.carlife.core.i.b("feeder", paramMusicSongModel.getMessage());
      }
    }
  }
  
  private Bundle c(MusicSongModel paramMusicSongModel)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("favorite", String.valueOf(paramMusicSongModel.q()));
      localJSONObject.put("play_time", this.j.getString("play_time"));
      localJSONObject.put("id", paramMusicSongModel.a);
      localJSONObject.put("url", paramMusicSongModel.l());
      localJSONObject.put("title", paramMusicSongModel.b);
      localJSONObject.put("duration", paramMusicSongModel.i);
      this.j.putString("data_type", "news_favorite");
      this.j.putString("data", localJSONObject.toString());
      return this.j;
    }
    catch (Exception paramMusicSongModel)
    {
      for (;;)
      {
        com.baidu.carlife.core.i.b("feeder", paramMusicSongModel.getMessage());
      }
    }
  }
  
  private com.baidu.carlife.radio.b.h c()
  {
    return this.f;
  }
  
  private com.baidu.carlife.radio.b.i d()
  {
    return this.g;
  }
  
  public void a(int paramInt, b paramb)
  {
    this.e = paramInt;
    this.i.clear();
    paramb = h.b().i();
    String str = com.baidu.carlife.radio.c.b.a().c(j.a().c().n()).a();
    if (paramb != null)
    {
      if (paramb.p() == 999) {
        return;
      }
      this.i.putString("type", String.valueOf(paramb.q));
      this.i.putString("item_id", paramb.a);
      if ((paramb.i != null) && (!j.a().g())) {
        this.i.putString("duration", paramb.i);
      }
      if ((paramb.d != null) && (!paramb.d.isEmpty())) {
        this.i.putString("album_id", paramb.d);
      }
    }
    this.i.putString("channel_id", str);
    a(paramInt, paramb);
    if (this.k == null) {
      this.k = String.valueOf(4);
    }
    if (this.k.equals(str))
    {
      d().a(b(paramb));
      return;
    }
    c().a(this.i);
  }
  
  public void a(MusicSongModel paramMusicSongModel)
  {
    this.i.clear();
    this.j.putString("type", String.valueOf(paramMusicSongModel.q));
    String str = j.a().c().n();
    this.j.putString("channel_id", str);
    this.j.putString("item_id", paramMusicSongModel.a);
    this.j.putString("favorite", String.valueOf(paramMusicSongModel.s));
    if ((paramMusicSongModel.d != null) && (!paramMusicSongModel.d.isEmpty())) {
      this.j.putString("album_id", paramMusicSongModel.d);
    }
    if (paramMusicSongModel.i != null) {
      this.j.putString("duration", paramMusicSongModel.i);
    }
    long l = p.a().f();
    this.j.putString("play_time", String.valueOf(l));
    if (this.k == null) {
      this.k = String.valueOf(4);
    }
    if (this.k.equals(str))
    {
      d().a(c(paramMusicSongModel));
      return;
    }
    this.h.a(this.j);
  }
  
  public int b()
  {
    return this.e;
  }
  
  private static class a
  {
    private static final c a = new c(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */