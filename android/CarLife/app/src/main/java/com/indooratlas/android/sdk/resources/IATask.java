package com.indooratlas.android.sdk.resources;

import android.os.Looper;
import android.support.annotation.Nullable;

public abstract interface IATask<R>
{
  public abstract void cancel();
  
  public abstract IAResult<R> get();
  
  public abstract boolean isCancelled();
  
  public abstract void setCallback(IAResultCallback<R> paramIAResultCallback, @Nullable Looper paramLooper);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/resources/IATask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */