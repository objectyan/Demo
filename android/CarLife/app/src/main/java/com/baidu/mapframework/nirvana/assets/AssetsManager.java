package com.baidu.mapframework.nirvana.assets;

import android.content.Context;
import android.content.res.AssetManager;
import com.baidu.mapframework.nirvana.b;
import com.baidu.mapframework.nirvana.b.a;
import com.baidu.mapframework.nirvana.b.c;
import com.baidu.mapframework.nirvana.e;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.n;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.io.IOException;
import java.io.InputStream;
import org.jetbrains.annotations.NotNull;

public class AssetsManager
{
  private static void b(@NotNull AssetsTask paramAssetsTask)
  {
    e.b().b(paramAssetsTask);
  }
  
  public static void open(@NotNull Module paramModule, @NotNull final AssetsTask paramAssetsTask, @NotNull ScheduleConfig paramScheduleConfig)
  {
    if (!n.a(paramModule, paramAssetsTask, paramScheduleConfig)) {
      return;
    }
    e.b().a(c.a, paramAssetsTask, paramModule, paramScheduleConfig);
    e.b().a(paramAssetsTask);
    try
    {
      paramAssetsTask.a(new InputStream()
      {
        public int available()
          throws IOException
        {
          return this.a.available();
        }
        
        public void close()
          throws IOException
        {
          AssetsManager.a(paramAssetsTask);
          this.a.close();
        }
        
        public void mark(int paramAnonymousInt)
        {
          this.a.mark(paramAnonymousInt);
        }
        
        public boolean markSupported()
        {
          return this.a.markSupported();
        }
        
        public int read()
          throws IOException
        {
          return this.a.read();
        }
        
        public int read(byte[] paramAnonymousArrayOfByte)
          throws IOException
        {
          return this.a.read(paramAnonymousArrayOfByte);
        }
        
        public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
          throws IOException
        {
          return this.a.read(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        }
        
        public void reset()
          throws IOException
        {
          try
          {
            this.a.reset();
            return;
          }
          finally
          {
            localObject = finally;
            throw ((Throwable)localObject);
          }
        }
        
        public long skip(long paramAnonymousLong)
          throws IOException
        {
          return this.a.skip(paramAnonymousLong);
        }
      });
      return;
    }
    catch (Exception paramModule)
    {
      paramAssetsTask = paramAssetsTask.getExceptionCallback();
      if (paramAssetsTask != null)
      {
        paramAssetsTask.a(paramModule);
        return;
      }
      e.a("AssetsManager", paramModule);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/assets/AssetsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */