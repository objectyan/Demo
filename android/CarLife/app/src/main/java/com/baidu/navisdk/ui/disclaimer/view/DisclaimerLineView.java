package com.baidu.navisdk.ui.disclaimer.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.R.styleable;
import com.baidu.navisdk.util.jar.JarUtils;

public class DisclaimerLineView
  extends RelativeLayout
{
  public DisclaimerLineView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DisclaimerLineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DisclaimerLineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View localView = JarUtils.inflate((Activity)paramContext, 1711472670, this);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DisclaimerLineView);
    paramContext = paramAttributeSet.getString(0);
    paramAttributeSet.recycle();
    paramAttributeSet = (TextView)localView.findViewById(1711866080);
    if (!TextUtils.isEmpty(paramContext)) {
      paramAttributeSet.setText(String.format("　 %s", new Object[] { paramContext }));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/disclaimer/view/DisclaimerLineView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */