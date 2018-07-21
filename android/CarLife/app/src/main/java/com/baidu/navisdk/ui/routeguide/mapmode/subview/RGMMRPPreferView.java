package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMRPPreferView
  extends BNBaseView
{
  private static String TAG = RGMMRPPreferView.class.getName();
  private final String[] TIPS_TEXT_CONTENT = { "躲避拥堵/", "高速优先/", "不走高速/", "少收费/" };
  private final String TIPS_TEXT_DEFAULT = "推荐";
  private final String TIPS_TEXT_PREFIX = "正在使用";
  private final String TIPS_TEXT_SUFFIX = "方案";
  private ViewGroup mRPPreferContainer = null;
  private TextView mRPPreferTV = null;
  private View mRPPreferView = null;
  
  public RGMMRPPreferView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
    updateStyle(BNStyleManager.getDayStyle());
    initListener();
  }
  
  private String getTipsText()
  {
    StringBuilder localStringBuilder2 = new StringBuilder("正在使用");
    localObject2 = localStringBuilder2;
    for (;;)
    {
      try
      {
        int i = BNRoutePlaner.getInstance().getCalcPreference();
        localObject2 = localStringBuilder2;
        if ((isOnLineNetMode()) && ((i & 0x10) != 0))
        {
          localObject2 = localStringBuilder2;
          localStringBuilder2.append(this.TIPS_TEXT_CONTENT[0]);
        }
        if ((i & 0x2) != 0)
        {
          localObject2 = localStringBuilder2;
          localStringBuilder2.append(this.TIPS_TEXT_CONTENT[1]);
        }
        if ((i & 0x4) != 0)
        {
          localObject2 = localStringBuilder2;
          localStringBuilder2.append(this.TIPS_TEXT_CONTENT[2]);
        }
        if ((i & 0x8) != 0)
        {
          localObject2 = localStringBuilder2;
          localStringBuilder2.append(this.TIPS_TEXT_CONTENT[3]);
        }
        localObject2 = localStringBuilder2;
        if (!localStringBuilder2.toString().equals("正在使用")) {
          continue;
        }
        localObject2 = localStringBuilder2;
        localStringBuilder2.append("推荐");
        localStringBuilder1 = localStringBuilder2;
        localObject2 = localStringBuilder1;
        localStringBuilder1.append("方案");
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder1;
        Object localObject1 = localObject2;
        continue;
      }
      return localStringBuilder1.toString();
      localStringBuilder1 = localStringBuilder2;
      localObject2 = localStringBuilder2;
      if (localStringBuilder2.toString().length() >= 1)
      {
        localObject2 = localStringBuilder2;
        localStringBuilder1 = new StringBuilder(localStringBuilder2.substring(0, localStringBuilder2.toString().length() - 1));
      }
    }
  }
  
  private void initListener()
  {
    if (this.mRPPreferContainer != null) {
      this.mRPPreferContainer.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
    }
  }
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {}
    do
    {
      do
      {
        return;
      } while (this.mRPPreferContainer == null);
      this.mRPPreferContainer.removeAllViews();
      this.mRPPreferView = JarUtils.inflate((Activity)this.mContext, 1711472707, null);
    } while (this.mRPPreferView == null);
    this.mRPPreferTV = ((TextView)this.mRPPreferView.findViewById(1711866462));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    this.mRPPreferContainer.addView(this.mRPPreferView, localLayoutParams);
  }
  
  private boolean isOnLineNetMode()
  {
    int i = BNRoutePlaner.getInstance().getEngineCalcRouteNetMode();
    return (i == 3) || (i == 1);
  }
  
  public void hide()
  {
    super.hide();
    LogUtil.e(TAG, "hide()");
    if (this.mRPPreferContainer != null) {
      this.mRPPreferContainer.setVisibility(8);
    }
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mCurOrientation == paramInt) {
      return;
    }
    super.orientationChanged(paramViewGroup, paramInt);
  }
  
  public void show()
  {
    super.show();
    LogUtil.e(TAG, "show()");
    if (this.mRPPreferContainer != null) {
      this.mRPPreferContainer.setVisibility(0);
    }
    if (this.mRPPreferTV != null)
    {
      String str = getTipsText();
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-1), "正在使用".length(), str.length() - "方案".length(), 33);
      localSpannableStringBuilder.setSpan(new RelativeSizeSpan(1.05F), "正在使用".length(), str.length() - "方案".length(), 33);
      this.mRPPreferTV.setText(localSpannableStringBuilder);
    }
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMRPPreferView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */