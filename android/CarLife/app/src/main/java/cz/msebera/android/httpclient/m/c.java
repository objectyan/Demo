package cz.msebera.android.httpclient.m;

import java.util.concurrent.Future;

public abstract interface c<T, E>
{
  public abstract Future<E> a(T paramT, Object paramObject, cz.msebera.android.httpclient.c.c<E> paramc);
  
  public abstract void a(E paramE, boolean paramBoolean);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/m/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */