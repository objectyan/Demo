package com.baidu.ufosdk.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ViewFlipper;
import com.baidu.ufosdk.ResumeCallBack;
import com.baidu.ufosdk.a;
import com.baidu.ufosdk.util.c;
import java.util.ArrayList;

public class FeedbackImageViewFlipperActivity
  extends Activity
  implements GestureDetector.OnGestureListener
{
  private GestureDetector a;
  private ViewFlipper b;
  
  protected void onCreate(Bundle paramBundle)
  {
    int k = 0;
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setRequestedOrientation(1);
    paramBundle = new LinearLayout.LayoutParams(-1, -1);
    paramBundle.gravity = 17;
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setLayoutParams(paramBundle);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    localLinearLayout.setBackgroundColor(-16777216);
    this.b = new ViewFlipper(this);
    localLinearLayout.addView(this.b, paramBundle);
    setContentView(localLinearLayout);
    this.a = new GestureDetector(this);
    int i = 0;
    label125:
    int j;
    if (i >= FeedbackInputActivity.a.size())
    {
      i = 0;
      j = i;
      label127:
      if (j < FeedbackInputActivity.a.size()) {
        break label217;
      }
      j = k;
    }
    for (;;)
    {
      if (j >= i)
      {
        this.b.setAutoStart(true);
        this.b.setFlipInterval(3000);
        if ((this.b.isAutoStart()) && (!this.b.isFlipping())) {
          this.b.startFlipping();
        }
        return;
        if (FeedbackInputActivity.b.equals(FeedbackInputActivity.a.get(i))) {
          break label125;
        }
        i += 1;
        break;
        label217:
        paramBundle = new ImageView(this);
        paramBundle.setAdjustViewBounds(true);
        paramBundle.setScaleType(ImageView.ScaleType.FIT_CENTER);
        paramBundle.setImageBitmap((Bitmap)FeedbackInputActivity.a.get(j));
        this.b.addView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
        j += 1;
        break label127;
      }
      paramBundle = new ImageView(this);
      paramBundle.setAdjustViewBounds(true);
      paramBundle.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramBundle.setImageBitmap((Bitmap)FeedbackInputActivity.a.get(j));
      this.b.addView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
      j += 1;
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    c.b("onFling");
    if (paramMotionEvent2.getX() - paramMotionEvent1.getX() > 60.0F)
    {
      paramMotionEvent1 = new TranslateAnimation(-com.baidu.ufosdk.b.e.a(this)[0], 0.0F, 0.0F, 0.0F);
      paramMotionEvent1.setDuration(500L);
      paramMotionEvent2 = new TranslateAnimation(0.0F, com.baidu.ufosdk.b.e.a(this)[0], 0.0F, 0.0F);
      paramMotionEvent2.setDuration(500L);
      this.b.setInAnimation(paramMotionEvent1);
      this.b.setOutAnimation(paramMotionEvent2);
      this.b.showNext();
    }
    while (paramMotionEvent2.getX() - paramMotionEvent1.getX() >= -60.0F) {
      return true;
    }
    paramMotionEvent1 = new TranslateAnimation(com.baidu.ufosdk.b.e.a(this)[0], 0.0F, 0.0F, 0.0F);
    paramMotionEvent1.setDuration(500L);
    paramMotionEvent2 = new TranslateAnimation(0.0F, -com.baidu.ufosdk.b.e.a(this)[0], 0.0F, 0.0F);
    paramMotionEvent2.setDuration(500L);
    this.b.setInAnimation(paramMotionEvent1);
    this.b.setOutAnimation(paramMotionEvent2);
    this.b.showPrevious();
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  protected void onRestart()
  {
    super.onRestart();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (a.ah != null) {
      a.ah.onResumeCallback();
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    finish();
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.b.stopFlipping();
    this.b.setAutoStart(false);
    return this.a.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/FeedbackImageViewFlipperActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */