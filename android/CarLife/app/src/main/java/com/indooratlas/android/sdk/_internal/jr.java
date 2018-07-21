package com.indooratlas.android.sdk._internal;

import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class jr
  extends jo
{
  protected boolean f = false;
  protected List<kd> g = new LinkedList();
  protected ByteBuffer h;
  private final Random i = new Random();
  
  public int a(kf paramkf)
  {
    if ((paramkf.c("Origin")) && (a(paramkf))) {
      return jo.b.a;
    }
    return jo.b.b;
  }
  
  public int a(kf paramkf, km paramkm)
  {
    if ((paramkf.b("WebSocket-Origin").equals(paramkm.b("Origin"))) && (a(paramkm))) {
      return jo.b.a;
    }
    return jo.b.b;
  }
  
  public kg a(kg paramkg)
    throws jw
  {
    paramkg.a("Upgrade", "WebSocket");
    paramkg.a("Connection", "Upgrade");
    if (!paramkg.c("Origin")) {
      paramkg.a("Origin", "random" + this.i.nextInt());
    }
    return paramkg;
  }
  
  public kh a(kf paramkf, kn paramkn)
    throws jw
  {
    paramkn.a("Web Socket Protocol Handshake");
    paramkn.a("Upgrade", "WebSocket");
    paramkn.a("Connection", paramkf.b("Connection"));
    paramkn.a("WebSocket-Origin", paramkf.b("Origin"));
    paramkn.a("WebSocket-Location", "ws://" + paramkf.b("Host") + paramkf.a());
    return paramkn;
  }
  
  public ByteBuffer a(kd paramkd)
  {
    if (paramkd.f() != kd.a.b) {
      throw new RuntimeException("only text frames supported");
    }
    paramkd = paramkd.c();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramkd.remaining() + 2);
    localByteBuffer.put((byte)0);
    paramkd.mark();
    localByteBuffer.put(paramkd);
    paramkd.reset();
    localByteBuffer.put((byte)-1);
    localByteBuffer.flip();
    return localByteBuffer;
  }
  
  public List<kd> a(ByteBuffer paramByteBuffer)
    throws ju
  {
    paramByteBuffer = c(paramByteBuffer);
    if (paramByteBuffer == null) {
      throw new ju(1002);
    }
    return paramByteBuffer;
  }
  
  public final List<kd> a(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    throw new RuntimeException("not yet implemented");
  }
  
  public final void a()
  {
    this.f = false;
    this.h = null;
  }
  
  public int b()
  {
    return jo.a.a;
  }
  
  public jo c()
  {
    return new jr();
  }
  
  protected final List<kd> c(ByteBuffer paramByteBuffer)
    throws ju
  {
    Object localObject2 = null;
    while (paramByteBuffer.hasRemaining())
    {
      byte b = paramByteBuffer.get();
      if (b == 0)
      {
        if (this.f) {
          throw new jv("unexpected START_OF_FRAME");
        }
        this.f = true;
      }
      else if (b == -1)
      {
        if (!this.f) {
          throw new jv("unexpected END_OF_FRAME");
        }
        if (this.h != null)
        {
          this.h.flip();
          localObject1 = new ke();
          ((ke)localObject1).a(this.h);
          ((ke)localObject1).a(true);
          ((ke)localObject1).a(kd.a.b);
          this.g.add(localObject1);
          this.h = null;
          paramByteBuffer.mark();
        }
        this.f = false;
      }
      else
      {
        localObject1 = localObject2;
        if (!this.f) {
          return localObject1;
        }
        if (this.h == null) {
          this.h = ByteBuffer.allocate(b);
        }
        for (;;)
        {
          this.h.put(b);
          break;
          if (!this.h.hasRemaining())
          {
            localObject1 = this.h;
            ((ByteBuffer)localObject1).flip();
            ByteBuffer localByteBuffer = ByteBuffer.allocate(a(((ByteBuffer)localObject1).capacity() * 2));
            localByteBuffer.put((ByteBuffer)localObject1);
            this.h = localByteBuffer;
          }
        }
      }
    }
    Object localObject1 = this.g;
    this.g = new LinkedList();
    return (List<kd>)localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/jr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */