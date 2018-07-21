package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.l.j;

public abstract interface t
{
  public abstract void addHeader(f paramf);
  
  public abstract void addHeader(String paramString1, String paramString2);
  
  public abstract boolean containsHeader(String paramString);
  
  public abstract f[] getAllHeaders();
  
  public abstract f getFirstHeader(String paramString);
  
  public abstract f[] getHeaders(String paramString);
  
  public abstract f getLastHeader(String paramString);
  
  @Deprecated
  public abstract j getParams();
  
  public abstract ak getProtocolVersion();
  
  public abstract i headerIterator();
  
  public abstract i headerIterator(String paramString);
  
  public abstract void removeHeader(f paramf);
  
  public abstract void removeHeaders(String paramString);
  
  public abstract void setHeader(f paramf);
  
  public abstract void setHeader(String paramString1, String paramString2);
  
  public abstract void setHeaders(f[] paramArrayOff);
  
  @Deprecated
  public abstract void setParams(j paramj);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */