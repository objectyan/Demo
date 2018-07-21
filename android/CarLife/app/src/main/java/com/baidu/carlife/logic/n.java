package com.baidu.carlife.logic;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class n
  extends ClickableSpan
{
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */