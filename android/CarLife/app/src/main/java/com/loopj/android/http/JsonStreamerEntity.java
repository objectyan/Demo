package com.loopj.android.http;

import android.text.TextUtils;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.k.b;
import cz.msebera.android.httpclient.n;
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
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonStreamerEntity
  implements n
{
  private static final int BUFFER_SIZE = 4096;
  private static final UnsupportedOperationException ERR_UNSUPPORTED = new UnsupportedOperationException("Unsupported operation in this implementation.");
  private static final f HEADER_GZIP_ENCODING = new b("Content-Encoding", "gzip");
  private static final f HEADER_JSON_CONTENT;
  private static final byte[] JSON_FALSE;
  private static final byte[] JSON_NULL;
  private static final byte[] JSON_TRUE = "true".getBytes();
  private static final String LOG_TAG = "JsonStreamerEntity";
  private static final byte[] STREAM_CONTENTS;
  private static final byte[] STREAM_NAME;
  private static final byte[] STREAM_TYPE;
  private final byte[] buffer = new byte['က'];
  private final f contentEncoding;
  private final byte[] elapsedField;
  private final Map<String, Object> jsonParams = new HashMap();
  private final ResponseHandlerInterface progressHandler;
  
  static
  {
    JSON_FALSE = "false".getBytes();
    JSON_NULL = "null".getBytes();
    STREAM_NAME = escape("name");
    STREAM_TYPE = escape("type");
    STREAM_CONTENTS = escape("contents");
    HEADER_JSON_CONTENT = new b("Content-Type", "application/json");
  }
  
  public JsonStreamerEntity(ResponseHandlerInterface paramResponseHandlerInterface, boolean paramBoolean, String paramString)
  {
    this.progressHandler = paramResponseHandlerInterface;
    if (paramBoolean)
    {
      paramResponseHandlerInterface = HEADER_GZIP_ENCODING;
      this.contentEncoding = paramResponseHandlerInterface;
      if (!TextUtils.isEmpty(paramString)) {
        break label66;
      }
    }
    label66:
    for (paramResponseHandlerInterface = (ResponseHandlerInterface)localObject;; paramResponseHandlerInterface = escape(paramString))
    {
      this.elapsedField = paramResponseHandlerInterface;
      return;
      paramResponseHandlerInterface = null;
      break;
    }
  }
  
  private void endMetaData(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(34);
  }
  
  static byte[] escape(String paramString)
  {
    if (paramString == null) {
      return JSON_NULL;
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append('"');
    int k = paramString.length();
    int i = -1;
    for (;;)
    {
      int j = i + 1;
      if (j >= k) {
        break;
      }
      char c = paramString.charAt(j);
      String str;
      int m;
      switch (c)
      {
      default: 
        if ((c <= '\037') || ((c >= '') && (c <= '')) || ((c >= ' ') && (c <= '⃿')))
        {
          str = Integer.toHexString(c);
          localStringBuilder.append("\\u");
          m = str.length();
          i = 0;
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
          if (i < 4 - m)
          {
            localStringBuilder.append('0');
            i += 1;
            continue;
            localStringBuilder.append("\\\"");
            i = j;
            break;
            localStringBuilder.append("\\\\");
            i = j;
            break;
            localStringBuilder.append("\\b");
            i = j;
            break;
            localStringBuilder.append("\\f");
            i = j;
            break;
            localStringBuilder.append("\\n");
            i = j;
            break;
            localStringBuilder.append("\\r");
            i = j;
            break;
            localStringBuilder.append("\\t");
            i = j;
            break;
          }
        }
        localStringBuilder.append(str.toUpperCase(Locale.US));
        i = j;
        break;
      }
      localStringBuilder.append(c);
      i = j;
    }
    localStringBuilder.append('"');
    return localStringBuilder.toString().getBytes();
  }
  
  private void writeMetaData(OutputStream paramOutputStream, String paramString1, String paramString2)
    throws IOException
  {
    paramOutputStream.write(STREAM_NAME);
    paramOutputStream.write(58);
    paramOutputStream.write(escape(paramString1));
    paramOutputStream.write(44);
    paramOutputStream.write(STREAM_TYPE);
    paramOutputStream.write(58);
    paramOutputStream.write(escape(paramString2));
    paramOutputStream.write(44);
    paramOutputStream.write(STREAM_CONTENTS);
    paramOutputStream.write(58);
    paramOutputStream.write(34);
  }
  
  private void writeToFromFile(OutputStream paramOutputStream, RequestParams.FileWrapper paramFileWrapper)
    throws IOException
  {
    writeMetaData(paramOutputStream, paramFileWrapper.file.getName(), paramFileWrapper.contentType);
    long l1 = 0L;
    long l2 = paramFileWrapper.file.length();
    paramFileWrapper = new FileInputStream(paramFileWrapper.file);
    Base64OutputStream localBase64OutputStream = new Base64OutputStream(paramOutputStream, 18);
    for (;;)
    {
      int i = paramFileWrapper.read(this.buffer);
      if (i == -1) {
        break;
      }
      localBase64OutputStream.write(this.buffer, 0, i);
      l1 += i;
      this.progressHandler.sendProgressMessage(l1, l2);
    }
    AsyncHttpClient.silentCloseOutputStream(localBase64OutputStream);
    endMetaData(paramOutputStream);
    AsyncHttpClient.silentCloseInputStream(paramFileWrapper);
  }
  
  private void writeToFromStream(OutputStream paramOutputStream, RequestParams.StreamWrapper paramStreamWrapper)
    throws IOException
  {
    writeMetaData(paramOutputStream, paramStreamWrapper.name, paramStreamWrapper.contentType);
    Base64OutputStream localBase64OutputStream = new Base64OutputStream(paramOutputStream, 18);
    for (;;)
    {
      int i = paramStreamWrapper.inputStream.read(this.buffer);
      if (i == -1) {
        break;
      }
      localBase64OutputStream.write(this.buffer, 0, i);
    }
    AsyncHttpClient.silentCloseOutputStream(localBase64OutputStream);
    endMetaData(paramOutputStream);
    if (paramStreamWrapper.autoClose) {
      AsyncHttpClient.silentCloseInputStream(paramStreamWrapper.inputStream);
    }
  }
  
  public void addPart(String paramString, Object paramObject)
  {
    this.jsonParams.put(paramString, paramObject);
  }
  
  public void consumeContent()
    throws IOException, UnsupportedOperationException
  {}
  
  public InputStream getContent()
    throws IOException, UnsupportedOperationException
  {
    throw ERR_UNSUPPORTED;
  }
  
  public f getContentEncoding()
  {
    return this.contentEncoding;
  }
  
  public long getContentLength()
  {
    return -1L;
  }
  
  public f getContentType()
  {
    return HEADER_JSON_CONTENT;
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
    long l = System.currentTimeMillis();
    Object localObject1;
    int k;
    int i;
    label81:
    int j;
    if (this.contentEncoding != null)
    {
      paramOutputStream = new GZIPOutputStream(paramOutputStream, 4096);
      paramOutputStream.write(123);
      localObject1 = this.jsonParams.keySet();
      k = ((Set)localObject1).size();
      if (k <= 0) {
        break label672;
      }
      i = 0;
      Iterator localIterator = ((Set)localObject1).iterator();
      if (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        j = i + 1;
      }
    }
    else
    {
      for (;;)
      {
        Object localObject3;
        try
        {
          localObject3 = this.jsonParams.get(localObject1);
          paramOutputStream.write(escape((String)localObject1));
          paramOutputStream.write(58);
          if (localObject3 == null)
          {
            paramOutputStream.write(JSON_NULL);
            if (this.elapsedField == null)
            {
              i = j;
              if (j >= k) {
                break label81;
              }
            }
            paramOutputStream.write(44);
            i = j;
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
            writeToFromFile(paramOutputStream, (RequestParams.FileWrapper)localObject3);
            paramOutputStream.write(125);
            continue;
          }
          writeToFromStream(paramOutputStream, (RequestParams.StreamWrapper)localObject3);
        }
        finally
        {
          if ((this.elapsedField != null) || (j < k)) {
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
            for (byte[] arrayOfByte = JSON_TRUE;; arrayOfByte = JSON_FALSE)
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
            paramOutputStream.write(escape(localObject3.toString()));
          }
        }
      }
    }
    l = System.currentTimeMillis() - l;
    if (this.elapsedField != null)
    {
      paramOutputStream.write(this.elapsedField);
      paramOutputStream.write(58);
      paramOutputStream.write((l + "").getBytes());
    }
    AsyncHttpClient.log.i("JsonStreamerEntity", "Uploaded JSON in " + Math.floor(l / 1000L) + " seconds");
    label672:
    paramOutputStream.write(125);
    paramOutputStream.flush();
    AsyncHttpClient.silentCloseOutputStream(paramOutputStream);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/JsonStreamerEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */