package com.baidu.carlife.n;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.carlife.core.i;
import com.baidu.carlife.custom.elhyf.a;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import cz.msebera.android.httpclient.f;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  public static final String a = "HUOtaManager";
  public static final String b = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CarlifeOta";
  public static final int c = 1001;
  public static final int d = 1002;
  static final String p = "version.config";
  private static final int s = 0;
  private static final int t = 1;
  private static final int u = 2;
  String e = "http://caronline.yfgps.com/carlife/ota";
  String f = "rv02.eroad_5001_u2";
  String g;
  String h;
  String i;
  String j = "18039";
  String k = "170223";
  String l = "";
  long m;
  boolean n = false;
  String o = "";
  public Handler q = null;
  private int r = 0;
  private Handler v = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      d.this.c();
    }
  };
  
  public d(Handler paramHandler)
  {
    File localFile = new File(b);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    this.q = paramHandler;
  }
  
  public static String e()
  {
    return b;
  }
  
  public static String f()
  {
    return e() + "/CarLife-Vehicle.apk";
  }
  
  private boolean h()
  {
    File localFile = new File(e());
    return (localFile.exists()) && (localFile.length() == this.m);
  }
  
  public void a()
  {
    try
    {
      Object localObject = new FileInputStream(b + "/" + "version.config");
      byte[] arrayOfByte = new byte[((FileInputStream)localObject).available()];
      ((FileInputStream)localObject).read(arrayOfByte);
      ((FileInputStream)localObject).close();
      i.b("HUOtaManager", "read data: " + new String(arrayOfByte));
      localObject = new JSONObject(new String(arrayOfByte));
      this.f = ((JSONObject)localObject).getString("board");
      this.k = ((JSONObject)localObject).getString("versionCode");
      if (((JSONObject)localObject).has("ignore")) {
        this.l = ((JSONObject)localObject).getString("ignore");
      }
      i.b("HUOtaManager", "mIgnoreVersionCode: " + new String(arrayOfByte));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a(final File paramFile)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          d.b(d.this).sendEmptyMessage(0);
          FileInputStream localFileInputStream = new FileInputStream(paramFile);
          Object localObject = localFileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, paramFile.length());
          MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
          localMessageDigest.update((ByteBuffer)localObject);
          localObject = new BigInteger(1, localMessageDigest.digest()).toString(16).toLowerCase();
          int j = d.this.h.length();
          int k = ((String)localObject).length();
          int i = 0;
          while (i < j - k)
          {
            localObject = "0" + (String)localObject;
            i += 1;
          }
          if (d.this.h.equalsIgnoreCase((String)localObject)) {
            d.b(d.this).sendEmptyMessage(2);
          }
          for (;;)
          {
            localFileInputStream.close();
            return;
            d.b(d.this).sendEmptyMessage(1);
            paramFile.delete();
          }
          return;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localFileNotFoundException.printStackTrace();
          return;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          return;
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          localNoSuchAlgorithmException.printStackTrace();
        }
      }
    }).start();
  }
  
  public void a(String paramString1, String paramString2)
  {
    i.b("HUOtaManager", "OTA checkUpdateManual");
    a(this.f, this.k, true);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.r = 0;
    i.b("HUOtaManager", "boardName: " + paramString1);
    i.b("HUOtaManager", "versionCode: " + paramString2);
    i.b("HUOtaManager", "OtaPath: " + f());
    this.f = paramString1;
    this.k = paramString2;
    i.b("HUOtaManager", "mIsDownloading: " + this.n);
    if (this.n) {
      return;
    }
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("board", paramString1);
    localRequestParams.put("versionCode", paramString2);
    a.a().get(this.e, localRequestParams, new JsonHttpResponseHandler()
    {
      public void onFailure(int paramAnonymousInt, f[] paramAnonymousArrayOff, Throwable paramAnonymousThrowable, JSONObject paramAnonymousJSONObject)
      {
        i.b("HUOtaManager", "HttpResponseHandler onFailure: ");
      }
      
      public void onSuccess(int paramAnonymousInt, f[] paramAnonymousArrayOff, JSONObject paramAnonymousJSONObject)
      {
        if (d.this.q != null)
        {
          paramAnonymousArrayOff = Message.obtain();
          paramAnonymousArrayOff.what = 1001;
          paramAnonymousArrayOff.arg1 = 50;
          d.this.q.sendMessage(paramAnonymousArrayOff);
        }
        try
        {
          Thread.sleep(3000L);
          i.b("HUOtaManager", "HttpResponseHandler onSuccess: ");
        }
        catch (InterruptedException paramAnonymousArrayOff)
        {
          try
          {
            paramAnonymousInt = paramAnonymousJSONObject.getInt("error");
            if (paramAnonymousInt == 0)
            {
              d.this.g = paramAnonymousJSONObject.getString("url");
              d.this.i = paramAnonymousJSONObject.getString("tips");
              d.this.m = paramAnonymousJSONObject.getLong("length");
              d.this.h = paramAnonymousJSONObject.getString("md5");
              d.this.j = ("" + paramAnonymousJSONObject.getLong("versionCode"));
              if (d.a(d.this)) {
                d.this.a(new File(d.f()));
              }
              if (d.this.q != null)
              {
                paramAnonymousArrayOff = Message.obtain();
                paramAnonymousArrayOff.what = 1001;
                paramAnonymousArrayOff.arg1 = 100;
                d.this.q.sendMessage(paramAnonymousArrayOff);
              }
            }
          }
          catch (JSONException paramAnonymousArrayOff)
          {
            try
            {
              for (;;)
              {
                Thread.sleep(1000L);
                if (d.this.q != null)
                {
                  paramAnonymousArrayOff = Message.obtain();
                  paramAnonymousArrayOff.what = 1002;
                  paramAnonymousArrayOff.arg1 = 100;
                  d.this.q.sendMessage(paramAnonymousArrayOff);
                }
                return;
                paramAnonymousArrayOff = paramAnonymousArrayOff;
                paramAnonymousArrayOff.printStackTrace();
                continue;
                paramAnonymousArrayOff = paramAnonymousJSONObject.getString("message");
                i.b("HUOtaManager", "HttpResponseHandler code:" + paramAnonymousInt);
                i.b("HUOtaManager", "HttpResponseHandler strMsg:" + paramAnonymousArrayOff);
              }
              paramAnonymousArrayOff = paramAnonymousArrayOff;
              paramAnonymousArrayOff.printStackTrace();
            }
            catch (InterruptedException paramAnonymousArrayOff)
            {
              for (;;)
              {
                paramAnonymousArrayOff.printStackTrace();
              }
            }
          }
        }
      }
    });
  }
  
  public void b()
  {
    i.b("HUOtaManager", "OTA checkUpdateManual");
    a(this.f, this.k, true);
  }
  
  public void c()
  {
    this.n = true;
    this.o = this.f;
    String str = f();
    i.b("HUOtaManager", "downloadPath: " + str);
    File localFile = new File(str);
    if (localFile.exists())
    {
      if (localFile.length() == this.m)
      {
        a(localFile);
        return;
      }
      localFile.delete();
    }
    a.a().setURLEncodingEnabled(false);
    a.a().get(this.g, new FileAsyncHttpResponseHandler(new File(str))
    {
      public void onFailure(int paramAnonymousInt, f[] paramAnonymousArrayOff, Throwable paramAnonymousThrowable, File paramAnonymousFile)
      {
        d.this.n = false;
        d.this.o = "";
        Log.i("mai", "retryCount:" + d.c(d.this));
        if (d.c(d.this) >= 2)
        {
          d.a(d.this, 0);
          i.b("HUOtaManager", "onDownloadFailed: " + paramAnonymousInt);
          return;
        }
        d.b(d.this).postDelayed(new Runnable()
        {
          public void run()
          {
            d.d(d.this);
            d.this.c();
          }
        }, 3000L);
      }
      
      public void onProgress(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        super.onProgress(paramAnonymousLong1, paramAnonymousLong2);
        int i = (int)(100L * paramAnonymousLong1 / paramAnonymousLong2);
        i.b("HUOtaManager", "onDownloadProgress: " + i);
      }
      
      public void onSuccess(int paramAnonymousInt, f[] paramAnonymousArrayOff, File paramAnonymousFile)
      {
        d.this.n = false;
        d.this.o = "";
        d.this.a(paramAnonymousFile);
      }
    });
    a.a().setURLEncodingEnabled(true);
  }
  
  public boolean d()
  {
    return (this.f != null) && (!"".equals(this.f));
  }
  
  public void g()
  {
    Object localObject = new File(b);
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {}
    for (;;)
    {
      return;
      localObject = Arrays.asList(((File)localObject).listFiles(new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          return paramAnonymousFile.getName().endsWith(".fex");
        }
      }));
      Collections.sort((List)localObject, new Comparator()
      {
        public int a(File paramAnonymousFile1, File paramAnonymousFile2)
        {
          if (paramAnonymousFile1.lastModified() > paramAnonymousFile2.lastModified()) {
            return -1;
          }
          if (paramAnonymousFile1.lastModified() == paramAnonymousFile2.lastModified()) {
            return 0;
          }
          return 1;
        }
      });
      int i1 = 1;
      while (i1 < ((List)localObject).size())
      {
        ((File)((List)localObject).get(i1)).delete();
        i1 += 1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/n/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */