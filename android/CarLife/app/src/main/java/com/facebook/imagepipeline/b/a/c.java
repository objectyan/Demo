package com.facebook.imagepipeline.b.a;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import b.ab;
import b.ab.a;
import b.ad;
import b.ae;
import b.d.a;
import b.f;
import b.p;
import b.y;
import com.facebook.common.e.a;
import com.facebook.imagepipeline.i.d;
import com.facebook.imagepipeline.l.ae.a;
import com.facebook.imagepipeline.l.aj;
import com.facebook.imagepipeline.l.j;
import com.facebook.imagepipeline.l.r;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class c
  extends com.facebook.imagepipeline.l.c<a>
{
  private static final String a = "OkHttpNetworkFetchProducer";
  private static final String b = "queue_time";
  private static final String c = "fetch_time";
  private static final String d = "total_time";
  private static final String e = "image_size";
  private final y f;
  private Executor g;
  
  public c(y paramy)
  {
    this.f = paramy;
    this.g = paramy.u().a();
  }
  
  private void a(b.e parame, Exception paramException, ae.a parama)
  {
    if (parame.e())
    {
      parama.a();
      return;
    }
    parama.a(paramException);
  }
  
  public a a(j<d> paramj, aj paramaj)
  {
    return new a(paramj, paramaj);
  }
  
  public void a(a parama, int paramInt)
  {
    parama.c = SystemClock.elapsedRealtime();
  }
  
  public void a(final a parama, final ae.a parama1)
  {
    parama.a = SystemClock.elapsedRealtime();
    final Object localObject = parama.e();
    localObject = new ab.a().a(new d.a().b().e()).a(((Uri)localObject).toString()).a().d();
    localObject = this.f.a((ab)localObject);
    parama.b().a(new com.facebook.imagepipeline.l.e()
    {
      public void a()
      {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          localObject.c();
          return;
        }
        c.a(c.this).execute(new Runnable()
        {
          public void run()
          {
            c.1.this.a.c();
          }
        });
      }
    });
    ((b.e)localObject).a(new f()
    {
      public void a(b.e paramAnonymouse, ad paramAnonymousad)
        throws IOException
      {
        parama.b = SystemClock.elapsedRealtime();
        localae = paramAnonymousad.h();
        try
        {
          if (!paramAnonymousad.d())
          {
            c.a(c.this, paramAnonymouse, new IOException("Unexpected HTTP code " + paramAnonymousad), parama1);
            try
            {
              localae.close();
              return;
            }
            catch (Exception paramAnonymouse)
            {
              a.d("OkHttpNetworkFetchProducer", "Exception when closing response body", paramAnonymouse);
              return;
            }
          }
          long l2 = localae.b();
          long l1 = l2;
          if (l2 < 0L) {
            l1 = 0L;
          }
          parama1.a(localae.d(), (int)l1);
          try
          {
            localae.close();
            return;
          }
          catch (Exception paramAnonymouse)
          {
            a.d("OkHttpNetworkFetchProducer", "Exception when closing response body", paramAnonymouse);
            return;
          }
          try
          {
            localae.close();
            throw paramAnonymouse;
          }
          catch (Exception paramAnonymousad)
          {
            for (;;)
            {
              a.d("OkHttpNetworkFetchProducer", "Exception when closing response body", paramAnonymousad);
            }
          }
        }
        catch (Exception paramAnonymousad)
        {
          paramAnonymousad = paramAnonymousad;
          c.a(c.this, paramAnonymouse, paramAnonymousad, parama1);
          try
          {
            localae.close();
            return;
          }
          catch (Exception paramAnonymouse)
          {
            a.d("OkHttpNetworkFetchProducer", "Exception when closing response body", paramAnonymouse);
            return;
          }
        }
        finally {}
      }
      
      public void a(b.e paramAnonymouse, IOException paramAnonymousIOException)
      {
        c.a(c.this, paramAnonymouse, paramAnonymousIOException, parama1);
      }
    });
  }
  
  public Map<String, String> b(a parama, int paramInt)
  {
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("queue_time", Long.toString(parama.b - parama.a));
    localHashMap.put("fetch_time", Long.toString(parama.c - parama.b));
    localHashMap.put("total_time", Long.toString(parama.c - parama.a));
    localHashMap.put("image_size", Integer.toString(paramInt));
    return localHashMap;
  }
  
  public static class a
    extends r
  {
    public long a;
    public long b;
    public long c;
    
    public a(j<d> paramj, aj paramaj)
    {
      super(paramaj);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */