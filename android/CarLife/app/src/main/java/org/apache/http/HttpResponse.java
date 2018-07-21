package org.apache.http;

import java.util.Locale;

@Deprecated
public abstract interface HttpResponse
  extends HttpMessage
{
  public abstract HttpEntity getEntity();
  
  public abstract Locale getLocale();
  
  public abstract StatusLine getStatusLine();
  
  public abstract void setEntity(HttpEntity paramHttpEntity);
  
  public abstract void setLocale(Locale paramLocale);
  
  public abstract void setReasonPhrase(String paramString)
    throws IllegalStateException;
  
  public abstract void setStatusCode(int paramInt)
    throws IllegalStateException;
  
  public abstract void setStatusLine(ProtocolVersion paramProtocolVersion, int paramInt);
  
  public abstract void setStatusLine(ProtocolVersion paramProtocolVersion, int paramInt, String paramString);
  
  public abstract void setStatusLine(StatusLine paramStatusLine);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/HttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */