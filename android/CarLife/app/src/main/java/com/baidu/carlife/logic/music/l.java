package com.baidu.carlife.logic.music;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.util.w;
import com.baidu.navi.util.StatisticManager;
import com.netease.cloudmusic.utils.NeteaseMusicUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class l
  extends b
{
  private static final String T = "param=200y200&quality=70";
  private HandlerThread U = null;
  private j V = null;
  
  public l(Context paramContext)
  {
    this.C = paramContext;
    this.E = a.a[2];
    this.U = new HandlerThread(l.class.getSimpleName());
    this.U.start();
    this.V = new a(this.U.getLooper());
    k.a(this.V);
    this.F = 2;
    this.I = new ArrayList();
    this.J = new ArrayList();
  }
  
  public int a(int paramInt, String paramString)
  {
    e(paramString);
    if (e.a().r())
    {
      c();
      this.V.sendMessage(Message.obtain(this.V, 222, paramInt, -1, paramString));
    }
    for (;;)
    {
      return 1;
      i(3);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.O = paramString1;
    this.P = paramString2;
    if (paramBoolean)
    {
      this.V.sendMessage(Message.obtain(this.V, 1, 1, -1));
      return;
    }
    this.V.sendMessage(Message.obtain(this.V, 1, 0, -1));
  }
  
  public void b(boolean paramBoolean)
  {
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
    return e.a(paramString + "?" + "param=200y200&quality=70");
  }
  
  public void d(int paramInt)
  {
    if (e(paramInt))
    {
      if (this.H != null) {
        this.H.a(paramInt);
      }
      return;
    }
    if (e.a().r())
    {
      c();
      this.V.sendMessage(Message.obtain(this.V, 205, paramInt, -1));
      return;
    }
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
  
  public int k()
  {
    if (e.a().r())
    {
      this.V.sendMessage(Message.obtain(this.V, 2, 0, -1));
      return 0;
    }
    i(3);
    return 0;
  }
  
  private class a
    extends j
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void careAbout() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        switch (paramMessage.arg1)
        {
        }
        while (l.this.e(paramMessage.arg1))
        {
          k.b(206, paramMessage.arg1, l.this.s());
          return;
          l.this.a(1, NeteaseMusicUtils.getTopList());
          continue;
          l.this.a(2, NeteaseMusicUtils.getPlayList());
        }
        StatisticManager.onEvent("MUSIC_NETEASE_0005", "获取歌单失败");
        k.a(248, l.this.s(), 1000);
        return;
        String str = (String)paramMessage.obj;
        ArrayList localArrayList = null;
        if (l.this.x.containsKey(str)) {
          paramMessage = (List)l.this.x.get(str);
        }
        while ((paramMessage != null) && (paramMessage.size() > 0))
        {
          paramMessage = new Pair(str, paramMessage);
          k.a(218, l.this.s(), paramMessage);
          return;
          switch (paramMessage.arg1)
          {
          default: 
            paramMessage = localArrayList;
            break;
          case 1: 
            paramMessage = NeteaseMusicUtils.getToplistDetail(str);
            break;
          case 2: 
            paramMessage = NeteaseMusicUtils.getPlaylistDetail(str);
          }
        }
        if (str != null) {
          StatisticManager.onEvent("MUSIC_NETEASE_0005", "获取播放列表失败");
        }
        k.a(249, l.this.s(), 1000);
        return;
        localArrayList = new ArrayList();
        l.this.Q = NeteaseMusicUtils.getSearchMusicList(l.this.O, l.this.P, localArrayList, 0);
        if (paramMessage.arg1 == 0)
        {
          n.a().a(localArrayList, 2);
          return;
        }
        k.a(423, localArrayList);
        return;
        paramMessage = l.this.f("TEMPLIST_ID");
      } while ((paramMessage == null) || (paramMessage.isEmpty()));
      paramMessage = l.this;
      paramMessage.N += 1;
      paramMessage = new ArrayList();
      l.this.M = NeteaseMusicUtils.getSearchMusicList(l.this.K, l.this.L, paramMessage, l.this.N);
      if (!l.this.M) {
        l.this.j("TEMPLIST_ID");
      }
      paramMessage = new Pair("TEMPLIST_ID", paramMessage);
      k.a(218, l.this.s(), paramMessage);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */