package com.baidu.carlife.model;

public class q
{
  public static final String A = "nearby";
  public static final String B = "arrival";
  public static final String C = "poi_type";
  public static final String D = "player";
  public static final String E = "other";
  public static final String a = "music";
  public static final String b = "play";
  public static final String c = "music_setting";
  public static final String d = "search";
  public static final String e = "next_song";
  public static final String f = "pre_song";
  public static final String g = "pause";
  public static final String h = "play";
  public static final String i = "song";
  public static final String j = "singer";
  public static final String k = "contact";
  public static final String l = "call";
  public static final String m = "setting";
  public static final String n = "goto";
  public static final String o = "open_voice_wake";
  public static final String p = "close_voice_wake";
  public static final String q = "check_update";
  public static final String r = "open_help";
  public static final String s = "route_home";
  public static final String t = "route_work";
  public static final String u = "音乐";
  public static final String v = "首页";
  public static final String w = "地图";
  public static final String x = "电话";
  public static final String y = "map";
  public static final String z = "route";
  public String F;
  public String G;
  public String H;
  public b I;
  public a J;
  public d K;
  public c L;
  
  public q() {}
  
  public q(String paramString)
  {
    this.F = paramString;
    if (paramString.equals("music")) {
      this.I = new b();
    }
    do
    {
      return;
      if (paramString.equals("player"))
      {
        this.I = new b();
        return;
      }
      if (paramString.equals("contact"))
      {
        this.K = new d();
        return;
      }
      if (paramString.equals("setting"))
      {
        this.L = new c();
        return;
      }
    } while (!paramString.equals("map"));
    this.J = new a();
  }
  
  public String a()
  {
    return this.I.a;
  }
  
  public String b()
  {
    return this.I.b;
  }
  
  public String c()
  {
    return this.K.b;
  }
  
  public class a
  {
    public String a = "";
    public String b = "";
    public String c = "";
    
    public a() {}
  }
  
  public class b
  {
    public String a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    
    public b() {}
  }
  
  public class c
  {
    public String a = "";
    
    public c() {}
  }
  
  public class d
  {
    public String a = "";
    public String b = "";
    
    public d() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/model/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */