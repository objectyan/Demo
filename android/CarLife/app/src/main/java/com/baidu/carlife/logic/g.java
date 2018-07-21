package com.baidu.carlife.logic;

import android.content.Context;
import android.os.Message;
import com.baidu.carlife.core.connect.c;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.protobuf.CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode;
import com.baidu.carlife.protobuf.CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode.Builder;
import com.baidu.carlife.protobuf.CarlifeFeatureConfigListProto.CarlifeFeatureConfigList;
import com.baidu.carlife.protobuf.CarlifeFeatureConfigProto.CarlifeFeatureConfig;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class g
  implements com.baidu.carlife.core.connect.a.a
{
  private static final Object C = new Object();
  private static g D = null;
  public static final String a = "VOICE_MIC";
  public static final String b = "VOICE_WAKEUP";
  public static final String c = "BLUETOOTH_AUTO_PAIR";
  public static final String d = "BLUETOOTH_INTERNAL_UI";
  public static final String e = "FOCUS_UI";
  public static final String f = "MEDIA_SAMPLE_RATE";
  public static final String g = "AUDIO_TRANSMISSION_MODE";
  public static final String h = "CONTENT_ENCRYPTION";
  public static final String i = "ENGINE_TYPE";
  public static final String j = "INPUT_DISABLE";
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 1;
  public static final int o = 0;
  public static final int p = 0;
  public static final int q = 1;
  public static int r = 0;
  public static int s = 1;
  public static int t = 0;
  public static int u = 1;
  public static final int v = -1;
  public static int x = 1000;
  private static final String y = "FeatureConfigManager";
  private Timer A = null;
  private TimerTask B = null;
  private Context E = null;
  private List<CarlifeFeatureConfigProto.CarlifeFeatureConfig> F = null;
  private j G = new j()
  {
    public void careAbout()
    {
      addMsg(98386);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      g.a(g.this, g.a(g.this, (c)paramAnonymousMessage.obj));
      g.c(g.this);
      g.b(g.this);
      if (com.baidu.carlife.l.a.a().U())
      {
        i.b("FeatureConfigManager", "[configure] encrypt: on");
        com.baidu.carlife.l.a.a().a(g.this);
        return;
      }
      i.b("FeatureConfigManager", "[configure] encrypt: off");
      com.baidu.carlife.core.k.b(1007);
      g.this.b(true);
    }
  };
  public boolean w = false;
  private boolean z = true;
  
  public static g a()
  {
    if (D == null) {}
    synchronized (C)
    {
      if (D == null) {
        D = new g();
      }
      return D;
    }
  }
  
  private List<CarlifeFeatureConfigProto.CarlifeFeatureConfig> a(c paramc)
  {
    try
    {
      paramc = CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.parseFrom(paramc.f());
      if (paramc == null) {
        return null;
      }
      paramc = paramc.getFeatureConfigList();
      return paramc;
    }
    catch (InvalidProtocolBufferException paramc)
    {
      paramc.printStackTrace();
    }
    return null;
  }
  
  public static void a(int paramInt)
  {
    c localc = new c(true);
    localc.c(425992);
    Object localObject = CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode.newBuilder();
    ((CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode.Builder)localObject).setKeycode(paramInt);
    localObject = ((CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode.Builder)localObject).build();
    localc.b(((CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode)localObject).toByteArray());
    localc.d(((CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode)localObject).getSerializedSize());
    com.baidu.carlife.core.k.a(425992, 0, 0, localc, 500);
  }
  
  public static void g()
  {
    if (a().c())
    {
      a(24);
      a(23);
    }
  }
  
  private void i()
  {
    if ((this.F == null) || (this.F.isEmpty())) {
      return;
    }
    CarlifeFeatureConfigProto.CarlifeFeatureConfig localCarlifeFeatureConfig;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.F.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localCarlifeFeatureConfig = (CarlifeFeatureConfigProto.CarlifeFeatureConfig)localIterator.next();
        i.b("FeatureConfigManager", "------key:" + localCarlifeFeatureConfig.getKey() + "----value:" + localCarlifeFeatureConfig.getValue());
        if ("BLUETOOTH_AUTO_PAIR".equals(localCarlifeFeatureConfig.getKey()))
        {
          com.baidu.carlife.bluetooth.a.a().a(localCarlifeFeatureConfig.getKey(), localCarlifeFeatureConfig.getValue());
          continue;
        }
        if (!"BLUETOOTH_INTERNAL_UI".equals(localCarlifeFeatureConfig.getKey())) {
          break label160;
        }
      }
      catch (Exception localException)
      {
        i.e("FeatureConfigManager", "feature config get exception");
        localException.printStackTrace();
        return;
      }
      com.baidu.carlife.bluetooth.a.a().a(localCarlifeFeatureConfig.getKey(), localCarlifeFeatureConfig.getValue());
      continue;
      label160:
      if ("FOCUS_UI".equals(localCarlifeFeatureConfig.getKey()))
      {
        if (localCarlifeFeatureConfig.getValue() == 1)
        {
          a(24);
          a(23);
        }
      }
      else if ("MEDIA_SAMPLE_RATE".equals(localCarlifeFeatureConfig.getKey()))
      {
        com.baidu.carlife.l.a.a().b(localCarlifeFeatureConfig.getValue());
        i.b("FeatureConfigManager", "KEY_MEDIA_SAMPLE_RATE = " + localCarlifeFeatureConfig.getValue());
      }
      else if ("VOICE_MIC".equals(localCarlifeFeatureConfig.getKey()))
      {
        k.a().a(6, localCarlifeFeatureConfig.getValue());
        n.a().r();
      }
      else if ("VOICE_WAKEUP".equals(localCarlifeFeatureConfig.getKey()))
      {
        n localn = n.a();
        if (localCarlifeFeatureConfig.getValue() != 1) {
          break label540;
        }
        bool = true;
        label306:
        localn.c(bool);
      }
      else
      {
        if (!"AUDIO_TRANSMISSION_MODE".equals(localCarlifeFeatureConfig.getKey())) {
          break label368;
        }
        com.baidu.carlife.l.a.a().a(localCarlifeFeatureConfig.getValue());
        i.b("FeatureConfigManager", "KEY_AUDIO_TRANSMISSION_MODE = " + localCarlifeFeatureConfig.getValue());
      }
    }
    label368:
    if ("CONTENT_ENCRYPTION".equals(localCarlifeFeatureConfig.getKey())) {
      if (localCarlifeFeatureConfig.getValue() != 1) {
        break label545;
      }
    }
    label540:
    label545:
    for (boolean bool = true;; bool = false)
    {
      com.baidu.carlife.l.a.a().f(bool);
      break;
      if ("ENGINE_TYPE".equals(localCarlifeFeatureConfig.getKey()))
      {
        i.b("FeatureConfigManager", "engine type: " + localCarlifeFeatureConfig.getValue());
        break;
      }
      if ("INPUT_DISABLE".equals(localCarlifeFeatureConfig.getKey()))
      {
        if (localCarlifeFeatureConfig.getValue() == s) {}
        for (this.z = true;; this.z = false)
        {
          i.b("FeatureConfigManager", "####### KEY_INPUT_DISABLE:" + localCarlifeFeatureConfig.getValue());
          break;
        }
      }
      i.e("FeatureConfigManager", "the key is error:" + localCarlifeFeatureConfig.getKey());
      break;
      bool = false;
      break label306;
    }
  }
  
  private void j()
  {
    try
    {
      i.b("FeatureConfigManager", "Wait for Feature Config Timer Start");
      this.A = new Timer();
      this.B = new TimerTask()
      {
        public void run()
        {
          if (g.a(g.this) != null)
          {
            g.b(g.this);
            com.baidu.carlife.core.k.b(1008);
            g.this.b(true);
          }
        }
      };
      this.A.schedule(this.B, x);
      return;
    }
    catch (Exception localException)
    {
      i.b("FeatureConfigManager", "startTimer get exception");
      localException.printStackTrace();
    }
  }
  
  private void k()
  {
    i.e("FeatureConfigManager", "Wait for Feature Config Stop");
    if (this.A != null)
    {
      this.A.cancel();
      this.A = null;
    }
    if (this.B != null)
    {
      this.B.cancel();
      this.B = null;
    }
  }
  
  public int a(String paramString)
  {
    if ((this.F == null) || (this.F.isEmpty())) {}
    CarlifeFeatureConfigProto.CarlifeFeatureConfig localCarlifeFeatureConfig;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return -1;
        localIterator = this.F.iterator();
      }
      localCarlifeFeatureConfig = (CarlifeFeatureConfigProto.CarlifeFeatureConfig)localIterator.next();
    } while (!paramString.equals(localCarlifeFeatureConfig.getKey()));
    return localCarlifeFeatureConfig.getValue();
  }
  
  public void a(Context paramContext)
  {
    this.E = paramContext;
    com.baidu.carlife.core.k.a(this.G);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      com.baidu.carlife.l.a.a().c(65646);
      b(true);
      com.baidu.carlife.core.k.b(1007);
      return;
    }
    com.baidu.carlife.l.a.a().O();
  }
  
  public void b()
  {
    com.baidu.carlife.l.a.a().c(65617);
    j();
    b(false);
  }
  
  public void b(boolean paramBoolean)
  {
    this.w = paramBoolean;
    e.a();
    e.c(paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      new Thread()
      {
        public void run()
        {
          g.this.h();
        }
      }.start();
    }
    while ((!a().f()) || (a().a("VOICE_MIC") != 1)) {
      return;
    }
    new Thread()
    {
      public void run()
      {
        i.b("CarLifeVoice", "request mic permission");
        com.baidu.carlife.core.k.a(4027, 400);
        g.this.h();
        com.baidu.carlife.core.k.a(4027);
        com.baidu.carlife.core.k.b(4028);
      }
    }.start();
  }
  
  public boolean c()
  {
    return a("FOCUS_UI") == 1;
  }
  
  public boolean d()
  {
    return this.z;
  }
  
  public void e()
  {
    this.F = null;
    this.z = true;
  }
  
  public boolean f()
  {
    return this.w;
  }
  
  /* Error */
  public void h()
  {
    // Byte code:
    //   0: new 368	android/media/AudioRecord
    //   3: dup
    //   4: bipush 6
    //   6: sipush 16000
    //   9: bipush 16
    //   11: iconst_2
    //   12: ldc_w 369
    //   15: invokespecial 372	android/media/AudioRecord:<init>	(IIIII)V
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 375	android/media/AudioRecord:startRecording	()V
    //   23: aload_1
    //   24: invokevirtual 378	android/media/AudioRecord:stop	()V
    //   27: aload_1
    //   28: ifnull +7 -> 35
    //   31: aload_1
    //   32: invokevirtual 381	android/media/AudioRecord:release	()V
    //   35: return
    //   36: astore_2
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 382	java/lang/IllegalStateException:printStackTrace	()V
    //   43: goto -16 -> 27
    //   46: astore_2
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_2
    //   50: invokevirtual 383	java/lang/IllegalArgumentException:printStackTrace	()V
    //   53: goto -26 -> 27
    //   56: astore_2
    //   57: goto -8 -> 49
    //   60: astore_2
    //   61: goto -22 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	g
    //   18	31	1	localAudioRecord	android.media.AudioRecord
    //   36	4	2	localIllegalStateException1	IllegalStateException
    //   46	4	2	localIllegalArgumentException1	IllegalArgumentException
    //   56	1	2	localIllegalArgumentException2	IllegalArgumentException
    //   60	1	2	localIllegalStateException2	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   0	19	36	java/lang/IllegalStateException
    //   0	19	46	java/lang/IllegalArgumentException
    //   19	27	56	java/lang/IllegalArgumentException
    //   19	27	60	java/lang/IllegalStateException
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */