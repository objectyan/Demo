package com.baidu.carlife.wechat.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
{
  private int a;
  private String b;
  private String c;
  private String d;
  private int e;
  private int f;
  private int g;
  private int h;
  private String i;
  private String j;
  private String k;
  private List<g> l = new ArrayList();
  
  public static b a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int m;
      try
      {
        b localb = new b();
        localb.a = paramJSONObject.optInt("Uin");
        localb.b = paramJSONObject.getString("UserName");
        Object localObject = paramJSONObject.optString("RemarkName");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localb.c = ((String)localObject);
          localb.c = localb.c.replaceAll("<span.*></span>", "�");
          localb.j = com.baidu.carlife.wechat.a.b.b.a().a(localb.b());
          localb.d = paramJSONObject.optString("HeadImgUrl");
          localb.e = paramJSONObject.optInt("Statues");
          localb.f = paramJSONObject.optInt("VerifyFlag");
          localb.g = paramJSONObject.optInt("StarFriend");
          localb.h = paramJSONObject.optInt("ContactFlag");
          localb.i = paramJSONObject.optString("Alias");
          localb.k = paramJSONObject.optString("EncryChatRoomId");
          localObject = localb;
          if (localb.k())
          {
            localb.l = new ArrayList();
            localObject = localb;
            if (!paramJSONObject.isNull("MemberList"))
            {
              JSONArray localJSONArray = paramJSONObject.getJSONArray("MemberList");
              m = 0;
              int n = localJSONArray.length();
              localObject = localb;
              if (m < n)
              {
                localObject = localb.k;
                paramJSONObject = (JSONObject)localObject;
                if (TextUtils.isEmpty((CharSequence)localObject)) {
                  paramJSONObject = localb.b;
                }
                paramJSONObject = g.a(localJSONArray.getJSONObject(m), paramJSONObject);
                if (paramJSONObject == null) {
                  break label300;
                }
                localb.l.add(paramJSONObject);
                break label300;
              }
            }
          }
        }
        else
        {
          localb.c = paramJSONObject.getString("NickName");
          continue;
        }
        return (b)localObject;
      }
      catch (Exception paramJSONObject)
      {
        com.baidu.carlife.wechat.a.b.c.e("contact parse failed");
        paramJSONObject.printStackTrace();
        localObject = null;
      }
      label300:
      m += 1;
    }
  }
  
  private boolean o()
  {
    return (this.j == null) || (this.j.length() <= 0);
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String b()
  {
    if ((TextUtils.isEmpty(this.c)) && (k()))
    {
      if ((this.l != null) && (this.l.size() > 0))
      {
        StringBuffer localStringBuffer = new StringBuffer();
        int n = Math.min(5, this.l.size());
        int m = 0;
        while (m < n)
        {
          localStringBuffer.append(((g)this.l.get(m)).c());
          if (m < n - 1) {
            localStringBuffer.append("、");
          }
          m += 1;
        }
        if (this.l.size() > 5) {
          localStringBuffer.append("...");
        }
        return localStringBuffer.toString();
      }
      return "群消息";
    }
    return this.c;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.j;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public int d()
  {
    return this.g;
  }
  
  public g d(String paramString)
  {
    if (this.l != null)
    {
      Iterator localIterator = this.l.iterator();
      while (localIterator.hasNext())
      {
        g localg = (g)localIterator.next();
        if (TextUtils.equals(paramString, localg.b())) {
          return localg;
        }
      }
    }
    return null;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public int f()
  {
    return this.e;
  }
  
  public String g()
  {
    return this.i;
  }
  
  public String h()
  {
    return this.k;
  }
  
  public List<g> i()
  {
    return this.l;
  }
  
  public boolean j()
  {
    return (this.f > 0) || (!this.b.startsWith("@"));
  }
  
  public boolean k()
  {
    return this.b.startsWith("@@");
  }
  
  public boolean l()
  {
    return (this.h >= 2048) && (this.h < 4096);
  }
  
  public boolean m()
  {
    return d(c.a().e()) != null;
  }
  
  public int n()
  {
    if (this.g == 1) {
      return 0;
    }
    if (k()) {
      return 1;
    }
    if (o()) {
      return 3;
    }
    int m = this.j.charAt(0);
    if ((m >= 97) && (m <= 122)) {
      return 2;
    }
    return 3;
  }
  
  public String toString()
  {
    return "Contact[" + this.c + "," + this.b + "]";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */