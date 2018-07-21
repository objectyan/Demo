package com.baidu.carlife.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.carlife.core.i;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.view.StatusButton;
import com.baidu.carlife.view.StatusButton.a;
import com.baidu.carlife.view.StatusButton.b;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;

public class NaviSettingFragment
  extends ContentFragment
{
  private ViewGroup a;
  private StatusButton b;
  private StatusButton c;
  private StatusButton d;
  private StatusButton e;
  private CheckBox f;
  private CheckBox g;
  private CheckBox h;
  private CheckBox i;
  private CheckBox j;
  private TextView k;
  private ImageButton l;
  private TextView m;
  private Boolean n = Boolean.valueOf(false);
  private CompoundButton.OnCheckedChangeListener o = new CompoundButton.OnCheckedChangeListener()
  {
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      if (BNSettingManager.getVoiceMode() == 2) {
        return;
      }
      if (paramAnonymousCompoundButton == NaviSettingFragment.a(NaviSettingFragment.this))
      {
        BNSettingManager.setElecCameraSpeakEnable(paramAnonymousBoolean);
        StatisticManager.onEvent("1054", "播报内容-电子眼_" + paramAnonymousBoolean);
      }
      for (;;)
      {
        BaiduNaviSDKManager.getInstance().updateRGEngineSpeekStatus();
        return;
        if (paramAnonymousCompoundButton == NaviSettingFragment.b(NaviSettingFragment.this))
        {
          BNSettingManager.setSpeedCameraSpeakEnable(paramAnonymousBoolean);
          StatisticManager.onEvent("1054", "播报内容-限速提醒_" + paramAnonymousBoolean);
        }
        else if (paramAnonymousCompoundButton == NaviSettingFragment.c(NaviSettingFragment.this))
        {
          BNSettingManager.setSaftyDriveSpeakEnable(paramAnonymousBoolean);
          StatisticManager.onEvent("1054", "播报内容-安全驾驶_" + paramAnonymousBoolean);
        }
        else if (paramAnonymousCompoundButton == NaviSettingFragment.d(NaviSettingFragment.this))
        {
          BNSettingManager.setRoadConditionpeakEnable(paramAnonymousBoolean);
          StatisticManager.onEvent("1054", "播报内容-前方路况_" + paramAnonymousBoolean);
        }
        else if (paramAnonymousCompoundButton == NaviSettingFragment.e(NaviSettingFragment.this))
        {
          BNSettingManager.setStraightDirectSpeakEnable(paramAnonymousBoolean);
          StatisticManager.onEvent("1054", "播报内容-直行顺行提醒_" + paramAnonymousBoolean);
        }
      }
    }
  };
  private StatusButton.a p = new StatusButton.a()
  {
    public void a(StatusButton paramAnonymousStatusButton, StatusButton.b paramAnonymousb)
    {
      if (paramAnonymousStatusButton == NaviSettingFragment.f(NaviSettingFragment.this)) {
        if (paramAnonymousb == StatusButton.b.a) {
          BNSettingManager.setNaviDayAndNightMode(2);
        }
      }
      for (;;)
      {
        BaiduNaviSDKManager.getInstance().updateRGEngineSpeekStatus();
        return;
        if (paramAnonymousb == StatusButton.b.b)
        {
          BNSettingManager.setNaviDayAndNightMode(3);
        }
        else
        {
          BNSettingManager.setNaviDayAndNightMode(1);
          continue;
          if (paramAnonymousStatusButton == NaviSettingFragment.g(NaviSettingFragment.this))
          {
            if (paramAnonymousb == StatusButton.b.a)
            {
              BNSettingManager.setVoiceMode(0);
              BNSettingManager.resetVoiceModeParams(0);
              StatisticManager.onEvent("1054", "播报模式-新手");
            }
            for (;;)
            {
              NaviSettingFragment.a(NaviSettingFragment.this, BNSettingManager.getVoiceMode());
              break;
              if (paramAnonymousb == StatusButton.b.b)
              {
                BNSettingManager.setVoiceMode(1);
                BNSettingManager.resetVoiceModeParams(1);
                StatisticManager.onEvent("1054", "播报模式-专家");
              }
              else
              {
                BNSettingManager.setVoiceMode(2);
                StatisticManager.onEvent("1054", "播报模式-静音");
              }
            }
          }
          if (paramAnonymousStatusButton == NaviSettingFragment.h(NaviSettingFragment.this))
          {
            if (paramAnonymousb == StatusButton.b.a)
            {
              BNSettingManager.setPrefRoutePlanMode(2);
              StatisticManager.onEvent("1054", "算路方式-离线");
            }
            else if (paramAnonymousb == StatusButton.b.c)
            {
              BNSettingManager.setPrefRoutePlanMode(3);
              StatisticManager.onEvent("1054", "算路方式-在线");
            }
          }
          else if (paramAnonymousStatusButton == NaviSettingFragment.i(NaviSettingFragment.this)) {
            if (paramAnonymousb == StatusButton.b.a)
            {
              BNSettingManager.setPrefSearchMode(2);
              StatisticManager.onEvent("1054", "搜索方式-离线");
            }
            else if (paramAnonymousb == StatusButton.b.c)
            {
              BNSettingManager.setPrefSearchMode(3);
              StatisticManager.onEvent("1054", "搜索方式-在线");
            }
          }
        }
      }
    }
  };
  private g q;
  private g r;
  
  private void a()
  {
    this.b = ((StatusButton)this.a.findViewById(2131624475));
    this.c = ((StatusButton)this.a.findViewById(2131624496));
    this.k = ((TextView)this.a.findViewById(2131624498));
    this.d = ((StatusButton)this.a.findViewById(2131624499));
    this.e = ((StatusButton)this.a.findViewById(2131624461));
    LinearLayout localLinearLayout = (LinearLayout)this.a.findViewById(2131624481);
    this.g = ((CheckBox)localLinearLayout.findViewById(2131624482));
    this.j = ((CheckBox)localLinearLayout.findViewById(2131624483));
    localLinearLayout = (LinearLayout)this.a.findViewById(2131624478);
    this.i = ((CheckBox)localLinearLayout.findViewById(2131624480));
    this.f = ((CheckBox)localLinearLayout.findViewById(2131624479));
    this.h = ((CheckBox)((LinearLayout)this.a.findViewById(2131624484)).findViewById(2131624485));
    this.f.setId(2147483632);
    this.g.setId(2147483633);
    this.h.setId(2147483634);
    this.i.setId(2147483635);
    this.j.setId(2147483636);
  }
  
  private void a(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1))
    {
      bool = BNSettingManager.isElecCameraSpeakEnable();
      this.f.setEnabled(true);
      this.f.setChecked(bool);
      bool = BNSettingManager.isSpeedCameraSpeakEnable();
      this.g.setEnabled(true);
      this.g.setChecked(bool);
      bool = BNSettingManager.isSaftyDriveSpeakEnable();
      this.h.setEnabled(true);
      this.h.setChecked(bool);
      bool = BNSettingManager.isRoadConditionSpeakEnable();
      this.i.setEnabled(true);
      this.i.setChecked(bool);
      bool = BNSettingManager.isStraightDirectSpeakEnable();
      this.j.setEnabled(true);
      this.j.setChecked(bool);
    }
    while (2 != paramInt)
    {
      boolean bool;
      return;
    }
    this.f.setChecked(false);
    this.f.setEnabled(false);
    this.g.setChecked(false);
    this.g.setEnabled(false);
    this.h.setChecked(false);
    this.h.setEnabled(false);
    this.i.setChecked(false);
    this.i.setEnabled(false);
    this.j.setChecked(false);
    this.j.setEnabled(false);
  }
  
  private void b()
  {
    int i1 = BNSettingManager.getNaviDayAndNightMode();
    if (i1 == 2)
    {
      this.e.a();
      i1 = BNSettingManager.getVoiceMode();
      if (i1 != 0) {
        break label101;
      }
      this.b.a();
      label33:
      a(i1);
      if (BNSettingManager.getPrefRoutPlanMode() != 2) {
        break label133;
      }
      this.c.a();
    }
    for (;;)
    {
      if (BNSettingManager.getPrefSearchMode() != 2) {
        break label144;
      }
      this.d.a();
      return;
      if (i1 == 3)
      {
        this.e.b();
        break;
      }
      if (i1 != 1) {
        break;
      }
      this.e.c();
      break;
      label101:
      if (i1 == 1)
      {
        this.b.b();
        break label33;
      }
      if (i1 != 2) {
        break label33;
      }
      this.b.c();
      break label33;
      label133:
      this.c.c();
    }
    label144:
    this.d.c();
  }
  
  private void c()
  {
    this.e.a(2131296409, 2131296719, 2131296300);
    this.e.a(this.p);
    this.b.a(2131297150, 2131297154, 2131297157);
    this.b.a(this.p);
    this.c.a(2131296854, 2131296855);
    this.c.a(this.p);
    this.d.a(2131296854, 2131296855);
    this.d.a(this.p);
    this.f.setOnCheckedChangeListener(this.o);
    this.i.setOnCheckedChangeListener(this.o);
    this.g.setOnCheckedChangeListener(this.o);
    this.j.setOnCheckedChangeListener(this.o);
    this.h.setOnCheckedChangeListener(this.o);
  }
  
  public void driving()
  {
    i.b("yftech", "NaviSettingFragment driving");
    getNaviFragmentManager().back();
    getNaviFragmentManager().back();
    com.baidu.carlife.custom.a.a().d();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.a = ((ViewGroup)paramLayoutInflater.inflate(2130968961, null));
    setCommonTitleBar(this.a, getString(2131296695));
    a();
    return this.a;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    int i1;
    if (!paramBoolean)
    {
      i1 = BNSettingManager.getVoiceMode();
      if (i1 != 0) {
        break label31;
      }
      this.b.a();
    }
    for (;;)
    {
      a(i1);
      return;
      label31:
      if (i1 == 1) {
        this.b.b();
      } else if (i1 == 2) {
        this.b.c();
      }
    }
  }
  
  public void onInitFocusAreas()
  {
    if (this.fragmentType != getCurrentFragmentType()) {
      return;
    }
    if (this.q == null)
    {
      this.q = new g(this.mContentView.findViewById(2131624260), 2);
      this.q.d(this.mContentView.findViewById(2131624258));
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.q });
    d.a().h(this.q);
  }
  
  protected void onInitView() {}
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    b();
    c();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
    updateCommonSkin();
  }
  
  protected void onUpdateStyle(boolean paramBoolean)
  {
    if ((this.b == null) || (this.e == null) || (this.c == null) || (this.d == null)) {
      return;
    }
    this.b.d();
    this.e.d();
    this.d.d();
    this.c.d();
  }
  
  public void stopDriving() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/NaviSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */