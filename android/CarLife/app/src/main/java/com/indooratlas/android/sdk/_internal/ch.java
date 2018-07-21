package com.indooratlas.android.sdk._internal;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ch
  extends ds
{
  protected final cq b;
  
  public ch(bf parambf)
  {
    this.b = new cq(parambf.v);
  }
  
  public final void a(cx paramcx, dd paramdd)
  {
    int i;
    if ((paramcx.a != null) && ((paramcx.a.a() == -100) || (paramcx.a.a() == -101)))
    {
      i = 1;
      if (i == 0) {
        break label358;
      }
      localObject2 = (List)paramcx.c;
      localObject1 = this.b;
      if (localObject2 != null)
      {
        ((List)localObject2).size();
        long l = ((cq)localObject1).d;
        l = ((cq)localObject1).e;
        ((cq)localObject1).d = ((cq)localObject1).c.a();
        ((cq)localObject1).e = SystemClock.elapsedRealtime();
        if (!((List)localObject2).isEmpty())
        {
          localObject2 = new ArrayList((Collection)localObject2);
          Collections.sort((List)localObject2, cu.a);
          localObject2 = ((List)localObject2).iterator();
        }
      }
    }
    else
    {
      label144:
      label231:
      label276:
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label279;
        }
        dx localdx = (dx)((Iterator)localObject2).next();
        if (localdx.h != 0)
        {
          int j = localdx.g;
          if ((j >= 2412) && (j <= 2484)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label231;
            }
            if (!((cq)localObject1).a(((cq)localObject1).b, localdx)) {
              break label144;
            }
            break label144;
            i = 0;
            break;
          }
          if ((j >= 5170) && (j <= 5825)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label276;
            }
            if (!((cq)localObject1).a(((cq)localObject1).a, localdx)) {
              break;
            }
            break;
          }
        }
      }
    }
    label279:
    Object localObject2 = this.b;
    Object localObject1 = new ff.h();
    ((ff.h)localObject1).b = ((cq)localObject2).d;
    ((ff.h)localObject1).d = cq.a(((cq)localObject2).b);
    ((ff.h)localObject1).e = cq.a(((cq)localObject2).a);
    localObject2 = this.b;
    ((cq)localObject2).b.clear();
    ((cq)localObject2).a.clear();
    a((ff.h)localObject1);
    label358:
    super.a(paramcx, paramdd);
  }
  
  public void a(ff.h paramh) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */