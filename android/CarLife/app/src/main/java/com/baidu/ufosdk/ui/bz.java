package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

final class bz
  implements View.OnClickListener
{
  bz(br parambr) {}
  
  public final void onClick(View paramView)
  {
    try
    {
      FeedbackInputActivity.b = ((BitmapDrawable)((ImageView)paramView).getDrawable()).getBitmap();
      paramView = new Intent(br.a(this.a), FeedbackImageViewFlipperActivity.class);
      br.a(this.a).startActivity(paramView);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */