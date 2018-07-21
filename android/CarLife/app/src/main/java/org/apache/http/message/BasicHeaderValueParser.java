package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public class BasicHeaderValueParser
  implements HeaderValueParser
{
  public static final BasicHeaderValueParser DEFAULT = null;
  
  public BasicHeaderValueParser()
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final HeaderElement[] parseElements(String paramString, HeaderValueParser paramHeaderValueParser)
    throws ParseException
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final HeaderElement parseHeaderElement(String paramString, HeaderValueParser paramHeaderValueParser)
    throws ParseException
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final NameValuePair parseNameValuePair(String paramString, HeaderValueParser paramHeaderValueParser)
    throws ParseException
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final NameValuePair[] parseParameters(String paramString, HeaderValueParser paramHeaderValueParser)
    throws ParseException
  {
    throw new RuntimeException("Stub!");
  }
  
  protected HeaderElement createHeaderElement(String paramString1, String paramString2, NameValuePair[] paramArrayOfNameValuePair)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected NameValuePair createNameValuePair(String paramString1, String paramString2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public HeaderElement[] parseElements(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor)
  {
    throw new RuntimeException("Stub!");
  }
  
  public HeaderElement parseHeaderElement(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor)
  {
    throw new RuntimeException("Stub!");
  }
  
  public NameValuePair parseNameValuePair(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor)
  {
    throw new RuntimeException("Stub!");
  }
  
  public NameValuePair parseNameValuePair(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor, char[] paramArrayOfChar)
  {
    throw new RuntimeException("Stub!");
  }
  
  public NameValuePair[] parseParameters(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/message/BasicHeaderValueParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */