package com.baidu.navisdk.ui.cruise.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class CruiseMenu
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final String TAG = CruiseMenu.class.getSimpleName();
  private static final int[] sItemNameTextViewIds = { 1711865979, 1711865983 };
  private static final int[] sItemViewIds;
  private static final int[] sLineViewIds = { 1711865977, 1711865981, 1711865985 };
  private static final int[] sSettingCheckBoxIds = { 1711865973, 1711865974, 1711865975, 1711865976 };
  public static final String[] sSettingPrefKeys = { "CloseSpeedCamera", "CloseTrafficLightCamera", "ClosePeccanryCamera", "CloseTrafficSign" };
  private static final String[] sSettingStatEventIds = { "410023", "410024", "410025", "410026" };
  private static final int[][] sSettingToastResIds = { { 1711669703, 1711669704 }, { 1711669711, 1711669712 }, { 1711669707, 1711669708 }, { 1711669714, 1711669715 } };
  private Activity mActivity;
  private Button mCloseButton;
  private Context mContext;
  private boolean mDayStyle = true;
  private TextView[] mItemNameTextViews = new TextView[sItemNameTextViewIds.length];
  private View[] mItemViews = new View[sItemViewIds.length];
  private View[] mLineViews = new View[sLineViewIds.length];
  private IOnMenuItemClickedListener mMenuBackClickListener = null;
  public View mMenuList;
  private PreferenceHelper mPrefs;
  public View mRootView;
  private CheckBox[] mSettingCheckBoxes = new CheckBox[sSettingCheckBoxIds.length];
  private Bundle mSettingPrefs;
  private TextView mSettingTitleTextView;
  
  static
  {
    sItemViewIds = new int[] { 1711865978, 1711865982 };
  }
  
  public CruiseMenu(Context paramContext)
  {
    this.mActivity = ((Activity)paramContext);
    this.mContext = paramContext;
    this.mPrefs = PreferenceHelper.getInstance(paramContext);
    this.mSettingPrefs = new Bundle();
    int j = this.mPrefs.getInt("CloseCamera", 0);
    int i = 0;
    while (i < sSettingPrefKeys.length)
    {
      initSettingPref(sSettingPrefKeys[i], j);
      i += 1;
    }
  }
  
  private void handleVoiceSettingItemChanged(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    if (paramBoolean)
    {
      i = 0;
      if ((paramInt >= 0) && (paramInt < sSettingPrefKeys.length))
      {
        this.mSettingPrefs.putInt(sSettingPrefKeys[paramInt], i);
        BNRouteGuider.getInstance().SetCruiseSetting(this.mSettingPrefs);
        this.mPrefs.putInt(sSettingPrefKeys[paramInt], i);
      }
      if (!paramBoolean) {
        break label150;
      }
    }
    label150:
    for (int i = j;; i = 1)
    {
      if ((paramInt >= 0) && (i >= 0) && (paramInt < sSettingToastResIds.length) && (i < sSettingToastResIds[paramInt].length)) {
        TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(sSettingToastResIds[paramInt][i]));
      }
      if ((paramInt >= 0) && (paramInt < sSettingStatEventIds.length)) {
        BNStatisticsManager.getInstance().onEvent(this.mContext, sSettingStatEventIds[paramInt], sSettingStatEventIds[paramInt]);
      }
      return;
      i = 1;
      break;
    }
  }
  
  private void initSettingPref(String paramString, int paramInt)
  {
    if (this.mPrefs.contains(paramString))
    {
      this.mSettingPrefs.putInt(paramString, this.mPrefs.getInt(paramString, 0));
      return;
    }
    this.mPrefs.putInt(paramString, paramInt);
    this.mSettingPrefs.putInt(paramString, paramInt);
  }
  
  private void showQaDialog()
  {
    if (NetworkUtils.isNetworkAvailable(this.mContext))
    {
      new CruiseQADialog(this.mActivity, 16973833).show();
      return;
    }
    TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711669729));
  }
  
  public View getView()
  {
    return this.mRootView;
  }
  
  public void handleCruiseVoiceChanged(boolean paramBoolean1, boolean paramBoolean2)
  {
    TTSPlayerControl.setNaviMuteState(paramBoolean2);
    if (paramBoolean1)
    {
      if (!TTSPlayerControl.isNaviMuteState()) {
        TipTool.onCreateToastDialog(this.mContext, "电子狗播报已开启");
      }
    }
    else {
      return;
    }
    TipTool.onCreateToastDialog(this.mContext, "电子狗播报已静音");
  }
  
  public void hide()
  {
    if (this.mRootView != null) {
      this.mRootView.setVisibility(8);
    }
  }
  
  public void initViews()
  {
    this.mRootView = JarUtils.inflate(this.mActivity, 1711472662, null);
    this.mRootView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.mCloseButton = ((Button)this.mRootView.findViewById(1711865986));
    if (this.mCloseButton != null) {
      this.mCloseButton.setOnClickListener(this);
    }
    this.mMenuList = this.mRootView.findViewById(1711865970);
    if (this.mMenuList == null) {
      return;
    }
    this.mSettingTitleTextView = ((TextView)this.mMenuList.findViewById(1711865971));
    View localView = this.mMenuList.findViewById(1711865972);
    if (localView != null)
    {
      int j = BNStyleManager.getDimension(1711734829);
      i = j;
      if (Build.VERSION.SDK_INT >= 17) {
        i = j - ScreenUtil.getInstance().dip2px(20);
      }
      j = 0;
      if (j < sSettingCheckBoxIds.length)
      {
        this.mSettingCheckBoxes[j] = ((CheckBox)localView.findViewById(sSettingCheckBoxIds[j]));
        CheckBox localCheckBox;
        if (this.mSettingCheckBoxes[j] != null)
        {
          this.mSettingCheckBoxes[j].setOnCheckedChangeListener(this);
          int k = this.mPrefs.getInt(sSettingPrefKeys[j], 0);
          localCheckBox = this.mSettingCheckBoxes[j];
          if (k != 0) {
            break label274;
          }
        }
        label274:
        for (boolean bool = true;; bool = false)
        {
          localCheckBox.setChecked(bool);
          this.mSettingCheckBoxes[j].setPadding(i, this.mSettingCheckBoxes[j].getPaddingTop(), this.mSettingCheckBoxes[j].getPaddingRight(), this.mSettingCheckBoxes[j].getPaddingBottom());
          j += 1;
          break;
        }
      }
    }
    int i = 0;
    while (i < sItemViewIds.length)
    {
      this.mItemViews[i] = this.mMenuList.findViewById(sItemViewIds[i]);
      if (this.mItemViews[i] != null) {
        this.mItemViews[i].setOnClickListener(this);
      }
      i += 1;
    }
    i = 0;
    while (i < sLineViewIds.length)
    {
      this.mLineViews[i] = this.mMenuList.findViewById(sLineViewIds[i]);
      i += 1;
    }
    i = 0;
    while (i < sItemNameTextViewIds.length)
    {
      this.mItemNameTextViews[i] = ((TextView)this.mMenuList.findViewById(sItemNameTextViewIds[i]));
      i += 1;
    }
    onUpdateStyle(this.mDayStyle);
  }
  
  public boolean isShowing()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mRootView != null)
    {
      bool1 = bool2;
      if (this.mRootView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      int j;
      if (i < sSettingCheckBoxIds.length)
      {
        if (paramCompoundButton.getId() != sSettingCheckBoxIds[i]) {
          break label70;
        }
        j = this.mPrefs.getInt(sSettingPrefKeys[i], 0);
        if ((!paramBoolean) || (j != 1)) {
          break label54;
        }
        handleVoiceSettingItemChanged(i, true);
      }
      label54:
      while ((paramBoolean) || (j != 0)) {
        return;
      }
      handleVoiceSettingItemChanged(i, false);
      return;
      label70:
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 1711865986) {
      onMenuBack();
    }
    do
    {
      return;
      if (paramView.getId() == 1711865978)
      {
        BCruiser.getInstance().innerJumpToOfflineDataManagerPage();
        BNStatisticsManager.getInstance().onEvent(this.mContext, "410027", "410027");
        return;
      }
    } while (paramView.getId() != 1711865982);
    BNStatisticsManager.getInstance().onEvent(this.mContext, "410028", "410028");
    showQaDialog();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onMenuBack()
  {
    if (this.mMenuBackClickListener != null) {
      this.mMenuBackClickListener.onClickClose();
    }
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    int j = 0;
    this.mDayStyle = paramBoolean;
    if (this.mMenuList == null) {}
    for (;;)
    {
      return;
      this.mRootView.setBackgroundColor(JarUtils.getResources().getColor(1711800451));
      this.mCloseButton.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407603));
      if (this.mSettingTitleTextView != null) {
        this.mSettingTitleTextView.setTextColor(BNStyleManager.getColor(1711800416));
      }
      Object localObject1 = this.mSettingCheckBoxes;
      int k = localObject1.length;
      int i = 0;
      Object localObject2;
      while (i < k)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null) {
          ((CheckBox)localObject2).setTextColor(BNStyleManager.getColor(1711800416));
        }
        i += 1;
      }
      localObject1 = this.mLineViews;
      k = localObject1.length;
      i = 0;
      while (i < k)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null) {
          ((View)localObject2).setBackgroundDrawable(BNStyleManager.getDrawable(1711407533));
        }
        i += 1;
      }
      localObject1 = this.mItemViews;
      k = localObject1.length;
      i = 0;
      while (i < k)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null)
        {
          ((View)localObject2).setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407444));
          int m = ScreenUtil.getInstance().dip2px(10);
          ((View)localObject2).setPadding(m, 0, m, 0);
        }
        i += 1;
      }
      localObject1 = this.mItemNameTextViews;
      k = localObject1.length;
      i = j;
      while (i < k)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null) {
          ((TextView)localObject2).setTextColor(BNStyleManager.getColor(1711800416));
        }
        i += 1;
      }
    }
  }
  
  public void setMenuItemClickListener(IOnMenuItemClickedListener paramIOnMenuItemClickedListener)
  {
    this.mMenuBackClickListener = paramIOnMenuItemClickedListener;
  }
  
  public void show()
  {
    if (this.mRootView != null) {
      this.mRootView.setVisibility(0);
    }
  }
  
  public static abstract interface IOnMenuItemClickedListener
  {
    public abstract void onClickClose();
    
    public abstract void onClickHelp();
    
    public abstract void onClickOfflineData();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/cruise/view/CruiseMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */