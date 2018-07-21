package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class Result
  extends MessageMicro
{
  public static final int ERROR_FIELD_NUMBER = 2;
  public static final int TYPE_FIELD_NUMBER = 1;
  private boolean a;
  private int b = 0;
  private boolean c;
  private int d = 0;
  private int e = -1;
  
  public static Result parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Result().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Result parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Result)new Result().mergeFrom(paramArrayOfByte);
  }
  
  public final Result clear()
  {
    clearType();
    clearError();
    this.e = -1;
    return this;
  }
  
  public Result clearError()
  {
    this.c = false;
    this.d = 0;
    return this;
  }
  
  public Result clearType()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
  }
  
  public int getError()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasType()) {
      i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getType());
    }
    int j = i;
    if (hasError()) {
      j = i + CodedOutputStreamMicro.computeSInt32Size(2, getError());
    }
    this.e = j;
    return j;
  }
  
  public int getType()
  {
    return this.b;
  }
  
  public boolean hasError()
  {
    return this.c;
  }
  
  public boolean hasType()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Result mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setType(paramCodedInputStreamMicro.readInt32());
        break;
      case 16: 
        setError(paramCodedInputStreamMicro.readSInt32());
      }
    }
  }
  
  public Result setError(int paramInt)
  {
    this.c = true;
    this.d = paramInt;
    return this;
  }
  
  public Result setType(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasType()) {
      paramCodedOutputStreamMicro.writeInt32(1, getType());
    }
    if (hasError()) {
      paramCodedOutputStreamMicro.writeSInt32(2, getError());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */