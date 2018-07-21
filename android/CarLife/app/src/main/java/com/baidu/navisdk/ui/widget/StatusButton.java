package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;

public class StatusButton
  extends LinearLayout
{
  private onStatusButtonClickListener allListener;
  private RadioButton btn1;
  private RadioButton btn2;
  private RadioButton btn3;
  private RadioGroup btnGroup;
  private View.OnClickListener cl1;
  private View.OnClickListener cl2;
  private View.OnClickListener cl3;
  private boolean isMapMode = true;
  private Context mContext;
  private int setBtnFlag;
  
  public StatusButton(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    initView();
  }
  
  public StatusButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    initView();
  }
  
  private ColorStateList createColorStateList(int paramInt1, int paramInt2, int paramInt3)
  {
    return new ColorStateList(new int[][] { { 16842919 }, { 16842912 }, new int[0] }, new int[] { paramInt2, paramInt3, paramInt1 });
  }
  
  private void initView()
  {
    this.isMapMode = BNSettingManager.isUsingMapMode();
    if (this.isMapMode) {
      JarUtils.inflate((Activity)this.mContext, 1711472750, this);
    }
    for (;;)
    {
      this.btnGroup = ((RadioGroup)findViewById(1711867049));
      this.btn1 = ((RadioButton)this.btnGroup.getChildAt(0));
      this.btn2 = ((RadioButton)this.btnGroup.getChildAt(1));
      this.btn3 = ((RadioButton)this.btnGroup.getChildAt(2));
      if (!BNStyleManager.getDayStyle()) {
        updateDayStyle();
      }
      this.btnGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
      {
        public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
        {
          if ((paramAnonymousInt == StatusButton.this.btn1.getId()) && (StatusButton.this.setBtnFlag != 1))
          {
            StatusButton.access$102(StatusButton.this, 1);
            if (StatusButton.this.allListener == null) {
              break label211;
            }
            switch (StatusButton.this.setBtnFlag)
            {
            }
          }
          label211:
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if ((paramAnonymousInt == StatusButton.this.btn2.getId()) && (StatusButton.this.setBtnFlag != 2))
                  {
                    StatusButton.access$102(StatusButton.this, 2);
                    break;
                  }
                } while ((paramAnonymousInt != StatusButton.this.btn3.getId()) || (StatusButton.this.setBtnFlag == 3));
                StatusButton.access$102(StatusButton.this, 3);
                break;
                StatusButton.this.allListener.onClick(StatusButton.this, StatusButton.StatusButtonChild.LEFT);
                return;
                StatusButton.this.allListener.onClick(StatusButton.this, StatusButton.StatusButtonChild.MID);
                return;
                StatusButton.this.allListener.onClick(StatusButton.this, StatusButton.StatusButtonChild.RIGHT);
                return;
                switch (StatusButton.this.setBtnFlag)
                {
                default: 
                  return;
                }
              } while (StatusButton.this.cl1 == null);
              StatusButton.this.cl1.onClick(StatusButton.this.btn1);
              return;
            } while (StatusButton.this.cl2 == null);
            StatusButton.this.cl2.onClick(StatusButton.this.btn2);
            return;
          } while (StatusButton.this.cl3 == null);
          StatusButton.this.cl3.onClick(StatusButton.this.btn3);
        }
      });
      return;
      JarUtils.inflate((Activity)this.mContext, 1711472751, this);
    }
  }
  
  public StatusButton setAllBtnClickListener(onStatusButtonClickListener paramonStatusButtonClickListener)
  {
    this.allListener = paramonStatusButtonClickListener;
    return this;
  }
  
  public StatusButton setAllButtonText(int paramInt1, int paramInt2)
  {
    this.btn1.setText(paramInt1);
    this.btn2.setVisibility(8);
    this.btn3.setText(paramInt2);
    return this;
  }
  
  public StatusButton setAllButtonText(int paramInt1, int paramInt2, int paramInt3)
  {
    this.btn1.setText(paramInt1);
    this.btn2.setText(paramInt2);
    this.btn3.setText(paramInt3);
    return this;
  }
  
  public StatusButton setAllButtonText(String paramString1, String paramString2)
  {
    this.btn1.setText(paramString1);
    this.btn2.setVisibility(8);
    this.btn3.setText(paramString2);
    return this;
  }
  
  public StatusButton setAllButtonText(String paramString1, String paramString2, String paramString3)
  {
    this.btn1.setText(paramString1);
    this.btn2.setText(paramString2);
    this.btn3.setText(paramString3);
    return this;
  }
  
  public StatusButton setLeftBtnChecked()
  {
    this.btn1.setChecked(true);
    this.setBtnFlag = 1;
    return this;
  }
  
  public StatusButton setLeftBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.cl1 = paramOnClickListener;
    return this;
  }
  
  public StatusButton setLeftButtonText(int paramInt)
  {
    this.btn1.setText(paramInt);
    return this;
  }
  
  public StatusButton setLeftButtonText(String paramString)
  {
    this.btn1.setText(paramString);
    return this;
  }
  
  public StatusButton setMidBtnChecked()
  {
    this.btn2.setChecked(true);
    this.setBtnFlag = 2;
    return this;
  }
  
  public StatusButton setMidBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.cl2 = paramOnClickListener;
    return this;
  }
  
  public StatusButton setMidBtnGone(boolean paramBoolean)
  {
    this.btn2.setVisibility(8);
    return this;
  }
  
  public StatusButton setMidButtonText(int paramInt)
  {
    this.btn2.setText(paramInt);
    return this;
  }
  
  public StatusButton setMidButtonText(String paramString)
  {
    this.btn2.setText(paramString);
    return this;
  }
  
  public StatusButton setRightBtnChecked()
  {
    this.btn3.setChecked(true);
    this.setBtnFlag = 3;
    return this;
  }
  
  public StatusButton setRightBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.cl3 = paramOnClickListener;
    return this;
  }
  
  public StatusButton setRightButtonText(int paramInt)
  {
    this.btn3.setText(paramInt);
    return this;
  }
  
  public StatusButton setRightButtonText(String paramString)
  {
    this.btn3.setText(paramString);
    return this;
  }
  
  public void updateDayStyle()
  {
    if (this.isMapMode)
    {
      ColorStateList localColorStateList = createColorStateList(BNStyleManager.getColor(1711800445), BNStyleManager.getColor(1711800444), BNStyleManager.getColor(1711800444));
      this.btn1.setTextColor(localColorStateList);
      localColorStateList = createColorStateList(BNStyleManager.getColor(1711800445), BNStyleManager.getColor(1711800444), BNStyleManager.getColor(1711800444));
      this.btn2.setTextColor(localColorStateList);
      localColorStateList = createColorStateList(BNStyleManager.getColor(1711800445), BNStyleManager.getColor(1711800444), BNStyleManager.getColor(1711800444));
      this.btn3.setTextColor(localColorStateList);
      if (Build.VERSION.SDK_INT > 15)
      {
        this.btn1.setBackground(BNStyleManager.getDrawable(1711407854));
        this.btn2.setBackground(BNStyleManager.getDrawable(1711407857));
        this.btn3.setBackground(BNStyleManager.getDrawable(1711407860));
      }
    }
    else
    {
      return;
    }
    this.btn1.setBackgroundDrawable(BNStyleManager.getDrawable(1711407854));
    this.btn2.setBackgroundDrawable(BNStyleManager.getDrawable(1711407857));
    this.btn3.setBackgroundDrawable(BNStyleManager.getDrawable(1711407860));
  }
  
  public static enum StatusButtonChild
  {
    LEFT,  MID,  RIGHT;
    
    private StatusButtonChild() {}
  }
  
  public static abstract interface onStatusButtonClickListener
  {
    public abstract void onClick(StatusButton paramStatusButton, StatusButton.StatusButtonChild paramStatusButtonChild);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/StatusButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */