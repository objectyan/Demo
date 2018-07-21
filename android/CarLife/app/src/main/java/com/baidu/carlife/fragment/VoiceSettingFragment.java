package com.baidu.carlife.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.tts.OnTTSVoiceDataSwitchListener;
import com.baidu.carlife.c.d.c;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.a.f;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.SwitchButton;
import com.baidu.navi.fragment.ContentFragment;

public class VoiceSettingFragment
  extends ContentFragment
{
  private com.baidu.carlife.logic.b.e.a a;
  private SwitchButton b;
  private TextView c;
  private TextView d;
  private com.baidu.carlife.f.g e;
  private com.baidu.carlife.f.g f;
  private OnTTSVoiceDataSwitchListener g = new OnTTSVoiceDataSwitchListener()
  {
    public void onTTSVoiceDataSwitched(final boolean paramAnonymousBoolean)
    {
      com.baidu.carlife.c.g.b.a().a(new Runnable()
      {
        public void run()
        {
          com.baidu.carlife.core.screen.presentation.a.g.a().b().c();
          if (!paramAnonymousBoolean) {
            return;
          }
          VoiceSettingFragment.a(VoiceSettingFragment.this).a().b(Boolean.valueOf(BaseTTSPlayer.getInstance().getLastTTSVoiceDataPath().contains("bd_etts_common_speech_f7_mand_eng_high_am-mix_v3.0.0_20170512.dat")));
        }
      });
    }
  };
  
  private void a()
  {
    if (n.a().n())
    {
      w.a(2131297222);
      return;
    }
    n.a().a(true);
    e.a().a(true);
    w.a(2131297225);
    n.a().g();
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    paramTextView.setSelected(paramBoolean);
    Resources localResources = getResources();
    if (paramBoolean) {}
    for (int i = 2131559221;; i = 2131559204)
    {
      paramTextView.setTextColor(localResources.getColor(i));
      return;
    }
  }
  
  private void a(String paramString)
  {
    com.baidu.carlife.core.screen.presentation.a.g.a().b().b("切换中...");
    BaseTTSPlayer.getInstance().setCustomParams(false);
    BaseTTSPlayer.getInstance().loadCustomResource("");
    BaseTTSPlayer.getInstance().setCurrentSelectPath(paramString);
    BaseTTSPlayer.getInstance().switchTTSVoiceData(null, this.g);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean == e.a().o()) {
      return;
    }
    if (paramBoolean)
    {
      a();
      return;
    }
    b();
  }
  
  private void b()
  {
    n.a().a(false);
    e.a().a(false);
    w.a(2131297206, 0);
    n.a().h();
  }
  
  public void driving()
  {
    i.b("yftech", "VoiceSettingFragment driving");
    if (com.baidu.carlife.custom.b.a().b()) {
      back();
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.a = new com.baidu.carlife.logic.b.e.a();
    this.b.setChecked(((Boolean)this.a.c().b()).booleanValue());
    this.b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        boolean bool1 = false;
        if (n.a().n())
        {
          if (paramAnonymousBoolean) {
            VoiceSettingFragment.b(VoiceSettingFragment.this).setChecked(false);
          }
          w.a(2131297222);
          return;
        }
        boolean bool2 = e.a().o();
        paramAnonymousCompoundButton = VoiceSettingFragment.this;
        paramAnonymousBoolean = bool1;
        if (!bool2) {
          paramAnonymousBoolean = true;
        }
        VoiceSettingFragment.a(paramAnonymousCompoundButton, paramAnonymousBoolean);
      }
    });
    this.c.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        VoiceSettingFragment.a(VoiceSettingFragment.this, "bd_etts_common_speech_f7_mand_eng_high_am-mix_v3.0.0_20170512.dat");
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        VoiceSettingFragment.a(VoiceSettingFragment.this, "bd_etts_common_speech_taiwan_mand_eng_high_am-mgc_v3.0.0_20170807.dat");
      }
    });
    paramBundle = this.d;
    if (!((Boolean)this.a.a().b()).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramBundle, bool);
      a(this.c, ((Boolean)this.a.a().b()).booleanValue());
      this.a.a().a(new com.baidu.carlife.c.d.d()
      {
        public void a(@Nullable Boolean paramAnonymousBoolean)
        {
          VoiceSettingFragment.a(VoiceSettingFragment.this, VoiceSettingFragment.c(VoiceSettingFragment.this), paramAnonymousBoolean.booleanValue());
        }
      });
      this.a.a().a(new com.baidu.carlife.c.d.d()
      {
        public void a(@Nullable Boolean paramAnonymousBoolean)
        {
          VoiceSettingFragment localVoiceSettingFragment = VoiceSettingFragment.this;
          TextView localTextView = VoiceSettingFragment.d(VoiceSettingFragment.this);
          if (!paramAnonymousBoolean.booleanValue()) {}
          for (boolean bool = true;; bool = false)
          {
            VoiceSettingFragment.a(localVoiceSettingFragment, localTextView, bool);
            return;
          }
        }
      });
      return;
    }
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968829, null);
    setCommonTitleBar(this.mContentView, getStringUtil(2131296359));
    this.b = ((SwitchButton)this.mContentView.findViewById(2131625241));
    this.c = ((TextView)this.mContentView.findViewById(2131625243));
    this.d = ((TextView)this.mContentView.findViewById(2131625244));
    return this.mContentView;
  }
  
  public void onDestroyView()
  {
    this.a.b();
    super.onDestroyView();
  }
  
  public void onInitFocusAreas()
  {
    super.onInitFocusAreas();
    if (this.e == null)
    {
      this.e = new com.baidu.carlife.f.g(this.mContentView.findViewById(2131624260), 2);
      this.e.d(this.mContentView.findViewById(2131624258));
    }
    if (this.f == null)
    {
      this.f = new com.baidu.carlife.f.g(this.mContentView, 4);
      this.f.d(this.b).d(this.c).d(this.d);
    }
    com.baidu.carlife.f.d.a().b(new com.baidu.carlife.f.a[] { this.e, this.f });
    com.baidu.carlife.f.d.a().h(this.e);
  }
  
  protected void onInitView() {}
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
    updateCommonSkin();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/VoiceSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */