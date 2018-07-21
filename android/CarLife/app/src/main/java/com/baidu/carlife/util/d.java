package com.baidu.carlife.util;

import android.os.Environment;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.i;
import java.io.File;

public class d
{
  private static final String a = "CarlifeFile";
  private static final String b = "BaiduCarlife";
  private static final String c = "bnav";
  private static final String d = "public.der";
  private static final String e = "NetWorkDownload";
  private static final String f = "music";
  private static final String g = "keyboard";
  private static final String h = "debugAudioData";
  private static final String i = "debugLog";
  private static final String j = "vehicle";
  private static final String k = "keyboardlib_v4.sqlite";
  private static d n = new d();
  private File l = new File(m(), "BaiduCarlife");
  private File m;
  
  private d()
  {
    if (!this.l.exists()) {
      this.l.mkdir();
    }
    this.m = new File(this.l, "bnav");
    i.b("CarlifeFile", "mCarLifeRootDir=" + this.l + ", mCarLifeNaviDir=" + this.m);
  }
  
  public static d a()
  {
    return n;
  }
  
  private File m()
  {
    try
    {
      File localFile;
      if (Environment.getExternalStorageState().equals("mounted")) {
        localFile = Environment.getExternalStorageDirectory();
      } else {
        localFile = a.a().getFilesDir();
      }
    }
    catch (Exception localException)
    {
      i.e("CarlifeFile", "Get SD Path Failed");
      return null;
    }
    return localException;
  }
  
  public File a(String paramString)
  {
    return new File(this.l, paramString);
  }
  
  public File b()
  {
    return a.a().getDir("h5_database", 0);
  }
  
  public File c()
  {
    return a.a().getDir("h5_cache", 0);
  }
  
  public File d()
  {
    return this.l;
  }
  
  public File e()
  {
    return this.m;
  }
  
  public File f()
  {
    return a("public.der");
  }
  
  public File g()
  {
    return a("NetWorkDownload");
  }
  
  public File h()
  {
    return a("keyboard");
  }
  
  public File i()
  {
    File localFile = h();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile, "keyboardlib_v4.sqlite");
  }
  
  public File j()
  {
    return a("debugAudioData");
  }
  
  public File k()
  {
    return a("debugLog");
  }
  
  public File l()
  {
    return a("vehicle");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */