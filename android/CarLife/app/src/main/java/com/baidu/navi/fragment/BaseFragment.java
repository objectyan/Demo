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
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.BaseDialog;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.C1269a;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.core.screen.C1278f;
import com.baidu.carlife.core.screen.C1283l;
import com.baidu.carlife.core.screen.C1284m;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.core.screen.presentation.p071a.C1308f;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.fragment.WebViewFragment;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.logic.CommandCenter;

public abstract class BaseFragment extends Fragment implements C1277e, C1278f, C1283l, C1284m {
    private static final String TAG = "Framework";
    public static CarlifeActivity mActivity;
    protected static boolean mResumeMapView = true;
    protected static boolean mUpdateIts = true;
    protected int fragmentType;
    private C1308f mCarlifeView;
    protected View mContentView;
    protected boolean mDayStyle;
    protected boolean mEnableLandInMapMode = false;
    private C1328h mFragmentManagerCallbackProxy;
    protected int mOrientation;
    protected boolean mViewCreated = false;

    protected abstract void onUpdateOrientation(int i);

    protected abstract void onUpdateStyle(boolean z);

    public static void initBeforeAll(CarlifeActivity activity) {
        mActivity = activity;
    }

    public void onAttach(Context activity) {
        super.onAttach(activity);
        C1260i.b("Framework", "onAttach: " + getClass().getName());
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C1260i.b("Framework", "onCreate: " + getClass().getName());
        this.mFragmentManagerCallbackProxy = C1328h.a();
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        C1260i.b("Framework", "onCreateView: " + getClass().getName());
        this.mFragmentManagerCallbackProxy = C1328h.a();
        this.mCarlifeView = C1309g.a().b();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        C1260i.b("Framework", "onActivityCreated");
    }

    public void onStart() {
        super.onStart();
        C1260i.b("Framework", "onStart");
    }

    public void onResume() {
        super.onResume();
        C1260i.b("Framework", "onResume");
    }

    public void onPause() {
        super.onPause();
        C1260i.b("Framework", "onPause");
    }

    public void onStop() {
        super.onStop();
        C1260i.b("Framework", "onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        C1260i.b("Framework", "onDestroyView");
    }

    public void onDestroy() {
        super.onDestroy();
        C1260i.b("Framework", "onDestroy");
    }

    public void onDetach() {
        super.onDetach();
        C1260i.b("Framework", "onDetach");
    }

    public void cancelRequest() {
        CommandCenter.getInstance().cancelRequest(getClass().getSimpleName());
    }

    public void updateOrientation(int orientation) {
        C1260i.b("Framework", "updateOrientation orientation " + orientation);
        if (this.mViewCreated) {
            onUpdateOrientation(orientation);
        }
        this.mOrientation = orientation;
    }

    public void updateStyle(boolean dayStyle) {
        C1260i.b("Framework", "updateStyle");
        if (this.mViewCreated) {
            onUpdateStyle(dayStyle);
        }
        this.mDayStyle = dayStyle;
    }

    protected void forbiddenLanscapse() {
        if (BNSettingManager.getCurrentUsingMode() != 1) {
            return;
        }
        if (this.mEnableLandInMapMode) {
            mActivity.setRequestedOrientation(-1);
        } else {
            mActivity.setRequestedOrientation(1);
        }
    }

    protected void enableLandscapse() {
        if (BNSettingManager.getCurrentUsingMode() == 1) {
            this.mEnableLandInMapMode = true;
        }
    }

    public boolean canProcessUI() {
        return isAdded();
    }

    public static CarlifeActivity getNaviActivity() {
        return mActivity;
    }

    public int getType() {
        return this.fragmentType;
    }

    public void setType(int fragmentType) {
        this.fragmentType = fragmentType;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    public String getStringUtil(int resId) {
        return mActivity.getString(resId);
    }

    public void openWebView(int webviewType, int type, String title, String url) {
        Bundle bundle = new Bundle();
        bundle.putInt(WebViewFragment.f4863c, webviewType);
        bundle.putString(WebViewFragment.f4861a, title);
        bundle.putString(WebViewFragment.f4862b, url);
        showFragment(type, bundle);
    }

    public void showDialog(BaseDialog childView) {
        this.mCarlifeView.showDialog(childView);
    }

    public void showDialog(BaseDialog childView, C1265a gravity) {
        this.mCarlifeView.showDialog(childView, gravity);
    }

    public void dismissDialog() {
        this.mCarlifeView.dismissDialog();
    }

    public void dismissDialog(BaseDialog childView) {
        this.mCarlifeView.dismissDialog(childView);
    }

    public void cancelDialog() {
        this.mCarlifeView.cancelDialog();
    }

    public void cancelDialog(BaseDialog childView) {
        this.mCarlifeView.cancelDialog(childView);
    }

    public boolean isDialogShown() {
        return this.mCarlifeView.isDialogShown();
    }

    public void back() {
        back(null);
    }

    public void back(Bundle bundle) {
        if (this.mFragmentManagerCallbackProxy != null) {
            this.mFragmentManagerCallbackProxy.back(bundle);
        }
    }

    public void removeWeChatFragmentFromStack() {
        this.mFragmentManagerCallbackProxy.removeWeChatFragmentFromStack();
    }

    public void backTo(int type, Bundle bundle) {
        this.mFragmentManagerCallbackProxy.backTo(type, bundle);
    }

    public void showFragment(int type, Bundle bundle) {
        this.mFragmentManagerCallbackProxy.showFragment(type, bundle);
    }

    public void showPluginFrament(Fragment fragment) {
        this.mFragmentManagerCallbackProxy.showPluginFrament(fragment);
    }

    public void push(ContentFragment fragment) {
        this.mFragmentManagerCallbackProxy.push(fragment);
    }

    public void removeFragmentTo(int type) {
        this.mFragmentManagerCallbackProxy.removeFragmentTo(type);
    }

    public void removeAllFragmentByType(int fragmentType) {
        this.mFragmentManagerCallbackProxy.removeAllFragmentByType(fragmentType);
    }

    public ContentFragment getCurrentFragment() {
        return this.mFragmentManagerCallbackProxy.getCurrentFragment();
    }

    public int getCurrentFragmentType() {
        return this.mFragmentManagerCallbackProxy.getCurrentFragmentType();
    }

    public NaviFragmentManager getNaviFragmentManager() {
        return this.mFragmentManagerCallbackProxy.getNaviFragmentManager();
    }

    public void showLatestHomeFragment() {
        this.mFragmentManagerCallbackProxy.showLatestHomeFragment();
    }

    public void showLatestMusicFragment() {
        this.mFragmentManagerCallbackProxy.showLatestMusicFragment();
    }

    public void showLatestPhoneFragment() {
        this.mFragmentManagerCallbackProxy.showLatestPhoneFragment();
    }

    public void showLatestNaviFragment() {
        this.mFragmentManagerCallbackProxy.showLatestNaviFragment();
    }

    public boolean isCarlifeFragment(int type) {
        return this.mFragmentManagerCallbackProxy.isCarlifeFragment(type);
    }

    public ContentFragment createFragment(int type) {
        return this.mFragmentManagerCallbackProxy.createFragment(type);
    }

    public boolean isProgressDialogShowing() {
        return this.mCarlifeView.d();
    }

    public boolean showConnectForbidDialog() {
        return this.mCarlifeView.showConnectForbidDialog();
    }

    public void updateMainDisplayStatus(int modeType) {
        this.mCarlifeView.updateMainDisplayStatus(modeType);
    }

    public void updateGaussianBlurBackground() {
        this.mCarlifeView.updateGaussianBlurBackground();
    }

    public void setBottomBarStatus(boolean show) {
        if (this.mCarlifeView != null) {
            this.mCarlifeView.setBottomBarStatus(show);
        }
    }

    public void setBottomBarBackgroud(Drawable drawable) {
        if (this.mCarlifeView != null) {
            this.mCarlifeView.setBottomBarBackgroud(drawable);
        }
    }

    public void innerNameSearch(String key) {
        this.mCarlifeView.innerNameSearch(key);
    }

    public void openNaviFromOutSide(int type, Bundle bundle) {
        this.mCarlifeView.openNaviFromOutSide(type, bundle);
    }

    public void openNavi() {
        this.mCarlifeView.openNavi();
    }

    public void openNavi(Bundle bundle) {
        this.mCarlifeView.openNavi(bundle);
    }

    public void startCalcRoute(C1269a poi) {
        this.mCarlifeView.startCalcRoute(poi);
    }

    public void showWindowView(View view, LayoutParams layoutParams) {
        this.mCarlifeView.showWindowView(view, layoutParams);
    }

    public void hideWindowView() {
        this.mCarlifeView.hideWindowView();
    }

    public boolean isWindowViewShown() {
        return this.mCarlifeView.isWindowViewShown();
    }

    public void performOpenHome() {
        this.mCarlifeView.performOpenHome();
    }

    protected void showGuideHint(String hintStr) {
        this.mCarlifeView.a(hintStr);
    }

    protected void dismissGuideHint() {
        this.mCarlifeView.a();
    }

    public void hideMapFragment() {
        this.mCarlifeView.hideMapFragment();
    }

    public void showMapFragment() {
        this.mCarlifeView.showMapFragment();
    }

    public boolean isNaviMapFragment() {
        return this.mFragmentManagerCallbackProxy.isNaviMapFragment();
    }

    public int getNextFragmentType() {
        return this.mFragmentManagerCallbackProxy.getNextFragmentType();
    }
}
