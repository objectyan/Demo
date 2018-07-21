package com.baidu.navi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.R.p;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.util.common.ScreenUtil;

public class CommonTitleBar
  extends FrameLayout
{
  protected static final int DEFAULT_TITLE_HEIGHT = 48;
  protected static final int DEFAULT_TITLE_TEXT_COLOR = 16777215;
  protected static final int DEFAULT_TITLE_TEXT_SIZE = 20;
  protected static final int MIDDLE_TITLE_TEXT_SIZE = 12;
  private boolean hasSetLeftContentFromOutSide;
  private boolean hasSetMiddleContentFromOutSide;
  private boolean hasSetRightContentFromOutSide;
  private boolean isMapMode = NaviFragmentManager.isUsingMapMode();
  protected RelativeLayout mLayout;
  protected Button mLeftButton;
  protected FrameLayout mLeftContent;
  protected ImageView mLeftImageView;
  private View.OnClickListener mLeftListener;
  protected FrameLayout mMiddleContent;
  private View.OnClickListener mMiddleListern;
  protected TextView mMiddleTextView;
  protected TextView mRightButton;
  protected FrameLayout mRightContent;
  protected ImageView mRightImageView;
  private View.OnClickListener mRightListner;
  
  public CommonTitleBar(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public CommonTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
    initAttr(paramContext, paramAttributeSet);
  }
  
  public Drawable getBackground()
  {
    return this.mLayout.getBackground();
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
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.p.CommonTitleBar);
    paramAttributeSet = paramContext.getDrawable(0);
    if (paramAttributeSet != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.mLayout.setBackground(paramAttributeSet);
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
      this.mLayout.setBackgroundDrawable(paramAttributeSet);
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
    paramContext = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    if (this.isMapMode)
    {
      this.mLayout = ((RelativeLayout)paramContext.inflate(2130968703, null));
      paramContext = new FrameLayout.LayoutParams(-2, ScreenUtil.getInstance().dip2px(48));
      addView(this.mLayout, paramContext);
      this.mLeftImageView = ((ImageView)this.mLayout.findViewById(2131624137));
      this.mLeftButton = ((Button)this.mLayout.findViewById(2131624284));
      this.mRightImageView = ((ImageView)this.mLayout.findViewById(2131624286));
      this.mRightButton = ((TextView)this.mLayout.findViewById(2131624287));
      this.mMiddleContent = ((FrameLayout)this.mLayout.findViewById(2131624288));
      this.mRightContent = ((FrameLayout)this.mLayout.findViewById(2131624188));
      this.mLeftContent = ((FrameLayout)this.mLayout.findViewById(2131624283));
      this.mLeftButton.setVisibility(8);
      this.mMiddleTextView = ((TextView)this.mLayout.findViewById(2131624285));
      paramContext = this.mMiddleTextView;
      if (!this.isMapMode) {
        break label236;
      }
    }
    label236:
    for (int i = 2131558507;; i = 2131558581)
    {
      paramContext.setTextColor(StyleManager.getColor(i));
      return;
      this.mLayout = ((RelativeLayout)paramContext.inflate(2130968636, null));
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
    this.mLeftContent.removeAllViews();
    this.mLeftContent.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    this.mLeftContent.setOnClickListener(this.mLeftListener);
    this.mLeftContent.setClickable(true);
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
    setLeftText(StyleManager.getString(paramInt));
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
    this.mLeftButton.setTextColor(paramInt);
  }
  
  public void setLeftTextColorById(int paramInt)
  {
    this.mLeftButton.setTextColor(StyleManager.getColor(paramInt));
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
    this.mMiddleContent.setVisibility(0);
    this.mMiddleContent.removeAllViews();
    this.mMiddleContent.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    this.hasSetMiddleContentFromOutSide = true;
    this.mMiddleTextView.setVisibility(4);
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
    if (this.mMiddleTextView != null)
    {
      this.mMiddleTextView.setText(paramInt);
      this.mMiddleTextView.setVisibility(0);
      this.mMiddleContent.setVisibility(8);
    }
  }
  
  public void setMiddleText(CharSequence paramCharSequence)
  {
    if (this.mMiddleTextView != null)
    {
      this.mMiddleTextView.setText(paramCharSequence);
      this.mMiddleTextView.setVisibility(0);
      this.mMiddleContent.setVisibility(8);
    }
  }
  
  public void setMiddleTextColor(int paramInt)
  {
    if (this.mMiddleTextView != null) {
      this.mMiddleTextView.setTextColor(paramInt);
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
    this.mRightContent.removeAllViews();
    this.mRightContent.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    this.mRightContent.setOnClickListener(this.mRightListner);
    this.mRightContent.setClickable(true);
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
    if (this.mRightImageView != null) {
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
    setRightText(StyleManager.getString(paramInt));
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
    if (this.mRightButton != null) {
      this.mRightButton.setTextColor(paramInt);
    }
  }
  
  public void setRightTextVisible(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.mRightButton != null)
    {
      localTextView = this.mRightButton;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void updateStyle()
  {
    if (!this.isMapMode) {}
    do
    {
      return;
      if (this.mLeftImageView != null)
      {
        this.mLeftImageView.setBackgroundDrawable(StyleManager.getDrawable(2130838020));
        this.mLeftImageView.setImageDrawable(StyleManager.getDrawable(2130838022));
      }
      if (this.mLeftButton != null) {
        this.mLeftButton.setBackgroundDrawable(StyleManager.getDrawable(2130838018));
      }
      this.mLayout.setBackgroundColor(StyleManager.getColor(2131558505));
    } while ((!NaviFragmentManager.isUsingMapMode()) || (this.mMiddleTextView == null));
    this.mMiddleTextView.setTextColor(StyleManager.getColor(2131558507));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/CommonTitleBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */