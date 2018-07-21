package com.baidu.carlife.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class KeyboardEditText
  extends EditText
{
  private a.c a;
  private String b;
  
  public KeyboardEditText(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public KeyboardEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public KeyboardEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public String getFinishText()
  {
    return this.b;
  }
  
  public a.c getOnClickFinishListener()
  {
    return this.a;
  }
  
  public void setFinishText(String paramString)
  {
    this.b = paramString;
  }
  
  public void setOnClickFinishListener(a.c paramc)
  {
    this.a = paramc;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/KeyboardEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */