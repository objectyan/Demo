package com.baidu.carlife.wechat.e;

import android.text.TextUtils;
import com.baidu.carlife.wechat.b.j;
import java.net.URLEncoder;

public final class c
{
  public static void a()
  {
    a.b = "wx.qq.com";
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a.b = paramString;
    }
  }
  
  public static final String b()
  {
    return ("https://" + a.b() + "/jslogin?appid=wx782c26e4c19acffb&redirect_uri=" + k() + "&fun=new&lang=zh_CN&_={timestamp}").replace("{timestamp}", String.valueOf(System.currentTimeMillis()));
  }
  
  public static final String b(String paramString)
  {
    return "https://login.weixin.qq.com/l/" + paramString;
  }
  
  public static final String c()
  {
    String str = "https://" + a.a() + "/cgi-bin/mmwebwx-bin/webwxinit?r={r}&lang={lang}&pass_ticket={pass_ticket}";
    j localj = com.baidu.carlife.wechat.b.c.a().g();
    return str.replace("{pass_ticket}", localj.f()).replace("{r}", String.valueOf(System.currentTimeMillis() ^ 0xFFFFFFFFFFFFFFFF)).replace("{lang}", localj.g());
  }
  
  public static final String c(String paramString)
  {
    return ("https://" + a.b() + "/cgi-bin/mmwebwx-bin/login?loginicon=true&uuid={uuid}&tip=0&r={r}&_={timestamp}").replace("{uuid}", paramString).replace("{r}", String.valueOf(System.currentTimeMillis() ^ 0xFFFFFFFFFFFFFFFF)).replace("{timestamp}", String.valueOf(System.currentTimeMillis()));
  }
  
  public static final String d()
  {
    return ("https://" + a.a() + "/cgi-bin/mmwebwx-bin/webwxbatchgetcontact?r={timestamp}&type=ex").replace("{timestamp}", String.valueOf(System.currentTimeMillis()));
  }
  
  public static final String d(String paramString)
  {
    String str = "https://" + a.a() + "/cgi-bin/mmwebwx-bin/webwxgetcontact?r={timestamp}&seq={seq}&skey={skey}&pass_ticket={pass_ticket}&lang={lang}";
    j localj = com.baidu.carlife.wechat.b.c.a().g();
    return str.replace("{pass_ticket}", localj.f()).replace("{timestamp}", String.valueOf(System.currentTimeMillis())).replace("{skey}", localj.a()).replace("{seq}", paramString).replace("{lang}", localj.g());
  }
  
  public static final String e()
  {
    String str = "https://" + a.a() + "/cgi-bin/mmwebwx-bin/webwxsendmsg?lang={lang}&pass_ticket={pass_ticket}";
    j localj = com.baidu.carlife.wechat.b.c.a().g();
    return str.replace("{pass_ticket}", localj.f()).replace("{lang}", localj.g());
  }
  
  public static final String f()
  {
    String str = "https://" + a.d() + "/cgi-bin/mmwebwx-bin/synccheck?r={r}&skey={skey}&sid={sid}&uin={uin}&deviceid={deviceid}&synckey={synckey}&_={timestamp}";
    j localj = com.baidu.carlife.wechat.b.c.a().g();
    return str.replace("{r}", String.valueOf(System.currentTimeMillis() ^ 0xFFFFFFFFFFFFFFFF)).replace("{skey}", localj.a()).replace("{sid}", localj.b().replaceAll("\\+", "%2B")).replace("{uin}", localj.c()).replace("{deviceid}", com.baidu.carlife.wechat.g.c.b()).replace("{synckey}", com.baidu.carlife.wechat.b.c.a().l()).replace("{timestamp}", String.valueOf(System.currentTimeMillis()));
  }
  
  public static final String g()
  {
    String str = "https://" + a.a() + "/cgi-bin/mmwebwx-bin/webwxsync?skey={skey}&sid={sid}&pass_ticket={pass_ticket}&lang={lang}";
    j localj = com.baidu.carlife.wechat.b.c.a().g();
    return str.replace("{skey}", localj.a()).replace("{sid}", localj.b().replaceAll("\\+", "%2B")).replace("{pass_ticket}", localj.f()).replace("{lang}", localj.g());
  }
  
  public static final String h()
  {
    return ("https://" + a.a() + "/cgi-bin/mmwebwx-bin/webwxlogout?redirect=1&type=0&skey={skey}").replace("{skey}", com.baidu.carlife.wechat.b.c.a().g().a());
  }
  
  public static final String i()
  {
    return "https://" + a.a();
  }
  
  public static final String j()
  {
    return "https://" + a.a();
  }
  
  private static String k()
  {
    try
    {
      String str = URLEncoder.encode("https://" + a.a() + "/cgi-bin/mmwebwx-bin/webwxnewloginpage", "UTF-8");
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "https%3A%2F%2F" + a.a() + "%2Fcgi-bin%2Fmmwebwx-bin%2Fwebwxnewloginpage";
  }
  
  static final class a
  {
    public static final String a = "wx.qq.com";
    static String b = "wx.qq.com";
    
    static String a()
    {
      return b;
    }
    
    static String b()
    {
      return "login." + a();
    }
    
    static String c()
    {
      return "file." + a();
    }
    
    static String d()
    {
      return "webpush." + a();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */