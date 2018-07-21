package com.baidu.navi.controller;

import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.NaviAccountUtils.INaviAccountListener;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.userdata.BNFavoriteManager;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;

public class AccountController
{
  public static final int ACCOUNT_STATE_NEWUSER = 1;
  public static final int ACCOUNT_STATE_SWITCHUSER = 2;
  public static final int ACCOUNT_STATE_UNLOGIN = 0;
  public static final int MSG_EVENT_LOGOUT = 100;
  private int mAccoutState = 0;
  private IAccountListener mLogoutListener;
  
  public static AccountController getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  private String getPrefUserId()
  {
    return PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getString("user_pre_uid", "default");
  }
  
  private String setPrefUserId(String paramString)
  {
    return PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getString("user_pre_uid", paramString);
  }
  
  private int updateLoginState()
  {
    if (NaviAccountUtils.getInstance().isLogin())
    {
      String str1 = NaviAccountUtils.getInstance().getUserName();
      String str2 = NaviAccountUtils.getInstance().getUid();
      String str3 = getPrefUserId();
      if ((str2 != null) && (!str2.equals(str3)))
      {
        PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putString("PREF_CURRENT_USERNAME", str1);
        setPrefUserId(str2);
        if (!str3.equals("default")) {
          break label78;
        }
        this.mAccoutState = 1;
      }
    }
    for (;;)
    {
      return this.mAccoutState;
      label78:
      this.mAccoutState = 2;
      continue;
      this.mAccoutState = 0;
    }
  }
  
  public void loginIn(IAccountListener paramIAccountListener)
  {
    if (!NaviAccountUtils.getInstance().isLogin()) {
      NaviAccountUtils.getInstance().openLoginActivity(BNaviModuleManager.getActivity(), new NaviAccount(paramIAccountListener));
    }
  }
  
  public void logout()
  {
    String str = NaviAccountUtils.getInstance().getUid();
    NaviAccountUtils.getInstance().logout();
    FavoritePois.getPoiInstance().setBduid(str);
    FavoritePois.getPoiInstance().logoutCleanUp();
    JNITrajectoryControl.sInstance.logoutCleanUp();
    TrackConfig.getInstance().setTotalDistanse(0);
    setPrefUserId("default");
  }
  
  public void relogin()
  {
    NaviAccountUtils.getInstance().openLoginActivity(BNaviModuleManager.getActivity(), new NaviAccount(null));
  }
  
  public void setLogoutListener(IAccountListener paramIAccountListener)
  {
    this.mLogoutListener = paramIAccountListener;
  }
  
  public static abstract interface IAccountListener
  {
    public abstract void onLogResult(boolean paramBoolean);
  }
  
  private static class LazyHolder
  {
    private static AccountController sInstance = new AccountController(null);
  }
  
  private class NaviAccount
    implements NaviAccountUtils.INaviAccountListener
  {
    private AccountController.IAccountListener mListener;
    
    public NaviAccount(AccountController.IAccountListener paramIAccountListener)
    {
      this.mListener = paramIAccountListener;
    }
    
    public void onLoginSuccess()
    {
      AccountController.this.getPrefUserId();
      if (AccountController.this.updateLoginState() == 2)
      {
        LogUtil.e("Account", "zyq switchUser");
        JNITrajectoryControl.sInstance.logoutCleanUp();
        BNFavoriteManager.getInstance().cleanAllFavPois();
      }
      if (this.mListener != null) {
        this.mListener.onLogResult(true);
      }
    }
    
    public void onReloginSuccess(boolean paramBoolean)
    {
      if (this.mListener != null) {
        this.mListener.onLogResult(paramBoolean);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/AccountController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */