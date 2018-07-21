package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class Ckuserphone
  extends MessageMicro
{
  public static final int STATUS_FIELD_NUMBER = 1;
  public static final int URL_FIELD_NUMBER = 2;
  private boolean a;
  private int b = 0;
  private boolean c;
  private String d = "";
  private int e = -1;
  
  public static Ckuserphone parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Ckuserphone().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Ckuserphone parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Ckuserphone)new Ckuserphone().mergeFrom(paramArrayOfByte);
  }
  
  public final Ckuserphone clear()
  {
    clearStatus();
    clearUrl();
    this.e = -1;
    return this;
  }
  
  public Ckuserphone clearStatus()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public Ckuserphone clearUrl()
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
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasStatus()) {
      i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getStatus());
    }
    int j = i;
    if (hasUrl()) {
      j = i + CodedOutputStreamMicro.computeStringSize(2, getUrl());
    }
    this.e = j;
    return j;
  }
  
  public int getStatus()
  {
    return this.b;
  }
  
  public String getUrl()
  {
    return this.d;
  }
  
  public boolean hasStatus()
  {
    return this.a;
  }
  
  public boolean hasUrl()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Ckuserphone mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
      case 8: 
        setStatus(paramCodedInputStreamMicro.readInt32());
        break;
      case 18: 
        setUrl(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public Ckuserphone setStatus(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public Ckuserphone setUrl(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasStatus()) {
      paramCodedOutputStreamMicro.writeInt32(1, getStatus());
    }
    if (hasUrl()) {
      paramCodedOutputStreamMicro.writeString(2, getUrl());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Ckuserphone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */