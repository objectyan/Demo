package com.indooratlas.android.sdk._internal;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public abstract class ek<T>
  extends Handler
{
  private final WeakReference<T> a;
  
  public ek(T paramT)
  {
    this.a = new WeakReference(paramT);
  }
  
  public abstract void a(T paramT, Message paramMessage);
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject = this.a.get();
    if (localObject != null) {
      a(localObject, paramMessage);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */