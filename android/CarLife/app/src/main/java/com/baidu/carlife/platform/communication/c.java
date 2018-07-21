package com.baidu.carlife.platform.communication;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import com.baidu.carlife.core.i;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class c
{
  public static final String a = "CARLIFE_PLATFORM_SOCKET_SERVER";
  private static final String b = c.class.getSimpleName();
  private static c c;
  private LocalServerSocket d = new LocalServerSocket("CARLIFE_PLATFORM_SOCKET_SERVER");
  private a e = new a();
  private c f;
  private HashMap<String, b> g = new HashMap();
  private Object h = new Object();
  private b i;
  
  private c()
    throws IOException
  {
    this.e.start();
    this.f = new c();
    this.f.start();
  }
  
  public static c a()
  {
    if (c == null) {}
    try
    {
      c = new c();
      return c;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        i.b(b, localIOException);
      }
    }
  }
  
  private boolean a(String paramString, b paramb)
  {
    synchronized (this.h)
    {
      if (this.g.containsKey(paramString)) {
        return false;
      }
      this.g.put(paramString, paramb);
      return true;
    }
  }
  
  public b a(String paramString)
  {
    synchronized (this.h)
    {
      b localb = (b)this.g.get(paramString);
      this.g.remove(paramString);
      return localb;
    }
  }
  
  public void a(b paramb)
  {
    this.i = paramb;
  }
  
  public void b()
  {
    this.e.a();
  }
  
  public void c()
  {
    this.e.c();
    this.f.a();
  }
  
  private class a
    extends Thread
  {
    private boolean b = false;
    private LinkedBlockingQueue<Object> c = new LinkedBlockingQueue();
    private LinkedBlockingQueue<LocalSocket> d = new LinkedBlockingQueue();
    
    public a()
    {
      setName("Carlife AcceptThread");
    }
    
    public void a()
    {
      try
      {
        this.c.put(new Object());
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        i.a(c.d(), localInterruptedException);
      }
    }
    
    public LocalSocket b()
      throws InterruptedException
    {
      return (LocalSocket)this.d.take();
    }
    
    public void c()
    {
      this.b = true;
      interrupt();
    }
    
    public void run()
    {
      try
      {
        for (;;)
        {
          this.c.take();
          LocalSocket localLocalSocket = c.a(c.this).accept();
          if (localLocalSocket != null) {
            try
            {
              this.d.put(localLocalSocket);
            }
            catch (InterruptedException localInterruptedException1)
            {
              i.a(c.d(), localInterruptedException1);
            }
          }
        }
      }
      catch (IOException localIOException)
      {
        i.a(c.d(), localIOException);
        return;
      }
      catch (InterruptedException localInterruptedException2)
      {
        boolean bool;
        do
        {
          i.a(c.d(), localInterruptedException2);
          bool = this.b;
        } while (!bool);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString);
  }
  
  private class c
    extends Thread
  {
    private boolean b = false;
    
    public c()
    {
      setName("Carlife ShakeHandThread");
    }
    
    private CLPackage a(CLPackage paramCLPackage)
      throws IllegalArgumentException
    {
      if ((paramCLPackage != null) && ("Hi,Carlife".equals(paramCLPackage.getDataInString())))
      {
        paramCLPackage = new CLPackage();
        paramCLPackage.setData("CARLIFE_PLATFORM_SOCKET_SERVER");
        return paramCLPackage;
      }
      return null;
    }
    
    private String b(CLPackage paramCLPackage)
    {
      if (paramCLPackage != null) {
        return paramCLPackage.getDataInString();
      }
      return null;
    }
    
    public void a()
    {
      this.b = true;
      interrupt();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: iconst_0
      //   3: istore 5
      //   5: iconst_0
      //   6: istore_2
      //   7: iconst_0
      //   8: istore 6
      //   10: iconst_0
      //   11: istore_3
      //   12: iconst_0
      //   13: istore 4
      //   15: aload_0
      //   16: getfield 15	com/baidu/carlife/platform/communication/c$c:a	Lcom/baidu/carlife/platform/communication/c;
      //   19: invokestatic 66	com/baidu/carlife/platform/communication/c:b	(Lcom/baidu/carlife/platform/communication/c;)Lcom/baidu/carlife/platform/communication/c$a;
      //   22: invokevirtual 71	com/baidu/carlife/platform/communication/c$a:b	()Landroid/net/LocalSocket;
      //   25: astore 16
      //   27: aconst_null
      //   28: astore 14
      //   30: aconst_null
      //   31: astore 15
      //   33: aconst_null
      //   34: astore 13
      //   36: aconst_null
      //   37: astore 10
      //   39: aconst_null
      //   40: astore 12
      //   42: aconst_null
      //   43: astore 11
      //   45: new 73	java/io/ObjectOutputStream
      //   48: dup
      //   49: aload 16
      //   51: invokevirtual 79	android/net/LocalSocket:getOutputStream	()Ljava/io/OutputStream;
      //   54: invokespecial 82	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   57: astore 8
      //   59: new 84	java/io/ObjectInputStream
      //   62: dup
      //   63: aload 16
      //   65: invokevirtual 88	android/net/LocalSocket:getInputStream	()Ljava/io/InputStream;
      //   68: invokespecial 91	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   71: astore 9
      //   73: iload 4
      //   75: istore_1
      //   76: iload 5
      //   78: istore_2
      //   79: iload 6
      //   81: istore_3
      //   82: aload_0
      //   83: aload 9
      //   85: invokevirtual 95	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   88: checkcast 34	com/baidu/carlife/platform/communication/CLPackage
      //   91: invokespecial 97	com/baidu/carlife/platform/communication/c$c:a	(Lcom/baidu/carlife/platform/communication/CLPackage;)Lcom/baidu/carlife/platform/communication/CLPackage;
      //   94: astore 10
      //   96: aload 10
      //   98: ifnonnull +100 -> 198
      //   101: iload 4
      //   103: istore_1
      //   104: iload 5
      //   106: istore_2
      //   107: iload 6
      //   109: istore_3
      //   110: new 30	java/lang/IllegalArgumentException
      //   113: dup
      //   114: ldc 99
      //   116: invokespecial 101	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   119: athrow
      //   120: astore 10
      //   122: invokestatic 104	com/baidu/carlife/platform/communication/c:d	()Ljava/lang/String;
      //   125: aload 10
      //   127: invokestatic 109	com/baidu/carlife/core/i:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   130: iload_1
      //   131: ifne -131 -> 0
      //   134: aload 9
      //   136: ifnull +8 -> 144
      //   139: aload 9
      //   141: invokevirtual 112	java/io/ObjectInputStream:close	()V
      //   144: aload 8
      //   146: ifnull +8 -> 154
      //   149: aload 8
      //   151: invokevirtual 113	java/io/ObjectOutputStream:close	()V
      //   154: aload 16
      //   156: ifnull -156 -> 0
      //   159: aload 16
      //   161: invokevirtual 114	android/net/LocalSocket:close	()V
      //   164: goto -164 -> 0
      //   167: astore 8
      //   169: invokestatic 104	com/baidu/carlife/platform/communication/c:d	()Ljava/lang/String;
      //   172: aload 8
      //   174: invokestatic 109	com/baidu/carlife/core/i:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   177: goto -177 -> 0
      //   180: astore 8
      //   182: invokestatic 104	com/baidu/carlife/platform/communication/c:d	()Ljava/lang/String;
      //   185: aload 8
      //   187: invokestatic 109	com/baidu/carlife/core/i:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   190: aload_0
      //   191: getfield 20	com/baidu/carlife/platform/communication/c$c:b	Z
      //   194: ifeq -194 -> 0
      //   197: return
      //   198: iload 4
      //   200: istore_1
      //   201: iload 5
      //   203: istore_2
      //   204: iload 6
      //   206: istore_3
      //   207: aload 8
      //   209: aload 10
      //   211: invokevirtual 118	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
      //   214: iload 4
      //   216: istore_1
      //   217: iload 5
      //   219: istore_2
      //   220: iload 6
      //   222: istore_3
      //   223: aload_0
      //   224: aload 9
      //   226: invokevirtual 95	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   229: checkcast 34	com/baidu/carlife/platform/communication/CLPackage
      //   232: invokespecial 120	com/baidu/carlife/platform/communication/c$c:b	(Lcom/baidu/carlife/platform/communication/CLPackage;)Ljava/lang/String;
      //   235: astore 10
      //   237: iload 4
      //   239: istore_1
      //   240: iload 5
      //   242: istore_2
      //   243: iload 6
      //   245: istore_3
      //   246: aload 10
      //   248: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   251: ifeq +49 -> 300
      //   254: iload 4
      //   256: istore_1
      //   257: iload 5
      //   259: istore_2
      //   260: iload 6
      //   262: istore_3
      //   263: new 30	java/lang/IllegalArgumentException
      //   266: dup
      //   267: ldc 99
      //   269: invokespecial 101	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   272: athrow
      //   273: astore 11
      //   275: iload_2
      //   276: istore_1
      //   277: aload 9
      //   279: astore 10
      //   281: aload 11
      //   283: astore 9
      //   285: invokestatic 104	com/baidu/carlife/platform/communication/c:d	()Ljava/lang/String;
      //   288: aload 9
      //   290: invokestatic 109	com/baidu/carlife/core/i:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   293: aload 10
      //   295: astore 9
      //   297: goto -167 -> 130
      //   300: iload 4
      //   302: istore_1
      //   303: iload 5
      //   305: istore_2
      //   306: iload 6
      //   308: istore_3
      //   309: new 128	com/baidu/carlife/platform/communication/b
      //   312: dup
      //   313: aload 16
      //   315: aload 10
      //   317: invokespecial 131	com/baidu/carlife/platform/communication/b:<init>	(Landroid/net/LocalSocket;Ljava/lang/String;)V
      //   320: astore 11
      //   322: iload 4
      //   324: istore_1
      //   325: iload 5
      //   327: istore_2
      //   328: iload 6
      //   330: istore_3
      //   331: aload_0
      //   332: getfield 15	com/baidu/carlife/platform/communication/c$c:a	Lcom/baidu/carlife/platform/communication/c;
      //   335: aload 10
      //   337: aload 11
      //   339: invokestatic 134	com/baidu/carlife/platform/communication/c:a	(Lcom/baidu/carlife/platform/communication/c;Ljava/lang/String;Lcom/baidu/carlife/platform/communication/b;)Z
      //   342: ifne +49 -> 391
      //   345: iload 4
      //   347: istore_1
      //   348: iload 5
      //   350: istore_2
      //   351: iload 6
      //   353: istore_3
      //   354: new 30	java/lang/IllegalArgumentException
      //   357: dup
      //   358: ldc 99
      //   360: invokespecial 101	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   363: athrow
      //   364: astore 11
      //   366: iload_3
      //   367: istore_1
      //   368: aload 9
      //   370: astore 10
      //   372: aload 11
      //   374: astore 9
      //   376: invokestatic 104	com/baidu/carlife/platform/communication/c:d	()Ljava/lang/String;
      //   379: aload 9
      //   381: invokestatic 109	com/baidu/carlife/core/i:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   384: aload 10
      //   386: astore 9
      //   388: goto -258 -> 130
      //   391: iconst_1
      //   392: istore 5
      //   394: iconst_1
      //   395: istore 6
      //   397: iconst_1
      //   398: istore 7
      //   400: iconst_1
      //   401: istore 4
      //   403: iload 4
      //   405: istore_1
      //   406: iload 6
      //   408: istore_2
      //   409: iload 7
      //   411: istore_3
      //   412: aload_0
      //   413: getfield 15	com/baidu/carlife/platform/communication/c$c:a	Lcom/baidu/carlife/platform/communication/c;
      //   416: invokestatic 137	com/baidu/carlife/platform/communication/c:c	(Lcom/baidu/carlife/platform/communication/c;)Lcom/baidu/carlife/platform/communication/c$b;
      //   419: ifnull +26 -> 445
      //   422: iload 4
      //   424: istore_1
      //   425: iload 6
      //   427: istore_2
      //   428: iload 7
      //   430: istore_3
      //   431: aload_0
      //   432: getfield 15	com/baidu/carlife/platform/communication/c$c:a	Lcom/baidu/carlife/platform/communication/c;
      //   435: invokestatic 137	com/baidu/carlife/platform/communication/c:c	(Lcom/baidu/carlife/platform/communication/c;)Lcom/baidu/carlife/platform/communication/c$b;
      //   438: aload 10
      //   440: invokeinterface 141 2 0
      //   445: iload 5
      //   447: istore_1
      //   448: goto -318 -> 130
      //   451: astore 9
      //   453: invokestatic 104	com/baidu/carlife/platform/communication/c:d	()Ljava/lang/String;
      //   456: aload 9
      //   458: invokestatic 109	com/baidu/carlife/core/i:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   461: goto -317 -> 144
      //   464: astore 8
      //   466: invokestatic 104	com/baidu/carlife/platform/communication/c:d	()Ljava/lang/String;
      //   469: aload 8
      //   471: invokestatic 109	com/baidu/carlife/core/i:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   474: goto -320 -> 154
      //   477: astore 9
      //   479: aload 12
      //   481: astore 10
      //   483: aload 15
      //   485: astore 8
      //   487: iload_3
      //   488: istore_1
      //   489: goto -113 -> 376
      //   492: astore 9
      //   494: aload 12
      //   496: astore 10
      //   498: iload_3
      //   499: istore_1
      //   500: goto -124 -> 376
      //   503: astore 9
      //   505: aload 14
      //   507: astore 8
      //   509: iload_2
      //   510: istore_1
      //   511: goto -226 -> 285
      //   514: astore 9
      //   516: iload_2
      //   517: istore_1
      //   518: goto -233 -> 285
      //   521: astore 10
      //   523: aload 11
      //   525: astore 9
      //   527: aload 13
      //   529: astore 8
      //   531: goto -409 -> 122
      //   534: astore 10
      //   536: aload 11
      //   538: astore 9
      //   540: goto -418 -> 122
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	543	0	this	c
      //   1	517	1	i	int
      //   6	511	2	j	int
      //   11	488	3	k	int
      //   13	410	4	m	int
      //   3	443	5	n	int
      //   8	418	6	i1	int
      //   398	31	7	i2	int
      //   57	93	8	localObjectOutputStream	java.io.ObjectOutputStream
      //   167	6	8	localIOException1	IOException
      //   180	28	8	localInterruptedException	InterruptedException
      //   464	6	8	localIOException2	IOException
      //   485	45	8	localObject1	Object
      //   71	316	9	localObject2	Object
      //   451	6	9	localIOException3	IOException
      //   477	1	9	localIllegalArgumentException1	IllegalArgumentException
      //   492	1	9	localIllegalArgumentException2	IllegalArgumentException
      //   503	1	9	localClassNotFoundException1	ClassNotFoundException
      //   514	1	9	localClassNotFoundException2	ClassNotFoundException
      //   525	14	9	localIllegalArgumentException3	IllegalArgumentException
      //   37	60	10	localCLPackage	CLPackage
      //   120	90	10	localIOException4	IOException
      //   235	262	10	localObject3	Object
      //   521	1	10	localIOException5	IOException
      //   534	1	10	localIOException6	IOException
      //   43	1	11	localObject4	Object
      //   273	9	11	localClassNotFoundException3	ClassNotFoundException
      //   320	18	11	localb	b
      //   364	173	11	localIllegalArgumentException4	IllegalArgumentException
      //   40	455	12	localObject5	Object
      //   34	494	13	localObject6	Object
      //   28	478	14	localObject7	Object
      //   31	453	15	localObject8	Object
      //   25	289	16	localLocalSocket	LocalSocket
      // Exception table:
      //   from	to	target	type
      //   82	96	120	java/io/IOException
      //   110	120	120	java/io/IOException
      //   207	214	120	java/io/IOException
      //   223	237	120	java/io/IOException
      //   246	254	120	java/io/IOException
      //   263	273	120	java/io/IOException
      //   309	322	120	java/io/IOException
      //   331	345	120	java/io/IOException
      //   354	364	120	java/io/IOException
      //   412	422	120	java/io/IOException
      //   431	445	120	java/io/IOException
      //   159	164	167	java/io/IOException
      //   15	27	180	java/lang/InterruptedException
      //   82	96	273	java/lang/ClassNotFoundException
      //   110	120	273	java/lang/ClassNotFoundException
      //   207	214	273	java/lang/ClassNotFoundException
      //   223	237	273	java/lang/ClassNotFoundException
      //   246	254	273	java/lang/ClassNotFoundException
      //   263	273	273	java/lang/ClassNotFoundException
      //   309	322	273	java/lang/ClassNotFoundException
      //   331	345	273	java/lang/ClassNotFoundException
      //   354	364	273	java/lang/ClassNotFoundException
      //   412	422	273	java/lang/ClassNotFoundException
      //   431	445	273	java/lang/ClassNotFoundException
      //   82	96	364	java/lang/IllegalArgumentException
      //   110	120	364	java/lang/IllegalArgumentException
      //   207	214	364	java/lang/IllegalArgumentException
      //   223	237	364	java/lang/IllegalArgumentException
      //   246	254	364	java/lang/IllegalArgumentException
      //   263	273	364	java/lang/IllegalArgumentException
      //   309	322	364	java/lang/IllegalArgumentException
      //   331	345	364	java/lang/IllegalArgumentException
      //   354	364	364	java/lang/IllegalArgumentException
      //   412	422	364	java/lang/IllegalArgumentException
      //   431	445	364	java/lang/IllegalArgumentException
      //   139	144	451	java/io/IOException
      //   149	154	464	java/io/IOException
      //   45	59	477	java/lang/IllegalArgumentException
      //   59	73	492	java/lang/IllegalArgumentException
      //   45	59	503	java/lang/ClassNotFoundException
      //   59	73	514	java/lang/ClassNotFoundException
      //   45	59	521	java/io/IOException
      //   59	73	534	java/io/IOException
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/communication/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */