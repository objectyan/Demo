package com.baidu.carlife.wechat.b;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class d
{
  private b a;
  private int b;
  private int c;
  private String d;
  private String e;
  private String f;
  private String g;
  private int h;
  private long i;
  private String j;
  private e k;
  private f l;
  private String m;
  private int n = 0;
  private a o;
  
  public d() {}
  
  public d(b paramb, String paramString)
  {
    this.e = c.a().e();
    this.f = paramb.a();
    this.b = 1;
    this.g = paramString;
    this.i = (System.currentTimeMillis() / 1000L);
    this.n = 1;
    this.a = paramb;
  }
  
  public static d a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      d locald;
      try
      {
        locald = new d();
        locald.d = paramJSONObject.getString("MsgId");
        locald.b = paramJSONObject.getInt("MsgType");
        locald.c = paramJSONObject.getInt("AppMsgType");
        locald.e = paramJSONObject.getString("FromUserName");
        locald.f = paramJSONObject.getString("ToUserName");
        if ((!locald.e.startsWith("@")) || (!locald.f.startsWith("@")))
        {
          com.baidu.carlife.wechat.a.b.c.e("非联系人或群聊消息，丢弃");
          return null;
        }
        if (c.a().a(locald.f))
        {
          locald.a = c.a().b(locald.e);
          str = locald.e;
          locald.g = paramJSONObject.getString("Content");
          locald.g = locald.g.trim();
          if (!str.startsWith("@@")) {
            break label292;
          }
          String[] arrayOfString = locald.g.split(":<br/>", 2);
          if ((arrayOfString == null) || (arrayOfString.length != 2)) {
            break label284;
          }
          locald.m = arrayOfString[0];
          locald.g = arrayOfString[1];
          locald.h = paramJSONObject.getInt("Status");
          locald.i = paramJSONObject.getLong("CreateTime");
          locald.j = paramJSONObject.getString("Url");
          switch (locald.b)
          {
          case 1: 
            locald.n = 0;
            return locald;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      locald.a = c.a().b(locald.f);
      String str = locald.f;
      continue;
      label284:
      locald.m = str;
      continue;
      label292:
      locald.m = str;
      continue;
      if (locald.g.endsWith("pictype=location"))
      {
        str = locald.g.split(":<br/>")[0];
        paramJSONObject = "coord=([0-9\\.]+),([0-9\\.]+)";
        if (locald.j.contains("www.google.com/maps")) {
          paramJSONObject = "q=([0-9\\.]+),([0-9\\.]+)";
        }
        paramJSONObject = Pattern.compile(paramJSONObject).matcher(locald.j);
        if (!paramJSONObject.find()) {
          break label401;
        }
      }
      label401:
      for (locald.l = new f(str, paramJSONObject.group(1), paramJSONObject.group(2));; locald.l = null)
      {
        locald.g = locald.g.replaceAll("【以上文字由语音转换】", "");
        break;
      }
      if (locald.c == 3) {
        locald.q();
      } else {
        locald.k = null;
      }
    }
  }
  
  private void q()
  {
    String str2 = "";
    String str1 = "";
    String str3 = "";
    Matcher localMatcher = Pattern.compile("&lt;title&gt;(.*)&lt;/title&gt;(.*)&lt;des&gt;(.*)&lt;/des&gt;").matcher(this.g);
    if (localMatcher.find())
    {
      str2 = localMatcher.group(1).replace("分享歌曲：", "");
      str1 = localMatcher.group(3);
    }
    localMatcher = Pattern.compile("&lt;dataurl&gt;(.*)&lt;/dataurl&gt;").matcher(this.g);
    if (localMatcher.find()) {
      str3 = localMatcher.group(1);
    }
    if (TextUtils.isEmpty(str3))
    {
      this.k = null;
      com.baidu.carlife.wechat.a.b.c.e("music msg parse failed");
      return;
    }
    this.k = new e(str2, str1, str3);
    com.baidu.carlife.wechat.a.b.c.c("music msg： " + this.k.toString());
  }
  
  public String a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void a(b paramb)
  {
    this.a = paramb;
  }
  
  public void a(a parama)
  {
    this.o = parama;
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.m = paramString;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public b g()
  {
    return this.a;
  }
  
  public e h()
  {
    return this.k;
  }
  
  public f i()
  {
    return this.l;
  }
  
  public int j()
  {
    return this.h;
  }
  
  public long k()
  {
    return this.i;
  }
  
  public int l()
  {
    return this.n;
  }
  
  public String m()
  {
    return this.m;
  }
  
  public String n()
  {
    return com.baidu.carlife.wechat.e.c.j() + "/cgi-bin/mmwebwx-bin/webwxgetvoice?msgid=" + this.d + "&skey=" + c.a().g().a();
  }
  
  public boolean o()
  {
    if ((this.a != null) && (this.a.j()))
    {
      com.baidu.carlife.wechat.a.b.c.e("公众号 || 微信官方号 || 文件传输助手，忽略。。。。。。");
      return false;
    }
    if ((this.b >= 10000) || (this.b == 51) || ((this.b == 49) && (this.c != 3)))
    {
      com.baidu.carlife.wechat.a.b.c.e("type >=10000 || type ==51 || (type==49 && appMsgType!=3)，忽略。。。。。。");
      return false;
    }
    if ((this.b == 49) && (this.c == 3) && (this.k == null))
    {
      com.baidu.carlife.wechat.a.b.c.e("音乐分享，musicUrl解析失败，忽略。。。。。。");
      return false;
    }
    return true;
  }
  
  public a p()
  {
    return this.o;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */