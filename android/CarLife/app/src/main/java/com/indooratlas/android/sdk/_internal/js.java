package com.indooratlas.android.sdk._internal;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class js
  extends jr
{
  private static final byte[] j = { -1, 0 };
  private boolean i = false;
  private final Random k = new Random();
  
  private static byte[] a(String paramString)
    throws jw
  {
    long l2;
    try
    {
      l1 = Long.parseLong(paramString.replaceAll("[^0-9]", ""));
      l2 = paramString.split(" ").length - 1;
      if (l2 == 0L) {
        throw new jw("invalid Sec-WebSocket-Key (/key2/)");
      }
    }
    catch (NumberFormatException paramString)
    {
      throw new jw("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
    }
    long l1 = new Long(l1 / l2).longValue();
    int m = (byte)(int)(l1 >> 24);
    int n = (byte)(int)(l1 << 8 >> 24);
    int i1 = (byte)(int)(l1 << 16 >> 24);
    int i2 = (byte)(int)(l1 << 24 >> 24);
    return new byte[] { m, n, i1, i2 };
  }
  
  private static byte[] a(String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws jw
  {
    paramString1 = a(paramString1);
    paramString2 = a(paramString2);
    int m = paramString1[0];
    int n = paramString1[1];
    int i1 = paramString1[2];
    int i2 = paramString1[3];
    int i3 = paramString2[0];
    int i4 = paramString2[1];
    int i5 = paramString2[2];
    int i6 = paramString2[3];
    int i7 = paramArrayOfByte[0];
    int i8 = paramArrayOfByte[1];
    int i9 = paramArrayOfByte[2];
    int i10 = paramArrayOfByte[3];
    int i11 = paramArrayOfByte[4];
    int i12 = paramArrayOfByte[5];
    int i13 = paramArrayOfByte[6];
    int i14 = paramArrayOfByte[7];
    try
    {
      paramString1 = MessageDigest.getInstance("MD5");
      return paramString1.digest(new byte[] { m, n, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14 });
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
  }
  
  private static String d()
  {
    Random localRandom = new Random();
    long l = localRandom.nextInt(12) + 1;
    String str = Long.toString((localRandom.nextInt(Math.abs(new Long(4294967295L / l).intValue())) + 1) * l);
    int n = localRandom.nextInt(12);
    int m = 0;
    while (m < n + 1)
    {
      int i1 = Math.abs(localRandom.nextInt(str.length()));
      char c2 = (char)(localRandom.nextInt(95) + 33);
      char c1 = c2;
      if (c2 >= '0')
      {
        c1 = c2;
        if (c2 <= '9') {
          c1 = (char)(c2 - '\017');
        }
      }
      str = new StringBuilder(str).insert(i1, c1).toString();
      m += 1;
    }
    m = 0;
    while (m < l)
    {
      n = Math.abs(localRandom.nextInt(str.length() - 1) + 1);
      str = new StringBuilder(str).insert(n, " ").toString();
      m += 1;
    }
    return str;
  }
  
  public final int a(kf paramkf)
  {
    if ((paramkf.b("Upgrade").equals("WebSocket")) && (paramkf.b("Connection").contains("Upgrade")) && (paramkf.b("Sec-WebSocket-Key1").length() > 0) && (!paramkf.b("Sec-WebSocket-Key2").isEmpty()) && (paramkf.c("Origin"))) {
      return jo.b.a;
    }
    return jo.b.b;
  }
  
  public final int a(kf paramkf, km paramkm)
  {
    if (this.i) {
      return jo.b.b;
    }
    try
    {
      if ((!paramkm.b("Sec-WebSocket-Origin").equals(paramkf.b("Origin"))) || (!a(paramkm))) {
        return jo.b.b;
      }
      paramkm = paramkm.c();
      if ((paramkm == null) || (paramkm.length == 0)) {
        throw new jt();
      }
    }
    catch (jw paramkf)
    {
      throw new RuntimeException("bad handshakerequest", paramkf);
    }
    if (Arrays.equals(paramkm, a(paramkf.b("Sec-WebSocket-Key1"), paramkf.b("Sec-WebSocket-Key2"), paramkf.c()))) {
      return jo.b.a;
    }
    int m = jo.b.b;
    return m;
  }
  
  public final kg a(kg paramkg)
  {
    paramkg.a("Upgrade", "WebSocket");
    paramkg.a("Connection", "Upgrade");
    paramkg.a("Sec-WebSocket-Key1", d());
    paramkg.a("Sec-WebSocket-Key2", d());
    if (!paramkg.c("Origin")) {
      paramkg.a("Origin", "random" + this.k.nextInt());
    }
    byte[] arrayOfByte = new byte[8];
    this.k.nextBytes(arrayOfByte);
    paramkg.a(arrayOfByte);
    return paramkg;
  }
  
  public final kh a(kf paramkf, kn paramkn)
    throws jw
  {
    paramkn.a("WebSocket Protocol Handshake");
    paramkn.a("Upgrade", "WebSocket");
    paramkn.a("Connection", paramkf.b("Connection"));
    paramkn.a("Sec-WebSocket-Origin", paramkf.b("Origin"));
    paramkn.a("Sec-WebSocket-Location", "ws://" + paramkf.b("Host") + paramkf.a());
    String str1 = paramkf.b("Sec-WebSocket-Key1");
    String str2 = paramkf.b("Sec-WebSocket-Key2");
    paramkf = paramkf.c();
    if ((str1 == null) || (str2 == null) || (paramkf == null) || (paramkf.length != 8)) {
      throw new jw("Bad keys");
    }
    paramkn.a(a(str1, str2, paramkf));
    return paramkn;
  }
  
  public final ByteBuffer a(kd paramkd)
  {
    if (paramkd.f() == kd.a.f) {
      return ByteBuffer.wrap(j);
    }
    return super.a(paramkd);
  }
  
  public final List<kd> a(ByteBuffer paramByteBuffer)
    throws ju
  {
    paramByteBuffer.mark();
    List localList2 = super.c(paramByteBuffer);
    List localList1 = localList2;
    if (localList2 == null)
    {
      paramByteBuffer.reset();
      localList1 = this.g;
      this.f = true;
      if (this.h == null)
      {
        this.h = ByteBuffer.allocate(2);
        if (paramByteBuffer.remaining() > this.h.remaining()) {
          throw new jv();
        }
      }
      else
      {
        throw new jv();
      }
      this.h.put(paramByteBuffer);
      if (this.h.hasRemaining()) {
        break label137;
      }
      if (Arrays.equals(this.h.array(), j)) {
        localList1.add(new kb((byte)0));
      }
    }
    else
    {
      return localList1;
    }
    throw new jv();
    label137:
    this.g = new LinkedList();
    return localList1;
  }
  
  public final int b()
  {
    return jo.a.b;
  }
  
  public final kk b(ByteBuffer paramByteBuffer)
    throws jw
  {
    kh localkh = a(paramByteBuffer, this.d);
    if (((localkh.c("Sec-WebSocket-Key1")) || (this.d == jj.b.a)) && (!localkh.c("Sec-WebSocket-Version"))) {
      if (this.d != jj.b.b) {
        break label77;
      }
    }
    for (int m = 8;; m = 16)
    {
      byte[] arrayOfByte = new byte[m];
      try
      {
        paramByteBuffer.get(arrayOfByte);
        localkh.a(arrayOfByte);
        return localkh;
      }
      catch (BufferUnderflowException localBufferUnderflowException)
      {
        label77:
        throw new jt(paramByteBuffer.capacity() + 16);
      }
    }
  }
  
  public final jo c()
  {
    return new js();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/js.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */