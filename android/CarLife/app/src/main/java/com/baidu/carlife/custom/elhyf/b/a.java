package com.baidu.carlife.custom.elhyf.b;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.carlife.core.i;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import cz.msebera.android.httpclient.f;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

public class a
{
  public static final String a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CarlifeOta";
  static final String m = "version.config";
  private static final int o = 0;
  private static final int p = 1;
  private static final int q = 2;
  a b;
  String c;
  String d;
  String e;
  String f;
  String g;
  String h;
  String i = "";
  long j;
  boolean k = false;
  String l = "";
  private int n = 0;
  private Handler r = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 0: 
        a.this.b.g();
        return;
      case 1: 
        a.this.b.h();
        return;
      }
      a.this.b.a(a.a(a.this), a.this.c, a.this.g);
    }
  };
  
  public a(a parama)
  {
    this.b = parama;
    parama = new File(a);
    if (!parama.exists()) {
      parama.mkdirs();
    }
    try
    {
      parama = new FileInputStream(a + "/" + "version.config");
      byte[] arrayOfByte = new byte[parama.available()];
      parama.read(arrayOfByte);
      parama.close();
      parama = new JSONObject(new String(arrayOfByte));
      this.c = parama.getString("board");
      this.h = parama.getString("versionCode");
      if (parama.has("ignore")) {
        this.i = parama.getString("ignore");
      }
      return;
    }
    catch (FileNotFoundException parama)
    {
      parama.printStackTrace();
      return;
    }
    catch (IOException parama)
    {
      parama.printStackTrace();
      return;
    }
    catch (JSONException parama)
    {
      parama.printStackTrace();
    }
  }
  
  private void f()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ignore", this.i);
      localJSONObject.put("board", this.c);
      localJSONObject.put("versionCode", this.h);
      FileOutputStream localFileOutputStream = new FileOutputStream(a + "/" + "version.config");
      localFileOutputStream.write(localJSONObject.toString().getBytes());
      localFileOutputStream.flush();
      localFileOutputStream.close();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
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
    }
  }
  
  private boolean g()
  {
    File localFile = new File(h());
    return (localFile.exists()) && (localFile.length() == this.j);
  }
  
  private String h()
  {
    return a + "/" + this.c + "." + this.g + ".fex";
  }
  
  public void a()
  {
    i.b("OTAUPDATE", "OTA checkUpdateManual");
    a(this.c, this.h, true);
  }
  
  public void a(final File paramFile)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          a.c(a.this).sendEmptyMessage(0);
          FileInputStream localFileInputStream = new FileInputStream(paramFile);
          Object localObject = localFileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, paramFile.length());
          MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
          localMessageDigest.update((ByteBuffer)localObject);
          localObject = new BigInteger(1, localMessageDigest.digest()).toString(16).toLowerCase();
          int j = a.this.e.length();
          int k = ((String)localObject).length();
          int i = 0;
          while (i < j - k)
          {
            localObject = "0" + (String)localObject;
            i += 1;
          }
          if (a.this.e.equalsIgnoreCase((String)localObject)) {
            a.c(a.this).sendEmptyMessage(2);
          }
          for (;;)
          {
            localFileInputStream.close();
            return;
            a.c(a.this).sendEmptyMessage(1);
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
  
  public void a(String paramString1, String paramString2, final boolean paramBoolean)
  {
    this.n = 0;
    i.b("OTAUPDATE", "boardName: " + paramString1);
    i.b("OTAUPDATE", "versionCode: " + paramString2);
    i.b("OTAUPDATE", "DEBUG: false");
    this.c = paramString1;
    this.h = paramString2;
    f();
    if (this.k) {
      return;
    }
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("board", paramString1);
    localRequestParams.put("versionCode", paramString2);
    com.baidu.carlife.custom.elhyf.a.a().get("http://caronline.yfgps.com/carlife/ota", localRequestParams, new JsonHttpResponseHandler()
    {
      public void onFailure(int paramAnonymousInt, f[] paramAnonymousArrayOff, Throwable paramAnonymousThrowable, JSONObject paramAnonymousJSONObject)
      {
        i.b("OTAUPDATE", "HttpResponseHandler onFailure: ");
        if (a.this.b != null) {
          a.this.b.a(paramBoolean);
        }
      }
      
      public void onSuccess(int paramAnonymousInt, f[] paramAnonymousArrayOff, JSONObject paramAnonymousJSONObject)
      {
        i.b("OTAUPDATE", "HttpResponseHandler onSuccess: ");
        try
        {
          if (paramAnonymousJSONObject.getInt("error") != 0) {
            break label235;
          }
          a.this.d = paramAnonymousJSONObject.getString("url");
          a.this.f = paramAnonymousJSONObject.getString("tips");
          a.this.j = paramAnonymousJSONObject.getLong("length");
          a.this.e = paramAnonymousJSONObject.getString("md5");
          a.this.g = ("" + paramAnonymousJSONObject.getLong("versionCode"));
          if ((!paramBoolean) && (a.this.i.equals(a.this.g)))
          {
            a.this.b.b(false);
            return;
          }
          if ((a.this.k) && (a.this.l.equals(a.this.c))) {
            return;
          }
          if (a.b(a.this))
          {
            a.this.a(new File(a.a(a.this)));
            return;
          }
        }
        catch (JSONException paramAnonymousArrayOff)
        {
          paramAnonymousArrayOff.printStackTrace();
          return;
        }
        a.this.b.a(a.this.f, a.this.j);
        return;
        label235:
        a.this.b.b(paramBoolean);
      }
    });
  }
  
  public void b()
  {
    this.k = true;
    this.l = this.c;
    String str = h();
    File localFile = new File(str);
    if (localFile.exists())
    {
      if (localFile.length() == this.j)
      {
        a(localFile);
        return;
      }
      localFile.delete();
    }
    com.baidu.carlife.custom.elhyf.a.a().setURLEncodingEnabled(false);
    com.baidu.carlife.custom.elhyf.a.a().get(this.d, new FileAsyncHttpResponseHandler(new File(str))
    {
      public void onFailure(int paramAnonymousInt, f[] paramAnonymousArrayOff, Throwable paramAnonymousThrowable, File paramAnonymousFile)
      {
        a.this.k = false;
        a.this.l = "";
        Log.i("mai", "retryCount:" + a.d(a.this));
        if (a.d(a.this) >= 2)
        {
          a.a(a.this, 0);
          a.this.b.a(paramAnonymousInt);
          return;
        }
        a.c(a.this).postDelayed(new Runnable()
        {
          public void run()
          {
            a.e(a.this);
            a.this.b();
          }
        }, 3000L);
      }
      
      public void onProgress(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        super.onProgress(paramAnonymousLong1, paramAnonymousLong2);
        int i = (int)(100L * paramAnonymousLong1 / paramAnonymousLong2);
        a.this.b.b(i);
      }
      
      public void onSuccess(int paramAnonymousInt, f[] paramAnonymousArrayOff, File paramAnonymousFile)
      {
        a.this.k = false;
        a.this.l = "";
        a.this.a(paramAnonymousFile);
      }
    });
    com.baidu.carlife.custom.elhyf.a.a().setURLEncodingEnabled(true);
  }
  
  public void c()
  {
    this.i = this.g;
    f();
  }
  
  public boolean d()
  {
    return (this.c != null) && (!"".equals(this.c));
  }
  
  public void e()
  {
    Object localObject = new File(a);
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
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
    
    public abstract void a(String paramString, long paramLong);
    
    public abstract void a(String paramString1, String paramString2, String paramString3);
    
    public abstract void a(boolean paramBoolean);
    
    public abstract void b(int paramInt);
    
    public abstract void b(boolean paramBoolean);
    
    public abstract void g();
    
    public abstract void h();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/custom/elhyf/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */