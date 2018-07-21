package com.baidu.carlife.core.screen.presentation;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.baidu.carlife.core.d;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.h;
import com.baidu.carlife.core.screen.k;
import com.baidu.carlife.core.screen.video.e;

@TargetApi(17)
public class a
  extends Presentation
  implements h
{
  public static String a = "CarlifeFakePresentation";
  protected k b;
  protected TextureView c;
  TextureView.SurfaceTextureListener d = new TextureView.SurfaceTextureListener()
  {
    public void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      com.baidu.carlife.core.i.b(a.a, "onSurfaceTextureAvailable, SurfaceTexture = " + paramAnonymousSurfaceTexture.toString());
      com.baidu.carlife.core.i.b(a.a, "width = " + paramAnonymousInt1 + ", height = " + paramAnonymousInt2);
      paramAnonymousSurfaceTexture = new Surface(paramAnonymousSurfaceTexture);
      d locald = d.a();
      paramAnonymousSurfaceTexture = new i(locald.h(), locald.i(), locald.g(), paramAnonymousSurfaceTexture, 2);
      a.this.a(paramAnonymousSurfaceTexture);
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
    {
      com.baidu.carlife.core.i.b(a.a, "onSurfaceTextureDestroyed, SurfaceTexture = " + paramAnonymousSurfaceTexture.toString());
      return true;
    }
    
    public void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      com.baidu.carlife.core.i.b(a.a, "onSurfaceTextureSizeChanged, SurfaceTexture = " + paramAnonymousSurfaceTexture.toString());
    }
    
    public void onSurfaceTextureUpdated(SurfaceTexture arg1)
    {
      if ((f.jp > 3) || (!a.a(a.this).j())) {}
      long l1;
      for (;;)
      {
        l1 = System.currentTimeMillis();
        long l2 = a.b(a.this);
        l1 = e.e - (l1 - l2);
        a.a(a.this, System.currentTimeMillis());
        if ((l1 <= 0L) || (l1 >= 500L))
        {
          return;
          synchronized (a.a(a.this).f)
          {
            a.this.c.getBitmap(a.a(a.this).f);
          }
        }
      }
      try
      {
        Thread.sleep(l1);
        return;
      }
      catch (InterruptedException ???)
      {
        ???.printStackTrace();
      }
    }
  };
  private long e = 0L;
  private e f;
  
  public a(Context paramContext, Display paramDisplay, k paramk)
  {
    super(paramContext, paramDisplay);
    this.b = paramk;
    a();
    this.f = e.b();
  }
  
  private void a()
  {
    Window localWindow = getWindow();
    localWindow.setType(2030);
    localWindow.addFlags(268435456);
    localWindow.addFlags(16777216);
    localWindow.addFlags(1024);
  }
  
  protected void a(i parami)
  {
    if (this.b != null) {
      this.b.a(parami);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = new TextureView(getContext());
    paramBundle = new FrameLayout(getContext());
    paramBundle.addView(this.c, new FrameLayout.LayoutParams(-1, -1));
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    setContentView(paramBundle, (ViewGroup.LayoutParams)localObject);
    if (this.f.j())
    {
      this.c.setSurfaceTextureListener(this.d);
      return;
    }
    paramBundle = d.a();
    float f1 = 0.0F;
    float f2 = 0.0F;
    if (paramBundle.h() != 0) {
      f1 = e.c() * 1.0F / paramBundle.h();
    }
    if (paramBundle.i() != 0) {
      f2 = e.d() * 1.0F / paramBundle.i();
    }
    this.c.setScaleX(f1);
    this.c.setScaleY(f2);
    localObject = (ViewGroup)this.c.getParent();
    ViewGroup.LayoutParams localLayoutParams = ((ViewGroup)localObject).getLayoutParams();
    localLayoutParams.width = paramBundle.h();
    localLayoutParams.height = paramBundle.i();
    ((ViewGroup)localObject).setLayoutParams(localLayoutParams);
    ((ViewGroup)localObject).invalidate();
    this.c.setSurfaceTextureListener(this.d);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */