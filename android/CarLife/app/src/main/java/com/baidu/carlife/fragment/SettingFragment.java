package com.baidu.carlife.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.adpter.q;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.f.d;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.util.h;
import com.baidu.carlife.util.r;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.SwitchButton;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.track.common.TrackConfigUtil;
import com.baidu.navi.util.StatisticManager;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.File;

public class SettingFragment
  extends ContentFragment
  implements AdapterView.OnItemClickListener
{
  public static String a = SettingFragment.class.getSimpleName();
  protected q b;
  private ListView c;
  private a d;
  private com.baidu.carlife.view.dialog.c e;
  private com.baidu.carlife.f.g f;
  private com.baidu.carlife.f.c g;
  
  private boolean b()
  {
    if ((!c()) && (n.a().n()))
    {
      w.a(2131297222, 0);
      return false;
    }
    return true;
  }
  
  private boolean c()
  {
    return e.a().o();
  }
  
  private void d()
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
        h.a((File)localObject);
      }
    }).start();
  }
  
  private void e()
  {
    if (this.e != null) {
      this.e.d();
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((f.jx == f.a.ab) || (f.jx == f.a.aa)) {
      bool = true;
    }
    return bool;
  }
  
  public void driving()
  {
    i.b("yftech", "SettingFragment driving");
    e();
    back();
    com.baidu.carlife.custom.a.a().d();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968809, null);
    setCommonTitleBar(this.mContentView, getString(2131296639));
    int i;
    if (f.jv) {
      i = 2131230720;
    }
    for (;;)
    {
      this.b = new q(getContext(), i);
      this.c = ((ListView)this.mContentView.findViewById(2131625180));
      this.c.setOverScrollMode(2);
      this.c.setAdapter(this.b);
      this.c.setOnItemClickListener(this);
      this.d = new a(Looper.getMainLooper());
      k.a(this.d);
      return this.mContentView;
      if (a()) {
        i = 2131230721;
      } else {
        i = 2131230722;
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    this.d.removeCallbacksAndMessages(null);
    k.b(this.d);
    this.b = null;
    this.e = null;
    this.c = null;
    super.onDestroy();
  }
  
  public void onInitFocusAreas()
  {
    if (this.fragmentType != getCurrentFragmentType()) {
      return;
    }
    if (this.f == null)
    {
      this.f = new com.baidu.carlife.f.g(this.mContentView.findViewById(2131624146), 2);
      this.f.d(this.mContentView.findViewById(2131624258));
    }
    if (this.g == null) {
      this.g = new com.baidu.carlife.f.c(this.c, 6);
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.f, this.g });
    d.a().h(this.g);
    this.g.e();
  }
  
  protected void onInitView() {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt = (int)paramAdapterView.getItemIdAtPosition(paramInt);
    i.b(a, "onItemClick:itemId = " + paramInt);
    if (f.jv) {
      switch (paramInt)
      {
      }
    }
    label585:
    label776:
    label941:
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
                } while (!b());
                paramAdapterView = (SwitchButton)paramView.findViewById(2131625241);
                paramAdapterView.setVisibility(0);
                if (!e.a().o()) {}
                for (bool = true;; bool = false)
                {
                  paramAdapterView.setChecked(bool);
                  return;
                }
                paramAdapterView = (SwitchButton)paramView.findViewById(2131625241);
                paramAdapterView.setVisibility(0);
                if (!com.baidu.carlife.l.a.a().j()) {}
                for (bool = true;; bool = false)
                {
                  paramAdapterView.setChecked(bool);
                  return;
                }
                if (!com.baidu.carlife.logic.g.a().c()) {
                  break;
                }
              } while (showConnectForbidDialog());
              showFragment(532, null);
              return;
              showFragment(532, null);
              return;
              if (!com.baidu.carlife.logic.g.a().c()) {
                break;
              }
            } while (showConnectForbidDialog());
            showFragment(568, null);
            return;
            showFragment(568, null);
            return;
            paramAdapterView = (SwitchButton)paramView.findViewById(2131625241);
            if (!TrackConfigUtil.getInstance().getRouteRecordFlag()) {}
            for (bool = true;; bool = false)
            {
              paramAdapterView.setChecked(bool);
              return;
            }
            try
            {
              mActivity.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
              return;
            }
            catch (Exception paramAdapterView)
            {
              paramAdapterView.printStackTrace();
              return;
            }
            if (this.e == null)
            {
              this.e = new com.baidu.carlife.view.dialog.c(mActivity).b(2131296270).a(2131296271).g(17).c(2131296264).q().d(2131296259);
              this.e.a(new com.baidu.carlife.core.screen.b()
              {
                public void onClick()
                {
                  SettingFragment.a(SettingFragment.this);
                }
              });
            }
            showDialog(this.e);
            StatisticManager.onEvent("1028", "1028");
            return;
            showFragment(539, null);
            StatisticManager.onEvent("1029", "1029");
            return;
            if (!a()) {
              break label776;
            }
            switch (paramInt)
            {
            default: 
              return;
            case 0: 
              paramAdapterView = (SwitchButton)paramView.findViewById(2131625241);
              if (!b())
              {
                paramAdapterView.setChecked(false);
                return;
              }
              paramAdapterView.setVisibility(0);
              if (!e.a().o()) {}
              for (bool = true;; bool = false)
              {
                paramAdapterView.setChecked(bool);
                return;
              }
            case 1: 
              paramAdapterView = (SwitchButton)paramView.findViewById(2131625241);
              paramAdapterView.setVisibility(0);
              if (!com.baidu.carlife.l.a.a().j()) {}
              for (bool = true;; bool = false)
              {
                paramAdapterView.setChecked(bool);
                return;
              }
            case 2: 
              if (!com.baidu.carlife.logic.g.a().c()) {
                break label585;
              }
            }
          } while (showConnectForbidDialog());
          showFragment(532, null);
          return;
          showFragment(532, null);
          return;
          if (!com.baidu.carlife.logic.g.a().c()) {
            break;
          }
        } while (showConnectForbidDialog());
        showFragment(568, null);
        return;
        showFragment(568, null);
        return;
        paramAdapterView = (SwitchButton)paramView.findViewById(2131625241);
        if (!TrackConfigUtil.getInstance().getRouteRecordFlag()) {}
        for (bool = true;; bool = false)
        {
          paramAdapterView.setChecked(bool);
          return;
        }
        com.baidu.carlife.custom.elhyf.b.a().d();
        return;
        if (this.e == null)
        {
          this.e = new com.baidu.carlife.view.dialog.c(mActivity).b(2131296270).a(2131296271).g(17).c(2131296264).q().d(2131296259);
          this.e.a(new com.baidu.carlife.core.screen.b()
          {
            public void onClick()
            {
              SettingFragment.a(SettingFragment.this);
            }
          });
        }
        showDialog(this.e);
        StatisticManager.onEvent("1028", "1028");
        return;
        showFragment(539, null);
        StatisticManager.onEvent("1029", "1029");
        return;
        switch (paramInt)
        {
        default: 
          return;
        case 0: 
          paramAdapterView = (SwitchButton)paramView.findViewById(2131625241);
          if (!b())
          {
            paramAdapterView.setChecked(false);
            return;
          }
          paramAdapterView.setVisibility(0);
          if (!e.a().o()) {}
          for (bool = true;; bool = false)
          {
            paramAdapterView.setChecked(bool);
            return;
          }
        case 1: 
          paramAdapterView = (SwitchButton)paramView.findViewById(2131625241);
          paramAdapterView.setVisibility(0);
          if (!com.baidu.carlife.l.a.a().j()) {}
          for (bool = true;; bool = false)
          {
            paramAdapterView.setChecked(bool);
            return;
          }
        case 2: 
          if (!com.baidu.carlife.logic.g.a().c()) {
            break label941;
          }
        }
      } while (showConnectForbidDialog());
      showFragment(532, null);
      return;
      showFragment(532, null);
      return;
      if (!com.baidu.carlife.logic.g.a().c()) {
        break;
      }
    } while (showConnectForbidDialog());
    showFragment(568, null);
    return;
    showFragment(568, null);
    return;
    paramAdapterView = (SwitchButton)paramView.findViewById(2131625241);
    if (!TrackConfigUtil.getInstance().getRouteRecordFlag()) {}
    for (boolean bool = true;; bool = false)
    {
      paramAdapterView.setChecked(bool);
      return;
    }
    if (this.e == null)
    {
      this.e = new com.baidu.carlife.view.dialog.c(mActivity).b(2131296270).a(2131296271).g(17).c(2131296264).q().d(2131296259);
      this.e.a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          SettingFragment.a(SettingFragment.this);
        }
      });
    }
    showDialog(this.e);
    StatisticManager.onEvent("1028", "1028");
    return;
    showFragment(539, null);
    StatisticManager.onEvent("1029", "1029");
  }
  
  public void onResume()
  {
    super.onResume();
    i.b(a);
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
    updateCommonSkin();
    this.c.setSelector(r.b(2130838223));
    this.c.setDivider(r.b(2131558624));
    this.c.setDividerHeight(getResources().getDimensionPixelSize(2131361846));
    this.b.notifyDataSetChanged();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void stopDriving()
  {
    i.b("yftech", "SettingFragment stopDriving");
  }
  
  private class a
    extends j
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void careAbout()
    {
      addMsg(16875523);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return;
        int i;
        if ((String)paramMessage.obj == null) {
          i = 2131230720;
        }
        while (SettingFragment.this.b != null)
        {
          SettingFragment.this.b.a(i);
          SettingFragment.this.b.notifyDataSetChanged();
          return;
          if (SettingFragment.this.a()) {
            i = 2131230721;
          } else {
            i = 2131230722;
          }
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/SettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */