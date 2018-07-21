package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class OfflineVersion
  extends MessageMicro
{
  public static final int OFFLINE_MAP_FIELD_NUMBER = 1;
  public static final int OFFLINE_SEARCH_FIELD_NUMBER = 2;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private int e = -1;
  
  public static OfflineVersion parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new OfflineVersion().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static OfflineVersion parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (OfflineVersion)new OfflineVersion().mergeFrom(paramArrayOfByte);
  }
  
  public final OfflineVersion clear()
  {
    clearOfflineMap();
    clearOfflineSearch();
    this.e = -1;
    return this;
  }
  
  public OfflineVersion clearOfflineMap()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public OfflineVersion clearOfflineSearch()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
  }
  
  public String getOfflineMap()
  {
    return this.b;
  }
  
  public String getOfflineSearch()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasOfflineMap()) {
      i = 0 + CodedOutputStreamMicro.computeStringSize(1, getOfflineMap());
    }
    int j = i;
    if (hasOfflineSearch()) {
      j = i + CodedOutputStreamMicro.computeStringSize(2, getOfflineSearch());
    }
    this.e = j;
    return j;
  }
  
  public boolean hasOfflineMap()
  {
    return this.a;
  }
  
  public boolean hasOfflineSearch()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public OfflineVersion mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setOfflineMap(paramCodedInputStreamMicro.readString());
        break;
      case 18: 
        setOfflineSearch(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public OfflineVersion setOfflineMap(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public OfflineVersion setOfflineSearch(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasOfflineMap()) {
      paramCodedOutputStreamMicro.writeString(1, getOfflineMap());
    }
    if (hasOfflineSearch()) {
      paramCodedOutputStreamMicro.writeString(2, getOfflineSearch());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/OfflineVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */