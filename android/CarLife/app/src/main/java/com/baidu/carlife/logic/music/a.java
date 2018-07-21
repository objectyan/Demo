package com.baidu.carlife.logic.music;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.k.a.e.a;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.model.o;
import com.baidu.carlife.platform.model.CLAlbum;
import com.baidu.carlife.util.p;
import com.baidu.carlife.util.w;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
  implements e.a
{
  public static final String[] a = { "com.baidu.music.local", "com.tencent.qqmusic", "com.baidu.music.netease" };
  private static final String b = "CarLifeMusic";
  private static final String c = "appListData";
  private static final int[] i = { 2130838963, 2130838997, 2130838965 };
  private static final int[] j = { 0, 1, 2 };
  private com.baidu.carlife.k.q d;
  private a e;
  private HandlerThread f = new HandlerThread("CarLifeMusic");
  private Context g;
  private b h;
  private List<com.baidu.carlife.model.j> k = new ArrayList();
  private HashMap<String, b> l;
  private com.baidu.carlife.adpter.k m;
  private AdapterView.OnItemClickListener n;
  private int o = 0;
  private com.baidu.carlife.platform.b p = new com.baidu.carlife.platform.b()
  {
    public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousInt != 0)
      {
        com.baidu.carlife.core.i.e("CarLifeMusic", "---onGetSong---error:" + paramAnonymousInt + "---packageName:" + paramAnonymousString2);
        return;
      }
      paramAnonymousString1 = (s)h.b().b(paramAnonymousString2);
      if (paramAnonymousString1 == null)
      {
        com.baidu.carlife.core.i.e("CarLifeMusic", "---onGetSong--dataManager == Null----packageName:" + paramAnonymousString2);
        return;
      }
      paramAnonymousString1.a(paramAnonymousString3, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousBoolean);
    }
    
    public void a(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, List<MusicSongModel> paramAnonymousList, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      paramAnonymousString1 = (s)h.b().b(paramAnonymousString2);
      if (paramAnonymousString1 == null)
      {
        w.a("非法第三方音乐,不能同步", 1);
        return;
      }
      Object localObject = paramAnonymousString1.r();
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        paramAnonymousString2 = ((com.baidu.carlife.model.i)((List)localObject).get(0)).c;
        localObject = ((com.baidu.carlife.model.i)((List)localObject).get(0)).a;
        if ((paramAnonymousString2 != null) && (paramAnonymousString2.equals(paramAnonymousString3)) && (localObject != null) && (((String)localObject).equals("下载听")))
        {
          paramAnonymousString1.a(paramAnonymousList, paramAnonymousString3, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
          return;
        }
      }
      com.baidu.carlife.core.i.b("CarLifePlatform", "--onGetSongList-pn:" + paramAnonymousInt2 + "-rn:" + paramAnonymousInt3 + "---total:" + paramAnonymousInt4);
      if (paramAnonymousInt1 != 0)
      {
        com.baidu.carlife.core.i.b("CarLifePlatform", "PlatformManager.onGetSongList() - FAIL");
        com.baidu.carlife.core.k.b(249, paramAnonymousString1.s());
        return;
      }
      com.baidu.carlife.core.i.b("CarLifePlatform", "PlatformManager.onGetSongList() - OK");
      paramAnonymousString1.a(paramAnonymousList, paramAnonymousString3, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
    }
    
    public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, List<CLAlbum> paramAnonymousList)
    {
      paramAnonymousString1 = (s)h.b().b(paramAnonymousString2);
      if (paramAnonymousString1 == null) {
        return;
      }
      if ((paramAnonymousInt == 0) && (paramAnonymousList != null) && (paramAnonymousList.size() > 0))
      {
        com.baidu.carlife.core.i.b("CarLifePlatform", "PlatformManager.onGetAlbumList() --OK-");
        paramAnonymousString1.a(paramAnonymousList);
        return;
      }
      com.baidu.carlife.core.k.a(248, paramAnonymousString1.s(), 1000);
      switch (paramAnonymousString1.s())
      {
      default: 
        return;
      case 3: 
        StatisticManager.onEvent("MUSIC_XMLY_0010", "同步成功但网络失败");
        return;
      case 4: 
        StatisticManager.onEvent("MUSIC_KAOLA_0010", "同步成功但网络失败");
        return;
      }
      StatisticManager.onEvent("MUSIC_CYB_0010", "同步成功但网络失败");
    }
    
    public void a(String paramAnonymousString)
    {
      com.baidu.carlife.core.k.a(412, paramAnonymousString);
    }
    
    public void b(String paramAnonymousString)
    {
      StatisticManager.onEvent("1035", paramAnonymousString);
      a.a(a.this).sendMessage(Message.obtain(a.a(a.this), 422, paramAnonymousString));
    }
  };
  
  protected a()
  {
    this.f.start();
    this.e = new a(this.f.getLooper());
    com.baidu.carlife.core.k.a(this.e);
  }
  
  private b a(int paramInt, String paramString)
  {
    s locals = null;
    switch (paramInt)
    {
    default: 
      if (paramInt >= 3) {
        locals = new s(this.g, paramInt, paramString);
      }
      return locals;
    case 0: 
      return new e(this.g);
    case 1: 
      return new q(this.g, j[1], a[1]);
    }
    return new l(this.g);
  }
  
  public static List<com.baidu.carlife.model.j> a(String paramString)
  {
    for (;;)
    {
      int i1;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        if (localJSONArray != null)
        {
          int i2 = localJSONArray.length();
          if (i2 >= 1)
          {
            ArrayList localArrayList = new ArrayList();
            i1 = 0;
            paramString = localArrayList;
            if (i1 >= i2) {
              break label182;
            }
            paramString = localJSONArray.optJSONObject(i1);
            if (paramString == null) {
              break label184;
            }
            com.baidu.carlife.model.j localj = new com.baidu.carlife.model.j();
            localj.i = paramString.optString("sdk_address");
            localj.h = paramString.optString("appid");
            localj.g = paramString.optInt("app_type");
            localj.k = paramString.optString("app_description");
            localj.m = paramString.optString("sdk_name");
            localj.n = paramString.optString("akey");
            localj.l = paramString.optString("app_name");
            localj.j = paramString.optString("app_icon_address");
            localj.c = (i1 + 3);
            localArrayList.add(localj);
          }
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      paramString = null;
      label182:
      return paramString;
      label184:
      i1 += 1;
    }
  }
  
  private void a(com.baidu.carlife.model.j paramj)
  {
    if (this.k != null)
    {
      this.k.add(paramj);
      b(paramj.c, paramj.m);
    }
  }
  
  private void a(List<com.baidu.carlife.model.j> paramList)
  {
    Object localObject = this.g.getResources().getStringArray(2131230732);
    int i1 = 0;
    while (i1 < localObject.length)
    {
      a(new com.baidu.carlife.model.j(localObject[i1], i[i1], j[i1], a[i1]));
      i1 += 1;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.baidu.carlife.model.j localj = (com.baidu.carlife.model.j)((Iterator)localObject).next();
        b(localj.c, localj.m);
      }
      this.k.addAll(paramList);
    }
    t.a().a(this.k);
    try
    {
      b(e(p.a().a("LastestPlaySource", a[0])));
      return;
    }
    catch (ClassCastException paramList)
    {
      p.a().c("LastestPlaySource");
      b(0);
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    paramString = a(paramInt, paramString);
    if (paramString != null) {
      this.l.put(paramString.q(), paramString);
    }
  }
  
  private void b(List<com.baidu.carlife.model.j> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    ArrayList localArrayList = new ArrayList(this.k.subList(0, 3));
    int i1 = 0;
    int i2;
    if (i1 < ((List)localObject).size())
    {
      int i4 = 0;
      i2 = 3;
      label54:
      int i3 = i4;
      if (i2 < this.k.size())
      {
        if (((com.baidu.carlife.model.j)((List)localObject).get(i1)).equals(this.k.get(i2))) {
          i3 = 1;
        }
      }
      else
      {
        if (i3 == 0) {
          break label177;
        }
        localArrayList.add(new com.baidu.carlife.model.j((o)this.k.get(i2), i1 + 3));
        b(((com.baidu.carlife.model.j)this.k.get(i2)).m).F = (i1 + 3);
      }
      for (;;)
      {
        i1 += 1;
        break;
        i2 += 1;
        break label54;
        label177:
        localArrayList.add(new com.baidu.carlife.model.j((o)((List)localObject).get(i1), i1 + 3));
        b(i1 + 3, ((com.baidu.carlife.model.j)((List)localObject).get(i1)).m);
      }
    }
    localObject = (com.baidu.carlife.model.j)this.k.get(f());
    Iterator localIterator1;
    if ((j() > 0) && (j() < this.k.size()))
    {
      paramList = (com.baidu.carlife.model.j)this.k.get(j());
      localIterator1 = this.k.iterator();
    }
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label500;
      }
      com.baidu.carlife.model.j localj = (com.baidu.carlife.model.j)localIterator1.next();
      i2 = 0;
      Iterator localIterator2 = localArrayList.iterator();
      do
      {
        i1 = i2;
        if (!localIterator2.hasNext()) {
          break;
        }
      } while (!localj.equals((com.baidu.carlife.model.j)localIterator2.next()));
      i1 = 1;
      if (i1 != 0)
      {
        if (localj.equals(localObject)) {
          this.o = b(localj.m).F;
        }
        if (!localj.equals(paramList)) {
          continue;
        }
        g(b(localj.m).F);
        p.a().b("LastestPlaySource", localj.m);
        continue;
        paramList = null;
        break;
      }
      if (localj.equals(paramList))
      {
        this.h.a(true);
        h();
      }
      if ((localj.equals(localObject)) && (!localj.equals(paramList))) {
        h();
      }
      d(localj.m);
    }
    label500:
    if (!com.baidu.carlife.util.a.a())
    {
      i1 = 0;
      if (i1 < localArrayList.size())
      {
        if ("com.ximalaya.ting.android".equalsIgnoreCase(((com.baidu.carlife.model.j)localArrayList.get(i1)).m)) {
          ((com.baidu.carlife.model.j)localArrayList.get(i1)).l = "XimalayaFM";
        }
        for (;;)
        {
          i1 += 1;
          break;
          if ("com.itings.myradio".equalsIgnoreCase(((com.baidu.carlife.model.j)localArrayList.get(i1)).m)) {
            ((com.baidu.carlife.model.j)localArrayList.get(i1)).l = "Kaola FM";
          } else if ("com.shinyv.cnr".equalsIgnoreCase(((com.baidu.carlife.model.j)localArrayList.get(i1)).m)) {
            ((com.baidu.carlife.model.j)localArrayList.get(i1)).l = "China Radio";
          }
        }
      }
    }
    this.k.clear();
    this.k.addAll(localArrayList);
    b(f());
    t.a().a(this.k);
  }
  
  private void d(String paramString)
  {
    b localb = b(paramString);
    if (f(localb.s()))
    {
      this.h.a(true);
      g(-1);
    }
    localb.y();
    this.l.remove(paramString);
  }
  
  private int e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return -1;
      paramString = b(paramString);
    } while (paramString == null);
    return paramString.s();
  }
  
  private boolean f(int paramInt)
  {
    return j() == paramInt;
  }
  
  private void g(int paramInt)
  {
    this.h.a(paramInt);
  }
  
  private int j()
  {
    return this.h.a();
  }
  
  protected b a(int paramInt)
  {
    if (!h.i(paramInt)) {}
    com.baidu.carlife.model.j localj;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return null;
        localIterator = this.k.iterator();
      }
      localj = (com.baidu.carlife.model.j)localIterator.next();
    } while (paramInt != localj.c);
    return b(localj.m);
  }
  
  protected void a()
  {
    Iterator localIterator = this.l.keySet().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)this.l.get(localIterator.next());
      if ((!f(localb.s())) && (localb.s() != 0))
      {
        localb.a(0);
        localb.e(null);
      }
    }
  }
  
  public void a(Context paramContext, b paramb)
  {
    this.g = paramContext;
    this.h = paramb;
    this.l = new HashMap();
    this.m = new com.baidu.carlife.adpter.k(this.g, this.k);
    this.n = new j(this.g);
    com.baidu.carlife.platform.c.a().a(this.g, this.p);
    this.d = new com.baidu.carlife.k.q(this.g);
    this.d.registerResponseListener(this);
    this.e.post(new Runnable()
    {
      public void run()
      {
        String str = com.baidu.carlife.core.e.g("appListData");
        com.baidu.carlife.core.i.b("CarLifeMusic", "----getLocalData---" + str);
        a.a(a.this, a.a(str));
        a.b(a.this).toGetRequest();
      }
    });
  }
  
  protected b b()
  {
    b localb = b(e(f()));
    if (localb != null) {
      return localb;
    }
    if (this.l.isEmpty()) {
      this.l.put(a[0], new e(this.g));
    }
    return b(a[0]);
  }
  
  protected b b(String paramString)
  {
    return (b)this.l.get(paramString);
  }
  
  protected void b(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    c(i1);
    j.a(i1);
    e();
  }
  
  protected com.baidu.carlife.adpter.k c()
  {
    return this.m;
  }
  
  protected String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    com.baidu.carlife.model.j localj;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return null;
        localIterator = this.k.iterator();
      }
      localj = (com.baidu.carlife.model.j)localIterator.next();
    } while ((TextUtils.isEmpty(localj.m)) || (!localj.m.equalsIgnoreCase(paramString)));
    return localj.l;
  }
  
  protected void c(int paramInt)
  {
    if (this.k != null)
    {
      if ((this.o < 0) || (this.o >= this.k.size())) {
        break label90;
      }
      ((com.baidu.carlife.model.j)this.k.get(this.o)).a = false;
    }
    for (;;)
    {
      if ((paramInt >= 0) && (paramInt < this.k.size()))
      {
        ((com.baidu.carlife.model.j)this.k.get(paramInt)).a = true;
        this.o = paramInt;
      }
      return;
      label90:
      this.o = 0;
    }
  }
  
  protected AdapterView.OnItemClickListener d()
  {
    return this.n;
  }
  
  protected com.baidu.carlife.model.j d(int paramInt)
  {
    try
    {
      com.baidu.carlife.model.j localj = (com.baidu.carlife.model.j)this.k.get(paramInt);
      return localj;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
    return null;
  }
  
  protected String e(int paramInt)
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      com.baidu.carlife.model.j localj = (com.baidu.carlife.model.j)localIterator.next();
      if (paramInt == localj.c) {
        return localj.m;
      }
    }
    return null;
  }
  
  protected void e()
  {
    if ((this.m != null) && (BaseFragment.getNaviActivity() != null)) {
      BaseFragment.getNaviActivity().runOnUiThread(new Runnable()
      {
        public void run()
        {
          a.c(a.this).notifyDataSetChanged();
        }
      });
    }
  }
  
  protected int f()
  {
    return this.o;
  }
  
  protected void g()
  {
    b(0);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("music_type_changed", true);
    Object localObject = com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager();
    int i1 = ((NaviFragmentManager)localObject).getCurrentFragmentType();
    if (i1 == 745) {
      ((NaviFragmentManager)localObject).showFragment(737, localBundle);
    }
    do
    {
      do
      {
        return;
        if (i1 != 737) {
          break;
        }
      } while ((((NaviFragmentManager)localObject).getCurrentFragment() == null) || (((NaviFragmentManager)localObject).getCurrentFragment().getArguments() == null));
      ((NaviFragmentManager)localObject).getCurrentFragment().getArguments().putBundle("show_bundle", localBundle);
      ((NaviFragmentManager)localObject).getCurrentFragment().onStart();
      return;
      localObject = ((NaviFragmentManager)localObject).getLatestFragment(737);
    } while (((ContentFragment)localObject).getArguments() == null);
    ((ContentFragment)localObject).getArguments().putBundle("show_bundle", localBundle);
    ((ContentFragment)localObject).onStart();
  }
  
  protected void h()
  {
    b(2);
    Object localObject = com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("music_type_changed", true);
    int i1 = ((NaviFragmentManager)localObject).getCurrentFragmentType();
    if (i1 == 745) {
      if ((((NaviFragmentManager)localObject).getCurrentFragment() != null) && (((NaviFragmentManager)localObject).getCurrentFragment().getArguments() != null))
      {
        ((NaviFragmentManager)localObject).getCurrentFragment().getArguments().putBundle("show_bundle", localBundle);
        ((NaviFragmentManager)localObject).getCurrentFragment().onStart();
      }
    }
    do
    {
      return;
      if (i1 == 737)
      {
        ((NaviFragmentManager)localObject).showFragment(745, localBundle);
        return;
      }
      localObject = ((NaviFragmentManager)localObject).getLatestFragment(745);
    } while ((localObject == null) || (((ContentFragment)localObject).getArguments() == null));
    ((ContentFragment)localObject).getArguments().putBundle("show_bundle", localBundle);
    ((ContentFragment)localObject).onStart();
    b().a(0);
  }
  
  protected void i()
  {
    b(2);
    Object localObject = com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager();
    Bundle localBundle = new Bundle();
    localBundle.putString("album_id", "TEMPLIST_ID");
    int i1 = ((NaviFragmentManager)localObject).getCurrentFragmentType();
    if (i1 == 745) {
      ((NaviFragmentManager)localObject).showFragment(737, localBundle);
    }
    do
    {
      do
      {
        return;
        if (i1 != 737) {
          break;
        }
      } while ((((NaviFragmentManager)localObject).getCurrentFragment() == null) || (((NaviFragmentManager)localObject).getCurrentFragment().getArguments() == null));
      ((NaviFragmentManager)localObject).getCurrentFragment().getArguments().putBundle("show_bundle", localBundle);
      ((NaviFragmentManager)localObject).getCurrentFragment().onStart();
      return;
      localObject = ((NaviFragmentManager)localObject).getLatestFragment(737);
    } while (((ContentFragment)localObject).getArguments() == null);
    ((ContentFragment)localObject).getArguments().putBundle("show_bundle", localBundle);
    ((ContentFragment)localObject).onStart();
  }
  
  public void onNetWorkResponse(int paramInt)
  {
    switch (paramInt)
    {
    case -2: 
    case -1: 
    default: 
    case 0: 
      String str;
      do
      {
        return;
        com.baidu.carlife.core.i.b("ouyang", "------RESPONSE_SUCCESS------");
        str = this.d.b();
      } while ((TextUtils.isEmpty(str)) || (str.equals(com.baidu.carlife.core.e.g("appListData"))));
      com.baidu.carlife.core.i.b("ouyang", "------RESPONSE_SUCCESS---1---");
      b(this.d.a());
      com.baidu.carlife.core.e.c("appListData", str);
      return;
    }
    b(null);
    com.baidu.carlife.core.e.c("appListData", "");
  }
  
  private class a
    extends com.baidu.carlife.core.j
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void careAbout() {}
    
    public void handleMessage(final Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        if (!com.baidu.carlife.core.c.a().e()) {
          break;
        }
        paramMessage = (String)paramMessage.obj;
      } while ((a.this.b(paramMessage) == null) || (BaseFragment.getNaviActivity() == null));
      BaseFragment.getNaviActivity().runOnUiThread(new Runnable()
      {
        public void run()
        {
          a.this.b(paramMessage).j();
        }
      });
      return;
      sendMessageDelayed(Message.obtain(paramMessage), 300L);
    }
  }
  
  public static abstract interface b
  {
    public abstract int a();
    
    public abstract void a(int paramInt);
    
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */