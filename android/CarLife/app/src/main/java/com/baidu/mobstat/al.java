package com.baidu.mobstat;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public class al
{
  private static String a;
  private static al b;
  private Handler c;
  
  static
  {
    if (Build.VERSION.SDK_INT < 9) {}
    for (String str = "http://openrcv.baidu.com/1010/bplus.gif";; str = "https://openrcv.baidu.com/1010/bplus.gif")
    {
      a = str;
      return;
    }
  }
  
  private al()
  {
    HandlerThread localHandlerThread = new HandlerThread("LogSender");
    localHandlerThread.start();
    this.c = new Handler(localHandlerThread.getLooper());
  }
  
  public static al a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new al();
      }
      return b;
    }
    finally {}
  }
  
  private String a(Context paramContext, String paramString1, String paramString2)
  {
    if (!paramString1.startsWith("https:")) {}
    for (int i = 1;; i = 0)
    {
      paramString1 = cu.d(paramContext, paramString1);
      paramString1.setDoOutput(true);
      paramString1.setInstanceFollowRedirects(false);
      paramString1.setUseCaches(false);
      paramString1.setRequestProperty("Content-Encoding", "gzip");
      paramString1.connect();
      Object localObject;
      try
      {
        localObject = paramString1.getOutputStream();
        localGZIPOutputStream = new GZIPOutputStream((OutputStream)localObject);
        localGZIPOutputStream.write(new byte[] { 72, 77, 48, 49 });
        localGZIPOutputStream.write(new byte[] { 0, 0, 0, 1 });
        localGZIPOutputStream.write(new byte[] { 0, 0, 3, -14 });
        localGZIPOutputStream.write(new byte[] { 0, 0, 0, 0, 0, 0, 0, 0 });
        localGZIPOutputStream.write(new byte[] { 0, 2 });
        if (i == 0) {
          break label540;
        }
        localGZIPOutputStream.write(new byte[] { 0, 1 });
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          GZIPOutputStream localGZIPOutputStream;
          byte[] arrayOfByte;
          bd.b(paramContext);
          return "";
          localGZIPOutputStream.write(new byte[] { 0, 0 });
        }
      }
      finally
      {
        paramString1.disconnect();
      }
      localGZIPOutputStream.write(new byte[] { 72, 77, 48, 49 });
      if (i != 0)
      {
        paramContext = cs.a();
        arrayOfByte = dc.a(false, cw.a(), paramContext);
        localGZIPOutputStream.write(a(arrayOfByte.length, 4));
        localGZIPOutputStream.write(arrayOfByte);
        paramString2 = paramString2.getBytes("utf-8");
        paramContext = cs.a(paramContext, new byte[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, paramString2);
        localGZIPOutputStream.write(a(paramContext.length, 2));
      }
      for (;;)
      {
        localGZIPOutputStream.write(paramContext);
        localGZIPOutputStream.close();
        ((OutputStream)localObject).close();
        i = paramString1.getResponseCode();
        int j = paramString1.getContentLength();
        bd.c("code: " + i + "; len: " + j);
        if ((i == 200) && (j == 0)) {
          break;
        }
        throw new IOException("Response code = " + paramString1.getResponseCode());
        label540:
        paramContext = paramString2.getBytes("utf-8");
      }
      paramContext = new BufferedReader(new InputStreamReader(paramString1.getInputStream()));
      paramString2 = new StringBuilder();
      for (;;)
      {
        localObject = paramContext.readLine();
        if (localObject == null)
        {
          paramContext = paramString2.toString();
          paramString1.disconnect();
          return paramContext;
        }
        paramString2.append((String)localObject);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    if (!"mounted".equals(cu.a())) {}
    for (;;)
    {
      return;
      Object localObject1 = new File(Environment.getExternalStorageDirectory(), "backups/system");
      if (((File)localObject1).exists())
      {
        localObject1 = ((File)localObject1).listFiles();
        if ((localObject1 != null) && (localObject1.length != 0)) {
          try
          {
            Arrays.sort((Object[])localObject1, new an(this));
            int m = localObject1.length;
            int j = 0;
            for (k = 0; j < m; k = i)
            {
              Object localObject2 = localObject1[j];
              if (((File)localObject2).isFile()) {
                break label118;
              }
              i = k;
              j += 1;
            }
          }
          catch (Exception localException)
          {
            int k;
            label118:
            do
            {
              String str1;
              String str2;
              for (;;)
              {
                bd.b(localException);
                continue;
                str1 = localException.getName();
                i = k;
                if (!TextUtils.isEmpty(str1))
                {
                  i = k;
                  if (str1.startsWith("__send_log_data_"))
                  {
                    str1 = "backups/system" + File.separator + str1;
                    str2 = cu.b(str1);
                    if (!b(paramContext, str2)) {
                      break;
                    }
                    cu.c(str1);
                    i = 0;
                  }
                }
              }
              a(str2, str1);
              k += 1;
              int i = k;
            } while (k < 5);
          }
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    cu.a("backups/system" + File.separator + "__send_log_data_" + System.currentTimeMillis(), paramString, false);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      try
      {
        paramString1 = new JSONObject(paramString1);
        JSONObject localJSONObject = v.a(paramString1);
        if (localJSONObject == null) {
          continue;
        }
        v.b(localJSONObject);
        cu.a(paramString2, paramString1.toString(), false);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1 = null;
        }
      }
    }
  }
  
  private static byte[] a(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[(paramInt - i - 1)] = ((byte)(int)(0xFF & paramLong));
      paramLong >>= 8;
      i += 1;
    }
    return arrayOfByte;
  }
  
  private boolean b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      a(paramContext, a, paramString);
      return true;
    }
    catch (Exception paramContext)
    {
      bd.c(paramContext);
    }
    return false;
  }
  
  public void a(Context paramContext, String paramString)
  {
    bd.a("data = " + paramString);
    if ((paramString == null) || ("".equals(paramString))) {
      return;
    }
    this.c.post(new am(this, paramString, paramContext));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */