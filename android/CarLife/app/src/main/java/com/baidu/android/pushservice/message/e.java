package com.baidu.android.pushservice.message;

public class e
{
  protected short a;
  protected short b;
  protected byte[] c;
  protected boolean d;
  protected boolean e = false;
  protected boolean f;
  private k g;
  
  public e(short paramShort)
  {
    this.a = paramShort;
  }
  
  public void a(k paramk)
  {
    this.g = paramk;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public byte[] a()
  {
    return this.c;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public k d()
  {
    return this.g;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("type : ");
    localStringBuffer.append(this.a);
    localStringBuffer.append(", version: ");
    localStringBuffer.append(this.b);
    localStringBuffer.append(", needReply: ");
    localStringBuffer.append(this.d);
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */