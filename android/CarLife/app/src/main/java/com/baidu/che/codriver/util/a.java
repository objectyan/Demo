package com.baidu.che.codriver.util;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;

public class a
{
  private static ImageLoader a;
  private static a b;
  
  public static ImageLoader a()
  {
    if (a == null)
    {
      b = new a();
      a = new ImageLoader(o.a(), b);
    }
    return a;
  }
  
  public static void b()
  {
    if (b != null) {
      b.a();
    }
    a = null;
  }
  
  public static class a
    implements ImageLoader.ImageCache
  {
    private LruCache<String, Bitmap> a = new LruCache(10485760)
    {
      protected int a(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        if (paramAnonymousBitmap != null) {
          return paramAnonymousBitmap.getRowBytes() * paramAnonymousBitmap.getHeight();
        }
        return 0;
      }
    };
    
    public void a()
    {
      this.a.evictAll();
    }
    
    public Bitmap getBitmap(String paramString)
    {
      return (Bitmap)this.a.get(paramString);
    }
    
    public void putBitmap(String paramString, Bitmap paramBitmap)
    {
      this.a.put(paramString, paramBitmap);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */