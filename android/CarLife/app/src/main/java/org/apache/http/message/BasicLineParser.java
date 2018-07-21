package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public class BasicLineParser
  implements LineParser
{
  public static final BasicLineParser DEFAULT = null;
  protected final ProtocolVersion protocol;
  
  public BasicLineParser()
  {
    throw new RuntimeException("Stub!");
  }
  
  public BasicLineParser(ProtocolVersion paramProtocolVersion)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final Header parseHeader(String paramString, LineParser paramLineParser)
    throws ParseException
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final ProtocolVersion parseProtocolVersion(String paramString, LineParser paramLineParser)
    throws ParseException
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final RequestLine parseRequestLine(String paramString, LineParser paramLineParser)
    throws ParseException
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final StatusLine parseStatusLine(String paramString, LineParser paramLineParser)
    throws ParseException
  {
    throw new RuntimeException("Stub!");
  }
  
  protected ProtocolVersion createProtocolVersion(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected RequestLine createRequestLine(String paramString1, String paramString2, ProtocolVersion paramProtocolVersion)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected StatusLine createStatusLine(ProtocolVersion paramProtocolVersion, int paramInt, String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean hasProtocolVersion(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor)
  {
    throw new RuntimeException("Stub!");
  }
  
  public Header parseHeader(CharArrayBuffer paramCharArrayBuffer)
    throws ParseException
  {
    throw new RuntimeException("Stub!");
  }
  
  public ProtocolVersion parseProtocolVersion(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor)
    throws ParseException
  {
    throw new RuntimeException("Stub!");
  }
  
  public RequestLine parseRequestLine(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor)
    throws ParseException
  {
    throw new RuntimeException("Stub!");
  }
  
  public StatusLine parseStatusLine(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor)
    throws ParseException
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void skipWhitespace(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/apache/http/message/BasicLineParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */