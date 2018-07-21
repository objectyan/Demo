package com.baidu.carlife.logic.music;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import com.baidu.baidunavis.control.NavTrajectoryController;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.f;
import com.baidu.carlife.fragment.MusicPlayerFragment;
import com.baidu.carlife.logic.a.d;
import com.baidu.carlife.logic.b.b;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.service.MusicPlayService;
import com.baidu.carlife.service.MusicPlayService.a;
import com.baidu.carlife.util.l;
import com.baidu.carlife.util.w;
import com.baidu.che.codriver.sdk.a.f.a.a;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticManager;
import com.netease.cloudmusic.utils.NeteaseMusicUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h
{
  private static h H;
  private static final Object I = new Object();
  public static final String a = "CarLifeMusic";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = -1;
  public static final String g = "localPlayStrategy";
  public static String h = "单曲模式";
  public static String i = "随机模式";
  public static String j = "循环模式";
  public static final String k = "LastestPlaySource";
  public static final int l = 2;
  private static final int o = 1;
  private MusicSongModel A = null;
  private MusicSongModel B = null;
  private boolean C = false;
  private boolean D = true;
  private List<MusicSongModel> E;
  private ArrayList<String> F;
  private List<MusicSongModel> G;
  private int J;
  private int K;
  private ArrayList<MusicSongModel> L = new ArrayList();
  private f.a.a M;
  private HandlerThread N;
  private HandlerThread O;
  private com.baidu.carlife.core.j P;
  private Handler Q;
  private Handler R;
  private Context S;
  private MusicPlayService.a T;
  private a U;
  private g V;
  private com.baidu.carlife.logic.a.j W;
  private Bundle X;
  private ServiceConnection Y = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      com.baidu.carlife.core.i.b("CarLifeMusic", "---onServiceConnected----");
      h.a(h.this, (MusicPlayService.a)paramAnonymousIBinder);
      h.h(h.this).a(new m()
      {
        public void a()
        {
          if (h.this.q())
          {
            h.f(h.this);
            return;
          }
          h.g(h.this);
        }
        
        public void a(int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, Object paramAnonymous2Object)
        {
          h.this.a(paramAnonymous2Int1, paramAnonymous2Int2, paramAnonymous2Int3, paramAnonymous2Object);
        }
        
        public void a(boolean paramAnonymous2Boolean)
        {
          if (h.this.q())
          {
            h.this.e(paramAnonymous2Boolean);
            return;
          }
          h.this.d(paramAnonymous2Boolean);
        }
        
        public void b()
        {
          h.this.f(false);
        }
      });
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      com.baidu.carlife.core.i.b("CarLifeMusic", "---onServiceDisconnected----");
    }
  };
  private int m;
  private int n = -1;
  private boolean p = false;
  private long q = -1L;
  private long r = -1L;
  private boolean s = false;
  private boolean t = true;
  private int u = 1;
  private int v = 0;
  private boolean w = true;
  private boolean x = false;
  private boolean y = false;
  private int z = 5;
  
  private void K()
  {
    this.t = true;
    this.x = true;
    this.w = false;
    this.v = 0;
    this.A.k = true;
    this.A.j = 0;
    try
    {
      this.u = (Integer.parseInt(this.A.i) / 1000);
      if (this.q == -1L)
      {
        this.q = System.currentTimeMillis();
        this.P.removeMessages(1);
        this.P.sendEmptyMessageDelayed(1, 3000L);
      }
      this.V.b();
      if ((this.n == 1) || (this.n == 0))
      {
        com.baidu.carlife.core.k.a(226);
        com.baidu.carlife.core.k.b(226, this.n);
      }
      this.P.sendEmptyMessage(229);
      Y();
      com.baidu.carlife.core.k.a(225, this.n, 100);
      com.baidu.carlife.core.k.b(310, 43985);
      com.baidu.carlife.logic.k.a().a(3, 1);
      A();
      this.R.post(new Runnable()
      {
        public void run()
        {
          h.this.r().t();
        }
      });
      if (this.y)
      {
        f(this.w);
        this.y = false;
      }
      if ((n.a().l()) || (com.baidu.carlife.logic.k.a().c() != 0)) {
        f(this.w);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        this.u = 1;
      }
    }
  }
  
  private void L()
  {
    this.t = true;
    this.x = true;
    this.w = false;
    this.v = 0;
    this.B.k = true;
    this.B.j = 0;
    try
    {
      this.u = (Integer.parseInt(this.B.i) / 1000);
      if (this.q == -1L)
      {
        this.q = System.currentTimeMillis();
        this.P.removeMessages(1);
        this.P.sendEmptyMessageDelayed(1, 3000L);
      }
      this.V.b();
      com.baidu.carlife.core.k.a(226);
      com.baidu.carlife.core.k.b(226, 101);
      com.baidu.carlife.core.k.b(310, 43985);
      com.baidu.carlife.g.a.a(this.B, 200, 200);
      Y();
      com.baidu.carlife.core.k.a(225, 101, 100);
      com.baidu.carlife.logic.k.a().a(3, 1);
      A();
      if (this.y)
      {
        f(this.w);
        this.y = false;
      }
      if ((n.a().l()) || (com.baidu.carlife.logic.k.a().c() != 0)) {
        f(this.w);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        this.u = 1;
      }
    }
  }
  
  private void M()
  {
    this.P.removeMessages(221);
    this.P.sendEmptyMessageDelayed(221, 0L);
  }
  
  private boolean N()
  {
    return (this.B.n > 0L) && (this.B.n >= this.B.o);
  }
  
  private void O()
  {
    this.W.d().a();
    this.F.clear();
    this.W.d().b(this.B.m);
    this.P.removeMessages(221);
    this.P.sendEmptyMessageDelayed(221, 500L);
  }
  
  private void P()
  {
    if (com.baidu.carlife.logic.a.j.a().b() == 3) {}
    int i1;
    List localList;
    do
    {
      return;
      i1 = this.W.c().m();
      localList = this.W.c().g();
    } while ((localList == null) || (i1 < localList.size() - 1));
    this.W.c().a(0, this.W.c().n());
  }
  
  private void Q()
  {
    StatisticManager.onEvent("CONTENT_REC_0001_VOICE");
    com.baidu.carlife.radio.a.a locala = com.baidu.carlife.radio.c.b.a().c(this.W.c().n());
    StatisticManager.onEvent(locala.d() + "_VOICE");
  }
  
  private void R()
  {
    this.P.removeMessages(260);
    this.P.removeMessages(221);
  }
  
  private int S()
  {
    if (i(this.n))
    {
      if ((this.A != null) && (!this.A.k))
      {
        if (this.w)
        {
          d(true);
          return 4;
        }
        return 3;
      }
    }
    else
    {
      aj();
      int i1 = b(0);
      List localList = a(0);
      if ((localList != null) && (localList.size() > 0))
      {
        f(true);
        a(0, (MusicSongModel)localList.get(i1));
        return 4;
      }
      return 0;
    }
    return -1;
  }
  
  private void T()
  {
    if ((!g(0)) || (TextUtils.isEmpty(this.A.m))) {
      return;
    }
    this.T.a();
    if (!new File(this.A.m).exists())
    {
      this.R.post(new Runnable()
      {
        public void run()
        {
          h.d(h.this);
        }
      });
      return;
    }
    this.T.a(n(), this.A);
  }
  
  private void U()
  {
    if (b(this.A))
    {
      if ((this.A.n > 0L) && (this.A.n >= this.A.o))
      {
        M();
        c(this.A);
        af();
        return;
      }
      d(this.A);
      b(this.n, this.A);
      return;
    }
    b(this.n, this.A);
  }
  
  private void V()
  {
    d.b().a(MusicPlayerFragment.class.getName(), new com.baidu.carlife.logic.j(this.G));
    d.b().a(com.baidu.carlife.logic.j.class.getName(), new com.baidu.carlife.logic.j(this.E));
    d.b().a(com.baidu.carlife.logic.i.class.getName(), new com.baidu.carlife.logic.i(this.F));
  }
  
  private void W()
  {
    com.baidu.carlife.logic.a.j.a().a(new r(this.S, 101, "CarLifeRadio"));
  }
  
  private void X()
  {
    this.P.removeMessages(307);
  }
  
  private void Y()
  {
    this.P.removeMessages(307);
    this.P.sendEmptyMessageDelayed(307, 1000L);
  }
  
  private void Z()
  {
    String str;
    switch (this.m)
    {
    default: 
      return;
    case 0: 
      str = h;
    }
    for (;;)
    {
      w.a(str, 0);
      return;
      str = i;
      continue;
      str = j;
    }
  }
  
  private void a(MusicSongModel paramMusicSongModel, int paramInt)
  {
    if (paramMusicSongModel != null) {
      a(paramMusicSongModel);
    }
    com.baidu.carlife.core.k.a(226);
    com.baidu.carlife.core.k.b(226, paramInt);
  }
  
  private void aa()
  {
    if (q())
    {
      if (this.B != null)
      {
        localObject = this.W.c().g();
        if (localObject != null) {
          ((List)localObject).remove(this.B);
        }
        this.B = this.W.c().p();
        e(this.B);
      }
      return;
    }
    Object localObject = h(n());
    ((b)localObject).a(this.A);
    if ((d() != null) && (!d().isEmpty()))
    {
      a(true);
      w.a(this.S.getString(2131296610), 1);
      return;
    }
    A();
    ((b)localObject).b();
    f(-1);
  }
  
  private void ab()
  {
    Object localObject;
    int i1;
    if (this.W.g())
    {
      if (this.B.j > this.u) {
        this.B.j = 1;
      }
      localObject = this.V;
      MusicSongModel localMusicSongModel = this.B;
      i1 = localMusicSongModel.j;
      localMusicSongModel.j = (i1 + 1);
      ((g)localObject).a(i1);
    }
    do
    {
      return;
      this.V.a(this.B.j);
      localObject = this.B;
      i1 = ((MusicSongModel)localObject).j;
      ((MusicSongModel)localObject).j = (i1 + 1);
    } while (i1 <= this.u);
    c.a().a(2, this.W.c());
    a(true, false);
  }
  
  private void ac()
  {
    if (this.T != null) {
      this.T.d();
    }
  }
  
  private void ad()
  {
    if (this.T != null) {
      this.T.b();
    }
  }
  
  private void ae()
  {
    if (this.T != null) {
      this.T.c();
    }
  }
  
  private void af()
  {
    List localList = d();
    if (localList == null) {
      return;
    }
    int i1 = a(localList.size(), e(), true);
    if (this.m == 1) {
      i.a(i1);
    }
    for (;;)
    {
      try
      {
        MusicSongModel localMusicSongModel = (MusicSongModel)localList.get(i1);
        if (b(localMusicSongModel))
        {
          if ((localMusicSongModel.n > 0L) && (localMusicSongModel.n >= localMusicSongModel.o)) {
            break;
          }
          d(localMusicSongModel);
          h(localMusicSongModel);
          if (this.n == 2) {
            localMusicSongModel.m = NeteaseMusicUtils.getSimpleSongUrl(localMusicSongModel.a);
          }
          k(localMusicSongModel);
          return;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        com.baidu.carlife.core.i.e("CarLifeMusic", "MusicListError: list size = " + localList.size() + ", nextIndex = " + i1);
        localIndexOutOfBoundsException.printStackTrace();
        return;
      }
      h(localIndexOutOfBoundsException);
    }
  }
  
  private void ag()
  {
    if ((this.B == null) || ((TextUtils.isEmpty(this.B.a)) && (TextUtils.isEmpty(this.B.m)))) {}
    do
    {
      do
      {
        return;
        com.baidu.carlife.core.i.b("CarLifeMusic", "---------bufferSize11:" + this.B.n);
        if (this.B.n == -1000L)
        {
          j(n());
          return;
        }
        if (!this.W.g()) {
          break;
        }
        if (this.F.size() > 2)
        {
          this.T.a(101, this.B, this.F);
          return;
        }
        i1 = this.v;
        this.v = (i1 + 1);
      } while (i1 >= this.z * 2);
      this.P.removeMessages(221);
      this.P.sendEmptyMessageDelayed(221, 500L);
      return;
      if (!ah()) {
        break;
      }
    } while (this.T == null);
    this.T.a(101, this.B);
    return;
    int i1 = this.v;
    this.v = (i1 + 1);
    if (i1 < this.z * 2)
    {
      this.P.removeMessages(221);
      this.P.sendEmptyMessageDelayed(221, 500L);
      return;
    }
    com.baidu.carlife.core.i.e("CarLifeMusic", "播放出错");
    j(101);
  }
  
  private boolean ah()
  {
    return (this.B.o != 0L) && ((this.B.n >= this.B.o) || ((this.B.n > 30720L) && (this.B.n > this.B.o / 100L)));
  }
  
  /* Error */
  private void ai()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 171	com/baidu/carlife/logic/music/h:A	Lcom/baidu/carlife/model/MusicSongModel;
    //   4: ifnull +29 -> 33
    //   7: aload_0
    //   8: getfield 171	com/baidu/carlife/logic/music/h:A	Lcom/baidu/carlife/model/MusicSongModel;
    //   11: getfield 556	com/baidu/carlife/model/MusicSongModel:a	Ljava/lang/String;
    //   14: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +17 -> 34
    //   20: aload_0
    //   21: getfield 171	com/baidu/carlife/logic/music/h:A	Lcom/baidu/carlife/model/MusicSongModel;
    //   24: getfield 307	com/baidu/carlife/model/MusicSongModel:m	Ljava/lang/String;
    //   27: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifeq +4 -> 34
    //   33: return
    //   34: ldc 48
    //   36: new 355	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 356	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 582
    //   46: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_0
    //   50: getfield 171	com/baidu/carlife/logic/music/h:A	Lcom/baidu/carlife/model/MusicSongModel;
    //   53: getfield 287	com/baidu/carlife/model/MusicSongModel:n	J
    //   56: invokevirtual 585	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   59: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 587	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_0
    //   66: getfield 171	com/baidu/carlife/logic/music/h:A	Lcom/baidu/carlife/model/MusicSongModel;
    //   69: getfield 287	com/baidu/carlife/model/MusicSongModel:n	J
    //   72: ldc2_w 588
    //   75: lcmp
    //   76: ifne +12 -> 88
    //   79: aload_0
    //   80: aload_0
    //   81: invokevirtual 412	com/baidu/carlife/logic/music/h:n	()I
    //   84: invokevirtual 591	com/baidu/carlife/logic/music/h:j	(I)V
    //   87: return
    //   88: aload_0
    //   89: getfield 171	com/baidu/carlife/logic/music/h:A	Lcom/baidu/carlife/model/MusicSongModel;
    //   92: getfield 199	com/baidu/carlife/model/MusicSongModel:i	Ljava/lang/String;
    //   95: ifnonnull +135 -> 230
    //   98: new 615	android/media/MediaPlayer
    //   101: dup
    //   102: invokespecial 616	android/media/MediaPlayer:<init>	()V
    //   105: astore 10
    //   107: iconst_0
    //   108: istore 7
    //   110: iconst_0
    //   111: istore 8
    //   113: iconst_0
    //   114: istore 9
    //   116: iconst_0
    //   117: istore_2
    //   118: iload_2
    //   119: istore_3
    //   120: iload 7
    //   122: istore 4
    //   124: iload 8
    //   126: istore 5
    //   128: iload 9
    //   130: istore 6
    //   132: aload 10
    //   134: aload_0
    //   135: getfield 171	com/baidu/carlife/logic/music/h:A	Lcom/baidu/carlife/model/MusicSongModel;
    //   138: getfield 307	com/baidu/carlife/model/MusicSongModel:m	Ljava/lang/String;
    //   141: invokevirtual 619	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   144: iload_2
    //   145: istore_3
    //   146: iload 7
    //   148: istore 4
    //   150: iload 8
    //   152: istore 5
    //   154: iload 9
    //   156: istore 6
    //   158: aload 10
    //   160: iconst_3
    //   161: invokevirtual 622	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   164: iload_2
    //   165: istore_3
    //   166: iload 7
    //   168: istore 4
    //   170: iload 8
    //   172: istore 5
    //   174: iload 9
    //   176: istore 6
    //   178: aload 10
    //   180: invokevirtual 625	android/media/MediaPlayer:prepare	()V
    //   183: iload_2
    //   184: istore_3
    //   185: iload 7
    //   187: istore 4
    //   189: iload 8
    //   191: istore 5
    //   193: iload 9
    //   195: istore 6
    //   197: aload 10
    //   199: invokevirtual 628	android/media/MediaPlayer:getDuration	()I
    //   202: istore_2
    //   203: iload_2
    //   204: istore_3
    //   205: iload_2
    //   206: istore 4
    //   208: iload_2
    //   209: istore 5
    //   211: iload_2
    //   212: istore 6
    //   214: aload 10
    //   216: invokevirtual 631	android/media/MediaPlayer:release	()V
    //   219: aload_0
    //   220: getfield 171	com/baidu/carlife/logic/music/h:A	Lcom/baidu/carlife/model/MusicSongModel;
    //   223: iload_2
    //   224: invokestatic 636	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   227: putfield 199	com/baidu/carlife/model/MusicSongModel:i	Ljava/lang/String;
    //   230: aload_0
    //   231: getfield 171	com/baidu/carlife/logic/music/h:A	Lcom/baidu/carlife/model/MusicSongModel;
    //   234: getfield 199	com/baidu/carlife/model/MusicSongModel:i	Ljava/lang/String;
    //   237: invokestatic 205	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   240: istore_2
    //   241: aload_0
    //   242: getfield 171	com/baidu/carlife/logic/music/h:A	Lcom/baidu/carlife/model/MusicSongModel;
    //   245: getfield 287	com/baidu/carlife/model/MusicSongModel:n	J
    //   248: l2f
    //   249: aload_0
    //   250: getfield 171	com/baidu/carlife/logic/music/h:A	Lcom/baidu/carlife/model/MusicSongModel;
    //   253: getfield 289	com/baidu/carlife/model/MusicSongModel:o	J
    //   256: l2f
    //   257: fdiv
    //   258: iload_2
    //   259: sipush 1000
    //   262: idiv
    //   263: i2f
    //   264: fmul
    //   265: fstore_1
    //   266: ldc 48
    //   268: new 355	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 356	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 638
    //   278: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: fload_1
    //   282: invokevirtual 641	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   285: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 587	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: fload_1
    //   292: fconst_2
    //   293: fcmpl
    //   294: ifle +84 -> 378
    //   297: aload_0
    //   298: getfield 399	com/baidu/carlife/logic/music/h:T	Lcom/baidu/carlife/service/MusicPlayService$a;
    //   301: ifnull -268 -> 33
    //   304: aload_0
    //   305: getfield 399	com/baidu/carlife/logic/music/h:T	Lcom/baidu/carlife/service/MusicPlayService$a;
    //   308: aload_0
    //   309: getfield 145	com/baidu/carlife/logic/music/h:n	I
    //   312: aload_0
    //   313: getfield 171	com/baidu/carlife/logic/music/h:A	Lcom/baidu/carlife/model/MusicSongModel;
    //   316: invokevirtual 413	com/baidu/carlife/service/MusicPlayService$a:a	(ILcom/baidu/carlife/model/MusicSongModel;)V
    //   319: return
    //   320: astore 10
    //   322: aload 10
    //   324: invokevirtual 642	java/lang/IllegalArgumentException:printStackTrace	()V
    //   327: iload_3
    //   328: istore_2
    //   329: goto -110 -> 219
    //   332: astore 10
    //   334: aload 10
    //   336: invokevirtual 643	java/lang/SecurityException:printStackTrace	()V
    //   339: iload 4
    //   341: istore_2
    //   342: goto -123 -> 219
    //   345: astore 10
    //   347: aload 10
    //   349: invokevirtual 644	java/lang/IllegalStateException:printStackTrace	()V
    //   352: iload 5
    //   354: istore_2
    //   355: goto -136 -> 219
    //   358: astore 10
    //   360: aload 10
    //   362: invokevirtual 645	java/io/IOException:printStackTrace	()V
    //   365: iload 6
    //   367: istore_2
    //   368: goto -149 -> 219
    //   371: astore 10
    //   373: iconst_1
    //   374: istore_2
    //   375: goto -134 -> 241
    //   378: ldc 48
    //   380: new 355	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 356	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 647
    //   390: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_0
    //   394: getfield 161	com/baidu/carlife/logic/music/h:v	I
    //   397: invokevirtual 569	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   400: invokevirtual 369	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 587	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   406: aload_0
    //   407: getfield 161	com/baidu/carlife/logic/music/h:v	I
    //   410: istore_2
    //   411: aload_0
    //   412: iload_2
    //   413: iconst_1
    //   414: iadd
    //   415: putfield 161	com/baidu/carlife/logic/music/h:v	I
    //   418: iload_2
    //   419: aload_0
    //   420: getfield 169	com/baidu/carlife/logic/music/h:z	I
    //   423: if_icmpge +28 -> 451
    //   426: aload_0
    //   427: getfield 213	com/baidu/carlife/logic/music/h:P	Lcom/baidu/carlife/core/j;
    //   430: sipush 221
    //   433: invokevirtual 219	com/baidu/carlife/core/j:removeMessages	(I)V
    //   436: aload_0
    //   437: getfield 213	com/baidu/carlife/logic/music/h:P	Lcom/baidu/carlife/core/j;
    //   440: sipush 221
    //   443: ldc2_w 468
    //   446: invokevirtual 225	com/baidu/carlife/core/j:sendEmptyMessageDelayed	(IJ)Z
    //   449: pop
    //   450: return
    //   451: aload_0
    //   452: aload_0
    //   453: invokevirtual 412	com/baidu/carlife/logic/music/h:n	()I
    //   456: invokevirtual 591	com/baidu/carlife/logic/music/h:j	(I)V
    //   459: aload_0
    //   460: invokevirtual 412	com/baidu/carlife/logic/music/h:n	()I
    //   463: iconst_3
    //   464: if_icmplt -431 -> 33
    //   467: invokestatic 652	com/baidu/carlife/platform/c:a	()Lcom/baidu/carlife/platform/c;
    //   470: aload_0
    //   471: aload_0
    //   472: invokevirtual 412	com/baidu/carlife/logic/music/h:n	()I
    //   475: invokespecial 654	com/baidu/carlife/logic/music/h:o	(I)Ljava/lang/String;
    //   478: invokevirtual 655	com/baidu/carlife/platform/c:b	(Ljava/lang/String;)V
    //   481: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	this	h
    //   265	27	1	f1	float
    //   117	307	2	i1	int
    //   119	209	3	i2	int
    //   122	218	4	i3	int
    //   126	227	5	i4	int
    //   130	236	6	i5	int
    //   108	78	7	i6	int
    //   111	79	8	i7	int
    //   114	80	9	i8	int
    //   105	110	10	localMediaPlayer	android.media.MediaPlayer
    //   320	3	10	localIllegalArgumentException	IllegalArgumentException
    //   332	3	10	localSecurityException	SecurityException
    //   345	3	10	localIllegalStateException	IllegalStateException
    //   358	3	10	localIOException	java.io.IOException
    //   371	1	10	localNumberFormatException	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   132	144	320	java/lang/IllegalArgumentException
    //   158	164	320	java/lang/IllegalArgumentException
    //   178	183	320	java/lang/IllegalArgumentException
    //   197	203	320	java/lang/IllegalArgumentException
    //   214	219	320	java/lang/IllegalArgumentException
    //   132	144	332	java/lang/SecurityException
    //   158	164	332	java/lang/SecurityException
    //   178	183	332	java/lang/SecurityException
    //   197	203	332	java/lang/SecurityException
    //   214	219	332	java/lang/SecurityException
    //   132	144	345	java/lang/IllegalStateException
    //   158	164	345	java/lang/IllegalStateException
    //   178	183	345	java/lang/IllegalStateException
    //   197	203	345	java/lang/IllegalStateException
    //   214	219	345	java/lang/IllegalStateException
    //   132	144	358	java/io/IOException
    //   158	164	358	java/io/IOException
    //   178	183	358	java/io/IOException
    //   197	203	358	java/io/IOException
    //   214	219	358	java/io/IOException
    //   230	241	371	java/lang/NumberFormatException
  }
  
  private void aj()
  {
    this.U.g();
  }
  
  private void ak()
  {
    this.U.i();
  }
  
  private void al()
  {
    long l1 = this.A.o;
    long l2 = this.A.n;
    for (;;)
    {
      long l3;
      try
      {
        l3 = (this.A.j + 2) * l1 / this.u;
        if ((l2 < l1) && (l2 <= l3) && (this.t))
        {
          f(false);
          this.t = false;
          B();
          com.baidu.carlife.core.i.b("CarLifeMusic", "-service--is not Enough----");
          if (!this.A.l) {
            break;
          }
          com.baidu.carlife.core.i.b("CarLifeMusic", "---MSG_MUSIC_PLAY_UI_UPDATE------bufferTime:" + this.v);
          int i1 = this.v + 1;
          this.v = i1;
          if (i1 > 8)
          {
            f(true);
            j(n());
            StatisticManager.onEvent("MUSIC_NETEASE_0005", "获取歌曲数据超时");
          }
          return;
        }
      }
      catch (ArithmeticException localArithmeticException)
      {
        return;
      }
      if (((l2 >= l1) || (l2 > l3)) && (!this.t))
      {
        d(false);
        this.t = true;
        A();
        com.baidu.carlife.core.i.b("CarLifeMusic", "-service-- Enough startplay----");
      }
    }
    this.v = 0;
  }
  
  private void am()
  {
    long l1 = this.B.o;
    long l2 = this.B.n;
    for (;;)
    {
      long l3;
      try
      {
        l3 = (this.B.j + 2) * l1 / this.u;
        if ((l2 < l1) && (l2 <= l3) && (this.t))
        {
          f(false);
          this.t = false;
          B();
          com.baidu.carlife.core.i.b("CarLifeMusic", "-service--is not Enough----");
          if (this.t) {
            this.B.l = false;
          }
          if (!this.B.l) {
            break;
          }
          com.baidu.carlife.core.i.b("CarLifeMusic", "---MSG_MUSIC_PLAY_UI_UPDATE------bufferTime:" + this.v);
          int i1 = this.v + 1;
          this.v = i1;
          if (i1 > 8)
          {
            f(true);
            j(101);
          }
          return;
        }
      }
      catch (ArithmeticException localArithmeticException)
      {
        return;
      }
      if (((l2 >= l1) || (l2 > l3)) && (!this.t))
      {
        e(false);
        this.t = true;
        A();
        com.baidu.carlife.core.i.b("CarLifeMusic", "-service-- Enough startplay----");
      }
    }
    this.v = 0;
  }
  
  private void an()
  {
    this.Q.post(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 17	com/baidu/carlife/logic/music/h$3:a	Lcom/baidu/carlife/logic/music/h;
        //   4: invokestatic 35	com/baidu/carlife/logic/music/h:i	(Lcom/baidu/carlife/logic/music/h;)Lcom/baidu/carlife/model/MusicSongModel;
        //   7: ifnonnull +4 -> 11
        //   10: return
        //   11: aload_0
        //   12: getfield 17	com/baidu/carlife/logic/music/h$3:a	Lcom/baidu/carlife/logic/music/h;
        //   15: invokestatic 35	com/baidu/carlife/logic/music/h:i	(Lcom/baidu/carlife/logic/music/h;)Lcom/baidu/carlife/model/MusicSongModel;
        //   18: getfield 41	com/baidu/carlife/model/MusicSongModel:o	J
        //   21: lstore 9
        //   23: aload_0
        //   24: getfield 17	com/baidu/carlife/logic/music/h$3:a	Lcom/baidu/carlife/logic/music/h;
        //   27: invokestatic 35	com/baidu/carlife/logic/music/h:i	(Lcom/baidu/carlife/logic/music/h;)Lcom/baidu/carlife/model/MusicSongModel;
        //   30: getfield 44	com/baidu/carlife/model/MusicSongModel:n	J
        //   33: lstore 11
        //   35: aload_0
        //   36: getfield 17	com/baidu/carlife/logic/music/h$3:a	Lcom/baidu/carlife/logic/music/h;
        //   39: invokestatic 35	com/baidu/carlife/logic/music/h:i	(Lcom/baidu/carlife/logic/music/h;)Lcom/baidu/carlife/model/MusicSongModel;
        //   42: getfield 47	com/baidu/carlife/model/MusicSongModel:a	Ljava/lang/String;
        //   45: astore 13
        //   47: lload 11
        //   49: lload 9
        //   51: lcmp
        //   52: iflt -42 -> 10
        //   55: lload 9
        //   57: lconst_0
        //   58: lcmp
        //   59: ifeq -49 -> 10
        //   62: aload_0
        //   63: getfield 17	com/baidu/carlife/logic/music/h$3:a	Lcom/baidu/carlife/logic/music/h;
        //   66: invokestatic 35	com/baidu/carlife/logic/music/h:i	(Lcom/baidu/carlife/logic/music/h;)Lcom/baidu/carlife/model/MusicSongModel;
        //   69: getfield 50	com/baidu/carlife/model/MusicSongModel:m	Ljava/lang/String;
        //   72: astore 14
        //   74: new 52	android/media/MediaPlayer
        //   77: dup
        //   78: invokespecial 53	android/media/MediaPlayer:<init>	()V
        //   81: astore 15
        //   83: iconst_0
        //   84: istore 6
        //   86: iconst_0
        //   87: istore 7
        //   89: iconst_0
        //   90: istore 8
        //   92: iconst_0
        //   93: istore_1
        //   94: iload_1
        //   95: istore_2
        //   96: iload 6
        //   98: istore_3
        //   99: iload 7
        //   101: istore 4
        //   103: iload 8
        //   105: istore 5
        //   107: aload 15
        //   109: aload 14
        //   111: invokevirtual 57	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
        //   114: iload_1
        //   115: istore_2
        //   116: iload 6
        //   118: istore_3
        //   119: iload 7
        //   121: istore 4
        //   123: iload 8
        //   125: istore 5
        //   127: aload 15
        //   129: iconst_3
        //   130: invokevirtual 61	android/media/MediaPlayer:setAudioStreamType	(I)V
        //   133: iload_1
        //   134: istore_2
        //   135: iload 6
        //   137: istore_3
        //   138: iload 7
        //   140: istore 4
        //   142: iload 8
        //   144: istore 5
        //   146: aload 15
        //   148: invokevirtual 64	android/media/MediaPlayer:prepare	()V
        //   151: iload_1
        //   152: istore_2
        //   153: iload 6
        //   155: istore_3
        //   156: iload 7
        //   158: istore 4
        //   160: iload 8
        //   162: istore 5
        //   164: aload 15
        //   166: invokevirtual 68	android/media/MediaPlayer:getDuration	()I
        //   169: istore_1
        //   170: iload_1
        //   171: istore_2
        //   172: iload_1
        //   173: istore_3
        //   174: iload_1
        //   175: istore 4
        //   177: iload_1
        //   178: istore 5
        //   180: aload 15
        //   182: invokevirtual 71	android/media/MediaPlayer:release	()V
        //   185: aload 13
        //   187: ifnull +21 -> 208
        //   190: aload 13
        //   192: aload_0
        //   193: getfield 17	com/baidu/carlife/logic/music/h$3:a	Lcom/baidu/carlife/logic/music/h;
        //   196: invokestatic 35	com/baidu/carlife/logic/music/h:i	(Lcom/baidu/carlife/logic/music/h;)Lcom/baidu/carlife/model/MusicSongModel;
        //   199: getfield 47	com/baidu/carlife/model/MusicSongModel:a	Ljava/lang/String;
        //   202: invokevirtual 77	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   205: ifne +26 -> 231
        //   208: aload 14
        //   210: ifnull -200 -> 10
        //   213: aload 14
        //   215: aload_0
        //   216: getfield 17	com/baidu/carlife/logic/music/h$3:a	Lcom/baidu/carlife/logic/music/h;
        //   219: invokestatic 35	com/baidu/carlife/logic/music/h:i	(Lcom/baidu/carlife/logic/music/h;)Lcom/baidu/carlife/model/MusicSongModel;
        //   222: getfield 50	com/baidu/carlife/model/MusicSongModel:m	Ljava/lang/String;
        //   225: invokevirtual 77	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   228: ifeq -218 -> 10
        //   231: aload_0
        //   232: getfield 17	com/baidu/carlife/logic/music/h$3:a	Lcom/baidu/carlife/logic/music/h;
        //   235: invokestatic 35	com/baidu/carlife/logic/music/h:i	(Lcom/baidu/carlife/logic/music/h;)Lcom/baidu/carlife/model/MusicSongModel;
        //   238: iload_1
        //   239: invokestatic 81	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   242: putfield 83	com/baidu/carlife/model/MusicSongModel:i	Ljava/lang/String;
        //   245: aload_0
        //   246: getfield 17	com/baidu/carlife/logic/music/h$3:a	Lcom/baidu/carlife/logic/music/h;
        //   249: aload_0
        //   250: getfield 17	com/baidu/carlife/logic/music/h$3:a	Lcom/baidu/carlife/logic/music/h;
        //   253: invokestatic 35	com/baidu/carlife/logic/music/h:i	(Lcom/baidu/carlife/logic/music/h;)Lcom/baidu/carlife/model/MusicSongModel;
        //   256: getfield 83	com/baidu/carlife/model/MusicSongModel:i	Ljava/lang/String;
        //   259: invokestatic 89	java/lang/Integer:parseInt	(Ljava/lang/String;)I
        //   262: sipush 1000
        //   265: idiv
        //   266: invokestatic 92	com/baidu/carlife/logic/music/h:a	(Lcom/baidu/carlife/logic/music/h;I)I
        //   269: pop
        //   270: sipush 226
        //   273: invokestatic 96	com/baidu/carlife/core/k:a	(I)V
        //   276: sipush 226
        //   279: bipush 101
        //   281: invokestatic 100	com/baidu/carlife/core/k:b	(II)V
        //   284: return
        //   285: astore 15
        //   287: aload 15
        //   289: invokevirtual 103	java/lang/IllegalArgumentException:printStackTrace	()V
        //   292: iload_2
        //   293: istore_1
        //   294: goto -109 -> 185
        //   297: astore 15
        //   299: aload 15
        //   301: invokevirtual 104	java/lang/SecurityException:printStackTrace	()V
        //   304: iload_3
        //   305: istore_1
        //   306: goto -121 -> 185
        //   309: astore 15
        //   311: aload 15
        //   313: invokevirtual 105	java/lang/IllegalStateException:printStackTrace	()V
        //   316: iload 4
        //   318: istore_1
        //   319: goto -134 -> 185
        //   322: astore 15
        //   324: aload 15
        //   326: invokevirtual 106	java/io/IOException:printStackTrace	()V
        //   329: iload 5
        //   331: istore_1
        //   332: goto -147 -> 185
        //   335: astore 13
        //   337: aload_0
        //   338: getfield 17	com/baidu/carlife/logic/music/h$3:a	Lcom/baidu/carlife/logic/music/h;
        //   341: iconst_1
        //   342: invokestatic 92	com/baidu/carlife/logic/music/h:a	(Lcom/baidu/carlife/logic/music/h;I)I
        //   345: pop
        //   346: goto -76 -> 270
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	349	0	this	3
        //   93	239	1	i	int
        //   95	198	2	j	int
        //   98	207	3	k	int
        //   101	216	4	m	int
        //   105	225	5	n	int
        //   84	70	6	i1	int
        //   87	70	7	i2	int
        //   90	71	8	i3	int
        //   21	35	9	l1	long
        //   33	15	11	l2	long
        //   45	146	13	str1	String
        //   335	1	13	localNumberFormatException	NumberFormatException
        //   72	142	14	str2	String
        //   81	100	15	localMediaPlayer	android.media.MediaPlayer
        //   285	3	15	localIllegalArgumentException	IllegalArgumentException
        //   297	3	15	localSecurityException	SecurityException
        //   309	3	15	localIllegalStateException	IllegalStateException
        //   322	3	15	localIOException	java.io.IOException
        // Exception table:
        //   from	to	target	type
        //   107	114	285	java/lang/IllegalArgumentException
        //   127	133	285	java/lang/IllegalArgumentException
        //   146	151	285	java/lang/IllegalArgumentException
        //   164	170	285	java/lang/IllegalArgumentException
        //   180	185	285	java/lang/IllegalArgumentException
        //   107	114	297	java/lang/SecurityException
        //   127	133	297	java/lang/SecurityException
        //   146	151	297	java/lang/SecurityException
        //   164	170	297	java/lang/SecurityException
        //   180	185	297	java/lang/SecurityException
        //   107	114	309	java/lang/IllegalStateException
        //   127	133	309	java/lang/IllegalStateException
        //   146	151	309	java/lang/IllegalStateException
        //   164	170	309	java/lang/IllegalStateException
        //   180	185	309	java/lang/IllegalStateException
        //   107	114	322	java/io/IOException
        //   127	133	322	java/io/IOException
        //   146	151	322	java/io/IOException
        //   164	170	322	java/io/IOException
        //   180	185	322	java/io/IOException
        //   245	270	335	java/lang/NumberFormatException
      }
    });
  }
  
  private void ao()
  {
    if (!this.p) {
      return;
    }
    StatisticManager.onEvent("MUSIC_0002");
    switch (this.n)
    {
    }
    for (;;)
    {
      this.p = false;
      return;
      StatisticManager.onEvent("MUSIC_BDYY_0002");
      continue;
      StatisticManager.onEvent("MUSIC_QQ_0004");
      String str = h(1).o();
      if (!str.isEmpty()) {
        if (str.equals(this.S.getString(2131296634)))
        {
          StatisticManager.onEvent("MUSIC_QQ_0009");
        }
        else if (str.equals("最近播放"))
        {
          StatisticManager.onEvent("MUSIC_QQ_0011");
        }
        else if (str.equals(this.S.getString(2131296635)))
        {
          StatisticManager.onEvent("MUSIC_QQ_0010");
        }
        else if (str.equals(this.S.getString(2131296637)))
        {
          StatisticManager.onEvent("MUSIC_QQ_0012");
        }
        else if (str.equals(this.S.getString(2131296631)))
        {
          StatisticManager.onEvent("MUSIC_QQ_0013");
          continue;
          StatisticManager.onEvent("MUSIC_NETEASE_0003");
          continue;
          StatisticManager.onEvent("MUSIC_XMLY_0004");
          StatisticManager.onEvent("MUSIC_XMLY_0009", h(3).o());
          continue;
          StatisticManager.onEvent("MUSIC_KAOLA_0004");
          StatisticManager.onEvent("MUSIC_KAOLA_0009", h(4).o());
          continue;
          StatisticManager.onEvent("MUSIC_CYB_0004");
          StatisticManager.onEvent("MUSIC_CYB_0009", h(5).o());
        }
      }
    }
  }
  
  private void ap()
  {
    int i1;
    if (this.q != -1L)
    {
      i1 = (int)(System.currentTimeMillis() - this.q);
      if (i1 > 3000)
      {
        if (!q()) {
          break label134;
        }
        StatisticManager.onEventDuration(this.S, "CONTENT_REC_0001_TIME", "随心听播放时长", i1);
        Object localObject = this.W.c().n();
        localObject = com.baidu.carlife.radio.c.b.a().c((String)localObject);
        if (localObject != null) {
          StatisticManager.onEventDuration(this.S, ((com.baidu.carlife.radio.a.a)localObject).d() + "_TIME", ((com.baidu.carlife.radio.a.a)localObject).b() + "频道播放时长", i1);
        }
      }
      this.q = -1L;
    }
    else
    {
      return;
    }
    label134:
    switch (this.n)
    {
    }
    for (;;)
    {
      StatisticManager.onEventDuration(this.S, "MUSIC_0003", "音乐播放时长", i1);
      if (NavTrajectoryController.hasConnected) {
        break;
      }
      StatisticManager.onEventDuration(this.S, "MUSIC_0006", "单机音乐播放时长", i1);
      break;
      StatisticManager.onEventDuration(this.S, "MUSIC_BDYY_0003", "本地音乐时长", i1);
      continue;
      StatisticManager.onEventDuration(this.S, "MUSIC_QQ_0005", "QQ音乐时长", i1);
      continue;
      StatisticManager.onEventDuration(this.S, "MUSIC_NETEASE_0004", "网易云音乐时长", i1);
      continue;
      StatisticManager.onEventDuration(this.S, "MUSIC_XMLY_0005", "喜马拉雅音乐时长", i1);
      continue;
      StatisticManager.onEventDuration(this.S, "MUSIC_KAOLA_0005", "考拉音乐时长", i1);
      continue;
      StatisticManager.onEventDuration(this.S, "MUSIC_CYB_0005", "车悦宝音乐时长", i1);
    }
  }
  
  public static h b()
  {
    try
    {
      if (H == null) {
        H = new h();
      }
      h localh = H;
      return localh;
    }
    finally {}
  }
  
  private void b(int paramInt, MusicSongModel paramMusicSongModel)
  {
    this.P.removeMessages(253);
    this.P.sendMessageDelayed(Message.obtain(this.P, 253, paramInt, -1, paramMusicSongModel), 0L);
  }
  
  private void g(MusicSongModel paramMusicSongModel)
  {
    this.A = paramMusicSongModel;
    this.p = true;
  }
  
  private MusicSongModel h(boolean paramBoolean)
  {
    return this.W.a(paramBoolean);
  }
  
  private void h(MusicSongModel paramMusicSongModel)
  {
    try
    {
      J().add(paramMusicSongModel);
      if (J().size() > 3) {
        d((MusicSongModel)J().get(0));
      }
      if (com.baidu.carlife.core.e.t())
      {
        paramMusicSongModel = J().iterator();
        while (paramMusicSongModel.hasNext())
        {
          MusicSongModel localMusicSongModel = (MusicSongModel)paramMusicSongModel.next();
          com.baidu.carlife.core.i.b("CarLifeMusic", "----addBufferMusic--song:" + localMusicSongModel.b);
        }
      }
    }
    finally {}
  }
  
  private void i(MusicSongModel paramMusicSongModel)
  {
    if ((paramMusicSongModel.n > 0L) && (paramMusicSongModel.n < paramMusicSongModel.o))
    {
      paramMusicSongModel.n = 0L;
      paramMusicSongModel.o = 0L;
    }
  }
  
  public static boolean i(int paramInt)
  {
    return (paramInt == 101) || (paramInt == 0) || (paramInt == 2) || (paramInt == 1) || (paramInt >= 3);
  }
  
  private void j(MusicSongModel paramMusicSongModel)
  {
    a(this.B);
    this.B = paramMusicSongModel;
    this.v = 0;
    this.x = false;
  }
  
  private void k(MusicSongModel paramMusicSongModel)
  {
    t();
    com.baidu.carlife.core.i.b("CarLifeMusic", "----startDownloadSong---0----");
    if (l.a(f.jm) <= 10000000L)
    {
      u();
      if (l.a(f.jm) <= 10000000L) {
        w.a(this.S.getString(2131296605), 1);
      }
    }
    do
    {
      do
      {
        return;
        if (q())
        {
          this.W.d().b();
          return;
        }
        if (this.n >= 3)
        {
          com.baidu.carlife.core.i.b("CarLifeMusic", "----startDownloadSong---MUSIC_TYPE_THIRDPARTY----");
          com.baidu.carlife.platform.c.a().a(o(this.n), paramMusicSongModel);
          return;
        }
      } while ((this.n != 2) && (this.n != 0));
      com.baidu.carlife.core.i.b("CarLifeMusic", "----startDownloadSong---NETEASE or WECHAT----");
      paramMusicSongModel = (com.baidu.carlife.logic.e)d.b().a(MusicPlayerFragment.class.getName());
    } while (paramMusicSongModel == null);
    if (!paramMusicSongModel.isAlive()) {
      paramMusicSongModel.start();
    }
    paramMusicSongModel.b();
  }
  
  private boolean n(int paramInt)
  {
    return (paramInt == 531) || (paramInt == 595) || (paramInt == 594);
  }
  
  private String o(int paramInt)
  {
    return this.U.e(paramInt);
  }
  
  public void A()
  {
    if (this.B != null) {
      this.B.l = false;
    }
    if (this.A != null) {
      this.A.l = false;
    }
    com.baidu.carlife.view.g.e().f();
  }
  
  public void B()
  {
    NaviFragmentManager localNaviFragmentManager;
    if (q())
    {
      if (this.B != null) {
        this.B.l = true;
      }
      if (this.A != null) {
        this.A.l = false;
      }
      localNaviFragmentManager = com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager();
      if (!localNaviFragmentManager.isCarlifeMusicFragment(localNaviFragmentManager.getCurrentFragmentType())) {
        break label98;
      }
      com.baidu.carlife.view.g.e().a(2131296859);
    }
    label98:
    while ((!q()) || (!n(localNaviFragmentManager.getCurrentFragmentType())))
    {
      return;
      if (this.B != null) {
        this.B.l = false;
      }
      if (this.A == null) {
        break;
      }
      this.A.l = true;
      break;
    }
    com.baidu.carlife.view.g.e().a(2131296859);
  }
  
  public void C()
  {
    if (System.currentTimeMillis() - this.r < 500L) {
      return;
    }
    if (q())
    {
      x();
      return;
    }
    S();
  }
  
  public void D()
  {
    if (!this.x) {
      this.y = true;
    }
    f(true);
  }
  
  public com.baidu.carlife.adpter.k E()
  {
    return this.U.c();
  }
  
  public AdapterView.OnItemClickListener F()
  {
    return this.U.d();
  }
  
  public void G()
  {
    this.U.e();
  }
  
  public void H()
  {
    this.U.a();
  }
  
  public boolean I()
  {
    this.s = false;
    int i1 = com.baidu.carlife.core.e.s();
    if (i1 == 1)
    {
      if (this.D)
      {
        this.D = false;
        this.s = true;
        A();
      }
      return true;
    }
    if (i1 == 2)
    {
      this.D = true;
      return true;
    }
    this.D = true;
    return false;
  }
  
  public List<MusicSongModel> J()
  {
    if (q()) {
      return this.E;
    }
    return this.G;
  }
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return i.a(k(), paramInt1, paramInt2, paramBoolean, true);
  }
  
  public int a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString1))) {
      return S();
    }
    return 0;
  }
  
  public String a(String paramString)
  {
    return this.U.c(paramString);
  }
  
  public List<MusicSongModel> a(int paramInt)
  {
    b localb = h(paramInt);
    if (localb == null) {
      return null;
    }
    return localb.g();
  }
  
  public List<MusicSongModel> a(int paramInt, String paramString)
  {
    b localb = h(paramInt);
    if (localb == null) {
      return null;
    }
    return localb.f(paramString);
  }
  
  public void a()
  {
    this.S = BaiduNaviApplication.getInstance().getApplicationContext();
    this.N = new HandlerThread("MusicPlayController");
    this.N.start();
    this.O = new HandlerThread("CostTimeThread");
    this.O.start();
    this.P = new a(this.N.getLooper());
    com.baidu.carlife.core.k.a(this.P);
    this.Q = new Handler(this.O.getLooper());
    this.R = new Handler(this.S.getMainLooper());
    this.E = new CopyOnWriteArrayList();
    this.G = new CopyOnWriteArrayList();
    this.F = new ArrayList();
    this.m = com.baidu.carlife.util.p.a().a("localPlayStrategy", 2);
    h = this.S.getResources().getString(2131296649);
    i = this.S.getResources().getString(2131296648);
    j = this.S.getResources().getString(2131296647);
    Intent localIntent = new Intent(this.S, MusicPlayService.class);
    this.S.bindService(localIntent, this.Y, 1);
    com.baidu.carlife.logic.b.a().a(this.S, new b.b()
    {
      public void a()
      {
        h.a(h.this);
      }
      
      public void a(boolean paramAnonymousBoolean)
      {
        if (h.this.q())
        {
          h.this.e(paramAnonymousBoolean);
          return;
        }
        h.this.d(paramAnonymousBoolean);
      }
      
      public void b()
      {
        h.b(h.this);
      }
      
      public void b(boolean paramAnonymousBoolean)
      {
        h.this.f(paramAnonymousBoolean);
      }
      
      public void c()
      {
        h.c(h.this);
      }
    });
    this.U = new a();
    this.U.a(this.S, new a.b()
    {
      public int a()
      {
        return h.this.n();
      }
      
      public void a(int paramAnonymousInt)
      {
        h.this.f(paramAnonymousInt);
      }
      
      public void a(boolean paramAnonymousBoolean)
      {
        h.this.f(paramAnonymousBoolean);
      }
    });
    this.V = new g(this.S);
    V();
    W();
    this.W = com.baidu.carlife.logic.a.j.a();
    this.X = new Bundle();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b localb = h(paramInt1);
    if (localb != null) {
      localb.f(paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (this.n != 1);
    if (paramInt2 == 1)
    {
      a(true, false);
      return;
    }
    StatisticManager.onEvent("MUSIC_QQ_0015", "音乐数据不完整" + paramInt3);
    com.baidu.carlife.wechat.a.b.c.e("thinkreed", "qq music error to switch song");
    a(true);
  }
  
  public void a(final int paramInt, MusicSongModel paramMusicSongModel)
  {
    t();
    if ((this.T == null) || (paramMusicSongModel == null) || (!i(paramInt))) {}
    do
    {
      return;
      g(false);
      f(true);
      a(this.B, 101);
      f(paramInt);
      H();
      a(this.A);
      g(paramMusicSongModel);
      this.v = 0;
      this.x = false;
      R();
      if (paramInt == 0)
      {
        B();
        if (paramMusicSongModel.i == null)
        {
          this.z = 5;
          a(0).add(0, paramMusicSongModel);
          b(this.n, this.A);
          h(paramInt).b(j());
          return;
        }
        com.baidu.carlife.core.k.a(226);
        com.baidu.carlife.core.k.b(226, paramInt);
        this.P.sendEmptyMessageDelayed(260, 500L);
        return;
      }
      if ((paramInt == 1) && (paramMusicSongModel.m != null))
      {
        if (!new File(paramMusicSongModel.m).exists())
        {
          this.R.post(new Runnable()
          {
            public void run()
            {
              h.d(h.this);
            }
          });
          return;
        }
        this.T.a(paramInt, paramMusicSongModel);
        return;
      }
      if (!I()) {
        break;
      }
      if (!this.s) {
        B();
      }
      com.baidu.carlife.core.k.a(226);
      com.baidu.carlife.core.k.b(226, paramInt);
      if (paramInt == 2)
      {
        this.z = 5;
        U();
        return;
      }
      if (paramInt == 1)
      {
        this.T.a(paramInt, paramMusicSongModel);
        return;
      }
    } while (paramInt < 3);
    this.z = 15;
    U();
    return;
    this.R.post(new Runnable()
    {
      public void run()
      {
        w.a("网络异常", 0);
        b localb = h.this.h(paramInt);
        if (localb == null) {
          return;
        }
        localb.i(3);
      }
    });
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    if (!i(paramInt)) {
      i1 = 0;
    }
    f(i1);
    a(paramBoolean, true);
  }
  
  public void a(MusicSongModel paramMusicSongModel)
  {
    if (paramMusicSongModel != null)
    {
      paramMusicSongModel.j = 0;
      paramMusicSongModel.k = false;
      paramMusicSongModel.l = false;
      paramMusicSongModel.h = null;
    }
  }
  
  public void a(String paramString1, String paramString2, f.a.a parama)
  {
    StatisticManager.onEvent("VOICE_0008");
    List localList = a(0);
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i1;
      if ((TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1))) {
        i1 = i.a(localList, this.L, paramString1);
      }
      while (i1 > 0)
      {
        this.J = 0;
        paramString1 = new ArrayList();
        k.a(this.L, paramString1);
        parama.a(paramString1);
        return;
        if ((!TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString1))) {
          i1 = i.b(localList, this.L, paramString2);
        } else if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString1))) {
          i1 = i.a(localList, this.L);
        } else {
          i1 = i.a(localList, this.L, paramString2, paramString1);
        }
      }
    }
    this.J = 2;
    this.M = parama;
    h(2).a(paramString1, paramString2, true);
  }
  
  public void a(boolean paramBoolean)
  {
    a(n(), paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (q()) {
      if (!I())
      {
        f(true);
        y();
      }
    }
    Object localObject;
    label86:
    do
    {
      return;
      if (c.a().b() != 2)
      {
        localObject = c.a();
        if (!paramBoolean1) {
          break label86;
        }
      }
      for (i1 = 4;; i1 = 3)
      {
        ((c)localObject).a(i1, this.W.c());
        localObject = h(paramBoolean1);
        X();
        f(true);
        if (localObject == null) {
          break;
        }
        e((MusicSongModel)localObject);
        return;
      }
      localObject = d();
    } while ((localObject == null) || (((List)localObject).isEmpty()));
    int i1 = ((List)localObject).size();
    int i2 = i.a(k(), i1, e(), paramBoolean1, paramBoolean2);
    if (i2 < 0)
    {
      w.a(this.S.getString(2131296602), 1);
      return;
    }
    if (i2 >= i1)
    {
      w.a(this.S.getString(2131296607), 1);
      return;
    }
    X();
    c(i2);
    a(n(), (MusicSongModel)((List)localObject).get(i2));
  }
  
  public int b(int paramInt)
  {
    b localb = h(paramInt);
    if (localb == null) {
      return 0;
    }
    return localb.m();
  }
  
  public b b(String paramString)
  {
    return this.U.b(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    if (q())
    {
      if (!paramBoolean) {
        break label33;
      }
      StatisticManager.onEvent("CONTENT_CONTROl_0002");
      StatisticManager.onEvent("VOICE_CONTROl_0002");
    }
    for (;;)
    {
      a(n(), paramBoolean);
      return;
      label33:
      StatisticManager.onEvent("CONTENT_CONTROl_0001");
      StatisticManager.onEvent("VOICE_CONTROl_0001");
    }
  }
  
  public boolean b(MusicSongModel paramMusicSongModel)
  {
    Iterator localIterator = J().iterator();
    while (localIterator.hasNext())
    {
      MusicSongModel localMusicSongModel = (MusicSongModel)localIterator.next();
      if (((localMusicSongModel.a != null) && (localMusicSongModel.a.equals(paramMusicSongModel.a))) || ((localMusicSongModel.m != null) && (localMusicSongModel.m.equals(paramMusicSongModel.m)))) {
        return true;
      }
    }
    return false;
  }
  
  public void c()
  {
    f(true);
    ((e)h(0)).z();
    o();
    t();
    if (this.S != null) {}
    try
    {
      this.S.unbindService(this.Y);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  public void c(int paramInt)
  {
    a(this.n, paramInt);
  }
  
  public void c(MusicSongModel paramMusicSongModel)
  {
    J().remove(paramMusicSongModel);
    J().add(paramMusicSongModel);
  }
  
  public void c(String paramString)
  {
    if ((this.T == null) || (paramString == null)) {
      return;
    }
    int i1 = 0;
    try
    {
      int i2 = Integer.valueOf(paramString).intValue();
      i1 = i2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    this.W.a(i1);
    if (paramString.equals(this.W.c().n()))
    {
      if (!q())
      {
        e(this.W.c().p());
        return;
      }
      e(true);
      return;
    }
    if (v()) {
      c.a().a(4, this.W.c());
    }
    f(true);
    this.W.c().e(paramString);
    e(this.W.c().p());
  }
  
  public void c(boolean paramBoolean)
  {
    b localb = r();
    if (localb != null) {
      a(localb.s(), paramBoolean);
    }
  }
  
  public List<MusicSongModel> d()
  {
    return a(this.n);
  }
  
  public void d(int paramInt)
  {
    this.U.c(paramInt);
  }
  
  public void d(MusicSongModel paramMusicSongModel)
  {
    int i1 = 0;
    paramMusicSongModel.n = 0L;
    Object localObject = paramMusicSongModel.a;
    Iterator localIterator = J().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        MusicSongModel localMusicSongModel = (MusicSongModel)localIterator.next();
        if (((localMusicSongModel.a != null) && (localMusicSongModel.a.equals(localObject))) || ((localMusicSongModel.m != null) && (localMusicSongModel.m.equals(paramMusicSongModel.m))))
        {
          paramMusicSongModel = (MusicSongModel)J().remove(i1);
          if (J().indexOf(paramMusicSongModel) < 0)
          {
            localObject = new File(f.jm + "/" + paramMusicSongModel.a + ".mp3");
            if (((File)localObject).exists()) {
              ((File)localObject).delete();
            }
          }
          com.baidu.carlife.core.i.b("CarLifeMusic", "----removeBufferMusic--song:" + paramMusicSongModel.b);
        }
      }
      else
      {
        return;
      }
      i1 += 1;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.A == null) || (this.T == null) || (q())) {}
    do
    {
      return;
      if (paramBoolean) {
        this.w = false;
      }
    } while ((this.w) || (this.A.k));
    this.A.k = true;
    this.T.a(this.n);
    if (this.q == -1L)
    {
      this.q = System.currentTimeMillis();
      this.P.removeMessages(1);
      this.P.sendEmptyMessageDelayed(1, 3000L);
    }
    com.baidu.carlife.core.k.b(225, this.n);
    this.P.sendEmptyMessage(407);
    com.baidu.carlife.logic.k.a().a(3, 1);
    this.R.post(new Runnable()
    {
      public void run()
      {
        h.this.r().t();
      }
    });
  }
  
  public int e()
  {
    return b(this.n);
  }
  
  public void e(int paramInt)
  {
    this.m = paramInt;
    com.baidu.carlife.core.k.b(407);
    Z();
  }
  
  public void e(MusicSongModel paramMusicSongModel)
  {
    t();
    ((com.baidu.carlife.logic.e)d.b().a(MusicPlayerFragment.class.getName())).a();
    if ((this.T == null) || (paramMusicSongModel == null)) {
      return;
    }
    R();
    g(true);
    f(true);
    a(this.A, n());
    if (!I())
    {
      y();
      return;
    }
    i(paramMusicSongModel);
    j(paramMusicSongModel);
    Q();
    P();
    if (!this.s) {
      B();
    }
    com.baidu.carlife.core.k.a(226);
    com.baidu.carlife.core.k.b(226, 101);
    this.z = 15;
    if (this.W.g())
    {
      O();
      return;
    }
    if (N())
    {
      M();
      t();
      return;
    }
    if (!b(this.B))
    {
      b(101, this.B);
      return;
    }
    if (this.B.n < 0L) {
      this.B.n = 0L;
    }
    c(paramMusicSongModel);
    k(paramMusicSongModel);
    M();
  }
  
  public void e(boolean paramBoolean)
  {
    if ((this.B == null) || (this.T == null) || (!q())) {}
    do
    {
      return;
      if (paramBoolean) {
        this.w = false;
      }
    } while ((this.w) || (this.B.k) || (this.W.c().p() != this.B));
    this.B.k = true;
    this.T.a(101);
    if (this.q == -1L)
    {
      this.q = System.currentTimeMillis();
      this.P.removeMessages(1);
      this.P.sendEmptyMessageDelayed(1, 3000L);
    }
    com.baidu.carlife.core.k.b(225, 101);
    this.P.sendEmptyMessage(407);
    com.baidu.carlife.logic.k.a().a(3, 1);
  }
  
  public int f()
  {
    b localb = h(n());
    if (localb != null) {
      return localb.s();
    }
    return 0;
  }
  
  public void f(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 100))
    {
      this.n = paramInt;
      com.baidu.carlife.util.p.a().b("LastestPlaySource", o(paramInt));
    }
  }
  
  public void f(MusicSongModel paramMusicSongModel)
  {
    String str1 = paramMusicSongModel.b;
    String str2 = paramMusicSongModel.f;
    paramMusicSongModel.a = paramMusicSongModel.m;
    List localList = a(0);
    ArrayList localArrayList = new ArrayList();
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i1;
      if ((TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        i1 = i.a(localList, localArrayList, str2);
      }
      while (i1 >= 1)
      {
        paramMusicSongModel = (MusicSongModel)localArrayList.get(0);
        if (paramMusicSongModel.i == null)
        {
          return;
          if ((!TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) {
            i1 = i.b(localList, localArrayList, str1);
          } else {
            i1 = i.a(localList, localArrayList, str1, str2);
          }
        }
        else
        {
          a(0, localList.indexOf(paramMusicSongModel));
          a(0, paramMusicSongModel);
          return;
        }
      }
    }
    a(0, paramMusicSongModel);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.T == null) {}
    do
    {
      return;
      if (!this.w) {
        this.w = paramBoolean;
      }
      if (paramBoolean) {
        this.r = System.currentTimeMillis();
      }
      if ((this.A != null) && (this.A.k))
      {
        this.P.removeMessages(1);
        this.A.k = false;
        this.T.a();
        com.baidu.carlife.core.k.b(225, this.n);
        com.baidu.carlife.logic.k.a().a(3, 0);
        this.R.post(new Runnable()
        {
          public void run()
          {
            h.this.r().t();
          }
        });
        ap();
        return;
      }
    } while ((this.B == null) || (!this.B.k));
    this.P.removeMessages(1);
    this.B.k = false;
    p.a().c();
    this.T.a();
    com.baidu.carlife.core.k.b(225, 101);
    com.baidu.carlife.logic.k.a().a(3, 0);
    ap();
  }
  
  public int g()
  {
    return this.U.f();
  }
  
  public void g(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public boolean g(int paramInt)
  {
    return n() == paramInt;
  }
  
  public b h(int paramInt)
  {
    return this.U.a(paramInt);
  }
  
  public MusicSongModel h()
  {
    return this.A;
  }
  
  public MusicSongModel i()
  {
    return this.B;
  }
  
  public String j()
  {
    return r().n();
  }
  
  public void j(int paramInt)
  {
    this.v = 0;
    this.y = false;
    com.baidu.carlife.core.k.b(227, paramInt);
    A();
  }
  
  public int k()
  {
    return this.m;
  }
  
  public void k(int paramInt)
  {
    if ((this.L == null) || (paramInt < 0) || (paramInt >= this.L.size()))
    {
      com.baidu.carlife.core.i.e("CarLifeMusic", "param error");
      return;
    }
    MusicSongModel localMusicSongModel = (MusicSongModel)this.L.get(paramInt);
    if (this.J == 0)
    {
      this.K = 0;
      a(0, h(0).g().indexOf(localMusicSongModel));
      aj();
    }
    while (2 != this.J)
    {
      a(this.K, localMusicSongModel);
      return;
    }
    this.K = 2;
    b localb = h(this.K);
    localb.e("TEMPLIST_ID");
    localb.a("搜索歌曲播放列表");
    localb.f(paramInt);
    List localList = localb.f("TEMPLIST_ID");
    if (localList != null) {
      localList.clear();
    }
    for (;;)
    {
      localb.a("TEMPLIST_ID", this.L);
      localb.l();
      ak();
      break;
      localb.a("TEMPLIST_ID", new ArrayList());
    }
  }
  
  public void l(int paramInt)
  {
    this.U.b(paramInt);
  }
  
  public boolean l()
  {
    return this.w;
  }
  
  public com.baidu.carlife.model.j m(int paramInt)
  {
    return this.U.d(paramInt);
  }
  
  public void m()
  {
    int i1 = this.m + 1;
    this.m = i1;
    this.m = (i1 % 3);
    this.P.sendEmptyMessage(407);
    Z();
  }
  
  public int n()
  {
    return this.n;
  }
  
  public void o()
  {
    com.baidu.carlife.util.p.a().b("localPlayStrategy", this.m);
  }
  
  public boolean p()
  {
    return (this.A != null) && (this.A.k);
  }
  
  public boolean q()
  {
    return this.C;
  }
  
  public b r()
  {
    return this.U.b();
  }
  
  public r s()
  {
    return this.W.c();
  }
  
  public void t()
  {
    this.W.d().a();
    if ((!q()) && (n() >= 3)) {
      com.baidu.carlife.platform.c.a().b(o(n()));
    }
  }
  
  public void u()
  {
    if (J() != null) {
      J().clear();
    }
    com.baidu.carlife.core.e.b(f.jm, ".mp3");
  }
  
  public boolean v()
  {
    return (q()) && (this.B != null) && (this.B.k);
  }
  
  public boolean w()
  {
    return (q()) && (this.B != null) && (!this.B.k);
  }
  
  public void x()
  {
    if (q()) {
      e(true);
    }
    com.baidu.carlife.radio.a.a locala;
    do
    {
      return;
      if (this.W.c().n() != null)
      {
        e(this.W.c().p());
        return;
      }
      locala = com.baidu.carlife.radio.c.b.a().d();
    } while (locala == null);
    this.W.c().e(locala.a());
    e(this.W.c().p());
  }
  
  public void y()
  {
    this.R.post(new Runnable()
    {
      public void run()
      {
        w.a("网络异常", 0);
        if (h.e(h.this).c() == null) {
          return;
        }
        h.e(h.this).c().i(3);
      }
    });
  }
  
  public boolean z()
  {
    List localList;
    if (i(this.n))
    {
      localList = a(this.n);
      if ((localList != null) && (!localList.isEmpty())) {}
    }
    else
    {
      do
      {
        return true;
        aj();
        localList = a(0);
      } while ((localList == null) || (localList.isEmpty()));
    }
    return false;
  }
  
  private class a
    extends com.baidu.carlife.core.j
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void careAbout()
    {
      addMsg(217);
      addMsg(307);
      addMsg(407);
      addMsg(404);
      addMsg(416);
      addMsg(423);
      addMsg(424);
    }
    
    public void handleMessage(final Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 307: 
      case 229: 
      case 253: 
      case 221: 
      case 217: 
      case 407: 
      case 404: 
      case 416: 
      case 260: 
      case 1: 
      case 423: 
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  final Object localObject;
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                return;
                                if (!h.this.q()) {
                                  break;
                                }
                              } while (h.i(h.this) == null);
                              com.baidu.carlife.core.k.a(307, h.i(h.this).j, 101, 1000);
                              if (h.i(h.this).k) {
                                h.j(h.this);
                              }
                              h.k(h.this);
                              return;
                            } while (h.l(h.this) == null);
                            com.baidu.carlife.core.k.a(paramMessage.what, h.l(h.this).j, h.m(h.this), 1000);
                            if (h.l(h.this).k)
                            {
                              h.n(h.this).a(h.l(h.this).j);
                              paramMessage = h.l(h.this);
                              int i = paramMessage.j;
                              paramMessage.j = (i + 1);
                              if (i > h.o(h.this)) {
                                h.this.a(true, false);
                              }
                            }
                          } while ((h.this.g(0)) || (h.this.g(1)));
                          h.p(h.this);
                          return;
                          paramMessage = h.this.h(h.m(h.this));
                        } while (paramMessage == null);
                        localObject = h.this.d();
                      } while ((localObject == null) || (((List)localObject).isEmpty()) || (TextUtils.isEmpty(h.l(h.this).g)));
                      new Thread(new Runnable()
                      {
                        public void run()
                        {
                          h.l(h.this).h = paramMessage.d(h.l(h.this).g);
                          com.baidu.carlife.core.k.a(219, h.m(h.this), h.l(h.this).h);
                          byte[] arrayOfByte = com.baidu.carlife.core.e.a().a(h.l(h.this).h);
                          h.n(h.this).a(h.l(h.this), arrayOfByte, localObject.size(), h.q(h.this));
                        }
                      }).start();
                      return;
                      localObject = (MusicSongModel)paramMessage.obj;
                    } while (localObject == null);
                    if (paramMessage.arg1 != 2) {
                      break;
                    }
                    ((MusicSongModel)localObject).m = NeteaseMusicUtils.getSimpleSongUrl(((MusicSongModel)localObject).a);
                  } while (TextUtils.isEmpty(((MusicSongModel)localObject).m));
                  if ((((MusicSongModel)localObject).a() != null) && (((MusicSongModel)localObject).l() == null))
                  {
                    h.e(h.this).c().c(h.e(h.this).c().n(), ((MusicSongModel)localObject).a());
                    return;
                  }
                  ((MusicSongModel)localObject).n = 0L;
                  h.a(h.this, (MusicSongModel)localObject);
                  h.b(h.this, (MusicSongModel)localObject);
                  removeMessages(221);
                  sendEmptyMessageDelayed(221, 500L);
                  return;
                  if (h.this.q())
                  {
                    h.r(h.this);
                    return;
                  }
                  h.s(h.this);
                  return;
                  paramMessage = (MusicSongModel)paramMessage.obj;
                  if (h.this.q())
                  {
                    h.t(h.this);
                    return;
                  }
                  if (((h.l(h.this).a != null) && (h.l(h.this).a.equals(paramMessage.a()))) || ((h.l(h.this).m != null) && (h.l(h.this).m.equals(paramMessage.l()))))
                  {
                    h.u(h.this);
                    return;
                  }
                  com.baidu.carlife.core.i.b("CarLifeMusic", "----MSG_MUSIC_DOWNLOAD_COMPLETE--NEXTSONG-");
                  i.a(-1);
                  return;
                  if (!h.this.q()) {
                    break;
                  }
                  paramMessage = h.e(h.this).c().g();
                } while ((paramMessage == null) || (paramMessage.isEmpty()) || (h.i(h.this) == null) || (TextUtils.isEmpty(h.i(h.this).b)));
                h.n(h.this).a(h.i(h.this), com.baidu.carlife.core.e.a().a(h.i(h.this).h), paramMessage.size(), 2);
                return;
                paramMessage = h.this.d();
              } while ((paramMessage == null) || (paramMessage.isEmpty()));
              h.n(h.this).a(h.l(h.this), com.baidu.carlife.core.e.a().a(h.l(h.this).h), paramMessage.size(), h.q(h.this));
              return;
              com.baidu.carlife.core.i.e("CarLifeMusic", "----MSG_MUSIC_AUDIO_DECODER_ERROR--");
              if ((h.this.q()) && (h.i(h.this).n <= h.i(h.this).o / 2L))
              {
                removeMsg(221);
                sendEmptyMessageDelayed(221, 1000L);
                return;
              }
              w.a(h.v(h.this).getString(2131296606), 0);
              h.w(h.this).post(new Runnable()
              {
                public void run()
                {
                  h.d(h.this);
                }
              });
              return;
              com.baidu.carlife.core.i.e("CarLifeMusic", "----MSG_MUSIC_AUDIO_DECODER_ERROR_NO_INPUT_DATA--");
            } while ((!h.this.g(0)) || (h.this.h().j >= h.o(h.this) - 20));
            h.w(h.this).post(new Runnable()
            {
              public void run()
              {
                h.d(h.this);
              }
            });
            return;
            h.x(h.this);
            return;
          } while (!h.this.p());
          h.y(h.this);
          return;
        } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof ArrayList)));
        h.a(h.this, (ArrayList)paramMessage.obj);
        paramMessage.obj = null;
        if (h.z(h.this).size() > 0)
        {
          paramMessage = new ArrayList();
          k.a(h.z(h.this), paramMessage);
          h.w(h.this).post(new Runnable()
          {
            public void run()
            {
              h.A(h.this).a(paramMessage);
            }
          });
          return;
        }
        h.w(h.this).post(new Runnable()
        {
          public void run()
          {
            h.A(h.this).a("未能找到符合要求的歌曲");
          }
        });
        return;
      }
      h.this.a(true, true);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */