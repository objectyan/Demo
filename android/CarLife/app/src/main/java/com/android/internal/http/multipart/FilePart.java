package com.android.internal.http.multipart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class FilePart
  extends PartBase
{
  public static final String DEFAULT_CHARSET = "ISO-8859-1";
  public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
  public static final String DEFAULT_TRANSFER_ENCODING = "binary";
  protected static final String FILE_NAME = "; filename=";
  
  public FilePart(String paramString, PartSource paramPartSource)
  {
    super((String)null, (String)null, (String)null, (String)null);
    throw new RuntimeException("Stub!");
  }
  
  public FilePart(String paramString1, PartSource paramPartSource, String paramString2, String paramString3)
  {
    super((String)null, (String)null, (String)null, (String)null);
    throw new RuntimeException("Stub!");
  }
  
  public FilePart(String paramString, File paramFile)
    throws FileNotFoundException
  {
    super((String)null, (String)null, (String)null, (String)null);
    throw new RuntimeException("Stub!");
  }
  
  public FilePart(String paramString1, File paramFile, String paramString2, String paramString3)
    throws FileNotFoundException
  {
    super((String)null, (String)null, (String)null, (String)null);
    throw new RuntimeException("Stub!");
  }
  
  public FilePart(String paramString1, String paramString2, File paramFile)
    throws FileNotFoundException
  {
    super((String)null, (String)null, (String)null, (String)null);
    throw new RuntimeException("Stub!");
  }
  
  public FilePart(String paramString1, String paramString2, File paramFile, String paramString3, String paramString4)
    throws FileNotFoundException
  {
    super((String)null, (String)null, (String)null, (String)null);
    throw new RuntimeException("Stub!");
  }
  
  protected PartSource getSource()
  {
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
  
  protected void sendDispositionHeader(OutputStream paramOutputStream)
    throws IOException
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/android/internal/http/multipart/FilePart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */