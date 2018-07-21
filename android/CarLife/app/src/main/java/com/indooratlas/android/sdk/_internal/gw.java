package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

public class gw
{
  private static final gw a = ;
  
  public static gw a()
  {
    return a;
  }
  
  public static String b()
  {
    return "OkHttp";
  }
  
  /* Error */
  private static gw c()
  {
    // Byte code:
    //   0: ldc 34
    //   2: invokestatic 40	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: pop
    //   6: new 42	com/indooratlas/android/sdk/_internal/gv
    //   9: dup
    //   10: aconst_null
    //   11: ldc 44
    //   13: iconst_1
    //   14: anewarray 36	java/lang/Class
    //   17: dup
    //   18: iconst_0
    //   19: getstatic 50	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   22: aastore
    //   23: invokespecial 53	com/indooratlas/android/sdk/_internal/gv:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   26: astore 5
    //   28: new 42	com/indooratlas/android/sdk/_internal/gv
    //   31: dup
    //   32: aconst_null
    //   33: ldc 55
    //   35: iconst_1
    //   36: anewarray 36	java/lang/Class
    //   39: dup
    //   40: iconst_0
    //   41: ldc 57
    //   43: aastore
    //   44: invokespecial 53	com/indooratlas/android/sdk/_internal/gv:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   47: astore 6
    //   49: ldc 59
    //   51: invokestatic 40	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   54: astore_0
    //   55: aload_0
    //   56: ldc 61
    //   58: iconst_1
    //   59: anewarray 36	java/lang/Class
    //   62: dup
    //   63: iconst_0
    //   64: ldc 63
    //   66: aastore
    //   67: invokevirtual 67	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   70: astore_1
    //   71: aload_0
    //   72: ldc 69
    //   74: iconst_1
    //   75: anewarray 36	java/lang/Class
    //   78: dup
    //   79: iconst_0
    //   80: ldc 63
    //   82: aastore
    //   83: invokevirtual 67	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   86: astore_2
    //   87: ldc 71
    //   89: invokestatic 40	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   92: pop
    //   93: new 42	com/indooratlas/android/sdk/_internal/gv
    //   96: dup
    //   97: ldc 73
    //   99: ldc 75
    //   101: iconst_0
    //   102: anewarray 36	java/lang/Class
    //   105: invokespecial 53	com/indooratlas/android/sdk/_internal/gv:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   108: astore_0
    //   109: new 42	com/indooratlas/android/sdk/_internal/gv
    //   112: dup
    //   113: aconst_null
    //   114: ldc 77
    //   116: iconst_1
    //   117: anewarray 36	java/lang/Class
    //   120: dup
    //   121: iconst_0
    //   122: ldc 73
    //   124: aastore
    //   125: invokespecial 53	com/indooratlas/android/sdk/_internal/gv:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   128: astore_3
    //   129: aload_1
    //   130: astore 4
    //   132: aload_0
    //   133: astore_1
    //   134: aload 4
    //   136: astore_0
    //   137: new 6	com/indooratlas/android/sdk/_internal/gw$a
    //   140: dup
    //   141: aload 5
    //   143: aload 6
    //   145: aload_0
    //   146: aload_2
    //   147: aload_1
    //   148: aload_3
    //   149: invokespecial 80	com/indooratlas/android/sdk/_internal/gw$a:<init>	(Lcom/indooratlas/android/sdk/_internal/gv;Lcom/indooratlas/android/sdk/_internal/gv;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/indooratlas/android/sdk/_internal/gv;Lcom/indooratlas/android/sdk/_internal/gv;)V
    //   152: areturn
    //   153: astore_0
    //   154: ldc 82
    //   156: invokestatic 40	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   159: pop
    //   160: goto -154 -> 6
    //   163: astore_0
    //   164: ldc 84
    //   166: invokestatic 40	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   169: astore_0
    //   170: new 86	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   177: ldc 84
    //   179: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: ldc 93
    //   184: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 40	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   193: astore_1
    //   194: new 86	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   201: ldc 84
    //   203: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 98
    //   208: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 40	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   217: astore_2
    //   218: new 86	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   225: ldc 84
    //   227: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc 100
    //   232: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 40	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   241: astore_3
    //   242: new 9	com/indooratlas/android/sdk/_internal/gw$b
    //   245: dup
    //   246: aload_0
    //   247: ldc 102
    //   249: iconst_2
    //   250: anewarray 36	java/lang/Class
    //   253: dup
    //   254: iconst_0
    //   255: ldc 104
    //   257: aastore
    //   258: dup
    //   259: iconst_1
    //   260: aload_1
    //   261: aastore
    //   262: invokevirtual 67	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   265: aload_0
    //   266: ldc 106
    //   268: iconst_1
    //   269: anewarray 36	java/lang/Class
    //   272: dup
    //   273: iconst_0
    //   274: ldc 104
    //   276: aastore
    //   277: invokevirtual 67	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   280: aload_0
    //   281: ldc 108
    //   283: iconst_1
    //   284: anewarray 36	java/lang/Class
    //   287: dup
    //   288: iconst_0
    //   289: ldc 104
    //   291: aastore
    //   292: invokevirtual 67	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   295: aload_2
    //   296: aload_3
    //   297: invokespecial 111	com/indooratlas/android/sdk/_internal/gw$b:<init>	(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    //   300: astore_0
    //   301: aload_0
    //   302: areturn
    //   303: astore_0
    //   304: new 2	com/indooratlas/android/sdk/_internal/gw
    //   307: dup
    //   308: invokespecial 112	com/indooratlas/android/sdk/_internal/gw:<init>	()V
    //   311: areturn
    //   312: astore_0
    //   313: aconst_null
    //   314: astore_0
    //   315: aconst_null
    //   316: astore 4
    //   318: aload_1
    //   319: astore_3
    //   320: aload_0
    //   321: astore_1
    //   322: aload_3
    //   323: astore_0
    //   324: aload 4
    //   326: astore_3
    //   327: goto -190 -> 137
    //   330: astore_0
    //   331: aconst_null
    //   332: astore_0
    //   333: aconst_null
    //   334: astore_2
    //   335: aconst_null
    //   336: astore_3
    //   337: aload_0
    //   338: astore_1
    //   339: aload_3
    //   340: astore_0
    //   341: aconst_null
    //   342: astore 4
    //   344: aload_1
    //   345: astore_3
    //   346: aload_0
    //   347: astore_1
    //   348: aload_3
    //   349: astore_0
    //   350: aload 4
    //   352: astore_3
    //   353: goto -216 -> 137
    //   356: astore_0
    //   357: goto -53 -> 304
    //   360: astore_0
    //   361: aload_1
    //   362: astore_0
    //   363: goto -30 -> 333
    //   366: astore_0
    //   367: aconst_null
    //   368: astore_0
    //   369: aconst_null
    //   370: astore_2
    //   371: aconst_null
    //   372: astore_1
    //   373: goto -32 -> 341
    //   376: astore_0
    //   377: aconst_null
    //   378: astore_0
    //   379: aconst_null
    //   380: astore_2
    //   381: goto -40 -> 341
    //   384: astore_0
    //   385: aconst_null
    //   386: astore_0
    //   387: goto -46 -> 341
    //   390: astore_3
    //   391: goto -50 -> 341
    //   394: astore_3
    //   395: goto -80 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   54	92	0	localObject1	Object
    //   153	1	0	localClassNotFoundException1	ClassNotFoundException
    //   163	1	0	localClassNotFoundException2	ClassNotFoundException
    //   169	133	0	localObject2	Object
    //   303	1	0	localClassNotFoundException3	ClassNotFoundException
    //   312	1	0	localClassNotFoundException4	ClassNotFoundException
    //   314	10	0	localObject3	Object
    //   330	1	0	localClassNotFoundException5	ClassNotFoundException
    //   332	18	0	localObject4	Object
    //   356	1	0	localNoSuchMethodException1	NoSuchMethodException
    //   360	1	0	localClassNotFoundException6	ClassNotFoundException
    //   362	1	0	localObject5	Object
    //   366	1	0	localNoSuchMethodException2	NoSuchMethodException
    //   368	1	0	localObject6	Object
    //   376	1	0	localNoSuchMethodException3	NoSuchMethodException
    //   378	1	0	localObject7	Object
    //   384	1	0	localNoSuchMethodException4	NoSuchMethodException
    //   386	1	0	localObject8	Object
    //   70	303	1	localObject9	Object
    //   86	295	2	localObject10	Object
    //   128	225	3	localObject11	Object
    //   390	1	3	localNoSuchMethodException5	NoSuchMethodException
    //   394	1	3	localClassNotFoundException7	ClassNotFoundException
    //   130	221	4	localObject12	Object
    //   26	116	5	localgv1	gv
    //   47	97	6	localgv2	gv
    // Exception table:
    //   from	to	target	type
    //   0	6	153	java/lang/ClassNotFoundException
    //   6	49	163	java/lang/ClassNotFoundException
    //   137	153	163	java/lang/ClassNotFoundException
    //   154	160	163	java/lang/ClassNotFoundException
    //   164	301	303	java/lang/ClassNotFoundException
    //   87	109	312	java/lang/ClassNotFoundException
    //   49	71	330	java/lang/ClassNotFoundException
    //   164	301	356	java/lang/NoSuchMethodException
    //   71	87	360	java/lang/ClassNotFoundException
    //   49	71	366	java/lang/NoSuchMethodException
    //   71	87	376	java/lang/NoSuchMethodException
    //   87	109	384	java/lang/NoSuchMethodException
    //   109	129	390	java/lang/NoSuchMethodException
    //   109	129	394	java/lang/ClassNotFoundException
  }
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public void a(SSLSocket paramSSLSocket) {}
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<gi> paramList) {}
  
  public String b(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  static final class a
    extends gw
  {
    private final gv<Socket> a;
    private final gv<Socket> b;
    private final Method c;
    private final Method d;
    private final gv<Socket> e;
    private final gv<Socket> f;
    
    public a(gv<Socket> paramgv1, gv<Socket> paramgv2, Method paramMethod1, Method paramMethod2, gv<Socket> paramgv3, gv<Socket> paramgv4)
    {
      this.a = paramgv1;
      this.b = paramgv2;
      this.c = paramMethod1;
      this.d = paramMethod2;
      this.e = paramgv3;
      this.f = paramgv4;
    }
    
    public final void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
      throws IOException
    {
      try
      {
        paramSocket.connect(paramInetSocketAddress, paramInt);
        return;
      }
      catch (AssertionError paramSocket)
      {
        if (gy.a(paramSocket)) {
          throw new IOException(paramSocket);
        }
        throw paramSocket;
      }
      catch (SecurityException paramSocket)
      {
        paramInetSocketAddress = new IOException("Exception in connect");
        paramInetSocketAddress.initCause(paramSocket);
        throw paramInetSocketAddress;
      }
    }
    
    public final void a(SSLSocket paramSSLSocket, String paramString, List<gi> paramList)
    {
      if (paramString != null)
      {
        this.a.a(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
        this.b.a(paramSSLSocket, new Object[] { paramString });
      }
      if ((this.f != null) && (this.f.a(paramSSLSocket)))
      {
        paramString = new in();
        int j = paramList.size();
        int i = 0;
        while (i < j)
        {
          gi localgi = (gi)paramList.get(i);
          if (localgi != gi.a)
          {
            paramString.b(localgi.toString().length());
            paramString.a(localgi.toString());
          }
          i += 1;
        }
        paramString = paramString.n();
        this.f.b(paramSSLSocket, new Object[] { paramString });
      }
    }
    
    public final String b(SSLSocket paramSSLSocket)
    {
      if (this.e == null) {
        return null;
      }
      if (!this.e.a(paramSSLSocket)) {
        return null;
      }
      paramSSLSocket = (byte[])this.e.b(paramSSLSocket, new Object[0]);
      if (paramSSLSocket != null) {
        return new String(paramSSLSocket, gy.c);
      }
      return null;
    }
  }
  
  static final class b
    extends gw
  {
    private final Method a;
    private final Method b;
    private final Method c;
    private final Class<?> d;
    private final Class<?> e;
    
    public b(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
    {
      this.a = paramMethod1;
      this.b = paramMethod2;
      this.c = paramMethod3;
      this.d = paramClass1;
      this.e = paramClass2;
    }
    
    public final void a(SSLSocket paramSSLSocket)
    {
      try
      {
        this.c.invoke(null, new Object[] { paramSSLSocket });
        return;
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        for (;;) {}
      }
    }
    
    public final void a(SSLSocket paramSSLSocket, String paramString, List<gi> paramList)
    {
      paramString = new ArrayList(paramList.size());
      int j = paramList.size();
      int i = 0;
      Object localObject;
      while (i < j)
      {
        localObject = (gi)paramList.get(i);
        if (localObject != gi.a) {
          paramString.add(((gi)localObject).toString());
        }
        i += 1;
      }
      try
      {
        paramList = gw.class.getClassLoader();
        localObject = this.d;
        Class localClass = this.e;
        paramString = new gw.c(paramString);
        paramString = Proxy.newProxyInstance(paramList, new Class[] { localObject, localClass }, paramString);
        this.a.invoke(null, new Object[] { paramSSLSocket, paramString });
        return;
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError(paramSSLSocket);
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        for (;;) {}
      }
    }
    
    public final String b(SSLSocket paramSSLSocket)
    {
      try
      {
        paramSSLSocket = (gw.c)Proxy.getInvocationHandler(this.b.invoke(null, new Object[] { paramSSLSocket }));
        if ((!gw.c.a(paramSSLSocket)) && (gw.c.b(paramSSLSocket) == null))
        {
          gs.a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
          return null;
        }
        if (gw.c.a(paramSSLSocket)) {
          return null;
        }
        paramSSLSocket = gw.c.b(paramSSLSocket);
        return paramSSLSocket;
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        for (;;) {}
      }
    }
  }
  
  static final class c
    implements InvocationHandler
  {
    private final List<String> a;
    private boolean b;
    private String c;
    
    public c(List<String> paramList)
    {
      this.a = paramList;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      String str = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      paramObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        paramObject = gy.b;
      }
      if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
        return Boolean.valueOf(true);
      }
      if ((str.equals("unsupported")) && (Void.TYPE == localClass))
      {
        this.b = true;
        return null;
      }
      if ((str.equals("protocols")) && (paramObject.length == 0)) {
        return this.a;
      }
      if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
      {
        paramObject = (List)paramObject[0];
        int j = ((List)paramObject).size();
        int i = 0;
        while (i < j)
        {
          if (this.a.contains(((List)paramObject).get(i)))
          {
            paramObject = (String)((List)paramObject).get(i);
            this.c = ((String)paramObject);
            return paramObject;
          }
          i += 1;
        }
        paramObject = (String)this.a.get(0);
        this.c = ((String)paramObject);
        return paramObject;
      }
      if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramObject.length == 1))
      {
        this.c = ((String)paramObject[0]);
        return null;
      }
      return paramMethod.invoke(this, (Object[])paramObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/gw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */