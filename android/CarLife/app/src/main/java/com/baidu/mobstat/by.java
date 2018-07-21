package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.Timer;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

class by
{
  private static by a = new by();
  private boolean b = false;
  private int c = 0;
  private int d = 1;
  private SendStrategyEnum e = SendStrategyEnum.APP_START;
  private Timer f;
  private Handler g;
  
  private by()
  {
    HandlerThread localHandlerThread = new HandlerThread("LogSenderThread");
    localHandlerThread.start();
    this.g = new Handler(localHandlerThread.getLooper());
  }
  
  public static by a()
  {
    return a;
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = null;
    try
    {
      paramString2 = new JSONObject(paramString2);
      if (paramString2 == null) {
        return;
      }
      try
      {
        localJSONObject = (JSONObject)paramString2.get("trace");
        localJSONObject.put("failed_cnt", localJSONObject.getLong("failed_cnt") + 1L);
        cu.a(paramContext, paramString1, paramString2.toString(), false);
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2 = localException;
      }
    }
  }
  
  private boolean b(Context paramContext, String paramString)
  {
    boolean bool = false;
    if ((this.b) && (!de.n(paramContext))) {
      return false;
    }
    try
    {
      c(paramContext, Config.LOG_SEND_URL, paramString);
      bool = true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        db.c(paramContext);
      }
    }
    db.a("send log data over. result = " + bool + "; data = " + paramString);
    return bool;
  }
  
  private String c(Context paramContext, String paramString1, String paramString2)
  {
    if (!paramString1.startsWith("https://")) {
      return e(paramContext, paramString1, paramString2);
    }
    return d(paramContext, paramString1, paramString2);
  }
  
  private void c(Context paramContext)
  {
    if ((this.b) && (!de.n(paramContext))) {
      return;
    }
    this.g.post(new cc(this, paramContext));
  }
  
  private String d(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = cu.d(paramContext, paramString1);
    paramString1.setDoOutput(true);
    paramString1.setInstanceFollowRedirects(false);
    paramString1.setUseCaches(false);
    paramString1.setRequestProperty("Content-Type", "gzip");
    paramString1.connect();
    db.a("AdUtil.httpPost connected");
    StringBuilder localStringBuilder;
    try
    {
      paramContext = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(paramString1.getOutputStream())));
      paramContext.write(paramString2);
      paramContext.flush();
      paramContext.close();
      paramString2 = new BufferedReader(new InputStreamReader(paramString1.getInputStream()));
      localStringBuilder = new StringBuilder();
      for (paramContext = paramString2.readLine(); paramContext != null; paramContext = paramString2.readLine()) {
        localStringBuilder.append(paramContext);
      }
      int i = paramString1.getContentLength();
      if ((paramString1.getResponseCode() != 200) || (i != 0)) {
        throw new IOException("http code = " + paramString1.getResponseCode() + "; contentResponse = " + localStringBuilder);
      }
    }
    finally
    {
      paramString1.disconnect();
    }
    paramContext = localStringBuilder.toString();
    paramString1.disconnect();
    return paramContext;
  }
  
  private String e(Context paramContext, String paramString1, String paramString2)
  {
    db.a("httpPostEncrypt");
    paramString1 = cu.d(paramContext, paramString1);
    paramString1.setDoOutput(true);
    paramString1.setInstanceFollowRedirects(false);
    paramString1.setUseCaches(false);
    paramString1.setRequestProperty("Content-Type", "gzip");
    paramContext = cs.a();
    Object localObject = cs.b();
    paramString1.setRequestProperty("key", dc.a(paramContext));
    paramString1.setRequestProperty("iv", dc.a((byte[])localObject));
    paramContext = cs.a(paramContext, (byte[])localObject, paramString2.getBytes("utf-8"));
    paramString1.connect();
    db.a("AdUtil.httpPost connected");
    try
    {
      paramString2 = new GZIPOutputStream(paramString1.getOutputStream());
      paramString2.write(paramContext);
      paramString2.flush();
      paramString2.close();
      paramString2 = new BufferedReader(new InputStreamReader(paramString1.getInputStream()));
      localObject = new StringBuilder();
      for (paramContext = paramString2.readLine(); paramContext != null; paramContext = paramString2.readLine()) {
        ((StringBuilder)localObject).append(paramContext);
      }
      int i = paramString1.getContentLength();
      if ((paramString1.getResponseCode() != 200) || (i != 0)) {
        throw new IOException("http code = " + paramString1.getResponseCode() + "; contentResponse = " + localObject);
      }
    }
    finally
    {
      paramString1.disconnect();
    }
    paramContext = ((StringBuilder)localObject).toString();
    paramString1.disconnect();
    return paramContext;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 30)) {
      this.c = paramInt;
    }
  }
  
  public void a(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext != null) {
      localContext = paramContext.getApplicationContext();
    }
    if (localContext == null) {
      return;
    }
    this.g.post(new bz(this, localContext));
  }
  
  public void a(Context paramContext, SendStrategyEnum paramSendStrategyEnum, int paramInt, boolean paramBoolean)
  {
    if (paramSendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
      if ((paramInt > 0) && (paramInt <= 24))
      {
        this.d = paramInt;
        this.e = SendStrategyEnum.SET_TIME_INTERVAL;
        bj.a().a(paramContext, this.e.ordinal());
        bj.a().b(paramContext, this.d);
      }
    }
    for (;;)
    {
      this.b = paramBoolean;
      bj.a().a(paramContext, this.b);
      db.a("sstype is:" + this.e.name() + " And timeInterval is:" + this.d + " And mOnlyWifi:" + this.b);
      return;
      db.c("timeInterval is invalid, new strategy does not work");
      continue;
      this.e = paramSendStrategyEnum;
      bj.a().a(paramContext, this.e.ordinal());
      if (paramSendStrategyEnum.equals(SendStrategyEnum.ONCE_A_DAY)) {
        bj.a().b(paramContext, 24);
      }
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    cu.a(paramContext, "__send_data_" + System.currentTimeMillis(), paramString, false);
  }
  
  public void b(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    long l = this.d * 3600000;
    this.f = new Timer();
    this.f.schedule(new cb(this, paramContext), l, l);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */