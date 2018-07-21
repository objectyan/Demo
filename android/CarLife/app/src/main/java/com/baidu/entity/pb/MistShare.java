package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class MistShare
  extends MessageMicro
{
  public static final int URL_FIELD_NUMBER = 1;
  private boolean a;
  private String b = "";
  private int c = -1;
  
  public static MistShare parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new MistShare().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static MistShare parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (MistShare)new MistShare().mergeFrom(paramArrayOfByte);
  }
  
  public final MistShare clear()
  {
    clearUrl();
    this.c = -1;
    return this;
  }
  
  public MistShare clearUrl()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.c < 0) {
      getSerializedSize();
    }
    return this.c;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasUrl()) {
      i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
    }
    this.c = i;
    return i;
  }
  
  public String getUrl()
  {
    return this.b;
  }
  
  public boolean hasUrl()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public MistShare mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setUrl(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public MistShare setUrl(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasUrl()) {
      paramCodedOutputStreamMicro.writeString(1, getUrl());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/MistShare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */