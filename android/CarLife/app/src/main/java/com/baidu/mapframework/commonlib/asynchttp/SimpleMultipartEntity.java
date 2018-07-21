package com.baidu.mapframework.commonlib.asynchttp;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class SimpleMultipartEntity
  implements HttpEntity
{
  protected static final byte[] CR_LF = "\r\n".getBytes();
  protected static final String STR_CR_LF = "\r\n";
  private static final String a = "SimpleMultipartEntity";
  private static final byte[] b = "Content-Transfer-Encoding: binary\r\n".getBytes();
  private static final char[] c = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  protected final String boundary;
  protected final byte[] boundaryEnd;
  protected final byte[] boundaryLine;
  private final List<FilePart> d = new ArrayList();
  private final ResponseHandlerInterface e;
  private boolean f;
  private long g;
  private long h;
  protected final ByteArrayOutputStream out = new ByteArrayOutputStream();
  
  public SimpleMultipartEntity(ResponseHandlerInterface paramResponseHandlerInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Random localRandom = new Random();
    int i = 0;
    while (i < 30)
    {
      localStringBuilder.append(c[localRandom.nextInt(c.length)]);
      i += 1;
    }
    this.boundary = localStringBuilder.toString();
    this.boundaryLine = ("--" + this.boundary + "\r\n").getBytes();
    this.boundaryEnd = ("--" + this.boundary + "--" + "\r\n").getBytes();
    this.e = paramResponseHandlerInterface;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "application/octet-stream";
    }
    return str;
  }
  
  private void a(long paramLong)
  {
    this.g += paramLong;
    this.e.sendProgressMessage(this.g, this.h);
  }
  
  private byte[] a(String paramString1, String paramString2)
  {
    return ("Content-Disposition: form-data; name=\"" + paramString1 + "\"; filename=\"" + paramString2 + "\"" + "\r\n").getBytes();
  }
  
  private byte[] b(String paramString)
  {
    return ("Content-Type: " + a(paramString) + "\r\n").getBytes();
  }
  
  public void addPart(String paramString, File paramFile)
  {
    addPart(paramString, paramFile, null);
  }
  
  public void addPart(String paramString1, File paramFile, String paramString2)
  {
    this.d.add(new FilePart(paramString1, paramFile, a(paramString2)));
  }
  
  public void addPart(String paramString1, File paramFile, String paramString2, String paramString3)
  {
    this.d.add(new FilePart(paramString1, paramFile, a(paramString2), paramString3));
  }
  
  public void addPart(String paramString1, String paramString2)
  {
    addPartWithCharset(paramString1, paramString2, null);
  }
  
  public void addPart(String paramString1, String paramString2, InputStream paramInputStream, String paramString3)
    throws IOException
  {
    this.out.write(this.boundaryLine);
    this.out.write(a(paramString1, paramString2));
    this.out.write(b(paramString3));
    this.out.write(b);
    this.out.write(CR_LF);
    paramString1 = new byte['က'];
    for (;;)
    {
      int i = paramInputStream.read(paramString1);
      if (i == -1) {
        break;
      }
      this.out.write(paramString1, 0, i);
    }
    this.out.write(CR_LF);
    this.out.flush();
  }
  
  public void addPart(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      this.out.write(this.boundaryLine);
      this.out.write(createContentDisposition(paramString1));
      this.out.write(b(paramString3));
      this.out.write(CR_LF);
      this.out.write(paramString2.getBytes());
      this.out.write(CR_LF);
      return;
    }
    catch (IOException paramString1)
    {
      AsyncHttpClient.log.e("SimpleMultipartEntity", "addPart ByteArrayOutputStream exception", paramString1);
    }
  }
  
  public void addPartWithCharset(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString3;
    if (paramString3 == null) {
      str = "UTF-8";
    }
    addPart(paramString1, paramString2, "text/plain; charset=" + str);
  }
  
  public void consumeContent()
    throws IOException, UnsupportedOperationException
  {
    if (isStreaming()) {
      throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
    }
  }
  
  protected byte[] createContentDisposition(String paramString)
  {
    return ("Content-Disposition: form-data; name=\"" + paramString + "\"" + "\r\n").getBytes();
  }
  
  public InputStream getContent()
    throws IOException, UnsupportedOperationException
  {
    throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
  }
  
  public Header getContentEncoding()
  {
    return null;
  }
  
  public long getContentLength()
  {
    long l1 = this.out.size();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      long l2 = ((FilePart)localIterator.next()).getTotalLength();
      if (l2 < 0L) {
        return -1L;
      }
      l1 += l2;
    }
    return l1 + this.boundaryEnd.length;
  }
  
  public Header getContentType()
  {
    return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.boundary);
  }
  
  public boolean isChunked()
  {
    return false;
  }
  
  public boolean isRepeatable()
  {
    return this.f;
  }
  
  public boolean isStreaming()
  {
    return false;
  }
  
  public void setIsRepeatable(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    this.g = 0L;
    this.h = ((int)getContentLength());
    this.out.writeTo(paramOutputStream);
    a(this.out.size());
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((FilePart)localIterator.next()).writeTo(paramOutputStream);
    }
    paramOutputStream.write(this.boundaryEnd);
    a(this.boundaryEnd.length);
  }
  
  private class FilePart
  {
    public File file;
    public byte[] header;
    
    public FilePart(String paramString1, File paramFile, String paramString2)
    {
      this.header = a(paramString1, paramFile.getName(), paramString2);
      this.file = paramFile;
    }
    
    public FilePart(String paramString1, File paramFile, String paramString2, String paramString3)
    {
      this$1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        this$1 = paramFile.getName();
      }
      this.header = a(paramString1, SimpleMultipartEntity.this, paramString2);
      this.file = paramFile;
    }
    
    private byte[] a(String paramString1, String paramString2, String paramString3)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        localByteArrayOutputStream.write(SimpleMultipartEntity.this.boundaryLine);
        localByteArrayOutputStream.write(SimpleMultipartEntity.a(SimpleMultipartEntity.this, paramString1, paramString2));
        localByteArrayOutputStream.write(SimpleMultipartEntity.a(SimpleMultipartEntity.this, paramString3));
        localByteArrayOutputStream.write(SimpleMultipartEntity.a());
        localByteArrayOutputStream.write(SimpleMultipartEntity.CR_LF);
        return localByteArrayOutputStream.toByteArray();
      }
      catch (IOException paramString1)
      {
        for (;;)
        {
          AsyncHttpClient.log.e("SimpleMultipartEntity", "createHeader ByteArrayOutputStream exception", paramString1);
        }
      }
    }
    
    public long getTotalLength()
    {
      long l1 = this.file.length();
      long l2 = SimpleMultipartEntity.CR_LF.length;
      return this.header.length + (l1 + l2);
    }
    
    public void writeTo(OutputStream paramOutputStream)
      throws IOException
    {
      paramOutputStream.write(this.header);
      SimpleMultipartEntity.a(SimpleMultipartEntity.this, this.header.length);
      FileInputStream localFileInputStream = new FileInputStream(this.file);
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
        SimpleMultipartEntity.a(SimpleMultipartEntity.this, i);
      }
      paramOutputStream.write(SimpleMultipartEntity.CR_LF);
      SimpleMultipartEntity.a(SimpleMultipartEntity.this, SimpleMultipartEntity.CR_LF.length);
      paramOutputStream.flush();
      AsyncHttpClient.silentCloseInputStream(localFileInputStream);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/SimpleMultipartEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */