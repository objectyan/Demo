package com.baidu.navi.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.carlife.view.KeyboardEditText;
import com.baidu.carlife.view.a;
import com.baidu.carlife.view.a.a;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.utils.StringUtils;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.util.common.ScreenUtil;

public class CarPlateFragment
  extends ContentFragment
  implements View.OnClickListener
{
  private View.OnClickListener clickListener;
  private KeyboardEditText edtCarPlateNum;
  private ImageView imgBackBtn;
  private LayoutInflater inflater;
  private final String[][] mCityShotNames;
  private LinearLayout mColumnsLinear;
  private ViewGroup mViewGroup;
  private String oldCarPlate;
  private TextView tvCnCarPlate;
  private TextView tvCompleteBtn;
  
  public CarPlateFragment()
  {
    String[] arrayOfString = { "豫", "贵", "青", "琼", "辽", "吉", "藏", "闽" };
    this.mCityShotNames = new String[][] { { "京", "沪", "鄂", "湘", "川", "渝", "粤", "鲁", "津", "浙" }, arrayOfString, { "冀", "苏", "皖", "赣", "甘", "陕", "新" }, { "黑", "宁", "云", "蒙", "晋", "桂" } };
    this.clickListener = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarPlateFragment.this.tvCnCarPlate.setText(((TextView)paramAnonymousView).getText());
      }
    };
  }
  
  private void createLinear(String[] paramArrayOfString, int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    Object localObject = new LinearLayout.LayoutParams(-1, -2, 1.0F);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(17);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localObject = this.inflater.inflate(2130968845, null, false);
      TextView localTextView = (TextView)((View)localObject).findViewById(2131624630);
      localTextView.setText(paramArrayOfString[i]);
      localTextView.setTextColor(Color.parseColor("#FFFFFFFF"));
      localTextView.setTextSize(18.0F);
      localTextView.setOnClickListener(this.clickListener);
      ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(ScreenUtil.getInstance().getHeightPixels() / paramInt, -2));
      localTextView.setGravity(17);
      localLinearLayout.addView((View)localObject);
      i += 1;
    }
    this.mColumnsLinear.addView(localLinearLayout);
  }
  
  private void dismissPop()
  {
    if (this.mColumnsLinear != null) {
      this.mColumnsLinear.setVisibility(8);
    }
  }
  
  private void displayColumns()
  {
    if (this.mColumnsLinear != null)
    {
      this.mColumnsLinear.removeAllViews();
      this.mColumnsLinear.setVisibility(0);
    }
    int i = 0;
    while (i < this.mCityShotNames.length)
    {
      createLinear(this.mCityShotNames[i], 10);
      i += 1;
    }
  }
  
  @NonNull
  private TextWatcher getTextChangedListener()
  {
    new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if ((paramAnonymousCharSequence.length() > 0) && (paramAnonymousInt3 - paramAnonymousInt2 > 0))
        {
          CarPlateFragment.this.edtCarPlateNum.setText(paramAnonymousCharSequence.toString().toUpperCase());
          CarPlateFragment.this.edtCarPlateNum.setSelection(paramAnonymousCharSequence.length());
        }
      }
    };
  }
  
  private boolean hideInputMethodView()
  {
    if (this.edtCarPlateNum == null) {}
    InputMethodManager localInputMethodManager;
    do
    {
      return false;
      localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    } while ((localInputMethodManager == null) || (!localInputMethodManager.isActive()));
    localInputMethodManager.hideSoftInputFromWindow(this.edtCarPlateNum.getWindowToken(), 0);
    if (this.edtCarPlateNum.hasFocus()) {
      this.edtCarPlateNum.clearFocus();
    }
    return true;
  }
  
  private void initData()
  {
    this.oldCarPlate = BNSettingManager.getPlateFromLocal(getNaviActivity());
    if (!TextUtils.isEmpty(this.oldCarPlate))
    {
      this.tvCnCarPlate.setText(this.oldCarPlate.trim().substring(0, 1));
      this.edtCarPlateNum.setText(this.oldCarPlate.trim().substring(1, this.oldCarPlate.length()));
    }
  }
  
  private void initListener()
  {
    this.imgBackBtn.setOnClickListener(this);
    this.tvCompleteBtn.setOnClickListener(this);
    this.tvCnCarPlate.setOnClickListener(this);
    this.edtCarPlateNum.addTextChangedListener(getTextChangedListener());
    KeyboardEditText localKeyboardEditText = this.edtCarPlateNum;
    a locala = a.a();
    locala.getClass();
    localKeyboardEditText.setOnTouchListener(new a.a(locala, this.edtCarPlateNum, 0, null, null));
    this.edtCarPlateNum.setOnClickListener(this);
    a.a().a(this.edtCarPlateNum);
  }
  
  private void initView()
  {
    this.imgBackBtn = ((ImageView)this.mViewGroup.findViewById(2131624186));
    this.tvCompleteBtn = ((TextView)this.mViewGroup.findViewById(2131624736));
    this.tvCnCarPlate = ((TextView)this.mViewGroup.findViewById(2131624734));
    this.edtCarPlateNum = ((KeyboardEditText)this.mViewGroup.findViewById(2131624737));
    this.mColumnsLinear = ((LinearLayout)this.mViewGroup.findViewById(2131624738));
  }
  
  private boolean isCanCommit()
  {
    boolean bool2 = false;
    String str = this.edtCarPlateNum.getText().toString();
    boolean bool1;
    if (TextUtils.isEmpty(str))
    {
      BNSettingManager.getPlateFromLocal(getNaviActivity());
      BNRoutePlaner.getInstance().setCalcPrefCarNo("");
      RGCarPreferSettingController.getInstance().updatePreferValue(32, false);
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (str.length() <= 5);
        str = this.tvCnCarPlate.getText().toString().trim() + str;
        bool1 = bool2;
      } while (!StringUtils.isCarPlate(str));
      BNSettingManager.setCarPlateToLocal(getNaviActivity(), str);
      BNRoutePlaner.getInstance().setCalcPrefCarNo(str);
      RGCarPreferSettingController.getInstance().updatePreferValue(32, true);
      bool1 = true;
    } while (str.equals(this.oldCarPlate));
    StatisticManager.onEvent("NAVI_0034", "NAVI_0034");
    return true;
  }
  
  private void showKeyBoardPop()
  {
    displayColumns();
    hideInputMethodView();
  }
  
  public boolean onBackPressed()
  {
    dismissPop();
    hideInputMethodView();
    back();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131624734) {
      dismissPop();
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131624186: 
      onBackPressed();
      return;
    case 2131624734: 
      showKeyBoardPop();
      return;
    }
    hideInputMethodView();
    if (isCanCommit())
    {
      onBackPressed();
      return;
    }
    Toast.makeText(getContext(), 2131296848, 0).show();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.inflater = paramLayoutInflater;
    this.mViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2130968741, null));
    initView();
    initData();
    initListener();
    return this.mViewGroup;
  }
  
  protected void onInitView() {}
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/CarPlateFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */