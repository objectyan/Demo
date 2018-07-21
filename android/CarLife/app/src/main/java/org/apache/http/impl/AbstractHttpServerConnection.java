package org.apache.http.impl;

import java.io.IOException;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.impl.entity.EntityDeserializer;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

@Deprecated
public abstract class AbstractHttpServerConnection
  implements HttpServerConnection
{
  public AbstractHttpServerConnection()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected abstract void assertOpen()
    throws IllegalStateException;
  
  protected EntityDeserializer createEntityDeserializer()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected EntitySerializer createEntitySerializer()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected HttpRequestFactory createHttpRequestFactory()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected HttpMessageParser createRequestParser(SessionInputBuffer paramSessionInputBuffer, HttpRequestFactory paramHttpRequestFactory, HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected HttpMessageWriter createResponseWriter(SessionOutputBuffer paramSessionOutputBuffer, HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void doFlush()
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  public void flush()
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpConnectionMetrics getMetrics()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void init(SessionInputBuffer paramSessionInputBuffer, SessionOutputBuffer paramSessionOutputBuffer, HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isStale()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void receiveRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
    throws HttpException, IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  public HttpRequest receiveRequestHeader()
    throws HttpException, IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  public void sendResponseEntity(HttpResponse paramHttpResponse)
    throws HttpException, IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  public void sendResponseHeader(HttpResponse paramHttpResponse)
    throws HttpException, IOException
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/impl/AbstractHttpServerConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */