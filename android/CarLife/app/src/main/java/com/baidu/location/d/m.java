package com.baidu.location.d;

import com.baidu.location.a.a;
import com.baidu.location.f.f;
import java.util.Locale;

public class m
{
  private long a = 0L;
  private long b = 0L;
  private long c = 0L;
  private long d = 0L;
  private int e = 0;
  private long f = 0L;
  private long g = 0L;
  private String h = null;
  private String i = null;
  private String j = null;
  
  public void a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = 0;
    this.f = 0L;
    this.g = 0L;
    this.h = null;
    this.i = null;
    this.j = null;
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e = 1;
      return;
    }
    this.e = 0;
  }
  
  public long b()
  {
    return this.g;
  }
  
  public void b(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void b(String paramString)
  {
    if (this.j == null)
    {
      this.j = paramString;
      return;
    }
    this.j = String.format("%s%s", new Object[] { this.j, paramString });
  }
  
  public String c()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    f.a();
    if (f.j()) {}
    for (this.h = "&cn=32";; this.h = String.format(Locale.CHINA, "&cn=%d", new Object[] { Integer.valueOf(com.baidu.location.f.b.a().e()) }))
    {
      localStringBuffer.append(this.h);
      localStringBuffer.append(String.format(Locale.CHINA, "&fir=%d&tim=%d&dsc=%d&det=%d&ded=%d&typ=%s", new Object[] { Integer.valueOf(this.e), Long.valueOf(this.a), Long.valueOf(this.b - this.a), Long.valueOf(this.c - this.b), Long.valueOf(this.d - this.c), this.i }));
      if (this.j != null) {
        localStringBuffer.append(this.j);
      }
      localStringBuffer.append(com.baidu.location.h.b.a().a(false));
      localStringBuffer.append(a.a().f());
      return localStringBuffer.toString();
    }
  }
  
  public void c(long paramLong)
  {
    this.c = paramLong;
  }
  
  public String d()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    f.a();
    long l;
    if (f.j())
    {
      this.h = "&cn=32";
      localStringBuffer.append(this.h);
      l = this.g - this.f;
      if (l >= 0L) {
        break label82;
      }
    }
    label82:
    while (l > 600000L)
    {
      return null;
      this.h = String.format(Locale.CHINA, "&cn=%d", new Object[] { Integer.valueOf(com.baidu.location.f.b.a().e()) });
      break;
    }
    localStringBuffer.append(String.format(Locale.CHINA, "&dgps=%d", new Object[] { Long.valueOf(this.g - this.f) }));
    if (this.j != null) {
      localStringBuffer.append(this.j);
    }
    localStringBuffer.append(com.baidu.location.h.b.a().a(false));
    localStringBuffer.append(a.a().f());
    return localStringBuffer.toString();
  }
  
  public void d(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void e(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void f(long paramLong)
  {
    this.g = paramLong;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */