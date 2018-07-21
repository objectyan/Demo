package com.baidu.carlife.k.a;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

public class b
  implements HttpEntity
{
  private static final char[] d = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  ByteArrayOutputStream a = new ByteArrayOutputStream();
  boolean b = false;
  boolean c = false;
  private String e = null;
  
  public b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Random localRandom = new Random();
    int i = 0;
    while (i < 30)
    {
      localStringBuffer.append(d[localRandom.nextInt(d.length)]);
      i += 1;
    }
    this.e = localStringBuffer.toString();
  }
  
  public void a()
  {
    if (!this.c) {}
    try
    {
      this.a.write(("--" + this.e + "\r\n").getBytes());
      this.c = true;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, File paramFile, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramFile == null)) {
      return;
    }
    try
    {
      a(paramString, paramFile.getName(), new FileInputStream(paramFile), paramBoolean);
      return;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    a();
    try
    {
      this.a.write(("Content-Disposition: form-data; name=\"" + paramString1 + "\"\r\n\r\n").getBytes());
      this.a.write(paramString2.getBytes());
      this.a.write(("\r\n--" + this.e + "\r\n").getBytes());
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, InputStream paramInputStream, String paramString3, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramInputStream == null)) {
      return;
    }
    a();
    try
    {
      paramString3 = "Content-Type: " + paramString3 + "\r\n";
      this.a.write(("Content-Disposition: form-data; name=\"" + paramString1 + "\"; filename=\"" + paramString2 + "\"\r\n").getBytes());
      this.a.write(paramString3.getBytes());
      this.a.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes());
      paramString1 = new byte['က'];
      for (;;)
      {
        int i = paramInputStream.read(paramString1);
        if (i == -1) {
          break;
        }
        this.a.write(paramString1, 0, i);
      }
      try
      {
        paramInputStream.close();
        throw paramString1;
      }
      catch (IOException paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
        }
      }
    }
    catch (IOException paramString1)
    {
      paramString1 = paramString1;
      paramString1.printStackTrace();
      try
      {
        paramInputStream.close();
        return;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      if (!paramBoolean) {
        this.a.write(("\r\n--" + this.e + "\r\n").getBytes());
      }
      for (;;)
      {
        this.a.flush();
        try
        {
          paramInputStream.close();
          return;
        }
        catch (IOException paramString1)
        {
          paramString1.printStackTrace();
          return;
        }
        b();
      }
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, InputStream paramInputStream, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramInputStream, "application/octet-stream", paramBoolean);
  }
  
  public void b()
  {
    if (this.b) {
      return;
    }
    try
    {
      this.a.write(("\r\n--" + this.e + "--\r\n").getBytes());
      this.b = true;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public void consumeContent()
    throws IOException, UnsupportedOperationException
  {
    if (isStreaming()) {
      throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
    }
  }
  
  public InputStream getContent()
    throws IOException, UnsupportedOperationException
  {
    return new ByteArrayInputStream(this.a.toByteArray());
  }
  
  public Header getContentEncoding()
  {
    return null;
  }
  
  public long getContentLength()
  {
    b();
    return this.a.toByteArray().length;
  }
  
  public Header getContentType()
  {
    return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.e);
  }
  
  public boolean isChunked()
  {
    return false;
  }
  
  public boolean isRepeatable()
  {
    return false;
  }
  
  public boolean isStreaming()
  {
    return false;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(this.a.toByteArray());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */