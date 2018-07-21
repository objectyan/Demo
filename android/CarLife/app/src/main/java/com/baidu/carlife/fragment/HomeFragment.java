package com.baidu.carlife.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.k.a.e.a;
import com.baidu.carlife.k.a.h.a;
import com.baidu.carlife.k.a.h.b;
import com.baidu.carlife.k.a.h.c;
import com.baidu.carlife.k.u;
import com.baidu.carlife.logic.o;
import com.baidu.carlife.logic.q;
import com.baidu.carlife.logic.voice.m;
import com.baidu.carlife.radio.b.aa;
import com.baidu.carlife.radio.b.aa.a;
import com.baidu.carlife.radio.c.a.a;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.HomeCardMusicMelodyView;
import com.baidu.carlife.view.HomeCardView;
import com.baidu.carlife.view.MainTopBarView;
import com.baidu.che.codriver.protocol.d.a;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData.Result;
import com.baidu.che.codriver.protocol.data.nlp.RestrictionData;
import com.baidu.che.codriver.sdk.a.g.a;
import com.baidu.che.codriver.vr.m.c;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.controller.AccountController;
import com.baidu.navi.controller.AccountController.IAccountListener;
import com.baidu.navi.controller.UserCenterController;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class HomeFragment
  extends ContentFragment
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  public static String a = HomeFragment.class.getSimpleName();
  private static final int b = 99;
  private static final int c = 101;
  private boolean A = false;
  private com.baidu.carlife.view.dialog.d B;
  private com.baidu.carlife.adpter.g C;
  private HomeCardView d;
  private HomeCardView e;
  private HomeCardView f;
  private HomeCardView g;
  private HomeCardView h;
  private j i;
  private com.baidu.carlife.f.g j;
  private com.baidu.carlife.f.g k;
  private com.baidu.carlife.f.g l;
  private SimpleDraweeView m;
  private View n;
  private View o;
  private View p;
  private com.baidu.carlife.view.dialog.c q;
  private boolean r = false;
  private u s;
  private com.baidu.carlife.k.s t;
  private Drawable u;
  private String v;
  private String w;
  private e.a x = new e.a()
  {
    public void onNetWorkResponse(int paramAnonymousInt)
    {
      if ((paramAnonymousInt == 0) && (HomeFragment.this.isAdded()))
      {
        if (HomeFragment.a(HomeFragment.this) == null) {
          HomeFragment.b(HomeFragment.this);
        }
        com.baidu.carlife.model.r localr = HomeFragment.a(HomeFragment.this).a();
        HomeFragment.a(HomeFragment.this, localr.f, localr.a, localr.g);
      }
    }
  };
  private e.a y = new e.a()
  {
    public void onNetWorkResponse(int paramAnonymousInt)
    {
      final Object localObject2 = HomeFragment.c(HomeFragment.this).b();
      final Object localObject1 = HomeFragment.c(HomeFragment.this).a();
      String str2 = (String)localObject1 + "_1.png";
      Object localObject3 = BaseFragment.mActivity.getFilesDir().getAbsolutePath() + File.separator + str2;
      HomeFragment.a(HomeFragment.this, null);
      HomeFragment.a(HomeFragment.this, null);
      if (localObject2 == null) {
        if (f.jx.a().equals(localObject1))
        {
          HomeFragment.a(HomeFragment.this, com.baidu.carlife.util.p.a().a((String)localObject1 + "VehicleName", null));
          localObject1 = new File((String)localObject3);
          HomeFragment.a(HomeFragment.this, Drawable.createFromPath(((File)localObject1).getAbsolutePath()));
          HomeFragment.a(HomeFragment.this, HomeFragment.d(HomeFragment.this), HomeFragment.e(HomeFragment.this));
        }
      }
      while (!f.jx.a().equals(localObject1)) {
        return;
      }
      final String str1 = ((com.baidu.carlife.model.p)localObject2).c;
      HomeFragment.a(HomeFragment.this, ((com.baidu.carlife.model.p)localObject2).b);
      com.baidu.carlife.util.p.a().b((String)localObject1 + "VehicleName", HomeFragment.e(HomeFragment.this));
      localObject3 = new File((String)localObject3);
      if ((com.baidu.carlife.util.p.a().a((String)localObject1 + "TimeStamp", "").equals(str1)) && (((File)localObject3).exists()))
      {
        HomeFragment.a(HomeFragment.this, Drawable.createFromPath(((File)localObject3).getAbsolutePath()));
        HomeFragment.a(HomeFragment.this, HomeFragment.d(HomeFragment.this), HomeFragment.e(HomeFragment.this));
        return;
      }
      HomeFragment.a(HomeFragment.this, null, HomeFragment.e(HomeFragment.this));
      localObject2 = new com.baidu.carlife.k.a.h(HomeFragment.this.getContext(), ((com.baidu.carlife.model.p)localObject2).a, str2, BaseFragment.mActivity.getFilesDir().getAbsolutePath(), null, true, 0);
      ((com.baidu.carlife.k.a.h)localObject2).a(new h.c()
      {
        public void a(long paramAnonymous2Long, int paramAnonymous2Int) {}
        
        public void a(h.b paramAnonymous2b, h.a paramAnonymous2a)
        {
          if (h.b.e == paramAnonymous2b)
          {
            com.baidu.carlife.util.p.a().b(localObject1 + "TimeStamp", str1);
            if ((localObject2.b() != null) && (com.baidu.carlife.l.a.a().N()))
            {
              HomeFragment.a(HomeFragment.this, Drawable.createFromPath(localObject2.b().getAbsolutePath()));
              HomeFragment.a(HomeFragment.this, HomeFragment.d(HomeFragment.this), HomeFragment.e(HomeFragment.this));
            }
          }
        }
      });
      ((com.baidu.carlife.k.a.h)localObject2).e();
    }
  };
  private Random z = new Random();
  
  private Drawable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.contains("多云")) {
        return getResources().getDrawable(2130839455);
      }
      if (paramString.contains("晴")) {
        return getResources().getDrawable(2130839456);
      }
      if (paramString.contains("雨")) {
        return getResources().getDrawable(2130839458);
      }
      if (paramString.contains("雪")) {
        return getResources().getDrawable(2130839461);
      }
    } while (!paramString.contains("阴"));
    return getResources().getDrawable(2130839459);
  }
  
  private void a(int paramInt)
  {
    if ((com.baidu.carlife.logic.music.h.b().v()) && (paramInt == 101))
    {
      this.A = false;
      d();
      Object localObject = com.baidu.carlife.radio.c.b.a().c(com.baidu.carlife.logic.music.h.b().s().n());
      String str;
      if (localObject != null)
      {
        this.r = true;
        str = ((com.baidu.carlife.radio.a.a)localObject).b();
        localObject = str;
        if (!com.baidu.carlife.util.a.a())
        {
          if (!"每日随心".equals(str)) {
            break label112;
          }
          localObject = "Daily Audio";
        }
      }
      for (;;)
      {
        this.e.b((String)localObject);
        this.e.b(2130838243);
        this.e.c(2130838242);
        this.e.b();
        return;
        label112:
        if ("音乐".equals(str))
        {
          localObject = "Music";
        }
        else if ("儿童".equals(str))
        {
          localObject = "Children";
        }
        else if ("听书".equals(str))
        {
          localObject = "Audio Book";
        }
        else if ("电台".equals(str))
        {
          localObject = "Radio";
        }
        else if ("语音点播".equals(str))
        {
          localObject = "VOD";
        }
        else if ("情感".equals(str))
        {
          localObject = "Emotion";
        }
        else if ("学习".equals(str))
        {
          localObject = "Study";
        }
        else if ("新闻".equals(str))
        {
          localObject = "News";
        }
        else
        {
          localObject = str;
          if ("娱乐".equals(str)) {
            localObject = "Recreation";
          }
        }
      }
    }
    this.A = true;
    d();
    this.e.b(2130838245);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.u = getResources().getDrawable(paramInt1);
    this.v = getString(paramInt2);
    a(this.u, this.v);
    this.w = f.jx.a();
  }
  
  private void a(Drawable paramDrawable, String paramString)
  {
    if ((!isAdded()) || (this.g == null)) {
      return;
    }
    if (paramDrawable == null) {
      this.g.e(2130838574);
    }
    while (TextUtils.isEmpty(paramString)) {
      if (com.baidu.carlife.util.a.a())
      {
        this.g.f(2130838575);
        return;
        this.g.c(paramDrawable);
      }
      else
      {
        this.g.c("Baidu CarLife");
        return;
      }
    }
    this.g.c(paramString);
  }
  
  private void a(final RoutePlanNode paramRoutePlanNode)
  {
    if (BaiduNaviSDKManager.getInstance().isNaviBegin())
    {
      showDialog(new com.baidu.carlife.view.dialog.c(mActivity).a(2131296442).c(2131296264).d(2131296259).a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          HomeFragment.a(HomeFragment.this, paramRoutePlanNode);
        }
      }), BaseDialog.a.a);
      return;
    }
    b(paramRoutePlanNode);
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    i.b(a, "temperature = " + paramString1 + ", state = " + paramString2);
    if ((this.mContentView == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramString1.length() <= 1)) {}
    TextView localTextView;
    do
    {
      return;
      localTextView = (TextView)this.mContentView.findViewById(2131625595);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(a(paramString2), null, null, null);
      paramString1 = paramString1.trim();
    } while (com.baidu.carlife.core.e.e(paramString1));
    localTextView.setText(paramString1);
  }
  
  private void b()
  {
    this.d = ((HomeCardView)this.mContentView.findViewById(2131624707));
    this.e = ((HomeCardView)this.mContentView.findViewById(2131624710));
    this.f = ((HomeCardView)this.mContentView.findViewById(2131624893));
    this.g = ((HomeCardView)this.mContentView.findViewById(2131624895));
    this.h = ((HomeCardView)this.mContentView.findViewById(2131624898));
    this.m = ((SimpleDraweeView)this.mContentView.findViewById(2131624888));
    this.n = this.mContentView.findViewById(2131624887);
    this.o = this.mContentView.findViewById(2131624253);
    this.p = this.mContentView.findViewById(2131624897);
    a();
  }
  
  private void b(int paramInt)
  {
    if ((this.e == null) || (this.r)) {
      return;
    }
    if (paramInt > 0)
    {
      if (paramInt < 10000)
      {
        this.e.b(String.valueOf(paramInt) + getResources().getString(2131296552));
        return;
      }
      if (paramInt < 10000000)
      {
        paramInt /= 1000;
        if (paramInt % 10 == 0)
        {
          this.e.b(String.valueOf(a(paramInt / 10 * 10000)) + getResources().getString(2131296552));
          return;
        }
        this.e.b(String.valueOf(a(paramInt / 10.0D * 10000.0D)) + getResources().getString(2131296552));
        return;
      }
      this.e.b(getResources().getString(2131296554));
      return;
    }
    this.e.b("");
  }
  
  private void b(RoutePlanNode paramRoutePlanNode)
  {
    openNavi();
    if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
      BaiduNaviSDKManager.getInstance().quitNavi();
    }
    if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
      BaiduNaviSDKManager.getInstance().quitCruise();
    }
    com.baidu.carlife.core.screen.presentation.h.a().backTo(17, null);
    NavPoiController.getInstance().startCalcRoute(paramRoutePlanNode);
  }
  
  private void c()
  {
    this.n.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    if (this.h != null) {
      this.h.setOnClickListener(this);
    }
    this.d.a(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        StatisticManager.onEvent("HOME_ICON_0006");
        HomeFragment.i(HomeFragment.this);
      }
    }).b(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        StatisticManager.onEvent("HOME_ICON_0007");
        HomeFragment.h(HomeFragment.this);
      }
    });
    this.f.a(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        StatisticManager.onEvent("HOME_ICON_0001");
        o.a().c();
        HomeFragment.this.showFragment(542, null);
      }
    });
    this.g.c(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        StatisticManager.onEvent("HOME_ICON_0004");
        HomeFragment.this.showFragment(545, null);
      }
    });
    this.e.a(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        m.a().b();
        StatisticManager.onEvent("HOME_ICON_0009");
        if (com.baidu.carlife.logic.music.h.b().v())
        {
          com.baidu.carlife.logic.music.p.a().c();
          com.baidu.carlife.logic.music.h.b().f(true);
          return;
        }
        if (!com.baidu.carlife.core.e.a().r())
        {
          w.a(2131296718);
          return;
        }
        new com.baidu.carlife.radio.c.a(HomeFragment.this.getContext()).a(HomeFragment.this, new a.a()
        {
          public void a()
          {
            if (com.baidu.carlife.logic.music.h.b().q()) {
              com.baidu.carlife.logic.music.p.a().d();
            }
            com.baidu.carlife.logic.music.h.b().x();
          }
        });
      }
    }).b(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        m.a().b();
        StatisticManager.onEvent("HOME_ICON_0010");
        if (!com.baidu.carlife.core.e.a().r())
        {
          w.a(2131296718);
          return;
        }
        new com.baidu.carlife.radio.c.a(HomeFragment.this.getContext()).a(HomeFragment.this, new a.a()
        {
          public void a()
          {
            com.baidu.carlife.logic.music.h.b().g(true);
            com.baidu.carlife.logic.music.h.b().a(true);
          }
        });
      }
    });
    this.n.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0) {
          HomeFragment.j(HomeFragment.this).setAlpha(0.4F);
        }
        for (;;)
        {
          return false;
          if (paramAnonymousMotionEvent.getAction() == 1) {
            HomeFragment.j(HomeFragment.this).setAlpha(1.0F);
          }
        }
      }
    });
  }
  
  private void d()
  {
    if ((this.A) || (getCurrentFragment() != this) || (!com.baidu.carlife.logic.music.h.b().v()))
    {
      this.i.removeMsg(99);
      this.e.g(8);
      return;
    }
    this.e.g(0);
    this.e.getMusicMelody().setStartIndex(this.z.nextInt(40));
    this.e.getMusicMelody().invalidate();
    this.i.sendEmptyMessageDelayed(99, 200L);
  }
  
  private void e()
  {
    if (com.baidu.carlife.core.e.a().r()) {
      new aa().a(new aa.a()
      {
        public void a(int paramAnonymousInt)
        {
          HomeFragment.a(HomeFragment.this, paramAnonymousInt);
        }
        
        public void a(String paramAnonymousString)
        {
          i.b(HomeFragment.a, "UserOnlineNumberRequest error " + paramAnonymousString);
        }
      });
    }
  }
  
  private void f()
  {
    com.baidu.che.codriver.util.c.d("cltcwidg");
    String str = GeoLocateModel.getInstance().getCurrentDistrict().mName;
    com.baidu.carlife.logic.codriver.adapter.b.a().a(str + "限行信息", new g.a()
    {
      public void a(d.a paramAnonymousa)
      {
        com.baidu.che.codriver.util.c.d("");
        if (HomeFragment.k(HomeFragment.this) != null) {
          HomeFragment.k(HomeFragment.this).b("");
        }
      }
      
      public void a(NLPResponseData paramAnonymousNLPResponseData)
      {
        com.baidu.che.codriver.util.c.d("");
        if (HomeFragment.k(HomeFragment.this) == null) {}
        do
        {
          return;
          if ((paramAnonymousNLPResponseData == null) || (paramAnonymousNLPResponseData.resultList == null) || (paramAnonymousNLPResponseData.resultList.size() <= 0) || (!"traffic_limit".equals(((NLPResponseData.Result)paramAnonymousNLPResponseData.resultList.get(0)).cardType)) || (!"universal_search".equals(((NLPResponseData.Result)paramAnonymousNLPResponseData.resultList.get(0)).intent)) || (((NLPResponseData.Result)paramAnonymousNLPResponseData.resultList.get(0)).ttsStatus == null) || (((NLPResponseData.Result)paramAnonymousNLPResponseData.resultList.get(0)).data == null)) {
            break;
          }
          Gson localGson = new Gson();
          Type localType = new TypeToken() {}.getType();
          paramAnonymousNLPResponseData = (RestrictionData)localGson.fromJson(((NLPResponseData.Result)paramAnonymousNLPResponseData.resultList.get(0)).data, localType);
        } while (paramAnonymousNLPResponseData == null);
        HomeFragment.k(HomeFragment.this).b(paramAnonymousNLPResponseData.getTodayRestriction());
        return;
        HomeFragment.k(HomeFragment.this).b("");
      }
    });
  }
  
  private void g()
  {
    if (this.g == null) {
      return;
    }
    if (com.baidu.carlife.n.e.a().b())
    {
      this.g.d(0);
      return;
    }
    if ((!com.baidu.carlife.l.a.a().N()) && (o.a().b()))
    {
      this.g.d(0);
      return;
    }
    this.g.d(8);
  }
  
  private void h()
  {
    this.s = new u();
    this.s.registerResponseListener(this.x);
  }
  
  private void i()
  {
    if (this.o == null) {
      return;
    }
    if (com.baidu.carlife.logic.b.a.a())
    {
      this.o.setVisibility(0);
      return;
    }
    this.o.setVisibility(8);
  }
  
  private void j()
  {
    if (NaviAccountUtils.getInstance().isLogin()) {
      if (NaviAccountUtils.getInstance().getPortraitUrl() != null)
      {
        locala = com.baidu.carlife.g.a.a(this.m, NaviAccountUtils.getInstance().getPortraitUrl(), 52, 52);
        this.m.setController(locala);
      }
    }
    while (this.m == null)
    {
      com.facebook.drawee.c.a locala;
      return;
      NaviAccountUtils.getInstance().asyncGetProtraitUrl(new SapiCallBack()
      {
        public void a(GetPortraitResponse paramAnonymousGetPortraitResponse)
        {
          com.facebook.drawee.c.a locala = com.baidu.carlife.g.a.a(HomeFragment.j(HomeFragment.this), paramAnonymousGetPortraitResponse.portrait, 52, 52);
          HomeFragment.j(HomeFragment.this).setController(locala);
          com.baidu.carlife.util.p.a().b("account_portrait_url", paramAnonymousGetPortraitResponse.portrait);
        }
        
        public void onNetworkFailed()
        {
          Object localObject = com.baidu.carlife.util.p.a().a("account_portrait_url", "");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = com.baidu.carlife.g.a.a(HomeFragment.j(HomeFragment.this), (String)localObject, 52, 52);
            HomeFragment.j(HomeFragment.this).setController((com.facebook.drawee.g.a)localObject);
          }
        }
        
        public void onSystemError(int paramAnonymousInt) {}
      });
      return;
    }
    this.m.setImageURI("");
  }
  
  private void k()
  {
    if (this.s == null) {
      h();
    }
    if (this.s.a() == null) {
      this.s.toPostRequest();
    }
  }
  
  private void l()
  {
    f.a locala = f.jx;
    switch (11.a[locala.ordinal()])
    {
    default: 
      if ((locala.a().equals(this.w)) && (this.u != null))
      {
        a(this.u, this.v);
        return;
      }
      break;
    case 1: 
      this.u = null;
      this.v = null;
      a(this.u, this.v);
      this.w = locala.a();
      return;
    }
    this.w = locala.a();
    this.t = new com.baidu.carlife.k.s();
    this.t.registerResponseListener(this.y);
    this.t.a(this.w);
    this.t.toGetRequest();
  }
  
  private void m()
  {
    MainTopBarView localMainTopBarView = (MainTopBarView)this.mContentView.findViewById(2131624889);
    if (com.baidu.carlife.l.a.a().N())
    {
      localMainTopBarView.b(true);
      return;
    }
    localMainTopBarView.b(false);
    a(null, null);
  }
  
  private void n()
  {
    if (this.C == null)
    {
      this.C = new com.baidu.carlife.adpter.g(getActivity());
      this.C.a(new com.baidu.carlife.logic.b.b()
      {
        public boolean a(int paramAnonymousInt)
        {
          switch (paramAnonymousInt)
          {
          default: 
            return false;
          }
          return com.baidu.carlife.logic.b.a.a();
        }
      });
    }
    if (this.B == null)
    {
      this.B = new com.baidu.carlife.view.dialog.d(getActivity(), this.C, this);
      this.B.j();
      this.B.setSelected(0);
    }
    for (;;)
    {
      p();
      showDialog(this.B, BaseDialog.a.d);
      return;
      this.B.i();
    }
  }
  
  private void o()
  {
    AccountController.getInstance().loginIn(new AccountController.IAccountListener()
    {
      public void onLogResult(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          StatisticManager.onEvent("HOME_MINE_0007");
          UserCenterController.getInstance().startUpdateUserInfo(1, null);
          HomeFragment.x(HomeFragment.this);
        }
      }
    });
  }
  
  private void p()
  {
    if (this.C == null) {
      return;
    }
    String str = getContext().getString(2131297203);
    try
    {
      bool = NaviAccountUtils.getInstance().isLogin();
      if (bool) {
        str = NaviAccountUtils.getInstance().getUserName();
      }
      this.C.a(str);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  private void q()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        if (TextUtils.isEmpty(SysOSAPIv2.getInstance().getSdcardPath())) {}
        Object localObject;
        do
        {
          do
          {
            return;
            localObject = SysOSAPIv2.getInstance().getSdcardPath() + File.separator + f.hM + File.separator + "tmp";
          } while (TextUtils.isEmpty((CharSequence)localObject));
          localObject = new File((String)localObject);
        } while (!((File)localObject).exists());
        com.baidu.carlife.util.h.a((File)localObject);
      }
    }).start();
  }
  
  private void r()
  {
    Object localObject = new com.baidu.carlife.core.connect.c(true);
    ((com.baidu.carlife.core.connect.c)localObject).c(65569);
    localObject = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject).d(), 1001, 0, localObject);
    com.baidu.carlife.l.a.a().a((Message)localObject);
  }
  
  private void s()
  {
    if (AddressSettingModel.hasSetCompAddr(com.baidu.carlife.core.a.a()))
    {
      a(AddressSettingModel.getCompAddrNode(com.baidu.carlife.core.a.a()));
      return;
    }
    com.baidu.carlife.logic.codriver.adapter.b.a().a(m.c.d);
  }
  
  private void t()
  {
    if (AddressSettingModel.hasSetHomeAddr(com.baidu.carlife.core.a.a()))
    {
      a(AddressSettingModel.getHomeAddrNode(com.baidu.carlife.core.a.a()));
      return;
    }
    com.baidu.carlife.logic.codriver.adapter.b.a().a(m.c.c);
  }
  
  private void u()
  {
    i.b(a, "goVoiceNavi" + m.c.e);
    com.baidu.carlife.logic.codriver.adapter.b.a().a(m.c.e);
  }
  
  public String a(double paramDouble)
  {
    return new DecimalFormat("#,##0").format(paramDouble);
  }
  
  public void a()
  {
    if ((this.p != null) && (com.baidu.carlife.core.d.m()))
    {
      this.p.setVisibility(0);
      View localView = this.mContentView.findViewById(2131624891);
      if (localView != null) {
        localView.setVisibility(0);
      }
      localView = this.mContentView.findViewById(2131624892);
      if (localView != null) {
        localView.setVisibility(0);
      }
      localView = this.mContentView.findViewById(2131624894);
      if (localView != null) {
        localView.setVisibility(0);
      }
      localView = this.mContentView.findViewById(2131624896);
      if (localView != null) {
        localView.setVisibility(0);
      }
      this.mContentView.requestLayout();
    }
  }
  
  public boolean onBackPressed()
  {
    if (mActivity != null) {
      mActivity.d();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131624893: 
      com.baidu.carlife.view.g.e().f();
      StatisticManager.onEvent("HOME_ICON_0001");
      o.a().c();
      showFragment(542, null);
      return;
    case 2131624710: 
      m.a().b();
      StatisticManager.onEvent("HOME_ICON_0008");
      showFragment(594, null);
      return;
    case 2131624707: 
      com.baidu.carlife.view.g.e().f();
      StatisticManager.onEvent("HOME_ICON_0005");
      u();
      return;
    case 2131624895: 
      com.baidu.carlife.view.g.e().f();
      StatisticManager.onEvent("HOME_ICON_0004");
      showFragment(545, null);
      return;
    case 2131624887: 
      com.baidu.carlife.view.g.e().f();
      n();
      return;
    }
    r();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968763, null);
    this.i = new a(null);
    k.a(this.i);
    setBottomBarStatus(true);
    b();
    c();
    h();
    k.b(3007);
    try
    {
      NaviAccountUtils.getInstance().initAccount(BaiduNaviApplication.getInstance());
      NaviAccountUtils.getInstance().asyncGetUserInfo();
      com.baidu.carlife.util.s.a(false, true, false, true);
      com.baidu.carlife.view.g.e().b();
      q.f().i();
      if (BNLocationManagerProxy.getInstance().isLocationValid())
      {
        f();
        e();
        return this.mContentView;
      }
    }
    catch (Exception paramLayoutInflater)
    {
      for (;;)
      {
        paramLayoutInflater.printStackTrace();
        continue;
        this.i.postDelayed(new Runnable()
        {
          public void run()
          {
            if (BNLocationManagerProxy.getInstance().isLocationValid()) {
              HomeFragment.f(HomeFragment.this);
            }
            HomeFragment.g(HomeFragment.this);
          }
        }, 2000L);
      }
    }
  }
  
  public void onDestroyView()
  {
    this.q = null;
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    k.b(this.i);
    super.onDetach();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    i.b(a);
    k();
    g();
    i();
    if (paramBoolean)
    {
      this.A = true;
      com.baidu.carlife.view.g.e().f();
      return;
    }
    this.A = false;
    d();
  }
  
  public void onInitFocusAreas()
  {
    if ((this.mContentView == null) || (this.d == null) || (this.e == null) || (this.f == null) || (this.g == null) || (this.n == null)) {
      return;
    }
    com.baidu.carlife.f.d locald = com.baidu.carlife.f.d.a();
    if (this.k == null)
    {
      this.k = new com.baidu.carlife.f.g(this.mContentView, 2);
      this.k.d(this.n);
    }
    if (this.j == null)
    {
      this.j = new com.baidu.carlife.f.g(this.mContentView.findViewById(2131624890), 4);
      this.j.d(this.d).d(this.e).d(this.f).d(this.g);
      if ((this.h != null) && (this.h.isShown())) {
        this.j.d(this.h);
      }
    }
    View localView = mActivity.u().g();
    if (this.l == null)
    {
      this.l = new com.baidu.carlife.f.g(localView, 6);
      this.l.d(localView.findViewById(2131623991)).d(localView.findViewById(2131623992)).d(localView.findViewById(2131623993)).d(localView.findViewById(2131623994)).d(localView.findViewById(2131623995));
    }
    this.l.b(true);
    this.l.b(localView.findViewById(2131623993));
    locald.b(new com.baidu.carlife.f.a[] { this.k, this.j, this.l });
    locald.h(this.l);
  }
  
  protected void onInitView() {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.i.removeMsg(101);
    int i1 = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i1;
    }
    for (;;)
    {
      this.i.sendEmptyMessageDelayed(101, paramInt);
      label71:
      return;
      if (NaviAccountUtils.getInstance().isLogin()) {
        showFragment(544, null);
      }
      for (;;)
      {
        paramInt = 200;
        break;
        if (!this.C.a()) {
          break label71;
        }
        StatisticManager.onEvent("HOME_MINE_0001", "点击我的-登录小人按键的用户数");
        o();
      }
      showFragment(578, null);
      paramInt = 200;
      continue;
      showFragment(580, null);
      paramInt = 200;
      continue;
      showFragment(581, null);
      paramInt = 200;
      continue;
      showFragment(565, null);
      paramInt = 100;
      continue;
      if (this.q == null)
      {
        this.q = new com.baidu.carlife.view.dialog.c(mActivity).b(2131296270).a(2131296271).g(17).c(2131296264).q().d(2131296259);
        this.q.a(new com.baidu.carlife.core.screen.b()
        {
          public void onClick()
          {
            HomeFragment.y(HomeFragment.this);
          }
        });
      }
      showDialog(this.q);
      StatisticManager.onEvent("1028", "1028");
      paramInt = i1;
      continue;
      showFragment(539, null);
      StatisticManager.onEvent("1029", "1029");
      paramInt = 100;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.A = true;
  }
  
  public void onResume()
  {
    super.onResume();
    k.b(3007);
    g();
    i();
    m();
    k();
    i.b(a);
    this.A = false;
    this.i.removeMsg(99);
    if (com.baidu.carlife.logic.music.h.b().v()) {
      d();
    }
    j();
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin() {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public boolean onVoiceCommand(String paramString1, String paramString2)
  {
    i.b(a, "HomeFragment VOICE Command: " + paramString1 + " # " + paramString2);
    if (paramString2.equals("发现"))
    {
      onClick(this.f);
      return true;
    }
    if ((this.B != null) && (this.B.isShown())) {
      return this.B.a(paramString1, paramString2);
    }
    if (paramString2.equals("ind_center"))
    {
      onClick(this.n);
      return true;
    }
    return false;
  }
  
  private class a
    extends j
  {
    private a() {}
    
    public void careAbout()
    {
      addMsg(3007);
      addMsg(3008);
      addMsg(3012);
      addMsg(225);
      addMsg(1002);
      addMsg(1040);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 3008: 
      case 1002: 
      case 3007: 
      case 3012: 
        do
        {
          return;
          HomeFragment.l(HomeFragment.this);
          return;
          if (com.baidu.carlife.l.a.a().N()) {
            HomeFragment.m(HomeFragment.this);
          }
          for (;;)
          {
            HomeFragment.n(HomeFragment.this);
            if (paramMessage.what != 1002) {
              break;
            }
            i.b(HomeFragment.a, "####### MSG_CONNECT_STATUS_DISCONNECTED : " + HomeFragment.o(HomeFragment.this));
            if (HomeFragment.o(HomeFragment.this) == null) {
              break;
            }
            HomeFragment.o(HomeFragment.this).setVisibility(8);
            paramMessage = HomeFragment.p(HomeFragment.this).findViewById(2131624891);
            if (paramMessage != null) {
              paramMessage.setVisibility(8);
            }
            paramMessage = HomeFragment.q(HomeFragment.this).findViewById(2131624892);
            if (paramMessage != null) {
              paramMessage.setVisibility(8);
            }
            paramMessage = HomeFragment.r(HomeFragment.this).findViewById(2131624894);
            if (paramMessage != null) {
              paramMessage.setVisibility(8);
            }
            paramMessage = HomeFragment.s(HomeFragment.this).findViewById(2131624896);
            if (paramMessage != null) {
              paramMessage.setVisibility(8);
            }
            HomeFragment.t(HomeFragment.this).requestLayout();
            return;
            HomeFragment.a(HomeFragment.this, null, null);
          }
        } while (HomeFragment.this.getCurrentFragmentType() != HomeFragment.u(HomeFragment.this));
        HomeFragment.n(HomeFragment.this);
        return;
      case 99: 
        HomeFragment.v(HomeFragment.this);
        return;
      case 225: 
        HomeFragment.b(HomeFragment.this, paramMessage.arg1);
        return;
      case 101: 
        HomeFragment.this.dismissDialog(HomeFragment.w(HomeFragment.this));
        return;
      }
      HomeFragment.this.a();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/HomeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */