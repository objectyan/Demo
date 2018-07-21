package com.indooratlas.android.sdk._internal;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class ke
  implements kc
{
  protected static byte[] b = new byte[0];
  private ByteBuffer a;
  protected boolean c;
  protected kd.a d;
  protected boolean e;
  
  public ke() {}
  
  public ke(kd.a parama)
  {
    this.d = parama;
    this.a = ByteBuffer.wrap(b);
  }
  
  public ke(kd paramkd)
  {
    this.c = paramkd.d();
    this.d = paramkd.f();
    this.a = paramkd.c();
    this.e = paramkd.e();
  }
  
  public final void a(kd.a parama)
  {
    this.d = parama;
  }
  
  public void a(ByteBuffer paramByteBuffer)
    throws ju
  {
    this.a = paramByteBuffer;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public ByteBuffer c()
  {
    return this.a;
  }
  
  public final boolean d()
  {
    return this.c;
  }
  
  public final boolean e()
  {
    return this.e;
  }
  
  public final kd.a f()
  {
    return this.d;
  }
  
  public String toString()
  {
    return "Framedata{ optcode:" + this.d + ", fin:" + this.c + ", payloadlength:[pos:" + this.a.position() + ", len:" + this.a.remaining() + "], payload:" + Arrays.toString(kp.a(new String(this.a.array()))) + "}";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */