package com.baidu.carlife.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.carlife.core.i;
import com.baidu.carlife.custom.a;
import com.baidu.carlife.util.w;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.shell.listener.AuthorizationListener;

public class LoginFragment
  extends ContentFragment
{
  private SapiWebView a;
  
  public void back()
  {
    if (this.mModuleFrom == 3)
    {
      super.back();
      showLatestNaviFragment();
      return;
    }
    super.back();
  }
  
  public void driving()
  {
    i.b("yftech", "LoginFragment driving");
    back();
    a.a().d();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.a.onAuthorizedResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackPressed()
  {
    back();
    return true;
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968775, null);
    this.a = ((SapiWebView)paramLayoutInflater.findViewById(2131624963));
    this.a.setOnFinishCallback(new SapiWebView.OnFinishCallback()
    {
      public void onFinish()
      {
        LoginFragment.this.back();
      }
    });
    this.a.setAuthorizationListener(new AuthorizationListener()
    {
      public void onFailed(int paramAnonymousInt, String paramAnonymousString)
      {
        w.a(StyleManager.getString(2131296561));
        NaviAccountUtils.getInstance().onLoginResult(false);
        LoginFragment.this.back();
      }
      
      public void onSuccess()
      {
        w.a(StyleManager.getString(2131296562));
        NaviAccountUtils.getInstance().onLoginResult(true);
        LoginFragment.this.back();
        NaviAccountUtils.getInstance().asyncGetUserInfo();
        com.baidu.carlife.logic.h.b = true;
        StatisticManager.onEvent("1056", "1056");
        StatisticManager.onEvent("HOME_MINE_0002");
      }
    });
    this.a.loadSmsLogin();
    setBottomBarStatus(false);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    setBottomBarStatus(true);
  }
  
  protected void onInitView() {}
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void stopDriving() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/fragment/LoginFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */