package com.baidu.carlife.wechat.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.baidunavis.tts.IBNTTSPlayerWeChatListener;
import com.baidu.carlife.logic.music.h;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.wechat.a.a.c.c;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.json.JSONObject;

public class k
{
  private List<d> a = new ArrayList();
  private List<d> b = new ArrayList();
  private Map<String, a> c = new HashMap();
  private List<String> d = new ArrayList();
  private Queue<d> e = new LinkedList();
  private Queue<d> f = new LinkedList();
  private MediaPlayer g;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private com.baidu.carlife.core.screen.presentation.a.d k;
  private List<b> l = new ArrayList();
  
  public static k a()
  {
    return a.a;
  }
  
  private void a(d paramd, String paramString)
  {
    String str = paramString;
    if (paramString.length() > 500) {
      str = paramString.substring(0, 500);
    }
    com.baidu.carlife.wechat.f.b.d().a(paramd.g(), str + "，请说回复或取消");
    com.baidu.carlife.view.g.e().a(d.a.b);
  }
  
  private void a(e parame)
  {
    MusicSongModel localMusicSongModel = new MusicSongModel();
    localMusicSongModel.m = parame.c();
    localMusicSongModel.b = parame.a();
    localMusicSongModel.f = parame.b();
    h.b().f(localMusicSongModel);
  }
  
  private void a(f paramf)
  {
    paramf = CoordinateTransformUtil.transferGCJ02ToBD09(Double.parseDouble(paramf.c()), Double.parseDouble(paramf.b()));
    paramf = new com.baidu.carlife.core.screen.a(paramf.getLongitudeE6() / 100000.0D, paramf.getLatitudeE6() / 100000.0D);
    if (this.k != null) {
      this.k.a(paramf);
    }
  }
  
  private void a(String paramString, final b paramb)
  {
    this.j = false;
    paramString = new File(paramString);
    try
    {
      if (this.g == null) {
        this.g = new MediaPlayer();
      }
      for (;;)
      {
        this.g.setAudioStreamType(3);
        this.g.setDataSource(paramString.getAbsolutePath());
        this.g.prepareAsync();
        this.g.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
          public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
          {
            k.a(k.this).start();
          }
        });
        this.g.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
          public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            com.baidu.carlife.wechat.f.b.d().a(paramb, "请说回复或取消");
            com.baidu.carlife.view.g.e().a(d.a.b);
          }
        });
        return;
        this.g.reset();
      }
      try
      {
        this.g.release();
        this.g = null;
        com.baidu.carlife.wechat.f.b.d().c();
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      com.baidu.carlife.wechat.a.b.c.e("播报语音消息异常，e=" + paramString);
    }
  }
  
  private void a(final String paramString, final d paramd)
  {
    String str = paramd.n();
    com.baidu.carlife.wechat.a.b.c.c("url=" + str);
    this.j = true;
    paramString = new c.c()
    {
      public void a(final com.baidu.carlife.wechat.a.a.a paramAnonymousa)
      {
        if (TextUtils.isEmpty(paramString)) {
          k.a(k.this, paramAnonymousa.d(), paramd.g());
        }
        do
        {
          return;
          com.baidu.carlife.wechat.f.d.a();
          com.baidu.carlife.wechat.f.d.a(new IBNTTSPlayerWeChatListener()
          {
            public void notifyTTSEnd()
            {
              com.baidu.carlife.wechat.f.d.a(null);
              k.a(k.this, paramAnonymousa.d(), k.4.this.b.g());
            }
            
            public void notifyTTSInterrupt()
            {
              com.baidu.carlife.wechat.f.d.a(null);
              com.baidu.carlife.wechat.f.b.d().c();
            }
            
            public void notifyTTSStart() {}
          });
        } while (com.baidu.carlife.wechat.f.d.a(paramString) >= 0);
        com.baidu.carlife.wechat.f.d.a(null);
        com.baidu.carlife.wechat.f.b.d().c();
      }
      
      public void a(Exception paramAnonymousException)
      {
        com.baidu.carlife.wechat.a.b.c.e("下载语音消息出错，e=" + paramAnonymousException);
        k.a(k.this, false);
        com.baidu.carlife.wechat.f.b.d().c();
      }
    };
    com.baidu.carlife.wechat.a.a.c.a(str, com.baidu.carlife.core.a.a().getCacheDir().getAbsolutePath(), paramString);
  }
  
  private void d(final d paramd)
  {
    if (paramd.i() == null)
    {
      e(paramd);
      return;
    }
    c.c local1 = new c.c()
    {
      public void a(com.baidu.carlife.wechat.a.a.a paramAnonymousa)
      {
        try
        {
          com.baidu.carlife.wechat.a.b.c.c("反geo：" + paramAnonymousa.b());
          paramAnonymousa = new JSONObject(paramAnonymousa.b());
          if (paramAnonymousa.getInt("status") == 0)
          {
            paramAnonymousa = paramAnonymousa.getJSONObject("result").optString("sematic_description");
            if (!TextUtils.isEmpty(paramAnonymousa))
            {
              paramAnonymousa = paramAnonymousa.replaceAll("附近([0-9]*)米", "");
              paramd.i().a(paramAnonymousa);
            }
          }
          k.a(k.this, paramd);
          return;
        }
        catch (Exception paramAnonymousa)
        {
          for (;;)
          {
            paramAnonymousa.printStackTrace();
          }
        }
      }
      
      public void a(Exception paramAnonymousException)
      {
        k.a(k.this, paramd);
      }
    };
    com.baidu.carlife.wechat.a.a.c.a(com.baidu.carlife.wechat.e.a.a(paramd.i().b(), paramd.i().c()), local1);
  }
  
  private List<d> e(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (TextUtils.equals(locald.e(), paramString)) {
        localArrayList.add(locald);
      }
    }
    return localArrayList;
  }
  
  private void e(d paramd)
  {
    paramd.a(1);
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject;
    if (paramd.g().k())
    {
      localObject = paramd.g().d(paramd.m());
      if (localObject != null)
      {
        localObject = ((g)localObject).c();
        localStringBuffer.append("群消息，收到" + (String)localObject);
      }
    }
    while (paramd.i() != null)
    {
      localStringBuffer.append("分享的地理位置，请说开始导航或取消");
      com.baidu.carlife.wechat.f.b.d().c(paramd, localStringBuffer.toString());
      paramd.a(d.a.c);
      com.baidu.carlife.wechat.c.a.a().a(paramd);
      return;
      localStringBuffer.append("群消息，收到一条");
      continue;
      localStringBuffer.append("收到" + paramd.g().b());
    }
    if (paramd.h() != null)
    {
      localStringBuffer.append("分享的音乐，请说播放音乐或取消");
      com.baidu.carlife.wechat.f.b.d().b(paramd, localStringBuffer.toString());
      paramd.a(d.a.a);
      com.baidu.carlife.wechat.c.a.a().a(paramd);
      return;
    }
    localStringBuffer.append("发来的");
    if (paramd.b() == 34) {
      localStringBuffer.append("语音");
    }
    localStringBuffer.append("消息");
    if (com.baidu.carlife.wechat.g.b.c())
    {
      if (paramd.b() == 34) {
        a(localStringBuffer.toString(), paramd);
      }
      for (;;)
      {
        paramd.a(d.a.b);
        com.baidu.carlife.wechat.c.a.a().a(paramd);
        return;
        localObject = paramd.f().replace("<br/>", "");
        a(paramd, localStringBuffer.toString() + (String)localObject);
      }
    }
    localStringBuffer.append("，请说播报或取消");
    com.baidu.carlife.wechat.f.b.d().a(paramd, localStringBuffer.toString());
    paramd.a(d.a.a);
    com.baidu.carlife.wechat.c.a.a().a(paramd);
  }
  
  private boolean f(d paramd)
  {
    if (paramd.g() == null)
    {
      com.baidu.carlife.wechat.a.b.c.e("联系人信息为空默认不播报");
      return false;
    }
    if (com.baidu.carlife.wechat.g.b.a())
    {
      com.baidu.carlife.wechat.a.b.c.e("静音设置为true，所有消息不播报");
      return false;
    }
    if ((com.baidu.carlife.wechat.g.b.b()) && (paramd.g().k()))
    {
      com.baidu.carlife.wechat.a.b.c.e("屏蔽群消息设置为true，所有群消息不播报");
      return false;
    }
    String str2 = paramd.g().g();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramd.g().b();
    }
    if (com.baidu.carlife.wechat.g.b.d().contains(str1))
    {
      com.baidu.carlife.wechat.a.b.c.e("私密好友消息，不播报");
      return false;
    }
    if ((paramd.g().k()) && (paramd.g().f() == 0))
    {
      com.baidu.carlife.wechat.a.b.c.e("手机端设置免打扰的群聊，默认不播报");
      return false;
    }
    if ((paramd.h() == null) && (paramd.i() == null) && (paramd.b() != 34) && (paramd.b() != 1))
    {
      com.baidu.carlife.wechat.a.b.c.e("非 音乐、位置、语音、文字消息，默认不播报");
      return false;
    }
    if (n.a().l())
    {
      com.baidu.carlife.wechat.a.b.c.e("正在语音场景中，不播报微信消息");
      return false;
    }
    if (com.baidu.carlife.logic.k.a().c() != 0)
    {
      com.baidu.carlife.wechat.a.b.c.e("正在电话场景中，不播报微信消息");
      return false;
    }
    return true;
  }
  
  private void i()
  {
    for (;;)
    {
      try
      {
        com.baidu.carlife.wechat.a.b.c.c("isReplying = " + this.i + " ; isPlaying = " + this.h);
        boolean bool = this.i;
        if (bool) {
          return;
        }
        if (this.h) {
          continue;
        }
        com.baidu.carlife.wechat.a.b.c.c("play unread msgs count = " + this.e.size());
        com.baidu.carlife.wechat.a.b.c.c("play unread room msgs count = " + this.f.size());
        if (this.e.size() > 0)
        {
          this.h = true;
          d((d)this.e.poll());
          continue;
        }
        if (this.f.size() <= 0) {
          break label202;
        }
      }
      finally {}
      this.h = true;
      d((d)this.f.poll());
      continue;
      label202:
      this.h = false;
      com.baidu.carlife.view.g.e().g();
    }
  }
  
  public void a(com.baidu.carlife.core.screen.presentation.a.d paramd)
  {
    this.k = paramd;
  }
  
  public void a(d paramd)
  {
    String str = paramd.g().a();
    if (this.c.containsKey(str)) {
      ((a)this.c.get(str)).a(paramd.k());
    }
    for (;;)
    {
      paramd = this.l.iterator();
      while (paramd.hasNext()) {
        ((b)paramd.next()).a();
      }
      paramd = new a(paramd.g(), paramd.k());
      this.c.put(str, paramd);
    }
  }
  
  public void a(b paramb)
  {
    if (!this.l.contains(paramb)) {
      this.l.add(paramb);
    }
  }
  
  public void a(String paramString)
  {
    this.d.add(paramString);
  }
  
  public void a(List<a> paramList)
  {
    this.c.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      this.c.put(locala.a().a(), locala);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public b b(String paramString)
  {
    if (this.c.containsKey(paramString)) {
      return ((a)this.c.get(paramString)).a();
    }
    return null;
  }
  
  public List<String> b()
  {
    return this.d;
  }
  
  public void b(d paramd)
  {
    this.b.add(paramd);
    a(paramd);
  }
  
  public void b(b paramb)
  {
    this.l.remove(paramb);
  }
  
  public void b(List<b> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (this.c.containsKey(localb.a()))
      {
        ((a)this.c.get(localb.a())).a(localb);
      }
      else
      {
        a locala = new a(localb, System.currentTimeMillis() / 1000L);
        this.c.put(localb.a(), locala);
      }
    }
  }
  
  public List<a> c()
  {
    return new ArrayList(this.c.values());
  }
  
  public List<d> c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (TextUtils.equals(locald.d(), paramString))
      {
        locald.a(1);
        localArrayList.add(locald);
      }
    }
    localArrayList.addAll(e(paramString));
    return localArrayList;
  }
  
  public void c(d paramd)
  {
    if (paramd.i() != null)
    {
      a(paramd.i());
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public void run()
        {
          com.baidu.carlife.wechat.f.b.d().c();
        }
      }, 2000L);
      return;
    }
    if (paramd.h() != null)
    {
      a(paramd.h());
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public void run()
        {
          com.baidu.carlife.wechat.f.b.d().c();
        }
      }, 2000L);
      return;
    }
    if (paramd.b() == 34)
    {
      a(null, paramd);
      return;
    }
    a(paramd, paramd.f().replace("<br/>", ""));
  }
  
  public void c(List<d> paramList)
  {
    if (paramList == null) {}
    d locald;
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          locald = (d)localIterator.next();
          if ((locald.g() != null) && (locald.o()))
          {
            if (c.a().a(locald.e())) {
              break label75;
            }
            b(locald);
          }
        }
        this.a.add(locald);
      }
      finally {}
    }
    label75:
    a(locald);
    label126:
    StringBuilder localStringBuilder;
    if (f(locald))
    {
      if (locald.g().a().startsWith("@@"))
      {
        this.f.offer(locald);
        i();
      }
    }
    else
    {
      if (!locald.g().a().startsWith("@@")) {
        break label262;
      }
      com.baidu.carlife.wechat.a.b.c.c("群消息：type=" + locald.b() + "," + locald.g().b());
      paramList = locald.g().d(locald.m());
      localStringBuilder = new StringBuilder();
      if (paramList == null) {
        break label321;
      }
    }
    label262:
    label321:
    for (paramList = paramList.c();; paramList = "")
    {
      com.baidu.carlife.wechat.a.b.c.c(paramList + ":" + locald.f());
      break;
      this.e.offer(locald);
      break label126;
      com.baidu.carlife.wechat.a.b.c.c("新消息：type=" + locald.b() + "," + locald.g().b() + " >> " + locald.f());
      break;
    }
  }
  
  public int d()
  {
    int m = 0;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((d)localIterator.next()).l() == 0) {
        m += 1;
      }
    }
    return m;
  }
  
  public int d(String paramString)
  {
    int m = 0;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if ((TextUtils.equals(paramString, locald.d())) && (locald.l() == 0)) {
        m += 1;
      }
    }
    return m;
  }
  
  public void e()
  {
    this.d = new ArrayList();
    this.c = new HashMap();
    this.e = new LinkedList();
    this.f = new LinkedList();
    this.a = new ArrayList();
    this.b = new ArrayList();
    this.h = false;
    this.i = false;
    if (this.g != null) {}
    try
    {
      this.g.release();
      this.g = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void f()
  {
    this.h = false;
    this.i = false;
    this.j = false;
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a();
    }
    g();
    i();
  }
  
  public void g()
  {
    if ((this.g != null) && (this.g.isPlaying())) {}
    try
    {
      this.g.stop();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean h()
  {
    return this.j;
  }
  
  private static class a
  {
    public static final k a = new k(null);
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */