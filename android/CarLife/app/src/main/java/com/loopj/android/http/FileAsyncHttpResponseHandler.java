package com.loopj.android.http;

import android.content.Context;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.n;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public abstract class FileAsyncHttpResponseHandler
  extends AsyncHttpResponseHandler
{
  private static final String LOG_TAG = "FileAsyncHttpRH";
  protected final boolean append;
  protected final File file;
  protected File frontendFile;
  protected final boolean renameIfExists;
  
  public FileAsyncHttpResponseHandler(Context paramContext)
  {
    this.file = getTemporaryFile(paramContext);
    this.append = false;
    this.renameIfExists = false;
  }
  
  public FileAsyncHttpResponseHandler(File paramFile)
  {
    this(paramFile, false);
  }
  
  public FileAsyncHttpResponseHandler(File paramFile, boolean paramBoolean)
  {
    this(paramFile, paramBoolean, false);
  }
  
  public FileAsyncHttpResponseHandler(File paramFile, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramFile, paramBoolean1, paramBoolean2, false);
  }
  
  public FileAsyncHttpResponseHandler(File paramFile, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramBoolean3);
    if (paramFile != null) {}
    for (paramBoolean3 = true;; paramBoolean3 = false)
    {
      Utils.asserts(paramBoolean3, "File passed into FileAsyncHttpResponseHandler constructor must not be null");
      if ((!paramFile.isDirectory()) && (!paramFile.getParentFile().isDirectory())) {
        Utils.asserts(paramFile.getParentFile().mkdirs(), "Cannot create parent directories for requested File location");
      }
      if ((paramFile.isDirectory()) && (!paramFile.mkdirs())) {
        AsyncHttpClient.log.d("FileAsyncHttpRH", "Cannot create directories for requested Directory location, might not be a problem");
      }
      this.file = paramFile;
      this.append = paramBoolean1;
      this.renameIfExists = paramBoolean2;
      return;
    }
  }
  
  public boolean deleteTargetFile()
  {
    return (getTargetFile() != null) && (getTargetFile().delete());
  }
  
  protected File getOriginalFile()
  {
    if (this.file != null) {}
    for (boolean bool = true;; bool = false)
    {
      Utils.asserts(bool, "Target file is null, fatal!");
      return this.file;
    }
  }
  
  protected byte[] getResponseData(n paramn)
    throws IOException
  {
    if (paramn != null)
    {
      InputStream localInputStream = paramn.getContent();
      long l = paramn.getContentLength();
      paramn = new FileOutputStream(getTargetFile(), this.append);
      if (localInputStream != null)
      {
        try
        {
          byte[] arrayOfByte = new byte['က'];
          int i = 0;
          for (;;)
          {
            int j = localInputStream.read(arrayOfByte);
            if ((j == -1) || (Thread.currentThread().isInterrupted())) {
              break;
            }
            i += j;
            paramn.write(arrayOfByte, 0, j);
            sendProgressMessage(i, l);
          }
          AsyncHttpClient.silentCloseInputStream(localInputStream);
        }
        finally
        {
          AsyncHttpClient.silentCloseInputStream(localInputStream);
          paramn.flush();
          AsyncHttpClient.silentCloseOutputStream(paramn);
        }
        paramn.flush();
        AsyncHttpClient.silentCloseOutputStream(paramn);
      }
    }
    return null;
  }
  
  public File getTargetFile()
  {
    if (this.frontendFile == null) {
      if (!getOriginalFile().isDirectory()) {
        break label32;
      }
    }
    label32:
    for (File localFile = getTargetFileByParsingURL();; localFile = getOriginalFile())
    {
      this.frontendFile = localFile;
      return this.frontendFile;
    }
  }
  
  protected File getTargetFileByParsingURL()
  {
    Utils.asserts(getOriginalFile().isDirectory(), "Target file is not a directory, cannot proceed");
    boolean bool;
    String str;
    File localFile;
    label110:
    int i;
    if (getRequestURI() != null)
    {
      bool = true;
      Utils.asserts(bool, "RequestURI is null, cannot proceed");
      str = getRequestURI().toString();
      str = str.substring(str.lastIndexOf('/') + 1, str.length());
      localFile = new File(getOriginalFile(), str);
      if ((!localFile.exists()) || (!this.renameIfExists)) {
        break label213;
      }
      if (str.contains(".")) {
        break label156;
      }
      str = str + " (%d)";
      i = 0;
    }
    for (;;)
    {
      localFile = new File(getOriginalFile(), String.format(str, new Object[] { Integer.valueOf(i) }));
      if (!localFile.exists())
      {
        return localFile;
        bool = false;
        break;
        label156:
        str = str.substring(0, str.lastIndexOf('.')) + " (%d)" + str.substring(str.lastIndexOf('.'), str.length());
        break label110;
      }
      i += 1;
    }
    label213:
    return localFile;
  }
  
  protected File getTemporaryFile(Context paramContext)
  {
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Utils.asserts(bool, "Tried creating temporary file without having Context");
      try
      {
        paramContext = File.createTempFile("temp_", "_handled", paramContext.getCacheDir());
        return paramContext;
      }
      catch (IOException paramContext)
      {
        AsyncHttpClient.log.e("FileAsyncHttpRH", "Cannot create temporary file", paramContext);
      }
    }
    return null;
  }
  
  public abstract void onFailure(int paramInt, f[] paramArrayOff, Throwable paramThrowable, File paramFile);
  
  public final void onFailure(int paramInt, f[] paramArrayOff, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    onFailure(paramInt, paramArrayOff, paramThrowable, getTargetFile());
  }
  
  public abstract void onSuccess(int paramInt, f[] paramArrayOff, File paramFile);
  
  public final void onSuccess(int paramInt, f[] paramArrayOff, byte[] paramArrayOfByte)
  {
    onSuccess(paramInt, paramArrayOff, getTargetFile());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/FileAsyncHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */