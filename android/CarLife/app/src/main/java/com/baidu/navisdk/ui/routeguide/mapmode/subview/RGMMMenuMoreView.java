package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.ReplacementTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.iview.IMoreSettingView;
import com.baidu.navisdk.ui.routeguide.mapmode.presenter.MoreSettingPresenter;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseOrientationView;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import com.baidu.navisdk.ui.widget.BNDebugModelDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public class RGMMMenuMoreView
  extends BNBaseOrientationView
  implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, TextView.OnEditorActionListener, IMoreSettingView
{
  public static final int BLUETOOTH_INDEX = 1;
  public static final int DYNAMIC_3D_INDEX = 4;
  public static final int FLOAT_INDEX = 7;
  private static final long K_INTERNEL_CLICK = 1000L;
  private static final long K_MAX_CLICK = 7L;
  public static final int LICENSE_PLATES_LIMIT_INDEX = 0;
  public static final int LIST_OPTION_CNT = 8;
  public static final int PARK_INDEX = 6;
  public static final int REAL_ENLARGE_INDEX = 3;
  public static final int SCALE_INDEX = 2;
  private static final int SHOT_NAME_CELLS_CNT = 9;
  public static final int SHOW_CAR_LOGO_TO_END_INDEX = 5;
  private static String TAG = "RouteGuide";
  private static String mPlateNumTag = "";
  private RelativeLayout carPlateParent;
  private RadioGroup dayModeSelector;
  private RadioGroup guideAngleSeletor;
  private int[] hDividerLineView = { 1711866791, 1711866800, 1711866813, 1711866819, 1711866828, 1711866834, 1711866840, 1711866845, 1711866850, 1711866855, 1711866862, 1711866867, 1711866873, 1711866786 };
  private boolean isInputMethodShowing = false;
  private int[] mBackgroundView = { 1711866820, 1711866796, 1711866801, 1711866807, 1711866814, 1711866827, 1711866829, 1711866830, 1711866835, 1711866836, 1711866841, 1711866842, 1711866846, 1711866851, 1711866856, 1711866861, 1711866863, 1711866868, 1711866874, 1711866875, 1711866790, 1711866792, 1711866785, 1711866809 };
  private ImageView mCarLogoArrowView = null;
  private ImageView mCarLogoRedGuide;
  private String mCarNum = "";
  private TextView mCarPlate;
  private ImageButton mCarPlateDelete;
  private TextView mCarPlateHead;
  private EditText mCarPlateInput;
  private RelativeLayout mCarPlateSettingView;
  private TextView mCarPlateTs;
  private ImageView[] mCheckboxs = new ImageView[8];
  private LinearLayout mCityShortName;
  private final String[] mCityShotNames = { "京", "沪", "浙", "苏", "粤", "鲁", "晋", "冀", "豫", "川", "渝", "辽", "吉", "黑", "皖", "鄂", "湘", "赣", "闽", "陕", "甘", "宁", "蒙", "津", "贵", "云", "桂", "琼", "青", "新", "藏" };
  private int mClickNum;
  private int[] mDividerCategoryView = { 1711866826, 1711866860, 1711866789 };
  private ImageView mIVBlueToothRedGuide;
  private boolean[] mIsChecked = new boolean[8];
  private long mLastClickTime;
  private ScrollView mMenuMoreScroll;
  private MoreSettingPresenter mPresenter = new MoreSettingPresenter(this);
  private int[] mTextViewId = { 1711866802, 1711866821, 1711866827, 1711866835, 1711866852, 1711866847, 1711866861, 1711866864, 1711866815, 1711866869, 1711866790, 1711866793, 1711866827, 1711866829, 1711866835, 1711866841, 1711866857, 1711866861, 1711866874, 1711866790, 1711866793 };
  private int[] mTipsTextViewId = { 1711866853, 1711866848, 1711866865, 1711866817, 1711866871, 1711866858, 1711866878, 1711866795, 1711866804, 1711866823 };
  private BNCommonTitleBar mTitleBar = null;
  private int[] mTogglebuttonGroup = { 1711866796, 1711866830, 1711866836, 1711866842, 1711866875 };
  private ImageView mVoiceRedGuide = null;
  private TextView mVoiceTV = null;
  private TextView mVoiceValTips;
  private RadioGroup misicVolumeSelector;
  private RadioGroup oververSelector;
  private View shadowView;
  private View.OnClickListener shotNameOnclickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (paramAnonymousView == null) {}
      while ((RGMMMenuMoreView.this.mCarPlateInput == null) || (RGMMMenuMoreView.this.mCarPlate == null) || (RGMMMenuMoreView.this.mCityShortName == null) || (RGMMMenuMoreView.this.shadowView == null)) {
        return;
      }
      paramAnonymousView = ((TextView)paramAnonymousView).getText().toString();
      RGMMMenuMoreView.this.updatePlateView(paramAnonymousView);
      if ((RGMMMenuMoreView.this.mCarPlateInput != null) && (RGMMMenuMoreView.this.mCarPlateInput.getText().toString().length() >= 6) && (RGMMMenuMoreView.this.mIsChecked[0] != 0) && ((RGMMMenuMoreView.this.mCarPlateInput.getVisibility() == 0) || (RGMMMenuMoreView.this.mCarPlate.getVisibility() == 0)) && (RGMMMenuMoreView.this.mCarPlateInput.getVisibility() == 0) && (RGMMMenuMoreView.this.checkPlate())) {
        RGMMMenuMoreView.this.mPresenter.handleCheckPlateSuccess(RGMMMenuMoreView.this.mContext, RGMMMenuMoreView.this.mCarNum);
      }
      RGMMMenuMoreView.this.setCityShortPanelVisible(8);
      RGMMMenuMoreView.this.shadowView.setVisibility(8);
    }
  };
  private RadioGroup voiceModeSeletor;
  
  public RGMMMenuMoreView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
  }
  
  private boolean carPlateNumIsEmpty()
  {
    if ((this.mCarPlate == null) || (this.mCarPlateInput == null)) {}
    while (TextUtils.isEmpty(this.mCarPlateInput.getText().toString().trim())) {
      return true;
    }
    return false;
  }
  
  private void changeContinewNavi()
  {
    if (("NAV_STATE_OPERATE".equals(RGControlPanelModel.getInstance().getNavState())) && (this.mSubViewListener != null)) {
      this.mSubViewListener.onOtherAction(3, 0, 0, null);
    }
  }
  
  private boolean checkClick()
  {
    boolean bool = false;
    long l = System.currentTimeMillis();
    if (l - this.mLastClickTime < 1000L) {}
    for (this.mClickNum += 1;; this.mClickNum = 0)
    {
      this.mLastClickTime = l;
      if (this.mClickNum > 3L) {
        TipTool.onCreateToastDialog(this.mContext, "连击:" + this.mClickNum);
      }
      if (this.mClickNum >= 7L)
      {
        this.mClickNum = 0;
        bool = true;
      }
      return bool;
    }
  }
  
  private boolean checkPlate()
  {
    if ((this.mCarPlate == null) || (this.mCarPlateInput == null)) {
      return false;
    }
    this.mCarNum = this.mCarPlate.getText().toString().trim();
    if (TextUtils.isEmpty(this.mCarNum)) {
      this.mCarNum = this.mCarPlateInput.getText().toString().trim();
    }
    return this.mPresenter.checkPlate(this.mCarNum);
  }
  
  private boolean getIsTrueCurDay(boolean paramBoolean)
  {
    if ((this.mRootView != null) && (this.hDividerLineView.length > 0) && (this.mRootView.findViewById(this.hDividerLineView[0]) != null))
    {
      View localView = this.mRootView.findViewById(this.hDividerLineView[0]);
      if (Build.VERSION.SDK_INT >= 11)
      {
        int i = ((ColorDrawable)localView.getBackground()).getColor();
        if (JarUtils.getResources() != null) {
          if (i != JarUtils.getResources().getColor(1711800690)) {
            break label102;
          }
        }
      }
    }
    label102:
    for (boolean bool = true;; bool = false)
    {
      this.mIsCurDay = bool;
      if (paramBoolean != this.mIsCurDay) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void hideInput()
  {
    if (this.carPlateParent == null) {
      return;
    }
    this.carPlateParent.setVisibility(8);
  }
  
  private boolean hideInputMethodView()
  {
    if (this.mCarPlateInput == null) {}
    InputMethodManager localInputMethodManager;
    do
    {
      return false;
      localInputMethodManager = (InputMethodManager)this.mContext.getSystemService("input_method");
    } while ((localInputMethodManager == null) || (!localInputMethodManager.isActive()));
    localInputMethodManager.hideSoftInputFromWindow(this.mCarPlateInput.getWindowToken(), 0);
    this.mCarPlateInput.clearFocus();
    return true;
  }
  
  private void hidePlate()
  {
    if ((this.mCarPlate == null) || (this.mCarPlateDelete == null)) {
      return;
    }
    hideInputMethodView();
    this.mCarPlate.setVisibility(8);
    this.mCarPlateDelete.setVisibility(8);
  }
  
  private void initActionOnOff()
  {
    this.mIsChecked = this.mPresenter.initUserConfig();
    int i = 0;
    while (i < 8)
    {
      updateCheckDrawable(i);
      i += 1;
    }
    if (this.mCarPlateSettingView != null)
    {
      if (this.mIsChecked[0] != 0) {
        break label61;
      }
      this.mCarPlateSettingView.setVisibility(8);
    }
    for (;;)
    {
      initRadioGroups();
      return;
      label61:
      this.mCarPlateSettingView.setVisibility(0);
    }
  }
  
  private void initLicensePlatesLimitView()
  {
    this.mCarPlateSettingView = ((RelativeLayout)this.mRootView.findViewById(1711866807));
    this.carPlateParent = ((RelativeLayout)this.mRootView.findViewById(1711866809));
    this.mCarPlateTs = ((TextView)this.mRootView.findViewById(1711866803));
    this.mCarPlateInput = ((EditText)this.mRootView.findViewById(1711866811));
    this.mCarPlateDelete = ((ImageButton)this.mRootView.findViewById(1711866812));
    this.mCarPlateHead = ((TextView)this.mRootView.findViewById(1711866810));
    this.mRootView.findViewById(1711866805).setOnClickListener(this);
    this.mCarPlate = ((TextView)this.mRootView.findViewById(1711866808));
    this.mCityShortName = ((LinearLayout)this.mRootView.findViewById(1711866788));
    this.shadowView = this.mRootView.findViewById(1711866879);
    initPlateInput();
    updateCheckDrawable(0);
    this.mCarPlateDelete.setOnClickListener(this);
    this.mCarPlate.setOnClickListener(this);
    this.mPresenter.initPlateFromLocal(this.mContext);
    this.mCarPlateInput.setOnEditorActionListener(this);
  }
  
  private void initPlateInput()
  {
    if ((this.mCarPlateInput == null) || (this.mCarPlateHead == null) || (this.mCarPlate == null)) {
      return;
    }
    this.mCarPlateInput.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        try
        {
          RGMMMenuMoreView.this.mCarPlateTs.setText("");
          RGMMMenuMoreView.this.mCarPlateTs.setTextColor(Color.parseColor("#7a7c80"));
          if (paramAnonymousEditable.length() >= 6)
          {
            if ((RGMMMenuMoreView.this.mIsChecked[0] != 0) && ((RGMMMenuMoreView.this.mCarPlateInput.getVisibility() == 0) || (RGMMMenuMoreView.this.mCarPlate.getVisibility() == 0)) && (RGMMMenuMoreView.this.mCarPlateInput.getVisibility() == 0) && (RGMMMenuMoreView.this.checkPlate()))
            {
              if (paramAnonymousEditable.length() == 7)
              {
                RGMMMenuMoreView.this.mCarPlateTs.setText("(新能源车牌)");
                RGMMMenuMoreView.this.mCarPlateTs.setTextColor(Color.parseColor("#45cc6a"));
              }
              RGMMMenuMoreView.this.mPresenter.handleCheckPlateSuccess(RGMMMenuMoreView.this.mContext, RGMMMenuMoreView.this.mCarNum);
              RGMMMenuMoreView.this.mPresenter.updatePreferValue(32, RGMMMenuMoreView.this.mIsChecked[0]);
            }
          }
          else if ((paramAnonymousEditable.length() == 0) && (RGMMMenuMoreView.this.mCarPlateInput != null))
          {
            boolean bool = RGMMMenuMoreView.this.mCarPlateInput.isShown();
            if (bool) {}
          }
        }
        catch (Exception paramAnonymousEditable) {}
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (TextUtils.isEmpty(paramAnonymousCharSequence)) {
          return;
        }
        try
        {
          paramAnonymousCharSequence = paramAnonymousCharSequence.toString().toUpperCase().trim();
          RGMMMenuMoreView.this.mCarPlate.setText(RGMMMenuMoreView.this.mCarPlateHead.getText() + paramAnonymousCharSequence.toString());
          return;
        }
        catch (Exception paramAnonymousCharSequence) {}
      }
    });
    this.mCarPlateInput.setTransformationMethod(new AllCapTransMethod());
    this.mCarPlateHead.setOnClickListener(this);
    this.mCarPlateInput.setClickable(true);
    this.mCarPlateInput.setOnClickListener(this);
    this.mCarPlateInput.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          RGMMMenuMoreView.this.mPresenter.addUserOP("b.2");
        }
      }
    });
  }
  
  private void initRadioGroups()
  {
    this.voiceModeSeletor = ((RadioGroup)this.mRootView.findViewById(1711866796));
    this.guideAngleSeletor = ((RadioGroup)this.mRootView.findViewById(1711866830));
    this.dayModeSelector = ((RadioGroup)this.mRootView.findViewById(1711866836));
    this.oververSelector = ((RadioGroup)this.mRootView.findViewById(1711866842));
    this.misicVolumeSelector = ((RadioGroup)this.mRootView.findViewById(1711866875));
    this.mPresenter.initActionSwitchSetting();
    this.voiceModeSeletor.setOnCheckedChangeListener(this);
    this.guideAngleSeletor.setOnCheckedChangeListener(this);
    this.dayModeSelector.setOnCheckedChangeListener(this);
    this.oververSelector.setOnCheckedChangeListener(this);
    this.misicVolumeSelector.setOnCheckedChangeListener(this);
  }
  
  private void openCarPlatDirectly(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.mMenuMoreScroll.scrollTo(0, 0);
      if (this.mIsChecked[0] == 0)
      {
        reverseItemCheck(0);
        this.mPresenter.onSettingsChange(this.mIsChecked, 0);
      }
      showInputMethodView();
      return;
    }
    showInputMethodView();
  }
  
  private void reverseItemCheck(int paramInt)
  {
    try
    {
      boolean[] arrayOfBoolean = this.mIsChecked;
      if (this.mIsChecked[paramInt] == 0) {}
      for (int i = 1;; i = 0)
      {
        arrayOfBoolean[paramInt] = i;
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void setCityShortPanelVisible(int paramInt)
  {
    if (this.mCityShortName != null) {
      this.mCityShortName.setVisibility(paramInt);
    }
  }
  
  private void showDialogCityShotName()
  {
    if ((this.mCityShortName == null) || (this.shadowView == null)) {}
    for (;;)
    {
      return;
      hideInputMethodView();
      this.mCityShortName.requestFocus();
      if (this.mCityShortName.getVisibility() == 0)
      {
        setCityShortPanelVisible(8);
        this.shadowView.setVisibility(8);
        return;
      }
      setCityShortPanelVisible(0);
      this.shadowView.setVisibility(0);
      this.shadowView.setOnClickListener(this);
      this.mCityShortName.setClickable(true);
      this.mCityShortName.removeAllViews();
      int j = 0;
      while (j < this.mCityShotNames.length) {
        if ((j == 0) || (j % 9 == 0))
        {
          LinearLayout localLinearLayout1 = (LinearLayout)JarUtils.inflate((Activity)this.mContext, 1711472640, null);
          int i = 0;
          if (i < 9)
          {
            LinearLayout localLinearLayout2 = (LinearLayout)JarUtils.inflate((Activity)this.mContext, 1711472641, null);
            localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 1.0F));
            TextView localTextView = (TextView)localLinearLayout2.findViewById(1711865859);
            if (j < this.mCityShotNames.length)
            {
              localTextView.setText(this.mCityShotNames[j]);
              localTextView.setOnClickListener(this.shotNameOnclickListener);
            }
            for (;;)
            {
              localLinearLayout1.addView(localLinearLayout2);
              j += 1;
              i += 1;
              break;
              localTextView.setVisibility(4);
            }
          }
          this.mCityShortName.addView(localLinearLayout1);
        }
      }
    }
  }
  
  private void showInput()
  {
    if (this.carPlateParent == null) {
      return;
    }
    this.carPlateParent.setVisibility(0);
    this.mCarPlateInput.setFocusable(true);
    this.mCarPlateInput.setFocusableInTouchMode(true);
    this.mCarPlateInput.requestFocus();
  }
  
  private void showInputMethodView()
  {
    if (this.mCarPlateInput == null) {}
    InputMethodManager localInputMethodManager;
    do
    {
      return;
      this.mCarPlateInput.setFocusable(true);
      this.mCarPlateInput.setFocusableInTouchMode(true);
      this.mCarPlateInput.requestFocus();
      localInputMethodManager = (InputMethodManager)this.mCarPlateInput.getContext().getSystemService("input_method");
    } while (localInputMethodManager == null);
    localInputMethodManager.showSoftInput(this.mCarPlateInput, 0);
  }
  
  private void showPlate()
  {
    if ((this.mCarPlate == null) || (this.mCarPlateDelete == null)) {
      return;
    }
    this.mCarPlate.setVisibility(0);
    this.mCarPlateDelete.setVisibility(0);
  }
  
  private void updateDayModeView()
  {
    this.mCarLogoArrowView.setImageDrawable(JarUtils.getResources().getDrawable(1711407528));
    int i = 0;
    while ((this.mRootView != null) && (i < this.mTextViewId.length))
    {
      localObject = (TextView)this.mRootView.findViewById(this.mTextViewId[i]);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(Color.parseColor("#333333"));
      }
      i += 1;
    }
    i = 0;
    while ((this.mRootView != null) && (i < this.mTipsTextViewId.length))
    {
      localObject = (TextView)this.mRootView.findViewById(this.mTipsTextViewId[i]);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(BNStyleManager.getColor(1711800676));
      }
      i += 1;
    }
    if (this.mTitleBar != null)
    {
      this.mTitleBar.setTitleBarBackgroundColor(BNStyleManager.getColor(1711800536));
      this.mTitleBar.setMiddleTextColor(BNStyleManager.getColor(1711800538));
      this.mTitleBar.setLeftIconAlpha(1.0F);
      this.mTitleBar.setTitleBarDivideLineBackgroudColor(BNStyleManager.getColor(1711800539));
      this.mTitleBar.setLeftImageViewSrc(BNStyleManager.getDrawable(1711407181));
    }
    Object localObject = JarUtils.getResources().getColorStateList(1711800810);
    i = 0;
    while ((this.mTogglebuttonGroup != null) && (i < this.mTogglebuttonGroup.length))
    {
      RadioGroup localRadioGroup = (RadioGroup)this.mRootView.findViewById(this.mTogglebuttonGroup[i]);
      int j = 0;
      while ((localRadioGroup.getChildCount() > 0) && (j < localRadioGroup.getChildCount()))
      {
        RadioButton localRadioButton = (RadioButton)localRadioGroup.getChildAt(j);
        if (localObject != null) {
          localRadioButton.setTextColor((ColorStateList)localObject);
        }
        localRadioButton.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407154));
        j += 1;
      }
      i += 1;
    }
    if ((this.carPlateParent != null) && (this.mCarPlate != null) && (this.mCarPlateInput != null))
    {
      this.carPlateParent.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407168));
      this.mCarPlate.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407168));
      this.mCarPlateInput.setTextColor(-16777216);
      this.mCarPlate.setTextColor(-16777216);
    }
  }
  
  private void updateNightModeView()
  {
    this.mCarLogoArrowView.setImageDrawable(JarUtils.getResources().getDrawable(1711407527));
    int i = 0;
    Object localObject;
    while ((this.mRootView != null) && (i < this.mTextViewId.length))
    {
      localObject = (TextView)this.mRootView.findViewById(this.mTextViewId[i]);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      }
      i += 1;
    }
    i = 0;
    while ((this.mRootView != null) && (i < this.mTipsTextViewId.length))
    {
      localObject = (TextView)this.mRootView.findViewById(this.mTipsTextViewId[i]);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(Color.parseColor("#606367"));
      }
      i += 1;
    }
    if (this.mTitleBar != null)
    {
      this.mTitleBar.setTitleBarBackgroundColor(JarUtils.getResources().getColor(1711800695));
      this.mTitleBar.setMiddleTextColor(Color.parseColor("#ffffff"));
      this.mTitleBar.setLeftIconAlpha(0.3F);
      this.mTitleBar.setTitleBarDivideLineBackgroudColor(BNStyleManager.getColor(1711800540));
      this.mTitleBar.setLeftImageViewSrc(BNStyleManager.getDrawable(1711407183));
    }
    i = 0;
    while ((this.mTogglebuttonGroup != null) && (i < this.mTogglebuttonGroup.length))
    {
      localObject = (RadioGroup)this.mRootView.findViewById(this.mTogglebuttonGroup[i]);
      int j = 0;
      while ((((RadioGroup)localObject).getChildCount() > 0) && (j < ((RadioGroup)localObject).getChildCount()))
      {
        RadioButton localRadioButton = (RadioButton)((RadioGroup)localObject).getChildAt(j);
        localRadioButton.setTextColor(-1);
        localRadioButton.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407155));
        j += 1;
      }
      i += 1;
    }
    if ((this.carPlateParent != null) && (this.mCarPlate != null) && (this.mCarPlateInput != null))
    {
      this.carPlateParent.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407169));
      this.mCarPlate.setBackgroundDrawable(JarUtils.getResources().getDrawable(1711407169));
      this.mCarPlateInput.setTextColor(-1);
      this.mCarPlate.setTextColor(-1);
    }
  }
  
  private void updatePlateView(String paramString)
  {
    if ((this.mCarPlateHead == null) || (this.mCarPlate == null)) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.mCarPlateHead.setText(paramString);
      this.mCarPlate.setText(paramString + this.mCarPlateInput.getText().toString().toUpperCase().trim());
      return;
    }
    this.mCarPlateHead.setText("");
  }
  
  public boolean checkMenuMoreViewPlateChanged()
  {
    if (this.mIsChecked[0] == 0) {}
    String str;
    do
    {
      do
      {
        return false;
      } while ((this.mCarPlateInput == null) || (this.mCarPlateHead == null));
      str = this.mCarPlateHead.getText().toString().trim() + this.mCarPlateInput.getText().toString().trim();
    } while ((StringUtils.isEmpty(mPlateNumTag)) || (StringUtils.isEmpty(str)) || (mPlateNumTag.equals(str)));
    return true;
  }
  
  public ViewGroup.LayoutParams generalLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -1);
  }
  
  public int getContainerViewId()
  {
    return 1711866547;
  }
  
  public void getIsShowMapSwitch(int paramInt)
  {
    if (this.oververSelector != null)
    {
      if (paramInt == 0) {
        this.oververSelector.check(1711866843);
      }
    }
    else {
      return;
    }
    this.oververSelector.check(1711866844);
  }
  
  public int getLandscapeLayoutId()
  {
    return 1711472729;
  }
  
  public void getMapMode(int paramInt)
  {
    if (this.guideAngleSeletor != null)
    {
      if (paramInt != 0) {
        break label22;
      }
      this.guideAngleSeletor.check(1711866831);
    }
    label22:
    while (paramInt != 1) {
      return;
    }
    this.guideAngleSeletor.check(1711866832);
  }
  
  public void getNaviDayAndNightMode(int paramInt)
  {
    if (this.dayModeSelector != null)
    {
      if (paramInt == 0) {
        this.dayModeSelector.check(1711866837);
      }
    }
    else {
      return;
    }
    if (paramInt == 1)
    {
      this.dayModeSelector.check(1711866838);
      return;
    }
    this.dayModeSelector.check(1711866839);
  }
  
  public void getPlayTTsVoiceMode(int paramInt)
  {
    if ((this.misicVolumeSelector != null) && (this.mVoiceValTips != null))
    {
      if (paramInt == 0)
      {
        this.misicVolumeSelector.check(1711866876);
        this.mVoiceValTips.setText(JarUtils.getResources().getString(1711670363));
      }
    }
    else {
      return;
    }
    this.misicVolumeSelector.check(1711866877);
    this.mVoiceValTips.setText(JarUtils.getResources().getString(1711670364));
  }
  
  public int getPortraitLayoutId()
  {
    return 1711472729;
  }
  
  public void getVoiceMode(int paramInt)
  {
    if (paramInt == 0)
    {
      this.voiceModeSeletor.check(1711866797);
      return;
    }
    if (paramInt == 1)
    {
      this.voiceModeSeletor.check(1711866798);
      return;
    }
    this.voiceModeSeletor.check(1711866799);
  }
  
  public void hide()
  {
    if (isVisibility()) {
      RGViewController.getInstance().updateToolBoxStatus();
    }
    super.hide();
    hideInputMethodView();
    setCityShortPanelVisible(8);
    XDVoiceInstructManager.getInstance().setWakeupEnable(true);
  }
  
  public void initListener()
  {
    this.mTitleBar.findViewById(1711865878).setOnClickListener(this);
    this.mRootView.findViewById(1711866820).setOnClickListener(this);
    this.mRootView.findViewById(1711866801).setOnClickListener(this);
    this.mRootView.findViewById(1711866851).setOnClickListener(this);
    this.mRootView.findViewById(1711866856).setOnClickListener(this);
    this.mRootView.findViewById(1711866846).setOnClickListener(this);
    this.mRootView.findViewById(1711866863).setOnClickListener(this);
    this.mRootView.findViewById(1711866868).setOnClickListener(this);
    this.mRootView.findViewById(1711866814).setOnClickListener(this);
    this.mRootView.findViewById(1711866792).setOnClickListener(this);
    this.mRootView.findViewById(1711866833).setOnClickListener(this);
    this.mRootView.findViewById(1711866861).setOnClickListener(this);
    this.mTitleBar.setOnClickListener(this);
  }
  
  public void initViewById()
  {
    if (this.mRootView == null) {
      return;
    }
    this.mTitleBar = ((BNCommonTitleBar)this.mRootView.findViewById(1711865893));
    if (this.mTitleBar != null)
    {
      this.mTitleBar.setMiddleTextVisible(true);
      this.mTitleBar.setMiddleText(BNStyleManager.getString(1711669404));
      this.mTitleBar.setMiddleTextSize(16.0F);
      this.mTitleBar.setRightTextVisible(false);
    }
    this.mMenuMoreScroll = ((ScrollView)this.mRootView.findViewById(1711866787));
    this.mCheckboxs[0] = ((ImageView)this.mRootView.findViewById(1711866806));
    this.mCheckboxs[1] = ((ImageView)this.mRootView.findViewById(1711866818));
    this.mCheckboxs[2] = ((ImageView)this.mRootView.findViewById(1711866849));
    this.mCheckboxs[3] = ((ImageView)this.mRootView.findViewById(1711866854));
    this.mCheckboxs[5] = ((ImageView)this.mRootView.findViewById(1711866859));
    this.mCheckboxs[6] = ((ImageView)this.mRootView.findViewById(1711866866));
    this.mCheckboxs[7] = ((ImageView)this.mRootView.findViewById(1711866872));
    this.mPresenter.initRedGuide();
    this.mIVBlueToothRedGuide = ((ImageView)this.mRootView.findViewById(1711866816));
    this.mCarLogoRedGuide = ((ImageView)this.mRootView.findViewById(1711866822));
    this.mVoiceRedGuide = ((ImageView)this.mRootView.findViewById(1711866729));
    this.mCarLogoArrowView = ((ImageView)this.mRootView.findViewById(1711866824));
    this.mVoiceTV = ((TextView)this.mRootView.findViewById(1711866795));
    this.mVoiceValTips = ((TextView)this.mRootView.findViewById(1711866878));
    initActionOnOff();
    initLicensePlatesLimitView();
  }
  
  public void jumpCarLogoPage()
  {
    if (this.mSubViewListener != null) {
      this.mSubViewListener.onCarLogoAction();
    }
  }
  
  public boolean menuMoreViewCloseAble()
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.mCityShortName != null) && (this.mCityShortName.isShown()))
    {
      setCityShortPanelVisible(8);
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.mIsChecked[0] == 0);
        if (!carPlateNumIsEmpty()) {
          break;
        }
        reverseItemCheck(0);
        this.mPresenter.onSettingsChange(this.mIsChecked, 0);
        bool1 = bool2;
      } while (this.mIsChecked[0] != 0);
      hideInputMethodView();
      return true;
      bool2 = checkPlate();
      bool1 = bool2;
    } while (bool2);
    this.mCarPlateTs.setTextColor(-65536);
    this.mCarPlateTs.setText(JarUtils.getResources().getString(1711670362));
    this.mCarPlateTs.setVisibility(0);
    return bool2;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 3001) {
      if (BNaviModuleManager.hasPermission("android.settings.action.MANAGE_OVERLAY_PERMISSION"))
      {
        reverseItemCheck(7);
        this.mPresenter.onSettingsChange(this.mIsChecked, 7);
      }
    }
    while ((paramInt1 != 3002) || (this.mPresenter == null)) {
      return;
    }
    this.mPresenter.getVoiceName();
  }
  
  public void onBlueToothRedGuide(boolean paramBoolean)
  {
    if ((this.mIVBlueToothRedGuide != null) && (paramBoolean)) {
      this.mIVBlueToothRedGuide.setVisibility(0);
    }
  }
  
  public void onCarLogoRedGuide(boolean paramBoolean)
  {
    if (this.mCarLogoRedGuide == null) {
      return;
    }
    if (paramBoolean)
    {
      this.mCarLogoRedGuide.setVisibility(0);
      return;
    }
    this.mCarLogoRedGuide.setVisibility(8);
  }
  
  public void onCarPlateInputLayoutVisible(int paramInt)
  {
    if ((this.mCarPlateSettingView != null) && (this.mCarPlateTs != null))
    {
      this.mCarPlateSettingView.setVisibility(paramInt);
      this.mCarPlateTs.setVisibility(paramInt);
      if ((paramInt == 8) && (JarUtils.getResources().getString(1711670362).equals(this.mCarPlateTs.getText().toString()))) {
        this.mCarPlateTs.setText("");
      }
    }
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 1711866797: 
    case 1711866798: 
    case 1711866799: 
    case 1711866831: 
    case 1711866832: 
    case 1711866837: 
    case 1711866838: 
    case 1711866839: 
    case 1711866876: 
    case 1711866877: 
      do
      {
        do
        {
          return;
          this.mPresenter.onChangeDetailVoiceModeSetting();
          changeContinewNavi();
          return;
          this.mPresenter.onChangeConciseVoiceModeSetting();
          changeContinewNavi();
          return;
          this.mPresenter.onChangeQuiteVoiceModeSetting();
          changeContinewNavi();
          return;
          this.mPresenter.onChangeAngleFollowModeSetting();
          return;
          this.mPresenter.onChangeAngleTrueNorthModeSetting();
          return;
          this.mPresenter.setNaviDayAndNightMode(1);
          return;
          this.mPresenter.setNaviDayAndNightMode(2);
          return;
          this.mPresenter.setNaviDayAndNightMode(3);
          return;
          this.mPresenter.setPlayTTSMusicMode(0);
        } while (this.mVoiceValTips == null);
        this.mVoiceValTips.setText(JarUtils.getResources().getString(1711670363));
        return;
        this.mPresenter.setPlayTTSMusicMode(1);
      } while (this.mVoiceValTips == null);
      this.mVoiceValTips.setText(JarUtils.getResources().getString(1711670364));
      return;
    case 1711866843: 
      this.mPresenter.setRouteConditionOverView(0);
      changeContinewNavi();
      return;
    }
    this.mPresenter.setRouteConditionOverView(1);
    changeContinewNavi();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      try
      {
        switch (paramView.getId())
        {
        case 1711865893: 
        case 1711865878: 
          if (this.mSubViewListener != null)
          {
            this.mSubViewListener.onMenuMoreAction();
            return;
          }
          break;
        case 1711866833: 
          this.mPresenter.onChangeAngleHUDModeSetting();
          return;
        case 1711866820: 
          this.mPresenter.setCarLogo();
          return;
        case 1711866846: 
          reverseItemCheck(2);
          this.mPresenter.onSettingsChange(this.mIsChecked, 2);
          return;
        case 1711866801: 
          reverseItemCheck(0);
          this.mPresenter.onSettingsChange(this.mIsChecked, 0);
          if (this.mIsChecked[0] == 0)
          {
            hideInputMethodView();
            return;
          }
          if ((this.mCarPlateInput != null) && (this.mCarPlateInput.isShown()))
          {
            showInputMethodView();
            return;
          }
          break;
        case 1711866851: 
          reverseItemCheck(3);
          this.mPresenter.onSettingsChange(this.mIsChecked, 3);
          return;
        case 1711866856: 
          reverseItemCheck(5);
          this.mPresenter.onSettingsChange(this.mIsChecked, 5);
          return;
        case 1711866863: 
          reverseItemCheck(6);
          this.mPresenter.onSettingsChange(this.mIsChecked, 6);
          return;
        case 1711866868: 
          int i = this.mIsChecked[7];
          if (i != 0) {
            this.mPresenter.addUserOP("3.x.1", null, "", null);
          }
          while ((i == 0) && (!BNaviModuleManager.hasPermission("android.settings.action.MANAGE_OVERLAY_PERMISSION")))
          {
            RGViewController.getInstance().showOpenOverlyPermissonDialog();
            return;
            this.mPresenter.addUserOP("3.x.1", "", null, null);
          }
          reverseItemCheck(7);
          this.mPresenter.onSettingsChange(this.mIsChecked, 7);
          return;
        case 1711866814: 
          this.mPresenter.setBlueToothChannelGuide(this.mContext, this.mIsChecked[1]);
          return;
        case 1711866805: 
          hideInputMethodView();
          BNaviModuleManager.openCarPlateExplainPage(this.mContext);
          return;
        case 1711866792: 
          BNSettingManager.setFirstVoiceGuide(true);
          if (this.mVoiceRedGuide != null) {
            this.mVoiceRedGuide.setVisibility(8);
          }
          UserOPController.getInstance().add("3.5.6");
          if (this.mSubViewListener != null)
          {
            this.mSubViewListener.onOtherAction(5, 3, 0, null);
            return;
          }
          break;
        case 1711866812: 
          if ((this.mCarPlate != null) && (this.mCarPlateInput != null))
          {
            this.mCarPlate.setText("");
            this.mCarPlateInput.setText("");
            hidePlate();
            showInput();
            return;
          }
          break;
        case 1711866808: 
          hidePlate();
          showInput();
          String str = this.mCarPlate.getText().toString();
          paramView = "";
          if (!TextUtils.isEmpty(str))
          {
            if (str.length() >= 7)
            {
              paramView = str.substring(0, 1);
              str = str.substring(1, str.length());
              this.mCarPlateInput.setText(str);
              this.mCarPlateInput.setSelection(str.length());
            }
            this.mCarPlateHead.setText(paramView);
            showInputMethodView();
            return;
          }
          break;
        case 1711866810: 
          showDialogCityShotName();
          return;
        case 1711866811: 
          this.mPresenter.addUserOP("b.2");
          return;
        case 1711866879: 
          this.shadowView.setVisibility(8);
          setCityShortPanelVisible(8);
          return;
        case 1711866861: 
          if (checkClick())
          {
            new BNDebugModelDialog(this.mContext).show();
            return;
          }
          break;
        }
      }
      catch (Exception paramView) {}
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      hideInputMethodView();
      return true;
    }
    return false;
  }
  
  public void onResume()
  {
    if (this.mPresenter != null) {
      this.mPresenter.getVoiceName();
    }
  }
  
  public void onSwitchBackground(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.mCityShortName != null) && (this.mCityShortName.isShown())) {
      hideInputMethodView();
    }
  }
  
  public void onVoiceRedGuide(boolean paramBoolean)
  {
    if ((this.mVoiceRedGuide != null) && (paramBoolean)) {
      this.mVoiceRedGuide.setVisibility(0);
    }
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    super.orientationChanged(paramViewGroup, paramInt);
    if (this.isInputMethodShowing)
    {
      this.isInputMethodShowing = false;
      openCarPlatDirectly(true);
    }
  }
  
  public void setInputMethodShowFlag()
  {
    if (isVisibility())
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.mCarPlateInput.getContext().getSystemService("input_method");
      if ((this.mCarPlateInput != null) && (this.mCarPlateInput.isFocused()) && (localInputMethodManager.isActive(this.mCarPlateInput))) {
        this.isInputMethodShowing = true;
      }
    }
  }
  
  public void setNaviDayAndNightMode(int paramInt)
  {
    if (this.dayModeSelector != null)
    {
      if (paramInt == 3) {
        this.dayModeSelector.check(1711866839);
      }
    }
    else {
      return;
    }
    if (paramInt == 2)
    {
      this.dayModeSelector.check(1711866838);
      return;
    }
    this.dayModeSelector.check(1711866837);
  }
  
  public void setVoiceSpeakSetting(int paramInt1, int paramInt2)
  {
    if (this.mSubViewListener != null) {
      this.mSubViewListener.onOtherAction(6, paramInt1, paramInt2, null);
    }
  }
  
  public void show(Bundle paramBundle)
  {
    super.show(paramBundle);
    int i = BNRoutePlaner.getInstance().getCalcPreference();
    RGCarPreferSettingController.getInstance().setLastRPPreferSettingValue(i);
    RGNotificationController.getInstance().hideAllCommonView();
    RGNotificationController.getInstance().hideAllOperableView();
    this.mPresenter.getVoiceName();
    initActionOnOff();
    this.mPresenter.getPlateFromLocal(this.mContext);
    if (paramBundle != null)
    {
      boolean bool = paramBundle.getBoolean("open_car_plate", false);
      LogUtil.e(TAG, "openCarPlate: " + bool);
      if (bool) {
        openCarPlatDirectly(false);
      }
    }
    XDVoiceInstructManager.getInstance().setWakeupEnable(false);
  }
  
  public void showBlueToothChannelGuide(boolean paramBoolean)
  {
    this.mIVBlueToothRedGuide.setVisibility(8);
    if (paramBoolean)
    {
      RGMapModeViewController.getInstance().showBtOscDialog();
      return;
    }
    TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(1711669692));
  }
  
  public void showCarPlate(String paramString)
  {
    mPlateNumTag = paramString;
    this.mCarNum = paramString;
    if (!TextUtils.isEmpty(this.mCarNum))
    {
      showPlate();
      hideInput();
      if (this.mCarNum.length() >= 1)
      {
        this.mCarPlateHead.setText(this.mCarNum.substring(0, 1));
        this.mCarPlateInput.setText(this.mCarNum.substring(1));
      }
      this.mPresenter.updatePreferValue(32, this.mIsChecked[0]);
    }
  }
  
  public void updateBlueToothView(boolean paramBoolean)
  {
    try
    {
      this.mIsChecked[1] = paramBoolean;
      updateCheckDrawable(1);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void updateCheckDrawable(int paramInt)
  {
    try
    {
      if (this.mIsChecked[paramInt] != 0)
      {
        this.mCheckboxs[paramInt].setImageDrawable(JarUtils.getResources().getDrawable(1711408040));
        return;
      }
      this.mCheckboxs[paramInt].setImageDrawable(JarUtils.getResources().getDrawable(1711408041));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void updateDataByLast() {}
  
  public void updateGuideAngleSeletor()
  {
    if (BNSettingManager.getMapMode() == 1)
    {
      getMapMode(0);
      return;
    }
    getMapMode(1);
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    if (getIsTrueCurDay(paramBoolean)) {
      return;
    }
    super.updateStyle(paramBoolean);
    int i = 0;
    View localView;
    while ((this.mRootView != null) && (i < this.hDividerLineView.length))
    {
      localView = this.mRootView.findViewById(this.hDividerLineView[i]);
      if (localView != null) {
        localView.setBackgroundColor(BNStyleManager.getColor(1711800690));
      }
      i += 1;
    }
    i = 0;
    while ((this.mRootView != null) && (i < this.mDividerCategoryView.length))
    {
      localView = this.mRootView.findViewById(this.mDividerCategoryView[i]);
      if (localView != null) {
        localView.setBackgroundColor(BNStyleManager.getColor(1711800692));
      }
      i += 1;
    }
    i = 0;
    while ((this.mRootView != null) && (i < this.mBackgroundView.length))
    {
      localView = this.mRootView.findViewById(this.mBackgroundView[i]);
      if (localView != null) {
        localView.setBackgroundColor(BNStyleManager.getColor(1711800694));
      }
      i += 1;
    }
    if (paramBoolean)
    {
      updateDayModeView();
      return;
    }
    updateNightModeView();
  }
  
  public void updateVoiceName(String paramString)
  {
    if (this.mVoiceTV != null) {
      this.mVoiceTV.setText(paramString);
    }
  }
  
  static class AllCapTransMethod
    extends ReplacementTransformationMethod
  {
    protected char[] getOriginal()
    {
      return new char[] { 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
    }
    
    protected char[] getReplacement()
    {
      return new char[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMMenuMoreView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */