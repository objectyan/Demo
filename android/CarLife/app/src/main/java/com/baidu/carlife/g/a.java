package com.baidu.carlife.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.baidu.carlife.c.d.a;
import com.baidu.carlife.c.f;
import com.baidu.carlife.core.k;
import com.baidu.carlife.model.MusicSongModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.f.g;
import java.util.concurrent.Executor;

public class a
{
  private static final int a = 1920;
  private static final int b = 1080;
  
  public static com.facebook.drawee.c.a a(SimpleDraweeView paramSimpleDraweeView, String paramString, int paramInt1, int paramInt2)
  {
    paramString = com.facebook.imagepipeline.m.d.a(Uri.parse(paramString)).a(new com.facebook.imagepipeline.e.d(paramInt1, paramInt2)).m();
    return ((com.facebook.drawee.a.a.d)((com.facebook.drawee.a.a.d)com.facebook.drawee.a.a.b.b().a(paramSimpleDraweeView.getController())).b(paramString)).q();
  }
  
  public static void a(Uri paramUri, Context paramContext)
  {
    a(paramUri, new a(paramContext), 1920, 1080);
  }
  
  private static void a(Uri paramUri, com.facebook.imagepipeline.g.b paramb, int paramInt1, int paramInt2)
  {
    paramUri = com.facebook.imagepipeline.m.d.a(paramUri).a(new com.facebook.imagepipeline.e.d(paramInt1, paramInt2)).m();
    ((com.facebook.drawee.a.a.d)com.facebook.drawee.a.a.b.b().b(paramUri)).q();
    com.facebook.drawee.a.a.b.d().c(paramUri, com.baidu.carlife.core.a.a()).a(paramb, new Executor()
    {
      public void execute(@NonNull Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable.run();
      }
    });
  }
  
  public static void a(MusicSongModel paramMusicSongModel, int paramInt1, int paramInt2)
  {
    if (paramMusicSongModel.g != null) {
      a(Uri.parse(paramMusicSongModel.g), new c(paramMusicSongModel), paramInt1, paramInt2);
    }
  }
  
  private static final class a
    extends com.facebook.imagepipeline.g.b
  {
    private static final int a = -1509949440;
    private Context b;
    
    public a(Context paramContext)
    {
      this.b = paramContext;
    }
    
    protected void a(Bitmap paramBitmap)
    {
      f.a().a(new a.b(this.b), paramBitmap, new d.a()
      {
        public void a() {}
        
        public void a(Bitmap paramAnonymousBitmap)
        {
          paramAnonymousBitmap = new com.facebook.drawee.e.b(a.a.a(a.a.this).getResources()).e(new BitmapDrawable(a.a.a(a.a.this).getResources(), paramAnonymousBitmap)).f(new ColorDrawable(-1509949440)).u();
          k.a(427);
          k.a(427, paramAnonymousBitmap.a());
        }
        
        public void b() {}
      });
    }
    
    protected void a(com.facebook.c.d<com.facebook.common.h.a<com.facebook.imagepipeline.i.b>> paramd) {}
  }
  
  private static final class b
    extends com.baidu.carlife.c.d<Bitmap, Bitmap>
  {
    private static final int a = 5;
    private Context b;
    
    public b(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public void a(Bitmap paramBitmap)
    {
      if (Build.VERSION.SDK_INT >= 17) {}
      for (paramBitmap = com.baidu.carlife.logic.music.d.a(this.b, paramBitmap, 5);; paramBitmap = com.baidu.carlife.logic.music.d.a(paramBitmap, 5))
      {
        a().a(paramBitmap);
        return;
      }
    }
  }
  
  private static final class c
    extends com.facebook.imagepipeline.g.b
  {
    private MusicSongModel a;
    
    public c(MusicSongModel paramMusicSongModel)
    {
      this.a = paramMusicSongModel;
    }
    
    public void a(Bitmap paramBitmap)
    {
      if (paramBitmap != null)
      {
        this.a.h = paramBitmap;
        k.a(219, this.a.h);
      }
      if (com.baidu.carlife.l.a.a().N()) {
        k.b(407);
      }
    }
    
    public void a(com.facebook.c.d paramd)
    {
      k.b(407);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */