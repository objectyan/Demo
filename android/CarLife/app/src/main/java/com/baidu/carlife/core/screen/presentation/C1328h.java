package com.baidu.carlife.core.screen.presentation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.OnFragmentListener;
import android.util.AndroidRuntimeException;
import com.baidu.carlife.core.screen.C1278f;
import com.baidu.carlife.core.screen.C1283l;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;

/* compiled from: FragmentManagerCallbackProxy */
/* renamed from: com.baidu.carlife.core.screen.presentation.h */
public class C1328h implements C1278f {
    /* renamed from: a */
    private static C1328h f3824a;
    /* renamed from: b */
    private NaviFragmentManager f3825b;

    private C1328h(NaviFragmentManager naviFragmentManager) {
        this.f3825b = naviFragmentManager;
    }

    /* renamed from: a */
    public static C1328h m4757a() {
        if (f3824a != null) {
            return f3824a;
        }
        throw new AndroidRuntimeException("Please call init method first.");
    }

    /* renamed from: a */
    public static void m4758a(NaviFragmentManager naviFragmentManager) {
        f3824a = new C1328h(naviFragmentManager);
    }

    /* renamed from: a */
    public void m4761a(OnFragmentListener listener) {
        this.f3825b.setFragmentManager(listener);
    }

    public void back() {
        back(null);
    }

    public void back(Bundle bundle) {
        this.f3825b.back(bundle);
    }

    public void backTo(int type, Bundle bundle) {
        this.f3825b.backTo(type, bundle);
    }

    public void removeWeChatFragmentFromStack() {
        this.f3825b.removeWeChatFragmentFromStack();
    }

    public void showFragment(int type, Bundle bundle) {
        this.f3825b.showFragment(type, bundle);
    }

    public void showPluginFrament(Fragment fragment) {
        this.f3825b.showPluginFrament(fragment);
    }

    public void push(ContentFragment fragment) {
        this.f3825b.push(fragment);
    }

    public void removeFragmentTo(int type) {
        this.f3825b.removeFragmentTo(type);
    }

    public void removeAllFragmentByType(int fragmentType) {
        this.f3825b.removeAllFragmentByType(fragmentType);
    }

    public ContentFragment getCurrentFragment() {
        return this.f3825b.getCurrentFragment();
    }

    public int getCurrentFragmentType() {
        return this.f3825b.getCurrentFragmentType();
    }

    /* renamed from: b */
    public boolean m4764b() {
        return getCurrentFragmentType() == NaviFragmentManager.TYPE_MUSIC_PLAYER;
    }

    public NaviFragmentManager getNaviFragmentManager() {
        return this.f3825b;
    }

    public void showLatestHomeFragment() {
        this.f3825b.showLatestHomeFragment();
    }

    public void showLatestMusicFragment() {
        this.f3825b.showLatestMusicFragment();
    }

    public void showLatestPhoneFragment() {
        this.f3825b.showLatestPhoneFragment();
    }

    public boolean isCarlifeFragment(int type) {
        return this.f3825b.isCarlifeFragment(type);
    }

    public ContentFragment createFragment(int type) {
        return this.f3825b.createFragment(type);
    }

    /* renamed from: a */
    public boolean m4763a(int type) {
        return this.f3825b.isCarlifeRadioMusicFragment(type);
    }

    /* renamed from: b */
    public boolean m4765b(int type) {
        return this.f3825b.isCarlifeMusicFragment(type);
    }

    /* renamed from: c */
    public String m4767c() {
        return this.f3825b.getCurFragmentModule();
    }

    /* renamed from: d */
    public int m4768d() {
        return this.f3825b.getCurFragmentModuleType();
    }

    /* renamed from: e */
    public int m4770e() {
        int type = m4768d();
        if (type == 4001) {
            return 1;
        }
        if (type == 4004) {
            return 4;
        }
        if (type == 4002) {
            return 2;
        }
        return 3;
    }

    /* renamed from: c */
    public ContentFragment m4766c(int type) {
        return this.f3825b.getLatestFragment(type);
    }

    /* renamed from: f */
    public boolean m4773f() {
        return this.f3825b.isNaviStart();
    }

    public void showLatestNaviFragment() {
        this.f3825b.backToNavi(null);
    }

    /* renamed from: a */
    public void m4759a(Bundle bundle) {
        this.f3825b.backToNavi(bundle);
    }

    /* renamed from: d */
    public boolean m4769d(int type) {
        return this.f3825b.isCarlifeHomeFragment(type);
    }

    /* renamed from: e */
    public boolean m4771e(int type) {
        return this.f3825b.isCarlifeTelephoneFragment(type);
    }

    /* renamed from: g */
    public BaseFragment m4774g() {
        return this.f3825b.getLatestMusicFragment();
    }

    /* renamed from: h */
    public int m4776h() {
        return this.f3825b.getFragmentStackSize();
    }

    /* renamed from: f */
    public int m4772f(int type) {
        return this.f3825b.findFragmentIndexInStack(type);
    }

    /* renamed from: a */
    public void m4760a(Fragment fragment) {
        this.f3825b.removePluginFragment(fragment);
    }

    /* renamed from: a */
    public void m4762a(C1283l listener) {
        this.f3825b.setUIListener(listener);
    }

    /* renamed from: i */
    public void m4777i() {
        this.f3825b.hideAllFragments();
    }

    /* renamed from: j */
    public Fragment m4778j() {
        return this.f3825b.getLatestNaviFragment();
    }

    /* renamed from: k */
    public void m4779k() {
        this.f3825b.showFirstHomeFragment();
    }

    public boolean isNaviMapFragment() {
        return this.f3825b.isMapViewFragment(this.f3825b.mLastFragmentType);
    }

    public int getNextFragmentType() {
        return this.f3825b.mLastFragmentType;
    }

    /* renamed from: g */
    public boolean m4775g(int type) {
        return this.f3825b.isNeedHideTabFragment(type);
    }
}
