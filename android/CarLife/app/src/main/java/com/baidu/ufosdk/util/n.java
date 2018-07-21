package com.baidu.ufosdk.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import android.view.Window;
import java.io.ByteArrayOutputStream;

public final class n
{
  public static n a;
  private Context b;
  private Bitmap c;
  private ByteArrayOutputStream d;
  
  private n(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static n a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new n(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  @SuppressLint({"NewApi"})
  public final void a(Activity paramActivity, int paramInt)
  {
    int j = 40;
    View localView = paramActivity.getWindow().getDecorView();
    localView.setDrawingCacheEnabled(true);
    localView.buildDrawingCache();
    this.d = new ByteArrayOutputStream();
    this.c = localView.getDrawingCache();
    if (this.c != null) {
      this.c.compress(Bitmap.CompressFormat.JPEG, 40, this.d);
    }
    c.c("stream.toByteArray() length is " + this.d.toByteArray().length);
    c.c("stream.toByteArray() length is " + i.c(this.d.toByteArray().length));
    int i = this.d.toByteArray().length;
    for (;;)
    {
      if ((i <= 300000) || (j < 0))
      {
        c.c("stream.toByteArray() length is " + this.d.toByteArray().length);
        c.c("stream.toByteArray() length is " + i.c(this.d.toByteArray().length));
        paramActivity = new o(this, paramActivity, paramInt);
        if (this.c != null) {
          break;
        }
        c.d("screen shot is null");
        paramActivity.run();
        return;
      }
      c.c("quality is " + j);
      this.d = new ByteArrayOutputStream();
      this.c.compress(Bitmap.CompressFormat.JPEG, j, this.d);
      j -= 10;
      i = this.d.toByteArray().length;
      c.c("streamLength is " + i);
    }
    try
    {
      this.c.setHasAlpha(false);
      this.c.prepareToDraw();
      paramActivity.run();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */