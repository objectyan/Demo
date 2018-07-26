package com.baidu.carlife.core.screen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;

/* compiled from: OnFragmentManagerCallback */
/* renamed from: com.baidu.carlife.core.screen.f */
public interface C1278f {
    void back();

    void back(Bundle bundle);

    void backTo(int i, Bundle bundle);

    ContentFragment createFragment(int i);

    ContentFragment getCurrentFragment();

    int getCurrentFragmentType();

    NaviFragmentManager getNaviFragmentManager();

    int getNextFragmentType();

    boolean isCarlifeFragment(int i);

    boolean isNaviMapFragment();

    void push(ContentFragment contentFragment);

    void removeAllFragmentByType(int i);

    void removeFragmentTo(int i);

    void removeWeChatFragmentFromStack();

    void showFragment(int i, Bundle bundle);

    void showLatestHomeFragment();

    void showLatestMusicFragment();

    void showLatestNaviFragment();

    void showLatestPhoneFragment();

    void showPluginFrament(Fragment fragment);
}
