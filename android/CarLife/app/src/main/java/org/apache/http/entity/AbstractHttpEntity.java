package org.apache.http.entity;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

@Deprecated
public abstract class AbstractHttpEntity
  implements HttpEntity
{
  protected boolean chunked;
  protected Header contentEncoding;
  protected Header contentType;
  
  protected AbstractHttpEntity()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void consumeContent()
    throws IOException, UnsupportedOperationException
  {
    throw new RuntimeException("Stub!");
  }
  
  public Header getContentEncoding()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Header getContentType()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isChunked()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setChunked(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setContentEncoding(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setContentEncoding(Header paramHeader)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setContentType(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setContentType(Header paramHeader)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/entity/AbstractHttpEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */