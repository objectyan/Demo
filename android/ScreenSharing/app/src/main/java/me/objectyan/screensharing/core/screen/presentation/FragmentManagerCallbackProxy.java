package me.objectyan.screensharing.core.screen.presentation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AndroidRuntimeException;

import me.objectyan.screensharing.core.screen.OnFragmentManagerCallback;


public class FragmentManagerCallbackProxy implements OnFragmentManagerCallback {

    private static FragmentManagerCallbackProxy sFragmentManagerCallbackProxy;

//    private NaviFragmentManager f3825b;

    private FragmentManagerCallbackProxy() {
//        this.f3825b = naviFragmentManager;
    }


    public static FragmentManagerCallbackProxy m4757a() {
        if (sFragmentManagerCallbackProxy != null) {
            return sFragmentManagerCallbackProxy;
        }
        throw new AndroidRuntimeException("Please call init method first.");
    }


//    public static void m4758a(NaviFragmentManager naviFragmentManager) {
//        sFragmentManagerCallbackProxy = new FragmentManagerCallbackProxy(naviFragmentManager);
//    }


//    public void m4761a(OnFragmentListener listener) {
//        this.f3825b.setFragmentManager(listener);
//    }

    public void back() {
        back(null);
    }

    @Override
    public void back(Bundle bundle) {

    }

    @Override
    public void backTo(int i, Bundle bundle) {

    }

//    @Override
//    public ContentFragment createFragment(int i) {
//        return null;
//    }

//    @Override
//    public ContentFragment getCurrentFragment() {
//        return null;
//    }

    @Override
    public int getCurrentFragmentType() {
        return 0;
    }

//    @Override
//    public NaviFragmentManager getNaviFragmentManager() {
//        return null;
//    }

    @Override
    public int getNextFragmentType() {
        return 0;
    }

    @Override
    public boolean isCarlifeFragment(int i) {
        return false;
    }

    @Override
    public boolean isNaviMapFragment() {
        return false;
    }

//    @Override
//    public void push(ContentFragment contentFragment) {
//
//    }

    @Override
    public void removeAllFragmentByType(int i) {

    }

    @Override
    public void removeFragmentTo(int i) {

    }

    @Override
    public void removeWeChatFragmentFromStack() {

    }

    @Override
    public void showFragment(int i, Bundle bundle) {

    }

    @Override
    public void showLatestHomeFragment() {

    }

    @Override
    public void showLatestMusicFragment() {

    }

    @Override
    public void showLatestNaviFragment() {

    }

    @Override
    public void showLatestPhoneFragment() {

    }

    @Override
    public void showPluginFrament(Fragment fragment) {

    }

//    public void back(Bundle bundle) {
//        this.f3825b.back(bundle);
//    }

//    public void backTo(int type, Bundle bundle) {
//        this.f3825b.backTo(type, bundle);
//    }
//
//    public void removeWeChatFragmentFromStack() {
//        this.f3825b.removeWeChatFragmentFromStack();
//    }
//
//    public void showFragment(int type, Bundle bundle) {
//        this.f3825b.showFragment(type, bundle);
//    }
//
//    public void showPluginFrament(Fragment fragment) {
//        this.f3825b.showPluginFrament(fragment);
//    }
//
//    public void push(ContentFragment fragment) {
//        this.f3825b.push(fragment);
//    }
//
//    public void removeFragmentTo(int type) {
//        this.f3825b.removeFragmentTo(type);
//    }
//
//    public void removeAllFragmentByType(int fragmentType) {
//        this.f3825b.removeAllFragmentByType(fragmentType);
//    }
//
//    public ContentFragment getCurrentFragment() {
//        return this.f3825b.getCurrentFragment();
//    }
//
//    public int getCurrentFragmentType() {
//        return this.f3825b.getCurrentFragmentType();
//    }
//
//
//    public boolean m4764b() {
//        return getCurrentFragmentType() == NaviFragmentManager.TYPE_MUSIC_PLAYER;
//    }
//
//    public NaviFragmentManager getNaviFragmentManager() {
//        return this.f3825b;
//    }
//
//    public void showLatestHomeFragment() {
//        this.f3825b.showLatestHomeFragment();
//    }
//
//    public void showLatestMusicFragment() {
//        this.f3825b.showLatestMusicFragment();
//    }
//
//    public void showLatestPhoneFragment() {
//        this.f3825b.showLatestPhoneFragment();
//    }
//
//    public boolean isCarlifeFragment(int type) {
//        return this.f3825b.isCarlifeFragment(type);
//    }
//
//    public ContentFragment createFragment(int type) {
//        return this.f3825b.createFragment(type);
//    }
//
//
//    public boolean m4763a(int type) {
//        return this.f3825b.isCarlifeRadioMusicFragment(type);
//    }
//
//
//    public boolean m4765b(int type) {
//        return this.f3825b.isCarlifeMusicFragment(type);
//    }
//
//
//    public String m4767c() {
//        return this.f3825b.getCurFragmentModule();
//    }
//
//
//    public int m4768d() {
//        return this.f3825b.getCurFragmentModuleType();
//    }
//
//
//    public int m4770e() {
//        int type = m4768d();
//        if (type == 4001) {
//            return 1;
//        }
//        if (type == 4004) {
//            return 4;
//        }
//        if (type == 4002) {
//            return 2;
//        }
//        return 3;
//    }
//
//
//    public ContentFragment m4766c(int type) {
//        return this.f3825b.getLatestFragment(type);
//    }
//
//
//    public boolean m4773f() {
//        return this.f3825b.isNaviStart();
//    }
//
//    public void showLatestNaviFragment() {
//        this.f3825b.backToNavi(null);
//    }
//
//
//    public void m4759a(Bundle bundle) {
//        this.f3825b.backToNavi(bundle);
//    }
//
//
//    public boolean m4769d(int type) {
//        return this.f3825b.isCarlifeHomeFragment(type);
//    }
//
//
//    public boolean m4771e(int type) {
//        return this.f3825b.isCarlifeTelephoneFragment(type);
//    }
//
//
//    public BaseFragment m4774g() {
//        return this.f3825b.getLatestMusicFragment();
//    }
//
//
//    public int m4776h() {
//        return this.f3825b.getFragmentStackSize();
//    }
//
//
//    public int m4772f(int type) {
//        return this.f3825b.findFragmentIndexInStack(type);
//    }
//
//
//    public void m4760a(Fragment fragment) {
//        this.f3825b.removePluginFragment(fragment);
//    }
//
//
//    public void m4762a(OnUIListener listener) {
//        this.f3825b.setUIListener(listener);
//    }
//
//
//    public void m4777i() {
//        this.f3825b.hideAllFragments();
//    }
//
//
//    public Fragment m4778j() {
//        return this.f3825b.getLatestNaviFragment();
//    }
//
//
//    public void m4779k() {
//        this.f3825b.showFirstHomeFragment();
//    }
//
//    public boolean isNaviMapFragment() {
//        return this.f3825b.isMapViewFragment(this.f3825b.mLastFragmentType);
//    }
//
//    public int getNextFragmentType() {
//        return this.f3825b.mLastFragmentType;
//    }
//
//
//    public boolean m4775g(int type) {
//        return this.f3825b.isNeedHideTabFragment(type);
//    }
}
