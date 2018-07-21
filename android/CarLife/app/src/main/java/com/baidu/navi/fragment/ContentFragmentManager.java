package com.baidu.navi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.OnFragmentListener;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public abstract class ContentFragmentManager
{
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
  protected FragmentInfo mCurrentFragmentInfo;
  protected ArrayList<FragmentInfo> mFragmentInfoStack;
  protected FragmentManager mFragmentManager;
  public int mLastFragmentType;
  protected Stack<Fragment> mPluginFragments;
  protected l mUiListener;
  
  public ContentFragmentManager(OnFragmentListener paramOnFragmentListener)
  {
    this.mFragmentManager = paramOnFragmentListener.getSupportFragmentManager();
    this.mFragmentInfoStack = new ArrayList();
    this.mCurrentFragmentInfo = null;
    this.mPluginFragments = new Stack();
  }
  
  private ContentFragment getFragment(int paramInt)
  {
    Object localObject2 = null;
    int i = 0;
    Iterator localIterator = this.mFragmentInfoStack.iterator();
    for (;;)
    {
      Object localObject1 = localObject2;
      if (localIterator.hasNext())
      {
        if (((FragmentInfo)localIterator.next()).mType == paramInt)
        {
          localObject1 = ((FragmentInfo)this.mFragmentInfoStack.remove(i)).mFragment;
          removeAllCarLifeFragmentByType(paramInt);
          i.b("ouyang", "-------------getFragment-OK-isExist----");
        }
      }
      else
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (this.mContentFragmentFactory != null)
          {
            localObject2 = this.mContentFragmentFactory.createFragment(paramInt);
            i.b("ouyang", "-------------getFragment-OK--create--- : " + paramInt);
          }
        }
        return (ContentFragment)localObject2;
      }
      i += 1;
    }
  }
  
  private void replaceCarLifeFragment(ContentFragment paramContentFragment)
  {
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    if (paramContentFragment.isAdded()) {
      return;
    }
    localFragmentTransaction.replace(2131623987, paramContentFragment);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  private void replaceCarLifeHomeFragment(ContentFragment paramContentFragment, int paramInt, boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    ContentFragment localContentFragment = null;
    if (this.mCurrentFragmentInfo != null) {
      localContentFragment = this.mCurrentFragmentInfo.mFragment;
    }
    this.mLastFragmentType = paramContentFragment.fragmentType;
    if (paramBoolean) {
      if (localContentFragment != null)
      {
        if (!isCarlifeHomeFragment(localContentFragment.getType())) {
          break label86;
        }
        localFragmentTransaction.remove(localContentFragment);
        if (!paramContentFragment.isAdded()) {
          break label97;
        }
        localFragmentTransaction.show(paramContentFragment);
      }
    }
    for (;;)
    {
      localFragmentTransaction.commitAllowingStateLoss();
      return;
      label86:
      localFragmentTransaction.hide(localContentFragment);
      break;
      label97:
      if (paramContentFragment.isDetached())
      {
        localFragmentTransaction.attach(paramContentFragment);
        continue;
        if ((paramInt != localContentFragment.getType()) && (localContentFragment != null))
        {
          if (!isCarlifeLaunchFragment(localContentFragment.getType())) {
            break label165;
          }
          localFragmentTransaction.remove(localContentFragment);
        }
        for (;;)
        {
          if (!paramContentFragment.isAdded()) {
            break label199;
          }
          localFragmentTransaction.show(paramContentFragment);
          break;
          label165:
          if (isCarlifeHomeFragment(localContentFragment.getType())) {
            localFragmentTransaction.detach(localContentFragment);
          } else {
            localFragmentTransaction.hide(localContentFragment);
          }
        }
        label199:
        if (paramContentFragment.isDetached())
        {
          localFragmentTransaction.attach(paramContentFragment);
        }
        else if ((!paramContentFragment.isAdded()) && (!paramContentFragment.isAddFt()))
        {
          localFragmentTransaction.add(2131623987, paramContentFragment);
          paramContentFragment.setAddFt(true);
        }
      }
    }
  }
  
  private void replaceCarLifeMusicFragment(ContentFragment paramContentFragment, int paramInt, boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    ContentFragment localContentFragment = null;
    if (this.mCurrentFragmentInfo != null) {
      localContentFragment = this.mCurrentFragmentInfo.mFragment;
    }
    this.mLastFragmentType = paramContentFragment.fragmentType;
    if (paramBoolean) {
      if (localContentFragment != null)
      {
        if (!isCarlifeMusicFragment(localContentFragment.getType())) {
          break label86;
        }
        localFragmentTransaction.remove(localContentFragment);
        if (!paramContentFragment.isAdded()) {
          break label97;
        }
        localFragmentTransaction.show(paramContentFragment);
      }
    }
    for (;;)
    {
      localFragmentTransaction.commitAllowingStateLoss();
      return;
      label86:
      localFragmentTransaction.hide(localContentFragment);
      break;
      label97:
      if (paramContentFragment.isDetached())
      {
        localFragmentTransaction.attach(paramContentFragment);
        continue;
        if ((paramInt != localContentFragment.getType()) && (localContentFragment != null))
        {
          if (!isCarlifeMusicFragment(localContentFragment.getType())) {
            break label165;
          }
          localFragmentTransaction.detach(localContentFragment);
        }
        for (;;)
        {
          if (!paramContentFragment.isAdded()) {
            break label176;
          }
          localFragmentTransaction.show(paramContentFragment);
          break;
          label165:
          localFragmentTransaction.hide(localContentFragment);
        }
        label176:
        if (paramContentFragment.isDetached())
        {
          localFragmentTransaction.attach(paramContentFragment);
        }
        else if ((!paramContentFragment.isAdded()) && (!paramContentFragment.isAddFt()))
        {
          localFragmentTransaction.add(2131623987, paramContentFragment);
          paramContentFragment.setAddFt(true);
        }
      }
    }
  }
  
  private void replaceCarLifeTelephoneFragment(ContentFragment paramContentFragment, int paramInt, boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    ContentFragment localContentFragment = null;
    if (this.mCurrentFragmentInfo != null) {
      localContentFragment = this.mCurrentFragmentInfo.mFragment;
    }
    this.mLastFragmentType = paramContentFragment.fragmentType;
    if (paramBoolean) {
      if (localContentFragment != null)
      {
        if (!isCarlifeTelephoneFragment(localContentFragment.getType())) {
          break label86;
        }
        localFragmentTransaction.remove(localContentFragment);
        if (!paramContentFragment.isAdded()) {
          break label97;
        }
        localFragmentTransaction.show(paramContentFragment);
      }
    }
    for (;;)
    {
      localFragmentTransaction.commitAllowingStateLoss();
      return;
      label86:
      localFragmentTransaction.hide(localContentFragment);
      break;
      label97:
      if (paramContentFragment.isDetached())
      {
        localFragmentTransaction.attach(paramContentFragment);
        continue;
        if ((paramInt != localContentFragment.getType()) && (localContentFragment != null))
        {
          if (!isCarlifeTelephoneFragment(localContentFragment.getType())) {
            break label165;
          }
          localFragmentTransaction.detach(localContentFragment);
        }
        for (;;)
        {
          if (!paramContentFragment.isAdded()) {
            break label176;
          }
          localFragmentTransaction.show(paramContentFragment);
          break;
          label165:
          localFragmentTransaction.hide(localContentFragment);
        }
        label176:
        if (paramContentFragment.isDetached())
        {
          localFragmentTransaction.attach(paramContentFragment);
        }
        else if ((!paramContentFragment.isAdded()) && (!paramContentFragment.isAddFt()))
        {
          localFragmentTransaction.add(2131623987, paramContentFragment);
          paramContentFragment.setAddFt(true);
        }
      }
    }
  }
  
  public void addPluginFragment(Fragment paramFragment)
  {
    if (this.mPluginFragments.size() > 0) {}
    for (Object localObject = (Fragment)this.mPluginFragments.peek();; localObject = this.mCurrentFragmentInfo.mFragment)
    {
      FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
      if (!paramFragment.isAdded()) {
        localFragmentTransaction.add(2131623987, paramFragment);
      }
      localFragmentTransaction.hide((Fragment)localObject);
      localFragmentTransaction.commitAllowingStateLoss();
      this.mPluginFragments.push(paramFragment);
      return;
    }
  }
  
  public void back()
  {
    back(null);
  }
  
  public void back(Bundle paramBundle)
  {
    int i = getCurrentFragmentType();
    FragmentInfo localFragmentInfo;
    if (isCarlifeFragment(i)) {
      if (isCarlifeHomeFragment(i)) {
        localFragmentInfo = popHome();
      }
    }
    while (localFragmentInfo == null)
    {
      return;
      if (isCarlifeMusicLocalFragment(i))
      {
        localFragmentInfo = popLocalMusic();
      }
      else if (isCarlifeMusicNeteaseFragment(i))
      {
        localFragmentInfo = popNetease();
      }
      else if (isCarlifeMusicThirdFragment(i))
      {
        localFragmentInfo = popThirdParty();
      }
      else
      {
        localFragmentInfo = popCarlife();
        continue;
        localFragmentInfo = popNavi();
      }
    }
    Bundle localBundle;
    if (localFragmentInfo.mFragment != null)
    {
      localBundle = localFragmentInfo.mFragment.getArguments();
      if (localBundle != null)
      {
        if (paramBundle == null) {
          break label178;
        }
        localBundle.putBundle("back_bundle", paramBundle);
      }
    }
    label128:
    if (isCarlifeMusicFragment(localFragmentInfo.mType)) {
      replaceCarLifeMusicFragment(localFragmentInfo.mFragment, localFragmentInfo.mType, true);
    }
    for (;;)
    {
      this.mCurrentFragmentInfo = localFragmentInfo;
      if (this.mCurrentFragmentInfo.mFragment == null) {
        break;
      }
      this.mCurrentFragmentInfo.mFragment.requestRestoreView();
      return;
      label178:
      localBundle.remove("back_bundle");
      break label128;
      if (isCarlifeHomeFragment(localFragmentInfo.mType)) {
        replaceCarLifeHomeFragment(localFragmentInfo.mFragment, localFragmentInfo.mType, true);
      } else if (isCarlifeTelephoneFragment(localFragmentInfo.mType)) {
        replaceCarLifeTelephoneFragment(localFragmentInfo.mFragment, localFragmentInfo.mType, true);
      } else if (isCarlifeLaunchFragment(localFragmentInfo.mType)) {
        replaceCarLifeFragment(localFragmentInfo.mFragment);
      } else if (!isCarlifeFragment(localFragmentInfo.mType)) {
        replaceFragment(localFragmentInfo.mFragment, localFragmentInfo.mType, true);
      }
    }
  }
  
  public void backToNavi(Bundle paramBundle)
  {
    Bundle localBundle = null;
    int i = this.mFragmentInfoStack.size() - 1;
    Object localObject;
    for (;;)
    {
      localObject = localBundle;
      if (i >= 0)
      {
        if (!isCarlifeFragment(((FragmentInfo)this.mFragmentInfoStack.get(i)).mType)) {
          localObject = (FragmentInfo)this.mFragmentInfoStack.remove(i);
        }
      }
      else
      {
        if (localObject != null) {
          break;
        }
        i.b("Framework", "----------fragment is null!----");
        return;
      }
      i -= 1;
    }
    if (this.mCurrentFragmentInfo != null) {
      push(this.mCurrentFragmentInfo);
    }
    if (((FragmentInfo)localObject).mFragment != null)
    {
      localBundle = ((FragmentInfo)localObject).mFragment.getArguments();
      if (localBundle != null)
      {
        if (paramBundle == null) {
          break label212;
        }
        localBundle.putBundle("back_bundle", paramBundle);
      }
    }
    for (;;)
    {
      replaceFragment(((FragmentInfo)localObject).mFragment, ((FragmentInfo)localObject).mType, false);
      this.mCurrentFragmentInfo = ((FragmentInfo)localObject);
      if (this.mUiListener != null)
      {
        this.mUiListener.updateGaussianBlurBackground();
        this.mUiListener.updateMainDisplayStatus(4003);
        this.mUiListener.setBottomBarStatus(true);
      }
      if ((this.mCurrentFragmentInfo.mType != 113) && (this.mCurrentFragmentInfo.mType != 114)) {
        break;
      }
      this.mCurrentFragmentInfo.mFragment.requestInitView();
      return;
      label212:
      localBundle.remove("back_bundle");
    }
  }
  
  public int findFragmentIndexInStack(int paramInt)
  {
    int i = 0;
    while (i < this.mFragmentInfoStack.size())
    {
      if (((FragmentInfo)this.mFragmentInfoStack.get(i)).mType == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public ContentFragment getCurrentFragment()
  {
    if (this.mCurrentFragmentInfo == null) {
      return null;
    }
    return this.mCurrentFragmentInfo.mFragment;
  }
  
  public int getCurrentFragmentType()
  {
    if (this.mCurrentFragmentInfo == null) {
      return 0;
    }
    return this.mCurrentFragmentInfo.mType;
  }
  
  public ContentFragment getFragmentInStack(int paramInt)
  {
    if (paramInt >= this.mFragmentInfoStack.size()) {
      return null;
    }
    return ((FragmentInfo)this.mFragmentInfoStack.get(paramInt)).mFragment;
  }
  
  public FragmentManager getFragmentManager()
  {
    return this.mFragmentManager;
  }
  
  public int getFragmentStackSize()
  {
    return this.mFragmentInfoStack.size();
  }
  
  public int getFragmentTypeInStack(int paramInt)
  {
    if (paramInt >= this.mFragmentInfoStack.size()) {
      return -1;
    }
    return ((FragmentInfo)this.mFragmentInfoStack.get(paramInt)).mType;
  }
  
  public void hideAllFragments()
  {
    List localList = this.mFragmentManager.getFragments();
    if (localList != null)
    {
      FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
      int j = localList.size();
      int i = 0;
      if (i < j)
      {
        Fragment localFragment = (Fragment)localList.get(i);
        if ((localFragment == null) || ((localFragment instanceof MapFragment))) {}
        for (;;)
        {
          i += 1;
          break;
          localFragmentTransaction.hide(localFragment);
        }
      }
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  public abstract boolean isCarLifeMusicSDKFragment(ContentFragment paramContentFragment1, ContentFragment paramContentFragment2);
  
  public abstract boolean isCarlifeFragment(int paramInt);
  
  public abstract boolean isCarlifeHomeFragment(int paramInt);
  
  public abstract boolean isCarlifeLaunchFragment(int paramInt);
  
  public abstract boolean isCarlifeMusicFragment(int paramInt);
  
  public abstract boolean isCarlifeMusicLocalFragment(int paramInt);
  
  public abstract boolean isCarlifeMusicNeteaseFragment(int paramInt);
  
  public abstract boolean isCarlifeMusicThirdFragment(int paramInt);
  
  public abstract boolean isCarlifeRadioMusicFragment(int paramInt);
  
  public abstract boolean isCarlifeTelephoneFragment(int paramInt);
  
  public abstract boolean isMapViewFragment(int paramInt);
  
  public abstract boolean isRadioFragment(int paramInt);
  
  public abstract boolean isWeChatFragment(int paramInt);
  
  protected void logFragmentStack()
  {
    Object localObject1 = "fragment in stack: [";
    Object localObject2 = localObject1;
    if (this.mContentFragmentFactory != null)
    {
      int j = this.mFragmentInfoStack.size();
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        localObject2 = (String)localObject1 + this.mContentFragmentFactory.toString(((FragmentInfo)this.mFragmentInfoStack.get(i)).mType);
        localObject1 = localObject2;
        if (i < this.mFragmentInfoStack.size() - 1) {
          localObject1 = (String)localObject2 + ", ";
        }
        i += 1;
      }
    }
    i.b("Framework", (String)localObject2 + "]");
  }
  
  protected FragmentInfo pop()
  {
    int i = this.mFragmentInfoStack.size();
    if (i <= 0) {
      return null;
    }
    return (FragmentInfo)this.mFragmentInfoStack.remove(i - 1);
  }
  
  protected FragmentInfo popCarlife()
  {
    if (this.mFragmentInfoStack.size() <= 0) {}
    for (;;)
    {
      return null;
      int i = this.mFragmentInfoStack.size() - 1;
      while (i >= 0)
      {
        if (isCarlifeFragment(((FragmentInfo)this.mFragmentInfoStack.get(i)).mType))
        {
          FragmentInfo localFragmentInfo = (FragmentInfo)this.mFragmentInfoStack.get(i);
          this.mFragmentInfoStack.remove(i);
          return localFragmentInfo;
        }
        i -= 1;
      }
    }
  }
  
  protected FragmentInfo popHome()
  {
    if (this.mFragmentInfoStack.size() <= 0) {}
    for (;;)
    {
      return null;
      int i = this.mFragmentInfoStack.size() - 1;
      while (i >= 0)
      {
        if (isCarlifeHomeFragment(((FragmentInfo)this.mFragmentInfoStack.get(i)).mType))
        {
          FragmentInfo localFragmentInfo = (FragmentInfo)this.mFragmentInfoStack.get(i);
          this.mFragmentInfoStack.remove(i);
          return localFragmentInfo;
        }
        i -= 1;
      }
    }
  }
  
  protected FragmentInfo popLocalMusic()
  {
    if (this.mFragmentInfoStack.size() <= 0) {}
    for (;;)
    {
      return null;
      int i = this.mFragmentInfoStack.size() - 1;
      while (i >= 0)
      {
        if (isCarlifeMusicLocalFragment(((FragmentInfo)this.mFragmentInfoStack.get(i)).mType))
        {
          FragmentInfo localFragmentInfo = (FragmentInfo)this.mFragmentInfoStack.get(i);
          this.mFragmentInfoStack.remove(i);
          return localFragmentInfo;
        }
        i -= 1;
      }
    }
  }
  
  protected FragmentInfo popNavi()
  {
    if (this.mFragmentInfoStack.size() <= 0) {}
    for (;;)
    {
      return null;
      int i = this.mFragmentInfoStack.size() - 1;
      while (i >= 0)
      {
        if (!isCarlifeFragment(((FragmentInfo)this.mFragmentInfoStack.get(i)).mType)) {
          return (FragmentInfo)this.mFragmentInfoStack.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  protected FragmentInfo popNetease()
  {
    if (this.mFragmentInfoStack.size() <= 0) {}
    for (;;)
    {
      return null;
      int i = this.mFragmentInfoStack.size() - 1;
      while (i >= 0)
      {
        if (isCarlifeMusicNeteaseFragment(((FragmentInfo)this.mFragmentInfoStack.get(i)).mType)) {
          return (FragmentInfo)this.mFragmentInfoStack.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  protected FragmentInfo popThirdParty()
  {
    if (this.mFragmentInfoStack.size() <= 0) {}
    for (;;)
    {
      return null;
      int i = this.mFragmentInfoStack.size() - 1;
      while (i >= 0)
      {
        if (isCarlifeMusicThirdFragment(((FragmentInfo)this.mFragmentInfoStack.get(i)).mType)) {
          return (FragmentInfo)this.mFragmentInfoStack.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  protected void push(FragmentInfo paramFragmentInfo)
  {
    if (paramFragmentInfo == null) {
      return;
    }
    this.mFragmentInfoStack.add(paramFragmentInfo);
  }
  
  public void removeAllCarLifeFragmentByType(int paramInt)
  {
    for (int i = findFragmentIndexInStack(paramInt);; i = findFragmentIndexInStack(paramInt))
    {
      if ((i < 0) || (i >= this.mFragmentInfoStack.size())) {
        return;
      }
      this.mFragmentInfoStack.remove(i);
    }
  }
  
  public void removeAllFragmentByType(int paramInt)
  {
    for (int i = findFragmentIndexInStack(paramInt); i >= 0; i = findFragmentIndexInStack(paramInt)) {
      removeFragmentFromStack(i);
    }
  }
  
  protected int removeFragmentFromStack(int paramInt)
  {
    if (paramInt >= this.mFragmentInfoStack.size()) {
      return -1;
    }
    if ((!isCarlifeFragment(((FragmentInfo)this.mFragmentInfoStack.get(paramInt)).mType)) || (((FragmentInfo)this.mFragmentInfoStack.get(paramInt)).mType == 516) || (((FragmentInfo)this.mFragmentInfoStack.get(paramInt)).mType == 514) || (((FragmentInfo)this.mFragmentInfoStack.get(paramInt)).mType == 517))
    {
      FragmentInfo localFragmentInfo = (FragmentInfo)this.mFragmentInfoStack.remove(paramInt);
      FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
      localFragmentTransaction.remove(localFragmentInfo.mFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      return localFragmentInfo.mType;
    }
    return -1;
  }
  
  public void removePluginFragment(Fragment paramFragment)
  {
    if (this.mPluginFragments.size() > 1) {}
    for (Object localObject = (Fragment)this.mPluginFragments.get(this.mPluginFragments.size() - 2);; localObject = this.mCurrentFragmentInfo.mFragment)
    {
      FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
      localFragmentTransaction.remove(paramFragment);
      localFragmentTransaction.show((Fragment)localObject);
      localFragmentTransaction.commitAllowingStateLoss();
      this.mPluginFragments.remove(paramFragment);
      return;
    }
  }
  
  public void removeTopPluginFragment()
  {
    if (this.mPluginFragments.size() > 1) {}
    for (Object localObject = (Fragment)this.mPluginFragments.get(this.mPluginFragments.size() - 2);; localObject = this.mCurrentFragmentInfo.mFragment)
    {
      Fragment localFragment = (Fragment)this.mPluginFragments.pop();
      FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
      localFragmentTransaction.remove(localFragment);
      localFragmentTransaction.show((Fragment)localObject);
      localFragmentTransaction.commitAllowingStateLoss();
      return;
    }
  }
  
  public void removeWeChatFragmentFromStack()
  {
    int i = this.mFragmentInfoStack.size() - 1;
    while (i >= 0)
    {
      if (isWeChatFragment(((FragmentInfo)this.mFragmentInfoStack.get(i)).mType))
      {
        FragmentInfo localFragmentInfo = (FragmentInfo)this.mFragmentInfoStack.remove(i);
        FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
        localFragmentTransaction.remove(localFragmentInfo.mFragment);
        localFragmentTransaction.commitAllowingStateLoss();
      }
      i -= 1;
    }
  }
  
  protected void replaceFragment(ContentFragment paramContentFragment, int paramInt, boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mCurrentFragmentInfo != null)
    {
      localObject1 = localObject2;
      if (this.mCurrentFragmentInfo.mFragment != null) {
        localObject1 = this.mCurrentFragmentInfo.mFragment;
      }
    }
    this.mLastFragmentType = paramContentFragment.fragmentType;
    if (paramBoolean) {
      if (localObject1 != null)
      {
        if (!isCarlifeFragment(((ContentFragment)localObject1).getType())) {
          break label104;
        }
        localFragmentTransaction.hide((Fragment)localObject1);
        if (!paramContentFragment.isAdded()) {
          break label115;
        }
        localFragmentTransaction.show(paramContentFragment);
      }
    }
    for (;;)
    {
      localFragmentTransaction.commitAllowingStateLoss();
      return;
      label104:
      localFragmentTransaction.remove((Fragment)localObject1);
      break;
      label115:
      if (paramContentFragment.isDetached())
      {
        localFragmentTransaction.attach(paramContentFragment);
        continue;
        if ((paramInt != ((ContentFragment)localObject1).getType()) && (localObject1 != null))
        {
          if (!isCarlifeFragment(((ContentFragment)localObject1).getType())) {
            break label183;
          }
          localFragmentTransaction.hide((Fragment)localObject1);
        }
        for (;;)
        {
          if (!paramContentFragment.isAdded()) {
            break label194;
          }
          localFragmentTransaction.show(paramContentFragment);
          break;
          label183:
          localFragmentTransaction.detach((Fragment)localObject1);
        }
        label194:
        if (paramContentFragment.isDetached())
        {
          localFragmentTransaction.attach(paramContentFragment);
        }
        else if ((!paramContentFragment.isAdded()) && (!paramContentFragment.isAddFt()))
        {
          localFragmentTransaction.add(2131623987, paramContentFragment);
          paramContentFragment.setAddFt(true);
        }
      }
    }
  }
  
  public void setFragmentFactory(IContentFragmentFactory paramIContentFragmentFactory)
  {
    this.mContentFragmentFactory = paramIContentFragmentFactory;
  }
  
  public void setFragmentManager(OnFragmentListener paramOnFragmentListener)
  {
    this.mFragmentManager = paramOnFragmentListener.getSupportFragmentManager();
  }
  
  public void setUIListener(l paraml)
  {
    this.mUiListener = paraml;
  }
  
  public void showCarlifeFragment(int paramInt, Bundle paramBundle)
  {
    Object localObject2 = getFragment(paramInt);
    Object localObject1 = localObject2;
    int j;
    int i;
    if (this.mCurrentFragmentInfo != null)
    {
      if (paramInt != this.mCurrentFragmentInfo.mType)
      {
        push(this.mCurrentFragmentInfo);
        localObject1 = localObject2;
      }
    }
    else
    {
      if (localObject1 != null)
      {
        Bundle localBundle = ((ContentFragment)localObject1).getArguments();
        localObject2 = localBundle;
        if (localBundle == null)
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt("key_fragment_type", paramInt);
          ((ContentFragment)localObject1).setArguments((Bundle)localObject2);
        }
        if (paramBundle != null) {
          ((Bundle)localObject2).putBundle("show_bundle", paramBundle);
        }
      }
      j = 4001;
      if (!isCarlifeMusicFragment(paramInt)) {
        break label188;
      }
      i = 4004;
      replaceCarLifeMusicFragment((ContentFragment)localObject1, paramInt, false);
    }
    for (;;)
    {
      if (this.mUiListener != null) {
        this.mUiListener.updateMainDisplayStatus(i);
      }
      this.mCurrentFragmentInfo = new FragmentInfo((ContentFragment)localObject1, paramInt);
      if (this.mCurrentFragmentInfo.mFragment != null) {
        this.mCurrentFragmentInfo.mFragment.requestInitView();
      }
      return;
      localObject1 = this.mCurrentFragmentInfo.mFragment;
      break;
      label188:
      if (isCarlifeHomeFragment(paramInt))
      {
        i = 4001;
        replaceCarLifeHomeFragment((ContentFragment)localObject1, paramInt, false);
      }
      else if (isCarlifeTelephoneFragment(paramInt))
      {
        i = 4002;
        replaceCarLifeTelephoneFragment((ContentFragment)localObject1, paramInt, false);
      }
      else
      {
        i = j;
        if (isCarlifeLaunchFragment(paramInt))
        {
          replaceCarLifeFragment((ContentFragment)localObject1);
          i = j;
        }
      }
    }
  }
  
  public void showFragment(int paramInt, Bundle paramBundle)
  {
    Object localObject1 = null;
    if (this.mContentFragmentFactory != null) {
      localObject1 = this.mContentFragmentFactory.createFragment(paramInt);
    }
    Object localObject2 = localObject1;
    if (this.mCurrentFragmentInfo != null)
    {
      if (this.mCurrentFragmentInfo.mType == paramInt) {
        break label176;
      }
      push(this.mCurrentFragmentInfo);
    }
    label176:
    for (localObject2 = localObject1;; localObject2 = this.mCurrentFragmentInfo.mFragment)
    {
      if (localObject2 != null)
      {
        Bundle localBundle = ((ContentFragment)localObject2).getArguments();
        localObject1 = localBundle;
        if (localBundle == null)
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("key_fragment_type", paramInt);
          ((ContentFragment)localObject2).setArguments((Bundle)localObject1);
        }
        if (paramBundle != null) {
          ((Bundle)localObject1).putBundle("show_bundle", paramBundle);
        }
      }
      replaceFragment((ContentFragment)localObject2, paramInt, false);
      this.mCurrentFragmentInfo = new FragmentInfo((ContentFragment)localObject2, paramInt);
      if (this.mCurrentFragmentInfo.mFragment != null) {
        this.mCurrentFragmentInfo.mFragment.requestInitView();
      }
      if (this.mUiListener != null)
      {
        this.mUiListener.updateGaussianBlurBackground();
        this.mUiListener.updateMainDisplayStatus(4003);
      }
      return;
    }
  }
  
  protected class FragmentInfo
  {
    public ContentFragment mFragment;
    public int mType;
    
    public FragmentInfo(ContentFragment paramContentFragment, int paramInt)
    {
      this.mFragment = paramContentFragment;
      this.mType = paramInt;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/ContentFragmentManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */