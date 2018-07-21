package com.baidu.carlife.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.i;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.util.r;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;

public class SettingAboutFragment
  extends ContentFragment
  implements View.OnClickListener
{
  private Button a;
  private Button b;
  private TextView c;
  private g d;
  private g e;
  
  public void driving()
  {
    i.b("yftech", "SettingAboutFragment driving");
    getNaviFragmentManager().back();
    getNaviFragmentManager().back();
    com.baidu.carlife.custom.a.a().d();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131625185: 
      com.baidu.carlife.logic.a.a().a(false);
      return;
    }
    showFragment(540, null);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968810, null);
    setCommonTitleBar(this.mContentView, getString(2131296640));
    this.a = ((Button)this.mContentView.findViewById(2131625185));
    if ("1012961a".equals(f.jt)) {
      this.a.setVisibility(8);
    }
    for (;;)
    {
      this.b = ((Button)this.mContentView.findViewById(2131625186));
      this.b.setOnClickListener(this);
      this.c = ((TextView)this.mContentView.findViewById(2131625182));
      String str = getString(2131297204) + e.g();
      paramLayoutInflater = str;
      if (!"".equals(f.jq)) {
        paramLayoutInflater = str + " (" + f.jq + ")";
      }
      this.c.setText(paramLayoutInflater);
      return this.mContentView;
      this.a.setVisibility(0);
      this.a.setOnClickListener(this);
    }
  }
  
  public void onInitFocusAreas()
  {
    if (this.fragmentType != getCurrentFragmentType()) {
      return;
    }
    if (this.d == null)
    {
      this.d = new g(this.mContentView.findViewById(2131624146), 2);
      this.d.d(this.mContentView.findViewById(2131624258));
    }
    if (this.e == null)
    {
      this.e = new g(this.mContentView, 4);
      if (!"1012961a".equals(f.jt)) {
        this.e.d(this.a);
      }
      this.e.d(this.b);
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.d, this.e });
    d.a().h(this.d);
  }
  
  protected void onInitView() {}
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
    updateCommonSkin();
    this.c.setTextColor(r.a(2131558702));
    this.a.setBackground(r.b(2130838206));
    this.a.setTextColor(r.a(2131558701));
    this.b.setBackground(r.b(2130838206));
    this.b.setTextColor(r.a(2131558701));
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void stopDriving() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/SettingAboutFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */