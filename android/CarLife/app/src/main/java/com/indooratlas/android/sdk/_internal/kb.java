package com.indooratlas.android.sdk._internal;

import java.nio.ByteBuffer;

public final class kb
  extends ke
  implements ka
{
  static final ByteBuffer a = ByteBuffer.allocate(0);
  private int f;
  private String g;
  
  public kb()
  {
    super(kd.a.f);
    a(true);
  }
  
  public kb(byte paramByte)
    throws ju
  {
    super(kd.a.f);
    a(true);
    a(1000, "");
  }
  
  public kb(int paramInt, String paramString)
    throws ju
  {
    super(kd.a.f);
    a(true);
    a(paramInt, paramString);
  }
  
  private void a(int paramInt, String paramString)
    throws ju
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 1015)
      {
        paramString = "";
        i = 1005;
      }
      if (i == 1005)
      {
        if (paramString.length() > 0) {
          throw new ju(1002, "A close frame must have a closecode if it has a reason");
        }
      }
      else
      {
        paramString = kp.a(paramString);
        ByteBuffer localByteBuffer1 = ByteBuffer.allocate(4);
        localByteBuffer1.putInt(i);
        localByteBuffer1.position(2);
        ByteBuffer localByteBuffer2 = ByteBuffer.allocate(paramString.length + 2);
        localByteBuffer2.put(localByteBuffer1);
        localByteBuffer2.put(paramString);
        localByteBuffer2.rewind();
        a(localByteBuffer2);
      }
      return;
    }
  }
  
  public final int a()
  {
    return this.f;
  }
  
  public final void a(ByteBuffer paramByteBuffer)
    throws ju
  {
    super.a(paramByteBuffer);
    this.f = 1005;
    paramByteBuffer = super.c();
    paramByteBuffer.mark();
    if (paramByteBuffer.remaining() >= 2)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.position(2);
      localByteBuffer.putShort(paramByteBuffer.getShort());
      localByteBuffer.position(0);
      this.f = localByteBuffer.getInt();
      if ((this.f == 1006) || (this.f == 1015) || (this.f == 1005) || (this.f > 4999) || (this.f < 1000) || (this.f == 1004)) {
        throw new jv("closecode must not be sent over the wire: " + this.f);
      }
    }
    paramByteBuffer.reset();
    if (this.f == 1005)
    {
      this.g = kp.a(super.c());
      return;
    }
    paramByteBuffer = super.c();
    int i = paramByteBuffer.position();
    try
    {
      paramByteBuffer.position(paramByteBuffer.position() + 2);
      this.g = kp.a(paramByteBuffer);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new jv(localIllegalArgumentException);
    }
    finally
    {
      paramByteBuffer.position(i);
    }
  }
  
  public final String b()
  {
    return this.g;
  }
  
  public final ByteBuffer c()
  {
    if (this.f == 1005) {
      return a;
    }
    return super.c();
  }
  
  public final String toString()
  {
    return super.toString() + "code: " + this.f;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/kb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */