package org.apache.http.client.methods;

import java.io.IOException;
import java.net.URI;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.message.AbstractHttpMessage;

@Deprecated
public abstract class HttpRequestBase
  extends AbstractHttpMessage
  implements AbortableHttpRequest, HttpUriRequest
{
  public HttpRequestBase()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void abort()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    throw new RuntimeException("Stub!");
  }
  
  public abstract String getMethod();
  
  public ProtocolVersion getProtocolVersion()
  {
    throw new RuntimeException("Stub!");
  }
  
  public RequestLine getRequestLine()
  {
    throw new RuntimeException("Stub!");
  }
  
  public URI getURI()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isAborted()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setConnectionRequest(ClientConnectionRequest paramClientConnectionRequest)
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setReleaseTrigger(ConnectionReleaseTrigger paramConnectionReleaseTrigger)
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setURI(URI paramURI)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/client/methods/HttpRequestBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */