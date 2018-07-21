package com.baidu.carlife.k.a;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.android.volley.toolbox.ImageLoader.ImageCache;

public class a
  implements ImageLoader.ImageCache
{
  private LruCache<String, Bitmap> a = new LruCache((int)(Runtime.getRuntime().maxMemory() / 1024L) / 8)
  {
    protected int a(String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
      return paramAnonymousBitmap.getByteCount() / 1024;
    }
  };
  
  public Bitmap getBitmap(String paramString)
  {
    return (Bitmap)this.a.get(paramString);
  }
  
  public void putBitmap(String paramString, Bitmap paramBitmap)
  {
    this.a.put(paramString, paramBitmap);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */