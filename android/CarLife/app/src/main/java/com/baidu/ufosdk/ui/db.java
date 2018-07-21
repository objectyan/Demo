package com.baidu.ufosdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public final class db
  extends ImageView
{
  private Paint a;
  private int b = 5;
  private int c = 5;
  private Paint d;
  
  public db(Context paramContext)
  {
    super(paramContext);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.b = ((int)(this.b * f));
    this.c = ((int)(f * this.c));
    this.a = new Paint();
    this.a.setColor(-1);
    this.a.setAntiAlias(true);
    this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.d = new Paint();
    this.d.setXfermode(null);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    super.draw(localCanvas);
    Path localPath = new Path();
    localPath.moveTo(0.0F, this.c);
    localPath.lineTo(0.0F, 0.0F);
    localPath.lineTo(this.b, 0.0F);
    localPath.arcTo(new RectF(0.0F, 0.0F, this.b * 2, this.c * 2), -90.0F, -90.0F);
    localPath.close();
    localCanvas.drawPath(localPath, this.a);
    localPath = new Path();
    localPath.moveTo(getWidth(), this.c);
    localPath.lineTo(getWidth(), 0.0F);
    localPath.lineTo(getWidth() - this.b, 0.0F);
    localPath.arcTo(new RectF(getWidth() - this.b * 2, 0.0F, getWidth(), this.c * 2 + 0), -90.0F, 90.0F);
    localPath.close();
    localCanvas.drawPath(localPath, this.a);
    localPath = new Path();
    localPath.moveTo(0.0F, getHeight() - this.c);
    localPath.lineTo(0.0F, getHeight());
    localPath.lineTo(this.b, getHeight());
    localPath.arcTo(new RectF(0.0F, getHeight() - this.c * 2, this.b * 2 + 0, getHeight()), 90.0F, 90.0F);
    localPath.close();
    localCanvas.drawPath(localPath, this.a);
    localPath = new Path();
    localPath.moveTo(getWidth() - this.b, getHeight());
    localPath.lineTo(getWidth(), getHeight());
    localPath.lineTo(getWidth(), getHeight() - this.c);
    localPath.arcTo(new RectF(getWidth() - this.b * 2, getHeight() - this.c * 2, getWidth(), getHeight()), 0.0F, 90.0F);
    localPath.close();
    localCanvas.drawPath(localPath, this.a);
    paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, this.d);
    localBitmap.recycle();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */