package com.android.internal.http.multipart;

import java.io.IOException;
import java.io.OutputStream;

public class StringPart
  extends PartBase
{
  public static final String DEFAULT_CHARSET = "US-ASCII";
  public static final String DEFAULT_CONTENT_TYPE = "text/plain";
  public static final String DEFAULT_TRANSFER_ENCODING = "8bit";
  
  public StringPart(String paramString1, String paramString2)
  {
    super((String)null, (String)null, (String)null, (String)null);
    throw new RuntimeException("Stub!");
  }
  
  public StringPart(String paramString1, String paramString2, String paramString3)
  {
    super((String)null, (String)null, (String)null, (String)null);
    throw new RuntimeException("Stub!");
  }
  
  protected long lengthOfData()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void sendData(OutputStream paramOutputStream)
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setCharSet(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/android/internal/http/multipart/StringPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */