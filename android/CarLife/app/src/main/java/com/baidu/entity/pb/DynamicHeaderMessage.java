package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class DynamicHeaderMessage
  extends MessageMicro
{
  public static final int DYNAMIC_PB_RES_FIELD_NUMBER = 1;
  public static final int SELFMAP_PB_RES_FIELD_NUMBER = 2;
  private boolean a;
  private ByteStringMicro b = ByteStringMicro.EMPTY;
  private boolean c;
  private ByteStringMicro d = ByteStringMicro.EMPTY;
  private int e = -1;
  
  public static DynamicHeaderMessage parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new DynamicHeaderMessage().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static DynamicHeaderMessage parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (DynamicHeaderMessage)new DynamicHeaderMessage().mergeFrom(paramArrayOfByte);
  }
  
  public final DynamicHeaderMessage clear()
  {
    clearDynamicPbRes();
    clearSelfmapPbRes();
    this.e = -1;
    return this;
  }
  
  public DynamicHeaderMessage clearDynamicPbRes()
  {
    this.a = false;
    this.b = ByteStringMicro.EMPTY;
    return this;
  }
  
  public DynamicHeaderMessage clearSelfmapPbRes()
  {
    this.c = false;
    this.d = ByteStringMicro.EMPTY;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
  }
  
  public ByteStringMicro getDynamicPbRes()
  {
    return this.b;
  }
  
  public ByteStringMicro getSelfmapPbRes()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasDynamicPbRes()) {
      i = 0 + CodedOutputStreamMicro.computeBytesSize(1, getDynamicPbRes());
    }
    int j = i;
    if (hasSelfmapPbRes()) {
      j = i + CodedOutputStreamMicro.computeBytesSize(2, getSelfmapPbRes());
    }
    this.e = j;
    return j;
  }
  
  public boolean hasDynamicPbRes()
  {
    return this.a;
  }
  
  public boolean hasSelfmapPbRes()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public DynamicHeaderMessage mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setDynamicPbRes(paramCodedInputStreamMicro.readBytes());
        break;
      case 18: 
        setSelfmapPbRes(paramCodedInputStreamMicro.readBytes());
      }
    }
  }
  
  public DynamicHeaderMessage setDynamicPbRes(ByteStringMicro paramByteStringMicro)
  {
    this.a = true;
    this.b = paramByteStringMicro;
    return this;
  }
  
  public DynamicHeaderMessage setSelfmapPbRes(ByteStringMicro paramByteStringMicro)
  {
    this.c = true;
    this.d = paramByteStringMicro;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasDynamicPbRes()) {
      paramCodedOutputStreamMicro.writeBytes(1, getDynamicPbRes());
    }
    if (hasSelfmapPbRes()) {
      paramCodedOutputStreamMicro.writeBytes(2, getSelfmapPbRes());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/DynamicHeaderMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */