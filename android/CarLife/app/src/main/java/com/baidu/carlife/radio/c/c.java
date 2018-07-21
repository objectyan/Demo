package com.baidu.carlife.radio.c;

import android.content.res.Resources;
import com.baidu.carlife.core.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class c
{
  private static Map<String, String[]> a = new HashMap();
  private static Random b = new Random();
  
  static
  {
    a();
  }
  
  public static String a(String paramString)
  {
    if (!a.containsKey(paramString)) {
      return null;
    }
    if ("每日随心".equals(paramString))
    {
      a.remove(paramString);
      return a.a().getString(2131298806);
    }
    String str = a((String[])a.get(paramString));
    a.remove(paramString);
    if (str.equals("")) {
      return null;
    }
    return "您可以这样说，" + str;
  }
  
  public static String a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
      return "";
    }
    int i = b.nextInt(paramArrayOfString.length);
    if (i < paramArrayOfString.length) {
      return paramArrayOfString[i];
    }
    return "";
  }
  
  public static void a()
  {
    Resources localResources = a.a().getResources();
    a.put("电台", localResources.getStringArray(2131230803));
    a.put("儿童", localResources.getStringArray(2131230802));
    a.put("情感", localResources.getStringArray(2131230805));
    a.put("听书", localResources.getStringArray(2131230806));
    a.put("学习", localResources.getStringArray(2131230807));
    a.put("娱乐", localResources.getStringArray(2131230808));
    a.put("新闻", localResources.getStringArray(2131230804));
    a.put("每日随心", null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */