package com.indooratlas.android.sdk._internal;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class jp
  extends jo
{
  private ByteBuffer g;
  private kd h = null;
  private final Random i = new Random();
  
  static
  {
    if (!jp.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      f = bool;
      return;
    }
  }
  
  private static String a(String paramString)
  {
    paramString = paramString.trim();
    paramString = paramString + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      return ko.a(localMessageDigest.digest(paramString.getBytes()));
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  private static byte[] a(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int j = 0;
    while (j < paramInt)
    {
      arrayOfByte[j] = ((byte)(int)(paramLong >>> paramInt * 8 - 8 - j * 8));
      j += 1;
    }
    return arrayOfByte;
  }
  
  public static int c(kk paramkk)
  {
    int j = -1;
    paramkk = paramkk.b("Sec-WebSocket-Version");
    if (paramkk.length() > 0) {}
    try
    {
      j = new Integer(paramkk.trim()).intValue();
      return j;
    }
    catch (NumberFormatException paramkk) {}
    return -1;
  }
  
  private kd c(ByteBuffer paramByteBuffer)
    throws jp.a, ju
  {
    int k = 10;
    int i1 = 0;
    int i2 = paramByteBuffer.remaining();
    if (i2 < 2) {
      throw new a(2);
    }
    int n = paramByteBuffer.get();
    if (n >> 8 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      j = (byte)((n & 0x7F) >> 4);
      if (j == 0) {
        break;
      }
      throw new jv("bad rsv " + j);
    }
    int j = paramByteBuffer.get();
    if ((j & 0xFFFFFF80) != 0) {}
    for (int m = 1;; m = 0)
    {
      j = (byte)(j & 0x7F);
      n = (byte)(n & 0xF);
      switch (n)
      {
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        throw new jv("unknow optcode " + (short)n);
      }
    }
    kd.a locala = kd.a.a;
    while ((!bool) && ((locala == kd.a.d) || (locala == kd.a.e) || (locala == kd.a.f)))
    {
      throw new jv("control frames may no be fragmented");
      locala = kd.a.b;
      continue;
      locala = kd.a.c;
      continue;
      locala = kd.a.f;
      continue;
      locala = kd.a.d;
      continue;
      locala = kd.a.e;
    }
    Object localObject;
    if ((j < 0) || (j > 125))
    {
      if ((locala == kd.a.d) || (locala == kd.a.e) || (locala == kd.a.f)) {
        throw new jv("more than 125 octets");
      }
      if (j == 126)
      {
        if (i2 < 4) {
          throw new a(4);
        }
        localObject = new byte[3];
        localObject[1] = paramByteBuffer.get();
        localObject[2] = paramByteBuffer.get();
        j = new BigInteger((byte[])localObject).intValue();
        k = 4;
      }
    }
    for (;;)
    {
      if (m != 0) {}
      for (n = 4;; n = 0)
      {
        k = n + k + j;
        if (i2 >= k) {
          break label518;
        }
        throw new a(k);
        if (i2 < 10) {
          throw new a(10);
        }
        localObject = new byte[8];
        j = 0;
        while (j < 8)
        {
          localObject[j] = paramByteBuffer.get();
          j += 1;
        }
        long l = new BigInteger((byte[])localObject).longValue();
        if (l > 2147483647L) {
          throw new jx("Payloadsize is to big...");
        }
        j = (int)l;
        break;
      }
      label518:
      localObject = ByteBuffer.allocate(a(j));
      if (m != 0)
      {
        byte[] arrayOfByte = new byte[4];
        paramByteBuffer.get(arrayOfByte);
        k = i1;
        while (k < j)
        {
          ((ByteBuffer)localObject).put((byte)(paramByteBuffer.get() ^ arrayOfByte[(k % 4)]));
          k += 1;
        }
      }
      ((ByteBuffer)localObject).put(paramByteBuffer.array(), paramByteBuffer.position(), ((ByteBuffer)localObject).limit());
      paramByteBuffer.position(paramByteBuffer.position() + ((ByteBuffer)localObject).limit());
      if (locala == kd.a.f) {
        paramByteBuffer = new kb();
      }
      for (;;)
      {
        ((ByteBuffer)localObject).flip();
        paramByteBuffer.a((ByteBuffer)localObject);
        return paramByteBuffer;
        paramByteBuffer = new ke();
        paramByteBuffer.a(bool);
        paramByteBuffer.a(locala);
      }
      k = 2;
    }
  }
  
  public int a(kf paramkf)
    throws jw
  {
    int j = c(paramkf);
    if ((j == 7) || (j == 8))
    {
      if (a(paramkf)) {
        return jo.b.a;
      }
      return jo.b.b;
    }
    return jo.b.b;
  }
  
  public final int a(kf paramkf, km paramkm)
    throws jw
  {
    if ((!paramkf.c("Sec-WebSocket-Key")) || (!paramkm.c("Sec-WebSocket-Accept"))) {
      return jo.b.b;
    }
    paramkm = paramkm.b("Sec-WebSocket-Accept");
    if (a(paramkf.b("Sec-WebSocket-Key")).equals(paramkm)) {
      return jo.b.a;
    }
    return jo.b.b;
  }
  
  public kg a(kg paramkg)
  {
    paramkg.a("Upgrade", "websocket");
    paramkg.a("Connection", "Upgrade");
    paramkg.a("Sec-WebSocket-Version", "8");
    byte[] arrayOfByte = new byte[16];
    this.i.nextBytes(arrayOfByte);
    paramkg.a("Sec-WebSocket-Key", ko.a(arrayOfByte));
    return paramkg;
  }
  
  public final kh a(kf paramkf, kn paramkn)
    throws jw
  {
    paramkn.a("Upgrade", "websocket");
    paramkn.a("Connection", paramkf.b("Connection"));
    paramkn.a("Switching Protocols");
    paramkf = paramkf.b("Sec-WebSocket-Key");
    if (paramkf == null) {
      throw new jw("missing Sec-WebSocket-Key");
    }
    paramkn.a("Sec-WebSocket-Accept", a(paramkf));
    return paramkn;
  }
  
  public final ByteBuffer a(kd paramkd)
  {
    int m = -128;
    int i2 = 0;
    ByteBuffer localByteBuffer1 = paramkd.c();
    int n;
    int k;
    label40:
    int j;
    label49:
    label57:
    ByteBuffer localByteBuffer2;
    kd.a locala;
    if (this.d == jj.b.a)
    {
      n = 1;
      if (localByteBuffer1.remaining() > 125) {
        break label154;
      }
      k = 1;
      if (k <= 1) {
        break label176;
      }
      j = k + 1;
      if (n == 0) {
        break label181;
      }
      i1 = 4;
      localByteBuffer2 = ByteBuffer.allocate(i1 + (j + 1) + localByteBuffer1.remaining());
      locala = paramkd.f();
      if (locala != kd.a.a) {
        break label187;
      }
      j = 0;
      label92:
      if (!paramkd.d()) {
        break label284;
      }
    }
    label154:
    label176:
    label181:
    label187:
    label284:
    for (int i1 = -128;; i1 = 0)
    {
      localByteBuffer2.put((byte)(j | (byte)i1));
      paramkd = a(localByteBuffer1.remaining(), k);
      if ((f) || (paramkd.length == k)) {
        break label290;
      }
      throw new AssertionError();
      n = 0;
      break;
      if (localByteBuffer1.remaining() <= 65535)
      {
        k = 2;
        break label40;
      }
      k = 8;
      break label40;
      j = k;
      break label49;
      i1 = 0;
      break label57;
      if (locala == kd.a.b)
      {
        j = 1;
        break label92;
      }
      if (locala == kd.a.c)
      {
        j = 2;
        break label92;
      }
      if (locala == kd.a.f)
      {
        j = 8;
        break label92;
      }
      if (locala == kd.a.d)
      {
        j = 9;
        break label92;
      }
      if (locala == kd.a.e)
      {
        j = 10;
        break label92;
      }
      throw new RuntimeException("Don't know how to handle " + locala.toString());
    }
    label290:
    if (k == 1)
    {
      j = paramkd[0];
      if (n != 0) {}
      for (;;)
      {
        localByteBuffer2.put((byte)(j | m));
        if (n == 0) {
          break;
        }
        paramkd = ByteBuffer.allocate(4);
        paramkd.putInt(this.i.nextInt());
        localByteBuffer2.put(paramkd.array());
        j = i2;
        while (localByteBuffer1.hasRemaining())
        {
          localByteBuffer2.put((byte)(localByteBuffer1.get() ^ paramkd.get(j % 4)));
          j += 1;
        }
        m = 0;
      }
    }
    if (k == 2)
    {
      if (n != 0) {}
      for (;;)
      {
        localByteBuffer2.put((byte)(m | 0x7E));
        localByteBuffer2.put(paramkd);
        break;
        m = 0;
      }
    }
    if (k == 8)
    {
      if (n != 0) {}
      for (;;)
      {
        localByteBuffer2.put((byte)(m | 0x7F));
        localByteBuffer2.put(paramkd);
        break;
        m = 0;
      }
    }
    throw new RuntimeException("Size representation not supported/specified");
    localByteBuffer2.put(localByteBuffer1);
    if ((!f) && (localByteBuffer2.remaining() != 0)) {
      throw new AssertionError(localByteBuffer2.remaining());
    }
    localByteBuffer2.flip();
    return localByteBuffer2;
  }
  
  public final List<kd> a(ByteBuffer paramByteBuffer)
    throws jx, ju
  {
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList();
      if (this.g != null) {}
      try
      {
        paramByteBuffer.mark();
        int j = paramByteBuffer.remaining();
        int k = this.g.remaining();
        if (k > j)
        {
          this.g.put(paramByteBuffer.array(), paramByteBuffer.position(), j);
          paramByteBuffer.position(j + paramByteBuffer.position());
          return Collections.emptyList();
        }
        this.g.put(paramByteBuffer.array(), paramByteBuffer.position(), k);
        paramByteBuffer.position(paramByteBuffer.position() + k);
        localLinkedList.add(c((ByteBuffer)this.g.duplicate().position(0)));
        this.g = null;
        while (paramByteBuffer.hasRemaining())
        {
          paramByteBuffer.mark();
          try
          {
            localLinkedList.add(c(paramByteBuffer));
          }
          catch (a locala2)
          {
            paramByteBuffer.reset();
            this.g = ByteBuffer.allocate(a(locala2.a));
            this.g.put(paramByteBuffer);
          }
        }
        return localLinkedList;
      }
      catch (a locala1)
      {
        this.g.limit();
        ByteBuffer localByteBuffer = ByteBuffer.allocate(a(locala1.a));
        if ((!f) && (localByteBuffer.limit() <= this.g.limit())) {
          throw new AssertionError();
        }
        this.g.rewind();
        localByteBuffer.put(this.g);
        this.g = localByteBuffer;
      }
    }
  }
  
  public final List<kd> a(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    ke localke = new ke();
    try
    {
      localke.a(paramByteBuffer);
      localke.a(true);
      localke.a(kd.a.c);
      localke.b(paramBoolean);
      return Collections.singletonList(localke);
    }
    catch (ju paramByteBuffer)
    {
      throw new jy(paramByteBuffer);
    }
  }
  
  public final void a()
  {
    this.g = null;
  }
  
  public final int b()
  {
    return jo.a.c;
  }
  
  public jo c()
  {
    return new jp();
  }
  
  final class a
    extends Throwable
  {
    private static final long serialVersionUID = 7330519489840500997L;
    int a;
    
    public a(int paramInt)
    {
      this.a = paramInt;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/jp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */