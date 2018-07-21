package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.i.c;
import com.baidu.android.pushservice.j.k;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.android.pushservice.message.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e
{
  private static int c = -1;
  private static Boolean e = Boolean.valueOf(false);
  private static volatile e n;
  private final int A = 30;
  private String B;
  Handler a = new Handler();
  com.baidu.android.pushservice.message.d b;
  private boolean d = false;
  private boolean f = false;
  private HashMap<Long, com.baidu.android.pushservice.e.a> g = new HashMap();
  private b h;
  private a i;
  private boolean j = false;
  private int k = 0;
  private Context l;
  private boolean m = true;
  private boolean o;
  private String p = h.c();
  private int q = 0;
  private Thread r;
  private Runnable s = new Runnable()
  {
    public void run()
    {
      e.h(e.this);
    }
  };
  private Runnable t = new Runnable()
  {
    public void run()
    {
      com.baidu.android.pushservice.g.a.c("PushConnection", " -- Send Timeout --", e.c(e.this).getApplicationContext());
      if (e.i(e.this)) {
        e.d(e.this, false);
      }
      e.this.a(false);
      e.e(e.this);
      p.b("PushConnection Send Timeout " + e.c(e.this).getPackageName() + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + e.h() + System.currentTimeMillis(), e.c(e.this).getApplicationContext());
    }
  };
  private long u = 0L;
  private int[] v = { 180, 300, 360, 420, 540, 720, 900 };
  private int w = 0;
  private int x = 0;
  private final int y = 3;
  private int z = 0;
  
  private e(Context paramContext)
  {
    this.l = paramContext;
    int i1 = g();
    if ((i1 >= 0) && (i1 < this.v.length)) {
      this.w = i1;
    }
    m();
    g.a(this.l).a(this.v[this.w]);
    this.B = k.d(this.l);
    this.q = h.a(this.l);
  }
  
  public static e a(Context paramContext)
  {
    if (n == null) {
      n = new e(paramContext);
    }
    return n;
  }
  
  private void a(final String paramString, final int paramInt)
  {
    com.baidu.android.pushservice.i.d.a().a(new c("insertAgentBehavior", (short)95)
    {
      public void a()
      {
        try
        {
          com.baidu.android.pushservice.h.i locali = new com.baidu.android.pushservice.h.i();
          locali.d = paramString;
          locali.e = System.currentTimeMillis();
          locali.f = b.b(e.c(e.this));
          locali.g = paramInt;
          if (paramString.equals("030303")) {
            locali.i = p.w(e.c(e.this));
          }
          for (;;)
          {
            q.b(e.c(e.this), locali);
            return;
            if (paramString.equals("030301")) {
              locali.i = p.x(e.c(e.this));
            }
          }
          return;
        }
        catch (Exception localException)
        {
          com.baidu.android.pushservice.g.a.c("PushConnection", "insertAgent exception", e.c(e.this).getApplicationContext());
        }
      }
    });
  }
  
  private void i()
  {
    for (;;)
    {
      try
      {
        if ((this.d) || (e.booleanValue()))
        {
          com.baidu.android.pushservice.g.a.c("PushConnection", "Connect return. mConnected:" + this.d + " mConnectting:" + e, this.l.getApplicationContext());
          return;
        }
        if (!j.a(this.l).c())
        {
          com.baidu.android.pushservice.g.a.a("PushConnection", "re-token", this.l.getApplicationContext());
          g.a(this.l).d();
          continue;
        }
        p.b("PushConnection connectImpl from " + this.l.getPackageName() + " at Time " + System.currentTimeMillis(), this.l);
      }
      finally {}
      e = Boolean.valueOf(true);
      c = -1;
      Runnable local1 = new Runnable()
      {
        public void run()
        {
          try
          {
            e.a(PushSocket.createSocket(e.a(e.this), e.b(e.this)));
            Object localObject;
            int i;
            if (a.b() > 0)
            {
              localObject = new com.baidu.android.pushservice.h.i();
              ((com.baidu.android.pushservice.h.i)localObject).d = "039907";
              ((com.baidu.android.pushservice.h.i)localObject).e = System.currentTimeMillis();
              ((com.baidu.android.pushservice.h.i)localObject).f = b.b(e.c(e.this));
              if (e.h() >= 0)
              {
                ((com.baidu.android.pushservice.h.i)localObject).g = 0;
                q.b(e.c(e.this), (com.baidu.android.pushservice.h.i)localObject);
              }
            }
            else
            {
              if ((e.h() != -1) && (e.h() != -2)) {
                break label363;
              }
              i = 132;
            }
            try
            {
              int j = PushSocket.getLastSocketError();
              i = j;
            }
            catch (Exception localException1)
            {
              for (;;) {}
            }
            com.baidu.android.pushservice.g.a.b("PushConnection", "Create socket err, errno: " + i + "socketfd: " + e.h(), e.c(e.this).getApplicationContext());
            if (h.c().equals(e.a(e.this))) {
              e.a(e.this, "030301", i);
            }
            for (;;)
            {
              if (e.h() == -2)
              {
                localObject = h.a(e.c(e.this), e.d(e.this));
                e.a(e.this, false);
                if (!TextUtils.isEmpty((CharSequence)localObject)) {
                  e.a(e.this, (String)localObject);
                }
              }
              if ((e.h() == -1) && (i == 110)) {
                e.a(e.this, 80);
              }
              e.a(Boolean.valueOf(false));
              e.e(e.this);
              p.b("PushConnection Create socket err " + e.c(e.this).getPackageName() + " lastSocketError " + i + " socketfd " + e.h() + System.currentTimeMillis(), e.c(e.this).getApplicationContext());
              return;
              ((com.baidu.android.pushservice.h.i)localObject).g = e.h();
              break;
              e.a(e.this, "030303", 10002);
            }
            label363:
            com.baidu.android.pushservice.g.a.a("PushConnection", "create Socket ok", e.c(e.this).getApplicationContext());
            p.b("create Socket ok socketfd" + e.h(), e.c(e.this));
            e.this.b = new f(e.c(e.this).getApplicationContext());
            e.b(e.this, true);
            if (e.f(e.this) != null) {
              e.f(e.this).interrupt();
            }
            if (e.g(e.this) != null) {
              e.g(e.this).interrupt();
            }
            e.c(e.this, false);
            e.a(e.this, new e.a(e.this));
            e.f(e.this).start();
            e.a(e.this, new e.b(e.this));
            e.g(e.this).start();
            e.this.b.a(e.h());
            if (!h.c().equals(e.a(e.this))) {
              e.a(e.this, "030302", 0);
            }
            e.a(Boolean.valueOf(false));
            e.a(e.this, true);
            e.a(e.this, h.c());
            h.c(e.c(e.this));
            return;
          }
          catch (Exception localException2)
          {
            for (;;) {}
          }
        }
      };
      if (this.r != null) {
        this.r.interrupt();
      }
      this.r = new Thread(local1);
      this.r.setName("PushService-PushService-connect");
      this.r.start();
    }
  }
  
  private void j()
  {
    com.baidu.android.pushservice.g.a.c("PushConnection", "disconnectedByPeer, mStoped == " + this.j, this.l.getApplicationContext());
    p.b("PushConnection destroy from " + this.l.getPackageName() + " at Time " + System.currentTimeMillis(), this.l);
    k();
    if (this.j) {}
    do
    {
      return;
      this.k += 1;
    } while (this.k >= 3);
    this.a.removeCallbacks(this.s);
    int i1 = (this.k - 1) * 30 * 1000;
    if (this.k == 1) {
      i1 = 3000;
    }
    this.a.postDelayed(this.s, i1);
    com.baidu.android.pushservice.g.a.c("PushConnection", "Schedule retry-- retry times: " + this.k + " time delay: " + i1, this.l.getApplicationContext());
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: ldc -49
    //   2: ldc_w 317
    //   5: aload_0
    //   6: getfield 132	com/baidu/android/pushservice/e:l	Landroid/content/Context;
    //   9: invokevirtual 233	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   12: invokestatic 238	com/baidu/android/pushservice/g/a:c	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   15: aload_0
    //   16: getfield 97	com/baidu/android/pushservice/e:a	Landroid/os/Handler;
    //   19: ifnull +14 -> 33
    //   22: aload_0
    //   23: getfield 97	com/baidu/android/pushservice/e:a	Landroid/os/Handler;
    //   26: aload_0
    //   27: getfield 116	com/baidu/android/pushservice/e:t	Ljava/lang/Runnable;
    //   30: invokevirtual 301	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   33: aload_0
    //   34: iconst_1
    //   35: putfield 83	com/baidu/android/pushservice/e:f	Z
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 81	com/baidu/android/pushservice/e:d	Z
    //   43: aload_0
    //   44: getfield 319	com/baidu/android/pushservice/e:b	Lcom/baidu/android/pushservice/message/d;
    //   47: ifnull +25 -> 72
    //   50: aload_0
    //   51: getfield 319	com/baidu/android/pushservice/e:b	Lcom/baidu/android/pushservice/message/d;
    //   54: invokevirtual 324	com/baidu/android/pushservice/message/d:a	()Ljava/util/LinkedList;
    //   57: astore_1
    //   58: aload_1
    //   59: monitorenter
    //   60: aload_0
    //   61: getfield 319	com/baidu/android/pushservice/e:b	Lcom/baidu/android/pushservice/message/d;
    //   64: invokevirtual 324	com/baidu/android/pushservice/message/d:a	()Ljava/util/LinkedList;
    //   67: invokevirtual 327	java/lang/Object:notifyAll	()V
    //   70: aload_1
    //   71: monitorexit
    //   72: getstatic 66	com/baidu/android/pushservice/e:c	I
    //   75: invokestatic 330	com/baidu/android/pushservice/jni/PushSocket:a	(I)V
    //   78: aload_0
    //   79: getfield 319	com/baidu/android/pushservice/e:b	Lcom/baidu/android/pushservice/message/d;
    //   82: ifnull +10 -> 92
    //   85: aload_0
    //   86: getfield 319	com/baidu/android/pushservice/e:b	Lcom/baidu/android/pushservice/message/d;
    //   89: invokevirtual 332	com/baidu/android/pushservice/message/d:b	()V
    //   92: return
    //   93: astore_2
    //   94: aload_1
    //   95: monitorexit
    //   96: aload_2
    //   97: athrow
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 132	com/baidu/android/pushservice/e:l	Landroid/content/Context;
    //   103: aload_1
    //   104: invokestatic 337	com/baidu/android/pushservice/h/q:a	(Landroid/content/Context;Ljava/lang/Throwable;)V
    //   107: goto -35 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	e
    //   98	6	1	localException	Exception
    //   93	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   60	72	93	finally
    //   94	96	93	finally
    //   50	60	98	java/lang/Exception
    //   96	98	98	java/lang/Exception
  }
  
  private void l()
  {
    Object localObject = this.g.keySet();
    long l1 = System.currentTimeMillis();
    i locali = g.a(this.l).c();
    if (locali != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        long l2 = ((Long)((Iterator)localObject).next()).longValue();
        if (l2 < l1)
        {
          locali.a((com.baidu.android.pushservice.e.a)this.g.get(Long.valueOf(l2)));
          this.g.remove(Long.valueOf(l2));
        }
      }
    }
  }
  
  /* Error */
  private void m()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 385	java/io/File
    //   5: dup
    //   6: invokestatic 391	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   9: ldc_w 393
    //   12: invokespecial 396	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_2
    //   16: aload_2
    //   17: invokevirtual 399	java/io/File:exists	()Z
    //   20: ifeq +168 -> 188
    //   23: new 401	java/util/Properties
    //   26: dup
    //   27: invokespecial 402	java/util/Properties:<init>	()V
    //   30: astore 4
    //   32: new 404	java/io/FileInputStream
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 407	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   40: astore_3
    //   41: aload_3
    //   42: astore_2
    //   43: aload 4
    //   45: aload_3
    //   46: invokevirtual 411	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   49: aload_3
    //   50: astore_2
    //   51: aload 4
    //   53: ldc_w 413
    //   56: invokevirtual 417	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore 5
    //   61: aload 5
    //   63: ifnull +79 -> 142
    //   66: aload_3
    //   67: astore_2
    //   68: aload 5
    //   70: invokevirtual 422	java/lang/String:length	()I
    //   73: ifle +69 -> 142
    //   76: aload_3
    //   77: astore_2
    //   78: new 424	org/json/JSONArray
    //   81: dup
    //   82: aload 5
    //   84: invokespecial 426	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   87: astore 5
    //   89: aload_3
    //   90: astore_2
    //   91: iload_1
    //   92: aload 5
    //   94: invokevirtual 427	org/json/JSONArray:length	()I
    //   97: if_icmpge +45 -> 142
    //   100: aload_3
    //   101: astore_2
    //   102: aload_0
    //   103: getfield 120	com/baidu/android/pushservice/e:v	[I
    //   106: iload_1
    //   107: aload 5
    //   109: iload_1
    //   110: invokevirtual 430	org/json/JSONArray:getInt	(I)I
    //   113: iastore
    //   114: aload_3
    //   115: astore_2
    //   116: aload_0
    //   117: iconst_0
    //   118: putfield 122	com/baidu/android/pushservice/e:w	I
    //   121: aload_3
    //   122: astore_2
    //   123: aload_0
    //   124: iconst_0
    //   125: putfield 124	com/baidu/android/pushservice/e:x	I
    //   128: aload_3
    //   129: astore_2
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 128	com/baidu/android/pushservice/e:z	I
    //   135: iload_1
    //   136: iconst_1
    //   137: iadd
    //   138: istore_1
    //   139: goto -50 -> 89
    //   142: aload_3
    //   143: astore_2
    //   144: aload 4
    //   146: ldc_w 432
    //   149: invokevirtual 417	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   152: astore 4
    //   154: aload 4
    //   156: ifnull +24 -> 180
    //   159: aload_3
    //   160: astore_2
    //   161: aload 4
    //   163: invokevirtual 422	java/lang/String:length	()I
    //   166: ifle +14 -> 180
    //   169: aload_3
    //   170: astore_2
    //   171: aload_0
    //   172: aload 4
    //   174: invokestatic 438	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   177: putfield 122	com/baidu/android/pushservice/e:w	I
    //   180: aload_3
    //   181: ifnull +7 -> 188
    //   184: aload_3
    //   185: invokevirtual 441	java/io/FileInputStream:close	()V
    //   188: return
    //   189: astore_2
    //   190: ldc -49
    //   192: new 209	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 443
    //   202: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_2
    //   206: invokevirtual 446	java/io/IOException:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: aload_0
    //   216: getfield 132	com/baidu/android/pushservice/e:l	Landroid/content/Context;
    //   219: invokevirtual 233	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   222: invokestatic 448	com/baidu/android/pushservice/g/a:b	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   225: return
    //   226: astore 4
    //   228: aconst_null
    //   229: astore_3
    //   230: aload_3
    //   231: astore_2
    //   232: ldc -49
    //   234: new 209	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 450
    //   244: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload 4
    //   249: invokevirtual 451	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   252: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: aload_0
    //   259: getfield 132	com/baidu/android/pushservice/e:l	Landroid/content/Context;
    //   262: invokevirtual 233	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   265: invokestatic 448	com/baidu/android/pushservice/g/a:b	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   268: aload_3
    //   269: ifnull -81 -> 188
    //   272: aload_3
    //   273: invokevirtual 441	java/io/FileInputStream:close	()V
    //   276: return
    //   277: astore_2
    //   278: ldc -49
    //   280: new 209	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   287: ldc_w 443
    //   290: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_2
    //   294: invokevirtual 446	java/io/IOException:getMessage	()Ljava/lang/String;
    //   297: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: aload_0
    //   304: getfield 132	com/baidu/android/pushservice/e:l	Landroid/content/Context;
    //   307: invokevirtual 233	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   310: invokestatic 448	com/baidu/android/pushservice/g/a:b	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   313: return
    //   314: astore_3
    //   315: aconst_null
    //   316: astore_2
    //   317: aload_2
    //   318: ifnull +7 -> 325
    //   321: aload_2
    //   322: invokevirtual 441	java/io/FileInputStream:close	()V
    //   325: aload_3
    //   326: athrow
    //   327: astore_2
    //   328: ldc -49
    //   330: new 209	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   337: ldc_w 443
    //   340: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload_2
    //   344: invokevirtual 446	java/io/IOException:getMessage	()Ljava/lang/String;
    //   347: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: aload_0
    //   354: getfield 132	com/baidu/android/pushservice/e:l	Landroid/content/Context;
    //   357: invokevirtual 233	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   360: invokestatic 448	com/baidu/android/pushservice/g/a:b	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   363: goto -38 -> 325
    //   366: astore_3
    //   367: goto -50 -> 317
    //   370: astore 4
    //   372: goto -142 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	e
    //   1	138	1	i1	int
    //   15	156	2	localObject1	Object
    //   189	17	2	localIOException1	java.io.IOException
    //   231	1	2	localObject2	Object
    //   277	17	2	localIOException2	java.io.IOException
    //   316	6	2	localObject3	Object
    //   327	17	2	localIOException3	java.io.IOException
    //   40	233	3	localFileInputStream	java.io.FileInputStream
    //   314	12	3	localObject4	Object
    //   366	1	3	localObject5	Object
    //   30	143	4	localObject6	Object
    //   226	22	4	localException1	Exception
    //   370	1	4	localException2	Exception
    //   59	49	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   184	188	189	java/io/IOException
    //   32	41	226	java/lang/Exception
    //   272	276	277	java/io/IOException
    //   32	41	314	finally
    //   321	325	327	java/io/IOException
    //   43	49	366	finally
    //   51	61	366	finally
    //   68	76	366	finally
    //   78	89	366	finally
    //   91	100	366	finally
    //   102	114	366	finally
    //   116	121	366	finally
    //   123	128	366	finally
    //   130	135	366	finally
    //   144	154	366	finally
    //   161	169	366	finally
    //   171	180	366	finally
    //   232	268	366	finally
    //   43	49	370	java/lang/Exception
    //   51	61	370	java/lang/Exception
    //   68	76	370	java/lang/Exception
    //   78	89	370	java/lang/Exception
    //   91	100	370	java/lang/Exception
    //   102	114	370	java/lang/Exception
    //   116	121	370	java/lang/Exception
    //   123	128	370	java/lang/Exception
    //   130	135	370	java/lang/Exception
    //   144	154	370	java/lang/Exception
    //   161	169	370	java/lang/Exception
    //   171	180	370	java/lang/Exception
  }
  
  public void a(boolean paramBoolean)
  {
    String str = k.d(this.l);
    if (!TextUtils.equals(this.B, str))
    {
      this.w = g();
      this.x = 0;
      p.b("RTC stat change " + e() + " because of network changing", this.l);
      this.B = str;
      g.a(this.l).a(e());
      return;
    }
    int i1 = e();
    if (paramBoolean) {
      if (!k.a(this.l)) {
        this.w += 1;
      }
    }
    for (;;)
    {
      p.b("RTC stat change from " + i1 + " to " + e(), this.l);
      break;
      f();
      this.x += 1;
      if (this.x >= 3)
      {
        this.x = 0;
        if (this.w < this.v.length - 1)
        {
          this.x = 0;
          this.w += 1;
        }
      }
      if (this.z >= 30)
      {
        this.z = 0;
        com.baidu.android.pushservice.h.i locali = new com.baidu.android.pushservice.h.i();
        locali.d = "030101";
        locali.e = System.currentTimeMillis();
        locali.f = b.b(this.l);
        locali.a = e();
        q.a(this.l, locali);
        continue;
        this.x = 0;
        this.z = 0;
        if (k.a(this.l))
        {
          if (this.w > 0)
          {
            this.w -= 1;
            f();
          }
        }
        else {
          this.w += 1;
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b()
  {
    this.k = 0;
    this.j = false;
    i();
  }
  
  public void c()
  {
    com.baidu.android.pushservice.g.a.c("PushConnection", "---stop---", this.l.getApplicationContext());
    p.b("PushConnection stop from " + this.l.getPackageName() + " at Time " + System.currentTimeMillis(), this.l);
    this.f = true;
    this.j = true;
    this.a.removeCallbacks(this.s);
    k();
    n = null;
  }
  
  public void d()
  {
    if (this.b != null)
    {
      if (System.currentTimeMillis() - this.u <= 120000L) {
        break label47;
      }
      com.baidu.android.pushservice.i.d.a().a(new c("heartbeat", (short)98)
      {
        public void a()
        {
          long l = System.currentTimeMillis();
          int i = (int)(l / 60000L % 5L);
          int j = (int)(l / 1000L);
          if ((i == 0) && (j % 60 < 15)) {
            l = (Math.random() * 60.0D * 1000.0D);
          }
          try
          {
            Thread.sleep(l);
            e.this.b.c();
            e.a(e.this, System.currentTimeMillis());
            com.baidu.android.pushservice.g.a.c("PushConnection", "sendHeartbeatMessage", e.c(e.this).getApplicationContext());
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;) {}
          }
        }
      });
    }
    for (;;)
    {
      l();
      return;
      label47:
      com.baidu.android.pushservice.g.a.c("PushConnection", "sendHeartbeatMessage ingnored， because too frequent.", this.l.getApplicationContext());
    }
  }
  
  public int e()
  {
    if (this.w < 0) {
      this.w = 0;
    }
    for (;;)
    {
      return this.v[this.w];
      if (this.w >= this.v.length) {
        this.w = (this.v.length - 1);
      }
    }
  }
  
  public void f()
  {
    if (k.b(this.l))
    {
      m.a(this.l, "com.baidu.pushservice.CUR_PERIOD_WIFI", this.w);
      return;
    }
    m.a(this.l, "com.baidu.pushservice.CUR_PERIOD_MOBILE", this.w);
  }
  
  public int g()
  {
    if (!k.a(this.l)) {
      return 0;
    }
    if (k.b(this.l)) {
      return m.b(this.l, "com.baidu.pushservice.CUR_PERIOD_WIFI", 0);
    }
    return m.b(this.l, "com.baidu.pushservice.CUR_PERIOD_MOBILE", 0);
  }
  
  class a
    extends Thread
  {
    a()
    {
      setName("PushService-PushConnection-readThread");
    }
    
    public void run()
    {
      while (!e.j(e.this)) {
        try
        {
          localObject = PushSocket.a(e.c(e.this), e.h());
          e.this.a.removeCallbacks(e.k(e.this));
          if (e.i(e.this))
          {
            e.d(e.this, false);
            e.this.a(true);
          }
          if ((localObject == null) || (localObject.length == 0))
          {
            int i = PushSocket.getLastSocketError();
            com.baidu.android.pushservice.g.a.a("PushConnection", "Receive err,errno:" + i, e.c(e.this).getApplicationContext());
            e.a(e.this, "039913", i);
            e.e(e.this);
            p.b("PushConnection Receive err " + e.c(e.this).getPackageName() + " lastSocketError " + i + " socketfd " + e.h() + System.currentTimeMillis(), e.c(e.this).getApplicationContext());
          }
        }
        catch (Exception localException3)
        {
          Object localObject;
          for (;;)
          {
            localObject = null;
            if (a.b() > 0) {
              q.a(e.c(e.this), "039908", PushSocket.getLastSocketError(), p.a(localException3));
            }
            com.baidu.android.pushservice.g.a.b("PushConnection", "Get message exception", e.c(e.this).getApplicationContext());
            q.a(e.c(e.this), localException3);
          }
          try
          {
            localObject = e.this.b.a((byte[])localObject, localObject.length);
            if (localObject != null) {}
            try
            {
              e.this.b.b((com.baidu.android.pushservice.message.e)localObject);
              e.b(e.this, 0);
            }
            catch (Exception localException1)
            {
              com.baidu.android.pushservice.g.a.b("PushConnection", "Handle message exception " + p.a(localException1), e.c(e.this).getApplicationContext());
              p.b("PushConnection Handle message exception " + e.c(e.this).getPackageName() + p.a(localException1) + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + e.h() + System.currentTimeMillis(), e.c(e.this).getApplicationContext());
              if (a.b() > 0) {
                q.a(e.c(e.this), "039910", PushSocket.getLastSocketError(), p.a(localException1));
              }
              e.e(e.this);
            }
          }
          catch (Exception localException2)
          {
            com.baidu.android.pushservice.g.a.c("PushConnection", "Read message exception " + p.a(localException2), e.c(e.this).getApplicationContext());
            if (a.b() > 0) {
              q.a(e.c(e.this), "039909", PushSocket.getLastSocketError(), p.a(localException2));
            }
            e.e(e.this);
            p.b("PushConnection Read message exception " + e.c(e.this).getPackageName() + p.a(localException2) + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + e.h() + System.currentTimeMillis(), e.c(e.this).getApplicationContext());
          }
        }
      }
    }
  }
  
  class b
    extends Thread
  {
    b()
    {
      setName("PushService-PushConnection-SendThread");
    }
    
    public void run()
    {
      for (;;)
      {
        com.baidu.android.pushservice.message.e locale;
        int i;
        if (!e.j(e.this))
        {
          locale = null;
          synchronized (e.this.b.a())
          {
            i = e.this.b.a().size();
            if (i != 0) {}
          }
        }
        try
        {
          e.this.b.a().wait();
          if (e.this.b.a().size() > 0) {
            locale = (com.baidu.android.pushservice.message.e)e.this.b.a().removeFirst();
          }
          if (e.j(e.this))
          {
            return;
            localObject = finally;
            throw ((Throwable)localObject);
          }
          if ((localObject == null) || (((com.baidu.android.pushservice.message.e)localObject).a() == null)) {
            continue;
          }
          if (((com.baidu.android.pushservice.message.e)localObject).b())
          {
            if (!((com.baidu.android.pushservice.message.e)localObject).c()) {
              break label279;
            }
            e.d(e.this, true);
            e.this.a.removeCallbacks(e.k(e.this));
            e.this.a.postDelayed(e.k(e.this), 60000L);
          }
          try
          {
            i = PushSocket.sendMsg(e.h(), ((com.baidu.android.pushservice.message.e)localObject).a(), ((com.baidu.android.pushservice.message.e)localObject).a().length);
            if (i != -1) {
              continue;
            }
            e.e(e.this);
            p.b("PushConnection sendMsg err " + e.c(e.this).getPackageName() + " lastSocketError " + PushSocket.getLastSocketError() + " socketfd " + e.h() + System.currentTimeMillis(), e.c(e.this).getApplicationContext());
            continue;
            label279:
            e.d(e.this, false);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              i = -1;
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */