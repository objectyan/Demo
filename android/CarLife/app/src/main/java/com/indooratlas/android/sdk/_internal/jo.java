package com.indooratlas.android.sdk._internal;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class jo
{
  public static int a = 1000;
  public static int b = 64;
  public static final byte[] c = kp.a("<policy-file-request/>\000");
  protected int d = 0;
  protected kd.a e = null;
  
  public static int a(int paramInt)
    throws jx, ju
  {
    if (paramInt < 0) {
      throw new ju(1002, "Negative count");
    }
    return paramInt;
  }
  
  public static kh a(ByteBuffer paramByteBuffer, int paramInt)
    throws jw, jt
  {
    Object localObject1 = c(paramByteBuffer);
    if (localObject1 == null) {
      throw new jt(paramByteBuffer.capacity() + 128);
    }
    Object localObject2 = ((String)localObject1).split(" ", 3);
    if (localObject2.length != 3) {
      throw new jw();
    }
    if (paramInt == jj.b.a)
    {
      localObject1 = new kj();
      kn localkn = (kn)localObject1;
      localkn.a(Short.parseShort(localObject2[1]));
      localkn.a(localObject2[2]);
    }
    for (;;)
    {
      localObject2 = c(paramByteBuffer);
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break;
      }
      localObject2 = ((String)localObject2).split(":", 2);
      if (localObject2.length != 2)
      {
        throw new jw("not an http header");
        localObject1 = new ki();
        ((kg)localObject1).a(localObject2[1]);
      }
      else
      {
        ((kh)localObject1).a(localObject2[0], localObject2[1].replaceFirst("^ +", ""));
      }
    }
    if (localObject2 == null) {
      throw new jt();
    }
    return (kh)localObject1;
  }
  
  protected static boolean a(kk paramkk)
  {
    return (paramkk.b("Upgrade").equalsIgnoreCase("websocket")) && (paramkk.b("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"));
  }
  
  public static List<ByteBuffer> b(kk paramkk)
  {
    Object localObject1 = new StringBuilder(100);
    if ((paramkk instanceof kf))
    {
      ((StringBuilder)localObject1).append("GET ");
      ((StringBuilder)localObject1).append(((kf)paramkk).a());
      ((StringBuilder)localObject1).append(" HTTP/1.1");
    }
    Object localObject2;
    for (;;)
    {
      ((StringBuilder)localObject1).append("\r\n");
      localObject2 = paramkk.b();
      while (((Iterator)localObject2).hasNext())
      {
        String str1 = (String)((Iterator)localObject2).next();
        String str2 = paramkk.b(str1);
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(": ");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append("\r\n");
      }
      if (!(paramkk instanceof km)) {
        break;
      }
      ((StringBuilder)localObject1).append("HTTP/1.1 101 " + ((km)paramkk).a());
    }
    throw new RuntimeException("unknow role");
    ((StringBuilder)localObject1).append("\r\n");
    localObject1 = kp.b(((StringBuilder)localObject1).toString());
    paramkk = paramkk.c();
    if (paramkk == null) {}
    for (int i = 0;; i = paramkk.length)
    {
      localObject2 = ByteBuffer.allocate(i + localObject1.length);
      ((ByteBuffer)localObject2).put((byte[])localObject1);
      if (paramkk != null) {
        ((ByteBuffer)localObject2).put(paramkk);
      }
      ((ByteBuffer)localObject2).flip();
      return Collections.singletonList(localObject2);
    }
  }
  
  private static String c(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.remaining());
    byte b1;
    for (int i = 48;; i = b1) {
      if (paramByteBuffer.hasRemaining())
      {
        b1 = paramByteBuffer.get();
        localByteBuffer.put(b1);
        if ((i == 13) && (b1 == 10))
        {
          localByteBuffer.limit(localByteBuffer.position() - 2);
          localByteBuffer.position(0);
        }
      }
      else
      {
        for (paramByteBuffer = localByteBuffer; paramByteBuffer == null; paramByteBuffer = null)
        {
          return null;
          paramByteBuffer.position(paramByteBuffer.position() - localByteBuffer.position());
        }
        return kp.a(paramByteBuffer.array(), paramByteBuffer.limit());
      }
    }
  }
  
  public abstract int a(kf paramkf)
    throws jw;
  
  public abstract int a(kf paramkf, km paramkm)
    throws jw;
  
  public abstract kg a(kg paramkg)
    throws jw;
  
  public abstract kh a(kf paramkf, kn paramkn)
    throws jw;
  
  public abstract ByteBuffer a(kd paramkd);
  
  public abstract List<kd> a(ByteBuffer paramByteBuffer)
    throws ju;
  
  public abstract List<kd> a(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public abstract void a();
  
  public abstract int b();
  
  public kk b(ByteBuffer paramByteBuffer)
    throws jw
  {
    return a(paramByteBuffer, this.d);
  }
  
  public final void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public abstract jo c();
  
  public static enum a {}
  
  public static enum b {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/jo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */