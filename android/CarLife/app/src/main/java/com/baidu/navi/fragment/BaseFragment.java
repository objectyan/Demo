package com.baidu.navi.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.BaseDialog;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.core.screen.a;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.core.screen.l;
import com.baidu.carlife.core.screen.m;
import com.baidu.carlife.core.screen.presentation.a.g;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.logic.CommandCenter;

public abstract class BaseFragment
  extends Fragment
  implements e, com.baidu.carlife.core.screen.f, l, m
{
  private static final String TAG = "Framework";
  public static CarlifeActivity mActivity;
  protected static boolean mResumeMapView = true;
  protected static boolean mUpdateIts = true;
  protected int fragmentType;
  private com.baidu.carlife.core.screen.presentation.a.f mCarlifeView;
  protected View mContentView;
  protected boolean mDayStyle;
  protected boolean mEnableLandInMapMode = false;
  private h mFragmentManagerCallbackProxy;
  protected int mOrientation;
  protected boolean mViewCreated = false;
  
  public static CarlifeActivity getNaviActivity()
  {
    return mActivity;
  }
  
  public static void initBeforeAll(CarlifeActivity paramCarlifeActivity)
  {
    mActivity = paramCarlifeActivity;
  }
  
  public void back()
  {
    back(null);
  }
  
  public void back(Bundle paramBundle)
  {
    if (this.mFragmentManagerCallbackProxy != null) {
      this.mFragmentManagerCallbackProxy.back(paramBundle);
    }
  }
  
  public void backTo(int paramInt, Bundle paramBundle)
  {
    this.mFragmentManagerCallbackProxy.backTo(paramInt, paramBundle);
  }
  
  public boolean canProcessUI()
  {
    return isAdded();
  }
  
  public void cancelDialog()
  {
    this.mCarlifeView.cancelDialog();
  }
  
  public void cancelDialog(BaseDialog paramBaseDialog)
  {
    this.mCarlifeView.cancelDialog(paramBaseDialog);
  }
  
  public void cancelRequest()
  {
    CommandCenter.getInstance().cancelRequest(getClass().getSimpleName());
  }
  
  public ContentFragment createFragment(int paramInt)
  {
    return this.mFragmentManagerCallbackProxy.createFragment(paramInt);
  }
  
  public void dismissDialog()
  {
    this.mCarlifeView.dismissDialog();
  }
  
  public void dismissDialog(BaseDialog paramBaseDialog)
  {
    this.mCarlifeView.dismissDialog(paramBaseDialog);
  }
  
  protected void dismissGuideHint()
  {
    this.mCarlifeView.a();
  }
  
  protected void enableLandscapse()
  {
    if (BNSettingManager.getCurrentUsingMode() == 1) {
      this.mEnableLandInMapMode = true;
    }
  }
  
  protected void forbiddenLanscapse()
  {
    if (BNSettingManager.getCurrentUsingMode() == 1)
    {
      if (this.mEnableLandInMapMode) {
        mActivity.setRequestedOrientation(-1);
      }
    }
    else {
      return;
    }
    mActivity.setRequestedOrientation(1);
  }
  
  public ContentFragment getCurrentFragment()
  {
    return this.mFragmentManagerCallbackProxy.getCurrentFragment();
  }
  
  public int getCurrentFragmentType()
  {
    return this.mFragmentManagerCallbackProxy.getCurrentFragmentType();
  }
  
  public NaviFragmentManager getNaviFragmentManager()
  {
    return this.mFragmentManagerCallbackProxy.getNaviFragmentManager();
  }
  
  public int getNextFragmentType()
  {
    return this.mFragmentManagerCallbackProxy.getNextFragmentType();
  }
  
  public String getStringUtil(int paramInt)
  {
    return mActivity.getString(paramInt);
  }
  
  public int getType()
  {
    return this.fragmentType;
  }
  
  public void hideMapFragment()
  {
    this.mCarlifeView.hideMapFragment();
  }
  
  public void hideWindowView()
  {
    this.mCarlifeView.hideWindowView();
  }
  
  public void innerNameSearch(String paramString)
  {
    this.mCarlifeView.innerNameSearch(paramString);
  }
  
  public boolean isCarlifeFragment(int paramInt)
  {
    return this.mFragmentManagerCallbackProxy.isCarlifeFragment(paramInt);
  }
  
  public boolean isDialogShown()
  {
    return this.mCarlifeView.isDialogShown();
  }
  
  public boolean isNaviMapFragment()
  {
    return this.mFragmentManagerCallbackProxy.isNaviMapFragment();
  }
  
  public boolean isProgressDialogShowing()
  {
    return this.mCarlifeView.d();
  }
  
  public boolean isWindowViewShown()
  {
    return this.mCarlifeView.isWindowViewShown();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    i.b("Framework", "onActivityCreated");
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    i.b("Framework", "onAttach: " + getClass().getName());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i.b("Framework", "onCreate: " + getClass().getName());
    this.mFragmentManagerCallbackProxy = h.a();
    setHasOptionsMenu(true);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    i.b("Framework", "onCreateView: " + getClass().getName());
    this.mFragmentManagerCallbackProxy = h.a();
    this.mCarlifeView = g.a().b();
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    i.b("Framework", "onDestroy");
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    i.b("Framework", "onDestroyView");
  }
  
  public void onDetach()
  {
    super.onDetach();
    i.b("Framework", "onDetach");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onPause()
  {
    super.onPause();
    i.b("Framework", "onPause");
  }
  
  public void onResume()
  {
    super.onResume();
    i.b("Framework", "onResume");
  }
  
  public void onStart()
  {
    super.onStart();
    i.b("Framework", "onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    i.b("Framework", "onStop");
  }
  
  protected abstract void onUpdateOrientation(int paramInt);
  
  protected abstract void onUpdateStyle(boolean paramBoolean);
  
  public void openNavi()
  {
    this.mCarlifeView.openNavi();
  }
  
  public void openNavi(Bundle paramBundle)
  {
    this.mCarlifeView.openNavi(paramBundle);
  }
  
  public void openNaviFromOutSide(int paramInt, Bundle paramBundle)
  {
    this.mCarlifeView.openNaviFromOutSide(paramInt, paramBundle);
  }
  
  public void openWebView(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("bundle_type", paramInt1);
    localBundle.putString("bundle_title_key", paramString1);
    localBundle.putString("bundle_url_key", paramString2);
    showFragment(paramInt2, localBundle);
  }
  
  public void performOpenHome()
  {
    this.mCarlifeView.performOpenHome();
  }
  
  public void push(ContentFragment paramContentFragment)
  {
    this.mFragmentManagerCallbackProxy.push(paramContentFragment);
  }
  
  public void removeAllFragmentByType(int paramInt)
  {
    this.mFragmentManagerCallbackProxy.removeAllFragmentByType(paramInt);
  }
  
  public void removeFragmentTo(int paramInt)
  {
    this.mFragmentManagerCallbackProxy.removeFragmentTo(paramInt);
  }
  
  public void removeWeChatFragmentFromStack()
  {
    this.mFragmentManagerCallbackProxy.removeWeChatFragmentFromStack();
  }
  
  public void setBottomBarBackgroud(Drawable paramDrawable)
  {
    if (this.mCarlifeView != null) {
      this.mCarlifeView.setBottomBarBackgroud(paramDrawable);
    }
  }
  
  public void setBottomBarStatus(boolean paramBoolean)
  {
    if (this.mCarlifeView != null) {
      this.mCarlifeView.setBottomBarStatus(paramBoolean);
    }
  }
  
  public void setType(int paramInt)
  {
    this.fragmentType = paramInt;
  }
  
  public boolean showConnectForbidDialog()
  {
    return this.mCarlifeView.showConnectForbidDialog();
  }
  
  public void showDialog(BaseDialog paramBaseDialog)
  {
    this.mCarlifeView.showDialog(paramBaseDialog);
  }
  
  public void showDialog(BaseDialog paramBaseDialog, BaseDialog.a parama)
  {
    this.mCarlifeView.showDialog(paramBaseDialog, parama);
  }
  
  public void showFragment(int paramInt, Bundle paramBundle)
  {
    this.mFragmentManagerCallbackProxy.showFragment(paramInt, paramBundle);
  }
  
  protected void showGuideHint(String paramString)
  {
    this.mCarlifeView.a(paramString);
  }
  
  public void showLatestHomeFragment()
  {
    this.mFragmentManagerCallbackProxy.showLatestHomeFragment();
  }
  
  public void showLatestMusicFragment()
  {
    this.mFragmentManagerCallbackProxy.showLatestMusicFragment();
  }
  
  public void showLatestNaviFragment()
  {
    this.mFragmentManagerCallbackProxy.showLatestNaviFragment();
  }
  
  public void showLatestPhoneFragment()
  {
    this.mFragmentManagerCallbackProxy.showLatestPhoneFragment();
  }
  
  public void showMapFragment()
  {
    this.mCarlifeView.showMapFragment();
  }
  
  public void showPluginFrament(Fragment paramFragment)
  {
    this.mFragmentManagerCallbackProxy.showPluginFrament(paramFragment);
  }
  
  public void showWindowView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.mCarlifeView.showWindowView(paramView, paramLayoutParams);
  }
  
  public void startCalcRoute(a parama)
  {
    this.mCarlifeView.startCalcRoute(parama);
  }
  
  public void updateGaussianBlurBackground()
  {
    this.mCarlifeView.updateGaussianBlurBackground();
  }
  
  public void updateMainDisplayStatus(int paramInt)
  {
    this.mCarlifeView.updateMainDisplayStatus(paramInt);
  }
  
  public void updateOrientation(int paramInt)
  {
    i.b("Framework", "updateOrientation orientation " + paramInt);
    if (this.mViewCreated) {
      onUpdateOrientation(paramInt);
    }
    this.mOrientation = paramInt;
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    i.b("Framework", "updateStyle");
    if (this.mViewCreated) {
      onUpdateStyle(paramBoolean);
    }
    this.mDayStyle = paramBoolean;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/BaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */