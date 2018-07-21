package com.baidu.carlife.wechat.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class WechatSettingFragment
  extends a
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private LinearLayout b;
  private CheckBox c;
  private LinearLayout d;
  private CheckBox e;
  private LinearLayout f;
  private ImageButton g;
  
  private void a(View paramView)
  {
    this.g = ((ImageButton)paramView.findViewById(2131625233));
    this.g.setBackground(com.baidu.carlife.view.a.b.a(getActivity()));
    this.g.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        WechatSettingFragment.this.back();
      }
    });
    this.b = ((LinearLayout)paramView.findViewById(2131625234));
    this.b.setOnClickListener(this);
    this.c = ((CheckBox)paramView.findViewById(2131625235));
    this.c.setOnCheckedChangeListener(this);
    this.d = ((LinearLayout)paramView.findViewById(2131625236));
    this.d.setOnClickListener(this);
    this.e = ((CheckBox)paramView.findViewById(2131625237));
    this.e.setOnCheckedChangeListener(this);
    this.f = ((LinearLayout)paramView.findViewById(2131625238));
    this.f.setOnClickListener(this);
    a();
  }
  
  public void a()
  {
    this.c.setChecked(com.baidu.carlife.wechat.g.b.c());
    this.e.setChecked(com.baidu.carlife.wechat.g.b.b());
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131625235) {
      com.baidu.carlife.wechat.g.b.c(paramBoolean);
    }
    while (paramCompoundButton.getId() != 2131625237) {
      return;
    }
    com.baidu.carlife.wechat.g.b.b(paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramView.getId() == 2131625234)
    {
      paramView = this.c;
      if (!this.c.isChecked()) {
        paramView.setChecked(bool1);
      }
    }
    do
    {
      return;
      bool1 = false;
      break;
      if (paramView.getId() == 2131625236)
      {
        paramView = this.e;
        if (!this.e.isChecked()) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramView.setChecked(bool1);
          return;
        }
      }
    } while (paramView.getId() != 2131625238);
    showFragment(590, null);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968828, null);
    paramLayoutInflater.setOnClickListener(null);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected void onInitView() {}
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/fragment/WechatSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */