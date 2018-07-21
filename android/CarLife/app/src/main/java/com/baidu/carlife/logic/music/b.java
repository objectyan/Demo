package com.baidu.carlife.logic.music;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.navi.fragment.BaseFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class b
{
  protected static boolean R = false;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 1;
  public static final int e = 2;
  public static final String f = "album_type";
  public static final String g = "album_name";
  public static final String h = "album_id";
  public static final String i = "music_type_changed";
  public static final String j = "music_playing_icon";
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 3;
  public static final int o = 4;
  public static final int p = 5;
  public static final int q = 6;
  public static final int r = 7;
  public static final int s = -1;
  public static final int t = -101;
  public static final int u = 110;
  protected String A = null;
  protected int B = 0;
  protected Context C;
  protected MusicSongModel D = null;
  protected String E = null;
  protected int F = 0;
  protected c G;
  protected a H;
  protected List<com.baidu.carlife.model.i> I = null;
  protected List<com.baidu.carlife.model.i> J = null;
  protected String K;
  protected String L;
  protected boolean M = false;
  protected int N = 0;
  protected String O;
  protected String P;
  protected boolean Q = false;
  protected ArrayList<String> S = new ArrayList();
  private int T = 0;
  private int U = 1;
  private boolean V;
  public final String a = "CarLifeMusic";
  protected int v = 2;
  protected int w = 2;
  protected HashMap<String, List<MusicSongModel>> x = null;
  protected String y = null;
  protected String z = null;
  
  private void b(a parama)
  {
    this.H = parama;
  }
  
  private void b(c paramc)
  {
    this.G = paramc;
  }
  
  private void l(int paramInt)
  {
    this.U = paramInt;
  }
  
  private String m(int paramInt)
  {
    try
    {
      String str = ((com.baidu.carlife.model.i)r().get(paramInt)).c;
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private int z()
  {
    return h.b().g();
  }
  
  public abstract int a(int paramInt, String paramString);
  
  protected void a()
  {
    if (z() != s()) {}
    do
    {
      do
      {
        return;
        if (v() != 0) {
          break;
        }
      } while (this.H == null);
      this.H.b(x());
      return;
    } while ((v() != 1) || (this.G == null));
    this.G.a(x());
  }
  
  protected void a(int paramInt)
  {
    this.T = paramInt;
  }
  
  protected void a(int paramInt, List<com.baidu.carlife.model.i> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      if (paramInt == 2)
      {
        this.J.addAll(paramList);
        return;
      }
    } while (paramInt != 1);
    this.I.addAll(paramList);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      String str;
      do
      {
        do
        {
          return;
          paramBundle = paramBundle.getBundle("show_bundle");
          if (paramBundle != null) {
            break;
          }
        } while (R);
        R = true;
        b();
        return;
        if (!paramBundle.containsKey("album_id")) {
          break;
        }
        str = paramBundle.getString("album_id");
      } while (str == null);
      if (str.equals("TEMPLIST_ID")) {
        b();
      }
      for (;;)
      {
        paramBundle.remove("album_id");
        return;
        if (!g(str))
        {
          h.b().f(true);
          e();
          a(w(), str);
        }
        else if (!str.equals(n()))
        {
          e(str);
          f(0);
          b();
        }
      }
      if (paramBundle.getBoolean("music_type_changed", false))
      {
        b();
        paramBundle.remove("music_type_changed");
        return;
      }
    } while (!paramBundle.getBoolean("music_playing_icon", false));
    b(n());
    paramBundle.remove("music_playing_icon");
  }
  
  public void a(Pair<String, List<MusicSongModel>> paramPair)
  {
    boolean bool = g((String)paramPair.first);
    a((String)paramPair.first, (List)paramPair.second);
    b((String)paramPair.first);
    if (!bool)
    {
      f(0);
      b();
    }
  }
  
  public void a(a parama)
  {
    b(parama);
    a(0);
    a();
    if (x() == 2) {
      j();
    }
  }
  
  public void a(c paramc)
  {
    b(paramc);
    a(1);
    a();
  }
  
  public void a(MusicSongModel paramMusicSongModel)
  {
    List localList = f(n());
    if ((localList == null) || (localList.isEmpty()) || (paramMusicSongModel == null)) {}
    MusicSongModel localMusicSongModel;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = localList.iterator();
      }
      localMusicSongModel = (MusicSongModel)localIterator.next();
    } while (!paramMusicSongModel.equals(localMusicSongModel));
    localList.remove(localMusicSongModel);
    f(m() - 1);
    b(n());
  }
  
  protected void a(String paramString)
  {
    this.z = paramString;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void a(String paramString, List<MusicSongModel> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {}
    do
    {
      return;
      if (!g(paramString)) {
        break;
      }
    } while (f(paramString) == null);
    f(paramString).addAll(paramList);
    return;
    this.x.put(paramString, paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.V = paramBoolean;
  }
  
  protected void b()
  {
    if (this.G != null)
    {
      i(2);
      this.G.b();
    }
  }
  
  protected void b(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void b(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = paramBundle.getBundle("show_bundle");
    } while (localBundle == null);
    if ((localBundle.getBoolean("music_type_changed", false)) && (x() == 1) && (s() != 1)) {
      b(false);
    }
    localBundle.putBoolean("music_type_changed", false);
    paramBundle.putBundle("show_bundle", localBundle);
  }
  
  protected void b(String paramString)
  {
    if (this.G != null) {
      this.G.a(paramString);
    }
  }
  
  public void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.K = paramString1;
    this.L = paramString2;
    this.M = paramBoolean;
    this.N = 0;
  }
  
  public abstract void b(boolean paramBoolean);
  
  protected void c()
  {
    if (v() == 0) {
      if (this.H != null) {
        this.H.a();
      }
    }
    while ((v() != 1) || (this.G == null)) {
      return;
    }
    this.G.a();
  }
  
  protected void c(int paramInt)
  {
    int i1 = 1;
    if (((this.v == 1) || (this.v == 7)) && (paramInt == 2) && (this.F >= 3)) {
      if (Build.VERSION.SDK_INT < 23) {
        break label68;
      }
    }
    for (;;)
    {
      if (i1 != 0)
      {
        Intent localIntent = new Intent("com.baidu.carlife.Action.StartActivityBroadReceiver");
        BaseFragment.getNaviActivity().sendBroadcast(localIntent);
      }
      this.v = paramInt;
      return;
      label68:
      i1 = 0;
    }
  }
  
  protected void c(String paramString)
  {
    Object localObject1 = this.C.getPackageManager();
    do
    {
      try
      {
        localObject2 = ((PackageManager)localObject1).getPackageInfo(paramString, 0);
        Intent localIntent = new Intent("android.intent.action.MAIN", null);
        localIntent.addCategory("android.intent.category.LAUNCHER");
        localIntent.setPackage(((PackageInfo)localObject2).packageName);
        localObject1 = ((PackageManager)localObject1).queryIntentActivities(localIntent, 0);
        if (!((List)localObject1).iterator().hasNext())
        {
          com.baidu.carlife.core.i.e("CarLifeMusic", "openApp " + paramString + " fail, can't find ResolveInfo");
          return;
        }
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      localObject1 = (ResolveInfo)((List)localObject1).iterator().next();
    } while (localObject1 == null);
    localObject1 = ((ResolveInfo)localObject1).activityInfo.name;
    Object localObject2 = new Intent("android.intent.action.MAIN");
    ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
    ((Intent)localObject2).setFlags(268435456);
    ((Intent)localObject2).setComponent(new ComponentName(paramString, (String)localObject1));
    try
    {
      BaseFragment.getNaviActivity().startActivity((Intent)localObject2);
      return;
    }
    catch (Exception paramString)
    {
      com.baidu.carlife.core.i.b("CarLifeMusic", "startActivity error:" + paramString.getMessage());
    }
  }
  
  public abstract Bitmap d(String paramString);
  
  protected void d()
  {
    if (v() == 0) {
      if (this.H != null) {
        this.H.b();
      }
    }
    while ((v() != 1) || (this.G == null)) {
      return;
    }
    this.G.c();
  }
  
  public abstract void d(int paramInt);
  
  protected void e()
  {
    if (this.G != null) {
      this.G.e();
    }
  }
  
  public void e(String paramString)
  {
    if (paramString == null) {
      this.y = null;
    }
    while (paramString.equals(this.y)) {
      return;
    }
    f(0);
    this.y = paramString;
  }
  
  public abstract boolean e(int paramInt);
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        break;
      }
      paramObject = (b)paramObject;
    } while ((!TextUtils.isEmpty(((b)paramObject).q())) && (((b)paramObject).q().equals(this.E)));
    return false;
  }
  
  public List<MusicSongModel> f(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.x == null) || (this.x.isEmpty())) {
      return null;
    }
    return (List)this.x.get(paramString);
  }
  
  public void f()
  {
    a(w(), n());
  }
  
  public void f(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    this.B = i1;
  }
  
  public abstract List<MusicSongModel> g();
  
  public List<com.baidu.carlife.model.i> g(int paramInt)
  {
    if (paramInt == 2) {
      return this.J;
    }
    if (paramInt == 1) {
      return this.I;
    }
    return null;
  }
  
  public boolean g(String paramString)
  {
    return this.x.get(paramString) != null;
  }
  
  public MusicSongModel h(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (g() == null)) {
      return null;
    }
    Iterator localIterator = g().iterator();
    while (localIterator.hasNext())
    {
      MusicSongModel localMusicSongModel = (MusicSongModel)localIterator.next();
      if (paramString.equals(localMusicSongModel.a)) {
        return localMusicSongModel;
      }
    }
    return null;
  }
  
  public abstract void h();
  
  public void h(int paramInt)
  {
    if ((r() == null) || (r().isEmpty())) {}
    Bundle localBundle;
    do
    {
      return;
      a(((com.baidu.carlife.model.i)r().get(paramInt)).a);
      String str = m(paramInt);
      localBundle = new Bundle();
      localBundle.putString("album_id", str);
      localBundle.putInt("album_type", w());
      if (s() > 100)
      {
        com.baidu.carlife.core.screen.presentation.h.a().showFragment(595, localBundle);
        return;
      }
    } while (s() <= 0);
    com.baidu.carlife.core.screen.presentation.h.a().showFragment(737, localBundle);
  }
  
  public void i(int paramInt)
  {
    b(paramInt);
    if ((z() == s()) && (this.G != null)) {
      this.G.a(x());
    }
  }
  
  public boolean i()
  {
    return this.V;
  }
  
  public boolean i(String paramString)
  {
    return true;
  }
  
  public void j()
  {
    d(w());
  }
  
  public void j(int paramInt)
  {
    c(paramInt);
    if ((z() == s()) && (this.H != null)) {
      this.H.b(x());
    }
  }
  
  public void j(String paramString) {}
  
  public int k()
  {
    return 1;
  }
  
  public void k(int paramInt)
  {
    l(paramInt);
    d(paramInt);
  }
  
  public void l()
  {
    this.K = this.O;
    this.L = this.P;
    this.M = this.Q;
    this.N = 0;
    if (this.M) {
      this.S.remove("TEMPLIST_ID");
    }
    while (this.S.contains("TEMPLIST_ID")) {
      return;
    }
    this.S.add("TEMPLIST_ID");
  }
  
  public int m()
  {
    return this.B;
  }
  
  public String n()
  {
    return this.y;
  }
  
  public String o()
  {
    return this.z;
  }
  
  public MusicSongModel p()
  {
    List localList = g();
    if ((localList != null) && (!localList.isEmpty())) {
      try
      {
        MusicSongModel localMusicSongModel = (MusicSongModel)localList.get(m());
        return localMusicSongModel;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        f(0);
        return (MusicSongModel)localList.get(m());
      }
    }
    return null;
  }
  
  public String q()
  {
    return this.E;
  }
  
  public List<com.baidu.carlife.model.i> r()
  {
    return g(w());
  }
  
  public int s()
  {
    return this.F;
  }
  
  public void t()
  {
    if (v() == 0) {
      if (this.H != null) {
        this.H.c();
      }
    }
    while (this.G == null) {
      return;
    }
    this.G.d();
  }
  
  public void u()
  {
    com.baidu.carlife.core.screen.presentation.h.a().showFragment(745, null);
  }
  
  public int v()
  {
    return this.T;
  }
  
  public int w()
  {
    return this.U;
  }
  
  public int x()
  {
    if (v() == 0) {
      return this.v;
    }
    return this.w;
  }
  
  public void y()
  {
    this.E = null;
    this.F = -1;
    this.S.clear();
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void a(String paramString);
    
    public abstract void b();
    
    public abstract void b(int paramInt);
    
    public abstract void c();
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void a(String paramString);
    
    public abstract void b();
    
    public abstract void c();
    
    public abstract void d();
    
    public abstract void e();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */