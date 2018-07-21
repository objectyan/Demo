package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class NaviContent
  extends MessageMicro
{
  public static final int OUTTYPE_FIELD_NUMBER = 2;
  public static final int OUT_FIELD_NUMBER = 1;
  private boolean a;
  private ByteStringMicro b = ByteStringMicro.EMPTY;
  private boolean c;
  private String d = "";
  private int e = -1;
  
  public static NaviContent parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new NaviContent().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static NaviContent parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (NaviContent)new NaviContent().mergeFrom(paramArrayOfByte);
  }
  
  public final NaviContent clear()
  {
    clearOut();
    clearOuttype();
    this.e = -1;
    return this;
  }
  
  public NaviContent clearOut()
  {
    this.a = false;
    this.b = ByteStringMicro.EMPTY;
    return this;
  }
  
  public NaviContent clearOuttype()
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
  
  public ByteStringMicro getOut()
  {
    return this.b;
  }
  
  public String getOuttype()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasOut()) {
      i = 0 + CodedOutputStreamMicro.computeBytesSize(1, getOut());
    }
    int j = i;
    if (hasOuttype()) {
      j = i + CodedOutputStreamMicro.computeStringSize(2, getOuttype());
    }
    this.e = j;
    return j;
  }
  
  public boolean hasOut()
  {
    return this.a;
  }
  
  public boolean hasOuttype()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public NaviContent mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setOut(paramCodedInputStreamMicro.readBytes());
        break;
      case 18: 
        setOuttype(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public NaviContent setOut(ByteStringMicro paramByteStringMicro)
  {
    this.a = true;
    this.b = paramByteStringMicro;
    return this;
  }
  
  public NaviContent setOuttype(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasOut()) {
      paramCodedOutputStreamMicro.writeBytes(1, getOut());
    }
    if (hasOuttype()) {
      paramCodedOutputStreamMicro.writeString(2, getOuttype());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/NaviContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */