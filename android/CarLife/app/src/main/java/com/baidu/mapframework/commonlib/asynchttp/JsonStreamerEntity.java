package com.baidu.mapframework.commonlib.asynchttp;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonStreamerEntity
  implements HttpEntity
{
  private static final String a = "JsonStreamerEntity";
  private static final UnsupportedOperationException b = new UnsupportedOperationException("Unsupported operation in this implementation.");
  private static final int c = 4096;
  private static final byte[] d = "true".getBytes();
  private static final byte[] e = "false".getBytes();
  private static final byte[] f = "null".getBytes();
  private static final byte[] g = a("name");
  private static final byte[] h = a("type");
  private static final byte[] i = a("contents");
  private static final Header j = new BasicHeader("Content-Type", "application/json");
  private static final Header k = new BasicHeader("Content-Encoding", "gzip");
  private final byte[] l = new byte['က'];
  private final Map<String, Object> m = new HashMap();
  private final Header n;
  private final byte[] o;
  private final ResponseHandlerInterface p;
  
  public JsonStreamerEntity(ResponseHandlerInterface paramResponseHandlerInterface, boolean paramBoolean, String paramString)
  {
    this.p = paramResponseHandlerInterface;
    if (paramBoolean)
    {
      paramResponseHandlerInterface = k;
      this.n = paramResponseHandlerInterface;
      if (!TextUtils.isEmpty(paramString)) {
        break label66;
      }
    }
    label66:
    for (paramResponseHandlerInterface = (ResponseHandlerInterface)localObject;; paramResponseHandlerInterface = a(paramString))
    {
      this.o = paramResponseHandlerInterface;
      return;
      paramResponseHandlerInterface = null;
      break;
    }
  }
  
  private void a(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(34);
  }
  
  private void a(OutputStream paramOutputStream, RequestParams.FileWrapper paramFileWrapper)
    throws IOException
  {
    a(paramOutputStream, paramFileWrapper.file.getName(), paramFileWrapper.contentType);
    long l1 = 0L;
    long l2 = paramFileWrapper.file.length();
    paramFileWrapper = new FileInputStream(paramFileWrapper.file);
    Base64OutputStream localBase64OutputStream = new Base64OutputStream(paramOutputStream, 18);
    for (;;)
    {
      int i1 = paramFileWrapper.read(this.l);
      if (i1 == -1) {
        break;
      }
      localBase64OutputStream.write(this.l, 0, i1);
      l1 += i1;
      this.p.sendProgressMessage(l1, l2);
    }
    AsyncHttpClient.silentCloseOutputStream(localBase64OutputStream);
    a(paramOutputStream);
    AsyncHttpClient.silentCloseInputStream(paramFileWrapper);
  }
  
  private void a(OutputStream paramOutputStream, RequestParams.StreamWrapper paramStreamWrapper)
    throws IOException
  {
    a(paramOutputStream, paramStreamWrapper.name, paramStreamWrapper.contentType);
    Base64OutputStream localBase64OutputStream = new Base64OutputStream(paramOutputStream, 18);
    for (;;)
    {
      int i1 = paramStreamWrapper.inputStream.read(this.l);
      if (i1 == -1) {
        break;
      }
      localBase64OutputStream.write(this.l, 0, i1);
    }
    AsyncHttpClient.silentCloseOutputStream(localBase64OutputStream);
    a(paramOutputStream);
    if (paramStreamWrapper.autoClose) {
      AsyncHttpClient.silentCloseInputStream(paramStreamWrapper.inputStream);
    }
  }
  
  private void a(OutputStream paramOutputStream, String paramString1, String paramString2)
    throws IOException
  {
    paramOutputStream.write(g);
    paramOutputStream.write(58);
    paramOutputStream.write(a(paramString1));
    paramOutputStream.write(44);
    paramOutputStream.write(h);
    paramOutputStream.write(58);
    paramOutputStream.write(a(paramString2));
    paramOutputStream.write(44);
    paramOutputStream.write(i);
    paramOutputStream.write(58);
    paramOutputStream.write(34);
  }
  
  static byte[] a(String paramString)
  {
    if (paramString == null) {
      return f;
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append('"');
    int i3 = paramString.length();
    int i1 = -1;
    for (;;)
    {
      int i2 = i1 + 1;
      if (i2 >= i3) {
        break;
      }
      char c1 = paramString.charAt(i2);
      String str;
      int i4;
      switch (c1)
      {
      default: 
        if ((c1 <= '\037') || ((c1 >= '') && (c1 <= '')) || ((c1 >= ' ') && (c1 <= '⃿')))
        {
          str = Integer.toHexString(c1);
          localStringBuilder.append("\\u");
          i4 = str.length();
          i1 = 0;
        }
        break;
      case '"': 
      case '\\': 
      case '\b': 
      case '\f': 
      case '\n': 
      case '\r': 
      case '\t': 
        for (;;)
        {
          if (i1 < 4 - i4)
          {
            localStringBuilder.append('0');
            i1 += 1;
            continue;
            localStringBuilder.append("\\\"");
            i1 = i2;
            break;
            localStringBuilder.append("\\\\");
            i1 = i2;
            break;
            localStringBuilder.append("\\b");
            i1 = i2;
            break;
            localStringBuilder.append("\\f");
            i1 = i2;
            break;
            localStringBuilder.append("\\n");
            i1 = i2;
            break;
            localStringBuilder.append("\\r");
            i1 = i2;
            break;
            localStringBuilder.append("\\t");
            i1 = i2;
            break;
          }
        }
        localStringBuilder.append(str.toUpperCase(Locale.US));
        i1 = i2;
        break;
      }
      localStringBuilder.append(c1);
      i1 = i2;
    }
    localStringBuilder.append('"');
    return localStringBuilder.toString().getBytes();
  }
  
  public void addPart(String paramString, Object paramObject)
  {
    this.m.put(paramString, paramObject);
  }
  
  public void consumeContent()
    throws IOException, UnsupportedOperationException
  {}
  
  public InputStream getContent()
    throws IOException, UnsupportedOperationException
  {
    throw b;
  }
  
  public Header getContentEncoding()
  {
    return this.n;
  }
  
  public long getContentLength()
  {
    return -1L;
  }
  
  public Header getContentType()
  {
    return j;
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
    if (paramOutputStream == null) {
      throw new IllegalStateException("Output stream cannot be null.");
    }
    long l1 = System.currentTimeMillis();
    Object localObject1;
    int i3;
    int i1;
    label81:
    int i2;
    if (this.n != null)
    {
      paramOutputStream = new GZIPOutputStream(paramOutputStream, 4096);
      paramOutputStream.write(123);
      localObject1 = this.m.keySet();
      i3 = ((Set)localObject1).size();
      if (i3 <= 0) {
        break label672;
      }
      i1 = 0;
      Iterator localIterator = ((Set)localObject1).iterator();
      if (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        i2 = i1 + 1;
      }
    }
    else
    {
      for (;;)
      {
        Object localObject3;
        try
        {
          localObject3 = this.m.get(localObject1);
          paramOutputStream.write(a((String)localObject1));
          paramOutputStream.write(58);
          if (localObject3 == null)
          {
            paramOutputStream.write(f);
            if (this.o == null)
            {
              i1 = i2;
              if (i2 >= i3) {
                break label81;
              }
            }
            paramOutputStream.write(44);
            i1 = i2;
            break label81;
            break;
          }
          boolean bool = localObject3 instanceof RequestParams.FileWrapper;
          if ((!bool) && (!(localObject3 instanceof RequestParams.StreamWrapper))) {
            break label263;
          }
          paramOutputStream.write(123);
          if (bool)
          {
            a(paramOutputStream, (RequestParams.FileWrapper)localObject3);
            paramOutputStream.write(125);
            continue;
          }
          a(paramOutputStream, (RequestParams.StreamWrapper)localObject3);
        }
        finally
        {
          if ((this.o != null) || (i2 < i3)) {
            paramOutputStream.write(44);
          }
        }
        continue;
        label263:
        if ((localObject3 instanceof JsonValueInterface))
        {
          paramOutputStream.write(((JsonValueInterface)localObject3).getEscapedJsonValue());
        }
        else if ((localObject3 instanceof JSONObject))
        {
          paramOutputStream.write(localObject3.toString().getBytes());
        }
        else if ((localObject3 instanceof JSONArray))
        {
          paramOutputStream.write(localObject3.toString().getBytes());
        }
        else
        {
          if ((localObject3 instanceof Boolean))
          {
            if (((Boolean)localObject3).booleanValue()) {}
            for (byte[] arrayOfByte = d;; arrayOfByte = e)
            {
              paramOutputStream.write(arrayOfByte);
              break;
            }
          }
          if ((localObject3 instanceof Long)) {
            paramOutputStream.write((((Number)localObject3).longValue() + "").getBytes());
          } else if ((localObject3 instanceof Double)) {
            paramOutputStream.write((((Number)localObject3).doubleValue() + "").getBytes());
          } else if ((localObject3 instanceof Float)) {
            paramOutputStream.write((((Number)localObject3).floatValue() + "").getBytes());
          } else if ((localObject3 instanceof Integer)) {
            paramOutputStream.write((((Number)localObject3).intValue() + "").getBytes());
          } else {
            paramOutputStream.write(a(localObject3.toString()));
          }
        }
      }
    }
    l1 = System.currentTimeMillis() - l1;
    if (this.o != null)
    {
      paramOutputStream.write(this.o);
      paramOutputStream.write(58);
      paramOutputStream.write((l1 + "").getBytes());
    }
    AsyncHttpClient.log.i("JsonStreamerEntity", "Uploaded JSON in " + Math.floor(l1 / 1000L) + " seconds");
    label672:
    paramOutputStream.write(125);
    paramOutputStream.flush();
    AsyncHttpClient.silentCloseOutputStream(paramOutputStream);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/JsonStreamerEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */