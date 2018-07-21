package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.R.styleable;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNCommonTitleBar
  extends FrameLayout
{
  protected static final int DEFAULT_TITLE_HEIGHT = 60;
  protected static final int DEFAULT_TITLE_TEXT_COLOR = 16777215;
  protected static final int DEFAULT_TITLE_TEXT_SIZE = 20;
  protected static final int MIDDLE_TITLE_TEXT_SIZE = 12;
  private boolean hasSetLeftContentFromOutSide;
  private boolean hasSetMiddleContentFromOutSide;
  private boolean hasSetRightContentFromOutSide;
  private boolean isMapMode = true;
  protected FrameLayout mLayout;
  protected Button mLeftButton;
  protected FrameLayout mLeftContent;
  protected ImageView mLeftImageView;
  private View.OnClickListener mLeftListener;
  protected FrameLayout mMiddleContent;
  private View.OnClickListener mMiddleListern;
  protected TextView mMiddleTextView;
  protected RelativeLayout mReLayout;
  protected Button mRightButton;
  protected FrameLayout mRightContent;
  protected ImageView mRightImageView;
  private View.OnClickListener mRightListner;
  protected View mTitleBarDivideLine;
  
  public BNCommonTitleBar(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public BNCommonTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
    initAttr(paramContext, paramAttributeSet);
  }
  
  public View getLeftContent()
  {
    return this.mLeftImageView;
  }
  
  public View getMiddleContent()
  {
    return this.mMiddleContent;
  }
  
  public View getRightContent()
  {
    return this.mRightContent;
  }
  
  protected void initAttr(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CommonTitleBar);
    paramAttributeSet = paramContext.getDrawable(0);
    if (paramAttributeSet != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.mReLayout.setBackground(paramAttributeSet);
      }
    }
    else
    {
      boolean bool = true;
      if (paramContext.peekValue(6) != null) {
        bool = paramContext.getBoolean(6, true);
      }
      if (!bool) {
        break label220;
      }
      this.mRightContent.setVisibility(0);
      label71:
      paramAttributeSet = paramContext.getString(5);
      this.mMiddleTextView.setText(paramAttributeSet);
      paramAttributeSet = paramContext.getDrawable(1);
      if (paramAttributeSet == null) {
        break label231;
      }
      this.mRightImageView.setImageDrawable(paramAttributeSet);
      this.mRightImageView.setVisibility(0);
      label111:
      paramAttributeSet = paramContext.getString(2);
      if (TextUtils.isEmpty(paramAttributeSet)) {
        break label243;
      }
      this.mRightButton.setText(paramAttributeSet);
      this.mRightButton.setVisibility(0);
      label140:
      paramAttributeSet = paramContext.getDrawable(4);
      if (paramAttributeSet != null)
      {
        this.mLeftImageView.setImageDrawable(paramAttributeSet);
        this.mLeftImageView.setVisibility(0);
      }
      paramAttributeSet = paramContext.getString(3);
      if (TextUtils.isEmpty(paramAttributeSet)) {
        break label276;
      }
      this.mLeftButton.setText(paramAttributeSet);
      this.mLeftButton.setVisibility(0);
      this.mLeftImageView.setVisibility(8);
    }
    for (;;)
    {
      paramContext.recycle();
      return;
      this.mReLayout.setBackgroundDrawable(paramAttributeSet);
      break;
      label220:
      this.mRightContent.setVisibility(4);
      break label71;
      label231:
      this.mRightImageView.setVisibility(8);
      break label111;
      label243:
      if (this.mRightImageView.getVisibility() == 0)
      {
        this.mRightButton.setVisibility(8);
        break label140;
      }
      this.mRightButton.setVisibility(4);
      break label140;
      label276:
      this.mLeftButton.setVisibility(8);
    }
  }
  
  protected void initView(Context paramContext)
  {
    Resources localResources;
    if (this.isMapMode)
    {
      this.mLayout = ((FrameLayout)JarUtils.inflate((Activity)paramContext, 1711472655, this));
      this.mReLayout = ((RelativeLayout)this.mLayout.findViewById(1711865885));
      this.mLeftImageView = ((ImageView)this.mLayout.findViewById(1711865878));
      this.mLeftButton = ((Button)this.mLayout.findViewById(1711865887));
      this.mRightImageView = ((ImageView)this.mLayout.findViewById(1711865879));
      this.mRightButton = ((Button)this.mLayout.findViewById(1711865889));
      this.mMiddleContent = ((FrameLayout)this.mLayout.findViewById(1711865890));
      this.mRightContent = ((FrameLayout)this.mLayout.findViewById(1711865888));
      this.mLeftContent = ((FrameLayout)this.mLayout.findViewById(1711865886));
      this.mTitleBarDivideLine = this.mLayout.findViewById(1711865891);
      this.mLeftButton.setVisibility(8);
      this.mMiddleTextView = ((TextView)this.mLayout.findViewById(1711865880));
      paramContext = this.mMiddleTextView;
      localResources = JarUtils.getResources();
      if (!this.isMapMode) {
        break label239;
      }
    }
    label239:
    for (int i = 1711800538;; i = 1711800654)
    {
      paramContext.setTextColor(localResources.getColor(i));
      return;
      this.mLayout = ((FrameLayout)JarUtils.inflate((Activity)paramContext, 1711472654, this));
      break;
    }
  }
  
  public void setLeftContenVisible(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = this.mLeftContent;
    if (paramBoolean == true) {}
    for (int i = 0;; i = 4)
    {
      localFrameLayout.setVisibility(i);
      return;
    }
  }
  
  public void setLeftContent(View paramView)
  {
    if (this.mLeftContent != null)
    {
      this.mLeftContent.removeAllViews();
      this.mLeftContent.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
      this.mLeftContent.setOnClickListener(this.mLeftListener);
      this.mLeftContent.setClickable(true);
    }
    this.hasSetRightContentFromOutSide = true;
  }
  
  public void setLeftContentBackgroud(Drawable paramDrawable)
  {
    this.mLeftContent.setBackgroundDrawable(paramDrawable);
  }
  
  public void setLeftContentClickable(boolean paramBoolean)
  {
    this.mLeftContent.setClickable(paramBoolean);
  }
  
  public void setLeftEnabled(boolean paramBoolean)
  {
    if (this.mLeftButton != null) {
      this.mLeftButton.setEnabled(paramBoolean);
    }
    if (this.mLeftImageView != null) {
      this.mLeftImageView.setEnabled(paramBoolean);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    if (this.mLeftImageView != null)
    {
      this.mLeftImageView.setImageDrawable(paramDrawable);
      this.mLeftImageView.setVisibility(0);
    }
    if (this.mLeftButton != null) {
      this.mLeftButton.setVisibility(4);
    }
  }
  
  public void setLeftIconAlpha(float paramFloat)
  {
    if (this.mLeftImageView != null) {}
    try
    {
      this.mLeftImageView.setAlpha(paramFloat);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setLeftIconBackGround(Drawable paramDrawable)
  {
    if (this.mLeftImageView != null)
    {
      this.mLeftImageView.setBackgroundDrawable(paramDrawable);
      this.mLeftImageView.setVisibility(0);
    }
    if (this.mLeftButton != null) {
      this.mLeftButton.setVisibility(8);
    }
  }
  
  public void setLeftIconVisible(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.mLeftImageView != null)
    {
      localImageView = this.mLeftImageView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setLeftImageViewSrc(Drawable paramDrawable)
  {
    if (this.mLeftImageView != null) {
      this.mLeftImageView.setImageDrawable(paramDrawable);
    }
  }
  
  public void setLeftOnClickedListener(View.OnClickListener paramOnClickListener)
  {
    this.mLeftListener = paramOnClickListener;
    if (this.hasSetLeftContentFromOutSide)
    {
      this.mLeftContent.setClickable(true);
      this.mLeftContent.setOnClickListener(paramOnClickListener);
    }
    do
    {
      return;
      this.mLeftContent.setClickable(false);
      if (this.mLeftImageView != null) {
        this.mLeftImageView.setOnClickListener(paramOnClickListener);
      }
    } while (this.mLeftButton == null);
    this.mLeftButton.setOnClickListener(paramOnClickListener);
  }
  
  public void setLeftText(int paramInt)
  {
    setLeftText(BNStyleManager.getString(paramInt));
  }
  
  public void setLeftText(String paramString)
  {
    int i = ScreenUtil.getInstance().dip2px(8);
    if (this.mLeftButton != null)
    {
      this.mLeftButton.setText(paramString);
      this.mLeftButton.setPadding(i, 0, i, 0);
      this.mLeftButton.setVisibility(0);
      this.mLeftContent.setVisibility(0);
    }
    if (this.mLeftImageView != null) {
      this.mLeftImageView.setVisibility(8);
    }
  }
  
  public void setLeftTextBackground(Drawable paramDrawable)
  {
    if (this.mLeftButton != null)
    {
      this.mLeftButton.setBackgroundDrawable(paramDrawable);
      this.mLeftButton.setVisibility(0);
    }
    if (this.mLeftImageView != null) {
      this.mLeftImageView.setVisibility(8);
    }
  }
  
  public void setLeftTextColor(int paramInt)
  {
    if (this.mLeftButton != null)
    {
      this.mLeftButton.setTextColor(paramInt);
      this.mLeftButton.setVisibility(0);
    }
    if (this.mLeftImageView != null) {
      this.mLeftImageView.setVisibility(4);
    }
  }
  
  public void setLeftTextVisible(boolean paramBoolean)
  {
    Button localButton;
    if (this.mLeftButton != null)
    {
      localButton = this.mLeftButton;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localButton.setVisibility(i);
      return;
    }
  }
  
  public void setMiddleContenVisible(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = this.mMiddleContent;
    if (paramBoolean == true) {}
    for (int i = 0;; i = 4)
    {
      localFrameLayout.setVisibility(i);
      return;
    }
  }
  
  public void setMiddleContent(View paramView)
  {
    if (this.mMiddleContent != null)
    {
      this.mMiddleContent.removeAllViews();
      this.mMiddleContent.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    }
    this.hasSetMiddleContentFromOutSide = true;
    if (this.mMiddleTextView != null) {
      this.mMiddleTextView.setVisibility(4);
    }
  }
  
  public void setMiddleContentBackgroud(Drawable paramDrawable)
  {
    this.mMiddleContent.setBackgroundDrawable(paramDrawable);
  }
  
  public void setMiddleContentClickable(boolean paramBoolean)
  {
    this.mMiddleContent.setClickable(paramBoolean);
  }
  
  public void setMiddleOnClickedListener(View.OnClickListener paramOnClickListener)
  {
    this.mMiddleContent.setOnClickListener(paramOnClickListener);
    this.mMiddleContent.setClickable(true);
  }
  
  public void setMiddleText(int paramInt)
  {
    if (this.mMiddleTextView != null) {
      this.mMiddleTextView.setText(paramInt);
    }
  }
  
  public void setMiddleText(CharSequence paramCharSequence)
  {
    if (this.mMiddleTextView != null) {
      this.mMiddleTextView.setText(paramCharSequence);
    }
  }
  
  public void setMiddleTextColor(int paramInt)
  {
    if (this.mMiddleTextView != null) {
      this.mMiddleTextView.setTextColor(paramInt);
    }
  }
  
  public void setMiddleTextSize(float paramFloat)
  {
    if (this.mMiddleTextView != null) {
      this.mMiddleTextView.setTextSize(paramFloat);
    }
  }
  
  public void setMiddleTextVisible(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.mMiddleTextView != null)
    {
      localTextView = this.mMiddleTextView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void setRightContenVisible(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = this.mRightContent;
    if (paramBoolean == true) {}
    for (int i = 0;; i = 4)
    {
      localFrameLayout.setVisibility(i);
      return;
    }
  }
  
  public void setRightContent(View paramView)
  {
    if (this.mRightContent != null)
    {
      this.mRightContent.removeAllViews();
      this.mRightContent.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
      this.mRightContent.setOnClickListener(this.mRightListner);
      this.mRightContent.setClickable(true);
    }
    this.hasSetRightContentFromOutSide = true;
  }
  
  public void setRightContentBackgroud(Drawable paramDrawable)
  {
    this.mRightContent.setBackgroundDrawable(paramDrawable);
  }
  
  public void setRightContentClickable(boolean paramBoolean)
  {
    this.mRightContent.setClickable(paramBoolean);
  }
  
  public void setRightEnabled(boolean paramBoolean)
  {
    if (this.mRightButton != null) {
      this.mRightButton.setEnabled(paramBoolean);
    }
    if (this.mRightImageView != null) {
      this.mRightImageView.setEnabled(paramBoolean);
    }
  }
  
  public void setRightIcon(Drawable paramDrawable)
  {
    if (this.mRightImageView != null)
    {
      this.mRightImageView.setImageDrawable(paramDrawable);
      this.mRightImageView.setVisibility(0);
    }
    if (this.mRightButton != null) {
      this.mRightButton.setVisibility(4);
    }
  }
  
  public void setRightIconBackGround(Drawable paramDrawable)
  {
    if (this.mRightImageView != null)
    {
      this.mRightImageView.setBackgroundDrawable(paramDrawable);
      this.mRightImageView.setVisibility(0);
    }
    if (this.mRightButton != null) {
      this.mRightButton.setVisibility(4);
    }
  }
  
  public void setRightIconVisible(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.mRightImageView != null)
    {
      localImageView = this.mRightImageView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setRightOnClickedListener(View.OnClickListener paramOnClickListener)
  {
    this.mRightListner = paramOnClickListener;
    if (this.hasSetRightContentFromOutSide)
    {
      this.mRightContent.setClickable(true);
      this.mRightContent.setOnClickListener(paramOnClickListener);
    }
    do
    {
      return;
      this.mRightContent.setClickable(false);
      if (this.mRightImageView != null) {
        this.mRightImageView.setOnClickListener(paramOnClickListener);
      }
    } while (this.mRightButton == null);
    this.mRightButton.setOnClickListener(paramOnClickListener);
  }
  
  public void setRightText(int paramInt)
  {
    setRightText(BNStyleManager.getString(paramInt));
  }
  
  public void setRightText(String paramString)
  {
    if (this.mRightButton != null)
    {
      this.mRightButton.setText(paramString);
      this.mRightButton.setVisibility(0);
    }
    if (this.mRightImageView != null) {
      this.mRightImageView.setVisibility(4);
    }
  }
  
  public void setRightTextBackground(Drawable paramDrawable)
  {
    if (this.mRightButton != null)
    {
      this.mRightButton.setBackgroundDrawable(paramDrawable);
      this.mRightButton.setVisibility(0);
    }
    if (this.mRightImageView != null) {
      this.mRightImageView.setVisibility(4);
    }
  }
  
  public void setRightTextColor(int paramInt)
  {
    if (this.mRightButton != null)
    {
      this.mRightButton.setTextColor(paramInt);
      this.mRightButton.setVisibility(0);
    }
    if (this.mRightImageView != null) {
      this.mRightImageView.setVisibility(4);
    }
  }
  
  public void setRightTextVisible(boolean paramBoolean)
  {
    Button localButton;
    if (this.mRightButton != null)
    {
      localButton = this.mRightButton;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localButton.setVisibility(i);
      return;
    }
  }
  
  public void setTitleBarBackground(Drawable paramDrawable)
  {
    this.mReLayout.setBackgroundDrawable(paramDrawable);
  }
  
  public void setTitleBarBackgroundColor(int paramInt)
  {
    this.mReLayout.setBackgroundColor(paramInt);
  }
  
  public void setTitleBarDivideLineBackgroudColor(int paramInt)
  {
    this.mTitleBarDivideLine.setBackgroundColor(paramInt);
  }
  
  public void updateStyle()
  {
    if (!this.isMapMode) {}
    do
    {
      return;
      if (this.mLeftImageView != null)
      {
        this.mLeftImageView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407179));
        this.mLeftImageView.setImageDrawable(BNStyleManager.getDrawable(1711407182));
      }
      if (this.mLeftButton != null) {
        this.mLeftButton.setBackgroundDrawable(BNStyleManager.getDrawable(1711407177));
      }
      this.mReLayout.setBackgroundColor(BNStyleManager.getColor(1711800536));
      if (this.mRightImageView != null) {
        this.mRightImageView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407179));
      }
      if (this.mRightButton != null) {
        this.mRightButton.setBackgroundDrawable(BNStyleManager.getDrawable(1711407177));
      }
    } while (this.mMiddleTextView == null);
    this.mMiddleTextView.setTextColor(BNStyleManager.getColor(1711800538));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNCommonTitleBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */