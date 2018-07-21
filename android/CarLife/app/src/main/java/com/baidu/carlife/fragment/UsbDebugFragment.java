package com.baidu.carlife.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;

public class UsbDebugFragment
  extends ContentFragment
{
  public static final String a = "firstEnter";
  private View b;
  
  public boolean onBackPressed()
  {
    return true;
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mContentView = paramLayoutInflater.inflate(2130968818, null);
    setBottomBarStatus(false);
    this.b = this.mContentView.findViewById(2131625208);
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          BaseFragment.mActivity.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
          UsbDebugFragment.this.showFragment(515, null);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            paramAnonymousView.printStackTrace();
          }
        }
      }
    });
    return this.mContentView;
  }
  
  protected void onInitView() {}
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/UsbDebugFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */