package com.baidu.tts.auth;

import android.content.Context;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.f.n;
import com.baidu.tts.h.a.c;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.k.a;
import com.baidu.tts.tools.StringTool;
import java.io.File;

public class b
  implements com.baidu.tts.k.b<b, a>
{
  private String a;
  private String b;
  
  public int a(b paramb)
  {
    String str = paramb.a();
    paramb = paramb.b();
    boolean bool1 = StringTool.isEqual(this.a, str);
    boolean bool2 = StringTool.isEqual(this.b, paramb);
    if ((bool1) && (bool2)) {
      return 0;
    }
    return 1;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public a c()
    throws Exception
  {
    a locala = new a();
    locala.a(this.b);
    locala.b(this.a);
    if (!locala.g())
    {
      Object localObject = com.baidu.tts.h.b.b.a();
      Context localContext = ((com.baidu.tts.h.b.b)localObject).h();
      localObject = ((com.baidu.tts.h.b.b)localObject).i();
      LoggerProxy.d("OfflineAuth", "+ downloadLicense");
      int i = EmbeddedSynthesizerEngine.bdTTSGetLicense(localContext, this.a, (String)localObject, "0", "", this.b);
      LoggerProxy.d("OfflineAuth", "- downloadLicense ret = " + i);
      locala.a(i);
      if (i < 0) {
        locala.a(c.a().a(n.t, i, "appCode=" + this.a + "--licensePath=" + this.b));
      }
    }
    else
    {
      return locala;
    }
    locala.g();
    return locala;
  }
  
  public static class a
    implements a
  {
    private int a;
    private int b = -1;
    private String c;
    private String d;
    private TtsError e;
    
    public int a()
    {
      if (this.a >= 1000) {
        return this.a - 1000;
      }
      return 0;
    }
    
    public void a(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void a(TtsError paramTtsError)
    {
      if (paramTtsError != null) {
        LoggerProxy.d("OfflineAuth", "this=" + this + "--error=" + paramTtsError.getDetailMessage());
      }
      this.e = paramTtsError;
    }
    
    public void a(String paramString)
    {
      this.c = paramString;
    }
    
    public TtsError b()
    {
      return this.e;
    }
    
    public void b(String paramString)
    {
      this.d = paramString;
    }
    
    public String c()
    {
      if (e()) {
        return "valid official";
      }
      if (d()) {
        return "valid temp";
      }
      switch (this.a)
      {
      case -9: 
      default: 
        return "not a valid result";
      case -2: 
        return "package name unmatched";
      case -3: 
        return "sign or appcode unmatched";
      case -4: 
        return "cuid unmatched";
      case -5: 
        return "official license expired";
      case -6: 
        return "will expire after a month";
      case -7: 
        return "platform unmatched";
      case -8: 
        return "license not exist or invalid license";
      }
      return "temp license expired";
    }
    
    public boolean d()
    {
      return this.a >= 1000;
    }
    
    public boolean e()
    {
      return (this.a >= 0) && (this.a < 1000);
    }
    
    public boolean f()
    {
      return (this.a == -5) || (this.a == -6);
    }
    
    public boolean g()
    {
      if (StringTool.isEmpty(this.c)) {}
      File localFile;
      do
      {
        return false;
        localFile = new File(this.c);
      } while (!localFile.exists());
      Object localObject = com.baidu.tts.h.b.b.a();
      Context localContext = ((com.baidu.tts.h.b.b)localObject).h();
      localObject = ((com.baidu.tts.h.b.b)localObject).i();
      byte[] arrayOfByte = new byte[32];
      this.a = EmbeddedSynthesizerEngine.bdTTSVerifyLicense(localContext, this.d, (String)localObject, this.c, arrayOfByte);
      LoggerProxy.d("OfflineAuth", "verify result=" + this.a);
      if (arrayOfByte != null)
      {
        localObject = new String(arrayOfByte);
        LoggerProxy.d("OfflineAuth", "get appIdStr=" + (String)localObject);
      }
      try
      {
        int i = ((String)localObject).indexOf("end");
        if (i != -1) {
          new com.baidu.tts.e.b(localContext, ((String)localObject).substring(0, i)).start();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool;
          LoggerProxy.d("OfflineAuth", "embedded statistics start exception=" + localException.toString());
        }
      }
      if (this.a < 0)
      {
        bool = localFile.delete();
        LoggerProxy.d("OfflineAuth", "isDelete=" + bool);
        return false;
      }
      return true;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/auth/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */