package com.baidu.navi.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.carlife.core.c;
import com.baidu.carlife.core.i;
import com.baidu.carlife.h.a;
import com.baidu.carlife.logic.t;
import com.baidu.carlife.util.r;
import com.baidu.carlife.view.a.b;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class ContentFragment
  extends BaseFragment
  implements a
{
  public static final String TAG = "Framework";
  protected boolean isAddFt = false;
  public boolean isDisplayed = false;
  protected boolean isResumed = false;
  public Bundle mBackBundle;
  protected View mContentView;
  protected int mModuleFrom;
  protected boolean mNeedInitView = false;
  protected boolean mNeedRetoreView = false;
  public Bundle mShowBundle;
  protected String mSkinName;
  
  public void driving() {}
  
  protected long getAnimationTotalDuration(Collection<Animation> paramCollection)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      for (;;)
      {
        l2 = l1;
        if (!paramCollection.hasNext()) {
          break;
        }
        Animation localAnimation = (Animation)paramCollection.next();
        l1 = Math.max(localAnimation.getStartOffset() + localAnimation.getDuration(), l1);
      }
    }
    return l2;
  }
  
  public boolean isAddFt()
  {
    return this.isAddFt;
  }
  
  protected boolean isGausianFragment()
  {
    return getCurrentFragmentType() == 737;
  }
  
  public boolean isMapPage()
  {
    return false;
  }
  
  public void loge(String paramString) {}
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
  }
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  protected abstract View onCreateContentView(LayoutInflater paramLayoutInflater);
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.isAddFt = false;
    paramViewGroup = getArguments();
    if (paramViewGroup != null)
    {
      if (paramViewGroup.containsKey("back_bundle")) {
        this.mBackBundle = paramViewGroup.getBundle("back_bundle");
      }
      if (paramViewGroup.containsKey("key_fragment_type")) {
        this.fragmentType = paramViewGroup.getInt("key_fragment_type");
      }
      this.mShowBundle = paramViewGroup.getBundle("show_bundle");
      if ((this.mShowBundle != null) && (this.mShowBundle.containsKey("module_from"))) {
        this.mModuleFrom = this.mShowBundle.getInt("module_from");
      }
    }
    int i;
    boolean bool;
    if (isMapPage())
    {
      showMapFragment();
      i = c.a().g();
      bool = StyleManager.getRealDayStyle();
      paramViewGroup = t.a().c();
      if (this.mContentView == null) {
        break label278;
      }
      paramLayoutInflater = (ViewGroup)this.mContentView.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.removeView(this.mContentView);
      }
      this.mViewCreated = true;
      if (this.mOrientation != i) {
        updateOrientation(i);
      }
      if (this.mDayStyle != bool) {
        updateStyle(bool);
      }
      if (!paramViewGroup.equals(this.mSkinName))
      {
        i.b("Framework", "onCreateView skin");
        onUpdateSkin();
        this.mSkinName = paramViewGroup;
      }
    }
    for (;;)
    {
      if ((!isMapPage()) && (this.mContentView != null)) {
        this.mContentView.setClickable(true);
      }
      if (this.fragmentType == getCurrentFragmentType()) {
        onInitFocusAreas();
      }
      onInit();
      return this.mContentView;
      hideMapFragment();
      break;
      label278:
      this.mContentView = onCreateContentView(paramLayoutInflater);
      this.mViewCreated = true;
      updateOrientation(i);
      updateStyle(bool);
      this.mSkinName = t.a().c();
      onUpdateSkin();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!isNaviMapFragment()) {
      hideMapFragment();
    }
  }
  
  public void onDestroyView()
  {
    this.mViewCreated = false;
    this.mNeedInitView = false;
    this.mNeedRetoreView = false;
    this.isDisplayed = false;
    super.onDestroyView();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (!isMapPage()) {
        break label67;
      }
      showMapFragment();
    }
    for (;;)
    {
      super.onHiddenChanged(paramBoolean);
      String str = t.a().c();
      if ((!paramBoolean) && (!str.equals(this.mSkinName)))
      {
        i.b("Framework", "onHiddenChanged Skin");
        onUpdateSkin();
        this.mSkinName = str;
      }
      if (!paramBoolean) {
        onInitFocusAreas();
      }
      return;
      label67:
      hideMapFragment();
    }
  }
  
  protected void onInit()
  {
    if (this.mNeedInitView)
    {
      onInitView();
      this.mNeedInitView = false;
    }
    if (this.mNeedRetoreView)
    {
      onRestoreView();
      this.mNeedRetoreView = false;
    }
  }
  
  public void onInitFocusAreas() {}
  
  protected abstract void onInitView();
  
  public void onPause()
  {
    try
    {
      if (this.isResumed)
      {
        this.isResumed = false;
        StatisticManager.onPageEnd(mActivity, getClass().getSimpleName());
      }
      super.onPause();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i.a("", localException.toString());
      }
    }
  }
  
  protected void onRestoreView() {}
  
  public void onResume()
  {
    this.isDisplayed = true;
    try
    {
      if (!this.isResumed)
      {
        this.isResumed = true;
        StatisticManager.onPageStart(mActivity, getClass().getSimpleName());
      }
      super.onResume();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i.a("", localException.toString());
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onUpdateSkin() {}
  
  public boolean onVoiceCommand(int paramInt)
  {
    return false;
  }
  
  public boolean onVoiceCommand(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean)
  {
    if (2 == paramInt1) {}
    switch (paramInt2)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean onVoiceCommand(String paramString1, String paramString2)
  {
    return false;
  }
  
  public void pageBack(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 4) || (paramInt == 2))
    {
      if (getCurrentFragmentType() == 35) {
        backTo(34, null);
      }
      back();
      if (paramInt == 1) {
        performOpenHome();
      }
      do
      {
        return;
        if (paramInt == 4)
        {
          showLatestMusicFragment();
          return;
        }
      } while (paramInt != 2);
      showLatestPhoneFragment();
      return;
    }
    back();
  }
  
  public void replyVoiceCommand(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      BNVoiceCommandController.getInstance().commonVoiceCommandResponse(paramInt1, paramInt2);
    }
  }
  
  public void requestInitView()
  {
    if (this.mViewCreated)
    {
      onInitView();
      return;
    }
    this.mNeedInitView = true;
  }
  
  public void requestRestoreView()
  {
    if (this.mViewCreated)
    {
      onRestoreView();
      return;
    }
    this.mNeedRetoreView = true;
  }
  
  public void setAddFt(boolean paramBoolean)
  {
    this.isAddFt = paramBoolean;
  }
  
  protected void setCommonTitleBar(View paramView, String paramString)
  {
    Object localObject = (ImageButton)paramView.findViewById(2131624258);
    if (localObject != null)
    {
      ((ImageButton)localObject).setBackground(b.a(mActivity));
      ((ImageButton)localObject).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ContentFragment.this.back();
        }
      });
    }
    localObject = paramView.findViewById(2131624261);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ContentFragment.this.back();
        }
      });
    }
    paramView = (TextView)paramView.findViewById(2131624059);
    if ((paramView != null) && (!TextUtils.isEmpty(paramString))) {
      paramView.setText(paramString);
    }
  }
  
  protected void startAnimation(Map<View, Animation> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        Animation localAnimation = (Animation)paramMap.get(localView);
        if ((localAnimation != null) && (localView != null)) {
          localView.startAnimation(localAnimation);
        }
      }
    }
  }
  
  public void stopDriving() {}
  
  protected void updateCommonSkin()
  {
    if (this.mContentView == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (ImageButton)this.mContentView.findViewById(2131624258);
      if (localObject != null)
      {
        ((ImageButton)localObject).setImageDrawable(r.b(2130838256));
        ((ImageButton)localObject).setBackground(b.a(mActivity));
      }
      localObject = (TextView)this.mContentView.findViewById(2131624059);
    } while (localObject == null);
    ((TextView)localObject).setTextColor(r.a(2131558699));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/ContentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */