package com.baidu.ufosdk.util;

import android.graphics.Bitmap;
import android.os.Message;
import com.baidu.ufosdk.ui.FeedbackInputActivity;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;

final class b
  implements Runnable
{
  b(a parama, String paramString1, String paramString2, q paramq) {}
  
  public final void run()
  {
    try
    {
      Bitmap localBitmap = a.a(this.b);
      if (localBitmap != null)
      {
        a.b().put(this.c, new SoftReference(localBitmap));
        f.a().a(localBitmap, this.c);
        FeedbackInputActivity.a.add(localBitmap);
        this.d.obtainMessage(0, localBitmap).sendToTarget();
        return;
      }
      this.d.obtainMessage(0, null).sendToTarget();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      c.d(localOutOfMemoryError.toString());
      System.gc();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */