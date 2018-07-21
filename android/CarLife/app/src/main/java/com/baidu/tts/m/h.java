package com.baidu.tts.m;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.f.e;

public class h
  extends com.baidu.tts.n.a<h>
{
  public int a;
  private e b;
  private int c;
  private int d;
  private String e;
  private int f;
  private int g;
  private byte[] h;
  private com.baidu.tts.f.a i;
  private i j;
  private TtsError k;
  
  public static h a(i parami, TtsError paramTtsError)
  {
    parami = b(parami);
    parami.a(paramTtsError);
    return parami;
  }
  
  public static h b(TtsError paramTtsError)
  {
    h localh = new h();
    localh.a(paramTtsError);
    return localh;
  }
  
  public static h b(i parami)
  {
    h localh = new h();
    localh.a(parami);
    return localh;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(TtsError paramTtsError)
  {
    this.k = paramTtsError;
  }
  
  public void a(com.baidu.tts.f.a parama)
  {
    this.i = parama;
  }
  
  public void a(e parame)
  {
    this.b = parame;
  }
  
  public void a(i parami)
  {
    this.j = parami;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.h = paramArrayOfByte;
  }
  
  public int b()
  {
    return this.f;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public int c()
  {
    return this.g;
  }
  
  public void c(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.g = paramInt;
  }
  
  public byte[] d()
  {
    return this.h;
  }
  
  public i e()
  {
    return this.j;
  }
  
  public void e(int paramInt)
  {
    this.c = paramInt;
  }
  
  public TtsError f()
  {
    return this.k;
  }
  
  public e g()
  {
    return this.b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/m/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */