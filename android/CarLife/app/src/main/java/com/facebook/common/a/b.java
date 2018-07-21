package com.facebook.common.a;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.facebook.common.internal.k;
import java.lang.ref.WeakReference;

public class b
{
  public static void a(a parama, Context paramContext)
  {
    Context localContext = paramContext;
    if (!(paramContext instanceof d))
    {
      localContext = paramContext;
      if ((paramContext instanceof ContextWrapper)) {
        localContext = ((ContextWrapper)paramContext).getBaseContext();
      }
    }
    if ((localContext instanceof d)) {
      ((d)localContext).a(new a(parama));
    }
  }
  
  private static class a
    extends c
  {
    private final WeakReference<a> a;
    
    public a(a parama)
    {
      this.a = new WeakReference(parama);
    }
    
    private a g(Activity paramActivity)
    {
      a locala = (a)this.a.get();
      if (locala == null)
      {
        k.a(paramActivity instanceof d);
        ((d)paramActivity).b(this);
      }
      return locala;
    }
    
    public void a(Activity paramActivity)
    {
      a locala = g(paramActivity);
      if (locala != null) {
        locala.a(paramActivity);
      }
    }
    
    public void b(Activity paramActivity)
    {
      a locala = g(paramActivity);
      if (locala != null) {
        locala.b(paramActivity);
      }
    }
    
    public void c(Activity paramActivity)
    {
      a locala = g(paramActivity);
      if (locala != null) {
        locala.c(paramActivity);
      }
    }
    
    public void d(Activity paramActivity)
    {
      a locala = g(paramActivity);
      if (locala != null) {
        locala.d(paramActivity);
      }
    }
    
    public void e(Activity paramActivity)
    {
      a locala = g(paramActivity);
      if (locala != null) {
        locala.e(paramActivity);
      }
    }
    
    public void f(Activity paramActivity)
    {
      a locala = g(paramActivity);
      if (locala != null) {
        locala.f(paramActivity);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */