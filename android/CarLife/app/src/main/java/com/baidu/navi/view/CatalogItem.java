package com.baidu.navi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.carlife.R.p;
import com.baidu.navi.style.StyleManager;

public class CatalogItem
  extends LinearLayout
{
  private Context mContext;
  private ImageView mImageView;
  private LayoutInflater mInflater;
  private LinearLayout mLayout;
  private TextView mTextView;
  
  public CatalogItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.mLayout = ((LinearLayout)this.mInflater.inflate(2130968696, null));
    addView(this.mLayout);
    this.mImageView = ((ImageView)this.mLayout.findViewById(2131624629));
    this.mTextView = ((TextView)this.mLayout.findViewById(2131624630));
    initAttributeSet(paramContext, paramAttributeSet);
  }
  
  private void initAttributeSet(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.p.CatalogItem);
    paramAttributeSet = paramContext.getDrawable(0);
    if (paramAttributeSet != null) {
      this.mLayout.setBackgroundDrawable(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(1);
    if (paramAttributeSet != null) {
      this.mImageView.setImageDrawable(paramAttributeSet);
    }
    int i = paramContext.getInteger(3, 0);
    if (i > 0) {
      this.mTextView.setTextSize(i);
    }
    paramAttributeSet = paramContext.peekValue(2);
    if (paramAttributeSet != null)
    {
      if (paramAttributeSet.type != 3) {
        break label158;
      }
      paramAttributeSet = paramContext.getString(2);
      this.mTextView.setText(paramAttributeSet);
    }
    for (;;)
    {
      i = paramContext.getColor(4, StyleManager.getColor(2131558489));
      this.mTextView.setTextColor(i);
      i = (int)paramContext.getDimension(5, -1.0F);
      int j = (int)paramContext.getDimension(6, -2.0F);
      this.mLayout.setLayoutParams(new LinearLayout.LayoutParams(i, j));
      paramContext.recycle();
      return;
      label158:
      if (paramAttributeSet.type == 16)
      {
        i = paramContext.getInteger(2, 0);
        this.mTextView.setText(i);
      }
    }
  }
  
  public LinearLayout getLayout()
  {
    return this.mLayout;
  }
  
  public void setDayNightStyle()
  {
    this.mTextView.setTextColor(StyleManager.getColor(2131558489));
    this.mLayout.setBackgroundDrawable(StyleManager.getDrawable(2130838116));
  }
  
  public void setDayNightStyle(int paramInt)
  {
    this.mTextView.setTextColor(StyleManager.getColor(2131558489));
    this.mImageView.setImageDrawable(StyleManager.getDrawable(paramInt));
    this.mLayout.setBackgroundDrawable(StyleManager.getDrawable(2130838116));
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mLayout.setOnClickListener(paramOnClickListener);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/CatalogItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */