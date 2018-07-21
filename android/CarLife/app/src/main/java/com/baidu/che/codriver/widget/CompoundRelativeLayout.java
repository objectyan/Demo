package com.baidu.che.codriver.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class CompoundRelativeLayout
  extends RelativeLayout
{
  private boolean a;
  
  public CompoundRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public CompoundRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (a()) {
      mergeDrawableStates(arrayOfInt, new int[] { 16842912 });
    }
    return arrayOfInt;
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.a == paramBoolean) {
      return;
    }
    this.a = paramBoolean;
    refreshDrawableState();
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/widget/CompoundRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */