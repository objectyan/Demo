package com.baidu.carlife.logic.music;

import com.baidu.carlife.model.j;
import java.util.HashMap;
import java.util.List;

public class t
{
  private HashMap<String, Integer> a;
  
  private t()
  {
    b();
  }
  
  public static t a()
  {
    return a.a();
  }
  
  private String a(j paramj)
  {
    if ((paramj.l.equals("本地音乐")) || (paramj.m.equals("com.baidu.music.local"))) {
      return "media_player";
    }
    if ((paramj.l.equals("QQ音乐")) || (paramj.m.equals("com.tencent.qqmusic"))) {
      return "QQ音乐";
    }
    if ((paramj.l.equals("网易云音乐")) || (paramj.m.equals("com.baidu.music.netease"))) {
      return "neteasemusic";
    }
    if ((paramj.l.equals("喜马拉雅FM")) || (paramj.m.equals("com.ximalaya.ting.android"))) {
      return "喜马拉雅fm";
    }
    if ((paramj.l.equals("考拉FM")) || (paramj.m.equals("com.itings.myradio"))) {
      return "考拉fm";
    }
    if (paramj.l.equals("车悦宝")) {
      return "车悦宝";
    }
    if ((paramj.l.equals("中国广播")) || (paramj.m.equals("com.shinyv.cnr"))) {
      return "中国广播";
    }
    return paramj.l;
  }
  
  private void b()
  {
    this.a = new HashMap();
    this.a.put("media_player", Integer.valueOf(0));
    int i = 0 + 1;
    this.a.put("QQ音乐", Integer.valueOf(i));
    i += 1;
    this.a.put("neteasemusic", Integer.valueOf(i));
    i += 1;
    this.a.put("喜马拉雅fm", Integer.valueOf(i));
    i += 1;
    this.a.put("考拉fm", Integer.valueOf(i));
    i += 1;
    this.a.put("车悦宝", Integer.valueOf(i));
    i += 1;
    this.a.put("中国广播", Integer.valueOf(i));
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)this.a.get(paramString);
    if (paramString == null) {
      return -1;
    }
    return paramString.intValue();
  }
  
  public void a(List<j> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {}
    for (;;)
    {
      return;
      this.a.clear();
      int i = 0;
      while (i < paramList.size())
      {
        String str = a((j)paramList.get(i));
        if ("media_player".equals(str)) {
          this.a.put("media_player", Integer.valueOf(i));
        }
        this.a.put(str, Integer.valueOf(i));
        i += 1;
      }
    }
  }
  
  private static final class a
  {
    private static final t a = new t(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */