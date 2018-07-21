package com.indooratlas.android.sdk._internal;

import android.os.ParcelUuid;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class ce
  extends ds
{
  protected final cl b;
  
  public ce(bf parambf)
  {
    this.b = new cl(parambf.v);
  }
  
  public final void a(cx paramcx, dd paramdd)
  {
    if (paramcx.a())
    {
      if (paramcx.a()) {}
      cl localcl;
      for (Object localObject = (List)paramcx.c;; localObject = null)
      {
        localcl = this.b;
        if (localObject == null) {
          break;
        }
        localcl.f = localcl.e.a();
        localcl.g = SystemClock.elapsedRealtime();
        new StringBuilder("received ").append(((Collection)localObject).size()).append(" ble events at clientTime: %d, systemTime: %d");
        long l = localcl.f;
        l = localcl.g;
        localObject = ((Collection)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          dh localdh = (dh)((Iterator)localObject).next();
          if (localdh != null) {
            localcl.a(localdh);
          }
        }
      }
      if (this.b.a() > 0)
      {
        localcl = this.b;
        localObject = new ff.h();
        ((ff.h)localObject).b = localcl.f;
        ((ff.h)localObject).g = new ff.c();
        ((ff.h)localObject).g.d = localcl.a(localcl.a);
        ((ff.h)localObject).g.b = cl.b(localcl.b);
        localcl = this.b;
        localcl.a.clear();
        localcl.b.clear();
        a((ff.h)localObject);
      }
    }
    super.a(paramcx, paramdd);
  }
  
  public final void a(@Nullable eu.a parama)
  {
    cl localcl = this.b;
    localcl.c = parama;
    localcl.d = null;
    if ((parama != null) && (parama.g != null) && (parama.g.length > 0))
    {
      localcl.d = new HashMap();
      eu.a.a[] arrayOfa = parama.g;
      int j = arrayOfa.length;
      int i = 0;
      if (i < j)
      {
        eu.a.a locala = arrayOfa[i];
        if (locala != null)
        {
          parama = locala.b;
          if (parama != null) {
            break label143;
          }
          parama = null;
          label89:
          if (parama == null) {
            break label241;
          }
          if (localcl.d.containsKey(parama)) {
            new StringBuilder("Duplicate uuid ").append(parama).append(" from server");
          }
          localcl.d.put(parama, locala);
        }
        for (;;)
        {
          i += 1;
          break;
          label143:
          long l2;
          if (parama.length == 2)
          {
            l1 = parama[0] & 0xFF;
            l2 = 4096L + (((parama[1] & 0xFF) << 32) + (l1 << 40));
          }
          for (long l1 = -9223371485494954757L;; l1 = parama.getLong())
          {
            parama = new ParcelUuid(new UUID(l2, l1));
            break;
            if (parama.length != 16) {
              break label236;
            }
            parama = ByteBuffer.wrap(parama);
            l2 = parama.getLong();
          }
          label236:
          parama = null;
          break label89;
          label241:
          new StringBuilder("Cannot convert bytes from server ").append(Arrays.toString(locala.b)).append(" to valid service id.");
        }
      }
    }
  }
  
  public void a(ff.h paramh) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */