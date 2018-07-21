package com.loopj.android.http;

import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.b.l;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class RangeFileAsyncHttpResponseHandler
  extends FileAsyncHttpResponseHandler
{
  private static final String LOG_TAG = "RangeFileAsyncHttpRH";
  private boolean append = false;
  private long current = 0L;
  
  public RangeFileAsyncHttpResponseHandler(File paramFile)
  {
    super(paramFile);
  }
  
  protected byte[] getResponseData(n paramn)
    throws IOException
  {
    if (paramn != null)
    {
      InputStream localInputStream = paramn.getContent();
      long l = paramn.getContentLength() + this.current;
      paramn = new FileOutputStream(getTargetFile(), this.append);
      if (localInputStream != null)
      {
        try
        {
          byte[] arrayOfByte = new byte['က'];
          while (this.current < l)
          {
            int i = localInputStream.read(arrayOfByte);
            if ((i == -1) || (Thread.currentThread().isInterrupted())) {
              break;
            }
            this.current += i;
            paramn.write(arrayOfByte, 0, i);
            sendProgressMessage(this.current, l);
          }
          localInputStream.close();
        }
        finally
        {
          localInputStream.close();
          paramn.flush();
          paramn.close();
        }
        paramn.flush();
        paramn.close();
      }
    }
    return null;
  }
  
  public void sendResponseMessage(x paramx)
    throws IOException
  {
    an localan;
    if (!Thread.currentThread().isInterrupted())
    {
      localan = paramx.a();
      if (localan.b() != 416) {
        break label55;
      }
      if (!Thread.currentThread().isInterrupted()) {
        sendSuccessMessage(localan.b(), paramx.getAllHeaders(), null);
      }
    }
    label55:
    do
    {
      do
      {
        return;
        if (localan.b() < 300) {
          break;
        }
      } while (Thread.currentThread().isInterrupted());
      sendFailureMessage(localan.b(), paramx.getAllHeaders(), null, new l(localan.b(), localan.c()));
      return;
    } while (Thread.currentThread().isInterrupted());
    f localf = paramx.getFirstHeader("Content-Range");
    if (localf == null)
    {
      this.append = false;
      this.current = 0L;
    }
    for (;;)
    {
      sendSuccessMessage(localan.b(), paramx.getAllHeaders(), getResponseData(paramx.b()));
      return;
      AsyncHttpClient.log.v("RangeFileAsyncHttpRH", "Content-Range: " + localf.d());
    }
  }
  
  public void updateRequestHeaders(q paramq)
  {
    if ((this.file.exists()) && (this.file.canWrite())) {
      this.current = this.file.length();
    }
    if (this.current > 0L)
    {
      this.append = true;
      paramq.setHeader("Range", "bytes=" + this.current + "-");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/RangeFileAsyncHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */