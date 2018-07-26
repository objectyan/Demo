package com.baidu.navi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.OnFragmentListener;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.C1283l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public abstract class ContentFragmentManager {
    public static final String KEY_BACK_BUNDLE = "back_bundle";
    public static final String KEY_FRAGMENT_TYPE = "key_fragment_type";
    public static final String KEY_SHOW_BUNDLE = "show_bundle";
    public static final String MODULE_FROM = "module_from";
    public static final int MODULE_HOME = 1;
    public static final int MODULE_MUSIC = 4;
    public static final int MODULE_NAVI = 3;
    public static final int MODULE_PHONE = 2;
    private static final String TAG = "Framework";
    protected IContentFragmentFactory mContentFragmentFactory;
    protected FragmentInfo mCurrentFragmentInfo = null;
    protected ArrayList<FragmentInfo> mFragmentInfoStack = new ArrayList();
    protected FragmentManager mFragmentManager;
    public int mLastFragmentType;
    protected Stack<Fragment> mPluginFragments = new Stack();
    protected C1283l mUiListener;

    protected class FragmentInfo {
        public ContentFragment mFragment;
        public int mType;

        public FragmentInfo(ContentFragment fragment, int type) {
            this.mFragment = fragment;
            this.mType = type;
        }
    }

    public abstract boolean isCarLifeMusicSDKFragment(ContentFragment contentFragment, ContentFragment contentFragment2);

    public abstract boolean isCarlifeFragment(int i);

    public abstract boolean isCarlifeHomeFragment(int i);

    public abstract boolean isCarlifeLaunchFragment(int i);

    public abstract boolean isCarlifeMusicFragment(int i);

    public abstract boolean isCarlifeMusicLocalFragment(int i);

    public abstract boolean isCarlifeMusicNeteaseFragment(int i);

    public abstract boolean isCarlifeMusicThirdFragment(int i);

    public abstract boolean isCarlifeRadioMusicFragment(int i);

    public abstract boolean isCarlifeTelephoneFragment(int i);

    public abstract boolean isMapViewFragment(int i);

    public abstract boolean isRadioFragment(int i);

    public abstract boolean isWeChatFragment(int i);

    public ContentFragmentManager(OnFragmentListener activity) {
        this.mFragmentManager = activity.getSupportFragmentManager();
    }

    public void setFragmentManager(OnFragmentListener listener) {
        this.mFragmentManager = listener.getSupportFragmentManager();
    }

    public void setFragmentFactory(IContentFragmentFactory contentFragmentFactory) {
        this.mContentFragmentFactory = contentFragmentFactory;
    }

    public void showFragment(int type, Bundle bundle) {
        ContentFragment fragment = null;
        if (this.mContentFragmentFactory != null) {
            fragment = this.mContentFragmentFactory.createFragment(type);
        }
        if (this.mCurrentFragmentInfo != null) {
            if (this.mCurrentFragmentInfo.mType != type) {
                push(this.mCurrentFragmentInfo);
            } else {
                fragment = this.mCurrentFragmentInfo.mFragment;
            }
        }
        if (fragment != null) {
            Bundle parentBundle = fragment.getArguments();
            if (parentBundle == null) {
                parentBundle = new Bundle();
                parentBundle.putInt(KEY_FRAGMENT_TYPE, type);
                fragment.setArguments(parentBundle);
            }
            if (bundle != null) {
                parentBundle.putBundle(KEY_SHOW_BUNDLE, bundle);
            }
        }
        replaceFragment(fragment, type, false);
        this.mCurrentFragmentInfo = new FragmentInfo(fragment, type);
        if (this.mCurrentFragmentInfo.mFragment != null) {
            this.mCurrentFragmentInfo.mFragment.requestInitView();
        }
        if (this.mUiListener != null) {
            this.mUiListener.updateGaussianBlurBackground();
            this.mUiListener.updateMainDisplayStatus(4003);
        }
    }

    public void backToNavi(Bundle bundle) {
        FragmentInfo fragmentInfo = null;
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (!isCarlifeFragment(((FragmentInfo) this.mFragmentInfoStack.get(i)).mType)) {
                fragmentInfo = (FragmentInfo) this.mFragmentInfoStack.remove(i);
                break;
            }
        }
        if (fragmentInfo == null) {
            C1260i.b("Framework", "----------fragment is null!----");
            return;
        }
        if (this.mCurrentFragmentInfo != null) {
            push(this.mCurrentFragmentInfo);
        }
        if (fragmentInfo.mFragment != null) {
            Bundle parentBundle = fragmentInfo.mFragment.getArguments();
            if (parentBundle != null) {
                if (bundle != null) {
                    parentBundle.putBundle(KEY_BACK_BUNDLE, bundle);
                } else {
                    parentBundle.remove(KEY_BACK_BUNDLE);
                }
            }
        }
        replaceFragment(fragmentInfo.mFragment, fragmentInfo.mType, false);
        this.mCurrentFragmentInfo = fragmentInfo;
        if (this.mUiListener != null) {
            this.mUiListener.updateGaussianBlurBackground();
            this.mUiListener.updateMainDisplayStatus(4003);
            this.mUiListener.setBottomBarStatus(true);
        }
        if (this.mCurrentFragmentInfo.mType == 113 || this.mCurrentFragmentInfo.mType == 114) {
            this.mCurrentFragmentInfo.mFragment.requestInitView();
        }
    }

    public void back(Bundle bundle) {
        FragmentInfo fragmentInfo;
        int curType = getCurrentFragmentType();
        if (!isCarlifeFragment(curType)) {
            fragmentInfo = popNavi();
        } else if (isCarlifeHomeFragment(curType)) {
            fragmentInfo = popHome();
        } else if (isCarlifeMusicLocalFragment(curType)) {
            fragmentInfo = popLocalMusic();
        } else if (isCarlifeMusicNeteaseFragment(curType)) {
            fragmentInfo = popNetease();
        } else if (isCarlifeMusicThirdFragment(curType)) {
            fragmentInfo = popThirdParty();
        } else {
            fragmentInfo = popCarlife();
        }
        if (fragmentInfo != null) {
            if (fragmentInfo.mFragment != null) {
                Bundle parentBundle = fragmentInfo.mFragment.getArguments();
                if (parentBundle != null) {
                    if (bundle != null) {
                        parentBundle.putBundle(KEY_BACK_BUNDLE, bundle);
                    } else {
                        parentBundle.remove(KEY_BACK_BUNDLE);
                    }
                }
            }
            if (isCarlifeMusicFragment(fragmentInfo.mType)) {
                replaceCarLifeMusicFragment(fragmentInfo.mFragment, fragmentInfo.mType, true);
            } else if (isCarlifeHomeFragment(fragmentInfo.mType)) {
                replaceCarLifeHomeFragment(fragmentInfo.mFragment, fragmentInfo.mType, true);
            } else if (isCarlifeTelephoneFragment(fragmentInfo.mType)) {
                replaceCarLifeTelephoneFragment(fragmentInfo.mFragment, fragmentInfo.mType, true);
            } else if (isCarlifeLaunchFragment(fragmentInfo.mType)) {
                replaceCarLifeFragment(fragmentInfo.mFragment);
            } else if (!isCarlifeFragment(fragmentInfo.mType)) {
                replaceFragment(fragmentInfo.mFragment, fragmentInfo.mType, true);
            }
            this.mCurrentFragmentInfo = fragmentInfo;
            if (this.mCurrentFragmentInfo.mFragment != null) {
                this.mCurrentFragmentInfo.mFragment.requestRestoreView();
            }
        }
    }

    public void back() {
        back(null);
    }

    public ContentFragment getCurrentFragment() {
        if (this.mCurrentFragmentInfo == null) {
            return null;
        }
        return this.mCurrentFragmentInfo.mFragment;
    }

    public int getCurrentFragmentType() {
        if (this.mCurrentFragmentInfo == null) {
            return 0;
        }
        return this.mCurrentFragmentInfo.mType;
    }

    public int getFragmentStackSize() {
        return this.mFragmentInfoStack.size();
    }

    public ContentFragment getFragmentInStack(int index) {
        if (index >= this.mFragmentInfoStack.size()) {
            return null;
        }
        return ((FragmentInfo) this.mFragmentInfoStack.get(index)).mFragment;
    }

    public int getFragmentTypeInStack(int index) {
        if (index >= this.mFragmentInfoStack.size()) {
            return -1;
        }
        return ((FragmentInfo) this.mFragmentInfoStack.get(index)).mType;
    }

    public int findFragmentIndexInStack(int type) {
        for (int i = 0; i < this.mFragmentInfoStack.size(); i++) {
            if (((FragmentInfo) this.mFragmentInfoStack.get(i)).mType == type) {
                return i;
            }
        }
        return -1;
    }

    protected int removeFragmentFromStack(int index) {
        if (index >= this.mFragmentInfoStack.size()) {
            return -1;
        }
        if (isCarlifeFragment(((FragmentInfo) this.mFragmentInfoStack.get(index)).mType) && ((FragmentInfo) this.mFragmentInfoStack.get(index)).mType != 516 && ((FragmentInfo) this.mFragmentInfoStack.get(index)).mType != 514 && ((FragmentInfo) this.mFragmentInfoStack.get(index)).mType != 517) {
            return -1;
        }
        FragmentInfo fragmentInfo = (FragmentInfo) this.mFragmentInfoStack.remove(index);
        FragmentTransaction ft = this.mFragmentManager.beginTransaction();
        ft.remove(fragmentInfo.mFragment);
        ft.commitAllowingStateLoss();
        return fragmentInfo.mType;
    }

    public void removeAllFragmentByType(int fragmentType) {
        int index = findFragmentIndexInStack(fragmentType);
        while (index >= 0) {
            removeFragmentFromStack(index);
            index = findFragmentIndexInStack(fragmentType);
        }
    }

    public void removeAllCarLifeFragmentByType(int fragmentType) {
        int index = findFragmentIndexInStack(fragmentType);
        while (index >= 0 && index < this.mFragmentInfoStack.size()) {
            this.mFragmentInfoStack.remove(index);
            index = findFragmentIndexInStack(fragmentType);
        }
    }

    public void removeWeChatFragmentFromStack() {
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (isWeChatFragment(((FragmentInfo) this.mFragmentInfoStack.get(i)).mType)) {
                FragmentInfo fragmentInfo = (FragmentInfo) this.mFragmentInfoStack.remove(i);
                FragmentTransaction ft = this.mFragmentManager.beginTransaction();
                ft.remove(fragmentInfo.mFragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    protected void push(FragmentInfo fragmentInfo) {
        if (fragmentInfo != null) {
            this.mFragmentInfoStack.add(fragmentInfo);
        }
    }

    protected FragmentInfo pop() {
        int size = this.mFragmentInfoStack.size();
        if (size <= 0) {
            return null;
        }
        return (FragmentInfo) this.mFragmentInfoStack.remove(size - 1);
    }

    protected FragmentInfo popHome() {
        if (this.mFragmentInfoStack.size() <= 0) {
            return null;
        }
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (isCarlifeHomeFragment(((FragmentInfo) this.mFragmentInfoStack.get(i)).mType)) {
                FragmentInfo fragmentInfo = (FragmentInfo) this.mFragmentInfoStack.get(i);
                this.mFragmentInfoStack.remove(i);
                return fragmentInfo;
            }
        }
        return null;
    }

    protected FragmentInfo popLocalMusic() {
        if (this.mFragmentInfoStack.size() <= 0) {
            return null;
        }
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (isCarlifeMusicLocalFragment(((FragmentInfo) this.mFragmentInfoStack.get(i)).mType)) {
                FragmentInfo fragmentInfo = (FragmentInfo) this.mFragmentInfoStack.get(i);
                this.mFragmentInfoStack.remove(i);
                return fragmentInfo;
            }
        }
        return null;
    }

    protected FragmentInfo popNetease() {
        if (this.mFragmentInfoStack.size() <= 0) {
            return null;
        }
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (isCarlifeMusicNeteaseFragment(((FragmentInfo) this.mFragmentInfoStack.get(i)).mType)) {
                return (FragmentInfo) this.mFragmentInfoStack.remove(i);
            }
        }
        return null;
    }

    protected FragmentInfo popThirdParty() {
        if (this.mFragmentInfoStack.size() <= 0) {
            return null;
        }
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (isCarlifeMusicThirdFragment(((FragmentInfo) this.mFragmentInfoStack.get(i)).mType)) {
                return (FragmentInfo) this.mFragmentInfoStack.remove(i);
            }
        }
        return null;
    }

    protected FragmentInfo popCarlife() {
        if (this.mFragmentInfoStack.size() <= 0) {
            return null;
        }
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (isCarlifeFragment(((FragmentInfo) this.mFragmentInfoStack.get(i)).mType)) {
                FragmentInfo fragmentInfo = (FragmentInfo) this.mFragmentInfoStack.get(i);
                this.mFragmentInfoStack.remove(i);
                return fragmentInfo;
            }
        }
        return null;
    }

    protected FragmentInfo popNavi() {
        if (this.mFragmentInfoStack.size() <= 0) {
            return null;
        }
        for (int i = this.mFragmentInfoStack.size() - 1; i >= 0; i--) {
            if (!isCarlifeFragment(((FragmentInfo) this.mFragmentInfoStack.get(i)).mType)) {
                return (FragmentInfo) this.mFragmentInfoStack.remove(i);
            }
        }
        return null;
    }

    protected void logFragmentStack() {
        String fragmentStackStr = "fragment in stack: [";
        if (this.mContentFragmentFactory != null) {
            int size = this.mFragmentInfoStack.size();
            for (int i = 0; i < size; i++) {
                fragmentStackStr = fragmentStackStr + this.mContentFragmentFactory.toString(((FragmentInfo) this.mFragmentInfoStack.get(i)).mType);
                if (i < this.mFragmentInfoStack.size() - 1) {
                    fragmentStackStr = fragmentStackStr + ", ";
                }
            }
        }
        C1260i.b("Framework", fragmentStackStr + "]");
    }

    public void showCarlifeFragment(int type, Bundle bundle) {
        ContentFragment fragment = getFragment(type);
        if (this.mCurrentFragmentInfo != null) {
            if (type != this.mCurrentFragmentInfo.mType) {
                push(this.mCurrentFragmentInfo);
            } else {
                fragment = this.mCurrentFragmentInfo.mFragment;
            }
        }
        if (fragment != null) {
            Bundle parentBundle = fragment.getArguments();
            if (parentBundle == null) {
                parentBundle = new Bundle();
                parentBundle.putInt(KEY_FRAGMENT_TYPE, type);
                fragment.setArguments(parentBundle);
            }
            if (bundle != null) {
                parentBundle.putBundle(KEY_SHOW_BUNDLE, bundle);
            }
        }
        int bottomStatusType = 4001;
        if (isCarlifeMusicFragment(type)) {
            bottomStatusType = 4004;
            replaceCarLifeMusicFragment(fragment, type, false);
        } else if (isCarlifeHomeFragment(type)) {
            bottomStatusType = 4001;
            replaceCarLifeHomeFragment(fragment, type, false);
        } else if (isCarlifeTelephoneFragment(type)) {
            bottomStatusType = 4002;
            replaceCarLifeTelephoneFragment(fragment, type, false);
        } else if (isCarlifeLaunchFragment(type)) {
            replaceCarLifeFragment(fragment);
        }
        if (this.mUiListener != null) {
            this.mUiListener.updateMainDisplayStatus(bottomStatusType);
        }
        this.mCurrentFragmentInfo = new FragmentInfo(fragment, type);
        if (this.mCurrentFragmentInfo.mFragment != null) {
            this.mCurrentFragmentInfo.mFragment.requestInitView();
        }
    }

    private ContentFragment getFragment(int type) {
        ContentFragment fragment = null;
        int index = 0;
        Iterator it = this.mFragmentInfoStack.iterator();
        while (it.hasNext()) {
            if (((FragmentInfo) it.next()).mType == type) {
                fragment = ((FragmentInfo) this.mFragmentInfoStack.remove(index)).mFragment;
                removeAllCarLifeFragmentByType(type);
                C1260i.b("ouyang", "-------------getFragment-OK-isExist----");
                break;
            }
            index++;
        }
        if (fragment != null || this.mContentFragmentFactory == null) {
            return fragment;
        }
        fragment = this.mContentFragmentFactory.createFragment(type);
        C1260i.b("ouyang", "-------------getFragment-OK--create--- : " + type);
        return fragment;
    }

    protected void replaceFragment(ContentFragment fragment, int type, boolean back) {
        FragmentTransaction ft = this.mFragmentManager.beginTransaction();
        ContentFragment currFragment = null;
        if (!(this.mCurrentFragmentInfo == null || this.mCurrentFragmentInfo.mFragment == null)) {
            currFragment = this.mCurrentFragmentInfo.mFragment;
        }
        this.mLastFragmentType = fragment.fragmentType;
        if (!back) {
            if (!(type == currFragment.getType() || currFragment == null)) {
                if (isCarlifeFragment(currFragment.getType())) {
                    ft.hide(currFragment);
                } else {
                    ft.detach(currFragment);
                }
            }
            if (fragment.isAdded()) {
                ft.show(fragment);
            } else if (fragment.isDetached()) {
                ft.attach(fragment);
            } else if (!(fragment.isAdded() || fragment.isAddFt())) {
                ft.add(C0965R.id.content_frame, fragment);
                fragment.setAddFt(true);
            }
        } else if (currFragment != null) {
            if (isCarlifeFragment(currFragment.getType())) {
                ft.hide(currFragment);
            } else {
                ft.remove(currFragment);
            }
            if (fragment.isAdded()) {
                ft.show(fragment);
            } else if (fragment.isDetached()) {
                ft.attach(fragment);
            }
        }
        ft.commitAllowingStateLoss();
    }

    private void replaceCarLifeMusicFragment(ContentFragment fragment, int type, boolean back) {
        FragmentTransaction ft = this.mFragmentManager.beginTransaction();
        ContentFragment currFragment = null;
        if (this.mCurrentFragmentInfo != null) {
            currFragment = this.mCurrentFragmentInfo.mFragment;
        }
        this.mLastFragmentType = fragment.fragmentType;
        if (!back) {
            if (!(type == currFragment.getType() || currFragment == null)) {
                if (isCarlifeMusicFragment(currFragment.getType())) {
                    ft.detach(currFragment);
                } else {
                    ft.hide(currFragment);
                }
            }
            if (fragment.isAdded()) {
                ft.show(fragment);
            } else if (fragment.isDetached()) {
                ft.attach(fragment);
            } else if (!(fragment.isAdded() || fragment.isAddFt())) {
                ft.add(C0965R.id.content_frame, fragment);
                fragment.setAddFt(true);
            }
        } else if (currFragment != null) {
            if (isCarlifeMusicFragment(currFragment.getType())) {
                ft.remove(currFragment);
            } else {
                ft.hide(currFragment);
            }
            if (fragment.isAdded()) {
                ft.show(fragment);
            } else if (fragment.isDetached()) {
                ft.attach(fragment);
            }
        }
        ft.commitAllowingStateLoss();
    }

    private void replaceCarLifeHomeFragment(ContentFragment fragment, int type, boolean back) {
        FragmentTransaction ft = this.mFragmentManager.beginTransaction();
        ContentFragment currFragment = null;
        if (this.mCurrentFragmentInfo != null) {
            currFragment = this.mCurrentFragmentInfo.mFragment;
        }
        this.mLastFragmentType = fragment.fragmentType;
        if (!back) {
            if (!(type == currFragment.getType() || currFragment == null)) {
                if (isCarlifeLaunchFragment(currFragment.getType())) {
                    ft.remove(currFragment);
                } else if (isCarlifeHomeFragment(currFragment.getType())) {
                    ft.detach(currFragment);
                } else {
                    ft.hide(currFragment);
                }
            }
            if (fragment.isAdded()) {
                ft.show(fragment);
            } else if (fragment.isDetached()) {
                ft.attach(fragment);
            } else if (!(fragment.isAdded() || fragment.isAddFt())) {
                ft.add(C0965R.id.content_frame, fragment);
                fragment.setAddFt(true);
            }
        } else if (currFragment != null) {
            if (isCarlifeHomeFragment(currFragment.getType())) {
                ft.remove(currFragment);
            } else {
                ft.hide(currFragment);
            }
            if (fragment.isAdded()) {
                ft.show(fragment);
            } else if (fragment.isDetached()) {
                ft.attach(fragment);
            }
        }
        ft.commitAllowingStateLoss();
    }

    private void replaceCarLifeTelephoneFragment(ContentFragment fragment, int type, boolean back) {
        FragmentTransaction ft = this.mFragmentManager.beginTransaction();
        ContentFragment currFragment = null;
        if (this.mCurrentFragmentInfo != null) {
            currFragment = this.mCurrentFragmentInfo.mFragment;
        }
        this.mLastFragmentType = fragment.fragmentType;
        if (!back) {
            if (!(type == currFragment.getType() || currFragment == null)) {
                if (isCarlifeTelephoneFragment(currFragment.getType())) {
                    ft.detach(currFragment);
                } else {
                    ft.hide(currFragment);
                }
            }
            if (fragment.isAdded()) {
                ft.show(fragment);
            } else if (fragment.isDetached()) {
                ft.attach(fragment);
            } else if (!(fragment.isAdded() || fragment.isAddFt())) {
                ft.add(C0965R.id.content_frame, fragment);
                fragment.setAddFt(true);
            }
        } else if (currFragment != null) {
            if (isCarlifeTelephoneFragment(currFragment.getType())) {
                ft.remove(currFragment);
            } else {
                ft.hide(currFragment);
            }
            if (fragment.isAdded()) {
                ft.show(fragment);
            } else if (fragment.isDetached()) {
                ft.attach(fragment);
            }
        }
        ft.commitAllowingStateLoss();
    }

    private void replaceCarLifeFragment(ContentFragment fragment) {
        FragmentTransaction ft = this.mFragmentManager.beginTransaction();
        if (!fragment.isAdded()) {
            ft.replace(C0965R.id.content_frame, fragment);
            ft.commitAllowingStateLoss();
        }
    }

    public void addPluginFragment(Fragment fragment) {
        Fragment lastFragment;
        if (this.mPluginFragments.size() > 0) {
            lastFragment = (Fragment) this.mPluginFragments.peek();
        } else {
            lastFragment = this.mCurrentFragmentInfo.mFragment;
        }
        FragmentTransaction ft = this.mFragmentManager.beginTransaction();
        if (!fragment.isAdded()) {
            ft.add(C0965R.id.content_frame, fragment);
        }
        ft.hide(lastFragment);
        ft.commitAllowingStateLoss();
        this.mPluginFragments.push(fragment);
    }

    public void removePluginFragment(Fragment fragment) {
        Fragment lastFragment;
        if (this.mPluginFragments.size() > 1) {
            lastFragment = (Fragment) this.mPluginFragments.get(this.mPluginFragments.size() - 2);
        } else {
            lastFragment = this.mCurrentFragmentInfo.mFragment;
        }
        FragmentTransaction ft = this.mFragmentManager.beginTransaction();
        ft.remove(fragment);
        ft.show(lastFragment);
        ft.commitAllowingStateLoss();
        this.mPluginFragments.remove(fragment);
    }

    public void removeTopPluginFragment() {
        Fragment lastFragment;
        if (this.mPluginFragments.size() > 1) {
            lastFragment = (Fragment) this.mPluginFragments.get(this.mPluginFragments.size() - 2);
        } else {
            lastFragment = this.mCurrentFragmentInfo.mFragment;
        }
        Fragment fragment = (Fragment) this.mPluginFragments.pop();
        FragmentTransaction ft = this.mFragmentManager.beginTransaction();
        ft.remove(fragment);
        ft.show(lastFragment);
        ft.commitAllowingStateLoss();
    }

    public void setUIListener(C1283l listener) {
        this.mUiListener = listener;
    }

    public FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public void hideAllFragments() {
        List<Fragment> allFragments = this.mFragmentManager.getFragments();
        if (allFragments != null) {
            FragmentTransaction ft = this.mFragmentManager.beginTransaction();
            int len = allFragments.size();
            for (int i = 0; i < len; i++) {
                Fragment fragment = (Fragment) allFragments.get(i);
                if (!(fragment == null || (fragment instanceof MapFragment))) {
                    ft.hide(fragment);
                }
            }
            ft.commitAllowingStateLoss();
        }
    }
}
