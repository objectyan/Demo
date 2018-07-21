package com.baidu.ufosdk.ui;

import android.view.View;

final class az
  implements da
{
  az(FeedbackInputActivity paramFeedbackInputActivity, cx paramcx) {}
  
  public final void a()
  {
    this.b.dismiss();
    FeedbackInputActivity.b(this.a).setVisibility(0);
    FeedbackInputActivity.b(this.a).bringToFront();
    new Thread(new bc(this)).start();
  }
  
  public final void a(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      this.b.dismiss();
      FeedbackInputActivity.b(this.a).setVisibility(0);
      FeedbackInputActivity.b(this.a).bringToFront();
      new Thread(new ba(this, paramString)).start();
      return;
    }
    this.b.dismiss();
    FeedbackInputActivity.b(this.a).setVisibility(0);
    FeedbackInputActivity.b(this.a).bringToFront();
    new Thread(new bb(this)).start();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */