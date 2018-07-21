package org.apache.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Deprecated
public abstract interface HttpEntity
{
  public abstract void consumeContent()
    throws IOException;
  
  public abstract InputStream getContent()
    throws IOException, IllegalStateException;
  
  public abstract Header getContentEncoding();
  
  public abstract long getContentLength();
  
  public abstract Header getContentType();
  
  public abstract boolean isChunked();
  
  public abstract boolean isRepeatable();
  
  public abstract boolean isStreaming();
  
  public abstract void writeTo(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/HttpEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */