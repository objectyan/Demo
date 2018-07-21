package com.baidu.carlife.view;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.widget.ImageView;

public class SignalImageView
  extends ImageView
{
  private TelephonyManager a;
  private a b;
  
  public SignalImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SignalImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SignalImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = ((TelephonyManager)paramContext.getSystemService("phone"));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.b = new a(null);
    this.a.listen(this.b, 256);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.listen(this.b, 0);
  }
  
  private class a
    extends PhoneStateListener
  {
    private final int b = 0;
    private final int c = 1;
    private final int d = 2;
    private final int e = 3;
    private final int f = 4;
    
    private a() {}
    
    private void a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        SignalImageView.this.setImageResource(2130839431);
        return;
      case 1: 
        SignalImageView.this.setImageResource(2130839432);
        return;
      case 2: 
        SignalImageView.this.setImageResource(2130839433);
        return;
      case 3: 
        SignalImageView.this.setImageResource(2130839434);
        return;
      }
      SignalImageView.this.setImageResource(2130839435);
    }
    
    public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      super.onSignalStrengthsChanged(paramSignalStrength);
      if (SignalImageView.a(SignalImageView.this).getSimState() == 5)
      {
        int i;
        if (!paramSignalStrength.isGsm())
        {
          i = paramSignalStrength.getCdmaDbm();
          if (i >= -75) {
            i = 4;
          }
        }
        for (;;)
        {
          a(i);
          return;
          if (i >= -85)
          {
            i = 3;
          }
          else if (i >= -95)
          {
            i = 2;
          }
          else if (i >= -100)
          {
            i = 1;
          }
          else
          {
            i = 0;
            continue;
            i = paramSignalStrength.getGsmSignalStrength();
            if ((i < 0) || (i >= 99)) {
              i = 0;
            } else if (i >= 16) {
              i = 4;
            } else if (i >= 8) {
              i = 3;
            } else if (i >= 4) {
              i = 2;
            } else {
              i = 1;
            }
          }
        }
      }
      SignalImageView.this.setImageResource(2130839436);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/view/SignalImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */