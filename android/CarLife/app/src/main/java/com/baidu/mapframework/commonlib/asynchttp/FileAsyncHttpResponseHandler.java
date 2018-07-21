package com.baidu.mapframework.commonlib.asynchttp;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

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
    if (paramFile != null) {}
    for (boolean bool = true;; bool = false)
    {
      Utils.asserts(bool, "File passed into FileAsyncHttpResponseHandler constructor must not be null");
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
  
  protected byte[] getResponseData(HttpEntity paramHttpEntity)
    throws IOException
  {
    if (paramHttpEntity != null)
    {
      InputStream localInputStream = paramHttpEntity.getContent();
      long l = paramHttpEntity.getContentLength();
      paramHttpEntity = new FileOutputStream(getTargetFile(), this.append);
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
            paramHttpEntity.write(arrayOfByte, 0, j);
            sendProgressMessage(i, l);
          }
          AsyncHttpClient.silentCloseInputStream(localInputStream);
        }
        finally
        {
          AsyncHttpClient.silentCloseInputStream(localInputStream);
          paramHttpEntity.flush();
          AsyncHttpClient.silentCloseOutputStream(paramHttpEntity);
        }
        paramHttpEntity.flush();
        AsyncHttpClient.silentCloseOutputStream(paramHttpEntity);
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
      if (str.contains("build/intermediates/exploded-aar/com.baidu.baidumap/map-basic-libs/1.0.0/res")) {
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
  
  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, File paramFile);
  
  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    onFailure(paramInt, paramArrayOfHeader, paramThrowable, getTargetFile());
  }
  
  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, File paramFile);
  
  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    onSuccess(paramInt, paramArrayOfHeader, getTargetFile());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/FileAsyncHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */