package com.baidu.carlife.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTextView
  extends TextView
{
  private SimpleDateFormat a = new SimpleDateFormat("HH:mm");
  private Handler b = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      TimeTextView.this.setText(TimeTextView.a(TimeTextView.this).format(new Date()));
      sendEmptyMessageDelayed(0, 60000L);
    }
  };
  
  public TimeTextView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TimeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TimeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Date localDate = new Date();
    setText(this.a.format(localDate));
    int i = localDate.getSeconds();
    this.b.sendEmptyMessageDelayed(0, (60 - i) * 1000);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.b.removeMessages(0);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/TimeTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */