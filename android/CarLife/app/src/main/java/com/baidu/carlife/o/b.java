package com.baidu.carlife.o;

import android.content.Context;
import android.os.Message;
import com.baidu.carlife.core.connect.c;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import com.baidu.carlife.logic.music.p;
import com.baidu.carlife.logic.music.r;
import com.baidu.carlife.protobuf.CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest;
import com.baidu.carlife.protobuf.CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.Builder;
import com.baidu.che.codriver.sdk.a.a.b;
import com.baidu.che.codriver.sdk.a.k.b;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.voice.MapVoiceCommandController;
import java.util.HashMap;
import java.util.Map;

public class b
{
  private static final String a = b.class.getSimpleName();
  private static b b = null;
  private static Context c = null;
  private Map<Integer, String> d = new HashMap();
  private a.b e = new a.b()
  {
    public void onCommand(String paramAnonymousString1, String paramAnonymousString2)
    {
      i.b(b.b(), "## mCommandListener onCommand():" + paramAnonymousString1 + " # " + paramAnonymousString2);
      if (paramAnonymousString1.equals("open_home_page")) {
        b.a(b.this, 4001);
      }
      do
      {
        do
        {
          return;
          if (paramAnonymousString1.equals("open_phone_page"))
          {
            b.a(b.this, 4002);
            return;
          }
          if (paramAnonymousString1.equals("open_navi_page"))
          {
            b.a(b.this, 4003);
            return;
          }
          if (paramAnonymousString1.equals("open_music_page"))
          {
            b.a(b.this, 4004);
            return;
          }
          if (paramAnonymousString1.equals("take_picture"))
          {
            b.a(17);
            return;
          }
          if (paramAnonymousString1.equals("max_brightness"))
          {
            b.a(13);
            return;
          }
          if (paramAnonymousString1.equals("min_brightness"))
          {
            b.a(14);
            return;
          }
          if (paramAnonymousString1.equals("open_dvr"))
          {
            b.a(0);
            return;
          }
          if (paramAnonymousString1.equals("open_camera"))
          {
            b.a(22);
            return;
          }
          if (!paramAnonymousString1.equals("scene_music")) {
            break;
          }
          if ("播放音乐,播放歌曲,继续播放".contains(paramAnonymousString2))
          {
            if (com.baidu.carlife.logic.music.h.b().q()) {
              p.a().d();
            }
            com.baidu.carlife.logic.music.h.b().a(null, null);
            return;
          }
          if ("暂停播放,停止播放".contains(paramAnonymousString2))
          {
            if (com.baidu.carlife.logic.music.h.b().q()) {
              p.a().c();
            }
            com.baidu.carlife.logic.music.h.b().f(true);
            return;
          }
          if (paramAnonymousString2.contains("下一"))
          {
            com.baidu.carlife.logic.music.h.b().a(true);
            return;
          }
        } while (!paramAnonymousString2.contains("上一"));
        com.baidu.carlife.logic.music.h.b().a(false);
        return;
      } while (!paramAnonymousString1.equals("select_index"));
      i.b(b.b(), "voice scene select: " + paramAnonymousString2);
    }
  };
  private k.b f = new k.b()
  {
    public void a(String paramAnonymousString)
    {
      i.b(b.b(), "close feature = " + paramAnonymousString);
      if ("导航".equals(paramAnonymousString))
      {
        MapVoiceCommandController.getInstance().openNavi();
        MapVoiceCommandController.getInstance().exitNavi();
        return;
      }
      com.baidu.carlife.m.a.a().a(b.c().getString(2131296727), 1);
    }
    
    public void a(String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      i.b(b.b(), "open feature = " + paramAnonymousString);
      if (paramAnonymousString.equals("system_setting")) {
        b.a(2);
      }
      do
      {
        return;
        if (paramAnonymousString.equals("图库"))
        {
          b.a(3);
          return;
        }
        if (paramAnonymousString.equals("playback"))
        {
          b.a(4);
          return;
        }
        if (paramAnonymousString.equals("后视"))
        {
          b.a(22);
          return;
        }
        if (paramAnonymousString.equals("home"))
        {
          b.a(b.this, 4001);
          return;
        }
        if (paramAnonymousString.equals("music_player_bsg"))
        {
          b.a(b.this, 4004);
          return;
        }
        if ((paramAnonymousString.equals("导航")) || (paramAnonymousString.equals("地图")))
        {
          b.a(b.this, 4003);
          return;
        }
        if (paramAnonymousString.equals("telephone"))
        {
          b.a(b.this, 4002);
          return;
        }
        if (paramAnonymousString.equals("回放"))
        {
          b.a(4);
          return;
        }
        if (paramAnonymousString.equals("记录仪"))
        {
          b.a(0);
          return;
        }
        if (paramAnonymousString.equals("随心听"))
        {
          if (!com.baidu.carlife.l.a.a().N())
          {
            i.b("#######", "VoiceControlManager VOICE_PHONE_0004,VOICE_0006");
            StatisticManager.onEvent("VOICE_PHONE_0004");
            StatisticManager.onEvent("VOICE_0006");
          }
          com.baidu.carlife.logic.music.h.b().s().a(null, null);
          return;
        }
        i.b(b.b(), "------- Wake up CMD -------: " + paramAnonymousBoolean);
        if (!paramAnonymousBoolean) {
          break;
        }
      } while (b.this.a(paramAnonymousString));
      com.baidu.carlife.m.a.a().a(b.c().getString(2131297207), 1);
      return;
      com.baidu.carlife.m.a.a().a(b.c().getString(2131296727), 1);
    }
    
    public void b(String paramAnonymousString)
    {
      i.b(b.b(), "increase feature = " + paramAnonymousString);
      if (paramAnonymousString.equals("volume"))
      {
        b.a(7);
        return;
      }
      if (paramAnonymousString.equals("light"))
      {
        b.a(11);
        return;
      }
      com.baidu.carlife.m.a.a().a(b.c().getString(2131296727), 1);
    }
    
    public void c(String paramAnonymousString)
    {
      i.b(b.b(), "decrease feature = " + paramAnonymousString);
      if (paramAnonymousString.equals("volume"))
      {
        b.a(8);
        return;
      }
      if (paramAnonymousString.equals("light"))
      {
        b.a(12);
        return;
      }
      com.baidu.carlife.m.a.a().a(b.c().getString(2131296727), 1);
    }
    
    public void d(String paramAnonymousString)
    {
      i.b(b.b(), "maxmize feature = " + paramAnonymousString);
      if (paramAnonymousString.equals("volume"))
      {
        b.a(9);
        return;
      }
      if (paramAnonymousString.equals("light"))
      {
        b.a(13);
        return;
      }
      com.baidu.carlife.m.a.a().a(b.c().getString(2131296727), 1);
    }
    
    public void e(String paramAnonymousString)
    {
      i.b(b.b(), "minimize feature = " + paramAnonymousString);
      if (paramAnonymousString.equals("light"))
      {
        b.a(14);
        return;
      }
      com.baidu.carlife.m.a.a().a(b.c().getString(2131296727), 1);
    }
    
    public void f(String paramAnonymousString)
    {
      i.b(b.b(), "manipulate feature = " + paramAnonymousString);
      if (paramAnonymousString.equals("take_picture"))
      {
        b.a(17);
        return;
      }
      com.baidu.carlife.m.a.a().a(b.c().getString(2131296727), 1);
    }
  };
  
  public static b a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new b();
      }
      return b;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    if (!f()) {}
    CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest localCarlifeVoiceControlRequest;
    do
    {
      return;
      if (!com.baidu.carlife.l.a.a().N())
      {
        i.b(a, "CarLife not connected");
        return;
      }
      localCarlifeVoiceControlRequest = c(paramInt);
    } while (localCarlifeVoiceControlRequest == null);
    a(localCarlifeVoiceControlRequest);
    i.b(a, "MD --- >HU: Voice Control Cmd, id =  " + paramInt);
  }
  
  public static void a(CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest paramCarlifeVoiceControlRequest)
  {
    i.b(a, "MD--->HU : send voice control cmd to HU");
    if (paramCarlifeVoiceControlRequest == null) {}
    while (!com.baidu.carlife.l.a.a().N()) {
      return;
    }
    c localc = new c(true);
    localc.c(65638);
    localc.b(paramCarlifeVoiceControlRequest.toByteArray());
    localc.d(paramCarlifeVoiceControlRequest.getSerializedSize());
    paramCarlifeVoiceControlRequest = Message.obtain(null, localc.d(), 1001, 0, localc);
    com.baidu.carlife.l.a.a().a(paramCarlifeVoiceControlRequest);
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4002: 
      a(1);
      k.b(paramInt);
      return;
    case 4004: 
      a(1);
      k.b(paramInt);
      return;
    case 4003: 
      a(1);
      k.b(paramInt);
      return;
    }
    a(18);
    k.b(paramInt);
  }
  
  private static CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest c(int paramInt)
  {
    CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.Builder localBuilder = CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.newBuilder();
    if (localBuilder == null) {
      return null;
    }
    localBuilder.setCommand(paramInt);
    return localBuilder.build();
  }
  
  private void d()
  {
    this.e.addCommand("open_home_page", new String[] { "打开主页,前往首页" });
    this.e.addCommand("open_phone_page", new String[] { "打开电话,前往电话" });
    this.e.addCommand("open_navi_page", new String[] { "打开地图,前往地图,地图" });
    this.e.addCommand("open_music_page", new String[] { "打开音乐,前往音乐" });
    this.e.addCommand("take_picture", new String[] { "拍张照片" });
    this.e.addCommand("max_brightness", new String[] { "屏幕最亮" });
    this.e.addCommand("min_brightness", new String[] { "屏幕最暗" });
    this.e.addCommand("open_dvr", new String[] { "打开记录仪,记录仪" });
    this.e.addCommand("open_camera", new String[] { "打开后视,后视" });
    this.e.addCommand("select_index", new String[] { "第一个,第二个,第三个" });
  }
  
  private void e()
  {
    this.e.addCommand("scene_music", new String[] { "播放音乐", "播放歌曲", "暂停播放", "停止播放", "继续播放", "下一首", "下一曲", "上一首", "上一曲" });
  }
  
  private static boolean f()
  {
    boolean bool = false;
    if ((f.jx == f.a.ab) || (f.jx == f.a.aa)) {
      bool = true;
    }
    return bool;
  }
  
  public void a(Context paramContext)
  {
    i.b(a, "VoiceControlManager Init");
    c = paramContext;
    this.d.put(Integer.valueOf(18), "打开主页,前往首页");
    this.d.put(Integer.valueOf(13), "屏幕最亮");
    this.d.put(Integer.valueOf(14), "屏幕最暗");
    this.d.put(Integer.valueOf(0), "打开记录仪,记录仪");
    this.d.put(Integer.valueOf(17), "拍张照片");
    this.d.put(Integer.valueOf(22), "打开后视,后视");
    d();
    e();
    com.baidu.carlife.logic.codriver.adapter.b.a().a(this.e);
    com.baidu.carlife.logic.codriver.adapter.b.a().a(this.f);
  }
  
  public boolean a(String paramString)
  {
    ContentFragment localContentFragment = com.baidu.carlife.core.screen.presentation.h.a().getCurrentFragment();
    if (localContentFragment == null)
    {
      com.baidu.che.codriver.util.h.b(a, "doGotoCommand: fragment Error");
      return false;
    }
    return localContentFragment.onVoiceCommand("", paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/o/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */