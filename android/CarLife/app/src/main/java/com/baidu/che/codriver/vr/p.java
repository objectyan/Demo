package com.baidu.che.codriver.vr;

import org.json.JSONObject;

public class p
{
  public static final String A = "route_home";
  public static final String B = "route_work";
  public static final String C = "nearby";
  public static final String D = "poi";
  public static final String E = "select";
  public static final String F = "call";
  public static final String G = "open";
  public static final String H = "close";
  public static final String I = "save";
  public static final String J = "volume_up";
  public static final String K = "volume_down";
  public static final String L = "volume_up_max";
  public static final String M = "volume_down_min";
  public static final String N = "light_up";
  public static final String O = "light_down";
  public static final String P = "light_down_min";
  public static final String Q = "light_up_max";
  public static final String R = "yes";
  public static final String S = "no";
  public static final String T = "quit";
  public static final String U = "next";
  public static final String V = "back";
  public static final String W = "addWakeUpWord";
  public static final String X = "wakeup";
  public static final String Y = "customCmd";
  public static final String Z = "set_home";
  public static final int a = 0;
  public static final String aA = "goto_music_local";
  public static final String aB = "goto_music_qq";
  public static final String aC = "goto_netease";
  public static final String aD = "goto_music_xmly";
  public static final String aE = "goto_music_kaola";
  public static final String aF = "goto_music_chyb";
  public static final String aG = "goto_music_chinese_fm";
  public static final String aH = "download_music";
  public static final String aI = "synchronize_music";
  public static final String aJ = "download";
  public static final String aK = "sync";
  public static final String aL = "number";
  public static final String aM = "name";
  public static final String aN = "words";
  public static final String aO = "name";
  public static final String aP = "wakeupWords";
  public static final String aQ = "wechat_name";
  public static final String aR = "wechat_id";
  public static final String aS = "nlp_next";
  public static final String aT = "nlp_pre";
  public static final String aU = "nlp_click";
  public static final String aV = "phone_nlp_number";
  public static final String aa = "set_work";
  public static final String ab = "navigate";
  public static final String ac = "start_navigate";
  public static final String ad = "switch";
  public static final String ae = "tune";
  public static final String af = "set";
  public static final String ag = "set_ac";
  public static final String ah = "heat";
  public static final String ai = "login";
  public static final String aj = "logout";
  public static final String ak = "send";
  public static final String al = "listen";
  public static final String am = "location";
  public static final String an = "goto_contacts";
  public static final String ao = "goto_call_record";
  public static final String ap = "goto_item_discover";
  public static final String aq = "goto_item_park";
  public static final String ar = "goto_item_discover_food";
  public static final String as = "goto_item_fuel";
  public static final String at = "goto_item_rescue";
  public static final String au = "goto_item_ind_center";
  public static final String av = "goto_navi_set";
  public static final String aw = "goto_vr_Set";
  public static final String ax = "goto_journey_Set";
  public static final String ay = "goto_help";
  public static final String az = "goto_about";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final String f = "domain";
  public static final String g = "intent";
  public static final String h = "object";
  public static final String i = "data";
  public static final String j = "calendar";
  public static final String k = "map";
  public static final String l = "navigate_instruction";
  public static final String m = "telephone";
  public static final String n = "music";
  public static final String o = "player";
  public static final String p = "codriver";
  public static final String q = "carlife";
  public static final String r = "app";
  public static final String s = "flight";
  public static final String t = "train";
  public static final String u = "hotel";
  public static final String v = "wechat";
  public static final String w = "other";
  public static final String x = "radio";
  public static final String y = "sound_program";
  public static final String z = "route";
  private String aW;
  private String aX;
  private String aY;
  private String aZ;
  private String ba;
  private String bb;
  private float bc;
  private int bd;
  
  public int a()
  {
    return this.bd;
  }
  
  public void a(float paramFloat)
  {
    this.bc = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.bd = paramInt;
  }
  
  public void a(String paramString)
  {
    this.aW = paramString;
  }
  
  public String b()
  {
    return this.aW;
  }
  
  public void b(String paramString)
  {
    this.aX = paramString;
  }
  
  public String c()
  {
    return this.aX;
  }
  
  public void c(String paramString)
  {
    this.aY = paramString;
  }
  
  public String d()
  {
    return this.aY;
  }
  
  public void d(String paramString)
  {
    this.aZ = paramString;
  }
  
  public String e()
  {
    return this.aZ;
  }
  
  public void e(String paramString)
  {
    this.ba = paramString;
  }
  
  public float f()
  {
    return this.bc;
  }
  
  public void f(String paramString)
  {
    this.bb = paramString;
  }
  
  public String g()
  {
    return this.ba;
  }
  
  public String h()
  {
    return this.bb;
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("text", this.aZ);
      ((JSONObject)localObject).put("errno", this.bd);
      ((JSONObject)localObject).put("domain", this.aW);
      ((JSONObject)localObject).put("intent", this.aX);
      ((JSONObject)localObject).put("object", this.aY);
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */