package com.baidu.mobstat;

import android.content.Context;
import java.io.File;
import java.util.Arrays;

class cc
  implements Runnable
{
  cc(by paramby, Context paramContext) {}
  
  public void run()
  {
    for (;;)
    {
      int j;
      try
      {
        Object localObject = this.a.getFilesDir();
        if (localObject == null) {
          break label167;
        }
        if (!((File)localObject).exists()) {
          return;
        }
        localObject = ((File)localObject).list(new cd(this));
        if (localObject == null) {
          break label167;
        }
        i = localObject.length;
        if (i == 0) {
          break label167;
        }
        String str2;
        try
        {
          Arrays.sort((Object[])localObject, new ce(this));
          int m = localObject.length;
          j = 0;
          i = 0;
          if (j >= m) {
            break label167;
          }
          String str1 = localObject[j];
          str2 = cu.a(this.a, str1);
          if (by.a(this.b, this.a, str2))
          {
            cu.b(this.a, str1);
            i = 0;
          }
        }
        catch (Exception localException2)
        {
          db.b(localException2);
          continue;
        }
        by.a(this.a, localException2, str2);
      }
      catch (Exception localException1)
      {
        db.b(localException1);
        return;
      }
      int k = i + 1;
      int i = k;
      if (k >= 5) {
        label167:
        return;
      }
      j += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */