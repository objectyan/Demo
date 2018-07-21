package com.baidu.tts.loopj;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;

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
  
  protected byte[] getResponseData(HttpEntity paramHttpEntity)
    throws IOException
  {
    if (paramHttpEntity != null)
    {
      InputStream localInputStream = paramHttpEntity.getContent();
      long l = paramHttpEntity.getContentLength() + this.current;
      paramHttpEntity = new FileOutputStream(getTargetFile(), this.append);
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
            paramHttpEntity.write(arrayOfByte, 0, i);
            sendProgressMessage(this.current, l);
          }
          localInputStream.close();
        }
        finally
        {
          localInputStream.close();
          paramHttpEntity.flush();
          paramHttpEntity.close();
        }
        paramHttpEntity.flush();
        paramHttpEntity.close();
      }
    }
    return null;
  }
  
  public void sendResponseMessage(HttpResponse paramHttpResponse)
    throws IOException
  {
    StatusLine localStatusLine;
    if (!Thread.currentThread().isInterrupted())
    {
      localStatusLine = paramHttpResponse.getStatusLine();
      if (localStatusLine.getStatusCode() != 416) {
        break label55;
      }
      if (!Thread.currentThread().isInterrupted()) {
        sendSuccessMessage(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), null);
      }
    }
    label55:
    do
    {
      do
      {
        return;
        if (localStatusLine.getStatusCode() < 300) {
          break;
        }
      } while (Thread.currentThread().isInterrupted());
      sendFailureMessage(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), null, new HttpResponseException(localStatusLine.getStatusCode(), localStatusLine.getReasonPhrase()));
      return;
    } while (Thread.currentThread().isInterrupted());
    Header localHeader = paramHttpResponse.getFirstHeader("Content-Range");
    if (localHeader == null)
    {
      this.append = false;
      this.current = 0L;
    }
    for (;;)
    {
      sendSuccessMessage(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), getResponseData(paramHttpResponse.getEntity()));
      return;
      AsyncHttpClient.log.v("RangeFileAsyncHttpRH", "Content-Range: " + localHeader.getValue());
    }
  }
  
  public void updateRequestHeaders(HttpUriRequest paramHttpUriRequest)
  {
    if ((this.file.exists()) && (this.file.canWrite())) {
      this.current = this.file.length();
    }
    if (this.current > 0L)
    {
      this.append = true;
      paramHttpUriRequest.setHeader("Range", "bytes=" + this.current + "-");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/loopj/RangeFileAsyncHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */