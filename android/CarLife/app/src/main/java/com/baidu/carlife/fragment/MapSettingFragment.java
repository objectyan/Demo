package com.baidu.carlife.fragment;

public class MapSettingFragment
  extends BaseSettingFragment<com.baidu.carlife.logic.b.b.a>
{
  protected String a()
  {
    return getStringUtil(2131296358);
  }
  
  protected com.baidu.carlife.c.b.a<com.baidu.carlife.logic.b.b.a> b()
  {
    return new com.baidu.carlife.logic.b.a.b();
  }
  
  protected com.baidu.carlife.c.e.b<com.baidu.carlife.logic.b.b.a> c()
  {
    return new com.baidu.carlife.logic.b.c.b.b();
  }
  
  public void onResume()
  {
    super.onResume();
    setBottomBarStatus(true);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/MapSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */