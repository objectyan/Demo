package com.indooratlas.android.sdk._internal;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class bq
{
  public gh a;
  public String b;
  public final List<c> c = new ArrayList();
  AtomicBoolean d = new AtomicBoolean(false);
  public b e;
  public String f;
  private final gg g;
  private String h;
  private final fs i = new fs()
  {
    public final void a(fr paramAnonymousfr, IOException paramAnonymousIOException)
    {
      ee.a("IACore", "Failed to send: ", new Object[] { paramAnonymousIOException });
      bq.this.d.set(false);
    }
    
    public final void a(gm arg1)
      throws IOException
    {
      if (???.c())
      {
        new StringBuilder("Sent to: ").append(???.a().a()).append("\n\t").append(???.a().a("Authorization")).append("\n\t").append(???.a().a("Content-Range"));
        synchronized (bq.this.c)
        {
          if (!bq.this.c.isEmpty()) {
            bq.this.c.remove(0);
          }
          bq.this.d.set(false);
          bq.this.a();
          return;
        }
      }
      new StringBuilder("Failed to send, statusCode: ").append(???.b()).append(", message: ").append(???.d());
      bq.this.d.set(false);
    }
  };
  
  private bq(@NonNull String paramString)
  {
    this.h = (paramString + "/cpa-binlogs/v1/");
    this.g = gg.a("application/x-protobuf");
  }
  
  public final void a()
  {
    if (this.d.get()) {
      return;
    }
    synchronized (this.c)
    {
      if (!this.c.isEmpty())
      {
        Object localObject1 = (c)this.c.get(0);
        if (this.a != null)
        {
          this.d.set(true);
          String str = "events " + ((c)localObject1).b + "-" + ((c)localObject1).c;
          localObject1 = new gk.a().a(this.h + ((c)localObject1).d).a(gl.a(this.g, ((c)localObject1).a)).b("Content-Type", "application/x-protobuf").b("Authorization", "IDA-Key " + this.b).b("Content-Range", str).b("Content-Length", String.valueOf(((c)localObject1).a.length)).a(str).a();
          this.a.a((gk)localObject1).a(this.i);
        }
      }
      return;
    }
  }
  
  public final void b()
  {
    synchronized (this.c)
    {
      this.c.clear();
      return;
    }
  }
  
  public static final class a
  {
    public String a;
    public bq.b b;
    public gh c;
    public String d;
  }
  
  public static abstract interface b {}
  
  public final class c
  {
    final byte[] a;
    final long b;
    final long c;
    public final String d;
    
    public c(byte[] paramArrayOfByte, long paramLong1, long paramLong2, String paramString)
    {
      this.a = paramArrayOfByte;
      this.b = paramLong1;
      this.c = paramLong2;
      this.d = paramString;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */