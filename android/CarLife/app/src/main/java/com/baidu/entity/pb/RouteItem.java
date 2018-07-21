package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class RouteItem
  extends MessageMicro
{
  public static final int IDX_FIELD_NUMBER = 1;
  public static final int RECOMDATA_FIELD_NUMBER = 2;
  private boolean a;
  private int b = 0;
  private boolean c;
  private ByteStringMicro d = ByteStringMicro.EMPTY;
  private int e = -1;
  
  public static RouteItem parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new RouteItem().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static RouteItem parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (RouteItem)new RouteItem().mergeFrom(paramArrayOfByte);
  }
  
  public final RouteItem clear()
  {
    clearIdx();
    clearRecomdata();
    this.e = -1;
    return this;
  }
  
  public RouteItem clearIdx()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public RouteItem clearRecomdata()
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
  
  public int getIdx()
  {
    return this.b;
  }
  
  public ByteStringMicro getRecomdata()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasIdx()) {
      i = 0 + CodedOutputStreamMicro.computeUInt32Size(1, getIdx());
    }
    int j = i;
    if (hasRecomdata()) {
      j = i + CodedOutputStreamMicro.computeBytesSize(2, getRecomdata());
    }
    this.e = j;
    return j;
  }
  
  public boolean hasIdx()
  {
    return this.a;
  }
  
  public boolean hasRecomdata()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public RouteItem mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setIdx(paramCodedInputStreamMicro.readUInt32());
        break;
      case 18: 
        setRecomdata(paramCodedInputStreamMicro.readBytes());
      }
    }
  }
  
  public RouteItem setIdx(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public RouteItem setRecomdata(ByteStringMicro paramByteStringMicro)
  {
    this.c = true;
    this.d = paramByteStringMicro;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasIdx()) {
      paramCodedOutputStreamMicro.writeUInt32(1, getIdx());
    }
    if (hasRecomdata()) {
      paramCodedOutputStreamMicro.writeBytes(2, getRecomdata());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/RouteItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */