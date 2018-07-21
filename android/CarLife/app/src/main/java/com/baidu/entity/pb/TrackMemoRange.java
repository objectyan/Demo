package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class TrackMemoRange
  extends MessageMicro
{
  public static final int DATE_FIELD_NUMBER = 1;
  private List<String> a = Collections.emptyList();
  private int b = -1;
  
  public static TrackMemoRange parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new TrackMemoRange().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static TrackMemoRange parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (TrackMemoRange)new TrackMemoRange().mergeFrom(paramArrayOfByte);
  }
  
  public TrackMemoRange addDate(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramString);
    return this;
  }
  
  public final TrackMemoRange clear()
  {
    clearDate();
    this.b = -1;
    return this;
  }
  
  public TrackMemoRange clearDate()
  {
    this.a = Collections.emptyList();
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.b < 0) {
      getSerializedSize();
    }
    return this.b;
  }
  
  public String getDate(int paramInt)
  {
    return (String)this.a.get(paramInt);
  }
  
  public int getDateCount()
  {
    return this.a.size();
  }
  
  public List<String> getDateList()
  {
    return this.a;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getDateList().iterator();
    for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next()) + i) {}
    i = 0 + i + getDateList().size() * 1;
    this.b = i;
    return i;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public TrackMemoRange mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    for (;;)
    {
      int i = paramCodedInputStreamMicro.readTag();
      switch (i)
      {
      default: 
        if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
        break;
      case 0: 
        return this;
      case 10: 
        addDate(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public TrackMemoRange setDate(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.a.set(paramInt, paramString);
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getDateList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeString(1, (String)localIterator.next());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/TrackMemoRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */