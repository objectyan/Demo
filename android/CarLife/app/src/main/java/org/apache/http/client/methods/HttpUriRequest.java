package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.HttpRequest;

@Deprecated
public abstract interface HttpUriRequest
  extends HttpRequest
{
  public abstract void abort()
    throws UnsupportedOperationException;
  
  public abstract String getMethod();
  
  public abstract URI getURI();
  
  public abstract boolean isAborted();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/client/methods/HttpUriRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */