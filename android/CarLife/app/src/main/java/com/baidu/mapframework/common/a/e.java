package com.baidu.mapframework.common.a;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class e
  implements a
{
  private final File a;
  private boolean b;
  private FileOutputStream c;
  
  e(File paramFile)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("The file appender root path is null!");
    }
    if ((!paramFile.exists()) && (!paramFile.mkdirs())) {
      this.b = false;
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException("The file appender root path is not a directory!");
    }
    this.a = new File(paramFile, "ui_" + System.currentTimeMillis() + ".log");
    try
    {
      this.b = this.a.exists();
      if (!this.b)
      {
        this.b = this.a.createNewFile();
        if (this.b) {
          this.c = new FileOutputStream(this.a, true);
        }
      }
      return;
    }
    catch (IOException paramFile)
    {
      this.b = false;
    }
  }
  
  private byte[] b(i parami)
    throws UnsupportedEncodingException
  {
    return String.format(Locale.getDefault(), "[%d] [%s] [%s] [%s] [%s] [%s]\n", new Object[] { Long.valueOf(parami.d), parami.a.format(new Date(parami.d)), parami.c, parami.b, parami.f, parami.e }).getBytes("UTF-8");
  }
  
  public void a()
  {
    try
    {
      if (this.c != null) {
        this.c.close();
      }
      this.b = false;
      return;
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      this.b = false;
      return;
    }
    finally
    {
      localObject = finally;
      this.b = false;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(i parami)
  {
    if (!this.b) {
      return;
    }
    try
    {
      if (this.c == null) {
        this.c = new FileOutputStream(this.a, true);
      }
      FileLock localFileLock = this.c.getChannel().lock();
      parami = b(parami);
      this.c.write(parami);
      this.c.flush();
      localFileLock.release();
      return;
    }
    catch (IOException parami) {}
  }
  
  public a.a b()
  {
    return a.a.c;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/common/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */