package com.baidu.carlife.logic;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.TaskStackBuilder;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.d;
import com.baidu.carlife.k.a.e.a;
import com.baidu.carlife.k.a.h;
import com.baidu.carlife.k.a.h.a;
import com.baidu.carlife.k.a.h.b;
import com.baidu.carlife.k.a.h.c;
import com.baidu.carlife.service.NotificationDownloadService;
import com.baidu.carlife.service.NotificationDownloadService.a;
import com.baidu.carlife.util.w;
import com.baidu.navi.ActivityStack;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a
{
  private static final int h = 96;
  private final int a = 8194;
  private final int b = 1;
  private final int c = 2;
  private final int d = 3;
  private final int e = 4;
  private final int f = 4097;
  private final int g = 4098;
  private Activity i = null;
  private com.baidu.carlife.core.screen.e j;
  private volatile int k = 4097;
  private SharedPreferences l = null;
  private com.baidu.carlife.view.dialog.b m = null;
  private com.baidu.carlife.view.dialog.c n = null;
  private NotificationDownloadService o = null;
  private boolean p;
  private boolean q;
  private com.baidu.carlife.k.a r;
  private com.baidu.carlife.model.c s;
  private h t;
  private File u;
  private Handler v = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 1: 
        do
        {
          return;
          a.a(a.this, 4097);
          com.baidu.carlife.core.screen.presentation.a.e.a().c();
          a.a(a.this);
        } while (!a.b(a.this));
        ActivityStack.exitApp(true);
        return;
      case 2: 
        com.baidu.carlife.core.screen.presentation.a.e.a().c();
        a.c(a.this);
        return;
      case 3: 
        a.d(a.this);
        return;
      }
      a.e(a.this);
    }
  };
  private h.c w = new h.c()
  {
    private void a()
    {
      a.a(a.this, null);
      a.u(a.this);
      a.a(a.this, null, true);
    }
    
    private void b()
    {
      a.a(a.this, a.o(a.this).b());
      new Thread(new Runnable()
      {
        public void run()
        {
          if (a.r(a.this) == 1)
          {
            a.s(a.this).sendEmptyMessage(3);
            return;
          }
          a.s(a.this).sendEmptyMessage(4);
        }
      }).start();
    }
    
    private void c()
    {
      a.u(a.this);
    }
    
    public void a(long paramAnonymousLong, int paramAnonymousInt)
    {
      try
      {
        if (a.k(a.this))
        {
          a.n(a.this).a(paramAnonymousInt);
          return;
        }
        if (a.t(a.this) != null)
        {
          a.t(a.this).setProgress(paramAnonymousInt);
          a.t(a.this).setPercent(paramAnonymousInt);
          a.t(a.this).setHasFinished((int)(paramAnonymousInt * paramAnonymousLong / 100L / 1024L / 1024L), (int)(paramAnonymousLong / 1024L / 1024L));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    public void a(h.b paramAnonymousb, h.a paramAnonymousa)
    {
      switch (a.5.a[paramAnonymousb.ordinal()])
      {
      default: 
        return;
      case 1: 
        b();
        return;
      case 2: 
        a();
        return;
      }
      c();
    }
  };
  private ServiceConnection x = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      paramAnonymousComponentName = (NotificationDownloadService.a)paramAnonymousIBinder;
      a.a(a.this, paramAnonymousComponentName.a());
      a.n(a.this).a(a.v(a.this));
      a.n(a.this).a(0);
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      i.b("AppUpdateManager", "app update onServiceDisconnected");
      if (a.n(a.this) != null) {
        a.n(a.this).a();
      }
    }
  };
  
  public static a a()
  {
    return b.a();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (this.i == null) {
      return;
    }
    if (this.n == null)
    {
      this.n = new com.baidu.carlife.view.dialog.c(this.i).q();
      this.n.a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          a.a(a.this, 4098);
          if (a.k(a.this))
          {
            a.m(a.this).dismissDialog(a.l(a.this));
            if (a.n(a.this) != null) {
              a.n(a.this).a(0);
            }
            a.o(a.this).e();
            return;
          }
          a.p(a.this);
        }
      });
      this.n.b(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          a.q(a.this);
        }
      });
      this.n.setOnDialogCancelListener(new d()
      {
        public void onCancel()
        {
          a.q(a.this);
        }
      });
    }
    if (paramBoolean)
    {
      this.n.b(2131296366);
      this.n.c(2131296365);
      this.n.d(2131296361);
      this.n.a(2131296364);
    }
    for (;;)
    {
      this.j.showDialog(this.n);
      return;
      this.n.b(2131296373);
      this.n.c(2131296371);
      String str1;
      if (f())
      {
        this.n.d(2131296372);
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        str1 = paramString;
      }
      try
      {
        if (paramString.length() > 96) {
          str1 = paramString.substring(0, 96) + "\n...";
        }
        this.n.b(str1);
        continue;
        this.n.d(2131296370);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          String str2 = paramString;
        }
      }
    }
  }
  
  private void c()
  {
    s();
    a(this.u);
    w.a(2131296363, 0);
  }
  
  private void d()
  {
    s();
    a(this.u);
    l();
    k();
    if (f()) {
      ActivityStack.exitApp(true);
    }
  }
  
  private void e()
  {
    if (this.s == null) {}
    do
    {
      do
      {
        return;
        if (this.s.g != 1) {
          break;
        }
      } while ((!f()) && (this.q) && (r()));
      a(this.s.k, false);
      return;
    } while (this.q);
    w.a(2131296369, 0);
  }
  
  private boolean f()
  {
    boolean bool = true;
    if (this.s == null) {
      return false;
    }
    if (this.s.h == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void g()
  {
    com.baidu.carlife.core.screen.presentation.a.e.a().a(com.baidu.carlife.core.a.a().getString(2131296381), new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        a.f(a.this).cancel();
      }
    });
  }
  
  private void h()
  {
    if (this.i == null) {
      return;
    }
    if (this.m == null)
    {
      this.m = new com.baidu.carlife.view.dialog.b(this.i);
      this.m.setOnDialogCancelListener(new d()
      {
        public void onCancel()
        {
          a.i(a.this);
        }
      });
    }
    if (!f())
    {
      this.m.c(2131296360);
      this.m.q();
      this.m.d(2131296361);
      this.m.a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          a.j(a.this);
        }
      });
      this.m.b(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          a.i(a.this);
        }
      });
    }
    for (;;)
    {
      this.m.setPercent(0);
      this.m.setProgress(0);
      this.m.setHasFinished(0, this.s.j / 1048576);
      this.j.showDialog(this.m);
      return;
      this.m.q();
      this.m.c(2131296361);
      this.m.a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          a.i(a.this);
        }
      });
    }
  }
  
  private void i()
  {
    this.j.dismissDialog(this.m);
    if (this.t != null) {
      this.t.d();
    }
    if (this.o != null) {
      this.o.a();
    }
    if (f()) {
      ActivityStack.exitApp(true);
    }
  }
  
  /* Error */
  private int j()
  {
    // Byte code:
    //   0: new 328	com/baidu/carlife/util/g
    //   3: dup
    //   4: invokespecial 329	com/baidu/carlife/util/g:<init>	()V
    //   7: astore 9
    //   9: aload 9
    //   11: invokevirtual 331	com/baidu/carlife/util/g:b	()V
    //   14: aload_0
    //   15: getfield 129	com/baidu/carlife/logic/a:u	Ljava/io/File;
    //   18: invokevirtual 336	java/io/File:length	()J
    //   21: lstore 4
    //   23: lload 4
    //   25: lconst_0
    //   26: lcmp
    //   27: ifne +7 -> 34
    //   30: iconst_0
    //   31: istore_1
    //   32: iload_1
    //   33: ireturn
    //   34: lload 4
    //   36: ldc2_w 337
    //   39: lcmp
    //   40: ifgt +166 -> 206
    //   43: aconst_null
    //   44: astore 8
    //   46: aconst_null
    //   47: astore 7
    //   49: new 340	java/io/BufferedInputStream
    //   52: dup
    //   53: new 342	java/io/FileInputStream
    //   56: dup
    //   57: aload_0
    //   58: getfield 129	com/baidu/carlife/logic/a:u	Ljava/io/File;
    //   61: invokespecial 344	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 347	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: astore 6
    //   69: sipush 1024
    //   72: newarray <illegal type>
    //   74: astore 7
    //   76: aload 6
    //   78: aload 7
    //   80: invokevirtual 351	java/io/BufferedInputStream:read	([B)I
    //   83: istore_1
    //   84: iload_1
    //   85: iconst_m1
    //   86: if_icmpeq +34 -> 120
    //   89: aload 9
    //   91: aload 7
    //   93: iload_1
    //   94: invokevirtual 354	com/baidu/carlife/util/g:a	([BI)V
    //   97: goto -21 -> 76
    //   100: astore 7
    //   102: iconst_m1
    //   103: istore_1
    //   104: aload 6
    //   106: ifnull -74 -> 32
    //   109: aload 6
    //   111: invokevirtual 357	java/io/BufferedInputStream:close	()V
    //   114: iconst_m1
    //   115: ireturn
    //   116: astore 6
    //   118: iconst_m1
    //   119: ireturn
    //   120: aload 6
    //   122: ifnull +8 -> 130
    //   125: aload 6
    //   127: invokevirtual 357	java/io/BufferedInputStream:close	()V
    //   130: aload 9
    //   132: invokevirtual 358	com/baidu/carlife/util/g:c	()V
    //   135: aload 9
    //   137: invokevirtual 361	com/baidu/carlife/util/g:a	()[B
    //   140: astore 6
    //   142: new 198	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   149: astore 7
    //   151: iconst_0
    //   152: istore_1
    //   153: iload_1
    //   154: bipush 16
    //   156: if_icmpge +341 -> 497
    //   159: aload 7
    //   161: aload 6
    //   163: iload_1
    //   164: baload
    //   165: invokestatic 364	com/baidu/carlife/util/g:b	(B)Ljava/lang/String;
    //   168: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: iload_1
    //   173: iconst_1
    //   174: iadd
    //   175: istore_1
    //   176: goto -23 -> 153
    //   179: astore 6
    //   181: iconst_m1
    //   182: ireturn
    //   183: astore 7
    //   185: aload 8
    //   187: astore 6
    //   189: aload 6
    //   191: ifnull +8 -> 199
    //   194: aload 6
    //   196: invokevirtual 357	java/io/BufferedInputStream:close	()V
    //   199: aload 7
    //   201: athrow
    //   202: astore 6
    //   204: iconst_m1
    //   205: ireturn
    //   206: aconst_null
    //   207: astore 8
    //   209: aconst_null
    //   210: astore 7
    //   212: new 366	java/io/RandomAccessFile
    //   215: dup
    //   216: aload_0
    //   217: getfield 129	com/baidu/carlife/logic/a:u	Ljava/io/File;
    //   220: ldc_w 367
    //   223: invokespecial 370	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   226: astore 6
    //   228: sipush 1024
    //   231: newarray <illegal type>
    //   233: astore 7
    //   235: aload 6
    //   237: lconst_0
    //   238: invokevirtual 374	java/io/RandomAccessFile:seek	(J)V
    //   241: iconst_0
    //   242: istore_1
    //   243: aload 6
    //   245: aload 7
    //   247: invokevirtual 375	java/io/RandomAccessFile:read	([B)I
    //   250: istore_3
    //   251: iload_3
    //   252: iconst_m1
    //   253: if_icmpeq +25 -> 278
    //   256: iload_1
    //   257: iload_3
    //   258: iadd
    //   259: istore_2
    //   260: iload_2
    //   261: ldc_w 376
    //   264: if_icmpgt +143 -> 407
    //   267: aload 9
    //   269: aload 7
    //   271: iload_3
    //   272: invokevirtual 354	com/baidu/carlife/util/g:a	([BI)V
    //   275: goto +276 -> 551
    //   278: aload 6
    //   280: aload_0
    //   281: getfield 125	com/baidu/carlife/logic/a:s	Lcom/baidu/carlife/model/c;
    //   284: getfield 305	com/baidu/carlife/model/c:j	I
    //   287: iconst_2
    //   288: idiv
    //   289: i2l
    //   290: invokevirtual 374	java/io/RandomAccessFile:seek	(J)V
    //   293: iconst_0
    //   294: istore_1
    //   295: aload 6
    //   297: aload 7
    //   299: invokevirtual 375	java/io/RandomAccessFile:read	([B)I
    //   302: istore_3
    //   303: iload_3
    //   304: iconst_m1
    //   305: if_icmpeq +25 -> 330
    //   308: iload_1
    //   309: iload_3
    //   310: iadd
    //   311: istore_2
    //   312: iload_2
    //   313: ldc_w 376
    //   316: if_icmpgt +128 -> 444
    //   319: aload 9
    //   321: aload 7
    //   323: iload_3
    //   324: invokevirtual 354	com/baidu/carlife/util/g:a	([BI)V
    //   327: goto +236 -> 563
    //   330: aload 6
    //   332: aload_0
    //   333: getfield 125	com/baidu/carlife/logic/a:s	Lcom/baidu/carlife/model/c;
    //   336: getfield 305	com/baidu/carlife/model/c:j	I
    //   339: ldc_w 376
    //   342: isub
    //   343: i2l
    //   344: invokevirtual 374	java/io/RandomAccessFile:seek	(J)V
    //   347: iconst_0
    //   348: istore_1
    //   349: aload 6
    //   351: aload 7
    //   353: invokevirtual 375	java/io/RandomAccessFile:read	([B)I
    //   356: istore_3
    //   357: iload_3
    //   358: iconst_m1
    //   359: if_icmpeq +31 -> 390
    //   362: iload_1
    //   363: iload_3
    //   364: iadd
    //   365: istore_2
    //   366: iload_2
    //   367: ldc_w 376
    //   370: if_icmpgt +106 -> 476
    //   373: aload 9
    //   375: aload 7
    //   377: iload_3
    //   378: invokevirtual 354	com/baidu/carlife/util/g:a	([BI)V
    //   381: iload_2
    //   382: istore_1
    //   383: iload_2
    //   384: ldc_w 376
    //   387: if_icmplt -38 -> 349
    //   390: aload 6
    //   392: ifnull -262 -> 130
    //   395: aload 6
    //   397: invokevirtual 377	java/io/RandomAccessFile:close	()V
    //   400: goto -270 -> 130
    //   403: astore 6
    //   405: iconst_m1
    //   406: ireturn
    //   407: aload 9
    //   409: aload 7
    //   411: iload_3
    //   412: iload_2
    //   413: ldc_w 376
    //   416: isub
    //   417: isub
    //   418: invokevirtual 354	com/baidu/carlife/util/g:a	([BI)V
    //   421: goto +130 -> 551
    //   424: astore 7
    //   426: iconst_m1
    //   427: istore_1
    //   428: aload 6
    //   430: ifnull -398 -> 32
    //   433: aload 6
    //   435: invokevirtual 377	java/io/RandomAccessFile:close	()V
    //   438: iconst_m1
    //   439: ireturn
    //   440: astore 6
    //   442: iconst_m1
    //   443: ireturn
    //   444: aload 9
    //   446: aload 7
    //   448: iload_3
    //   449: iload_2
    //   450: ldc_w 376
    //   453: isub
    //   454: isub
    //   455: invokevirtual 354	com/baidu/carlife/util/g:a	([BI)V
    //   458: goto +105 -> 563
    //   461: astore 7
    //   463: aload 6
    //   465: ifnull +8 -> 473
    //   468: aload 6
    //   470: invokevirtual 377	java/io/RandomAccessFile:close	()V
    //   473: aload 7
    //   475: athrow
    //   476: aload 9
    //   478: aload 7
    //   480: iload_3
    //   481: iload_2
    //   482: ldc_w 376
    //   485: isub
    //   486: isub
    //   487: invokevirtual 354	com/baidu/carlife/util/g:a	([BI)V
    //   490: goto -109 -> 381
    //   493: astore 6
    //   495: iconst_m1
    //   496: ireturn
    //   497: aload 7
    //   499: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: aload_0
    //   503: getfield 125	com/baidu/carlife/logic/a:s	Lcom/baidu/carlife/model/c;
    //   506: getfield 379	com/baidu/carlife/model/c:n	Ljava/lang/String;
    //   509: invokevirtual 383	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   512: ifeq +5 -> 517
    //   515: iconst_1
    //   516: ireturn
    //   517: iconst_0
    //   518: ireturn
    //   519: astore 7
    //   521: aload 8
    //   523: astore 6
    //   525: goto -62 -> 463
    //   528: astore 6
    //   530: aload 7
    //   532: astore 6
    //   534: goto -108 -> 426
    //   537: astore 7
    //   539: goto -350 -> 189
    //   542: astore 6
    //   544: aload 7
    //   546: astore 6
    //   548: goto -446 -> 102
    //   551: iload_2
    //   552: istore_1
    //   553: iload_2
    //   554: ldc_w 376
    //   557: if_icmplt -314 -> 243
    //   560: goto -282 -> 278
    //   563: iload_2
    //   564: istore_1
    //   565: iload_2
    //   566: ldc_w 376
    //   569: if_icmplt -274 -> 295
    //   572: goto -242 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	575	0	this	a
    //   31	534	1	i1	int
    //   259	311	2	i2	int
    //   250	237	3	i3	int
    //   21	14	4	l1	long
    //   67	43	6	localBufferedInputStream	java.io.BufferedInputStream
    //   116	10	6	localIOException1	java.io.IOException
    //   140	22	6	arrayOfByte1	byte[]
    //   179	1	6	localIOException2	java.io.IOException
    //   187	8	6	localObject1	Object
    //   202	1	6	localIOException3	java.io.IOException
    //   226	170	6	localRandomAccessFile	java.io.RandomAccessFile
    //   403	31	6	localIOException4	java.io.IOException
    //   440	29	6	localIOException5	java.io.IOException
    //   493	1	6	localIOException6	java.io.IOException
    //   523	1	6	localObject2	Object
    //   528	1	6	localException1	Exception
    //   532	1	6	localObject3	Object
    //   542	1	6	localIOException7	java.io.IOException
    //   546	1	6	localObject4	Object
    //   47	45	7	arrayOfByte2	byte[]
    //   100	1	7	localIOException8	java.io.IOException
    //   149	11	7	localStringBuilder	StringBuilder
    //   183	17	7	localObject5	Object
    //   210	200	7	arrayOfByte3	byte[]
    //   424	23	7	localException2	Exception
    //   461	37	7	arrayOfByte4	byte[]
    //   519	12	7	localObject6	Object
    //   537	8	7	localObject7	Object
    //   44	478	8	localObject8	Object
    //   7	470	9	localg	com.baidu.carlife.util.g
    // Exception table:
    //   from	to	target	type
    //   69	76	100	java/io/IOException
    //   76	84	100	java/io/IOException
    //   89	97	100	java/io/IOException
    //   109	114	116	java/io/IOException
    //   125	130	179	java/io/IOException
    //   49	69	183	finally
    //   194	199	202	java/io/IOException
    //   395	400	403	java/io/IOException
    //   228	241	424	java/lang/Exception
    //   243	251	424	java/lang/Exception
    //   267	275	424	java/lang/Exception
    //   278	293	424	java/lang/Exception
    //   295	303	424	java/lang/Exception
    //   319	327	424	java/lang/Exception
    //   330	347	424	java/lang/Exception
    //   349	357	424	java/lang/Exception
    //   373	381	424	java/lang/Exception
    //   407	421	424	java/lang/Exception
    //   444	458	424	java/lang/Exception
    //   476	490	424	java/lang/Exception
    //   433	438	440	java/io/IOException
    //   228	241	461	finally
    //   243	251	461	finally
    //   267	275	461	finally
    //   278	293	461	finally
    //   295	303	461	finally
    //   319	327	461	finally
    //   330	347	461	finally
    //   349	357	461	finally
    //   373	381	461	finally
    //   407	421	461	finally
    //   444	458	461	finally
    //   476	490	461	finally
    //   468	473	493	java/io/IOException
    //   212	228	519	finally
    //   212	228	528	java/lang/Exception
    //   69	76	537	finally
    //   76	84	537	finally
    //   89	97	537	finally
    //   49	69	542	java/io/IOException
  }
  
  private void k()
  {
    if (this.u == null) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setDataAndType(Uri.fromFile(this.u), "application/vnd.android.package-archive");
    this.i.startActivity(localIntent);
  }
  
  private void l()
  {
    SharedPreferences.Editor localEditor = this.l.edit();
    localEditor.putString("newAppVersionName", this.s.l);
    localEditor.commit();
  }
  
  private void m()
  {
    this.t = new h(this.s.m, "CarLife.apk", this.w);
    this.t.a(this.s.j);
    this.t.e();
  }
  
  private void n()
  {
    this.j.dismissDialog(this.n);
    if (!this.l.contains("newAppVersionName"))
    {
      p();
      return;
    }
    if (this.l.getString("newAppVersionName", "").equals(this.s.l))
    {
      if ((this.u == null) || (!this.u.exists()))
      {
        p();
        return;
      }
      o();
      new Thread(new Runnable()
      {
        public void run()
        {
          if (a.r(a.this) == 1)
          {
            a.s(a.this).sendEmptyMessage(1);
            return;
          }
          a.s(a.this).sendEmptyMessage(2);
        }
      }).start();
      return;
    }
    p();
  }
  
  private void o()
  {
    com.baidu.carlife.core.screen.presentation.a.e.a().b(com.baidu.carlife.core.a.a().getString(2131297190));
  }
  
  private void p()
  {
    if (this.s.i == 0)
    {
      h();
      m();
      return;
    }
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(this.s.m));
      this.i.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void q()
  {
    this.k = 4097;
    this.j.dismissDialog(this.n);
    if (this.o != null) {
      this.o.a();
    }
    if (this.t != null) {
      this.t.d();
    }
    if (f()) {
      ActivityStack.exitApp(true);
    }
  }
  
  private boolean r()
  {
    SharedPreferences.Editor localEditor = this.l.edit();
    int i1 = this.l.getInt("todayUpdateCount", 0);
    if (!this.l.contains("lastUpdateTime"))
    {
      localEditor.putString("lastUpdateTime", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
      localEditor.putInt("todayUpdateCount", 1);
      localEditor.commit();
      return false;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String str1 = localSimpleDateFormat.format(new Date());
    String str2 = this.l.getString("lastUpdateTime", null);
    do
    {
      try
      {
        if (!localSimpleDateFormat.parse(str1).after(localSimpleDateFormat.parse(str2))) {
          continue;
        }
        localEditor.putString("lastUpdateTime", str1);
        localEditor.putInt("todayUpdateCount", 1);
        localEditor.commit();
        return false;
      }
      catch (ParseException localParseException)
      {
        return false;
      }
      localEditor.putInt("todayUpdateCount", i1 + 1);
      localEditor.commit();
      return false;
    } while (i1 < 2);
    return true;
  }
  
  private void s()
  {
    this.k = 4097;
    this.j.dismissDialog();
    if (this.o != null) {
      this.o.a();
    }
  }
  
  private void t()
  {
    Intent localIntent = new Intent(this.i, NotificationDownloadService.class);
    this.p = this.i.bindService(localIntent, this.x, 1);
  }
  
  public void a(Activity paramActivity, com.baidu.carlife.core.screen.e parame)
  {
    this.i = paramActivity;
    this.j = parame;
    this.l = paramActivity.getSharedPreferences("CarlifeUpdateRecord", 0);
  }
  
  public void a(File paramFile)
  {
    if (this.i == null) {
      return;
    }
    Object localObject = new NotificationCompat.Builder(this.i).setSmallIcon(2130838698).setContentTitle(this.i.getString(2131296367)).setContentText(this.i.getString(2131296362));
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.android.package-archive");
    paramFile = TaskStackBuilder.create(this.i);
    paramFile.addParentStack(CarlifeActivity.class);
    paramFile.addNextIntent(localIntent);
    ((NotificationCompat.Builder)localObject).setContentIntent(paramFile.getPendingIntent(0, 134217728));
    paramFile = (NotificationManager)this.i.getSystemService("notification");
    localObject = ((NotificationCompat.Builder)localObject).build();
    ((Notification)localObject).flags |= 0x10;
    paramFile.notify(8194, (Notification)localObject);
  }
  
  public void a(boolean paramBoolean)
  {
    if ("1012961a".equals(f.jt)) {
      return;
    }
    if (this.k != 4097)
    {
      w.a(2131296374, 0);
      return;
    }
    if (!paramBoolean) {
      g();
    }
    this.q = paramBoolean;
    this.r = new com.baidu.carlife.k.a();
    this.r.registerResponseListener(new a(null));
    this.r.toPostRequest();
  }
  
  public void b()
  {
    if (this.o != null)
    {
      i.b("AppUpdateManager", "unbindService");
      this.o.stopSelf();
      this.i.unbindService(this.x);
    }
  }
  
  private class a
    implements e.a
  {
    private a() {}
    
    public void onNetWorkResponse(int paramInt)
    {
      com.baidu.carlife.core.screen.presentation.a.e.a().c();
      switch (paramInt)
      {
      }
      do
      {
        return;
        a.a(a.this, a.f(a.this).a());
        a.g(a.this);
        return;
      } while (a.h(a.this));
      w.a(2131296368, 0);
    }
  }
  
  private static class b
  {
    private static a a = new a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */