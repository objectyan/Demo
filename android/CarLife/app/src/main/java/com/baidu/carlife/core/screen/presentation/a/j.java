package com.baidu.carlife.core.screen.presentation.a;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.c;
import com.baidu.carlife.core.d;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.screen.k;
import com.baidu.carlife.core.screen.video.e;

public class j
{
  private static final String b = "CarlifeActivity#MaskView";
  private static com.baidu.carlife.core.screen.presentation.i f;
  private static Surface g;
  TextureView.SurfaceTextureListener a = new TextureView.SurfaceTextureListener()
  {
    public void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      com.baidu.carlife.core.i.b("CarlifeActivity#MaskView", "onSurfaceTextureAvailable surface=" + paramAnonymousSurfaceTexture + ", width=" + paramAnonymousInt1 + ", height=" + paramAnonymousInt2);
      paramAnonymousSurfaceTexture = new Surface(paramAnonymousSurfaceTexture);
      d locald = d.a();
      j.a(new com.baidu.carlife.core.screen.presentation.i(locald.h(), locald.i(), locald.g(), paramAnonymousSurfaceTexture, 2));
      if (!c.a().l())
      {
        j.this.a();
        c.a().i(true);
      }
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      com.baidu.carlife.core.i.b("CarlifeActivity#MaskView", "onSurfaceTextureDestroyed surface=" + paramAnonymousSurfaceTexture);
      return false;
    }
    
    public void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      com.baidu.carlife.core.i.b("CarlifeActivity#MaskView", "onSurfaceTextureSizeChanged surface=" + paramAnonymousSurfaceTexture + ", width=" + paramAnonymousInt1 + ", height=" + paramAnonymousInt2);
    }
    
    public void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      if (f.jp <= 3) {
        com.baidu.carlife.core.i.b("CarlifeActivity#MaskView", "onSurfaceTextureUpdated , 外层");
      }
    }
  };
  private View c;
  private TextureView d;
  private k e;
  
  public j(k paramk)
  {
    this.e = paramk;
    paramk = new FrameLayout(a.a());
    this.d = new TextureView(a.a());
    ImageView localImageView = new ImageView(a.a());
    localImageView.setImageDrawable(b.b().f());
    LinearLayout localLinearLayout = new LinearLayout(a.a());
    localLinearLayout.setBackgroundColor(-16777216);
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    localLinearLayout.addView(localImageView, new ViewGroup.LayoutParams(-1, -1));
    paramk.addView(this.d, new ViewGroup.LayoutParams(-1, -1));
    paramk.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -1));
    this.c = paramk;
    if (!e.b().j())
    {
      ((ViewGroup)this.c).removeView(this.d);
      g = e.b().a();
      paramk = d.a();
      f = new com.baidu.carlife.core.screen.presentation.i(e.c(), e.d(), paramk.g(), g, 2);
      if (!c.a().l())
      {
        a();
        c.a().i(true);
      }
      return;
    }
    this.d.setSurfaceTextureListener(this.a);
  }
  
  public static void a(Surface paramSurface)
  {
    g = paramSurface;
    paramSurface = d.a();
    f = new com.baidu.carlife.core.screen.presentation.i(e.c(), e.d(), paramSurface.g(), g, 2);
  }
  
  public void a()
  {
    if (f != null) {
      this.e.a(f);
    }
  }
  
  public View b()
  {
    return this.c;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */