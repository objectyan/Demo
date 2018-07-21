package com.baidu.carlife.k;

import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.i;
import com.baidu.carlife.k.a.d;
import com.baidu.carlife.k.a.e;
import com.baidu.carlife.k.a.f;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class o
  extends e
{
  private InputStream a;
  private String b;
  private String c;
  
  public o(String paramString1, String paramString2, InputStream paramInputStream)
  {
    this.tag = o.class.getSimpleName();
    this.b = paramString1;
    this.a = paramInputStream;
    this.c = paramString2;
  }
  
  protected d getPostRequestParams()
  {
    d locald = new d();
    locald.put("os", "0");
    locald.put("appid", "3");
    locald.put("app_ver", this.b);
    locald.toSign("sign");
    locald.put("datafile", this.a, this.c);
    return locald;
  }
  
  protected String getUrl()
  {
    return f.a();
  }
  
  protected int responseSuccessCallBack(String paramString)
  {
    Object localObject1 = null;
    paramString = null;
    Object localObject3 = null;
    FileOutputStream localFileOutputStream3 = null;
    FileOutputStream localFileOutputStream1 = localFileOutputStream3;
    Object localObject2 = localObject3;
    for (;;)
    {
      try
      {
        localFileOutputStream2 = BaiduNaviApplication.getInstance().openFileOutput("CarlifeVechicleCrash.log", 0);
        paramString = localFileOutputStream2;
        localFileOutputStream1 = localFileOutputStream3;
        localObject1 = localFileOutputStream2;
        localObject2 = localObject3;
        localFileOutputStream2.write("".getBytes());
        paramString = localFileOutputStream2;
        localFileOutputStream1 = localFileOutputStream3;
        localObject1 = localFileOutputStream2;
        localObject2 = localObject3;
        localFileOutputStream3 = BaiduNaviApplication.getInstance().openFileOutput("CarlifeVechicleCrash.log.gz", 0);
        paramString = localFileOutputStream2;
        localFileOutputStream1 = localFileOutputStream3;
        localObject1 = localFileOutputStream2;
        localObject2 = localFileOutputStream3;
        localFileOutputStream3.write("".getBytes());
      }
      catch (Exception localException)
      {
        FileOutputStream localFileOutputStream2;
        localObject1 = paramString;
        localObject2 = localFileOutputStream1;
        i.e(this.tag, localException.toString());
        if (paramString == null) {
          continue;
        }
        try
        {
          paramString.close();
          if (localFileOutputStream1 == null) {
            continue;
          }
          localFileOutputStream1.close();
          return 0;
        }
        catch (IOException paramString)
        {
          i.e(this.tag, paramString.toString());
          return 0;
        }
      }
      finally
      {
        if (localObject1 == null) {
          break label194;
        }
      }
      try
      {
        localFileOutputStream2.close();
        if (localFileOutputStream3 != null) {
          localFileOutputStream3.close();
        }
        return 0;
      }
      catch (IOException paramString)
      {
        i.e(this.tag, paramString.toString());
        return 0;
      }
    }
    try
    {
      ((FileOutputStream)localObject1).close();
      label194:
      if (localObject2 != null) {
        ((FileOutputStream)localObject2).close();
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        i.e(this.tag, localIOException.toString());
      }
    }
    throw paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */