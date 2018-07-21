package com.baidu.carlife.radio.c;

import android.text.TextUtils;
import com.baidu.carlife.core.i;
import com.baidu.carlife.util.h;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
{
  protected static final String a = "radio_channel_cache";
  public static final String b = "10";
  private static final String c = "radio_channel_list.json";
  private static final String d = "radio_channel_list.json";
  private static boolean e = true;
  private static final long f = 10800L;
  private List<com.baidu.carlife.radio.a.a> g = new ArrayList();
  private long h = 0L;
  
  public static b a()
  {
    return a.a;
  }
  
  private List<com.baidu.carlife.radio.a.a> e(String paramString)
  {
    localArrayList = new ArrayList();
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("data").getJSONArray("list");
      int i = 0;
      int j = paramString.length();
      while (i < j)
      {
        com.baidu.carlife.radio.a.a locala = new com.baidu.carlife.radio.a.a();
        JSONObject localJSONObject = paramString.getJSONObject(i);
        locala.a(localJSONObject.getString("channel_id"));
        locala.b(localJSONObject.getString("name"));
        locala.c(localJSONObject.getString("picture"));
        locala.d(localJSONObject.getString("statistic_id"));
        localArrayList.add(locala);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      localArrayList.clear();
    }
  }
  
  private long g()
  {
    i.c("radio_channel_cache", "get cache time");
    try
    {
      String str = h();
      if (!TextUtils.isEmpty(str))
      {
        long l = new JSONObject(str).getLong("timestamp");
        return l;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0L;
  }
  
  private String h()
  {
    i.c("radio_channel_cache", "read cache data");
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        localFileInputStream = com.baidu.carlife.core.a.a().openFileInput("radio_channel_list.json");
        localObject1 = localFileInputStream;
        localObject3 = localFileInputStream;
        localObject5 = new byte[localFileInputStream.available()];
        localObject1 = localFileInputStream;
        localObject3 = localFileInputStream;
        localFileInputStream.read((byte[])localObject5);
        localObject1 = localFileInputStream;
        localObject3 = localFileInputStream;
        localObject5 = new String((byte[])localObject5, "UTF-8");
      }
      catch (Exception localException4)
      {
        FileInputStream localFileInputStream;
        Object localObject5;
        localObject3 = localException1;
        localException4.printStackTrace();
        localObject3 = localObject4;
        if (localException1 == null) {
          continue;
        }
        try
        {
          localException1.close();
          return null;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          return null;
        }
      }
      finally
      {
        if (localObject3 == null) {
          break label120;
        }
      }
      try
      {
        localFileInputStream.close();
        localObject3 = localObject5;
        return (String)localObject3;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return (String)localObject5;
      }
    }
    try
    {
      ((FileInputStream)localObject3).close();
      label120:
      throw ((Throwable)localObject2);
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        localException3.printStackTrace();
      }
    }
  }
  
  private String i()
  {
    i.c("radio_channel_cache", "read default data");
    return h.a(com.baidu.carlife.core.a.a(), "radio_channel_list.json");
  }
  
  public void a(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  public boolean a(String paramString)
  {
    return TextUtils.equals(paramString, "10");
  }
  
  public String b(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return "";
    }
    return paramString.c();
  }
  
  public boolean b()
  {
    return e;
  }
  
  public com.baidu.carlife.radio.a.a c()
  {
    com.baidu.carlife.radio.a.a locala = new com.baidu.carlife.radio.a.a();
    locala.a("10");
    locala.b("语音点播");
    locala.c("res://com.baidu.carlife/2130839326");
    locala.d("CONTENT_REC_0011");
    return locala;
  }
  
  public com.baidu.carlife.radio.a.a c(String paramString)
  {
    if (this.g.size() == 0) {
      e();
    }
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      com.baidu.carlife.radio.a.a locala = (com.baidu.carlife.radio.a.a)localIterator.next();
      if (locala.a().equals(paramString)) {
        return locala;
      }
    }
    if (this.g.size() == 0) {}
    for (paramString = null;; paramString = (com.baidu.carlife.radio.a.a)this.g.get(0)) {
      return paramString;
    }
  }
  
  public com.baidu.carlife.radio.a.a d()
  {
    if (this.g.size() == 0) {
      e();
    }
    if (this.g.size() == 0) {
      return null;
    }
    return (com.baidu.carlife.radio.a.a)this.g.get(0);
  }
  
  public void d(String paramString)
  {
    i.c("radio_channel_cache", "write cache data");
    this.g.clear();
    this.h = 0L;
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localFileOutputStream = com.baidu.carlife.core.a.a().openFileOutput("radio_channel_list.json", 0);
        localObject1 = localFileOutputStream;
        localObject2 = localFileOutputStream;
        localFileOutputStream.write(paramString.getBytes("UTF-8"));
      }
      catch (Exception paramString)
      {
        FileOutputStream localFileOutputStream;
        localObject2 = localObject1;
        paramString.printStackTrace();
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((FileOutputStream)localObject1).close();
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      finally
      {
        if (localObject2 == null) {
          break label101;
        }
      }
      try
      {
        localFileOutputStream.close();
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    try
    {
      ((FileOutputStream)localObject2).close();
      label101:
      throw paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public List<com.baidu.carlife.radio.a.a> e()
  {
    if (this.g.size() > 0)
    {
      i.c("radio_channel_cache", "use memory cache");
      return this.g;
    }
    String str = h();
    if (!TextUtils.isEmpty(str))
    {
      this.g = e(str);
      if (this.g.size() != 0) {}
    }
    for (this.g = e(i());; this.g = e(i()))
    {
      this.g.add(c());
      return this.g;
    }
  }
  
  public boolean f()
  {
    if (this.h == 0L) {
      this.h = g();
    }
    return System.currentTimeMillis() / 1000L - this.h < 10800L;
  }
  
  private static class a
  {
    public static final b a = new b(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */