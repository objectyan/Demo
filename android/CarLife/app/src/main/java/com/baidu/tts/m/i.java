package com.baidu.tts.m;

import android.text.TextUtils;
import com.baidu.tts.n.a;
import java.io.UnsupportedEncodingException;

public class i
  extends a<i>
{
  private String a;
  private String b;
  private String c = "0";
  private com.baidu.tts.f.i d;
  private String e;
  
  public i(String paramString1, String paramString2)
  {
    b(paramString1);
    d(paramString2);
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.e)) {
      this.a = (this.e + this.a);
    }
  }
  
  public void a(com.baidu.tts.f.i parami)
  {
    this.d = parami;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public void b(String paramString)
  {
    this.a = paramString;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public void c(String paramString)
  {
    this.b = paramString;
  }
  
  public String d()
  {
    return this.b;
  }
  
  public void d(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    this.c = str;
  }
  
  public byte[] e()
  {
    try
    {
      byte[] arrayOfByte = this.a.getBytes(this.b);
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }
  
  public String f()
  {
    return this.c;
  }
  
  public com.baidu.tts.f.i g()
  {
    return this.d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/m/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */