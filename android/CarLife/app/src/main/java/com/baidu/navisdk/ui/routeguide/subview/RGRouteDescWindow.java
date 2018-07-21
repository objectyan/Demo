package com.baidu.navisdk.ui.routeguide.subview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.baidu.navisdk.ui.widget.AlwaysMarqueeTextView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.common.StringUtils.UnitLangEnum;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RGRouteDescWindow
  extends PopupWindow
{
  private static final int MSG_DISMISS = 1;
  private static final String TAG = "RouteGuide";
  private final Context mContext;
  private AlwaysMarqueeTextView mEndNameTextView;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
      } while ((RGRouteDescWindow.this.mContext == null) || (((Activity)RGRouteDescWindow.this.mContext).isFinishing()) || (!RGRouteDescWindow.this.isShowing()));
      RGRouteDescWindow.this.dismiss();
    }
  };
  private View mParent;
  private TextView mRouteDist;
  private TextView mRouteDistUnit;
  private TextView mRouteTime;
  protected OnRGSubViewListener mSubViewListener;
  
  public RGRouteDescWindow(Context paramContext, View paramView, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mSubViewListener = paramOnRGSubViewListener;
    this.mParent = paramView;
    paramContext = JarUtils.inflate((Activity)this.mContext, 1711472740, null);
    this.mRouteDist = ((TextView)paramContext.findViewById(1711866957));
    this.mRouteDistUnit = ((TextView)paramContext.findViewById(1711866958));
    this.mRouteTime = ((TextView)paramContext.findViewById(1711866959));
    this.mEndNameTextView = ((AlwaysMarqueeTextView)paramContext.findViewById(1711866961));
    setWindowLayoutMode(-2, -2);
    setContentView(paramContext);
    setBackgroundDrawable(new ColorDrawable(0));
    setAnimationStyle(1711996928);
    onMeasureAndLayout();
    setOutsideTouchable(true);
    getContentView().setFocusableInTouchMode(true);
    setTouchable(true);
    getContentView().setOnKeyListener(new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        LogUtil.e("RouteGuide", "返回了");
        switch (paramAnonymousInt)
        {
        default: 
          return false;
        }
        return true;
      }
    });
    setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        if (RGRouteDescWindow.this.mSubViewListener != null) {
          RGRouteDescWindow.this.mSubViewListener.onRouteDescWindowHide();
        }
      }
    });
    setTouchInterceptor(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
  }
  
  private void onMeasureAndLayout()
  {
    getContentView().measure(View.MeasureSpec.makeMeasureSpec(ScreenUtil.getInstance().getWidthPixels(), Integer.MIN_VALUE), -2);
    setWidth(getContentView().getMeasuredWidth());
    setHeight(getContentView().getMeasuredHeight());
  }
  
  private void setRouteTime(String paramString)
  {
    SpannableString localSpannableString = new SpannableString(paramString);
    paramString = Pattern.compile("[0-9.<]+").matcher(paramString);
    while (paramString.find()) {
      localSpannableString.setSpan(new ForegroundColorSpan(-5180122), paramString.start(), paramString.end(), 33);
    }
    this.mRouteTime.setText(localSpannableString);
  }
  
  public void dismiss()
  {
    this.mHandler.removeMessages(1);
    if ((this.mContext == null) || (((Activity)this.mContext).isFinishing()) || (!isShowing()) || (this != null)) {}
    try
    {
      super.dismiss();
      setFocusable(false);
      getContentView().setFocusable(false);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void setDistanceAndTime(int paramInt1, int paramInt2)
  {
    String[] arrayOfString = StringUtils.formatDistance(paramInt1, StringUtils.UnitLangEnum.ZH);
    String str = StringUtils.formatTime2(paramInt2, 2);
    this.mRouteDist.setText(arrayOfString[0]);
    this.mRouteDistUnit.setText(arrayOfString[1]);
    setRouteTime(str);
  }
  
  public void setEndName(String paramString)
  {
    this.mEndNameTextView.setText(paramString);
  }
  
  public void show()
  {
    LogUtil.e("RouteGuide", "show");
    try
    {
      if ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()))
      {
        if (this.mSubViewListener != null) {
          this.mSubViewListener.onRouteDescWindowShow();
        }
        onMeasureAndLayout();
        showAtLocation(this.mParent, 17, 0, 0);
        getContentView().setFocusable(true);
        setFocusable(true);
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 2000L);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/RGRouteDescWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */