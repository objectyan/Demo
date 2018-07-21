package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.Calendar;

public class BNDigitalClock
  extends TextView
{
  private static final String m12 = "现在h:mm";
  private static final String m24 = "现在k:mm";
  Calendar mCalendar;
  String mFormat = "现在k:mm";
  private Handler mHandler;
  private Runnable mTicker;
  private boolean mTickerStopped = false;
  
  public BNDigitalClock(Context paramContext)
  {
    super(paramContext);
    initClock(paramContext);
  }
  
  public BNDigitalClock(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initClock(paramContext);
  }
  
  private void initClock(Context paramContext)
  {
    if (this.mCalendar == null) {
      this.mCalendar = Calendar.getInstance();
    }
    setFormat();
  }
  
  private void setFormat()
  {
    this.mFormat = "现在k:mm";
  }
  
  protected void onAttachedToWindow()
  {
    this.mTickerStopped = false;
    super.onAttachedToWindow();
    this.mHandler = new Handler();
    this.mTicker = new Runnable()
    {
      public void run()
      {
        if (BNDigitalClock.this.mTickerStopped) {
          return;
        }
        BNDigitalClock.this.mCalendar.setTimeInMillis(System.currentTimeMillis());
        BNDigitalClock.this.setText(DateFormat.format(BNDigitalClock.this.mFormat, BNDigitalClock.this.mCalendar));
        BNDigitalClock.this.invalidate();
        long l = SystemClock.uptimeMillis();
        BNDigitalClock.this.mHandler.postAtTime(BNDigitalClock.this.mTicker, l + (1000L - l % 1000L));
      }
    };
    this.mTicker.run();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mTickerStopped = true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNDigitalClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */