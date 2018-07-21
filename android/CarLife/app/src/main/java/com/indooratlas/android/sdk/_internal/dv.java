package com.indooratlas.android.sdk._internal;

import android.os.Handler;
import android.support.annotation.NonNull;

public final class dv
{
  @NonNull
  final cy a;
  @NonNull
  final cw b;
  @NonNull
  final da c;
  
  public dv(@NonNull cy paramcy, @NonNull cw paramcw, @NonNull da paramda)
  {
    eg.a(paramcy, "listener cannot be null", new Object[0]);
    eg.a(paramcw, "listener cannot be null", new Object[0]);
    eg.a(paramda, "listener cannot be null", new Object[0]);
    this.a = paramcy;
    this.b = paramcw;
    this.c = paramda;
  }
  
  public final void a()
  {
    if (this.c.a != null) {
      this.c.a.post(new Runnable()
      {
        public final void run() {}
      });
    }
  }
  
  public final void a(final cx paramcx)
  {
    eg.a(paramcx, "event must not be null", new Object[0]);
    if (this.c.a != null)
    {
      localObject = cz.a;
      localObject = this.c.a;
      this.c.a.post(new Runnable()
      {
        public final void run()
        {
          dv.this.a.a(paramcx);
        }
      });
      return;
    }
    Object localObject = cz.a;
    this.a.a(paramcx);
  }
  
  public final void b()
  {
    if (this.c.a != null) {
      this.c.a.post(new Runnable()
      {
        public final void run() {}
      });
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */