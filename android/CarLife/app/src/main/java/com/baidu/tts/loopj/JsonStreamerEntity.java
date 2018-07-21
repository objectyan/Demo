package com.baidu.tts.loopj;

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
  private static final int BUFFER_SIZE = 4096;
  private static final UnsupportedOperationException ERR_UNSUPPORTED = new UnsupportedOperationException("Unsupported operation in this implementation.");
  private static final Header HEADER_GZIP_ENCODING = new BasicHeader("Content-Encoding", "gzip");
  private static final Header HEADER_JSON_CONTENT;
  private static final byte[] JSON_FALSE;
  private static final byte[] JSON_NULL;
  private static final byte[] JSON_TRUE = "true".getBytes();
  private static final String LOG_TAG = "JsonStreamerEntity";
  private static final byte[] STREAM_CONTENTS;
  private static final byte[] STREAM_NAME;
  private static final byte[] STREAM_TYPE;
  private final byte[] buffer = new byte['က'];
  private final Header contentEncoding;
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
    HEADER_JSON_CONTENT = new BasicHeader("Content-Type", "application/json");
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
    int j = i + 1;
    if (j < k)
    {
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
        while (i < 4 - m)
        {
          localStringBuilder.append('0');
          i += 1;
          continue;
          localStringBuilder.append("\\\"");
        }
      }
      for (;;)
      {
        i = j;
        break;
        localStringBuilder.append("\\\\");
        continue;
        localStringBuilder.append("\\b");
        continue;
        localStringBuilder.append("\\f");
        continue;
        localStringBuilder.append("\\n");
        continue;
        localStringBuilder.append("\\r");
        continue;
        localStringBuilder.append("\\t");
        continue;
        localStringBuilder.append(str.toUpperCase(Locale.US));
        continue;
        localStringBuilder.append(c);
      }
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
  
  public Header getContentEncoding()
  {
    return this.contentEncoding;
  }
  
  public long getContentLength()
  {
    return -1L;
  }
  
  public Header getContentType()
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
    Object localObject1 = paramOutputStream;
    if (this.contentEncoding != null) {
      localObject1 = new GZIPOutputStream(paramOutputStream, 4096);
    }
    ((OutputStream)localObject1).write(123);
    paramOutputStream = this.jsonParams.keySet();
    int j = paramOutputStream.size();
    if (j > 0)
    {
      Iterator localIterator = paramOutputStream.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        paramOutputStream = (String)localIterator.next();
        i += 1;
        for (;;)
        {
          Object localObject2;
          try
          {
            localObject2 = this.jsonParams.get(paramOutputStream);
            ((OutputStream)localObject1).write(escape(paramOutputStream));
            ((OutputStream)localObject1).write(58);
            if (localObject2 == null)
            {
              ((OutputStream)localObject1).write(JSON_NULL);
              if ((this.elapsedField != null) || (i < j)) {
                ((OutputStream)localObject1).write(44);
              }
              break;
            }
            boolean bool = localObject2 instanceof RequestParams.FileWrapper;
            if ((!bool) && (!(localObject2 instanceof RequestParams.StreamWrapper))) {
              break label258;
            }
            ((OutputStream)localObject1).write(123);
            if (bool)
            {
              writeToFromFile((OutputStream)localObject1, (RequestParams.FileWrapper)localObject2);
              ((OutputStream)localObject1).write(125);
              continue;
            }
            writeToFromStream((OutputStream)localObject1, (RequestParams.StreamWrapper)localObject2);
          }
          finally
          {
            if ((this.elapsedField != null) || (i < j)) {
              ((OutputStream)localObject1).write(44);
            }
          }
          continue;
          label258:
          if ((localObject2 instanceof JsonValueInterface))
          {
            ((OutputStream)localObject1).write(((JsonValueInterface)localObject2).getEscapedJsonValue());
          }
          else if ((localObject2 instanceof JSONObject))
          {
            ((OutputStream)localObject1).write(localObject2.toString().getBytes());
          }
          else if ((localObject2 instanceof JSONArray))
          {
            ((OutputStream)localObject1).write(localObject2.toString().getBytes());
          }
          else
          {
            if ((localObject2 instanceof Boolean))
            {
              if (((Boolean)localObject2).booleanValue()) {}
              for (paramOutputStream = JSON_TRUE;; paramOutputStream = JSON_FALSE)
              {
                ((OutputStream)localObject1).write(paramOutputStream);
                break;
              }
            }
            if ((localObject2 instanceof Long)) {
              ((OutputStream)localObject1).write((((Number)localObject2).longValue() + "").getBytes());
            } else if ((localObject2 instanceof Double)) {
              ((OutputStream)localObject1).write((((Number)localObject2).doubleValue() + "").getBytes());
            } else if ((localObject2 instanceof Float)) {
              ((OutputStream)localObject1).write((((Number)localObject2).floatValue() + "").getBytes());
            } else if ((localObject2 instanceof Integer)) {
              ((OutputStream)localObject1).write((((Number)localObject2).intValue() + "").getBytes());
            } else {
              ((OutputStream)localObject1).write(escape(localObject2.toString()));
            }
          }
        }
      }
      l = System.currentTimeMillis() - l;
      if (this.elapsedField != null)
      {
        ((OutputStream)localObject1).write(this.elapsedField);
        ((OutputStream)localObject1).write(58);
        ((OutputStream)localObject1).write((l + "").getBytes());
      }
      AsyncHttpClient.log.i("JsonStreamerEntity", "Uploaded JSON in " + Math.floor(l / 1000L) + " seconds");
    }
    ((OutputStream)localObject1).write(125);
    ((OutputStream)localObject1).flush();
    AsyncHttpClient.silentCloseOutputStream((OutputStream)localObject1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/loopj/JsonStreamerEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */