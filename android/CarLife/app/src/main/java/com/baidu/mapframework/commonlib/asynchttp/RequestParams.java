package com.baidu.mapframework.commonlib.asynchttp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class RequestParams
  implements Serializable
{
  public static final String APPLICATION_JSON = "application/json";
  public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
  protected static final String LOG_TAG = "RequestParams";
  protected boolean autoCloseInputStreams;
  protected String contentEncoding = "UTF-8";
  protected String elapsedFieldInJsonStreamer = "_elapsed";
  protected final ConcurrentHashMap<String, List<FileWrapper>> fileArrayParams = new ConcurrentHashMap();
  protected final ConcurrentHashMap<String, FileWrapper> fileParams = new ConcurrentHashMap();
  protected boolean forceMultipartEntity = false;
  protected boolean isRepeatable;
  protected final ConcurrentHashMap<String, StreamWrapper> streamParams = new ConcurrentHashMap();
  protected final ConcurrentHashMap<String, String> urlParams = new ConcurrentHashMap();
  protected final ConcurrentHashMap<String, Object> urlParamsWithObjects = new ConcurrentHashMap();
  protected boolean useJsonStreamer;
  
  public RequestParams()
  {
    this((Map)null);
  }
  
  public RequestParams(String paramString1, final String paramString2)
  {
    this(new HashMap() {});
  }
  
  public RequestParams(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public RequestParams(Object... paramVarArgs)
  {
    int j = paramVarArgs.length;
    if (j % 2 != 0) {
      throw new IllegalArgumentException("Supplied arguments must be even");
    }
    int i = 0;
    while (i < j)
    {
      put(String.valueOf(paramVarArgs[i]), String.valueOf(paramVarArgs[(i + 1)]));
      i += 2;
    }
  }
  
  private List<BasicNameValuePair> a(String paramString, Object paramObject)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramObject instanceof Map))
    {
      Map localMap = (Map)paramObject;
      paramObject = new ArrayList(localMap.keySet());
      if ((((List)paramObject).size() > 0) && ((((List)paramObject).get(0) instanceof Comparable))) {
        Collections.sort((List)paramObject);
      }
      Iterator localIterator = ((List)paramObject).iterator();
      Object localObject;
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramObject = localIterator.next();
        } while (!(paramObject instanceof String));
        localObject = localMap.get(paramObject);
      } while (localObject == null);
      if (paramString == null) {}
      for (paramObject = (String)paramObject;; paramObject = String.format(Locale.US, "%s[%s]", new Object[] { paramString, paramObject }))
      {
        localLinkedList.addAll(a((String)paramObject, localObject));
        break;
      }
    }
    int j;
    int i;
    if ((paramObject instanceof List))
    {
      paramObject = (List)paramObject;
      j = ((List)paramObject).size();
      i = 0;
      while (i < j)
      {
        localLinkedList.addAll(a(String.format(Locale.US, "%s[%d]", new Object[] { paramString, Integer.valueOf(i) }), ((List)paramObject).get(i)));
        i += 1;
      }
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localLinkedList.addAll(a(String.format(Locale.US, "%s[%d]", new Object[] { paramString, Integer.valueOf(i) }), paramObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof Set))
    {
      paramObject = ((Set)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        localLinkedList.addAll(a(paramString, ((Iterator)paramObject).next()));
      }
    }
    localLinkedList.add(new BasicNameValuePair(paramString, paramObject.toString()));
    return localLinkedList;
  }
  
  private HttpEntity a()
  {
    try
    {
      UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(getParamsList(), this.contentEncoding);
      return localUrlEncodedFormEntity;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      AsyncHttpClient.log.e("RequestParams", "createFormEntity failed", localUnsupportedEncodingException);
    }
    return null;
  }
  
  private HttpEntity a(ResponseHandlerInterface paramResponseHandlerInterface)
    throws IOException
  {
    if ((!this.fileParams.isEmpty()) || (!this.streamParams.isEmpty())) {}
    Map.Entry localEntry;
    for (boolean bool = true;; bool = false)
    {
      paramResponseHandlerInterface = new JsonStreamerEntity(paramResponseHandlerInterface, bool, this.elapsedFieldInJsonStreamer);
      localIterator = this.urlParams.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        paramResponseHandlerInterface.addPart((String)localEntry.getKey(), localEntry.getValue());
      }
    }
    Iterator localIterator = this.urlParamsWithObjects.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      paramResponseHandlerInterface.addPart((String)localEntry.getKey(), localEntry.getValue());
    }
    localIterator = this.fileParams.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      paramResponseHandlerInterface.addPart((String)localEntry.getKey(), localEntry.getValue());
    }
    localIterator = this.streamParams.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      StreamWrapper localStreamWrapper = (StreamWrapper)localEntry.getValue();
      if (localStreamWrapper.inputStream != null) {
        paramResponseHandlerInterface.addPart((String)localEntry.getKey(), StreamWrapper.a(localStreamWrapper.inputStream, localStreamWrapper.name, localStreamWrapper.contentType, localStreamWrapper.autoClose));
      }
    }
    return paramResponseHandlerInterface;
  }
  
  private HttpEntity b(ResponseHandlerInterface paramResponseHandlerInterface)
    throws IOException
  {
    paramResponseHandlerInterface = new SimpleMultipartEntity(paramResponseHandlerInterface);
    paramResponseHandlerInterface.setIsRepeatable(this.isRepeatable);
    Iterator localIterator = this.urlParams.entrySet().iterator();
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      paramResponseHandlerInterface.addPartWithCharset((String)((Map.Entry)localObject1).getKey(), (String)((Map.Entry)localObject1).getValue(), this.contentEncoding);
    }
    localIterator = a(null, this.urlParamsWithObjects).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (BasicNameValuePair)localIterator.next();
      paramResponseHandlerInterface.addPartWithCharset(((BasicNameValuePair)localObject1).getName(), ((BasicNameValuePair)localObject1).getValue(), this.contentEncoding);
    }
    localIterator = this.streamParams.entrySet().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localObject2 = (StreamWrapper)((Map.Entry)localObject1).getValue();
      if (((StreamWrapper)localObject2).inputStream != null) {
        paramResponseHandlerInterface.addPart((String)((Map.Entry)localObject1).getKey(), ((StreamWrapper)localObject2).name, ((StreamWrapper)localObject2).inputStream, ((StreamWrapper)localObject2).contentType);
      }
    }
    localIterator = this.fileParams.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localObject2 = (FileWrapper)((Map.Entry)localObject1).getValue();
      paramResponseHandlerInterface.addPart((String)((Map.Entry)localObject1).getKey(), ((FileWrapper)localObject2).file, ((FileWrapper)localObject2).contentType, ((FileWrapper)localObject2).customFileName);
    }
    localIterator = this.fileArrayParams.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localObject2 = ((List)((Map.Entry)localObject1).getValue()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        FileWrapper localFileWrapper = (FileWrapper)((Iterator)localObject2).next();
        paramResponseHandlerInterface.addPart((String)((Map.Entry)localObject1).getKey(), localFileWrapper.file, localFileWrapper.contentType, localFileWrapper.customFileName);
      }
    }
    return paramResponseHandlerInterface;
  }
  
  public void add(String paramString1, String paramString2)
  {
    Object localObject1;
    if ((paramString1 != null) && (paramString2 != null))
    {
      Object localObject2 = this.urlParamsWithObjects.get(paramString1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        put(paramString1, localObject1);
      }
      if (!(localObject1 instanceof List)) {
        break label59;
      }
      ((List)localObject1).add(paramString2);
    }
    label59:
    while (!(localObject1 instanceof Set)) {
      return;
    }
    ((Set)localObject1).add(paramString2);
  }
  
  public HttpEntity getEntity(ResponseHandlerInterface paramResponseHandlerInterface)
    throws IOException
  {
    if (this.useJsonStreamer) {
      return a(paramResponseHandlerInterface);
    }
    if ((!this.forceMultipartEntity) && (this.streamParams.isEmpty()) && (this.fileParams.isEmpty()) && (this.fileArrayParams.isEmpty())) {
      return a();
    }
    return b(paramResponseHandlerInterface);
  }
  
  protected String getParamString()
  {
    return URLEncodedUtils.format(getParamsList(), this.contentEncoding);
  }
  
  protected List<BasicNameValuePair> getParamsList()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.urlParams.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localLinkedList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    localLinkedList.addAll(a(null, this.urlParamsWithObjects));
    return localLinkedList;
  }
  
  public boolean has(String paramString)
  {
    return (this.urlParams.get(paramString) != null) || (this.streamParams.get(paramString) != null) || (this.fileParams.get(paramString) != null) || (this.urlParamsWithObjects.get(paramString) != null) || (this.fileArrayParams.get(paramString) != null);
  }
  
  public void put(String paramString, int paramInt)
  {
    if (paramString != null) {
      this.urlParams.put(paramString, String.valueOf(paramInt));
    }
  }
  
  public void put(String paramString, long paramLong)
  {
    if (paramString != null) {
      this.urlParams.put(paramString, String.valueOf(paramLong));
    }
  }
  
  public void put(String paramString, File paramFile)
    throws FileNotFoundException
  {
    put(paramString, paramFile, null, null);
  }
  
  public void put(String paramString1, File paramFile, String paramString2)
    throws FileNotFoundException
  {
    put(paramString1, paramFile, paramString2, null);
  }
  
  public void put(String paramString1, File paramFile, String paramString2, String paramString3)
    throws FileNotFoundException
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      throw new FileNotFoundException();
    }
    if (paramString1 != null) {
      this.fileParams.put(paramString1, new FileWrapper(paramFile, paramString2, paramString3));
    }
  }
  
  public void put(String paramString, InputStream paramInputStream)
  {
    put(paramString, paramInputStream, null);
  }
  
  public void put(String paramString1, InputStream paramInputStream, String paramString2)
  {
    put(paramString1, paramInputStream, paramString2, null);
  }
  
  public void put(String paramString1, InputStream paramInputStream, String paramString2, String paramString3)
  {
    put(paramString1, paramInputStream, paramString2, paramString3, this.autoCloseInputStreams);
  }
  
  public void put(String paramString1, InputStream paramInputStream, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramString1 != null) && (paramInputStream != null)) {
      this.streamParams.put(paramString1, StreamWrapper.a(paramInputStream, paramString2, paramString3, paramBoolean));
    }
  }
  
  public void put(String paramString, Object paramObject)
  {
    if ((paramString != null) && (paramObject != null)) {
      this.urlParamsWithObjects.put(paramString, paramObject);
    }
  }
  
  public void put(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      this.urlParams.put(paramString1, paramString2);
    }
  }
  
  public void put(String paramString1, String paramString2, File paramFile)
    throws FileNotFoundException
  {
    put(paramString1, paramFile, null, paramString2);
  }
  
  public void put(String paramString, File[] paramArrayOfFile)
    throws FileNotFoundException
  {
    put(paramString, paramArrayOfFile, null, null);
  }
  
  public void put(String paramString1, File[] paramArrayOfFile, String paramString2, String paramString3)
    throws FileNotFoundException
  {
    if (paramString1 != null)
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = paramArrayOfFile[i];
        if ((localFile == null) || (!localFile.exists())) {
          throw new FileNotFoundException();
        }
        localArrayList.add(new FileWrapper(localFile, paramString2, paramString3));
        i += 1;
      }
      this.fileArrayParams.put(paramString1, localArrayList);
    }
  }
  
  public void remove(String paramString)
  {
    this.urlParams.remove(paramString);
    this.streamParams.remove(paramString);
    this.fileParams.remove(paramString);
    this.urlParamsWithObjects.remove(paramString);
    this.fileArrayParams.remove(paramString);
  }
  
  public void setAutoCloseInputStreams(boolean paramBoolean)
  {
    this.autoCloseInputStreams = paramBoolean;
  }
  
  public void setContentEncoding(String paramString)
  {
    if (paramString != null)
    {
      this.contentEncoding = paramString;
      return;
    }
    AsyncHttpClient.log.d("RequestParams", "setContentEncoding called with null attribute");
  }
  
  public void setElapsedFieldInJsonStreamer(String paramString)
  {
    this.elapsedFieldInJsonStreamer = paramString;
  }
  
  public void setForceMultipartEntityContentType(boolean paramBoolean)
  {
    this.forceMultipartEntity = paramBoolean;
  }
  
  public void setHttpEntityIsRepeatable(boolean paramBoolean)
  {
    this.isRepeatable = paramBoolean;
  }
  
  public void setUseJsonStreamer(boolean paramBoolean)
  {
    this.useJsonStreamer = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.urlParams.entrySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)((Map.Entry)localObject).getValue());
    }
    localIterator = this.streamParams.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append("=");
      localStringBuilder.append("STREAM");
    }
    localIterator = this.fileParams.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append("=");
      localStringBuilder.append("FILE");
    }
    localIterator = this.fileArrayParams.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append("=");
      localStringBuilder.append("FILES(SIZE=").append(((List)((Map.Entry)localObject).getValue()).size()).append(")");
    }
    localIterator = a(null, this.urlParamsWithObjects).iterator();
    while (localIterator.hasNext())
    {
      localObject = (BasicNameValuePair)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append(((BasicNameValuePair)localObject).getName());
      localStringBuilder.append("=");
      localStringBuilder.append(((BasicNameValuePair)localObject).getValue());
    }
    return localStringBuilder.toString();
  }
  
  public static class FileWrapper
    implements Serializable
  {
    public final String contentType;
    public final String customFileName;
    public final File file;
    
    public FileWrapper(File paramFile, String paramString1, String paramString2)
    {
      this.file = paramFile;
      this.contentType = paramString1;
      this.customFileName = paramString2;
    }
  }
  
  public static class StreamWrapper
  {
    public final boolean autoClose;
    public final String contentType;
    public final InputStream inputStream;
    public final String name;
    
    public StreamWrapper(InputStream paramInputStream, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.inputStream = paramInputStream;
      this.name = paramString1;
      this.contentType = paramString2;
      this.autoClose = paramBoolean;
    }
    
    static StreamWrapper a(InputStream paramInputStream, String paramString1, String paramString2, boolean paramBoolean)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "application/octet-stream";
      }
      return new StreamWrapper(paramInputStream, paramString1, str, paramBoolean);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/RequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */