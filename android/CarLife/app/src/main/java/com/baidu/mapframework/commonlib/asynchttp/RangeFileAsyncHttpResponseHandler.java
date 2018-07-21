package com.baidu.mapframework.commonlib.asynchttp;

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
  private static final String a = "RangeFileAsyncHttpRH";
  private long b = 0L;
  private boolean c = false;
  
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
      long l = paramHttpEntity.getContentLength() + this.b;
      paramHttpEntity = new FileOutputStream(getTargetFile(), this.c);
      if (localInputStream != null)
      {
        try
        {
          byte[] arrayOfByte = new byte['က'];
          while (this.b < l)
          {
            int i = localInputStream.read(arrayOfByte);
            if ((i == -1) || (Thread.currentThread().isInterrupted())) {
              break;
            }
            this.b += i;
            paramHttpEntity.write(arrayOfByte, 0, i);
            sendProgressMessage(this.b, l);
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
      this.c = false;
      this.b = 0L;
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
      this.b = this.file.length();
    }
    if (this.b > 0L)
    {
      this.c = true;
      paramHttpUriRequest.setHeader("Range", "bytes=" + this.b + "-");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/RangeFileAsyncHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */