package com.baidu.che.codriver.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CompoundImageView
  extends ImageView
{
  private boolean a;
  
  public CompoundImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CompoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (a()) {
      mergeDrawableStates(arrayOfInt, new int[] { 16842912 });
    }
    return arrayOfInt;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (a() == paramBoolean) {
      return;
    }
    this.a = paramBoolean;
    refreshDrawableState();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/widget/CompoundImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */