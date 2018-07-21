package com.baidu.carlife.fragment;

import android.annotation.SuppressLint;
import com.baidu.carlife.core.i;

@SuppressLint({"ValidFragment"})
public class HomeHelpFragment
  extends BaseSettingFragment<com.baidu.carlife.logic.b.b.a>
{
  protected String a()
  {
    return getString(2131296356);
  }
  
  protected com.baidu.carlife.c.b.a<com.baidu.carlife.logic.b.b.a> b()
  {
    return new com.baidu.carlife.logic.b.a.a();
  }
  
  protected com.baidu.carlife.c.e.b<com.baidu.carlife.logic.b.b.a> c()
  {
    return new com.baidu.carlife.logic.b.c.b.a(this);
  }
  
  public void driving()
  {
    i.b("yftech", "HomeHelpFragment driving");
    if (com.baidu.carlife.custom.b.a().b())
    {
      dismissDialog();
      back();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    setBottomBarStatus(true);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/HomeHelpFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */