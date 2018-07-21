package com.baidu.carlife.logic.music;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.k;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.platform.c;
import com.baidu.carlife.platform.model.CLAlbum;
import com.baidu.carlife.util.w;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class s
  extends b
{
  private static final int T = 20;
  private MusicSongModel U = null;
  private Thread V = null;
  private long W = 0L;
  private com.baidu.carlife.core.j X = new com.baidu.carlife.core.j(BaiduNaviApplication.getInstance().getMainLooper())
  {
    public void careAbout()
    {
      addMsg(4014);
      addMsg(412);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      try
      {
        String str = (String)paramAnonymousMessage.obj;
        if (TextUtils.isEmpty(str)) {
          return;
        }
        if (!str.equals(s.this.q())) {
          break label189;
        }
        switch (paramAnonymousMessage.what)
        {
        case 412: 
          if (s.this.v() == 1)
          {
            s.this.u();
            s.this.a(0);
          }
          s.this.j(1);
          s.this.e(null);
          s.this.I.clear();
          s.this.x.clear();
          s.this.H.a(str);
          s.this.S.clear();
          return;
        }
      }
      catch (Exception paramAnonymousMessage)
      {
        paramAnonymousMessage.printStackTrace();
        return;
      }
      if (paramAnonymousMessage.arg1 == 43990)
      {
        s.this.j(1);
        return;
      }
      if (paramAnonymousMessage.arg1 == 43991) {
        s.this.j(0);
      }
      label189:
      return;
    }
  };
  
  public s(Context paramContext, int paramInt, String paramString)
  {
    this.C = paramContext;
    this.E = paramString;
    this.F = paramInt;
    B();
    this.I = new ArrayList();
    k.a(this.X);
  }
  
  private void A()
  {
    if (!e.a().r())
    {
      w.a(this.C.getString(2131296368), 0);
      return;
    }
    Object localObject1 = h.b().m(s());
    if (localObject1 == null) {}
    for (localObject1 = null; TextUtils.isEmpty((CharSequence)localObject1); localObject1 = ((com.baidu.carlife.model.j)localObject1).i)
    {
      w.a("非法URL" + (String)localObject1, 1);
      return;
    }
    Object localObject2 = localObject1;
    if (!((String)localObject1).startsWith("http")) {
      localObject2 = "http://" + (String)localObject1;
    }
    try
    {
      localObject1 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject2));
      ((Intent)localObject1).addFlags(268435456);
      this.C.startActivity((Intent)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void B()
  {
    if (k(this.E))
    {
      List localList = g();
      if ((localList != null) && (!localList.isEmpty()))
      {
        c(2);
        return;
      }
      c(1);
      return;
    }
    c(0);
  }
  
  private boolean k(String paramString)
  {
    try
    {
      paramString = this.C.getPackageManager().getPackageInfo(paramString, 0);
      if (paramString != null) {
        break label19;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      label19:
      do
      {
        paramString = paramString;
      } while (0 == 0);
      return true;
    }
    finally
    {
      do
      {
        paramString = finally;
      } while (0 == 0);
    }
    return false;
    return true;
    return true;
  }
  
  private void z()
  {
    this.W = System.currentTimeMillis();
    if ((this.X != null) && (this.V == null))
    {
      this.V = new Thread()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: ldc 29
          //   2: ldc 31
          //   4: invokestatic 37	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
          //   7: invokestatic 42	com/baidu/carlife/logic/music/h:b	()Lcom/baidu/carlife/logic/music/h;
          //   10: aload_0
          //   11: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   14: invokevirtual 46	com/baidu/carlife/logic/music/s:s	()I
          //   17: invokevirtual 50	com/baidu/carlife/logic/music/h:m	(I)Lcom/baidu/carlife/model/j;
          //   20: astore 6
          //   22: getstatic 56	android/os/Build$VERSION:SDK_INT	I
          //   25: bipush 23
          //   27: if_icmplt +22 -> 49
          //   30: iconst_1
          //   31: istore_1
          //   32: aload 6
          //   34: ifnull +14 -> 48
          //   37: aload 6
          //   39: invokevirtual 61	com/baidu/carlife/model/j:a	()Ljava/lang/String;
          //   42: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
          //   45: ifeq +9 -> 54
          //   48: return
          //   49: iconst_0
          //   50: istore_1
          //   51: goto -19 -> 32
          //   54: iload_1
          //   55: ifeq +21 -> 76
          //   58: aload_0
          //   59: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   62: aload 6
          //   64: getfield 70	com/baidu/carlife/model/j:m	Ljava/lang/String;
          //   67: invokevirtual 74	com/baidu/carlife/logic/music/s:c	(Ljava/lang/String;)V
          //   70: ldc2_w 75
          //   73: invokestatic 80	java/lang/Thread:sleep	(J)V
          //   76: new 82	android/content/Intent
          //   79: dup
          //   80: aload 6
          //   82: invokevirtual 61	com/baidu/carlife/model/j:a	()Ljava/lang/String;
          //   85: invokespecial 84	android/content/Intent:<init>	(Ljava/lang/String;)V
          //   88: astore 5
          //   90: aload 5
          //   92: ldc 86
          //   94: ldc 88
          //   96: invokevirtual 92	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   99: pop
          //   100: aload 5
          //   102: aload 6
          //   104: getfield 70	com/baidu/carlife/model/j:m	Ljava/lang/String;
          //   107: invokevirtual 96	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
          //   110: pop
          //   111: aconst_null
          //   112: astore_2
          //   113: aconst_null
          //   114: astore_3
          //   115: aload_0
          //   116: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   119: getfield 100	com/baidu/carlife/logic/music/s:C	Landroid/content/Context;
          //   122: aload 5
          //   124: invokevirtual 106	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
          //   127: astore 4
          //   129: aload 4
          //   131: astore_2
          //   132: aload_2
          //   133: ifnonnull +110 -> 243
          //   136: aload_0
          //   137: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   140: aload 6
          //   142: getfield 70	com/baidu/carlife/model/j:m	Ljava/lang/String;
          //   145: invokevirtual 74	com/baidu/carlife/logic/music/s:c	(Ljava/lang/String;)V
          //   148: iconst_0
          //   149: istore_1
          //   150: iload_1
          //   151: bipush 10
          //   153: if_icmpge +90 -> 243
          //   156: aload_2
          //   157: ifnonnull +86 -> 243
          //   160: ldc2_w 107
          //   163: invokestatic 80	java/lang/Thread:sleep	(J)V
          //   166: aload_0
          //   167: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   170: getfield 100	com/baidu/carlife/logic/music/s:C	Landroid/content/Context;
          //   173: aload 5
          //   175: invokevirtual 106	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
          //   178: astore_2
          //   179: iload_1
          //   180: iconst_1
          //   181: iadd
          //   182: istore_1
          //   183: goto -33 -> 150
          //   186: astore_2
          //   187: ldc 29
          //   189: ldc 110
          //   191: invokestatic 113	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   194: goto -118 -> 76
          //   197: astore_2
          //   198: aload_2
          //   199: invokevirtual 116	java/lang/InterruptedException:printStackTrace	()V
          //   202: goto -126 -> 76
          //   205: astore_2
          //   206: ldc 117
          //   208: iconst_0
          //   209: invokestatic 122	com/baidu/carlife/util/w:a	(II)V
          //   212: new 11	com/baidu/carlife/logic/music/s$1$1
          //   215: dup
          //   216: aload_0
          //   217: invokespecial 125	com/baidu/carlife/logic/music/s$1$1:<init>	(Lcom/baidu/carlife/logic/music/s$1;)V
          //   220: astore_2
          //   221: aload_0
          //   222: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   225: invokestatic 128	com/baidu/carlife/logic/music/s:a	(Lcom/baidu/carlife/logic/music/s;)Lcom/baidu/carlife/core/j;
          //   228: aload_2
          //   229: ldc2_w 129
          //   232: invokevirtual 136	com/baidu/carlife/core/j:postDelayed	(Ljava/lang/Runnable;J)Z
          //   235: pop
          //   236: aload_0
          //   237: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   240: invokevirtual 139	com/baidu/carlife/logic/music/s:d	()V
          //   243: aload_0
          //   244: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   247: aconst_null
          //   248: invokestatic 142	com/baidu/carlife/logic/music/s:a	(Lcom/baidu/carlife/logic/music/s;Ljava/lang/Thread;)Ljava/lang/Thread;
          //   251: pop
          //   252: return
          //   253: astore_2
          //   254: aload_2
          //   255: invokevirtual 143	java/lang/Exception:printStackTrace	()V
          //   258: goto -15 -> 243
          //   261: astore 4
          //   263: aload 4
          //   265: invokevirtual 143	java/lang/Exception:printStackTrace	()V
          //   268: iconst_0
          //   269: ifne -26 -> 243
          //   272: aload_0
          //   273: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   276: aload 6
          //   278: getfield 70	com/baidu/carlife/model/j:m	Ljava/lang/String;
          //   281: invokevirtual 74	com/baidu/carlife/logic/music/s:c	(Ljava/lang/String;)V
          //   284: iconst_0
          //   285: istore_1
          //   286: aload_3
          //   287: astore_2
          //   288: iload_1
          //   289: bipush 10
          //   291: if_icmpge -48 -> 243
          //   294: aload_2
          //   295: ifnonnull -52 -> 243
          //   298: ldc2_w 107
          //   301: invokestatic 80	java/lang/Thread:sleep	(J)V
          //   304: aload_0
          //   305: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   308: getfield 100	com/baidu/carlife/logic/music/s:C	Landroid/content/Context;
          //   311: aload 5
          //   313: invokevirtual 106	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
          //   316: astore_2
          //   317: iload_1
          //   318: iconst_1
          //   319: iadd
          //   320: istore_1
          //   321: goto -33 -> 288
          //   324: astore_2
          //   325: ldc 117
          //   327: iconst_0
          //   328: invokestatic 122	com/baidu/carlife/util/w:a	(II)V
          //   331: new 11	com/baidu/carlife/logic/music/s$1$1
          //   334: dup
          //   335: aload_0
          //   336: invokespecial 125	com/baidu/carlife/logic/music/s$1$1:<init>	(Lcom/baidu/carlife/logic/music/s$1;)V
          //   339: astore_2
          //   340: aload_0
          //   341: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   344: invokestatic 128	com/baidu/carlife/logic/music/s:a	(Lcom/baidu/carlife/logic/music/s;)Lcom/baidu/carlife/core/j;
          //   347: aload_2
          //   348: ldc2_w 129
          //   351: invokevirtual 136	com/baidu/carlife/core/j:postDelayed	(Ljava/lang/Runnable;J)Z
          //   354: pop
          //   355: aload_0
          //   356: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   359: invokevirtual 139	com/baidu/carlife/logic/music/s:d	()V
          //   362: goto -119 -> 243
          //   365: astore_2
          //   366: aload_2
          //   367: invokevirtual 143	java/lang/Exception:printStackTrace	()V
          //   370: goto -127 -> 243
          //   373: astore_3
          //   374: iconst_0
          //   375: ifne +91 -> 466
          //   378: aload_0
          //   379: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   382: aload 6
          //   384: getfield 70	com/baidu/carlife/model/j:m	Ljava/lang/String;
          //   387: invokevirtual 74	com/baidu/carlife/logic/music/s:c	(Ljava/lang/String;)V
          //   390: iconst_0
          //   391: istore_1
          //   392: iload_1
          //   393: bipush 10
          //   395: if_icmpge +71 -> 466
          //   398: aload_2
          //   399: ifnonnull +67 -> 466
          //   402: ldc2_w 107
          //   405: invokestatic 80	java/lang/Thread:sleep	(J)V
          //   408: aload_0
          //   409: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   412: getfield 100	com/baidu/carlife/logic/music/s:C	Landroid/content/Context;
          //   415: aload 5
          //   417: invokevirtual 106	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
          //   420: astore_2
          //   421: iload_1
          //   422: iconst_1
          //   423: iadd
          //   424: istore_1
          //   425: goto -33 -> 392
          //   428: astore_2
          //   429: ldc 117
          //   431: iconst_0
          //   432: invokestatic 122	com/baidu/carlife/util/w:a	(II)V
          //   435: new 11	com/baidu/carlife/logic/music/s$1$1
          //   438: dup
          //   439: aload_0
          //   440: invokespecial 125	com/baidu/carlife/logic/music/s$1$1:<init>	(Lcom/baidu/carlife/logic/music/s$1;)V
          //   443: astore_2
          //   444: aload_0
          //   445: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   448: invokestatic 128	com/baidu/carlife/logic/music/s:a	(Lcom/baidu/carlife/logic/music/s;)Lcom/baidu/carlife/core/j;
          //   451: aload_2
          //   452: ldc2_w 129
          //   455: invokevirtual 136	com/baidu/carlife/core/j:postDelayed	(Ljava/lang/Runnable;J)Z
          //   458: pop
          //   459: aload_0
          //   460: getfield 17	com/baidu/carlife/logic/music/s$1:a	Lcom/baidu/carlife/logic/music/s;
          //   463: invokevirtual 139	com/baidu/carlife/logic/music/s:d	()V
          //   466: aload_3
          //   467: athrow
          //   468: astore_2
          //   469: aload_2
          //   470: invokevirtual 143	java/lang/Exception:printStackTrace	()V
          //   473: goto -7 -> 466
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	476	0	this	1
          //   31	394	1	i	int
          //   112	67	2	localObject1	Object
          //   186	1	2	localActivityNotFoundException1	android.content.ActivityNotFoundException
          //   197	2	2	localInterruptedException	InterruptedException
          //   205	1	2	localActivityNotFoundException2	android.content.ActivityNotFoundException
          //   220	9	2	local11	1
          //   253	2	2	localException1	Exception
          //   287	30	2	localObject2	Object
          //   324	1	2	localActivityNotFoundException3	android.content.ActivityNotFoundException
          //   339	9	2	local12	1
          //   365	34	2	localException2	Exception
          //   420	1	2	localComponentName1	android.content.ComponentName
          //   428	1	2	localActivityNotFoundException4	android.content.ActivityNotFoundException
          //   443	9	2	local13	1
          //   468	2	2	localException3	Exception
          //   114	173	3	localObject3	Object
          //   373	94	3	localObject4	Object
          //   127	3	4	localComponentName2	android.content.ComponentName
          //   261	3	4	localException4	Exception
          //   88	328	5	localIntent	Intent
          //   20	363	6	localj	com.baidu.carlife.model.j
          // Exception table:
          //   from	to	target	type
          //   58	76	186	android/content/ActivityNotFoundException
          //   58	76	197	java/lang/InterruptedException
          //   136	148	205	android/content/ActivityNotFoundException
          //   160	179	205	android/content/ActivityNotFoundException
          //   136	148	253	java/lang/Exception
          //   160	179	253	java/lang/Exception
          //   115	129	261	java/lang/Exception
          //   272	284	324	android/content/ActivityNotFoundException
          //   298	317	324	android/content/ActivityNotFoundException
          //   272	284	365	java/lang/Exception
          //   298	317	365	java/lang/Exception
          //   115	129	373	finally
          //   263	268	373	finally
          //   378	390	428	android/content/ActivityNotFoundException
          //   402	421	428	android/content/ActivityNotFoundException
          //   378	390	468	java/lang/Exception
          //   402	421	468	java/lang/Exception
        }
      };
      this.V.start();
    }
  }
  
  public int a(int paramInt, String paramString)
  {
    int i = 0;
    e(paramString);
    if (e.a().r())
    {
      if (f(paramString) == null)
      {
        paramInt = 0;
        if (!i(paramString)) {
          break label65;
        }
        w.a(this.C.getString(2131296616), 1);
        i = 1;
      }
      label65:
      do
      {
        return i;
        paramInt = f(paramString).size();
        break;
        if (paramInt == 0) {
          c();
        }
      } while (TextUtils.isEmpty(paramString));
      c.a().a(q(), paramString, paramInt, 20);
      return 0;
    }
    i(3);
    return 0;
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if ((this.U == null) || (!this.U.a.equals(paramString))) {
      this.U = h(paramString);
    }
    if (this.U == null) {
      com.baidu.carlife.core.i.e("CarLifeMusic", "---onGetSong--songId:" + paramString);
    }
    do
    {
      return;
      this.U.n = paramLong1;
      this.U.o = paramLong2;
      if ((paramBoolean) && (paramLong1 >= paramLong2) && (paramLong1 > 0L))
      {
        com.baidu.carlife.core.i.b("CarLifeMusic", "----MSG_MUSIC_THIRDPARTY_DOWNLOAD_COMPLETE---");
        k.a(217, this.U);
      }
    } while (!paramBoolean);
    this.U = null;
  }
  
  public void a(List<CLAlbum> paramList)
  {
    com.baidu.carlife.core.i.b("CarLifePlatform", "PlatformManager.onGetAlbumList() --2");
    this.I.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.baidu.carlife.model.i locali = new com.baidu.carlife.model.i((CLAlbum)paramList.next());
      this.I.add(locali);
    }
    if (this.I.isEmpty())
    {
      k.a(248, s(), 1000);
      return;
    }
    paramList = (com.baidu.carlife.model.i)this.I.get(0);
    if (paramList.a.equals("下载听")) {
      this.A = paramList.c;
    }
    k.b(206, 1, s());
    int i = (int)(System.currentTimeMillis() - this.W);
    switch (this.F)
    {
    default: 
      return;
    case 3: 
      StatisticManager.onEventDuration(this.C, "MUSIC_XMLY_0008", "喜马拉雅FM同步时长", i);
      return;
    case 4: 
      StatisticManager.onEventDuration(this.C, "MUSIC_KAOLA_0008", "考拉FM同步时长", i);
      return;
    }
    StatisticManager.onEventDuration(this.C, "MUSIC_CYB_0008", "车悦宝同步时长", i);
  }
  
  public void a(List<MusicSongModel> paramList, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Pair localPair = new Pair(paramString, paramList);
      k.a(218, s(), localPair);
      if (paramInt2 <= 0) {
        paramInt2 = paramList.size();
      }
      for (;;)
      {
        if ((paramInt3 > 0) && (paramInt3 <= paramInt1 + paramInt2))
        {
          com.baidu.carlife.core.i.b("CarLifeMusic", "PlatformManager.onGetSongList() - ALL");
          j(paramString);
        }
        return;
      }
    }
    paramList = f(paramString);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      com.baidu.carlife.core.i.b("CarLifeMusic", "PlatformManager.onGetSongList() - FAIL");
      b(paramString);
    }
    if ((this.I != null) && (this.I.size() != 0) && (this.A != null) && (this.A.equals(paramString)))
    {
      b(paramString);
      k.b(249, s(), -1);
      return;
    }
    k.b(249, s());
  }
  
  public void b(boolean paramBoolean)
  {
    if (x() == 1)
    {
      if (paramBoolean) {}
      switch (this.F)
      {
      default: 
        c();
        z();
      }
    }
    do
    {
      return;
      StatisticManager.onEvent("MUSIC_XMLY_0007");
      break;
      StatisticManager.onEvent("MUSIC_KAOLA_0007");
      break;
      StatisticManager.onEvent("MUSIC_CYB_0007");
      break;
      if (x() == 0)
      {
        if (paramBoolean) {
          switch (this.F)
          {
          }
        }
        for (;;)
        {
          A();
          return;
          StatisticManager.onEvent("MUSIC_XMLY_0006");
          continue;
          StatisticManager.onEvent("MUSIC_KAOLA_0006");
          continue;
          StatisticManager.onEvent("MUSIC_CYB_0006");
        }
      }
    } while (x() != 3);
    if (e.a().r())
    {
      if (v() == 0)
      {
        a(false);
        j();
        return;
      }
      b();
      return;
    }
    w.a(this.C.getString(2131296368), 0);
  }
  
  public Bitmap d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return e.a(paramString);
  }
  
  public void d(int paramInt)
  {
    if (e(w())) {
      if (this.H != null) {
        this.H.a(paramInt);
      }
    }
    do
    {
      return;
      if (!e.a().r()) {
        break;
      }
      c();
    } while (c.a().a(q()));
    z();
    return;
    j(3);
    d();
  }
  
  public boolean e(int paramInt)
  {
    if (paramInt == 2) {
      if (this.J != null) {}
    }
    while ((paramInt != 1) || (this.I == null) || (this.I.isEmpty()))
    {
      do
      {
        return false;
      } while (this.J.isEmpty());
      return true;
    }
    return true;
  }
  
  public List<MusicSongModel> g()
  {
    return f(n());
  }
  
  @Deprecated
  public void h() {}
  
  public boolean i(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.S.contains(paramString)) {
      return false;
    }
    return true;
  }
  
  public void j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.S.add(paramString);
  }
  
  public void y()
  {
    c.a().c(q());
    e(null);
    this.I.clear();
    this.x.clear();
    k.b(this.X);
    this.X = null;
    super.y();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */