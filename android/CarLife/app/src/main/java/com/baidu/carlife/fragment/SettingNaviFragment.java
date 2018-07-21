package com.baidu.carlife.fragment;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.baidu.carlife.core.i;
import com.baidu.carlife.f.g;
import com.baidu.carlife.view.SwitchButton;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.utils.StringUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.commontool.BNAutoDayNightHelper;
import com.baidu.navisdk.comapi.commontool.BNDayNightChangedObserver;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSortModel;
import java.util.ArrayList;
import java.util.List;

public class SettingNaviFragment
  extends ContentFragment
  implements View.OnClickListener
{
  private ViewGroup a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private SwitchButton h;
  private TextView i;
  private View j;
  private List<TextView> k;
  private ArrayList<RGRouteSortModel> l;
  private SwitchButton m;
  private View n;
  private int o;
  private int p = 5;
  private int q = 1;
  private int r = 0;
  private BNDayNightChangedObserver s = new BNDayNightChangedObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      SettingNaviFragment.b(SettingNaviFragment.this);
    }
  };
  private g t;
  
  private void a()
  {
    if (RGCarPreferSettingController.getInstance().isCarLimitOpen())
    {
      String str = BNSettingManager.getPlateFromLocal(getNaviActivity());
      if (StringUtils.isCarPlate(str))
      {
        this.i.setText(str);
        this.j.setVisibility(0);
        this.h.setChecked(true);
        RGCarPreferSettingController.getInstance().setCarLimitOpen(true);
        return;
      }
      RGCarPreferSettingController.getInstance().setCarLimitOpen(false);
      this.h.setChecked(false);
      this.j.setVisibility(8);
      return;
    }
    RGCarPreferSettingController.getInstance().setCarLimitOpen(false);
    this.h.setChecked(false);
    this.j.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      BNSettingManager.setPrefRoutePlanMode(3);
      StatisticManager.onEvent("1054", "算路方式-在线");
      return;
    }
    BNSettingManager.setPrefRoutePlanMode(2);
    StatisticManager.onEvent("1054", "算路方式-离线");
  }
  
  private void b()
  {
    this.b = ((TextView)this.a.findViewById(2131625035));
    this.c = ((TextView)this.a.findViewById(2131625036));
    this.d = ((TextView)this.a.findViewById(2131625037));
    this.e = ((TextView)this.a.findViewById(2131625038));
    this.f = ((TextView)this.a.findViewById(2131625039));
    this.g = ((TextView)this.a.findViewById(2131625040));
    this.m = ((SwitchButton)this.a.findViewById(2131625042));
    this.n = this.a.findViewById(2131625041);
    this.h = ((SwitchButton)this.a.findViewById(2131625022));
    this.i = ((TextView)this.a.findViewById(2131625024));
    this.j = this.a.findViewById(2131625023);
    this.k = new ArrayList();
    TextView localTextView = (TextView)this.a.findViewById(2131625027);
    this.k.add(localTextView);
    localTextView = (TextView)this.a.findViewById(2131625028);
    this.k.add(localTextView);
    localTextView = (TextView)this.a.findViewById(2131625029);
    this.k.add(localTextView);
    localTextView = (TextView)this.a.findViewById(2131625030);
    this.k.add(localTextView);
    localTextView = (TextView)this.a.findViewById(2131625031);
    this.k.add(localTextView);
    localTextView = (TextView)this.a.findViewById(2131625032);
    this.k.add(localTextView);
    localTextView = (TextView)this.a.findViewById(2131625033);
    this.k.add(localTextView);
    localTextView = (TextView)this.a.findViewById(2131625034);
    this.k.add(localTextView);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = BNSettingManager.getPlateFromLocal(getNaviActivity());
      if (StringUtils.isCarPlate(str))
      {
        this.i.setText(str);
        this.j.setVisibility(0);
        RGCarPreferSettingController.getInstance().setCarLimitOpen(true);
        StatisticManager.onEvent("NAVI_0034", "NAVI_0034");
        return;
      }
      RGCarPreferSettingController.getInstance().setCarLimitOpen(false);
      h();
      return;
    }
    RGCarPreferSettingController.getInstance().setCarLimitOpen(false);
    this.j.setVisibility(8);
  }
  
  private void c()
  {
    if (BNSettingManager.getNaviDayAndNightMode() == 2)
    {
      this.b.setSelected(true);
      this.c.setSelected(false);
      this.d.setSelected(false);
    }
    do
    {
      return;
      if (BNSettingManager.getNaviDayAndNightMode() == 3)
      {
        this.b.setSelected(false);
        this.c.setSelected(true);
        this.d.setSelected(false);
        return;
      }
    } while (BNSettingManager.getNaviDayAndNightMode() != 1);
    this.b.setSelected(false);
    this.c.setSelected(false);
    this.d.setSelected(true);
  }
  
  private void d()
  {
    int i1 = BNSettingManager.getVoiceMode();
    if (i1 == 0)
    {
      this.e.setSelected(true);
      this.f.setSelected(false);
      this.g.setSelected(false);
    }
    do
    {
      return;
      if (i1 == 1)
      {
        this.e.setSelected(false);
        this.f.setSelected(true);
        this.g.setSelected(false);
        return;
      }
    } while (i1 != 2);
    this.e.setSelected(false);
    this.f.setSelected(false);
    this.g.setSelected(true);
  }
  
  private void e()
  {
    this.l = RGRouteSortController.getInstance().getRouteSortList();
    Object localObject1;
    int i1;
    Object localObject2;
    if (!com.baidu.carlife.util.a.a())
    {
      localObject1 = com.baidu.carlife.core.a.a().getResources();
      i1 = 0;
      if (i1 < this.l.size())
      {
        localObject2 = (RGRouteSortModel)this.l.get(i1);
        if ("智能推荐".equals(((RGRouteSortModel)localObject2).mItemName)) {
          ((RGRouteSortModel)localObject2).mItemName = ((Resources)localObject1).getString(2131296919);
        }
        for (;;)
        {
          if ("距离优先".equals(((RGRouteSortModel)localObject2).mItemName)) {
            ((RGRouteSortModel)localObject2).mItemName = ((Resources)localObject1).getString(2131296891);
          }
          if ("躲避拥堵".equals(((RGRouteSortModel)localObject2).mItemName)) {
            ((RGRouteSortModel)localObject2).mItemName = ((Resources)localObject1).getString(2131296888);
          }
          if ("不走高速".equals(((RGRouteSortModel)localObject2).mItemName)) {
            ((RGRouteSortModel)localObject2).mItemName = ((Resources)localObject1).getString(2131296889);
          }
          if ("高速优先".equals(((RGRouteSortModel)localObject2).mItemName)) {
            ((RGRouteSortModel)localObject2).mItemName = ((Resources)localObject1).getString(2131296892);
          }
          ((RGRouteSortModel)this.l.get(i1)).mItemName = ((RGRouteSortModel)localObject2).mItemName;
          i1 += 1;
          break;
          if ("时间优先".equals(((RGRouteSortModel)localObject2).mItemName)) {
            ((RGRouteSortModel)localObject2).mItemName = ((Resources)localObject1).getString(2131296920);
          }
        }
      }
    }
    int i3 = BNRoutePlaner.getInstance().getCalcPreference();
    label325:
    label332:
    int i2;
    if (this.o < 540) {
      if (this.l.size() >= 3)
      {
        this.p = 3;
        this.q = (this.l.size() - 3);
        this.r = 2;
        if (!com.baidu.carlife.util.a.a())
        {
          if (this.l.size() <= 3) {
            break label642;
          }
          this.p = 3;
          this.q = (this.l.size() - 3);
          this.r = 2;
        }
        i1 = 0;
        i2 = i1;
        if (i1 >= this.l.size()) {
          break label670;
        }
        i2 = i1;
        if (i1 >= this.p) {
          break label670;
        }
        i2 = i1;
        if (i1 >= this.k.size()) {
          break label670;
        }
        localObject1 = (RGRouteSortModel)this.l.get(i1);
        localObject2 = (TextView)this.k.get(i1);
        ((TextView)localObject2).setText(((RGRouteSortModel)localObject1).mItemName);
        ((TextView)localObject2).setTag(Integer.valueOf(i1));
        ((TextView)localObject2).setVisibility(0);
        if ((((RGRouteSortModel)localObject1).mPreferValue & i3) == 0) {
          break label661;
        }
        ((TextView)localObject2).setSelected(true);
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setOnClickListener(this);
      if (!com.baidu.carlife.util.a.a())
      {
        ((TextView)localObject2).setTextSize(12.0F);
        ((TextView)localObject2).getLayoutParams().width = com.baidu.carlife.core.a.a().getResources().getDimensionPixelSize(2131361984);
      }
      i1 += 1;
      break label332;
      this.p = this.l.size();
      this.q = 0;
      this.r = 0;
      break;
      if (this.o < 640)
      {
        if (this.l.size() >= 4)
        {
          this.p = 4;
          this.q = (this.l.size() - 4);
          this.r = 1;
          break;
        }
        this.p = this.l.size();
        this.q = 0;
        this.r = 0;
        break;
      }
      if (this.l.size() >= 5)
      {
        this.p = 5;
        this.q = (this.l.size() - 5);
        this.r = 0;
        break;
      }
      this.p = this.l.size();
      this.q = 0;
      this.r = 0;
      break;
      label642:
      this.p = this.l.size();
      this.q = 0;
      break label325;
      label661:
      ((TextView)localObject2).setSelected(false);
    }
    label670:
    if ((i2 < this.l.size()) && (this.l.size() - i2 <= this.q) && (this.r + i2 < this.k.size()))
    {
      localObject1 = (RGRouteSortModel)this.l.get(i2);
      localObject2 = (TextView)this.k.get(this.r + i2);
      ((TextView)localObject2).setText(((RGRouteSortModel)localObject1).mItemName);
      ((TextView)localObject2).setTag(Integer.valueOf(i2));
      ((TextView)localObject2).setVisibility(0);
      if ((((RGRouteSortModel)localObject1).mPreferValue & i3) != 0) {
        ((TextView)localObject2).setSelected(true);
      }
      for (;;)
      {
        ((TextView)localObject2).setOnClickListener(this);
        if (!com.baidu.carlife.util.a.a())
        {
          ((TextView)localObject2).setTextSize(12.0F);
          ((TextView)localObject2).getLayoutParams().width = com.baidu.carlife.core.a.a().getResources().getDimensionPixelSize(2131361984);
        }
        i2 += 1;
        break;
        ((TextView)localObject2).setSelected(false);
      }
    }
  }
  
  private void f()
  {
    int i1 = BNSettingManager.getPrefRoutPlanMode();
    SwitchButton localSwitchButton = this.m;
    if (i1 != 2) {}
    for (boolean bool = true;; bool = false)
    {
      localSwitchButton.setChecked(bool);
      return;
    }
  }
  
  private void g()
  {
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.n.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SettingNaviFragment.a(SettingNaviFragment.this).toggle();
      }
    });
    this.j.setOnClickListener(this);
  }
  
  private void h()
  {
    showFragment(557, null);
  }
  
  public void driving()
  {
    i.b("yftech", "NaviSettingFragment driving");
    getNaviFragmentManager().back();
    getNaviFragmentManager().back();
    com.baidu.carlife.custom.a.a().d();
  }
  
  public void onClick(View paramView)
  {
    int i1;
    label74:
    RGRouteSortModel localRGRouteSortModel;
    int i2;
    switch (paramView.getId())
    {
    default: 
      i1 = 0;
      if (i1 < this.k.size())
      {
        if ((paramView != this.k.get(i1)) || (((Integer)paramView.getTag()).intValue() >= this.l.size())) {
          break label450;
        }
        ((TextView)this.k.get(i1)).setSelected(true);
        localRGRouteSortModel = (RGRouteSortModel)this.l.get(((Integer)paramView.getTag()).intValue());
        if ((RGRouteSortController.getInstance().getPreferValue() & 0x20) == 0) {
          break label441;
        }
        i2 = localRGRouteSortModel.mPreferValue | 0x20;
        label181:
        BNaviModuleManager.setLastPreferValue(i2);
        BNSettingManager.setDefaultRouteSort(i2);
        RGRouteSortController.getInstance().setPreferValue(i2);
        BNRoutePlaner.getInstance().setCalcPrference(i2);
      }
      break;
    }
    for (;;)
    {
      i1 += 1;
      break label74;
      this.b.setSelected(true);
      this.c.setSelected(false);
      this.d.setSelected(false);
      BNSettingManager.setNaviDayAndNightMode(2);
      return;
      this.b.setSelected(false);
      this.c.setSelected(true);
      this.d.setSelected(false);
      BNSettingManager.setNaviDayAndNightMode(3);
      return;
      this.b.setSelected(false);
      this.c.setSelected(false);
      this.d.setSelected(true);
      BNSettingManager.setNaviDayAndNightMode(1);
      return;
      this.e.setSelected(true);
      this.f.setSelected(false);
      this.g.setSelected(false);
      BNSettingManager.setVoiceMode(0);
      BNSettingManager.resetVoiceModeParams(0);
      BaiduNaviSDKManager.getInstance().updateRGEngineSpeekStatus();
      StatisticManager.onEvent("1054", "播报模式-新手");
      return;
      this.e.setSelected(false);
      this.f.setSelected(true);
      this.g.setSelected(false);
      BNSettingManager.setVoiceMode(1);
      BNSettingManager.resetVoiceModeParams(1);
      BaiduNaviSDKManager.getInstance().updateRGEngineSpeekStatus();
      StatisticManager.onEvent("1054", "播报模式-专家");
      return;
      this.e.setSelected(false);
      this.f.setSelected(false);
      this.g.setSelected(true);
      BNSettingManager.setVoiceMode(2);
      BaiduNaviSDKManager.getInstance().updateRGEngineSpeekStatus();
      StatisticManager.onEvent("1054", "播报模式-静音");
      return;
      h();
      break;
      label441:
      i2 = localRGRouteSortModel.mPreferValue;
      break label181;
      label450:
      ((TextView)this.k.get(i1)).setSelected(false);
    }
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.a = ((ViewGroup)paramLayoutInflater.inflate(2130968787, null));
    setCommonTitleBar(this.a, getString(2131296695));
    this.o = (com.baidu.carlife.core.d.a().h() / (com.baidu.carlife.core.d.a().g() / 160));
    b();
    g();
    BNAutoDayNightHelper.getInstance().addObserver(this.s);
    return this.a;
  }
  
  public void onDestroyView()
  {
    BNAutoDayNightHelper.getInstance().deleteObserver(this.s);
    super.onDestroyView();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    e();
    d();
  }
  
  public void onInitFocusAreas()
  {
    if ((this.fragmentType != getCurrentFragmentType()) || (this.a == null)) {
      return;
    }
    if (this.t == null)
    {
      this.t = new g(this.a.findViewById(2131624260), 2);
      this.t.d(this.a.findViewById(2131624258));
    }
    com.baidu.carlife.f.d.a().b(new com.baidu.carlife.f.a[] { this.t });
    com.baidu.carlife.f.d.a().h(this.t);
  }
  
  protected void onInitView() {}
  
  public void onResume()
  {
    super.onResume();
    a();
    e();
    c();
    d();
    f();
    this.m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        SettingNaviFragment.a(SettingNaviFragment.this, paramAnonymousBoolean);
      }
    });
    this.h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        SettingNaviFragment.b(SettingNaviFragment.this, paramAnonymousBoolean);
      }
    });
  }
  
  public void onStop()
  {
    super.onStop();
    this.m.setOnCheckedChangeListener(null);
    this.h.setOnCheckedChangeListener(null);
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void stopDriving() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/SettingNaviFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */