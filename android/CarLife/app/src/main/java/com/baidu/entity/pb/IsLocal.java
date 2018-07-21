package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class IsLocal
  extends MessageMicro
{
  public static final int IS_LOCAL_FIELD_NUMBER = 1;
  private boolean a;
  private boolean b = false;
  private int c = -1;
  
  public static IsLocal parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new IsLocal().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static IsLocal parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (IsLocal)new IsLocal().mergeFrom(paramArrayOfByte);
  }
  
  public final IsLocal clear()
  {
    clearIsLocal();
    this.c = -1;
    return this;
  }
  
  public IsLocal clearIsLocal()
  {
    this.a = false;
    this.b = false;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.c < 0) {
      getSerializedSize();
    }
    return this.c;
  }
  
  public boolean getIsLocal()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasIsLocal()) {
      i = 0 + CodedOutputStreamMicro.computeBoolSize(1, getIsLocal());
    }
    this.c = i;
    return i;
  }
  
  public boolean hasIsLocal()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public IsLocal mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setIsLocal(paramCodedInputStreamMicro.readBool());
      }
    }
  }
  
  public IsLocal setIsLocal(boolean paramBoolean)
  {
    this.a = true;
    this.b = paramBoolean;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasIsLocal()) {
      paramCodedOutputStreamMicro.writeBool(1, getIsLocal());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/IsLocal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */