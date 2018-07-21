package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BNMessageDialog
  extends BNBaseDialog
{
  private EditText mEditText;
  private View.OnFocusChangeListener mOnFocusChangeListener = new View.OnFocusChangeListener()
  {
    public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      if (!paramAnonymousBoolean)
      {
        paramAnonymousView = (EditText)paramAnonymousView;
        ((InputMethodManager)BNaviModuleManager.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
      }
    }
  };
  private TextView mTextView;
  
  public BNMessageDialog(Activity paramActivity)
  {
    super(paramActivity);
    paramActivity = JarUtils.inflate(paramActivity, 1711472684, null);
    if (paramActivity != null)
    {
      this.mTextView = ((TextView)paramActivity.findViewById(1711865859));
      this.mEditText = ((EditText)paramActivity.findViewById(1711866230));
      this.mEditText.setOnFocusChangeListener(this.mOnFocusChangeListener);
      setContent(paramActivity);
    }
  }
  
  private String strFilter(String paramString1, String paramString2)
  {
    return Pattern.compile(paramString2).matcher(paramString1).replaceAll("").trim();
  }
  
  public BNMessageDialog enableBackKey(boolean paramBoolean)
  {
    super.enableBackKey(paramBoolean);
    return this;
  }
  
  public String getEditTextMessage()
  {
    return this.mEditText.getText().toString();
  }
  
  public BNMessageDialog setContent(View paramView)
  {
    super.setContent(paramView);
    return this;
  }
  
  public BNMessageDialog setContentHeight(int paramInt)
  {
    super.setContentHeight(paramInt);
    return this;
  }
  
  public BNMessageDialog setContentWidth(int paramInt)
  {
    super.setContentWidth(paramInt);
    return this;
  }
  
  public void setEditTextFocus(boolean paramBoolean)
  {
    this.mEditText.setFocusable(paramBoolean);
  }
  
  public BNMessageDialog setEditTextMessage(String paramString)
  {
    this.mTextView.setVisibility(8);
    this.mEditText.setVisibility(0);
    this.mEditText.setText(paramString, TextView.BufferType.SPANNABLE);
    return this;
  }
  
  public BNMessageDialog setEditTextMessageHeight(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.mEditText.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.mEditText.setLayoutParams(localLayoutParams);
    return this;
  }
  
  public BNMessageDialog setEditTextMessageWidth(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.mEditText.getLayoutParams();
    localLayoutParams.width = paramInt;
    this.mEditText.setLayoutParams(localLayoutParams);
    return this;
  }
  
  public BNMessageDialog setFilter(InputFilter[] paramArrayOfInputFilter)
  {
    this.mEditText.setFilters(paramArrayOfInputFilter);
    return this;
  }
  
  public BNMessageDialog setFirstBtnEnabled(boolean paramBoolean)
  {
    super.setFirstBtnEnabled(paramBoolean);
    return this;
  }
  
  public BNMessageDialog setFirstBtnText(String paramString)
  {
    super.setFirstBtnText(paramString);
    return this;
  }
  
  public BNMessageDialog setLastSelection()
  {
    int i = getEditTextMessage().length();
    this.mEditText.setSelection(i);
    return this;
  }
  
  public BNMessageDialog setMessage(String paramString)
  {
    if (this.mTextView != null)
    {
      this.mTextView.setVisibility(0);
      this.mTextView.setText(paramString, TextView.BufferType.SPANNABLE);
    }
    if (this.mEditText != null) {
      this.mEditText.setVisibility(8);
    }
    return this;
  }
  
  public BNMessageDialog setMessageHeight(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.mTextView.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.mTextView.setLayoutParams(localLayoutParams);
    return this;
  }
  
  public BNMessageDialog setMessageWidth(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.mTextView.getLayoutParams();
    localLayoutParams.width = paramInt;
    this.mTextView.setLayoutParams(localLayoutParams);
    return this;
  }
  
  public BNMessageDialog setOnFirstBtnClickListener(BNBaseDialog.OnNaviClickListener paramOnNaviClickListener)
  {
    super.setOnFirstBtnClickListener(paramOnNaviClickListener);
    return this;
  }
  
  public BNMessageDialog setOnSecondBtnClickListener(BNBaseDialog.OnNaviClickListener paramOnNaviClickListener)
  {
    super.setOnSecondBtnClickListener(paramOnNaviClickListener);
    return this;
  }
  
  public BNMessageDialog setSecondBtnEnabled(boolean paramBoolean)
  {
    super.setSecondBtnEnabled(paramBoolean);
    return this;
  }
  
  public BNMessageDialog setSecondBtnText(String paramString)
  {
    super.setSecondBtnText(paramString);
    return this;
  }
  
  public BNMessageDialog setStringFilter(final String paramString)
  {
    this.mEditText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousCharSequence = BNMessageDialog.this.mEditText.getText().toString();
        String str = BNMessageDialog.this.strFilter(paramAnonymousCharSequence, paramString);
        if (!paramAnonymousCharSequence.equals(str))
        {
          BNMessageDialog.this.mEditText.setText(str);
          BNMessageDialog.this.mEditText.setSelection(str.length());
        }
      }
    });
    return this;
  }
  
  public BNMessageDialog setTitleText(String paramString)
  {
    super.setTitleText(paramString);
    return this;
  }
  
  public void show()
  {
    if (this.isSupportDayNight)
    {
      this.mTextView.setTextColor(BNStyleManager.getColor(1711800402));
      this.mEditText.setTextColor(BNStyleManager.getColor(1711800402));
    }
    super.show();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNMessageDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */