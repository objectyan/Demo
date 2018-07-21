package com.baidu.navi.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.util.p;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.logic.drawable.UrlDrawable;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.SapiConfiguration.Builder;
import com.baidu.sapi2.shell.callback.GetUserInfoCallBack;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.baidu.sapi2.shell.response.GetUserInfoResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;

public class NaviAccountUtils
{
  public static final int BUDSS_CHECK_INTERVAL = 86400000;
  public static final int LOGIN_BUDSS_EXPIRED = 600002;
  public static final int LOGIN_BUDSS_NORMAL = 600001;
  private static final String SP_PHONE_NUMBER = "passportPhone";
  private static final String TAG = "Favorite";
  private SapiAccountManager mAccountManager = null;
  private boolean mIsAccountInit = false;
  private INaviAccountListener mListener;
  private int mLoginType = 0;
  private String mPortraitUrl = null;
  private String mSecurePhoneNum;
  
  public static NaviAccountUtils getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  private void getUserInfo(Handler paramHandler) {}
  
  public void asyncGetBduss(IBdussListener paramIBdussListener)
  {
    if (paramIBdussListener != null) {
      paramIBdussListener.onBduss(this.mAccountManager.getSession("bduss"));
    }
  }
  
  public void asyncGetProtraitUrl(final SapiCallBack<GetPortraitResponse> paramSapiCallBack)
  {
    SapiAccount localSapiAccount = SapiAccountManager.getInstance().getSession();
    SapiAccountManager.getInstance().getAccountService().getPortrait(new SapiCallBack()
    {
      public void onNetworkFailed()
      {
        if (paramSapiCallBack != null) {
          paramSapiCallBack.onNetworkFailed();
        }
      }
      
      public void onSuccess(GetPortraitResponse paramAnonymousGetPortraitResponse)
      {
        if ((paramAnonymousGetPortraitResponse != null) && (!TextUtils.isEmpty(paramAnonymousGetPortraitResponse.portrait))) {
          NaviAccountUtils.access$202(NaviAccountUtils.this, paramAnonymousGetPortraitResponse.portrait);
        }
        if (paramSapiCallBack != null) {
          paramSapiCallBack.onSuccess(paramAnonymousGetPortraitResponse);
        }
      }
      
      public void onSystemError(int paramAnonymousInt)
      {
        if (paramSapiCallBack != null) {
          paramSapiCallBack.onSystemError(paramAnonymousInt);
        }
      }
    }, localSapiAccount.bduss, localSapiAccount.ptoken, localSapiAccount.stoken);
  }
  
  public void asyncGetUserInfo()
  {
    SapiAccount localSapiAccount = SapiAccountManager.getInstance().getSession();
    if (localSapiAccount == null) {
      return;
    }
    SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallBack()
    {
      public void onBdussInvalid()
      {
        i.b("passport", "onBdussInvalid");
      }
      
      public void onFinish()
      {
        i.b("passport", "onFinish");
      }
      
      public void onNetworkFailed()
      {
        NaviAccountUtils.access$302(NaviAccountUtils.this, p.a().a("passportPhone", null));
        i.b("passport", "onNetworkFailed phoneNum=" + NaviAccountUtils.this.mSecurePhoneNum);
      }
      
      public void onSuccess(GetUserInfoResponse paramAnonymousGetUserInfoResponse)
      {
        if (paramAnonymousGetUserInfoResponse != null)
        {
          NaviAccountUtils.access$302(NaviAccountUtils.this, paramAnonymousGetUserInfoResponse.secureMobile);
          p.a().b("passportPhone", NaviAccountUtils.this.mSecurePhoneNum);
          FavoritePois.getPoiInstance().setBduid(paramAnonymousGetUserInfoResponse.uid);
          i.b("passport", "onSuccess phoneNum=" + NaviAccountUtils.this.mSecurePhoneNum + ", uid:" + paramAnonymousGetUserInfoResponse.uid);
        }
      }
      
      public void onSystemError(int paramAnonymousInt)
      {
        i.b("passport", "onSystemError");
      }
    }, localSapiAccount.bduss);
  }
  
  public void asyncSetPortraitToImageView(final ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    if (this.mPortraitUrl != null)
    {
      paramImageView.setImageDrawable(UrlDrawable.getDrawable(this.mPortraitUrl));
      return;
    }
    SapiAccount localSapiAccount = SapiAccountManager.getInstance().getSession();
    SapiAccountManager.getInstance().getAccountService().getPortrait(new SapiCallBack()
    {
      public void onNetworkFailed() {}
      
      public void onSuccess(GetPortraitResponse paramAnonymousGetPortraitResponse)
      {
        if ((paramAnonymousGetPortraitResponse != null) && (!TextUtils.isEmpty(paramAnonymousGetPortraitResponse.portrait)))
        {
          NaviAccountUtils.access$202(NaviAccountUtils.this, paramAnonymousGetPortraitResponse.portrait);
          paramImageView.setImageDrawable(UrlDrawable.getDrawable(paramAnonymousGetPortraitResponse.portrait));
        }
      }
      
      public void onSystemError(int paramAnonymousInt) {}
    }, localSapiAccount.bduss, localSapiAccount.ptoken, localSapiAccount.stoken);
  }
  
  public void firstLaunch() {}
  
  public String getPToken()
  {
    return this.mAccountManager.getSession("ptoken");
  }
  
  public String getPortraitUrl()
  {
    return this.mPortraitUrl;
  }
  
  public String getSToken()
  {
    return this.mAccountManager.getSession("stoken");
  }
  
  public String getSecurePhoneNum()
  {
    return this.mSecurePhoneNum;
  }
  
  public String getUid()
  {
    return this.mAccountManager.getSession("uid");
  }
  
  public String getUserName()
  {
    return this.mAccountManager.getSession("displayname");
  }
  
  public void initAccount(Context paramContext)
  {
    paramContext = new SapiConfiguration.Builder(paramContext);
    paramContext.setProductLineInfo("navi", "1", "74f335623ec2a2cc327f7951e6974f3f");
    if (BNSettingManager.isUserAccountOnline()) {
      paramContext.setRuntimeEnvironment(Domain.DOMAIN_ONLINE);
    }
    for (;;)
    {
      paramContext.setSocialBindType(BindType.IMPLICIT);
      paramContext = paramContext.build();
      this.mAccountManager.init(paramContext);
      return;
      paramContext.setRuntimeEnvironment(Domain.DOMAIN_QA);
    }
  }
  
  public boolean isLogin()
  {
    return this.mAccountManager.isLogin();
  }
  
  public boolean isLogin(Handler paramHandler)
  {
    boolean bool = false;
    long l2;
    if (this.mAccountManager.isLogin())
    {
      long l1 = BNSettingManager.getLastCheckBudssTime();
      l2 = System.currentTimeMillis();
      LogUtil.e("wywy", "mlastTimeCheckBudss=" + l1 + " curTime=" + l2 + " diff=" + (l2 - l1));
      if (l2 - l1 < 86400000L) {
        bool = true;
      }
    }
    else
    {
      return bool;
    }
    BNSettingManager.setLastCheckBudssTime(l2);
    getUserInfo(paramHandler);
    return false;
  }
  
  public void logout()
  {
    this.mAccountManager.logout();
    this.mPortraitUrl = null;
    this.mSecurePhoneNum = null;
    p.a().c("passportPhone");
  }
  
  public void onLoginResult(boolean paramBoolean)
  {
    String str1 = syncGetBduss();
    String str2 = getUid();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      if (!paramBoolean) {
        break label153;
      }
      LogUtil.e("", "ugc=====NaviAccountUtils22  userId " + str2);
      if (!str2.equals("-1")) {
        LogUtil.e("", "ugc=====NaviAccountUtils22  userId " + str2);
      }
      JNITrajectoryControl.sInstance.updateUserInfo(str1, str2, 1);
      TrackDataShop.getInstance().updateNotLoginTracksBduis(str2);
    }
    for (;;)
    {
      TrackConfig.getInstance().setTotalDistanse(0);
      FavoritePois.getPoiInstance().login(str2);
      switch (this.mLoginType)
      {
      case 0: 
      default: 
        return;
        label153:
        JNITrajectoryControl.sInstance.updateUserInfo(str1, str2, 0);
      }
    }
    if ((this.mListener != null) && (paramBoolean)) {
      this.mListener.onLoginSuccess();
    }
    this.mListener = null;
    this.mLoginType = 0;
    return;
    if (this.mListener != null) {
      this.mListener.onReloginSuccess(paramBoolean);
    }
    this.mListener = null;
    this.mLoginType = 0;
  }
  
  public void openLoginActivity(Activity paramActivity, INaviAccountListener paramINaviAccountListener)
  {
    if (!NetworkUtils.isNetworkAvailable(paramActivity.getApplicationContext()))
    {
      TipTool.onCreateToastDialog(paramActivity, paramActivity.getString(2131296718));
      return;
    }
    int i = h.a().d();
    if (i == 4001) {
      i = 1;
    }
    for (;;)
    {
      paramActivity = new Bundle();
      paramActivity.putInt("module_from", i);
      h.a().showFragment(548, paramActivity);
      this.mListener = paramINaviAccountListener;
      this.mLoginType = 1;
      return;
      if (i == 4004) {
        i = 4;
      } else if (i == 4002) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  public void reLogin(Activity paramActivity, final INaviAccountListener paramINaviAccountListener)
  {
    paramActivity = SapiAccountManager.getInstance().getSession().getReloginCredentials();
    SapiAccountManager.getInstance().getAccountService().relogin(new SapiCallBack()
    {
      public void onNetworkFailed()
      {
        paramINaviAccountListener.onReloginSuccess(false);
      }
      
      public void onSuccess(SapiResponse paramAnonymousSapiResponse)
      {
        paramAnonymousSapiResponse = NaviAccountUtils.this.syncGetBduss();
        String str = NaviAccountUtils.this.getUid();
        if ((!TextUtils.isEmpty(paramAnonymousSapiResponse)) && (!TextUtils.isEmpty(str)))
        {
          LogUtil.e("", "ugc=====NaviAccountUtils11  userId " + str);
          if (!str.equals("-1")) {
            LogUtil.e("", "ugc=====NaviAccountUtils11  userId " + str);
          }
          JNITrajectoryControl.sInstance.updateUserInfo(paramAnonymousSapiResponse, str, 1);
        }
        paramINaviAccountListener.onReloginSuccess(true);
      }
      
      public void onSystemError(int paramAnonymousInt)
      {
        paramINaviAccountListener.onReloginSuccess(false);
      }
    }, paramActivity);
  }
  
  public void setUserHeadToImageView(ImageView paramImageView)
  {
    if (paramImageView == null) {}
    do
    {
      return;
      paramImageView = SapiAccountManager.getInstance().getSession();
    } while (paramImageView == null);
    SapiAccountManager.getInstance().getAccountService().getPortrait(new SapiCallBack()
    {
      public void onNetworkFailed() {}
      
      public void onSuccess(GetPortraitResponse paramAnonymousGetPortraitResponse)
      {
        if ((paramAnonymousGetPortraitResponse != null) && (!TextUtils.isEmpty(paramAnonymousGetPortraitResponse.portrait))) {
          NaviAccountUtils.access$202(NaviAccountUtils.this, paramAnonymousGetPortraitResponse.portrait);
        }
      }
      
      public void onSystemError(int paramAnonymousInt) {}
    }, paramImageView.bduss, paramImageView.ptoken, paramImageView.stoken);
  }
  
  public String syncGetBduss()
  {
    if ((this.mAccountManager != null) && (this.mAccountManager.isLogin())) {
      return this.mAccountManager.getSession("bduss");
    }
    return "";
  }
  
  public static abstract interface IBdussListener
  {
    public abstract void onBduss(String paramString);
  }
  
  public static abstract interface INaviAccountListener
  {
    public abstract void onLoginSuccess();
    
    public abstract void onReloginSuccess(boolean paramBoolean);
  }
  
  private static class LazyHolder
  {
    private static final NaviAccountUtils sInstance = new NaviAccountUtils(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/util/NaviAccountUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */