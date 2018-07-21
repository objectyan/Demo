package org.apache.http;

import java.io.IOException;

@Deprecated
public abstract interface HttpServerConnection
  extends HttpConnection
{
  public abstract void flush()
    throws IOException;
  
  public abstract void receiveRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
    throws HttpException, IOException;
  
  public abstract HttpRequest receiveRequestHeader()
    throws HttpException, IOException;
  
  public abstract void sendResponseEntity(HttpResponse paramHttpResponse)
    throws HttpException, IOException;
  
  public abstract void sendResponseHeader(HttpResponse paramHttpResponse)
    throws HttpException, IOException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/HttpServerConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */