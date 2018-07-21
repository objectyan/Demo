package org.apache.http.cookie;

import java.util.Date;

@Deprecated
public abstract interface Cookie
{
  public abstract String getComment();
  
  public abstract String getCommentURL();
  
  public abstract String getDomain();
  
  public abstract Date getExpiryDate();
  
  public abstract String getName();
  
  public abstract String getPath();
  
  public abstract int[] getPorts();
  
  public abstract String getValue();
  
  public abstract int getVersion();
  
  public abstract boolean isExpired(Date paramDate);
  
  public abstract boolean isPersistent();
  
  public abstract boolean isSecure();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/cookie/Cookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */