package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class SelfHeaderMessage
  extends MessageMicro
{
  public static final int DYNAMIC_PB_RES_FIELD_NUMBER = 1;
  private boolean a;
  private ByteStringMicro b = ByteStringMicro.EMPTY;
  private int c = -1;
  
  public static SelfHeaderMessage parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new SelfHeaderMessage().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static SelfHeaderMessage parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (SelfHeaderMessage)new SelfHeaderMessage().mergeFrom(paramArrayOfByte);
  }
  
  public final SelfHeaderMessage clear()
  {
    clearDynamicPbRes();
    this.c = -1;
    return this;
  }
  
  public SelfHeaderMessage clearDynamicPbRes()
  {
    this.a = false;
    this.b = ByteStringMicro.EMPTY;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.c < 0) {
      getSerializedSize();
    }
    return this.c;
  }
  
  public ByteStringMicro getDynamicPbRes()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasDynamicPbRes()) {
      i = 0 + CodedOutputStreamMicro.computeBytesSize(1, getDynamicPbRes());
    }
    this.c = i;
    return i;
  }
  
  public boolean hasDynamicPbRes()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public SelfHeaderMessage mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
      }
    }
  }
  
  public SelfHeaderMessage setDynamicPbRes(ByteStringMicro paramByteStringMicro)
  {
    this.a = true;
    this.b = paramByteStringMicro;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasDynamicPbRes()) {
      paramCodedOutputStreamMicro.writeBytes(1, getDynamicPbRes());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/SelfHeaderMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */