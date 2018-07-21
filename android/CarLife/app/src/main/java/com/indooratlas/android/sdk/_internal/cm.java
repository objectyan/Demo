package com.indooratlas.android.sdk._internal;

import android.os.Looper;
import android.support.annotation.Nullable;
import com.indooratlas.android.sdk.resources.IAResult;
import com.indooratlas.android.sdk.resources.IAResult.Error;
import com.indooratlas.android.sdk.resources.IAResultCallback;
import com.indooratlas.android.sdk.resources.IATask;

public final class cm<R>
  implements IATask<R>
{
  private aa<R> a;
  
  public cm(aa<R> paramaa)
  {
    this.a = paramaa;
  }
  
  private static IAResult.Error b(ad paramad)
  {
    ad.a locala = paramad.a;
    if (locala == ad.a.c) {
      return IAResult.Error.networkError(paramad.getCause());
    }
    if (locala == ad.a.b) {
      return IAResult.Error.httpError(paramad.b.b(), paramad.b.c());
    }
    return IAResult.Error.conversionError(paramad.getCause());
  }
  
  public final void cancel()
  {
    this.a.a();
  }
  
  public final IAResult<R> get()
  {
    ae localae = this.a.c();
    if (localae.a) {
      return IAResult.success(localae.b);
    }
    return IAResult.failure(b(localae.d));
  }
  
  public final boolean isCancelled()
  {
    return this.a.b();
  }
  
  public final void setCallback(final IAResultCallback<R> paramIAResultCallback, @Nullable final Looper paramLooper)
  {
    this.a.a(new ag()
    {
      public final void a(final ad paramAnonymousad)
      {
        cm.a(paramLooper, new Runnable()
        {
          public final void run()
          {
            cm.1.this.b.onResult(IAResult.failure(cm.a(paramAnonymousad)));
          }
        });
      }
      
      public final void a(final ae<R> paramAnonymousae)
      {
        cm.a(paramLooper, new Runnable()
        {
          public final void run()
          {
            cm.1.this.b.onResult(IAResult.success(paramAnonymousae.b));
          }
        });
      }
    });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */