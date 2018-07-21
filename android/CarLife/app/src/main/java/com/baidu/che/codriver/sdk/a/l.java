package com.baidu.che.codriver.sdk.a;

import android.content.Context;
import com.baidu.che.codriver.sdk.handler.MusicCommandHandler;
import com.baidu.che.codriver.sdk.handler.a;
import com.baidu.che.codriver.sdk.handler.b;
import com.baidu.che.codriver.sdk.handler.d;
import com.baidu.che.codriver.sdk.handler.e;
import com.baidu.che.codriver.sdk.handler.f;
import com.baidu.che.codriver.sdk.handler.g;
import com.baidu.che.codriver.sdk.handler.h;
import com.baidu.che.codriver.sdk.handler.i;
import com.baidu.che.codriver.sdk.handler.j;
import java.util.HashMap;
import java.util.Map;

public class l
{
  public static final String a = "music.tool";
  public static final String b = "player.tool";
  public static final String c = "phone.tool";
  public static final String d = "tts.tool";
  public static final String e = "system.tool";
  public static final String f = "media.tool";
  public static final String g = "asr.tool";
  public static final String h = "bt.tool";
  public static final String i = "hardkey.tool";
  public static final String j = "nlp.tool";
  public static final String k = "private_radio.tool";
  private b l;
  private Map<String, a> m = new HashMap();
  
  public l()
  {
    this.m.put("music.tool", new MusicCommandHandler());
    this.m.put("player.tool", new g());
    this.m.put("phone.tool", new f());
    this.m.put("tts.tool", new j());
    this.m.put("system.tool", new i());
    this.m.put("media.tool", new d());
    this.m.put("asr.tool", new a());
    this.m.put("bt.tool", new b());
    this.m.put("hardkey.tool", new com.baidu.che.codriver.sdk.handler.c());
    this.m.put("nlp.tool", new e());
    this.m.put("private_radio.tool", new h());
  }
  
  public static l a()
  {
    return c.a();
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    if (this.l != null) {
      this.l.b(com.baidu.che.codriver.util.c.a().getPackageName(), paramString1, paramString2, paramString3);
    }
    return null;
  }
  
  public void a(b paramb)
  {
    this.l = paramb;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.l != null) {
      this.l.a(paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((this.m.get(paramString2) != null) && (this.l != null)) {
      ((a)this.m.get(paramString2)).a(paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  public static abstract interface a
  {
    public abstract String a(String paramString1, String paramString2, String paramString3, String paramString4);
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString1, String paramString2);
    
    public abstract boolean a(String paramString);
    
    public abstract String b(String paramString1, String paramString2, String paramString3, String paramString4);
  }
  
  private static class c
  {
    private static l a = new l();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */