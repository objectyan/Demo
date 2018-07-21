package cz.msebera.android.httpclient.l;

import cz.msebera.android.httpclient.o.a;

@Deprecated
public final class h
  implements c
{
  public static int a(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    return paramj.a("http.socket.timeout", 0);
  }
  
  public static void a(j paramj, int paramInt)
  {
    a.a(paramj, "HTTP parameters");
    paramj.b("http.socket.timeout", paramInt);
  }
  
  public static void a(j paramj, boolean paramBoolean)
  {
    a.a(paramj, "HTTP parameters");
    paramj.b("http.socket.reuseaddr", paramBoolean);
  }
  
  public static void b(j paramj, int paramInt)
  {
    a.a(paramj, "HTTP parameters");
    paramj.b("http.socket.buffer-size", paramInt);
  }
  
  public static void b(j paramj, boolean paramBoolean)
  {
    a.a(paramj, "HTTP parameters");
    paramj.b("http.tcp.nodelay", paramBoolean);
  }
  
  public static boolean b(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    return paramj.a("http.socket.reuseaddr", false);
  }
  
  public static void c(j paramj, int paramInt)
  {
    a.a(paramj, "HTTP parameters");
    paramj.b("http.socket.linger", paramInt);
  }
  
  public static void c(j paramj, boolean paramBoolean)
  {
    a.a(paramj, "HTTP parameters");
    paramj.b("http.connection.stalecheck", paramBoolean);
  }
  
  public static boolean c(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    return paramj.a("http.tcp.nodelay", true);
  }
  
  public static int d(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    return paramj.a("http.socket.buffer-size", -1);
  }
  
  public static void d(j paramj, int paramInt)
  {
    a.a(paramj, "HTTP parameters");
    paramj.b("http.connection.timeout", paramInt);
  }
  
  public static void d(j paramj, boolean paramBoolean)
  {
    a.a(paramj, "HTTP parameters");
    paramj.b("http.socket.keepalive", paramBoolean);
  }
  
  public static int e(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    return paramj.a("http.socket.linger", -1);
  }
  
  public static int f(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    return paramj.a("http.connection.timeout", 0);
  }
  
  public static boolean g(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    return paramj.a("http.connection.stalecheck", true);
  }
  
  public static boolean h(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    return paramj.a("http.socket.keepalive", false);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/l/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */