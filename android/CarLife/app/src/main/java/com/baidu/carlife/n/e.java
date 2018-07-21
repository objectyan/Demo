package com.baidu.carlife.n;

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
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.fragment.HomeMoreFragment.b;
import com.baidu.carlife.k.a.h;
import com.baidu.carlife.k.a.h.a;
import com.baidu.carlife.k.a.h.b;
import com.baidu.carlife.k.a.h.c;
import com.baidu.carlife.k.t;
import com.baidu.carlife.protobuf.CarLifeUpdateSuccessProtos.CarLifeUpdateSuccess;
import com.baidu.carlife.protobuf.CarlifeSystemInfoProtos.CarlifeSystemInfo;
import com.baidu.carlife.service.NotificationDownloadService;
import com.baidu.carlife.service.NotificationDownloadService.a;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.dialog.u;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.File;

public class e
{
  private static final String A = "newVehhicleVersionName";
  private static final String B = "hasDownVehhicleVersionName";
  private static final String d = "VehicleDownloadManager";
  private b C = null;
  private int D = -1;
  private int E = -1;
  private boolean F = false;
  private boolean G = false;
  private HomeMoreFragment.b H;
  private h.c I = new h.c()
  {
    private void a()
    {
      i.b("VehicleDownloadManager", "Download Error!");
      e.a(e.this, null);
      e.p(e.this);
      e.this.b(1004);
    }
    
    private void b()
    {
      i.b("VehicleDownloadManager", "after DownLoadSuccess");
      e.a(e.this, e.q(e.this).b());
      new Thread(new Runnable()
      {
        public void run()
        {
          i.b("VehicleDownloadManager", "StartCheckMD5");
          if (e.k(e.this) == 1)
          {
            i.b("VehicleDownloadManager", "checkApkMD5 success");
            e.l(e.this).sendEmptyMessage(3);
            return;
          }
          i.b("VehicleDownloadManager", "checkApkMD5 Fail");
          e.l(e.this).sendEmptyMessage(4);
        }
      }).start();
    }
    
    private void c()
    {
      i.b("VehicleDownloadManager", "afterDownloadCancel");
      e.p(e.this);
    }
    
    public void a(long paramAnonymousLong, int paramAnonymousInt)
    {
      try
      {
        if (e.m(e.this))
        {
          e.n(e.this).a(paramAnonymousInt);
          return;
        }
        if (e.o(e.this) != null)
        {
          e.o(e.this).setProgress(paramAnonymousInt);
          e.o(e.this).setPercent(paramAnonymousInt);
          e.o(e.this).setHasFinished((int)(paramAnonymousInt * paramAnonymousLong / 100L / 1024L / 1024L), (int)(paramAnonymousLong / 1024L / 1024L));
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
      switch (e.5.a[paramAnonymousb.ordinal()])
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
  private ServiceConnection J = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      paramAnonymousComponentName = (NotificationDownloadService.a)paramAnonymousIBinder;
      e.a(e.this, paramAnonymousComponentName.a());
      e.n(e.this).a(e.r(e.this));
      e.n(e.this).a(0);
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      i.b("VehicleDownloadManager", "app update onServiceDisconnected");
      if (e.n(e.this) != null) {
        e.n(e.this).a();
      }
    }
  };
  private b.a K = new b.a()
  {
    private void a()
    {
      i.b("VehicleDownloadManager", "OnTranfer Success");
      e.b(e.this, 4097);
      e.s(e.this).dismissDialog();
      if (e.n(e.this) != null) {
        e.n(e.this).a();
      }
    }
    
    private void b()
    {
      i.b("VehicleDownloadManager", "OnTranfer Error");
      e.b(e.this, 4097);
      e.s(e.this).dismissDialog(e.o(e.this));
      if (e.n(e.this) != null) {
        e.n(e.this).a();
      }
      e.this.b(1006);
    }
    
    private void c()
    {
      i.b("VehicleDownloadManager", "OnTranfer Cancel");
      e.b(e.this, 4097);
      e.s(e.this).dismissDialog();
      if (e.n(e.this) != null) {
        e.n(e.this).a();
      }
    }
    
    public void a(long paramAnonymousLong, int paramAnonymousInt)
    {
      try
      {
        if (e.m(e.this))
        {
          e.n(e.this).a(paramAnonymousInt);
          return;
        }
        if (e.o(e.this) != null)
        {
          e.o(e.this).setProgress(paramAnonymousInt);
          e.o(e.this).setPercent(paramAnonymousInt);
          e.o(e.this).setHasFinished((int)(paramAnonymousInt * paramAnonymousLong / 100L / 1024L / 1024L), (int)(paramAnonymousLong / 1024L / 1024L));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    public void a(b.d paramAnonymousd, b.c paramAnonymousc)
    {
      switch (e.5.b[paramAnonymousd.ordinal()])
      {
      default: 
        return;
      case 1: 
        a();
        return;
      case 2: 
        b();
        return;
      }
      c();
    }
  };
  com.baidu.carlife.core.screen.b a = new com.baidu.carlife.core.screen.b()
  {
    public void onClick()
    {
      i.b("VehicleDownloadManager", "####### OnDialogFirstBtnClick: " + e.t(e.this).getDialogType());
      switch (e.t(e.this).getDialogType())
      {
      case 1004: 
      default: 
        return;
      case 1001: 
        i.b("VehicleDownloadManager", "####### DLG_NO_NEED_UPDATE click");
        e.this.b(1001);
        return;
      case 1002: 
        i.b("VehicleDownloadManager", "####### DLG_CHECK_USE_MOBILE_NET_DWON click");
        e.u(e.this);
        return;
      case 1003: 
        i.b("VehicleDownloadManager", "####### DLG_CHECK_DOWN_LOAD");
        e.u(e.this);
        return;
      }
      i.b("VehicleDownloadManager", "####### DLG_CHECK_TRANSFER_NOW");
      e.v(e.this);
    }
  };
  com.baidu.carlife.core.screen.b b = new com.baidu.carlife.core.screen.b()
  {
    public void onClick()
    {
      i.b("VehicleDownloadManager", "####### OnDialogSecondBtnClick: " + e.t(e.this).getDialogType());
      switch (e.t(e.this).getDialogType())
      {
      case 1003: 
      case 1004: 
      default: 
        return;
      case 1001: 
        i.b("VehicleDownloadManager", "####### DLG_NO_NEED_UPDATE second");
        return;
      case 1002: 
        i.b("VehicleDownloadManager", "####### DLG_CHECK_USE_WIFI_DWON second");
        return;
      }
      i.b("VehicleDownloadManager", "####### DLG_CHECK_TRANSFER_NOW second");
    }
  };
  com.baidu.carlife.core.screen.d c = new com.baidu.carlife.core.screen.d()
  {
    public void onCancel()
    {
      i.b("VehicleDownloadManager", "####### OnDialogCancelBtnClick: " + e.t(e.this).getDialogType());
      switch (e.t(e.this).getDialogType())
      {
      case 1003: 
      case 1004: 
      default: 
        return;
      case 1001: 
        i.b("VehicleDownloadManager", "####### DLG_NO_NEED_UPDATE cancel");
        return;
      case 1002: 
        i.b("VehicleDownloadManager", "####### DLG_CHECK_USE_WIFI_DWON cancel");
        return;
      }
      i.b("VehicleDownloadManager", "####### DLG_CHECK_TRANSFER_NOW cancel");
    }
  };
  private final int e = 8194;
  private final int f = 1;
  private final int g = 2;
  private final int h = 3;
  private final int i = 4;
  private final int j = 11;
  private final int k = 4097;
  private final int l = 4098;
  private final int m = 5;
  private Activity n = null;
  private com.baidu.carlife.core.screen.e o;
  private volatile int p = 4097;
  private SharedPreferences q = null;
  private u r = null;
  private c s = null;
  private NotificationDownloadService t = null;
  private boolean u;
  private t v;
  private com.baidu.carlife.model.c w;
  private h x;
  private File y;
  private String z = "0";
  
  public static e a()
  {
    return c.a();
  }
  
  private void b(com.baidu.carlife.core.connect.c paramc)
  {
    try
    {
      paramc = CarlifeSystemInfoProtos.CarlifeSystemInfo.parseFrom(paramc.f());
      String str = paramc.getUpdateUrl();
      t.b(str);
      this.D = paramc.getFirmwareVersionCode();
      a(false);
      i.b("VehicleDownloadManager", "MSG_DATA_HU_SYSTEMINFO= " + str);
      i.b("VehicleDownloadManager", "MSG_DATA_HU_SYSTEMINFO= " + this.D);
      return;
    }
    catch (Exception paramc)
    {
      paramc.printStackTrace();
    }
  }
  
  private void c(int paramInt)
  {
    i.b("VehicleDownloadManager", "showUpdateDialog: " + paramInt);
    if (this.s == null) {
      this.s = new c(this.n, paramInt);
    }
    this.s.a(this.a);
    this.s.b(this.b);
    this.s.setOnDialogCancelListener(this.c);
    this.s.setNewAppSize(this.w.j);
    this.s.setDialogType(paramInt);
    this.s.i();
    this.o.showDialog(this.s);
  }
  
  private void c(com.baidu.carlife.core.connect.c paramc)
  {
    try
    {
      int i1 = CarLifeUpdateSuccessProtos.CarLifeUpdateSuccess.parseFrom(paramc.f()).getVersionCode();
      paramc = "车机端安装完成! 版本号：" + i1;
      w.a();
      w.a(paramc, 3500);
      return;
    }
    catch (InvalidProtocolBufferException paramc)
    {
      paramc.printStackTrace();
    }
  }
  
  private void g()
  {
    i.b("VehicleDownloadManager", "afterDownloadCheckMD5Fail");
    w();
    a(this.y);
    w.a(2131296363, 0);
  }
  
  private void h()
  {
    i.b("VehicleDownloadManager", "afterDownloadCheckMD5Success");
    q();
    b(1005);
  }
  
  private void i()
  {
    this.C.obtainMessage(5).sendToTarget();
  }
  
  private void j()
  {
    this.F = false;
    if (this.w == null) {
      return;
    }
    if (this.w.g == 1)
    {
      if (d())
      {
        i.b("VehicleDownloadManager", "Download Apk has exist !");
        b(1005);
        return;
      }
      i.b("VehicleDownloadManager", "Download file not exit, Download now.......");
      s();
      return;
    }
    b(1001);
  }
  
  private void k()
  {
    com.baidu.carlife.core.screen.presentation.a.e.a().a(a.a().getString(2131296381), new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        e.e(e.this).cancel();
      }
    });
  }
  
  private void l()
  {
    if (this.n == null) {
      return;
    }
    if (this.r == null) {
      this.r = new u(this.n);
    }
    this.r.setOnDialogCancelListener(new com.baidu.carlife.core.screen.d()
    {
      public void onCancel()
      {
        e.j(e.this);
      }
    });
    this.r.setTitle(2131297394);
    this.r.q();
    this.r.c(2131296361);
    this.r.a(new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        e.j(e.this);
      }
    });
    this.r.setPercent(0);
    this.r.setProgress(0);
    this.r.setHasFinished(0, this.w.j / 1048576);
    this.o.showDialog(this.r);
  }
  
  private void m()
  {
    if (this.n == null) {
      return;
    }
    if (this.r == null) {
      this.r = new u(this.n);
    }
    this.r.setOnDialogCancelListener(new com.baidu.carlife.core.screen.d()
    {
      public void onCancel()
      {
        e.j(e.this);
      }
    });
    this.r.setTitle(2131298623);
    this.r.q();
    this.r.c(2131296361);
    this.r.a(new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        e.j(e.this);
      }
    });
    this.r.setPercent(0);
    this.r.setProgress(0);
    this.r.setHasFinished(0, this.w.j / 1048576);
    this.o.showDialog(this.r);
  }
  
  private void n()
  {
    this.o.dismissDialog(this.r);
    i.b("VehicleDownloadManager", "cancel:: cancelUpdateProgressDialog");
    if (this.x != null) {
      this.x.d();
    }
    if (this.t != null) {
      this.t.a();
    }
  }
  
  /* Error */
  private int o()
  {
    // Byte code:
    //   0: new 432	com/baidu/carlife/util/g
    //   3: dup
    //   4: invokespecial 433	com/baidu/carlife/util/g:<init>	()V
    //   7: astore 9
    //   9: aload 9
    //   11: invokevirtual 435	com/baidu/carlife/util/g:b	()V
    //   14: aload_0
    //   15: getfield 181	com/baidu/carlife/n/e:y	Ljava/io/File;
    //   18: invokevirtual 441	java/io/File:length	()J
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
    //   36: ldc2_w 442
    //   39: lcmp
    //   40: ifgt +166 -> 206
    //   43: aconst_null
    //   44: astore 8
    //   46: aconst_null
    //   47: astore 7
    //   49: new 445	java/io/BufferedInputStream
    //   52: dup
    //   53: new 447	java/io/FileInputStream
    //   56: dup
    //   57: aload_0
    //   58: getfield 181	com/baidu/carlife/n/e:y	Ljava/io/File;
    //   61: invokespecial 449	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 452	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: astore 6
    //   69: sipush 1024
    //   72: newarray <illegal type>
    //   74: astore 7
    //   76: aload 6
    //   78: aload 7
    //   80: invokevirtual 456	java/io/BufferedInputStream:read	([B)I
    //   83: istore_1
    //   84: iload_1
    //   85: iconst_m1
    //   86: if_icmpeq +34 -> 120
    //   89: aload 9
    //   91: aload 7
    //   93: iload_1
    //   94: invokevirtual 459	com/baidu/carlife/util/g:a	([BI)V
    //   97: goto -21 -> 76
    //   100: astore 7
    //   102: iconst_m1
    //   103: istore_1
    //   104: aload 6
    //   106: ifnull -74 -> 32
    //   109: aload 6
    //   111: invokevirtual 462	java/io/BufferedInputStream:close	()V
    //   114: iconst_m1
    //   115: ireturn
    //   116: astore 6
    //   118: iconst_m1
    //   119: ireturn
    //   120: aload 6
    //   122: ifnull +8 -> 130
    //   125: aload 6
    //   127: invokevirtual 462	java/io/BufferedInputStream:close	()V
    //   130: aload 9
    //   132: invokevirtual 464	com/baidu/carlife/util/g:c	()V
    //   135: aload 9
    //   137: invokevirtual 466	com/baidu/carlife/util/g:a	()[B
    //   140: astore 6
    //   142: new 224	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 225	java/lang/StringBuilder:<init>	()V
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
    //   165: invokestatic 469	com/baidu/carlife/util/g:b	(B)Ljava/lang/String;
    //   168: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   196: invokevirtual 462	java/io/BufferedInputStream:close	()V
    //   199: aload 7
    //   201: athrow
    //   202: astore 6
    //   204: iconst_m1
    //   205: ireturn
    //   206: aconst_null
    //   207: astore 8
    //   209: aconst_null
    //   210: astore 7
    //   212: new 471	java/io/RandomAccessFile
    //   215: dup
    //   216: aload_0
    //   217: getfield 181	com/baidu/carlife/n/e:y	Ljava/io/File;
    //   220: ldc_w 472
    //   223: invokespecial 475	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   226: astore 6
    //   228: sipush 1024
    //   231: newarray <illegal type>
    //   233: astore 7
    //   235: aload 6
    //   237: lconst_0
    //   238: invokevirtual 479	java/io/RandomAccessFile:seek	(J)V
    //   241: iconst_0
    //   242: istore_1
    //   243: aload 6
    //   245: aload 7
    //   247: invokevirtual 480	java/io/RandomAccessFile:read	([B)I
    //   250: istore_3
    //   251: iload_3
    //   252: iconst_m1
    //   253: if_icmpeq +25 -> 278
    //   256: iload_1
    //   257: iload_3
    //   258: iadd
    //   259: istore_2
    //   260: iload_2
    //   261: ldc_w 481
    //   264: if_icmpgt +143 -> 407
    //   267: aload 9
    //   269: aload 7
    //   271: iload_3
    //   272: invokevirtual 459	com/baidu/carlife/util/g:a	([BI)V
    //   275: goto +276 -> 551
    //   278: aload 6
    //   280: aload_0
    //   281: getfield 174	com/baidu/carlife/n/e:w	Lcom/baidu/carlife/model/c;
    //   284: getfield 268	com/baidu/carlife/model/c:j	I
    //   287: iconst_2
    //   288: idiv
    //   289: i2l
    //   290: invokevirtual 479	java/io/RandomAccessFile:seek	(J)V
    //   293: iconst_0
    //   294: istore_1
    //   295: aload 6
    //   297: aload 7
    //   299: invokevirtual 480	java/io/RandomAccessFile:read	([B)I
    //   302: istore_3
    //   303: iload_3
    //   304: iconst_m1
    //   305: if_icmpeq +25 -> 330
    //   308: iload_1
    //   309: iload_3
    //   310: iadd
    //   311: istore_2
    //   312: iload_2
    //   313: ldc_w 481
    //   316: if_icmpgt +128 -> 444
    //   319: aload 9
    //   321: aload 7
    //   323: iload_3
    //   324: invokevirtual 459	com/baidu/carlife/util/g:a	([BI)V
    //   327: goto +236 -> 563
    //   330: aload 6
    //   332: aload_0
    //   333: getfield 174	com/baidu/carlife/n/e:w	Lcom/baidu/carlife/model/c;
    //   336: getfield 268	com/baidu/carlife/model/c:j	I
    //   339: ldc_w 481
    //   342: isub
    //   343: i2l
    //   344: invokevirtual 479	java/io/RandomAccessFile:seek	(J)V
    //   347: iconst_0
    //   348: istore_1
    //   349: aload 6
    //   351: aload 7
    //   353: invokevirtual 480	java/io/RandomAccessFile:read	([B)I
    //   356: istore_3
    //   357: iload_3
    //   358: iconst_m1
    //   359: if_icmpeq +31 -> 390
    //   362: iload_1
    //   363: iload_3
    //   364: iadd
    //   365: istore_2
    //   366: iload_2
    //   367: ldc_w 481
    //   370: if_icmpgt +106 -> 476
    //   373: aload 9
    //   375: aload 7
    //   377: iload_3
    //   378: invokevirtual 459	com/baidu/carlife/util/g:a	([BI)V
    //   381: iload_2
    //   382: istore_1
    //   383: iload_2
    //   384: ldc_w 481
    //   387: if_icmplt -38 -> 349
    //   390: aload 6
    //   392: ifnull -262 -> 130
    //   395: aload 6
    //   397: invokevirtual 482	java/io/RandomAccessFile:close	()V
    //   400: goto -270 -> 130
    //   403: astore 6
    //   405: iconst_m1
    //   406: ireturn
    //   407: aload 9
    //   409: aload 7
    //   411: iload_3
    //   412: iload_2
    //   413: ldc_w 481
    //   416: isub
    //   417: isub
    //   418: invokevirtual 459	com/baidu/carlife/util/g:a	([BI)V
    //   421: goto +130 -> 551
    //   424: astore 7
    //   426: iconst_m1
    //   427: istore_1
    //   428: aload 6
    //   430: ifnull -398 -> 32
    //   433: aload 6
    //   435: invokevirtual 482	java/io/RandomAccessFile:close	()V
    //   438: iconst_m1
    //   439: ireturn
    //   440: astore 6
    //   442: iconst_m1
    //   443: ireturn
    //   444: aload 9
    //   446: aload 7
    //   448: iload_3
    //   449: iload_2
    //   450: ldc_w 481
    //   453: isub
    //   454: isub
    //   455: invokevirtual 459	com/baidu/carlife/util/g:a	([BI)V
    //   458: goto +105 -> 563
    //   461: astore 7
    //   463: aload 6
    //   465: ifnull +8 -> 473
    //   468: aload 6
    //   470: invokevirtual 482	java/io/RandomAccessFile:close	()V
    //   473: aload 7
    //   475: athrow
    //   476: aload 9
    //   478: aload 7
    //   480: iload_3
    //   481: iload_2
    //   482: ldc_w 481
    //   485: isub
    //   486: isub
    //   487: invokevirtual 459	com/baidu/carlife/util/g:a	([BI)V
    //   490: goto -109 -> 381
    //   493: astore 6
    //   495: iconst_m1
    //   496: ireturn
    //   497: aload 7
    //   499: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: aload_0
    //   503: getfield 174	com/baidu/carlife/n/e:w	Lcom/baidu/carlife/model/c;
    //   506: getfield 484	com/baidu/carlife/model/c:n	Ljava/lang/String;
    //   509: invokevirtual 490	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
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
    //   554: ldc_w 481
    //   557: if_icmplt -314 -> 243
    //   560: goto -282 -> 278
    //   563: iload_2
    //   564: istore_1
    //   565: iload_2
    //   566: ldc_w 481
    //   569: if_icmplt -274 -> 295
    //   572: goto -242 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	575	0	this	e
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
  
  private void p()
  {
    m();
    b.a().a(this.K);
    b.a().c(this.w.g);
  }
  
  private void q()
  {
    SharedPreferences.Editor localEditor = this.q.edit();
    localEditor.putString("newVehhicleVersionName", this.w.l);
    localEditor.commit();
  }
  
  private void r()
  {
    String str = d.e();
    i.b("VehicleDownloadManager", "requestDownloadApp: " + str);
    this.x = new h(this.n, this.w.m, "CarLife-Vehicle.apk", str, this.I, true, 0);
    this.x.a(this.w.j);
    this.x.e();
  }
  
  private void s()
  {
    if (!this.q.contains("newVehhicleVersionName"))
    {
      i.b("VehicleDownloadManager", "not contain update record");
      u();
      return;
    }
    i.b("VehicleDownloadManager", "contain update record");
    if (this.q.getString("newVehhicleVersionName", "").equals(this.w.l))
    {
      i.b("VehicleDownloadManager", "has down new vehicle apk");
      if (this.y == null) {
        this.y = new File(d.f());
      }
      if ((this.y == null) || (!this.y.exists()))
      {
        i.b("VehicleDownloadManager", "OTA File not exist!");
        u();
        return;
      }
      t();
      new Thread(new Runnable()
      {
        public void run()
        {
          if (e.k(e.this) == 1)
          {
            e.l(e.this).sendEmptyMessage(1);
            return;
          }
          e.l(e.this).sendEmptyMessage(2);
        }
      }).start();
      return;
    }
    u();
  }
  
  private void t()
  {
    com.baidu.carlife.core.screen.presentation.a.e.a().b(a.a().getString(2131297190));
  }
  
  private void u()
  {
    this.p = 4098;
    if (this.w.i == 0)
    {
      i.b("VehicleDownloadManager", "downloadApk");
      l();
      r();
      return;
    }
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(this.w.m));
      this.n.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void v()
  {
    this.p = 4097;
    if (this.t != null) {
      this.t.a();
    }
    i.b("VehicleDownloadManager", "cancel:: updateDialogCancel");
    if (this.x != null) {
      this.x.d();
    }
  }
  
  private void w()
  {
    this.p = 4097;
    i.b("VehicleDownloadManager", "afterDownload dismissdialog");
    this.o.dismissDialog();
    if (this.t != null) {
      this.t.a();
    }
  }
  
  private void x()
  {
    Intent localIntent = new Intent(this.n, NotificationDownloadService.class);
    this.u = this.n.bindService(localIntent, this.J, 1);
  }
  
  public void a(int paramInt)
  {
    if (this.s != null) {
      this.s.setNewAppSize(paramInt);
    }
  }
  
  public void a(Activity paramActivity, com.baidu.carlife.core.screen.e parame)
  {
    this.n = paramActivity;
    this.o = parame;
    this.q = paramActivity.getSharedPreferences("CarlifeUpdateRecord", 0);
    this.C = new b();
    k.a(this.C);
  }
  
  public void a(com.baidu.carlife.core.connect.c paramc)
  {
    w.a();
    w.a("传输完成，车机端开始安装更新!", 3500);
  }
  
  public void a(HomeMoreFragment.b paramb)
  {
    this.H = paramb;
  }
  
  public void a(File paramFile)
  {
    if (this.n == null) {
      return;
    }
    Object localObject = new NotificationCompat.Builder(this.n).setSmallIcon(2130838698).setContentTitle(this.n.getString(2131296367)).setContentText(this.n.getString(2131296362));
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.android.package-archive");
    paramFile = TaskStackBuilder.create(this.n);
    paramFile.addParentStack(CarlifeActivity.class);
    paramFile.addNextIntent(localIntent);
    ((NotificationCompat.Builder)localObject).setContentIntent(paramFile.getPendingIntent(0, 134217728));
    paramFile = (NotificationManager)this.n.getSystemService("notification");
    localObject = ((NotificationCompat.Builder)localObject).build();
    ((Notification)localObject).flags |= 0x10;
    paramFile.notify(8194, (Notification)localObject);
  }
  
  public void a(boolean paramBoolean)
  {
    i.b("#######", "####### checkNewVersion: " + paramBoolean);
    this.v = new t();
    this.v.a(this.z);
    if (paramBoolean) {
      this.v.registerResponseListener(new a(null));
    }
    for (;;)
    {
      this.v.toPostRequest();
      return;
      this.v.registerResponseListener(new d(null));
    }
  }
  
  public void b(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 11;
    localMessage.arg1 = paramInt;
    this.C.sendMessage(localMessage);
  }
  
  public boolean b()
  {
    return this.F;
  }
  
  public void c()
  {
    if (this.p != 4097)
    {
      w.a(2131296374, 0);
      return;
    }
    i.b("VehicleDownloadManager", "checkHUNewVersion");
    k();
    a(true);
  }
  
  public boolean d()
  {
    if (this.q.getString("newVehhicleVersionName", "").equals(this.w.l))
    {
      if (this.y == null) {
        this.y = new File(d.f());
      }
      if ((this.y != null) && (this.y.exists())) {
        return true;
      }
      i.b("VehicleDownloadManager", "Not exit down load apk file !");
    }
    return false;
  }
  
  public void e()
  {
    if (com.baidu.carlife.core.e.s() == 1)
    {
      i.b("VehicleDownloadManager", "checkUseWifiToDownLoad MOBILE");
      b(1002);
      return;
    }
    i.b("VehicleDownloadManager", "checkUseWifiToDownLoad WIFI ->> check download immediately");
    b(1003);
  }
  
  public void f()
  {
    if (this.t != null)
    {
      i.b("VehicleDownloadManager", "unbindService");
      this.t.stopSelf();
      this.n.unbindService(this.J);
    }
  }
  
  private class a
    implements com.baidu.carlife.k.a.e.a
  {
    private a() {}
    
    public void onNetWorkResponse(int paramInt)
    {
      i.b("VehicleDownloadManager", "onNetWorkResponse: " + paramInt);
      com.baidu.carlife.core.screen.presentation.a.e.a().c();
      switch (paramInt)
      {
      case -1: 
      default: 
        return;
      case 0: 
        e.a(e.this, e.e(e.this).a());
        i.b("VehicleDownloadManager", "RESPONSE_SUCCESS: " + e.f(e.this).toString());
        if (e.f(e.this).g == 1)
        {
          e.a(e.this, true);
          e.g(e.this);
          e.this.a(e.f(e.this).j);
          e.this.e();
          return;
        }
        e.a(e.this, false);
        e.g(e.this);
        e.this.b(1001);
        return;
      }
      w.a(2131296368, 0);
    }
  }
  
  private class b
    extends j
  {
    public b() {}
    
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void careAbout()
    {
      addMsg(491526);
      addMsg(491530);
      addMsg(491531);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        e.a(e.this, (com.baidu.carlife.core.connect.c)paramMessage.obj);
        return;
        e.this.a((com.baidu.carlife.core.connect.c)paramMessage.obj);
        return;
        e.b(e.this, (com.baidu.carlife.core.connect.c)paramMessage.obj);
        return;
        e.a(e.this, paramMessage.arg1);
        return;
        i.b("VehicleDownloadManager", "MD5 Success!");
        e.b(e.this, 4097);
        com.baidu.carlife.core.screen.presentation.a.e.a().c();
        e.this.b(1005);
        return;
        i.b("VehicleDownloadManager", "MD5 Error!");
        com.baidu.carlife.core.screen.presentation.a.e.a().c();
        e.a(e.this);
        return;
        i.b("VehicleDownloadManager", "MD5 Success!  AfterDownload");
        e.b(e.this);
        return;
        e.c(e.this);
        return;
      } while (e.d(e.this) == null);
      e.d(e.this).a();
    }
  }
  
  private static class c
  {
    private static e a = new e();
  }
  
  private class d
    implements com.baidu.carlife.k.a.e.a
  {
    private d() {}
    
    public void onNetWorkResponse(int paramInt)
    {
      i.b("VehicleDownloadManager", "checkNewVersion Response: " + paramInt);
      switch (paramInt)
      {
      case -1: 
      default: 
        i.b("VehicleDownloadManager", "onNetWorkResponse Error: " + paramInt);
        return;
      case 0: 
        e.a(e.this, e.e(e.this).a());
        i.b("VehicleDownloadManager", "RESPONSE_SUCCESS: " + e.f(e.this).toString());
        e.c(e.this, Integer.parseInt(e.f(e.this).l));
        i.b("VehicleDownloadManager", "checkNewVersion: " + e.h(e.this));
        if ((e.f(e.this).g == 1) || (e.h(e.this) > e.i(e.this)))
        {
          e.a(e.this, true);
          e.g(e.this);
          k.b(3012);
          e.this.a(e.f(e.this).j);
          return;
        }
        e.a(e.this, false);
        e.g(e.this);
        return;
      }
      i.b("VehicleDownloadManager", "onNetWorkResponse: RESPONSE_ERROR_NONETWORK");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/n/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */