package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeView
  extends TextView
{
  private static final int HANDLER_WHAT_UPDATE_TIME = 4097;
  private Date mDate;
  private SimpleDateFormat mFormat = new SimpleDateFormat("HH:mm");
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      TimeView.access$002(TimeView.this, new Date());
      TimeView.this.setText(TimeView.this.mFormat.format(TimeView.this.mDate));
      TimeView.this.mHandler.sendEmptyMessageDelayed(4097, 60000L);
    }
  };
  
  public TimeView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TimeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TimeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mDate = new Date();
    setText(this.mFormat.format(this.mDate));
    this.mHandler.sendEmptyMessageDelayed(4097, (60 - this.mDate.getSeconds()) * 1000);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mHandler.removeMessages(4097);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/TimeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */