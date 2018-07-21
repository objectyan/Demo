package com.baidu.navisdk.ui.routeguide.subview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EllipsizingTextView
  extends TextView
{
  private static final Pattern DEFAULT_END_PUNCTUATION = Pattern.compile("[\\.!?,;:…]*$", 32);
  private static final CharSequence ELLIPSIS = "…";
  private boolean isEllipsized;
  private boolean isStale;
  private final List<EllipsizeListener> mEllipsizeListeners = new ArrayList();
  private EllipsizeStrategy mEllipsizeStrategy;
  private Pattern mEndPunctPattern;
  private CharSequence mFullText;
  private float mLineAddVertPad = 0.0F;
  private float mLineSpacingMult = 1.0F;
  private int mMaxLines;
  private boolean programmaticChange;
  
  public EllipsizingTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16843091 }, paramInt, 0);
    setMaxLines(paramContext.getInt(0, Integer.MAX_VALUE));
    paramContext.recycle();
    setEndPunctuationPattern(DEFAULT_END_PUNCTUATION);
  }
  
  /* Error */
  private void resetText()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 124	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:getMaxLines	()I
    //   4: istore_1
    //   5: aload_0
    //   6: getfield 126	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:mFullText	Ljava/lang/CharSequence;
    //   9: astore_3
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_1
    //   13: iconst_m1
    //   14: if_icmpeq +43 -> 57
    //   17: aload_0
    //   18: getfield 128	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:mEllipsizeStrategy	Lcom/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView$EllipsizeStrategy;
    //   21: ifnonnull +8 -> 29
    //   24: aload_0
    //   25: aconst_null
    //   26: invokevirtual 132	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:setEllipsize	(Landroid/text/TextUtils$TruncateAt;)V
    //   29: aload_0
    //   30: getfield 128	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:mEllipsizeStrategy	Lcom/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView$EllipsizeStrategy;
    //   33: aload_0
    //   34: getfield 126	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:mFullText	Ljava/lang/CharSequence;
    //   37: invokevirtual 136	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView$EllipsizeStrategy:processText	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   40: astore_3
    //   41: aload_0
    //   42: getfield 128	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:mEllipsizeStrategy	Lcom/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView$EllipsizeStrategy;
    //   45: aload_0
    //   46: getfield 126	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:mFullText	Ljava/lang/CharSequence;
    //   49: invokevirtual 140	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView$EllipsizeStrategy:isInLayout	(Ljava/lang/CharSequence;)Z
    //   52: ifne +86 -> 138
    //   55: iconst_1
    //   56: istore_2
    //   57: aload_3
    //   58: aload_0
    //   59: invokevirtual 143	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:getText	()Ljava/lang/CharSequence;
    //   62: invokevirtual 149	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   65: ifne +18 -> 83
    //   68: aload_0
    //   69: iconst_1
    //   70: putfield 151	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:programmaticChange	Z
    //   73: aload_0
    //   74: aload_3
    //   75: invokevirtual 155	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:setText	(Ljava/lang/CharSequence;)V
    //   78: aload_0
    //   79: iconst_0
    //   80: putfield 151	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:programmaticChange	Z
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 157	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:isStale	Z
    //   88: iload_2
    //   89: aload_0
    //   90: getfield 159	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:isEllipsized	Z
    //   93: if_icmpeq +58 -> 151
    //   96: aload_0
    //   97: iload_2
    //   98: putfield 159	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:isEllipsized	Z
    //   101: aload_0
    //   102: getfield 77	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:mEllipsizeListeners	Ljava/util/List;
    //   105: invokeinterface 165 1 0
    //   110: astore_3
    //   111: aload_3
    //   112: invokeinterface 171 1 0
    //   117: ifeq +34 -> 151
    //   120: aload_3
    //   121: invokeinterface 175 1 0
    //   126: checkcast 11	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView$EllipsizeListener
    //   129: iload_2
    //   130: invokeinterface 179 2 0
    //   135: goto -24 -> 111
    //   138: iconst_0
    //   139: istore_2
    //   140: goto -83 -> 57
    //   143: astore_3
    //   144: aload_0
    //   145: iconst_0
    //   146: putfield 151	com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView:programmaticChange	Z
    //   149: aload_3
    //   150: athrow
    //   151: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	EllipsizingTextView
    //   4	11	1	i	int
    //   11	129	2	bool	boolean
    //   9	112	3	localObject1	Object
    //   143	7	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   73	78	143	finally
  }
  
  public void addEllipsizeListener(EllipsizeListener paramEllipsizeListener)
  {
    this.mEllipsizeListeners.add(paramEllipsizeListener);
  }
  
  public boolean ellipsizingLastFullyVisibleLine()
  {
    return this.mMaxLines == Integer.MAX_VALUE;
  }
  
  public int getMaxLines()
  {
    return this.mMaxLines;
  }
  
  public boolean isEllipsized()
  {
    return this.isEllipsized;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.isStale) {
      resetText();
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (ellipsizingLastFullyVisibleLine()) {
      this.isStale = true;
    }
  }
  
  public void removeEllipsizeListener(EllipsizeListener paramEllipsizeListener)
  {
    this.mEllipsizeListeners.remove(paramEllipsizeListener);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    if (paramTruncateAt == null)
    {
      this.mEllipsizeStrategy = new EllipsizeNoneStrategy(null);
      return;
    }
    switch (paramTruncateAt)
    {
    default: 
      this.mEllipsizeStrategy = new EllipsizeNoneStrategy(null);
      return;
    case ???: 
      this.mEllipsizeStrategy = new EllipsizeEndStrategy(null);
      return;
    case ???: 
      this.mEllipsizeStrategy = new EllipsizeStartStrategy(null);
      return;
    case ???: 
      this.mEllipsizeStrategy = new EllipsizeMiddleStrategy(null);
      return;
    }
    super.setEllipsize(paramTruncateAt);
    this.isStale = false;
    this.mEllipsizeStrategy = new EllipsizeNoneStrategy(null);
  }
  
  public void setEndPunctuationPattern(Pattern paramPattern)
  {
    this.mEndPunctPattern = paramPattern;
  }
  
  public void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    this.mLineAddVertPad = paramFloat1;
    this.mLineSpacingMult = paramFloat2;
    super.setLineSpacing(paramFloat1, paramFloat2);
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.mMaxLines = paramInt;
    this.isStale = true;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    if (ellipsizingLastFullyVisibleLine()) {
      this.isStale = true;
    }
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (!this.programmaticChange)
    {
      this.mFullText = paramCharSequence;
      this.isStale = true;
    }
    super.setText(paramCharSequence, paramBufferType);
  }
  
  private class EllipsizeEndStrategy
    extends EllipsizingTextView.EllipsizeStrategy
  {
    private EllipsizeEndStrategy()
    {
      super(null);
    }
    
    protected CharSequence createEllipsizedText(CharSequence paramCharSequence)
    {
      int i = createWorkingLayout(paramCharSequence).getLineEnd(EllipsizingTextView.this.mMaxLines - 1);
      int k = paramCharSequence.length();
      int j = k - i;
      i = j;
      if (j < EllipsizingTextView.ELLIPSIS.length()) {
        i = EllipsizingTextView.ELLIPSIS.length();
      }
      Object localObject = TextUtils.substring(paramCharSequence, 0, k - i).trim();
      for (String str = stripEndPunctuation((CharSequence)localObject);; str = stripEndPunctuation((CharSequence)localObject))
      {
        if (!isInLayout(str + EllipsizingTextView.ELLIPSIS))
        {
          i = ((String)localObject).lastIndexOf(' ');
          if (i != -1) {}
        }
        else
        {
          str = str + EllipsizingTextView.ELLIPSIS;
          localObject = new SpannableStringBuilder(str);
          if ((paramCharSequence instanceof Spanned)) {
            TextUtils.copySpansFrom((Spanned)paramCharSequence, 0, str.length(), null, (Spannable)localObject, 0);
          }
          return (CharSequence)localObject;
        }
        localObject = ((String)localObject).substring(0, i).trim();
      }
    }
    
    public String stripEndPunctuation(CharSequence paramCharSequence)
    {
      return EllipsizingTextView.this.mEndPunctPattern.matcher(paramCharSequence).replaceFirst("");
    }
  }
  
  public static abstract interface EllipsizeListener
  {
    public abstract void ellipsizeStateChanged(boolean paramBoolean);
  }
  
  private class EllipsizeMiddleStrategy
    extends EllipsizingTextView.EllipsizeStrategy
  {
    private EllipsizeMiddleStrategy()
    {
      super(null);
    }
    
    protected CharSequence createEllipsizedText(CharSequence paramCharSequence)
    {
      int m = createWorkingLayout(paramCharSequence).getLineEnd(EllipsizingTextView.this.mMaxLines - 1);
      int k = paramCharSequence.length();
      int j = k - m;
      int i = j;
      if (j < EllipsizingTextView.ELLIPSIS.length()) {
        i = EllipsizingTextView.ELLIPSIS.length();
      }
      i += m % 2;
      String str2 = TextUtils.substring(paramCharSequence, 0, k / 2 - i / 2).trim();
      for (String str1 = TextUtils.substring(paramCharSequence, k / 2 + i / 2, k).trim();; str1 = str1.substring(j, str1.length()).trim())
      {
        if (!isInLayout(str2 + EllipsizingTextView.ELLIPSIS + str1))
        {
          i = str2.lastIndexOf(' ');
          j = str1.indexOf(' ');
          if ((i != -1) && (j != -1)) {}
        }
        else
        {
          SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder(str2);
          SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder(str1);
          if ((paramCharSequence instanceof Spanned))
          {
            TextUtils.copySpansFrom((Spanned)paramCharSequence, 0, str2.length(), null, localSpannableStringBuilder1, 0);
            TextUtils.copySpansFrom((Spanned)paramCharSequence, k - str1.length(), k, null, localSpannableStringBuilder2, 0);
          }
          return TextUtils.concat(new CharSequence[] { localSpannableStringBuilder1, EllipsizingTextView.ELLIPSIS, localSpannableStringBuilder2 });
        }
        str2 = str2.substring(0, i).trim();
      }
    }
  }
  
  private class EllipsizeNoneStrategy
    extends EllipsizingTextView.EllipsizeStrategy
  {
    private EllipsizeNoneStrategy()
    {
      super(null);
    }
    
    protected CharSequence createEllipsizedText(CharSequence paramCharSequence)
    {
      return paramCharSequence;
    }
  }
  
  private class EllipsizeStartStrategy
    extends EllipsizingTextView.EllipsizeStrategy
  {
    private EllipsizeStartStrategy()
    {
      super(null);
    }
    
    protected CharSequence createEllipsizedText(CharSequence paramCharSequence)
    {
      int i = createWorkingLayout(paramCharSequence).getLineEnd(EllipsizingTextView.this.mMaxLines - 1);
      int k = paramCharSequence.length();
      int j = k - i;
      i = j;
      if (j < EllipsizingTextView.ELLIPSIS.length()) {
        i = EllipsizingTextView.ELLIPSIS.length();
      }
      for (String str = TextUtils.substring(paramCharSequence, i, k).trim();; str = str.substring(i, str.length()).trim()) {
        if (!isInLayout(EllipsizingTextView.ELLIPSIS + str))
        {
          i = str.indexOf(' ');
          if (i != -1) {}
        }
        else
        {
          str = EllipsizingTextView.ELLIPSIS + str;
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
          if ((paramCharSequence instanceof Spanned)) {
            TextUtils.copySpansFrom((Spanned)paramCharSequence, k - str.length(), k, null, localSpannableStringBuilder, 0);
          }
          return localSpannableStringBuilder;
        }
      }
    }
  }
  
  private abstract class EllipsizeStrategy
  {
    private EllipsizeStrategy() {}
    
    protected abstract CharSequence createEllipsizedText(CharSequence paramCharSequence);
    
    protected Layout createWorkingLayout(CharSequence paramCharSequence)
    {
      return new StaticLayout(paramCharSequence, EllipsizingTextView.this.getPaint(), EllipsizingTextView.this.getMeasuredWidth() - EllipsizingTextView.this.getPaddingLeft() - EllipsizingTextView.this.getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, EllipsizingTextView.this.mLineSpacingMult, EllipsizingTextView.this.mLineAddVertPad, false);
    }
    
    protected int getFullyVisibleLinesCount()
    {
      Layout localLayout = createWorkingLayout("");
      return (EllipsizingTextView.this.getHeight() - EllipsizingTextView.this.getCompoundPaddingTop() - EllipsizingTextView.this.getCompoundPaddingBottom()) / localLayout.getLineBottom(0);
    }
    
    protected int getLinesCount()
    {
      if (EllipsizingTextView.this.ellipsizingLastFullyVisibleLine())
      {
        int j = getFullyVisibleLinesCount();
        int i = j;
        if (j == -1) {
          i = 1;
        }
        return i;
      }
      return EllipsizingTextView.this.mMaxLines;
    }
    
    public boolean isInLayout(CharSequence paramCharSequence)
    {
      return createWorkingLayout(paramCharSequence).getLineCount() <= getLinesCount();
    }
    
    public CharSequence processText(CharSequence paramCharSequence)
    {
      CharSequence localCharSequence = paramCharSequence;
      if (!isInLayout(paramCharSequence)) {
        localCharSequence = createEllipsizedText(paramCharSequence);
      }
      return localCharSequence;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/widget/EllipsizingTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */