package com.baidu.che.codriver.protocol;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Request.Priority;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.util.o;
import java.util.HashMap;
import java.util.Map;

public abstract class b<T>
{
  private static String a = "HttpAsyncTask";
  private boolean b;
  private Request<?> c = null;
  private Class<T> d;
  private d<T> e = null;
  
  public b(d<T> paramd, Class<T> paramClass)
  {
    this.e = paramd;
    this.b = true;
    this.d = paramClass;
  }
  
  protected int a()
  {
    return 0;
  }
  
  public void a(d<T> paramd)
  {
    this.e = paramd;
  }
  
  protected abstract String b();
  
  protected Map<String, String> c()
  {
    return null;
  }
  
  public final void d()
  {
    String str = b();
    if (TextUtils.isEmpty(str))
    {
      h.d(a, "Request URL is null!!!");
      return;
    }
    h.b(a, "Request URL = " + str);
    this.b = false;
    this.c = new c(a(), str, this.d, new Response.Listener()new Response.ErrorListener
    {
      public void onResponse(T paramAnonymousT)
      {
        h.b(b.j(), "onResponse()");
        b.a(b.this, true);
        if (b.a(b.this) != null) {
          b.a(b.this).a(paramAnonymousT);
        }
        b.a(b.this, null);
      }
    }, new Response.ErrorListener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        h.e(b.j(), "onErrorResponse():" + paramAnonymousVolleyError.getMessage());
        if ((paramAnonymousVolleyError != null) && (paramAnonymousVolleyError.getMessage() != null)) {
          h.e(b.j(), paramAnonymousVolleyError.getMessage().toString());
        }
        b.a(b.this, true);
        if (b.a(b.this) != null) {
          b.a(b.this).a(d.a.b);
        }
        b.a(b.this, null);
      }
    })
    {
      public byte[] getBody()
        throws AuthFailureError
      {
        return b.this.h();
      }
      
      public Map<String, String> getHeaders()
        throws AuthFailureError
      {
        return b.this.g();
      }
      
      public Request.Priority getPriority()
      {
        return b.this.i();
      }
    };
    this.c.setRetryPolicy(new DefaultRetryPolicy(6000, 0, 1.0F));
    this.c.setShouldCache(false);
    o.a(this.c);
  }
  
  public boolean e()
  {
    return this.b;
  }
  
  public void f()
  {
    if ((this.c != null) && (!this.c.isCanceled())) {
      this.c.cancel();
    }
  }
  
  protected Map<String, String> g()
  {
    return new HashMap();
  }
  
  protected byte[] h()
  {
    return null;
  }
  
  protected Request.Priority i()
  {
    return Request.Priority.NORMAL;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/protocol/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */