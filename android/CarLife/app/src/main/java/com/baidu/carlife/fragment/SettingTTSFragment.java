package com.baidu.carlife.fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.tts.OnTTSVoiceDataSwitchListener;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.a.f;
import com.baidu.carlife.f.d;
import com.baidu.carlife.util.w;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;

public class SettingTTSFragment
  extends ContentFragment
  implements View.OnClickListener
{
  private ViewGroup a;
  private TextView b;
  private TextView c;
  private OnTTSVoiceDataSwitchListener d = new OnTTSVoiceDataSwitchListener()
  {
    public void onTTSVoiceDataSwitched(boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
      {
        SettingTTSFragment.a(SettingTTSFragment.this).sendEmptyMessage(110);
        return;
      }
      SettingTTSFragment.a(SettingTTSFragment.this).sendEmptyMessage(111);
    }
  };
  private Handler e = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 110)
      {
        com.baidu.carlife.core.screen.presentation.a.g.a().b().c();
        w.a("切换成功");
        SettingTTSFragment.b(SettingTTSFragment.this);
      }
      while (paramAnonymousMessage.what != 111) {
        return;
      }
      com.baidu.carlife.core.screen.presentation.a.g.a().b().c();
      w.a("切换失败");
      SettingTTSFragment.b(SettingTTSFragment.this);
    }
  };
  private com.baidu.carlife.f.g f;
  
  private void a()
  {
    if (BaseTTSPlayer.getInstance().getLastTTSVoiceDataPath().contains("bd_etts_common_speech_taiwan_mand_eng_high_am-mgc_v3.0.0_20170807.dat"))
    {
      this.b.setSelected(false);
      this.c.setSelected(true);
      return;
    }
    this.c.setSelected(false);
    this.b.setSelected(true);
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
    if (paramView.getId() == 2131625027)
    {
      com.baidu.carlife.core.screen.presentation.a.g.a().b().b("切换中...");
      BaseTTSPlayer.getInstance().setCustomParams(false);
      BaseTTSPlayer.getInstance().loadCustomResource("");
      BaseTTSPlayer.getInstance().setCurrentSelectPath("bd_etts_common_speech_f7_mand_eng_high_am-mix_v3.0.0_20170512.dat");
      BaseTTSPlayer.getInstance().switchTTSVoiceData(null, this.d);
    }
    while (paramView.getId() != 2131625028) {
      return;
    }
    com.baidu.carlife.core.screen.presentation.a.g.a().b().b("切换中...");
    BaseTTSPlayer.getInstance().setCustomParams(false);
    BaseTTSPlayer.getInstance().loadCustomResource("");
    BaseTTSPlayer.getInstance().setCurrentSelectPath("bd_etts_common_speech_taiwan_mand_eng_high_am-mgc_v3.0.0_20170807.dat");
    BaseTTSPlayer.getInstance().switchTTSVoiceData(null, this.d);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.a = ((ViewGroup)paramLayoutInflater.inflate(2130968817, null));
    setCommonTitleBar(this.a, getString(2131297179));
    this.b = ((TextView)this.a.findViewById(2131625027));
    this.c = ((TextView)this.a.findViewById(2131625028));
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    a();
    return this.a;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    a();
  }
  
  public void onInitFocusAreas()
  {
    if ((this.fragmentType != getCurrentFragmentType()) || (this.a == null)) {
      return;
    }
    if (this.f == null)
    {
      this.f = new com.baidu.carlife.f.g(this.a.findViewById(2131624260), 2);
      this.f.d(this.a.findViewById(2131624258));
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.f });
    d.a().h(this.f);
  }
  
  protected void onInitView() {}
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void stopDriving() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/SettingTTSFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */