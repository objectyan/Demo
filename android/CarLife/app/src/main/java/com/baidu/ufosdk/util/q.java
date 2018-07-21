package com.baidu.ufosdk.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import android.widget.TextView;

public final class q
  extends Handler
{
  ImageView a;
  Handler b;
  Context c;
  TextView d = null;
  
  public q(Context paramContext, ImageView paramImageView, Handler paramHandler)
  {
    this.a = paramImageView;
    this.b = paramHandler;
    this.c = paramContext;
  }
  
  public q(Context paramContext, TextView paramTextView, Handler paramHandler)
  {
    this.d = paramTextView;
    this.b = paramHandler;
    this.c = paramContext;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.obj != null)
    {
      paramMessage = (Bitmap)paramMessage.obj;
      if (this.d != null)
      {
        paramMessage = new ImageSpan(this.c, paramMessage);
        SpannableString localSpannableString = new SpannableString("icon");
        localSpannableString.setSpan(paramMessage, 0, 4, 33);
        this.d.setText(localSpannableString);
      }
    }
    for (;;)
    {
      return;
      this.a.setImageBitmap(paramMessage);
      if (paramMessage.getHeight() > paramMessage.getWidth())
      {
        this.a.setMaxWidth(i.a(this.c, 80.0F));
        this.a.setMaxHeight(i.a(this.c, 120.0F));
      }
      while (this.b != null)
      {
        this.b.obtainMessage(6).sendToTarget();
        return;
        this.a.setMaxWidth(i.a(this.c, 120.0F));
        this.a.setMaxHeight(i.a(this.c, 80.0F));
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */