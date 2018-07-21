package org.apache.http.message;

import org.apache.http.FormattedHeader;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public class BufferedHeader
  implements FormattedHeader
{
  public BufferedHeader(CharArrayBuffer paramCharArrayBuffer)
    throws ParseException
  {
    throw new RuntimeException("Stub!");
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    throw new RuntimeException("Stub!");
  }
  
  public CharArrayBuffer getBuffer()
  {
    throw new RuntimeException("Stub!");
  }
  
  public HeaderElement[] getElements()
    throws ParseException
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getName()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getValue()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getValuePos()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String toString()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/message/BufferedHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */